package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.net.Proxy;
import java.util.List;
import okhttp3.OkHttpClient;

public class FastDownloadTask
  extends DownloadTask
{
  int connect_retry = 0;
  long connect_time = 0L;
  int exe_retry = 0;
  long exe_time = 0L;
  private boolean mAPNProxy;
  private boolean mAllowProxy;
  private String mDomainWithPort;
  private int mOrigPort = 0;
  private String mRealUrl;
  private String mRefer;
  private final long mTimeStamp = SystemClock.uptimeMillis();
  long send_req_time = 0L;
  private Proxy triedNetworkProxy;
  
  public FastDownloadTask(Context paramContext, OkHttpClient paramOkHttpClient, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramOkHttpClient, paramQZoneHttpClient, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  private boolean setStrategy(int paramInt)
  {
    String str2 = getDomain();
    if (this.pDownloadStrategyLib == null) {
      this.pDownloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(getUrl(), getDomain(), this.mIsHttp2);
    }
    this.pOldStrategyInfo = this.pCurrStrategyInfo;
    if (this.pDownloadStrategyLib.getStrategyList() != null) {
      i = this.pDownloadStrategyLib.getStrategyList().size();
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    for (this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(this.attemptStrategyCount % i); (this.mIsHttp2) && (this.pCurrStrategyInfo != null) && (this.pOldStrategyInfo != null) && (this.pCurrStrategyInfo.id == this.pOldStrategyInfo.id); this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(this.attemptStrategyCount % i)) {
      this.attemptStrategyCount += 1;
    }
    this.attemptStrategyCount += 1;
    boolean bool = this.mIsHttp2;
    int j = 80;
    if ((bool) && (this.attemptStrategyCount > i))
    {
      this.mIsHttp2 = false;
      this.pDownloadStrategyLib.setPort(80);
    }
    int i = j;
    if (this.mIsHttp2) {
      i = 443;
    }
    this.mStandardPort = i;
    if (QDLog.isInfoEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloader strategy: ");
      ((StringBuilder)localObject).append(this.pCurrStrategyInfo.toString());
      ((StringBuilder)localObject).append(" currAttempCount:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" attemptStrategyCount:");
      ((StringBuilder)localObject).append(this.attemptStrategyCount);
      ((StringBuilder)localObject).append(" ,best:");
      ((StringBuilder)localObject).append(this.pDownloadStrategyLib.getBestId());
      ((StringBuilder)localObject).append(" url:");
      ((StringBuilder)localObject).append(getUrl());
      ((StringBuilder)localObject).append(" Apn:");
      ((StringBuilder)localObject).append(NetworkManager.getApnValue());
      ((StringBuilder)localObject).append(" ISP:");
      ((StringBuilder)localObject).append(NetworkManager.getIspType());
      ((StringBuilder)localObject).append(" threadid:");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QDLog.i("downloader_strategy", ((StringBuilder)localObject).toString());
    }
    this.mAllowProxy = this.pCurrStrategyInfo.allowProxy;
    this.mAPNProxy = this.pCurrStrategyInfo.useConfigApn;
    i = this.pDownloadStrategyLib.getPort();
    paramInt = i;
    if (!Utils.isPortValid(i))
    {
      this.pDownloadStrategyLib.setPort(this.mStandardPort);
      paramInt = this.mStandardPort;
    }
    if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.pCurrStrategyInfo.id)
    {
      i = paramInt;
      if (this.pOldStrategyInfo != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.pOldStrategyInfo.id) {
          if ((this.pPortConfigStrategy != null) && (this.pPortConfigStrategy.supportExtraPort(str2)))
          {
            i = this.pPortConfigStrategy.changePort(str2, paramInt);
            if ((i != paramInt) && (Utils.isPortValid(i))) {
              break label672;
            }
            if (QDLog.isInfoEnable())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("downloader strategy: Pass! port:");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(" newport:");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(" threadId:");
              ((StringBuilder)localObject).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject).toString());
            }
            return false;
          }
          else
          {
            if (QDLog.isInfoEnable())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("downloader strategy: Pass! Not support !80. threadId:");
              ((StringBuilder)localObject).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject).toString());
            }
            return false;
          }
        }
      }
      label672:
      str1 = this.pDownloadStrategyLib.getBackupIP();
      localObject = str1;
      if (this.pBackupIPConfigStrategy != null)
      {
        localObject = str1;
        if (!this.pBackupIPConfigStrategy.isIPValid(str2, str1))
        {
          this.pDownloadStrategyLib.setBackupIP(null);
          localObject = this.pBackupIPConfigStrategy.resolveIP(str2);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            this.pDownloadStrategyLib.setBackupIP((String)localObject);
          }
          else
          {
            if (QDLog.isInfoEnable())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("downloader strategy: backup ip is null. Pass! threadId:");
              ((StringBuilder)localObject).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject).toString());
            }
            return false;
          }
        }
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
      return true;
    }
    if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pCurrStrategyInfo.id)
    {
      i = paramInt;
      if (this.pOldStrategyInfo != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pOldStrategyInfo.id) {
          if ((this.pPortConfigStrategy != null) && (this.pPortConfigStrategy.supportExtraPort(str2)))
          {
            i = this.pPortConfigStrategy.changePort(str2, paramInt);
            if ((i != paramInt) && (Utils.isPortValid(i))) {
              break label1046;
            }
            if (QDLog.isInfoEnable())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("downloader strategy: Pass! port:");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(" newport:");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(" threadId:");
              ((StringBuilder)localObject).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject).toString());
            }
            return false;
          }
          else
          {
            if (QDLog.isInfoEnable())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("downloader strategy: Pass! Not support !80. threadId:");
              ((StringBuilder)localObject).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject).toString());
            }
            return false;
          }
        }
      }
      label1046:
      str1 = DnsService.getInstance().getDomainIP(str2);
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = DnsService.getInstance().getDomainIP(str2);
      }
      if ((localObject != null) && (!((String)localObject).equals(this.pDownloadStrategyLib.getBackupIP())) && (!((String)localObject).equals(this.pDownloadStrategyLib.getDirectIP())))
      {
        this.pDownloadStrategyLib.setDnsIP((String)localObject);
        this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
        this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
        return true;
      }
      this.pDownloadStrategyLib.setDnsIP(null);
      if (QDLog.isInfoEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloader strategy: Pass! Domain IP 重复. threadId:");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        QDLog.i("downloader", ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.pCurrStrategyInfo.id)
    {
      i = paramInt;
      if (this.pOldStrategyInfo != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.pOldStrategyInfo.id) {
          if ((this.pPortConfigStrategy != null) && (this.pPortConfigStrategy.supportExtraPort(str2)))
          {
            i = this.pPortConfigStrategy.changePort(str2, paramInt);
            if ((i != paramInt) && (Utils.isPortValid(i))) {
              break label1483;
            }
            if (QDLog.isInfoEnable())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("downloader strategy: Pass! port:");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(" newport:");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(" threadId:");
              ((StringBuilder)localObject).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject).toString());
            }
            return false;
          }
          else
          {
            if (QDLog.isInfoEnable())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("downloader strategy: Pass! Not support !");
              ((StringBuilder)localObject).append(this.mStandardPort);
              ((StringBuilder)localObject).append(". threadId:");
              ((StringBuilder)localObject).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject).toString());
            }
            return false;
          }
        }
      }
    }
    else
    {
      if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.pCurrStrategyInfo.id) {
        break label1728;
      }
      i = paramInt;
      if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.pCurrStrategyInfo.id) {
        break label1728;
      }
    }
    label1483:
    String str1 = this.pDownloadStrategyLib.getDirectIP();
    Object localObject = str1;
    if (this.pDirectIPConfigStrategy != null)
    {
      localObject = str1;
      if (!this.pDirectIPConfigStrategy.isIPValid(str2, str1))
      {
        this.pDownloadStrategyLib.setDirectIP(null);
        localObject = this.pDirectIPConfigStrategy.resolveIP(str2);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.pDownloadStrategyLib.setDirectIP((String)localObject);
        }
        else
        {
          if (QDLog.isInfoEnable())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloader strategy: direct ip is null. Pass! threadId:");
            ((StringBuilder)localObject).append(Thread.currentThread().getId());
            QDLog.i("downloader", ((StringBuilder)localObject).toString());
          }
          return false;
        }
      }
    }
    if ((localObject != null) && (!((String)localObject).equals(this.pDownloadStrategyLib.getBackupIP())) && (!((String)localObject).equals(this.pDownloadStrategyLib.getDnsIP())))
    {
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
      return true;
    }
    if (QDLog.isInfoEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloader strategy: Pass! Domain IP 重复. threadId:");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QDLog.i("downloader", ((StringBuilder)localObject).toString());
    }
    return false;
    label1728:
    localObject = this.mContext;
    if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.pCurrStrategyInfo.id) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = NetworkUtils.getProxy((Context)localObject, bool);
    if (localObject == null)
    {
      if (QDLog.isInfoEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloader strategy: proxy is null. Pass! threadId:");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        QDLog.i("downloader", ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (((Proxy)localObject).equals(this.triedNetworkProxy))
    {
      if (QDLog.isInfoEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloader strategy: proxy 重复. Pass! threadId:");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        QDLog.i("downloader", ((StringBuilder)localObject).toString());
      }
      return false;
    }
    this.triedNetworkProxy = ((Proxy)localObject);
    paramInt = this.mStandardPort;
    return true;
  }
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 22
    //   3: aload_2
    //   4: astore 21
    //   6: iconst_2
    //   7: anewarray 343	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload 21
    //   21: aastore
    //   22: invokestatic 349	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   25: istore 6
    //   27: invokestatic 354	com/tencent/component/network/utils/SDCardUtil:isSdCardHasEnoughCapability	()Z
    //   30: istore 8
    //   32: iconst_0
    //   33: istore 5
    //   35: lconst_0
    //   36: lstore 11
    //   38: aload_1
    //   39: invokeinterface 359 1 0
    //   44: ifeq +13 -> 57
    //   47: aload_0
    //   48: aload 22
    //   50: aload 21
    //   52: aconst_null
    //   53: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   56: return
    //   57: aload_0
    //   58: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   61: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   64: ifne +41 -> 105
    //   67: iload 5
    //   69: aload_0
    //   70: getfield 370	com/tencent/component/network/downloader/impl/FastDownloadTask:mAttemptTotalCount	I
    //   73: iconst_1
    //   74: isub
    //   75: if_icmpne +13 -> 88
    //   78: aload_2
    //   79: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   82: bipush 6
    //   84: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   87: return
    //   88: ldc2_w 382
    //   91: invokestatic 387	java/lang/Thread:sleep	(J)V
    //   94: goto +11 -> 105
    //   97: ldc 225
    //   99: ldc_w 389
    //   102: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: iload 8
    //   107: ifne +12 -> 119
    //   110: aload_2
    //   111: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   114: iconst_2
    //   115: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   118: return
    //   119: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   122: lstore 13
    //   124: new 394	com/tencent/component/network/downloader/DownloadReport
    //   127: dup
    //   128: invokespecial 395	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   131: astore 25
    //   133: aload 25
    //   135: iload 6
    //   137: putfield 396	com/tencent/component/network/downloader/DownloadReport:id	I
    //   140: aload 25
    //   142: aload_0
    //   143: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   146: putfield 399	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   149: aload 25
    //   151: aload_0
    //   152: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   155: putfield 402	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   158: aload 25
    //   160: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   163: putfield 410	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   176: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   179: lstore 17
    //   181: aload_0
    //   182: aload_0
    //   183: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   186: invokespecial 423	com/tencent/component/network/downloader/impl/FastDownloadTask:setStrategy	(I)Z
    //   189: istore 9
    //   191: iload 9
    //   193: ifne +9 -> 202
    //   196: iload 5
    //   198: istore_3
    //   199: goto +18250 -> 18449
    //   202: aconst_null
    //   203: astore 22
    //   205: goto +5 -> 210
    //   208: astore 22
    //   210: ldc_w 425
    //   213: astore 30
    //   215: ldc_w 427
    //   218: astore 28
    //   220: ldc_w 429
    //   223: astore 21
    //   225: aload 22
    //   227: ifnonnull +14965 -> 15192
    //   230: aload_2
    //   231: invokevirtual 432	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   234: getstatic 436	com/tencent/component/network/downloader/impl/FastDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   237: invokevirtual 442	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   240: checkcast 444	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   243: astore 26
    //   245: aload 26
    //   247: aload_0
    //   248: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   251: putfield 445	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   254: aload 26
    //   256: aload_0
    //   257: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   260: putfield 448	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   263: aload_0
    //   264: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   267: astore 22
    //   269: aload 22
    //   271: ifnull +149 -> 420
    //   274: aload_0
    //   275: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   278: invokeinterface 458 1 0
    //   283: astore 22
    //   285: goto +138 -> 423
    //   288: astore 21
    //   290: ldc_w 460
    //   293: astore 27
    //   295: ldc_w 462
    //   298: astore 31
    //   300: aload 25
    //   302: astore 24
    //   304: ldc_w 464
    //   307: astore 29
    //   309: ldc_w 427
    //   312: astore 22
    //   314: aconst_null
    //   315: astore 28
    //   317: aconst_null
    //   318: astore 23
    //   320: iconst_0
    //   321: istore_3
    //   322: aconst_null
    //   323: astore 26
    //   325: lload 11
    //   327: lstore 15
    //   329: aload 27
    //   331: astore 25
    //   333: ldc 225
    //   335: astore 34
    //   337: ldc_w 466
    //   340: astore 33
    //   342: ldc_w 468
    //   345: astore 32
    //   347: lload 13
    //   349: lstore 11
    //   351: aconst_null
    //   352: astore 35
    //   354: aload 21
    //   356: astore 27
    //   358: aload 32
    //   360: astore 21
    //   362: aload 24
    //   364: astore 32
    //   366: lload 15
    //   368: lstore 13
    //   370: aload 35
    //   372: astore 24
    //   374: goto +18173 -> 18547
    //   377: astore 22
    //   379: aload 25
    //   381: astore 24
    //   383: ldc_w 466
    //   386: astore 33
    //   388: ldc_w 462
    //   391: astore 31
    //   393: aconst_null
    //   394: astore 29
    //   396: aconst_null
    //   397: astore 27
    //   399: aconst_null
    //   400: astore 23
    //   402: iconst_0
    //   403: istore_3
    //   404: aload 22
    //   406: astore 25
    //   408: ldc_w 460
    //   411: astore 26
    //   413: aload 29
    //   415: astore 22
    //   417: goto +14819 -> 15236
    //   420: aconst_null
    //   421: astore 22
    //   423: aload 26
    //   425: aload 22
    //   427: putfield 471	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   430: aload 25
    //   432: iload 5
    //   434: putfield 474	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   437: aload 25
    //   439: aload_0
    //   440: getfield 476	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   443: putfield 479	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   446: aload_0
    //   447: aload_0
    //   448: aload_0
    //   449: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   452: invokevirtual 482	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   455: putfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   458: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   461: istore_3
    //   462: iload_3
    //   463: iconst_2
    //   464: if_icmpeq +21 -> 485
    //   467: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   470: istore_3
    //   471: iload_3
    //   472: iconst_3
    //   473: if_icmpne +6 -> 479
    //   476: goto +9 -> 485
    //   479: iconst_0
    //   480: istore 4
    //   482: goto +6 -> 488
    //   485: iconst_1
    //   486: istore 4
    //   488: aload_0
    //   489: invokevirtual 492	com/tencent/component/network/downloader/impl/FastDownloadTask:enableIpv6Debug	()Z
    //   492: istore 9
    //   494: aload 26
    //   496: getfield 471	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   499: astore 22
    //   501: aload 22
    //   503: ifnonnull +649 -> 1152
    //   506: aload_0
    //   507: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   510: ldc_w 466
    //   513: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   516: ifeq +10 -> 526
    //   519: aload_0
    //   520: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   523: ifeq +629 -> 1152
    //   526: aload_0
    //   527: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   530: ifnull +622 -> 1152
    //   533: aload_0
    //   534: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   537: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   540: ifnull +612 -> 1152
    //   543: aload_0
    //   544: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   547: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   550: getfield 502	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   553: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   556: ifne +596 -> 1152
    //   559: aload_0
    //   560: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   563: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   566: getfield 502	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   569: astore 22
    //   571: aload_0
    //   572: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   575: astore 23
    //   577: aload 22
    //   579: bipush 58
    //   581: invokestatic 506	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   584: istore_3
    //   585: iload 4
    //   587: ifne +21061 -> 21648
    //   590: iload_3
    //   591: iconst_2
    //   592: if_icmpge +21053 -> 21645
    //   595: aload_0
    //   596: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   599: istore_3
    //   600: iload_3
    //   601: ifle +17 -> 618
    //   604: aload_0
    //   605: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   608: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   611: iload_3
    //   612: putfield 509	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   615: goto +14 -> 629
    //   618: aload_0
    //   619: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   622: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   625: getfield 509	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   628: istore_3
    //   629: iload_3
    //   630: istore 7
    //   632: iload_3
    //   633: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   636: ifne +7 -> 643
    //   639: bipush 80
    //   641: istore 7
    //   643: new 123	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   650: astore 23
    //   652: aload 23
    //   654: aload 22
    //   656: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 23
    //   662: ldc_w 511
    //   665: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 23
    //   671: iload 7
    //   673: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 23
    //   679: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: astore 22
    //   684: aload_0
    //   685: getfield 513	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   688: ifnull +20954 -> 21642
    //   691: aload_0
    //   692: aload_0
    //   693: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   696: aload_0
    //   697: getfield 513	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   700: aload 22
    //   702: invokevirtual 517	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   705: putfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   708: goto +20934 -> 21642
    //   711: aload 22
    //   713: bipush 58
    //   715: invokestatic 506	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   718: iconst_2
    //   719: if_icmplt +136 -> 855
    //   722: aload_0
    //   723: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   726: istore_3
    //   727: iload_3
    //   728: ifle +17 -> 745
    //   731: aload_0
    //   732: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   735: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   738: iload_3
    //   739: putfield 509	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   742: goto +14 -> 756
    //   745: aload_0
    //   746: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   749: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   752: getfield 509	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   755: istore_3
    //   756: iload_3
    //   757: istore 7
    //   759: iload_3
    //   760: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   763: ifne +7 -> 770
    //   766: bipush 80
    //   768: istore 7
    //   770: new 123	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   777: astore 23
    //   779: aload 23
    //   781: ldc_w 519
    //   784: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload 23
    //   790: aload 22
    //   792: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload 23
    //   798: ldc_w 521
    //   801: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 23
    //   807: iload 7
    //   809: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload 23
    //   815: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: astore 23
    //   820: aload 23
    //   822: astore 22
    //   824: aload_0
    //   825: getfield 513	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   828: ifnull +174 -> 1002
    //   831: aload_0
    //   832: aload_0
    //   833: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   836: aload_0
    //   837: getfield 513	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   840: aload 23
    //   842: invokevirtual 517	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   845: putfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   848: aload 23
    //   850: astore 22
    //   852: goto +150 -> 1002
    //   855: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   858: iconst_3
    //   859: if_icmpne +20810 -> 21669
    //   862: aload_0
    //   863: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   866: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   869: getstatic 272	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   872: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   875: if_icmpeq +20794 -> 21669
    //   878: aload_0
    //   879: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   882: istore_3
    //   883: iload_3
    //   884: ifle +17 -> 901
    //   887: aload_0
    //   888: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   891: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   894: iload_3
    //   895: putfield 509	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   898: goto +14 -> 912
    //   901: aload_0
    //   902: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   905: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   908: getfield 509	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   911: istore_3
    //   912: iload_3
    //   913: istore 7
    //   915: iload_3
    //   916: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   919: ifne +7 -> 926
    //   922: bipush 80
    //   924: istore 7
    //   926: new 123	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   933: astore 23
    //   935: aload 23
    //   937: aload 22
    //   939: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload 23
    //   945: ldc_w 511
    //   948: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload 23
    //   954: iload 7
    //   956: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: aload 23
    //   962: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: astore 23
    //   967: aload 23
    //   969: astore 22
    //   971: aload_0
    //   972: getfield 513	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   975: ifnull +27 -> 1002
    //   978: aload_0
    //   979: aload_0
    //   980: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   983: aload_0
    //   984: getfield 513	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   987: aload 23
    //   989: invokevirtual 517	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   992: putfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   995: aload 23
    //   997: astore 22
    //   999: goto +3 -> 1002
    //   1002: aload 25
    //   1004: aload_0
    //   1005: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1008: invokevirtual 135	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1011: putfield 524	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1014: invokestatic 527	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   1017: ifeq +466 -> 1483
    //   1020: new 123	java/lang/StringBuilder
    //   1023: dup
    //   1024: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1027: astore 23
    //   1029: aload 23
    //   1031: ldc_w 529
    //   1034: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload 23
    //   1040: aload 25
    //   1042: getfield 524	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1045: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 23
    //   1051: ldc_w 531
    //   1054: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: aload 23
    //   1060: aload 22
    //   1062: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: aload 23
    //   1068: ldc 149
    //   1070: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload 23
    //   1076: aload_0
    //   1077: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1080: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload 23
    //   1086: ldc 223
    //   1088: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload 23
    //   1094: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1097: invokevirtual 172	java/lang/Thread:getId	()J
    //   1100: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: ldc 225
    //   1106: aload 23
    //   1108: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1114: goto +369 -> 1483
    //   1117: astore 21
    //   1119: ldc_w 462
    //   1122: astore 31
    //   1124: ldc_w 460
    //   1127: astore 27
    //   1129: goto -829 -> 300
    //   1132: astore 22
    //   1134: ldc_w 462
    //   1137: astore 31
    //   1139: ldc_w 460
    //   1142: astore 26
    //   1144: goto +308 -> 1452
    //   1147: astore 22
    //   1149: goto -770 -> 379
    //   1152: aload_0
    //   1153: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1156: astore 22
    //   1158: aload 22
    //   1160: ifnull +323 -> 1483
    //   1163: aload_0
    //   1164: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1167: ldc_w 466
    //   1170: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1173: ifeq +310 -> 1483
    //   1176: iload 4
    //   1178: ifeq +305 -> 1483
    //   1181: iload 9
    //   1183: ifeq +300 -> 1483
    //   1186: aload_0
    //   1187: aload_0
    //   1188: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1191: ldc_w 533
    //   1194: ldc_w 535
    //   1197: invokevirtual 517	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1200: putfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1203: aload_0
    //   1204: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   1207: istore_3
    //   1208: iload_3
    //   1209: ifle +17 -> 1226
    //   1212: aload_0
    //   1213: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1216: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1219: iload_3
    //   1220: putfield 509	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   1223: goto +14 -> 1237
    //   1226: aload_0
    //   1227: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1230: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1233: getfield 509	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   1236: istore_3
    //   1237: iload_3
    //   1238: istore 7
    //   1240: iload_3
    //   1241: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   1244: ifne +7 -> 1251
    //   1247: bipush 80
    //   1249: istore 7
    //   1251: new 123	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1258: astore 22
    //   1260: aload 22
    //   1262: ldc_w 519
    //   1265: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: aload 22
    //   1271: ldc_w 537
    //   1274: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload 22
    //   1280: ldc_w 521
    //   1283: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: aload 22
    //   1289: iload 7
    //   1291: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1294: pop
    //   1295: aload 22
    //   1297: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1300: astore 22
    //   1302: aload_0
    //   1303: getfield 513	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   1306: ifnull +20 -> 1326
    //   1309: aload_0
    //   1310: aload_0
    //   1311: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1314: aload_0
    //   1315: getfield 513	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   1318: aload 22
    //   1320: invokevirtual 517	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1323: putfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1326: aload 25
    //   1328: aload_0
    //   1329: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1332: invokevirtual 135	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1335: putfield 524	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1338: invokestatic 527	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   1341: ifeq +142 -> 1483
    //   1344: new 123	java/lang/StringBuilder
    //   1347: dup
    //   1348: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1351: astore 22
    //   1353: aload 22
    //   1355: ldc_w 529
    //   1358: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: aload 22
    //   1364: aload 25
    //   1366: getfield 524	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1369: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: pop
    //   1373: aload 22
    //   1375: ldc_w 539
    //   1378: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: aload 22
    //   1384: aload_0
    //   1385: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1388: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: aload 22
    //   1394: ldc 223
    //   1396: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: aload 22
    //   1402: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1405: invokevirtual 172	java/lang/Thread:getId	()J
    //   1408: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1411: pop
    //   1412: ldc 225
    //   1414: aload 22
    //   1416: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1422: goto +61 -> 1483
    //   1425: astore 21
    //   1427: ldc_w 460
    //   1430: astore 27
    //   1432: ldc_w 462
    //   1435: astore 31
    //   1437: goto -1137 -> 300
    //   1440: astore 22
    //   1442: ldc_w 460
    //   1445: astore 26
    //   1447: ldc_w 462
    //   1450: astore 31
    //   1452: aload 25
    //   1454: astore 24
    //   1456: ldc_w 466
    //   1459: astore 33
    //   1461: aconst_null
    //   1462: astore 29
    //   1464: aconst_null
    //   1465: astore 27
    //   1467: aconst_null
    //   1468: astore 23
    //   1470: iconst_0
    //   1471: istore_3
    //   1472: aload 22
    //   1474: astore 25
    //   1476: aload 29
    //   1478: astore 22
    //   1480: goto +13756 -> 15236
    //   1483: aload_0
    //   1484: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1487: astore 22
    //   1489: aload 22
    //   1491: ifnull +27 -> 1518
    //   1494: aload 25
    //   1496: aload_0
    //   1497: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1500: invokevirtual 135	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1503: putfield 524	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1506: aload 25
    //   1508: aload_0
    //   1509: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1512: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1515: putfield 542	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   1518: aload_0
    //   1519: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1522: istore 9
    //   1524: iload 9
    //   1526: ifeq +38 -> 1564
    //   1529: iload 4
    //   1531: ifne +33 -> 1564
    //   1534: aload_0
    //   1535: aload_0
    //   1536: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   1539: aload_0
    //   1540: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1543: aload_0
    //   1544: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1547: aload_0
    //   1548: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1551: aload_0
    //   1552: getfield 476	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   1555: invokestatic 548	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   1558: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1561: goto +32 -> 1593
    //   1564: aload_0
    //   1565: aload_0
    //   1566: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   1569: aload_0
    //   1570: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1573: aload_0
    //   1574: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1577: aload_0
    //   1578: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1581: aload_0
    //   1582: getfield 476	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   1585: aload 26
    //   1587: invokestatic 552	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   1590: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1593: aload_0
    //   1594: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1597: astore 22
    //   1599: aload 22
    //   1601: ifnull +28 -> 1629
    //   1604: aload_0
    //   1605: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1608: aload_0
    //   1609: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1612: aload_0
    //   1613: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1616: aload_0
    //   1617: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1620: aload_0
    //   1621: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1624: invokeinterface 562 5 0
    //   1629: aload_0
    //   1630: aload_0
    //   1631: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1634: aload_0
    //   1635: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1638: aload_0
    //   1639: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1642: aload_0
    //   1643: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1646: invokevirtual 565	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   1649: aload_0
    //   1650: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1653: astore 22
    //   1655: aload_0
    //   1656: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1659: astore 23
    //   1661: aload_0
    //   1662: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1665: astore 27
    //   1667: aload_0
    //   1668: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1671: astore 29
    //   1673: aload 25
    //   1675: astore 24
    //   1677: ldc_w 466
    //   1680: astore 33
    //   1682: lload 13
    //   1684: lstore 15
    //   1686: ldc 225
    //   1688: astore 34
    //   1690: aload_0
    //   1691: aload 22
    //   1693: aload 23
    //   1695: aload 27
    //   1697: aload 29
    //   1699: aload 26
    //   1701: invokevirtual 569	com/tencent/component/network/downloader/impl/FastDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   1704: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   1707: lstore 19
    //   1709: lload 19
    //   1711: lload 17
    //   1713: lsub
    //   1714: lstore 11
    //   1716: aload_0
    //   1717: lconst_0
    //   1718: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1721: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1724: lstore 17
    //   1726: aload_0
    //   1727: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1730: astore 22
    //   1732: aload 22
    //   1734: ifnull +179 -> 1913
    //   1737: aload_0
    //   1738: getfield 573	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   1741: ifnonnull +10 -> 1751
    //   1744: aload_0
    //   1745: invokestatic 577	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   1748: putfield 573	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   1751: invokestatic 581	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   1754: astore 22
    //   1756: aload_0
    //   1757: getfield 573	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   1760: aload_0
    //   1761: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1764: aload 22
    //   1766: invokevirtual 586	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   1769: astore 23
    //   1771: aconst_null
    //   1772: astore 27
    //   1774: aload 22
    //   1776: astore 26
    //   1778: aload 27
    //   1780: astore 22
    //   1782: goto +192 -> 1974
    //   1785: astore 27
    //   1787: aload 22
    //   1789: astore 21
    //   1791: goto +13 -> 1804
    //   1794: astore 23
    //   1796: goto +80 -> 1876
    //   1799: astore 27
    //   1801: aconst_null
    //   1802: astore 21
    //   1804: lload 11
    //   1806: lstore 15
    //   1808: aconst_null
    //   1809: astore 23
    //   1811: lload 13
    //   1813: lstore 11
    //   1815: aconst_null
    //   1816: astore 26
    //   1818: aload 26
    //   1820: astore 35
    //   1822: ldc_w 464
    //   1825: astore 29
    //   1827: ldc_w 468
    //   1830: astore 32
    //   1832: aload 28
    //   1834: astore 22
    //   1836: ldc_w 460
    //   1839: astore 25
    //   1841: ldc_w 462
    //   1844: astore 31
    //   1846: iconst_0
    //   1847: istore_3
    //   1848: aload 21
    //   1850: astore 28
    //   1852: aload 32
    //   1854: astore 21
    //   1856: aload 24
    //   1858: astore 32
    //   1860: lload 15
    //   1862: lstore 13
    //   1864: aload 35
    //   1866: astore 24
    //   1868: goto +16679 -> 18547
    //   1871: astore 23
    //   1873: aconst_null
    //   1874: astore 22
    //   1876: aconst_null
    //   1877: astore 27
    //   1879: aconst_null
    //   1880: astore 26
    //   1882: iconst_0
    //   1883: istore_3
    //   1884: aload 23
    //   1886: astore 25
    //   1888: aload 27
    //   1890: astore 23
    //   1892: aload 22
    //   1894: astore 27
    //   1896: aload 26
    //   1898: astore 22
    //   1900: ldc_w 462
    //   1903: astore 31
    //   1905: ldc_w 460
    //   1908: astore 26
    //   1910: goto +13326 -> 15236
    //   1913: aload_0
    //   1914: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1917: astore 22
    //   1919: aload 22
    //   1921: ifnull +42 -> 1963
    //   1924: aload_0
    //   1925: aload_0
    //   1926: getfield 590	com/tencent/component/network/downloader/impl/FastDownloadTask:pokHttpClient	Lokhttp3/OkHttpClient;
    //   1929: aload_0
    //   1930: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1933: invokevirtual 596	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   1936: invokevirtual 602	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   1939: putfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1942: aload_0
    //   1943: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1946: invokeinterface 611 1 0
    //   1951: astore 22
    //   1953: aconst_null
    //   1954: astore 26
    //   1956: aload 26
    //   1958: astore 23
    //   1960: goto +14 -> 1974
    //   1963: aconst_null
    //   1964: astore 26
    //   1966: aload 26
    //   1968: astore 22
    //   1970: aload 22
    //   1972: astore 23
    //   1974: aload_0
    //   1975: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1978: lload 17
    //   1980: lsub
    //   1981: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1984: aload 23
    //   1986: ifnonnull +24 -> 2010
    //   1989: aload 22
    //   1991: ifnull +6 -> 1997
    //   1994: goto +16 -> 2010
    //   1997: aload_2
    //   1998: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2001: iconst_3
    //   2002: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   2005: iconst_0
    //   2006: istore_3
    //   2007: goto +9577 -> 11584
    //   2010: aload 23
    //   2012: ifnull +29 -> 2041
    //   2015: aload 23
    //   2017: invokeinterface 617 1 0
    //   2022: ifnull +19 -> 2041
    //   2025: aload 23
    //   2027: invokeinterface 617 1 0
    //   2032: invokeinterface 622 1 0
    //   2037: istore_3
    //   2038: goto +14 -> 2052
    //   2041: aload 22
    //   2043: ifnull +12 -> 2055
    //   2046: aload 22
    //   2048: invokevirtual 627	okhttp3/Response:code	()I
    //   2051: istore_3
    //   2052: goto +5 -> 2057
    //   2055: iconst_0
    //   2056: istore_3
    //   2057: aload_2
    //   2058: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2061: iload_3
    //   2062: putfield 630	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   2065: sipush 200
    //   2068: iload_3
    //   2069: if_icmpeq +86 -> 2155
    //   2072: sipush 206
    //   2075: iload_3
    //   2076: if_icmpne +6 -> 2082
    //   2079: goto +76 -> 2155
    //   2082: sipush 416
    //   2085: iload_3
    //   2086: if_icmpne +27 -> 2113
    //   2089: aload_0
    //   2090: ldc_w 632
    //   2093: invokevirtual 635	com/tencent/component/network/downloader/impl/FastDownloadTask:removeHttpParam	(Ljava/lang/String;)V
    //   2096: aload_2
    //   2097: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2100: bipush 7
    //   2102: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   2105: goto +16 -> 2121
    //   2108: astore 27
    //   2110: goto +37 -> 2147
    //   2113: aload_2
    //   2114: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2117: iconst_3
    //   2118: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   2121: aload_0
    //   2122: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2125: ifnull +17 -> 2142
    //   2128: aload_0
    //   2129: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2132: aload_0
    //   2133: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2136: iconst_1
    //   2137: invokeinterface 639 3 0
    //   2142: goto +9438 -> 11580
    //   2145: astore 27
    //   2147: goto +19533 -> 21680
    //   2150: astore 25
    //   2152: goto +19603 -> 21755
    //   2155: iload_3
    //   2156: istore 4
    //   2158: aload 26
    //   2160: astore 27
    //   2162: aload_0
    //   2163: aload 23
    //   2165: aload 22
    //   2167: aload_2
    //   2168: aload_1
    //   2169: iload 4
    //   2171: invokevirtual 643	com/tencent/component/network/downloader/impl/FastDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   2174: istore 9
    //   2176: iload 9
    //   2178: ifeq +9402 -> 11580
    //   2181: aload_2
    //   2182: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2185: invokevirtual 646	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   2188: aload_2
    //   2189: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2192: getfield 655	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   2195: istore 9
    //   2197: iload 9
    //   2199: ifeq +6262 -> 8461
    //   2202: aload_0
    //   2203: aload 23
    //   2205: aload 22
    //   2207: invokevirtual 659	com/tencent/component/network/downloader/impl/FastDownloadTask:getRetcode	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;)I
    //   2210: istore 7
    //   2212: aload_2
    //   2213: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2216: iload 7
    //   2218: putfield 662	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   2221: iload 7
    //   2223: invokestatic 665	com/tencent/component/network/module/base/Config:canRetCodeRetry	(I)Z
    //   2226: istore 9
    //   2228: iload 9
    //   2230: ifeq +3078 -> 5308
    //   2233: iload 5
    //   2235: iconst_1
    //   2236: iadd
    //   2237: istore 5
    //   2239: aload_2
    //   2240: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2243: lload 15
    //   2245: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2248: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   2251: aload_2
    //   2252: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2255: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2258: aload_0
    //   2259: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   2262: lsub
    //   2263: putfield 678	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   2266: aload_2
    //   2267: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2270: aload_0
    //   2271: getfield 681	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   2274: putfield 684	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   2277: aload_0
    //   2278: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2281: invokestatic 689	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   2284: invokevirtual 693	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2287: astore 32
    //   2289: aload_0
    //   2290: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2293: ifnull +28 -> 2321
    //   2296: aload_0
    //   2297: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2300: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2303: ifnull +18 -> 2321
    //   2306: aload_0
    //   2307: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2310: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2313: getfield 502	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2316: astore 31
    //   2318: goto +6 -> 2324
    //   2321: aconst_null
    //   2322: astore 31
    //   2324: aload_0
    //   2325: aload_0
    //   2326: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2329: aload 23
    //   2331: aload 22
    //   2333: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   2336: astore 35
    //   2338: aload 27
    //   2340: ifnull +58 -> 2398
    //   2343: aload 27
    //   2345: ldc_w 699
    //   2348: invokeinterface 705 2 0
    //   2353: checkcast 282	java/lang/String
    //   2356: astore 29
    //   2358: goto +7 -> 2365
    //   2361: aload 21
    //   2363: astore 29
    //   2365: aload 27
    //   2367: ldc_w 707
    //   2370: invokeinterface 705 2 0
    //   2375: checkcast 282	java/lang/String
    //   2378: astore 26
    //   2380: aload 29
    //   2382: astore 27
    //   2384: goto +22 -> 2406
    //   2387: aload 21
    //   2389: astore 26
    //   2391: aload 29
    //   2393: astore 27
    //   2395: goto +11 -> 2406
    //   2398: aload 21
    //   2400: astore 26
    //   2402: aload 26
    //   2404: astore 27
    //   2406: aload_2
    //   2407: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2410: aload 27
    //   2412: putfield 710	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   2415: aload_0
    //   2416: lconst_0
    //   2417: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   2420: aload_0
    //   2421: iconst_0
    //   2422: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   2425: aload_0
    //   2426: lconst_0
    //   2427: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   2430: aload_0
    //   2431: iconst_0
    //   2432: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   2435: aload_2
    //   2436: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2439: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2442: ifeq +12 -> 2454
    //   2445: aload_1
    //   2446: invokeinterface 359 1 0
    //   2451: ifeq +31 -> 2482
    //   2454: aload_0
    //   2455: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2458: ifnull +24 -> 2482
    //   2461: aload_0
    //   2462: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2465: aload_0
    //   2466: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2469: aload_2
    //   2470: invokevirtual 716	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2473: aload 23
    //   2475: aload 22
    //   2477: invokeinterface 720 5 0
    //   2482: aload_1
    //   2483: invokeinterface 359 1 0
    //   2488: ifne +2754 -> 5242
    //   2491: aload_0
    //   2492: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2495: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2498: istore 9
    //   2500: aload_2
    //   2501: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2504: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2507: ifne +926 -> 3433
    //   2510: new 123	java/lang/StringBuilder
    //   2513: dup
    //   2514: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   2517: astore 36
    //   2519: aload 36
    //   2521: ldc_w 722
    //   2524: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: pop
    //   2528: aload 36
    //   2530: aload_0
    //   2531: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2534: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: pop
    //   2538: aload 36
    //   2540: ldc_w 724
    //   2543: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: pop
    //   2547: aload 36
    //   2549: aload_0
    //   2550: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2553: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2556: pop
    //   2557: aload 36
    //   2559: ldc_w 729
    //   2562: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2565: pop
    //   2566: aload_0
    //   2567: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2570: ifeq +29 -> 2599
    //   2573: aload 22
    //   2575: ifnull +24 -> 2599
    //   2578: aload 22
    //   2580: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2583: ifnull +16 -> 2599
    //   2586: aload 22
    //   2588: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2591: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   2594: astore 29
    //   2596: goto +8 -> 2604
    //   2599: ldc_w 738
    //   2602: astore 29
    //   2604: aload 36
    //   2606: aload 29
    //   2608: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2611: pop
    //   2612: aload 36
    //   2614: ldc_w 740
    //   2617: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2620: pop
    //   2621: aload 36
    //   2623: aload 32
    //   2625: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2628: pop
    //   2629: aload 36
    //   2631: ldc_w 745
    //   2634: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2637: pop
    //   2638: aload 36
    //   2640: aload 31
    //   2642: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2645: pop
    //   2646: aload 36
    //   2648: ldc_w 747
    //   2651: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: pop
    //   2655: aload 36
    //   2657: aconst_null
    //   2658: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2661: pop
    //   2662: aload 36
    //   2664: ldc_w 749
    //   2667: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2670: pop
    //   2671: aload 36
    //   2673: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2676: invokevirtual 172	java/lang/Thread:getId	()J
    //   2679: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2682: pop
    //   2683: aload 36
    //   2685: ldc_w 751
    //   2688: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2691: pop
    //   2692: aload 36
    //   2694: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2697: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2700: pop
    //   2701: aload 36
    //   2703: ldc_w 753
    //   2706: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2709: pop
    //   2710: aload 36
    //   2712: aload_0
    //   2713: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   2716: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2719: pop
    //   2720: aload 36
    //   2722: ldc_w 755
    //   2725: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: pop
    //   2729: aload 36
    //   2731: aload_0
    //   2732: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   2735: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2738: pop
    //   2739: aload 36
    //   2741: ldc_w 757
    //   2744: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: pop
    //   2748: aload_0
    //   2749: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   2752: ifeq +19 -> 2771
    //   2755: aload_0
    //   2756: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2759: aload_0
    //   2760: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   2763: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   2766: astore 29
    //   2768: goto +6 -> 2774
    //   2771: aconst_null
    //   2772: astore 29
    //   2774: aload 36
    //   2776: aload 29
    //   2778: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2781: pop
    //   2782: aload 36
    //   2784: ldc_w 759
    //   2787: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2790: pop
    //   2791: aload 36
    //   2793: iload 9
    //   2795: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2798: pop
    //   2799: aload 36
    //   2801: ldc_w 761
    //   2804: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2807: pop
    //   2808: aload 36
    //   2810: aload 26
    //   2812: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2815: pop
    //   2816: aload 36
    //   2818: ldc_w 763
    //   2821: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2824: pop
    //   2825: aload 36
    //   2827: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2830: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2833: pop
    //   2834: aload 36
    //   2836: ldc_w 464
    //   2839: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2842: pop
    //   2843: aload 36
    //   2845: aload_2
    //   2846: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2849: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2852: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2855: pop
    //   2856: aload 36
    //   2858: ldc_w 768
    //   2861: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2864: pop
    //   2865: aload 36
    //   2867: aload_2
    //   2868: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2871: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2874: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2877: pop
    //   2878: aload 36
    //   2880: ldc_w 468
    //   2883: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2886: pop
    //   2887: aload 36
    //   2889: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2892: aload_0
    //   2893: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   2896: lsub
    //   2897: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2900: pop
    //   2901: aload 36
    //   2903: ldc_w 462
    //   2906: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2909: pop
    //   2910: aload 36
    //   2912: aload_2
    //   2913: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2916: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2919: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2922: pop
    //   2923: aload 36
    //   2925: ldc_w 776
    //   2928: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2931: pop
    //   2932: aload 36
    //   2934: aload_2
    //   2935: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2938: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2941: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2944: pop
    //   2945: aload 36
    //   2947: ldc_w 780
    //   2950: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2953: pop
    //   2954: aload 36
    //   2956: aload_2
    //   2957: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2960: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2963: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2966: pop
    //   2967: aload 36
    //   2969: ldc_w 785
    //   2972: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2975: pop
    //   2976: aload 36
    //   2978: aload_0
    //   2979: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   2982: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2985: pop
    //   2986: aload 36
    //   2988: ldc_w 460
    //   2991: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2994: pop
    //   2995: aload 36
    //   2997: aload_0
    //   2998: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   3001: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3004: pop
    //   3005: aload 36
    //   3007: ldc_w 790
    //   3010: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3013: pop
    //   3014: aload 36
    //   3016: aload_2
    //   3017: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3020: invokevirtual 793	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3023: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3026: pop
    //   3027: aload 36
    //   3029: ldc_w 795
    //   3032: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3035: pop
    //   3036: aload 36
    //   3038: iload 4
    //   3040: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3043: pop
    //   3044: aload 36
    //   3046: aload 28
    //   3048: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3051: pop
    //   3052: aload 36
    //   3054: aload 35
    //   3056: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3059: pop
    //   3060: aload 36
    //   3062: aload 30
    //   3064: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3067: pop
    //   3068: aload 36
    //   3070: aload 27
    //   3072: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3075: pop
    //   3076: aload 36
    //   3078: ldc_w 797
    //   3081: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3084: pop
    //   3085: aload_0
    //   3086: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3089: astore 28
    //   3091: aload 28
    //   3093: ifnull +16 -> 3109
    //   3096: aload 28
    //   3098: iconst_0
    //   3099: bipush 30
    //   3101: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   3104: astore 28
    //   3106: goto +3 -> 3109
    //   3109: aload 36
    //   3111: aload 28
    //   3113: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3116: pop
    //   3117: aload 36
    //   3119: ldc_w 803
    //   3122: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3125: pop
    //   3126: aload_0
    //   3127: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3130: ifnull +15 -> 3145
    //   3133: aload_0
    //   3134: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3137: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3140: istore 4
    //   3142: goto +6 -> 3148
    //   3145: iconst_0
    //   3146: istore 4
    //   3148: aload 36
    //   3150: iload 4
    //   3152: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3155: pop
    //   3156: aload 36
    //   3158: ldc_w 805
    //   3161: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3164: pop
    //   3165: aload 36
    //   3167: aload_2
    //   3168: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3171: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3174: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: pop
    //   3178: aload 36
    //   3180: ldc_w 810
    //   3183: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3186: pop
    //   3187: aload 36
    //   3189: lload 11
    //   3191: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3194: pop
    //   3195: aload 36
    //   3197: ldc_w 812
    //   3200: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3203: pop
    //   3204: aload 36
    //   3206: aload_0
    //   3207: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3210: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3213: pop
    //   3214: aload 36
    //   3216: ldc_w 460
    //   3219: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3222: pop
    //   3223: aload 36
    //   3225: aload_0
    //   3226: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3229: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3232: pop
    //   3233: aload 36
    //   3235: ldc_w 814
    //   3238: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3241: pop
    //   3242: aload 36
    //   3244: aload_0
    //   3245: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3248: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3251: pop
    //   3252: aload 36
    //   3254: ldc_w 460
    //   3257: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3260: pop
    //   3261: aload 36
    //   3263: aload_0
    //   3264: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3267: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3270: pop
    //   3271: aload 36
    //   3273: ldc_w 816
    //   3276: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3279: pop
    //   3280: aload 36
    //   3282: aload_0
    //   3283: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   3286: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3289: pop
    //   3290: aload 36
    //   3292: ldc_w 818
    //   3295: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3298: pop
    //   3299: aload 36
    //   3301: aload_0
    //   3302: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   3305: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3308: pop
    //   3309: aload 36
    //   3311: ldc_w 823
    //   3314: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: pop
    //   3318: aload 36
    //   3320: aload_0
    //   3321: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   3324: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3327: pop
    //   3328: aload 36
    //   3330: ldc_w 828
    //   3333: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: pop
    //   3337: aload_0
    //   3338: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3341: ifnull +17 -> 3358
    //   3344: aload_0
    //   3345: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3348: invokeinterface 458 1 0
    //   3353: astore 28
    //   3355: goto +6 -> 3361
    //   3358: aconst_null
    //   3359: astore 28
    //   3361: aload 36
    //   3363: aload 28
    //   3365: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3368: pop
    //   3369: aload 36
    //   3371: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3374: astore 28
    //   3376: aload 24
    //   3378: aload 28
    //   3380: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3383: ldc_w 833
    //   3386: aload 24
    //   3388: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3391: aconst_null
    //   3392: invokestatic 837	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3395: aload_0
    //   3396: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3399: astore 24
    //   3401: aload 24
    //   3403: ifnull +22 -> 3425
    //   3406: aload 24
    //   3408: ldc_w 839
    //   3411: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3414: ifeq +11 -> 3425
    //   3417: aload_0
    //   3418: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   3421: iconst_0
    //   3422: invokestatic 844	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   3425: ldc_w 425
    //   3428: astore 24
    //   3430: goto +853 -> 4283
    //   3433: aload 24
    //   3435: astore 29
    //   3437: new 123	java/lang/StringBuilder
    //   3440: dup
    //   3441: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   3444: astore 36
    //   3446: aload 36
    //   3448: ldc_w 846
    //   3451: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3454: pop
    //   3455: aload 36
    //   3457: aload_0
    //   3458: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3461: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3464: pop
    //   3465: aload 36
    //   3467: ldc_w 724
    //   3470: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3473: pop
    //   3474: aload 36
    //   3476: aload_0
    //   3477: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3480: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3483: pop
    //   3484: aload 36
    //   3486: ldc_w 729
    //   3489: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3492: pop
    //   3493: aload_0
    //   3494: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3497: ifeq +29 -> 3526
    //   3500: aload 22
    //   3502: ifnull +24 -> 3526
    //   3505: aload 22
    //   3507: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3510: ifnull +16 -> 3526
    //   3513: aload 22
    //   3515: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3518: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3521: astore 24
    //   3523: goto +8 -> 3531
    //   3526: ldc_w 738
    //   3529: astore 24
    //   3531: aload 36
    //   3533: aload 24
    //   3535: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3538: pop
    //   3539: aload 36
    //   3541: ldc_w 740
    //   3544: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3547: pop
    //   3548: aload 36
    //   3550: aload 32
    //   3552: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3555: pop
    //   3556: aload 36
    //   3558: ldc_w 745
    //   3561: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3564: pop
    //   3565: aload 36
    //   3567: aload 31
    //   3569: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3572: pop
    //   3573: aload 36
    //   3575: ldc_w 747
    //   3578: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: pop
    //   3582: aload 36
    //   3584: aconst_null
    //   3585: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3588: pop
    //   3589: aload 36
    //   3591: ldc_w 749
    //   3594: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3597: pop
    //   3598: aload 36
    //   3600: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3603: invokevirtual 172	java/lang/Thread:getId	()J
    //   3606: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3609: pop
    //   3610: aload 36
    //   3612: ldc_w 751
    //   3615: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3618: pop
    //   3619: aload 36
    //   3621: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3624: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3627: pop
    //   3628: aload 36
    //   3630: ldc_w 753
    //   3633: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3636: pop
    //   3637: aload 36
    //   3639: aload_0
    //   3640: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3643: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3646: pop
    //   3647: aload 36
    //   3649: ldc_w 755
    //   3652: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3655: pop
    //   3656: aload 36
    //   3658: aload_0
    //   3659: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3662: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3665: pop
    //   3666: aload 36
    //   3668: ldc_w 757
    //   3671: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3674: pop
    //   3675: aload_0
    //   3676: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3679: ifeq +19 -> 3698
    //   3682: aload_0
    //   3683: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3686: aload_0
    //   3687: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3690: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3693: astore 24
    //   3695: goto +6 -> 3701
    //   3698: aconst_null
    //   3699: astore 24
    //   3701: aload 36
    //   3703: aload 24
    //   3705: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3708: pop
    //   3709: aload 36
    //   3711: ldc_w 763
    //   3714: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3717: pop
    //   3718: aload 36
    //   3720: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3723: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3726: pop
    //   3727: aload 36
    //   3729: ldc_w 761
    //   3732: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3735: pop
    //   3736: aload 36
    //   3738: aload 26
    //   3740: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3743: pop
    //   3744: aload 36
    //   3746: ldc_w 768
    //   3749: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3752: pop
    //   3753: aload 36
    //   3755: aload_2
    //   3756: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3759: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3762: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3765: pop
    //   3766: aload 36
    //   3768: ldc_w 468
    //   3771: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3774: pop
    //   3775: aload 36
    //   3777: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3780: aload_0
    //   3781: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3784: lsub
    //   3785: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3788: pop
    //   3789: aload 36
    //   3791: ldc_w 462
    //   3794: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3797: pop
    //   3798: aload 36
    //   3800: aload_2
    //   3801: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3804: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3807: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3810: pop
    //   3811: aload 36
    //   3813: ldc_w 776
    //   3816: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3819: pop
    //   3820: aload 36
    //   3822: aload_2
    //   3823: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3826: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3829: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3832: pop
    //   3833: aload 36
    //   3835: ldc_w 780
    //   3838: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3841: pop
    //   3842: aload 36
    //   3844: aload_2
    //   3845: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3848: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3851: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3854: pop
    //   3855: aload 36
    //   3857: ldc_w 785
    //   3860: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3863: pop
    //   3864: aload 36
    //   3866: aload_0
    //   3867: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   3870: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3873: pop
    //   3874: aload 36
    //   3876: ldc_w 460
    //   3879: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3882: pop
    //   3883: aload 36
    //   3885: aload_0
    //   3886: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   3889: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3892: pop
    //   3893: aload 36
    //   3895: ldc_w 848
    //   3898: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3901: pop
    //   3902: aload 36
    //   3904: iload 4
    //   3906: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3909: pop
    //   3910: aload 36
    //   3912: aload 28
    //   3914: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3917: pop
    //   3918: aload 36
    //   3920: aload 35
    //   3922: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3925: pop
    //   3926: aload 36
    //   3928: ldc_w 464
    //   3931: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3934: pop
    //   3935: aload 36
    //   3937: aload_2
    //   3938: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3941: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3944: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3947: pop
    //   3948: aload 36
    //   3950: aload 30
    //   3952: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3955: pop
    //   3956: aload 36
    //   3958: aload 27
    //   3960: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3963: pop
    //   3964: aload 36
    //   3966: ldc_w 797
    //   3969: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3972: pop
    //   3973: aload_0
    //   3974: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3977: astore 24
    //   3979: aload 24
    //   3981: ifnull +16 -> 3997
    //   3984: aload 24
    //   3986: iconst_0
    //   3987: bipush 30
    //   3989: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   3992: astore 24
    //   3994: goto +3 -> 3997
    //   3997: aload 36
    //   3999: aload 24
    //   4001: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4004: pop
    //   4005: aload 36
    //   4007: ldc_w 803
    //   4010: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4013: pop
    //   4014: aload_0
    //   4015: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4018: ifnull +15 -> 4033
    //   4021: aload_0
    //   4022: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4025: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4028: istore 4
    //   4030: goto +6 -> 4036
    //   4033: iconst_0
    //   4034: istore 4
    //   4036: aload 36
    //   4038: iload 4
    //   4040: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4043: pop
    //   4044: aload 36
    //   4046: ldc_w 805
    //   4049: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4052: pop
    //   4053: aload 36
    //   4055: aload_2
    //   4056: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4059: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4062: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4065: pop
    //   4066: aload 36
    //   4068: ldc_w 810
    //   4071: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4074: pop
    //   4075: aload 30
    //   4077: astore 24
    //   4079: aload 36
    //   4081: lload 11
    //   4083: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4086: pop
    //   4087: aload 36
    //   4089: ldc_w 812
    //   4092: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4095: pop
    //   4096: aload 36
    //   4098: aload_0
    //   4099: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4102: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4105: pop
    //   4106: aload 36
    //   4108: ldc_w 460
    //   4111: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4114: pop
    //   4115: aload 36
    //   4117: aload_0
    //   4118: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   4121: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4124: pop
    //   4125: aload 36
    //   4127: ldc_w 814
    //   4130: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4133: pop
    //   4134: aload 36
    //   4136: aload_0
    //   4137: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   4140: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4143: pop
    //   4144: aload 36
    //   4146: ldc_w 460
    //   4149: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4152: pop
    //   4153: aload 36
    //   4155: aload_0
    //   4156: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   4159: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4162: pop
    //   4163: aload 36
    //   4165: ldc_w 816
    //   4168: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4171: pop
    //   4172: aload 36
    //   4174: aload_0
    //   4175: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   4178: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4181: pop
    //   4182: aload 36
    //   4184: ldc_w 818
    //   4187: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4190: pop
    //   4191: aload 36
    //   4193: aload_0
    //   4194: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   4197: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4200: pop
    //   4201: aload 36
    //   4203: ldc_w 823
    //   4206: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4209: pop
    //   4210: aload 36
    //   4212: aload_0
    //   4213: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   4216: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4219: pop
    //   4220: aload 36
    //   4222: ldc_w 828
    //   4225: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4228: pop
    //   4229: aload_0
    //   4230: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4233: ifnull +17 -> 4250
    //   4236: aload_0
    //   4237: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4240: invokeinterface 458 1 0
    //   4245: astore 28
    //   4247: goto +6 -> 4253
    //   4250: aconst_null
    //   4251: astore 28
    //   4253: aload 36
    //   4255: aload 28
    //   4257: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4260: pop
    //   4261: aload 29
    //   4263: aload 36
    //   4265: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4268: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4271: ldc_w 833
    //   4274: aload 29
    //   4276: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4279: aconst_null
    //   4280: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4283: iload_3
    //   4284: istore 4
    //   4286: iload 9
    //   4288: ifne +8 -> 4296
    //   4291: aload_0
    //   4292: iconst_0
    //   4293: putfield 854	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   4296: aload_2
    //   4297: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4300: astore 28
    //   4302: new 123	java/lang/StringBuilder
    //   4305: dup
    //   4306: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   4309: astore 29
    //   4311: aload 29
    //   4313: aload_0
    //   4314: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   4317: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4320: pop
    //   4321: aload 29
    //   4323: ldc_w 856
    //   4326: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4329: pop
    //   4330: aload 29
    //   4332: aload 31
    //   4334: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4337: pop
    //   4338: aload 29
    //   4340: ldc_w 858
    //   4343: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4346: pop
    //   4347: aload 29
    //   4349: aload_2
    //   4350: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4353: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4356: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4359: pop
    //   4360: aload 29
    //   4362: ldc_w 860
    //   4365: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4368: pop
    //   4369: aload_0
    //   4370: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4373: ifnull +14 -> 4387
    //   4376: aload_0
    //   4377: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4380: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4383: istore_3
    //   4384: goto +5 -> 4389
    //   4387: iconst_0
    //   4388: istore_3
    //   4389: aload 29
    //   4391: iload_3
    //   4392: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4395: pop
    //   4396: aload 29
    //   4398: ldc_w 795
    //   4401: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4404: pop
    //   4405: aload 29
    //   4407: iload 4
    //   4409: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4412: pop
    //   4413: aload 29
    //   4415: ldc_w 464
    //   4418: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4421: pop
    //   4422: aload 29
    //   4424: aload_2
    //   4425: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4428: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4431: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4434: pop
    //   4435: aload 29
    //   4437: ldc_w 462
    //   4440: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4443: pop
    //   4444: aload 29
    //   4446: aload_2
    //   4447: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4450: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4453: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4456: pop
    //   4457: aload 29
    //   4459: ldc_w 776
    //   4462: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4465: pop
    //   4466: aload 29
    //   4468: aload_2
    //   4469: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4472: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4475: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4478: pop
    //   4479: aload 29
    //   4481: ldc_w 768
    //   4484: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4487: pop
    //   4488: aload 29
    //   4490: aload_2
    //   4491: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4494: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4497: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4500: pop
    //   4501: aload 29
    //   4503: ldc_w 468
    //   4506: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4509: pop
    //   4510: aload 29
    //   4512: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4515: aload_0
    //   4516: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4519: lsub
    //   4520: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4523: pop
    //   4524: aload 27
    //   4526: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4529: ifne +38 -> 4567
    //   4532: new 123	java/lang/StringBuilder
    //   4535: dup
    //   4536: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   4539: astore 21
    //   4541: aload 21
    //   4543: aload 24
    //   4545: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4548: pop
    //   4549: aload 21
    //   4551: aload 27
    //   4553: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4556: pop
    //   4557: aload 21
    //   4559: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4562: astore 21
    //   4564: goto +3 -> 4567
    //   4567: aload 29
    //   4569: aload 21
    //   4571: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4574: pop
    //   4575: aload 29
    //   4577: ldc_w 427
    //   4580: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4583: pop
    //   4584: aload 29
    //   4586: aload 35
    //   4588: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4591: pop
    //   4592: aload 28
    //   4594: aload 29
    //   4596: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4599: putfield 863	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   4602: aload_0
    //   4603: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4606: ifnull +121 -> 4727
    //   4609: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4612: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4615: aload_0
    //   4616: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4619: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4622: if_icmpne +105 -> 4727
    //   4625: aload_0
    //   4626: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4629: ifnull +98 -> 4727
    //   4632: aload 26
    //   4634: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4637: ifne +40 -> 4677
    //   4640: aload_0
    //   4641: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4644: astore 21
    //   4646: aload_0
    //   4647: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4650: astore 24
    //   4652: aload_2
    //   4653: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4656: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4659: istore 10
    //   4661: aload 21
    //   4663: aload 24
    //   4665: aload 26
    //   4667: iload 10
    //   4669: invokeinterface 867 4 0
    //   4674: goto +53 -> 4727
    //   4677: aload_0
    //   4678: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4681: aload_0
    //   4682: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4685: aload_0
    //   4686: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4689: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4692: aload_2
    //   4693: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4696: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4699: invokeinterface 867 4 0
    //   4704: goto +23 -> 4727
    //   4707: astore 21
    //   4709: goto +5 -> 4714
    //   4712: astore 21
    //   4714: aload 34
    //   4716: ldc_w 872
    //   4719: aload 21
    //   4721: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4724: goto +3 -> 4727
    //   4727: aload_0
    //   4728: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4731: ifnull +101 -> 4832
    //   4734: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4737: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4740: aload_0
    //   4741: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4744: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4747: if_icmpne +85 -> 4832
    //   4750: aload_0
    //   4751: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4754: ifnull +78 -> 4832
    //   4757: aload 26
    //   4759: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4762: ifne +28 -> 4790
    //   4765: aload_0
    //   4766: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4769: aload_0
    //   4770: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4773: aload 26
    //   4775: aload_2
    //   4776: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4779: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4782: invokeinterface 867 4 0
    //   4787: goto +45 -> 4832
    //   4790: aload_0
    //   4791: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4794: aload_0
    //   4795: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4798: aload_0
    //   4799: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4802: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4805: aload_2
    //   4806: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4809: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4812: invokeinterface 867 4 0
    //   4817: goto +15 -> 4832
    //   4820: astore 21
    //   4822: ldc 225
    //   4824: ldc_w 874
    //   4827: aload 21
    //   4829: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4832: iload 9
    //   4834: ifeq +74 -> 4908
    //   4837: aload_0
    //   4838: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4841: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   4844: astore 21
    //   4846: aload_0
    //   4847: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4850: astore 24
    //   4852: aload_0
    //   4853: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4856: ifeq +30 -> 4886
    //   4859: aload_0
    //   4860: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4863: astore 26
    //   4865: aload 26
    //   4867: ifnull +19 -> 4886
    //   4870: aload 26
    //   4872: aload 33
    //   4874: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4877: ifeq +9 -> 4886
    //   4880: iconst_1
    //   4881: istore 9
    //   4883: goto +6 -> 4889
    //   4886: iconst_0
    //   4887: istore 9
    //   4889: aload 21
    //   4891: aload 24
    //   4893: iload 9
    //   4895: aload_2
    //   4896: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4899: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4902: invokevirtual 878	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   4905: goto +3 -> 4908
    //   4908: aload 25
    //   4910: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   4913: putfield 881	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4916: aload 25
    //   4918: aload_0
    //   4919: invokevirtual 884	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   4922: putfield 887	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4925: aload 25
    //   4927: aload 23
    //   4929: putfield 891	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4932: aload 25
    //   4934: aload 22
    //   4936: putfield 895	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   4939: aload 25
    //   4941: iload 4
    //   4943: putfield 896	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4946: aload 25
    //   4948: aconst_null
    //   4949: putfield 900	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4952: aload 32
    //   4954: ifnonnull +9 -> 4963
    //   4957: aconst_null
    //   4958: astore 21
    //   4960: goto +10 -> 4970
    //   4963: aload 32
    //   4965: invokevirtual 903	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   4968: astore 21
    //   4970: aload 25
    //   4972: aload 21
    //   4974: putfield 906	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4977: aload 25
    //   4979: aconst_null
    //   4980: putfield 909	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4983: aload 25
    //   4985: aload_2
    //   4986: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4989: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4992: putfield 910	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4995: aload 25
    //   4997: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5000: aload_0
    //   5001: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5004: lsub
    //   5005: putfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5008: aload 25
    //   5010: aload_2
    //   5011: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5014: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5017: putfield 916	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   5020: aload 25
    //   5022: aload 25
    //   5024: getfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5027: aload_2
    //   5028: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5031: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5034: lsub
    //   5035: putfield 919	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5038: aload 25
    //   5040: lload 11
    //   5042: putfield 922	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5045: aload 25
    //   5047: aload_0
    //   5048: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5051: putfield 925	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5054: aload 25
    //   5056: aload_0
    //   5057: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   5060: putfield 928	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5063: aload 25
    //   5065: aload_0
    //   5066: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   5069: putfield 931	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5072: aload 25
    //   5074: lconst_0
    //   5075: putfield 934	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5078: aload 25
    //   5080: aload_0
    //   5081: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   5084: putfield 937	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   5087: aload 25
    //   5089: aload_2
    //   5090: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5093: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5096: putfield 940	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5099: aload 25
    //   5101: aload_0
    //   5102: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5105: invokestatic 943	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   5108: putfield 945	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   5111: aload 25
    //   5113: aload_0
    //   5114: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5117: putfield 948	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   5120: aload_0
    //   5121: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5124: astore 21
    //   5126: aload 21
    //   5128: ifnull +20 -> 5148
    //   5131: aload 21
    //   5133: ldc_w 466
    //   5136: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5139: ifeq +9 -> 5148
    //   5142: iconst_1
    //   5143: istore 9
    //   5145: goto +6 -> 5151
    //   5148: iconst_0
    //   5149: istore 9
    //   5151: aload 25
    //   5153: iload 9
    //   5155: putfield 951	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   5158: aload 25
    //   5160: aload_2
    //   5161: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5164: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5167: putfield 953	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   5170: aload 25
    //   5172: getstatic 959	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   5175: invokevirtual 962	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   5178: putfield 965	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   5181: aload 22
    //   5183: ifnull +24 -> 5207
    //   5186: aload 22
    //   5188: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5191: ifnull +16 -> 5207
    //   5194: aload 25
    //   5196: aload 22
    //   5198: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5201: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5204: putfield 967	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   5207: aload_2
    //   5208: astore 21
    //   5210: aload 21
    //   5212: aload 25
    //   5214: invokevirtual 971	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5217: aload_2
    //   5218: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5221: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5224: ifeq +15 -> 5239
    //   5227: aload_0
    //   5228: aload_1
    //   5229: aload 21
    //   5231: aload 25
    //   5233: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5236: goto +6 -> 5242
    //   5239: goto +3 -> 5242
    //   5242: aload_0
    //   5243: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5246: ifeq +27 -> 5273
    //   5249: aload_0
    //   5250: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   5253: ifnull +12 -> 5265
    //   5256: aload_0
    //   5257: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   5260: invokeinterface 974 1 0
    //   5265: aload_0
    //   5266: aconst_null
    //   5267: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   5270: goto +26 -> 5296
    //   5273: aload_0
    //   5274: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   5277: ifnull +15 -> 5292
    //   5280: aload_0
    //   5281: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   5284: invokevirtual 979	org/apache/http/client/methods/HttpGet:abort	()V
    //   5287: aload_0
    //   5288: aconst_null
    //   5289: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   5292: aload_0
    //   5293: invokevirtual 982	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   5296: aload_1
    //   5297: astore 22
    //   5299: iload 5
    //   5301: istore_3
    //   5302: aload_2
    //   5303: astore 21
    //   5305: goto +13144 -> 18449
    //   5308: aload_2
    //   5309: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5312: lload 15
    //   5314: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5317: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   5320: aload_2
    //   5321: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5324: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5327: aload_0
    //   5328: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5331: lsub
    //   5332: putfield 678	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   5335: aload_2
    //   5336: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5339: aload_0
    //   5340: getfield 681	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   5343: putfield 684	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   5346: aload_0
    //   5347: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5350: invokestatic 689	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   5353: invokevirtual 693	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   5356: astore 32
    //   5358: aload_0
    //   5359: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5362: ifnull +28 -> 5390
    //   5365: aload_0
    //   5366: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5369: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5372: ifnull +18 -> 5390
    //   5375: aload_0
    //   5376: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5379: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5382: getfield 502	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   5385: astore 29
    //   5387: goto +6 -> 5393
    //   5390: aconst_null
    //   5391: astore 29
    //   5393: aload_0
    //   5394: aload_0
    //   5395: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   5398: aload 23
    //   5400: aload 22
    //   5402: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   5405: astore 35
    //   5407: aload 27
    //   5409: ifnull +66 -> 5475
    //   5412: aload 27
    //   5414: ldc_w 699
    //   5417: invokeinterface 705 2 0
    //   5422: checkcast 282	java/lang/String
    //   5425: astore 26
    //   5427: goto +7 -> 5434
    //   5430: aload 21
    //   5432: astore 26
    //   5434: aload 27
    //   5436: ldc_w 707
    //   5439: invokeinterface 705 2 0
    //   5444: checkcast 282	java/lang/String
    //   5447: astore 31
    //   5449: aload 26
    //   5451: astore 27
    //   5453: aload 31
    //   5455: astore 26
    //   5457: goto +26 -> 5483
    //   5460: aload 21
    //   5462: astore 31
    //   5464: aload 26
    //   5466: astore 27
    //   5468: aload 31
    //   5470: astore 26
    //   5472: goto +11 -> 5483
    //   5475: aload 21
    //   5477: astore 27
    //   5479: aload 27
    //   5481: astore 26
    //   5483: aload_2
    //   5484: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5487: aload 27
    //   5489: putfield 710	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   5492: aload_0
    //   5493: lconst_0
    //   5494: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5497: aload_0
    //   5498: iconst_0
    //   5499: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   5502: aload_0
    //   5503: lconst_0
    //   5504: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   5507: aload_0
    //   5508: iconst_0
    //   5509: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   5512: aload_2
    //   5513: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5516: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5519: ifeq +12 -> 5531
    //   5522: aload_1
    //   5523: invokeinterface 359 1 0
    //   5528: ifeq +31 -> 5559
    //   5531: aload_0
    //   5532: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5535: ifnull +24 -> 5559
    //   5538: aload_0
    //   5539: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5542: aload_0
    //   5543: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5546: aload_2
    //   5547: invokevirtual 716	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   5550: aload 23
    //   5552: aload 22
    //   5554: invokeinterface 720 5 0
    //   5559: aload_1
    //   5560: invokeinterface 359 1 0
    //   5565: ifne +2726 -> 8291
    //   5568: aload_0
    //   5569: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5572: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5575: istore 8
    //   5577: aload_2
    //   5578: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5581: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5584: ifne +918 -> 6502
    //   5587: new 123	java/lang/StringBuilder
    //   5590: dup
    //   5591: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   5594: astore 36
    //   5596: aload 36
    //   5598: ldc_w 722
    //   5601: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5604: pop
    //   5605: aload 36
    //   5607: aload_0
    //   5608: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5611: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5614: pop
    //   5615: aload 36
    //   5617: ldc_w 724
    //   5620: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5623: pop
    //   5624: aload 36
    //   5626: aload_0
    //   5627: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5630: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5633: pop
    //   5634: aload 36
    //   5636: ldc_w 729
    //   5639: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5642: pop
    //   5643: aload_0
    //   5644: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5647: ifeq +29 -> 5676
    //   5650: aload 22
    //   5652: ifnull +24 -> 5676
    //   5655: aload 22
    //   5657: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5660: ifnull +16 -> 5676
    //   5663: aload 22
    //   5665: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5668: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5671: astore 31
    //   5673: goto +8 -> 5681
    //   5676: ldc_w 738
    //   5679: astore 31
    //   5681: aload 36
    //   5683: aload 31
    //   5685: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5688: pop
    //   5689: aload 36
    //   5691: ldc_w 740
    //   5694: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5697: pop
    //   5698: aload 36
    //   5700: aload 32
    //   5702: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5705: pop
    //   5706: aload 36
    //   5708: ldc_w 745
    //   5711: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5714: pop
    //   5715: aload 36
    //   5717: aload 29
    //   5719: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5722: pop
    //   5723: aload 36
    //   5725: ldc_w 747
    //   5728: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5731: pop
    //   5732: aload 36
    //   5734: aconst_null
    //   5735: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5738: pop
    //   5739: aload 36
    //   5741: ldc_w 749
    //   5744: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5747: pop
    //   5748: aload 36
    //   5750: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5753: invokevirtual 172	java/lang/Thread:getId	()J
    //   5756: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5759: pop
    //   5760: aload 36
    //   5762: ldc_w 751
    //   5765: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5768: pop
    //   5769: aload 36
    //   5771: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5774: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5777: pop
    //   5778: aload 36
    //   5780: ldc_w 753
    //   5783: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5786: pop
    //   5787: aload 36
    //   5789: aload_0
    //   5790: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5793: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5796: pop
    //   5797: aload 36
    //   5799: ldc_w 755
    //   5802: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5805: pop
    //   5806: aload 36
    //   5808: aload_0
    //   5809: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5812: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5815: pop
    //   5816: aload 36
    //   5818: ldc_w 757
    //   5821: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5824: pop
    //   5825: aload_0
    //   5826: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5829: ifeq +19 -> 5848
    //   5832: aload_0
    //   5833: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5836: aload_0
    //   5837: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5840: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5843: astore 31
    //   5845: goto +6 -> 5851
    //   5848: aconst_null
    //   5849: astore 31
    //   5851: aload 36
    //   5853: aload 31
    //   5855: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5858: pop
    //   5859: aload 36
    //   5861: ldc_w 759
    //   5864: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5867: pop
    //   5868: aload 36
    //   5870: iload 8
    //   5872: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5875: pop
    //   5876: aload 36
    //   5878: ldc_w 761
    //   5881: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5884: pop
    //   5885: aload 36
    //   5887: aload 26
    //   5889: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5892: pop
    //   5893: aload 36
    //   5895: ldc_w 763
    //   5898: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5901: pop
    //   5902: aload 36
    //   5904: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5907: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5910: pop
    //   5911: aload 36
    //   5913: ldc_w 464
    //   5916: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5919: pop
    //   5920: aload 36
    //   5922: aload_2
    //   5923: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5926: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5929: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5932: pop
    //   5933: aload 36
    //   5935: ldc_w 768
    //   5938: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5941: pop
    //   5942: aload 36
    //   5944: aload_2
    //   5945: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5948: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5951: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5954: pop
    //   5955: aload 36
    //   5957: ldc_w 468
    //   5960: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5963: pop
    //   5964: aload 36
    //   5966: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5969: aload_0
    //   5970: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5973: lsub
    //   5974: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5977: pop
    //   5978: aload 36
    //   5980: ldc_w 462
    //   5983: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5986: pop
    //   5987: aload 36
    //   5989: aload_2
    //   5990: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5993: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5996: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5999: pop
    //   6000: aload 36
    //   6002: ldc_w 776
    //   6005: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6008: pop
    //   6009: aload 36
    //   6011: aload_2
    //   6012: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6015: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6018: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6021: pop
    //   6022: aload 36
    //   6024: ldc_w 780
    //   6027: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6030: pop
    //   6031: aload 36
    //   6033: aload_2
    //   6034: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6037: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6040: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6043: pop
    //   6044: aload 36
    //   6046: ldc_w 785
    //   6049: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6052: pop
    //   6053: aload 36
    //   6055: aload_0
    //   6056: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   6059: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6062: pop
    //   6063: aload 36
    //   6065: ldc_w 460
    //   6068: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6071: pop
    //   6072: aload 36
    //   6074: aload_0
    //   6075: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   6078: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6081: pop
    //   6082: aload 36
    //   6084: ldc_w 790
    //   6087: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6090: pop
    //   6091: aload 36
    //   6093: aload_2
    //   6094: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6097: invokevirtual 793	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   6100: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6103: pop
    //   6104: aload 36
    //   6106: ldc_w 795
    //   6109: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6112: pop
    //   6113: aload 36
    //   6115: iload 4
    //   6117: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6120: pop
    //   6121: aload 36
    //   6123: aload 28
    //   6125: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6128: pop
    //   6129: aload 36
    //   6131: aload 35
    //   6133: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6136: pop
    //   6137: aload 36
    //   6139: aload 30
    //   6141: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6144: pop
    //   6145: aload 36
    //   6147: aload 27
    //   6149: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6152: pop
    //   6153: aload 36
    //   6155: ldc_w 797
    //   6158: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6161: pop
    //   6162: aload_0
    //   6163: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6166: astore 28
    //   6168: aload 28
    //   6170: ifnull +16 -> 6186
    //   6173: aload 28
    //   6175: iconst_0
    //   6176: bipush 30
    //   6178: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   6181: astore 28
    //   6183: goto +3 -> 6186
    //   6186: aload 36
    //   6188: aload 28
    //   6190: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6193: pop
    //   6194: aload 36
    //   6196: ldc_w 803
    //   6199: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6202: pop
    //   6203: aload_0
    //   6204: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6207: ifnull +14 -> 6221
    //   6210: aload_0
    //   6211: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6214: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6217: istore_3
    //   6218: goto +5 -> 6223
    //   6221: iconst_0
    //   6222: istore_3
    //   6223: aload 36
    //   6225: iload_3
    //   6226: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6229: pop
    //   6230: aload 36
    //   6232: ldc_w 805
    //   6235: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6238: pop
    //   6239: aload 36
    //   6241: aload_2
    //   6242: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6245: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6248: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6251: pop
    //   6252: aload 36
    //   6254: ldc_w 810
    //   6257: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6260: pop
    //   6261: aload 36
    //   6263: lload 11
    //   6265: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6268: pop
    //   6269: aload 36
    //   6271: ldc_w 812
    //   6274: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6277: pop
    //   6278: aload 36
    //   6280: aload_0
    //   6281: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   6284: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6287: pop
    //   6288: aload 36
    //   6290: ldc_w 460
    //   6293: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6296: pop
    //   6297: aload 36
    //   6299: aload_0
    //   6300: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   6303: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6306: pop
    //   6307: aload 36
    //   6309: ldc_w 814
    //   6312: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6315: pop
    //   6316: aload 36
    //   6318: aload_0
    //   6319: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   6322: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6325: pop
    //   6326: aload 36
    //   6328: ldc_w 460
    //   6331: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6334: pop
    //   6335: aload 36
    //   6337: aload_0
    //   6338: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   6341: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6344: pop
    //   6345: aload 36
    //   6347: ldc_w 816
    //   6350: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6353: pop
    //   6354: aload 36
    //   6356: aload_0
    //   6357: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   6360: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6363: pop
    //   6364: aload 36
    //   6366: ldc_w 818
    //   6369: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6372: pop
    //   6373: aload 36
    //   6375: aload_0
    //   6376: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   6379: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6382: pop
    //   6383: aload 36
    //   6385: ldc_w 823
    //   6388: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6391: pop
    //   6392: aload 36
    //   6394: aload_0
    //   6395: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   6398: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6401: pop
    //   6402: aload 36
    //   6404: ldc_w 828
    //   6407: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6410: pop
    //   6411: aload_0
    //   6412: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6415: ifnull +17 -> 6432
    //   6418: aload_0
    //   6419: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6422: invokeinterface 458 1 0
    //   6427: astore 28
    //   6429: goto +6 -> 6435
    //   6432: aconst_null
    //   6433: astore 28
    //   6435: aload 36
    //   6437: aload 28
    //   6439: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6442: pop
    //   6443: aload 36
    //   6445: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6448: astore 28
    //   6450: aload 24
    //   6452: aload 28
    //   6454: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6457: ldc_w 833
    //   6460: aload 24
    //   6462: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6465: aconst_null
    //   6466: invokestatic 837	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6469: aload_0
    //   6470: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6473: astore 24
    //   6475: aload 24
    //   6477: ifnull +22 -> 6499
    //   6480: aload 24
    //   6482: ldc_w 839
    //   6485: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6488: ifeq +11 -> 6499
    //   6491: aload_0
    //   6492: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6495: iconst_0
    //   6496: invokestatic 844	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   6499: goto +846 -> 7345
    //   6502: aload 24
    //   6504: astore 31
    //   6506: new 123	java/lang/StringBuilder
    //   6509: dup
    //   6510: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   6513: astore 36
    //   6515: aload 36
    //   6517: ldc_w 846
    //   6520: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6523: pop
    //   6524: aload 36
    //   6526: aload_0
    //   6527: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   6530: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6533: pop
    //   6534: aload 36
    //   6536: ldc_w 724
    //   6539: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6542: pop
    //   6543: aload 36
    //   6545: aload_0
    //   6546: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6549: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6552: pop
    //   6553: aload 36
    //   6555: ldc_w 729
    //   6558: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6561: pop
    //   6562: aload_0
    //   6563: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6566: ifeq +29 -> 6595
    //   6569: aload 22
    //   6571: ifnull +24 -> 6595
    //   6574: aload 22
    //   6576: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6579: ifnull +16 -> 6595
    //   6582: aload 22
    //   6584: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6587: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6590: astore 24
    //   6592: goto +8 -> 6600
    //   6595: ldc_w 738
    //   6598: astore 24
    //   6600: aload 36
    //   6602: aload 24
    //   6604: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6607: pop
    //   6608: aload 36
    //   6610: ldc_w 740
    //   6613: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6616: pop
    //   6617: aload 36
    //   6619: aload 32
    //   6621: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6624: pop
    //   6625: aload 36
    //   6627: ldc_w 745
    //   6630: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6633: pop
    //   6634: aload 36
    //   6636: aload 29
    //   6638: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6641: pop
    //   6642: aload 36
    //   6644: ldc_w 747
    //   6647: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6650: pop
    //   6651: aload 36
    //   6653: aconst_null
    //   6654: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6657: pop
    //   6658: aload 36
    //   6660: ldc_w 749
    //   6663: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6666: pop
    //   6667: aload 36
    //   6669: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6672: invokevirtual 172	java/lang/Thread:getId	()J
    //   6675: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6678: pop
    //   6679: aload 36
    //   6681: ldc_w 751
    //   6684: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6687: pop
    //   6688: aload 36
    //   6690: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6693: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6696: pop
    //   6697: aload 36
    //   6699: ldc_w 753
    //   6702: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6705: pop
    //   6706: aload 36
    //   6708: aload_0
    //   6709: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   6712: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6715: pop
    //   6716: aload 36
    //   6718: ldc_w 755
    //   6721: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6724: pop
    //   6725: aload 36
    //   6727: aload_0
    //   6728: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   6731: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6734: pop
    //   6735: aload 36
    //   6737: ldc_w 757
    //   6740: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6743: pop
    //   6744: aload_0
    //   6745: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   6748: ifeq +19 -> 6767
    //   6751: aload_0
    //   6752: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   6755: aload_0
    //   6756: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   6759: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   6762: astore 24
    //   6764: goto +6 -> 6770
    //   6767: aconst_null
    //   6768: astore 24
    //   6770: aload 36
    //   6772: aload 24
    //   6774: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6777: pop
    //   6778: aload 36
    //   6780: ldc_w 763
    //   6783: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6786: pop
    //   6787: aload 36
    //   6789: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6792: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6795: pop
    //   6796: aload 36
    //   6798: ldc_w 761
    //   6801: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6804: pop
    //   6805: aload 36
    //   6807: aload 26
    //   6809: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6812: pop
    //   6813: aload 36
    //   6815: ldc_w 768
    //   6818: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6821: pop
    //   6822: aload 36
    //   6824: aload_2
    //   6825: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6828: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6831: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6834: pop
    //   6835: aload 36
    //   6837: ldc_w 468
    //   6840: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6843: pop
    //   6844: aload 36
    //   6846: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   6849: aload_0
    //   6850: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   6853: lsub
    //   6854: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6857: pop
    //   6858: aload 36
    //   6860: ldc_w 462
    //   6863: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6866: pop
    //   6867: aload 36
    //   6869: aload_2
    //   6870: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6873: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6876: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6879: pop
    //   6880: aload 36
    //   6882: ldc_w 776
    //   6885: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6888: pop
    //   6889: aload 36
    //   6891: aload_2
    //   6892: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6895: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6898: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6901: pop
    //   6902: aload 36
    //   6904: ldc_w 780
    //   6907: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6910: pop
    //   6911: aload 36
    //   6913: aload_2
    //   6914: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6917: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6920: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6923: pop
    //   6924: aload 36
    //   6926: ldc_w 785
    //   6929: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6932: pop
    //   6933: aload 36
    //   6935: aload_0
    //   6936: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   6939: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6942: pop
    //   6943: aload 36
    //   6945: ldc_w 460
    //   6948: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6951: pop
    //   6952: aload 36
    //   6954: aload_0
    //   6955: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   6958: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6961: pop
    //   6962: aload 36
    //   6964: ldc_w 848
    //   6967: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6970: pop
    //   6971: aload 36
    //   6973: iload 4
    //   6975: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6978: pop
    //   6979: aload 36
    //   6981: aload 28
    //   6983: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6986: pop
    //   6987: aload 36
    //   6989: aload 35
    //   6991: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6994: pop
    //   6995: aload 36
    //   6997: ldc_w 464
    //   7000: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7003: pop
    //   7004: aload 36
    //   7006: aload_2
    //   7007: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7010: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7013: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7016: pop
    //   7017: aload 36
    //   7019: aload 30
    //   7021: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7024: pop
    //   7025: aload 36
    //   7027: aload 27
    //   7029: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7032: pop
    //   7033: aload 36
    //   7035: ldc_w 797
    //   7038: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7041: pop
    //   7042: aload_0
    //   7043: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7046: astore 24
    //   7048: aload 24
    //   7050: ifnull +16 -> 7066
    //   7053: aload 24
    //   7055: iconst_0
    //   7056: bipush 30
    //   7058: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   7061: astore 24
    //   7063: goto +3 -> 7066
    //   7066: aload 36
    //   7068: aload 24
    //   7070: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7073: pop
    //   7074: aload 36
    //   7076: ldc_w 803
    //   7079: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7082: pop
    //   7083: aload_0
    //   7084: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7087: ifnull +14 -> 7101
    //   7090: aload_0
    //   7091: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7094: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7097: istore_3
    //   7098: goto +5 -> 7103
    //   7101: iconst_0
    //   7102: istore_3
    //   7103: aload 36
    //   7105: iload_3
    //   7106: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7109: pop
    //   7110: aload 36
    //   7112: ldc_w 805
    //   7115: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7118: pop
    //   7119: aload 36
    //   7121: aload_2
    //   7122: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7125: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7128: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7131: pop
    //   7132: aload 36
    //   7134: ldc_w 810
    //   7137: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7140: pop
    //   7141: aload 36
    //   7143: lload 11
    //   7145: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7148: pop
    //   7149: aload 36
    //   7151: ldc_w 812
    //   7154: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7157: pop
    //   7158: aload 36
    //   7160: aload_0
    //   7161: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   7164: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7167: pop
    //   7168: aload 36
    //   7170: ldc_w 460
    //   7173: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7176: pop
    //   7177: aload 36
    //   7179: aload_0
    //   7180: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   7183: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7186: pop
    //   7187: aload 36
    //   7189: ldc_w 814
    //   7192: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7195: pop
    //   7196: aload 36
    //   7198: aload_0
    //   7199: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   7202: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7205: pop
    //   7206: aload 36
    //   7208: ldc_w 460
    //   7211: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7214: pop
    //   7215: aload 36
    //   7217: aload_0
    //   7218: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   7221: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7224: pop
    //   7225: aload 36
    //   7227: ldc_w 816
    //   7230: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7233: pop
    //   7234: aload 36
    //   7236: aload_0
    //   7237: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   7240: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7243: pop
    //   7244: aload 36
    //   7246: ldc_w 818
    //   7249: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7252: pop
    //   7253: aload 36
    //   7255: aload_0
    //   7256: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   7259: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7262: pop
    //   7263: aload 36
    //   7265: ldc_w 823
    //   7268: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7271: pop
    //   7272: aload 36
    //   7274: aload_0
    //   7275: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   7278: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7281: pop
    //   7282: aload 36
    //   7284: ldc_w 828
    //   7287: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7290: pop
    //   7291: aload_0
    //   7292: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7295: ifnull +17 -> 7312
    //   7298: aload_0
    //   7299: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7302: invokeinterface 458 1 0
    //   7307: astore 24
    //   7309: goto +6 -> 7315
    //   7312: aconst_null
    //   7313: astore 24
    //   7315: aload 36
    //   7317: aload 24
    //   7319: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7322: pop
    //   7323: aload 31
    //   7325: aload 36
    //   7327: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7330: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7333: ldc_w 833
    //   7336: aload 31
    //   7338: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7341: aconst_null
    //   7342: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7345: iload 8
    //   7347: ifne +8 -> 7355
    //   7350: aload_0
    //   7351: iconst_0
    //   7352: putfield 854	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   7355: aload_2
    //   7356: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7359: astore 24
    //   7361: new 123	java/lang/StringBuilder
    //   7364: dup
    //   7365: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   7368: astore 28
    //   7370: aload 28
    //   7372: aload_0
    //   7373: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7376: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7379: pop
    //   7380: aload 28
    //   7382: ldc_w 856
    //   7385: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7388: pop
    //   7389: aload 28
    //   7391: aload 29
    //   7393: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7396: pop
    //   7397: aload 28
    //   7399: ldc_w 858
    //   7402: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7405: pop
    //   7406: aload 28
    //   7408: aload_2
    //   7409: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7412: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7415: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7418: pop
    //   7419: aload 28
    //   7421: ldc_w 860
    //   7424: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7427: pop
    //   7428: aload_0
    //   7429: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7432: ifnull +14 -> 7446
    //   7435: aload_0
    //   7436: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7439: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7442: istore_3
    //   7443: goto +5 -> 7448
    //   7446: iconst_0
    //   7447: istore_3
    //   7448: aload 28
    //   7450: iload_3
    //   7451: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7454: pop
    //   7455: aload 28
    //   7457: ldc_w 795
    //   7460: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7463: pop
    //   7464: aload 28
    //   7466: iload 4
    //   7468: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7471: pop
    //   7472: aload 28
    //   7474: ldc_w 464
    //   7477: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7480: pop
    //   7481: aload 28
    //   7483: aload_2
    //   7484: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7487: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7490: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7493: pop
    //   7494: aload 28
    //   7496: ldc_w 462
    //   7499: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7502: pop
    //   7503: aload 28
    //   7505: aload_2
    //   7506: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7509: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7512: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7515: pop
    //   7516: aload 28
    //   7518: ldc_w 776
    //   7521: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7524: pop
    //   7525: aload 28
    //   7527: aload_2
    //   7528: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7531: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7534: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7537: pop
    //   7538: aload 28
    //   7540: ldc_w 768
    //   7543: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7546: pop
    //   7547: aload 28
    //   7549: aload_2
    //   7550: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7553: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7556: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7559: pop
    //   7560: aload 28
    //   7562: ldc_w 468
    //   7565: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7568: pop
    //   7569: aload 28
    //   7571: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7574: aload_0
    //   7575: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7578: lsub
    //   7579: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7582: pop
    //   7583: aload 27
    //   7585: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7588: ifne +39 -> 7627
    //   7591: new 123	java/lang/StringBuilder
    //   7594: dup
    //   7595: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   7598: astore 21
    //   7600: aload 21
    //   7602: ldc_w 425
    //   7605: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7608: pop
    //   7609: aload 21
    //   7611: aload 27
    //   7613: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7616: pop
    //   7617: aload 21
    //   7619: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7622: astore 21
    //   7624: goto +3 -> 7627
    //   7627: aload 28
    //   7629: aload 21
    //   7631: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7634: pop
    //   7635: aload 28
    //   7637: ldc_w 427
    //   7640: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7643: pop
    //   7644: aload 28
    //   7646: aload 35
    //   7648: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7651: pop
    //   7652: aload 24
    //   7654: aload 28
    //   7656: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7659: putfield 863	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   7662: aload_0
    //   7663: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7666: ifnull +121 -> 7787
    //   7669: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7672: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7675: aload_0
    //   7676: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7679: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7682: if_icmpne +105 -> 7787
    //   7685: aload_0
    //   7686: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7689: ifnull +98 -> 7787
    //   7692: aload 26
    //   7694: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7697: ifne +40 -> 7737
    //   7700: aload_0
    //   7701: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7704: astore 21
    //   7706: aload_0
    //   7707: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   7710: astore 24
    //   7712: aload_2
    //   7713: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7716: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7719: istore 9
    //   7721: aload 21
    //   7723: aload 24
    //   7725: aload 26
    //   7727: iload 9
    //   7729: invokeinterface 867 4 0
    //   7734: goto +53 -> 7787
    //   7737: aload_0
    //   7738: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7741: aload_0
    //   7742: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   7745: aload_0
    //   7746: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7749: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   7752: aload_2
    //   7753: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7756: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7759: invokeinterface 867 4 0
    //   7764: goto +23 -> 7787
    //   7767: astore 21
    //   7769: goto +5 -> 7774
    //   7772: astore 21
    //   7774: aload 34
    //   7776: ldc_w 872
    //   7779: aload 21
    //   7781: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7784: goto +3 -> 7787
    //   7787: aload_0
    //   7788: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7791: ifnull +101 -> 7892
    //   7794: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7797: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7800: aload_0
    //   7801: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7804: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7807: if_icmpne +85 -> 7892
    //   7810: aload_0
    //   7811: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7814: ifnull +78 -> 7892
    //   7817: aload 26
    //   7819: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7822: ifne +28 -> 7850
    //   7825: aload_0
    //   7826: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7829: aload_0
    //   7830: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   7833: aload 26
    //   7835: aload_2
    //   7836: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7839: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7842: invokeinterface 867 4 0
    //   7847: goto +45 -> 7892
    //   7850: aload_0
    //   7851: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7854: aload_0
    //   7855: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   7858: aload_0
    //   7859: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7862: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   7865: aload_2
    //   7866: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7869: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7872: invokeinterface 867 4 0
    //   7877: goto +15 -> 7892
    //   7880: astore 21
    //   7882: ldc 225
    //   7884: ldc_w 874
    //   7887: aload 21
    //   7889: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7892: iload 8
    //   7894: ifeq +74 -> 7968
    //   7897: aload_0
    //   7898: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7901: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   7904: astore 21
    //   7906: aload_0
    //   7907: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7910: astore 24
    //   7912: aload_0
    //   7913: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7916: ifeq +30 -> 7946
    //   7919: aload_0
    //   7920: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7923: astore 26
    //   7925: aload 26
    //   7927: ifnull +19 -> 7946
    //   7930: aload 26
    //   7932: aload 33
    //   7934: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7937: ifeq +9 -> 7946
    //   7940: iconst_1
    //   7941: istore 8
    //   7943: goto +6 -> 7949
    //   7946: iconst_0
    //   7947: istore 8
    //   7949: aload 21
    //   7951: aload 24
    //   7953: iload 8
    //   7955: aload_2
    //   7956: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7959: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7962: invokevirtual 878	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   7965: goto +3 -> 7968
    //   7968: aload 25
    //   7970: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   7973: putfield 881	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   7976: aload 25
    //   7978: aload_0
    //   7979: invokevirtual 884	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   7982: putfield 887	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   7985: aload 25
    //   7987: aload 23
    //   7989: putfield 891	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   7992: aload 25
    //   7994: aload 22
    //   7996: putfield 895	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   7999: aload 25
    //   8001: iload 4
    //   8003: putfield 896	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   8006: aload 25
    //   8008: aconst_null
    //   8009: putfield 900	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   8012: aload 32
    //   8014: ifnonnull +9 -> 8023
    //   8017: aconst_null
    //   8018: astore 21
    //   8020: goto +10 -> 8030
    //   8023: aload 32
    //   8025: invokevirtual 903	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8028: astore 21
    //   8030: aload 25
    //   8032: aload 21
    //   8034: putfield 906	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   8037: aload 25
    //   8039: aconst_null
    //   8040: putfield 909	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   8043: aload 25
    //   8045: aload_2
    //   8046: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8049: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8052: putfield 910	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   8055: aload 25
    //   8057: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8060: aload_0
    //   8061: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8064: lsub
    //   8065: putfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   8068: aload 25
    //   8070: aload_2
    //   8071: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8074: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8077: putfield 916	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   8080: aload 25
    //   8082: aload 25
    //   8084: getfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   8087: aload_2
    //   8088: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8091: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8094: lsub
    //   8095: putfield 919	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   8098: aload 25
    //   8100: lload 11
    //   8102: putfield 922	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   8105: aload 25
    //   8107: aload_0
    //   8108: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8111: putfield 925	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   8114: aload 25
    //   8116: aload_0
    //   8117: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   8120: putfield 928	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   8123: aload 25
    //   8125: aload_0
    //   8126: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   8129: putfield 931	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   8132: aload 25
    //   8134: lconst_0
    //   8135: putfield 934	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   8138: aload 25
    //   8140: aload_0
    //   8141: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   8144: putfield 937	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   8147: aload 25
    //   8149: aload_2
    //   8150: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8153: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8156: putfield 940	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   8159: aload 25
    //   8161: aload_0
    //   8162: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8165: invokestatic 943	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   8168: putfield 945	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   8171: aload 25
    //   8173: aload_0
    //   8174: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8177: putfield 948	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   8180: aload_0
    //   8181: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8184: astore 21
    //   8186: aload 21
    //   8188: ifnull +20 -> 8208
    //   8191: aload 21
    //   8193: ldc_w 466
    //   8196: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8199: ifeq +9 -> 8208
    //   8202: iconst_1
    //   8203: istore 8
    //   8205: goto +6 -> 8211
    //   8208: iconst_0
    //   8209: istore 8
    //   8211: aload 25
    //   8213: iload 8
    //   8215: putfield 951	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   8218: aload 25
    //   8220: aload_2
    //   8221: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8224: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8227: putfield 953	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   8230: aload 25
    //   8232: getstatic 959	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   8235: invokevirtual 962	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   8238: putfield 965	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   8241: aload 22
    //   8243: ifnull +24 -> 8267
    //   8246: aload 22
    //   8248: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8251: ifnull +16 -> 8267
    //   8254: aload 25
    //   8256: aload 22
    //   8258: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8261: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8264: putfield 967	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   8267: aload_2
    //   8268: aload 25
    //   8270: invokevirtual 971	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   8273: aload_2
    //   8274: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8277: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8280: ifeq +11 -> 8291
    //   8283: aload_0
    //   8284: aload_1
    //   8285: aload_2
    //   8286: aload 25
    //   8288: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   8291: aload_0
    //   8292: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8295: ifeq +25 -> 8320
    //   8298: aload_0
    //   8299: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   8302: ifnull +12 -> 8314
    //   8305: aload_0
    //   8306: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   8309: invokeinterface 974 1 0
    //   8314: aload_0
    //   8315: aconst_null
    //   8316: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   8319: return
    //   8320: aload_0
    //   8321: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8324: ifnull +15 -> 8339
    //   8327: aload_0
    //   8328: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8331: invokevirtual 979	org/apache/http/client/methods/HttpGet:abort	()V
    //   8334: aload_0
    //   8335: aconst_null
    //   8336: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8339: aload_0
    //   8340: invokevirtual 982	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   8343: return
    //   8344: astore 32
    //   8346: ldc_w 462
    //   8349: astore 31
    //   8351: aload 27
    //   8353: astore 21
    //   8355: lload 11
    //   8357: lstore 13
    //   8359: aconst_null
    //   8360: astore 35
    //   8362: aload 23
    //   8364: astore 26
    //   8366: ldc_w 464
    //   8369: astore 29
    //   8371: aload 28
    //   8373: astore 23
    //   8375: ldc_w 460
    //   8378: astore 25
    //   8380: aload 22
    //   8382: astore 27
    //   8384: iload 4
    //   8386: istore_3
    //   8387: lload 15
    //   8389: lstore 11
    //   8391: ldc_w 468
    //   8394: astore 22
    //   8396: aload 21
    //   8398: astore 28
    //   8400: aload 22
    //   8402: astore 21
    //   8404: aload 23
    //   8406: astore 22
    //   8408: aload 27
    //   8410: astore 23
    //   8412: aload 32
    //   8414: astore 27
    //   8416: aload 24
    //   8418: astore 32
    //   8420: aload 35
    //   8422: astore 24
    //   8424: goto +10123 -> 18547
    //   8427: astore 25
    //   8429: ldc_w 462
    //   8432: astore 31
    //   8434: aload 23
    //   8436: astore 26
    //   8438: ldc_w 460
    //   8441: astore 29
    //   8443: aload 22
    //   8445: astore 23
    //   8447: iload 4
    //   8449: istore_3
    //   8450: aload 26
    //   8452: astore 22
    //   8454: aload 29
    //   8456: astore 26
    //   8458: goto +6778 -> 15236
    //   8461: aload_2
    //   8462: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8465: lload 15
    //   8467: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8470: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   8473: aload_2
    //   8474: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8477: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8480: aload_0
    //   8481: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8484: lsub
    //   8485: putfield 678	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8488: aload_2
    //   8489: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8492: aload_0
    //   8493: getfield 681	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   8496: putfield 684	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8499: aload_0
    //   8500: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8503: invokestatic 689	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8506: invokevirtual 693	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8509: astore 32
    //   8511: aload_0
    //   8512: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8515: ifnull +28 -> 8543
    //   8518: aload_0
    //   8519: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8522: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8525: ifnull +18 -> 8543
    //   8528: aload_0
    //   8529: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8532: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8535: getfield 502	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   8538: astore 29
    //   8540: goto +6 -> 8546
    //   8543: aconst_null
    //   8544: astore 29
    //   8546: aload_0
    //   8547: aload_0
    //   8548: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8551: aload 23
    //   8553: aload 22
    //   8555: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   8558: astore 35
    //   8560: aload 27
    //   8562: ifnull +66 -> 8628
    //   8565: aload 27
    //   8567: ldc_w 699
    //   8570: invokeinterface 705 2 0
    //   8575: checkcast 282	java/lang/String
    //   8578: astore 26
    //   8580: goto +7 -> 8587
    //   8583: aload 21
    //   8585: astore 26
    //   8587: aload 27
    //   8589: ldc_w 707
    //   8592: invokeinterface 705 2 0
    //   8597: checkcast 282	java/lang/String
    //   8600: astore 31
    //   8602: aload 26
    //   8604: astore 27
    //   8606: aload 31
    //   8608: astore 26
    //   8610: goto +26 -> 8636
    //   8613: aload 21
    //   8615: astore 31
    //   8617: aload 26
    //   8619: astore 27
    //   8621: aload 31
    //   8623: astore 26
    //   8625: goto +11 -> 8636
    //   8628: aload 21
    //   8630: astore 27
    //   8632: aload 27
    //   8634: astore 26
    //   8636: aload_2
    //   8637: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8640: aload 27
    //   8642: putfield 710	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8645: aload_0
    //   8646: lconst_0
    //   8647: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8650: aload_0
    //   8651: iconst_0
    //   8652: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8655: aload_0
    //   8656: lconst_0
    //   8657: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8660: aload_0
    //   8661: iconst_0
    //   8662: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8665: aload_2
    //   8666: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8669: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8672: ifeq +12 -> 8684
    //   8675: aload_1
    //   8676: invokeinterface 359 1 0
    //   8681: ifeq +31 -> 8712
    //   8684: aload_0
    //   8685: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8688: ifnull +24 -> 8712
    //   8691: aload_0
    //   8692: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8695: aload_0
    //   8696: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8699: aload_2
    //   8700: invokevirtual 716	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   8703: aload 23
    //   8705: aload 22
    //   8707: invokeinterface 720 5 0
    //   8712: aload_1
    //   8713: invokeinterface 359 1 0
    //   8718: ifne +2747 -> 11465
    //   8721: aload_0
    //   8722: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8725: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8728: istore 8
    //   8730: aload_2
    //   8731: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8734: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8737: ifne +926 -> 9663
    //   8740: new 123	java/lang/StringBuilder
    //   8743: dup
    //   8744: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   8747: astore 36
    //   8749: aload 36
    //   8751: ldc_w 722
    //   8754: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8757: pop
    //   8758: aload 36
    //   8760: aload_0
    //   8761: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8764: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8767: pop
    //   8768: aload 36
    //   8770: ldc_w 724
    //   8773: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8776: pop
    //   8777: aload 36
    //   8779: aload_0
    //   8780: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8783: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8786: pop
    //   8787: aload 36
    //   8789: ldc_w 729
    //   8792: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8795: pop
    //   8796: aload_0
    //   8797: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8800: ifeq +29 -> 8829
    //   8803: aload 22
    //   8805: ifnull +24 -> 8829
    //   8808: aload 22
    //   8810: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8813: ifnull +16 -> 8829
    //   8816: aload 22
    //   8818: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8821: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8824: astore 31
    //   8826: goto +8 -> 8834
    //   8829: ldc_w 738
    //   8832: astore 31
    //   8834: aload 36
    //   8836: aload 31
    //   8838: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8841: pop
    //   8842: aload 36
    //   8844: ldc_w 740
    //   8847: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8850: pop
    //   8851: aload 36
    //   8853: aload 32
    //   8855: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8858: pop
    //   8859: aload 36
    //   8861: ldc_w 745
    //   8864: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8867: pop
    //   8868: aload 36
    //   8870: aload 29
    //   8872: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8875: pop
    //   8876: aload 36
    //   8878: ldc_w 747
    //   8881: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8884: pop
    //   8885: aload 36
    //   8887: aconst_null
    //   8888: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8891: pop
    //   8892: aload 36
    //   8894: ldc_w 749
    //   8897: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8900: pop
    //   8901: aload 36
    //   8903: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8906: invokevirtual 172	java/lang/Thread:getId	()J
    //   8909: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8912: pop
    //   8913: aload 36
    //   8915: ldc_w 751
    //   8918: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8921: pop
    //   8922: aload 36
    //   8924: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8927: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8930: pop
    //   8931: aload 36
    //   8933: ldc_w 753
    //   8936: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8939: pop
    //   8940: aload 36
    //   8942: aload_0
    //   8943: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8946: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8949: pop
    //   8950: aload 36
    //   8952: ldc_w 755
    //   8955: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8958: pop
    //   8959: aload 36
    //   8961: aload_0
    //   8962: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8965: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8968: pop
    //   8969: aload 36
    //   8971: ldc_w 757
    //   8974: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8977: pop
    //   8978: aload_0
    //   8979: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8982: ifeq +19 -> 9001
    //   8985: aload_0
    //   8986: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8989: aload_0
    //   8990: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8993: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8996: astore 31
    //   8998: goto +6 -> 9004
    //   9001: aconst_null
    //   9002: astore 31
    //   9004: aload 36
    //   9006: aload 31
    //   9008: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9011: pop
    //   9012: aload 36
    //   9014: ldc_w 759
    //   9017: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9020: pop
    //   9021: aload 36
    //   9023: iload 8
    //   9025: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9028: pop
    //   9029: aload 36
    //   9031: ldc_w 761
    //   9034: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9037: pop
    //   9038: aload 36
    //   9040: aload 26
    //   9042: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9045: pop
    //   9046: aload 36
    //   9048: ldc_w 763
    //   9051: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9054: pop
    //   9055: aload 36
    //   9057: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9060: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9063: pop
    //   9064: aload 36
    //   9066: ldc_w 464
    //   9069: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9072: pop
    //   9073: aload 36
    //   9075: aload_2
    //   9076: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9079: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9082: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9085: pop
    //   9086: aload 36
    //   9088: ldc_w 768
    //   9091: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9094: pop
    //   9095: aload 36
    //   9097: aload_2
    //   9098: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9101: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9104: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9107: pop
    //   9108: aload 36
    //   9110: ldc_w 468
    //   9113: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9116: pop
    //   9117: aload 36
    //   9119: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9122: aload_0
    //   9123: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9126: lsub
    //   9127: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9130: pop
    //   9131: aload 36
    //   9133: ldc_w 462
    //   9136: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9139: pop
    //   9140: aload 36
    //   9142: aload_2
    //   9143: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9146: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9149: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9152: pop
    //   9153: aload 36
    //   9155: ldc_w 776
    //   9158: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9161: pop
    //   9162: aload 36
    //   9164: aload_2
    //   9165: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9168: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9171: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9174: pop
    //   9175: aload 36
    //   9177: ldc_w 780
    //   9180: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9183: pop
    //   9184: aload 36
    //   9186: aload_2
    //   9187: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9190: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9193: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9196: pop
    //   9197: aload 36
    //   9199: ldc_w 785
    //   9202: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9205: pop
    //   9206: aload 36
    //   9208: aload_0
    //   9209: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   9212: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9215: pop
    //   9216: aload 36
    //   9218: ldc_w 460
    //   9221: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9224: pop
    //   9225: aload 36
    //   9227: aload_0
    //   9228: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   9231: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9234: pop
    //   9235: aload 36
    //   9237: ldc_w 790
    //   9240: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9243: pop
    //   9244: aload 36
    //   9246: aload_2
    //   9247: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9250: invokevirtual 793	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   9253: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9256: pop
    //   9257: aload 36
    //   9259: ldc_w 795
    //   9262: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9265: pop
    //   9266: aload 36
    //   9268: iload 4
    //   9270: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9273: pop
    //   9274: aload 36
    //   9276: aload 28
    //   9278: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9281: pop
    //   9282: aload 36
    //   9284: aload 35
    //   9286: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9289: pop
    //   9290: aload 36
    //   9292: aload 30
    //   9294: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9297: pop
    //   9298: aload 36
    //   9300: aload 27
    //   9302: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9305: pop
    //   9306: aload 36
    //   9308: ldc_w 797
    //   9311: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9314: pop
    //   9315: aload_0
    //   9316: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9319: astore 28
    //   9321: aload 28
    //   9323: ifnull +16 -> 9339
    //   9326: aload 28
    //   9328: iconst_0
    //   9329: bipush 30
    //   9331: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   9334: astore 28
    //   9336: goto +3 -> 9339
    //   9339: aload 36
    //   9341: aload 28
    //   9343: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9346: pop
    //   9347: aload 36
    //   9349: ldc_w 803
    //   9352: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9355: pop
    //   9356: aload_0
    //   9357: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9360: ifnull +15 -> 9375
    //   9363: aload_0
    //   9364: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9367: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9370: istore 4
    //   9372: goto +6 -> 9378
    //   9375: iconst_0
    //   9376: istore 4
    //   9378: aload 36
    //   9380: iload 4
    //   9382: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9385: pop
    //   9386: aload 36
    //   9388: ldc_w 805
    //   9391: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9394: pop
    //   9395: aload 36
    //   9397: aload_2
    //   9398: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9401: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9404: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9407: pop
    //   9408: aload 36
    //   9410: ldc_w 810
    //   9413: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9416: pop
    //   9417: aload 36
    //   9419: lload 11
    //   9421: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9424: pop
    //   9425: aload 36
    //   9427: ldc_w 812
    //   9430: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9433: pop
    //   9434: aload 36
    //   9436: aload_0
    //   9437: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9440: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9443: pop
    //   9444: aload 36
    //   9446: ldc_w 460
    //   9449: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9452: pop
    //   9453: aload 36
    //   9455: aload_0
    //   9456: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   9459: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9462: pop
    //   9463: aload 36
    //   9465: ldc_w 814
    //   9468: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9471: pop
    //   9472: aload 36
    //   9474: aload_0
    //   9475: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   9478: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9481: pop
    //   9482: aload 36
    //   9484: ldc_w 460
    //   9487: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9490: pop
    //   9491: aload 36
    //   9493: aload_0
    //   9494: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   9497: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9500: pop
    //   9501: aload 36
    //   9503: ldc_w 816
    //   9506: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9509: pop
    //   9510: aload 36
    //   9512: aload_0
    //   9513: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   9516: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9519: pop
    //   9520: aload 36
    //   9522: ldc_w 818
    //   9525: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9528: pop
    //   9529: aload 36
    //   9531: aload_0
    //   9532: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   9535: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9538: pop
    //   9539: aload 36
    //   9541: ldc_w 823
    //   9544: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9547: pop
    //   9548: aload 36
    //   9550: aload_0
    //   9551: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   9554: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9557: pop
    //   9558: aload 36
    //   9560: ldc_w 828
    //   9563: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9566: pop
    //   9567: aload_0
    //   9568: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9571: ifnull +17 -> 9588
    //   9574: aload_0
    //   9575: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9578: invokeinterface 458 1 0
    //   9583: astore 28
    //   9585: goto +6 -> 9591
    //   9588: aconst_null
    //   9589: astore 28
    //   9591: aload 36
    //   9593: aload 28
    //   9595: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9598: pop
    //   9599: aload 36
    //   9601: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9604: astore 28
    //   9606: aload 24
    //   9608: aload 28
    //   9610: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9613: ldc_w 833
    //   9616: aload 24
    //   9618: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9621: aconst_null
    //   9622: invokestatic 837	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9625: aload_0
    //   9626: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9629: astore 24
    //   9631: aload 24
    //   9633: ifnull +22 -> 9655
    //   9636: aload 24
    //   9638: ldc_w 839
    //   9641: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9644: ifeq +11 -> 9655
    //   9647: aload_0
    //   9648: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9651: iconst_0
    //   9652: invokestatic 844	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   9655: ldc_w 464
    //   9658: astore 24
    //   9660: goto +857 -> 10517
    //   9663: aload 24
    //   9665: astore 31
    //   9667: new 123	java/lang/StringBuilder
    //   9670: dup
    //   9671: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   9674: astore 36
    //   9676: aload 36
    //   9678: ldc_w 846
    //   9681: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9684: pop
    //   9685: aload 36
    //   9687: aload_0
    //   9688: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   9691: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9694: pop
    //   9695: aload 36
    //   9697: ldc_w 724
    //   9700: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9703: pop
    //   9704: aload 36
    //   9706: aload_0
    //   9707: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9710: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9713: pop
    //   9714: aload 36
    //   9716: ldc_w 729
    //   9719: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9722: pop
    //   9723: aload_0
    //   9724: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9727: ifeq +29 -> 9756
    //   9730: aload 22
    //   9732: ifnull +24 -> 9756
    //   9735: aload 22
    //   9737: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9740: ifnull +16 -> 9756
    //   9743: aload 22
    //   9745: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9748: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9751: astore 24
    //   9753: goto +8 -> 9761
    //   9756: ldc_w 738
    //   9759: astore 24
    //   9761: aload 36
    //   9763: aload 24
    //   9765: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9768: pop
    //   9769: aload 36
    //   9771: ldc_w 740
    //   9774: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9777: pop
    //   9778: aload 36
    //   9780: aload 32
    //   9782: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9785: pop
    //   9786: aload 36
    //   9788: ldc_w 745
    //   9791: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9794: pop
    //   9795: aload 36
    //   9797: aload 29
    //   9799: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9802: pop
    //   9803: aload 36
    //   9805: ldc_w 747
    //   9808: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9811: pop
    //   9812: aload 36
    //   9814: aconst_null
    //   9815: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9818: pop
    //   9819: aload 36
    //   9821: ldc_w 749
    //   9824: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9827: pop
    //   9828: aload 36
    //   9830: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9833: invokevirtual 172	java/lang/Thread:getId	()J
    //   9836: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9839: pop
    //   9840: aload 36
    //   9842: ldc_w 751
    //   9845: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9848: pop
    //   9849: aload 36
    //   9851: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9854: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9857: pop
    //   9858: aload 36
    //   9860: ldc_w 753
    //   9863: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9866: pop
    //   9867: aload 36
    //   9869: aload_0
    //   9870: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9873: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9876: pop
    //   9877: aload 36
    //   9879: ldc_w 755
    //   9882: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9885: pop
    //   9886: aload 36
    //   9888: aload_0
    //   9889: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9892: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9895: pop
    //   9896: aload 36
    //   9898: ldc_w 757
    //   9901: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9904: pop
    //   9905: aload_0
    //   9906: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9909: ifeq +19 -> 9928
    //   9912: aload_0
    //   9913: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9916: aload_0
    //   9917: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9920: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9923: astore 24
    //   9925: goto +6 -> 9931
    //   9928: aconst_null
    //   9929: astore 24
    //   9931: aload 36
    //   9933: aload 24
    //   9935: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9938: pop
    //   9939: aload 36
    //   9941: ldc_w 763
    //   9944: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9947: pop
    //   9948: aload 36
    //   9950: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9953: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9956: pop
    //   9957: aload 36
    //   9959: ldc_w 761
    //   9962: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9965: pop
    //   9966: aload 36
    //   9968: aload 26
    //   9970: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9973: pop
    //   9974: aload 36
    //   9976: ldc_w 768
    //   9979: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9982: pop
    //   9983: aload 36
    //   9985: aload_2
    //   9986: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9989: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9992: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9995: pop
    //   9996: aload 36
    //   9998: ldc_w 468
    //   10001: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10004: pop
    //   10005: aload 36
    //   10007: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10010: aload_0
    //   10011: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10014: lsub
    //   10015: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10018: pop
    //   10019: aload 36
    //   10021: ldc_w 462
    //   10024: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10027: pop
    //   10028: aload 36
    //   10030: aload_2
    //   10031: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10034: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10037: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10040: pop
    //   10041: aload 36
    //   10043: ldc_w 776
    //   10046: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10049: pop
    //   10050: aload 36
    //   10052: aload_2
    //   10053: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10056: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10059: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10062: pop
    //   10063: aload 36
    //   10065: ldc_w 780
    //   10068: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10071: pop
    //   10072: aload 36
    //   10074: aload_2
    //   10075: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10078: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10081: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10084: pop
    //   10085: aload 36
    //   10087: ldc_w 785
    //   10090: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10093: pop
    //   10094: aload 36
    //   10096: aload_0
    //   10097: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   10100: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10103: pop
    //   10104: aload 36
    //   10106: ldc_w 460
    //   10109: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10112: pop
    //   10113: aload 36
    //   10115: aload_0
    //   10116: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   10119: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10122: pop
    //   10123: aload 36
    //   10125: ldc_w 848
    //   10128: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10131: pop
    //   10132: aload 36
    //   10134: iload 4
    //   10136: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10139: pop
    //   10140: aload 36
    //   10142: aload 28
    //   10144: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10147: pop
    //   10148: aload 36
    //   10150: aload 35
    //   10152: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10155: pop
    //   10156: ldc_w 464
    //   10159: astore 28
    //   10161: aload 36
    //   10163: aload 28
    //   10165: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10168: pop
    //   10169: aload 36
    //   10171: aload_2
    //   10172: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10175: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10178: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10181: pop
    //   10182: aload 36
    //   10184: aload 30
    //   10186: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10189: pop
    //   10190: aload 36
    //   10192: aload 27
    //   10194: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10197: pop
    //   10198: aload 36
    //   10200: ldc_w 797
    //   10203: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10206: pop
    //   10207: aload_0
    //   10208: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10211: astore 24
    //   10213: aload 24
    //   10215: ifnull +16 -> 10231
    //   10218: aload 24
    //   10220: iconst_0
    //   10221: bipush 30
    //   10223: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   10226: astore 24
    //   10228: goto +3 -> 10231
    //   10231: aload 36
    //   10233: aload 24
    //   10235: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10238: pop
    //   10239: aload 36
    //   10241: ldc_w 803
    //   10244: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10247: pop
    //   10248: aload_0
    //   10249: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10252: ifnull +15 -> 10267
    //   10255: aload_0
    //   10256: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10259: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10262: istore 4
    //   10264: goto +6 -> 10270
    //   10267: iconst_0
    //   10268: istore 4
    //   10270: aload 36
    //   10272: iload 4
    //   10274: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10277: pop
    //   10278: aload 36
    //   10280: ldc_w 805
    //   10283: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10286: pop
    //   10287: aload 36
    //   10289: aload_2
    //   10290: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10293: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10296: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10299: pop
    //   10300: aload 36
    //   10302: ldc_w 810
    //   10305: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10308: pop
    //   10309: aload 36
    //   10311: lload 11
    //   10313: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10316: pop
    //   10317: aload 36
    //   10319: ldc_w 812
    //   10322: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10325: pop
    //   10326: aload 36
    //   10328: aload_0
    //   10329: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10332: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10335: pop
    //   10336: aload 36
    //   10338: ldc_w 460
    //   10341: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10344: pop
    //   10345: aload 36
    //   10347: aload_0
    //   10348: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10351: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10354: pop
    //   10355: aload 36
    //   10357: ldc_w 814
    //   10360: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10363: pop
    //   10364: aload 36
    //   10366: aload_0
    //   10367: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10370: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10373: pop
    //   10374: aload 36
    //   10376: ldc_w 460
    //   10379: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10382: pop
    //   10383: aload 36
    //   10385: aload_0
    //   10386: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10389: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10392: pop
    //   10393: aload 36
    //   10395: ldc_w 816
    //   10398: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10401: pop
    //   10402: aload 36
    //   10404: aload_0
    //   10405: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   10408: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10411: pop
    //   10412: aload 36
    //   10414: ldc_w 818
    //   10417: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10420: pop
    //   10421: aload 36
    //   10423: aload_0
    //   10424: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   10427: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10430: pop
    //   10431: aload 36
    //   10433: ldc_w 823
    //   10436: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10439: pop
    //   10440: aload 36
    //   10442: aload_0
    //   10443: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   10446: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10449: pop
    //   10450: aload 36
    //   10452: ldc_w 828
    //   10455: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10458: pop
    //   10459: aload_0
    //   10460: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10463: ifnull +17 -> 10480
    //   10466: aload_0
    //   10467: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10470: invokeinterface 458 1 0
    //   10475: astore 24
    //   10477: goto +6 -> 10483
    //   10480: aconst_null
    //   10481: astore 24
    //   10483: aload 36
    //   10485: aload 24
    //   10487: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10490: pop
    //   10491: aload 31
    //   10493: aload 36
    //   10495: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10498: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10501: ldc_w 833
    //   10504: aload 31
    //   10506: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10509: aconst_null
    //   10510: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10513: aload 28
    //   10515: astore 24
    //   10517: iload_3
    //   10518: istore 4
    //   10520: iload 8
    //   10522: ifne +8 -> 10530
    //   10525: aload_0
    //   10526: iconst_0
    //   10527: putfield 854	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   10530: aload_2
    //   10531: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10534: astore 28
    //   10536: new 123	java/lang/StringBuilder
    //   10539: dup
    //   10540: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   10543: astore 30
    //   10545: aload 30
    //   10547: aload_0
    //   10548: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10551: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10554: pop
    //   10555: aload 30
    //   10557: ldc_w 856
    //   10560: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10563: pop
    //   10564: aload 30
    //   10566: aload 29
    //   10568: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10571: pop
    //   10572: aload 30
    //   10574: ldc_w 858
    //   10577: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10580: pop
    //   10581: aload 30
    //   10583: aload_2
    //   10584: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10587: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10590: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10593: pop
    //   10594: aload 30
    //   10596: ldc_w 860
    //   10599: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10602: pop
    //   10603: aload_0
    //   10604: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10607: ifnull +14 -> 10621
    //   10610: aload_0
    //   10611: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10614: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10617: istore_3
    //   10618: goto +5 -> 10623
    //   10621: iconst_0
    //   10622: istore_3
    //   10623: aload 30
    //   10625: iload_3
    //   10626: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10629: pop
    //   10630: aload 30
    //   10632: ldc_w 795
    //   10635: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10638: pop
    //   10639: aload 30
    //   10641: iload 4
    //   10643: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10646: pop
    //   10647: aload 30
    //   10649: aload 24
    //   10651: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10654: pop
    //   10655: aload 30
    //   10657: aload_2
    //   10658: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10661: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10664: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10667: pop
    //   10668: aload 30
    //   10670: ldc_w 462
    //   10673: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10676: pop
    //   10677: aload 30
    //   10679: aload_2
    //   10680: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10683: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10686: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10689: pop
    //   10690: aload 30
    //   10692: ldc_w 776
    //   10695: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10698: pop
    //   10699: aload 30
    //   10701: aload_2
    //   10702: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10705: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10708: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10711: pop
    //   10712: aload 30
    //   10714: ldc_w 768
    //   10717: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10720: pop
    //   10721: aload 30
    //   10723: aload_2
    //   10724: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10727: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10730: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10733: pop
    //   10734: aload 30
    //   10736: ldc_w 468
    //   10739: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10742: pop
    //   10743: aload 30
    //   10745: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10748: aload_0
    //   10749: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10752: lsub
    //   10753: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10756: pop
    //   10757: aload 27
    //   10759: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10762: ifne +39 -> 10801
    //   10765: new 123	java/lang/StringBuilder
    //   10768: dup
    //   10769: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   10772: astore 21
    //   10774: aload 21
    //   10776: ldc_w 425
    //   10779: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10782: pop
    //   10783: aload 21
    //   10785: aload 27
    //   10787: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10790: pop
    //   10791: aload 21
    //   10793: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10796: astore 21
    //   10798: goto +3 -> 10801
    //   10801: aload 30
    //   10803: aload 21
    //   10805: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10808: pop
    //   10809: aload 30
    //   10811: ldc_w 427
    //   10814: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10817: pop
    //   10818: aload 30
    //   10820: aload 35
    //   10822: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10825: pop
    //   10826: aload 28
    //   10828: aload 30
    //   10830: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10833: putfield 863	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   10836: aload_0
    //   10837: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10840: ifnull +121 -> 10961
    //   10843: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10846: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10849: aload_0
    //   10850: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10853: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10856: if_icmpne +105 -> 10961
    //   10859: aload_0
    //   10860: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10863: ifnull +98 -> 10961
    //   10866: aload 26
    //   10868: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10871: ifne +40 -> 10911
    //   10874: aload_0
    //   10875: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10878: astore 21
    //   10880: aload_0
    //   10881: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   10884: astore 24
    //   10886: aload_2
    //   10887: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10890: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10893: istore 9
    //   10895: aload 21
    //   10897: aload 24
    //   10899: aload 26
    //   10901: iload 9
    //   10903: invokeinterface 867 4 0
    //   10908: goto +53 -> 10961
    //   10911: aload_0
    //   10912: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10915: aload_0
    //   10916: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   10919: aload_0
    //   10920: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10923: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   10926: aload_2
    //   10927: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10930: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10933: invokeinterface 867 4 0
    //   10938: goto +23 -> 10961
    //   10941: astore 21
    //   10943: goto +5 -> 10948
    //   10946: astore 21
    //   10948: aload 34
    //   10950: ldc_w 872
    //   10953: aload 21
    //   10955: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10958: goto +3 -> 10961
    //   10961: aload_0
    //   10962: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10965: ifnull +101 -> 11066
    //   10968: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10971: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10974: aload_0
    //   10975: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10978: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10981: if_icmpne +85 -> 11066
    //   10984: aload_0
    //   10985: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10988: ifnull +78 -> 11066
    //   10991: aload 26
    //   10993: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10996: ifne +28 -> 11024
    //   10999: aload_0
    //   11000: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11003: aload_0
    //   11004: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11007: aload 26
    //   11009: aload_2
    //   11010: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11013: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11016: invokeinterface 867 4 0
    //   11021: goto +45 -> 11066
    //   11024: aload_0
    //   11025: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11028: aload_0
    //   11029: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11032: aload_0
    //   11033: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11036: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11039: aload_2
    //   11040: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11043: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11046: invokeinterface 867 4 0
    //   11051: goto +15 -> 11066
    //   11054: astore 21
    //   11056: ldc 225
    //   11058: ldc_w 874
    //   11061: aload 21
    //   11063: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11066: iload 8
    //   11068: ifeq +74 -> 11142
    //   11071: aload_0
    //   11072: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11075: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   11078: astore 21
    //   11080: aload_0
    //   11081: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11084: astore 24
    //   11086: aload_0
    //   11087: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11090: ifeq +30 -> 11120
    //   11093: aload_0
    //   11094: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11097: astore 26
    //   11099: aload 26
    //   11101: ifnull +19 -> 11120
    //   11104: aload 26
    //   11106: aload 33
    //   11108: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11111: ifeq +9 -> 11120
    //   11114: iconst_1
    //   11115: istore 8
    //   11117: goto +6 -> 11123
    //   11120: iconst_0
    //   11121: istore 8
    //   11123: aload 21
    //   11125: aload 24
    //   11127: iload 8
    //   11129: aload_2
    //   11130: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11133: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11136: invokevirtual 878	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   11139: goto +3 -> 11142
    //   11142: aload 25
    //   11144: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   11147: putfield 881	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   11150: aload 25
    //   11152: aload_0
    //   11153: invokevirtual 884	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   11156: putfield 887	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   11159: aload 25
    //   11161: aload 23
    //   11163: putfield 891	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   11166: aload 25
    //   11168: aload 22
    //   11170: putfield 895	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   11173: aload 25
    //   11175: iload 4
    //   11177: putfield 896	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   11180: aload 25
    //   11182: aconst_null
    //   11183: putfield 900	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   11186: aload 32
    //   11188: ifnonnull +9 -> 11197
    //   11191: aconst_null
    //   11192: astore 21
    //   11194: goto +10 -> 11204
    //   11197: aload 32
    //   11199: invokevirtual 903	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   11202: astore 21
    //   11204: aload 25
    //   11206: aload 21
    //   11208: putfield 906	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   11211: aload 25
    //   11213: aconst_null
    //   11214: putfield 909	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   11217: aload 25
    //   11219: aload_2
    //   11220: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11223: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11226: putfield 910	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   11229: aload 25
    //   11231: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11234: aload_0
    //   11235: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11238: lsub
    //   11239: putfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11242: aload 25
    //   11244: aload_2
    //   11245: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11248: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11251: putfield 916	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   11254: aload 25
    //   11256: aload 25
    //   11258: getfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11261: aload_2
    //   11262: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11265: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11268: lsub
    //   11269: putfield 919	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   11272: aload 25
    //   11274: lload 11
    //   11276: putfield 922	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   11279: aload 25
    //   11281: aload_0
    //   11282: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11285: putfield 925	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   11288: aload 25
    //   11290: aload_0
    //   11291: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   11294: putfield 928	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11297: aload 25
    //   11299: aload_0
    //   11300: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11303: putfield 931	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11306: aload 25
    //   11308: lconst_0
    //   11309: putfield 934	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11312: aload 25
    //   11314: aload_0
    //   11315: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11318: putfield 937	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11321: aload 25
    //   11323: aload_2
    //   11324: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11327: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11330: putfield 940	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11333: aload 25
    //   11335: aload_0
    //   11336: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11339: invokestatic 943	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   11342: putfield 945	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11345: aload 25
    //   11347: aload_0
    //   11348: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11351: putfield 948	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11354: aload_0
    //   11355: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11358: astore 21
    //   11360: aload 21
    //   11362: ifnull +20 -> 11382
    //   11365: aload 21
    //   11367: ldc_w 466
    //   11370: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11373: ifeq +9 -> 11382
    //   11376: iconst_1
    //   11377: istore 8
    //   11379: goto +6 -> 11385
    //   11382: iconst_0
    //   11383: istore 8
    //   11385: aload 25
    //   11387: iload 8
    //   11389: putfield 951	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   11392: aload 25
    //   11394: aload_2
    //   11395: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11398: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11401: putfield 953	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11404: aload 25
    //   11406: getstatic 959	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   11409: invokevirtual 962	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   11412: putfield 965	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   11415: aload 22
    //   11417: ifnull +24 -> 11441
    //   11420: aload 22
    //   11422: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11425: ifnull +16 -> 11441
    //   11428: aload 25
    //   11430: aload 22
    //   11432: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11435: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11438: putfield 967	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   11441: aload_2
    //   11442: aload 25
    //   11444: invokevirtual 971	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11447: aload_2
    //   11448: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11451: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11454: ifeq +11 -> 11465
    //   11457: aload_0
    //   11458: aload_1
    //   11459: aload_2
    //   11460: aload 25
    //   11462: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11465: aload_0
    //   11466: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11469: ifeq +22 -> 11491
    //   11472: aload_0
    //   11473: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   11476: ifnull -3162 -> 8314
    //   11479: aload_0
    //   11480: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   11483: invokeinterface 974 1 0
    //   11488: goto -3174 -> 8314
    //   11491: aload_0
    //   11492: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11495: ifnull -3156 -> 8339
    //   11498: goto -3171 -> 8327
    //   11501: astore 21
    //   11503: ldc_w 462
    //   11506: astore 31
    //   11508: aload 27
    //   11510: astore 25
    //   11512: aload 28
    //   11514: astore 27
    //   11516: ldc_w 460
    //   11519: astore 32
    //   11521: ldc_w 464
    //   11524: astore 29
    //   11526: aload 23
    //   11528: astore 26
    //   11530: aload 22
    //   11532: astore 23
    //   11534: iload 4
    //   11536: istore_3
    //   11537: aload 25
    //   11539: astore 28
    //   11541: aload 32
    //   11543: astore 25
    //   11545: aload 27
    //   11547: astore 22
    //   11549: lload 11
    //   11551: lstore 15
    //   11553: goto -11220 -> 333
    //   11556: astore 26
    //   11558: aload 22
    //   11560: astore 25
    //   11562: iload 4
    //   11564: istore_3
    //   11565: aload 23
    //   11567: astore 22
    //   11569: aload 25
    //   11571: astore 23
    //   11573: aload 26
    //   11575: astore 25
    //   11577: goto -9677 -> 1900
    //   11580: aload 25
    //   11582: astore 24
    //   11584: aload 22
    //   11586: astore 27
    //   11588: ldc_w 462
    //   11591: astore 35
    //   11593: aload 23
    //   11595: astore 28
    //   11597: ldc_w 460
    //   11600: astore 36
    //   11602: aload_2
    //   11603: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11606: lload 13
    //   11608: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11611: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   11614: aload_2
    //   11615: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11618: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11621: aload_0
    //   11622: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11625: lsub
    //   11626: putfield 678	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   11629: aload_2
    //   11630: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11633: aload_0
    //   11634: getfield 681	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   11637: putfield 684	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   11640: aload_0
    //   11641: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11644: invokestatic 689	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   11647: invokevirtual 693	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   11650: astore 29
    //   11652: aload_0
    //   11653: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11656: ifnull +28 -> 11684
    //   11659: aload_0
    //   11660: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11663: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   11666: ifnull +18 -> 11684
    //   11669: aload_0
    //   11670: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11673: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   11676: getfield 502	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   11679: astore 25
    //   11681: goto +6 -> 11687
    //   11684: aconst_null
    //   11685: astore 25
    //   11687: aload_0
    //   11688: aload_0
    //   11689: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11692: aload 28
    //   11694: aload 27
    //   11696: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   11699: astore 32
    //   11701: aload 26
    //   11703: ifnull +50 -> 11753
    //   11706: aload 26
    //   11708: ldc_w 699
    //   11711: invokeinterface 705 2 0
    //   11716: checkcast 282	java/lang/String
    //   11719: astore 23
    //   11721: goto +7 -> 11728
    //   11724: aload 21
    //   11726: astore 23
    //   11728: aload 26
    //   11730: ldc_w 707
    //   11733: invokeinterface 705 2 0
    //   11738: checkcast 282	java/lang/String
    //   11741: astore 22
    //   11743: goto +18 -> 11761
    //   11746: aload 21
    //   11748: astore 22
    //   11750: goto +11 -> 11761
    //   11753: aload 21
    //   11755: astore 23
    //   11757: aload 23
    //   11759: astore 22
    //   11761: aload_2
    //   11762: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11765: aload 23
    //   11767: putfield 710	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   11770: aload_0
    //   11771: lconst_0
    //   11772: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11775: aload_0
    //   11776: iconst_0
    //   11777: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   11780: aload_0
    //   11781: lconst_0
    //   11782: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   11785: aload_0
    //   11786: iconst_0
    //   11787: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   11790: aload_2
    //   11791: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11794: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11797: ifeq +12 -> 11809
    //   11800: aload_1
    //   11801: invokeinterface 359 1 0
    //   11806: ifeq +31 -> 11837
    //   11809: aload_0
    //   11810: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   11813: ifnull +24 -> 11837
    //   11816: aload_0
    //   11817: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   11820: aload_0
    //   11821: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11824: aload_2
    //   11825: invokevirtual 716	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   11828: aload 28
    //   11830: aload 27
    //   11832: invokeinterface 720 5 0
    //   11837: aload_1
    //   11838: invokeinterface 359 1 0
    //   11843: ifne +2756 -> 14599
    //   11846: aload_0
    //   11847: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11850: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   11853: istore 9
    //   11855: aload_2
    //   11856: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11859: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11862: ifne +931 -> 12793
    //   11865: new 123	java/lang/StringBuilder
    //   11868: dup
    //   11869: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   11872: astore 30
    //   11874: aload 30
    //   11876: ldc_w 722
    //   11879: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11882: pop
    //   11883: aload 30
    //   11885: aload_0
    //   11886: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11889: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11892: pop
    //   11893: aload 30
    //   11895: ldc_w 724
    //   11898: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11901: pop
    //   11902: aload 30
    //   11904: aload_0
    //   11905: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11908: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11911: pop
    //   11912: aload 30
    //   11914: ldc_w 729
    //   11917: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11920: pop
    //   11921: aload_0
    //   11922: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11925: ifeq +29 -> 11954
    //   11928: aload 27
    //   11930: ifnull +24 -> 11954
    //   11933: aload 27
    //   11935: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11938: ifnull +16 -> 11954
    //   11941: aload 27
    //   11943: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11946: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11949: astore 26
    //   11951: goto +8 -> 11959
    //   11954: ldc_w 738
    //   11957: astore 26
    //   11959: aload 30
    //   11961: aload 26
    //   11963: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11966: pop
    //   11967: aload 30
    //   11969: ldc_w 740
    //   11972: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11975: pop
    //   11976: aload 30
    //   11978: aload 29
    //   11980: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11983: pop
    //   11984: aload 30
    //   11986: ldc_w 745
    //   11989: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11992: pop
    //   11993: aload 30
    //   11995: aload 25
    //   11997: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12000: pop
    //   12001: aload 30
    //   12003: ldc_w 747
    //   12006: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12009: pop
    //   12010: aload 30
    //   12012: aconst_null
    //   12013: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12016: pop
    //   12017: aload 30
    //   12019: ldc_w 749
    //   12022: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12025: pop
    //   12026: aload 30
    //   12028: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12031: invokevirtual 172	java/lang/Thread:getId	()J
    //   12034: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12037: pop
    //   12038: aload 30
    //   12040: ldc_w 751
    //   12043: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12046: pop
    //   12047: aload 30
    //   12049: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12052: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12055: pop
    //   12056: aload 30
    //   12058: ldc_w 753
    //   12061: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12064: pop
    //   12065: aload 30
    //   12067: aload_0
    //   12068: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12071: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12074: pop
    //   12075: aload 30
    //   12077: ldc_w 755
    //   12080: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12083: pop
    //   12084: aload 30
    //   12086: aload_0
    //   12087: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12090: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12093: pop
    //   12094: aload 30
    //   12096: ldc_w 757
    //   12099: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12102: pop
    //   12103: aload_0
    //   12104: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12107: ifeq +19 -> 12126
    //   12110: aload_0
    //   12111: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12114: aload_0
    //   12115: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12118: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   12121: astore 26
    //   12123: goto +6 -> 12129
    //   12126: aconst_null
    //   12127: astore 26
    //   12129: aload 30
    //   12131: aload 26
    //   12133: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12136: pop
    //   12137: aload 30
    //   12139: ldc_w 759
    //   12142: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12145: pop
    //   12146: aload 30
    //   12148: iload 9
    //   12150: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12153: pop
    //   12154: aload 30
    //   12156: ldc_w 761
    //   12159: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12162: pop
    //   12163: aload 30
    //   12165: aload 22
    //   12167: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12170: pop
    //   12171: aload 30
    //   12173: ldc_w 763
    //   12176: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12179: pop
    //   12180: aload 30
    //   12182: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12185: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12188: pop
    //   12189: aload 30
    //   12191: ldc_w 464
    //   12194: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12197: pop
    //   12198: aload 30
    //   12200: aload_2
    //   12201: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12204: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12207: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12210: pop
    //   12211: aload 30
    //   12213: ldc_w 768
    //   12216: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12219: pop
    //   12220: aload 30
    //   12222: aload_2
    //   12223: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12226: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12229: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12232: pop
    //   12233: aload 30
    //   12235: ldc_w 468
    //   12238: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12241: pop
    //   12242: aload 30
    //   12244: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12247: aload_0
    //   12248: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12251: lsub
    //   12252: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12255: pop
    //   12256: aload 30
    //   12258: aload 35
    //   12260: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12263: pop
    //   12264: aload 30
    //   12266: aload_2
    //   12267: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12270: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12273: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12276: pop
    //   12277: aload 30
    //   12279: ldc_w 776
    //   12282: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12285: pop
    //   12286: aload 30
    //   12288: aload_2
    //   12289: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12292: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12295: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12298: pop
    //   12299: aload 30
    //   12301: ldc_w 780
    //   12304: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12307: pop
    //   12308: aload 30
    //   12310: aload_2
    //   12311: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12314: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12317: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12320: pop
    //   12321: aload 30
    //   12323: ldc_w 785
    //   12326: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12329: pop
    //   12330: aload 30
    //   12332: aload_0
    //   12333: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   12336: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12339: pop
    //   12340: aload 30
    //   12342: aload 36
    //   12344: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12347: pop
    //   12348: aload 30
    //   12350: aload_0
    //   12351: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   12354: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12357: pop
    //   12358: aload 30
    //   12360: ldc_w 790
    //   12363: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12366: pop
    //   12367: aload 30
    //   12369: aload_2
    //   12370: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12373: invokevirtual 793	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   12376: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12379: pop
    //   12380: aload 30
    //   12382: ldc_w 795
    //   12385: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12388: pop
    //   12389: aload 30
    //   12391: iload_3
    //   12392: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12395: pop
    //   12396: aload 30
    //   12398: ldc_w 427
    //   12401: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12404: pop
    //   12405: aload 30
    //   12407: aload 32
    //   12409: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12412: pop
    //   12413: aload 30
    //   12415: ldc_w 425
    //   12418: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12421: pop
    //   12422: aload 30
    //   12424: aload 23
    //   12426: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12429: pop
    //   12430: aload 30
    //   12432: ldc_w 797
    //   12435: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12438: pop
    //   12439: aload_0
    //   12440: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12443: astore 26
    //   12445: aload 26
    //   12447: ifnull +16 -> 12463
    //   12450: aload 26
    //   12452: iconst_0
    //   12453: bipush 30
    //   12455: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   12458: astore 26
    //   12460: goto +3 -> 12463
    //   12463: aload 30
    //   12465: aload 26
    //   12467: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12470: pop
    //   12471: aload 30
    //   12473: ldc_w 803
    //   12476: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12479: pop
    //   12480: aload_0
    //   12481: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12484: ifnull +15 -> 12499
    //   12487: aload_0
    //   12488: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12491: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12494: istore 4
    //   12496: goto +6 -> 12502
    //   12499: iconst_0
    //   12500: istore 4
    //   12502: aload 30
    //   12504: iload 4
    //   12506: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12509: pop
    //   12510: aload 30
    //   12512: ldc_w 805
    //   12515: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12518: pop
    //   12519: aload 30
    //   12521: aload_2
    //   12522: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12525: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12528: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12531: pop
    //   12532: aload 30
    //   12534: ldc_w 810
    //   12537: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12540: pop
    //   12541: aload 30
    //   12543: lload 11
    //   12545: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12548: pop
    //   12549: aload 30
    //   12551: ldc_w 812
    //   12554: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12557: pop
    //   12558: aload 30
    //   12560: aload_0
    //   12561: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12564: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12567: pop
    //   12568: aload 30
    //   12570: aload 36
    //   12572: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12575: pop
    //   12576: aload 30
    //   12578: aload_0
    //   12579: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12582: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12585: pop
    //   12586: aload 30
    //   12588: ldc_w 814
    //   12591: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12594: pop
    //   12595: aload 30
    //   12597: aload_0
    //   12598: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12601: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12604: pop
    //   12605: aload 30
    //   12607: aload 36
    //   12609: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12612: pop
    //   12613: aload 30
    //   12615: aload_0
    //   12616: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12619: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12622: pop
    //   12623: aload 30
    //   12625: ldc_w 816
    //   12628: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12631: pop
    //   12632: aload 30
    //   12634: aload_0
    //   12635: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   12638: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12641: pop
    //   12642: aload 30
    //   12644: ldc_w 818
    //   12647: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12650: pop
    //   12651: aload 30
    //   12653: aload_0
    //   12654: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   12657: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12660: pop
    //   12661: aload 30
    //   12663: ldc_w 823
    //   12666: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12669: pop
    //   12670: aload 30
    //   12672: aload_0
    //   12673: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   12676: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12679: pop
    //   12680: aload 30
    //   12682: ldc_w 828
    //   12685: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12688: pop
    //   12689: aload_0
    //   12690: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12693: ifnull +17 -> 12710
    //   12696: aload_0
    //   12697: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12700: invokeinterface 458 1 0
    //   12705: astore 26
    //   12707: goto +6 -> 12713
    //   12710: aconst_null
    //   12711: astore 26
    //   12713: aload 30
    //   12715: aload 26
    //   12717: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12720: pop
    //   12721: aload 30
    //   12723: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12726: astore 30
    //   12728: aload 24
    //   12730: astore 26
    //   12732: aload 26
    //   12734: aload 30
    //   12736: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12739: ldc_w 833
    //   12742: aload 26
    //   12744: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12747: aconst_null
    //   12748: invokestatic 837	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12751: aload_0
    //   12752: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12755: astore 26
    //   12757: aload 26
    //   12759: ifnull +22 -> 12781
    //   12762: aload 26
    //   12764: ldc_w 839
    //   12767: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12770: ifeq +11 -> 12781
    //   12773: aload_0
    //   12774: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   12777: iconst_0
    //   12778: invokestatic 844	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   12781: aload 23
    //   12783: astore 26
    //   12785: ldc_w 425
    //   12788: astore 23
    //   12790: goto +858 -> 13648
    //   12793: aload 24
    //   12795: astore 30
    //   12797: new 123	java/lang/StringBuilder
    //   12800: dup
    //   12801: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   12804: astore 37
    //   12806: aload 37
    //   12808: ldc_w 846
    //   12811: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12814: pop
    //   12815: aload 37
    //   12817: aload_0
    //   12818: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12821: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12824: pop
    //   12825: aload 37
    //   12827: ldc_w 724
    //   12830: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12833: pop
    //   12834: aload 37
    //   12836: aload_0
    //   12837: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12840: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12843: pop
    //   12844: aload 37
    //   12846: ldc_w 729
    //   12849: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12852: pop
    //   12853: aload_0
    //   12854: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12857: ifeq +29 -> 12886
    //   12860: aload 27
    //   12862: ifnull +24 -> 12886
    //   12865: aload 27
    //   12867: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12870: ifnull +16 -> 12886
    //   12873: aload 27
    //   12875: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12878: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12881: astore 26
    //   12883: goto +8 -> 12891
    //   12886: ldc_w 738
    //   12889: astore 26
    //   12891: aload 37
    //   12893: aload 26
    //   12895: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12898: pop
    //   12899: aload 37
    //   12901: ldc_w 740
    //   12904: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12907: pop
    //   12908: aload 37
    //   12910: aload 29
    //   12912: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12915: pop
    //   12916: aload 37
    //   12918: ldc_w 745
    //   12921: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12924: pop
    //   12925: aload 37
    //   12927: aload 25
    //   12929: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12932: pop
    //   12933: aload 37
    //   12935: ldc_w 747
    //   12938: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12941: pop
    //   12942: aload 37
    //   12944: aconst_null
    //   12945: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12948: pop
    //   12949: aload 37
    //   12951: ldc_w 749
    //   12954: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12957: pop
    //   12958: aload 37
    //   12960: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12963: invokevirtual 172	java/lang/Thread:getId	()J
    //   12966: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12969: pop
    //   12970: aload 37
    //   12972: ldc_w 751
    //   12975: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12978: pop
    //   12979: aload 37
    //   12981: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12984: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12987: pop
    //   12988: aload 37
    //   12990: ldc_w 753
    //   12993: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12996: pop
    //   12997: aload 37
    //   12999: aload_0
    //   13000: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13003: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13006: pop
    //   13007: aload 37
    //   13009: ldc_w 755
    //   13012: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13015: pop
    //   13016: aload 37
    //   13018: aload_0
    //   13019: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13022: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13025: pop
    //   13026: aload 37
    //   13028: ldc_w 757
    //   13031: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13034: pop
    //   13035: aload_0
    //   13036: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13039: ifeq +19 -> 13058
    //   13042: aload_0
    //   13043: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13046: aload_0
    //   13047: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13050: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   13053: astore 26
    //   13055: goto +6 -> 13061
    //   13058: aconst_null
    //   13059: astore 26
    //   13061: aload 37
    //   13063: aload 26
    //   13065: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13068: pop
    //   13069: aload 37
    //   13071: ldc_w 763
    //   13074: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13077: pop
    //   13078: aload 37
    //   13080: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   13083: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13086: pop
    //   13087: aload 37
    //   13089: ldc_w 761
    //   13092: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13095: pop
    //   13096: aload 37
    //   13098: aload 22
    //   13100: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13103: pop
    //   13104: aload 37
    //   13106: ldc_w 768
    //   13109: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13112: pop
    //   13113: aload 37
    //   13115: aload_2
    //   13116: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13119: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13122: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13125: pop
    //   13126: aload 37
    //   13128: ldc_w 468
    //   13131: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13134: pop
    //   13135: aload 37
    //   13137: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13140: aload_0
    //   13141: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13144: lsub
    //   13145: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13148: pop
    //   13149: aload 37
    //   13151: aload 35
    //   13153: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13156: pop
    //   13157: aload 37
    //   13159: aload_2
    //   13160: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13163: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13166: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13169: pop
    //   13170: aload 37
    //   13172: ldc_w 776
    //   13175: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13178: pop
    //   13179: aload 37
    //   13181: aload_2
    //   13182: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13185: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13188: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13191: pop
    //   13192: aload 37
    //   13194: ldc_w 780
    //   13197: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13200: pop
    //   13201: aload 37
    //   13203: aload_2
    //   13204: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13207: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   13210: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13213: pop
    //   13214: aload 37
    //   13216: ldc_w 785
    //   13219: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13222: pop
    //   13223: aload 37
    //   13225: aload_0
    //   13226: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   13229: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13232: pop
    //   13233: aload 37
    //   13235: aload 36
    //   13237: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13240: pop
    //   13241: aload 37
    //   13243: aload_0
    //   13244: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   13247: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13250: pop
    //   13251: aload 37
    //   13253: ldc_w 848
    //   13256: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13259: pop
    //   13260: aload 37
    //   13262: iload_3
    //   13263: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13266: pop
    //   13267: aload 37
    //   13269: ldc_w 427
    //   13272: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13275: pop
    //   13276: aload 37
    //   13278: aload 32
    //   13280: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13283: pop
    //   13284: aload 37
    //   13286: ldc_w 464
    //   13289: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13292: pop
    //   13293: aload 37
    //   13295: aload_2
    //   13296: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13299: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13302: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13305: pop
    //   13306: ldc_w 425
    //   13309: astore 31
    //   13311: aload 37
    //   13313: aload 31
    //   13315: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13318: pop
    //   13319: aload 37
    //   13321: aload 23
    //   13323: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13326: pop
    //   13327: aload 37
    //   13329: ldc_w 797
    //   13332: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13335: pop
    //   13336: aload_0
    //   13337: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13340: astore 26
    //   13342: aload 26
    //   13344: ifnull +16 -> 13360
    //   13347: aload 26
    //   13349: iconst_0
    //   13350: bipush 30
    //   13352: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   13355: astore 26
    //   13357: goto +3 -> 13360
    //   13360: aload 37
    //   13362: aload 26
    //   13364: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13367: pop
    //   13368: aload 37
    //   13370: ldc_w 803
    //   13373: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13376: pop
    //   13377: aload_0
    //   13378: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13381: ifnull +15 -> 13396
    //   13384: aload_0
    //   13385: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13388: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13391: istore 4
    //   13393: goto +6 -> 13399
    //   13396: iconst_0
    //   13397: istore 4
    //   13399: aload 37
    //   13401: iload 4
    //   13403: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13406: pop
    //   13407: aload 37
    //   13409: ldc_w 805
    //   13412: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13415: pop
    //   13416: aload 37
    //   13418: aload_2
    //   13419: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13422: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13425: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13428: pop
    //   13429: aload 37
    //   13431: ldc_w 810
    //   13434: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13437: pop
    //   13438: aload 37
    //   13440: lload 11
    //   13442: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13445: pop
    //   13446: aload 37
    //   13448: ldc_w 812
    //   13451: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13454: pop
    //   13455: aload 37
    //   13457: aload_0
    //   13458: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13461: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13464: pop
    //   13465: aload 37
    //   13467: aload 36
    //   13469: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13472: pop
    //   13473: aload 37
    //   13475: aload_0
    //   13476: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   13479: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13482: pop
    //   13483: aload 37
    //   13485: ldc_w 814
    //   13488: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13491: pop
    //   13492: aload 37
    //   13494: aload_0
    //   13495: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   13498: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13501: pop
    //   13502: aload 37
    //   13504: aload 36
    //   13506: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13509: pop
    //   13510: aload 37
    //   13512: aload_0
    //   13513: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   13516: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13519: pop
    //   13520: aload 37
    //   13522: ldc_w 816
    //   13525: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13528: pop
    //   13529: aload 37
    //   13531: aload_0
    //   13532: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   13535: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13538: pop
    //   13539: aload 37
    //   13541: ldc_w 818
    //   13544: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13547: pop
    //   13548: aload 37
    //   13550: aload_0
    //   13551: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   13554: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13557: pop
    //   13558: aload 37
    //   13560: ldc_w 823
    //   13563: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13566: pop
    //   13567: aload 37
    //   13569: aload_0
    //   13570: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   13573: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13576: pop
    //   13577: aload 37
    //   13579: ldc_w 828
    //   13582: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13585: pop
    //   13586: aload_0
    //   13587: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13590: ifnull +17 -> 13607
    //   13593: aload_0
    //   13594: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13597: invokeinterface 458 1 0
    //   13602: astore 26
    //   13604: goto +6 -> 13610
    //   13607: aconst_null
    //   13608: astore 26
    //   13610: aload 37
    //   13612: aload 26
    //   13614: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13617: pop
    //   13618: aload 30
    //   13620: aload 37
    //   13622: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13625: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13628: ldc_w 833
    //   13631: aload 30
    //   13633: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13636: aconst_null
    //   13637: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   13640: aload 23
    //   13642: astore 26
    //   13644: aload 31
    //   13646: astore 23
    //   13648: iload 9
    //   13650: ifne +8 -> 13658
    //   13653: aload_0
    //   13654: iconst_0
    //   13655: putfield 854	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   13658: aload_2
    //   13659: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13662: astore 30
    //   13664: new 123	java/lang/StringBuilder
    //   13667: dup
    //   13668: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   13671: astore 31
    //   13673: aload 31
    //   13675: aload_0
    //   13676: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13679: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13682: pop
    //   13683: aload 31
    //   13685: ldc_w 856
    //   13688: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13691: pop
    //   13692: aload 31
    //   13694: aload 25
    //   13696: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13699: pop
    //   13700: aload 31
    //   13702: ldc_w 858
    //   13705: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13708: pop
    //   13709: aload 31
    //   13711: aload_2
    //   13712: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13715: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13718: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13721: pop
    //   13722: aload 31
    //   13724: ldc_w 860
    //   13727: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13730: pop
    //   13731: aload_0
    //   13732: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13735: ifnull +15 -> 13750
    //   13738: aload_0
    //   13739: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13742: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13745: istore 4
    //   13747: goto +6 -> 13753
    //   13750: iconst_0
    //   13751: istore 4
    //   13753: aload 31
    //   13755: iload 4
    //   13757: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13760: pop
    //   13761: aload 31
    //   13763: ldc_w 795
    //   13766: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13769: pop
    //   13770: aload 31
    //   13772: iload_3
    //   13773: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13776: pop
    //   13777: aload 31
    //   13779: ldc_w 464
    //   13782: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13785: pop
    //   13786: aload 31
    //   13788: aload_2
    //   13789: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13792: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13795: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13798: pop
    //   13799: aload 31
    //   13801: aload 35
    //   13803: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13806: pop
    //   13807: aload 31
    //   13809: aload_2
    //   13810: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13813: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13816: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13819: pop
    //   13820: aload 31
    //   13822: ldc_w 776
    //   13825: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13828: pop
    //   13829: aload 31
    //   13831: aload_2
    //   13832: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13835: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13838: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13841: pop
    //   13842: aload 31
    //   13844: ldc_w 768
    //   13847: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13850: pop
    //   13851: aload 31
    //   13853: aload_2
    //   13854: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13857: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13860: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13863: pop
    //   13864: aload 31
    //   13866: ldc_w 468
    //   13869: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13872: pop
    //   13873: aload 31
    //   13875: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13878: aload_0
    //   13879: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13882: lsub
    //   13883: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13886: pop
    //   13887: aload 26
    //   13889: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13892: ifne +38 -> 13930
    //   13895: new 123	java/lang/StringBuilder
    //   13898: dup
    //   13899: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   13902: astore 21
    //   13904: aload 21
    //   13906: aload 23
    //   13908: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13911: pop
    //   13912: aload 21
    //   13914: aload 26
    //   13916: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13919: pop
    //   13920: aload 21
    //   13922: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13925: astore 21
    //   13927: goto +3 -> 13930
    //   13930: aload 31
    //   13932: aload 21
    //   13934: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13937: pop
    //   13938: aload 31
    //   13940: ldc_w 427
    //   13943: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13946: pop
    //   13947: aload 31
    //   13949: aload 32
    //   13951: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13954: pop
    //   13955: aload 30
    //   13957: aload 31
    //   13959: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13962: putfield 863	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   13965: aload_0
    //   13966: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13969: ifnull +121 -> 14090
    //   13972: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13975: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13978: aload_0
    //   13979: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13982: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13985: if_icmpne +105 -> 14090
    //   13988: aload_0
    //   13989: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13992: ifnull +98 -> 14090
    //   13995: aload 22
    //   13997: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14000: ifne +40 -> 14040
    //   14003: aload_0
    //   14004: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14007: astore 21
    //   14009: aload_0
    //   14010: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14013: astore 23
    //   14015: aload_2
    //   14016: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14019: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14022: istore 10
    //   14024: aload 21
    //   14026: aload 23
    //   14028: aload 22
    //   14030: iload 10
    //   14032: invokeinterface 867 4 0
    //   14037: goto +53 -> 14090
    //   14040: aload_0
    //   14041: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14044: aload_0
    //   14045: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14048: aload_0
    //   14049: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14052: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   14055: aload_2
    //   14056: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14059: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14062: invokeinterface 867 4 0
    //   14067: goto +23 -> 14090
    //   14070: astore 21
    //   14072: goto +5 -> 14077
    //   14075: astore 21
    //   14077: aload 34
    //   14079: ldc_w 872
    //   14082: aload 21
    //   14084: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14087: goto +3 -> 14090
    //   14090: aload_0
    //   14091: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14094: ifnull +101 -> 14195
    //   14097: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14100: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14103: aload_0
    //   14104: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14107: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14110: if_icmpne +85 -> 14195
    //   14113: aload_0
    //   14114: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14117: ifnull +78 -> 14195
    //   14120: aload 22
    //   14122: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14125: ifne +28 -> 14153
    //   14128: aload_0
    //   14129: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14132: aload_0
    //   14133: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14136: aload 22
    //   14138: aload_2
    //   14139: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14142: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14145: invokeinterface 867 4 0
    //   14150: goto +45 -> 14195
    //   14153: aload_0
    //   14154: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14157: aload_0
    //   14158: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14161: aload_0
    //   14162: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14165: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   14168: aload_2
    //   14169: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14172: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14175: invokeinterface 867 4 0
    //   14180: goto +15 -> 14195
    //   14183: astore 21
    //   14185: ldc 225
    //   14187: ldc_w 874
    //   14190: aload 21
    //   14192: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14195: iload 9
    //   14197: ifeq +74 -> 14271
    //   14200: aload_0
    //   14201: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   14204: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   14207: astore 21
    //   14209: aload_0
    //   14210: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14213: astore 22
    //   14215: aload_0
    //   14216: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14219: ifeq +30 -> 14249
    //   14222: aload_0
    //   14223: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14226: astore 23
    //   14228: aload 23
    //   14230: ifnull +19 -> 14249
    //   14233: aload 23
    //   14235: aload 33
    //   14237: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14240: ifeq +9 -> 14249
    //   14243: iconst_1
    //   14244: istore 9
    //   14246: goto +6 -> 14252
    //   14249: iconst_0
    //   14250: istore 9
    //   14252: aload 21
    //   14254: aload 22
    //   14256: iload 9
    //   14258: aload_2
    //   14259: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14262: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14265: invokevirtual 878	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   14268: goto +3 -> 14271
    //   14271: aload 24
    //   14273: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   14276: putfield 881	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   14279: aload 24
    //   14281: aload_0
    //   14282: invokevirtual 884	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   14285: putfield 887	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   14288: aload 24
    //   14290: aload 28
    //   14292: putfield 891	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   14295: aload 24
    //   14297: aload 27
    //   14299: putfield 895	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   14302: aload 24
    //   14304: iload_3
    //   14305: putfield 896	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   14308: aload 24
    //   14310: aconst_null
    //   14311: putfield 900	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   14314: aload 29
    //   14316: ifnonnull +9 -> 14325
    //   14319: aconst_null
    //   14320: astore 21
    //   14322: goto +10 -> 14332
    //   14325: aload 29
    //   14327: invokevirtual 903	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   14330: astore 21
    //   14332: aload 24
    //   14334: aload 21
    //   14336: putfield 906	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   14339: aload 24
    //   14341: aconst_null
    //   14342: putfield 909	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   14345: aload 24
    //   14347: aload_2
    //   14348: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14351: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14354: putfield 910	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   14357: aload 24
    //   14359: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14362: aload_0
    //   14363: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14366: lsub
    //   14367: putfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14370: aload 24
    //   14372: aload_2
    //   14373: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14376: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14379: putfield 916	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   14382: aload 24
    //   14384: aload 24
    //   14386: getfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14389: aload_2
    //   14390: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14393: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14396: lsub
    //   14397: putfield 919	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   14400: aload 24
    //   14402: lload 11
    //   14404: putfield 922	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   14407: aload 24
    //   14409: aload_0
    //   14410: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   14413: putfield 925	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   14416: aload 24
    //   14418: aload_0
    //   14419: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   14422: putfield 928	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   14425: aload 24
    //   14427: aload_0
    //   14428: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   14431: putfield 931	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   14434: aload 24
    //   14436: lconst_0
    //   14437: putfield 934	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   14440: aload 24
    //   14442: aload_0
    //   14443: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   14446: putfield 937	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   14449: aload 24
    //   14451: aload_2
    //   14452: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14455: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14458: putfield 940	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   14461: aload 24
    //   14463: aload_0
    //   14464: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14467: invokestatic 943	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   14470: putfield 945	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   14473: aload 24
    //   14475: aload_0
    //   14476: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14479: putfield 948	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   14482: aload_0
    //   14483: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14486: astore 21
    //   14488: aload 21
    //   14490: ifnull +20 -> 14510
    //   14493: aload 21
    //   14495: ldc_w 466
    //   14498: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14501: ifeq +9 -> 14510
    //   14504: iconst_1
    //   14505: istore 9
    //   14507: goto +6 -> 14513
    //   14510: iconst_0
    //   14511: istore 9
    //   14513: aload 24
    //   14515: iload 9
    //   14517: putfield 951	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   14520: aload 24
    //   14522: aload_2
    //   14523: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14526: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14529: putfield 953	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   14532: aload 24
    //   14534: getstatic 959	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   14537: invokevirtual 962	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   14540: putfield 965	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   14543: aload 27
    //   14545: ifnull +24 -> 14569
    //   14548: aload 27
    //   14550: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14553: ifnull +16 -> 14569
    //   14556: aload 24
    //   14558: aload 27
    //   14560: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14563: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   14566: putfield 967	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   14569: aload_2
    //   14570: aload 24
    //   14572: invokevirtual 971	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14575: aload_2
    //   14576: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14579: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14582: ifeq +14 -> 14596
    //   14585: aload_0
    //   14586: aload_1
    //   14587: aload_2
    //   14588: aload 24
    //   14590: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14593: goto +6 -> 14599
    //   14596: goto +3 -> 14599
    //   14599: aload_0
    //   14600: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14603: ifeq +27 -> 14630
    //   14606: aload_0
    //   14607: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   14610: ifnull +12 -> 14622
    //   14613: aload_0
    //   14614: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   14617: invokeinterface 974 1 0
    //   14622: aload_0
    //   14623: aconst_null
    //   14624: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   14627: goto +26 -> 14653
    //   14630: aload_0
    //   14631: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   14634: ifnull +15 -> 14649
    //   14637: aload_0
    //   14638: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   14641: invokevirtual 979	org/apache/http/client/methods/HttpGet:abort	()V
    //   14644: aload_0
    //   14645: aconst_null
    //   14646: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   14649: aload_0
    //   14650: invokevirtual 982	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   14653: aload_1
    //   14654: astore 22
    //   14656: iload 5
    //   14658: iconst_1
    //   14659: iadd
    //   14660: istore_3
    //   14661: aload_2
    //   14662: astore 21
    //   14664: goto +3785 -> 18449
    //   14667: astore 21
    //   14669: goto +10 -> 14679
    //   14672: astore 24
    //   14674: goto +59 -> 14733
    //   14677: astore 21
    //   14679: ldc_w 462
    //   14682: astore 31
    //   14684: ldc_w 464
    //   14687: astore 29
    //   14689: aload 26
    //   14691: astore 28
    //   14693: aload 23
    //   14695: astore 26
    //   14697: ldc_w 460
    //   14700: astore 27
    //   14702: ldc_w 425
    //   14705: astore 30
    //   14707: aload 22
    //   14709: astore 23
    //   14711: aload 25
    //   14713: astore 24
    //   14715: ldc_w 427
    //   14718: astore 22
    //   14720: aload 27
    //   14722: astore 25
    //   14724: lload 11
    //   14726: lstore 15
    //   14728: goto -14395 -> 333
    //   14731: astore 24
    //   14733: ldc_w 425
    //   14736: astore 30
    //   14738: ldc_w 427
    //   14741: astore 28
    //   14743: aload 22
    //   14745: astore 27
    //   14747: aload 23
    //   14749: astore 22
    //   14751: aload 27
    //   14753: astore 23
    //   14755: goto +89 -> 14844
    //   14758: astore 27
    //   14760: ldc_w 462
    //   14763: astore 31
    //   14765: ldc_w 464
    //   14768: astore 29
    //   14770: aload 26
    //   14772: astore 21
    //   14774: lload 11
    //   14776: lstore 13
    //   14778: aload 23
    //   14780: astore 26
    //   14782: ldc_w 460
    //   14785: astore 25
    //   14787: aconst_null
    //   14788: astore 35
    //   14790: aload 22
    //   14792: astore 23
    //   14794: lload 15
    //   14796: lstore 11
    //   14798: aload 28
    //   14800: astore 22
    //   14802: ldc_w 468
    //   14805: astore 32
    //   14807: iconst_0
    //   14808: istore_3
    //   14809: aload 21
    //   14811: astore 28
    //   14813: aload 32
    //   14815: astore 21
    //   14817: aload 24
    //   14819: astore 32
    //   14821: aload 35
    //   14823: astore 24
    //   14825: goto +3722 -> 18547
    //   14828: astore 24
    //   14830: aload 23
    //   14832: astore 27
    //   14834: iconst_0
    //   14835: istore_3
    //   14836: aload 22
    //   14838: astore 23
    //   14840: aload 27
    //   14842: astore 22
    //   14844: ldc_w 460
    //   14847: astore 32
    //   14849: ldc_w 462
    //   14852: astore 31
    //   14854: aload 25
    //   14856: astore 29
    //   14858: aload 26
    //   14860: astore 27
    //   14862: aload 32
    //   14864: astore 26
    //   14866: aload 24
    //   14868: astore 25
    //   14870: aload 29
    //   14872: astore 24
    //   14874: goto +362 -> 15236
    //   14877: astore 27
    //   14879: ldc_w 462
    //   14882: astore 31
    //   14884: ldc_w 464
    //   14887: astore 29
    //   14889: aload 28
    //   14891: astore 22
    //   14893: ldc_w 468
    //   14896: astore 21
    //   14898: lload 11
    //   14900: lstore 13
    //   14902: ldc_w 460
    //   14905: astore 25
    //   14907: aconst_null
    //   14908: astore 28
    //   14910: iconst_0
    //   14911: istore_3
    //   14912: aconst_null
    //   14913: astore 26
    //   14915: aconst_null
    //   14916: astore 35
    //   14918: aconst_null
    //   14919: astore 23
    //   14921: lload 15
    //   14923: lstore 11
    //   14925: aload 24
    //   14927: astore 32
    //   14929: aload 35
    //   14931: astore 24
    //   14933: goto +3614 -> 18547
    //   14936: astore 25
    //   14938: ldc_w 462
    //   14941: astore 31
    //   14943: ldc_w 460
    //   14946: astore 26
    //   14948: goto +220 -> 15168
    //   14951: astore 21
    //   14953: ldc_w 462
    //   14956: astore 31
    //   14958: goto -13834 -> 1124
    //   14961: astore 25
    //   14963: ldc_w 462
    //   14966: astore 22
    //   14968: ldc_w 460
    //   14971: astore 23
    //   14973: goto +187 -> 15160
    //   14976: astore 22
    //   14978: ldc_w 462
    //   14981: astore 31
    //   14983: ldc_w 460
    //   14986: astore 21
    //   14988: goto +65 -> 15053
    //   14991: astore 24
    //   14993: ldc_w 460
    //   14996: astore 23
    //   14998: ldc_w 462
    //   15001: astore 22
    //   15003: goto +140 -> 15143
    //   15006: astore 24
    //   15008: goto +20 -> 15028
    //   15011: astore 22
    //   15013: ldc_w 462
    //   15016: astore 31
    //   15018: ldc_w 460
    //   15021: astore 21
    //   15023: goto +30 -> 15053
    //   15026: astore 24
    //   15028: ldc_w 462
    //   15031: astore 22
    //   15033: ldc_w 460
    //   15036: astore 23
    //   15038: goto +105 -> 15143
    //   15041: astore 22
    //   15043: ldc_w 462
    //   15046: astore 31
    //   15048: ldc_w 460
    //   15051: astore 21
    //   15053: lload 11
    //   15055: lstore 15
    //   15057: ldc 225
    //   15059: astore 34
    //   15061: aload 25
    //   15063: astore 32
    //   15065: ldc_w 466
    //   15068: astore 33
    //   15070: ldc_w 425
    //   15073: astore 30
    //   15075: ldc_w 427
    //   15078: astore 35
    //   15080: ldc_w 468
    //   15083: astore 36
    //   15085: lload 13
    //   15087: lstore 11
    //   15089: aconst_null
    //   15090: astore 23
    //   15092: iconst_0
    //   15093: istore_3
    //   15094: aconst_null
    //   15095: astore 26
    //   15097: aconst_null
    //   15098: astore 24
    //   15100: aload 22
    //   15102: astore 27
    //   15104: ldc_w 464
    //   15107: astore 29
    //   15109: aconst_null
    //   15110: astore 28
    //   15112: aload 21
    //   15114: astore 25
    //   15116: aload 36
    //   15118: astore 21
    //   15120: aload 35
    //   15122: astore 22
    //   15124: lload 15
    //   15126: lstore 13
    //   15128: goto +3419 -> 18547
    //   15131: astore 24
    //   15133: ldc_w 462
    //   15136: astore 22
    //   15138: ldc_w 460
    //   15141: astore 23
    //   15143: aload 24
    //   15145: astore 26
    //   15147: ldc_w 466
    //   15150: astore 33
    //   15152: aload 25
    //   15154: astore 24
    //   15156: aload 26
    //   15158: astore 25
    //   15160: aload 23
    //   15162: astore 26
    //   15164: aload 22
    //   15166: astore 31
    //   15168: ldc_w 427
    //   15171: astore 28
    //   15173: ldc_w 425
    //   15176: astore 30
    //   15178: aconst_null
    //   15179: astore 27
    //   15181: aconst_null
    //   15182: astore 22
    //   15184: aconst_null
    //   15185: astore 23
    //   15187: iconst_0
    //   15188: istore_3
    //   15189: goto +47 -> 15236
    //   15192: ldc_w 462
    //   15195: astore 31
    //   15197: ldc_w 460
    //   15200: astore 23
    //   15202: aload 22
    //   15204: athrow
    //   15205: astore 22
    //   15207: aload 23
    //   15209: astore 21
    //   15211: goto -158 -> 15053
    //   15214: astore 26
    //   15216: ldc_w 466
    //   15219: astore 33
    //   15221: aload 25
    //   15223: astore 24
    //   15225: aload 31
    //   15227: astore 22
    //   15229: aload 26
    //   15231: astore 25
    //   15233: goto -73 -> 15160
    //   15236: ldc 225
    //   15238: aload 21
    //   15240: aload 25
    //   15242: invokestatic 837	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15245: aload_2
    //   15246: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   15249: aload 25
    //   15251: invokevirtual 985	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   15254: aload_0
    //   15255: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15258: astore 29
    //   15260: aload 29
    //   15262: ifnull +123 -> 15385
    //   15265: aload_0
    //   15266: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15269: astore 29
    //   15271: aload 29
    //   15273: ldc_w 839
    //   15276: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   15279: ifeq +106 -> 15385
    //   15282: aload_0
    //   15283: iconst_1
    //   15284: putfield 988	com/tencent/component/network/downloader/impl/FastDownloadTask:disableHttps	Z
    //   15287: iload 5
    //   15289: iconst_1
    //   15290: isub
    //   15291: istore 4
    //   15293: ldc_w 833
    //   15296: ldc_w 990
    //   15299: invokestatic 992	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15302: goto +87 -> 15389
    //   15305: astore 21
    //   15307: goto +5 -> 15312
    //   15310: astore 21
    //   15312: ldc 225
    //   15314: astore 34
    //   15316: aload 26
    //   15318: astore 29
    //   15320: aload 25
    //   15322: astore 35
    //   15324: lload 11
    //   15326: lstore 15
    //   15328: aload 21
    //   15330: astore 32
    //   15332: aload 22
    //   15334: astore 26
    //   15336: ldc_w 464
    //   15339: astore 36
    //   15341: lload 13
    //   15343: lstore 11
    //   15345: ldc_w 468
    //   15348: astore 21
    //   15350: aload 28
    //   15352: astore 22
    //   15354: aload 27
    //   15356: astore 28
    //   15358: aload 29
    //   15360: astore 25
    //   15362: aload 36
    //   15364: astore 29
    //   15366: aload 32
    //   15368: astore 27
    //   15370: aload 24
    //   15372: astore 32
    //   15374: lload 15
    //   15376: lstore 13
    //   15378: aload 35
    //   15380: astore 24
    //   15382: goto +3165 -> 18547
    //   15385: iload 5
    //   15387: istore 4
    //   15389: ldc 225
    //   15391: astore 38
    //   15393: aload_2
    //   15394: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15397: lload 13
    //   15399: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   15402: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   15405: aload_2
    //   15406: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15409: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   15412: aload_0
    //   15413: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   15416: lsub
    //   15417: putfield 678	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   15420: aload_2
    //   15421: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15424: aload_0
    //   15425: getfield 681	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   15428: putfield 684	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   15431: aload_0
    //   15432: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15435: invokestatic 689	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   15438: invokevirtual 693	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   15441: astore 35
    //   15443: aload_0
    //   15444: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15447: ifnull +28 -> 15475
    //   15450: aload_0
    //   15451: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15454: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   15457: ifnull +18 -> 15475
    //   15460: aload_0
    //   15461: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15464: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   15467: getfield 502	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   15470: astore 32
    //   15472: goto +6 -> 15478
    //   15475: aconst_null
    //   15476: astore 32
    //   15478: aload_0
    //   15479: aload_0
    //   15480: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15483: aload 22
    //   15485: aload 23
    //   15487: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   15490: astore 39
    //   15492: aload 27
    //   15494: ifnull +50 -> 15544
    //   15497: aload 27
    //   15499: ldc_w 699
    //   15502: invokeinterface 705 2 0
    //   15507: checkcast 282	java/lang/String
    //   15510: astore 29
    //   15512: goto +7 -> 15519
    //   15515: aload 21
    //   15517: astore 29
    //   15519: aload 27
    //   15521: ldc_w 707
    //   15524: invokeinterface 705 2 0
    //   15529: checkcast 282	java/lang/String
    //   15532: astore 27
    //   15534: goto +18 -> 15552
    //   15537: aload 21
    //   15539: astore 27
    //   15541: goto +11 -> 15552
    //   15544: aload 21
    //   15546: astore 27
    //   15548: aload 27
    //   15550: astore 29
    //   15552: aload_2
    //   15553: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15556: aload 29
    //   15558: putfield 710	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   15561: aload_0
    //   15562: lconst_0
    //   15563: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   15566: aload_0
    //   15567: iconst_0
    //   15568: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   15571: aload_0
    //   15572: lconst_0
    //   15573: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   15576: aload_0
    //   15577: iconst_0
    //   15578: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   15581: aload_2
    //   15582: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   15585: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   15588: ifeq +12 -> 15600
    //   15591: aload_1
    //   15592: invokeinterface 359 1 0
    //   15597: ifeq +31 -> 15628
    //   15600: aload_0
    //   15601: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   15604: ifnull +24 -> 15628
    //   15607: aload_0
    //   15608: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   15611: aload_0
    //   15612: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   15615: aload_2
    //   15616: invokevirtual 716	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   15619: aload 22
    //   15621: aload 23
    //   15623: invokeinterface 720 5 0
    //   15628: aload_1
    //   15629: invokeinterface 359 1 0
    //   15634: ifne +2750 -> 18384
    //   15637: aload_0
    //   15638: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15641: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   15644: istore 9
    //   15646: aload_2
    //   15647: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   15650: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   15653: ifne +926 -> 16579
    //   15656: new 123	java/lang/StringBuilder
    //   15659: dup
    //   15660: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   15663: astore 36
    //   15665: aload 36
    //   15667: ldc_w 722
    //   15670: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15673: pop
    //   15674: aload 36
    //   15676: aload_0
    //   15677: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   15680: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15683: pop
    //   15684: aload 36
    //   15686: ldc_w 724
    //   15689: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15692: pop
    //   15693: aload 36
    //   15695: aload_0
    //   15696: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15699: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15702: pop
    //   15703: aload 36
    //   15705: ldc_w 729
    //   15708: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15711: pop
    //   15712: aload_0
    //   15713: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15716: ifeq +29 -> 15745
    //   15719: aload 23
    //   15721: ifnull +24 -> 15745
    //   15724: aload 23
    //   15726: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   15729: ifnull +16 -> 15745
    //   15732: aload 23
    //   15734: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   15737: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   15740: astore 34
    //   15742: goto +8 -> 15750
    //   15745: ldc_w 738
    //   15748: astore 34
    //   15750: aload 36
    //   15752: aload 34
    //   15754: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15757: pop
    //   15758: aload 36
    //   15760: ldc_w 740
    //   15763: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15766: pop
    //   15767: aload 36
    //   15769: aload 35
    //   15771: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15774: pop
    //   15775: aload 36
    //   15777: ldc_w 745
    //   15780: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15783: pop
    //   15784: aload 36
    //   15786: aload 32
    //   15788: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15791: pop
    //   15792: aload 36
    //   15794: ldc_w 747
    //   15797: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15800: pop
    //   15801: aload 36
    //   15803: aconst_null
    //   15804: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15807: pop
    //   15808: aload 36
    //   15810: ldc_w 749
    //   15813: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15816: pop
    //   15817: aload 36
    //   15819: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15822: invokevirtual 172	java/lang/Thread:getId	()J
    //   15825: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15828: pop
    //   15829: aload 36
    //   15831: ldc_w 751
    //   15834: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15837: pop
    //   15838: aload 36
    //   15840: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   15843: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15846: pop
    //   15847: aload 36
    //   15849: ldc_w 753
    //   15852: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15855: pop
    //   15856: aload 36
    //   15858: aload_0
    //   15859: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15862: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15865: pop
    //   15866: aload 36
    //   15868: ldc_w 755
    //   15871: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15874: pop
    //   15875: aload 36
    //   15877: aload_0
    //   15878: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15881: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15884: pop
    //   15885: aload 36
    //   15887: ldc_w 757
    //   15890: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15893: pop
    //   15894: aload_0
    //   15895: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15898: ifeq +19 -> 15917
    //   15901: aload_0
    //   15902: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15905: aload_0
    //   15906: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15909: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   15912: astore 34
    //   15914: goto +6 -> 15920
    //   15917: aconst_null
    //   15918: astore 34
    //   15920: aload 36
    //   15922: aload 34
    //   15924: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15927: pop
    //   15928: aload 36
    //   15930: ldc_w 759
    //   15933: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15936: pop
    //   15937: aload 36
    //   15939: iload 9
    //   15941: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15944: pop
    //   15945: aload 36
    //   15947: ldc_w 761
    //   15950: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15953: pop
    //   15954: aload 36
    //   15956: aload 27
    //   15958: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15961: pop
    //   15962: aload 36
    //   15964: ldc_w 763
    //   15967: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15970: pop
    //   15971: aload 36
    //   15973: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   15976: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15979: pop
    //   15980: aload 36
    //   15982: ldc_w 464
    //   15985: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15988: pop
    //   15989: aload 36
    //   15991: aload_2
    //   15992: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15995: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   15998: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16001: pop
    //   16002: aload 36
    //   16004: ldc_w 768
    //   16007: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16010: pop
    //   16011: aload 36
    //   16013: aload_2
    //   16014: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   16017: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   16020: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16023: pop
    //   16024: aload 36
    //   16026: ldc_w 468
    //   16029: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16032: pop
    //   16033: aload 36
    //   16035: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   16038: aload_0
    //   16039: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   16042: lsub
    //   16043: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16046: pop
    //   16047: aload 36
    //   16049: aload 31
    //   16051: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16054: pop
    //   16055: aload 36
    //   16057: aload_2
    //   16058: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16061: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   16064: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16067: pop
    //   16068: aload 36
    //   16070: ldc_w 776
    //   16073: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16076: pop
    //   16077: aload 36
    //   16079: aload_2
    //   16080: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16083: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   16086: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16089: pop
    //   16090: aload 36
    //   16092: ldc_w 780
    //   16095: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16098: pop
    //   16099: aload 36
    //   16101: aload_2
    //   16102: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16105: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   16108: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16111: pop
    //   16112: aload 36
    //   16114: ldc_w 785
    //   16117: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16120: pop
    //   16121: aload 36
    //   16123: aload_0
    //   16124: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   16127: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16130: pop
    //   16131: aload 36
    //   16133: aload 26
    //   16135: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16138: pop
    //   16139: aload 36
    //   16141: aload_0
    //   16142: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   16145: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16148: pop
    //   16149: aload 36
    //   16151: ldc_w 790
    //   16154: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16157: pop
    //   16158: aload 36
    //   16160: aload_2
    //   16161: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   16164: invokevirtual 793	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   16167: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16170: pop
    //   16171: aload 36
    //   16173: ldc_w 795
    //   16176: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16179: pop
    //   16180: aload 36
    //   16182: iload_3
    //   16183: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16186: pop
    //   16187: aload 36
    //   16189: aload 28
    //   16191: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16194: pop
    //   16195: aload 36
    //   16197: aload 39
    //   16199: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16202: pop
    //   16203: aload 36
    //   16205: aload 30
    //   16207: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16210: pop
    //   16211: aload 36
    //   16213: aload 29
    //   16215: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16218: pop
    //   16219: aload 36
    //   16221: ldc_w 797
    //   16224: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16227: pop
    //   16228: aload_0
    //   16229: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16232: astore 34
    //   16234: aload 34
    //   16236: ifnull +16 -> 16252
    //   16239: aload 34
    //   16241: iconst_0
    //   16242: bipush 30
    //   16244: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   16247: astore 34
    //   16249: goto +3 -> 16252
    //   16252: aload 36
    //   16254: aload 34
    //   16256: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16259: pop
    //   16260: aload 36
    //   16262: ldc_w 803
    //   16265: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16268: pop
    //   16269: aload_0
    //   16270: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16273: ifnull +15 -> 16288
    //   16276: aload_0
    //   16277: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16280: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   16283: istore 5
    //   16285: goto +6 -> 16291
    //   16288: iconst_0
    //   16289: istore 5
    //   16291: aload 36
    //   16293: iload 5
    //   16295: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16298: pop
    //   16299: aload 36
    //   16301: ldc_w 805
    //   16304: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16307: pop
    //   16308: aload 36
    //   16310: aload_2
    //   16311: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16314: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   16317: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16320: pop
    //   16321: aload 36
    //   16323: ldc_w 810
    //   16326: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16329: pop
    //   16330: aload 36
    //   16332: lload 11
    //   16334: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16337: pop
    //   16338: aload 36
    //   16340: ldc_w 812
    //   16343: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16346: pop
    //   16347: aload 36
    //   16349: aload_0
    //   16350: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   16353: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16356: pop
    //   16357: aload 36
    //   16359: aload 26
    //   16361: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16364: pop
    //   16365: aload 36
    //   16367: aload_0
    //   16368: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   16371: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16374: pop
    //   16375: aload 36
    //   16377: ldc_w 814
    //   16380: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16383: pop
    //   16384: aload 36
    //   16386: aload_0
    //   16387: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   16390: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16393: pop
    //   16394: aload 36
    //   16396: aload 26
    //   16398: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16401: pop
    //   16402: aload 36
    //   16404: aload_0
    //   16405: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   16408: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16411: pop
    //   16412: aload 36
    //   16414: ldc_w 816
    //   16417: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16420: pop
    //   16421: aload 36
    //   16423: aload_0
    //   16424: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   16427: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16430: pop
    //   16431: aload 36
    //   16433: ldc_w 818
    //   16436: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16439: pop
    //   16440: aload 36
    //   16442: aload_0
    //   16443: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   16446: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16449: pop
    //   16450: aload 36
    //   16452: ldc_w 823
    //   16455: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16458: pop
    //   16459: aload 36
    //   16461: aload_0
    //   16462: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   16465: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16468: pop
    //   16469: aload 36
    //   16471: ldc_w 828
    //   16474: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16477: pop
    //   16478: aload_0
    //   16479: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16482: ifnull +17 -> 16499
    //   16485: aload_0
    //   16486: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16489: invokeinterface 458 1 0
    //   16494: astore 26
    //   16496: goto +6 -> 16502
    //   16499: aconst_null
    //   16500: astore 26
    //   16502: aload 36
    //   16504: aload 26
    //   16506: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16509: pop
    //   16510: aload 36
    //   16512: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16515: astore 34
    //   16517: aload 24
    //   16519: astore 26
    //   16521: aload 26
    //   16523: aload 34
    //   16525: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16528: ldc_w 833
    //   16531: aload 26
    //   16533: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16536: aload 25
    //   16538: invokestatic 837	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16541: aload_0
    //   16542: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16545: astore 26
    //   16547: aload 26
    //   16549: ifnull +22 -> 16571
    //   16552: aload 26
    //   16554: ldc_w 839
    //   16557: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   16560: ifeq +11 -> 16571
    //   16563: aload_0
    //   16564: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   16567: iconst_0
    //   16568: invokestatic 844	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   16571: ldc_w 464
    //   16574: astore 26
    //   16576: goto +852 -> 17428
    //   16579: aload 24
    //   16581: astore 36
    //   16583: new 123	java/lang/StringBuilder
    //   16586: dup
    //   16587: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   16590: astore 40
    //   16592: aload 40
    //   16594: ldc_w 846
    //   16597: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16600: pop
    //   16601: aload 40
    //   16603: aload_0
    //   16604: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   16607: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16610: pop
    //   16611: aload 40
    //   16613: ldc_w 724
    //   16616: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16619: pop
    //   16620: aload 40
    //   16622: aload_0
    //   16623: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   16626: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16629: pop
    //   16630: aload 40
    //   16632: ldc_w 729
    //   16635: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16638: pop
    //   16639: aload_0
    //   16640: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   16643: ifeq +29 -> 16672
    //   16646: aload 23
    //   16648: ifnull +24 -> 16672
    //   16651: aload 23
    //   16653: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   16656: ifnull +16 -> 16672
    //   16659: aload 23
    //   16661: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   16664: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   16667: astore 34
    //   16669: goto +8 -> 16677
    //   16672: ldc_w 738
    //   16675: astore 34
    //   16677: aload 40
    //   16679: aload 34
    //   16681: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16684: pop
    //   16685: aload 40
    //   16687: ldc_w 740
    //   16690: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16693: pop
    //   16694: aload 40
    //   16696: aload 35
    //   16698: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16701: pop
    //   16702: aload 40
    //   16704: ldc_w 745
    //   16707: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16710: pop
    //   16711: aload 40
    //   16713: aload 32
    //   16715: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16718: pop
    //   16719: aload 40
    //   16721: ldc_w 747
    //   16724: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16727: pop
    //   16728: aload 40
    //   16730: aconst_null
    //   16731: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16734: pop
    //   16735: aload 40
    //   16737: ldc_w 749
    //   16740: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16743: pop
    //   16744: aload 40
    //   16746: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16749: invokevirtual 172	java/lang/Thread:getId	()J
    //   16752: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16755: pop
    //   16756: aload 40
    //   16758: ldc_w 751
    //   16761: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16764: pop
    //   16765: aload 40
    //   16767: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   16770: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16773: pop
    //   16774: aload 40
    //   16776: ldc_w 753
    //   16779: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16782: pop
    //   16783: aload 40
    //   16785: aload_0
    //   16786: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16789: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16792: pop
    //   16793: aload 40
    //   16795: ldc_w 755
    //   16798: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16801: pop
    //   16802: aload 40
    //   16804: aload_0
    //   16805: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16808: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16811: pop
    //   16812: aload 40
    //   16814: ldc_w 757
    //   16817: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16820: pop
    //   16821: aload_0
    //   16822: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16825: ifeq +19 -> 16844
    //   16828: aload_0
    //   16829: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   16832: aload_0
    //   16833: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16836: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   16839: astore 34
    //   16841: goto +6 -> 16847
    //   16844: aconst_null
    //   16845: astore 34
    //   16847: aload 40
    //   16849: aload 34
    //   16851: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16854: pop
    //   16855: aload 40
    //   16857: ldc_w 763
    //   16860: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16863: pop
    //   16864: aload 40
    //   16866: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   16869: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16872: pop
    //   16873: aload 40
    //   16875: ldc_w 761
    //   16878: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16881: pop
    //   16882: aload 40
    //   16884: aload 27
    //   16886: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16889: pop
    //   16890: aload 40
    //   16892: ldc_w 768
    //   16895: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16898: pop
    //   16899: aload 40
    //   16901: aload_2
    //   16902: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   16905: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   16908: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16911: pop
    //   16912: aload 40
    //   16914: ldc_w 468
    //   16917: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16920: pop
    //   16921: aload 40
    //   16923: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   16926: aload_0
    //   16927: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   16930: lsub
    //   16931: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16934: pop
    //   16935: aload 40
    //   16937: aload 31
    //   16939: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16942: pop
    //   16943: aload 40
    //   16945: aload_2
    //   16946: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16949: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   16952: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16955: pop
    //   16956: aload 40
    //   16958: ldc_w 776
    //   16961: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16964: pop
    //   16965: aload 40
    //   16967: aload_2
    //   16968: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16971: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   16974: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16977: pop
    //   16978: aload 40
    //   16980: ldc_w 780
    //   16983: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16986: pop
    //   16987: aload 40
    //   16989: aload_2
    //   16990: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16993: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   16996: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16999: pop
    //   17000: aload 40
    //   17002: ldc_w 785
    //   17005: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17008: pop
    //   17009: aload 40
    //   17011: aload_0
    //   17012: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   17015: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17018: pop
    //   17019: aload 40
    //   17021: aload 26
    //   17023: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17026: pop
    //   17027: aload 40
    //   17029: aload_0
    //   17030: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   17033: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17036: pop
    //   17037: aload 40
    //   17039: ldc_w 848
    //   17042: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17045: pop
    //   17046: aload 40
    //   17048: iload_3
    //   17049: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17052: pop
    //   17053: aload 40
    //   17055: aload 28
    //   17057: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17060: pop
    //   17061: aload 40
    //   17063: aload 39
    //   17065: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17068: pop
    //   17069: ldc_w 464
    //   17072: astore 37
    //   17074: aload 40
    //   17076: aload 37
    //   17078: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17081: pop
    //   17082: aload 40
    //   17084: aload_2
    //   17085: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   17088: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   17091: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17094: pop
    //   17095: aload 40
    //   17097: aload 30
    //   17099: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17102: pop
    //   17103: aload 40
    //   17105: aload 29
    //   17107: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17110: pop
    //   17111: aload 40
    //   17113: ldc_w 797
    //   17116: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17119: pop
    //   17120: aload_0
    //   17121: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   17124: astore 34
    //   17126: aload 34
    //   17128: ifnull +16 -> 17144
    //   17131: aload 34
    //   17133: iconst_0
    //   17134: bipush 30
    //   17136: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   17139: astore 34
    //   17141: goto +3 -> 17144
    //   17144: aload 40
    //   17146: aload 34
    //   17148: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17151: pop
    //   17152: aload 40
    //   17154: ldc_w 803
    //   17157: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17160: pop
    //   17161: aload_0
    //   17162: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17165: ifnull +15 -> 17180
    //   17168: aload_0
    //   17169: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17172: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   17175: istore 5
    //   17177: goto +6 -> 17183
    //   17180: iconst_0
    //   17181: istore 5
    //   17183: aload 40
    //   17185: iload 5
    //   17187: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17190: pop
    //   17191: aload 40
    //   17193: ldc_w 805
    //   17196: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17199: pop
    //   17200: aload 40
    //   17202: aload_2
    //   17203: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   17206: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   17209: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17212: pop
    //   17213: aload 40
    //   17215: ldc_w 810
    //   17218: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17221: pop
    //   17222: aload 40
    //   17224: lload 11
    //   17226: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17229: pop
    //   17230: aload 40
    //   17232: ldc_w 812
    //   17235: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17238: pop
    //   17239: aload 40
    //   17241: aload_0
    //   17242: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   17245: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17248: pop
    //   17249: aload 40
    //   17251: aload 26
    //   17253: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17256: pop
    //   17257: aload 40
    //   17259: aload_0
    //   17260: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   17263: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17266: pop
    //   17267: aload 40
    //   17269: ldc_w 814
    //   17272: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17275: pop
    //   17276: aload 40
    //   17278: aload_0
    //   17279: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   17282: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17285: pop
    //   17286: aload 40
    //   17288: aload 26
    //   17290: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17293: pop
    //   17294: aload 40
    //   17296: aload_0
    //   17297: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   17300: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17303: pop
    //   17304: aload 40
    //   17306: ldc_w 816
    //   17309: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17312: pop
    //   17313: aload 40
    //   17315: aload_0
    //   17316: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   17319: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17322: pop
    //   17323: aload 40
    //   17325: ldc_w 818
    //   17328: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17331: pop
    //   17332: aload 40
    //   17334: aload_0
    //   17335: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   17338: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17341: pop
    //   17342: aload 40
    //   17344: ldc_w 823
    //   17347: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17350: pop
    //   17351: aload 40
    //   17353: aload_0
    //   17354: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   17357: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17360: pop
    //   17361: aload 40
    //   17363: ldc_w 828
    //   17366: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17369: pop
    //   17370: aload_0
    //   17371: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   17374: ifnull +17 -> 17391
    //   17377: aload_0
    //   17378: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   17381: invokeinterface 458 1 0
    //   17386: astore 26
    //   17388: goto +6 -> 17394
    //   17391: aconst_null
    //   17392: astore 26
    //   17394: aload 40
    //   17396: aload 26
    //   17398: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17401: pop
    //   17402: aload 36
    //   17404: aload 40
    //   17406: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17409: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   17412: ldc_w 833
    //   17415: aload 36
    //   17417: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   17420: aconst_null
    //   17421: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   17424: aload 37
    //   17426: astore 26
    //   17428: iload_3
    //   17429: istore 5
    //   17431: iload 9
    //   17433: ifne +8 -> 17441
    //   17436: aload_0
    //   17437: iconst_0
    //   17438: putfield 854	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   17441: aload_2
    //   17442: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   17445: astore 34
    //   17447: new 123	java/lang/StringBuilder
    //   17450: dup
    //   17451: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   17454: astore 36
    //   17456: aload 36
    //   17458: aload_0
    //   17459: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   17462: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17465: pop
    //   17466: aload 36
    //   17468: ldc_w 856
    //   17471: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17474: pop
    //   17475: aload 36
    //   17477: aload 32
    //   17479: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17482: pop
    //   17483: aload 36
    //   17485: ldc_w 858
    //   17488: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17491: pop
    //   17492: aload 36
    //   17494: aload_2
    //   17495: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   17498: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   17501: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17504: pop
    //   17505: aload 36
    //   17507: ldc_w 860
    //   17510: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17513: pop
    //   17514: aload_0
    //   17515: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17518: ifnull +14 -> 17532
    //   17521: aload_0
    //   17522: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17525: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   17528: istore_3
    //   17529: goto +5 -> 17534
    //   17532: iconst_0
    //   17533: istore_3
    //   17534: aload 36
    //   17536: iload_3
    //   17537: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17540: pop
    //   17541: aload 36
    //   17543: ldc_w 795
    //   17546: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17549: pop
    //   17550: aload 36
    //   17552: iload 5
    //   17554: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17557: pop
    //   17558: aload 36
    //   17560: aload 26
    //   17562: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17565: pop
    //   17566: aload 36
    //   17568: aload_2
    //   17569: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   17572: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   17575: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17578: pop
    //   17579: aload 36
    //   17581: aload 31
    //   17583: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17586: pop
    //   17587: aload 36
    //   17589: aload_2
    //   17590: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   17593: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   17596: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17599: pop
    //   17600: aload 36
    //   17602: ldc_w 776
    //   17605: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17608: pop
    //   17609: aload 36
    //   17611: aload_2
    //   17612: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   17615: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   17618: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17621: pop
    //   17622: aload 36
    //   17624: ldc_w 768
    //   17627: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17630: pop
    //   17631: aload 36
    //   17633: aload_2
    //   17634: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   17637: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   17640: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17643: pop
    //   17644: aload 36
    //   17646: ldc_w 468
    //   17649: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17652: pop
    //   17653: aload 36
    //   17655: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   17658: aload_0
    //   17659: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   17662: lsub
    //   17663: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17666: pop
    //   17667: aload 29
    //   17669: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17672: ifne +38 -> 17710
    //   17675: new 123	java/lang/StringBuilder
    //   17678: dup
    //   17679: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   17682: astore 21
    //   17684: aload 21
    //   17686: aload 30
    //   17688: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17691: pop
    //   17692: aload 21
    //   17694: aload 29
    //   17696: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17699: pop
    //   17700: aload 21
    //   17702: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17705: astore 21
    //   17707: goto +3 -> 17710
    //   17710: aload 36
    //   17712: aload 21
    //   17714: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17717: pop
    //   17718: aload 36
    //   17720: aload 28
    //   17722: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17725: pop
    //   17726: aload 36
    //   17728: aload 39
    //   17730: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17733: pop
    //   17734: aload 34
    //   17736: aload 36
    //   17738: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17741: putfield 863	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   17744: aload_0
    //   17745: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17748: ifnull +121 -> 17869
    //   17751: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17754: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   17757: aload_0
    //   17758: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17761: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   17764: if_icmpne +105 -> 17869
    //   17767: aload_0
    //   17768: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   17771: ifnull +98 -> 17869
    //   17774: aload 27
    //   17776: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17779: ifne +40 -> 17819
    //   17782: aload_0
    //   17783: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   17786: astore 21
    //   17788: aload_0
    //   17789: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   17792: astore 26
    //   17794: aload_2
    //   17795: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   17798: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   17801: istore 10
    //   17803: aload 21
    //   17805: aload 26
    //   17807: aload 27
    //   17809: iload 10
    //   17811: invokeinterface 867 4 0
    //   17816: goto +53 -> 17869
    //   17819: aload_0
    //   17820: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   17823: aload_0
    //   17824: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   17827: aload_0
    //   17828: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   17831: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   17834: aload_2
    //   17835: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   17838: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   17841: invokeinterface 867 4 0
    //   17846: goto +23 -> 17869
    //   17849: astore 21
    //   17851: goto +5 -> 17856
    //   17854: astore 21
    //   17856: aload 38
    //   17858: ldc_w 872
    //   17861: aload 21
    //   17863: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   17866: goto +3 -> 17869
    //   17869: aload_0
    //   17870: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17873: ifnull +101 -> 17974
    //   17876: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17879: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   17882: aload_0
    //   17883: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   17886: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   17889: if_icmpne +85 -> 17974
    //   17892: aload_0
    //   17893: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   17896: ifnull +78 -> 17974
    //   17899: aload 27
    //   17901: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17904: ifne +28 -> 17932
    //   17907: aload_0
    //   17908: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   17911: aload_0
    //   17912: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   17915: aload 27
    //   17917: aload_2
    //   17918: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   17921: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   17924: invokeinterface 867 4 0
    //   17929: goto +45 -> 17974
    //   17932: aload_0
    //   17933: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   17936: aload_0
    //   17937: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   17940: aload_0
    //   17941: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   17944: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   17947: aload_2
    //   17948: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   17951: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   17954: invokeinterface 867 4 0
    //   17959: goto +15 -> 17974
    //   17962: astore 21
    //   17964: aload 38
    //   17966: ldc_w 874
    //   17969: aload 21
    //   17971: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   17974: iload 9
    //   17976: ifeq +74 -> 18050
    //   17979: aload_0
    //   17980: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   17983: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   17986: astore 21
    //   17988: aload_0
    //   17989: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   17992: astore 26
    //   17994: aload_0
    //   17995: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   17998: ifeq +30 -> 18028
    //   18001: aload_0
    //   18002: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   18005: astore 27
    //   18007: aload 27
    //   18009: ifnull +19 -> 18028
    //   18012: aload 27
    //   18014: aload 33
    //   18016: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   18019: ifeq +9 -> 18028
    //   18022: iconst_1
    //   18023: istore 9
    //   18025: goto +6 -> 18031
    //   18028: iconst_0
    //   18029: istore 9
    //   18031: aload 21
    //   18033: aload 26
    //   18035: iload 9
    //   18037: aload_2
    //   18038: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   18041: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   18044: invokevirtual 878	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   18047: goto +3 -> 18050
    //   18050: aload 24
    //   18052: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   18055: putfield 881	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   18058: aload 24
    //   18060: aload_0
    //   18061: invokevirtual 884	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   18064: putfield 887	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   18067: aload 24
    //   18069: aload 22
    //   18071: putfield 891	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   18074: aload 24
    //   18076: aload 23
    //   18078: putfield 895	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   18081: aload 24
    //   18083: iload 5
    //   18085: putfield 896	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   18088: aload 24
    //   18090: aload 25
    //   18092: putfield 900	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   18095: aload 35
    //   18097: ifnonnull +9 -> 18106
    //   18100: aconst_null
    //   18101: astore 21
    //   18103: goto +10 -> 18113
    //   18106: aload 35
    //   18108: invokevirtual 903	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   18111: astore 21
    //   18113: aload 24
    //   18115: aload 21
    //   18117: putfield 906	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   18120: aload 24
    //   18122: aconst_null
    //   18123: putfield 909	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   18126: aload 24
    //   18128: aload_2
    //   18129: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   18132: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   18135: putfield 910	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   18138: aload 24
    //   18140: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   18143: aload_0
    //   18144: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   18147: lsub
    //   18148: putfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   18151: aload 24
    //   18153: aload_2
    //   18154: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   18157: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   18160: putfield 916	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   18163: aload 24
    //   18165: aload 24
    //   18167: getfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   18170: aload_2
    //   18171: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   18174: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   18177: lsub
    //   18178: putfield 919	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   18181: aload 24
    //   18183: lload 11
    //   18185: putfield 922	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   18188: aload 24
    //   18190: aload_0
    //   18191: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   18194: putfield 925	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   18197: aload 24
    //   18199: aload_0
    //   18200: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   18203: putfield 928	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   18206: aload 24
    //   18208: aload_0
    //   18209: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   18212: putfield 931	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   18215: aload 24
    //   18217: lconst_0
    //   18218: putfield 934	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   18221: aload 24
    //   18223: aload_0
    //   18224: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   18227: putfield 937	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   18230: aload 24
    //   18232: aload_2
    //   18233: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   18236: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   18239: putfield 940	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   18242: aload 24
    //   18244: aload_0
    //   18245: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   18248: invokestatic 943	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   18251: putfield 945	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   18254: aload 24
    //   18256: aload_0
    //   18257: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   18260: putfield 948	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   18263: aload_0
    //   18264: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   18267: astore 21
    //   18269: aload 21
    //   18271: ifnull +19 -> 18290
    //   18274: aload 21
    //   18276: aload 33
    //   18278: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   18281: ifeq +9 -> 18290
    //   18284: iconst_1
    //   18285: istore 9
    //   18287: goto +6 -> 18293
    //   18290: iconst_0
    //   18291: istore 9
    //   18293: aload 24
    //   18295: iload 9
    //   18297: putfield 951	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   18300: aload 24
    //   18302: aload_2
    //   18303: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   18306: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   18309: putfield 953	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   18312: aload 24
    //   18314: getstatic 959	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   18317: invokevirtual 962	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   18320: putfield 965	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   18323: aload 23
    //   18325: ifnull +24 -> 18349
    //   18328: aload 23
    //   18330: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   18333: ifnull +16 -> 18349
    //   18336: aload 24
    //   18338: aload 23
    //   18340: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   18343: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   18346: putfield 967	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   18349: aload_2
    //   18350: astore 21
    //   18352: aload 21
    //   18354: aload 24
    //   18356: invokevirtual 971	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   18359: aload_2
    //   18360: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   18363: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   18366: ifeq +15 -> 18381
    //   18369: aload_0
    //   18370: aload_1
    //   18371: aload 21
    //   18373: aload 24
    //   18375: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   18378: goto +6 -> 18384
    //   18381: goto +3 -> 18384
    //   18384: aload_1
    //   18385: astore 22
    //   18387: aload_2
    //   18388: astore 21
    //   18390: aload_0
    //   18391: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   18394: ifeq +27 -> 18421
    //   18397: aload_0
    //   18398: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   18401: ifnull +12 -> 18413
    //   18404: aload_0
    //   18405: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   18408: invokeinterface 974 1 0
    //   18413: aload_0
    //   18414: aconst_null
    //   18415: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   18418: goto +26 -> 18444
    //   18421: aload_0
    //   18422: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   18425: ifnull +15 -> 18440
    //   18428: aload_0
    //   18429: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   18432: invokevirtual 979	org/apache/http/client/methods/HttpGet:abort	()V
    //   18435: aload_0
    //   18436: aconst_null
    //   18437: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   18440: aload_0
    //   18441: invokevirtual 982	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   18444: iload 4
    //   18446: iconst_1
    //   18447: iadd
    //   18448: istore_3
    //   18449: aload_0
    //   18450: invokevirtual 995	com/tencent/component/network/downloader/impl/FastDownloadTask:canAttempt	()Z
    //   18453: ifne +4 -> 18457
    //   18456: return
    //   18457: iload_3
    //   18458: istore 5
    //   18460: goto -18422 -> 38
    //   18463: astore 29
    //   18465: aload 25
    //   18467: astore 21
    //   18469: aload 29
    //   18471: astore 25
    //   18473: goto +8 -> 18481
    //   18476: astore 25
    //   18478: aconst_null
    //   18479: astore 21
    //   18481: lload 11
    //   18483: lstore 15
    //   18485: ldc 225
    //   18487: astore 34
    //   18489: ldc_w 464
    //   18492: astore 29
    //   18494: aload 22
    //   18496: astore 36
    //   18498: aload 28
    //   18500: astore 22
    //   18502: ldc_w 468
    //   18505: astore 37
    //   18507: lload 13
    //   18509: lstore 11
    //   18511: aload 26
    //   18513: astore 35
    //   18515: aload 27
    //   18517: astore 28
    //   18519: aload 24
    //   18521: astore 32
    //   18523: aload 21
    //   18525: astore 24
    //   18527: lload 15
    //   18529: lstore 13
    //   18531: aload 25
    //   18533: astore 27
    //   18535: aload 36
    //   18537: astore 26
    //   18539: aload 37
    //   18541: astore 21
    //   18543: aload 35
    //   18545: astore 25
    //   18547: aload_2
    //   18548: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   18551: lload 11
    //   18553: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   18556: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   18559: aload_2
    //   18560: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   18563: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   18566: aload_0
    //   18567: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   18570: lsub
    //   18571: putfield 678	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   18574: aload_2
    //   18575: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   18578: aload_0
    //   18579: getfield 681	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   18582: putfield 684	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   18585: aload_0
    //   18586: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   18589: invokestatic 689	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   18592: invokevirtual 693	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   18595: astore 38
    //   18597: aload_0
    //   18598: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   18601: ifnull +28 -> 18629
    //   18604: aload_0
    //   18605: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   18608: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   18611: ifnull +18 -> 18629
    //   18614: aload_0
    //   18615: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   18618: invokevirtual 499	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   18621: getfield 502	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   18624: astore 36
    //   18626: goto +6 -> 18632
    //   18629: aconst_null
    //   18630: astore 36
    //   18632: aload_0
    //   18633: aload_0
    //   18634: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   18637: aload 26
    //   18639: aload 23
    //   18641: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   18644: astore 39
    //   18646: aload 28
    //   18648: ifnull +52 -> 18700
    //   18651: aload 28
    //   18653: ldc_w 699
    //   18656: invokeinterface 705 2 0
    //   18661: checkcast 282	java/lang/String
    //   18664: astore 35
    //   18666: goto +8 -> 18674
    //   18669: ldc_w 429
    //   18672: astore 35
    //   18674: aload 28
    //   18676: ldc_w 707
    //   18679: invokeinterface 705 2 0
    //   18684: checkcast 282	java/lang/String
    //   18687: astore 28
    //   18689: goto +20 -> 18709
    //   18692: ldc_w 429
    //   18695: astore 28
    //   18697: goto +12 -> 18709
    //   18700: ldc_w 429
    //   18703: astore 28
    //   18705: aload 28
    //   18707: astore 35
    //   18709: aload_2
    //   18710: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   18713: aload 35
    //   18715: putfield 710	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   18718: aload_0
    //   18719: lconst_0
    //   18720: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   18723: aload_0
    //   18724: iconst_0
    //   18725: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   18728: aload_0
    //   18729: lconst_0
    //   18730: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   18733: aload_0
    //   18734: iconst_0
    //   18735: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   18738: aload_2
    //   18739: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   18742: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   18745: ifeq +12 -> 18757
    //   18748: aload_1
    //   18749: invokeinterface 359 1 0
    //   18754: ifeq +31 -> 18785
    //   18757: aload_0
    //   18758: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   18761: ifnull +24 -> 18785
    //   18764: aload_0
    //   18765: getfield 556	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   18768: aload_0
    //   18769: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   18772: aload_2
    //   18773: invokevirtual 716	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   18776: aload 26
    //   18778: aload 23
    //   18780: invokeinterface 720 5 0
    //   18785: aload_1
    //   18786: invokeinterface 359 1 0
    //   18791: ifne +2723 -> 21514
    //   18794: aload_0
    //   18795: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   18798: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   18801: istore 8
    //   18803: aload_2
    //   18804: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   18807: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   18810: ifne +911 -> 19721
    //   18813: new 123	java/lang/StringBuilder
    //   18816: dup
    //   18817: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   18820: astore 40
    //   18822: aload 40
    //   18824: ldc_w 722
    //   18827: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18830: pop
    //   18831: aload 40
    //   18833: aload_0
    //   18834: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   18837: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18840: pop
    //   18841: aload 40
    //   18843: ldc_w 724
    //   18846: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18849: pop
    //   18850: aload 40
    //   18852: aload_0
    //   18853: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   18856: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   18859: pop
    //   18860: aload 40
    //   18862: ldc_w 729
    //   18865: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18868: pop
    //   18869: aload_0
    //   18870: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   18873: ifeq +29 -> 18902
    //   18876: aload 23
    //   18878: ifnull +24 -> 18902
    //   18881: aload 23
    //   18883: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   18886: ifnull +16 -> 18902
    //   18889: aload 23
    //   18891: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   18894: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   18897: astore 37
    //   18899: goto +8 -> 18907
    //   18902: ldc_w 738
    //   18905: astore 37
    //   18907: aload 40
    //   18909: aload 37
    //   18911: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18914: pop
    //   18915: aload 40
    //   18917: ldc_w 740
    //   18920: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18923: pop
    //   18924: aload 40
    //   18926: aload 38
    //   18928: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18931: pop
    //   18932: aload 40
    //   18934: ldc_w 745
    //   18937: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18940: pop
    //   18941: aload 40
    //   18943: aload 36
    //   18945: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18948: pop
    //   18949: aload 40
    //   18951: ldc_w 747
    //   18954: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18957: pop
    //   18958: aload 40
    //   18960: aconst_null
    //   18961: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18964: pop
    //   18965: aload 40
    //   18967: ldc_w 749
    //   18970: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18973: pop
    //   18974: aload 40
    //   18976: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   18979: invokevirtual 172	java/lang/Thread:getId	()J
    //   18982: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   18985: pop
    //   18986: aload 40
    //   18988: ldc_w 751
    //   18991: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18994: pop
    //   18995: aload 40
    //   18997: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   19000: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19003: pop
    //   19004: aload 40
    //   19006: ldc_w 753
    //   19009: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19012: pop
    //   19013: aload 40
    //   19015: aload_0
    //   19016: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   19019: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19022: pop
    //   19023: aload 40
    //   19025: ldc_w 755
    //   19028: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19031: pop
    //   19032: aload 40
    //   19034: aload_0
    //   19035: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   19038: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19041: pop
    //   19042: aload 40
    //   19044: ldc_w 757
    //   19047: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19050: pop
    //   19051: aload_0
    //   19052: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   19055: ifeq +19 -> 19074
    //   19058: aload_0
    //   19059: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   19062: aload_0
    //   19063: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   19066: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   19069: astore 37
    //   19071: goto +6 -> 19077
    //   19074: aconst_null
    //   19075: astore 37
    //   19077: aload 40
    //   19079: aload 37
    //   19081: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19084: pop
    //   19085: aload 40
    //   19087: ldc_w 759
    //   19090: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19093: pop
    //   19094: aload 40
    //   19096: iload 8
    //   19098: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19101: pop
    //   19102: aload 40
    //   19104: ldc_w 761
    //   19107: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19110: pop
    //   19111: aload 40
    //   19113: aload 28
    //   19115: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19118: pop
    //   19119: aload 40
    //   19121: ldc_w 763
    //   19124: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19127: pop
    //   19128: aload 40
    //   19130: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   19133: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19136: pop
    //   19137: aload 40
    //   19139: aload 29
    //   19141: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19144: pop
    //   19145: aload 40
    //   19147: aload_2
    //   19148: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   19151: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   19154: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19157: pop
    //   19158: aload 40
    //   19160: ldc_w 768
    //   19163: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19166: pop
    //   19167: aload 40
    //   19169: aload_2
    //   19170: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   19173: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   19176: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19179: pop
    //   19180: aload 40
    //   19182: aload 21
    //   19184: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19187: pop
    //   19188: aload 40
    //   19190: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   19193: aload_0
    //   19194: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   19197: lsub
    //   19198: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19201: pop
    //   19202: aload 40
    //   19204: aload 31
    //   19206: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19209: pop
    //   19210: aload 40
    //   19212: aload_2
    //   19213: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   19216: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   19219: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19222: pop
    //   19223: aload 40
    //   19225: ldc_w 776
    //   19228: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19231: pop
    //   19232: aload 40
    //   19234: aload_2
    //   19235: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   19238: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   19241: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19244: pop
    //   19245: aload 40
    //   19247: ldc_w 780
    //   19250: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19253: pop
    //   19254: aload 40
    //   19256: aload_2
    //   19257: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   19260: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   19263: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19266: pop
    //   19267: aload 40
    //   19269: ldc_w 785
    //   19272: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19275: pop
    //   19276: aload 40
    //   19278: aload_0
    //   19279: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   19282: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19285: pop
    //   19286: aload 40
    //   19288: aload 25
    //   19290: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19293: pop
    //   19294: aload 40
    //   19296: aload_0
    //   19297: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   19300: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19303: pop
    //   19304: aload 40
    //   19306: ldc_w 790
    //   19309: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19312: pop
    //   19313: aload 40
    //   19315: aload_2
    //   19316: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   19319: invokevirtual 793	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   19322: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19325: pop
    //   19326: aload 40
    //   19328: ldc_w 795
    //   19331: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19334: pop
    //   19335: aload 40
    //   19337: iload_3
    //   19338: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19341: pop
    //   19342: aload 40
    //   19344: aload 22
    //   19346: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19349: pop
    //   19350: aload 40
    //   19352: aload 39
    //   19354: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19357: pop
    //   19358: aload 40
    //   19360: aload 30
    //   19362: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19365: pop
    //   19366: aload 40
    //   19368: aload 35
    //   19370: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19373: pop
    //   19374: aload 40
    //   19376: ldc_w 797
    //   19379: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19382: pop
    //   19383: aload_0
    //   19384: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   19387: astore 37
    //   19389: aload 37
    //   19391: ifnull +16 -> 19407
    //   19394: aload 37
    //   19396: iconst_0
    //   19397: bipush 30
    //   19399: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   19402: astore 37
    //   19404: goto +3 -> 19407
    //   19407: aload 40
    //   19409: aload 37
    //   19411: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19414: pop
    //   19415: aload 40
    //   19417: ldc_w 803
    //   19420: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19423: pop
    //   19424: aload_0
    //   19425: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   19428: ifnull +15 -> 19443
    //   19431: aload_0
    //   19432: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   19435: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   19438: istore 4
    //   19440: goto +6 -> 19446
    //   19443: iconst_0
    //   19444: istore 4
    //   19446: aload 40
    //   19448: iload 4
    //   19450: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19453: pop
    //   19454: aload 40
    //   19456: ldc_w 805
    //   19459: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19462: pop
    //   19463: aload 40
    //   19465: aload_2
    //   19466: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   19469: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   19472: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19475: pop
    //   19476: aload 40
    //   19478: ldc_w 810
    //   19481: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19484: pop
    //   19485: aload 40
    //   19487: lload 13
    //   19489: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19492: pop
    //   19493: aload 40
    //   19495: ldc_w 812
    //   19498: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19501: pop
    //   19502: aload 40
    //   19504: aload_0
    //   19505: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   19508: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19511: pop
    //   19512: aload 40
    //   19514: aload 25
    //   19516: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19519: pop
    //   19520: aload 40
    //   19522: aload_0
    //   19523: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   19526: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19529: pop
    //   19530: aload 40
    //   19532: ldc_w 814
    //   19535: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19538: pop
    //   19539: aload 40
    //   19541: aload_0
    //   19542: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   19545: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19548: pop
    //   19549: aload 40
    //   19551: aload 25
    //   19553: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19556: pop
    //   19557: aload 40
    //   19559: aload_0
    //   19560: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   19563: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19566: pop
    //   19567: aload 40
    //   19569: ldc_w 816
    //   19572: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19575: pop
    //   19576: aload 40
    //   19578: aload_0
    //   19579: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   19582: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19585: pop
    //   19586: aload 40
    //   19588: ldc_w 818
    //   19591: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19594: pop
    //   19595: aload 40
    //   19597: aload_0
    //   19598: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   19601: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19604: pop
    //   19605: aload 40
    //   19607: ldc_w 823
    //   19610: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19613: pop
    //   19614: aload 40
    //   19616: aload_0
    //   19617: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   19620: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19623: pop
    //   19624: aload 40
    //   19626: ldc_w 828
    //   19629: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19632: pop
    //   19633: aload_0
    //   19634: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   19637: ifnull +17 -> 19654
    //   19640: aload_0
    //   19641: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   19644: invokeinterface 458 1 0
    //   19649: astore 25
    //   19651: goto +6 -> 19657
    //   19654: aconst_null
    //   19655: astore 25
    //   19657: aload 40
    //   19659: aload 25
    //   19661: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19664: pop
    //   19665: aload 32
    //   19667: aload 40
    //   19669: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19672: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   19675: ldc_w 833
    //   19678: aload 32
    //   19680: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   19683: aload 24
    //   19685: invokestatic 837	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   19688: aload_0
    //   19689: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   19692: astore 25
    //   19694: aload 25
    //   19696: ifnull +22 -> 19718
    //   19699: aload 25
    //   19701: ldc_w 839
    //   19704: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   19707: ifeq +11 -> 19718
    //   19710: aload_0
    //   19711: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   19714: iconst_0
    //   19715: invokestatic 844	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   19718: goto +846 -> 20564
    //   19721: new 123	java/lang/StringBuilder
    //   19724: dup
    //   19725: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   19728: astore 40
    //   19730: aload 40
    //   19732: ldc_w 846
    //   19735: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19738: pop
    //   19739: aload 40
    //   19741: aload_0
    //   19742: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   19745: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19748: pop
    //   19749: aload 40
    //   19751: ldc_w 724
    //   19754: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19757: pop
    //   19758: aload 40
    //   19760: aload_0
    //   19761: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   19764: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19767: pop
    //   19768: aload 40
    //   19770: ldc_w 729
    //   19773: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19776: pop
    //   19777: aload_0
    //   19778: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   19781: ifeq +29 -> 19810
    //   19784: aload 23
    //   19786: ifnull +24 -> 19810
    //   19789: aload 23
    //   19791: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   19794: ifnull +16 -> 19810
    //   19797: aload 23
    //   19799: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   19802: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   19805: astore 37
    //   19807: goto +8 -> 19815
    //   19810: ldc_w 738
    //   19813: astore 37
    //   19815: aload 40
    //   19817: aload 37
    //   19819: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19822: pop
    //   19823: aload 40
    //   19825: ldc_w 740
    //   19828: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19831: pop
    //   19832: aload 40
    //   19834: aload 38
    //   19836: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19839: pop
    //   19840: aload 40
    //   19842: ldc_w 745
    //   19845: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19848: pop
    //   19849: aload 40
    //   19851: aload 36
    //   19853: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19856: pop
    //   19857: aload 40
    //   19859: ldc_w 747
    //   19862: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19865: pop
    //   19866: aload 40
    //   19868: aconst_null
    //   19869: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19872: pop
    //   19873: aload 40
    //   19875: ldc_w 749
    //   19878: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19881: pop
    //   19882: aload 40
    //   19884: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   19887: invokevirtual 172	java/lang/Thread:getId	()J
    //   19890: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19893: pop
    //   19894: aload 40
    //   19896: ldc_w 751
    //   19899: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19902: pop
    //   19903: aload 40
    //   19905: invokestatic 156	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   19908: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19911: pop
    //   19912: aload 40
    //   19914: ldc_w 753
    //   19917: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19920: pop
    //   19921: aload 40
    //   19923: aload_0
    //   19924: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   19927: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19930: pop
    //   19931: aload 40
    //   19933: ldc_w 755
    //   19936: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19939: pop
    //   19940: aload 40
    //   19942: aload_0
    //   19943: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   19946: invokevirtual 727	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19949: pop
    //   19950: aload 40
    //   19952: ldc_w 757
    //   19955: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19958: pop
    //   19959: aload_0
    //   19960: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   19963: ifeq +19 -> 19982
    //   19966: aload_0
    //   19967: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   19970: aload_0
    //   19971: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   19974: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   19977: astore 37
    //   19979: goto +6 -> 19985
    //   19982: aconst_null
    //   19983: astore 37
    //   19985: aload 40
    //   19987: aload 37
    //   19989: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19992: pop
    //   19993: aload 40
    //   19995: ldc_w 763
    //   19998: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20001: pop
    //   20002: aload 40
    //   20004: invokestatic 489	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   20007: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20010: pop
    //   20011: aload 40
    //   20013: ldc_w 761
    //   20016: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20019: pop
    //   20020: aload 40
    //   20022: aload 28
    //   20024: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20027: pop
    //   20028: aload 40
    //   20030: ldc_w 768
    //   20033: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20036: pop
    //   20037: aload 40
    //   20039: aload_2
    //   20040: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   20043: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   20046: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20049: pop
    //   20050: aload 40
    //   20052: aload 21
    //   20054: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20057: pop
    //   20058: aload 40
    //   20060: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   20063: aload_0
    //   20064: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   20067: lsub
    //   20068: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20071: pop
    //   20072: aload 40
    //   20074: aload 31
    //   20076: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20079: pop
    //   20080: aload 40
    //   20082: aload_2
    //   20083: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20086: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   20089: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20092: pop
    //   20093: aload 40
    //   20095: ldc_w 776
    //   20098: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20101: pop
    //   20102: aload 40
    //   20104: aload_2
    //   20105: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20108: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   20111: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20114: pop
    //   20115: aload 40
    //   20117: ldc_w 780
    //   20120: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20123: pop
    //   20124: aload 40
    //   20126: aload_2
    //   20127: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20130: getfield 783	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   20133: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20136: pop
    //   20137: aload 40
    //   20139: ldc_w 785
    //   20142: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20145: pop
    //   20146: aload 40
    //   20148: aload_0
    //   20149: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   20152: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20155: pop
    //   20156: aload 40
    //   20158: aload 25
    //   20160: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20163: pop
    //   20164: aload 40
    //   20166: aload_0
    //   20167: invokevirtual 788	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   20170: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20173: pop
    //   20174: aload 40
    //   20176: ldc_w 848
    //   20179: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20182: pop
    //   20183: aload 40
    //   20185: iload_3
    //   20186: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20189: pop
    //   20190: aload 40
    //   20192: aload 22
    //   20194: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20197: pop
    //   20198: aload 40
    //   20200: aload 39
    //   20202: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20205: pop
    //   20206: aload 40
    //   20208: aload 29
    //   20210: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20213: pop
    //   20214: aload 40
    //   20216: aload_2
    //   20217: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20220: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   20223: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20226: pop
    //   20227: aload 40
    //   20229: aload 30
    //   20231: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20234: pop
    //   20235: aload 40
    //   20237: aload 35
    //   20239: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20242: pop
    //   20243: aload 40
    //   20245: ldc_w 797
    //   20248: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20251: pop
    //   20252: aload_0
    //   20253: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   20256: astore 37
    //   20258: aload 37
    //   20260: ifnull +16 -> 20276
    //   20263: aload 37
    //   20265: iconst_0
    //   20266: bipush 30
    //   20268: invokevirtual 801	java/lang/String:substring	(II)Ljava/lang/String;
    //   20271: astore 37
    //   20273: goto +3 -> 20276
    //   20276: aload 40
    //   20278: aload 37
    //   20280: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20283: pop
    //   20284: aload 40
    //   20286: ldc_w 803
    //   20289: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20292: pop
    //   20293: aload_0
    //   20294: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   20297: ifnull +15 -> 20312
    //   20300: aload_0
    //   20301: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   20304: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   20307: istore 4
    //   20309: goto +6 -> 20315
    //   20312: iconst_0
    //   20313: istore 4
    //   20315: aload 40
    //   20317: iload 4
    //   20319: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20322: pop
    //   20323: aload 40
    //   20325: ldc_w 805
    //   20328: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20331: pop
    //   20332: aload 40
    //   20334: aload_2
    //   20335: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20338: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   20341: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20344: pop
    //   20345: aload 40
    //   20347: ldc_w 810
    //   20350: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20353: pop
    //   20354: aload 40
    //   20356: lload 13
    //   20358: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20361: pop
    //   20362: aload 40
    //   20364: ldc_w 812
    //   20367: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20370: pop
    //   20371: aload 40
    //   20373: aload_0
    //   20374: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   20377: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20380: pop
    //   20381: aload 40
    //   20383: aload 25
    //   20385: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20388: pop
    //   20389: aload 40
    //   20391: aload_0
    //   20392: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   20395: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20398: pop
    //   20399: aload 40
    //   20401: ldc_w 814
    //   20404: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20407: pop
    //   20408: aload 40
    //   20410: aload_0
    //   20411: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   20414: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20417: pop
    //   20418: aload 40
    //   20420: aload 25
    //   20422: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20425: pop
    //   20426: aload 40
    //   20428: aload_0
    //   20429: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   20432: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20435: pop
    //   20436: aload 40
    //   20438: ldc_w 816
    //   20441: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20444: pop
    //   20445: aload 40
    //   20447: aload_0
    //   20448: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   20451: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20454: pop
    //   20455: aload 40
    //   20457: ldc_w 818
    //   20460: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20463: pop
    //   20464: aload 40
    //   20466: aload_0
    //   20467: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   20470: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20473: pop
    //   20474: aload 40
    //   20476: ldc_w 823
    //   20479: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20482: pop
    //   20483: aload 40
    //   20485: aload_0
    //   20486: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   20489: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20492: pop
    //   20493: aload 40
    //   20495: ldc_w 828
    //   20498: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20501: pop
    //   20502: aload_0
    //   20503: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   20506: ifnull +17 -> 20523
    //   20509: aload_0
    //   20510: getfield 452	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   20513: invokeinterface 458 1 0
    //   20518: astore 25
    //   20520: goto +6 -> 20526
    //   20523: aconst_null
    //   20524: astore 25
    //   20526: aload 40
    //   20528: aload 25
    //   20530: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20533: pop
    //   20534: aload 40
    //   20536: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20539: astore 37
    //   20541: aload 32
    //   20543: astore 25
    //   20545: aload 25
    //   20547: aload 37
    //   20549: putfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   20552: ldc_w 833
    //   20555: aload 25
    //   20557: getfield 831	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   20560: aconst_null
    //   20561: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   20564: iload 8
    //   20566: ifne +11 -> 20577
    //   20569: aload_0
    //   20570: iconst_0
    //   20571: putfield 854	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   20574: goto +3 -> 20577
    //   20577: aload_2
    //   20578: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   20581: astore 25
    //   20583: new 123	java/lang/StringBuilder
    //   20586: dup
    //   20587: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   20590: astore 37
    //   20592: aload 37
    //   20594: aload_0
    //   20595: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   20598: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20601: pop
    //   20602: aload 37
    //   20604: ldc_w 856
    //   20607: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20610: pop
    //   20611: aload 37
    //   20613: aload 36
    //   20615: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20618: pop
    //   20619: aload 37
    //   20621: ldc_w 858
    //   20624: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20627: pop
    //   20628: aload 37
    //   20630: aload_2
    //   20631: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20634: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   20637: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20640: pop
    //   20641: aload 37
    //   20643: ldc_w 860
    //   20646: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20649: pop
    //   20650: aload_0
    //   20651: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   20654: ifnull +15 -> 20669
    //   20657: aload_0
    //   20658: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   20661: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   20664: istore 4
    //   20666: goto +6 -> 20672
    //   20669: iconst_0
    //   20670: istore 4
    //   20672: aload 37
    //   20674: iload 4
    //   20676: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20679: pop
    //   20680: aload 37
    //   20682: ldc_w 795
    //   20685: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20688: pop
    //   20689: aload 37
    //   20691: iload_3
    //   20692: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20695: pop
    //   20696: aload 37
    //   20698: aload 29
    //   20700: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20703: pop
    //   20704: aload 37
    //   20706: aload_2
    //   20707: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20710: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   20713: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20716: pop
    //   20717: aload 37
    //   20719: aload 31
    //   20721: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20724: pop
    //   20725: aload 37
    //   20727: aload_2
    //   20728: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20731: getfield 774	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   20734: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20737: pop
    //   20738: aload 37
    //   20740: ldc_w 776
    //   20743: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20746: pop
    //   20747: aload 37
    //   20749: aload_2
    //   20750: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   20753: getfield 778	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   20756: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20759: pop
    //   20760: aload 37
    //   20762: ldc_w 768
    //   20765: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20768: pop
    //   20769: aload 37
    //   20771: aload_2
    //   20772: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   20775: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   20778: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20781: pop
    //   20782: aload 37
    //   20784: aload 21
    //   20786: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20789: pop
    //   20790: aload 37
    //   20792: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   20795: aload_0
    //   20796: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   20799: lsub
    //   20800: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20803: pop
    //   20804: aload 35
    //   20806: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20809: ifne +38 -> 20847
    //   20812: new 123	java/lang/StringBuilder
    //   20815: dup
    //   20816: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   20819: astore 21
    //   20821: aload 21
    //   20823: aload 30
    //   20825: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20828: pop
    //   20829: aload 21
    //   20831: aload 35
    //   20833: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20836: pop
    //   20837: aload 21
    //   20839: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20842: astore 21
    //   20844: goto +8 -> 20852
    //   20847: ldc_w 429
    //   20850: astore 21
    //   20852: aload 37
    //   20854: aload 21
    //   20856: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20859: pop
    //   20860: aload 37
    //   20862: aload 22
    //   20864: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20867: pop
    //   20868: aload 37
    //   20870: aload 39
    //   20872: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20875: pop
    //   20876: aload 25
    //   20878: aload 37
    //   20880: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20883: putfield 863	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   20886: aload_0
    //   20887: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   20890: ifnull +121 -> 21011
    //   20893: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   20896: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   20899: aload_0
    //   20900: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   20903: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   20906: if_icmpne +105 -> 21011
    //   20909: aload_0
    //   20910: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   20913: ifnull +98 -> 21011
    //   20916: aload 28
    //   20918: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20921: ifne +40 -> 20961
    //   20924: aload_0
    //   20925: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   20928: astore 21
    //   20930: aload_0
    //   20931: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   20934: astore 22
    //   20936: aload_2
    //   20937: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   20940: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   20943: istore 9
    //   20945: aload 21
    //   20947: aload 22
    //   20949: aload 28
    //   20951: iload 9
    //   20953: invokeinterface 867 4 0
    //   20958: goto +53 -> 21011
    //   20961: aload_0
    //   20962: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   20965: aload_0
    //   20966: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   20969: aload_0
    //   20970: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   20973: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   20976: aload_2
    //   20977: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   20980: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   20983: invokeinterface 867 4 0
    //   20988: goto +23 -> 21011
    //   20991: astore 21
    //   20993: goto +5 -> 20998
    //   20996: astore 21
    //   20998: aload 34
    //   21000: ldc_w 872
    //   21003: aload 21
    //   21005: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   21008: goto +3 -> 21011
    //   21011: aload_0
    //   21012: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   21015: ifnull +101 -> 21116
    //   21018: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   21021: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   21024: aload_0
    //   21025: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   21028: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   21031: if_icmpne +85 -> 21116
    //   21034: aload_0
    //   21035: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   21038: ifnull +78 -> 21116
    //   21041: aload 28
    //   21043: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21046: ifne +28 -> 21074
    //   21049: aload_0
    //   21050: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   21053: aload_0
    //   21054: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   21057: aload 28
    //   21059: aload_2
    //   21060: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   21063: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   21066: invokeinterface 867 4 0
    //   21071: goto +45 -> 21116
    //   21074: aload_0
    //   21075: getfield 310	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   21078: aload_0
    //   21079: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   21082: aload_0
    //   21083: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   21086: invokestatic 870	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   21089: aload_2
    //   21090: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   21093: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   21096: invokeinterface 867 4 0
    //   21101: goto +15 -> 21116
    //   21104: astore 21
    //   21106: aload 34
    //   21108: ldc_w 874
    //   21111: aload 21
    //   21113: invokestatic 851	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   21116: iload 8
    //   21118: ifeq +74 -> 21192
    //   21121: aload_0
    //   21122: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   21125: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   21128: astore 21
    //   21130: aload_0
    //   21131: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   21134: astore 22
    //   21136: aload_0
    //   21137: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   21140: ifeq +30 -> 21170
    //   21143: aload_0
    //   21144: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   21147: astore 25
    //   21149: aload 25
    //   21151: ifnull +19 -> 21170
    //   21154: aload 25
    //   21156: aload 33
    //   21158: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   21161: ifeq +9 -> 21170
    //   21164: iconst_1
    //   21165: istore 8
    //   21167: goto +6 -> 21173
    //   21170: iconst_0
    //   21171: istore 8
    //   21173: aload 21
    //   21175: aload 22
    //   21177: iload 8
    //   21179: aload_2
    //   21180: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   21183: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   21186: invokevirtual 878	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   21189: goto +3 -> 21192
    //   21192: aload 32
    //   21194: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   21197: putfield 881	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   21200: aload 32
    //   21202: aload_0
    //   21203: invokevirtual 884	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   21206: putfield 887	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   21209: aload 32
    //   21211: aload 26
    //   21213: putfield 891	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   21216: aload 32
    //   21218: aload 23
    //   21220: putfield 895	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   21223: aload 32
    //   21225: iload_3
    //   21226: putfield 896	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   21229: aload 32
    //   21231: aload 24
    //   21233: putfield 900	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   21236: aload 38
    //   21238: ifnonnull +9 -> 21247
    //   21241: aconst_null
    //   21242: astore 21
    //   21244: goto +10 -> 21254
    //   21247: aload 38
    //   21249: invokevirtual 903	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   21252: astore 21
    //   21254: aload 32
    //   21256: aload 21
    //   21258: putfield 906	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   21261: aload 32
    //   21263: aconst_null
    //   21264: putfield 909	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   21267: aload 32
    //   21269: aload_2
    //   21270: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   21273: getfield 808	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   21276: putfield 910	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   21279: aload 32
    //   21281: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   21284: aload_0
    //   21285: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   21288: lsub
    //   21289: putfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   21292: aload 32
    //   21294: aload_2
    //   21295: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   21298: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   21301: putfield 916	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   21304: aload 32
    //   21306: aload 32
    //   21308: getfield 913	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   21311: aload_2
    //   21312: invokevirtual 669	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   21315: getfield 771	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   21318: lsub
    //   21319: putfield 919	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   21322: aload 32
    //   21324: lload 13
    //   21326: putfield 922	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   21329: aload 32
    //   21331: aload_0
    //   21332: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   21335: putfield 925	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   21338: aload 32
    //   21340: aload_0
    //   21341: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   21344: putfield 928	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   21347: aload 32
    //   21349: aload_0
    //   21350: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   21353: putfield 931	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   21356: aload 32
    //   21358: lconst_0
    //   21359: putfield 934	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   21362: aload 32
    //   21364: aload_0
    //   21365: invokevirtual 826	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   21368: putfield 937	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   21371: aload 32
    //   21373: aload_2
    //   21374: invokevirtual 650	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   21377: getfield 766	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   21380: putfield 940	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   21383: aload 32
    //   21385: aload_0
    //   21386: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   21389: invokestatic 943	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   21392: putfield 945	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   21395: aload 32
    //   21397: aload_0
    //   21398: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   21401: putfield 948	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   21404: aload_0
    //   21405: getfield 484	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   21408: astore 21
    //   21410: aload 21
    //   21412: ifnull +19 -> 21431
    //   21415: aload 21
    //   21417: aload 33
    //   21419: invokevirtual 495	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   21422: ifeq +9 -> 21431
    //   21425: iconst_1
    //   21426: istore 8
    //   21428: goto +6 -> 21434
    //   21431: iconst_0
    //   21432: istore 8
    //   21434: aload 32
    //   21436: iload 8
    //   21438: putfield 951	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   21441: aload 32
    //   21443: aload_2
    //   21444: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   21447: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   21450: putfield 953	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   21453: aload 32
    //   21455: getstatic 959	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   21458: invokevirtual 962	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   21461: putfield 965	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   21464: aload 23
    //   21466: ifnull +24 -> 21490
    //   21469: aload 23
    //   21471: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   21474: ifnull +16 -> 21490
    //   21477: aload 32
    //   21479: aload 23
    //   21481: invokevirtual 733	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   21484: invokevirtual 736	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   21487: putfield 967	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   21490: aload_2
    //   21491: aload 32
    //   21493: invokevirtual 971	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   21496: aload_2
    //   21497: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   21500: invokevirtual 713	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   21503: ifeq +11 -> 21514
    //   21506: aload_0
    //   21507: aload_1
    //   21508: aload_2
    //   21509: aload 32
    //   21511: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   21514: aload_0
    //   21515: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   21518: ifeq +27 -> 21545
    //   21521: aload_0
    //   21522: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   21525: ifnull +12 -> 21537
    //   21528: aload_0
    //   21529: getfield 606	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   21532: invokeinterface 974 1 0
    //   21537: aload_0
    //   21538: aconst_null
    //   21539: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   21542: goto +26 -> 21568
    //   21545: aload_0
    //   21546: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   21549: ifnull +15 -> 21564
    //   21552: aload_0
    //   21553: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   21556: invokevirtual 979	org/apache/http/client/methods/HttpGet:abort	()V
    //   21559: aload_0
    //   21560: aconst_null
    //   21561: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   21564: aload_0
    //   21565: invokevirtual 982	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   21568: goto +6 -> 21574
    //   21571: aload 27
    //   21573: athrow
    //   21574: goto -3 -> 21571
    //   21577: astore 23
    //   21579: goto -21482 -> 97
    //   21582: astore 26
    //   21584: goto -19223 -> 2361
    //   21587: astore 26
    //   21589: goto -19202 -> 2387
    //   21592: astore 26
    //   21594: goto -16164 -> 5430
    //   21597: astore 27
    //   21599: goto -16139 -> 5460
    //   21602: astore 26
    //   21604: goto -13021 -> 8583
    //   21607: astore 27
    //   21609: goto -12996 -> 8613
    //   21612: astore 22
    //   21614: goto -9890 -> 11724
    //   21617: astore 22
    //   21619: goto -9873 -> 11746
    //   21622: astore 29
    //   21624: goto -6109 -> 15515
    //   21627: astore 27
    //   21629: goto -6092 -> 15537
    //   21632: astore 35
    //   21634: goto -2965 -> 18669
    //   21637: astore 28
    //   21639: goto -2947 -> 18692
    //   21642: goto -20640 -> 1002
    //   21645: goto +24 -> 21669
    //   21648: iload_3
    //   21649: iconst_2
    //   21650: if_icmpge +16 -> 21666
    //   21653: iload 9
    //   21655: ifeq +11 -> 21666
    //   21658: ldc_w 537
    //   21661: astore 22
    //   21663: goto -20952 -> 711
    //   21666: goto -20955 -> 711
    //   21669: aload 23
    //   21671: astore 22
    //   21673: goto -20671 -> 1002
    //   21676: astore 27
    //   21678: iconst_0
    //   21679: istore_3
    //   21680: aconst_null
    //   21681: astore 35
    //   21683: lload 11
    //   21685: lstore 15
    //   21687: ldc_w 464
    //   21690: astore 32
    //   21692: aload 23
    //   21694: astore 29
    //   21696: aload 22
    //   21698: astore 23
    //   21700: ldc_w 427
    //   21703: astore 22
    //   21705: ldc_w 468
    //   21708: astore 21
    //   21710: lload 13
    //   21712: lstore 11
    //   21714: ldc_w 460
    //   21717: astore 25
    //   21719: ldc_w 462
    //   21722: astore 31
    //   21724: aload 26
    //   21726: astore 28
    //   21728: aload 29
    //   21730: astore 26
    //   21732: aload 32
    //   21734: astore 29
    //   21736: aload 24
    //   21738: astore 32
    //   21740: lload 15
    //   21742: lstore 13
    //   21744: aload 35
    //   21746: astore 24
    //   21748: goto -3201 -> 18547
    //   21751: astore 25
    //   21753: iconst_0
    //   21754: istore_3
    //   21755: ldc_w 460
    //   21758: astore 32
    //   21760: aload 22
    //   21762: astore 29
    //   21764: aload 23
    //   21766: astore 22
    //   21768: ldc_w 462
    //   21771: astore 31
    //   21773: aload 26
    //   21775: astore 27
    //   21777: aload 29
    //   21779: astore 23
    //   21781: aload 32
    //   21783: astore 26
    //   21785: goto -6549 -> 15236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	21788	0	this	FastDownloadTask
    //   0	21788	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	21788	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   198	21557	3	i	int
    //   480	20195	4	j	int
    //   33	18426	5	k	int
    //   25	111	6	m	int
    //   630	1592	7	n	int
    //   30	21407	8	bool1	boolean
    //   189	21465	9	bool2	boolean
    //   4659	13151	10	bool3	boolean
    //   36	21677	11	l1	long
    //   122	21621	13	l2	long
    //   327	21414	15	l3	long
    //   179	1800	17	l4	long
    //   1707	3	19	l5	long
    //   4	220	21	localObject1	Object
    //   288	67	21	localObject2	Object
    //   360	1	21	localObject3	Object
    //   1117	1	21	localObject4	Object
    //   1425	1	21	localObject5	Object
    //   1789	2873	21	localObject6	Object
    //   4707	1	21	localException1	java.lang.Exception
    //   4712	8	21	localException2	java.lang.Exception
    //   4820	8	21	localException3	java.lang.Exception
    //   4844	2878	21	localObject7	Object
    //   7767	1	21	localException4	java.lang.Exception
    //   7772	8	21	localException5	java.lang.Exception
    //   7880	8	21	localException6	java.lang.Exception
    //   7904	2992	21	localObject8	Object
    //   10941	1	21	localException7	java.lang.Exception
    //   10946	8	21	localException8	java.lang.Exception
    //   11054	8	21	localException9	java.lang.Exception
    //   11078	288	21	localObject9	Object
    //   11501	253	21	localObject10	Object
    //   13902	123	21	localObject11	Object
    //   14070	1	21	localException10	java.lang.Exception
    //   14075	8	21	localException11	java.lang.Exception
    //   14183	8	21	localException12	java.lang.Exception
    //   14207	456	21	localObject12	Object
    //   14667	1	21	localObject13	Object
    //   14677	1	21	localObject14	Object
    //   14772	125	21	localObject15	Object
    //   14951	1	21	localObject16	Object
    //   14986	253	21	localObject17	Object
    //   15305	1	21	localObject18	Object
    //   15310	19	21	localObject19	Object
    //   15348	2456	21	localObject20	Object
    //   17849	1	21	localException13	java.lang.Exception
    //   17854	8	21	localException14	java.lang.Exception
    //   17962	8	21	localException15	java.lang.Exception
    //   17986	2960	21	localObject21	Object
    //   20991	1	21	localException16	java.lang.Exception
    //   20996	8	21	localException17	java.lang.Exception
    //   21104	8	21	localException18	java.lang.Exception
    //   21128	581	21	localObject22	Object
    //   1	203	22	localJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   208	18	22	localUnknownHostException	java.net.UnknownHostException
    //   267	46	22	localObject23	Object
    //   377	28	22	localThrowable1	java.lang.Throwable
    //   415	646	22	localObject24	Object
    //   1132	1	22	localThrowable2	java.lang.Throwable
    //   1147	1	22	localThrowable3	java.lang.Throwable
    //   1156	259	22	localObject25	Object
    //   1440	33	22	localThrowable4	java.lang.Throwable
    //   1478	13489	22	localObject26	Object
    //   14976	1	22	localObject27	Object
    //   15001	1	22	str1	String
    //   15011	1	22	localObject28	Object
    //   15031	1	22	str2	String
    //   15041	60	22	localObject29	Object
    //   15122	81	22	localObject30	Object
    //   15205	1	22	localObject31	Object
    //   15227	5949	22	localObject32	Object
    //   21612	1	22	localException19	java.lang.Exception
    //   21617	1	22	localException20	java.lang.Exception
    //   21661	106	22	localObject33	Object
    //   318	1452	23	localObject34	Object
    //   1794	1	23	localThrowable5	java.lang.Throwable
    //   1809	1	23	localObject35	Object
    //   1871	14	23	localThrowable6	java.lang.Throwable
    //   1890	19590	23	localObject36	Object
    //   21577	116	23	localException21	java.lang.Exception
    //   21698	82	23	localObject37	Object
    //   302	14287	24	localObject38	Object
    //   14672	1	24	localThrowable7	java.lang.Throwable
    //   14713	1	24	localObject39	Object
    //   14731	87	24	localThrowable8	java.lang.Throwable
    //   14823	1	24	localObject40	Object
    //   14828	39	24	localThrowable9	java.lang.Throwable
    //   14872	60	24	localObject41	Object
    //   14991	1	24	localThrowable10	java.lang.Throwable
    //   15006	1	24	localThrowable11	java.lang.Throwable
    //   15026	1	24	localThrowable12	java.lang.Throwable
    //   15098	1	24	localObject42	Object
    //   15131	13	24	localThrowable13	java.lang.Throwable
    //   15154	6593	24	localObject43	Object
    //   131	1756	25	localObject44	Object
    //   2150	6137	25	localThrowable14	java.lang.Throwable
    //   8378	1	25	str3	String
    //   8427	3034	25	localThrowable15	java.lang.Throwable
    //   11510	3396	25	localObject45	Object
    //   14936	1	25	localThrowable16	java.lang.Throwable
    //   14961	101	25	localThrowable17	java.lang.Throwable
    //   15114	3358	25	localObject46	Object
    //   18476	56	25	localObject47	Object
    //   18545	3173	25	localObject48	Object
    //   21751	1	25	localThrowable18	java.lang.Throwable
    //   243	11286	26	localObject49	Object
    //   11556	173	26	localThrowable19	java.lang.Throwable
    //   11949	3214	26	localObject50	Object
    //   15214	103	26	localThrowable20	java.lang.Throwable
    //   15334	5878	26	localObject51	Object
    //   21582	1	26	localException22	java.lang.Exception
    //   21587	1	26	localException23	java.lang.Exception
    //   21592	1	26	localException24	java.lang.Exception
    //   21602	123	26	localException25	java.lang.Exception
    //   21730	54	26	localObject52	Object
    //   293	1486	27	localObject53	Object
    //   1785	1	27	localObject54	Object
    //   1799	1	27	localObject55	Object
    //   1877	18	27	localObject56	Object
    //   2108	1	27	localObject57	Object
    //   2145	1	27	localObject58	Object
    //   2160	12592	27	localObject59	Object
    //   14758	1	27	localObject60	Object
    //   14832	29	27	localObject61	Object
    //   14877	1	27	localObject62	Object
    //   15102	6470	27	localObject63	Object
    //   21597	1	27	localException26	java.lang.Exception
    //   21607	1	27	localException27	java.lang.Exception
    //   21627	1	27	localException28	java.lang.Exception
    //   21676	1	27	localObject64	Object
    //   21775	1	27	localObject65	Object
    //   218	20840	28	localObject66	Object
    //   21637	1	28	localException29	java.lang.Exception
    //   21726	1	28	localObject67	Object
    //   307	17388	29	localObject68	Object
    //   18463	7	29	localObject69	Object
    //   18492	2207	29	str4	String
    //   21622	1	29	localException30	java.lang.Exception
    //   21694	84	29	localObject70	Object
    //   213	20611	30	localObject71	Object
    //   298	21474	31	localObject72	Object
    //   345	7679	32	localObject73	Object
    //   8344	69	32	localObject74	Object
    //   8418	13364	32	localObject75	Object
    //   340	21078	33	str5	String
    //   335	20772	34	localObject76	Object
    //   352	20480	35	localObject77	Object
    //   21632	1	35	localException31	java.lang.Exception
    //   21681	64	35	localObject78	Object
    //   2517	18097	36	localObject79	Object
    //   12804	8075	37	localObject80	Object
    //   15391	5857	38	localObject81	Object
    //   15490	5381	39	str6	String
    //   16590	3945	40	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   181	191	208	java/net/UnknownHostException
    //   274	285	288	finally
    //   467	471	288	finally
    //   506	526	288	finally
    //   526	577	288	finally
    //   274	285	377	java/lang/Throwable
    //   467	471	377	java/lang/Throwable
    //   577	585	1117	finally
    //   595	600	1117	finally
    //   604	615	1117	finally
    //   618	629	1117	finally
    //   632	639	1117	finally
    //   643	708	1117	finally
    //   711	727	1117	finally
    //   731	742	1117	finally
    //   745	756	1117	finally
    //   759	766	1117	finally
    //   770	779	1117	finally
    //   577	585	1132	java/lang/Throwable
    //   595	600	1132	java/lang/Throwable
    //   604	615	1132	java/lang/Throwable
    //   618	629	1132	java/lang/Throwable
    //   632	639	1132	java/lang/Throwable
    //   643	708	1132	java/lang/Throwable
    //   711	727	1132	java/lang/Throwable
    //   731	742	1132	java/lang/Throwable
    //   745	756	1132	java/lang/Throwable
    //   759	766	1132	java/lang/Throwable
    //   770	779	1132	java/lang/Throwable
    //   506	526	1147	java/lang/Throwable
    //   526	577	1147	java/lang/Throwable
    //   779	820	1425	finally
    //   824	848	1425	finally
    //   855	883	1425	finally
    //   887	898	1425	finally
    //   901	912	1425	finally
    //   915	922	1425	finally
    //   926	967	1425	finally
    //   971	995	1425	finally
    //   1002	1114	1425	finally
    //   1163	1176	1425	finally
    //   1186	1208	1425	finally
    //   1212	1223	1425	finally
    //   1226	1237	1425	finally
    //   1240	1247	1425	finally
    //   1251	1326	1425	finally
    //   1326	1422	1425	finally
    //   1494	1518	1425	finally
    //   1534	1561	1425	finally
    //   1604	1629	1425	finally
    //   779	820	1440	java/lang/Throwable
    //   824	848	1440	java/lang/Throwable
    //   855	883	1440	java/lang/Throwable
    //   887	898	1440	java/lang/Throwable
    //   901	912	1440	java/lang/Throwable
    //   915	922	1440	java/lang/Throwable
    //   926	967	1440	java/lang/Throwable
    //   971	995	1440	java/lang/Throwable
    //   1002	1114	1440	java/lang/Throwable
    //   1163	1176	1440	java/lang/Throwable
    //   1186	1208	1440	java/lang/Throwable
    //   1212	1223	1440	java/lang/Throwable
    //   1226	1237	1440	java/lang/Throwable
    //   1240	1247	1440	java/lang/Throwable
    //   1251	1326	1440	java/lang/Throwable
    //   1326	1422	1440	java/lang/Throwable
    //   1494	1518	1440	java/lang/Throwable
    //   1534	1561	1440	java/lang/Throwable
    //   1604	1629	1440	java/lang/Throwable
    //   1756	1771	1785	finally
    //   1756	1771	1794	java/lang/Throwable
    //   1737	1751	1799	finally
    //   1751	1756	1799	finally
    //   1924	1953	1799	finally
    //   1737	1751	1871	java/lang/Throwable
    //   1751	1756	1871	java/lang/Throwable
    //   1924	1953	1871	java/lang/Throwable
    //   2089	2105	2108	finally
    //   2113	2121	2145	finally
    //   2121	2142	2145	finally
    //   2089	2105	2150	java/lang/Throwable
    //   2113	2121	2150	java/lang/Throwable
    //   2121	2142	2150	java/lang/Throwable
    //   4661	4674	4707	java/lang/Exception
    //   4677	4704	4707	java/lang/Exception
    //   4632	4661	4712	java/lang/Exception
    //   4757	4787	4820	java/lang/Exception
    //   4790	4817	4820	java/lang/Exception
    //   7721	7734	7767	java/lang/Exception
    //   7737	7764	7767	java/lang/Exception
    //   7692	7721	7772	java/lang/Exception
    //   7817	7847	7880	java/lang/Exception
    //   7850	7877	7880	java/lang/Exception
    //   2202	2228	8344	finally
    //   2202	2228	8427	java/lang/Throwable
    //   10895	10908	10941	java/lang/Exception
    //   10911	10938	10941	java/lang/Exception
    //   10866	10895	10946	java/lang/Exception
    //   10991	11021	11054	java/lang/Exception
    //   11024	11051	11054	java/lang/Exception
    //   2181	2197	11501	finally
    //   2181	2197	11556	java/lang/Throwable
    //   14024	14037	14070	java/lang/Exception
    //   14040	14067	14070	java/lang/Exception
    //   13995	14024	14075	java/lang/Exception
    //   14120	14150	14183	java/lang/Exception
    //   14153	14180	14183	java/lang/Exception
    //   2162	2176	14667	finally
    //   2162	2176	14672	java/lang/Throwable
    //   2057	2065	14677	finally
    //   2057	2065	14731	java/lang/Throwable
    //   1974	1984	14758	finally
    //   1974	1984	14828	java/lang/Throwable
    //   1716	1732	14877	finally
    //   1913	1919	14877	finally
    //   1716	1732	14936	java/lang/Throwable
    //   1913	1919	14936	java/lang/Throwable
    //   1690	1709	14951	finally
    //   1690	1709	14961	java/lang/Throwable
    //   1152	1158	14976	finally
    //   1483	1489	14976	finally
    //   1518	1524	14976	finally
    //   1564	1593	14976	finally
    //   1593	1599	14976	finally
    //   1629	1673	14976	finally
    //   1152	1158	14991	java/lang/Throwable
    //   1483	1489	14991	java/lang/Throwable
    //   1518	1524	14991	java/lang/Throwable
    //   1564	1593	14991	java/lang/Throwable
    //   1593	1599	14991	java/lang/Throwable
    //   1629	1673	14991	java/lang/Throwable
    //   494	501	15006	java/lang/Throwable
    //   245	269	15011	finally
    //   423	462	15011	finally
    //   488	494	15011	finally
    //   494	501	15011	finally
    //   245	269	15026	java/lang/Throwable
    //   423	462	15026	java/lang/Throwable
    //   488	494	15026	java/lang/Throwable
    //   230	245	15041	finally
    //   230	245	15131	java/lang/Throwable
    //   15202	15205	15205	finally
    //   15202	15205	15214	java/lang/Throwable
    //   15271	15287	15305	finally
    //   15293	15302	15305	finally
    //   15265	15271	15310	finally
    //   17803	17816	17849	java/lang/Exception
    //   17819	17846	17849	java/lang/Exception
    //   17774	17803	17854	java/lang/Exception
    //   17899	17929	17962	java/lang/Exception
    //   17932	17959	17962	java/lang/Exception
    //   15245	15260	18463	finally
    //   15236	15245	18476	finally
    //   20945	20958	20991	java/lang/Exception
    //   20961	20988	20991	java/lang/Exception
    //   20916	20945	20996	java/lang/Exception
    //   21041	21071	21104	java/lang/Exception
    //   21074	21101	21104	java/lang/Exception
    //   88	94	21577	java/lang/Exception
    //   2343	2358	21582	java/lang/Exception
    //   2365	2380	21587	java/lang/Exception
    //   5412	5427	21592	java/lang/Exception
    //   5434	5449	21597	java/lang/Exception
    //   8565	8580	21602	java/lang/Exception
    //   8587	8602	21607	java/lang/Exception
    //   11706	11721	21612	java/lang/Exception
    //   11728	11743	21617	java/lang/Exception
    //   15497	15512	21622	java/lang/Exception
    //   15519	15534	21627	java/lang/Exception
    //   18651	18666	21632	java/lang/Exception
    //   18674	18689	21637	java/lang/Exception
    //   1997	2005	21676	finally
    //   2015	2038	21676	finally
    //   2046	2052	21676	finally
    //   1997	2005	21751	java/lang/Throwable
    //   2015	2038	21751	java/lang/Throwable
    //   2046	2052	21751	java/lang/Throwable
  }
  
  protected void initTask()
  {
    super.initTask();
    this.mDomainWithPort = Utils.getDominWithPort(getUrl());
    this.mOrigPort = Utils.getPort(getUrl());
    this.mRefer = HttpUtil.prepareRefer(getUrl());
    if (!DownloadGlobalStrategy.getInstance(this.mContext).supportHttps())
    {
      this.mIsHttp2 = false;
      this.mOriginalIsHttp2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.FastDownloadTask
 * JD-Core Version:    0.7.0.1
 */