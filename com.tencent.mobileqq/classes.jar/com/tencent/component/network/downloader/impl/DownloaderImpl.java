package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.Downloader.MiniDownloadListener;
import com.tencent.component.network.downloader.Downloader.StreamDownloadListener;
import com.tencent.component.network.downloader.PreConnectManager;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.handler.ContentHandler;
import com.tencent.component.network.downloader.handler.FileHandler;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy.KeepAlive;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.CacheManager;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.MultiHashMap;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.HttpUtil.ClientOptions;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public class DownloaderImpl
  extends Downloader
  implements DownloadTask.DownloadTaskHandler
{
  private static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE = KeepAliveStrategy.KeepAlive.DISABLE;
  private static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE_PROXY = KeepAliveStrategy.KeepAlive.DISABLE;
  private static final DownloadPreprocessStrategy.DownloadPool DEFAULT_THREAD_POOL = DownloadPreprocessStrategy.DownloadPool.COMMON;
  private static volatile int DownloadingHttp2TaskCount = 0;
  private static volatile int DownloadingHttpTaskCount = 0;
  public static int MAX_CONNECTION = 0;
  public static int MAX_CONNECTION_PER_ROUTE = 0;
  private static final String TAG = "Downloader";
  public static final int THREAD_POOL_SIZE;
  public static final long TIME_TO_LIVE_HTTP;
  public static final long TIME_TO_LIVE_HTTP2;
  public static final TimeUnit TIME_TO_LIVE_UNIT;
  private static final DownloaderImpl.ThreadPoolCache sThreadPoolCache = new DownloaderImpl.ThreadPoolCache("download", THREAD_POOL_SIZE);
  private Object ExecutingTaskListRock = new Object();
  private final FileCacheService mCacheFileCache = CacheManager.getFileCacheService(this.mContext, "download_cache", 100, 50, false);
  private Map<String, List<WeakReference<DownloadTask>>> mExecutingTaskList = new HashMap();
  private final HashMap<String, Future<DownloadResult>> mFutures = new HashMap();
  private QZoneHttpClient mHttpClient;
  private DownloaderImpl.LockManager mLockManager = new DownloaderImpl.LockManager(this, null);
  private OkHttpClient mOkClient;
  private boolean mPaused = false;
  private final MultiHashMap<String, DownloadRequest> mPendingRequests = new MultiHashMap();
  private final DownloaderImpl.ThreadPoolCache mThreadPoolCache = sThreadPoolCache;
  
  static
  {
    DownloadingHttp2TaskCount = 0;
    THREAD_POOL_SIZE = Config.getDefaultThreadPoolSize();
    MAX_CONNECTION = DownloadPreprocessStrategy.DownloadPool.size() * 3 * 5;
    MAX_CONNECTION_PER_ROUTE = THREAD_POOL_SIZE + 1;
    TIME_TO_LIVE_HTTP = Config.getDefaultHttpLiveTime();
    TIME_TO_LIVE_HTTP2 = Config.getDefaultHttp2LiveTime();
    TIME_TO_LIVE_UNIT = TimeUnit.SECONDS;
  }
  
  public DownloaderImpl(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString);
  }
  
  private boolean abortExecutingTask(String paramString)
  {
    if (!Utils.checkUrl(paramString)) {
      return false;
    }
    synchronized (this.ExecutingTaskListRock)
    {
      if (this.mExecutingTaskList.containsKey(paramString))
      {
        Object localObject2 = (List)this.mExecutingTaskList.get(paramString);
        this.mExecutingTaskList.remove(paramString);
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            DownloadTask localDownloadTask = (DownloadTask)((WeakReference)((Iterator)localObject2).next()).get();
            if ((localDownloadTask != null) && (paramString.equals(localDownloadTask.getUrl()))) {
              localDownloadTask.abort();
            }
          }
        }
      }
    }
    return true;
  }
  
  private boolean addPendingRequest(String arg1, String paramString2, DownloadRequest paramDownloadRequest)
  {
    if (paramDownloadRequest == null) {
      return false;
    }
    for (;;)
    {
      synchronized (this.mPendingRequests)
      {
        this.mPendingRequests.sizeOf(paramString2);
        Object localObject = (Collection)this.mPendingRequests.get(paramString2);
        if (localObject == null) {
          break label137;
        }
        localObject = ((Collection)localObject).iterator();
        int i = 0;
        j = i;
        if (((Iterator)localObject).hasNext())
        {
          DownloadRequest localDownloadRequest = (DownloadRequest)((Iterator)localObject).next();
          if ((localDownloadRequest == null) || (localDownloadRequest.isCanceled())) {
            break label134;
          }
          i += 1;
          break label134;
        }
        this.mPendingRequests.add(paramString2, paramDownloadRequest);
        if (j == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label134:
      continue;
      label137:
      int j = 0;
    }
  }
  
  private static void beaconReport(DownloadReport paramDownloadReport, DownloadResult.Status paramStatus, boolean paramBoolean)
  {
    String str2;
    String str1;
    HashMap localHashMap;
    int i;
    if ((paramDownloadReport != null) && (paramStatus != null))
    {
      str2 = "actQZphotoDownload";
      str1 = paramDownloadReport.url;
      localHashMap = new HashMap();
      localHashMap.put("totalTime", String.valueOf(paramDownloadReport.totaltime));
      localHashMap.put("waitTime", String.valueOf(paramDownloadReport.t_wait));
      localHashMap.put("recvTime", String.valueOf(paramDownloadReport.t_recvdata));
      localHashMap.put("getIPTime", String.valueOf(paramDownloadReport.t_prepare));
      localHashMap.put("reqTime", String.valueOf(paramDownloadReport.t_recvrsp));
      localHashMap.put("fileSize", String.valueOf(paramDownloadReport.fileSize));
      localHashMap.put("networkType", String.valueOf(NetworkState.g().getNetworkType()));
      localHashMap.put("downloadUrl", String.valueOf(str1));
      localHashMap.put("contentType", String.valueOf(paramDownloadReport.content_type));
      localHashMap.put("retryCount", String.valueOf(paramDownloadReport.currAttempCount));
      localHashMap.put("concurrent", String.valueOf(paramDownloadReport.concurrent));
      localHashMap.put("domain", String.valueOf(paramDownloadReport.domain));
      localHashMap.put("IPStrategy", String.valueOf(paramDownloadReport.strategyId));
      localHashMap.put("downloadTime", String.valueOf(paramDownloadReport.downloadTime));
      if (paramDownloadReport.downloadTime != 0L) {
        localHashMap.put("downloadSpeed", String.valueOf(paramDownloadReport.fileSize * 1000.0D / paramDownloadReport.downloadTime));
      }
      if (paramDownloadReport.totaltime != 0L) {
        localHashMap.put("totalSpeed", String.valueOf(paramDownloadReport.fileSize * 1000.0D / paramDownloadReport.totaltime));
      }
      if (!paramDownloadReport.isFromQzoneAlbum) {
        break label469;
      }
      if (!paramBoolean) {
        break label461;
      }
      if (!paramDownloadReport.isHttp2) {
        break label456;
      }
      i = 0;
      localHashMap.put("degradeToHttp", String.valueOf(i));
      str1 = "actQZphotoDownloadH2";
    }
    for (;;)
    {
      if (!paramDownloadReport.isSucceed)
      {
        localHashMap.put("httpRetCode", String.valueOf(paramStatus.failReason));
        localHashMap.put("param_FailCode", String.valueOf(paramStatus.failReason));
        if (paramStatus.failException != null) {
          localHashMap.put("exception2Code", String.valueOf(paramStatus.exception2Code));
        }
        localHashMap.put("httpStatus", String.valueOf(paramDownloadReport.httpStatus));
      }
      Config.reportToBeacon(str1, paramDownloadReport.isSucceed, localHashMap, paramDownloadReport.totaltime);
      return;
      label456:
      i = 1;
      break;
      label461:
      str1 = "actQZphotoDownloadAlbum";
      continue;
      label469:
      str1 = str2;
      if (paramDownloadReport.url != null)
      {
        str1 = str2;
        if (paramDownloadReport.url.startsWith("https://")) {
          str1 = "actQZphotoDownloadATS";
        }
      }
    }
  }
  
  private MultiHashMap<String, DownloadRequest> collectAllPendingRequest(boolean paramBoolean, MultiHashMap<String, DownloadRequest> paramMultiHashMap)
  {
    MultiHashMap localMultiHashMap = this.mPendingRequests;
    if (paramMultiHashMap != null) {}
    try
    {
      paramMultiHashMap.clear();
      if (this.mPendingRequests.isEmpty()) {
        return paramMultiHashMap;
      }
      Object localObject = paramMultiHashMap;
      if (paramMultiHashMap == null) {
        localObject = new MultiHashMap();
      }
      ((MultiHashMap)localObject).putAll(this.mPendingRequests);
      if (paramBoolean) {
        this.mPendingRequests.clear();
      }
      return localObject;
    }
    finally {}
  }
  
  private Collection<DownloadRequest> collectPendingRequest(String paramString, boolean paramBoolean, Collection<DownloadRequest> paramCollection)
  {
    try
    {
      MultiHashMap localMultiHashMap = this.mPendingRequests;
      if (paramBoolean) {}
      try
      {
        for (paramString = (HashSet)this.mPendingRequests.remove(paramString); paramCollection != null; paramString = (HashSet)this.mPendingRequests.get(paramString))
        {
          paramCollection.clear();
          if (paramString != null) {
            paramCollection.addAll(paramString);
          }
          return paramCollection;
        }
        return paramString;
      }
      finally {}
      return new ArrayList();
    }
    catch (Throwable paramString) {}
  }
  
  private void enqueueTask(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {}
    while (this.mPaused) {
      return;
    }
    ??? = getDownloadThreadPool(paramDownloadTask.getUrl(), paramDownloadTask.getDomain());
    paramDownloadTask.onTaskEnqueue();
    Future localFuture = ((PriorityThreadPool)???).submit(paramDownloadTask, new DownloaderImpl.1(this, paramDownloadTask), paramDownloadTask.getPriority());
    synchronized (this.mFutures)
    {
      this.mFutures.put(paramDownloadTask.getUrlKey(), localFuture);
      return;
    }
  }
  
  private PriorityThreadPool getDownloadThreadPool(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      if (this.pExternalThreadPool == null) {
        break;
      }
      return this.pExternalThreadPool;
    }
    DownloadPreprocessStrategy localDownloadPreprocessStrategy = this.pProcessStrategy;
    if (localDownloadPreprocessStrategy != null) {}
    for (paramString1 = localDownloadPreprocessStrategy.downloadPool(paramString1, paramString2);; paramString1 = null)
    {
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = DEFAULT_THREAD_POOL;
      }
      return this.mThreadPoolCache.get(paramString2.getName());
    }
  }
  
  public static PriorityThreadPool getWorkThreadPool()
  {
    return PriorityThreadPool.getDefault();
  }
  
  private boolean handleDownloadFile(DownloadResult paramDownloadResult, DownloadRequest paramDownloadRequest)
  {
    if (paramDownloadRequest == null) {}
    FileHandler localFileHandler;
    do
    {
      return false;
      localFileHandler = this.pFileHandler;
    } while (localFileHandler == null);
    return localFileHandler.handleFile(paramDownloadResult.getPath(), paramDownloadRequest.getPath());
  }
  
  private boolean handleRangeModeFail(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask instanceof RangeDownloadTask))
    {
      paramDownloadTask = paramDownloadTask.getDownloadRequest();
      if (paramDownloadTask != null)
      {
        QDLog.w("downloader_RANGE", "download fail, retry on  StrictMode, url:" + paramDownloadTask.getUrl());
        paramDownloadTask.mode = Downloader.DownloadMode.StrictMode;
        download(paramDownloadTask, true);
        return true;
      }
    }
    return false;
  }
  
  private boolean isDownloading(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      synchronized (this.ExecutingTaskListRock)
      {
        paramString = (List)this.mExecutingTaskList.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void notifyDownloadCanceled(Collection<DownloadRequest> paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled()))
        {
          Downloader.DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadCanceled(localDownloadRequest.getUrl());
          }
        }
      }
    }
  }
  
  private void notifyDownloadFailed(Collection<DownloadRequest> paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (localDownloadRequest.getListener() != null)) {
          localDownloadRequest.getListener().onDownloadFailed(localDownloadRequest.getUrl(), paramDownloadResult);
        }
      }
    }
  }
  
  private void notifyDownloadProgress(Collection<DownloadRequest> paramCollection, long paramLong, float paramFloat)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled()))
        {
          Downloader.DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadProgress(localDownloadRequest.getUrl(), paramLong, paramFloat);
          }
        }
      }
    }
  }
  
  private void notifyDownloadSucceed(Collection<DownloadRequest> paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (localDownloadRequest.getListener() != null) && (!localDownloadRequest.isCanceled())) {
          localDownloadRequest.getListener().onDownloadSucceed(localDownloadRequest.getUrl(), paramDownloadResult);
        }
      }
    }
  }
  
  private void notifyHeaderRequest(Collection<DownloadRequest> paramCollection, int paramInt, Map<String, List<String>> paramMap)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled()))
        {
          Downloader.DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if ((localDownloadListener instanceof Downloader.MiniDownloadListener)) {
            ((Downloader.MiniDownloadListener)localDownloadListener).onDownloadHeadersReceived(localDownloadRequest.getUrl(), paramInt, paramMap);
          }
        }
      }
    }
  }
  
  private void notifyStreamDownloadProgress(Collection<DownloadRequest> paramCollection, String paramString)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled()) && ((localDownloadRequest.getListener() instanceof Downloader.StreamDownloadListener)))
        {
          Downloader.StreamDownloadListener localStreamDownloadListener = (Downloader.StreamDownloadListener)localDownloadRequest.getListener();
          if (localStreamDownloadListener != null) {
            localStreamDownloadListener.onStreamDownloadProgress(localDownloadRequest.getUrl(), paramString);
          }
        }
      }
    }
  }
  
  private OkHttpClient obtainHttp2Client()
  {
    if (this.mOkClient != null) {
      return this.mOkClient;
    }
    try
    {
      if (this.mOkClient != null)
      {
        OkHttpClient localOkHttpClient = this.mOkClient;
        return localOkHttpClient;
      }
    }
    finally {}
    Object localObject2 = new HttpUtil.ClientOptions();
    ((HttpUtil.ClientOptions)localObject2).multiConnection = true;
    ((HttpUtil.ClientOptions)localObject2).maxConnection = MAX_CONNECTION;
    ((HttpUtil.ClientOptions)localObject2).maxConnectionPerRoute = MAX_CONNECTION_PER_ROUTE;
    ((HttpUtil.ClientOptions)localObject2).timeToLive = TIME_TO_LIVE_HTTP2;
    CustomDnsResolve localCustomDnsResolve = new CustomDnsResolve();
    localCustomDnsResolve.addIpStrategy(this.pDirectIPConfig);
    localCustomDnsResolve.addIpStrategy(this.pBackupIPConfig);
    this.mOkClient = HttpUtil.createHttp2Client((HttpUtil.ClientOptions)localObject2, localCustomDnsResolve);
    localObject2 = this.mOkClient;
    return localObject2;
  }
  
  private QZoneHttpClient obtainHttpClient()
  {
    if (this.mHttpClient != null) {
      return this.mHttpClient;
    }
    try
    {
      if (this.mHttpClient != null)
      {
        QZoneHttpClient localQZoneHttpClient = this.mHttpClient;
        return localQZoneHttpClient;
      }
    }
    finally {}
    Object localObject2;
    if (this.pHttpsIpDirectEnable)
    {
      localObject2 = new CustomDnsResolve();
      ((CustomDnsResolve)localObject2).addIpStrategy(this.pDirectIPConfig);
      ((CustomDnsResolve)localObject2).addIpStrategy(this.pBackupIPConfig);
    }
    for (this.mHttpClient = HttpUtil.CreateDefaultHttpClient((CustomDnsResolve)localObject2);; this.mHttpClient = HttpUtil.CreateDefaultHttpClient())
    {
      localObject2 = this.mHttpClient;
      return localObject2;
    }
  }
  
  private boolean removePendingRequest(String paramString, DownloadRequest paramDownloadRequest, Collection<DownloadRequest> paramCollection)
  {
    if (paramDownloadRequest == null) {
      return false;
    }
    for (;;)
    {
      int k;
      int j;
      synchronized (this.mPendingRequests)
      {
        k = this.mPendingRequests.sizeOf(paramString);
        if (paramCollection != null) {
          paramCollection.clear();
        }
        paramString = (Collection)this.mPendingRequests.get(paramString);
        if (paramString != null)
        {
          paramString = paramString.iterator();
          int i = 0;
          j = i;
          if (!paramString.hasNext()) {
            break label157;
          }
          DownloadRequest localDownloadRequest = (DownloadRequest)paramString.next();
          if (paramDownloadRequest.equals(localDownloadRequest))
          {
            localDownloadRequest.cancel();
            if (paramCollection != null) {
              paramCollection.add(paramDownloadRequest);
            }
          }
          if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled()))
          {
            i += 1;
            break label151;
            label133:
            return bool;
          }
        }
      }
      label151:
      label157:
      do
      {
        bool = false;
        break label133;
        break;
        j = 0;
      } while ((k <= 0) || (j != 0));
      boolean bool = true;
    }
  }
  
  public void abort(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (QDLog.isInfoEnable()) {
      QDLog.i("Downloader", "download abort url:" + paramString + " listener:" + paramDownloadListener);
    }
    paramDownloadListener = generateUrlKey(paramString);
    synchronized (this.mFutures)
    {
      Future localFuture = (Future)this.mFutures.remove(paramDownloadListener);
      if (localFuture != null) {
        localFuture.cancel();
      }
      abortExecutingTask(paramString);
      paramString = new ArrayList();
      collectPendingRequest(paramDownloadListener, true, paramString);
      notifyDownloadCanceled(paramString);
      return;
    }
  }
  
  public void abortAll() {}
  
  public void addCacheEntry(String paramString, DownloadResult paramDownloadResult)
  {
    String str2 = generateStorageName(paramString);
    String str1 = this.mCacheFileCache.getPath(str2);
    try
    {
      File localFile = new File(paramDownloadResult.getPath());
      boolean bool2 = FileUtils.copyFiles(localFile, new File(str1));
      boolean bool1 = bool2;
      paramDownloadResult = str1;
      if (!bool2)
      {
        paramDownloadResult = this.mCacheFileCache.getPath(str2, false);
        bool1 = FileUtils.copyFiles(localFile, new File(paramDownloadResult));
      }
      if (QDLog.isInfoEnable()) {
        QDLog.i("Downloader", "download cache entry to: " + paramDownloadResult + " " + paramString + " result:" + bool1);
      }
      return;
    }
    catch (Throwable paramDownloadResult)
    {
      QDLog.w("Downloader", "download ------- copy exception!!! " + paramString, paramDownloadResult);
    }
  }
  
  public void cancel()
  {
    Object localObject1 = null;
    MultiHashMap localMultiHashMap = collectAllPendingRequest(true, null);
    synchronized (this.mFutures)
    {
      if (!this.mFutures.isEmpty())
      {
        localObject1 = new ArrayList(this.mFutures.values());
        this.mFutures.clear();
      }
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = (Future)((Iterator)localObject1).next();
          if (??? != null) {
            ((Future)???).cancel();
          }
        }
      }
    }
    abortAll();
    if (localMultiHashMap != null)
    {
      Iterator localIterator = localMultiHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ??? = (String)localIterator.next();
        if (??? != null) {
          notifyDownloadCanceled((Collection)localMultiHashMap.get(???));
        }
      }
    }
  }
  
  public void cancel(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (!Utils.checkUrl(paramString)) {
      return;
    }
    QDLog.i("Downloader", "download cancel url:" + paramString + " listener:" + paramDownloadListener);
    Object localObject1 = generateUrlKey(paramString);
    ??? = new DownloadRequest(paramString, new String[0], false, paramDownloadListener);
    paramDownloadListener = new ArrayList();
    if (removePendingRequest((String)localObject1, (DownloadRequest)???, paramDownloadListener)) {}
    synchronized (this.mFutures)
    {
      localObject1 = (Future)this.mFutures.remove(localObject1);
      if ((localObject1 != null) && (!isDownloading(paramString))) {
        ((Future)localObject1).cancel();
      }
      notifyDownloadCanceled(paramDownloadListener);
      return;
    }
  }
  
  public void cancelAll()
  {
    cancel();
  }
  
  public void cleanCache()
  {
    this.mCacheFileCache.clear();
    if (this.pResumeTransfer != null) {
      this.pResumeTransfer.cleanCache();
    }
  }
  
  public void cleanCache(String paramString)
  {
    this.mCacheFileCache.deleteFile(generateStorageFileName(paramString));
    if (this.pResumeTransfer != null) {
      this.pResumeTransfer.cleanCache(paramString);
    }
  }
  
  public boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    Object localObject = paramDownloadRequest.getUrl();
    boolean bool1;
    if ((!Utils.checkUrl((String)localObject)) || (paramDownloadRequest.getPaths() == null)) {
      bool1 = false;
    }
    String str;
    do
    {
      do
      {
        return bool1;
        str = generateUrlKey((String)localObject);
        QDLog.i("downloader", "download :" + (String)localObject + " urlKey:" + str + " listener:" + paramDownloadRequest.getListener());
        bool1 = bool3;
      } while (!addPendingRequest((String)localObject, str, paramDownloadRequest));
      bool1 = bool3;
    } while (isDownloading((String)localObject));
    if (paramDownloadRequest.range > 0L) {
      paramDownloadRequest.addParam("Range", "bytes=" + paramDownloadRequest.range);
    }
    bool3 = Config.shouldUseHttp2(Utils.getDomin((String)localObject));
    int i;
    if ((Config.getNetworkStackType() == 2) || (Config.getNetworkStackType() == 3))
    {
      i = 1;
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      if ((paramDownloadRequest.mode != Downloader.DownloadMode.RangeMode) && (paramDownloadRequest.mode != Downloader.DownloadMode.OkHttpMode) && (!bool1)) {
        break label378;
      }
      obtainHttp2Client();
      label236:
      if (paramDownloadRequest.mode != Downloader.DownloadMode.StrictMode) {
        break label386;
      }
      localObject = new StrictDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, (String)localObject, str, paramBoolean, bool1);
      ((DownloadTask)localObject).setAttemptCount(12);
    }
    for (;;)
    {
      if (paramDownloadRequest.needMd5) {
        ((DownloadTask)localObject).setNeedMd5();
      }
      if (paramDownloadRequest.onResponseDataListener != null) {
        ((DownloadTask)localObject).setResponseDataListener(paramDownloadRequest.onResponseDataListener);
      }
      ((DownloadTask)localObject).setProgressCallbackStep(paramDownloadRequest.progressCallbackStep);
      ((DownloadTask)localObject).setHttpParams(paramDownloadRequest.getParams());
      ((DownloadTask)localObject).setHandler(this, this.pDirectIPConfig, this.pBackupIPConfig, this.pPortConfigStrategy, this.pResumeTransfer, this.pReportHandler, this.pExternalReportHandler, this.pNetworkFlowStatistics, this.pTmpFileCache);
      enqueueTask((DownloadTask)localObject);
      return true;
      i = 0;
      break;
      label378:
      obtainHttpClient();
      break label236;
      label386:
      if (paramDownloadRequest.mode == Downloader.DownloadMode.RangeMode)
      {
        localObject = new RangeDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, (String)localObject, str, paramBoolean, paramDownloadRequest.rangeNumber, paramDownloadRequest.getFileSizeForRangeMode());
        ((DownloadTask)localObject).setDownloadRequest(paramDownloadRequest);
      }
      else if (paramDownloadRequest.mode == Downloader.DownloadMode.OkHttpMode)
      {
        localObject = new OkHttpDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, (String)localObject, str, paramBoolean, bool1);
        ((DownloadTask)localObject).setAttemptCount(3);
      }
      else
      {
        localObject = new FastDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, (String)localObject, str, paramBoolean, bool1);
        ((DownloadTask)localObject).setAttemptCount(8);
      }
    }
  }
  
  public String findCacheEntryPath(String paramString)
  {
    paramString = generateStorageName(paramString);
    paramString = this.mCacheFileCache.getFile(paramString);
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  public String generateStorageFileName(String paramString)
  {
    return super.generateStorageName(paramString);
  }
  
  public Proxy getCustomProxy()
  {
    return getMobileProxy();
  }
  
  public int getHttp2TaskConcurrentCount()
  {
    return DownloadingHttp2TaskCount;
  }
  
  public int getHttpTaskConcurrentCount()
  {
    return DownloadingHttpTaskCount;
  }
  
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse)
  {
    ContentHandler localContentHandler = this.pContentHandler;
    if (localContentHandler != null) {
      return localContentHandler.handleContentType(paramDownloadResult, paramHttpResponse, paramResponse);
    }
    return true;
  }
  
  public void handleDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    notifyDownloadProgress(collectPendingRequest(paramString, false, new ArrayList()), paramLong, paramFloat);
  }
  
  public void handleKeepAliveStrategy(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, HttpUtil.RequestOptions paramRequestOptions)
  {
    boolean bool;
    if ((paramString1 != null) && (paramString2 != null) && ((paramBuilder != null) || (paramHttpRequest != null)))
    {
      bool = true;
      label20:
      AssertUtil.assertTrue(bool);
      paramString1 = this.pKeepAliveStrategy;
      if (paramString1 == null) {
        break label103;
      }
      paramString1 = paramString1.keepAlive(paramString2, paramHttpRequest, paramRequestOptions);
      label45:
      paramString2 = paramString1;
      if (paramString1 == null) {
        if (!HttpUtil.containsProxy(paramHttpRequest, paramRequestOptions)) {
          break label108;
        }
      }
    }
    label103:
    label108:
    for (paramString2 = DEFAULT_KEEP_ALIVE_PROXY;; paramString2 = DEFAULT_KEEP_ALIVE) {
      switch (DownloaderImpl.2.$SwitchMap$com$tencent$component$network$downloader$strategy$KeepAliveStrategy$KeepAlive[paramString2.ordinal()])
      {
      default: 
        return;
        bool = false;
        break label20;
        paramString1 = null;
        break label45;
      }
    }
    HttpUtil.setKeepAliveEnabled(paramHttpRequest, paramBuilder, true);
    return;
    HttpUtil.setKeepAliveEnabled(paramHttpRequest, paramBuilder, false);
  }
  
  public void handlePrepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, int paramInt)
  {
    if (this.pProcessStrategy != null) {
      this.pProcessStrategy.prepareRequest(paramString1, paramString2, paramHttpRequest, paramBuilder, paramInt);
    }
  }
  
  public void handleRequestHeader(String paramString, int paramInt, Map<String, List<String>> paramMap)
  {
    notifyHeaderRequest(collectPendingRequest(paramString, false, null), paramInt, paramMap);
  }
  
  public void handleStreamDownloadProgress(String paramString1, String paramString2)
  {
    notifyStreamDownloadProgress(collectPendingRequest(paramString1, false, new ArrayList()), paramString2);
  }
  
  public void pause()
  {
    this.mPaused = true;
  }
  
  public void preConnectHost(ArrayList<String> paramArrayList)
  {
    PreConnectManager.connectHost(obtainHttp2Client(), paramArrayList);
  }
  
  public String prepareRequestUrl(String paramString)
  {
    if (this.pProcessStrategy == null) {
      return null;
    }
    return this.pProcessStrategy.prepareUrl(paramString);
  }
  
  public void resume()
  {
    this.mPaused = false;
  }
  
  public void setHttpConnectionParam(int paramInt1, int paramInt2)
  {
    super.setHttpConnectionParam(paramInt1, paramInt2);
    if (this.pMaxConnectionPerRoute > 0) {
      MAX_CONNECTION_PER_ROUTE = this.pMaxConnectionPerRoute;
    }
    if (this.pMaxConnection > 0) {
      MAX_CONNECTION = this.pMaxConnection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloaderImpl
 * JD-Core Version:    0.7.0.1
 */