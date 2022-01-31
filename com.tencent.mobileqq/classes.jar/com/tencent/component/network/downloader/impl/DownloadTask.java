package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.Build;
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
import pjo;
import pjp;

public abstract class DownloadTask
  implements NetworkManager.NetStatusListener, ThreadPool.Job
{
  private static final BytesBufferPool jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool = new BytesBufferPool(4, 8192);
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  protected static final ThreadLocal a;
  protected static ConcurrentHashMap a;
  private static volatile long jdField_d_of_type_Long = System.currentTimeMillis();
  private static volatile int e = 0;
  protected int a;
  protected long a;
  protected final Context a;
  protected Call a;
  protected Request.Builder a;
  private Downloader.NetworkFlowStatistics jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics;
  private ReportHandler jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler;
  protected DownloadTask.DownloadTaskHandler a;
  protected DownloadGlobalStrategy.StrategyInfo a;
  protected DownloadGlobalStrategy.StrategyLib a;
  protected IPStrategy a;
  protected PortConfigStrategy a;
  protected ResumeTransfer a;
  private FileCacheService jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService;
  protected QZoneHttp2Client a;
  protected QZoneHttpClient a;
  private PriorityThreadPool.Priority jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool$Priority;
  private final String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap;
  protected HttpGet a;
  protected boolean a;
  protected int b;
  protected long b;
  private ReportHandler jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler;
  protected DownloadGlobalStrategy.StrategyInfo b;
  protected IPStrategy b;
  private final String jdField_b_of_type_JavaLangString;
  protected boolean b;
  protected int c;
  protected long c;
  private String c;
  public boolean c;
  protected int d;
  private boolean jdField_d_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaLangThreadLocal = new pjo();
  }
  
  public DownloadTask(Context paramContext, QZoneHttp2Client paramQZoneHttp2Client, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib = null;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = null;
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet = null;
    this.jdField_a_of_type_ComSquareupOkhttpRequest$Builder = null;
    this.jdField_a_of_type_ComSquareupOkhttpCall = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 80;
    this.jdField_d_of_type_Int = 0;
    AssertUtil.a(Utils.checkUrl(paramString1));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttp2Client = paramQZoneHttp2Client;
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient = paramQZoneHttpClient;
      if (!paramBoolean1) {
        break label160;
      }
    }
    label160:
    for (paramContext = PriorityThreadPool.Priority.HIGH;; paramContext = PriorityThreadPool.Priority.NORMAL)
    {
      a(paramContext);
      this.jdField_b_of_type_Boolean = paramBoolean2;
      this.jdField_c_of_type_Boolean = paramBoolean2;
      return;
      paramString2 = paramString1;
      break;
    }
  }
  
  public static int a()
  {
    return e;
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(paramString, paramBoolean);
  }
  
  private void a(PriorityThreadPool.Priority paramPriority)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool$Priority = paramPriority;
  }
  
  private void a(ThreadPool.JobContext paramJobContext)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ReportHandler.DownloadReportObject localDownloadReportObject = (ReportHandler.DownloadReportObject)localIterator.next();
        if ((localDownloadReportObject != null) && (((this.jdField_a_of_type_Boolean) && (!paramJobContext.isCancelled())) || ((localDownloadReportObject.retCode == 0) && (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler != null)))) {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler.uploadReport(localDownloadReportObject);
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.handleDownloadProgress(paramString, paramLong, paramFloat);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.handleStreamDownloadProgress(paramString1, paramString2);
  }
  
  private boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler == null) {
      return true;
    }
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.handleContentType(paramDownloadResult, paramHttpResponse, paramResponse);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new File(paramString);
        if (!pjp.a(paramString, true)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(paramString.getName());
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
  
  private String b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(paramString);
  }
  
  private void b(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult)
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
        } while ((paramDownloadResult != null) && (paramDownloadResult.contains("Permission denied")) && (b()));
      }
    }
    for (;;)
    {
      a(paramJobContext);
      return;
      if (404 == paramDownloadResult.getStatus().httpStatus)
      {
        paramDownloadResult = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
        if (paramDownloadResult != null) {
          break;
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
        QDLog.b("downloader", "save 404 url at first time.");
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramDownloadResult.intValue() + 1));
    QDLog.b("downloader", "save 404 url " + (paramDownloadResult.intValue() + 1));
  }
  
  private boolean b()
  {
    String str1 = Build.BRAND;
    String str2 = Build.MODEL;
    QDLog.b("downloader", "brand:" + str1 + " model:" + str2);
    return (str2 != null) && (str2.startsWith("MI"));
  }
  
  private String d()
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler != null) {}
    for (String str1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.generateStorageFileName(this.jdField_a_of_type_JavaLangString);; str1 = null)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        str2 = UUID.randomUUID().toString();
      }
      return str2;
    }
    return String.valueOf(this.jdField_a_of_type_JavaLangString.hashCode());
  }
  
  protected int a(HttpResponse paramHttpResponse, Response paramResponse)
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
  
  protected long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public final DownloadResult a(ThreadPool.JobContext paramJobContext)
  {
    String str = null;
    DownloadResult localDownloadResult = new DownloadResult(this.jdField_a_of_type_JavaLangString);
    if (paramJobContext.isCancelled())
    {
      a(paramJobContext, localDownloadResult, null);
      return localDownloadResult;
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler != null) {
      str = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.findCacheEntryPath(this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(str))
    {
      if (QDLog.b()) {
        QDLog.b("downloader", "find cache entry:" + str + " url:" + this.jdField_a_of_type_JavaLangString);
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
        a();
        NetworkManager.registNetStatusListener(this);
        a(paramJobContext, localDownloadResult);
        if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          this.jdField_a_of_type_Boolean = false;
          localDownloadResult.getStatus().setFailed(6);
        }
        b(paramJobContext, localDownloadResult);
        c();
        if (!localDownloadResult.getStatus().isSucceed()) {
          continue;
        }
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a = localDownloadResult;
        DownloadGlobalStrategy.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo, localDownloadResult.getStatus().isSucceed());
        if (localDownloadResult.getStatus().isSucceed()) {
          SpeedStatistics.a().a(localDownloadResult.getContent().size, localDownloadResult.getProcess().jdField_a_of_type_Long, localDownloadResult.getProcess().jdField_b_of_type_Long);
        }
      }
      catch (Throwable paramJobContext)
      {
        QDLog.d("downloader", "exception when execute DownloadTask. ", paramJobContext);
        NetworkManager.unregistNetStatusListener(this);
        continue;
      }
      finally
      {
        NetworkManager.unregistNetStatusListener(this);
      }
      return localDownloadResult;
      if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib != null) && (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a() != null))
      {
        this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a().a = localDownloadResult;
        DownloadGlobalStrategy.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(), localDownloadResult.getStatus().isSucceed());
      }
    }
  }
  
  public PriorityThreadPool.Priority a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadPriorityThreadPool$Priority;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.startsWith("https:"))
      {
        str = paramString;
        if (this.jdField_b_of_type_Boolean) {
          str = paramString.replace("http:", "https:");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler == null) {}
    do
    {
      return str;
      paramString = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.prepareRequestUrl(str);
    } while (TextUtils.isEmpty(paramString));
    return paramString;
  }
  
  protected String a(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, Response paramResponse)
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
  
  protected void a()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = Utils.getDomin(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public void a(DownloadTask.DownloadTaskHandler paramDownloadTaskHandler, IPStrategy paramIPStrategy1, IPStrategy paramIPStrategy2, PortConfigStrategy paramPortConfigStrategy, ResumeTransfer paramResumeTransfer, ReportHandler paramReportHandler1, ReportHandler paramReportHandler2, Downloader.NetworkFlowStatistics paramNetworkFlowStatistics, FileCacheService paramFileCacheService)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler = paramDownloadTaskHandler;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer = paramResumeTransfer;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler = paramReportHandler1;
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler = paramReportHandler2;
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService = paramFileCacheService;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics = paramNetworkFlowStatistics;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy = paramIPStrategy1;
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy = paramIPStrategy2;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy = paramPortConfigStrategy;
  }
  
  public abstract void a(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult);
  
  protected void a(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler != null)
    {
      if (paramJobContext.isCancelled()) {
        paramDownloadResult.getStatus().state = 4;
      }
      this.jdField_b_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler.handleReport(paramDownloadResult, paramDownloadReport);
    }
    if (paramJobContext.isCancelled()) {}
    int j;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler != null)
      {
        paramJobContext = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderHandlerReportHandler.obtainReportObj(paramDownloadResult, paramDownloadReport);
        this.jdField_a_of_type_JavaUtilList.add(paramJobContext);
      }
      j = 0;
    } while ((paramDownloadReport.isSucceed) || (paramDownloadReport.exception == null) || (paramDownloadResult == null));
    int i;
    if (paramDownloadReport.isFromQzoneAlbum) {
      if (this.jdField_c_of_type_Boolean) {
        i = 1;
      }
    }
    for (;;)
    {
      Config.a(i, paramDownloadReport.isHttp2, paramDownloadReport.url, paramDownloadResult.getStatus().exception2Code, Log.getStackTraceString(paramDownloadReport.exception));
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
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  protected void a(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilMap != null) && ((paramBuilder != null) || (paramHttpRequest != null)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
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
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.handlePrepareRequest(paramString1, paramString2, paramHttpRequest, paramBuilder, b());
  }
  
  protected void a(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, HttpUtil.RequestOptions paramRequestOptions)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.handleKeepAliveStrategy(paramString1, paramString2, paramHttpRequest, paramBuilder, paramRequestOptions);
  }
  
  public void a(Map paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  protected boolean a()
  {
    int i = this.jdField_b_of_type_Int + 1;
    this.jdField_b_of_type_Int = i;
    return i < this.jdField_a_of_type_Int;
  }
  
  /* Error */
  protected boolean a(HttpResponse paramHttpResponse, Response paramResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +296 -> 297
    //   4: aload_1
    //   5: invokeinterface 670 1 0
    //   10: astore 10
    //   12: aload_2
    //   13: ifnull +290 -> 303
    //   16: aload_2
    //   17: invokevirtual 674	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   20: astore 9
    //   22: aload 10
    //   24: ifnull +285 -> 309
    //   27: aload 10
    //   29: invokeinterface 679 1 0
    //   34: lstore 7
    //   36: aload_0
    //   37: lload 7
    //   39: putfield 401	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_Long	J
    //   42: aload_3
    //   43: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   46: aload_0
    //   47: getfield 401	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_Long	J
    //   50: putfield 682	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   53: aconst_null
    //   54: astore 12
    //   56: aconst_null
    //   57: astore 11
    //   59: aload 10
    //   61: ifnull +263 -> 324
    //   64: aload 10
    //   66: invokeinterface 686 1 0
    //   71: astore 11
    //   73: aload 12
    //   75: astore 9
    //   77: aload 11
    //   79: ifnull +12 -> 91
    //   82: aload 11
    //   84: invokeinterface 381 1 0
    //   89: astore 9
    //   91: aload 10
    //   93: invokeinterface 689 1 0
    //   98: astore 10
    //   100: aload 10
    //   102: ifnull +799 -> 901
    //   105: aload 10
    //   107: invokeinterface 381 1 0
    //   112: astore 10
    //   114: goto +790 -> 904
    //   117: aload 9
    //   119: ifnull +12 -> 131
    //   122: aload_3
    //   123: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   126: aload 9
    //   128: putfield 692	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   131: aload 10
    //   133: ifnull +12 -> 145
    //   136: aload_3
    //   137: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   140: aload 10
    //   142: putfield 695	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   145: aload_1
    //   146: ifnull +291 -> 437
    //   149: aload_1
    //   150: invokeinterface 539 1 0
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
    //   177: ldc_w 697
    //   180: aload 9
    //   182: iload 5
    //   184: aaload
    //   185: invokeinterface 540 1 0
    //   190: invokevirtual 700	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   193: ifeq +205 -> 398
    //   196: aload_3
    //   197: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   200: aload 9
    //   202: iload 5
    //   204: aaload
    //   205: invokeinterface 381 1 0
    //   210: putfield 703	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   213: aload_1
    //   214: ldc_w 705
    //   217: invokeinterface 376 2 0
    //   222: astore 9
    //   224: aload 9
    //   226: ifnull +181 -> 407
    //   229: aload_0
    //   230: aload 9
    //   232: invokeinterface 381 1 0
    //   237: invokestatic 709	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   240: i2l
    //   241: putfield 83	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_Long	J
    //   244: aload_3
    //   245: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   248: aload_0
    //   249: getfield 83	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_Long	J
    //   252: putfield 712	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   255: aload_1
    //   256: ldc_w 714
    //   259: invokeinterface 376 2 0
    //   264: astore 9
    //   266: aload 9
    //   268: ifnull +17 -> 285
    //   271: aload_3
    //   272: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   275: aload 9
    //   277: invokeinterface 381 1 0
    //   282: putfield 717	com/tencent/component/network/downloader/DownloadResult$Content:lastModified	Ljava/lang/String;
    //   285: aload 4
    //   287: invokeinterface 186 1 0
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
    //   316: invokevirtual 722	com/squareup/okhttp/ResponseBody:contentLength	()J
    //   319: lstore 7
    //   321: goto -285 -> 36
    //   324: aload 9
    //   326: ifnull +565 -> 891
    //   329: aload 9
    //   331: invokevirtual 726	com/squareup/okhttp/ResponseBody:contentType	()Lcom/squareup/okhttp/MediaType;
    //   334: astore 9
    //   336: aload 9
    //   338: ifnull +553 -> 891
    //   341: aload 9
    //   343: invokevirtual 729	com/squareup/okhttp/MediaType:toString	()Ljava/lang/String;
    //   346: astore 12
    //   348: aload 9
    //   350: invokevirtual 733	com/squareup/okhttp/MediaType:charset	()Ljava/nio/charset/Charset;
    //   353: astore 13
    //   355: aload 12
    //   357: astore 9
    //   359: aload 11
    //   361: astore 10
    //   363: aload 13
    //   365: ifnull -248 -> 117
    //   368: aload_3
    //   369: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   372: aload 13
    //   374: invokevirtual 737	java/nio/charset/Charset:name	()Ljava/lang/String;
    //   377: putfield 695	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   380: aload 12
    //   382: astore 9
    //   384: aload 11
    //   386: astore 10
    //   388: goto -271 -> 117
    //   391: astore_1
    //   392: aload_1
    //   393: invokevirtual 740	java/io/IOException:printStackTrace	()V
    //   396: iconst_0
    //   397: ireturn
    //   398: iload 5
    //   400: iconst_1
    //   401: iadd
    //   402: istore 5
    //   404: goto -234 -> 170
    //   407: aload_0
    //   408: ldc2_w 80
    //   411: putfield 83	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_Long	J
    //   414: aload_3
    //   415: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   418: ldc2_w 80
    //   421: putfield 712	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   424: goto -169 -> 255
    //   427: astore 9
    //   429: aload 9
    //   431: invokevirtual 741	java/lang/Exception:printStackTrace	()V
    //   434: goto -149 -> 285
    //   437: aload_2
    //   438: ifnull -153 -> 285
    //   441: aload_2
    //   442: invokevirtual 551	com/squareup/okhttp/Response:headers	()Lcom/squareup/okhttp/Headers;
    //   445: astore 9
    //   447: aload 9
    //   449: ifnull +50 -> 499
    //   452: aload 9
    //   454: invokevirtual 554	com/squareup/okhttp/Headers:size	()I
    //   457: istore 6
    //   459: iconst_0
    //   460: istore 5
    //   462: iload 5
    //   464: iload 6
    //   466: if_icmpge +33 -> 499
    //   469: ldc_w 697
    //   472: aload 9
    //   474: iload 5
    //   476: invokevirtual 557	com/squareup/okhttp/Headers:name	(I)Ljava/lang/String;
    //   479: invokevirtual 700	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   482: ifeq +127 -> 609
    //   485: aload_3
    //   486: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   489: aload 9
    //   491: iload 5
    //   493: invokevirtual 560	com/squareup/okhttp/Headers:value	(I)Ljava/lang/String;
    //   496: putfield 703	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   499: aload_2
    //   500: ldc_w 705
    //   503: invokevirtual 743	com/squareup/okhttp/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   506: astore 9
    //   508: aload 9
    //   510: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   513: ifne +105 -> 618
    //   516: aload_0
    //   517: aload 9
    //   519: invokestatic 709	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   522: i2l
    //   523: putfield 83	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_Long	J
    //   526: aload_3
    //   527: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   530: aload_0
    //   531: getfield 83	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_Long	J
    //   534: putfield 712	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   537: aload_2
    //   538: ldc_w 714
    //   541: invokevirtual 393	com/squareup/okhttp/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   544: astore 9
    //   546: aload 9
    //   548: ifnull -263 -> 285
    //   551: aload 9
    //   553: invokeinterface 396 1 0
    //   558: ifle -273 -> 285
    //   561: aload 9
    //   563: iconst_0
    //   564: invokeinterface 399 2 0
    //   569: checkcast 745	java/lang/CharSequence
    //   572: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: ifne -290 -> 285
    //   578: aload_3
    //   579: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   582: aload 9
    //   584: iconst_0
    //   585: invokeinterface 399 2 0
    //   590: checkcast 278	java/lang/String
    //   593: putfield 717	com/tencent/component/network/downloader/DownloadResult$Content:lastModified	Ljava/lang/String;
    //   596: goto -311 -> 285
    //   599: astore 9
    //   601: aload 9
    //   603: invokevirtual 741	java/lang/Exception:printStackTrace	()V
    //   606: goto -321 -> 285
    //   609: iload 5
    //   611: iconst_1
    //   612: iadd
    //   613: istore 5
    //   615: goto -153 -> 462
    //   618: aload_0
    //   619: ldc2_w 80
    //   622: putfield 83	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_Long	J
    //   625: aload_3
    //   626: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   629: ldc2_w 80
    //   632: putfield 712	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   635: goto -98 -> 537
    //   638: aload_3
    //   639: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   642: iconst_0
    //   643: putfield 748	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   646: aload_1
    //   647: ifnull +79 -> 726
    //   650: aload_1
    //   651: ldc_w 750
    //   654: invokeinterface 754 2 0
    //   659: astore 9
    //   661: aload 9
    //   663: ifnull +51 -> 714
    //   666: aload 9
    //   668: invokeinterface 757 1 0
    //   673: ifeq +41 -> 714
    //   676: aload 9
    //   678: invokeinterface 760 1 0
    //   683: astore 10
    //   685: aload 10
    //   687: ifnull -21 -> 666
    //   690: ldc_w 762
    //   693: aload 10
    //   695: invokeinterface 381 1 0
    //   700: invokevirtual 700	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   703: ifeq -37 -> 666
    //   706: aload_3
    //   707: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   710: iconst_1
    //   711: putfield 748	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   714: aload 4
    //   716: invokeinterface 186 1 0
    //   721: ifeq +84 -> 805
    //   724: iconst_0
    //   725: ireturn
    //   726: aload_2
    //   727: ifnull -13 -> 714
    //   730: aload_2
    //   731: ldc_w 750
    //   734: invokevirtual 393	com/squareup/okhttp/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   737: astore 9
    //   739: aload 9
    //   741: ifnull -27 -> 714
    //   744: aload 9
    //   746: invokeinterface 169 1 0
    //   751: astore 9
    //   753: aload 9
    //   755: invokeinterface 175 1 0
    //   760: ifeq -46 -> 714
    //   763: aload 9
    //   765: invokeinterface 179 1 0
    //   770: checkcast 278	java/lang/String
    //   773: astore 10
    //   775: aload 10
    //   777: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   780: ifeq -27 -> 753
    //   783: ldc_w 762
    //   786: aload 10
    //   788: invokevirtual 700	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   791: ifeq -38 -> 753
    //   794: aload_3
    //   795: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   798: iconst_1
    //   799: putfield 748	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   802: goto -88 -> 714
    //   805: aload_0
    //   806: aload_3
    //   807: aload_1
    //   808: aload_2
    //   809: invokespecial 764	com/tencent/component/network/downloader/impl/DownloadTask:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Z
    //   812: ifne +13 -> 825
    //   815: aload_3
    //   816: invokevirtual 259	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   819: iconst_5
    //   820: invokevirtual 446	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   823: iconst_0
    //   824: ireturn
    //   825: aload_0
    //   826: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   829: ifnull +50 -> 879
    //   832: aload_0
    //   833: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   836: aload_0
    //   837: getfield 123	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   840: aload_0
    //   841: getfield 465	com/tencent/component/network/downloader/impl/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   844: aload_1
    //   845: aload_2
    //   846: invokeinterface 769 5 0
    //   851: ifne +28 -> 879
    //   854: ldc_w 308
    //   857: ldc_w 771
    //   860: invokestatic 773	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   863: aload_0
    //   864: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   867: aload_0
    //   868: getfield 123	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   871: iconst_1
    //   872: invokeinterface 776 3 0
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
  protected boolean a(HttpResponse paramHttpResponse, Response paramResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: aload 4
    //   6: invokevirtual 779	com/tencent/component/network/downloader/impl/DownloadTask:a	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;)Z
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   17: lstore 19
    //   19: iload 5
    //   21: sipush 206
    //   24: if_icmpne +218 -> 242
    //   27: aload_0
    //   28: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   31: ifnull +200 -> 231
    //   34: aload_0
    //   35: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   38: aload_0
    //   39: getfield 123	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: invokeinterface 780 2 0
    //   47: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +181 -> 231
    //   53: aload_3
    //   54: aload_0
    //   55: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   58: aload_0
    //   59: getfield 123	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokeinterface 780 2 0
    //   67: invokevirtual 419	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   70: iconst_1
    //   71: istore 25
    //   73: getstatic 49	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   76: invokevirtual 783	com/tencent/component/network/utils/BytesBufferPool:a	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   79: astore 27
    //   81: lconst_0
    //   82: lstore 15
    //   84: aload_0
    //   85: getfield 401	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_Long	J
    //   88: lstore 21
    //   90: lconst_0
    //   91: lstore 7
    //   93: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   96: lstore 11
    //   98: new 216	java/io/File
    //   101: dup
    //   102: aload_3
    //   103: invokevirtual 786	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   106: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 28
    //   111: aload 28
    //   113: iconst_0
    //   114: invokestatic 224	pjp:a	(Ljava/io/File;Z)Z
    //   117: pop
    //   118: aload 4
    //   120: invokeinterface 186 1 0
    //   125: istore 26
    //   127: iload 26
    //   129: ifeq +251 -> 380
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 788	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 789	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: iconst_0
    //   145: ifeq +11 -> 156
    //   148: new 788	java/lang/NullPointerException
    //   151: dup
    //   152: invokespecial 789	java/lang/NullPointerException:<init>	()V
    //   155: athrow
    //   156: getstatic 49	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   159: aload 27
    //   161: invokevirtual 792	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   164: aload_0
    //   165: getfield 573	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   168: ifnull +22 -> 190
    //   171: aload_0
    //   172: getfield 573	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   175: invokestatic 795	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   178: lconst_0
    //   179: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   182: lload 11
    //   184: lsub
    //   185: invokeinterface 800 6 0
    //   190: ldc_w 308
    //   193: new 319	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 802
    //   203: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield 401	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_Long	J
    //   210: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: ldc_w 807
    //   216: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: lconst_0
    //   220: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 314	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iconst_0
    //   230: ireturn
    //   231: ldc_w 308
    //   234: ldc_w 809
    //   237: invokestatic 773	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: iconst_0
    //   241: ireturn
    //   242: aload_0
    //   243: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   246: ifnull +44 -> 290
    //   249: aload_0
    //   250: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   253: aload_0
    //   254: getfield 123	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   257: invokeinterface 780 2 0
    //   262: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifne +25 -> 290
    //   268: iload 5
    //   270: sipush 200
    //   273: if_icmpne +17 -> 290
    //   276: aload_0
    //   277: getfield 569	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   280: aload_0
    //   281: getfield 123	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   284: iconst_1
    //   285: invokeinterface 776 3 0
    //   290: aload_0
    //   291: invokespecial 811	com/tencent/component/network/downloader/impl/DownloadTask:d	()Ljava/lang/String;
    //   294: astore 28
    //   296: aload_0
    //   297: aload 28
    //   299: invokespecial 813	com/tencent/component/network/downloader/impl/DownloadTask:b	(Ljava/lang/String;)Ljava/lang/String;
    //   302: astore 27
    //   304: aload_0
    //   305: aload 28
    //   307: iconst_0
    //   308: invokespecial 814	com/tencent/component/network/downloader/impl/DownloadTask:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   311: astore 28
    //   313: aload_0
    //   314: aload 27
    //   316: aload_0
    //   317: getfield 401	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_Long	J
    //   320: invokespecial 816	com/tencent/component/network/downloader/impl/DownloadTask:a	(Ljava/lang/String;J)Z
    //   323: ifeq +15 -> 338
    //   326: aload_3
    //   327: aload 27
    //   329: invokevirtual 419	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   332: iconst_0
    //   333: istore 25
    //   335: goto -262 -> 73
    //   338: aload 27
    //   340: aload 28
    //   342: invokestatic 820	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   345: ifne +25 -> 370
    //   348: aload_0
    //   349: aload 28
    //   351: aload_0
    //   352: getfield 401	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_Long	J
    //   355: invokespecial 816	com/tencent/component/network/downloader/impl/DownloadTask:a	(Ljava/lang/String;J)Z
    //   358: ifeq +12 -> 370
    //   361: aload_3
    //   362: aload 28
    //   364: invokevirtual 419	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   367: goto -35 -> 332
    //   370: aload_3
    //   371: invokevirtual 259	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   374: iconst_2
    //   375: invokevirtual 446	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   378: iconst_0
    //   379: ireturn
    //   380: aload_0
    //   381: getfield 822	com/tencent/component/network/downloader/impl/DownloadTask:jdField_d_of_type_Boolean	Z
    //   384: ifeq +796 -> 1180
    //   387: aload_1
    //   388: ldc_w 824
    //   391: invokeinterface 376 2 0
    //   396: ifnull +13 -> 409
    //   399: aload_2
    //   400: ldc_w 824
    //   403: invokevirtual 393	com/squareup/okhttp/Response:headers	(Ljava/lang/String;)Ljava/util/List;
    //   406: ifnonnull +774 -> 1180
    //   409: ldc_w 826
    //   412: invokestatic 832	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   415: astore 4
    //   417: aload_1
    //   418: ifnull +254 -> 672
    //   421: aload_1
    //   422: invokeinterface 670 1 0
    //   427: ifnull +245 -> 672
    //   430: aload_1
    //   431: invokeinterface 670 1 0
    //   436: invokeinterface 835 1 0
    //   441: astore_1
    //   442: new 837	java/io/FileOutputStream
    //   445: dup
    //   446: aload 28
    //   448: iload 25
    //   450: invokespecial 840	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   453: astore_2
    //   454: aload 28
    //   456: invokevirtual 842	java/io/File:length	()J
    //   459: lstore 23
    //   461: iconst_0
    //   462: istore 5
    //   464: lconst_0
    //   465: lstore 9
    //   467: lload 15
    //   469: lstore 13
    //   471: lload 9
    //   473: lstore 7
    //   475: aload_1
    //   476: aload 27
    //   478: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:a	[B
    //   481: iload 5
    //   483: sipush 8192
    //   486: iload 5
    //   488: isub
    //   489: invokevirtual 853	java/io/InputStream:read	([BII)I
    //   492: istore 6
    //   494: iload 6
    //   496: ifle +208 -> 704
    //   499: iload 6
    //   501: iload 5
    //   503: iadd
    //   504: sipush 8192
    //   507: if_icmpne +187 -> 694
    //   510: lload 15
    //   512: lstore 13
    //   514: lload 9
    //   516: lstore 7
    //   518: aload_2
    //   519: aload 27
    //   521: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:a	[B
    //   524: iconst_0
    //   525: iload 6
    //   527: iload 5
    //   529: iadd
    //   530: invokevirtual 859	java/io/OutputStream:write	([BII)V
    //   533: lload 15
    //   535: lstore 13
    //   537: lload 9
    //   539: lstore 7
    //   541: aload_0
    //   542: aload_0
    //   543: getfield 131	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   546: aload 28
    //   548: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   551: invokespecial 862	com/tencent/component/network/downloader/impl/DownloadTask:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload 4
    //   556: ifnull +630 -> 1186
    //   559: lload 15
    //   561: lstore 13
    //   563: lload 9
    //   565: lstore 7
    //   567: aload 4
    //   569: aload 27
    //   571: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:a	[B
    //   574: iconst_0
    //   575: iload 5
    //   577: iload 6
    //   579: iadd
    //   580: invokevirtual 865	java/security/MessageDigest:update	([BII)V
    //   583: goto +603 -> 1186
    //   586: lload 15
    //   588: iload 6
    //   590: i2l
    //   591: ladd
    //   592: lstore 15
    //   594: lload 15
    //   596: lstore 13
    //   598: lload 9
    //   600: lstore 7
    //   602: aload_3
    //   603: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   606: lload 15
    //   608: putfield 481	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   611: lload 21
    //   613: lconst_0
    //   614: lcmp
    //   615: ifle +37 -> 652
    //   618: lload 15
    //   620: lstore 13
    //   622: lload 9
    //   624: lstore 7
    //   626: aload_0
    //   627: aload_0
    //   628: getfield 131	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   631: lload 21
    //   633: lload 23
    //   635: ladd
    //   636: lload 15
    //   638: lload 23
    //   640: ladd
    //   641: l2f
    //   642: lload 21
    //   644: lload 23
    //   646: ladd
    //   647: l2f
    //   648: fdiv
    //   649: invokespecial 867	com/tencent/component/network/downloader/impl/DownloadTask:a	(Ljava/lang/String;JF)V
    //   652: lload 15
    //   654: lstore 13
    //   656: lload 9
    //   658: lstore 7
    //   660: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   663: lstore 17
    //   665: lload 17
    //   667: lstore 11
    //   669: goto -202 -> 467
    //   672: aload_2
    //   673: ifnull +502 -> 1175
    //   676: aload_2
    //   677: invokevirtual 674	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   680: ifnull +495 -> 1175
    //   683: aload_2
    //   684: invokevirtual 674	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   687: invokevirtual 870	com/squareup/okhttp/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   690: astore_1
    //   691: goto -249 -> 442
    //   694: iload 5
    //   696: iload 6
    //   698: iadd
    //   699: istore 5
    //   701: goto -115 -> 586
    //   704: lload 9
    //   706: lstore 17
    //   708: iload 6
    //   710: ifgt +95 -> 805
    //   713: lload 9
    //   715: lstore 17
    //   717: iload 5
    //   719: ifle +86 -> 805
    //   722: lload 15
    //   724: lstore 13
    //   726: lload 9
    //   728: lstore 7
    //   730: aload_2
    //   731: aload 27
    //   733: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:a	[B
    //   736: iconst_0
    //   737: iload 5
    //   739: invokevirtual 859	java/io/OutputStream:write	([BII)V
    //   742: lload 15
    //   744: lstore 13
    //   746: lload 9
    //   748: lstore 7
    //   750: aload_0
    //   751: aload_0
    //   752: getfield 131	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   755: aload 28
    //   757: invokevirtual 860	java/io/File:getPath	()Ljava/lang/String;
    //   760: invokespecial 862	com/tencent/component/network/downloader/impl/DownloadTask:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   763: lload 9
    //   765: iload 5
    //   767: i2l
    //   768: ladd
    //   769: lstore 9
    //   771: lload 9
    //   773: lstore 17
    //   775: aload 4
    //   777: ifnull +28 -> 805
    //   780: lload 15
    //   782: lstore 13
    //   784: lload 9
    //   786: lstore 7
    //   788: aload 4
    //   790: aload 27
    //   792: getfield 847	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:a	[B
    //   795: iconst_0
    //   796: iload 5
    //   798: invokevirtual 865	java/security/MessageDigest:update	([BII)V
    //   801: lload 9
    //   803: lstore 17
    //   805: lload 15
    //   807: lstore 13
    //   809: lload 17
    //   811: lstore 7
    //   813: aload_0
    //   814: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   817: lload 19
    //   819: lsub
    //   820: putfield 104	com/tencent/component/network/downloader/impl/DownloadTask:jdField_c_of_type_Long	J
    //   823: lload 21
    //   825: lconst_0
    //   826: lcmp
    //   827: ifgt +25 -> 852
    //   830: lload 15
    //   832: lstore 13
    //   834: lload 17
    //   836: lstore 7
    //   838: aload_0
    //   839: aload_0
    //   840: getfield 131	com/tencent/component/network/downloader/impl/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   843: lload 21
    //   845: lload 23
    //   847: ladd
    //   848: fconst_1
    //   849: invokespecial 867	com/tencent/component/network/downloader/impl/DownloadTask:a	(Ljava/lang/String;JF)V
    //   852: lload 15
    //   854: lstore 13
    //   856: lload 17
    //   858: lstore 7
    //   860: aload_3
    //   861: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   864: lload 15
    //   866: putfield 481	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   869: aload_1
    //   870: ifnull +7 -> 877
    //   873: aload_1
    //   874: invokevirtual 873	java/io/InputStream:close	()V
    //   877: aload_2
    //   878: ifnull +7 -> 885
    //   881: aload_2
    //   882: invokevirtual 874	java/io/OutputStream:close	()V
    //   885: getstatic 49	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   888: aload 27
    //   890: invokevirtual 792	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   893: aload_0
    //   894: getfield 573	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   897: ifnull +23 -> 920
    //   900: aload_0
    //   901: getfield 573	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   904: invokestatic 795	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   907: lload 15
    //   909: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   912: lload 11
    //   914: lsub
    //   915: invokeinterface 800 6 0
    //   920: aload 4
    //   922: ifnull +165 -> 1087
    //   925: aload 4
    //   927: invokevirtual 878	java/security/MessageDigest:digest	()[B
    //   930: astore_1
    //   931: new 319	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   938: astore_2
    //   939: iconst_0
    //   940: istore 5
    //   942: iload 5
    //   944: aload_1
    //   945: arraylength
    //   946: if_icmpge +130 -> 1076
    //   949: aload_2
    //   950: aload_1
    //   951: iload 5
    //   953: baload
    //   954: sipush 255
    //   957: iand
    //   958: invokestatic 881	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   961: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: pop
    //   965: iload 5
    //   967: iconst_1
    //   968: iadd
    //   969: istore 5
    //   971: goto -29 -> 942
    //   974: astore_3
    //   975: aconst_null
    //   976: astore_1
    //   977: aconst_null
    //   978: astore_2
    //   979: lload 15
    //   981: lstore 13
    //   983: aload_2
    //   984: ifnull +7 -> 991
    //   987: aload_2
    //   988: invokevirtual 873	java/io/InputStream:close	()V
    //   991: aload_1
    //   992: ifnull +7 -> 999
    //   995: aload_1
    //   996: invokevirtual 874	java/io/OutputStream:close	()V
    //   999: getstatic 49	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   1002: aload 27
    //   1004: invokevirtual 792	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   1007: aload_0
    //   1008: getfield 573	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1011: ifnull +23 -> 1034
    //   1014: aload_0
    //   1015: getfield 573	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$NetworkFlowStatistics	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   1018: invokestatic 795	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1021: lload 13
    //   1023: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   1026: lload 11
    //   1028: lsub
    //   1029: invokeinterface 800 6 0
    //   1034: ldc_w 308
    //   1037: new 319	java/lang/StringBuilder
    //   1040: dup
    //   1041: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   1044: ldc_w 802
    //   1047: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: aload_0
    //   1051: getfield 401	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_Long	J
    //   1054: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1057: ldc_w 807
    //   1060: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: lload 7
    //   1065: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 314	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1074: aload_3
    //   1075: athrow
    //   1076: aload_3
    //   1077: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1080: aload_2
    //   1081: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: putfield 884	com/tencent/component/network/downloader/DownloadResult$Content:md5	Ljava/lang/String;
    //   1087: ldc_w 308
    //   1090: new 319	java/lang/StringBuilder
    //   1093: dup
    //   1094: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   1097: ldc_w 802
    //   1100: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload_0
    //   1104: getfield 401	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_Long	J
    //   1107: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1110: ldc_w 807
    //   1113: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: lload 17
    //   1118: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1121: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokestatic 314	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1127: iconst_1
    //   1128: ireturn
    //   1129: astore_3
    //   1130: aconst_null
    //   1131: astore 4
    //   1133: aload_1
    //   1134: astore_2
    //   1135: aload 4
    //   1137: astore_1
    //   1138: lload 15
    //   1140: lstore 13
    //   1142: goto -159 -> 983
    //   1145: astore_3
    //   1146: aload_1
    //   1147: astore 4
    //   1149: aload_2
    //   1150: astore_1
    //   1151: aload 4
    //   1153: astore_2
    //   1154: lload 15
    //   1156: lstore 13
    //   1158: goto -175 -> 983
    //   1161: astore 4
    //   1163: aload_1
    //   1164: astore_3
    //   1165: aload_2
    //   1166: astore_1
    //   1167: aload_3
    //   1168: astore_2
    //   1169: aload 4
    //   1171: astore_3
    //   1172: goto -189 -> 983
    //   1175: aconst_null
    //   1176: astore_1
    //   1177: goto -735 -> 442
    //   1180: aconst_null
    //   1181: astore 4
    //   1183: goto -766 -> 417
    //   1186: iconst_0
    //   1187: istore 5
    //   1189: lload 9
    //   1191: iload 6
    //   1193: iconst_0
    //   1194: iadd
    //   1195: i2l
    //   1196: ladd
    //   1197: lstore 9
    //   1199: goto -613 -> 586
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1202	0	this	DownloadTask
    //   0	1202	1	paramHttpResponse	HttpResponse
    //   0	1202	2	paramResponse	Response
    //   0	1202	3	paramDownloadResult	DownloadResult
    //   0	1202	4	paramJobContext	ThreadPool.JobContext
    //   0	1202	5	paramInt	int
    //   492	703	6	i	int
    //   91	973	7	l1	long
    //   465	733	9	l2	long
    //   96	931	11	l3	long
    //   469	688	13	l4	long
    //   82	1073	15	l5	long
    //   663	454	17	l6	long
    //   17	801	19	l7	long
    //   88	756	21	l8	long
    //   459	387	23	l9	long
    //   71	378	25	bool1	boolean
    //   125	3	26	bool2	boolean
    //   79	924	27	localObject1	Object
    //   109	647	28	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   98	127	974	finally
    //   380	409	974	finally
    //   409	417	974	finally
    //   421	442	974	finally
    //   676	691	974	finally
    //   442	454	1129	finally
    //   454	461	1145	finally
    //   475	494	1161	finally
    //   518	533	1161	finally
    //   541	554	1161	finally
    //   567	583	1161	finally
    //   602	611	1161	finally
    //   626	652	1161	finally
    //   660	665	1161	finally
    //   730	742	1161	finally
    //   750	763	1161	finally
    //   788	801	1161	finally
    //   813	823	1161	finally
    //   838	852	1161	finally
    //   860	869	1161	finally
  }
  
  protected int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected int b(HttpResponse paramHttpResponse, Response paramResponse)
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
  
  public String b()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = Utils.getDomin(this.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void b()
  {
    e += 1;
  }
  
  protected int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int c(HttpResponse paramHttpResponse, Response paramResponse)
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
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    e -= 1;
  }
  
  protected int d()
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler != null)
    {
      if (this.jdField_c_of_type_Boolean) {
        return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.getHttp2TaskConcurrentCount();
      }
      return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler.getHttpTaskConcurrentCount();
    }
    return 1;
  }
  
  public void d()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void e()
  {
    if (QDLog.b()) {
      QDLog.b("downloader", "downloader abort:" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet != null) {}
    while (this.jdField_a_of_type_ComSquareupOkhttpCall == null) {
      try
      {
        this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet.abort();
        return;
      }
      catch (Exception localException1)
      {
        QDLog.c("downloader", "downloader abort Exception", localException1);
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_ComSquareupOkhttpCall.cancel();
      return;
    }
    catch (Exception localException2)
    {
      QDLog.c("downloader", "downloader abort Exception", localException2);
    }
  }
  
  /* Error */
  protected void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 135	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   11: getstatic 71	com/tencent/component/network/downloader/impl/DownloadTask:jdField_d_of_type_Long	J
    //   14: lsub
    //   15: lstore_1
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: iflt +11 -> 30
    //   22: lload_1
    //   23: ldc2_w 912
    //   26: lcmp
    //   27: iflt -20 -> 7
    //   30: getstatic 63	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   39: getstatic 71	com/tencent/component/network/downloader/impl/DownloadTask:jdField_d_of_type_Long	J
    //   42: lsub
    //   43: lstore_1
    //   44: lload_1
    //   45: lconst_0
    //   46: lcmp
    //   47: iflt +21 -> 68
    //   50: lload_1
    //   51: ldc2_w 912
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
    //   69: getfield 135	com/tencent/component/network/downloader/impl/DownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   72: invokevirtual 919	com/tencent/component/network/utils/http/base/QZoneHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +49 -> 128
    //   82: aload 4
    //   84: instanceof 921
    //   87: ifeq +41 -> 128
    //   90: aload 4
    //   92: checkcast 921	com/tencent/component/network/utils/http/PoolingClientConnectionManager
    //   95: astore 4
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 924	com/tencent/component/network/utils/http/PoolingClientConnectionManager:closeExpiredConnections	()V
    //   107: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   110: putstatic 71	com/tencent/component/network/downloader/impl/DownloadTask:jdField_d_of_type_Long	J
    //   113: invokestatic 926	com/tencent/component/network/module/base/QDLog:a	()Z
    //   116: ifeq +12 -> 128
    //   119: ldc_w 308
    //   122: ldc_w 928
    //   125: invokestatic 929	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_3
    //   129: monitorexit
    //   130: return
    //   131: astore 4
    //   133: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   136: putstatic 71	com/tencent/component/network/downloader/impl/DownloadTask:jdField_d_of_type_Long	J
    //   139: invokestatic 926	com/tencent/component/network/module/base/QDLog:a	()Z
    //   142: ifeq -14 -> 128
    //   145: ldc_w 308
    //   148: ldc_w 928
    //   151: invokestatic 929	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -26 -> 128
    //   157: astore 4
    //   159: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   162: putstatic 71	com/tencent/component/network/downloader/impl/DownloadTask:jdField_d_of_type_Long	J
    //   165: invokestatic 926	com/tencent/component/network/module/base/QDLog:a	()Z
    //   168: ifeq +12 -> 180
    //   171: ldc_w 308
    //   174: ldc_w 928
    //   177: invokestatic 929	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask
 * JD-Core Version:    0.7.0.1
 */