package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadRequest.OnResponseDataListener;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.NetworkFlowStatistics;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.statistics.SpeedStatistics;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
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
  private Map<String, String> mHttpParams;
  protected boolean mIsHttp2;
  private boolean mNeedMd5;
  private Downloader.NetworkFlowStatistics mNetworkFlowStatistics;
  protected boolean mOriginalIsHttp2;
  private PriorityThreadPool.Priority mPriority;
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
    if (!TextUtils.isEmpty(paramString2))
    {
      this.mUrlKey = paramString2;
      this.pokHttpClient = paramOkHttpClient;
      this.pHttpClient = paramQZoneHttpClient;
      if (!paramBoolean1) {
        break label189;
      }
    }
    label189:
    for (paramContext = PriorityThreadPool.Priority.HIGH;; paramContext = PriorityThreadPool.Priority.NORMAL)
    {
      setPriority(paramContext);
      this.mIsHttp2 = paramBoolean2;
      this.mOriginalIsHttp2 = paramBoolean2;
      return;
      paramString2 = paramString1;
      break;
    }
  }
  
  private boolean ensureStorageSpace(String paramString, long paramLong)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new File(paramString);
        if (!DownloadTask.TaskHelper.ensureFile(paramString, true)) {
          continue;
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
        if (i * l > paramLong) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
        return false;
      }
      catch (IOException paramString) {}
    }
  }
  
  private void flushDownloadReport(ThreadPool.JobContext paramJobContext)
  {
    if (this.mReportHandler == null) {}
    ReportHandler.DownloadReportObject localDownloadReportObject;
    do
    {
      do
      {
        return;
      } while (this.reportList.size() <= 0);
      localDownloadReportObject = (ReportHandler.DownloadReportObject)this.reportList.get(this.reportList.size() - 1);
    } while ((localDownloadReportObject == null) || (((!this.mShouldReport) || (paramJobContext.isCancelled())) && ((localDownloadReportObject.retCode != 0) || (this.mReportHandler == null))));
    this.mReportHandler.uploadReport(localDownloadReportObject);
  }
  
  private String generateStorageName()
  {
    if (this.mDownloadTaskHandler != null) {}
    for (String str1 = this.mDownloadTaskHandler.generateStorageFileName(this.mUrl);; str1 = null)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (!TextUtils.isEmpty(this.mUrl)) {
          break;
        }
        str2 = UUID.randomUUID().toString();
      }
      return str2;
    }
    return String.valueOf(this.mUrl.hashCode());
  }
  
  private String generateStoragePath(String paramString)
  {
    return this.mTempFileCache.getPath(paramString);
  }
  
  private String generateStoragePath(String paramString, boolean paramBoolean)
  {
    return this.mTempFileCache.getPath(paramString, paramBoolean);
  }
  
  public static int getCurrTotalTaskCount()
  {
    return mTotalTaskCount;
  }
  
  private boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if (this.mDownloadTaskHandler == null) {
      return true;
    }
    return this.mDownloadTaskHandler.handleContentType(paramDownloadResult, paramHttpResponse, paramResponse);
  }
  
  private boolean isXiaoMi()
  {
    String str1 = Build.BRAND;
    String str2 = Build.MODEL;
    QDLog.i("downloader", "brand:" + str1 + " model:" + str2);
    return (str2 != null) && (str2.startsWith("MI"));
  }
  
  private void notifyDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.mDownloadTaskHandler == null) {
      return;
    }
    this.mDownloadTaskHandler.handleDownloadProgress(paramString, paramLong, paramFloat);
  }
  
  private void notifyStreamDownloadProgress(String paramString1, String paramString2)
  {
    if (this.mDownloadTaskHandler == null) {
      return;
    }
    this.mDownloadTaskHandler.handleStreamDownloadProgress(paramString1, paramString2);
  }
  
  private void processReport(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult)
  {
    if (paramDownloadResult.getStatus().isFailed()) {
      if (paramDownloadResult.getStatus().getFailException() != null)
      {
        paramDownloadResult = Log.getStackTraceString(paramDownloadResult.getStatus().getFailException());
        if ((paramDownloadResult == null) || (!paramDownloadResult.contains("refused"))) {}
      }
      else
      {
        do
        {
          return;
          if ((paramDownloadResult.getStatus().getFailException() == null) || (!(paramDownloadResult.getStatus().getFailException() instanceof SocketException))) {
            break;
          }
          paramDownloadResult = Log.getStackTraceString(paramDownloadResult.getStatus().getFailException());
        } while ((paramDownloadResult != null) && (paramDownloadResult.contains("Permission denied")) && (isXiaoMi()));
      }
    }
    for (;;)
    {
      flushDownloadReport(paramJobContext);
      return;
      if (404 == paramDownloadResult.getStatus().httpStatus)
      {
        paramDownloadResult = (Integer)map404Urls.get(this.mUrl);
        if (paramDownloadResult != null) {
          break;
        }
        map404Urls.put(this.mUrl, Integer.valueOf(1));
        QDLog.i("downloader", "save 404 url at first time.");
      }
    }
    map404Urls.put(this.mUrl, Integer.valueOf(paramDownloadResult.intValue() + 1));
    QDLog.i("downloader", "save 404 url " + (paramDownloadResult.intValue() + 1));
  }
  
  private void setPriority(PriorityThreadPool.Priority paramPriority)
  {
    this.mPriority = paramPriority;
  }
  
  public void abort()
  {
    if (QDLog.isInfoEnable()) {
      QDLog.i("downloader", "downloader abort:" + this.mUrl);
    }
    this.mShouldReport = false;
    if (this.request != null) {}
    while (this.okRequestCall == null) {
      try
      {
        this.request.abort();
        return;
      }
      catch (Exception localException1)
      {
        QDLog.w("downloader", "downloader abort Exception", localException1);
        return;
      }
    }
    try
    {
      this.okRequestCall.cancel();
      return;
    }
    catch (Exception localException2)
    {
      QDLog.w("downloader", "downloader abort Exception", localException2);
    }
  }
  
  protected void applyKeepAliveStrategy(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, HttpUtil.RequestOptions paramRequestOptions)
  {
    if (this.mDownloadTaskHandler == null) {
      return;
    }
    this.mDownloadTaskHandler.handleKeepAliveStrategy(paramString1, paramString2, paramHttpRequest, paramBuilder, paramRequestOptions);
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
    //   1: getfield 200	com/tencent/component/network/downloader/impl/DownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   11: getstatic 122	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   14: lsub
    //   15: lstore_1
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: iflt +11 -> 30
    //   22: lload_1
    //   23: ldc2_w 468
    //   26: lcmp
    //   27: iflt -20 -> 7
    //   30: getstatic 114	com/tencent/component/network/downloader/impl/DownloadTask:ConnectionCleanLock	Ljava/lang/Object;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   39: getstatic 122	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   42: lsub
    //   43: lstore_1
    //   44: lload_1
    //   45: lconst_0
    //   46: lcmp
    //   47: iflt +21 -> 68
    //   50: lload_1
    //   51: ldc2_w 468
    //   54: lcmp
    //   55: ifge +13 -> 68
    //   58: aload_3
    //   59: monitorexit
    //   60: return
    //   61: astore 4
    //   63: aload_3
    //   64: monitorexit
    //   65: aload 4
    //   67: athrow
    //   68: aload_0
    //   69: getfield 200	com/tencent/component/network/downloader/impl/DownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   72: invokevirtual 475	com/tencent/component/network/utils/http/base/QZoneHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +49 -> 128
    //   82: aload 4
    //   84: instanceof 477
    //   87: ifeq +41 -> 128
    //   90: aload 4
    //   92: checkcast 477	com/tencent/component/network/utils/http/PoolingClientConnectionManager
    //   95: astore 4
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 480	com/tencent/component/network/utils/http/PoolingClientConnectionManager:closeExpiredConnections	()V
    //   107: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   110: putstatic 122	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   113: invokestatic 483	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   116: ifeq +12 -> 128
    //   119: ldc_w 342
    //   122: ldc_w 485
    //   125: invokestatic 488	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_3
    //   129: monitorexit
    //   130: return
    //   131: astore 4
    //   133: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   136: putstatic 122	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   139: invokestatic 483	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   142: ifeq -14 -> 128
    //   145: ldc_w 342
    //   148: ldc_w 485
    //   151: invokestatic 488	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -26 -> 128
    //   157: astore 4
    //   159: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   162: putstatic 122	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   165: invokestatic 483	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   168: ifeq +12 -> 180
    //   171: ldc_w 342
    //   174: ldc_w 485
    //   177: invokestatic 488	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload 4
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	DownloadTask
    //   15	36	1	l	long
    //   33	96	3	localObject1	Object
    //   61	5	4	localObject2	Object
    //   75	28	4	localObject3	Object
    //   131	1	4	localException	Exception
    //   157	24	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	61	finally
    //   58	60	61	finally
    //   63	65	61	finally
    //   68	77	61	finally
    //   82	97	61	finally
    //   107	128	61	finally
    //   128	130	61	finally
    //   133	154	61	finally
    //   159	180	61	finally
    //   180	183	61	finally
    //   102	107	131	java/lang/Exception
    //   102	107	157	finally
  }
  
  protected boolean enableIpv6Debug()
  {
    try
    {
      boolean bool = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent", "ipv6_debug.config").exists();
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
  
  public abstract void execute(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult);
  
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
    try
    {
      i = (int)Long.parseLong(paramHttpResponse.getFirstHeader("Retcode").getValue());
    }
    catch (Exception paramHttpResponse)
    {
      long l;
      i = 0;
    }
    if (paramResponse != null)
    {
      paramHttpResponse = paramResponse.headers("Retcode");
      if ((paramHttpResponse != null) && (paramHttpResponse.size() > 0))
      {
        l = Long.parseLong((String)paramHttpResponse.get(0));
        return (int)l;
      }
    }
    int i = 0;
    return i;
  }
  
  protected int getRetryFlag(HttpResponse paramHttpResponse, Response paramResponse)
  {
    if (paramHttpResponse == null) {
      return -1;
    }
    if (paramHttpResponse != null) {}
    try
    {
      i = (int)Long.parseLong(paramHttpResponse.getFirstHeader("X-RtFlag").getValue());
    }
    catch (Exception paramHttpResponse)
    {
      long l;
      i = -1;
    }
    if (paramResponse != null)
    {
      paramHttpResponse = paramResponse.headers("X-RtFlag");
      if ((paramHttpResponse != null) && (paramHttpResponse.size() > 0))
      {
        l = Long.parseLong((String)paramHttpResponse.get(0));
        return (int)l;
      }
    }
    int i = -1;
    return i;
  }
  
  protected int getTaskConcurrentCount()
  {
    if (this.mDownloadTaskHandler != null)
    {
      if (this.mOriginalIsHttp2) {
        return this.mDownloadTaskHandler.getHttp2TaskConcurrentCount();
      }
      return this.mDownloadTaskHandler.getHttpTaskConcurrentCount();
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
    try
    {
      i = (int)Long.parseLong(paramHttpResponse.getFirstHeader("X-ErrNo").getValue());
    }
    catch (Exception paramHttpResponse)
    {
      long l;
      i = 0;
    }
    if (paramResponse != null)
    {
      paramHttpResponse = paramResponse.headers("X-ErrNo");
      if ((paramHttpResponse != null) && (paramHttpResponse.size() > 0))
      {
        l = Long.parseLong((String)paramHttpResponse.get(0));
        return (int)l;
      }
    }
    int i = 0;
    return i;
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
    if (paramJobContext.isCancelled()) {}
    int j;
    do
    {
      return;
      if (this.mReportHandler != null)
      {
        paramJobContext = this.mReportHandler.obtainReportObj(paramDownloadResult, paramDownloadReport);
        this.reportList.add(paramJobContext);
      }
      j = 0;
    } while ((paramDownloadReport.isSucceed) || (paramDownloadReport.exception == null) || (paramDownloadResult == null));
    int i;
    if (paramDownloadReport.isFromQzoneAlbum) {
      if (this.mOriginalIsHttp2) {
        i = 1;
      }
    }
    for (;;)
    {
      Config.reportToLp(i, paramDownloadReport.isHttp2, paramDownloadReport.url, paramDownloadResult.getStatus().exception2Code, Log.getStackTraceString(paramDownloadReport.exception));
      return;
      i = 2;
      continue;
      i = j;
      if (paramDownloadReport.url != null)
      {
        i = j;
        if (paramDownloadReport.url.startsWith("https://")) {
          i = 3;
        }
      }
    }
  }
  
  /* Error */
  protected boolean handleHeader(HttpResponse paramHttpResponse, Response paramResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +296 -> 297
    //   4: aload_1
    //   5: invokeinterface 620 1 0
    //   10: astore 10
    //   12: aload_2
    //   13: ifnull +290 -> 303
    //   16: aload_2
    //   17: invokevirtual 624	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   20: astore 9
    //   22: aload 10
    //   24: ifnull +285 -> 309
    //   27: aload 10
    //   29: invokeinterface 628 1 0
    //   34: lstore 7
    //   36: aload_0
    //   37: lload 7
    //   39: putfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   42: aload_3
    //   43: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   46: aload_0
    //   47: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   50: putfield 637	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   53: aconst_null
    //   54: astore 12
    //   56: aconst_null
    //   57: astore 11
    //   59: aload 10
    //   61: ifnull +263 -> 324
    //   64: aload 10
    //   66: invokeinterface 641 1 0
    //   71: astore 11
    //   73: aload 12
    //   75: astore 9
    //   77: aload 11
    //   79: ifnull +12 -> 91
    //   82: aload 11
    //   84: invokeinterface 538 1 0
    //   89: astore 9
    //   91: aload 10
    //   93: invokeinterface 644 1 0
    //   98: astore 10
    //   100: aload 10
    //   102: ifnull +799 -> 901
    //   105: aload 10
    //   107: invokeinterface 538 1 0
    //   112: astore 10
    //   114: goto +790 -> 904
    //   117: aload 9
    //   119: ifnull +12 -> 131
    //   122: aload_3
    //   123: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   126: aload 9
    //   128: putfield 647	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   131: aload 10
    //   133: ifnull +12 -> 145
    //   136: aload_3
    //   137: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   140: aload 10
    //   142: putfield 650	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   145: aload_1
    //   146: ifnull +291 -> 437
    //   149: aload_1
    //   150: invokeinterface 654 1 0
    //   155: astore 9
    //   157: aload 9
    //   159: ifnull +54 -> 213
    //   162: aload 9
    //   164: arraylength
    //   165: istore 6
    //   167: iconst_0
    //   168: istore 5
    //   170: iload 5
    //   172: iload 6
    //   174: if_icmpge +39 -> 213
    //   177: ldc_w 656
    //   180: aload 9
    //   182: iload 5
    //   184: aaload
    //   185: invokeinterface 657 1 0
    //   190: invokevirtual 660	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   193: ifeq +205 -> 398
    //   196: aload_3
    //   197: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   200: aload 9
    //   202: iload 5
    //   204: aaload
    //   205: invokeinterface 538 1 0
    //   210: putfield 663	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   213: aload_1
    //   214: ldc_w 665
    //   217: invokeinterface 533 2 0
    //   222: astore 9
    //   224: aload 9
    //   226: ifnull +181 -> 407
    //   229: aload_0
    //   230: aload 9
    //   232: invokeinterface 538 1 0
    //   237: invokestatic 669	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   240: i2l
    //   241: putfield 136	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   244: aload_3
    //   245: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   248: aload_0
    //   249: getfield 136	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   252: putfield 672	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   255: aload_1
    //   256: ldc_w 674
    //   259: invokeinterface 533 2 0
    //   264: astore 9
    //   266: aload 9
    //   268: ifnull +17 -> 285
    //   271: aload_3
    //   272: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   275: aload 9
    //   277: invokeinterface 538 1 0
    //   282: putfield 677	com/tencent/component/network/downloader/DownloadResult$Content:lastModified	Ljava/lang/String;
    //   285: aload 4
    //   287: invokeinterface 283 1 0
    //   292: ifeq +346 -> 638
    //   295: iconst_0
    //   296: ireturn
    //   297: aconst_null
    //   298: astore 10
    //   300: goto -288 -> 12
    //   303: aconst_null
    //   304: astore 9
    //   306: goto -284 -> 22
    //   309: aload 9
    //   311: ifnull +596 -> 907
    //   314: aload 9
    //   316: invokevirtual 682	okhttp3/ResponseBody:contentLength	()J
    //   319: lstore 7
    //   321: goto -285 -> 36
    //   324: aload 9
    //   326: ifnull +565 -> 891
    //   329: aload 9
    //   331: invokevirtual 686	okhttp3/ResponseBody:contentType	()Lokhttp3/MediaType;
    //   334: astore 9
    //   336: aload 9
    //   338: ifnull +553 -> 891
    //   341: aload 9
    //   343: invokevirtual 689	okhttp3/MediaType:toString	()Ljava/lang/String;
    //   346: astore 12
    //   348: aload 9
    //   350: invokevirtual 693	okhttp3/MediaType:charset	()Ljava/nio/charset/Charset;
    //   353: astore 13
    //   355: aload 12
    //   357: astore 9
    //   359: aload 11
    //   361: astore 10
    //   363: aload 13
    //   365: ifnull -248 -> 117
    //   368: aload_3
    //   369: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   372: aload 13
    //   374: invokevirtual 698	java/nio/charset/Charset:name	()Ljava/lang/String;
    //   377: putfield 650	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   380: aload 12
    //   382: astore 9
    //   384: aload 11
    //   386: astore 10
    //   388: goto -271 -> 117
    //   391: astore_1
    //   392: aload_1
    //   393: invokevirtual 701	java/lang/Throwable:printStackTrace	()V
    //   396: iconst_0
    //   397: ireturn
    //   398: iload 5
    //   400: iconst_1
    //   401: iadd
    //   402: istore 5
    //   404: goto -234 -> 170
    //   407: aload_0
    //   408: ldc2_w 133
    //   411: putfield 136	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   414: aload_3
    //   415: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   418: ldc2_w 133
    //   421: putfield 672	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   424: goto -169 -> 255
    //   427: astore 9
    //   429: aload 9
    //   431: invokevirtual 702	java/lang/Exception:printStackTrace	()V
    //   434: goto -149 -> 285
    //   437: aload_2
    //   438: ifnull -153 -> 285
    //   441: aload_2
    //   442: invokevirtual 705	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   445: astore 9
    //   447: aload 9
    //   449: ifnull +50 -> 499
    //   452: aload 9
    //   454: invokevirtual 708	okhttp3/Headers:size	()I
    //   457: istore 6
    //   459: iconst_0
    //   460: istore 5
    //   462: iload 5
    //   464: iload 6
    //   466: if_icmpge +33 -> 499
    //   469: ldc_w 656
    //   472: aload 9
    //   474: iload 5
    //   476: invokevirtual 710	okhttp3/Headers:name	(I)Ljava/lang/String;
    //   479: invokevirtual 660	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   482: ifeq +127 -> 609
    //   485: aload_3
    //   486: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   489: aload 9
    //   491: iload 5
    //   493: invokevirtual 713	okhttp3/Headers:value	(I)Ljava/lang/String;
    //   496: putfield 663	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   499: aload_2
    //   500: ldc_w 665
    //   503: invokevirtual 716	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   506: astore 9
    //   508: aload 9
    //   510: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   513: ifne +105 -> 618
    //   516: aload_0
    //   517: aload 9
    //   519: invokestatic 669	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   522: i2l
    //   523: putfield 136	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   526: aload_3
    //   527: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   530: aload_0
    //   531: getfield 136	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   534: putfield 672	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   537: aload_2
    //   538: ldc_w 674
    //   541: invokevirtual 550	okhttp3/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   544: astore 9
    //   546: aload 9
    //   548: ifnull -263 -> 285
    //   551: aload 9
    //   553: invokeinterface 272 1 0
    //   558: ifle -273 -> 285
    //   561: aload 9
    //   563: iconst_0
    //   564: invokeinterface 276 2 0
    //   569: checkcast 718	java/lang/CharSequence
    //   572: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: ifne -290 -> 285
    //   578: aload_3
    //   579: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   582: aload 9
    //   584: iconst_0
    //   585: invokeinterface 276 2 0
    //   590: checkcast 312	java/lang/String
    //   593: putfield 677	com/tencent/component/network/downloader/DownloadResult$Content:lastModified	Ljava/lang/String;
    //   596: goto -311 -> 285
    //   599: astore 9
    //   601: aload 9
    //   603: invokevirtual 702	java/lang/Exception:printStackTrace	()V
    //   606: goto -321 -> 285
    //   609: iload 5
    //   611: iconst_1
    //   612: iadd
    //   613: istore 5
    //   615: goto -153 -> 462
    //   618: aload_0
    //   619: ldc2_w 133
    //   622: putfield 136	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   625: aload_3
    //   626: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   629: ldc2_w 133
    //   632: putfield 672	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   635: goto -98 -> 537
    //   638: aload_3
    //   639: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   642: iconst_0
    //   643: putfield 721	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   646: aload_1
    //   647: ifnull +79 -> 726
    //   650: aload_1
    //   651: ldc_w 723
    //   654: invokeinterface 727 2 0
    //   659: astore 9
    //   661: aload 9
    //   663: ifnull +51 -> 714
    //   666: aload 9
    //   668: invokeinterface 732 1 0
    //   673: ifeq +41 -> 714
    //   676: aload 9
    //   678: invokeinterface 735 1 0
    //   683: astore 10
    //   685: aload 10
    //   687: ifnull -21 -> 666
    //   690: ldc_w 737
    //   693: aload 10
    //   695: invokeinterface 538 1 0
    //   700: invokevirtual 660	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   703: ifeq -37 -> 666
    //   706: aload_3
    //   707: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   710: iconst_1
    //   711: putfield 721	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   714: aload 4
    //   716: invokeinterface 283 1 0
    //   721: ifeq +84 -> 805
    //   724: iconst_0
    //   725: ireturn
    //   726: aload_2
    //   727: ifnull -13 -> 714
    //   730: aload_2
    //   731: ldc_w 723
    //   734: invokevirtual 550	okhttp3/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   737: astore 9
    //   739: aload 9
    //   741: ifnull -27 -> 714
    //   744: aload 9
    //   746: invokeinterface 741 1 0
    //   751: astore 9
    //   753: aload 9
    //   755: invokeinterface 744 1 0
    //   760: ifeq -46 -> 714
    //   763: aload 9
    //   765: invokeinterface 748 1 0
    //   770: checkcast 312	java/lang/String
    //   773: astore 10
    //   775: aload 10
    //   777: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   780: ifeq -27 -> 753
    //   783: ldc_w 737
    //   786: aload 10
    //   788: invokevirtual 660	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   791: ifeq -38 -> 753
    //   794: aload_3
    //   795: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   798: iconst_1
    //   799: putfield 721	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   802: goto -88 -> 714
    //   805: aload_0
    //   806: aload_3
    //   807: aload_1
    //   808: aload_2
    //   809: invokespecial 749	com/tencent/component/network/downloader/impl/DownloadTask:handleContentType	(Lcom/tencent/component/network/downloader/DownloadResult;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Z
    //   812: ifne +13 -> 825
    //   815: aload_3
    //   816: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   819: iconst_5
    //   820: invokevirtual 753	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   823: iconst_0
    //   824: ireturn
    //   825: aload_0
    //   826: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   829: ifnull +50 -> 879
    //   832: aload_0
    //   833: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   836: aload_0
    //   837: getfield 188	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   840: aload_0
    //   841: getfield 515	com/tencent/component/network/downloader/impl/DownloadTask:mDomain	Ljava/lang/String;
    //   844: aload_1
    //   845: aload_2
    //   846: invokeinterface 761 5 0
    //   851: ifne +28 -> 879
    //   854: ldc_w 342
    //   857: ldc_w 763
    //   860: invokestatic 765	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   863: aload_0
    //   864: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   867: aload_0
    //   868: getfield 188	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   871: iconst_1
    //   872: invokeinterface 769 3 0
    //   877: iconst_0
    //   878: ireturn
    //   879: iconst_1
    //   880: ireturn
    //   881: astore 9
    //   883: goto -346 -> 537
    //   886: astore 9
    //   888: goto -633 -> 255
    //   891: aconst_null
    //   892: astore 9
    //   894: aload 11
    //   896: astore 10
    //   898: goto -781 -> 117
    //   901: aconst_null
    //   902: astore 10
    //   904: goto -787 -> 117
    //   907: lconst_0
    //   908: lstore 7
    //   910: goto -874 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	913	0	this	DownloadTask
    //   0	913	1	paramHttpResponse	HttpResponse
    //   0	913	2	paramResponse	Response
    //   0	913	3	paramDownloadResult	DownloadResult
    //   0	913	4	paramJobContext	ThreadPool.JobContext
    //   168	446	5	i	int
    //   165	302	6	j	int
    //   34	875	7	l	long
    //   20	363	9	localObject1	Object
    //   427	3	9	localException1	Exception
    //   445	138	9	localObject2	Object
    //   599	3	9	localException2	Exception
    //   659	105	9	localObject3	Object
    //   881	1	9	localThrowable1	Throwable
    //   886	1	9	localThrowable2	Throwable
    //   892	1	9	localObject4	Object
    //   10	893	10	localObject5	Object
    //   57	838	11	localHeader	Header
    //   54	327	12	str	String
    //   353	20	13	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   27	36	391	java/lang/Throwable
    //   36	53	391	java/lang/Throwable
    //   64	73	391	java/lang/Throwable
    //   82	91	391	java/lang/Throwable
    //   91	100	391	java/lang/Throwable
    //   105	114	391	java/lang/Throwable
    //   122	131	391	java/lang/Throwable
    //   136	145	391	java/lang/Throwable
    //   314	321	391	java/lang/Throwable
    //   329	336	391	java/lang/Throwable
    //   341	355	391	java/lang/Throwable
    //   368	380	391	java/lang/Throwable
    //   271	285	427	java/lang/Exception
    //   551	596	599	java/lang/Exception
    //   516	537	881	java/lang/Throwable
    //   229	255	886	java/lang/Throwable
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
    //   6: invokevirtual 772	com/tencent/component/network/downloader/impl/DownloadTask:handleHeader	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;)Z
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   17: lstore 17
    //   19: iload 5
    //   21: sipush 206
    //   24: if_icmpne +231 -> 255
    //   27: aload_0
    //   28: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   31: ifnull +213 -> 244
    //   34: aload_0
    //   35: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   38: aload_0
    //   39: getfield 188	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   42: invokeinterface 775 2 0
    //   47: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +194 -> 244
    //   53: aload_3
    //   54: aload_0
    //   55: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   58: aload_0
    //   59: getfield 188	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   62: invokeinterface 775 2 0
    //   67: invokevirtual 778	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   70: iconst_1
    //   71: istore 24
    //   73: aconst_null
    //   74: astore 26
    //   76: getstatic 100	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   79: invokevirtual 781	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   82: astore 27
    //   84: lconst_0
    //   85: lstore 9
    //   87: aload_0
    //   88: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   91: lstore 21
    //   93: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   96: lstore 11
    //   98: iconst_0
    //   99: istore 25
    //   101: new 222	java/io/File
    //   104: dup
    //   105: aload_3
    //   106: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   109: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   112: astore 28
    //   114: aload 28
    //   116: iconst_0
    //   117: invokestatic 231	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:ensureFile	(Ljava/io/File;Z)Z
    //   120: pop
    //   121: aload 4
    //   123: invokeinterface 283 1 0
    //   128: istore 23
    //   130: iload 23
    //   132: ifeq +289 -> 421
    //   135: aload_0
    //   136: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   139: lload 17
    //   141: lsub
    //   142: putfield 166	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   145: iconst_0
    //   146: ifeq +11 -> 157
    //   149: new 785	java/lang/NullPointerException
    //   152: dup
    //   153: invokespecial 786	java/lang/NullPointerException:<init>	()V
    //   156: athrow
    //   157: iconst_0
    //   158: ifeq +11 -> 169
    //   161: new 785	java/lang/NullPointerException
    //   164: dup
    //   165: invokespecial 786	java/lang/NullPointerException:<init>	()V
    //   168: athrow
    //   169: getstatic 100	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   172: aload 27
    //   174: invokevirtual 790	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   177: aload_0
    //   178: getfield 792	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   181: ifnull +22 -> 203
    //   184: aload_0
    //   185: getfield 792	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   188: invokestatic 797	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   191: lconst_0
    //   192: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   195: lload 11
    //   197: lsub
    //   198: invokeinterface 803 6 0
    //   203: ldc_w 342
    //   206: new 344	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 345	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 805
    //   216: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   223: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   226: ldc_w 810
    //   229: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: lconst_0
    //   233: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   236: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 360	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: iconst_0
    //   243: ireturn
    //   244: ldc_w 342
    //   247: ldc_w 812
    //   250: invokestatic 765	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: iconst_0
    //   254: ireturn
    //   255: aload_0
    //   256: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   259: ifnull +44 -> 303
    //   262: aload_0
    //   263: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   266: aload_0
    //   267: getfield 188	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   270: invokeinterface 775 2 0
    //   275: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   278: ifne +25 -> 303
    //   281: iload 5
    //   283: sipush 200
    //   286: if_icmpne +17 -> 303
    //   289: aload_0
    //   290: getfield 755	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   293: aload_0
    //   294: getfield 188	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   297: iconst_1
    //   298: invokeinterface 769 3 0
    //   303: aload_0
    //   304: invokespecial 814	com/tencent/component/network/downloader/impl/DownloadTask:generateStorageName	()Ljava/lang/String;
    //   307: astore 27
    //   309: aload_0
    //   310: aload 27
    //   312: invokespecial 816	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;)Ljava/lang/String;
    //   315: astore 26
    //   317: aload_0
    //   318: aload 27
    //   320: iconst_0
    //   321: invokespecial 818	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   324: astore 27
    //   326: aload_0
    //   327: aload 26
    //   329: aload_0
    //   330: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   333: invokespecial 820	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   336: ifeq +15 -> 351
    //   339: aload_3
    //   340: aload 26
    //   342: invokevirtual 778	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   345: iconst_0
    //   346: istore 24
    //   348: goto -275 -> 73
    //   351: aload 26
    //   353: aload 27
    //   355: invokestatic 824	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   358: ifne +25 -> 383
    //   361: aload_0
    //   362: aload 27
    //   364: aload_0
    //   365: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   368: invokespecial 820	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   371: ifeq +12 -> 383
    //   374: aload_3
    //   375: aload 27
    //   377: invokevirtual 778	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   380: goto -35 -> 345
    //   383: aload_3
    //   384: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   387: iconst_2
    //   388: invokevirtual 753	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   391: iconst_0
    //   392: ireturn
    //   393: astore_1
    //   394: ldc_w 342
    //   397: ldc_w 826
    //   400: aload_1
    //   401: invokestatic 455	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   404: goto -247 -> 157
    //   407: astore_1
    //   408: ldc_w 342
    //   411: ldc_w 826
    //   414: aload_1
    //   415: invokestatic 455	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   418: goto -249 -> 169
    //   421: aload_0
    //   422: getfield 828	com/tencent/component/network/downloader/impl/DownloadTask:mNeedMd5	Z
    //   425: ifeq +1283 -> 1708
    //   428: aload_1
    //   429: ldc_w 830
    //   432: invokeinterface 533 2 0
    //   437: ifnull +13 -> 450
    //   440: aload_2
    //   441: ldc_w 830
    //   444: invokevirtual 550	okhttp3/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   447: ifnonnull +1261 -> 1708
    //   450: ldc_w 832
    //   453: invokestatic 838	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   456: astore 4
    //   458: aload_1
    //   459: ifnull +391 -> 850
    //   462: aload_1
    //   463: invokeinterface 620 1 0
    //   468: ifnull +382 -> 850
    //   471: aload_1
    //   472: invokeinterface 620 1 0
    //   477: invokeinterface 644 1 0
    //   482: ifnull +350 -> 832
    //   485: aload_1
    //   486: invokeinterface 620 1 0
    //   491: invokeinterface 644 1 0
    //   496: invokeinterface 538 1 0
    //   501: ifnull +331 -> 832
    //   504: aload_1
    //   505: invokeinterface 620 1 0
    //   510: invokeinterface 644 1 0
    //   515: invokeinterface 538 1 0
    //   520: invokevirtual 841	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   523: ldc_w 843
    //   526: invokevirtual 846	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   529: iconst_m1
    //   530: if_icmple +302 -> 832
    //   533: new 848	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   536: dup
    //   537: aload_1
    //   538: invokeinterface 620 1 0
    //   543: invokeinterface 851 1 0
    //   548: invokespecial 854	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   551: astore_1
    //   552: iconst_1
    //   553: istore 23
    //   555: new 856	java/io/FileOutputStream
    //   558: dup
    //   559: aload 28
    //   561: iload 24
    //   563: invokespecial 859	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   566: astore_2
    //   567: aload 28
    //   569: invokevirtual 861	java/io/File:length	()J
    //   572: lstore 19
    //   574: lconst_0
    //   575: lstore 9
    //   577: lconst_0
    //   578: lstore 13
    //   580: iconst_0
    //   581: istore 5
    //   583: lload 11
    //   585: lstore 7
    //   587: lload 13
    //   589: lstore 11
    //   591: lload 9
    //   593: lstore 13
    //   595: aload_1
    //   596: aload 27
    //   598: getfield 867	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   601: iload 5
    //   603: sipush 8192
    //   606: iload 5
    //   608: isub
    //   609: invokevirtual 873	java/io/InputStream:read	([BII)I
    //   612: istore 6
    //   614: iload 6
    //   616: ifle +333 -> 949
    //   619: iload 6
    //   621: iload 5
    //   623: iadd
    //   624: sipush 8192
    //   627: if_icmpne +312 -> 939
    //   630: lload 9
    //   632: lstore 13
    //   634: aload_2
    //   635: aload 27
    //   637: getfield 867	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   640: iconst_0
    //   641: iload 6
    //   643: iload 5
    //   645: iadd
    //   646: invokevirtual 879	java/io/OutputStream:write	([BII)V
    //   649: lload 9
    //   651: lstore 13
    //   653: aload_0
    //   654: aload_0
    //   655: getfield 196	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   658: aload 28
    //   660: invokevirtual 880	java/io/File:getPath	()Ljava/lang/String;
    //   663: invokespecial 882	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   666: aload 4
    //   668: ifnull +23 -> 691
    //   671: lload 9
    //   673: lstore 13
    //   675: aload 4
    //   677: aload 27
    //   679: getfield 867	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   682: iconst_0
    //   683: iload 6
    //   685: iload 5
    //   687: iadd
    //   688: invokevirtual 885	java/security/MessageDigest:update	([BII)V
    //   691: lload 9
    //   693: lstore 13
    //   695: aload_0
    //   696: getfield 164	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   699: getfield 889	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   702: ifnull +39 -> 741
    //   705: lload 9
    //   707: lstore 13
    //   709: aload_0
    //   710: getfield 164	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   713: getfield 889	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   716: aload 27
    //   718: getfield 867	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   721: iconst_0
    //   722: iload 5
    //   724: iload 6
    //   726: iadd
    //   727: aload_0
    //   728: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   731: lload 19
    //   733: l2i
    //   734: iload 23
    //   736: invokeinterface 895 8 0
    //   741: iload 6
    //   743: iconst_0
    //   744: iadd
    //   745: i2l
    //   746: lload 9
    //   748: ladd
    //   749: lstore 9
    //   751: iconst_0
    //   752: istore 5
    //   754: lload 11
    //   756: iload 6
    //   758: i2l
    //   759: ladd
    //   760: lstore 11
    //   762: aload_3
    //   763: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   766: lload 11
    //   768: putfield 897	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   771: lload 21
    //   773: lconst_0
    //   774: lcmp
    //   775: ifle +45 -> 820
    //   778: aload_1
    //   779: instanceof 848
    //   782: ifeq +919 -> 1701
    //   785: aload_1
    //   786: checkcast 848	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   789: invokevirtual 900	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:getRealReadLen	()J
    //   792: lstore 13
    //   794: aload_0
    //   795: aload_0
    //   796: getfield 196	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   799: lload 21
    //   801: lload 19
    //   803: ladd
    //   804: lload 13
    //   806: lload 19
    //   808: ladd
    //   809: l2f
    //   810: lload 21
    //   812: lload 19
    //   814: ladd
    //   815: l2f
    //   816: fdiv
    //   817: invokespecial 902	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   820: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   823: lstore 13
    //   825: lload 13
    //   827: lstore 7
    //   829: goto -238 -> 591
    //   832: aload_1
    //   833: invokeinterface 620 1 0
    //   838: invokeinterface 851 1 0
    //   843: astore_1
    //   844: iconst_0
    //   845: istore 23
    //   847: goto -292 -> 555
    //   850: iload 25
    //   852: istore 23
    //   854: aload 26
    //   856: astore_1
    //   857: aload_2
    //   858: ifnull -303 -> 555
    //   861: iload 25
    //   863: istore 23
    //   865: aload 26
    //   867: astore_1
    //   868: aload_2
    //   869: invokevirtual 624	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   872: ifnull -317 -> 555
    //   875: aload_2
    //   876: ldc_w 904
    //   879: invokevirtual 716	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   882: astore_1
    //   883: aload_1
    //   884: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   887: ifne +38 -> 925
    //   890: aload_1
    //   891: invokevirtual 841	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   894: ldc_w 843
    //   897: invokevirtual 846	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   900: iconst_m1
    //   901: if_icmple +24 -> 925
    //   904: new 848	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   907: dup
    //   908: aload_2
    //   909: invokevirtual 624	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   912: invokevirtual 907	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   915: invokespecial 854	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   918: astore_1
    //   919: iconst_1
    //   920: istore 23
    //   922: goto -367 -> 555
    //   925: aload_2
    //   926: invokevirtual 624	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   929: invokevirtual 907	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   932: astore_1
    //   933: iconst_0
    //   934: istore 23
    //   936: goto -381 -> 555
    //   939: iload 5
    //   941: iload 6
    //   943: iadd
    //   944: istore 5
    //   946: goto -192 -> 754
    //   949: lload 9
    //   951: lstore 15
    //   953: iload 6
    //   955: ifgt +122 -> 1077
    //   958: lload 9
    //   960: lstore 15
    //   962: iload 5
    //   964: ifle +113 -> 1077
    //   967: lload 9
    //   969: lstore 13
    //   971: aload_2
    //   972: aload 27
    //   974: getfield 867	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   977: iconst_0
    //   978: iload 5
    //   980: invokevirtual 879	java/io/OutputStream:write	([BII)V
    //   983: lload 9
    //   985: lstore 13
    //   987: aload_0
    //   988: aload_0
    //   989: getfield 196	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   992: aload 28
    //   994: invokevirtual 880	java/io/File:getPath	()Ljava/lang/String;
    //   997: invokespecial 882	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   1000: lload 9
    //   1002: lstore 13
    //   1004: aload_0
    //   1005: getfield 164	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   1008: getfield 889	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   1011: ifnull +36 -> 1047
    //   1014: lload 9
    //   1016: lstore 13
    //   1018: aload_0
    //   1019: getfield 164	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   1022: getfield 889	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   1025: aload 27
    //   1027: getfield 867	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   1030: iconst_0
    //   1031: iload 5
    //   1033: aload_0
    //   1034: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1037: lload 19
    //   1039: l2i
    //   1040: iload 23
    //   1042: invokeinterface 895 8 0
    //   1047: lload 9
    //   1049: iload 5
    //   1051: i2l
    //   1052: ladd
    //   1053: lstore 9
    //   1055: aload 4
    //   1057: ifnull +16 -> 1073
    //   1060: aload 4
    //   1062: aload 27
    //   1064: getfield 867	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   1067: iconst_0
    //   1068: iload 5
    //   1070: invokevirtual 885	java/security/MessageDigest:update	([BII)V
    //   1073: lload 9
    //   1075: lstore 15
    //   1077: lload 21
    //   1079: lconst_0
    //   1080: lcmp
    //   1081: ifgt +21 -> 1102
    //   1084: lload 15
    //   1086: lstore 13
    //   1088: aload_0
    //   1089: aload_0
    //   1090: getfield 196	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   1093: lload 21
    //   1095: lload 19
    //   1097: ladd
    //   1098: fconst_1
    //   1099: invokespecial 902	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   1102: lload 15
    //   1104: lstore 13
    //   1106: aload_3
    //   1107: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1110: lload 11
    //   1112: putfield 897	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1115: iload 23
    //   1117: ifeq +139 -> 1256
    //   1120: lload 15
    //   1122: lstore 13
    //   1124: new 222	java/io/File
    //   1127: dup
    //   1128: new 344	java/lang/StringBuilder
    //   1131: dup
    //   1132: invokespecial 345	java/lang/StringBuilder:<init>	()V
    //   1135: aload 28
    //   1137: invokevirtual 880	java/io/File:getPath	()Ljava/lang/String;
    //   1140: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: ldc_w 909
    //   1146: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   1155: astore 26
    //   1157: lload 15
    //   1159: lstore 13
    //   1161: aload 28
    //   1163: aload 26
    //   1165: invokestatic 915	com/tencent/component/network/utils/FileUtils:unGzip	(Ljava/io/File;Ljava/io/File;)Z
    //   1168: istore 23
    //   1170: lload 15
    //   1172: lstore 13
    //   1174: ldc_w 342
    //   1177: new 344	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 345	java/lang/StringBuilder:<init>	()V
    //   1184: ldc_w 917
    //   1187: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: iload 23
    //   1192: invokevirtual 920	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1195: ldc_w 922
    //   1198: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: aload 26
    //   1203: invokevirtual 880	java/io/File:getPath	()Ljava/lang/String;
    //   1206: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: ldc_w 924
    //   1212: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: aload 26
    //   1217: invokevirtual 861	java/io/File:length	()J
    //   1220: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1223: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: invokestatic 765	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1229: iload 23
    //   1231: ifeq +25 -> 1256
    //   1234: lload 15
    //   1236: lstore 13
    //   1238: aload 28
    //   1240: invokestatic 928	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   1243: lload 15
    //   1245: lstore 13
    //   1247: aload_3
    //   1248: aload 26
    //   1250: invokevirtual 880	java/io/File:getPath	()Ljava/lang/String;
    //   1253: invokevirtual 778	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   1256: aload_0
    //   1257: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   1260: lload 17
    //   1262: lsub
    //   1263: putfield 166	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   1266: aload_1
    //   1267: ifnull +7 -> 1274
    //   1270: aload_1
    //   1271: invokevirtual 931	java/io/InputStream:close	()V
    //   1274: aload_2
    //   1275: ifnull +7 -> 1282
    //   1278: aload_2
    //   1279: invokevirtual 932	java/io/OutputStream:close	()V
    //   1282: getstatic 100	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1285: aload 27
    //   1287: invokevirtual 790	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1290: aload_0
    //   1291: getfield 792	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1294: ifnull +23 -> 1317
    //   1297: aload_0
    //   1298: getfield 792	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1301: invokestatic 797	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1304: lload 11
    //   1306: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   1309: lload 7
    //   1311: lsub
    //   1312: invokeinterface 803 6 0
    //   1317: aload 4
    //   1319: ifnull +91 -> 1410
    //   1322: aload 4
    //   1324: invokevirtual 936	java/security/MessageDigest:digest	()[B
    //   1327: astore_2
    //   1328: new 344	java/lang/StringBuilder
    //   1331: dup
    //   1332: invokespecial 345	java/lang/StringBuilder:<init>	()V
    //   1335: astore_1
    //   1336: iconst_0
    //   1337: istore 5
    //   1339: iload 5
    //   1341: aload_2
    //   1342: arraylength
    //   1343: if_icmpge +56 -> 1399
    //   1346: aload_1
    //   1347: aload_2
    //   1348: iload 5
    //   1350: baload
    //   1351: sipush 255
    //   1354: iand
    //   1355: invokestatic 939	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1358: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: iload 5
    //   1364: iconst_1
    //   1365: iadd
    //   1366: istore 5
    //   1368: goto -29 -> 1339
    //   1371: astore_1
    //   1372: ldc_w 342
    //   1375: ldc_w 826
    //   1378: aload_1
    //   1379: invokestatic 455	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1382: goto -108 -> 1274
    //   1385: astore_1
    //   1386: ldc_w 342
    //   1389: ldc_w 826
    //   1392: aload_1
    //   1393: invokestatic 455	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1396: goto -114 -> 1282
    //   1399: aload_3
    //   1400: invokevirtual 632	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1403: aload_1
    //   1404: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: putfield 942	com/tencent/component/network/downloader/DownloadResult$Content:md5	Ljava/lang/String;
    //   1410: ldc_w 342
    //   1413: new 344	java/lang/StringBuilder
    //   1416: dup
    //   1417: invokespecial 345	java/lang/StringBuilder:<init>	()V
    //   1420: ldc_w 805
    //   1423: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: aload_0
    //   1427: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1430: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1433: ldc_w 810
    //   1436: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: lload 15
    //   1441: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 360	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1450: iconst_1
    //   1451: ireturn
    //   1452: astore_3
    //   1453: aconst_null
    //   1454: astore_1
    //   1455: aconst_null
    //   1456: astore_2
    //   1457: lconst_0
    //   1458: lstore 7
    //   1460: aload_0
    //   1461: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   1464: lload 17
    //   1466: lsub
    //   1467: putfield 166	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   1470: aload_2
    //   1471: ifnull +7 -> 1478
    //   1474: aload_2
    //   1475: invokevirtual 931	java/io/InputStream:close	()V
    //   1478: aload_1
    //   1479: ifnull +7 -> 1486
    //   1482: aload_1
    //   1483: invokevirtual 932	java/io/OutputStream:close	()V
    //   1486: getstatic 100	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1489: aload 27
    //   1491: invokevirtual 790	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1494: aload_0
    //   1495: getfield 792	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1498: ifnull +23 -> 1521
    //   1501: aload_0
    //   1502: getfield 792	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1505: invokestatic 797	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1508: lload 9
    //   1510: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   1513: lload 11
    //   1515: lsub
    //   1516: invokeinterface 803 6 0
    //   1521: ldc_w 342
    //   1524: new 344	java/lang/StringBuilder
    //   1527: dup
    //   1528: invokespecial 345	java/lang/StringBuilder:<init>	()V
    //   1531: ldc_w 805
    //   1534: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: aload_0
    //   1538: getfield 511	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1541: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1544: ldc_w 810
    //   1547: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: lload 7
    //   1552: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1555: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1558: invokestatic 360	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1561: aload_3
    //   1562: athrow
    //   1563: astore_2
    //   1564: ldc_w 342
    //   1567: ldc_w 826
    //   1570: aload_2
    //   1571: invokestatic 455	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1574: goto -96 -> 1478
    //   1577: astore_1
    //   1578: ldc_w 342
    //   1581: ldc_w 826
    //   1584: aload_1
    //   1585: invokestatic 455	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1588: goto -102 -> 1486
    //   1591: astore_3
    //   1592: aconst_null
    //   1593: astore 4
    //   1595: aload_1
    //   1596: astore_2
    //   1597: lconst_0
    //   1598: lstore 7
    //   1600: aload 4
    //   1602: astore_1
    //   1603: goto -143 -> 1460
    //   1606: astore_3
    //   1607: aload_1
    //   1608: astore 4
    //   1610: aload_2
    //   1611: astore_1
    //   1612: lconst_0
    //   1613: lstore 7
    //   1615: aload 4
    //   1617: astore_2
    //   1618: goto -158 -> 1460
    //   1621: astore_3
    //   1622: lload 11
    //   1624: lstore 9
    //   1626: aload_1
    //   1627: astore 4
    //   1629: aload_2
    //   1630: astore_1
    //   1631: aload 4
    //   1633: astore_2
    //   1634: lload 7
    //   1636: lstore 11
    //   1638: lload 13
    //   1640: lstore 7
    //   1642: goto -182 -> 1460
    //   1645: astore_3
    //   1646: aload_1
    //   1647: astore 4
    //   1649: aload_2
    //   1650: astore_1
    //   1651: lload 9
    //   1653: lstore 13
    //   1655: lload 11
    //   1657: lstore 9
    //   1659: aload 4
    //   1661: astore_2
    //   1662: lload 7
    //   1664: lstore 11
    //   1666: lload 13
    //   1668: lstore 7
    //   1670: goto -210 -> 1460
    //   1673: astore_3
    //   1674: aload_1
    //   1675: astore 4
    //   1677: aload_2
    //   1678: astore_1
    //   1679: lload 9
    //   1681: lstore 13
    //   1683: aload 4
    //   1685: astore_2
    //   1686: lload 11
    //   1688: lstore 9
    //   1690: lload 7
    //   1692: lstore 11
    //   1694: lload 13
    //   1696: lstore 7
    //   1698: goto -238 -> 1460
    //   1701: lload 11
    //   1703: lstore 13
    //   1705: goto -911 -> 794
    //   1708: aconst_null
    //   1709: astore 4
    //   1711: goto -1253 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1714	0	this	DownloadTask
    //   0	1714	1	paramHttpResponse	HttpResponse
    //   0	1714	2	paramResponse	Response
    //   0	1714	3	paramDownloadResult	DownloadResult
    //   0	1714	4	paramJobContext	ThreadPool.JobContext
    //   0	1714	5	paramInt	int
    //   612	342	6	i	int
    //   585	1112	7	l1	long
    //   85	1604	9	l2	long
    //   96	1606	11	l3	long
    //   578	1126	13	l4	long
    //   951	489	15	l5	long
    //   17	1448	17	l6	long
    //   572	524	19	l7	long
    //   91	1003	21	l8	long
    //   128	1102	23	bool1	boolean
    //   71	491	24	bool2	boolean
    //   99	763	25	bool3	boolean
    //   74	1175	26	localObject1	Object
    //   82	1408	27	localObject2	Object
    //   112	1127	28	localFile	File
    // Exception table:
    //   from	to	target	type
    //   149	157	393	java/lang/Throwable
    //   161	169	407	java/lang/Throwable
    //   1270	1274	1371	java/lang/Throwable
    //   1278	1282	1385	java/lang/Throwable
    //   101	130	1452	finally
    //   421	450	1452	finally
    //   450	458	1452	finally
    //   462	552	1452	finally
    //   832	844	1452	finally
    //   868	919	1452	finally
    //   925	933	1452	finally
    //   1474	1478	1563	java/lang/Throwable
    //   1482	1486	1577	java/lang/Throwable
    //   555	567	1591	finally
    //   567	574	1606	finally
    //   595	614	1621	finally
    //   634	649	1621	finally
    //   653	666	1621	finally
    //   675	691	1621	finally
    //   695	705	1621	finally
    //   709	741	1621	finally
    //   971	983	1621	finally
    //   987	1000	1621	finally
    //   1004	1014	1621	finally
    //   1018	1047	1621	finally
    //   1088	1102	1621	finally
    //   1106	1115	1621	finally
    //   1124	1157	1621	finally
    //   1161	1170	1621	finally
    //   1174	1229	1621	finally
    //   1238	1243	1621	finally
    //   1247	1256	1621	finally
    //   762	771	1645	finally
    //   778	794	1645	finally
    //   794	820	1645	finally
    //   820	825	1645	finally
    //   1060	1073	1673	finally
  }
  
  protected void initTask()
  {
    if (this.mDomain == null) {
      this.mDomain = Utils.getDomin(this.mUrl);
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
    int j = 0;
    int i = 0;
    paramHttpRequest = new StringBuffer();
    paramHttpRequest.append("<-----Response Headers----->");
    if (paramHttpResponse != null)
    {
      paramHttpRequest.append(paramHttpResponse.getStatusLine()).append(";");
      paramHttpResponse = paramHttpResponse.getAllHeaders();
      if (paramHttpResponse != null) {
        while (i < paramHttpResponse.length)
        {
          paramHttpRequest.append(paramHttpResponse[i].getName()).append(": ").append(paramHttpResponse[i].getValue()).append(";");
          i += 1;
        }
      }
    }
    else if (paramResponse != null)
    {
      paramHttpRequest.append(paramResponse.code()).append(";");
      paramHttpResponse = paramResponse.headers();
      if (paramHttpResponse != null)
      {
        i = j;
        while (i < paramHttpResponse.size())
        {
          paramHttpRequest.append(paramHttpResponse.name(i)).append(": ").append(paramHttpResponse.value(i)).append(";");
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
    if ((Config.getNetworkStackType() == 2) || (Config.getNetworkStackType() == 3))
    {
      i = 1;
      if ((paramString == null) || (paramString.startsWith("https:")) || (!this.mIsHttp2) || (i != 0)) {
        break label124;
      }
      paramString = paramString.replace("http:", "https:");
    }
    label124:
    for (;;)
    {
      String str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramString.startsWith("https:"))
        {
          str = paramString;
          if (this.disableHttps) {
            str = paramString.replace("https:", "http:");
          }
        }
      }
      if (this.mDownloadTaskHandler == null) {}
      do
      {
        return str;
        i = 0;
        break;
        paramString = this.mDownloadTaskHandler.prepareRequestUrl(str);
      } while (TextUtils.isEmpty(paramString));
      return paramString;
    }
  }
  
  public void removeHttpParam(String paramString)
  {
    this.mHttpParams.remove(paramString);
  }
  
  public final DownloadResult run(ThreadPool.JobContext paramJobContext)
  {
    String str = null;
    DownloadResult localDownloadResult = new DownloadResult(this.mUrl);
    if (paramJobContext.isCancelled())
    {
      handleDownloadReportForTask(paramJobContext, localDownloadResult, null);
      return localDownloadResult;
    }
    if (this.mDownloadTaskHandler != null) {
      str = this.mDownloadTaskHandler.findCacheEntryPath(this.mUrl);
    }
    if (!TextUtils.isEmpty(str))
    {
      if (QDLog.isInfoEnable()) {
        QDLog.i("downloader", "find cache entry:" + str + " url:" + this.mUrl);
      }
      localDownloadResult.setPath(str);
      localDownloadResult.getStatus().setSucceed();
      return localDownloadResult;
    }
    paramJobContext.setMode(2);
    for (;;)
    {
      try
      {
        initTask();
        NetworkManager.registNetStatusListener(this);
        execute(paramJobContext, localDownloadResult);
        if (!NetworkUtils.isNetworkAvailable(this.mContext))
        {
          this.mShouldReport = false;
          localDownloadResult.getStatus().setFailed(6);
        }
        processReport(paramJobContext, localDownloadResult);
        onTaskDequeue();
        if ((this.pCurrStrategyInfo == null) || (!localDownloadResult.getStatus().isSucceed())) {
          continue;
        }
        this.pCurrStrategyInfo.result = localDownloadResult;
        DownloadGlobalStrategy.getInstance(this.mContext).report(this.mContext, this.mUrl, this.mDomain, this.pCurrStrategyInfo, localDownloadResult.getStatus().isSucceed());
        if (localDownloadResult.getStatus().isSucceed()) {
          SpeedStatistics.getInstance().report(localDownloadResult.getContent().size, localDownloadResult.getProcess().startTime, localDownloadResult.getProcess().endTime);
        }
      }
      catch (Throwable paramJobContext)
      {
        QDLog.e("downloader", "exception when execute DownloadTask. ", paramJobContext);
        NetworkManager.unregistNetStatusListener(this);
        continue;
      }
      finally
      {
        NetworkManager.unregistNetStatusListener(this);
      }
      return localDownloadResult;
      if ((this.pDownloadStrategyLib != null) && (this.pDownloadStrategyLib.getBestStrategy() != null))
      {
        this.pDownloadStrategyLib.getBestStrategy().result = localDownloadResult;
        DownloadGlobalStrategy.getInstance(this.mContext).report(this.mContext, this.mUrl, this.mDomain, this.pDownloadStrategyLib.getBestStrategy(), localDownloadResult.getStatus().isSucceed());
      }
    }
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
  
  public void setResponseDataListener(DownloadRequest.OnResponseDataListener paramOnResponseDataListener)
  {
    this.pExtendParam.onResponseDataListener = paramOnResponseDataListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask
 * JD-Core Version:    0.7.0.1
 */