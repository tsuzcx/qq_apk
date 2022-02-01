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
  public static final int THREAD_POOL_SIZE = ;
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
      return true;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private boolean addPendingRequest(String arg1, String paramString2, DownloadRequest paramDownloadRequest)
  {
    boolean bool = false;
    if (paramDownloadRequest == null) {
      return false;
    }
    int j;
    synchronized (this.mPendingRequests)
    {
      this.mPendingRequests.sizeOf(paramString2);
      Object localObject = (Collection)this.mPendingRequests.get(paramString2);
      if (localObject != null)
      {
        localObject = ((Collection)localObject).iterator();
        int i = 0;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          DownloadRequest localDownloadRequest = (DownloadRequest)((Iterator)localObject).next();
          if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled())) {
            i += 1;
          }
        }
        this.mPendingRequests.add(paramString2, paramDownloadRequest);
        if (j == 0) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  private static void beaconReport(DownloadReport paramDownloadReport, DownloadResult.Status paramStatus, boolean paramBoolean)
  {
    if ((paramDownloadReport != null) && (paramStatus != null))
    {
      String str = paramDownloadReport.url;
      HashMap localHashMap = new HashMap();
      localHashMap.put("totalTime", String.valueOf(paramDownloadReport.totaltime));
      localHashMap.put("waitTime", String.valueOf(paramDownloadReport.t_wait));
      localHashMap.put("recvTime", String.valueOf(paramDownloadReport.t_recvdata));
      localHashMap.put("getIPTime", String.valueOf(paramDownloadReport.t_prepare));
      localHashMap.put("reqTime", String.valueOf(paramDownloadReport.t_recvrsp));
      localHashMap.put("fileSize", String.valueOf(paramDownloadReport.fileSize));
      localHashMap.put("networkType", String.valueOf(NetworkState.g().getNetworkType()));
      localHashMap.put("downloadUrl", String.valueOf(str));
      localHashMap.put("contentType", String.valueOf(paramDownloadReport.content_type));
      localHashMap.put("retryCount", String.valueOf(paramDownloadReport.currAttempCount));
      localHashMap.put("concurrent", String.valueOf(paramDownloadReport.concurrent));
      localHashMap.put("domain", String.valueOf(paramDownloadReport.domain));
      localHashMap.put("IPStrategy", String.valueOf(paramDownloadReport.strategyId));
      localHashMap.put("downloadTime", String.valueOf(paramDownloadReport.downloadTime));
      double d1;
      double d2;
      if (paramDownloadReport.downloadTime != 0L)
      {
        d1 = paramDownloadReport.fileSize;
        Double.isNaN(d1);
        d2 = paramDownloadReport.downloadTime;
        Double.isNaN(d2);
        localHashMap.put("downloadSpeed", String.valueOf(d1 * 1000.0D / d2));
      }
      if (paramDownloadReport.totaltime != 0L)
      {
        d1 = paramDownloadReport.fileSize;
        Double.isNaN(d1);
        d2 = paramDownloadReport.totaltime;
        Double.isNaN(d2);
        localHashMap.put("totalSpeed", String.valueOf(d1 * 1000.0D / d2));
      }
      if (paramDownloadReport.isFromQzoneAlbum)
      {
        if (paramBoolean)
        {
          localHashMap.put("degradeToHttp", String.valueOf(paramDownloadReport.isHttp2 ^ true));
          str = "actQZphotoDownloadH2";
        }
        else
        {
          str = "actQZphotoDownloadAlbum";
        }
      }
      else if ((paramDownloadReport.url != null) && (paramDownloadReport.url.startsWith("https://"))) {
        str = "actQZphotoDownloadATS";
      } else {
        str = "actQZphotoDownload";
      }
      if (!paramDownloadReport.isSucceed)
      {
        localHashMap.put("httpRetCode", String.valueOf(paramStatus.failReason));
        localHashMap.put("param_FailCode", String.valueOf(paramStatus.failReason));
        if (paramStatus.failException != null) {
          localHashMap.put("exception2Code", String.valueOf(paramStatus.exception2Code));
        }
        localHashMap.put("httpStatus", String.valueOf(paramDownloadReport.httpStatus));
      }
      Config.reportToBeacon(str, paramDownloadReport.isSucceed, localHashMap, paramDownloadReport.totaltime);
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
        for (paramString = this.mPendingRequests.remove(paramString);; paramString = this.mPendingRequests.get(paramString))
        {
          paramString = (HashSet)paramString;
          break;
        }
        if (paramCollection != null)
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
    }
    catch (Throwable paramString)
    {
      label80:
      break label80;
    }
    return new ArrayList();
  }
  
  private void enqueueTask(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    if (this.mPaused) {
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
    boolean bool;
    if (paramString1 != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtil.assertTrue(bool);
    if (this.pExternalThreadPool != null) {
      return this.pExternalThreadPool;
    }
    DownloadPreprocessStrategy localDownloadPreprocessStrategy = this.pProcessStrategy;
    if (localDownloadPreprocessStrategy != null) {
      paramString1 = localDownloadPreprocessStrategy.downloadPool(paramString1, paramString2);
    } else {
      paramString1 = null;
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = DEFAULT_THREAD_POOL;
    }
    return this.mThreadPoolCache.get(paramString2.getName());
  }
  
  public static PriorityThreadPool getWorkThreadPool()
  {
    return PriorityThreadPool.getDefault();
  }
  
  private boolean handleDownloadFile(DownloadResult paramDownloadResult, DownloadRequest paramDownloadRequest)
  {
    if (paramDownloadRequest == null) {
      return false;
    }
    FileHandler localFileHandler = this.pFileHandler;
    if (localFileHandler == null) {
      return false;
    }
    return localFileHandler.handleFile(paramDownloadResult.getPath(), paramDownloadRequest.getPath());
  }
  
  private boolean handleRangeModeFail(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask instanceof RangeDownloadTask))
    {
      paramDownloadTask = paramDownloadTask.getDownloadRequest();
      if (paramDownloadTask != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("download fail, retry on  StrictMode, url:");
        localStringBuilder.append(paramDownloadTask.getUrl());
        QDLog.w("downloader_RANGE", localStringBuilder.toString());
        paramDownloadTask.mode = Downloader.DownloadMode.StrictMode;
        download(paramDownloadTask, true);
        return true;
      }
    }
    return false;
  }
  
  private boolean isDownloading(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    synchronized (this.ExecutingTaskListRock)
    {
      paramString = (List)this.mExecutingTaskList.get(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.size() > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private void notifyDownloadCanceled(Collection<DownloadRequest> paramCollection)
  {
    if (paramCollection == null) {
      return;
    }
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
  
  private void notifyDownloadFailed(Collection<DownloadRequest> paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {
      return;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
      if ((localDownloadRequest != null) && (localDownloadRequest.getListener() != null)) {
        localDownloadRequest.getListener().onDownloadFailed(localDownloadRequest.getUrl(), paramDownloadResult);
      }
    }
  }
  
  private void notifyDownloadProgress(Collection<DownloadRequest> paramCollection, long paramLong, float paramFloat)
  {
    if (paramCollection == null) {
      return;
    }
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
  
  private void notifyDownloadSucceed(Collection<DownloadRequest> paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {
      return;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
      if ((localDownloadRequest != null) && (localDownloadRequest.getListener() != null) && (!localDownloadRequest.isCanceled())) {
        localDownloadRequest.getListener().onDownloadSucceed(localDownloadRequest.getUrl(), paramDownloadResult);
      }
    }
  }
  
  private void notifyHeaderRequest(Collection<DownloadRequest> paramCollection, int paramInt, Map<String, List<String>> paramMap)
  {
    if (paramCollection == null) {
      return;
    }
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
  
  private void notifyStreamDownloadProgress(Collection<DownloadRequest> paramCollection, String paramString)
  {
    if (paramCollection == null) {
      return;
    }
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
  
  private OkHttpClient obtainHttp2Client()
  {
    Object localObject1 = this.mOkClient;
    if (localObject1 != null) {
      return localObject1;
    }
    try
    {
      if (this.mOkClient != null)
      {
        localObject1 = this.mOkClient;
        return localObject1;
      }
      localObject1 = new HttpUtil.ClientOptions();
      ((HttpUtil.ClientOptions)localObject1).multiConnection = true;
      ((HttpUtil.ClientOptions)localObject1).maxConnection = MAX_CONNECTION;
      ((HttpUtil.ClientOptions)localObject1).maxConnectionPerRoute = MAX_CONNECTION_PER_ROUTE;
      ((HttpUtil.ClientOptions)localObject1).timeToLive = TIME_TO_LIVE_HTTP2;
      CustomDnsResolve localCustomDnsResolve = new CustomDnsResolve();
      localCustomDnsResolve.addIpStrategy(this.pDirectIPConfig);
      localCustomDnsResolve.addIpStrategy(this.pBackupIPConfig);
      this.mOkClient = HttpUtil.createHttp2Client((HttpUtil.ClientOptions)localObject1, localCustomDnsResolve);
      localObject1 = this.mOkClient;
      return localObject1;
    }
    finally {}
  }
  
  private QZoneHttpClient obtainHttpClient()
  {
    Object localObject1 = this.mHttpClient;
    if (localObject1 != null) {
      return localObject1;
    }
    try
    {
      if (this.mHttpClient != null)
      {
        localObject1 = this.mHttpClient;
        return localObject1;
      }
      if (this.pHttpsIpDirectEnable)
      {
        localObject1 = new CustomDnsResolve();
        ((CustomDnsResolve)localObject1).addIpStrategy(this.pDirectIPConfig);
        ((CustomDnsResolve)localObject1).addIpStrategy(this.pBackupIPConfig);
        this.mHttpClient = HttpUtil.CreateDefaultHttpClient((CustomDnsResolve)localObject1);
      }
      else
      {
        this.mHttpClient = HttpUtil.CreateDefaultHttpClient();
      }
      localObject1 = this.mHttpClient;
      return localObject1;
    }
    finally {}
  }
  
  private boolean removePendingRequest(String paramString, DownloadRequest paramDownloadRequest, Collection<DownloadRequest> paramCollection)
  {
    boolean bool2 = false;
    if (paramDownloadRequest == null) {
      return false;
    }
    int k;
    int j;
    boolean bool1;
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
        for (;;)
        {
          j = i;
          if (!paramString.hasNext()) {
            break;
          }
          DownloadRequest localDownloadRequest = (DownloadRequest)paramString.next();
          if (paramDownloadRequest.equals(localDownloadRequest))
          {
            localDownloadRequest.cancel();
            if (paramCollection != null) {
              paramCollection.add(paramDownloadRequest);
            }
          }
          if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled())) {
            i += 1;
          }
        }
        return bool1;
      }
    }
  }
  
  public void abort(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (QDLog.isInfoEnable())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("download abort url:");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(" listener:");
      ((StringBuilder)???).append(paramDownloadListener);
      QDLog.i("Downloader", ((StringBuilder)???).toString());
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
    String str = generateStorageName(paramString);
    Object localObject = this.mCacheFileCache.getPath(str);
    try
    {
      File localFile = new File(paramDownloadResult.getPath());
      boolean bool2 = FileUtils.copyFiles(localFile, new File((String)localObject));
      paramDownloadResult = (DownloadResult)localObject;
      boolean bool1 = bool2;
      if (!bool2)
      {
        paramDownloadResult = this.mCacheFileCache.getPath(str, false);
        bool1 = FileUtils.copyFiles(localFile, new File(paramDownloadResult));
      }
      if (QDLog.isInfoEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download cache entry to: ");
        ((StringBuilder)localObject).append(paramDownloadResult);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" result:");
        ((StringBuilder)localObject).append(bool1);
        QDLog.i("Downloader", ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramDownloadResult)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download ------- copy exception!!! ");
      ((StringBuilder)localObject).append(paramString);
      QDLog.w("Downloader", ((StringBuilder)localObject).toString(), paramDownloadResult);
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
      abortAll();
      if (localMultiHashMap != null)
      {
        localObject1 = localMultiHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = (String)((Iterator)localObject1).next();
          if (??? != null) {
            notifyDownloadCanceled((Collection)localMultiHashMap.get(???));
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void cancel(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (!Utils.checkUrl(paramString)) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("download cancel url:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" listener:");
    ((StringBuilder)localObject1).append(paramDownloadListener);
    QDLog.i("Downloader", ((StringBuilder)localObject1).toString());
    localObject1 = generateUrlKey(paramString);
    ??? = new DownloadRequest(paramString, new String[0], false, paramDownloadListener);
    paramDownloadListener = new ArrayList();
    if (removePendingRequest((String)localObject1, (DownloadRequest)???, paramDownloadListener)) {
      synchronized (this.mFutures)
      {
        localObject1 = (Future)this.mFutures.remove(localObject1);
        if ((localObject1 != null) && (!isDownloading(paramString))) {
          ((Future)localObject1).cancel();
        }
      }
    }
    notifyDownloadCanceled(paramDownloadListener);
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
    String str1 = paramDownloadRequest.getUrl();
    if (Utils.checkUrl(str1))
    {
      if (paramDownloadRequest.getPaths() == null) {
        return false;
      }
      String str2 = generateUrlKey(str1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download :");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" urlKey:");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(" listener:");
      ((StringBuilder)localObject).append(paramDownloadRequest.getListener());
      QDLog.i("downloader", ((StringBuilder)localObject).toString());
      if ((addPendingRequest(str1, str2, paramDownloadRequest)) && (!isDownloading(str1)))
      {
        if (paramDownloadRequest.range > 0L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bytes=");
          ((StringBuilder)localObject).append(paramDownloadRequest.range);
          paramDownloadRequest.addParam("Range", ((StringBuilder)localObject).toString());
        }
        boolean bool = Config.shouldUseHttp2(Utils.getDomin(str1));
        int i;
        if ((Config.getNetworkStackType() != 2) && (Config.getNetworkStackType() != 3)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((bool) && (i == 0)) {
          bool = true;
        } else {
          bool = false;
        }
        if ((paramDownloadRequest.mode != Downloader.DownloadMode.RangeMode) && (paramDownloadRequest.mode != Downloader.DownloadMode.OkHttpMode) && (!bool)) {
          obtainHttpClient();
        } else {
          obtainHttp2Client();
        }
        if (paramDownloadRequest.mode == Downloader.DownloadMode.StrictMode)
        {
          localObject = new StrictDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, str1, str2, paramBoolean, bool);
          ((DownloadTask)localObject).setAttemptCount(12);
        }
        for (;;)
        {
          break;
          if (paramDownloadRequest.mode == Downloader.DownloadMode.RangeMode)
          {
            RangeDownloadTask localRangeDownloadTask = new com/tencent/component/network/downloader/impl/RangeDownloadTask;
            Context localContext = this.mContext;
            OkHttpClient localOkHttpClient = this.mOkClient;
            QZoneHttpClient localQZoneHttpClient = this.mHttpClient;
            i = paramDownloadRequest.rangeNumber;
            long l = paramDownloadRequest.getFileSizeForRangeMode();
            localObject = localRangeDownloadTask;
            ((RangeDownloadTask)localObject).<init>(localContext, localOkHttpClient, localQZoneHttpClient, str1, str2, paramBoolean, i, l);
            localRangeDownloadTask.setDownloadRequest(paramDownloadRequest);
          }
          else if (paramDownloadRequest.mode == Downloader.DownloadMode.OkHttpMode)
          {
            localObject = new OkHttpDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, str1, str2, paramBoolean, bool);
            ((DownloadTask)localObject).setAttemptCount(3);
          }
          else
          {
            localObject = new FastDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, str1, str2, paramBoolean, bool);
            ((DownloadTask)localObject).setAttemptCount(8);
          }
        }
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
      }
      return true;
    }
    return false;
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
    if ((paramString1 != null) && (paramString2 != null) && ((paramBuilder != null) || (paramHttpRequest != null))) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtil.assertTrue(bool);
    paramString1 = this.pKeepAliveStrategy;
    if (paramString1 != null) {
      paramString1 = paramString1.keepAlive(paramString2, paramHttpRequest, paramRequestOptions);
    } else {
      paramString1 = null;
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      if (HttpUtil.containsProxy(paramHttpRequest, paramRequestOptions)) {
        paramString2 = DEFAULT_KEEP_ALIVE_PROXY;
      } else {
        paramString2 = DEFAULT_KEEP_ALIVE;
      }
    }
    int i = DownloaderImpl.2.$SwitchMap$com$tencent$component$network$downloader$strategy$KeepAliveStrategy$KeepAlive[paramString2.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      HttpUtil.setKeepAliveEnabled(paramHttpRequest, paramBuilder, false);
      return;
    }
    HttpUtil.setKeepAliveEnabled(paramHttpRequest, paramBuilder, true);
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
  
  public void preConnectHost(ArrayList<String> paramArrayList, String paramString)
  {
    PreConnectManager.connectHost(obtainHttp2Client(), paramArrayList, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloaderImpl
 * JD-Core Version:    0.7.0.1
 */