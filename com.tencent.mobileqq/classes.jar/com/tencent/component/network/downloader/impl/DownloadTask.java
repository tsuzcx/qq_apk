package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadRequest.OnResponseDataListener;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.NetworkFlowStatistics;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public abstract class DownloadTask
  implements NetworkManager.NetStatusListener, ThreadPool.Job<DownloadResult>
{
  private static final int BYTESBUFFER_POOL_SIZE = 4;
  private static final int BYTESBUFFER_SIZE = 8192;
  private static final Object ConnectionCleanLock = new Object();
  private static volatile long mConnectionCleanTimestamp = System.currentTimeMillis();
  private static volatile int mTotalTaskCount = 0;
  protected static ConcurrentHashMap<String, Integer> map404Urls;
  private static final BytesBufferPool sBytesBufferPool = new BytesBufferPool(4, 8192);
  protected static final ThreadLocal<HttpUtil.RequestOptions> sRequestOptions;
  protected int attemptStrategyCount = 0;
  protected boolean disableHttps = false;
  protected DownloadRequest downloadRequest = null;
  protected int mAttemptCurrCount = 0;
  protected int mAttemptTotalCount = 1;
  protected long mContentLength;
  protected final Context mContext;
  private String mDomain;
  protected DownloadTask.DownloadTaskHandler mDownloadTaskHandler;
  private ReportHandler mExternalReportHandler;
  protected Map<String, String> mHttpParams;
  protected boolean mIsHttp2;
  private float mLastCallbackProgress = 0.0F;
  private boolean mNeedMd5;
  private Downloader.NetworkFlowStatistics mNetworkFlowStatistics;
  protected boolean mOriginalIsHttp2;
  private PriorityThreadPool.Priority mPriority;
  private float mProgressCallbackStep = 0.0F;
  protected long mRealFileLength = -1L;
  private ReportHandler mReportHandler;
  protected boolean mShouldReport = true;
  protected int mStandardPort = 80;
  protected final long mTaskStartTimeStamp = System.currentTimeMillis();
  private FileCacheService mTempFileCache;
  private final String mUrl;
  private final String mUrlKey;
  protected Request.Builder okRequestBuilder = null;
  protected Call okRequestCall = null;
  protected IPStrategy pBackupIPConfigStrategy;
  protected DownloadGlobalStrategy.StrategyInfo pCurrStrategyInfo = null;
  protected IPStrategy pDirectIPConfigStrategy;
  protected DownloadGlobalStrategy.StrategyLib pDownloadStrategyLib = null;
  protected DownloadTask.ExtendParam pExtendParam = new DownloadTask.ExtendParam(this);
  protected QZoneHttpClient pHttpClient;
  protected DownloadGlobalStrategy.StrategyInfo pOldStrategyInfo = null;
  protected PortConfigStrategy pPortConfigStrategy;
  protected ResumeTransfer pResumeTransfer;
  protected OkHttpClient pokHttpClient;
  private List<ReportHandler.DownloadReportObject> reportList = new ArrayList();
  protected HttpGet request = null;
  protected long t_recv_data = 0L;
  
  static
  {
    map404Urls = new ConcurrentHashMap();
    sRequestOptions = new DownloadTask.1();
  }
  
  public DownloadTask(Context paramContext, OkHttpClient paramOkHttpClient, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AssertUtil.assertTrue(Utils.checkUrl(paramString1));
    this.mContext = paramContext;
    this.mUrl = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    this.mUrlKey = paramString1;
    this.pokHttpClient = paramOkHttpClient;
    this.pHttpClient = paramQZoneHttpClient;
    if (paramBoolean1) {
      paramContext = PriorityThreadPool.Priority.HIGH;
    } else {
      paramContext = PriorityThreadPool.Priority.NORMAL;
    }
    setPriority(paramContext);
    this.mIsHttp2 = paramBoolean2;
    this.mOriginalIsHttp2 = paramBoolean2;
  }
  
  private void flushDownloadReport(ThreadPool.JobContext paramJobContext)
  {
    if (this.mReportHandler == null) {
      return;
    }
    if (this.reportList.size() > 0)
    {
      Object localObject = this.reportList;
      localObject = (ReportHandler.DownloadReportObject)((List)localObject).get(((List)localObject).size() - 1);
      if (localObject != null)
      {
        if (((!this.mShouldReport) || (paramJobContext.isCancelled())) && (((ReportHandler.DownloadReportObject)localObject).retCode != 0)) {
          return;
        }
        paramJobContext = this.mReportHandler;
        if (paramJobContext != null) {
          paramJobContext.uploadReport((ReportHandler.DownloadReportObject)localObject);
        }
      }
    }
  }
  
  public static int getCurrTotalTaskCount()
  {
    return mTotalTaskCount;
  }
  
  private boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse)
  {
    DownloadTask.DownloadTaskHandler localDownloadTaskHandler = this.mDownloadTaskHandler;
    if (localDownloadTaskHandler == null) {
      return true;
    }
    return localDownloadTaskHandler.handleContentType(paramDownloadResult, paramHttpResponse, paramResponse);
  }
  
  private boolean isXiaoMi()
  {
    String str1 = Build.BRAND;
    String str2 = Build.MODEL;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("brand:");
    localStringBuilder.append(str1);
    localStringBuilder.append(" model:");
    localStringBuilder.append(str2);
    QDLog.i("downloader", localStringBuilder.toString());
    return (str2 != null) && (str2.startsWith("MI"));
  }
  
  private void notifyStreamDownloadProgress(String paramString1, String paramString2)
  {
    DownloadTask.DownloadTaskHandler localDownloadTaskHandler = this.mDownloadTaskHandler;
    if (localDownloadTaskHandler == null) {
      return;
    }
    localDownloadTaskHandler.handleStreamDownloadProgress(paramString1, paramString2);
  }
  
  private void processReport(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult)
  {
    if (paramDownloadResult.getStatus().isFailed()) {
      if (paramDownloadResult.getStatus().getFailException() != null)
      {
        paramDownloadResult = Log.getStackTraceString(paramDownloadResult.getStatus().getFailException());
        if ((paramDownloadResult == null) || (!paramDownloadResult.contains("refused"))) {}
      }
      else if ((paramDownloadResult.getStatus().getFailException() != null) && ((paramDownloadResult.getStatus().getFailException() instanceof SocketException)))
      {
        paramDownloadResult = Log.getStackTraceString(paramDownloadResult.getStatus().getFailException());
        if ((paramDownloadResult == null) || (!paramDownloadResult.contains("Permission denied")) || (!isXiaoMi())) {}
      }
      else if (404 == paramDownloadResult.getStatus().httpStatus)
      {
        paramDownloadResult = (Integer)map404Urls.get(this.mUrl);
        if (paramDownloadResult == null)
        {
          map404Urls.put(this.mUrl, Integer.valueOf(1));
          QDLog.i("downloader", "save 404 url at first time.");
        }
        else
        {
          map404Urls.put(this.mUrl, Integer.valueOf(paramDownloadResult.intValue() + 1));
          paramJobContext = new StringBuilder();
          paramJobContext.append("save 404 url ");
          paramJobContext.append(paramDownloadResult.intValue() + 1);
          QDLog.i("downloader", paramJobContext.toString());
          return;
        }
      }
    }
    flushDownloadReport(paramJobContext);
  }
  
  private void setPriority(PriorityThreadPool.Priority paramPriority)
  {
    this.mPriority = paramPriority;
  }
  
  public void abort()
  {
    if (QDLog.isInfoEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloader abort:");
      ((StringBuilder)localObject).append(this.mUrl);
      QDLog.i("downloader", ((StringBuilder)localObject).toString());
    }
    this.mShouldReport = false;
    Object localObject = this.request;
    if (localObject != null) {
      try
      {
        ((HttpGet)localObject).abort();
        return;
      }
      catch (Exception localException1)
      {
        QDLog.w("downloader", "downloader abort Exception", localException1);
        return;
      }
    }
    Call localCall = this.okRequestCall;
    if (localCall != null) {
      try
      {
        localCall.cancel();
        return;
      }
      catch (Exception localException2)
      {
        QDLog.w("downloader", "downloader abort Exception", localException2);
      }
    }
  }
  
  protected void applyKeepAliveStrategy(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, HttpUtil.RequestOptions paramRequestOptions)
  {
    DownloadTask.DownloadTaskHandler localDownloadTaskHandler = this.mDownloadTaskHandler;
    if (localDownloadTaskHandler == null) {
      return;
    }
    localDownloadTaskHandler.handleKeepAliveStrategy(paramString1, paramString2, paramHttpRequest, paramBuilder, paramRequestOptions);
  }
  
  protected boolean canAttempt()
  {
    int i = this.mAttemptCurrCount + 1;
    this.mAttemptCurrCount = i;
    return i < this.mAttemptTotalCount;
  }
  
  /* Error */
  protected void cleanExpireConnection()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 207	com/tencent/component/network/downloader/impl/DownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   11: getstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   14: lsub
    //   15: lstore_1
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: iflt +12 -> 31
    //   22: lload_1
    //   23: ldc2_w 401
    //   26: lcmp
    //   27: ifge +4 -> 31
    //   30: return
    //   31: getstatic 117	com/tencent/component/network/downloader/impl/DownloadTask:ConnectionCleanLock	Ljava/lang/Object;
    //   34: astore_3
    //   35: aload_3
    //   36: monitorenter
    //   37: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   40: getstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   43: lsub
    //   44: lstore_1
    //   45: lload_1
    //   46: lconst_0
    //   47: lcmp
    //   48: iflt +14 -> 62
    //   51: lload_1
    //   52: ldc2_w 401
    //   55: lcmp
    //   56: ifge +6 -> 62
    //   59: aload_3
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: getfield 207	com/tencent/component/network/downloader/impl/DownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   66: invokevirtual 408	com/tencent/component/network/utils/http/base/QZoneHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   69: astore 4
    //   71: aload 4
    //   73: ifnull +96 -> 169
    //   76: aload 4
    //   78: instanceof 410
    //   81: ifeq +88 -> 169
    //   84: aload 4
    //   86: checkcast 410	com/tencent/component/network/utils/http/PoolingClientConnectionManager
    //   89: astore 4
    //   91: aload 4
    //   93: ifnull +61 -> 154
    //   96: aload 4
    //   98: invokevirtual 413	com/tencent/component/network/utils/http/PoolingClientConnectionManager:closeExpiredConnections	()V
    //   101: goto +53 -> 154
    //   104: astore 4
    //   106: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   109: putstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   112: invokestatic 416	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc_w 285
    //   121: ldc_w 418
    //   124: invokestatic 421	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 4
    //   129: athrow
    //   130: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   133: putstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   136: invokestatic 416	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   139: ifeq +30 -> 169
    //   142: ldc_w 285
    //   145: ldc_w 418
    //   148: invokestatic 421	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: goto +18 -> 169
    //   154: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   157: putstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   160: invokestatic 416	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   163: ifeq +6 -> 169
    //   166: goto -24 -> 142
    //   169: aload_3
    //   170: monitorexit
    //   171: return
    //   172: astore 4
    //   174: aload_3
    //   175: monitorexit
    //   176: goto +6 -> 182
    //   179: aload 4
    //   181: athrow
    //   182: goto -3 -> 179
    //   185: astore 4
    //   187: goto -57 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	DownloadTask
    //   15	37	1	l	long
    //   34	141	3	localObject1	Object
    //   69	28	4	localObject2	Object
    //   104	24	4	localObject3	Object
    //   172	8	4	localObject4	Object
    //   185	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   96	101	104	finally
    //   37	45	172	finally
    //   59	61	172	finally
    //   62	71	172	finally
    //   76	91	172	finally
    //   106	127	172	finally
    //   127	130	172	finally
    //   130	142	172	finally
    //   142	151	172	finally
    //   154	166	172	finally
    //   169	171	172	finally
    //   174	176	172	finally
    //   96	101	185	java/lang/Exception
  }
  
  protected boolean enableIpv6Debug()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("tencent");
      boolean bool = new File(localStringBuilder.toString(), "ipv6_debug.config").exists();
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      QDLog.w("downloader", "enableIpv6Debug exception", localThrowable);
    }
    return false;
  }
  
  protected boolean ensureStorageSpace(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if (!DownloadTask.TaskHelper.ensureFile(paramString, true)) {
        return false;
      }
      this.mTempFileCache.putFile(paramString.getName());
      if (paramLong <= 0L) {
        return true;
      }
      while (!paramString.exists()) {
        paramString = paramString.getParentFile();
      }
      paramString = new StatFs(paramString.getAbsolutePath());
      long l = paramString.getAvailableBlocks();
      int i = paramString.getBlockSize();
      return l * i > paramLong;
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public abstract void execute(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult);
  
  protected String generateStorageName()
  {
    Object localObject1 = this.mDownloadTaskHandler;
    if (localObject1 != null) {
      localObject1 = ((DownloadTask.DownloadTaskHandler)localObject1).generateStorageFileName(this.mUrl);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(this.mUrl)) {
        return UUID.randomUUID().toString();
      }
      localObject2 = String.valueOf(this.mUrl.hashCode());
    }
    return localObject2;
  }
  
  protected String generateStoragePath(String paramString)
  {
    return this.mTempFileCache.getPath(paramString);
  }
  
  protected String generateStoragePath(String paramString, boolean paramBoolean)
  {
    return this.mTempFileCache.getPath(paramString, paramBoolean);
  }
  
  protected long getContentLength()
  {
    return this.mContentLength;
  }
  
  protected int getCurrAttemptCount()
  {
    return this.mAttemptCurrCount;
  }
  
  public String getDomain()
  {
    if (this.mDomain == null) {
      this.mDomain = Utils.getDomin(this.mUrl);
    }
    return this.mDomain;
  }
  
  public DownloadRequest getDownloadRequest()
  {
    return this.downloadRequest;
  }
  
  public PriorityThreadPool.Priority getPriority()
  {
    return this.mPriority;
  }
  
  protected long getRealFileLength()
  {
    return this.mRealFileLength;
  }
  
  protected int getRetcode(HttpResponse paramHttpResponse, Response paramResponse)
  {
    if ((paramHttpResponse == null) && (paramResponse == null)) {
      return 0;
    }
    if (paramHttpResponse != null) {}
    long l;
    try
    {
      l = Long.parseLong(paramHttpResponse.getFirstHeader("Retcode").getValue());
    }
    catch (Exception paramHttpResponse)
    {
      return 0;
    }
    if (paramResponse != null)
    {
      paramHttpResponse = paramResponse.headers("Retcode");
      if ((paramHttpResponse != null) && (paramHttpResponse.size() > 0))
      {
        l = Long.parseLong((String)paramHttpResponse.get(0));
        break label82;
      }
    }
    return 0;
    label82:
    return (int)l;
  }
  
  protected int getRetryFlag(HttpResponse paramHttpResponse, Response paramResponse)
  {
    if (paramHttpResponse == null) {
      return -1;
    }
    if (paramHttpResponse != null) {}
    long l;
    try
    {
      l = Long.parseLong(paramHttpResponse.getFirstHeader("X-RtFlag").getValue());
    }
    catch (Exception paramHttpResponse)
    {
      return -1;
    }
    if (paramResponse != null)
    {
      paramHttpResponse = paramResponse.headers("X-RtFlag");
      if ((paramHttpResponse != null) && (paramHttpResponse.size() > 0))
      {
        l = Long.parseLong((String)paramHttpResponse.get(0));
        break label78;
      }
    }
    return -1;
    label78:
    return (int)l;
  }
  
  protected String getSavePath(long paramLong)
  {
    String str2 = generateStorageName();
    String str1 = generateStoragePath(str2);
    str2 = generateStoragePath(str2, false);
    if (ensureStorageSpace(str1, paramLong)) {
      return str1;
    }
    if ((!TextUtils.equals(str1, str2)) && (ensureStorageSpace(str2, paramLong))) {
      return str2;
    }
    return null;
  }
  
  protected int getTaskConcurrentCount()
  {
    DownloadTask.DownloadTaskHandler localDownloadTaskHandler = this.mDownloadTaskHandler;
    if (localDownloadTaskHandler != null)
    {
      if (this.mOriginalIsHttp2) {
        return localDownloadTaskHandler.getHttp2TaskConcurrentCount();
      }
      return localDownloadTaskHandler.getHttpTaskConcurrentCount();
    }
    return 1;
  }
  
  protected int getTotalAttemptCount()
  {
    return this.mAttemptTotalCount;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public String getUrlKey()
  {
    return this.mUrlKey;
  }
  
  protected int getXErrorCode(HttpResponse paramHttpResponse, Response paramResponse)
  {
    if ((paramHttpResponse == null) && (paramResponse == null)) {
      return 0;
    }
    if (paramHttpResponse != null) {}
    long l;
    try
    {
      l = Long.parseLong(paramHttpResponse.getFirstHeader("X-ErrNo").getValue());
    }
    catch (Exception paramHttpResponse)
    {
      return 0;
    }
    if (paramResponse != null)
    {
      paramHttpResponse = paramResponse.headers("X-ErrNo");
      if ((paramHttpResponse != null) && (paramHttpResponse.size() > 0))
      {
        l = Long.parseLong((String)paramHttpResponse.get(0));
        break label82;
      }
    }
    return 0;
    label82:
    return (int)l;
  }
  
  protected void handleDownloadReportForTask(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    if (this.mExternalReportHandler != null)
    {
      if (paramJobContext.isCancelled()) {
        paramDownloadResult.getStatus().state = 4;
      }
      this.mExternalReportHandler.handleReport(paramDownloadResult, paramDownloadReport);
    }
    if (paramJobContext.isCancelled()) {
      return;
    }
    paramJobContext = this.mReportHandler;
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.obtainReportObj(paramDownloadResult, paramDownloadReport);
      this.reportList.add(paramJobContext);
    }
    int j = 0;
    if ((!paramDownloadReport.isSucceed) && (paramDownloadReport.exception != null) && (paramDownloadResult != null))
    {
      int i;
      if (paramDownloadReport.isFromQzoneAlbum)
      {
        if (this.mOriginalIsHttp2) {
          i = 1;
        } else {
          i = 2;
        }
      }
      else
      {
        i = j;
        if (paramDownloadReport.url != null)
        {
          i = j;
          if (paramDownloadReport.url.startsWith("https://")) {
            i = 3;
          }
        }
      }
      Config.reportToLp(i, paramDownloadReport.isHttp2, paramDownloadReport.url, paramDownloadResult.getStatus().exception2Code, Log.getStackTraceString(paramDownloadReport.exception));
    }
  }
  
  protected boolean handleHeader(HttpResponse paramHttpResponse, Response paramResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext)
  {
    if (paramHttpResponse != null) {
      headerCallback(paramHttpResponse);
    }
    if (paramResponse != null) {
      headerCallback(paramResponse);
    }
    localObject7 = null;
    if (paramHttpResponse != null) {
      localObject5 = paramHttpResponse.getEntity();
    } else {
      localObject5 = null;
    }
    Object localObject1;
    if (paramResponse != null) {
      localObject1 = paramResponse.body();
    } else {
      localObject1 = null;
    }
    if (localObject5 != null) {}
    try
    {
      l = ((HttpEntity)localObject5).getContentLength();
    }
    catch (Throwable paramHttpResponse)
    {
      for (;;)
      {
        Object localObject8;
        int j;
        int i;
        label410:
        label585:
        continue;
        long l = 0L;
        continue;
        Object localObject4 = null;
        continue;
        localObject5 = null;
        Object localObject6 = localObject7;
      }
    }
    if (localObject1 != null)
    {
      l = ((ResponseBody)localObject1).contentLength();
      this.mContentLength = l;
      paramDownloadResult.getContent().length = this.mContentLength;
      if (localObject5 != null)
      {
        localObject1 = ((HttpEntity)localObject5).getContentType();
        if (localObject1 == null) {
          break label940;
        }
        localObject1 = ((Header)localObject1).getValue();
        localObject8 = ((HttpEntity)localObject5).getContentEncoding();
        localObject6 = localObject7;
        localObject5 = localObject1;
        if (localObject8 != null)
        {
          localObject6 = ((Header)localObject8).getValue();
          localObject5 = localObject1;
        }
      }
      else
      {
        if (localObject1 == null) {
          break label946;
        }
        localObject5 = ((ResponseBody)localObject1).contentType();
        if (localObject5 == null) {
          break label946;
        }
        localObject1 = ((MediaType)localObject5).toString();
        localObject8 = ((MediaType)localObject5).charset();
        localObject6 = localObject7;
        localObject5 = localObject1;
        if (localObject8 != null)
        {
          paramDownloadResult.getContent().encoding = ((Charset)localObject8).name();
          localObject6 = localObject7;
          localObject5 = localObject1;
        }
      }
      if (localObject5 != null) {
        paramDownloadResult.getContent().type = ((String)localObject5);
      }
      if (localObject6 != null) {
        paramDownloadResult.getContent().encoding = ((String)localObject6);
      }
      if (paramHttpResponse != null)
      {
        localObject1 = paramHttpResponse.getAllHeaders();
        if (localObject1 != null)
        {
          j = localObject1.length;
          i = 0;
          while (i < j)
          {
            if ("Client-Ip".equalsIgnoreCase(localObject1[i].getName()))
            {
              paramDownloadResult.getContent().clientip = localObject1[i].getValue();
              break;
            }
            i += 1;
          }
        }
        localObject1 = paramHttpResponse.getFirstHeader("Size");
        if (localObject1 == null) {}
      }
      try
      {
        this.mRealFileLength = Integer.parseInt(((Header)localObject1).getValue());
        paramDownloadResult.getContent().realsize = this.mRealFileLength;
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        break label410;
      }
      this.mRealFileLength = -1L;
      paramDownloadResult.getContent().realsize = -1L;
      localObject1 = paramHttpResponse.getFirstHeader("Last-Modified");
      if (localObject1 != null)
      {
        try
        {
          paramDownloadResult.getContent().lastModified = ((Header)localObject1).getValue();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        if (paramResponse != null)
        {
          localObject2 = paramResponse.headers();
          if (localObject2 != null)
          {
            j = ((Headers)localObject2).size();
            i = 0;
            while (i < j)
            {
              if ("Client-Ip".equalsIgnoreCase(((Headers)localObject2).name(i)))
              {
                paramDownloadResult.getContent().clientip = ((Headers)localObject2).value(i);
                break;
              }
              i += 1;
            }
          }
          localObject2 = paramResponse.header("Size");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {}
        }
      }
      try
      {
        this.mRealFileLength = Integer.parseInt((String)localObject2);
        paramDownloadResult.getContent().realsize = this.mRealFileLength;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject3;
        break label585;
      }
      this.mRealFileLength = -1L;
      paramDownloadResult.getContent().realsize = -1L;
      localObject2 = paramResponse.headers("Last-Modified");
      if (localObject2 != null) {
        try
        {
          if ((((List)localObject2).size() > 0) && (!TextUtils.isEmpty((CharSequence)((List)localObject2).get(0)))) {
            paramDownloadResult.getContent().lastModified = ((String)((List)localObject2).get(0));
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      if (paramJobContext.isCancelled()) {
        return false;
      }
      paramDownloadResult.getContent().noCache = false;
      if (paramHttpResponse != null)
      {
        localObject3 = paramHttpResponse.headerIterator("Cache-Control");
        do
        {
          if ((localObject3 == null) || (!((HeaderIterator)localObject3).hasNext())) {
            break;
          }
          localObject5 = ((HeaderIterator)localObject3).nextHeader();
        } while ((localObject5 == null) || (!"no-cache".equalsIgnoreCase(((Header)localObject5).getValue())));
        paramDownloadResult.getContent().noCache = true;
      }
      else if (paramResponse != null)
      {
        localObject3 = paramResponse.headers("Cache-Control");
        if (localObject3 != null)
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (String)((Iterator)localObject3).next();
            if ((TextUtils.isEmpty((CharSequence)localObject5)) && ("no-cache".equalsIgnoreCase((String)localObject5))) {
              paramDownloadResult.getContent().noCache = true;
            }
          }
        }
      }
      if (paramJobContext.isCancelled()) {
        return false;
      }
      if (!handleContentType(paramDownloadResult, paramHttpResponse, paramResponse))
      {
        paramDownloadResult.getStatus().setFailed(5);
        return false;
      }
      paramDownloadResult = this.pResumeTransfer;
      if ((paramDownloadResult != null) && (!paramDownloadResult.handleResponse(this.mUrl, this.mDomain, paramHttpResponse, paramResponse)))
      {
        QDLog.w("downloader", "download 断线续传 response not valid.");
        this.pResumeTransfer.onDownloadResult(this.mUrl, true);
        return false;
      }
      return true;
      paramHttpResponse.printStackTrace();
      return false;
    }
  }
  
  /* Error */
  protected boolean handleResponse(HttpResponse paramHttpResponse, Response paramResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: aload 4
    //   6: invokevirtual 795	com/tencent/component/network/downloader/impl/DownloadTask:handleHeader	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;)Z
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   17: lstore 9
    //   19: lload 9
    //   21: lstore 11
    //   23: iconst_1
    //   24: istore 30
    //   26: iload 5
    //   28: sipush 206
    //   31: if_icmpne +62 -> 93
    //   34: aload_0
    //   35: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   38: astore 31
    //   40: aload 31
    //   42: ifnull +40 -> 82
    //   45: aload 31
    //   47: aload_0
    //   48: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   51: invokeinterface 798 2 0
    //   56: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +23 -> 82
    //   62: aload_3
    //   63: aload_0
    //   64: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   67: aload_0
    //   68: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   71: invokeinterface 798 2 0
    //   76: invokevirtual 801	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   79: goto +141 -> 220
    //   82: ldc_w 285
    //   85: ldc_w 803
    //   88: invokestatic 787	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_0
    //   94: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   97: astore 31
    //   99: aload 31
    //   101: ifnull +42 -> 143
    //   104: aload 31
    //   106: aload_0
    //   107: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   110: invokeinterface 798 2 0
    //   115: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +25 -> 143
    //   121: iload 5
    //   123: sipush 200
    //   126: if_icmpne +17 -> 143
    //   129: aload_0
    //   130: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   133: aload_0
    //   134: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   137: iconst_1
    //   138: invokeinterface 791 3 0
    //   143: aload_0
    //   144: invokevirtual 559	com/tencent/component/network/downloader/impl/DownloadTask:generateStorageName	()Ljava/lang/String;
    //   147: astore 32
    //   149: aload_0
    //   150: aload 32
    //   152: invokevirtual 561	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 31
    //   157: aload_0
    //   158: aload 32
    //   160: iconst_0
    //   161: invokevirtual 563	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   164: astore 32
    //   166: aload_0
    //   167: aload 31
    //   169: aload_0
    //   170: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   173: invokevirtual 565	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   176: ifeq +12 -> 188
    //   179: aload_3
    //   180: aload 31
    //   182: invokevirtual 801	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   185: goto +32 -> 217
    //   188: aload 31
    //   190: aload 32
    //   192: invokestatic 569	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   195: ifne +1477 -> 1672
    //   198: aload_0
    //   199: aload 32
    //   201: aload_0
    //   202: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   205: invokevirtual 565	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   208: ifeq +1464 -> 1672
    //   211: aload_3
    //   212: aload 32
    //   214: invokevirtual 801	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   217: iconst_0
    //   218: istore 30
    //   220: getstatic 103	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   223: invokevirtual 806	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   226: astore 34
    //   228: aload_0
    //   229: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   232: lstore 23
    //   234: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   237: lstore 7
    //   239: new 432	java/io/File
    //   242: dup
    //   243: aload_3
    //   244: invokevirtual 808	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   247: invokespecial 456	java/io/File:<init>	(Ljava/lang/String;)V
    //   250: astore 32
    //   252: aload 32
    //   254: iconst_0
    //   255: invokestatic 462	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:ensureFile	(Ljava/io/File;Z)Z
    //   258: pop
    //   259: aload 4
    //   261: invokeinterface 245 1 0
    //   266: istore 29
    //   268: iload 29
    //   270: ifeq +111 -> 381
    //   273: aload_0
    //   274: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   277: lload 11
    //   279: lsub
    //   280: putfield 173	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   283: getstatic 103	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   286: aload 34
    //   288: invokevirtual 812	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   291: aload_0
    //   292: getfield 814	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   295: astore_1
    //   296: aload_1
    //   297: ifnull +19 -> 316
    //   300: aload_1
    //   301: invokestatic 819	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   304: lconst_0
    //   305: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   308: lload 7
    //   310: lsub
    //   311: invokeinterface 825 6 0
    //   316: new 274	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   323: astore_1
    //   324: aload_1
    //   325: ldc_w 827
    //   328: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_1
    //   333: aload_0
    //   334: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   337: invokevirtual 830	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: ldc_w 832
    //   345: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_1
    //   350: lconst_0
    //   351: invokevirtual 830	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload_1
    //   356: ldc_w 834
    //   359: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload_1
    //   364: iconst_0
    //   365: invokevirtual 837	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: ldc_w 285
    //   372: aload_1
    //   373: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 295	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: iconst_0
    //   380: ireturn
    //   381: ldc_w 285
    //   384: astore 4
    //   386: aload_0
    //   387: getfield 839	com/tencent/component/network/downloader/impl/DownloadTask:mNeedMd5	Z
    //   390: istore 29
    //   392: iload 29
    //   394: ifeq +47 -> 441
    //   397: aload_1
    //   398: ldc_w 841
    //   401: invokeinterface 535 2 0
    //   406: ifnull +13 -> 419
    //   409: aload_2
    //   410: ldc_w 841
    //   413: invokevirtual 552	okhttp3/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   416: ifnonnull +25 -> 441
    //   419: ldc_w 843
    //   422: invokestatic 849	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   425: astore 31
    //   427: goto +17 -> 444
    //   430: astore_1
    //   431: iconst_0
    //   432: istore 29
    //   434: aconst_null
    //   435: astore_3
    //   436: aconst_null
    //   437: astore_2
    //   438: goto +1048 -> 1486
    //   441: aconst_null
    //   442: astore 31
    //   444: aload_3
    //   445: invokevirtual 660	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   448: iconst_0
    //   449: putfield 852	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   452: aload_1
    //   453: ifnull +128 -> 581
    //   456: aload_1
    //   457: invokeinterface 643 1 0
    //   462: ifnull +119 -> 581
    //   465: aload_1
    //   466: invokeinterface 643 1 0
    //   471: invokeinterface 672 1 0
    //   476: ifnull +90 -> 566
    //   479: aload_1
    //   480: invokeinterface 643 1 0
    //   485: invokeinterface 672 1 0
    //   490: invokeinterface 540 1 0
    //   495: ifnull +71 -> 566
    //   498: aload_1
    //   499: invokeinterface 643 1 0
    //   504: invokeinterface 672 1 0
    //   509: invokeinterface 540 1 0
    //   514: invokevirtual 855	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   517: ldc_w 857
    //   520: invokevirtual 860	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   523: iconst_m1
    //   524: if_icmple +42 -> 566
    //   527: new 862	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   530: dup
    //   531: aload_1
    //   532: invokeinterface 643 1 0
    //   537: invokeinterface 865 1 0
    //   542: invokespecial 868	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   545: astore_2
    //   546: aload_3
    //   547: invokevirtual 660	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   550: iconst_1
    //   551: putfield 852	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   554: goto +1133 -> 1687
    //   557: astore_1
    //   558: iconst_1
    //   559: istore 29
    //   561: aload_2
    //   562: astore_3
    //   563: goto -127 -> 436
    //   566: aload_1
    //   567: invokeinterface 643 1 0
    //   572: invokeinterface 865 1 0
    //   577: astore_1
    //   578: goto +1104 -> 1682
    //   581: aload_2
    //   582: ifnull +68 -> 650
    //   585: aload_2
    //   586: invokevirtual 647	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   589: ifnull +61 -> 650
    //   592: aload_2
    //   593: ldc_w 870
    //   596: invokevirtual 738	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   599: astore_1
    //   600: aload_1
    //   601: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   604: ifne +35 -> 639
    //   607: aload_1
    //   608: invokevirtual 855	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   611: ldc_w 857
    //   614: invokevirtual 860	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   617: iconst_m1
    //   618: if_icmple +21 -> 639
    //   621: new 862	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   624: dup
    //   625: aload_2
    //   626: invokevirtual 647	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   629: invokevirtual 873	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   632: invokespecial 868	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   635: astore_2
    //   636: goto +1051 -> 1687
    //   639: aload_2
    //   640: invokevirtual 647	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   643: invokevirtual 873	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   646: astore_1
    //   647: goto +1035 -> 1682
    //   650: aconst_null
    //   651: astore_2
    //   652: iconst_0
    //   653: istore 29
    //   655: new 875	java/io/FileOutputStream
    //   658: dup
    //   659: aload 32
    //   661: iload 30
    //   663: invokespecial 878	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   666: astore_1
    //   667: aload 32
    //   669: invokevirtual 880	java/io/File:length	()J
    //   672: lstore 25
    //   674: lconst_0
    //   675: lstore 15
    //   677: iconst_0
    //   678: istore 5
    //   680: lconst_0
    //   681: lstore 9
    //   683: lload 7
    //   685: lstore 13
    //   687: lload 15
    //   689: lstore 7
    //   691: lload 13
    //   693: lstore 19
    //   695: aload 34
    //   697: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   700: astore 33
    //   702: lload 11
    //   704: lstore 13
    //   706: aload_2
    //   707: aload 33
    //   709: iload 5
    //   711: sipush 8192
    //   714: iload 5
    //   716: isub
    //   717: invokevirtual 892	java/io/InputStream:read	([BII)I
    //   720: istore 6
    //   722: iload 6
    //   724: ifle +269 -> 993
    //   727: iload 5
    //   729: iload 6
    //   731: iadd
    //   732: istore 5
    //   734: iload 5
    //   736: sipush 8192
    //   739: if_icmpne +980 -> 1719
    //   742: aload_1
    //   743: aload 34
    //   745: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   748: iconst_0
    //   749: iload 5
    //   751: invokevirtual 898	java/io/OutputStream:write	([BII)V
    //   754: aload_0
    //   755: aload_0
    //   756: getfield 203	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   759: aload 32
    //   761: invokevirtual 899	java/io/File:getPath	()Ljava/lang/String;
    //   764: invokespecial 901	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: aload 31
    //   769: ifnull +28 -> 797
    //   772: aload 31
    //   774: aload 34
    //   776: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   779: iconst_0
    //   780: iload 5
    //   782: invokevirtual 904	java/security/MessageDigest:update	([BII)V
    //   785: goto +12 -> 797
    //   788: astore_3
    //   789: aload_1
    //   790: astore 31
    //   792: aload_3
    //   793: astore_1
    //   794: goto +919 -> 1713
    //   797: aload_0
    //   798: getfield 171	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   801: getfield 908	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   804: ifnull +889 -> 1693
    //   807: aload_0
    //   808: getfield 171	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   811: getfield 908	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   814: astore 33
    //   816: aload 34
    //   818: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   821: astore 35
    //   823: lload 7
    //   825: lstore 17
    //   827: lload 9
    //   829: lstore 15
    //   831: aload 33
    //   833: aload 35
    //   835: iconst_0
    //   836: iload 5
    //   838: aload_0
    //   839: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   842: lload 25
    //   844: l2i
    //   845: iload 29
    //   847: invokeinterface 914 8 0
    //   852: goto +841 -> 1693
    //   855: lload 7
    //   857: iload 6
    //   859: i2l
    //   860: ladd
    //   861: lstore 7
    //   863: lload 7
    //   865: lstore 17
    //   867: lload 9
    //   869: lstore 15
    //   871: aload_3
    //   872: invokevirtual 660	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   875: lload 7
    //   877: putfield 916	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   880: lload 23
    //   882: lconst_0
    //   883: lcmp
    //   884: ifle +85 -> 969
    //   887: lload 7
    //   889: lstore 17
    //   891: lload 9
    //   893: lstore 15
    //   895: aload_2
    //   896: instanceof 862
    //   899: ifeq +823 -> 1722
    //   902: lload 7
    //   904: lstore 17
    //   906: lload 9
    //   908: lstore 15
    //   910: aload_2
    //   911: checkcast 862	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   914: invokevirtual 919	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:getRealReadLen	()J
    //   917: lstore 21
    //   919: goto +3 -> 922
    //   922: lload 7
    //   924: lstore 17
    //   926: lload 9
    //   928: lstore 15
    //   930: aload_0
    //   931: getfield 203	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   934: astore 33
    //   936: lload 23
    //   938: lload 25
    //   940: ladd
    //   941: lstore 27
    //   943: lload 7
    //   945: lstore 17
    //   947: lload 9
    //   949: lstore 15
    //   951: aload_0
    //   952: aload 33
    //   954: lload 27
    //   956: lload 21
    //   958: lload 25
    //   960: ladd
    //   961: l2f
    //   962: lload 27
    //   964: l2f
    //   965: fdiv
    //   966: invokevirtual 923	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   969: lload 7
    //   971: lstore 17
    //   973: lload 9
    //   975: lstore 15
    //   977: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   980: lstore 21
    //   982: lload 13
    //   984: lstore 11
    //   986: lload 21
    //   988: lstore 13
    //   990: goto -299 -> 691
    //   993: aload_1
    //   994: astore 33
    //   996: iload 6
    //   998: ifgt +754 -> 1752
    //   1001: iload 5
    //   1003: ifle +749 -> 1752
    //   1006: lload 7
    //   1008: lstore 17
    //   1010: lload 9
    //   1012: lstore 15
    //   1014: aload 34
    //   1016: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   1019: astore 35
    //   1021: aload 33
    //   1023: aload 35
    //   1025: iconst_0
    //   1026: iload 5
    //   1028: invokevirtual 898	java/io/OutputStream:write	([BII)V
    //   1031: aload_0
    //   1032: aload_0
    //   1033: getfield 203	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   1036: aload 32
    //   1038: invokevirtual 899	java/io/File:getPath	()Ljava/lang/String;
    //   1041: invokespecial 901	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   1044: aload_0
    //   1045: getfield 171	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   1048: getfield 908	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   1051: ifnull +32 -> 1083
    //   1054: aload_0
    //   1055: getfield 171	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   1058: getfield 908	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   1061: aload 34
    //   1063: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   1066: iconst_0
    //   1067: iload 5
    //   1069: aload_0
    //   1070: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1073: lload 25
    //   1075: l2i
    //   1076: iload 29
    //   1078: invokeinterface 914 8 0
    //   1083: lload 9
    //   1085: iload 5
    //   1087: i2l
    //   1088: ladd
    //   1089: lstore 9
    //   1091: aload 31
    //   1093: ifnull +636 -> 1729
    //   1096: lload 9
    //   1098: lstore 11
    //   1100: aload 31
    //   1102: aload 34
    //   1104: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   1107: iconst_0
    //   1108: iload 5
    //   1110: invokevirtual 904	java/security/MessageDigest:update	([BII)V
    //   1113: goto +3 -> 1116
    //   1116: lload 23
    //   1118: lconst_0
    //   1119: lcmp
    //   1120: ifgt +32 -> 1152
    //   1123: lload 9
    //   1125: lstore 11
    //   1127: aload_0
    //   1128: aload_0
    //   1129: getfield 203	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   1132: lload 23
    //   1134: lload 25
    //   1136: ladd
    //   1137: fconst_1
    //   1138: invokevirtual 923	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   1141: goto +11 -> 1152
    //   1144: astore_3
    //   1145: lload 11
    //   1147: lstore 9
    //   1149: goto +229 -> 1378
    //   1152: aload_3
    //   1153: invokevirtual 660	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1156: lload 7
    //   1158: putfield 916	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1161: aload_0
    //   1162: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1165: lload 13
    //   1167: lsub
    //   1168: putfield 173	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   1171: aload_2
    //   1172: ifnull +23 -> 1195
    //   1175: aload_2
    //   1176: invokevirtual 926	java/io/InputStream:close	()V
    //   1179: goto +16 -> 1195
    //   1182: astore_2
    //   1183: aload 4
    //   1185: ldc_w 928
    //   1188: aload_2
    //   1189: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1192: goto +3 -> 1195
    //   1195: aload_1
    //   1196: invokevirtual 929	java/io/OutputStream:close	()V
    //   1199: goto +13 -> 1212
    //   1202: astore_1
    //   1203: aload 4
    //   1205: ldc_w 928
    //   1208: aload_1
    //   1209: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1212: getstatic 103	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1215: aload 34
    //   1217: invokevirtual 812	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1220: aload_0
    //   1221: getfield 814	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1224: astore_1
    //   1225: aload_1
    //   1226: ifnull +20 -> 1246
    //   1229: aload_1
    //   1230: invokestatic 819	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1233: lload 7
    //   1235: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1238: lload 19
    //   1240: lsub
    //   1241: invokeinterface 825 6 0
    //   1246: aload 31
    //   1248: ifnull +63 -> 1311
    //   1251: aload 31
    //   1253: invokevirtual 933	java/security/MessageDigest:digest	()[B
    //   1256: astore_1
    //   1257: new 274	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   1264: astore_2
    //   1265: iconst_0
    //   1266: istore 5
    //   1268: iload 5
    //   1270: aload_1
    //   1271: arraylength
    //   1272: if_icmpge +28 -> 1300
    //   1275: aload_2
    //   1276: aload_1
    //   1277: iload 5
    //   1279: baload
    //   1280: sipush 255
    //   1283: iand
    //   1284: invokestatic 936	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1287: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: iload 5
    //   1293: iconst_1
    //   1294: iadd
    //   1295: istore 5
    //   1297: goto -29 -> 1268
    //   1300: aload_3
    //   1301: invokevirtual 660	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1304: aload_2
    //   1305: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1308: putfield 939	com/tencent/component/network/downloader/DownloadResult$Content:md5	Ljava/lang/String;
    //   1311: new 274	java/lang/StringBuilder
    //   1314: dup
    //   1315: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   1318: astore_1
    //   1319: aload_1
    //   1320: ldc_w 827
    //   1323: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: pop
    //   1327: aload_1
    //   1328: aload_0
    //   1329: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1332: invokevirtual 830	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1335: pop
    //   1336: aload_1
    //   1337: ldc_w 832
    //   1340: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload_1
    //   1345: lload 9
    //   1347: invokevirtual 830	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload_1
    //   1352: ldc_w 834
    //   1355: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: aload_1
    //   1360: iload 29
    //   1362: invokevirtual 837	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: aload 4
    //   1368: aload_1
    //   1369: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1372: invokestatic 295	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: iconst_1
    //   1376: ireturn
    //   1377: astore_3
    //   1378: aload_2
    //   1379: astore 31
    //   1381: lload 7
    //   1383: lstore 11
    //   1385: aload_1
    //   1386: astore_2
    //   1387: aload_3
    //   1388: astore_1
    //   1389: lload 9
    //   1391: lstore 7
    //   1393: aload 4
    //   1395: astore_3
    //   1396: lload 11
    //   1398: lstore 9
    //   1400: aload 31
    //   1402: astore 4
    //   1404: goto +115 -> 1519
    //   1407: astore 31
    //   1409: goto +5 -> 1414
    //   1412: astore 31
    //   1414: aload_1
    //   1415: astore_3
    //   1416: aload 31
    //   1418: astore_1
    //   1419: aload_2
    //   1420: astore 31
    //   1422: lload 7
    //   1424: lstore 13
    //   1426: aload_3
    //   1427: astore_2
    //   1428: lload 9
    //   1430: lstore 7
    //   1432: aload 4
    //   1434: astore_3
    //   1435: lload 13
    //   1437: lstore 9
    //   1439: aload 31
    //   1441: astore 4
    //   1443: lload 11
    //   1445: lstore 13
    //   1447: goto +72 -> 1519
    //   1450: astore 4
    //   1452: aload_1
    //   1453: astore_3
    //   1454: aload 4
    //   1456: astore_1
    //   1457: goto +6 -> 1463
    //   1460: astore_1
    //   1461: aconst_null
    //   1462: astore_3
    //   1463: aload_2
    //   1464: astore 4
    //   1466: aload_3
    //   1467: astore_2
    //   1468: aload 4
    //   1470: astore_3
    //   1471: goto +15 -> 1486
    //   1474: astore_1
    //   1475: goto +4 -> 1479
    //   1478: astore_1
    //   1479: iconst_0
    //   1480: istore 29
    //   1482: aconst_null
    //   1483: astore_2
    //   1484: aconst_null
    //   1485: astore_3
    //   1486: ldc_w 285
    //   1489: astore 31
    //   1491: lconst_0
    //   1492: lstore 11
    //   1494: lconst_0
    //   1495: lstore 15
    //   1497: lload 9
    //   1499: lstore 13
    //   1501: aload_3
    //   1502: astore 4
    //   1504: lload 7
    //   1506: lstore 19
    //   1508: lload 15
    //   1510: lstore 9
    //   1512: aload 31
    //   1514: astore_3
    //   1515: lload 11
    //   1517: lstore 7
    //   1519: aload_0
    //   1520: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1523: lload 13
    //   1525: lsub
    //   1526: putfield 173	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   1529: aload 4
    //   1531: ifnull +22 -> 1553
    //   1534: aload 4
    //   1536: invokevirtual 926	java/io/InputStream:close	()V
    //   1539: goto +14 -> 1553
    //   1542: astore 4
    //   1544: aload_3
    //   1545: ldc_w 928
    //   1548: aload 4
    //   1550: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1553: aload_2
    //   1554: ifnull +19 -> 1573
    //   1557: aload_2
    //   1558: invokevirtual 929	java/io/OutputStream:close	()V
    //   1561: goto +12 -> 1573
    //   1564: astore_2
    //   1565: aload_3
    //   1566: ldc_w 928
    //   1569: aload_2
    //   1570: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1573: getstatic 103	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1576: aload 34
    //   1578: invokevirtual 812	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1581: aload_0
    //   1582: getfield 814	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1585: astore_2
    //   1586: aload_2
    //   1587: ifnull +20 -> 1607
    //   1590: aload_2
    //   1591: invokestatic 819	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1594: lload 9
    //   1596: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1599: lload 19
    //   1601: lsub
    //   1602: invokeinterface 825 6 0
    //   1607: new 274	java/lang/StringBuilder
    //   1610: dup
    //   1611: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   1614: astore_2
    //   1615: aload_2
    //   1616: ldc_w 827
    //   1619: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: pop
    //   1623: aload_2
    //   1624: aload_0
    //   1625: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1628: invokevirtual 830	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1631: pop
    //   1632: aload_2
    //   1633: ldc_w 832
    //   1636: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: pop
    //   1640: aload_2
    //   1641: lload 7
    //   1643: invokevirtual 830	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1646: pop
    //   1647: aload_2
    //   1648: ldc_w 834
    //   1651: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: pop
    //   1655: aload_2
    //   1656: iload 29
    //   1658: invokevirtual 837	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1661: pop
    //   1662: aload_3
    //   1663: aload_2
    //   1664: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1667: invokestatic 295	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1670: aload_1
    //   1671: athrow
    //   1672: aload_3
    //   1673: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1676: iconst_2
    //   1677: invokevirtual 775	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   1680: iconst_0
    //   1681: ireturn
    //   1682: aload_1
    //   1683: astore_2
    //   1684: goto -1032 -> 652
    //   1687: iconst_1
    //   1688: istore 29
    //   1690: goto -1035 -> 655
    //   1693: lload 9
    //   1695: iload 5
    //   1697: i2l
    //   1698: ladd
    //   1699: lstore 9
    //   1701: iconst_0
    //   1702: istore 5
    //   1704: goto -849 -> 855
    //   1707: astore_3
    //   1708: aload_1
    //   1709: astore 31
    //   1711: aload_3
    //   1712: astore_1
    //   1713: aload 31
    //   1715: astore_3
    //   1716: goto -297 -> 1419
    //   1719: goto -864 -> 855
    //   1722: lload 7
    //   1724: lstore 21
    //   1726: goto -804 -> 922
    //   1729: goto -613 -> 1116
    //   1732: astore_3
    //   1733: aload 33
    //   1735: astore 31
    //   1737: goto -26 -> 1711
    //   1740: astore_3
    //   1741: lload 17
    //   1743: lstore 7
    //   1745: lload 15
    //   1747: lstore 9
    //   1749: goto -41 -> 1708
    //   1752: goto -636 -> 1116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1755	0	this	DownloadTask
    //   0	1755	1	paramHttpResponse	HttpResponse
    //   0	1755	2	paramResponse	Response
    //   0	1755	3	paramDownloadResult	DownloadResult
    //   0	1755	4	paramJobContext	ThreadPool.JobContext
    //   0	1755	5	paramInt	int
    //   720	277	6	i	int
    //   237	1507	7	l1	long
    //   17	1731	9	l2	long
    //   21	1495	11	l3	long
    //   685	839	13	l4	long
    //   675	1071	15	l5	long
    //   825	917	17	l6	long
    //   693	907	19	l7	long
    //   917	808	21	l8	long
    //   232	901	23	l9	long
    //   672	463	25	l10	long
    //   941	22	27	l11	long
    //   266	1423	29	bool1	boolean
    //   24	638	30	bool2	boolean
    //   38	1363	31	localObject1	Object
    //   1407	1	31	localObject2	Object
    //   1412	5	31	localObject3	Object
    //   1420	316	31	localObject4	Object
    //   147	890	32	localObject5	Object
    //   700	1034	33	localObject6	Object
    //   226	1351	34	localBytesBuffer	com.tencent.component.network.utils.BytesBufferPool.BytesBuffer
    //   821	203	35	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   397	419	430	finally
    //   419	427	430	finally
    //   456	546	430	finally
    //   566	578	430	finally
    //   585	636	430	finally
    //   639	647	430	finally
    //   546	554	557	finally
    //   772	785	788	finally
    //   1100	1113	1144	finally
    //   1127	1141	1144	finally
    //   1175	1179	1182	java/lang/Throwable
    //   1195	1199	1202	java/lang/Throwable
    //   1152	1161	1377	finally
    //   706	722	1407	finally
    //   695	702	1412	finally
    //   667	674	1450	finally
    //   655	667	1460	finally
    //   386	392	1474	finally
    //   444	452	1474	finally
    //   239	268	1478	finally
    //   1534	1539	1542	java/lang/Throwable
    //   1557	1561	1564	java/lang/Throwable
    //   742	767	1707	finally
    //   797	823	1707	finally
    //   1021	1083	1732	finally
    //   831	852	1740	finally
    //   871	880	1740	finally
    //   895	902	1740	finally
    //   910	919	1740	finally
    //   930	936	1740	finally
    //   951	969	1740	finally
    //   977	982	1740	finally
    //   1014	1021	1740	finally
  }
  
  protected void headerCallback(Response paramResponse)
  {
    if (paramResponse == null) {
      return;
    }
    int i = paramResponse.code();
    paramResponse = paramResponse.headers().toMultimap();
    DownloadTask.DownloadTaskHandler localDownloadTaskHandler = this.mDownloadTaskHandler;
    if (localDownloadTaskHandler != null) {
      localDownloadTaskHandler.handleRequestHeader(this.mUrlKey, i, paramResponse);
    }
  }
  
  protected void headerCallback(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse != null)
    {
      if (paramHttpResponse.headerIterator() == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      HeaderIterator localHeaderIterator = paramHttpResponse.headerIterator();
      while (localHeaderIterator.hasNext())
      {
        Header localHeader = localHeaderIterator.nextHeader();
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(localHeader.getValue());
        localHashMap.put(localHeader.getName(), localArrayList);
      }
      int i = paramHttpResponse.getStatusLine().getStatusCode();
      paramHttpResponse = this.mDownloadTaskHandler;
      if (paramHttpResponse != null) {
        paramHttpResponse.handleRequestHeader(this.mUrlKey, i, localHashMap);
      }
    }
  }
  
  protected void initTask()
  {
    if (this.mDomain == null) {
      this.mDomain = Utils.getDomin(this.mUrl);
    }
  }
  
  protected void notifyDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    DownloadTask.DownloadTaskHandler localDownloadTaskHandler = this.mDownloadTaskHandler;
    if (localDownloadTaskHandler == null) {
      return;
    }
    if (paramFloat - this.mLastCallbackProgress >= this.mProgressCallbackStep)
    {
      this.mLastCallbackProgress = paramFloat;
      localDownloadTaskHandler.handleDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    this.mShouldReport = false;
  }
  
  public void onTaskDequeue()
  {
    mTotalTaskCount -= 1;
  }
  
  public void onTaskEnqueue()
  {
    mTotalTaskCount += 1;
  }
  
  protected String parserHttpHeaderInfo(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, Response paramResponse)
  {
    paramHttpRequest = new StringBuffer();
    paramHttpRequest.append("<-----Response Headers----->");
    int j = 0;
    int i = 0;
    if (paramHttpResponse != null)
    {
      paramHttpRequest.append(paramHttpResponse.getStatusLine());
      paramHttpRequest.append(";");
      paramHttpResponse = paramHttpResponse.getAllHeaders();
      if (paramHttpResponse != null) {
        while (i < paramHttpResponse.length)
        {
          paramHttpRequest.append(paramHttpResponse[i].getName());
          paramHttpRequest.append(": ");
          paramHttpRequest.append(paramHttpResponse[i].getValue());
          paramHttpRequest.append(";");
          i += 1;
        }
      }
    }
    else if (paramResponse != null)
    {
      paramHttpRequest.append(paramResponse.code());
      paramHttpRequest.append(";");
      paramHttpResponse = paramResponse.headers();
      if (paramHttpResponse != null)
      {
        i = j;
        while (i < paramHttpResponse.size())
        {
          paramHttpRequest.append(paramHttpResponse.name(i));
          paramHttpRequest.append(": ");
          paramHttpRequest.append(paramHttpResponse.value(i));
          paramHttpRequest.append(";");
          i += 1;
        }
      }
    }
    paramHttpRequest.append("/*********/");
    return paramHttpRequest.toString();
  }
  
  protected void prepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder)
  {
    if (this.mDownloadTaskHandler == null) {
      return;
    }
    if ((this.mHttpParams != null) && ((paramBuilder != null) || (paramHttpRequest != null)))
    {
      Iterator localIterator = this.mHttpParams.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          if (paramBuilder != null) {
            paramBuilder.header(str, (String)localObject);
          } else if (paramHttpRequest != null) {
            paramHttpRequest.addHeader(str, (String)localObject);
          }
        }
      }
    }
    this.mDownloadTaskHandler.handlePrepareRequest(paramString1, paramString2, paramHttpRequest, paramBuilder, getCurrAttemptCount());
  }
  
  protected String prepareUrl(String paramString)
  {
    int i;
    if ((Config.getNetworkStackType() != 2) && (Config.getNetworkStackType() != 3)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.startsWith("https:"))
      {
        localObject = paramString;
        if (this.mIsHttp2)
        {
          localObject = paramString;
          if (i == 0) {
            localObject = paramString.replace("http:", "https:");
          }
        }
      }
    }
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (((String)localObject).startsWith("https:"))
      {
        paramString = (String)localObject;
        if (this.disableHttps) {
          paramString = ((String)localObject).replace("https:", "http:");
        }
      }
    }
    localObject = this.mDownloadTaskHandler;
    if (localObject == null) {
      return paramString;
    }
    localObject = ((DownloadTask.DownloadTaskHandler)localObject).prepareRequestUrl(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return paramString;
    }
    return localObject;
  }
  
  public void removeHttpParam(String paramString)
  {
    this.mHttpParams.remove(paramString);
  }
  
  /* Error */
  public final DownloadResult run(ThreadPool.JobContext paramJobContext)
  {
    // Byte code:
    //   0: new 310	com/tencent/component/network/downloader/DownloadResult
    //   3: dup
    //   4: aload_0
    //   5: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   8: invokespecial 1056	com/tencent/component/network/downloader/DownloadResult:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: aload_1
    //   14: invokeinterface 245 1 0
    //   19: istore_2
    //   20: aconst_null
    //   21: astore_3
    //   22: iload_2
    //   23: ifeq +14 -> 37
    //   26: aload_0
    //   27: aload_1
    //   28: aload 4
    //   30: aconst_null
    //   31: invokevirtual 1058	com/tencent/component/network/downloader/impl/DownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   34: aload 4
    //   36: areturn
    //   37: aload_0
    //   38: getfield 259	com/tencent/component/network/downloader/impl/DownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   41: astore 5
    //   43: aload 5
    //   45: ifnull +15 -> 60
    //   48: aload 5
    //   50: aload_0
    //   51: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   54: invokeinterface 1061 2 0
    //   59: astore_3
    //   60: aload_3
    //   61: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +75 -> 139
    //   67: invokestatic 376	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   70: ifeq +52 -> 122
    //   73: new 274	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   80: astore_1
    //   81: aload_1
    //   82: ldc_w 1063
    //   85: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_1
    //   90: aload_3
    //   91: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: ldc_w 1065
    //   99: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: aload_0
    //   105: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   108: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: ldc_w 285
    //   115: aload_1
    //   116: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 295	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 4
    //   124: aload_3
    //   125: invokevirtual 801	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   128: aload 4
    //   130: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   133: invokevirtual 1068	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   136: aload 4
    //   138: areturn
    //   139: aload_1
    //   140: iconst_2
    //   141: invokeinterface 1072 2 0
    //   146: pop
    //   147: aload_0
    //   148: invokevirtual 1074	com/tencent/component/network/downloader/impl/DownloadTask:initTask	()V
    //   151: aload_0
    //   152: invokestatic 1078	com/tencent/component/network/NetworkManager:registNetStatusListener	(Lcom/tencent/component/network/NetworkManager$NetStatusListener;)V
    //   155: aload_0
    //   156: aload_1
    //   157: aload 4
    //   159: invokevirtual 1080	com/tencent/component/network/downloader/impl/DownloadTask:execute	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   162: aload_0
    //   163: getfield 193	com/tencent/component/network/downloader/impl/DownloadTask:mContext	Landroid/content/Context;
    //   166: invokestatic 1086	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   169: ifne +18 -> 187
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 147	com/tencent/component/network/downloader/impl/DownloadTask:mShouldReport	Z
    //   177: aload 4
    //   179: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   182: bipush 6
    //   184: invokevirtual 775	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   187: aload_0
    //   188: aload_1
    //   189: aload 4
    //   191: invokespecial 1088	com/tencent/component/network/downloader/impl/DownloadTask:processReport	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   194: aload_0
    //   195: invokevirtual 1090	com/tencent/component/network/downloader/impl/DownloadTask:onTaskDequeue	()V
    //   198: aload_0
    //   199: getfield 145	com/tencent/component/network/downloader/impl/DownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   202: ifnull +60 -> 262
    //   205: aload 4
    //   207: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   210: invokevirtual 1092	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   213: ifeq +49 -> 262
    //   216: aload_0
    //   217: getfield 145	com/tencent/component/network/downloader/impl/DownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   220: aload 4
    //   222: putfield 1098	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:result	Lcom/tencent/component/network/downloader/DownloadResult;
    //   225: aload_0
    //   226: getfield 193	com/tencent/component/network/downloader/impl/DownloadTask:mContext	Landroid/content/Context;
    //   229: invokestatic 1103	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   232: aload_0
    //   233: getfield 193	com/tencent/component/network/downloader/impl/DownloadTask:mContext	Landroid/content/Context;
    //   236: aload_0
    //   237: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   240: aload_0
    //   241: getfield 517	com/tencent/component/network/downloader/impl/DownloadTask:mDomain	Ljava/lang/String;
    //   244: aload_0
    //   245: getfield 145	com/tencent/component/network/downloader/impl/DownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   248: aload 4
    //   250: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   253: invokevirtual 1092	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   256: invokevirtual 1107	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:report	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;Z)V
    //   259: goto +69 -> 328
    //   262: aload_0
    //   263: getfield 141	com/tencent/component/network/downloader/impl/DownloadTask:pDownloadStrategyLib	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib;
    //   266: ifnull +62 -> 328
    //   269: aload_0
    //   270: getfield 141	com/tencent/component/network/downloader/impl/DownloadTask:pDownloadStrategyLib	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib;
    //   273: invokevirtual 1113	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib:getBestStrategy	()Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   276: ifnull +52 -> 328
    //   279: aload_0
    //   280: getfield 141	com/tencent/component/network/downloader/impl/DownloadTask:pDownloadStrategyLib	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib;
    //   283: invokevirtual 1113	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib:getBestStrategy	()Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   286: aload 4
    //   288: putfield 1098	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:result	Lcom/tencent/component/network/downloader/DownloadResult;
    //   291: aload_0
    //   292: getfield 193	com/tencent/component/network/downloader/impl/DownloadTask:mContext	Landroid/content/Context;
    //   295: invokestatic 1103	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   298: aload_0
    //   299: getfield 193	com/tencent/component/network/downloader/impl/DownloadTask:mContext	Landroid/content/Context;
    //   302: aload_0
    //   303: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   306: aload_0
    //   307: getfield 517	com/tencent/component/network/downloader/impl/DownloadTask:mDomain	Ljava/lang/String;
    //   310: aload_0
    //   311: getfield 141	com/tencent/component/network/downloader/impl/DownloadTask:pDownloadStrategyLib	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib;
    //   314: invokevirtual 1113	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib:getBestStrategy	()Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   317: aload 4
    //   319: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   322: invokevirtual 1092	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   325: invokevirtual 1107	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:report	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;Z)V
    //   328: aload 4
    //   330: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   333: invokevirtual 1092	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   336: ifeq +51 -> 387
    //   339: invokestatic 1118	com/tencent/component/network/module/statistics/SpeedStatistics:getInstance	()Lcom/tencent/component/network/module/statistics/SpeedStatistics;
    //   342: aload 4
    //   344: invokevirtual 660	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   347: getfield 916	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   350: aload 4
    //   352: invokevirtual 1122	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   355: getfield 1127	com/tencent/component/network/downloader/DownloadResult$Process:startTime	J
    //   358: aload 4
    //   360: invokevirtual 1122	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   363: getfield 1130	com/tencent/component/network/downloader/DownloadResult$Process:endTime	J
    //   366: invokevirtual 1133	com/tencent/component/network/module/statistics/SpeedStatistics:report	(JJJ)V
    //   369: goto +18 -> 387
    //   372: astore_1
    //   373: goto +21 -> 394
    //   376: astore_1
    //   377: ldc_w 285
    //   380: ldc_w 1135
    //   383: aload_1
    //   384: invokestatic 1138	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   387: aload_0
    //   388: invokestatic 1141	com/tencent/component/network/NetworkManager:unregistNetStatusListener	(Lcom/tencent/component/network/NetworkManager$NetStatusListener;)V
    //   391: aload 4
    //   393: areturn
    //   394: aload_0
    //   395: invokestatic 1141	com/tencent/component/network/NetworkManager:unregistNetStatusListener	(Lcom/tencent/component/network/NetworkManager$NetStatusListener;)V
    //   398: aload_1
    //   399: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	DownloadTask
    //   0	400	1	paramJobContext	ThreadPool.JobContext
    //   19	4	2	bool	boolean
    //   21	104	3	str	String
    //   11	381	4	localDownloadResult	DownloadResult
    //   41	8	5	localDownloadTaskHandler	DownloadTask.DownloadTaskHandler
    // Exception table:
    //   from	to	target	type
    //   147	187	372	finally
    //   187	259	372	finally
    //   262	328	372	finally
    //   328	369	372	finally
    //   377	387	372	finally
    //   147	187	376	java/lang/Throwable
    //   187	259	376	java/lang/Throwable
    //   262	328	376	java/lang/Throwable
    //   328	369	376	java/lang/Throwable
  }
  
  public void setAttemptCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.mAttemptTotalCount = i;
  }
  
  public void setDownloadRequest(DownloadRequest paramDownloadRequest)
  {
    this.downloadRequest = paramDownloadRequest;
  }
  
  public void setHandler(DownloadTask.DownloadTaskHandler paramDownloadTaskHandler, IPStrategy paramIPStrategy1, IPStrategy paramIPStrategy2, PortConfigStrategy paramPortConfigStrategy, ResumeTransfer paramResumeTransfer, ReportHandler paramReportHandler1, ReportHandler paramReportHandler2, Downloader.NetworkFlowStatistics paramNetworkFlowStatistics, FileCacheService paramFileCacheService)
  {
    this.mDownloadTaskHandler = paramDownloadTaskHandler;
    this.pResumeTransfer = paramResumeTransfer;
    this.mReportHandler = paramReportHandler1;
    this.mExternalReportHandler = paramReportHandler2;
    this.mTempFileCache = paramFileCacheService;
    this.mNetworkFlowStatistics = paramNetworkFlowStatistics;
    this.pDirectIPConfigStrategy = paramIPStrategy1;
    this.pBackupIPConfigStrategy = paramIPStrategy2;
    this.pPortConfigStrategy = paramPortConfigStrategy;
  }
  
  public void setHttpParams(Map<String, String> paramMap)
  {
    this.mHttpParams = paramMap;
  }
  
  public void setNeedMd5()
  {
    this.mNeedMd5 = true;
  }
  
  public void setProgressCallbackStep(float paramFloat)
  {
    this.mProgressCallbackStep = paramFloat;
  }
  
  public void setResponseDataListener(DownloadRequest.OnResponseDataListener paramOnResponseDataListener)
  {
    this.pExtendParam.onResponseDataListener = paramOnResponseDataListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask
 * JD-Core Version:    0.7.0.1
 */