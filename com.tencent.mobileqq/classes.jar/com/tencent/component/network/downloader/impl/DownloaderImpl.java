package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.text.TextUtils;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.Downloader.StreamDownloadListener;
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
import com.tencent.component.network.utils.http.base.QZoneHttp2Client;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
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
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import phw;
import phy;
import phz;

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
  private static final phz sThreadPoolCache = new phz("download", THREAD_POOL_SIZE);
  private Object ExecutingTaskListRock = new Object();
  private final FileCacheService mCacheFileCache = CacheManager.a(this.mContext, "download_cache", 100, 50, false);
  private Map mExecutingTaskList = new HashMap();
  private final HashMap mFutures = new HashMap();
  private QZoneHttpClient mHttpClient;
  private phy mLockManager = new phy(this, null);
  private QZoneHttp2Client mOkClient;
  private boolean mPaused = false;
  private final MultiHashMap mPendingRequests = new MultiHashMap();
  private final phz mThreadPoolCache = sThreadPoolCache;
  
  static
  {
    DownloadingHttp2TaskCount = 0;
    THREAD_POOL_SIZE = Config.e();
    MAX_CONNECTION = DownloadPreprocessStrategy.DownloadPool.size() * 3 * 5;
    MAX_CONNECTION_PER_ROUTE = THREAD_POOL_SIZE;
    TIME_TO_LIVE_HTTP = Config.b();
    TIME_TO_LIVE_HTTP2 = Config.c();
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
            if ((localDownloadTask != null) && (paramString.equals(localDownloadTask.a()))) {
              localDownloadTask.e();
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
      Config.a(str1, paramDownloadReport.isSucceed, localHashMap, paramDownloadReport.totaltime);
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
  
  private MultiHashMap collectAllPendingRequest(boolean paramBoolean, MultiHashMap paramMultiHashMap)
  {
    MultiHashMap localMultiHashMap2 = this.mPendingRequests;
    if (paramMultiHashMap != null) {}
    try
    {
      paramMultiHashMap.clear();
      if (this.mPendingRequests.isEmpty()) {
        return paramMultiHashMap;
      }
      MultiHashMap localMultiHashMap1 = paramMultiHashMap;
      if (paramMultiHashMap == null) {
        localMultiHashMap1 = new MultiHashMap();
      }
      localMultiHashMap1.putAll(this.mPendingRequests);
      if (paramBoolean) {
        this.mPendingRequests.clear();
      }
      return localMultiHashMap1;
    }
    finally {}
  }
  
  private Collection collectPendingRequest(String paramString, boolean paramBoolean, Collection paramCollection)
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
    ??? = getDownloadThreadPool(paramDownloadTask.a(), paramDownloadTask.b());
    paramDownloadTask.b();
    Future localFuture = ((PriorityThreadPool)???).submit(paramDownloadTask, new phw(this, paramDownloadTask), paramDownloadTask.a());
    synchronized (this.mFutures)
    {
      this.mFutures.put(paramDownloadTask.c(), localFuture);
      return;
    }
  }
  
  private PriorityThreadPool getDownloadThreadPool(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      if (this.pExternalThreadPool == null) {
        break;
      }
      return this.pExternalThreadPool;
    }
    DownloadPreprocessStrategy localDownloadPreprocessStrategy = this.pProcessStrategy;
    if (localDownloadPreprocessStrategy != null) {}
    for (paramString1 = localDownloadPreprocessStrategy.a(paramString1, paramString2);; paramString1 = null)
    {
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = DEFAULT_THREAD_POOL;
      }
      return this.mThreadPoolCache.a(paramString2.getName());
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
    return localFileHandler.a(paramDownloadResult.getPath(), paramDownloadRequest.getPath());
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
  
  private void notifyDownloadCanceled(Collection paramCollection)
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
  
  private void notifyDownloadFailed(Collection paramCollection, DownloadResult paramDownloadResult)
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
  
  private void notifyDownloadProgress(Collection paramCollection, long paramLong, float paramFloat)
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
  
  private void notifyDownloadSucceed(Collection paramCollection, DownloadResult paramDownloadResult)
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
  
  private void notifyStreamDownloadProgress(Collection paramCollection, String paramString)
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
            localStreamDownloadListener.a(localDownloadRequest.getUrl(), paramString);
          }
        }
      }
    }
  }
  
  private QZoneHttp2Client obtainHttp2Client()
  {
    if (this.mOkClient != null) {
      return this.mOkClient;
    }
    try
    {
      if (this.mOkClient != null)
      {
        QZoneHttp2Client localQZoneHttp2Client = this.mOkClient;
        return localQZoneHttp2Client;
      }
    }
    finally {}
    Object localObject2 = new HttpUtil.ClientOptions();
    ((HttpUtil.ClientOptions)localObject2).jdField_a_of_type_Boolean = true;
    ((HttpUtil.ClientOptions)localObject2).jdField_a_of_type_Int = MAX_CONNECTION;
    ((HttpUtil.ClientOptions)localObject2).b = MAX_CONNECTION_PER_ROUTE;
    ((HttpUtil.ClientOptions)localObject2).jdField_a_of_type_Long = TIME_TO_LIVE_HTTP2;
    this.mOkClient = HttpUtil.a((HttpUtil.ClientOptions)localObject2);
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
        QZoneHttpClient localQZoneHttpClient1 = this.mHttpClient;
        return localQZoneHttpClient1;
      }
    }
    finally {}
    this.mHttpClient = HttpUtil.a();
    QZoneHttpClient localQZoneHttpClient2 = this.mHttpClient;
    return localQZoneHttpClient2;
  }
  
  private boolean removePendingRequest(String paramString, DownloadRequest paramDownloadRequest, Collection paramCollection)
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
    if (QDLog.b()) {
      QDLog.b("Downloader", "download abort url:" + paramString + " listener:" + paramDownloadListener);
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
    String str1 = this.mCacheFileCache.a(str2);
    try
    {
      File localFile = new File(paramDownloadResult.getPath());
      boolean bool2 = FileUtils.copyFiles(localFile, new File(str1));
      boolean bool1 = bool2;
      paramDownloadResult = str1;
      if (!bool2)
      {
        paramDownloadResult = this.mCacheFileCache.a(str2, false);
        bool1 = FileUtils.copyFiles(localFile, new File(paramDownloadResult));
      }
      if (QDLog.b()) {
        QDLog.b("Downloader", "download cache entry to: " + paramDownloadResult + " " + paramString + " result:" + bool1);
      }
      return;
    }
    catch (Throwable paramDownloadResult)
    {
      QDLog.c("Downloader", "download ------- copy exception!!! " + paramString, paramDownloadResult);
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
    QDLog.b("Downloader", "download cancel url:" + paramString + " listener:" + paramDownloadListener);
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
    this.mCacheFileCache.a();
    if (this.pResumeTransfer != null) {
      this.pResumeTransfer.a();
    }
  }
  
  public void cleanCache(String paramString)
  {
    this.mCacheFileCache.a(generateStorageFileName(paramString));
    if (this.pResumeTransfer != null) {
      this.pResumeTransfer.a(paramString);
    }
  }
  
  public boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean)
  {
    Object localObject = paramDownloadRequest.getUrl();
    if ((!Utils.checkUrl((String)localObject)) || (paramDownloadRequest.getPaths() == null)) {
      return false;
    }
    String str = generateUrlKey((String)localObject);
    QDLog.b("downloader", "download :" + (String)localObject + " urlKey:" + str + " listener:" + paramDownloadRequest.getListener());
    boolean bool;
    if ((addPendingRequest((String)localObject, str, paramDownloadRequest)) && (!isDownloading((String)localObject)))
    {
      if (paramDownloadRequest.range > 0L) {
        paramDownloadRequest.addParam("Range", "bytes=" + paramDownloadRequest.range);
      }
      bool = Config.a(Utils.getDomin((String)localObject));
      if (!bool) {
        break label271;
      }
      obtainHttp2Client();
      if (paramDownloadRequest.mode != Downloader.DownloadMode.StrictMode) {
        break label279;
      }
      localObject = new StrictDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, (String)localObject, str, paramBoolean, bool);
      ((DownloadTask)localObject).a(12);
    }
    for (;;)
    {
      if (paramDownloadRequest.needMd5) {
        ((DownloadTask)localObject).d();
      }
      ((DownloadTask)localObject).a(paramDownloadRequest.getParams());
      ((DownloadTask)localObject).a(this, this.pDirectIPConfig, this.pBackupIPConfig, this.pPortConfigStrategy, this.pResumeTransfer, this.pReportHandler, this.pExternalReportHandler, this.pNetworkFlowStatistics, this.pTmpFileCache);
      enqueueTask((DownloadTask)localObject);
      return true;
      label271:
      obtainHttpClient();
      break;
      label279:
      localObject = new FastDownloadTask(this.mContext, this.mOkClient, this.mHttpClient, (String)localObject, str, paramBoolean, bool);
      ((DownloadTask)localObject).a(8);
    }
  }
  
  public String findCacheEntryPath(String paramString)
  {
    paramString = generateStorageName(paramString);
    paramString = this.mCacheFileCache.a(paramString);
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
      return localContentHandler.a(paramDownloadResult, paramHttpResponse, paramResponse);
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
      AssertUtil.a(bool);
      paramString1 = this.pKeepAliveStrategy;
      if (paramString1 == null) {
        break label103;
      }
      paramString1 = paramString1.a(paramString2, paramHttpRequest, paramRequestOptions);
      label45:
      paramString2 = paramString1;
      if (paramString1 == null) {
        if (!HttpUtil.a(paramHttpRequest, paramRequestOptions)) {
          break label108;
        }
      }
    }
    label103:
    label108:
    for (paramString2 = DEFAULT_KEEP_ALIVE_PROXY;; paramString2 = DEFAULT_KEEP_ALIVE) {
      switch (phx.a[paramString2.ordinal()])
      {
      default: 
        return;
        bool = false;
        break label20;
        paramString1 = null;
        break label45;
      }
    }
    HttpUtil.a(paramHttpRequest, paramBuilder, true);
    return;
    HttpUtil.a(paramHttpRequest, paramBuilder, false);
  }
  
  public void handlePrepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, int paramInt)
  {
    if (this.pProcessStrategy != null) {
      this.pProcessStrategy.a(paramString1, paramString2, paramHttpRequest, paramBuilder, paramInt);
    }
  }
  
  public void handleStreamDownloadProgress(String paramString1, String paramString2)
  {
    notifyStreamDownloadProgress(collectPendingRequest(paramString1, false, new ArrayList()), paramString2);
  }
  
  public void pause()
  {
    this.mPaused = true;
  }
  
  public String prepareRequestUrl(String paramString)
  {
    if (this.pProcessStrategy == null) {
      return null;
    }
    return this.pProcessStrategy.a(paramString);
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