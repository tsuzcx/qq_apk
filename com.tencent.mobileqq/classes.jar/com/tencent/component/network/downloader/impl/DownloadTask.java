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
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
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
    if (!TextUtils.isEmpty(paramString2))
    {
      this.mUrlKey = paramString2;
      this.pokHttpClient = paramOkHttpClient;
      this.pHttpClient = paramQZoneHttpClient;
      if (!paramBoolean1) {
        break label199;
      }
    }
    label199:
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
    //   19: iflt +11 -> 30
    //   22: lload_1
    //   23: ldc2_w 401
    //   26: lcmp
    //   27: iflt -20 -> 7
    //   30: getstatic 117	com/tencent/component/network/downloader/impl/DownloadTask:ConnectionCleanLock	Ljava/lang/Object;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   39: getstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   42: lsub
    //   43: lstore_1
    //   44: lload_1
    //   45: lconst_0
    //   46: lcmp
    //   47: iflt +21 -> 68
    //   50: lload_1
    //   51: ldc2_w 401
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
    //   69: getfield 207	com/tencent/component/network/downloader/impl/DownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   72: invokevirtual 408	com/tencent/component/network/utils/http/base/QZoneHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +49 -> 128
    //   82: aload 4
    //   84: instanceof 410
    //   87: ifeq +41 -> 128
    //   90: aload 4
    //   92: checkcast 410	com/tencent/component/network/utils/http/PoolingClientConnectionManager
    //   95: astore 4
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 413	com/tencent/component/network/utils/http/PoolingClientConnectionManager:closeExpiredConnections	()V
    //   107: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   110: putstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   113: invokestatic 416	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   116: ifeq +12 -> 128
    //   119: ldc_w 274
    //   122: ldc_w 418
    //   125: invokestatic 421	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_3
    //   129: monitorexit
    //   130: return
    //   131: astore 4
    //   133: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   136: putstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   139: invokestatic 416	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   142: ifeq -14 -> 128
    //   145: ldc_w 274
    //   148: ldc_w 418
    //   151: invokestatic 421	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -26 -> 128
    //   157: astore 4
    //   159: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   162: putstatic 125	com/tencent/component/network/downloader/impl/DownloadTask:mConnectionCleanTimestamp	J
    //   165: invokestatic 416	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   168: ifeq +12 -> 180
    //   171: ldc_w 274
    //   174: ldc_w 418
    //   177: invokestatic 421	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  protected boolean ensureStorageSpace(String paramString, long paramLong)
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
  
  public abstract void execute(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult);
  
  protected String generateStorageName()
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
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 636	com/tencent/component/network/downloader/impl/DownloadTask:headerCallback	(Lorg/apache/http/HttpResponse;)V
    //   9: aload_2
    //   10: ifnull +8 -> 18
    //   13: aload_0
    //   14: aload_2
    //   15: invokevirtual 639	com/tencent/component/network/downloader/impl/DownloadTask:headerCallback	(Lokhttp3/Response;)V
    //   18: aload_1
    //   19: ifnull +296 -> 315
    //   22: aload_1
    //   23: invokeinterface 643 1 0
    //   28: astore 10
    //   30: aload_2
    //   31: ifnull +290 -> 321
    //   34: aload_2
    //   35: invokevirtual 647	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   38: astore 9
    //   40: aload 10
    //   42: ifnull +285 -> 327
    //   45: aload 10
    //   47: invokeinterface 651 1 0
    //   52: lstore 7
    //   54: aload_0
    //   55: lload 7
    //   57: putfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   60: aload_3
    //   61: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   64: aload_0
    //   65: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   68: putfield 660	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   71: aconst_null
    //   72: astore 12
    //   74: aconst_null
    //   75: astore 11
    //   77: aload 10
    //   79: ifnull +263 -> 342
    //   82: aload 10
    //   84: invokeinterface 664 1 0
    //   89: astore 11
    //   91: aload 12
    //   93: astore 9
    //   95: aload 11
    //   97: ifnull +12 -> 109
    //   100: aload 11
    //   102: invokeinterface 540 1 0
    //   107: astore 9
    //   109: aload 10
    //   111: invokeinterface 667 1 0
    //   116: astore 10
    //   118: aload 10
    //   120: ifnull +799 -> 919
    //   123: aload 10
    //   125: invokeinterface 540 1 0
    //   130: astore 10
    //   132: goto +790 -> 922
    //   135: aload 9
    //   137: ifnull +12 -> 149
    //   140: aload_3
    //   141: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   144: aload 9
    //   146: putfield 670	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   149: aload 10
    //   151: ifnull +12 -> 163
    //   154: aload_3
    //   155: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   158: aload 10
    //   160: putfield 673	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   163: aload_1
    //   164: ifnull +291 -> 455
    //   167: aload_1
    //   168: invokeinterface 677 1 0
    //   173: astore 9
    //   175: aload 9
    //   177: ifnull +54 -> 231
    //   180: aload 9
    //   182: arraylength
    //   183: istore 6
    //   185: iconst_0
    //   186: istore 5
    //   188: iload 5
    //   190: iload 6
    //   192: if_icmpge +39 -> 231
    //   195: ldc_w 679
    //   198: aload 9
    //   200: iload 5
    //   202: aaload
    //   203: invokeinterface 680 1 0
    //   208: invokevirtual 683	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   211: ifeq +205 -> 416
    //   214: aload_3
    //   215: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   218: aload 9
    //   220: iload 5
    //   222: aaload
    //   223: invokeinterface 540 1 0
    //   228: putfield 686	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   231: aload_1
    //   232: ldc_w 688
    //   235: invokeinterface 535 2 0
    //   240: astore 9
    //   242: aload 9
    //   244: ifnull +181 -> 425
    //   247: aload_0
    //   248: aload 9
    //   250: invokeinterface 540 1 0
    //   255: invokestatic 692	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   258: i2l
    //   259: putfield 139	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   262: aload_3
    //   263: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   266: aload_0
    //   267: getfield 139	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   270: putfield 695	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   273: aload_1
    //   274: ldc_w 697
    //   277: invokeinterface 535 2 0
    //   282: astore 9
    //   284: aload 9
    //   286: ifnull +17 -> 303
    //   289: aload_3
    //   290: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   293: aload 9
    //   295: invokeinterface 540 1 0
    //   300: putfield 700	com/tencent/component/network/downloader/DownloadResult$Content:lastModified	Ljava/lang/String;
    //   303: aload 4
    //   305: invokeinterface 245 1 0
    //   310: ifeq +346 -> 656
    //   313: iconst_0
    //   314: ireturn
    //   315: aconst_null
    //   316: astore 10
    //   318: goto -288 -> 30
    //   321: aconst_null
    //   322: astore 9
    //   324: goto -284 -> 40
    //   327: aload 9
    //   329: ifnull +596 -> 925
    //   332: aload 9
    //   334: invokevirtual 705	okhttp3/ResponseBody:contentLength	()J
    //   337: lstore 7
    //   339: goto -285 -> 54
    //   342: aload 9
    //   344: ifnull +565 -> 909
    //   347: aload 9
    //   349: invokevirtual 709	okhttp3/ResponseBody:contentType	()Lokhttp3/MediaType;
    //   352: astore 9
    //   354: aload 9
    //   356: ifnull +553 -> 909
    //   359: aload 9
    //   361: invokevirtual 712	okhttp3/MediaType:toString	()Ljava/lang/String;
    //   364: astore 12
    //   366: aload 9
    //   368: invokevirtual 716	okhttp3/MediaType:charset	()Ljava/nio/charset/Charset;
    //   371: astore 13
    //   373: aload 12
    //   375: astore 9
    //   377: aload 11
    //   379: astore 10
    //   381: aload 13
    //   383: ifnull -248 -> 135
    //   386: aload_3
    //   387: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   390: aload 13
    //   392: invokevirtual 721	java/nio/charset/Charset:name	()Ljava/lang/String;
    //   395: putfield 673	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   398: aload 12
    //   400: astore 9
    //   402: aload 11
    //   404: astore 10
    //   406: goto -271 -> 135
    //   409: astore_1
    //   410: aload_1
    //   411: invokevirtual 724	java/lang/Throwable:printStackTrace	()V
    //   414: iconst_0
    //   415: ireturn
    //   416: iload 5
    //   418: iconst_1
    //   419: iadd
    //   420: istore 5
    //   422: goto -234 -> 188
    //   425: aload_0
    //   426: ldc2_w 136
    //   429: putfield 139	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   432: aload_3
    //   433: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   436: ldc2_w 136
    //   439: putfield 695	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   442: goto -169 -> 273
    //   445: astore 9
    //   447: aload 9
    //   449: invokevirtual 725	java/lang/Exception:printStackTrace	()V
    //   452: goto -149 -> 303
    //   455: aload_2
    //   456: ifnull -153 -> 303
    //   459: aload_2
    //   460: invokevirtual 728	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   463: astore 9
    //   465: aload 9
    //   467: ifnull +50 -> 517
    //   470: aload 9
    //   472: invokevirtual 731	okhttp3/Headers:size	()I
    //   475: istore 6
    //   477: iconst_0
    //   478: istore 5
    //   480: iload 5
    //   482: iload 6
    //   484: if_icmpge +33 -> 517
    //   487: ldc_w 679
    //   490: aload 9
    //   492: iload 5
    //   494: invokevirtual 733	okhttp3/Headers:name	(I)Ljava/lang/String;
    //   497: invokevirtual 683	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   500: ifeq +127 -> 627
    //   503: aload_3
    //   504: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   507: aload 9
    //   509: iload 5
    //   511: invokevirtual 736	okhttp3/Headers:value	(I)Ljava/lang/String;
    //   514: putfield 686	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   517: aload_2
    //   518: ldc_w 688
    //   521: invokevirtual 739	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   524: astore 9
    //   526: aload 9
    //   528: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   531: ifne +105 -> 636
    //   534: aload_0
    //   535: aload 9
    //   537: invokestatic 692	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   540: i2l
    //   541: putfield 139	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   544: aload_3
    //   545: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   548: aload_0
    //   549: getfield 139	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   552: putfield 695	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   555: aload_2
    //   556: ldc_w 697
    //   559: invokevirtual 552	okhttp3/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   562: astore 9
    //   564: aload 9
    //   566: ifnull -263 -> 303
    //   569: aload 9
    //   571: invokeinterface 233 1 0
    //   576: ifle -273 -> 303
    //   579: aload 9
    //   581: iconst_0
    //   582: invokeinterface 237 2 0
    //   587: checkcast 741	java/lang/CharSequence
    //   590: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   593: ifne -290 -> 303
    //   596: aload_3
    //   597: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   600: aload 9
    //   602: iconst_0
    //   603: invokeinterface 237 2 0
    //   608: checkcast 299	java/lang/String
    //   611: putfield 700	com/tencent/component/network/downloader/DownloadResult$Content:lastModified	Ljava/lang/String;
    //   614: goto -311 -> 303
    //   617: astore 9
    //   619: aload 9
    //   621: invokevirtual 725	java/lang/Exception:printStackTrace	()V
    //   624: goto -321 -> 303
    //   627: iload 5
    //   629: iconst_1
    //   630: iadd
    //   631: istore 5
    //   633: goto -153 -> 480
    //   636: aload_0
    //   637: ldc2_w 136
    //   640: putfield 139	com/tencent/component/network/downloader/impl/DownloadTask:mRealFileLength	J
    //   643: aload_3
    //   644: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   647: ldc2_w 136
    //   650: putfield 695	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   653: goto -98 -> 555
    //   656: aload_3
    //   657: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   660: iconst_0
    //   661: putfield 744	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   664: aload_1
    //   665: ifnull +79 -> 744
    //   668: aload_1
    //   669: ldc_w 746
    //   672: invokeinterface 750 2 0
    //   677: astore 9
    //   679: aload 9
    //   681: ifnull +51 -> 732
    //   684: aload 9
    //   686: invokeinterface 755 1 0
    //   691: ifeq +41 -> 732
    //   694: aload 9
    //   696: invokeinterface 758 1 0
    //   701: astore 10
    //   703: aload 10
    //   705: ifnull -21 -> 684
    //   708: ldc_w 760
    //   711: aload 10
    //   713: invokeinterface 540 1 0
    //   718: invokevirtual 683	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   721: ifeq -37 -> 684
    //   724: aload_3
    //   725: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   728: iconst_1
    //   729: putfield 744	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   732: aload 4
    //   734: invokeinterface 245 1 0
    //   739: ifeq +84 -> 823
    //   742: iconst_0
    //   743: ireturn
    //   744: aload_2
    //   745: ifnull -13 -> 732
    //   748: aload_2
    //   749: ldc_w 746
    //   752: invokevirtual 552	okhttp3/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   755: astore 9
    //   757: aload 9
    //   759: ifnull -27 -> 732
    //   762: aload 9
    //   764: invokeinterface 764 1 0
    //   769: astore 9
    //   771: aload 9
    //   773: invokeinterface 767 1 0
    //   778: ifeq -46 -> 732
    //   781: aload 9
    //   783: invokeinterface 771 1 0
    //   788: checkcast 299	java/lang/String
    //   791: astore 10
    //   793: aload 10
    //   795: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   798: ifeq -27 -> 771
    //   801: ldc_w 760
    //   804: aload 10
    //   806: invokevirtual 683	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   809: ifeq -38 -> 771
    //   812: aload_3
    //   813: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   816: iconst_1
    //   817: putfield 744	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   820: goto -88 -> 732
    //   823: aload_0
    //   824: aload_3
    //   825: aload_1
    //   826: aload_2
    //   827: invokespecial 772	com/tencent/component/network/downloader/impl/DownloadTask:handleContentType	(Lcom/tencent/component/network/downloader/DownloadResult;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Z
    //   830: ifne +13 -> 843
    //   833: aload_3
    //   834: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   837: iconst_5
    //   838: invokevirtual 776	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   841: iconst_0
    //   842: ireturn
    //   843: aload_0
    //   844: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   847: ifnull +50 -> 897
    //   850: aload_0
    //   851: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   854: aload_0
    //   855: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   858: aload_0
    //   859: getfield 517	com/tencent/component/network/downloader/impl/DownloadTask:mDomain	Ljava/lang/String;
    //   862: aload_1
    //   863: aload_2
    //   864: invokeinterface 784 5 0
    //   869: ifne +28 -> 897
    //   872: ldc_w 274
    //   875: ldc_w 786
    //   878: invokestatic 788	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   881: aload_0
    //   882: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   885: aload_0
    //   886: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   889: iconst_1
    //   890: invokeinterface 792 3 0
    //   895: iconst_0
    //   896: ireturn
    //   897: iconst_1
    //   898: ireturn
    //   899: astore 9
    //   901: goto -346 -> 555
    //   904: astore 9
    //   906: goto -633 -> 273
    //   909: aconst_null
    //   910: astore 9
    //   912: aload 11
    //   914: astore 10
    //   916: goto -781 -> 135
    //   919: aconst_null
    //   920: astore 10
    //   922: goto -787 -> 135
    //   925: lconst_0
    //   926: lstore 7
    //   928: goto -874 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	931	0	this	DownloadTask
    //   0	931	1	paramHttpResponse	HttpResponse
    //   0	931	2	paramResponse	Response
    //   0	931	3	paramDownloadResult	DownloadResult
    //   0	931	4	paramJobContext	ThreadPool.JobContext
    //   186	446	5	i	int
    //   183	302	6	j	int
    //   52	875	7	l	long
    //   38	363	9	localObject1	Object
    //   445	3	9	localException1	Exception
    //   463	138	9	localObject2	Object
    //   617	3	9	localException2	Exception
    //   677	105	9	localObject3	Object
    //   899	1	9	localThrowable1	Throwable
    //   904	1	9	localThrowable2	Throwable
    //   910	1	9	localObject4	Object
    //   28	893	10	localObject5	Object
    //   75	838	11	localHeader	Header
    //   72	327	12	str	String
    //   371	20	13	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   45	54	409	java/lang/Throwable
    //   54	71	409	java/lang/Throwable
    //   82	91	409	java/lang/Throwable
    //   100	109	409	java/lang/Throwable
    //   109	118	409	java/lang/Throwable
    //   123	132	409	java/lang/Throwable
    //   140	149	409	java/lang/Throwable
    //   154	163	409	java/lang/Throwable
    //   332	339	409	java/lang/Throwable
    //   347	354	409	java/lang/Throwable
    //   359	373	409	java/lang/Throwable
    //   386	398	409	java/lang/Throwable
    //   289	303	445	java/lang/Exception
    //   569	614	617	java/lang/Exception
    //   534	555	899	java/lang/Throwable
    //   247	273	904	java/lang/Throwable
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
    //   17: lstore 17
    //   19: iload 5
    //   21: sipush 206
    //   24: if_icmpne +244 -> 268
    //   27: aload_0
    //   28: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   31: ifnull +226 -> 257
    //   34: aload_0
    //   35: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   38: aload_0
    //   39: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   42: invokeinterface 798 2 0
    //   47: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +207 -> 257
    //   53: aload_3
    //   54: aload_0
    //   55: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   58: aload_0
    //   59: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   62: invokeinterface 798 2 0
    //   67: invokevirtual 801	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   70: iconst_1
    //   71: istore 24
    //   73: aconst_null
    //   74: astore 27
    //   76: getstatic 103	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   79: invokevirtual 804	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   82: astore 28
    //   84: lconst_0
    //   85: lstore 9
    //   87: aload_0
    //   88: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   91: lstore 19
    //   93: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   96: lstore 11
    //   98: iconst_0
    //   99: istore 25
    //   101: iconst_0
    //   102: istore 26
    //   104: new 426	java/io/File
    //   107: dup
    //   108: aload_3
    //   109: invokevirtual 806	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   112: invokespecial 456	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore 29
    //   117: aload 29
    //   119: iconst_0
    //   120: invokestatic 462	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:ensureFile	(Ljava/io/File;Z)Z
    //   123: pop
    //   124: aload 4
    //   126: invokeinterface 245 1 0
    //   131: istore 23
    //   133: iload 23
    //   135: ifeq +299 -> 434
    //   138: aload_0
    //   139: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   142: lload 17
    //   144: lsub
    //   145: putfield 173	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   148: iconst_0
    //   149: ifeq +11 -> 160
    //   152: new 808	java/lang/NullPointerException
    //   155: dup
    //   156: invokespecial 809	java/lang/NullPointerException:<init>	()V
    //   159: athrow
    //   160: iconst_0
    //   161: ifeq +11 -> 172
    //   164: new 808	java/lang/NullPointerException
    //   167: dup
    //   168: invokespecial 809	java/lang/NullPointerException:<init>	()V
    //   171: athrow
    //   172: getstatic 103	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   175: aload 28
    //   177: invokevirtual 813	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   180: aload_0
    //   181: getfield 815	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   184: ifnull +22 -> 206
    //   187: aload_0
    //   188: getfield 815	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   191: invokestatic 820	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   194: lconst_0
    //   195: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   198: lload 11
    //   200: lsub
    //   201: invokeinterface 826 6 0
    //   206: ldc_w 274
    //   209: new 276	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 828
    //   219: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_0
    //   223: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   226: invokevirtual 831	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   229: ldc_w 833
    //   232: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lconst_0
    //   236: invokevirtual 831	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: ldc_w 835
    //   242: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iconst_0
    //   246: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   249: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 295	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: iconst_0
    //   256: ireturn
    //   257: ldc_w 274
    //   260: ldc_w 840
    //   263: invokestatic 788	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: iconst_0
    //   267: ireturn
    //   268: aload_0
    //   269: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   272: ifnull +44 -> 316
    //   275: aload_0
    //   276: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   279: aload_0
    //   280: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   283: invokeinterface 798 2 0
    //   288: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +25 -> 316
    //   294: iload 5
    //   296: sipush 200
    //   299: if_icmpne +17 -> 316
    //   302: aload_0
    //   303: getfield 778	com/tencent/component/network/downloader/impl/DownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   306: aload_0
    //   307: getfield 195	com/tencent/component/network/downloader/impl/DownloadTask:mUrl	Ljava/lang/String;
    //   310: iconst_1
    //   311: invokeinterface 792 3 0
    //   316: aload_0
    //   317: invokevirtual 559	com/tencent/component/network/downloader/impl/DownloadTask:generateStorageName	()Ljava/lang/String;
    //   320: astore 28
    //   322: aload_0
    //   323: aload 28
    //   325: invokevirtual 561	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;)Ljava/lang/String;
    //   328: astore 27
    //   330: aload_0
    //   331: aload 28
    //   333: iconst_0
    //   334: invokevirtual 563	com/tencent/component/network/downloader/impl/DownloadTask:generateStoragePath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   337: astore 28
    //   339: aload_0
    //   340: aload 27
    //   342: aload_0
    //   343: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   346: invokevirtual 565	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   349: ifeq +15 -> 364
    //   352: aload_3
    //   353: aload 27
    //   355: invokevirtual 801	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   358: iconst_0
    //   359: istore 24
    //   361: goto -288 -> 73
    //   364: aload 27
    //   366: aload 28
    //   368: invokestatic 569	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   371: ifne +25 -> 396
    //   374: aload_0
    //   375: aload 28
    //   377: aload_0
    //   378: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   381: invokevirtual 565	com/tencent/component/network/downloader/impl/DownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   384: ifeq +12 -> 396
    //   387: aload_3
    //   388: aload 28
    //   390: invokevirtual 801	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   393: goto -35 -> 358
    //   396: aload_3
    //   397: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   400: iconst_2
    //   401: invokevirtual 776	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   404: iconst_0
    //   405: ireturn
    //   406: astore_1
    //   407: ldc_w 274
    //   410: ldc_w 842
    //   413: aload_1
    //   414: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   417: goto -257 -> 160
    //   420: astore_1
    //   421: ldc_w 274
    //   424: ldc_w 842
    //   427: aload_1
    //   428: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   431: goto -259 -> 172
    //   434: aload_0
    //   435: getfield 844	com/tencent/component/network/downloader/impl/DownloadTask:mNeedMd5	Z
    //   438: ifeq +1207 -> 1645
    //   441: aload_1
    //   442: ldc_w 846
    //   445: invokeinterface 535 2 0
    //   450: ifnull +13 -> 463
    //   453: aload_2
    //   454: ldc_w 846
    //   457: invokevirtual 552	okhttp3/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   460: ifnonnull +1185 -> 1645
    //   463: ldc_w 848
    //   466: invokestatic 854	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   469: astore 4
    //   471: aload_3
    //   472: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   475: iconst_0
    //   476: putfield 857	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   479: aload_1
    //   480: ifnull +407 -> 887
    //   483: aload_1
    //   484: invokeinterface 643 1 0
    //   489: ifnull +398 -> 887
    //   492: aload_1
    //   493: invokeinterface 643 1 0
    //   498: invokeinterface 667 1 0
    //   503: ifnull +366 -> 869
    //   506: aload_1
    //   507: invokeinterface 643 1 0
    //   512: invokeinterface 667 1 0
    //   517: invokeinterface 540 1 0
    //   522: ifnull +347 -> 869
    //   525: aload_1
    //   526: invokeinterface 643 1 0
    //   531: invokeinterface 667 1 0
    //   536: invokeinterface 540 1 0
    //   541: invokevirtual 860	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   544: ldc_w 862
    //   547: invokevirtual 865	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   550: iconst_m1
    //   551: if_icmple +318 -> 869
    //   554: new 867	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   557: dup
    //   558: aload_1
    //   559: invokeinterface 643 1 0
    //   564: invokeinterface 870 1 0
    //   569: invokespecial 873	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   572: astore_1
    //   573: iconst_1
    //   574: istore 23
    //   576: iconst_1
    //   577: istore 25
    //   579: aload_3
    //   580: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   583: iconst_1
    //   584: putfield 857	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   587: iload 25
    //   589: istore 23
    //   591: new 875	java/io/FileOutputStream
    //   594: dup
    //   595: aload 29
    //   597: iload 24
    //   599: invokespecial 878	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   602: astore_2
    //   603: aload 29
    //   605: invokevirtual 880	java/io/File:length	()J
    //   608: lstore 21
    //   610: iconst_0
    //   611: istore 5
    //   613: lconst_0
    //   614: lstore 13
    //   616: lconst_0
    //   617: lstore 9
    //   619: lload 11
    //   621: lstore 7
    //   623: lload 13
    //   625: lstore 11
    //   627: lload 9
    //   629: lstore 13
    //   631: aload_1
    //   632: aload 28
    //   634: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   637: iload 5
    //   639: sipush 8192
    //   642: iload 5
    //   644: isub
    //   645: invokevirtual 892	java/io/InputStream:read	([BII)I
    //   648: istore 6
    //   650: iload 6
    //   652: ifle +334 -> 986
    //   655: iload 6
    //   657: iload 5
    //   659: iadd
    //   660: sipush 8192
    //   663: if_icmpne +313 -> 976
    //   666: lload 9
    //   668: lstore 13
    //   670: aload_2
    //   671: aload 28
    //   673: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   676: iconst_0
    //   677: iload 6
    //   679: iload 5
    //   681: iadd
    //   682: invokevirtual 898	java/io/OutputStream:write	([BII)V
    //   685: lload 9
    //   687: lstore 13
    //   689: aload_0
    //   690: aload_0
    //   691: getfield 203	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   694: aload 29
    //   696: invokevirtual 899	java/io/File:getPath	()Ljava/lang/String;
    //   699: invokespecial 901	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: aload 4
    //   704: ifnull +23 -> 727
    //   707: lload 9
    //   709: lstore 13
    //   711: aload 4
    //   713: aload 28
    //   715: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   718: iconst_0
    //   719: iload 6
    //   721: iload 5
    //   723: iadd
    //   724: invokevirtual 904	java/security/MessageDigest:update	([BII)V
    //   727: lload 9
    //   729: lstore 13
    //   731: aload_0
    //   732: getfield 171	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   735: getfield 908	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   738: ifnull +39 -> 777
    //   741: lload 9
    //   743: lstore 13
    //   745: aload_0
    //   746: getfield 171	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   749: getfield 908	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   752: aload 28
    //   754: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   757: iconst_0
    //   758: iload 6
    //   760: iload 5
    //   762: iadd
    //   763: aload_0
    //   764: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   767: lload 21
    //   769: l2i
    //   770: iload 23
    //   772: invokeinterface 914 8 0
    //   777: lload 9
    //   779: iload 6
    //   781: iload 5
    //   783: iadd
    //   784: i2l
    //   785: ladd
    //   786: lstore 9
    //   788: iconst_0
    //   789: istore 5
    //   791: lload 11
    //   793: iload 6
    //   795: i2l
    //   796: ladd
    //   797: lstore 11
    //   799: aload_3
    //   800: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   803: lload 11
    //   805: putfield 916	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   808: lload 19
    //   810: lconst_0
    //   811: lcmp
    //   812: ifle +45 -> 857
    //   815: aload_1
    //   816: instanceof 867
    //   819: ifeq +819 -> 1638
    //   822: aload_1
    //   823: checkcast 867	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   826: invokevirtual 919	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:getRealReadLen	()J
    //   829: lstore 13
    //   831: aload_0
    //   832: aload_0
    //   833: getfield 203	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   836: lload 19
    //   838: lload 21
    //   840: ladd
    //   841: lload 13
    //   843: lload 21
    //   845: ladd
    //   846: l2f
    //   847: lload 19
    //   849: lload 21
    //   851: ladd
    //   852: l2f
    //   853: fdiv
    //   854: invokevirtual 923	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   857: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   860: lstore 13
    //   862: lload 13
    //   864: lstore 7
    //   866: goto -239 -> 627
    //   869: aload_1
    //   870: invokeinterface 643 1 0
    //   875: invokeinterface 870 1 0
    //   880: astore_1
    //   881: iconst_0
    //   882: istore 23
    //   884: goto -293 -> 591
    //   887: iload 26
    //   889: istore 23
    //   891: aload 27
    //   893: astore_1
    //   894: aload_2
    //   895: ifnull -304 -> 591
    //   898: iload 26
    //   900: istore 23
    //   902: aload 27
    //   904: astore_1
    //   905: aload_2
    //   906: invokevirtual 647	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   909: ifnull -318 -> 591
    //   912: aload_2
    //   913: ldc_w 925
    //   916: invokevirtual 739	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   919: astore_1
    //   920: aload_1
    //   921: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   924: ifne +38 -> 962
    //   927: aload_1
    //   928: invokevirtual 860	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   931: ldc_w 862
    //   934: invokevirtual 865	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   937: iconst_m1
    //   938: if_icmple +24 -> 962
    //   941: new 867	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream
    //   944: dup
    //   945: aload_2
    //   946: invokevirtual 647	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   949: invokevirtual 928	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   952: invokespecial 873	com/tencent/component/network/downloader/impl/strategy/ExGZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   955: astore_1
    //   956: iconst_1
    //   957: istore 23
    //   959: goto -368 -> 591
    //   962: aload_2
    //   963: invokevirtual 647	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   966: invokevirtual 928	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   969: astore_1
    //   970: iconst_0
    //   971: istore 23
    //   973: goto -382 -> 591
    //   976: iload 5
    //   978: iload 6
    //   980: iadd
    //   981: istore 5
    //   983: goto -192 -> 791
    //   986: lload 9
    //   988: lstore 15
    //   990: iload 6
    //   992: ifgt +122 -> 1114
    //   995: lload 9
    //   997: lstore 15
    //   999: iload 5
    //   1001: ifle +113 -> 1114
    //   1004: lload 9
    //   1006: lstore 13
    //   1008: aload_2
    //   1009: aload 28
    //   1011: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   1014: iconst_0
    //   1015: iload 5
    //   1017: invokevirtual 898	java/io/OutputStream:write	([BII)V
    //   1020: lload 9
    //   1022: lstore 13
    //   1024: aload_0
    //   1025: aload_0
    //   1026: getfield 203	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   1029: aload 29
    //   1031: invokevirtual 899	java/io/File:getPath	()Ljava/lang/String;
    //   1034: invokespecial 901	com/tencent/component/network/downloader/impl/DownloadTask:notifyStreamDownloadProgress	(Ljava/lang/String;Ljava/lang/String;)V
    //   1037: lload 9
    //   1039: lstore 13
    //   1041: aload_0
    //   1042: getfield 171	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   1045: getfield 908	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   1048: ifnull +36 -> 1084
    //   1051: lload 9
    //   1053: lstore 13
    //   1055: aload_0
    //   1056: getfield 171	com/tencent/component/network/downloader/impl/DownloadTask:pExtendParam	Lcom/tencent/component/network/downloader/impl/DownloadTask$ExtendParam;
    //   1059: getfield 908	com/tencent/component/network/downloader/impl/DownloadTask$ExtendParam:onResponseDataListener	Lcom/tencent/component/network/downloader/DownloadRequest$OnResponseDataListener;
    //   1062: aload 28
    //   1064: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   1067: iconst_0
    //   1068: iload 5
    //   1070: aload_0
    //   1071: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1074: lload 21
    //   1076: l2i
    //   1077: iload 23
    //   1079: invokeinterface 914 8 0
    //   1084: lload 9
    //   1086: iload 5
    //   1088: i2l
    //   1089: ladd
    //   1090: lstore 9
    //   1092: aload 4
    //   1094: ifnull +16 -> 1110
    //   1097: aload 4
    //   1099: aload 28
    //   1101: getfield 886	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   1104: iconst_0
    //   1105: iload 5
    //   1107: invokevirtual 904	java/security/MessageDigest:update	([BII)V
    //   1110: lload 9
    //   1112: lstore 15
    //   1114: lload 19
    //   1116: lconst_0
    //   1117: lcmp
    //   1118: ifgt +21 -> 1139
    //   1121: lload 15
    //   1123: lstore 13
    //   1125: aload_0
    //   1126: aload_0
    //   1127: getfield 203	com/tencent/component/network/downloader/impl/DownloadTask:mUrlKey	Ljava/lang/String;
    //   1130: lload 19
    //   1132: lload 21
    //   1134: ladd
    //   1135: fconst_1
    //   1136: invokevirtual 923	com/tencent/component/network/downloader/impl/DownloadTask:notifyDownloadProgress	(Ljava/lang/String;JF)V
    //   1139: lload 15
    //   1141: lstore 13
    //   1143: aload_3
    //   1144: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1147: lload 11
    //   1149: putfield 916	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1152: aload_0
    //   1153: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1156: lload 17
    //   1158: lsub
    //   1159: putfield 173	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   1162: aload_1
    //   1163: ifnull +7 -> 1170
    //   1166: aload_1
    //   1167: invokevirtual 931	java/io/InputStream:close	()V
    //   1170: aload_2
    //   1171: ifnull +7 -> 1178
    //   1174: aload_2
    //   1175: invokevirtual 932	java/io/OutputStream:close	()V
    //   1178: getstatic 103	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1181: aload 28
    //   1183: invokevirtual 813	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1186: aload_0
    //   1187: getfield 815	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1190: ifnull +23 -> 1213
    //   1193: aload_0
    //   1194: getfield 815	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1197: invokestatic 820	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1200: lload 11
    //   1202: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1205: lload 7
    //   1207: lsub
    //   1208: invokeinterface 826 6 0
    //   1213: aload 4
    //   1215: ifnull +91 -> 1306
    //   1218: aload 4
    //   1220: invokevirtual 936	java/security/MessageDigest:digest	()[B
    //   1223: astore_2
    //   1224: new 276	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1231: astore_1
    //   1232: iconst_0
    //   1233: istore 5
    //   1235: iload 5
    //   1237: aload_2
    //   1238: arraylength
    //   1239: if_icmpge +56 -> 1295
    //   1242: aload_1
    //   1243: aload_2
    //   1244: iload 5
    //   1246: baload
    //   1247: sipush 255
    //   1250: iand
    //   1251: invokestatic 939	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1254: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: iload 5
    //   1260: iconst_1
    //   1261: iadd
    //   1262: istore 5
    //   1264: goto -29 -> 1235
    //   1267: astore_1
    //   1268: ldc_w 274
    //   1271: ldc_w 842
    //   1274: aload_1
    //   1275: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1278: goto -108 -> 1170
    //   1281: astore_1
    //   1282: ldc_w 274
    //   1285: ldc_w 842
    //   1288: aload_1
    //   1289: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1292: goto -114 -> 1178
    //   1295: aload_3
    //   1296: invokevirtual 655	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1299: aload_1
    //   1300: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: putfield 942	com/tencent/component/network/downloader/DownloadResult$Content:md5	Ljava/lang/String;
    //   1306: ldc_w 274
    //   1309: new 276	java/lang/StringBuilder
    //   1312: dup
    //   1313: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1316: ldc_w 828
    //   1319: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: aload_0
    //   1323: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1326: invokevirtual 831	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1329: ldc_w 833
    //   1332: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: lload 15
    //   1337: invokevirtual 831	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1340: ldc_w 835
    //   1343: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: iload 23
    //   1348: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1351: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1354: invokestatic 295	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1357: iconst_1
    //   1358: ireturn
    //   1359: astore_3
    //   1360: aconst_null
    //   1361: astore_1
    //   1362: aconst_null
    //   1363: astore_2
    //   1364: lconst_0
    //   1365: lstore 7
    //   1367: iload 25
    //   1369: istore 23
    //   1371: aload_0
    //   1372: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1375: lload 17
    //   1377: lsub
    //   1378: putfield 173	com/tencent/component/network/downloader/impl/DownloadTask:t_recv_data	J
    //   1381: aload_2
    //   1382: ifnull +7 -> 1389
    //   1385: aload_2
    //   1386: invokevirtual 931	java/io/InputStream:close	()V
    //   1389: aload_1
    //   1390: ifnull +7 -> 1397
    //   1393: aload_1
    //   1394: invokevirtual 932	java/io/OutputStream:close	()V
    //   1397: getstatic 103	com/tencent/component/network/downloader/impl/DownloadTask:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1400: aload 28
    //   1402: invokevirtual 813	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1405: aload_0
    //   1406: getfield 815	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1409: ifnull +23 -> 1432
    //   1412: aload_0
    //   1413: getfield 815	com/tencent/component/network/downloader/impl/DownloadTask:mNetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1416: invokestatic 820	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1419: lload 9
    //   1421: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1424: lload 11
    //   1426: lsub
    //   1427: invokeinterface 826 6 0
    //   1432: ldc_w 274
    //   1435: new 276	java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1442: ldc_w 828
    //   1445: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: aload_0
    //   1449: getfield 513	com/tencent/component/network/downloader/impl/DownloadTask:mContentLength	J
    //   1452: invokevirtual 831	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1455: ldc_w 833
    //   1458: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: lload 7
    //   1463: invokevirtual 831	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1466: ldc_w 835
    //   1469: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: iload 23
    //   1474: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1477: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1480: invokestatic 295	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1483: aload_3
    //   1484: athrow
    //   1485: astore_2
    //   1486: ldc_w 274
    //   1489: ldc_w 842
    //   1492: aload_2
    //   1493: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1496: goto -107 -> 1389
    //   1499: astore_1
    //   1500: ldc_w 274
    //   1503: ldc_w 842
    //   1506: aload_1
    //   1507: invokestatic 388	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1510: goto -113 -> 1397
    //   1513: astore_3
    //   1514: lconst_0
    //   1515: lstore 7
    //   1517: aconst_null
    //   1518: astore 4
    //   1520: aload_1
    //   1521: astore_2
    //   1522: aload 4
    //   1524: astore_1
    //   1525: goto -154 -> 1371
    //   1528: astore_3
    //   1529: aconst_null
    //   1530: astore 4
    //   1532: aload_1
    //   1533: astore_2
    //   1534: lconst_0
    //   1535: lstore 7
    //   1537: aload 4
    //   1539: astore_1
    //   1540: goto -169 -> 1371
    //   1543: astore_3
    //   1544: aload_1
    //   1545: astore 4
    //   1547: aload_2
    //   1548: astore_1
    //   1549: lconst_0
    //   1550: lstore 7
    //   1552: aload 4
    //   1554: astore_2
    //   1555: goto -184 -> 1371
    //   1558: astore_3
    //   1559: lload 11
    //   1561: lstore 9
    //   1563: aload_1
    //   1564: astore 4
    //   1566: aload_2
    //   1567: astore_1
    //   1568: aload 4
    //   1570: astore_2
    //   1571: lload 7
    //   1573: lstore 11
    //   1575: lload 13
    //   1577: lstore 7
    //   1579: goto -208 -> 1371
    //   1582: astore_3
    //   1583: aload_1
    //   1584: astore 4
    //   1586: aload_2
    //   1587: astore_1
    //   1588: lload 9
    //   1590: lstore 13
    //   1592: lload 11
    //   1594: lstore 9
    //   1596: aload 4
    //   1598: astore_2
    //   1599: lload 7
    //   1601: lstore 11
    //   1603: lload 13
    //   1605: lstore 7
    //   1607: goto -236 -> 1371
    //   1610: astore_3
    //   1611: lload 7
    //   1613: lstore 13
    //   1615: aload_1
    //   1616: astore 4
    //   1618: aload_2
    //   1619: astore_1
    //   1620: lload 9
    //   1622: lstore 7
    //   1624: lload 11
    //   1626: lstore 9
    //   1628: aload 4
    //   1630: astore_2
    //   1631: lload 13
    //   1633: lstore 11
    //   1635: goto -264 -> 1371
    //   1638: lload 11
    //   1640: lstore 13
    //   1642: goto -811 -> 831
    //   1645: aconst_null
    //   1646: astore 4
    //   1648: goto -1177 -> 471
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1651	0	this	DownloadTask
    //   0	1651	1	paramHttpResponse	HttpResponse
    //   0	1651	2	paramResponse	Response
    //   0	1651	3	paramDownloadResult	DownloadResult
    //   0	1651	4	paramJobContext	ThreadPool.JobContext
    //   0	1651	5	paramInt	int
    //   648	343	6	i	int
    //   621	1002	7	l1	long
    //   85	1542	9	l2	long
    //   96	1543	11	l3	long
    //   614	1027	13	l4	long
    //   988	348	15	l5	long
    //   17	1359	17	l6	long
    //   91	1040	19	l7	long
    //   608	525	21	l8	long
    //   131	1342	23	bool1	boolean
    //   71	527	24	bool2	boolean
    //   99	1269	25	bool3	boolean
    //   102	797	26	bool4	boolean
    //   74	829	27	str	String
    //   82	1319	28	localObject	Object
    //   115	915	29	localFile	File
    // Exception table:
    //   from	to	target	type
    //   152	160	406	java/lang/Throwable
    //   164	172	420	java/lang/Throwable
    //   1166	1170	1267	java/lang/Throwable
    //   1174	1178	1281	java/lang/Throwable
    //   104	133	1359	finally
    //   434	463	1359	finally
    //   463	471	1359	finally
    //   471	479	1359	finally
    //   483	573	1359	finally
    //   869	881	1359	finally
    //   905	956	1359	finally
    //   962	970	1359	finally
    //   1385	1389	1485	java/lang/Throwable
    //   1393	1397	1499	java/lang/Throwable
    //   579	587	1513	finally
    //   591	603	1528	finally
    //   603	610	1543	finally
    //   631	650	1558	finally
    //   670	685	1558	finally
    //   689	702	1558	finally
    //   711	727	1558	finally
    //   731	741	1558	finally
    //   745	777	1558	finally
    //   1008	1020	1558	finally
    //   1024	1037	1558	finally
    //   1041	1051	1558	finally
    //   1055	1084	1558	finally
    //   1125	1139	1558	finally
    //   1143	1152	1558	finally
    //   799	808	1582	finally
    //   815	831	1582	finally
    //   831	857	1582	finally
    //   857	862	1582	finally
    //   1097	1110	1610	finally
  }
  
  protected void headerCallback(Response paramResponse)
  {
    if (paramResponse == null) {}
    int i;
    do
    {
      return;
      i = paramResponse.code();
      paramResponse = paramResponse.headers().toMultimap();
    } while (this.mDownloadTaskHandler == null);
    this.mDownloadTaskHandler.handleRequestHeader(this.mUrlKey, i, paramResponse);
  }
  
  protected void headerCallback(HttpResponse paramHttpResponse)
  {
    if ((paramHttpResponse == null) || (paramHttpResponse.headerIterator() == null)) {}
    HashMap localHashMap;
    int i;
    do
    {
      return;
      localHashMap = new HashMap();
      HeaderIterator localHeaderIterator = paramHttpResponse.headerIterator();
      while (localHeaderIterator.hasNext())
      {
        Header localHeader = localHeaderIterator.nextHeader();
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(localHeader.getValue());
        localHashMap.put(localHeader.getName(), localArrayList);
      }
      i = paramHttpResponse.getStatusLine().getStatusCode();
    } while (this.mDownloadTaskHandler == null);
    this.mDownloadTaskHandler.handleRequestHeader(this.mUrlKey, i, localHashMap);
  }
  
  protected void initTask()
  {
    if (this.mDomain == null) {
      this.mDomain = Utils.getDomin(this.mUrl);
    }
  }
  
  protected void notifyDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.mDownloadTaskHandler == null) {}
    while (paramFloat - this.mLastCallbackProgress < this.mProgressCallbackStep) {
      return;
    }
    this.mLastCallbackProgress = paramFloat;
    this.mDownloadTaskHandler.handleDownloadProgress(paramString, paramLong, paramFloat);
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
  
  public void setProgressCallbackStep(float paramFloat)
  {
    this.mProgressCallbackStep = paramFloat;
  }
  
  public void setResponseDataListener(DownloadRequest.OnResponseDataListener paramOnResponseDataListener)
  {
    this.pExtendParam.onResponseDataListener = paramOnResponseDataListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask
 * JD-Core Version:    0.7.0.1
 */