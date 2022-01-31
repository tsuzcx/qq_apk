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
    //   17: lstore 20
    //   19: iload 5
    //   21: sipush 206
    //   24: if_icmpne +218 -> 242
    //   27: aload_0
    //   28: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   31: ifnull +200 -> 231
    //   34: aload_0
    //   35: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   38: aload_0
    //   39: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   42: invokeinterface 760 2 0
    //   47: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +181 -> 231
    //   53: aload_3
    //   54: aload_0
    //   55: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   58: aload_0
    //   59: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   62: invokeinterface 760 2 0
    //   67: invokevirtual 763	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   70: iconst_1
    //   71: istore 26
    //   73: getstatic 96	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   76: invokevirtual 766	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   79: astore 28
    //   81: lconst_0
    //   82: lstore 16
    //   84: aload_0
    //   85: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   88: lstore 22
    //   90: lconst_0
    //   91: lstore 8
    //   93: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   96: lstore 12
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
    //   125: istore 27
    //   127: iload 27
    //   129: ifeq +279 -> 408
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 770	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: iconst_0
    //   145: ifeq +11 -> 156
    //   148: new 770	java/lang/NullPointerException
    //   151: dup
    //   152: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   155: athrow
    //   156: getstatic 96	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   159: aload 28
    //   161: invokevirtual 775	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   164: aload_0
    //   165: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   168: ifnull +22 -> 190
    //   171: aload_0
    //   172: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   175: invokestatic 782	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   178: lconst_0
    //   179: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   182: lload 12
    //   184: lsub
    //   185: invokeinterface 788 6 0
    //   190: ldc_w 329
    //   193: new 331	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 790
    //   203: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   210: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: ldc_w 795
    //   216: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: lconst_0
    //   220: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 347	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iconst_0
    //   230: ireturn
    //   231: ldc_w 329
    //   234: ldc_w 797
    //   237: invokestatic 750	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: iconst_0
    //   241: ireturn
    //   242: aload_0
    //   243: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   246: ifnull +44 -> 290
    //   249: aload_0
    //   250: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   253: aload_0
    //   254: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   257: invokeinterface 760 2 0
    //   262: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifne +25 -> 290
    //   268: iload 5
    //   270: sipush 200
    //   273: if_icmpne +17 -> 290
    //   276: aload_0
    //   277: getfield 740	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   280: aload_0
    //   281: getfield 175	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   284: iconst_1
    //   285: invokeinterface 754 3 0
    //   290: aload_0
    //   291: invokespecial 799	com/tencent/component/network/downloader/impl/DownloadTask:generateStorageName	()Ljava/lang/String;
    //   294: astore 29
    //   296: aload_0
    //   297: aload 29
    //   299: invokespecial 801	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;)Ljava/lang/String;
    //   302: astore 28
    //   304: aload_0
    //   305: aload 29
    //   307: iconst_0
    //   308: invokespecial 803	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   311: astore 29
    //   313: aload_0
    //   314: aload 28
    //   316: aload_0
    //   317: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   320: invokespecial 805	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   323: ifeq +15 -> 338
    //   326: aload_3
    //   327: aload 28
    //   329: invokevirtual 763	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   332: iconst_0
    //   333: istore 26
    //   335: goto -262 -> 73
    //   338: aload 28
    //   340: aload 29
    //   342: invokestatic 809	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   345: ifne +25 -> 370
    //   348: aload_0
    //   349: aload 29
    //   351: aload_0
    //   352: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   355: invokespecial 805	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   358: ifeq +12 -> 370
    //   361: aload_3
    //   362: aload 29
    //   364: invokevirtual 763	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   367: goto -35 -> 332
    //   370: aload_3
    //   371: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   374: iconst_2
    //   375: invokevirtual 738	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   378: iconst_0
    //   379: ireturn
    //   380: astore_1
    //   381: ldc_w 329
    //   384: ldc_w 811
    //   387: aload_1
    //   388: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   391: goto -247 -> 144
    //   394: astore_1
    //   395: ldc_w 329
    //   398: ldc_w 811
    //   401: aload_1
    //   402: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   405: goto -249 -> 156
    //   408: aload_0
    //   409: getfield 813	com/tencent/component/network/downloader/impl/DownloadTask:mNeedMd5	Z
    //   412: ifeq +1090 -> 1502
    //   415: aload_1
    //   416: ldc_w 815
    //   419: invokeinterface 518 2 0
    //   424: ifnull +13 -> 437
    //   427: aload_2
    //   428: ldc_w 815
    //   431: invokevirtual 535	com/squareup/okhttp/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   434: ifnonnull +1068 -> 1502
    //   437: ldc_w 817
    //   440: invokestatic 823	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   443: astore 4
    //   445: aload_1
    //   446: ifnull +325 -> 771
    //   449: aload_1
    //   450: invokeinterface 605 1 0
    //   455: ifnull +316 -> 771
    //   458: aload_1
    //   459: invokeinterface 605 1 0
    //   464: invokeinterface 629 1 0
    //   469: ifnull +296 -> 765
    //   472: aload_1
    //   473: invokeinterface 605 1 0
    //   478: invokeinterface 629 1 0
    //   483: invokeinterface 523 1 0
    //   488: ifnull +277 -> 765
    //   491: aload_1
    //   492: invokeinterface 605 1 0
    //   497: invokeinterface 629 1 0
    //   502: invokeinterface 523 1 0
    //   507: invokevirtual 826	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   510: ldc_w 828
    //   513: invokevirtual 831	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   516: iconst_m1
    //   517: if_icmple +248 -> 765
    //   520: iconst_1
    //   521: istore 5
    //   523: aload_1
    //   524: invokeinterface 605 1 0
    //   529: invokeinterface 834 1 0
    //   534: astore_1
    //   535: new 836	java/io/FileOutputStream
    //   538: dup
    //   539: aload 29
    //   541: iload 26
    //   543: invokespecial 839	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   546: astore_2
    //   547: aload 29
    //   549: invokevirtual 841	java/io/File:length	()J
    //   552: lstore 24
    //   554: iconst_0
    //   555: istore 6
    //   557: lconst_0
    //   558: lstore 10
    //   560: lload 16
    //   562: lstore 14
    //   564: lload 10
    //   566: lstore 8
    //   568: aload_1
    //   569: aload 28
    //   571: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   574: iload 6
    //   576: sipush 8192
    //   579: iload 6
    //   581: isub
    //   582: invokevirtual 853	java/io/InputStream:read	([BII)I
    //   585: istore 7
    //   587: iload 7
    //   589: ifle +217 -> 806
    //   592: iload 7
    //   594: iload 6
    //   596: iadd
    //   597: sipush 8192
    //   600: if_icmpne +196 -> 796
    //   603: lload 16
    //   605: lstore 14
    //   607: lload 10
    //   609: lstore 8
    //   611: aload_2
    //   612: aload 28
    //   614: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   617: iconst_0
    //   618: iload 7
    //   620: iload 6
    //   622: iadd
    //   623: invokevirtual 859	java/io/OutputStream:write	([BII)V
    //   626: lload 16
    //   628: lstore 14
    //   630: lload 10
    //   632: lstore 8
    //   634: aload_0
    //   635: aload_0
    //   636: getfield 183	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   639: aload 29
    //   641: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   644: invokespecial 862	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload 4
    //   649: ifnull +859 -> 1508
    //   652: lload 16
    //   654: lstore 14
    //   656: lload 10
    //   658: lstore 8
    //   660: aload 4
    //   662: aload 28
    //   664: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   667: iconst_0
    //   668: iload 6
    //   670: iload 7
    //   672: iadd
    //   673: invokevirtual 865	java/security/MessageDigest:update	([BII)V
    //   676: goto +832 -> 1508
    //   679: lload 16
    //   681: iload 7
    //   683: i2l
    //   684: ladd
    //   685: lstore 16
    //   687: lload 16
    //   689: lstore 14
    //   691: lload 10
    //   693: lstore 8
    //   695: aload_3
    //   696: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   699: lload 16
    //   701: putfield 867	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   704: lload 22
    //   706: lconst_0
    //   707: lcmp
    //   708: ifle +37 -> 745
    //   711: lload 16
    //   713: lstore 14
    //   715: lload 10
    //   717: lstore 8
    //   719: aload_0
    //   720: aload_0
    //   721: getfield 183	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   724: lload 22
    //   726: lload 24
    //   728: ladd
    //   729: lload 16
    //   731: lload 24
    //   733: ladd
    //   734: l2f
    //   735: lload 22
    //   737: lload 24
    //   739: ladd
    //   740: l2f
    //   741: fdiv
    //   742: invokespecial 869	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   745: lload 16
    //   747: lstore 14
    //   749: lload 10
    //   751: lstore 8
    //   753: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   756: lstore 18
    //   758: lload 18
    //   760: lstore 12
    //   762: goto -202 -> 560
    //   765: iconst_0
    //   766: istore 5
    //   768: goto -245 -> 523
    //   771: aload_2
    //   772: ifnull +722 -> 1494
    //   775: aload_2
    //   776: invokevirtual 609	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   779: ifnull +715 -> 1494
    //   782: aload_2
    //   783: invokevirtual 609	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   786: invokevirtual 872	com/squareup/okhttp/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   789: astore_1
    //   790: iconst_0
    //   791: istore 5
    //   793: goto -258 -> 535
    //   796: iload 6
    //   798: iload 7
    //   800: iadd
    //   801: istore 6
    //   803: goto -124 -> 679
    //   806: lload 10
    //   808: lstore 18
    //   810: iload 7
    //   812: ifgt +95 -> 907
    //   815: lload 10
    //   817: lstore 18
    //   819: iload 6
    //   821: ifle +86 -> 907
    //   824: lload 16
    //   826: lstore 14
    //   828: lload 10
    //   830: lstore 8
    //   832: aload_2
    //   833: aload 28
    //   835: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   838: iconst_0
    //   839: iload 6
    //   841: invokevirtual 859	java/io/OutputStream:write	([BII)V
    //   844: lload 16
    //   846: lstore 14
    //   848: lload 10
    //   850: lstore 8
    //   852: aload_0
    //   853: aload_0
    //   854: getfield 183	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   857: aload 29
    //   859: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   862: invokespecial 862	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   865: lload 10
    //   867: iload 6
    //   869: i2l
    //   870: ladd
    //   871: lstore 10
    //   873: lload 10
    //   875: lstore 18
    //   877: aload 4
    //   879: ifnull +28 -> 907
    //   882: lload 16
    //   884: lstore 14
    //   886: lload 10
    //   888: lstore 8
    //   890: aload 4
    //   892: aload 28
    //   894: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   897: iconst_0
    //   898: iload 6
    //   900: invokevirtual 865	java/security/MessageDigest:update	([BII)V
    //   903: lload 10
    //   905: lstore 18
    //   907: lload 16
    //   909: lstore 14
    //   911: lload 18
    //   913: lstore 8
    //   915: aload_0
    //   916: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   919: lload 20
    //   921: lsub
    //   922: putfield 153	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   925: lload 22
    //   927: lconst_0
    //   928: lcmp
    //   929: ifgt +25 -> 954
    //   932: lload 16
    //   934: lstore 14
    //   936: lload 18
    //   938: lstore 8
    //   940: aload_0
    //   941: aload_0
    //   942: getfield 183	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   945: lload 22
    //   947: lload 24
    //   949: ladd
    //   950: fconst_1
    //   951: invokespecial 869	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   954: lload 16
    //   956: lstore 14
    //   958: lload 18
    //   960: lstore 8
    //   962: aload_3
    //   963: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   966: lload 16
    //   968: putfield 867	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   971: iload 5
    //   973: ifeq +159 -> 1132
    //   976: lload 16
    //   978: lstore 14
    //   980: lload 18
    //   982: lstore 8
    //   984: new 209	java/io/File
    //   987: dup
    //   988: new 331	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   995: aload 29
    //   997: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   1000: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc_w 874
    //   1006: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   1015: astore 30
    //   1017: lload 16
    //   1019: lstore 14
    //   1021: lload 18
    //   1023: lstore 8
    //   1025: aload 29
    //   1027: aload 30
    //   1029: invokestatic 880	com/tencent/component/network/utils/FileUtils:unGzip	(Ljava/io/File;Ljava/io/File;)Z
    //   1032: istore 26
    //   1034: lload 16
    //   1036: lstore 14
    //   1038: lload 18
    //   1040: lstore 8
    //   1042: ldc_w 329
    //   1045: new 331	java/lang/StringBuilder
    //   1048: dup
    //   1049: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1052: ldc_w 882
    //   1055: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: iload 26
    //   1060: invokevirtual 885	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1063: ldc_w 887
    //   1066: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload 30
    //   1071: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   1074: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: ldc_w 889
    //   1080: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: aload 30
    //   1085: invokevirtual 841	java/io/File:length	()J
    //   1088: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1091: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: invokestatic 750	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1097: iload 26
    //   1099: ifeq +33 -> 1132
    //   1102: lload 16
    //   1104: lstore 14
    //   1106: lload 18
    //   1108: lstore 8
    //   1110: aload 29
    //   1112: invokestatic 893	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   1115: lload 16
    //   1117: lstore 14
    //   1119: lload 18
    //   1121: lstore 8
    //   1123: aload_3
    //   1124: aload 30
    //   1126: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   1129: invokevirtual 763	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   1132: aload_1
    //   1133: ifnull +7 -> 1140
    //   1136: aload_1
    //   1137: invokevirtual 896	java/io/InputStream:close	()V
    //   1140: aload_2
    //   1141: ifnull +7 -> 1148
    //   1144: aload_2
    //   1145: invokevirtual 897	java/io/OutputStream:close	()V
    //   1148: getstatic 96	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1151: aload 28
    //   1153: invokevirtual 775	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1156: aload_0
    //   1157: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1160: ifnull +23 -> 1183
    //   1163: aload_0
    //   1164: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1167: invokestatic 782	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1170: lload 16
    //   1172: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   1175: lload 12
    //   1177: lsub
    //   1178: invokeinterface 788 6 0
    //   1183: aload 4
    //   1185: ifnull +91 -> 1276
    //   1188: aload 4
    //   1190: invokevirtual 901	java/security/MessageDigest:digest	()[B
    //   1193: astore_1
    //   1194: new 331	java/lang/StringBuilder
    //   1197: dup
    //   1198: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1201: astore_2
    //   1202: iconst_0
    //   1203: istore 5
    //   1205: iload 5
    //   1207: aload_1
    //   1208: arraylength
    //   1209: if_icmpge +56 -> 1265
    //   1212: aload_2
    //   1213: aload_1
    //   1214: iload 5
    //   1216: baload
    //   1217: sipush 255
    //   1220: iand
    //   1221: invokestatic 904	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1224: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: pop
    //   1228: iload 5
    //   1230: iconst_1
    //   1231: iadd
    //   1232: istore 5
    //   1234: goto -29 -> 1205
    //   1237: astore_1
    //   1238: ldc_w 329
    //   1241: ldc_w 811
    //   1244: aload_1
    //   1245: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1248: goto -108 -> 1140
    //   1251: astore_1
    //   1252: ldc_w 329
    //   1255: ldc_w 811
    //   1258: aload_1
    //   1259: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1262: goto -114 -> 1148
    //   1265: aload_3
    //   1266: invokevirtual 617	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1269: aload_2
    //   1270: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: putfield 907	com/tencent/component/network/downloader/DownloadResult$Content:md5	Ljava/lang/String;
    //   1276: ldc_w 329
    //   1279: new 331	java/lang/StringBuilder
    //   1282: dup
    //   1283: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1286: ldc_w 790
    //   1289: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: aload_0
    //   1293: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1296: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1299: ldc_w 795
    //   1302: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: lload 18
    //   1307: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1310: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokestatic 347	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1316: iconst_1
    //   1317: ireturn
    //   1318: astore_3
    //   1319: aconst_null
    //   1320: astore_1
    //   1321: aconst_null
    //   1322: astore_2
    //   1323: lload 16
    //   1325: lstore 14
    //   1327: aload_2
    //   1328: ifnull +7 -> 1335
    //   1331: aload_2
    //   1332: invokevirtual 896	java/io/InputStream:close	()V
    //   1335: aload_1
    //   1336: ifnull +7 -> 1343
    //   1339: aload_1
    //   1340: invokevirtual 897	java/io/OutputStream:close	()V
    //   1343: getstatic 96	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1346: aload 28
    //   1348: invokevirtual 775	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1351: aload_0
    //   1352: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1355: ifnull +23 -> 1378
    //   1358: aload_0
    //   1359: getfield 777	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1362: invokestatic 782	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1365: lload 14
    //   1367: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   1370: lload 12
    //   1372: lsub
    //   1373: invokeinterface 788 6 0
    //   1378: ldc_w 329
    //   1381: new 331	java/lang/StringBuilder
    //   1384: dup
    //   1385: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   1388: ldc_w 790
    //   1391: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: aload_0
    //   1395: getfield 498	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1398: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1401: ldc_w 795
    //   1404: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: lload 8
    //   1409: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1412: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: invokestatic 347	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1418: aload_3
    //   1419: athrow
    //   1420: astore_2
    //   1421: ldc_w 329
    //   1424: ldc_w 811
    //   1427: aload_2
    //   1428: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1431: goto -96 -> 1335
    //   1434: astore_1
    //   1435: ldc_w 329
    //   1438: ldc_w 811
    //   1441: aload_1
    //   1442: invokestatic 442	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1445: goto -102 -> 1343
    //   1448: astore_3
    //   1449: aconst_null
    //   1450: astore 4
    //   1452: aload_1
    //   1453: astore_2
    //   1454: aload 4
    //   1456: astore_1
    //   1457: lload 16
    //   1459: lstore 14
    //   1461: goto -134 -> 1327
    //   1464: astore_3
    //   1465: aload_1
    //   1466: astore 4
    //   1468: aload_2
    //   1469: astore_1
    //   1470: aload 4
    //   1472: astore_2
    //   1473: lload 16
    //   1475: lstore 14
    //   1477: goto -150 -> 1327
    //   1480: astore 4
    //   1482: aload_1
    //   1483: astore_3
    //   1484: aload_2
    //   1485: astore_1
    //   1486: aload_3
    //   1487: astore_2
    //   1488: aload 4
    //   1490: astore_3
    //   1491: goto -164 -> 1327
    //   1494: iconst_0
    //   1495: istore 5
    //   1497: aconst_null
    //   1498: astore_1
    //   1499: goto -964 -> 535
    //   1502: aconst_null
    //   1503: astore 4
    //   1505: goto -1060 -> 445
    //   1508: iconst_0
    //   1509: istore 6
    //   1511: lload 10
    //   1513: iload 7
    //   1515: iconst_0
    //   1516: iadd
    //   1517: i2l
    //   1518: ladd
    //   1519: lstore 10
    //   1521: goto -842 -> 679
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1524	0	this	DownloadTask
    //   0	1524	1	paramHttpResponse	HttpResponse
    //   0	1524	2	paramResponse	Response
    //   0	1524	3	paramDownloadResult	DownloadResult
    //   0	1524	4	paramJobContext	ThreadPool.JobContext
    //   0	1524	5	paramInt	int
    //   555	955	6	i	int
    //   585	932	7	j	int
    //   91	1317	8	l1	long
    //   558	962	10	l2	long
    //   96	1275	12	l3	long
    //   562	914	14	l4	long
    //   82	1392	16	l5	long
    //   756	550	18	l6	long
    //   17	903	20	l7	long
    //   88	858	22	l8	long
    //   552	396	24	l9	long
    //   71	1027	26	bool1	boolean
    //   125	3	27	bool2	boolean
    //   79	1268	28	localObject1	Object
    //   109	1002	29	localObject2	Object
    //   1015	110	30	localFile	File
    // Exception table:
    //   from	to	target	type
    //   136	144	380	java/lang/Throwable
    //   148	156	394	java/lang/Throwable
    //   1136	1140	1237	java/lang/Throwable
    //   1144	1148	1251	java/lang/Throwable
    //   98	127	1318	finally
    //   408	437	1318	finally
    //   437	445	1318	finally
    //   449	520	1318	finally
    //   523	535	1318	finally
    //   775	790	1318	finally
    //   1331	1335	1420	java/lang/Throwable
    //   1339	1343	1434	java/lang/Throwable
    //   535	547	1448	finally
    //   547	554	1464	finally
    //   568	587	1480	finally
    //   611	626	1480	finally
    //   634	647	1480	finally
    //   660	676	1480	finally
    //   695	704	1480	finally
    //   719	745	1480	finally
    //   753	758	1480	finally
    //   832	844	1480	finally
    //   852	865	1480	finally
    //   890	903	1480	finally
    //   915	925	1480	finally
    //   940	954	1480	finally
    //   962	971	1480	finally
    //   984	1017	1480	finally
    //   1025	1034	1480	finally
    //   1042	1097	1480	finally
    //   1110	1115	1480	finally
    //   1123	1132	1480	finally
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