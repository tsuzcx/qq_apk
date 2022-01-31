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
import com.tencent.component.network.utils.http.base.QZoneHttp2Client;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.net.Proxy;
import java.util.List;

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
  
  public FastDownloadTask(Context paramContext, QZoneHttp2Client paramQZoneHttp2Client, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramQZoneHttp2Client, paramQZoneHttpClient, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  private boolean setStrategy(int paramInt)
  {
    int j = 80;
    String str2 = getDomain();
    if (this.pDownloadStrategyLib == null) {
      this.pDownloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(getUrl(), getDomain(), this.mIsHttp2);
    }
    this.pOldStrategyInfo = this.pCurrStrategyInfo;
    if (this.pDownloadStrategyLib.getStrategyList() != null) {}
    for (int i = this.pDownloadStrategyLib.getStrategyList().size();; i = 0)
    {
      if (i == 0) {}
      do
      {
        return false;
        for (this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(this.attemptStrategyCount % i); (this.mIsHttp2) && (this.pCurrStrategyInfo != null) && (this.pOldStrategyInfo != null) && (this.pCurrStrategyInfo.id == this.pOldStrategyInfo.id); this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(this.attemptStrategyCount % i)) {
          this.attemptStrategyCount += 1;
        }
        this.attemptStrategyCount += 1;
        if ((this.mIsHttp2) && (this.attemptStrategyCount > i))
        {
          this.mIsHttp2 = false;
          this.pDownloadStrategyLib.setPort(80);
        }
        i = j;
        if (this.mIsHttp2) {
          i = 443;
        }
        this.mStandardPort = i;
        if (QDLog.isInfoEnable()) {
          QDLog.i("downloader_strategy", "downloader strategy: " + this.pCurrStrategyInfo.toString() + " currAttempCount:" + paramInt + " attemptStrategyCount:" + this.attemptStrategyCount + " ,best:" + this.pDownloadStrategyLib.getBestId() + " url:" + getUrl() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
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
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.pCurrStrategyInfo.id) {
          break label720;
        }
        i = paramInt;
        if (this.pOldStrategyInfo == null) {
          break;
        }
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.pOldStrategyInfo.id) {
          break;
        }
        if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str2))) {
          break label644;
        }
        i = this.pPortConfigStrategy.changePort(str2, paramInt);
        if ((i != paramInt) && (Utils.isPortValid(i))) {
          break;
        }
      } while (!QDLog.isInfoEnable());
      QDLog.i("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
      return false;
      String str1 = this.pDownloadStrategyLib.getBackupIP();
      Object localObject = str1;
      if (this.pBackupIPConfigStrategy != null)
      {
        localObject = str1;
        if (!this.pBackupIPConfigStrategy.isIPValid(str2, str1))
        {
          this.pDownloadStrategyLib.setBackupIP(null);
          localObject = this.pBackupIPConfigStrategy.resolveIP(str2);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label682;
          }
          this.pDownloadStrategyLib.setBackupIP((String)localObject);
        }
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
      for (;;)
      {
        return true;
        label644:
        if (!QDLog.isInfoEnable()) {
          break;
        }
        QDLog.i("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return false;
        label682:
        if (!QDLog.isInfoEnable()) {
          break;
        }
        QDLog.i("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label720:
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pCurrStrategyInfo.id)
        {
          i = paramInt;
          if (this.pOldStrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pOldStrategyInfo.id)
            {
              if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str2))) {
                break label973;
              }
              i = this.pPortConfigStrategy.changePort(str2, paramInt);
              if ((i == paramInt) || (!Utils.isPortValid(i)))
              {
                if (!QDLog.isInfoEnable()) {
                  break;
                }
                QDLog.i("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
          str1 = DnsService.getInstance().getDomainIP(str2);
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = DnsService.getInstance().getDomainIP(str2);
          }
          if ((localObject == null) || (((String)localObject).equals(this.pDownloadStrategyLib.getBackupIP())) || (((String)localObject).equals(this.pDownloadStrategyLib.getDirectIP())))
          {
            this.pDownloadStrategyLib.setDnsIP(null);
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.pDownloadStrategyLib.setDnsIP((String)localObject);
          this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
          this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
          continue;
        }
        label973:
        if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.pCurrStrategyInfo.id)
        {
          i = paramInt;
          if (this.pOldStrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.pOldStrategyInfo.id)
            {
              if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str2))) {
                break label1342;
              }
              i = this.pPortConfigStrategy.changePort(str2, paramInt);
              if ((i == paramInt) || (!Utils.isPortValid(i)))
              {
                if (!QDLog.isInfoEnable()) {
                  break;
                }
                QDLog.i("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
        }
        label1342:
        do
        {
          str1 = this.pDownloadStrategyLib.getDirectIP();
          localObject = str1;
          if (this.pDirectIPConfigStrategy != null)
          {
            localObject = str1;
            if (!this.pDirectIPConfigStrategy.isIPValid(str2, str1))
            {
              this.pDownloadStrategyLib.setDirectIP(null);
              localObject = this.pDirectIPConfigStrategy.resolveIP(str2);
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label1573;
              }
              this.pDownloadStrategyLib.setDirectIP((String)localObject);
            }
          }
          if ((localObject != null) && (!((String)localObject).equals(this.pDownloadStrategyLib.getBackupIP())) && (!((String)localObject).equals(this.pDownloadStrategyLib.getDnsIP()))) {
            break label1611;
          }
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
          return false;
          if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.pCurrStrategyInfo.id) {
            break label1427;
          }
          i = paramInt;
        } while (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != this.pCurrStrategyInfo.id);
        label1427:
        localObject = this.mContext;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.pCurrStrategyInfo.id) {}
        for (boolean bool = true;; bool = false)
        {
          localObject = NetworkUtils.getProxy((Context)localObject, bool);
          if (localObject != null) {
            break label1510;
          }
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        label1510:
        if (((Proxy)localObject).equals(this.triedNetworkProxy))
        {
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: proxy 重复. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.triedNetworkProxy = ((Proxy)localObject);
        paramInt = this.mStandardPort;
        return true;
        label1573:
        if (!QDLog.isInfoEnable()) {
          break;
        }
        QDLog.i("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label1611:
        this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
        this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
      }
    }
  }
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 343	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_2
    //   14: aastore
    //   15: invokestatic 349	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   18: istore 9
    //   20: invokestatic 354	com/tencent/component/network/utils/SDCardUtil:isSdCardHasEnoughCapability	()Z
    //   23: istore 11
    //   25: lconst_0
    //   26: lstore 12
    //   28: iconst_0
    //   29: istore_3
    //   30: aload_1
    //   31: invokeinterface 359 1 0
    //   36: ifeq +11 -> 47
    //   39: aload_0
    //   40: aload_1
    //   41: aload_2
    //   42: aconst_null
    //   43: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   46: return
    //   47: aload_0
    //   48: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   51: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   54: ifne +29 -> 83
    //   57: iload_3
    //   58: aload_0
    //   59: getfield 370	com/tencent/component/network/downloader/impl/FastDownloadTask:mAttemptTotalCount	I
    //   62: iconst_1
    //   63: isub
    //   64: if_icmpne +13 -> 77
    //   67: aload_2
    //   68: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   71: bipush 6
    //   73: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   76: return
    //   77: ldc2_w 382
    //   80: invokestatic 387	java/lang/Thread:sleep	(J)V
    //   83: iload 11
    //   85: ifne +25 -> 110
    //   88: aload_2
    //   89: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   92: iconst_2
    //   93: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   96: return
    //   97: astore 22
    //   99: ldc 219
    //   101: ldc_w 389
    //   104: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -24 -> 83
    //   110: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   113: lstore 18
    //   115: new 394	com/tencent/component/network/downloader/DownloadReport
    //   118: dup
    //   119: invokespecial 395	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   122: astore 29
    //   124: aload 29
    //   126: iload 9
    //   128: putfield 396	com/tencent/component/network/downloader/DownloadReport:id	I
    //   131: aload 29
    //   133: aload_0
    //   134: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   137: putfield 399	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   140: aload 29
    //   142: aload_0
    //   143: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   146: putfield 402	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   149: aload 29
    //   151: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   154: putfield 410	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   162: aconst_null
    //   163: astore 26
    //   165: aconst_null
    //   166: astore 24
    //   168: aload_0
    //   169: aconst_null
    //   170: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   173: aconst_null
    //   174: astore 25
    //   176: iconst_0
    //   177: istore 7
    //   179: iconst_0
    //   180: istore 8
    //   182: aconst_null
    //   183: astore 22
    //   185: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   188: lstore 20
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   195: invokespecial 423	com/tencent/component/network/downloader/impl/FastDownloadTask:setStrategy	(I)Z
    //   198: istore 10
    //   200: iload 10
    //   202: ifne +15 -> 217
    //   205: aload_0
    //   206: invokevirtual 426	com/tencent/component/network/downloader/impl/FastDownloadTask:canAttempt	()Z
    //   209: ifeq -163 -> 46
    //   212: goto -182 -> 30
    //   215: astore 22
    //   217: aload 22
    //   219: ifnull +1692 -> 1911
    //   222: lload 12
    //   224: lstore 14
    //   226: lload 12
    //   228: lstore 16
    //   230: aload 22
    //   232: athrow
    //   233: astore 25
    //   235: aconst_null
    //   236: astore 22
    //   238: aconst_null
    //   239: astore 24
    //   241: aconst_null
    //   242: astore 23
    //   244: iload 8
    //   246: istore 4
    //   248: lload 14
    //   250: lstore 12
    //   252: ldc 219
    //   254: ldc_w 428
    //   257: aload 25
    //   259: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: iload_3
    //   263: istore 5
    //   265: aload_2
    //   266: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   269: aload 25
    //   271: invokevirtual 435	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   274: iload_3
    //   275: istore 6
    //   277: iload_3
    //   278: istore 5
    //   280: aload_0
    //   281: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   284: ifnull +48 -> 332
    //   287: iload_3
    //   288: istore 6
    //   290: iload_3
    //   291: istore 5
    //   293: aload_0
    //   294: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   297: ldc_w 439
    //   300: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   303: ifeq +29 -> 332
    //   306: iload_3
    //   307: istore 5
    //   309: aload_0
    //   310: iconst_1
    //   311: putfield 445	com/tencent/component/network/downloader/impl/FastDownloadTask:disableHttps	Z
    //   314: iload_3
    //   315: iconst_1
    //   316: isub
    //   317: istore 6
    //   319: iload 6
    //   321: istore 5
    //   323: ldc_w 447
    //   326: ldc_w 449
    //   329: invokestatic 451	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_2
    //   333: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   336: lload 18
    //   338: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   341: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   344: aload_2
    //   345: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   348: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   351: aload_0
    //   352: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   355: lsub
    //   356: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   359: aload_2
    //   360: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   363: aload_0
    //   364: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   367: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   370: aload_0
    //   371: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   374: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   377: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   380: astore 28
    //   382: aload_0
    //   383: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   386: ifnull +14645 -> 15031
    //   389: aload_0
    //   390: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   393: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   396: ifnull +14635 -> 15031
    //   399: aload_0
    //   400: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   403: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   406: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   409: astore 26
    //   411: aload_0
    //   412: aload_0
    //   413: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   416: aload 23
    //   418: aload 22
    //   420: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   423: astore 30
    //   425: aload 24
    //   427: ifnull +16348 -> 16775
    //   430: aload 24
    //   432: ldc_w 492
    //   435: invokeinterface 498 2 0
    //   440: checkcast 282	java/lang/String
    //   443: astore 24
    //   445: aload_2
    //   446: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   449: aload 24
    //   451: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   454: aload_0
    //   455: lconst_0
    //   456: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   459: aload_0
    //   460: iconst_0
    //   461: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   464: aload_0
    //   465: lconst_0
    //   466: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   469: aload_0
    //   470: iconst_0
    //   471: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   474: aload_2
    //   475: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   478: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   481: ifeq +12 -> 493
    //   484: aload_1
    //   485: invokeinterface 359 1 0
    //   490: ifeq +31 -> 521
    //   493: aload_0
    //   494: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   497: ifnull +24 -> 521
    //   500: aload_0
    //   501: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   504: aload_0
    //   505: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   508: aload_2
    //   509: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   512: aload 23
    //   514: aload 22
    //   516: invokeinterface 523 5 0
    //   521: aload_1
    //   522: invokeinterface 359 1 0
    //   527: ifne +1350 -> 1877
    //   530: aload_0
    //   531: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   534: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   537: istore 10
    //   539: aload_2
    //   540: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   543: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   546: ifne +14535 -> 15081
    //   549: new 125	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 525
    //   559: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_0
    //   563: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   566: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: ldc_w 527
    //   572: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_0
    //   576: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   579: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   582: ldc_w 532
    //   585: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: astore 31
    //   590: aload_0
    //   591: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   594: ifeq +14453 -> 15047
    //   597: aload 22
    //   599: ifnull +14448 -> 15047
    //   602: aload 22
    //   604: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   607: ifnull +14440 -> 15047
    //   610: aload 22
    //   612: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   615: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   618: astore 27
    //   620: aload 31
    //   622: aload 27
    //   624: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: ldc_w 543
    //   630: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload 28
    //   635: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   638: ldc_w 548
    //   641: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload 26
    //   646: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc_w 550
    //   652: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aconst_null
    //   656: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: ldc_w 552
    //   662: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   668: invokevirtual 174	java/lang/Thread:getId	()J
    //   671: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   674: ldc_w 554
    //   677: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   683: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc_w 556
    //   689: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_0
    //   693: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   696: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   699: ldc_w 558
    //   702: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload_0
    //   706: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   709: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   712: ldc_w 560
    //   715: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: astore 31
    //   720: aload_0
    //   721: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   724: ifeq +14331 -> 15055
    //   727: aload_0
    //   728: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   731: aload_0
    //   732: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   735: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   738: astore 27
    //   740: aload 31
    //   742: aload 27
    //   744: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   747: ldc_w 562
    //   750: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: iload 10
    //   755: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   758: ldc_w 564
    //   761: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   767: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   770: ldc_w 571
    //   773: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: aload_2
    //   777: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   780: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   783: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: ldc_w 576
    //   789: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_2
    //   793: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   796: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   799: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: ldc_w 581
    //   805: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   811: aload_0
    //   812: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   815: lsub
    //   816: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   819: ldc_w 583
    //   822: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload_2
    //   826: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   829: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   832: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   835: ldc_w 588
    //   838: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload_2
    //   842: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   845: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   848: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   851: ldc_w 592
    //   854: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_2
    //   858: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   861: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   864: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   867: ldc_w 597
    //   870: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload_0
    //   874: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   877: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: ldc_w 599
    //   883: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: aload_0
    //   887: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   890: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   893: ldc_w 604
    //   896: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload_2
    //   900: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   903: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   906: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   909: ldc_w 609
    //   912: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: iload 4
    //   917: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc_w 611
    //   923: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: aload 30
    //   928: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: ldc_w 613
    //   934: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: aload 24
    //   939: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc_w 615
    //   945: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: astore 31
    //   950: aload_0
    //   951: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   954: ifnull +14107 -> 15061
    //   957: aload_0
    //   958: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   961: iconst_0
    //   962: bipush 30
    //   964: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   967: astore 27
    //   969: aload 31
    //   971: aload 27
    //   973: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: ldc_w 621
    //   979: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: astore 27
    //   984: aload_0
    //   985: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   988: ifnull +14082 -> 15070
    //   991: aload_0
    //   992: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   995: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   998: istore_3
    //   999: aload 27
    //   1001: iload_3
    //   1002: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1005: ldc_w 623
    //   1008: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: aload_2
    //   1012: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1015: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1018: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: ldc_w 628
    //   1024: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: lload 12
    //   1029: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1032: ldc_w 630
    //   1035: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_0
    //   1039: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   1042: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1045: ldc_w 599
    //   1048: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload_0
    //   1052: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   1055: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1058: ldc_w 632
    //   1061: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload_0
    //   1065: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   1068: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1071: ldc_w 599
    //   1074: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: aload_0
    //   1078: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   1081: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1084: ldc_w 634
    //   1087: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: aload_0
    //   1091: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1094: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1097: ldc_w 636
    //   1100: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload_0
    //   1104: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   1107: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1110: ldc_w 641
    //   1113: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: aload_0
    //   1117: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   1120: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1123: ldc_w 646
    //   1126: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: astore 31
    //   1131: aload_0
    //   1132: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1135: ifnull +13940 -> 15075
    //   1138: aload_0
    //   1139: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1142: invokeinterface 656 1 0
    //   1147: astore 27
    //   1149: aload 29
    //   1151: aload 31
    //   1153: aload 27
    //   1155: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1164: ldc_w 447
    //   1167: aload 29
    //   1169: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1172: aload 25
    //   1174: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1177: aload_0
    //   1178: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1181: ifnull +24 -> 1205
    //   1184: aload_0
    //   1185: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1188: ldc_w 439
    //   1191: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1194: ifeq +11 -> 1205
    //   1197: aload_0
    //   1198: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1201: iconst_0
    //   1202: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   1205: iload 10
    //   1207: ifne +8 -> 1215
    //   1210: aload_0
    //   1211: iconst_0
    //   1212: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   1215: aload_2
    //   1216: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1219: astore 27
    //   1221: new 125	java/lang/StringBuilder
    //   1224: dup
    //   1225: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1228: aload_0
    //   1229: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1232: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: ldc_w 670
    //   1238: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: aload 26
    //   1243: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: ldc_w 672
    //   1249: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: aload_2
    //   1253: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1256: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1259: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: ldc_w 674
    //   1265: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: astore 26
    //   1270: aload_0
    //   1271: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1274: ifnull +14444 -> 15718
    //   1277: aload_0
    //   1278: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1281: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1284: istore_3
    //   1285: aload 26
    //   1287: iload_3
    //   1288: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1291: ldc_w 609
    //   1294: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: iload 4
    //   1299: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1302: ldc_w 571
    //   1305: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: aload_2
    //   1309: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1312: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1315: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: ldc_w 583
    //   1321: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: aload_2
    //   1325: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1328: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1331: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1334: ldc_w 588
    //   1337: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: aload_2
    //   1341: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1344: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1347: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1350: ldc_w 576
    //   1353: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: aload_2
    //   1357: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1360: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1363: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1366: ldc_w 581
    //   1369: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1375: aload_0
    //   1376: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1379: lsub
    //   1380: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1383: astore 26
    //   1385: aload 24
    //   1387: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1390: ifne +14333 -> 15723
    //   1393: new 125	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1400: ldc_w 613
    //   1403: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload 24
    //   1408: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1414: astore 24
    //   1416: aload 27
    //   1418: aload 26
    //   1420: aload 24
    //   1422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: ldc_w 611
    //   1428: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: aload 30
    //   1433: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1439: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   1442: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1445: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1448: aload_0
    //   1449: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1452: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1455: if_icmpne +37 -> 1492
    //   1458: aload_0
    //   1459: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1462: ifnull +30 -> 1492
    //   1465: aload_0
    //   1466: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1469: aload_0
    //   1470: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1473: aload_0
    //   1474: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1477: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1480: aload_2
    //   1481: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1484: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1487: invokeinterface 684 4 0
    //   1492: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1495: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1498: aload_0
    //   1499: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1502: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1505: if_icmpne +37 -> 1542
    //   1508: aload_0
    //   1509: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1512: ifnull +30 -> 1542
    //   1515: aload_0
    //   1516: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1519: aload_0
    //   1520: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1523: aload_0
    //   1524: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1527: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1530: aload_2
    //   1531: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1534: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1537: invokeinterface 684 4 0
    //   1542: iload 10
    //   1544: ifeq +64 -> 1608
    //   1547: aload_0
    //   1548: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   1551: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1554: astore 24
    //   1556: aload_0
    //   1557: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1560: astore 26
    //   1562: aload_0
    //   1563: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1566: ifeq +14195 -> 15761
    //   1569: aload_0
    //   1570: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1573: ifnull +14188 -> 15761
    //   1576: aload_0
    //   1577: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1580: ldc_w 686
    //   1583: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1586: ifeq +14175 -> 15761
    //   1589: iconst_1
    //   1590: istore 10
    //   1592: aload 24
    //   1594: aload 26
    //   1596: iload 10
    //   1598: aload_2
    //   1599: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1602: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1605: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   1608: aload 29
    //   1610: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   1613: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1616: aload 29
    //   1618: aload_0
    //   1619: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   1622: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1625: aload 29
    //   1627: aload 23
    //   1629: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1632: aload 29
    //   1634: aload 22
    //   1636: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   1639: aload 29
    //   1641: iload 4
    //   1643: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1646: aload 29
    //   1648: aload 25
    //   1650: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1653: aload 28
    //   1655: ifnonnull +14112 -> 15767
    //   1658: aconst_null
    //   1659: astore 22
    //   1661: aload 29
    //   1663: aload 22
    //   1665: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1668: aload 29
    //   1670: aconst_null
    //   1671: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1674: aload 29
    //   1676: aload_2
    //   1677: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1680: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1683: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1686: aload 29
    //   1688: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1691: aload_0
    //   1692: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1695: lsub
    //   1696: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1699: aload 29
    //   1701: aload_2
    //   1702: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1705: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1708: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1711: aload 29
    //   1713: aload 29
    //   1715: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1718: aload_2
    //   1719: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1722: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1725: lsub
    //   1726: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1729: aload 29
    //   1731: lload 12
    //   1733: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1736: aload 29
    //   1738: aload_0
    //   1739: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   1742: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1745: aload 29
    //   1747: aload_0
    //   1748: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1751: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1754: aload 29
    //   1756: aload_0
    //   1757: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   1760: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1763: aload 29
    //   1765: lconst_0
    //   1766: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1769: aload 29
    //   1771: aload_0
    //   1772: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   1775: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1778: aload 29
    //   1780: aload_2
    //   1781: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1784: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1787: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1790: aload 29
    //   1792: aload_0
    //   1793: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1796: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1799: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1802: aload 29
    //   1804: aload_0
    //   1805: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1808: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1811: aload_0
    //   1812: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1815: ifnull +13962 -> 15777
    //   1818: aload_0
    //   1819: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1822: ldc_w 686
    //   1825: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1828: ifeq +13949 -> 15777
    //   1831: iconst_1
    //   1832: istore 10
    //   1834: aload 29
    //   1836: iload 10
    //   1838: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1841: aload 29
    //   1843: aload_2
    //   1844: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1847: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1850: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1853: aload_2
    //   1854: aload 29
    //   1856: invokevirtual 768	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1859: aload_2
    //   1860: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1863: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1866: ifeq +11 -> 1877
    //   1869: aload_0
    //   1870: aload_1
    //   1871: aload_2
    //   1872: aload 29
    //   1874: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1877: aload_0
    //   1878: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1881: ifeq +13902 -> 15783
    //   1884: aload_0
    //   1885: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   1888: ifnull +10 -> 1898
    //   1891: aload_0
    //   1892: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   1895: invokevirtual 777	com/squareup/okhttp/Call:cancel	()V
    //   1898: aload_0
    //   1899: aconst_null
    //   1900: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   1903: iload 6
    //   1905: iconst_1
    //   1906: iadd
    //   1907: istore_3
    //   1908: goto -1703 -> 205
    //   1911: lload 12
    //   1913: lstore 14
    //   1915: lload 12
    //   1917: lstore 16
    //   1919: getstatic 781	com/tencent/component/network/downloader/impl/FastDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   1922: invokevirtual 787	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1925: checkcast 789	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   1928: astore 30
    //   1930: lload 12
    //   1932: lstore 14
    //   1934: lload 12
    //   1936: lstore 16
    //   1938: aload 30
    //   1940: aload_0
    //   1941: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   1944: putfield 790	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   1947: lload 12
    //   1949: lstore 14
    //   1951: lload 12
    //   1953: lstore 16
    //   1955: aload 30
    //   1957: aload_0
    //   1958: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   1961: putfield 793	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   1964: lload 12
    //   1966: lstore 14
    //   1968: lload 12
    //   1970: lstore 16
    //   1972: aload_0
    //   1973: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1976: ifnull +2632 -> 4608
    //   1979: lload 12
    //   1981: lstore 14
    //   1983: lload 12
    //   1985: lstore 16
    //   1987: aload_0
    //   1988: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1991: invokeinterface 656 1 0
    //   1996: astore 22
    //   1998: lload 12
    //   2000: lstore 14
    //   2002: lload 12
    //   2004: lstore 16
    //   2006: aload 30
    //   2008: aload 22
    //   2010: putfield 796	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2013: lload 12
    //   2015: lstore 14
    //   2017: lload 12
    //   2019: lstore 16
    //   2021: aload 29
    //   2023: iload_3
    //   2024: putfield 799	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   2027: lload 12
    //   2029: lstore 14
    //   2031: lload 12
    //   2033: lstore 16
    //   2035: aload 29
    //   2037: aload_0
    //   2038: getfield 801	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2041: putfield 804	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   2044: lload 12
    //   2046: lstore 14
    //   2048: lload 12
    //   2050: lstore 16
    //   2052: aload_0
    //   2053: aload_0
    //   2054: aload_0
    //   2055: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2058: invokevirtual 807	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   2061: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2064: lload 12
    //   2066: lstore 14
    //   2068: lload 12
    //   2070: lstore 16
    //   2072: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2075: iconst_2
    //   2076: if_icmpeq +14757 -> 16833
    //   2079: lload 12
    //   2081: lstore 14
    //   2083: lload 12
    //   2085: lstore 16
    //   2087: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2090: iconst_3
    //   2091: if_icmpne +2523 -> 4614
    //   2094: goto +14739 -> 16833
    //   2097: lload 12
    //   2099: lstore 14
    //   2101: lload 12
    //   2103: lstore 16
    //   2105: aload_0
    //   2106: invokevirtual 810	com/tencent/component/network/downloader/impl/FastDownloadTask:enableIpv6Debug	()Z
    //   2109: istore 10
    //   2111: lload 12
    //   2113: lstore 14
    //   2115: lload 12
    //   2117: lstore 16
    //   2119: aload 30
    //   2121: getfield 796	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2124: ifnonnull +4524 -> 6648
    //   2127: lload 12
    //   2129: lstore 14
    //   2131: lload 12
    //   2133: lstore 16
    //   2135: aload_0
    //   2136: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2139: ldc_w 686
    //   2142: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2145: ifeq +18 -> 2163
    //   2148: lload 12
    //   2150: lstore 14
    //   2152: lload 12
    //   2154: lstore 16
    //   2156: aload_0
    //   2157: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2160: ifeq +4488 -> 6648
    //   2163: lload 12
    //   2165: lstore 14
    //   2167: lload 12
    //   2169: lstore 16
    //   2171: aload_0
    //   2172: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2175: ifnull +4473 -> 6648
    //   2178: lload 12
    //   2180: lstore 14
    //   2182: lload 12
    //   2184: lstore 16
    //   2186: aload_0
    //   2187: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2190: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2193: ifnull +4455 -> 6648
    //   2196: lload 12
    //   2198: lstore 14
    //   2200: lload 12
    //   2202: lstore 16
    //   2204: aload_0
    //   2205: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2208: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2211: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2214: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2217: ifne +4431 -> 6648
    //   2220: lload 12
    //   2222: lstore 14
    //   2224: lload 12
    //   2226: lstore 16
    //   2228: aload_0
    //   2229: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2232: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2235: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2238: astore 28
    //   2240: lload 12
    //   2242: lstore 14
    //   2244: lload 12
    //   2246: lstore 16
    //   2248: aload_0
    //   2249: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2252: astore 27
    //   2254: lload 12
    //   2256: lstore 14
    //   2258: lload 12
    //   2260: lstore 16
    //   2262: aload 28
    //   2264: bipush 58
    //   2266: invokestatic 814	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   2269: istore 4
    //   2271: iload 5
    //   2273: ifne +14566 -> 16839
    //   2276: aload 27
    //   2278: astore 22
    //   2280: iload 4
    //   2282: iconst_2
    //   2283: if_icmpge +150 -> 2433
    //   2286: lload 12
    //   2288: lstore 14
    //   2290: lload 12
    //   2292: lstore 16
    //   2294: aload_0
    //   2295: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   2298: istore 4
    //   2300: iload 4
    //   2302: ifle +2318 -> 4620
    //   2305: lload 12
    //   2307: lstore 14
    //   2309: lload 12
    //   2311: lstore 16
    //   2313: aload_0
    //   2314: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2317: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2320: iload 4
    //   2322: putfield 817	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2325: lload 12
    //   2327: lstore 14
    //   2329: iload 4
    //   2331: istore 6
    //   2333: lload 12
    //   2335: lstore 16
    //   2337: iload 4
    //   2339: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   2342: ifne +7 -> 2349
    //   2345: bipush 80
    //   2347: istore 6
    //   2349: lload 12
    //   2351: lstore 14
    //   2353: lload 12
    //   2355: lstore 16
    //   2357: new 125	java/lang/StringBuilder
    //   2360: dup
    //   2361: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2364: aload 28
    //   2366: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2369: ldc_w 819
    //   2372: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: iload 6
    //   2377: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2380: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2383: astore 23
    //   2385: lload 12
    //   2387: lstore 14
    //   2389: aload 23
    //   2391: astore 22
    //   2393: lload 12
    //   2395: lstore 16
    //   2397: aload_0
    //   2398: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2401: ifnull +32 -> 2433
    //   2404: lload 12
    //   2406: lstore 14
    //   2408: lload 12
    //   2410: lstore 16
    //   2412: aload_0
    //   2413: aload_0
    //   2414: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2417: aload_0
    //   2418: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2421: aload 23
    //   2423: invokevirtual 825	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2426: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2429: aload 23
    //   2431: astore 22
    //   2433: lload 12
    //   2435: lstore 14
    //   2437: lload 12
    //   2439: lstore 16
    //   2441: aload 29
    //   2443: aload_0
    //   2444: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2447: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2450: putfield 828	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2453: lload 12
    //   2455: lstore 14
    //   2457: lload 12
    //   2459: lstore 16
    //   2461: invokestatic 831	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   2464: ifeq +77 -> 2541
    //   2467: lload 12
    //   2469: lstore 14
    //   2471: lload 12
    //   2473: lstore 16
    //   2475: ldc 219
    //   2477: new 125	java/lang/StringBuilder
    //   2480: dup
    //   2481: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2484: ldc_w 833
    //   2487: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2490: aload 29
    //   2492: getfield 828	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2495: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: ldc_w 835
    //   2501: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2504: aload 22
    //   2506: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: ldc 151
    //   2511: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2514: aload_0
    //   2515: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2518: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: ldc 225
    //   2523: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2529: invokevirtual 174	java/lang/Thread:getId	()J
    //   2532: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2535: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2538: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2541: lload 12
    //   2543: lstore 14
    //   2545: lload 12
    //   2547: lstore 16
    //   2549: aload_0
    //   2550: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2553: ifnull +43 -> 2596
    //   2556: lload 12
    //   2558: lstore 14
    //   2560: lload 12
    //   2562: lstore 16
    //   2564: aload 29
    //   2566: aload_0
    //   2567: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2570: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2573: putfield 828	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2576: lload 12
    //   2578: lstore 14
    //   2580: lload 12
    //   2582: lstore 16
    //   2584: aload 29
    //   2586: aload_0
    //   2587: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2590: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2593: putfield 838	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2596: lload 12
    //   2598: lstore 14
    //   2600: lload 12
    //   2602: lstore 16
    //   2604: aload_0
    //   2605: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2608: ifeq +4366 -> 6974
    //   2611: iload 5
    //   2613: ifne +4361 -> 6974
    //   2616: lload 12
    //   2618: lstore 14
    //   2620: lload 12
    //   2622: lstore 16
    //   2624: aload_0
    //   2625: aload_0
    //   2626: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2629: aload_0
    //   2630: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2633: aload_0
    //   2634: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2637: aload_0
    //   2638: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2641: aload_0
    //   2642: getfield 801	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2645: invokestatic 844	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   2648: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2651: lload 12
    //   2653: lstore 14
    //   2655: lload 12
    //   2657: lstore 16
    //   2659: aload_0
    //   2660: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2663: ifnull +36 -> 2699
    //   2666: lload 12
    //   2668: lstore 14
    //   2670: lload 12
    //   2672: lstore 16
    //   2674: aload_0
    //   2675: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2678: aload_0
    //   2679: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2682: aload_0
    //   2683: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2686: aload_0
    //   2687: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2690: aload_0
    //   2691: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2694: invokeinterface 848 5 0
    //   2699: lload 12
    //   2701: lstore 14
    //   2703: lload 12
    //   2705: lstore 16
    //   2707: aload_0
    //   2708: aload_0
    //   2709: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2712: aload_0
    //   2713: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2716: aload_0
    //   2717: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2720: aload_0
    //   2721: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2724: invokevirtual 851	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;)V
    //   2727: lload 12
    //   2729: lstore 14
    //   2731: lload 12
    //   2733: lstore 16
    //   2735: aload_0
    //   2736: aload_0
    //   2737: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2740: aload_0
    //   2741: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2744: aload_0
    //   2745: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2748: aload_0
    //   2749: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2752: aload 30
    //   2754: invokevirtual 855	com/tencent/component/network/downloader/impl/FastDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2757: lload 12
    //   2759: lstore 14
    //   2761: lload 12
    //   2763: lstore 16
    //   2765: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   2768: lload 20
    //   2770: lsub
    //   2771: lstore 12
    //   2773: lload 12
    //   2775: lstore 14
    //   2777: lload 12
    //   2779: lstore 16
    //   2781: aload_0
    //   2782: lconst_0
    //   2783: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2786: lload 12
    //   2788: lstore 14
    //   2790: lload 12
    //   2792: lstore 16
    //   2794: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2797: lstore 20
    //   2799: lload 12
    //   2801: lstore 14
    //   2803: lload 12
    //   2805: lstore 16
    //   2807: aload_0
    //   2808: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2811: ifnull +4203 -> 7014
    //   2814: lload 12
    //   2816: lstore 14
    //   2818: lload 12
    //   2820: lstore 16
    //   2822: aload_0
    //   2823: getfield 859	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2826: ifnonnull +18 -> 2844
    //   2829: lload 12
    //   2831: lstore 14
    //   2833: lload 12
    //   2835: lstore 16
    //   2837: aload_0
    //   2838: invokestatic 863	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2841: putfield 859	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2844: lload 12
    //   2846: lstore 14
    //   2848: lload 12
    //   2850: lstore 16
    //   2852: invokestatic 867	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   2855: astore 22
    //   2857: aload_0
    //   2858: getfield 859	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2861: aload_0
    //   2862: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2865: aload 22
    //   2867: invokevirtual 872	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   2870: astore 23
    //   2872: aconst_null
    //   2873: astore 25
    //   2875: aload 22
    //   2877: astore 24
    //   2879: aload 23
    //   2881: astore 22
    //   2883: aload 25
    //   2885: astore 23
    //   2887: aload_0
    //   2888: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2891: lload 20
    //   2893: lsub
    //   2894: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2897: aload 22
    //   2899: ifnonnull +8 -> 2907
    //   2902: aload 23
    //   2904: ifnull +11330 -> 14234
    //   2907: aload 22
    //   2909: ifnull +4174 -> 7083
    //   2912: aload 22
    //   2914: invokeinterface 878 1 0
    //   2919: ifnull +4164 -> 7083
    //   2922: aload 22
    //   2924: invokeinterface 878 1 0
    //   2929: invokeinterface 883 1 0
    //   2934: istore 4
    //   2936: aload_2
    //   2937: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2940: iload 4
    //   2942: putfield 884	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   2945: sipush 200
    //   2948: iload 4
    //   2950: if_icmpeq +11 -> 2961
    //   2953: sipush 206
    //   2956: iload 4
    //   2958: if_icmpne +9615 -> 12573
    //   2961: iload 4
    //   2963: istore 5
    //   2965: aload_0
    //   2966: aload 22
    //   2968: aload 23
    //   2970: aload_2
    //   2971: aload_1
    //   2972: iload 4
    //   2974: invokevirtual 888	com/tencent/component/network/downloader/impl/FastDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   2977: ifeq +9649 -> 12626
    //   2980: aload_2
    //   2981: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2984: invokevirtual 891	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   2987: aload_2
    //   2988: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2991: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   2994: ifeq +7233 -> 10227
    //   2997: aload_0
    //   2998: aload 22
    //   3000: aload 23
    //   3002: invokevirtual 898	com/tencent/component/network/downloader/impl/FastDownloadTask:getRetcode	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   3005: istore 5
    //   3007: aload_2
    //   3008: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3011: iload 5
    //   3013: putfield 901	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   3016: iload 5
    //   3018: invokestatic 904	com/tencent/component/network/module/base/Config:canRetCodeRetry	(I)Z
    //   3021: istore 10
    //   3023: iload 10
    //   3025: ifeq +4856 -> 7881
    //   3028: aload_2
    //   3029: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3032: lload 18
    //   3034: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3037: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3040: aload_2
    //   3041: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3044: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3047: aload_0
    //   3048: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3051: lsub
    //   3052: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3055: aload_2
    //   3056: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3059: aload_0
    //   3060: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   3063: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3066: aload_0
    //   3067: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3070: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3073: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3076: astore 27
    //   3078: aload_0
    //   3079: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3082: ifnull +4016 -> 7098
    //   3085: aload_0
    //   3086: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3089: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3092: ifnull +4006 -> 7098
    //   3095: aload_0
    //   3096: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3099: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3102: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   3105: astore 25
    //   3107: aload_0
    //   3108: aload_0
    //   3109: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3112: aload 22
    //   3114: aload 23
    //   3116: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   3119: astore 28
    //   3121: aload 24
    //   3123: ifnull +13684 -> 16807
    //   3126: aload 24
    //   3128: ldc_w 492
    //   3131: invokeinterface 498 2 0
    //   3136: checkcast 282	java/lang/String
    //   3139: astore 24
    //   3141: aload_2
    //   3142: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3145: aload 24
    //   3147: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3150: aload_0
    //   3151: lconst_0
    //   3152: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3155: aload_0
    //   3156: iconst_0
    //   3157: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3160: aload_0
    //   3161: lconst_0
    //   3162: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3165: aload_0
    //   3166: iconst_0
    //   3167: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3170: aload_2
    //   3171: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3174: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3177: ifeq +12 -> 3189
    //   3180: aload_1
    //   3181: invokeinterface 359 1 0
    //   3186: ifeq +31 -> 3217
    //   3189: aload_0
    //   3190: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3193: ifnull +24 -> 3217
    //   3196: aload_0
    //   3197: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3200: aload_0
    //   3201: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3204: aload_2
    //   3205: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3208: aload 22
    //   3210: aload 23
    //   3212: invokeinterface 523 5 0
    //   3217: aload_1
    //   3218: invokeinterface 359 1 0
    //   3223: ifne +1352 -> 4575
    //   3226: aload_0
    //   3227: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3230: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3233: istore 10
    //   3235: aload_2
    //   3236: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3239: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3242: ifne +3907 -> 7149
    //   3245: new 125	java/lang/StringBuilder
    //   3248: dup
    //   3249: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   3252: ldc_w 525
    //   3255: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3258: aload_0
    //   3259: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3262: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3265: ldc_w 527
    //   3268: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3271: aload_0
    //   3272: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3275: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3278: ldc_w 532
    //   3281: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3284: astore 30
    //   3286: aload_0
    //   3287: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3290: ifeq +3824 -> 7114
    //   3293: aload 23
    //   3295: ifnull +3819 -> 7114
    //   3298: aload 23
    //   3300: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3303: ifnull +3811 -> 7114
    //   3306: aload 23
    //   3308: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3311: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   3314: astore 26
    //   3316: aload 30
    //   3318: aload 26
    //   3320: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3323: ldc_w 543
    //   3326: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3329: aload 27
    //   3331: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3334: ldc_w 548
    //   3337: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3340: aload 25
    //   3342: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3345: ldc_w 550
    //   3348: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3351: aconst_null
    //   3352: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3355: ldc_w 552
    //   3358: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3361: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3364: invokevirtual 174	java/lang/Thread:getId	()J
    //   3367: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3370: ldc_w 554
    //   3373: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3376: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3379: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3382: ldc_w 556
    //   3385: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3388: aload_0
    //   3389: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3392: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3395: ldc_w 558
    //   3398: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3401: aload_0
    //   3402: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3405: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3408: ldc_w 560
    //   3411: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3414: astore 30
    //   3416: aload_0
    //   3417: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3420: ifeq +3702 -> 7122
    //   3423: aload_0
    //   3424: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3427: aload_0
    //   3428: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3431: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3434: astore 26
    //   3436: aload 30
    //   3438: aload 26
    //   3440: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3443: ldc_w 562
    //   3446: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3449: iload 10
    //   3451: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3454: ldc_w 564
    //   3457: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3460: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3463: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3466: ldc_w 571
    //   3469: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3472: aload_2
    //   3473: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3476: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3479: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3482: ldc_w 576
    //   3485: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3488: aload_2
    //   3489: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3492: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3495: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3498: ldc_w 581
    //   3501: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3504: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3507: aload_0
    //   3508: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3511: lsub
    //   3512: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3515: ldc_w 583
    //   3518: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3521: aload_2
    //   3522: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3525: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3528: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3531: ldc_w 588
    //   3534: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3537: aload_2
    //   3538: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3541: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3544: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3547: ldc_w 592
    //   3550: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3553: aload_2
    //   3554: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3557: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3560: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3563: ldc_w 597
    //   3566: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: aload_0
    //   3570: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   3573: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3576: ldc_w 599
    //   3579: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3582: aload_0
    //   3583: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   3586: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3589: ldc_w 604
    //   3592: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3595: aload_2
    //   3596: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3599: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3602: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3605: ldc_w 609
    //   3608: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3611: iload 4
    //   3613: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3616: ldc_w 611
    //   3619: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3622: aload 28
    //   3624: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3627: ldc_w 613
    //   3630: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3633: aload 24
    //   3635: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3638: ldc_w 615
    //   3641: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3644: astore 30
    //   3646: aload_0
    //   3647: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3650: ifnull +3478 -> 7128
    //   3653: aload_0
    //   3654: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3657: iconst_0
    //   3658: bipush 30
    //   3660: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   3663: astore 26
    //   3665: aload 30
    //   3667: aload 26
    //   3669: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3672: ldc_w 621
    //   3675: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3678: astore 26
    //   3680: aload_0
    //   3681: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3684: ifnull +3453 -> 7137
    //   3687: aload_0
    //   3688: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3691: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3694: istore 5
    //   3696: aload 26
    //   3698: iload 5
    //   3700: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3703: ldc_w 623
    //   3706: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3709: aload_2
    //   3710: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3713: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3716: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3719: ldc_w 628
    //   3722: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3725: lload 12
    //   3727: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3730: ldc_w 630
    //   3733: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3736: aload_0
    //   3737: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3740: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3743: ldc_w 599
    //   3746: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3749: aload_0
    //   3750: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3753: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3756: ldc_w 632
    //   3759: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3762: aload_0
    //   3763: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3766: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3769: ldc_w 599
    //   3772: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3775: aload_0
    //   3776: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3779: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3782: ldc_w 634
    //   3785: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3788: aload_0
    //   3789: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   3792: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3795: ldc_w 636
    //   3798: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3801: aload_0
    //   3802: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   3805: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3808: ldc_w 641
    //   3811: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3814: aload_0
    //   3815: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   3818: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3821: ldc_w 646
    //   3824: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3827: astore 30
    //   3829: aload_0
    //   3830: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3833: ifnull +3310 -> 7143
    //   3836: aload_0
    //   3837: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3840: invokeinterface 656 1 0
    //   3845: astore 26
    //   3847: aload 29
    //   3849: aload 30
    //   3851: aload 26
    //   3853: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3856: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3859: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3862: ldc_w 447
    //   3865: aload 29
    //   3867: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3870: aconst_null
    //   3871: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3874: aload_0
    //   3875: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3878: ifnull +24 -> 3902
    //   3881: aload_0
    //   3882: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3885: ldc_w 439
    //   3888: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3891: ifeq +11 -> 3902
    //   3894: aload_0
    //   3895: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   3898: iconst_0
    //   3899: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   3902: iload 10
    //   3904: ifne +8 -> 3912
    //   3907: aload_0
    //   3908: iconst_0
    //   3909: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   3912: aload_2
    //   3913: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3916: astore 26
    //   3918: new 125	java/lang/StringBuilder
    //   3921: dup
    //   3922: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   3925: aload_0
    //   3926: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3929: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3932: ldc_w 670
    //   3935: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3938: aload 25
    //   3940: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3943: ldc_w 672
    //   3946: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3949: aload_2
    //   3950: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3953: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3959: ldc_w 674
    //   3962: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3965: astore 25
    //   3967: aload_0
    //   3968: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3971: ifnull +3818 -> 7789
    //   3974: aload_0
    //   3975: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3978: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3981: istore 5
    //   3983: aload 25
    //   3985: iload 5
    //   3987: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3990: ldc_w 609
    //   3993: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3996: iload 4
    //   3998: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4001: ldc_w 571
    //   4004: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4007: aload_2
    //   4008: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4011: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4014: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4017: ldc_w 583
    //   4020: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4023: aload_2
    //   4024: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4027: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4030: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4033: ldc_w 588
    //   4036: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4039: aload_2
    //   4040: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4043: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4046: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4049: ldc_w 576
    //   4052: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4055: aload_2
    //   4056: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4059: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4062: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4065: ldc_w 581
    //   4068: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4071: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4074: aload_0
    //   4075: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4078: lsub
    //   4079: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4082: astore 25
    //   4084: aload 24
    //   4086: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4089: ifne +3706 -> 7795
    //   4092: new 125	java/lang/StringBuilder
    //   4095: dup
    //   4096: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4099: ldc_w 613
    //   4102: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4105: aload 24
    //   4107: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4110: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4113: astore 24
    //   4115: aload 26
    //   4117: aload 25
    //   4119: aload 24
    //   4121: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4124: ldc_w 611
    //   4127: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4130: aload 28
    //   4132: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4135: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4138: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   4141: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4144: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4147: aload_0
    //   4148: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4151: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4154: if_icmpne +37 -> 4191
    //   4157: aload_0
    //   4158: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4161: ifnull +30 -> 4191
    //   4164: aload_0
    //   4165: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4168: aload_0
    //   4169: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4172: aload_0
    //   4173: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4176: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4179: aload_2
    //   4180: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4183: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4186: invokeinterface 684 4 0
    //   4191: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4194: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4197: aload_0
    //   4198: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4201: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4204: if_icmpne +37 -> 4241
    //   4207: aload_0
    //   4208: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4211: ifnull +30 -> 4241
    //   4214: aload_0
    //   4215: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4218: aload_0
    //   4219: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4222: aload_0
    //   4223: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4226: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4229: aload_2
    //   4230: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4233: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4236: invokeinterface 684 4 0
    //   4241: iload 10
    //   4243: ifeq +64 -> 4307
    //   4246: aload_0
    //   4247: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4250: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   4253: astore 24
    //   4255: aload_0
    //   4256: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4259: astore 25
    //   4261: aload_0
    //   4262: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4265: ifeq +3568 -> 7833
    //   4268: aload_0
    //   4269: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4272: ifnull +3561 -> 7833
    //   4275: aload_0
    //   4276: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4279: ldc_w 686
    //   4282: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4285: ifeq +3548 -> 7833
    //   4288: iconst_1
    //   4289: istore 10
    //   4291: aload 24
    //   4293: aload 25
    //   4295: iload 10
    //   4297: aload_2
    //   4298: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4301: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4304: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   4307: aload 29
    //   4309: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   4312: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4315: aload 29
    //   4317: aload_0
    //   4318: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   4321: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4324: aload 29
    //   4326: aload 22
    //   4328: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4331: aload 29
    //   4333: aload 23
    //   4335: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   4338: aload 29
    //   4340: iload 4
    //   4342: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4345: aload 29
    //   4347: aconst_null
    //   4348: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4351: aload 27
    //   4353: ifnonnull +3486 -> 7839
    //   4356: aconst_null
    //   4357: astore 22
    //   4359: aload 29
    //   4361: aload 22
    //   4363: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4366: aload 29
    //   4368: aconst_null
    //   4369: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4372: aload 29
    //   4374: aload_2
    //   4375: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4378: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4381: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4384: aload 29
    //   4386: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4389: aload_0
    //   4390: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4393: lsub
    //   4394: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4397: aload 29
    //   4399: aload_2
    //   4400: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4403: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4406: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4409: aload 29
    //   4411: aload 29
    //   4413: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4416: aload_2
    //   4417: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4420: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4423: lsub
    //   4424: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4427: aload 29
    //   4429: lload 12
    //   4431: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4434: aload 29
    //   4436: aload_0
    //   4437: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4440: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4443: aload 29
    //   4445: aload_0
    //   4446: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   4449: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4452: aload 29
    //   4454: aload_0
    //   4455: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   4458: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4461: aload 29
    //   4463: lconst_0
    //   4464: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4467: aload 29
    //   4469: aload_0
    //   4470: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   4473: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4476: aload 29
    //   4478: aload_2
    //   4479: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4482: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4485: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4488: aload 29
    //   4490: aload_0
    //   4491: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4494: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4497: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4500: aload 29
    //   4502: aload_0
    //   4503: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4506: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4509: aload_0
    //   4510: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4513: ifnull +3336 -> 7849
    //   4516: aload_0
    //   4517: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4520: ldc_w 686
    //   4523: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4526: ifeq +3323 -> 7849
    //   4529: iconst_1
    //   4530: istore 10
    //   4532: aload 29
    //   4534: iload 10
    //   4536: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4539: aload 29
    //   4541: aload_2
    //   4542: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4545: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4548: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4551: aload_2
    //   4552: aload 29
    //   4554: invokevirtual 768	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4557: aload_2
    //   4558: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4561: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4564: ifeq +11 -> 4575
    //   4567: aload_0
    //   4568: aload_1
    //   4569: aload_2
    //   4570: aload 29
    //   4572: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4575: aload_0
    //   4576: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4579: ifeq +3276 -> 7855
    //   4582: aload_0
    //   4583: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   4586: ifnull +10 -> 4596
    //   4589: aload_0
    //   4590: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   4593: invokevirtual 777	com/squareup/okhttp/Call:cancel	()V
    //   4596: aload_0
    //   4597: aconst_null
    //   4598: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   4601: iload_3
    //   4602: iconst_1
    //   4603: iadd
    //   4604: istore_3
    //   4605: goto -4400 -> 205
    //   4608: aconst_null
    //   4609: astore 22
    //   4611: goto -2613 -> 1998
    //   4614: iconst_0
    //   4615: istore 5
    //   4617: goto -2520 -> 2097
    //   4620: lload 12
    //   4622: lstore 14
    //   4624: lload 12
    //   4626: lstore 16
    //   4628: aload_0
    //   4629: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4632: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4635: getfield 817	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4638: istore 4
    //   4640: goto -2315 -> 2325
    //   4643: lload 12
    //   4645: lstore 14
    //   4647: lload 12
    //   4649: lstore 16
    //   4651: aload 23
    //   4653: bipush 58
    //   4655: invokestatic 814	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   4658: iconst_2
    //   4659: if_icmplt +1769 -> 6428
    //   4662: lload 12
    //   4664: lstore 14
    //   4666: lload 12
    //   4668: lstore 16
    //   4670: aload_0
    //   4671: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   4674: istore 4
    //   4676: iload 4
    //   4678: ifle +1727 -> 6405
    //   4681: lload 12
    //   4683: lstore 14
    //   4685: lload 12
    //   4687: lstore 16
    //   4689: aload_0
    //   4690: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4693: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4696: iload 4
    //   4698: putfield 817	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4701: lload 12
    //   4703: lstore 14
    //   4705: iload 4
    //   4707: istore 6
    //   4709: lload 12
    //   4711: lstore 16
    //   4713: iload 4
    //   4715: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   4718: ifne +7 -> 4725
    //   4721: bipush 80
    //   4723: istore 6
    //   4725: lload 12
    //   4727: lstore 14
    //   4729: lload 12
    //   4731: lstore 16
    //   4733: new 125	java/lang/StringBuilder
    //   4736: dup
    //   4737: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4740: ldc_w 906
    //   4743: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4746: aload 23
    //   4748: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4751: ldc_w 908
    //   4754: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4757: iload 6
    //   4759: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4762: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4765: astore 23
    //   4767: lload 12
    //   4769: lstore 14
    //   4771: aload 23
    //   4773: astore 22
    //   4775: lload 12
    //   4777: lstore 16
    //   4779: aload_0
    //   4780: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4783: ifnull -2350 -> 2433
    //   4786: lload 12
    //   4788: lstore 14
    //   4790: lload 12
    //   4792: lstore 16
    //   4794: aload_0
    //   4795: aload_0
    //   4796: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4799: aload_0
    //   4800: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4803: aload 23
    //   4805: invokevirtual 825	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4808: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4811: aload 23
    //   4813: astore 22
    //   4815: goto -2382 -> 2433
    //   4818: astore 22
    //   4820: aconst_null
    //   4821: astore 23
    //   4823: iload 7
    //   4825: istore 4
    //   4827: lload 16
    //   4829: lstore 12
    //   4831: aload_2
    //   4832: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4835: lload 18
    //   4837: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4840: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4843: aload_2
    //   4844: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4847: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4850: aload_0
    //   4851: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4854: lsub
    //   4855: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4858: aload_2
    //   4859: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4862: aload_0
    //   4863: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   4866: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4869: aload_0
    //   4870: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4873: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4876: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4879: astore 30
    //   4881: aload_0
    //   4882: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4885: ifnull +10924 -> 15809
    //   4888: aload_0
    //   4889: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4892: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4895: ifnull +10914 -> 15809
    //   4898: aload_0
    //   4899: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4902: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4905: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   4908: astore 27
    //   4910: aload_0
    //   4911: aload_0
    //   4912: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   4915: aload 26
    //   4917: aload 25
    //   4919: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   4922: astore 31
    //   4924: aload 24
    //   4926: ifnull +11841 -> 16767
    //   4929: aload 24
    //   4931: ldc_w 492
    //   4934: invokeinterface 498 2 0
    //   4939: checkcast 282	java/lang/String
    //   4942: astore 24
    //   4944: aload_2
    //   4945: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4948: aload 24
    //   4950: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   4953: aload_0
    //   4954: lconst_0
    //   4955: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4958: aload_0
    //   4959: iconst_0
    //   4960: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   4963: aload_0
    //   4964: lconst_0
    //   4965: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   4968: aload_0
    //   4969: iconst_0
    //   4970: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   4973: aload_2
    //   4974: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4977: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4980: ifeq +12 -> 4992
    //   4983: aload_1
    //   4984: invokeinterface 359 1 0
    //   4989: ifeq +31 -> 5020
    //   4992: aload_0
    //   4993: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4996: ifnull +24 -> 5020
    //   4999: aload_0
    //   5000: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5003: aload_0
    //   5004: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5007: aload_2
    //   5008: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   5011: aload 26
    //   5013: aload 25
    //   5015: invokeinterface 523 5 0
    //   5020: aload_1
    //   5021: invokeinterface 359 1 0
    //   5026: ifne +1350 -> 6376
    //   5029: aload_0
    //   5030: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5033: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5036: istore 10
    //   5038: aload_2
    //   5039: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5042: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5045: ifne +10814 -> 15859
    //   5048: new 125	java/lang/StringBuilder
    //   5051: dup
    //   5052: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5055: ldc_w 525
    //   5058: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5061: aload_0
    //   5062: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5065: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5068: ldc_w 527
    //   5071: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5074: aload_0
    //   5075: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5078: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5081: ldc_w 532
    //   5084: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5087: astore 32
    //   5089: aload_0
    //   5090: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5093: ifeq +10732 -> 15825
    //   5096: aload 25
    //   5098: ifnull +10727 -> 15825
    //   5101: aload 25
    //   5103: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5106: ifnull +10719 -> 15825
    //   5109: aload 25
    //   5111: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5114: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   5117: astore 28
    //   5119: aload 32
    //   5121: aload 28
    //   5123: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5126: ldc_w 543
    //   5129: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5132: aload 30
    //   5134: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5137: ldc_w 548
    //   5140: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5143: aload 27
    //   5145: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5148: ldc_w 550
    //   5151: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5154: aconst_null
    //   5155: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5158: ldc_w 552
    //   5161: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5164: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5167: invokevirtual 174	java/lang/Thread:getId	()J
    //   5170: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5173: ldc_w 554
    //   5176: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5179: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5182: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5185: ldc_w 556
    //   5188: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5191: aload_0
    //   5192: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5195: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5198: ldc_w 558
    //   5201: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5204: aload_0
    //   5205: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5208: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5211: ldc_w 560
    //   5214: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5217: astore 32
    //   5219: aload_0
    //   5220: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5223: ifeq +10610 -> 15833
    //   5226: aload_0
    //   5227: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5230: aload_0
    //   5231: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5234: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5237: astore 28
    //   5239: aload 32
    //   5241: aload 28
    //   5243: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5246: ldc_w 562
    //   5249: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5252: iload 10
    //   5254: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5257: ldc_w 564
    //   5260: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5263: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5266: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5269: ldc_w 571
    //   5272: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5275: aload_2
    //   5276: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5279: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5282: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5285: ldc_w 576
    //   5288: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5291: aload_2
    //   5292: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5295: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5298: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5301: ldc_w 581
    //   5304: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5307: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5310: aload_0
    //   5311: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5314: lsub
    //   5315: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5318: ldc_w 583
    //   5321: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5324: aload_2
    //   5325: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5328: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5331: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5334: ldc_w 588
    //   5337: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5340: aload_2
    //   5341: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5344: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5347: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5350: ldc_w 592
    //   5353: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5356: aload_2
    //   5357: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5360: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5363: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5366: ldc_w 597
    //   5369: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5372: aload_0
    //   5373: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   5376: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5379: ldc_w 599
    //   5382: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5385: aload_0
    //   5386: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   5389: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5392: ldc_w 604
    //   5395: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5398: aload_2
    //   5399: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5402: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5405: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5408: ldc_w 609
    //   5411: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5414: iload 4
    //   5416: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5419: ldc_w 611
    //   5422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5425: aload 31
    //   5427: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5430: ldc_w 613
    //   5433: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5436: aload 24
    //   5438: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5441: ldc_w 615
    //   5444: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5447: astore 32
    //   5449: aload_0
    //   5450: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5453: ifnull +10386 -> 15839
    //   5456: aload_0
    //   5457: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5460: iconst_0
    //   5461: bipush 30
    //   5463: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   5466: astore 28
    //   5468: aload 32
    //   5470: aload 28
    //   5472: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5475: ldc_w 621
    //   5478: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5481: astore 28
    //   5483: aload_0
    //   5484: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5487: ifnull +10361 -> 15848
    //   5490: aload_0
    //   5491: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5494: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5497: istore_3
    //   5498: aload 28
    //   5500: iload_3
    //   5501: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5504: ldc_w 623
    //   5507: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5510: aload_2
    //   5511: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5514: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5517: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5520: ldc_w 628
    //   5523: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5526: lload 12
    //   5528: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5531: ldc_w 630
    //   5534: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5537: aload_0
    //   5538: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5541: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5544: ldc_w 599
    //   5547: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5550: aload_0
    //   5551: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   5554: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5557: ldc_w 632
    //   5560: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5563: aload_0
    //   5564: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   5567: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5570: ldc_w 599
    //   5573: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5576: aload_0
    //   5577: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   5580: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5583: ldc_w 634
    //   5586: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5589: aload_0
    //   5590: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   5593: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5596: ldc_w 636
    //   5599: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5602: aload_0
    //   5603: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   5606: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5609: ldc_w 641
    //   5612: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5615: aload_0
    //   5616: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   5619: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5622: ldc_w 646
    //   5625: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5628: astore 32
    //   5630: aload_0
    //   5631: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5634: ifnull +10219 -> 15853
    //   5637: aload_0
    //   5638: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5641: invokeinterface 656 1 0
    //   5646: astore 28
    //   5648: aload 29
    //   5650: aload 32
    //   5652: aload 28
    //   5654: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5657: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5660: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5663: ldc_w 447
    //   5666: aload 29
    //   5668: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5671: aload 23
    //   5673: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5676: aload_0
    //   5677: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5680: ifnull +24 -> 5704
    //   5683: aload_0
    //   5684: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5687: ldc_w 439
    //   5690: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5693: ifeq +11 -> 5704
    //   5696: aload_0
    //   5697: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5700: iconst_0
    //   5701: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   5704: iload 10
    //   5706: ifne +8 -> 5714
    //   5709: aload_0
    //   5710: iconst_0
    //   5711: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   5714: aload_2
    //   5715: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5718: astore 28
    //   5720: new 125	java/lang/StringBuilder
    //   5723: dup
    //   5724: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5727: aload_0
    //   5728: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5731: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5734: ldc_w 670
    //   5737: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5740: aload 27
    //   5742: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5745: ldc_w 672
    //   5748: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5751: aload_2
    //   5752: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5755: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5758: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5761: ldc_w 674
    //   5764: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5767: astore 27
    //   5769: aload_0
    //   5770: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5773: ifnull +10723 -> 16496
    //   5776: aload_0
    //   5777: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5780: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5783: istore_3
    //   5784: aload 27
    //   5786: iload_3
    //   5787: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5790: ldc_w 609
    //   5793: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5796: iload 4
    //   5798: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5801: ldc_w 571
    //   5804: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5807: aload_2
    //   5808: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5811: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5814: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5817: ldc_w 583
    //   5820: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5823: aload_2
    //   5824: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5827: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5830: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5833: ldc_w 588
    //   5836: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5839: aload_2
    //   5840: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5843: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5846: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5849: ldc_w 576
    //   5852: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5855: aload_2
    //   5856: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5859: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5862: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5865: ldc_w 581
    //   5868: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5871: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5874: aload_0
    //   5875: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5878: lsub
    //   5879: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5882: astore 27
    //   5884: aload 24
    //   5886: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5889: ifne +10612 -> 16501
    //   5892: new 125	java/lang/StringBuilder
    //   5895: dup
    //   5896: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5899: ldc_w 613
    //   5902: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5905: aload 24
    //   5907: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5910: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5913: astore 24
    //   5915: aload 28
    //   5917: aload 27
    //   5919: aload 24
    //   5921: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5924: ldc_w 611
    //   5927: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5930: aload 31
    //   5932: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5935: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5938: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   5941: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5944: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5947: aload_0
    //   5948: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5951: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5954: if_icmpne +37 -> 5991
    //   5957: aload_0
    //   5958: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5961: ifnull +30 -> 5991
    //   5964: aload_0
    //   5965: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5968: aload_0
    //   5969: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5972: aload_0
    //   5973: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5976: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5979: aload_2
    //   5980: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5983: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5986: invokeinterface 684 4 0
    //   5991: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5994: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5997: aload_0
    //   5998: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6001: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6004: if_icmpne +37 -> 6041
    //   6007: aload_0
    //   6008: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6011: ifnull +30 -> 6041
    //   6014: aload_0
    //   6015: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6018: aload_0
    //   6019: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6022: aload_0
    //   6023: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6026: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   6029: aload_2
    //   6030: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6033: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6036: invokeinterface 684 4 0
    //   6041: iload 10
    //   6043: ifeq +64 -> 6107
    //   6046: aload_0
    //   6047: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   6050: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   6053: astore 24
    //   6055: aload_0
    //   6056: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6059: astore 27
    //   6061: aload_0
    //   6062: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6065: ifeq +10474 -> 16539
    //   6068: aload_0
    //   6069: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6072: ifnull +10467 -> 16539
    //   6075: aload_0
    //   6076: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6079: ldc_w 686
    //   6082: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6085: ifeq +10454 -> 16539
    //   6088: iconst_1
    //   6089: istore 10
    //   6091: aload 24
    //   6093: aload 27
    //   6095: iload 10
    //   6097: aload_2
    //   6098: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6101: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6104: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   6107: aload 29
    //   6109: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   6112: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   6115: aload 29
    //   6117: aload_0
    //   6118: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   6121: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   6124: aload 29
    //   6126: aload 26
    //   6128: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   6131: aload 29
    //   6133: aload 25
    //   6135: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   6138: aload 29
    //   6140: iload 4
    //   6142: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   6145: aload 29
    //   6147: aload 23
    //   6149: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   6152: aload 30
    //   6154: ifnonnull +10391 -> 16545
    //   6157: aconst_null
    //   6158: astore 23
    //   6160: aload 29
    //   6162: aload 23
    //   6164: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   6167: aload 29
    //   6169: aconst_null
    //   6170: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   6173: aload 29
    //   6175: aload_2
    //   6176: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6179: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6182: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   6185: aload 29
    //   6187: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   6190: aload_0
    //   6191: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   6194: lsub
    //   6195: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6198: aload 29
    //   6200: aload_2
    //   6201: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6204: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6207: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6210: aload 29
    //   6212: aload 29
    //   6214: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6217: aload_2
    //   6218: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6221: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6224: lsub
    //   6225: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6228: aload 29
    //   6230: lload 12
    //   6232: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6235: aload 29
    //   6237: aload_0
    //   6238: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   6241: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6244: aload 29
    //   6246: aload_0
    //   6247: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   6250: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6253: aload 29
    //   6255: aload_0
    //   6256: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   6259: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   6262: aload 29
    //   6264: lconst_0
    //   6265: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   6268: aload 29
    //   6270: aload_0
    //   6271: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   6274: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6277: aload 29
    //   6279: aload_2
    //   6280: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6283: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6286: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6289: aload 29
    //   6291: aload_0
    //   6292: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6295: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6298: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6301: aload 29
    //   6303: aload_0
    //   6304: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6307: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6310: aload_0
    //   6311: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6314: ifnull +10241 -> 16555
    //   6317: aload_0
    //   6318: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6321: ldc_w 686
    //   6324: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6327: ifeq +10228 -> 16555
    //   6330: iconst_1
    //   6331: istore 10
    //   6333: aload 29
    //   6335: iload 10
    //   6337: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6340: aload 29
    //   6342: aload_2
    //   6343: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6346: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6349: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6352: aload_2
    //   6353: aload 29
    //   6355: invokevirtual 768	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6358: aload_2
    //   6359: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6362: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6365: ifeq +11 -> 6376
    //   6368: aload_0
    //   6369: aload_1
    //   6370: aload_2
    //   6371: aload 29
    //   6373: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6376: aload_0
    //   6377: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6380: ifeq +10181 -> 16561
    //   6383: aload_0
    //   6384: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6387: ifnull +10 -> 6397
    //   6390: aload_0
    //   6391: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6394: invokevirtual 777	com/squareup/okhttp/Call:cancel	()V
    //   6397: aload_0
    //   6398: aconst_null
    //   6399: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6402: aload 22
    //   6404: athrow
    //   6405: lload 12
    //   6407: lstore 14
    //   6409: lload 12
    //   6411: lstore 16
    //   6413: aload_0
    //   6414: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6417: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6420: getfield 817	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6423: istore 4
    //   6425: goto -1724 -> 4701
    //   6428: lload 12
    //   6430: lstore 14
    //   6432: aload 27
    //   6434: astore 22
    //   6436: lload 12
    //   6438: lstore 16
    //   6440: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6443: iconst_3
    //   6444: if_icmpne -4011 -> 2433
    //   6447: lload 12
    //   6449: lstore 14
    //   6451: aload 27
    //   6453: astore 22
    //   6455: lload 12
    //   6457: lstore 16
    //   6459: aload_0
    //   6460: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6463: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6466: getstatic 272	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6469: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6472: if_icmpeq -4039 -> 2433
    //   6475: lload 12
    //   6477: lstore 14
    //   6479: lload 12
    //   6481: lstore 16
    //   6483: aload_0
    //   6484: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6487: istore 4
    //   6489: iload 4
    //   6491: ifle +134 -> 6625
    //   6494: lload 12
    //   6496: lstore 14
    //   6498: lload 12
    //   6500: lstore 16
    //   6502: aload_0
    //   6503: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6506: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6509: iload 4
    //   6511: putfield 817	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6514: lload 12
    //   6516: lstore 14
    //   6518: lload 12
    //   6520: lstore 16
    //   6522: iload 4
    //   6524: istore 6
    //   6526: iload 4
    //   6528: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6531: ifne +7 -> 6538
    //   6534: bipush 80
    //   6536: istore 6
    //   6538: lload 12
    //   6540: lstore 14
    //   6542: lload 12
    //   6544: lstore 16
    //   6546: new 125	java/lang/StringBuilder
    //   6549: dup
    //   6550: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6553: aload 23
    //   6555: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6558: ldc_w 819
    //   6561: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6564: iload 6
    //   6566: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6569: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6572: astore 23
    //   6574: lload 12
    //   6576: lstore 14
    //   6578: aload 23
    //   6580: astore 22
    //   6582: lload 12
    //   6584: lstore 16
    //   6586: aload_0
    //   6587: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6590: ifnull -4157 -> 2433
    //   6593: lload 12
    //   6595: lstore 14
    //   6597: lload 12
    //   6599: lstore 16
    //   6601: aload_0
    //   6602: aload_0
    //   6603: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6606: aload_0
    //   6607: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6610: aload 23
    //   6612: invokevirtual 825	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6615: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6618: aload 23
    //   6620: astore 22
    //   6622: goto -4189 -> 2433
    //   6625: lload 12
    //   6627: lstore 14
    //   6629: lload 12
    //   6631: lstore 16
    //   6633: aload_0
    //   6634: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6637: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6640: getfield 817	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6643: istore 4
    //   6645: goto -131 -> 6514
    //   6648: lload 12
    //   6650: lstore 14
    //   6652: lload 12
    //   6654: lstore 16
    //   6656: aload_0
    //   6657: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6660: ldc_w 686
    //   6663: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6666: ifeq -4125 -> 2541
    //   6669: iload 5
    //   6671: ifeq -4130 -> 2541
    //   6674: iload 10
    //   6676: ifeq -4135 -> 2541
    //   6679: lload 12
    //   6681: lstore 14
    //   6683: lload 12
    //   6685: lstore 16
    //   6687: aload_0
    //   6688: aload_0
    //   6689: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6692: ldc_w 910
    //   6695: ldc_w 912
    //   6698: invokevirtual 825	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6701: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6704: lload 12
    //   6706: lstore 14
    //   6708: lload 12
    //   6710: lstore 16
    //   6712: aload_0
    //   6713: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6716: istore 4
    //   6718: iload 4
    //   6720: ifle +231 -> 6951
    //   6723: lload 12
    //   6725: lstore 14
    //   6727: lload 12
    //   6729: lstore 16
    //   6731: aload_0
    //   6732: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6735: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6738: iload 4
    //   6740: putfield 817	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6743: lload 12
    //   6745: lstore 14
    //   6747: lload 12
    //   6749: lstore 16
    //   6751: iload 4
    //   6753: istore 6
    //   6755: iload 4
    //   6757: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6760: ifne +7 -> 6767
    //   6763: bipush 80
    //   6765: istore 6
    //   6767: lload 12
    //   6769: lstore 14
    //   6771: lload 12
    //   6773: lstore 16
    //   6775: new 125	java/lang/StringBuilder
    //   6778: dup
    //   6779: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6782: ldc_w 906
    //   6785: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6788: ldc_w 914
    //   6791: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6794: ldc_w 908
    //   6797: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6800: iload 6
    //   6802: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6805: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6808: astore 22
    //   6810: lload 12
    //   6812: lstore 14
    //   6814: lload 12
    //   6816: lstore 16
    //   6818: aload_0
    //   6819: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6822: ifnull +28 -> 6850
    //   6825: lload 12
    //   6827: lstore 14
    //   6829: lload 12
    //   6831: lstore 16
    //   6833: aload_0
    //   6834: aload_0
    //   6835: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6838: aload_0
    //   6839: getfield 821	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6842: aload 22
    //   6844: invokevirtual 825	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6847: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6850: lload 12
    //   6852: lstore 14
    //   6854: lload 12
    //   6856: lstore 16
    //   6858: aload 29
    //   6860: aload_0
    //   6861: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6864: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   6867: putfield 828	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6870: lload 12
    //   6872: lstore 14
    //   6874: lload 12
    //   6876: lstore 16
    //   6878: invokestatic 831	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   6881: ifeq -4340 -> 2541
    //   6884: lload 12
    //   6886: lstore 14
    //   6888: lload 12
    //   6890: lstore 16
    //   6892: ldc 219
    //   6894: new 125	java/lang/StringBuilder
    //   6897: dup
    //   6898: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6901: ldc_w 833
    //   6904: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6907: aload 29
    //   6909: getfield 828	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6912: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6915: ldc_w 916
    //   6918: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6921: aload_0
    //   6922: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   6925: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6928: ldc 225
    //   6930: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6933: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6936: invokevirtual 174	java/lang/Thread:getId	()J
    //   6939: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6942: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6945: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6948: goto -4407 -> 2541
    //   6951: lload 12
    //   6953: lstore 14
    //   6955: lload 12
    //   6957: lstore 16
    //   6959: aload_0
    //   6960: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6963: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6966: getfield 817	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6969: istore 4
    //   6971: goto -228 -> 6743
    //   6974: lload 12
    //   6976: lstore 14
    //   6978: lload 12
    //   6980: lstore 16
    //   6982: aload_0
    //   6983: aload_0
    //   6984: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   6987: aload_0
    //   6988: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   6991: aload_0
    //   6992: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6995: aload_0
    //   6996: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6999: aload_0
    //   7000: getfield 801	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   7003: aload 30
    //   7005: invokestatic 920	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   7008: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7011: goto -4360 -> 2651
    //   7014: lload 12
    //   7016: lstore 14
    //   7018: lload 12
    //   7020: lstore 16
    //   7022: aload_0
    //   7023: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   7026: ifnull +9795 -> 16821
    //   7029: lload 12
    //   7031: lstore 14
    //   7033: lload 12
    //   7035: lstore 16
    //   7037: aload_0
    //   7038: aload_0
    //   7039: getfield 924	com/tencent/component/network/downloader/impl/FastDownloadTask:pokHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttp2Client;
    //   7042: aload_0
    //   7043: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   7046: invokevirtual 930	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   7049: aload 30
    //   7051: invokevirtual 936	com/tencent/component/network/utils/http/base/QZoneHttp2Client:newCall	(Lcom/squareup/okhttp/Request;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lcom/squareup/okhttp/Call;
    //   7054: putfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   7057: lload 12
    //   7059: lstore 14
    //   7061: lload 12
    //   7063: lstore 16
    //   7065: aload_0
    //   7066: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   7069: invokevirtual 939	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   7072: astore 23
    //   7074: aconst_null
    //   7075: astore 22
    //   7077: aconst_null
    //   7078: astore 24
    //   7080: goto -4193 -> 2887
    //   7083: aload 23
    //   7085: ifnull +9730 -> 16815
    //   7088: aload 23
    //   7090: invokevirtual 942	com/squareup/okhttp/Response:code	()I
    //   7093: istore 4
    //   7095: goto -4159 -> 2936
    //   7098: aconst_null
    //   7099: astore 25
    //   7101: goto -3994 -> 3107
    //   7104: astore 24
    //   7106: ldc_w 428
    //   7109: astore 24
    //   7111: goto -3970 -> 3141
    //   7114: ldc_w 944
    //   7117: astore 26
    //   7119: goto -3803 -> 3316
    //   7122: aconst_null
    //   7123: astore 26
    //   7125: goto -3689 -> 3436
    //   7128: aload_0
    //   7129: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7132: astore 26
    //   7134: goto -3469 -> 3665
    //   7137: iconst_0
    //   7138: istore 5
    //   7140: goto -3444 -> 3696
    //   7143: aconst_null
    //   7144: astore 26
    //   7146: goto -3299 -> 3847
    //   7149: new 125	java/lang/StringBuilder
    //   7152: dup
    //   7153: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   7156: ldc_w 946
    //   7159: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7162: aload_0
    //   7163: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7166: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7169: ldc_w 527
    //   7172: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7175: aload_0
    //   7176: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7179: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7182: ldc_w 532
    //   7185: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7188: astore 30
    //   7190: aload_0
    //   7191: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7194: ifeq +560 -> 7754
    //   7197: aload 23
    //   7199: ifnull +555 -> 7754
    //   7202: aload 23
    //   7204: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7207: ifnull +547 -> 7754
    //   7210: aload 23
    //   7212: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7215: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   7218: astore 26
    //   7220: aload 30
    //   7222: aload 26
    //   7224: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7227: ldc_w 543
    //   7230: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7233: aload 27
    //   7235: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7238: ldc_w 548
    //   7241: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7244: aload 25
    //   7246: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7249: ldc_w 550
    //   7252: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7255: aconst_null
    //   7256: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7259: ldc_w 552
    //   7262: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7265: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7268: invokevirtual 174	java/lang/Thread:getId	()J
    //   7271: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7274: ldc_w 554
    //   7277: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7280: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7283: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7286: ldc_w 556
    //   7289: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7292: aload_0
    //   7293: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7296: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7299: ldc_w 558
    //   7302: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7305: aload_0
    //   7306: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7309: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7312: ldc_w 560
    //   7315: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7318: astore 30
    //   7320: aload_0
    //   7321: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7324: ifeq +438 -> 7762
    //   7327: aload_0
    //   7328: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7331: aload_0
    //   7332: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7335: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7338: astore 26
    //   7340: aload 30
    //   7342: aload 26
    //   7344: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7347: ldc_w 564
    //   7350: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7353: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7356: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7359: ldc_w 576
    //   7362: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7365: aload_2
    //   7366: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7369: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7372: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7375: ldc_w 581
    //   7378: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7381: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7384: aload_0
    //   7385: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7388: lsub
    //   7389: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7392: ldc_w 583
    //   7395: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7398: aload_2
    //   7399: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7402: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7405: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7408: ldc_w 588
    //   7411: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7414: aload_2
    //   7415: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7418: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7421: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7424: ldc_w 592
    //   7427: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7430: aload_2
    //   7431: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7434: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7437: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7440: ldc_w 597
    //   7443: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7446: aload_0
    //   7447: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   7450: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7453: ldc_w 599
    //   7456: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7459: aload_0
    //   7460: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   7463: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7466: ldc_w 948
    //   7469: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7472: iload 4
    //   7474: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7477: ldc_w 611
    //   7480: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7483: aload 28
    //   7485: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7488: ldc_w 571
    //   7491: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7494: aload_2
    //   7495: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7498: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7501: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7504: ldc_w 613
    //   7507: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7510: aload 24
    //   7512: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7515: ldc_w 615
    //   7518: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7521: astore 30
    //   7523: aload_0
    //   7524: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7527: ifnull +241 -> 7768
    //   7530: aload_0
    //   7531: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7534: iconst_0
    //   7535: bipush 30
    //   7537: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   7540: astore 26
    //   7542: aload 30
    //   7544: aload 26
    //   7546: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7549: ldc_w 621
    //   7552: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7555: astore 26
    //   7557: aload_0
    //   7558: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7561: ifnull +216 -> 7777
    //   7564: aload_0
    //   7565: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7568: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7571: istore 5
    //   7573: aload 26
    //   7575: iload 5
    //   7577: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7580: ldc_w 623
    //   7583: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7586: aload_2
    //   7587: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7590: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7593: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7596: ldc_w 628
    //   7599: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7602: lload 12
    //   7604: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7607: ldc_w 630
    //   7610: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7613: aload_0
    //   7614: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   7617: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7620: ldc_w 599
    //   7623: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7626: aload_0
    //   7627: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   7630: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7633: ldc_w 632
    //   7636: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7639: aload_0
    //   7640: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   7643: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7646: ldc_w 599
    //   7649: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7652: aload_0
    //   7653: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   7656: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7659: ldc_w 634
    //   7662: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7665: aload_0
    //   7666: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   7669: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7672: ldc_w 636
    //   7675: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7678: aload_0
    //   7679: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   7682: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7685: ldc_w 641
    //   7688: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7691: aload_0
    //   7692: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   7695: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7698: ldc_w 646
    //   7701: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7704: astore 30
    //   7706: aload_0
    //   7707: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7710: ifnull +73 -> 7783
    //   7713: aload_0
    //   7714: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7717: invokeinterface 656 1 0
    //   7722: astore 26
    //   7724: aload 29
    //   7726: aload 30
    //   7728: aload 26
    //   7730: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7733: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7736: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7739: ldc_w 447
    //   7742: aload 29
    //   7744: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7747: aconst_null
    //   7748: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7751: goto -3849 -> 3902
    //   7754: ldc_w 944
    //   7757: astore 26
    //   7759: goto -539 -> 7220
    //   7762: aconst_null
    //   7763: astore 26
    //   7765: goto -425 -> 7340
    //   7768: aload_0
    //   7769: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7772: astore 26
    //   7774: goto -232 -> 7542
    //   7777: iconst_0
    //   7778: istore 5
    //   7780: goto -207 -> 7573
    //   7783: aconst_null
    //   7784: astore 26
    //   7786: goto -62 -> 7724
    //   7789: iconst_0
    //   7790: istore 5
    //   7792: goto -3809 -> 3983
    //   7795: ldc_w 428
    //   7798: astore 24
    //   7800: goto -3685 -> 4115
    //   7803: astore 24
    //   7805: ldc 219
    //   7807: ldc_w 953
    //   7810: aload 24
    //   7812: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7815: goto -3624 -> 4191
    //   7818: astore 24
    //   7820: ldc 219
    //   7822: ldc_w 955
    //   7825: aload 24
    //   7827: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7830: goto -3589 -> 4241
    //   7833: iconst_0
    //   7834: istore 10
    //   7836: goto -3545 -> 4291
    //   7839: aload 27
    //   7841: invokevirtual 958	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7844: astore 22
    //   7846: goto -3487 -> 4359
    //   7849: iconst_0
    //   7850: istore 10
    //   7852: goto -3320 -> 4532
    //   7855: aload_0
    //   7856: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7859: ifnull +15 -> 7874
    //   7862: aload_0
    //   7863: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7866: invokevirtual 963	org/apache/http/client/methods/HttpGet:abort	()V
    //   7869: aload_0
    //   7870: aconst_null
    //   7871: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7874: aload_0
    //   7875: invokevirtual 966	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   7878: goto -3277 -> 4601
    //   7881: aload_2
    //   7882: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7885: lload 18
    //   7887: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7890: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   7893: aload_2
    //   7894: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7897: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7900: aload_0
    //   7901: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7904: lsub
    //   7905: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   7908: aload_2
    //   7909: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7912: aload_0
    //   7913: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   7916: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   7919: aload_0
    //   7920: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7923: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   7926: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   7929: astore 27
    //   7931: aload_0
    //   7932: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7935: ifnull +1516 -> 9451
    //   7938: aload_0
    //   7939: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7942: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7945: ifnull +1506 -> 9451
    //   7948: aload_0
    //   7949: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7952: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7955: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   7958: astore 25
    //   7960: aload_0
    //   7961: aload_0
    //   7962: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7965: aload 22
    //   7967: aload 23
    //   7969: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   7972: astore 28
    //   7974: aload 24
    //   7976: ifnull +8823 -> 16799
    //   7979: aload 24
    //   7981: ldc_w 492
    //   7984: invokeinterface 498 2 0
    //   7989: checkcast 282	java/lang/String
    //   7992: astore 24
    //   7994: aload_2
    //   7995: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7998: aload 24
    //   8000: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8003: aload_0
    //   8004: lconst_0
    //   8005: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8008: aload_0
    //   8009: iconst_0
    //   8010: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8013: aload_0
    //   8014: lconst_0
    //   8015: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8018: aload_0
    //   8019: iconst_0
    //   8020: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8023: aload_2
    //   8024: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8027: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8030: ifeq +12 -> 8042
    //   8033: aload_1
    //   8034: invokeinterface 359 1 0
    //   8039: ifeq +31 -> 8070
    //   8042: aload_0
    //   8043: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8046: ifnull +24 -> 8070
    //   8049: aload_0
    //   8050: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8053: aload_0
    //   8054: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8057: aload_2
    //   8058: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   8061: aload 22
    //   8063: aload 23
    //   8065: invokeinterface 523 5 0
    //   8070: aload_1
    //   8071: invokeinterface 359 1 0
    //   8076: ifne +1348 -> 9424
    //   8079: aload_0
    //   8080: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8083: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8086: istore 10
    //   8088: aload_2
    //   8089: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8092: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8095: ifne +1406 -> 9501
    //   8098: new 125	java/lang/StringBuilder
    //   8101: dup
    //   8102: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8105: ldc_w 525
    //   8108: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8111: aload_0
    //   8112: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8115: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8118: ldc_w 527
    //   8121: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8124: aload_0
    //   8125: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8128: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8131: ldc_w 532
    //   8134: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8137: astore 30
    //   8139: aload_0
    //   8140: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8143: ifeq +1324 -> 9467
    //   8146: aload 23
    //   8148: ifnull +1319 -> 9467
    //   8151: aload 23
    //   8153: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8156: ifnull +1311 -> 9467
    //   8159: aload 23
    //   8161: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8164: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   8167: astore 26
    //   8169: aload 30
    //   8171: aload 26
    //   8173: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8176: ldc_w 543
    //   8179: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8182: aload 27
    //   8184: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8187: ldc_w 548
    //   8190: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8193: aload 25
    //   8195: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8198: ldc_w 550
    //   8201: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8204: aconst_null
    //   8205: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8208: ldc_w 552
    //   8211: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8214: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8217: invokevirtual 174	java/lang/Thread:getId	()J
    //   8220: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8223: ldc_w 554
    //   8226: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8229: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8232: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8235: ldc_w 556
    //   8238: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8241: aload_0
    //   8242: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8245: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8248: ldc_w 558
    //   8251: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8254: aload_0
    //   8255: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8258: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8261: ldc_w 560
    //   8264: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8267: astore 30
    //   8269: aload_0
    //   8270: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8273: ifeq +1202 -> 9475
    //   8276: aload_0
    //   8277: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8280: aload_0
    //   8281: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8284: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8287: astore 26
    //   8289: aload 30
    //   8291: aload 26
    //   8293: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8296: ldc_w 562
    //   8299: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8302: iload 10
    //   8304: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8307: ldc_w 564
    //   8310: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8313: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8316: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8319: ldc_w 571
    //   8322: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8325: aload_2
    //   8326: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8329: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8332: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8335: ldc_w 576
    //   8338: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8341: aload_2
    //   8342: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8345: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8348: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8351: ldc_w 581
    //   8354: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8357: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8360: aload_0
    //   8361: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8364: lsub
    //   8365: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8368: ldc_w 583
    //   8371: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8374: aload_2
    //   8375: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8378: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8381: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8384: ldc_w 588
    //   8387: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8390: aload_2
    //   8391: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8394: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8397: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8400: ldc_w 592
    //   8403: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8406: aload_2
    //   8407: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8410: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8413: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8416: ldc_w 597
    //   8419: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8422: aload_0
    //   8423: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   8426: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8429: ldc_w 599
    //   8432: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8435: aload_0
    //   8436: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   8439: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8442: ldc_w 604
    //   8445: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8448: aload_2
    //   8449: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8452: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8455: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8458: ldc_w 609
    //   8461: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8464: iload 4
    //   8466: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8469: ldc_w 611
    //   8472: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8475: aload 28
    //   8477: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8480: ldc_w 613
    //   8483: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8486: aload 24
    //   8488: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8491: ldc_w 615
    //   8494: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8497: astore 30
    //   8499: aload_0
    //   8500: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8503: ifnull +978 -> 9481
    //   8506: aload_0
    //   8507: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8510: iconst_0
    //   8511: bipush 30
    //   8513: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   8516: astore 26
    //   8518: aload 30
    //   8520: aload 26
    //   8522: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8525: ldc_w 621
    //   8528: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8531: astore 26
    //   8533: aload_0
    //   8534: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8537: ifnull +953 -> 9490
    //   8540: aload_0
    //   8541: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8544: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8547: istore_3
    //   8548: aload 26
    //   8550: iload_3
    //   8551: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8554: ldc_w 623
    //   8557: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8560: aload_2
    //   8561: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8564: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8567: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8570: ldc_w 628
    //   8573: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8576: lload 12
    //   8578: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8581: ldc_w 630
    //   8584: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8587: aload_0
    //   8588: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8591: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8594: ldc_w 599
    //   8597: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8600: aload_0
    //   8601: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8604: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8607: ldc_w 632
    //   8610: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8613: aload_0
    //   8614: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8617: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8620: ldc_w 599
    //   8623: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8626: aload_0
    //   8627: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8630: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8633: ldc_w 634
    //   8636: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8639: aload_0
    //   8640: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   8643: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8646: ldc_w 636
    //   8649: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8652: aload_0
    //   8653: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   8656: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8659: ldc_w 641
    //   8662: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8665: aload_0
    //   8666: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   8669: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8672: ldc_w 646
    //   8675: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8678: astore 30
    //   8680: aload_0
    //   8681: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8684: ifnull +811 -> 9495
    //   8687: aload_0
    //   8688: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8691: invokeinterface 656 1 0
    //   8696: astore 26
    //   8698: aload 29
    //   8700: aload 30
    //   8702: aload 26
    //   8704: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8707: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8710: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8713: ldc_w 447
    //   8716: aload 29
    //   8718: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8721: aconst_null
    //   8722: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8725: aload_0
    //   8726: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8729: ifnull +24 -> 8753
    //   8732: aload_0
    //   8733: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8736: ldc_w 439
    //   8739: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8742: ifeq +11 -> 8753
    //   8745: aload_0
    //   8746: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8749: iconst_0
    //   8750: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   8753: iload 10
    //   8755: ifne +8 -> 8763
    //   8758: aload_0
    //   8759: iconst_0
    //   8760: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   8763: aload_2
    //   8764: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8767: astore 26
    //   8769: new 125	java/lang/StringBuilder
    //   8772: dup
    //   8773: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8776: aload_0
    //   8777: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8780: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8783: ldc_w 670
    //   8786: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8789: aload 25
    //   8791: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8794: ldc_w 672
    //   8797: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8800: aload_2
    //   8801: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8804: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8807: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8810: ldc_w 674
    //   8813: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8816: astore 25
    //   8818: aload_0
    //   8819: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8822: ifnull +1316 -> 10138
    //   8825: aload_0
    //   8826: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8829: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8832: istore_3
    //   8833: aload 25
    //   8835: iload_3
    //   8836: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8839: ldc_w 609
    //   8842: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8845: iload 4
    //   8847: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8850: ldc_w 571
    //   8853: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8856: aload_2
    //   8857: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8860: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8863: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8866: ldc_w 583
    //   8869: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8872: aload_2
    //   8873: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8876: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8879: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8882: ldc_w 588
    //   8885: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8888: aload_2
    //   8889: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8892: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8895: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8898: ldc_w 576
    //   8901: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8904: aload_2
    //   8905: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8908: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8911: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8914: ldc_w 581
    //   8917: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8920: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8923: aload_0
    //   8924: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8927: lsub
    //   8928: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8931: astore 25
    //   8933: aload 24
    //   8935: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8938: ifne +1205 -> 10143
    //   8941: new 125	java/lang/StringBuilder
    //   8944: dup
    //   8945: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8948: ldc_w 613
    //   8951: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8954: aload 24
    //   8956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8959: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8962: astore 24
    //   8964: aload 26
    //   8966: aload 25
    //   8968: aload 24
    //   8970: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8973: ldc_w 611
    //   8976: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8979: aload 28
    //   8981: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8984: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8987: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   8990: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8993: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8996: aload_0
    //   8997: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9000: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9003: if_icmpne +37 -> 9040
    //   9006: aload_0
    //   9007: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9010: ifnull +30 -> 9040
    //   9013: aload_0
    //   9014: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9017: aload_0
    //   9018: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9021: aload_0
    //   9022: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9025: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9028: aload_2
    //   9029: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9032: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9035: invokeinterface 684 4 0
    //   9040: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9043: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9046: aload_0
    //   9047: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9050: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9053: if_icmpne +37 -> 9090
    //   9056: aload_0
    //   9057: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9060: ifnull +30 -> 9090
    //   9063: aload_0
    //   9064: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9067: aload_0
    //   9068: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9071: aload_0
    //   9072: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9075: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9078: aload_2
    //   9079: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9082: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9085: invokeinterface 684 4 0
    //   9090: iload 10
    //   9092: ifeq +64 -> 9156
    //   9095: aload_0
    //   9096: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9099: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   9102: astore 24
    //   9104: aload_0
    //   9105: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9108: astore 25
    //   9110: aload_0
    //   9111: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9114: ifeq +1067 -> 10181
    //   9117: aload_0
    //   9118: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9121: ifnull +1060 -> 10181
    //   9124: aload_0
    //   9125: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9128: ldc_w 686
    //   9131: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9134: ifeq +1047 -> 10181
    //   9137: iconst_1
    //   9138: istore 10
    //   9140: aload 24
    //   9142: aload 25
    //   9144: iload 10
    //   9146: aload_2
    //   9147: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9150: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9153: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   9156: aload 29
    //   9158: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   9161: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   9164: aload 29
    //   9166: aload_0
    //   9167: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   9170: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   9173: aload 29
    //   9175: aload 22
    //   9177: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   9180: aload 29
    //   9182: aload 23
    //   9184: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   9187: aload 29
    //   9189: iload 4
    //   9191: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   9194: aload 29
    //   9196: aconst_null
    //   9197: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   9200: aload 27
    //   9202: ifnonnull +985 -> 10187
    //   9205: aconst_null
    //   9206: astore 22
    //   9208: aload 29
    //   9210: aload 22
    //   9212: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   9215: aload 29
    //   9217: aconst_null
    //   9218: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9221: aload 29
    //   9223: aload_2
    //   9224: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9227: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9230: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9233: aload 29
    //   9235: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9238: aload_0
    //   9239: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9242: lsub
    //   9243: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9246: aload 29
    //   9248: aload_2
    //   9249: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9252: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9255: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9258: aload 29
    //   9260: aload 29
    //   9262: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9265: aload_2
    //   9266: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9269: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9272: lsub
    //   9273: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9276: aload 29
    //   9278: lload 12
    //   9280: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9283: aload 29
    //   9285: aload_0
    //   9286: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9289: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9292: aload 29
    //   9294: aload_0
    //   9295: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   9298: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9301: aload 29
    //   9303: aload_0
    //   9304: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   9307: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9310: aload 29
    //   9312: lconst_0
    //   9313: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9316: aload 29
    //   9318: aload_0
    //   9319: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   9322: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9325: aload 29
    //   9327: aload_2
    //   9328: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9331: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9334: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9337: aload 29
    //   9339: aload_0
    //   9340: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9343: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9346: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9349: aload 29
    //   9351: aload_0
    //   9352: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9355: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9358: aload_0
    //   9359: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9362: ifnull +835 -> 10197
    //   9365: aload_0
    //   9366: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9369: ldc_w 686
    //   9372: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9375: ifeq +822 -> 10197
    //   9378: iconst_1
    //   9379: istore 10
    //   9381: aload 29
    //   9383: iload 10
    //   9385: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9388: aload 29
    //   9390: aload_2
    //   9391: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9394: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9397: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9400: aload_2
    //   9401: aload 29
    //   9403: invokevirtual 768	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9406: aload_2
    //   9407: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9410: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9413: ifeq +11 -> 9424
    //   9416: aload_0
    //   9417: aload_1
    //   9418: aload_2
    //   9419: aload 29
    //   9421: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9424: aload_0
    //   9425: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9428: ifeq +775 -> 10203
    //   9431: aload_0
    //   9432: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   9435: ifnull +10 -> 9445
    //   9438: aload_0
    //   9439: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   9442: invokevirtual 777	com/squareup/okhttp/Call:cancel	()V
    //   9445: aload_0
    //   9446: aconst_null
    //   9447: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   9450: return
    //   9451: aconst_null
    //   9452: astore 25
    //   9454: goto -1494 -> 7960
    //   9457: astore 24
    //   9459: ldc_w 428
    //   9462: astore 24
    //   9464: goto -1470 -> 7994
    //   9467: ldc_w 944
    //   9470: astore 26
    //   9472: goto -1303 -> 8169
    //   9475: aconst_null
    //   9476: astore 26
    //   9478: goto -1189 -> 8289
    //   9481: aload_0
    //   9482: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9485: astore 26
    //   9487: goto -969 -> 8518
    //   9490: iconst_0
    //   9491: istore_3
    //   9492: goto -944 -> 8548
    //   9495: aconst_null
    //   9496: astore 26
    //   9498: goto -800 -> 8698
    //   9501: new 125	java/lang/StringBuilder
    //   9504: dup
    //   9505: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   9508: ldc_w 946
    //   9511: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9514: aload_0
    //   9515: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   9518: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9521: ldc_w 527
    //   9524: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9527: aload_0
    //   9528: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9531: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9534: ldc_w 532
    //   9537: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9540: astore 30
    //   9542: aload_0
    //   9543: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9546: ifeq +558 -> 10104
    //   9549: aload 23
    //   9551: ifnull +553 -> 10104
    //   9554: aload 23
    //   9556: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9559: ifnull +545 -> 10104
    //   9562: aload 23
    //   9564: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9567: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   9570: astore 26
    //   9572: aload 30
    //   9574: aload 26
    //   9576: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9579: ldc_w 543
    //   9582: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9585: aload 27
    //   9587: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9590: ldc_w 548
    //   9593: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9596: aload 25
    //   9598: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9601: ldc_w 550
    //   9604: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9607: aconst_null
    //   9608: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9611: ldc_w 552
    //   9614: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9617: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9620: invokevirtual 174	java/lang/Thread:getId	()J
    //   9623: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9626: ldc_w 554
    //   9629: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9632: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9635: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9638: ldc_w 556
    //   9641: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9644: aload_0
    //   9645: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9648: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9651: ldc_w 558
    //   9654: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9657: aload_0
    //   9658: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9661: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9664: ldc_w 560
    //   9667: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9670: astore 30
    //   9672: aload_0
    //   9673: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9676: ifeq +436 -> 10112
    //   9679: aload_0
    //   9680: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9683: aload_0
    //   9684: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9687: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9690: astore 26
    //   9692: aload 30
    //   9694: aload 26
    //   9696: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9699: ldc_w 564
    //   9702: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9705: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9708: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9711: ldc_w 576
    //   9714: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9717: aload_2
    //   9718: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9721: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9724: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9727: ldc_w 581
    //   9730: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9733: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9736: aload_0
    //   9737: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9740: lsub
    //   9741: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9744: ldc_w 583
    //   9747: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9750: aload_2
    //   9751: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9754: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9757: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9760: ldc_w 588
    //   9763: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9766: aload_2
    //   9767: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9770: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9773: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9776: ldc_w 592
    //   9779: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9782: aload_2
    //   9783: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9786: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9789: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9792: ldc_w 597
    //   9795: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9798: aload_0
    //   9799: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   9802: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9805: ldc_w 599
    //   9808: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9811: aload_0
    //   9812: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   9815: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9818: ldc_w 948
    //   9821: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9824: iload 4
    //   9826: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9829: ldc_w 611
    //   9832: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9835: aload 28
    //   9837: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9840: ldc_w 571
    //   9843: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9846: aload_2
    //   9847: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9850: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9853: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9856: ldc_w 613
    //   9859: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9862: aload 24
    //   9864: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9867: ldc_w 615
    //   9870: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9873: astore 30
    //   9875: aload_0
    //   9876: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9879: ifnull +239 -> 10118
    //   9882: aload_0
    //   9883: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9886: iconst_0
    //   9887: bipush 30
    //   9889: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   9892: astore 26
    //   9894: aload 30
    //   9896: aload 26
    //   9898: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9901: ldc_w 621
    //   9904: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9907: astore 26
    //   9909: aload_0
    //   9910: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9913: ifnull +214 -> 10127
    //   9916: aload_0
    //   9917: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9920: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9923: istore_3
    //   9924: aload 26
    //   9926: iload_3
    //   9927: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9930: ldc_w 623
    //   9933: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9936: aload_2
    //   9937: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9940: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9943: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9946: ldc_w 628
    //   9949: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9952: lload 12
    //   9954: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9957: ldc_w 630
    //   9960: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9963: aload_0
    //   9964: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9967: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9970: ldc_w 599
    //   9973: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9976: aload_0
    //   9977: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   9980: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9983: ldc_w 632
    //   9986: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9989: aload_0
    //   9990: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   9993: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9996: ldc_w 599
    //   9999: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10002: aload_0
    //   10003: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10006: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10009: ldc_w 634
    //   10012: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10015: aload_0
    //   10016: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   10019: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10022: ldc_w 636
    //   10025: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10028: aload_0
    //   10029: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   10032: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10035: ldc_w 641
    //   10038: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10041: aload_0
    //   10042: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   10045: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10048: ldc_w 646
    //   10051: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10054: astore 30
    //   10056: aload_0
    //   10057: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10060: ifnull +72 -> 10132
    //   10063: aload_0
    //   10064: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10067: invokeinterface 656 1 0
    //   10072: astore 26
    //   10074: aload 29
    //   10076: aload 30
    //   10078: aload 26
    //   10080: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10083: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10086: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10089: ldc_w 447
    //   10092: aload 29
    //   10094: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10097: aconst_null
    //   10098: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10101: goto -1348 -> 8753
    //   10104: ldc_w 944
    //   10107: astore 26
    //   10109: goto -537 -> 9572
    //   10112: aconst_null
    //   10113: astore 26
    //   10115: goto -423 -> 9692
    //   10118: aload_0
    //   10119: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10122: astore 26
    //   10124: goto -230 -> 9894
    //   10127: iconst_0
    //   10128: istore_3
    //   10129: goto -205 -> 9924
    //   10132: aconst_null
    //   10133: astore 26
    //   10135: goto -61 -> 10074
    //   10138: iconst_0
    //   10139: istore_3
    //   10140: goto -1307 -> 8833
    //   10143: ldc_w 428
    //   10146: astore 24
    //   10148: goto -1184 -> 8964
    //   10151: astore 24
    //   10153: ldc 219
    //   10155: ldc_w 953
    //   10158: aload 24
    //   10160: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10163: goto -1123 -> 9040
    //   10166: astore 24
    //   10168: ldc 219
    //   10170: ldc_w 955
    //   10173: aload 24
    //   10175: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10178: goto -1088 -> 9090
    //   10181: iconst_0
    //   10182: istore 10
    //   10184: goto -1044 -> 9140
    //   10187: aload 27
    //   10189: invokevirtual 958	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10192: astore 22
    //   10194: goto -986 -> 9208
    //   10197: iconst_0
    //   10198: istore 10
    //   10200: goto -819 -> 9381
    //   10203: aload_0
    //   10204: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10207: ifnull +15 -> 10222
    //   10210: aload_0
    //   10211: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10214: invokevirtual 963	org/apache/http/client/methods/HttpGet:abort	()V
    //   10217: aload_0
    //   10218: aconst_null
    //   10219: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10222: aload_0
    //   10223: invokevirtual 966	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   10226: return
    //   10227: aload_2
    //   10228: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10231: lload 18
    //   10233: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10236: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   10239: aload_2
    //   10240: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10243: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10246: aload_0
    //   10247: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10250: lsub
    //   10251: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   10254: aload_2
    //   10255: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10258: aload_0
    //   10259: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   10262: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   10265: aload_0
    //   10266: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10269: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   10272: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   10275: astore 27
    //   10277: aload_0
    //   10278: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10281: ifnull +1516 -> 11797
    //   10284: aload_0
    //   10285: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10288: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10291: ifnull +1506 -> 11797
    //   10294: aload_0
    //   10295: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10298: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10301: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   10304: astore 25
    //   10306: aload_0
    //   10307: aload_0
    //   10308: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10311: aload 22
    //   10313: aload 23
    //   10315: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   10318: astore 28
    //   10320: aload 24
    //   10322: ifnull +6469 -> 16791
    //   10325: aload 24
    //   10327: ldc_w 492
    //   10330: invokeinterface 498 2 0
    //   10335: checkcast 282	java/lang/String
    //   10338: astore 24
    //   10340: aload_2
    //   10341: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10344: aload 24
    //   10346: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   10349: aload_0
    //   10350: lconst_0
    //   10351: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10354: aload_0
    //   10355: iconst_0
    //   10356: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10359: aload_0
    //   10360: lconst_0
    //   10361: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10364: aload_0
    //   10365: iconst_0
    //   10366: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10369: aload_2
    //   10370: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10373: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10376: ifeq +12 -> 10388
    //   10379: aload_1
    //   10380: invokeinterface 359 1 0
    //   10385: ifeq +31 -> 10416
    //   10388: aload_0
    //   10389: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10392: ifnull +24 -> 10416
    //   10395: aload_0
    //   10396: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10399: aload_0
    //   10400: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10403: aload_2
    //   10404: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   10407: aload 22
    //   10409: aload 23
    //   10411: invokeinterface 523 5 0
    //   10416: aload_1
    //   10417: invokeinterface 359 1 0
    //   10422: ifne +1348 -> 11770
    //   10425: aload_0
    //   10426: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10429: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10432: istore 10
    //   10434: aload_2
    //   10435: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10438: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10441: ifne +1406 -> 11847
    //   10444: new 125	java/lang/StringBuilder
    //   10447: dup
    //   10448: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   10451: ldc_w 525
    //   10454: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10457: aload_0
    //   10458: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10461: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10464: ldc_w 527
    //   10467: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10470: aload_0
    //   10471: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10474: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10477: ldc_w 532
    //   10480: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10483: astore 30
    //   10485: aload_0
    //   10486: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10489: ifeq +1324 -> 11813
    //   10492: aload 23
    //   10494: ifnull +1319 -> 11813
    //   10497: aload 23
    //   10499: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10502: ifnull +1311 -> 11813
    //   10505: aload 23
    //   10507: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10510: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   10513: astore 26
    //   10515: aload 30
    //   10517: aload 26
    //   10519: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10522: ldc_w 543
    //   10525: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10528: aload 27
    //   10530: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10533: ldc_w 548
    //   10536: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10539: aload 25
    //   10541: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10544: ldc_w 550
    //   10547: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10550: aconst_null
    //   10551: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10554: ldc_w 552
    //   10557: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10560: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10563: invokevirtual 174	java/lang/Thread:getId	()J
    //   10566: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10569: ldc_w 554
    //   10572: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10575: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10578: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10581: ldc_w 556
    //   10584: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10587: aload_0
    //   10588: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10591: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10594: ldc_w 558
    //   10597: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10600: aload_0
    //   10601: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10604: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10607: ldc_w 560
    //   10610: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10613: astore 30
    //   10615: aload_0
    //   10616: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10619: ifeq +1202 -> 11821
    //   10622: aload_0
    //   10623: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10626: aload_0
    //   10627: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10630: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10633: astore 26
    //   10635: aload 30
    //   10637: aload 26
    //   10639: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10642: ldc_w 562
    //   10645: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10648: iload 10
    //   10650: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10653: ldc_w 564
    //   10656: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10659: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10662: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10665: ldc_w 571
    //   10668: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10671: aload_2
    //   10672: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10675: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10678: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10681: ldc_w 576
    //   10684: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10687: aload_2
    //   10688: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10691: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10694: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10697: ldc_w 581
    //   10700: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10703: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10706: aload_0
    //   10707: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10710: lsub
    //   10711: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10714: ldc_w 583
    //   10717: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10720: aload_2
    //   10721: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10724: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10727: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10730: ldc_w 588
    //   10733: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10736: aload_2
    //   10737: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10740: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10743: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10746: ldc_w 592
    //   10749: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10752: aload_2
    //   10753: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10756: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10759: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10762: ldc_w 597
    //   10765: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10768: aload_0
    //   10769: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   10772: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10775: ldc_w 599
    //   10778: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10781: aload_0
    //   10782: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   10785: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10788: ldc_w 604
    //   10791: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10794: aload_2
    //   10795: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10798: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   10801: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10804: ldc_w 609
    //   10807: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10810: iload 4
    //   10812: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10815: ldc_w 611
    //   10818: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10821: aload 28
    //   10823: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10826: ldc_w 613
    //   10829: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10832: aload 24
    //   10834: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10837: ldc_w 615
    //   10840: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10843: astore 30
    //   10845: aload_0
    //   10846: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10849: ifnull +978 -> 11827
    //   10852: aload_0
    //   10853: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10856: iconst_0
    //   10857: bipush 30
    //   10859: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   10862: astore 26
    //   10864: aload 30
    //   10866: aload 26
    //   10868: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10871: ldc_w 621
    //   10874: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10877: astore 26
    //   10879: aload_0
    //   10880: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10883: ifnull +953 -> 11836
    //   10886: aload_0
    //   10887: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10890: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10893: istore_3
    //   10894: aload 26
    //   10896: iload_3
    //   10897: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10900: ldc_w 623
    //   10903: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10906: aload_2
    //   10907: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10910: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10913: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10916: ldc_w 628
    //   10919: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10922: lload 12
    //   10924: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10927: ldc_w 630
    //   10930: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10933: aload_0
    //   10934: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10937: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10940: ldc_w 599
    //   10943: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10946: aload_0
    //   10947: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10950: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10953: ldc_w 632
    //   10956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10959: aload_0
    //   10960: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10963: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10966: ldc_w 599
    //   10969: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10972: aload_0
    //   10973: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10976: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10979: ldc_w 634
    //   10982: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10985: aload_0
    //   10986: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   10989: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10992: ldc_w 636
    //   10995: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10998: aload_0
    //   10999: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11002: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11005: ldc_w 641
    //   11008: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11011: aload_0
    //   11012: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11015: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11018: ldc_w 646
    //   11021: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11024: astore 30
    //   11026: aload_0
    //   11027: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11030: ifnull +811 -> 11841
    //   11033: aload_0
    //   11034: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11037: invokeinterface 656 1 0
    //   11042: astore 26
    //   11044: aload 29
    //   11046: aload 30
    //   11048: aload 26
    //   11050: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11053: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11056: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   11059: ldc_w 447
    //   11062: aload 29
    //   11064: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   11067: aconst_null
    //   11068: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11071: aload_0
    //   11072: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11075: ifnull +24 -> 11099
    //   11078: aload_0
    //   11079: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11082: ldc_w 439
    //   11085: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11088: ifeq +11 -> 11099
    //   11091: aload_0
    //   11092: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11095: iconst_0
    //   11096: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   11099: iload 10
    //   11101: ifne +8 -> 11109
    //   11104: aload_0
    //   11105: iconst_0
    //   11106: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   11109: aload_2
    //   11110: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11113: astore 26
    //   11115: new 125	java/lang/StringBuilder
    //   11118: dup
    //   11119: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11122: aload_0
    //   11123: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11126: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11129: ldc_w 670
    //   11132: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11135: aload 25
    //   11137: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11140: ldc_w 672
    //   11143: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11146: aload_2
    //   11147: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11150: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11153: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11156: ldc_w 674
    //   11159: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11162: astore 25
    //   11164: aload_0
    //   11165: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11168: ifnull +1316 -> 12484
    //   11171: aload_0
    //   11172: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11175: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11178: istore_3
    //   11179: aload 25
    //   11181: iload_3
    //   11182: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11185: ldc_w 609
    //   11188: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11191: iload 4
    //   11193: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11196: ldc_w 571
    //   11199: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11202: aload_2
    //   11203: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11206: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11209: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11212: ldc_w 583
    //   11215: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11218: aload_2
    //   11219: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11222: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11225: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11228: ldc_w 588
    //   11231: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11234: aload_2
    //   11235: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11238: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11241: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11244: ldc_w 576
    //   11247: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11250: aload_2
    //   11251: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11254: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11257: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11260: ldc_w 581
    //   11263: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11266: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11269: aload_0
    //   11270: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11273: lsub
    //   11274: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11277: astore 25
    //   11279: aload 24
    //   11281: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11284: ifne +1205 -> 12489
    //   11287: new 125	java/lang/StringBuilder
    //   11290: dup
    //   11291: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11294: ldc_w 613
    //   11297: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11300: aload 24
    //   11302: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11305: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11308: astore 24
    //   11310: aload 26
    //   11312: aload 25
    //   11314: aload 24
    //   11316: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11319: ldc_w 611
    //   11322: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11325: aload 28
    //   11327: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11330: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11333: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   11336: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11339: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11342: aload_0
    //   11343: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11346: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11349: if_icmpne +37 -> 11386
    //   11352: aload_0
    //   11353: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11356: ifnull +30 -> 11386
    //   11359: aload_0
    //   11360: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11363: aload_0
    //   11364: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11367: aload_0
    //   11368: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11371: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11374: aload_2
    //   11375: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11378: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11381: invokeinterface 684 4 0
    //   11386: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11389: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11392: aload_0
    //   11393: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11396: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11399: if_icmpne +37 -> 11436
    //   11402: aload_0
    //   11403: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11406: ifnull +30 -> 11436
    //   11409: aload_0
    //   11410: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11413: aload_0
    //   11414: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11417: aload_0
    //   11418: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11421: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11424: aload_2
    //   11425: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11428: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11431: invokeinterface 684 4 0
    //   11436: iload 10
    //   11438: ifeq +64 -> 11502
    //   11441: aload_0
    //   11442: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11445: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   11448: astore 24
    //   11450: aload_0
    //   11451: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11454: astore 25
    //   11456: aload_0
    //   11457: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11460: ifeq +1067 -> 12527
    //   11463: aload_0
    //   11464: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11467: ifnull +1060 -> 12527
    //   11470: aload_0
    //   11471: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11474: ldc_w 686
    //   11477: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11480: ifeq +1047 -> 12527
    //   11483: iconst_1
    //   11484: istore 10
    //   11486: aload 24
    //   11488: aload 25
    //   11490: iload 10
    //   11492: aload_2
    //   11493: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11496: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11499: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   11502: aload 29
    //   11504: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   11507: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   11510: aload 29
    //   11512: aload_0
    //   11513: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   11516: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   11519: aload 29
    //   11521: aload 22
    //   11523: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   11526: aload 29
    //   11528: aload 23
    //   11530: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   11533: aload 29
    //   11535: iload 4
    //   11537: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   11540: aload 29
    //   11542: aconst_null
    //   11543: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   11546: aload 27
    //   11548: ifnonnull +985 -> 12533
    //   11551: aconst_null
    //   11552: astore 22
    //   11554: aload 29
    //   11556: aload 22
    //   11558: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   11561: aload 29
    //   11563: aconst_null
    //   11564: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   11567: aload 29
    //   11569: aload_2
    //   11570: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11573: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11576: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   11579: aload 29
    //   11581: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11584: aload_0
    //   11585: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11588: lsub
    //   11589: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11592: aload 29
    //   11594: aload_2
    //   11595: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11598: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11601: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   11604: aload 29
    //   11606: aload 29
    //   11608: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11611: aload_2
    //   11612: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11615: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11618: lsub
    //   11619: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   11622: aload 29
    //   11624: lload 12
    //   11626: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   11629: aload 29
    //   11631: aload_0
    //   11632: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11635: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   11638: aload 29
    //   11640: aload_0
    //   11641: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   11644: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11647: aload 29
    //   11649: aload_0
    //   11650: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11653: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11656: aload 29
    //   11658: lconst_0
    //   11659: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11662: aload 29
    //   11664: aload_0
    //   11665: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11668: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11671: aload 29
    //   11673: aload_2
    //   11674: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11677: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11680: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11683: aload 29
    //   11685: aload_0
    //   11686: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11689: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   11692: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11695: aload 29
    //   11697: aload_0
    //   11698: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11701: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11704: aload_0
    //   11705: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11708: ifnull +835 -> 12543
    //   11711: aload_0
    //   11712: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11715: ldc_w 686
    //   11718: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11721: ifeq +822 -> 12543
    //   11724: iconst_1
    //   11725: istore 10
    //   11727: aload 29
    //   11729: iload 10
    //   11731: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   11734: aload 29
    //   11736: aload_2
    //   11737: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11740: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11743: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11746: aload_2
    //   11747: aload 29
    //   11749: invokevirtual 768	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11752: aload_2
    //   11753: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11756: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11759: ifeq +11 -> 11770
    //   11762: aload_0
    //   11763: aload_1
    //   11764: aload_2
    //   11765: aload 29
    //   11767: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11770: aload_0
    //   11771: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11774: ifeq +775 -> 12549
    //   11777: aload_0
    //   11778: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   11781: ifnull +10 -> 11791
    //   11784: aload_0
    //   11785: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   11788: invokevirtual 777	com/squareup/okhttp/Call:cancel	()V
    //   11791: aload_0
    //   11792: aconst_null
    //   11793: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   11796: return
    //   11797: aconst_null
    //   11798: astore 25
    //   11800: goto -1494 -> 10306
    //   11803: astore 24
    //   11805: ldc_w 428
    //   11808: astore 24
    //   11810: goto -1470 -> 10340
    //   11813: ldc_w 944
    //   11816: astore 26
    //   11818: goto -1303 -> 10515
    //   11821: aconst_null
    //   11822: astore 26
    //   11824: goto -1189 -> 10635
    //   11827: aload_0
    //   11828: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11831: astore 26
    //   11833: goto -969 -> 10864
    //   11836: iconst_0
    //   11837: istore_3
    //   11838: goto -944 -> 10894
    //   11841: aconst_null
    //   11842: astore 26
    //   11844: goto -800 -> 11044
    //   11847: new 125	java/lang/StringBuilder
    //   11850: dup
    //   11851: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11854: ldc_w 946
    //   11857: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11860: aload_0
    //   11861: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11864: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11867: ldc_w 527
    //   11870: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11873: aload_0
    //   11874: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11877: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11880: ldc_w 532
    //   11883: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11886: astore 30
    //   11888: aload_0
    //   11889: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11892: ifeq +558 -> 12450
    //   11895: aload 23
    //   11897: ifnull +553 -> 12450
    //   11900: aload 23
    //   11902: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   11905: ifnull +545 -> 12450
    //   11908: aload 23
    //   11910: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   11913: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   11916: astore 26
    //   11918: aload 30
    //   11920: aload 26
    //   11922: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11925: ldc_w 543
    //   11928: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11931: aload 27
    //   11933: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11936: ldc_w 548
    //   11939: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11942: aload 25
    //   11944: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11947: ldc_w 550
    //   11950: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11953: aconst_null
    //   11954: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11957: ldc_w 552
    //   11960: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11963: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11966: invokevirtual 174	java/lang/Thread:getId	()J
    //   11969: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11972: ldc_w 554
    //   11975: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11978: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11981: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11984: ldc_w 556
    //   11987: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11990: aload_0
    //   11991: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   11994: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11997: ldc_w 558
    //   12000: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12003: aload_0
    //   12004: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12007: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12010: ldc_w 560
    //   12013: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12016: astore 30
    //   12018: aload_0
    //   12019: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12022: ifeq +436 -> 12458
    //   12025: aload_0
    //   12026: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12029: aload_0
    //   12030: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12033: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   12036: astore 26
    //   12038: aload 30
    //   12040: aload 26
    //   12042: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12045: ldc_w 564
    //   12048: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12051: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12054: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12057: ldc_w 576
    //   12060: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12063: aload_2
    //   12064: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12067: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12070: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12073: ldc_w 581
    //   12076: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12079: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12082: aload_0
    //   12083: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12086: lsub
    //   12087: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12090: ldc_w 583
    //   12093: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12096: aload_2
    //   12097: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12100: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12103: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12106: ldc_w 588
    //   12109: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12112: aload_2
    //   12113: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12116: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12119: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12122: ldc_w 592
    //   12125: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12128: aload_2
    //   12129: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12132: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12135: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12138: ldc_w 597
    //   12141: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12144: aload_0
    //   12145: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   12148: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12151: ldc_w 599
    //   12154: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12157: aload_0
    //   12158: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   12161: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12164: ldc_w 948
    //   12167: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12170: iload 4
    //   12172: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12175: ldc_w 611
    //   12178: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12181: aload 28
    //   12183: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12186: ldc_w 571
    //   12189: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12192: aload_2
    //   12193: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12196: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12199: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12202: ldc_w 613
    //   12205: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12208: aload 24
    //   12210: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12213: ldc_w 615
    //   12216: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12219: astore 30
    //   12221: aload_0
    //   12222: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12225: ifnull +239 -> 12464
    //   12228: aload_0
    //   12229: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12232: iconst_0
    //   12233: bipush 30
    //   12235: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   12238: astore 26
    //   12240: aload 30
    //   12242: aload 26
    //   12244: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12247: ldc_w 621
    //   12250: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12253: astore 26
    //   12255: aload_0
    //   12256: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12259: ifnull +214 -> 12473
    //   12262: aload_0
    //   12263: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12266: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12269: istore_3
    //   12270: aload 26
    //   12272: iload_3
    //   12273: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12276: ldc_w 623
    //   12279: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12282: aload_2
    //   12283: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12286: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12289: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12292: ldc_w 628
    //   12295: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12298: lload 12
    //   12300: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12303: ldc_w 630
    //   12306: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12309: aload_0
    //   12310: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12313: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12316: ldc_w 599
    //   12319: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12322: aload_0
    //   12323: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12326: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12329: ldc_w 632
    //   12332: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12335: aload_0
    //   12336: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12339: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12342: ldc_w 599
    //   12345: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12348: aload_0
    //   12349: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12352: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12355: ldc_w 634
    //   12358: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12361: aload_0
    //   12362: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   12365: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12368: ldc_w 636
    //   12371: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12374: aload_0
    //   12375: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   12378: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12381: ldc_w 641
    //   12384: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12387: aload_0
    //   12388: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   12391: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12394: ldc_w 646
    //   12397: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12400: astore 30
    //   12402: aload_0
    //   12403: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12406: ifnull +72 -> 12478
    //   12409: aload_0
    //   12410: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12413: invokeinterface 656 1 0
    //   12418: astore 26
    //   12420: aload 29
    //   12422: aload 30
    //   12424: aload 26
    //   12426: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12429: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12432: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12435: ldc_w 447
    //   12438: aload 29
    //   12440: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12443: aconst_null
    //   12444: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12447: goto -1348 -> 11099
    //   12450: ldc_w 944
    //   12453: astore 26
    //   12455: goto -537 -> 11918
    //   12458: aconst_null
    //   12459: astore 26
    //   12461: goto -423 -> 12038
    //   12464: aload_0
    //   12465: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12468: astore 26
    //   12470: goto -230 -> 12240
    //   12473: iconst_0
    //   12474: istore_3
    //   12475: goto -205 -> 12270
    //   12478: aconst_null
    //   12479: astore 26
    //   12481: goto -61 -> 12420
    //   12484: iconst_0
    //   12485: istore_3
    //   12486: goto -1307 -> 11179
    //   12489: ldc_w 428
    //   12492: astore 24
    //   12494: goto -1184 -> 11310
    //   12497: astore 24
    //   12499: ldc 219
    //   12501: ldc_w 953
    //   12504: aload 24
    //   12506: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12509: goto -1123 -> 11386
    //   12512: astore 24
    //   12514: ldc 219
    //   12516: ldc_w 955
    //   12519: aload 24
    //   12521: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12524: goto -1088 -> 11436
    //   12527: iconst_0
    //   12528: istore 10
    //   12530: goto -1044 -> 11486
    //   12533: aload 27
    //   12535: invokevirtual 958	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   12538: astore 22
    //   12540: goto -986 -> 11554
    //   12543: iconst_0
    //   12544: istore 10
    //   12546: goto -819 -> 11727
    //   12549: aload_0
    //   12550: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12553: ifnull +15 -> 12568
    //   12556: aload_0
    //   12557: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12560: invokevirtual 963	org/apache/http/client/methods/HttpGet:abort	()V
    //   12563: aload_0
    //   12564: aconst_null
    //   12565: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12568: aload_0
    //   12569: invokevirtual 966	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   12572: return
    //   12573: sipush 416
    //   12576: iload 4
    //   12578: if_icmpne +1628 -> 14206
    //   12581: aload_0
    //   12582: ldc_w 968
    //   12585: invokevirtual 971	com/tencent/component/network/downloader/impl/FastDownloadTask:removeHttpParam	(Ljava/lang/String;)V
    //   12588: aload_2
    //   12589: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12592: bipush 7
    //   12594: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   12597: iload 4
    //   12599: istore 5
    //   12601: aload_0
    //   12602: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12605: ifnull +21 -> 12626
    //   12608: aload_0
    //   12609: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12612: aload_0
    //   12613: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12616: iconst_1
    //   12617: invokeinterface 974 3 0
    //   12622: iload 4
    //   12624: istore 5
    //   12626: aload_2
    //   12627: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12630: lload 18
    //   12632: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12635: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   12638: aload_2
    //   12639: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12642: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12645: aload_0
    //   12646: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12649: lsub
    //   12650: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   12653: aload_2
    //   12654: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12657: aload_0
    //   12658: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   12661: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   12664: aload_0
    //   12665: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12668: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   12671: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   12674: astore 27
    //   12676: aload_0
    //   12677: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12680: ifnull +1568 -> 14248
    //   12683: aload_0
    //   12684: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12687: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12690: ifnull +1558 -> 14248
    //   12693: aload_0
    //   12694: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12697: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12700: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   12703: astore 25
    //   12705: aload_0
    //   12706: aload_0
    //   12707: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12710: aload 22
    //   12712: aload 23
    //   12714: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   12717: astore 28
    //   12719: aload 24
    //   12721: ifnull +4062 -> 16783
    //   12724: aload 24
    //   12726: ldc_w 492
    //   12729: invokeinterface 498 2 0
    //   12734: checkcast 282	java/lang/String
    //   12737: astore 24
    //   12739: aload_2
    //   12740: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12743: aload 24
    //   12745: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   12748: aload_0
    //   12749: lconst_0
    //   12750: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12753: aload_0
    //   12754: iconst_0
    //   12755: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12758: aload_0
    //   12759: lconst_0
    //   12760: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12763: aload_0
    //   12764: iconst_0
    //   12765: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12768: aload_2
    //   12769: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12772: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12775: ifeq +12 -> 12787
    //   12778: aload_1
    //   12779: invokeinterface 359 1 0
    //   12784: ifeq +31 -> 12815
    //   12787: aload_0
    //   12788: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12791: ifnull +24 -> 12815
    //   12794: aload_0
    //   12795: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12798: aload_0
    //   12799: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12802: aload_2
    //   12803: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   12806: aload 22
    //   12808: aload 23
    //   12810: invokeinterface 523 5 0
    //   12815: aload_1
    //   12816: invokeinterface 359 1 0
    //   12821: ifne +1352 -> 14173
    //   12824: aload_0
    //   12825: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12828: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   12831: istore 10
    //   12833: aload_2
    //   12834: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12837: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12840: ifne +1459 -> 14299
    //   12843: new 125	java/lang/StringBuilder
    //   12846: dup
    //   12847: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   12850: ldc_w 525
    //   12853: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12856: aload_0
    //   12857: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12860: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12863: ldc_w 527
    //   12866: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12869: aload_0
    //   12870: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12873: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12876: ldc_w 532
    //   12879: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12882: astore 30
    //   12884: aload_0
    //   12885: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12888: ifeq +1376 -> 14264
    //   12891: aload 23
    //   12893: ifnull +1371 -> 14264
    //   12896: aload 23
    //   12898: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   12901: ifnull +1363 -> 14264
    //   12904: aload 23
    //   12906: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   12909: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   12912: astore 26
    //   12914: aload 30
    //   12916: aload 26
    //   12918: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12921: ldc_w 543
    //   12924: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12927: aload 27
    //   12929: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12932: ldc_w 548
    //   12935: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12938: aload 25
    //   12940: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12943: ldc_w 550
    //   12946: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12949: aconst_null
    //   12950: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12953: ldc_w 552
    //   12956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12959: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12962: invokevirtual 174	java/lang/Thread:getId	()J
    //   12965: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12968: ldc_w 554
    //   12971: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12974: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12977: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12980: ldc_w 556
    //   12983: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12986: aload_0
    //   12987: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12990: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12993: ldc_w 558
    //   12996: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12999: aload_0
    //   13000: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13003: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13006: ldc_w 560
    //   13009: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13012: astore 30
    //   13014: aload_0
    //   13015: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13018: ifeq +1254 -> 14272
    //   13021: aload_0
    //   13022: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13025: aload_0
    //   13026: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13029: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   13032: astore 26
    //   13034: aload 30
    //   13036: aload 26
    //   13038: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13041: ldc_w 562
    //   13044: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13047: iload 10
    //   13049: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13052: ldc_w 564
    //   13055: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13058: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   13061: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13064: ldc_w 571
    //   13067: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13070: aload_2
    //   13071: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13074: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13077: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13080: ldc_w 576
    //   13083: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13086: aload_2
    //   13087: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13090: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13093: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13096: ldc_w 581
    //   13099: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13102: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13105: aload_0
    //   13106: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13109: lsub
    //   13110: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13113: ldc_w 583
    //   13116: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13119: aload_2
    //   13120: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13123: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13126: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13129: ldc_w 588
    //   13132: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13135: aload_2
    //   13136: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13139: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13142: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13145: ldc_w 592
    //   13148: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13151: aload_2
    //   13152: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13155: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   13158: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13161: ldc_w 597
    //   13164: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13167: aload_0
    //   13168: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   13171: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13174: ldc_w 599
    //   13177: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13180: aload_0
    //   13181: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   13184: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13187: ldc_w 604
    //   13190: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13193: aload_2
    //   13194: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13197: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   13200: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13203: ldc_w 609
    //   13206: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13209: iload 5
    //   13211: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13214: ldc_w 611
    //   13217: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13220: aload 28
    //   13222: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13225: ldc_w 613
    //   13228: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13231: aload 24
    //   13233: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13236: ldc_w 615
    //   13239: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13242: astore 30
    //   13244: aload_0
    //   13245: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13248: ifnull +1030 -> 14278
    //   13251: aload_0
    //   13252: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13255: iconst_0
    //   13256: bipush 30
    //   13258: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   13261: astore 26
    //   13263: aload 30
    //   13265: aload 26
    //   13267: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13270: ldc_w 621
    //   13273: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13276: astore 26
    //   13278: aload_0
    //   13279: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13282: ifnull +1005 -> 14287
    //   13285: aload_0
    //   13286: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13289: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13292: istore 4
    //   13294: aload 26
    //   13296: iload 4
    //   13298: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13301: ldc_w 623
    //   13304: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13307: aload_2
    //   13308: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13311: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13314: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13317: ldc_w 628
    //   13320: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13323: lload 12
    //   13325: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13328: ldc_w 630
    //   13331: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13334: aload_0
    //   13335: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13338: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13341: ldc_w 599
    //   13344: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13347: aload_0
    //   13348: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   13351: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13354: ldc_w 632
    //   13357: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13360: aload_0
    //   13361: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   13364: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13367: ldc_w 599
    //   13370: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13373: aload_0
    //   13374: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   13377: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13380: ldc_w 634
    //   13383: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13386: aload_0
    //   13387: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   13390: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13393: ldc_w 636
    //   13396: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13399: aload_0
    //   13400: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   13403: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13406: ldc_w 641
    //   13409: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13412: aload_0
    //   13413: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   13416: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13419: ldc_w 646
    //   13422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13425: astore 30
    //   13427: aload_0
    //   13428: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13431: ifnull +862 -> 14293
    //   13434: aload_0
    //   13435: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13438: invokeinterface 656 1 0
    //   13443: astore 26
    //   13445: aload 29
    //   13447: aload 30
    //   13449: aload 26
    //   13451: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13454: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13457: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13460: ldc_w 447
    //   13463: aload 29
    //   13465: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13468: aconst_null
    //   13469: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   13472: aload_0
    //   13473: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13476: ifnull +24 -> 13500
    //   13479: aload_0
    //   13480: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13483: ldc_w 439
    //   13486: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13489: ifeq +11 -> 13500
    //   13492: aload_0
    //   13493: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13496: iconst_0
    //   13497: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   13500: iload 10
    //   13502: ifne +8 -> 13510
    //   13505: aload_0
    //   13506: iconst_0
    //   13507: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   13510: aload_2
    //   13511: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13514: astore 26
    //   13516: new 125	java/lang/StringBuilder
    //   13519: dup
    //   13520: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13523: aload_0
    //   13524: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13527: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13530: ldc_w 670
    //   13533: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13536: aload 25
    //   13538: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13541: ldc_w 672
    //   13544: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13547: aload_2
    //   13548: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13551: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13554: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13557: ldc_w 674
    //   13560: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13563: astore 25
    //   13565: aload_0
    //   13566: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13569: ifnull +1370 -> 14939
    //   13572: aload_0
    //   13573: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13576: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13579: istore 4
    //   13581: aload 25
    //   13583: iload 4
    //   13585: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13588: ldc_w 609
    //   13591: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13594: iload 5
    //   13596: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13599: ldc_w 571
    //   13602: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13605: aload_2
    //   13606: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13609: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13612: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13615: ldc_w 583
    //   13618: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13621: aload_2
    //   13622: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13625: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13628: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13631: ldc_w 588
    //   13634: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13637: aload_2
    //   13638: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13641: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13644: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13647: ldc_w 576
    //   13650: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13653: aload_2
    //   13654: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13657: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13660: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13663: ldc_w 581
    //   13666: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13669: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13672: aload_0
    //   13673: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13676: lsub
    //   13677: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13680: astore 25
    //   13682: aload 24
    //   13684: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13687: ifne +1258 -> 14945
    //   13690: new 125	java/lang/StringBuilder
    //   13693: dup
    //   13694: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13697: ldc_w 613
    //   13700: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13703: aload 24
    //   13705: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13708: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13711: astore 24
    //   13713: aload 26
    //   13715: aload 25
    //   13717: aload 24
    //   13719: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13722: ldc_w 611
    //   13725: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13728: aload 28
    //   13730: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13733: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13736: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   13739: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13742: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13745: aload_0
    //   13746: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13749: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13752: if_icmpne +37 -> 13789
    //   13755: aload_0
    //   13756: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13759: ifnull +30 -> 13789
    //   13762: aload_0
    //   13763: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13766: aload_0
    //   13767: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13770: aload_0
    //   13771: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13774: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   13777: aload_2
    //   13778: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13781: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13784: invokeinterface 684 4 0
    //   13789: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13792: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13795: aload_0
    //   13796: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13799: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13802: if_icmpne +37 -> 13839
    //   13805: aload_0
    //   13806: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13809: ifnull +30 -> 13839
    //   13812: aload_0
    //   13813: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13816: aload_0
    //   13817: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13820: aload_0
    //   13821: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13824: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   13827: aload_2
    //   13828: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13831: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13834: invokeinterface 684 4 0
    //   13839: iload 10
    //   13841: ifeq +64 -> 13905
    //   13844: aload_0
    //   13845: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13848: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   13851: astore 24
    //   13853: aload_0
    //   13854: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13857: astore 25
    //   13859: aload_0
    //   13860: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   13863: ifeq +1120 -> 14983
    //   13866: aload_0
    //   13867: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13870: ifnull +1113 -> 14983
    //   13873: aload_0
    //   13874: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13877: ldc_w 686
    //   13880: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13883: ifeq +1100 -> 14983
    //   13886: iconst_1
    //   13887: istore 10
    //   13889: aload 24
    //   13891: aload 25
    //   13893: iload 10
    //   13895: aload_2
    //   13896: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13899: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13902: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   13905: aload 29
    //   13907: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   13910: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   13913: aload 29
    //   13915: aload_0
    //   13916: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   13919: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   13922: aload 29
    //   13924: aload 22
    //   13926: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   13929: aload 29
    //   13931: aload 23
    //   13933: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   13936: aload 29
    //   13938: iload 5
    //   13940: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   13943: aload 29
    //   13945: aconst_null
    //   13946: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   13949: aload 27
    //   13951: ifnonnull +1038 -> 14989
    //   13954: aconst_null
    //   13955: astore 22
    //   13957: aload 29
    //   13959: aload 22
    //   13961: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   13964: aload 29
    //   13966: aconst_null
    //   13967: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   13970: aload 29
    //   13972: aload_2
    //   13973: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13976: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13979: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   13982: aload 29
    //   13984: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13987: aload_0
    //   13988: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13991: lsub
    //   13992: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13995: aload 29
    //   13997: aload_2
    //   13998: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14001: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14004: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   14007: aload 29
    //   14009: aload 29
    //   14011: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14014: aload_2
    //   14015: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14018: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14021: lsub
    //   14022: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   14025: aload 29
    //   14027: lload 12
    //   14029: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   14032: aload 29
    //   14034: aload_0
    //   14035: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   14038: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   14041: aload 29
    //   14043: aload_0
    //   14044: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   14047: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   14050: aload 29
    //   14052: aload_0
    //   14053: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   14056: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   14059: aload 29
    //   14061: lconst_0
    //   14062: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   14065: aload 29
    //   14067: aload_0
    //   14068: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   14071: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   14074: aload 29
    //   14076: aload_2
    //   14077: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14080: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14083: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   14086: aload 29
    //   14088: aload_0
    //   14089: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14092: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   14095: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   14098: aload 29
    //   14100: aload_0
    //   14101: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14104: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   14107: aload_0
    //   14108: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14111: ifnull +888 -> 14999
    //   14114: aload_0
    //   14115: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14118: ldc_w 686
    //   14121: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14124: ifeq +875 -> 14999
    //   14127: iconst_1
    //   14128: istore 10
    //   14130: aload 29
    //   14132: iload 10
    //   14134: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   14137: aload 29
    //   14139: aload_2
    //   14140: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14143: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14146: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   14149: aload_2
    //   14150: aload 29
    //   14152: invokevirtual 768	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14155: aload_2
    //   14156: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14159: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14162: ifeq +11 -> 14173
    //   14165: aload_0
    //   14166: aload_1
    //   14167: aload_2
    //   14168: aload 29
    //   14170: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14173: aload_0
    //   14174: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14177: ifeq +828 -> 15005
    //   14180: aload_0
    //   14181: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   14184: ifnull +10 -> 14194
    //   14187: aload_0
    //   14188: getfield 772	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   14191: invokevirtual 777	com/squareup/okhttp/Call:cancel	()V
    //   14194: aload_0
    //   14195: aconst_null
    //   14196: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   14199: iload_3
    //   14200: iconst_1
    //   14201: iadd
    //   14202: istore_3
    //   14203: goto -13998 -> 205
    //   14206: aload_2
    //   14207: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14210: iconst_3
    //   14211: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14214: goto -1617 -> 12597
    //   14217: astore 25
    //   14219: aload 22
    //   14221: astore 26
    //   14223: aload 23
    //   14225: astore 22
    //   14227: aload 26
    //   14229: astore 23
    //   14231: goto -13979 -> 252
    //   14234: aload_2
    //   14235: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14238: iconst_3
    //   14239: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14242: iconst_0
    //   14243: istore 5
    //   14245: goto -1619 -> 12626
    //   14248: aconst_null
    //   14249: astore 25
    //   14251: goto -1546 -> 12705
    //   14254: astore 24
    //   14256: ldc_w 428
    //   14259: astore 24
    //   14261: goto -1522 -> 12739
    //   14264: ldc_w 944
    //   14267: astore 26
    //   14269: goto -1355 -> 12914
    //   14272: aconst_null
    //   14273: astore 26
    //   14275: goto -1241 -> 13034
    //   14278: aload_0
    //   14279: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14282: astore 26
    //   14284: goto -1021 -> 13263
    //   14287: iconst_0
    //   14288: istore 4
    //   14290: goto -996 -> 13294
    //   14293: aconst_null
    //   14294: astore 26
    //   14296: goto -851 -> 13445
    //   14299: new 125	java/lang/StringBuilder
    //   14302: dup
    //   14303: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   14306: ldc_w 946
    //   14309: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14312: aload_0
    //   14313: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   14316: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14319: ldc_w 527
    //   14322: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14325: aload_0
    //   14326: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14329: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14332: ldc_w 532
    //   14335: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14338: astore 30
    //   14340: aload_0
    //   14341: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14344: ifeq +560 -> 14904
    //   14347: aload 23
    //   14349: ifnull +555 -> 14904
    //   14352: aload 23
    //   14354: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   14357: ifnull +547 -> 14904
    //   14360: aload 23
    //   14362: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   14365: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   14368: astore 26
    //   14370: aload 30
    //   14372: aload 26
    //   14374: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14377: ldc_w 543
    //   14380: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14383: aload 27
    //   14385: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14388: ldc_w 548
    //   14391: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14394: aload 25
    //   14396: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14399: ldc_w 550
    //   14402: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14405: aconst_null
    //   14406: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14409: ldc_w 552
    //   14412: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14415: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14418: invokevirtual 174	java/lang/Thread:getId	()J
    //   14421: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14424: ldc_w 554
    //   14427: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14430: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   14433: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14436: ldc_w 556
    //   14439: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14442: aload_0
    //   14443: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14446: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14449: ldc_w 558
    //   14452: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14455: aload_0
    //   14456: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14459: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14462: ldc_w 560
    //   14465: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14468: astore 30
    //   14470: aload_0
    //   14471: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14474: ifeq +438 -> 14912
    //   14477: aload_0
    //   14478: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   14481: aload_0
    //   14482: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14485: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   14488: astore 26
    //   14490: aload 30
    //   14492: aload 26
    //   14494: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14497: ldc_w 564
    //   14500: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14503: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   14506: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14509: ldc_w 576
    //   14512: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14515: aload_2
    //   14516: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14519: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14522: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14525: ldc_w 581
    //   14528: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14531: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14534: aload_0
    //   14535: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14538: lsub
    //   14539: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14542: ldc_w 583
    //   14545: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14548: aload_2
    //   14549: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14552: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   14555: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14558: ldc_w 588
    //   14561: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14564: aload_2
    //   14565: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14568: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   14571: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14574: ldc_w 592
    //   14577: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14580: aload_2
    //   14581: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14584: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   14587: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14590: ldc_w 597
    //   14593: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14596: aload_0
    //   14597: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   14600: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14603: ldc_w 599
    //   14606: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14609: aload_0
    //   14610: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   14613: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14616: ldc_w 948
    //   14619: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14622: iload 5
    //   14624: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14627: ldc_w 611
    //   14630: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14633: aload 28
    //   14635: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14638: ldc_w 571
    //   14641: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14644: aload_2
    //   14645: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14648: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14651: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14654: ldc_w 613
    //   14657: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14660: aload 24
    //   14662: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14665: ldc_w 615
    //   14668: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14671: astore 30
    //   14673: aload_0
    //   14674: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14677: ifnull +241 -> 14918
    //   14680: aload_0
    //   14681: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14684: iconst_0
    //   14685: bipush 30
    //   14687: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   14690: astore 26
    //   14692: aload 30
    //   14694: aload 26
    //   14696: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14699: ldc_w 621
    //   14702: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14705: astore 26
    //   14707: aload_0
    //   14708: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14711: ifnull +216 -> 14927
    //   14714: aload_0
    //   14715: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14718: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14721: istore 4
    //   14723: aload 26
    //   14725: iload 4
    //   14727: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14730: ldc_w 623
    //   14733: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14736: aload_2
    //   14737: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14740: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14743: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14746: ldc_w 628
    //   14749: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14752: lload 12
    //   14754: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14757: ldc_w 630
    //   14760: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14763: aload_0
    //   14764: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   14767: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14770: ldc_w 599
    //   14773: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14776: aload_0
    //   14777: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   14780: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14783: ldc_w 632
    //   14786: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14789: aload_0
    //   14790: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   14793: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14796: ldc_w 599
    //   14799: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14802: aload_0
    //   14803: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   14806: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14809: ldc_w 634
    //   14812: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14815: aload_0
    //   14816: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   14819: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14822: ldc_w 636
    //   14825: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14828: aload_0
    //   14829: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   14832: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14835: ldc_w 641
    //   14838: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14841: aload_0
    //   14842: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   14845: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14848: ldc_w 646
    //   14851: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14854: astore 30
    //   14856: aload_0
    //   14857: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14860: ifnull +73 -> 14933
    //   14863: aload_0
    //   14864: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14867: invokeinterface 656 1 0
    //   14872: astore 26
    //   14874: aload 29
    //   14876: aload 30
    //   14878: aload 26
    //   14880: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14883: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14886: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   14889: ldc_w 447
    //   14892: aload 29
    //   14894: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   14897: aconst_null
    //   14898: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14901: goto -1401 -> 13500
    //   14904: ldc_w 944
    //   14907: astore 26
    //   14909: goto -539 -> 14370
    //   14912: aconst_null
    //   14913: astore 26
    //   14915: goto -425 -> 14490
    //   14918: aload_0
    //   14919: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14922: astore 26
    //   14924: goto -232 -> 14692
    //   14927: iconst_0
    //   14928: istore 4
    //   14930: goto -207 -> 14723
    //   14933: aconst_null
    //   14934: astore 26
    //   14936: goto -62 -> 14874
    //   14939: iconst_0
    //   14940: istore 4
    //   14942: goto -1361 -> 13581
    //   14945: ldc_w 428
    //   14948: astore 24
    //   14950: goto -1237 -> 13713
    //   14953: astore 24
    //   14955: ldc 219
    //   14957: ldc_w 953
    //   14960: aload 24
    //   14962: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14965: goto -1176 -> 13789
    //   14968: astore 24
    //   14970: ldc 219
    //   14972: ldc_w 955
    //   14975: aload 24
    //   14977: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14980: goto -1141 -> 13839
    //   14983: iconst_0
    //   14984: istore 10
    //   14986: goto -1097 -> 13889
    //   14989: aload 27
    //   14991: invokevirtual 958	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   14994: astore 22
    //   14996: goto -1039 -> 13957
    //   14999: iconst_0
    //   15000: istore 10
    //   15002: goto -872 -> 14130
    //   15005: aload_0
    //   15006: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15009: ifnull +15 -> 15024
    //   15012: aload_0
    //   15013: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15016: invokevirtual 963	org/apache/http/client/methods/HttpGet:abort	()V
    //   15019: aload_0
    //   15020: aconst_null
    //   15021: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15024: aload_0
    //   15025: invokevirtual 966	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   15028: goto -829 -> 14199
    //   15031: aconst_null
    //   15032: astore 26
    //   15034: goto -14623 -> 411
    //   15037: astore 24
    //   15039: ldc_w 428
    //   15042: astore 24
    //   15044: goto -14599 -> 445
    //   15047: ldc_w 944
    //   15050: astore 27
    //   15052: goto -14432 -> 620
    //   15055: aconst_null
    //   15056: astore 27
    //   15058: goto -14318 -> 740
    //   15061: aload_0
    //   15062: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15065: astore 27
    //   15067: goto -14098 -> 969
    //   15070: iconst_0
    //   15071: istore_3
    //   15072: goto -14073 -> 999
    //   15075: aconst_null
    //   15076: astore 27
    //   15078: goto -13929 -> 1149
    //   15081: new 125	java/lang/StringBuilder
    //   15084: dup
    //   15085: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   15088: ldc_w 946
    //   15091: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15094: aload_0
    //   15095: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   15098: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15101: ldc_w 527
    //   15104: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15107: aload_0
    //   15108: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15111: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15114: ldc_w 532
    //   15117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15120: astore 31
    //   15122: aload_0
    //   15123: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15126: ifeq +558 -> 15684
    //   15129: aload 22
    //   15131: ifnull +553 -> 15684
    //   15134: aload 22
    //   15136: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   15139: ifnull +545 -> 15684
    //   15142: aload 22
    //   15144: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   15147: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   15150: astore 27
    //   15152: aload 31
    //   15154: aload 27
    //   15156: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15159: ldc_w 543
    //   15162: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15165: aload 28
    //   15167: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15170: ldc_w 548
    //   15173: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15176: aload 26
    //   15178: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15181: ldc_w 550
    //   15184: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15187: aconst_null
    //   15188: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15191: ldc_w 552
    //   15194: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15197: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15200: invokevirtual 174	java/lang/Thread:getId	()J
    //   15203: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15206: ldc_w 554
    //   15209: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15212: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   15215: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15218: ldc_w 556
    //   15221: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15224: aload_0
    //   15225: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15228: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15231: ldc_w 558
    //   15234: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15237: aload_0
    //   15238: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15241: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15244: ldc_w 560
    //   15247: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15250: astore 31
    //   15252: aload_0
    //   15253: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15256: ifeq +436 -> 15692
    //   15259: aload_0
    //   15260: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15263: aload_0
    //   15264: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15267: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   15270: astore 27
    //   15272: aload 31
    //   15274: aload 27
    //   15276: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15279: ldc_w 564
    //   15282: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15285: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   15288: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15291: ldc_w 576
    //   15294: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15297: aload_2
    //   15298: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15301: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   15304: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15307: ldc_w 581
    //   15310: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15313: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   15316: aload_0
    //   15317: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   15320: lsub
    //   15321: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15324: ldc_w 583
    //   15327: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15330: aload_2
    //   15331: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15334: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   15337: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15340: ldc_w 588
    //   15343: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15346: aload_2
    //   15347: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15350: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   15353: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15356: ldc_w 592
    //   15359: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15362: aload_2
    //   15363: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15366: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   15369: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15372: ldc_w 597
    //   15375: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15378: aload_0
    //   15379: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   15382: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15385: ldc_w 599
    //   15388: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15391: aload_0
    //   15392: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   15395: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15398: ldc_w 948
    //   15401: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15404: iload 4
    //   15406: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15409: ldc_w 611
    //   15412: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15415: aload 30
    //   15417: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15420: ldc_w 571
    //   15423: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15426: aload_2
    //   15427: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15430: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   15433: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15436: ldc_w 613
    //   15439: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15442: aload 24
    //   15444: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15447: ldc_w 615
    //   15450: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15453: astore 31
    //   15455: aload_0
    //   15456: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15459: ifnull +239 -> 15698
    //   15462: aload_0
    //   15463: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15466: iconst_0
    //   15467: bipush 30
    //   15469: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   15472: astore 27
    //   15474: aload 31
    //   15476: aload 27
    //   15478: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15481: ldc_w 621
    //   15484: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15487: astore 27
    //   15489: aload_0
    //   15490: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15493: ifnull +214 -> 15707
    //   15496: aload_0
    //   15497: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15500: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   15503: istore_3
    //   15504: aload 27
    //   15506: iload_3
    //   15507: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15510: ldc_w 623
    //   15513: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15516: aload_2
    //   15517: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15520: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   15523: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15526: ldc_w 628
    //   15529: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15532: lload 12
    //   15534: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15537: ldc_w 630
    //   15540: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15543: aload_0
    //   15544: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   15547: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15550: ldc_w 599
    //   15553: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15556: aload_0
    //   15557: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   15560: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15563: ldc_w 632
    //   15566: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15569: aload_0
    //   15570: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   15573: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15576: ldc_w 599
    //   15579: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15582: aload_0
    //   15583: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   15586: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15589: ldc_w 634
    //   15592: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15595: aload_0
    //   15596: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   15599: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15602: ldc_w 636
    //   15605: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15608: aload_0
    //   15609: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   15612: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15615: ldc_w 641
    //   15618: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15621: aload_0
    //   15622: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   15625: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15628: ldc_w 646
    //   15631: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15634: astore 31
    //   15636: aload_0
    //   15637: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15640: ifnull +72 -> 15712
    //   15643: aload_0
    //   15644: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15647: invokeinterface 656 1 0
    //   15652: astore 27
    //   15654: aload 29
    //   15656: aload 31
    //   15658: aload 27
    //   15660: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15663: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15666: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15669: ldc_w 447
    //   15672: aload 29
    //   15674: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15677: aconst_null
    //   15678: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15681: goto -14476 -> 1205
    //   15684: ldc_w 944
    //   15687: astore 27
    //   15689: goto -537 -> 15152
    //   15692: aconst_null
    //   15693: astore 27
    //   15695: goto -423 -> 15272
    //   15698: aload_0
    //   15699: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15702: astore 27
    //   15704: goto -230 -> 15474
    //   15707: iconst_0
    //   15708: istore_3
    //   15709: goto -205 -> 15504
    //   15712: aconst_null
    //   15713: astore 27
    //   15715: goto -61 -> 15654
    //   15718: iconst_0
    //   15719: istore_3
    //   15720: goto -14435 -> 1285
    //   15723: ldc_w 428
    //   15726: astore 24
    //   15728: goto -14312 -> 1416
    //   15731: astore 24
    //   15733: ldc 219
    //   15735: ldc_w 953
    //   15738: aload 24
    //   15740: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15743: goto -14251 -> 1492
    //   15746: astore 24
    //   15748: ldc 219
    //   15750: ldc_w 955
    //   15753: aload 24
    //   15755: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15758: goto -14216 -> 1542
    //   15761: iconst_0
    //   15762: istore 10
    //   15764: goto -14172 -> 1592
    //   15767: aload 28
    //   15769: invokevirtual 958	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   15772: astore 22
    //   15774: goto -14113 -> 1661
    //   15777: iconst_0
    //   15778: istore 10
    //   15780: goto -13946 -> 1834
    //   15783: aload_0
    //   15784: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15787: ifnull +15 -> 15802
    //   15790: aload_0
    //   15791: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15794: invokevirtual 963	org/apache/http/client/methods/HttpGet:abort	()V
    //   15797: aload_0
    //   15798: aconst_null
    //   15799: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15802: aload_0
    //   15803: invokevirtual 966	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   15806: goto -13903 -> 1903
    //   15809: aconst_null
    //   15810: astore 27
    //   15812: goto -10902 -> 4910
    //   15815: astore 24
    //   15817: ldc_w 428
    //   15820: astore 24
    //   15822: goto -10878 -> 4944
    //   15825: ldc_w 944
    //   15828: astore 28
    //   15830: goto -10711 -> 5119
    //   15833: aconst_null
    //   15834: astore 28
    //   15836: goto -10597 -> 5239
    //   15839: aload_0
    //   15840: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15843: astore 28
    //   15845: goto -10377 -> 5468
    //   15848: iconst_0
    //   15849: istore_3
    //   15850: goto -10352 -> 5498
    //   15853: aconst_null
    //   15854: astore 28
    //   15856: goto -10208 -> 5648
    //   15859: new 125	java/lang/StringBuilder
    //   15862: dup
    //   15863: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   15866: ldc_w 946
    //   15869: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15872: aload_0
    //   15873: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   15876: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15879: ldc_w 527
    //   15882: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15885: aload_0
    //   15886: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15889: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15892: ldc_w 532
    //   15895: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15898: astore 32
    //   15900: aload_0
    //   15901: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15904: ifeq +558 -> 16462
    //   15907: aload 25
    //   15909: ifnull +553 -> 16462
    //   15912: aload 25
    //   15914: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   15917: ifnull +545 -> 16462
    //   15920: aload 25
    //   15922: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   15925: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   15928: astore 28
    //   15930: aload 32
    //   15932: aload 28
    //   15934: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15937: ldc_w 543
    //   15940: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15943: aload 30
    //   15945: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15948: ldc_w 548
    //   15951: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15954: aload 27
    //   15956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15959: ldc_w 550
    //   15962: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15965: aconst_null
    //   15966: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15969: ldc_w 552
    //   15972: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15975: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15978: invokevirtual 174	java/lang/Thread:getId	()J
    //   15981: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15984: ldc_w 554
    //   15987: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15990: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   15993: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15996: ldc_w 556
    //   15999: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16002: aload_0
    //   16003: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16006: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16009: ldc_w 558
    //   16012: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16015: aload_0
    //   16016: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16019: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16022: ldc_w 560
    //   16025: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16028: astore 32
    //   16030: aload_0
    //   16031: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16034: ifeq +436 -> 16470
    //   16037: aload_0
    //   16038: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   16041: aload_0
    //   16042: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16045: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   16048: astore 28
    //   16050: aload 32
    //   16052: aload 28
    //   16054: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16057: ldc_w 564
    //   16060: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16063: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   16066: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16069: ldc_w 576
    //   16072: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16075: aload_2
    //   16076: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   16079: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   16082: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16085: ldc_w 581
    //   16088: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16091: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   16094: aload_0
    //   16095: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   16098: lsub
    //   16099: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16102: ldc_w 583
    //   16105: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16108: aload_2
    //   16109: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16112: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   16115: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16118: ldc_w 588
    //   16121: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16124: aload_2
    //   16125: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16128: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   16131: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16134: ldc_w 592
    //   16137: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16140: aload_2
    //   16141: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16144: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   16147: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16150: ldc_w 597
    //   16153: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16156: aload_0
    //   16157: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   16160: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16163: ldc_w 599
    //   16166: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16169: aload_0
    //   16170: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   16173: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16176: ldc_w 948
    //   16179: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16182: iload 4
    //   16184: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16187: ldc_w 611
    //   16190: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16193: aload 31
    //   16195: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16198: ldc_w 571
    //   16201: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16204: aload_2
    //   16205: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16208: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   16211: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16214: ldc_w 613
    //   16217: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16220: aload 24
    //   16222: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16225: ldc_w 615
    //   16228: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16231: astore 32
    //   16233: aload_0
    //   16234: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16237: ifnull +239 -> 16476
    //   16240: aload_0
    //   16241: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16244: iconst_0
    //   16245: bipush 30
    //   16247: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   16250: astore 28
    //   16252: aload 32
    //   16254: aload 28
    //   16256: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16259: ldc_w 621
    //   16262: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16265: astore 28
    //   16267: aload_0
    //   16268: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16271: ifnull +214 -> 16485
    //   16274: aload_0
    //   16275: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16278: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   16281: istore_3
    //   16282: aload 28
    //   16284: iload_3
    //   16285: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16288: ldc_w 623
    //   16291: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16294: aload_2
    //   16295: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16298: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   16301: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16304: ldc_w 628
    //   16307: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16310: lload 12
    //   16312: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16315: ldc_w 630
    //   16318: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16321: aload_0
    //   16322: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   16325: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16328: ldc_w 599
    //   16331: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16334: aload_0
    //   16335: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   16338: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16341: ldc_w 632
    //   16344: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16347: aload_0
    //   16348: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   16351: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16354: ldc_w 599
    //   16357: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16360: aload_0
    //   16361: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   16364: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16367: ldc_w 634
    //   16370: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16373: aload_0
    //   16374: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   16377: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16380: ldc_w 636
    //   16383: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16386: aload_0
    //   16387: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   16390: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16393: ldc_w 641
    //   16396: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16399: aload_0
    //   16400: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   16403: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16406: ldc_w 646
    //   16409: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16412: astore 32
    //   16414: aload_0
    //   16415: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16418: ifnull +72 -> 16490
    //   16421: aload_0
    //   16422: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16425: invokeinterface 656 1 0
    //   16430: astore 28
    //   16432: aload 29
    //   16434: aload 32
    //   16436: aload 28
    //   16438: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16441: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16444: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16447: ldc_w 447
    //   16450: aload 29
    //   16452: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16455: aconst_null
    //   16456: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16459: goto -10755 -> 5704
    //   16462: ldc_w 944
    //   16465: astore 28
    //   16467: goto -537 -> 15930
    //   16470: aconst_null
    //   16471: astore 28
    //   16473: goto -423 -> 16050
    //   16476: aload_0
    //   16477: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16480: astore 28
    //   16482: goto -230 -> 16252
    //   16485: iconst_0
    //   16486: istore_3
    //   16487: goto -205 -> 16282
    //   16490: aconst_null
    //   16491: astore 28
    //   16493: goto -61 -> 16432
    //   16496: iconst_0
    //   16497: istore_3
    //   16498: goto -10714 -> 5784
    //   16501: ldc_w 428
    //   16504: astore 24
    //   16506: goto -10591 -> 5915
    //   16509: astore 24
    //   16511: ldc 219
    //   16513: ldc_w 953
    //   16516: aload 24
    //   16518: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16521: goto -10530 -> 5991
    //   16524: astore 24
    //   16526: ldc 219
    //   16528: ldc_w 955
    //   16531: aload 24
    //   16533: invokestatic 951	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16536: goto -10495 -> 6041
    //   16539: iconst_0
    //   16540: istore 10
    //   16542: goto -10451 -> 6091
    //   16545: aload 30
    //   16547: invokevirtual 958	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   16550: astore 23
    //   16552: goto -10392 -> 6160
    //   16555: iconst_0
    //   16556: istore 10
    //   16558: goto -10225 -> 6333
    //   16561: aload_0
    //   16562: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16565: ifnull +15 -> 16580
    //   16568: aload_0
    //   16569: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16572: invokevirtual 963	org/apache/http/client/methods/HttpGet:abort	()V
    //   16575: aload_0
    //   16576: aconst_null
    //   16577: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16580: aload_0
    //   16581: invokevirtual 966	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   16584: goto -10182 -> 6402
    //   16587: astore 23
    //   16589: aconst_null
    //   16590: astore 27
    //   16592: aload 22
    //   16594: astore 24
    //   16596: aload 23
    //   16598: astore 22
    //   16600: aload 27
    //   16602: astore 23
    //   16604: iload 7
    //   16606: istore 4
    //   16608: goto -11777 -> 4831
    //   16611: astore 25
    //   16613: aconst_null
    //   16614: astore 28
    //   16616: aload 22
    //   16618: astore 26
    //   16620: aload 23
    //   16622: astore 27
    //   16624: aload 25
    //   16626: astore 22
    //   16628: aload 28
    //   16630: astore 23
    //   16632: iload 7
    //   16634: istore 4
    //   16636: aload 27
    //   16638: astore 25
    //   16640: goto -11809 -> 4831
    //   16643: astore 25
    //   16645: aconst_null
    //   16646: astore 28
    //   16648: aload 22
    //   16650: astore 26
    //   16652: aload 23
    //   16654: astore 27
    //   16656: aload 25
    //   16658: astore 22
    //   16660: aload 28
    //   16662: astore 23
    //   16664: aload 27
    //   16666: astore 25
    //   16668: goto -11837 -> 4831
    //   16671: astore 25
    //   16673: aload 23
    //   16675: astore 26
    //   16677: aload 22
    //   16679: astore 27
    //   16681: aconst_null
    //   16682: astore 23
    //   16684: aload 25
    //   16686: astore 22
    //   16688: aload 27
    //   16690: astore 25
    //   16692: goto -11861 -> 4831
    //   16695: astore 28
    //   16697: aload 23
    //   16699: astore 26
    //   16701: aload 22
    //   16703: astore 27
    //   16705: aload 25
    //   16707: astore 23
    //   16709: aload 28
    //   16711: astore 22
    //   16713: iload 5
    //   16715: istore_3
    //   16716: aload 27
    //   16718: astore 25
    //   16720: goto -11889 -> 4831
    //   16723: astore 25
    //   16725: aconst_null
    //   16726: astore 26
    //   16728: aload 22
    //   16730: astore 24
    //   16732: aconst_null
    //   16733: astore 23
    //   16735: aload 26
    //   16737: astore 22
    //   16739: iload 8
    //   16741: istore 4
    //   16743: goto -16491 -> 252
    //   16746: astore 25
    //   16748: aload 22
    //   16750: astore 26
    //   16752: aload 23
    //   16754: astore 22
    //   16756: iload 8
    //   16758: istore 4
    //   16760: aload 26
    //   16762: astore 23
    //   16764: goto -16512 -> 252
    //   16767: ldc_w 428
    //   16770: astore 24
    //   16772: goto -11828 -> 4944
    //   16775: ldc_w 428
    //   16778: astore 24
    //   16780: goto -16335 -> 445
    //   16783: ldc_w 428
    //   16786: astore 24
    //   16788: goto -4049 -> 12739
    //   16791: ldc_w 428
    //   16794: astore 24
    //   16796: goto -6456 -> 10340
    //   16799: ldc_w 428
    //   16802: astore 24
    //   16804: goto -8810 -> 7994
    //   16807: ldc_w 428
    //   16810: astore 24
    //   16812: goto -13671 -> 3141
    //   16815: iconst_0
    //   16816: istore 4
    //   16818: goto -13882 -> 2936
    //   16821: aconst_null
    //   16822: astore 23
    //   16824: aconst_null
    //   16825: astore 22
    //   16827: aconst_null
    //   16828: astore 24
    //   16830: goto -13943 -> 2887
    //   16833: iconst_1
    //   16834: istore 5
    //   16836: goto -14739 -> 2097
    //   16839: aload 28
    //   16841: astore 23
    //   16843: iload 4
    //   16845: iconst_2
    //   16846: if_icmpge -12203 -> 4643
    //   16849: aload 28
    //   16851: astore 23
    //   16853: iload 10
    //   16855: ifeq -12212 -> 4643
    //   16858: ldc_w 914
    //   16861: astore 23
    //   16863: goto -12220 -> 4643
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	16866	0	this	FastDownloadTask
    //   0	16866	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	16866	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   29	16687	3	i	int
    //   246	16601	4	j	int
    //   263	16572	5	k	int
    //   275	6526	6	m	int
    //   177	16456	7	n	int
    //   180	16577	8	i1	int
    //   18	109	9	i2	int
    //   198	16656	10	bool1	boolean
    //   23	61	11	bool2	boolean
    //   26	16285	12	l1	long
    //   224	6836	14	l2	long
    //   228	6836	16	l3	long
    //   113	12518	18	l4	long
    //   188	2704	20	l5	long
    //   97	1	22	localException1	java.lang.Exception
    //   183	1	22	localObject1	Object
    //   215	16	22	localUnknownHostException	java.net.UnknownHostException
    //   236	4578	22	localObject2	Object
    //   4818	1585	22	localObject3	Object
    //   6434	10392	22	localObject4	Object
    //   242	16309	23	localObject5	Object
    //   16587	10	23	localObject6	Object
    //   16602	260	23	localObject7	Object
    //   166	6913	24	localObject8	Object
    //   7104	1	24	localException2	java.lang.Exception
    //   7109	690	24	str1	String
    //   7803	8	24	localException3	java.lang.Exception
    //   7818	162	24	localException4	java.lang.Exception
    //   7992	1149	24	localObject9	Object
    //   9457	1	24	localException5	java.lang.Exception
    //   9462	685	24	str2	String
    //   10151	8	24	localException6	java.lang.Exception
    //   10166	160	24	localException7	java.lang.Exception
    //   10338	1149	24	localObject10	Object
    //   11803	1	24	localException8	java.lang.Exception
    //   11808	685	24	str3	String
    //   12497	8	24	localException9	java.lang.Exception
    //   12512	213	24	localException10	java.lang.Exception
    //   12737	1153	24	localObject11	Object
    //   14254	1	24	localException11	java.lang.Exception
    //   14259	690	24	str4	String
    //   14953	8	24	localException12	java.lang.Exception
    //   14968	8	24	localException13	java.lang.Exception
    //   15037	1	24	localException14	java.lang.Exception
    //   15042	685	24	str5	String
    //   15731	8	24	localException15	java.lang.Exception
    //   15746	8	24	localException16	java.lang.Exception
    //   15815	1	24	localException17	java.lang.Exception
    //   15820	685	24	str6	String
    //   16509	8	24	localException18	java.lang.Exception
    //   16524	8	24	localException19	java.lang.Exception
    //   16594	235	24	localObject12	Object
    //   174	1	25	localObject13	Object
    //   233	1416	25	localThrowable1	java.lang.Throwable
    //   2873	11019	25	localObject14	Object
    //   14217	1	25	localThrowable2	java.lang.Throwable
    //   14249	1672	25	str7	String
    //   16611	14	25	localObject15	Object
    //   16638	1	25	localObject16	Object
    //   16643	14	25	localObject17	Object
    //   16666	1	25	localObject18	Object
    //   16671	14	25	localObject19	Object
    //   16690	29	25	localObject20	Object
    //   16723	1	25	localThrowable3	java.lang.Throwable
    //   16746	1	25	localThrowable4	java.lang.Throwable
    //   163	16598	26	localObject21	Object
    //   618	16099	27	localObject22	Object
    //   380	16281	28	localObject23	Object
    //   16695	155	28	localObject24	Object
    //   122	16329	29	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   423	16123	30	localObject25	Object
    //   588	15606	31	localObject26	Object
    //   5087	11348	32	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	83	97	java/lang/Exception
    //   190	200	215	java/net/UnknownHostException
    //   230	233	233	java/lang/Throwable
    //   1919	1930	233	java/lang/Throwable
    //   1938	1947	233	java/lang/Throwable
    //   1955	1964	233	java/lang/Throwable
    //   1972	1979	233	java/lang/Throwable
    //   1987	1998	233	java/lang/Throwable
    //   2006	2013	233	java/lang/Throwable
    //   2021	2027	233	java/lang/Throwable
    //   2035	2044	233	java/lang/Throwable
    //   2052	2064	233	java/lang/Throwable
    //   2072	2079	233	java/lang/Throwable
    //   2087	2094	233	java/lang/Throwable
    //   2105	2111	233	java/lang/Throwable
    //   2119	2127	233	java/lang/Throwable
    //   2135	2148	233	java/lang/Throwable
    //   2156	2163	233	java/lang/Throwable
    //   2171	2178	233	java/lang/Throwable
    //   2186	2196	233	java/lang/Throwable
    //   2204	2220	233	java/lang/Throwable
    //   2228	2240	233	java/lang/Throwable
    //   2248	2254	233	java/lang/Throwable
    //   2262	2271	233	java/lang/Throwable
    //   2294	2300	233	java/lang/Throwable
    //   2313	2325	233	java/lang/Throwable
    //   2337	2345	233	java/lang/Throwable
    //   2357	2385	233	java/lang/Throwable
    //   2397	2404	233	java/lang/Throwable
    //   2412	2429	233	java/lang/Throwable
    //   2441	2453	233	java/lang/Throwable
    //   2461	2467	233	java/lang/Throwable
    //   2475	2541	233	java/lang/Throwable
    //   2549	2556	233	java/lang/Throwable
    //   2564	2576	233	java/lang/Throwable
    //   2584	2596	233	java/lang/Throwable
    //   2604	2611	233	java/lang/Throwable
    //   2624	2651	233	java/lang/Throwable
    //   2659	2666	233	java/lang/Throwable
    //   2674	2699	233	java/lang/Throwable
    //   2707	2727	233	java/lang/Throwable
    //   2735	2757	233	java/lang/Throwable
    //   2765	2773	233	java/lang/Throwable
    //   2781	2786	233	java/lang/Throwable
    //   2794	2799	233	java/lang/Throwable
    //   2807	2814	233	java/lang/Throwable
    //   2822	2829	233	java/lang/Throwable
    //   2837	2844	233	java/lang/Throwable
    //   2852	2857	233	java/lang/Throwable
    //   4628	4640	233	java/lang/Throwable
    //   4651	4662	233	java/lang/Throwable
    //   4670	4676	233	java/lang/Throwable
    //   4689	4701	233	java/lang/Throwable
    //   4713	4721	233	java/lang/Throwable
    //   4733	4767	233	java/lang/Throwable
    //   4779	4786	233	java/lang/Throwable
    //   4794	4811	233	java/lang/Throwable
    //   6413	6425	233	java/lang/Throwable
    //   6440	6447	233	java/lang/Throwable
    //   6459	6475	233	java/lang/Throwable
    //   6483	6489	233	java/lang/Throwable
    //   6502	6514	233	java/lang/Throwable
    //   6526	6534	233	java/lang/Throwable
    //   6546	6574	233	java/lang/Throwable
    //   6586	6593	233	java/lang/Throwable
    //   6601	6618	233	java/lang/Throwable
    //   6633	6645	233	java/lang/Throwable
    //   6656	6669	233	java/lang/Throwable
    //   6687	6704	233	java/lang/Throwable
    //   6712	6718	233	java/lang/Throwable
    //   6731	6743	233	java/lang/Throwable
    //   6755	6763	233	java/lang/Throwable
    //   6775	6810	233	java/lang/Throwable
    //   6818	6825	233	java/lang/Throwable
    //   6833	6850	233	java/lang/Throwable
    //   6858	6870	233	java/lang/Throwable
    //   6878	6884	233	java/lang/Throwable
    //   6892	6948	233	java/lang/Throwable
    //   6959	6971	233	java/lang/Throwable
    //   6982	7011	233	java/lang/Throwable
    //   7022	7029	233	java/lang/Throwable
    //   7037	7057	233	java/lang/Throwable
    //   7065	7074	233	java/lang/Throwable
    //   230	233	4818	finally
    //   1919	1930	4818	finally
    //   1938	1947	4818	finally
    //   1955	1964	4818	finally
    //   1972	1979	4818	finally
    //   1987	1998	4818	finally
    //   2006	2013	4818	finally
    //   2021	2027	4818	finally
    //   2035	2044	4818	finally
    //   2052	2064	4818	finally
    //   2072	2079	4818	finally
    //   2087	2094	4818	finally
    //   2105	2111	4818	finally
    //   2119	2127	4818	finally
    //   2135	2148	4818	finally
    //   2156	2163	4818	finally
    //   2171	2178	4818	finally
    //   2186	2196	4818	finally
    //   2204	2220	4818	finally
    //   2228	2240	4818	finally
    //   2248	2254	4818	finally
    //   2262	2271	4818	finally
    //   2294	2300	4818	finally
    //   2313	2325	4818	finally
    //   2337	2345	4818	finally
    //   2357	2385	4818	finally
    //   2397	2404	4818	finally
    //   2412	2429	4818	finally
    //   2441	2453	4818	finally
    //   2461	2467	4818	finally
    //   2475	2541	4818	finally
    //   2549	2556	4818	finally
    //   2564	2576	4818	finally
    //   2584	2596	4818	finally
    //   2604	2611	4818	finally
    //   2624	2651	4818	finally
    //   2659	2666	4818	finally
    //   2674	2699	4818	finally
    //   2707	2727	4818	finally
    //   2735	2757	4818	finally
    //   2765	2773	4818	finally
    //   2781	2786	4818	finally
    //   2794	2799	4818	finally
    //   2807	2814	4818	finally
    //   2822	2829	4818	finally
    //   2837	2844	4818	finally
    //   2852	2857	4818	finally
    //   4628	4640	4818	finally
    //   4651	4662	4818	finally
    //   4670	4676	4818	finally
    //   4689	4701	4818	finally
    //   4713	4721	4818	finally
    //   4733	4767	4818	finally
    //   4779	4786	4818	finally
    //   4794	4811	4818	finally
    //   6413	6425	4818	finally
    //   6440	6447	4818	finally
    //   6459	6475	4818	finally
    //   6483	6489	4818	finally
    //   6502	6514	4818	finally
    //   6526	6534	4818	finally
    //   6546	6574	4818	finally
    //   6586	6593	4818	finally
    //   6601	6618	4818	finally
    //   6633	6645	4818	finally
    //   6656	6669	4818	finally
    //   6687	6704	4818	finally
    //   6712	6718	4818	finally
    //   6731	6743	4818	finally
    //   6755	6763	4818	finally
    //   6775	6810	4818	finally
    //   6818	6825	4818	finally
    //   6833	6850	4818	finally
    //   6858	6870	4818	finally
    //   6878	6884	4818	finally
    //   6892	6948	4818	finally
    //   6959	6971	4818	finally
    //   6982	7011	4818	finally
    //   7022	7029	4818	finally
    //   7037	7057	4818	finally
    //   7065	7074	4818	finally
    //   3126	3141	7104	java/lang/Exception
    //   4164	4191	7803	java/lang/Exception
    //   4214	4241	7818	java/lang/Exception
    //   7979	7994	9457	java/lang/Exception
    //   9013	9040	10151	java/lang/Exception
    //   9063	9090	10166	java/lang/Exception
    //   10325	10340	11803	java/lang/Exception
    //   11359	11386	12497	java/lang/Exception
    //   11409	11436	12512	java/lang/Exception
    //   2936	2945	14217	java/lang/Throwable
    //   2965	3023	14217	java/lang/Throwable
    //   12581	12597	14217	java/lang/Throwable
    //   12601	12622	14217	java/lang/Throwable
    //   14206	14214	14217	java/lang/Throwable
    //   12724	12739	14254	java/lang/Exception
    //   13762	13789	14953	java/lang/Exception
    //   13812	13839	14968	java/lang/Exception
    //   430	445	15037	java/lang/Exception
    //   1465	1492	15731	java/lang/Exception
    //   1515	1542	15746	java/lang/Exception
    //   4929	4944	15815	java/lang/Exception
    //   5964	5991	16509	java/lang/Exception
    //   6014	6041	16524	java/lang/Exception
    //   2857	2872	16587	finally
    //   2887	2897	16611	finally
    //   2912	2936	16611	finally
    //   7088	7095	16611	finally
    //   14234	14242	16611	finally
    //   2936	2945	16643	finally
    //   2965	3023	16643	finally
    //   12581	12597	16643	finally
    //   12601	12622	16643	finally
    //   14206	14214	16643	finally
    //   252	262	16671	finally
    //   265	274	16695	finally
    //   280	287	16695	finally
    //   293	306	16695	finally
    //   309	314	16695	finally
    //   323	332	16695	finally
    //   2857	2872	16723	java/lang/Throwable
    //   2887	2897	16746	java/lang/Throwable
    //   2912	2936	16746	java/lang/Throwable
    //   7088	7095	16746	java/lang/Throwable
    //   14234	14242	16746	java/lang/Throwable
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