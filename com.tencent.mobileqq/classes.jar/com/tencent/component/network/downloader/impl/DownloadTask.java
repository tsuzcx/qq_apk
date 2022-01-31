package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.component.network.downloader.DownloadReport;
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
import com.tencent.component.network.utils.http.base.QZoneHttp2Client;
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
  protected QZoneHttpClient pHttpClient;
  protected DownloadGlobalStrategy.StrategyInfo pOldStrategyInfo = null;
  protected PortConfigStrategy pPortConfigStrategy;
  protected ResumeTransfer pResumeTransfer;
  protected QZoneHttp2Client pokHttpClient;
  private List<ReportHandler.DownloadReportObject> reportList = new ArrayList();
  protected HttpGet request = null;
  protected long t_recv_data = 0L;
  
  static
  {
    map404Urls = new ConcurrentHashMap();
    sRequestOptions = new DownloadTask.1();
  }
  
  public DownloadTask(Context paramContext, QZoneHttp2Client paramQZoneHttp2Client, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AssertUtil.assertTrue(Utils.checkUrl(paramString1));
    this.mContext = paramContext;
    this.mUrl = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.mUrlKey = paramString2;
      this.pokHttpClient = paramQZoneHttp2Client;
      this.pHttpClient = paramQZoneHttpClient;
      if (!paramBoolean1) {
        break label172;
      }
    }
    label172:
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
    //   1: getfield 187	com/tencent/component/network/downloader/impl/DownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   11: getstatic 118	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   14: lsub
    //   15: lstore_1
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: iflt +11 -> 30
    //   22: lload_1
    //   23: ldc2_w 455
    //   26: lcmp
    //   27: iflt -20 -> 7
    //   30: getstatic 110	com/tencent/component/network/downloader/impl/DownloadTask:ConnectionCleanLock	Ljava/lang/Object;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   39: getstatic 118	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   42: lsub
    //   43: lstore_1
    //   44: lload_1
    //   45: lconst_0
    //   46: lcmp
    //   47: iflt +21 -> 68
    //   50: lload_1
    //   51: ldc2_w 455
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
    //   69: getfield 187	com/tencent/component/network/downloader/impl/DownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   72: invokevirtual 462	com/tencent/component/network/utils/http/base/QZoneHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +49 -> 128
    //   82: aload 4
    //   84: instanceof 464
    //   87: ifeq +41 -> 128
    //   90: aload 4
    //   92: checkcast 464	com/tencent/component/network/utils/http/PoolingClientConnectionManager
    //   95: astore 4
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 467	com/tencent/component/network/utils/http/PoolingClientConnectionManager:closeExpiredConnections	()V
    //   107: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   110: putstatic 118	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   113: invokestatic 470	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   116: ifeq +12 -> 128
    //   119: ldc_w 329
    //   122: ldc_w 472
    //   125: invokestatic 475	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_3
    //   129: monitorexit
    //   130: return
    //   131: astore 4
    //   133: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   136: putstatic 118	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   139: invokestatic 470	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   142: ifeq -14 -> 128
    //   145: ldc_w 329
    //   148: ldc_w 472
    //   151: invokestatic 475	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -26 -> 128
    //   157: astore 4
    //   159: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   162: putstatic 118	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   165: invokestatic 470	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   168: ifeq +12 -> 180
    //   171: ldc_w 329
    //   174: ldc_w 472
    //   177: invokestatic 475	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   5: invokeinterface 605 1 0
    //   10: astore 10
    //   12: aload_2
    //   13: ifnull +290 -> 303
    //   16: aload_2
    //   17: invokevirtual 609	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   20: astore 9
    //   22: aload 10
    //   24: ifnull +285 -> 309
    //   27: aload 10
    //   29: invokeinterface 613 1 0
    //   34: lstore 7
    //   36: aload_0
    //   37: lload 7
    //   39: putfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   42: aload_3
    //   43: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   46: aload_0
    //   47: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   50: putfield 622	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   53: aconst_null
    //   54: astore 12
    //   56: aconst_null
    //   57: astore 11
    //   59: aload 10
    //   61: ifnull +263 -> 324
    //   64: aload 10
    //   66: invokeinterface 626 1 0
    //   71: astore 11
    //   73: aload 12
    //   75: astore 9
    //   77: aload 11
    //   79: ifnull +12 -> 91
    //   82: aload 11
    //   84: invokeinterface 523 1 0
    //   89: astore 9
    //   91: aload 10
    //   93: invokeinterface 629 1 0
    //   98: astore 10
    //   100: aload 10
    //   102: ifnull +799 -> 901
    //   105: aload 10
    //   107: invokeinterface 523 1 0
    //   112: astore 10
    //   114: goto +790 -> 904
    //   117: aload 9
    //   119: ifnull +12 -> 131
    //   122: aload_3
    //   123: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   126: aload 9
    //   128: putfield 632	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   131: aload 10
    //   133: ifnull +12 -> 145
    //   136: aload_3
    //   137: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   140: aload 10
    //   142: putfield 635	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   145: aload_1
    //   146: ifnull +291 -> 437
    //   149: aload_1
    //   150: invokeinterface 639 1 0
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
    //   177: ldc_w 641
    //   180: aload 9
    //   182: iload 5
    //   184: aaload
    //   185: invokeinterface 642 1 0
    //   190: invokevirtual 645	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   193: ifeq +205 -> 398
    //   196: aload_3
    //   197: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   200: aload 9
    //   202: iload 5
    //   204: aaload
    //   205: invokeinterface 523 1 0
    //   210: putfield 648	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   213: aload_1
    //   214: ldc_w 650
    //   217: invokeinterface 518 2 0
    //   222: astore 9
    //   224: aload 9
    //   226: ifnull +181 -> 407
    //   229: aload_0
    //   230: aload 9
    //   232: invokeinterface 523 1 0
    //   237: invokestatic 654	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   240: i2l
    //   241: putfield 132	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   244: aload_3
    //   245: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   248: aload_0
    //   249: getfield 132	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   252: putfield 657	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   255: aload_1
    //   256: ldc_w 659
    //   259: invokeinterface 518 2 0
    //   264: astore 9
    //   266: aload 9
    //   268: ifnull +17 -> 285
    //   271: aload_3
    //   272: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   275: aload 9
    //   277: invokeinterface 523 1 0
    //   282: putfield 662	com/tencent/component/network/downloader/DownloadResult$Content:lastModified	Ljava/lang/String;
    //   285: aload 4
    //   287: invokeinterface 270 1 0
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
    //   316: invokevirtual 667	com/squareup/okhttp/ResponseBody:contentLength	()J
    //   319: lstore 7
    //   321: goto -285 -> 36
    //   324: aload 9
    //   326: ifnull +565 -> 891
    //   329: aload 9
    //   331: invokevirtual 671	com/squareup/okhttp/ResponseBody:contentType	()Lcom/squareup/okhttp/MediaType;
    //   334: astore 9
    //   336: aload 9
    //   338: ifnull +553 -> 891
    //   341: aload 9
    //   343: invokevirtual 674	com/squareup/okhttp/MediaType:toString	()Ljava/lang/String;
    //   346: astore 12
    //   348: aload 9
    //   350: invokevirtual 678	com/squareup/okhttp/MediaType:charset	()Ljava/nio/charset/Charset;
    //   353: astore 13
    //   355: aload 12
    //   357: astore 9
    //   359: aload 11
    //   361: astore 10
    //   363: aload 13
    //   365: ifnull -248 -> 117
    //   368: aload_3
    //   369: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   372: aload 13
    //   374: invokevirtual 683	java/nio/charset/Charset:name	()Ljava/lang/String;
    //   377: putfield 635	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   380: aload 12
    //   382: astore 9
    //   384: aload 11
    //   386: astore 10
    //   388: goto -271 -> 117
    //   391: astore_1
    //   392: aload_1
    //   393: invokevirtual 686	java/io/IOException:printStackTrace	()V
    //   396: iconst_0
    //   397: ireturn
    //   398: iload 5
    //   400: iconst_1
    //   401: iadd
    //   402: istore 5
    //   404: goto -234 -> 170
    //   407: aload_0
    //   408: ldc2_w 129
    //   411: putfield 132	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   414: aload_3
    //   415: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   418: ldc2_w 129
    //   421: putfield 657	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   424: goto -169 -> 255
    //   427: astore 9
    //   429: aload 9
    //   431: invokevirtual 687	java/lang/Exception:printStackTrace	()V
    //   434: goto -149 -> 285
    //   437: aload_2
    //   438: ifnull -153 -> 285
    //   441: aload_2
    //   442: invokevirtual 690	com/squareup/okhttp/Response:headers	()Lcom/squareup/okhttp/Headers;
    //   445: astore 9
    //   447: aload 9
    //   449: ifnull +50 -> 499
    //   452: aload 9
    //   454: invokevirtual 693	com/squareup/okhttp/Headers:size	()I
    //   457: istore 6
    //   459: iconst_0
    //   460: istore 5
    //   462: iload 5
    //   464: iload 6
    //   466: if_icmpge +33 -> 499
    //   469: ldc_w 641
    //   472: aload 9
    //   474: iload 5
    //   476: invokevirtual 695	com/squareup/okhttp/Headers:name	(I)Ljava/lang/String;
    //   479: invokevirtual 645	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   482: ifeq +127 -> 609
    //   485: aload_3
    //   486: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   489: aload 9
    //   491: iload 5
    //   493: invokevirtual 698	com/squareup/okhttp/Headers:value	(I)Ljava/lang/String;
    //   496: putfield 648	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   499: aload_2
    //   500: ldc_w 650
    //   503: invokevirtual 701	com/squareup/okhttp/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   506: astore 9
    //   508: aload 9
    //   510: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   513: ifne +105 -> 618
    //   516: aload_0
    //   517: aload 9
    //   519: invokestatic 654	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   522: i2l
    //   523: putfield 132	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   526: aload_3
    //   527: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   530: aload_0
    //   531: getfield 132	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   534: putfield 657	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   537: aload_2
    //   538: ldc_w 659
    //   541: invokevirtual 535	com/squareup/okhttp/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   544: astore 9
    //   546: aload 9
    //   548: ifnull -263 -> 285
    //   551: aload 9
    //   553: invokeinterface 259 1 0
    //   558: ifle -273 -> 285
    //   561: aload 9
    //   563: iconst_0
    //   564: invokeinterface 263 2 0
    //   569: checkcast 703	java/lang/CharSequence
    //   572: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: ifne -290 -> 285
    //   578: aload_3
    //   579: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   582: aload 9
    //   584: iconst_0
    //   585: invokeinterface 263 2 0
    //   590: checkcast 299	java/lang/String
    //   593: putfield 662	com/tencent/component/network/downloader/DownloadResult$Content:lastModified	Ljava/lang/String;
    //   596: goto -311 -> 285
    //   599: astore 9
    //   601: aload 9
    //   603: invokevirtual 687	java/lang/Exception:printStackTrace	()V
    //   606: goto -321 -> 285
    //   609: iload 5
    //   611: iconst_1
    //   612: iadd
    //   613: istore 5
    //   615: goto -153 -> 462
    //   618: aload_0
    //   619: ldc2_w 129
    //   622: putfield 132	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   625: aload_3
    //   626: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   629: ldc2_w 129
    //   632: putfield 657	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   635: goto -98 -> 537
    //   638: aload_3
    //   639: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   642: iconst_0
    //   643: putfield 706	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   646: aload_1
    //   647: ifnull +79 -> 726
    //   650: aload_1
    //   651: ldc_w 708
    //   654: invokeinterface 712 2 0
    //   659: astore 9
    //   661: aload 9
    //   663: ifnull +51 -> 714
    //   666: aload 9
    //   668: invokeinterface 717 1 0
    //   673: ifeq +41 -> 714
    //   676: aload 9
    //   678: invokeinterface 720 1 0
    //   683: astore 10
    //   685: aload 10
    //   687: ifnull -21 -> 666
    //   690: ldc_w 722
    //   693: aload 10
    //   695: invokeinterface 523 1 0
    //   700: invokevirtual 645	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   703: ifeq -37 -> 666
    //   706: aload_3
    //   707: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   710: iconst_1
    //   711: putfield 706	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   714: aload 4
    //   716: invokeinterface 270 1 0
    //   721: ifeq +84 -> 805
    //   724: iconst_0
    //   725: ireturn
    //   726: aload_2
    //   727: ifnull -13 -> 714
    //   730: aload_2
    //   731: ldc_w 708
    //   734: invokevirtual 535	com/squareup/okhttp/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   737: astore 9
    //   739: aload 9
    //   741: ifnull -27 -> 714
    //   744: aload 9
    //   746: invokeinterface 726 1 0
    //   751: astore 9
    //   753: aload 9
    //   755: invokeinterface 729 1 0
    //   760: ifeq -46 -> 714
    //   763: aload 9
    //   765: invokeinterface 733 1 0
    //   770: checkcast 299	java/lang/String
    //   773: astore 10
    //   775: aload 10
    //   777: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   780: ifeq -27 -> 753
    //   783: ldc_w 722
    //   786: aload 10
    //   788: invokevirtual 645	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   791: ifeq -38 -> 753
    //   794: aload_3
    //   795: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   798: iconst_1
    //   799: putfield 706	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   802: goto -88 -> 714
    //   805: aload_0
    //   806: aload_3
    //   807: aload_1
    //   808: aload_2
    //   809: invokespecial 734	com/tencent/component/network/downloader/impl/DownloadTask:handleContentType	(Lcom/tencent/component/network/downloader/DownloadResult;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Z
    //   812: ifne +13 -> 825
    //   815: aload_3
    //   816: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   819: iconst_5
    //   820: invokevirtual 738	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   823: iconst_0
    //   824: ireturn
    //   825: aload_0
    //   826: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   829: ifnull +50 -> 879
    //   832: aload_0
    //   833: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   836: aload_0
    //   837: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   840: aload_0
    //   841: getfield 502	com/tencent/component/network/downloader/impl/DownloadTask:mDomain	Ljava/lang/String;
    //   844: aload_1
    //   845: aload_2
    //   846: invokeinterface 746 5 0
    //   851: ifne +28 -> 879
    //   854: ldc_w 329
    //   857: ldc_w 748
    //   860: invokestatic 750	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   863: aload_0
    //   864: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   867: aload_0
    //   868: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   871: iconst_1
    //   872: invokeinterface 754 3 0
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
    //   27	36	391	java/io/IOException
    //   36	53	391	java/io/IOException
    //   64	73	391	java/io/IOException
    //   82	91	391	java/io/IOException
    //   91	100	391	java/io/IOException
    //   105	114	391	java/io/IOException
    //   122	131	391	java/io/IOException
    //   136	145	391	java/io/IOException
    //   314	321	391	java/io/IOException
    //   329	336	391	java/io/IOException
    //   341	355	391	java/io/IOException
    //   368	380	391	java/io/IOException
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
    //   6: invokevirtual 757	com/tencent/component/network/downloader/impl/DownloadTask:handleHeader	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;)Z
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   17: lstore 22
    //   19: iload 5
    //   21: sipush 206
    //   24: if_icmpne +228 -> 252
    //   27: aload_0
    //   28: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   31: ifnull +210 -> 241
    //   34: aload_0
    //   35: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   38: aload_0
    //   39: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   42: invokeinterface 760 2 0
    //   47: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +191 -> 241
    //   53: aload_3
    //   54: aload_0
    //   55: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   58: aload_0
    //   59: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   62: invokeinterface 760 2 0
    //   67: invokevirtual 763	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   70: iconst_1
    //   71: istore 8
    //   73: getstatic 96	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   76: invokevirtual 766	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   79: astore 28
    //   81: lconst_0
    //   82: lstore 18
    //   84: aload_0
    //   85: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   88: lstore 24
    //   90: lconst_0
    //   91: lstore 10
    //   93: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   96: lstore 14
    //   98: new 209	java/io/File
    //   101: dup
    //   102: aload_3
    //   103: invokevirtual 768	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   106: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 29
    //   111: aload 29
    //   113: iconst_0
    //   114: invokestatic 218	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:ensureFile	(Ljava/io/File;Z)Z
    //   117: pop
    //   118: aload 4
    //   120: invokeinterface 270 1 0
    //   125: istore 9
    //   127: iload 9
    //   129: ifeq +289 -> 418
    //   132: aload_0
    //   133: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   136: lload 22
    //   138: lsub
    //   139: putfield 153	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   142: iconst_0
    //   143: ifeq +11 -> 154
    //   146: new 770	java/lang/NullPointerException
    //   149: dup
    //   150: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   153: athrow
    //   154: iconst_0
    //   155: ifeq +11 -> 166
    //   158: new 770	java/lang/NullPointerException
    //   161: dup
    //   162: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   165: athrow
    //   166: getstatic 96	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   169: aload 28
    //   171: invokevirtual 775	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   174: aload_0
    //   175: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   178: ifnull +22 -> 200
    //   181: aload_0
    //   182: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   185: invokestatic 782	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   188: lconst_0
    //   189: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   192: lload 14
    //   194: lsub
    //   195: invokeinterface 788 6 0
    //   200: ldc_w 329
    //   203: new 331	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 790
    //   213: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   220: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: ldc_w 795
    //   226: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: lconst_0
    //   230: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 347	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: iconst_0
    //   240: ireturn
    //   241: ldc_w 329
    //   244: ldc_w 797
    //   247: invokestatic 750	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: iconst_0
    //   251: ireturn
    //   252: aload_0
    //   253: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   256: ifnull +44 -> 300
    //   259: aload_0
    //   260: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   263: aload_0
    //   264: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   267: invokeinterface 760 2 0
    //   272: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifne +25 -> 300
    //   278: iload 5
    //   280: sipush 200
    //   283: if_icmpne +17 -> 300
    //   286: aload_0
    //   287: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   290: aload_0
    //   291: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   294: iconst_1
    //   295: invokeinterface 754 3 0
    //   300: aload_0
    //   301: invokespecial 799	com/tencent/component/network/downloader/impl/DownloadTask:generateStorageName	()Ljava/lang/String;
    //   304: astore 29
    //   306: aload_0
    //   307: aload 29
    //   309: invokespecial 801	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;)Ljava/lang/String;
    //   312: astore 28
    //   314: aload_0
    //   315: aload 29
    //   317: iconst_0
    //   318: invokespecial 803	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   321: astore 29
    //   323: aload_0
    //   324: aload 28
    //   326: aload_0
    //   327: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   330: invokespecial 805	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   333: ifeq +15 -> 348
    //   336: aload_3
    //   337: aload 28
    //   339: invokevirtual 763	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   342: iconst_0
    //   343: istore 8
    //   345: goto -272 -> 73
    //   348: aload 28
    //   350: aload 29
    //   352: invokestatic 809	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   355: ifne +25 -> 380
    //   358: aload_0
    //   359: aload 29
    //   361: aload_0
    //   362: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   365: invokespecial 805	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   368: ifeq +12 -> 380
    //   371: aload_3
    //   372: aload 29
    //   374: invokevirtual 763	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   377: goto -35 -> 342
    //   380: aload_3
    //   381: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   384: iconst_2
    //   385: invokevirtual 738	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   388: iconst_0
    //   389: ireturn
    //   390: astore_1
    //   391: ldc_w 329
    //   394: ldc_w 811
    //   397: aload_1
    //   398: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   401: goto -247 -> 154
    //   404: astore_1
    //   405: ldc_w 329
    //   408: ldc_w 811
    //   411: aload_1
    //   412: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   415: goto -249 -> 166
    //   418: aload_0
    //   419: getfield 813	com/tencent/component/network/downloader/impl/DownloadTask:mNeedMd5	Z
    //   422: ifeq +1090 -> 1512
    //   425: aload_1
    //   426: ldc_w 815
    //   429: invokeinterface 518 2 0
    //   434: ifnull +13 -> 447
    //   437: aload_2
    //   438: ldc_w 815
    //   441: invokevirtual 535	com/squareup/okhttp/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   444: ifnonnull +1068 -> 1512
    //   447: ldc_w 817
    //   450: invokestatic 823	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   453: astore 4
    //   455: aload_1
    //   456: ifnull +325 -> 781
    //   459: aload_1
    //   460: invokeinterface 605 1 0
    //   465: ifnull +316 -> 781
    //   468: aload_1
    //   469: invokeinterface 605 1 0
    //   474: invokeinterface 629 1 0
    //   479: ifnull +296 -> 775
    //   482: aload_1
    //   483: invokeinterface 605 1 0
    //   488: invokeinterface 629 1 0
    //   493: invokeinterface 523 1 0
    //   498: ifnull +277 -> 775
    //   501: aload_1
    //   502: invokeinterface 605 1 0
    //   507: invokeinterface 629 1 0
    //   512: invokeinterface 523 1 0
    //   517: invokevirtual 826	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   520: ldc_w 828
    //   523: invokevirtual 831	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   526: iconst_m1
    //   527: if_icmple +248 -> 775
    //   530: iconst_1
    //   531: istore 5
    //   533: aload_1
    //   534: invokeinterface 605 1 0
    //   539: invokeinterface 834 1 0
    //   544: astore_1
    //   545: new 836	java/io/FileOutputStream
    //   548: dup
    //   549: aload 29
    //   551: iload 8
    //   553: invokespecial 839	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   556: astore_2
    //   557: aload 29
    //   559: invokevirtual 841	java/io/File:length	()J
    //   562: lstore 26
    //   564: iconst_0
    //   565: istore 6
    //   567: lconst_0
    //   568: lstore 12
    //   570: lload 18
    //   572: lstore 16
    //   574: lload 12
    //   576: lstore 10
    //   578: aload_1
    //   579: aload 28
    //   581: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   584: iload 6
    //   586: sipush 8192
    //   589: iload 6
    //   591: isub
    //   592: invokevirtual 853	java/io/InputStream:read	([BII)I
    //   595: istore 7
    //   597: iload 7
    //   599: ifle +217 -> 816
    //   602: iload 7
    //   604: iload 6
    //   606: iadd
    //   607: sipush 8192
    //   610: if_icmpne +196 -> 806
    //   613: lload 18
    //   615: lstore 16
    //   617: lload 12
    //   619: lstore 10
    //   621: aload_2
    //   622: aload 28
    //   624: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   627: iconst_0
    //   628: iload 7
    //   630: iload 6
    //   632: iadd
    //   633: invokevirtual 859	java/io/OutputStream:write	([BII)V
    //   636: lload 18
    //   638: lstore 16
    //   640: lload 12
    //   642: lstore 10
    //   644: aload_0
    //   645: aload_0
    //   646: getfield 183	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   649: aload 29
    //   651: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   654: invokespecial 862	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   657: aload 4
    //   659: ifnull +859 -> 1518
    //   662: lload 18
    //   664: lstore 16
    //   666: lload 12
    //   668: lstore 10
    //   670: aload 4
    //   672: aload 28
    //   674: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   677: iconst_0
    //   678: iload 6
    //   680: iload 7
    //   682: iadd
    //   683: invokevirtual 865	java/security/MessageDigest:update	([BII)V
    //   686: goto +832 -> 1518
    //   689: lload 18
    //   691: iload 7
    //   693: i2l
    //   694: ladd
    //   695: lstore 18
    //   697: lload 18
    //   699: lstore 16
    //   701: lload 12
    //   703: lstore 10
    //   705: aload_3
    //   706: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   709: lload 18
    //   711: putfield 867	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   714: lload 24
    //   716: lconst_0
    //   717: lcmp
    //   718: ifle +37 -> 755
    //   721: lload 18
    //   723: lstore 16
    //   725: lload 12
    //   727: lstore 10
    //   729: aload_0
    //   730: aload_0
    //   731: getfield 183	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   734: lload 24
    //   736: lload 26
    //   738: ladd
    //   739: lload 18
    //   741: lload 26
    //   743: ladd
    //   744: l2f
    //   745: lload 24
    //   747: lload 26
    //   749: ladd
    //   750: l2f
    //   751: fdiv
    //   752: invokespecial 869	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   755: lload 18
    //   757: lstore 16
    //   759: lload 12
    //   761: lstore 10
    //   763: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   766: lstore 20
    //   768: lload 20
    //   770: lstore 14
    //   772: goto -202 -> 570
    //   775: iconst_0
    //   776: istore 5
    //   778: goto -245 -> 533
    //   781: aload_2
    //   782: ifnull +722 -> 1504
    //   785: aload_2
    //   786: invokevirtual 609	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   789: ifnull +715 -> 1504
    //   792: aload_2
    //   793: invokevirtual 609	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   796: invokevirtual 872	com/squareup/okhttp/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   799: astore_1
    //   800: iconst_0
    //   801: istore 5
    //   803: goto -258 -> 545
    //   806: iload 6
    //   808: iload 7
    //   810: iadd
    //   811: istore 6
    //   813: goto -124 -> 689
    //   816: lload 12
    //   818: lstore 20
    //   820: iload 7
    //   822: ifgt +95 -> 917
    //   825: lload 12
    //   827: lstore 20
    //   829: iload 6
    //   831: ifle +86 -> 917
    //   834: lload 18
    //   836: lstore 16
    //   838: lload 12
    //   840: lstore 10
    //   842: aload_2
    //   843: aload 28
    //   845: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   848: iconst_0
    //   849: iload 6
    //   851: invokevirtual 859	java/io/OutputStream:write	([BII)V
    //   854: lload 18
    //   856: lstore 16
    //   858: lload 12
    //   860: lstore 10
    //   862: aload_0
    //   863: aload_0
    //   864: getfield 183	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   867: aload 29
    //   869: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   872: invokespecial 862	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   875: lload 12
    //   877: iload 6
    //   879: i2l
    //   880: ladd
    //   881: lstore 12
    //   883: lload 12
    //   885: lstore 20
    //   887: aload 4
    //   889: ifnull +28 -> 917
    //   892: lload 18
    //   894: lstore 16
    //   896: lload 12
    //   898: lstore 10
    //   900: aload 4
    //   902: aload 28
    //   904: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   907: iconst_0
    //   908: iload 6
    //   910: invokevirtual 865	java/security/MessageDigest:update	([BII)V
    //   913: lload 12
    //   915: lstore 20
    //   917: lload 24
    //   919: lconst_0
    //   920: lcmp
    //   921: ifgt +25 -> 946
    //   924: lload 18
    //   926: lstore 16
    //   928: lload 20
    //   930: lstore 10
    //   932: aload_0
    //   933: aload_0
    //   934: getfield 183	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   937: lload 24
    //   939: lload 26
    //   941: ladd
    //   942: fconst_1
    //   943: invokespecial 869	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   946: lload 18
    //   948: lstore 16
    //   950: lload 20
    //   952: lstore 10
    //   954: aload_3
    //   955: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   958: lload 18
    //   960: putfield 867	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   963: iload 5
    //   965: ifeq +159 -> 1124
    //   968: lload 18
    //   970: lstore 16
    //   972: lload 20
    //   974: lstore 10
    //   976: new 209	java/io/File
    //   979: dup
    //   980: new 331	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   987: aload 29
    //   989: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   992: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: ldc_w 874
    //   998: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   1007: astore 30
    //   1009: lload 18
    //   1011: lstore 16
    //   1013: lload 20
    //   1015: lstore 10
    //   1017: aload 29
    //   1019: aload 30
    //   1021: invokestatic 880	com/tencent/component/network/utils/FileUtils:unGzip	(Ljava/io/File;Ljava/io/File;)Z
    //   1024: istore 8
    //   1026: lload 18
    //   1028: lstore 16
    //   1030: lload 20
    //   1032: lstore 10
    //   1034: ldc_w 329
    //   1037: new 331	java/lang/StringBuilder
    //   1040: dup
    //   1041: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1044: ldc_w 882
    //   1047: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: iload 8
    //   1052: invokevirtual 885	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1055: ldc_w 887
    //   1058: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload 30
    //   1063: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   1066: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: ldc_w 889
    //   1072: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: aload 30
    //   1077: invokevirtual 841	java/io/File:length	()J
    //   1080: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokestatic 750	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: iload 8
    //   1091: ifeq +33 -> 1124
    //   1094: lload 18
    //   1096: lstore 16
    //   1098: lload 20
    //   1100: lstore 10
    //   1102: aload 29
    //   1104: invokestatic 893	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   1107: lload 18
    //   1109: lstore 16
    //   1111: lload 20
    //   1113: lstore 10
    //   1115: aload_3
    //   1116: aload 30
    //   1118: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   1121: invokevirtual 763	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   1124: aload_0
    //   1125: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   1128: lload 22
    //   1130: lsub
    //   1131: putfield 153	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   1134: aload_1
    //   1135: ifnull +7 -> 1142
    //   1138: aload_1
    //   1139: invokevirtual 896	java/io/InputStream:close	()V
    //   1142: aload_2
    //   1143: ifnull +7 -> 1150
    //   1146: aload_2
    //   1147: invokevirtual 897	java/io/OutputStream:close	()V
    //   1150: getstatic 96	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1153: aload 28
    //   1155: invokevirtual 775	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1158: aload_0
    //   1159: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1162: ifnull +23 -> 1185
    //   1165: aload_0
    //   1166: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1169: invokestatic 782	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1172: lload 18
    //   1174: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   1177: lload 14
    //   1179: lsub
    //   1180: invokeinterface 788 6 0
    //   1185: aload 4
    //   1187: ifnull +91 -> 1278
    //   1190: aload 4
    //   1192: invokevirtual 901	java/security/MessageDigest:digest	()[B
    //   1195: astore_1
    //   1196: new 331	java/lang/StringBuilder
    //   1199: dup
    //   1200: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1203: astore_2
    //   1204: iconst_0
    //   1205: istore 5
    //   1207: iload 5
    //   1209: aload_1
    //   1210: arraylength
    //   1211: if_icmpge +56 -> 1267
    //   1214: aload_2
    //   1215: aload_1
    //   1216: iload 5
    //   1218: baload
    //   1219: sipush 255
    //   1222: iand
    //   1223: invokestatic 904	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1226: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: pop
    //   1230: iload 5
    //   1232: iconst_1
    //   1233: iadd
    //   1234: istore 5
    //   1236: goto -29 -> 1207
    //   1239: astore_1
    //   1240: ldc_w 329
    //   1243: ldc_w 811
    //   1246: aload_1
    //   1247: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1250: goto -108 -> 1142
    //   1253: astore_1
    //   1254: ldc_w 329
    //   1257: ldc_w 811
    //   1260: aload_1
    //   1261: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1264: goto -114 -> 1150
    //   1267: aload_3
    //   1268: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1271: aload_2
    //   1272: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1275: putfield 907	com/tencent/component/network/downloader/DownloadResult$Content:md5	Ljava/lang/String;
    //   1278: ldc_w 329
    //   1281: new 331	java/lang/StringBuilder
    //   1284: dup
    //   1285: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1288: ldc_w 790
    //   1291: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: aload_0
    //   1295: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1298: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1301: ldc_w 795
    //   1304: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: lload 20
    //   1309: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1312: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1315: invokestatic 347	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1318: iconst_1
    //   1319: ireturn
    //   1320: astore_2
    //   1321: aconst_null
    //   1322: astore_1
    //   1323: aconst_null
    //   1324: astore_3
    //   1325: lload 18
    //   1327: lstore 16
    //   1329: aload_0
    //   1330: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   1333: lload 22
    //   1335: lsub
    //   1336: putfield 153	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   1339: aload_3
    //   1340: ifnull +7 -> 1347
    //   1343: aload_3
    //   1344: invokevirtual 896	java/io/InputStream:close	()V
    //   1347: aload_1
    //   1348: ifnull +7 -> 1355
    //   1351: aload_1
    //   1352: invokevirtual 897	java/io/OutputStream:close	()V
    //   1355: getstatic 96	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1358: aload 28
    //   1360: invokevirtual 775	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1363: aload_0
    //   1364: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1367: ifnull +23 -> 1390
    //   1370: aload_0
    //   1371: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1374: invokestatic 782	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1377: lload 16
    //   1379: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   1382: lload 14
    //   1384: lsub
    //   1385: invokeinterface 788 6 0
    //   1390: ldc_w 329
    //   1393: new 331	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1400: ldc_w 790
    //   1403: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload_0
    //   1407: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1410: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1413: ldc_w 795
    //   1416: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: lload 10
    //   1421: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1424: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1427: invokestatic 347	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1430: aload_2
    //   1431: athrow
    //   1432: astore_3
    //   1433: ldc_w 329
    //   1436: ldc_w 811
    //   1439: aload_3
    //   1440: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1443: goto -96 -> 1347
    //   1446: astore_1
    //   1447: ldc_w 329
    //   1450: ldc_w 811
    //   1453: aload_1
    //   1454: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1457: goto -102 -> 1355
    //   1460: astore_2
    //   1461: aconst_null
    //   1462: astore 4
    //   1464: aload_1
    //   1465: astore_3
    //   1466: aload 4
    //   1468: astore_1
    //   1469: lload 18
    //   1471: lstore 16
    //   1473: goto -144 -> 1329
    //   1476: astore 4
    //   1478: aload_1
    //   1479: astore_3
    //   1480: aload_2
    //   1481: astore_1
    //   1482: lload 18
    //   1484: lstore 16
    //   1486: aload 4
    //   1488: astore_2
    //   1489: goto -160 -> 1329
    //   1492: astore 4
    //   1494: aload_1
    //   1495: astore_3
    //   1496: aload_2
    //   1497: astore_1
    //   1498: aload 4
    //   1500: astore_2
    //   1501: goto -172 -> 1329
    //   1504: iconst_0
    //   1505: istore 5
    //   1507: aconst_null
    //   1508: astore_1
    //   1509: goto -964 -> 545
    //   1512: aconst_null
    //   1513: astore 4
    //   1515: goto -1060 -> 455
    //   1518: iconst_0
    //   1519: istore 6
    //   1521: lload 12
    //   1523: iload 7
    //   1525: iconst_0
    //   1526: iadd
    //   1527: i2l
    //   1528: ladd
    //   1529: lstore 12
    //   1531: goto -842 -> 689
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1534	0	this	DownloadTask
    //   0	1534	1	paramHttpResponse	HttpResponse
    //   0	1534	2	paramResponse	Response
    //   0	1534	3	paramDownloadResult	DownloadResult
    //   0	1534	4	paramJobContext	ThreadPool.JobContext
    //   0	1534	5	paramInt	int
    //   565	955	6	i	int
    //   595	932	7	j	int
    //   71	1019	8	bool1	boolean
    //   125	3	9	bool2	boolean
    //   91	1329	10	l1	long
    //   568	962	12	l2	long
    //   96	1287	14	l3	long
    //   572	913	16	l4	long
    //   82	1401	18	l5	long
    //   766	542	20	l6	long
    //   17	1317	22	l7	long
    //   88	850	24	l8	long
    //   562	378	26	l9	long
    //   79	1280	28	localObject1	Object
    //   109	994	29	localObject2	Object
    //   1007	110	30	localFile	File
    // Exception table:
    //   from	to	target	type
    //   146	154	390	java/lang/Throwable
    //   158	166	404	java/lang/Throwable
    //   1138	1142	1239	java/lang/Throwable
    //   1146	1150	1253	java/lang/Throwable
    //   98	127	1320	finally
    //   418	447	1320	finally
    //   447	455	1320	finally
    //   459	530	1320	finally
    //   533	545	1320	finally
    //   785	800	1320	finally
    //   1343	1347	1432	java/lang/Throwable
    //   1351	1355	1446	java/lang/Throwable
    //   545	557	1460	finally
    //   557	564	1476	finally
    //   578	597	1492	finally
    //   621	636	1492	finally
    //   644	657	1492	finally
    //   670	686	1492	finally
    //   705	714	1492	finally
    //   729	755	1492	finally
    //   763	768	1492	finally
    //   842	854	1492	finally
    //   862	875	1492	finally
    //   900	913	1492	finally
    //   932	946	1492	finally
    //   954	963	1492	finally
    //   976	1009	1492	finally
    //   1017	1026	1492	finally
    //   1034	1089	1492	finally
    //   1102	1107	1492	finally
    //   1115	1124	1492	finally
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
        if (!localDownloadResult.getStatus().isSucceed()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask
 * JD-Core Version:    0.7.0.1
 */