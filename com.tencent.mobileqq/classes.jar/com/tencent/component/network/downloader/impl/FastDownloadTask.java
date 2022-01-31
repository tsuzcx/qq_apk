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
    //   219: ifnull +1664 -> 1883
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
    //   386: ifnull +14468 -> 14854
    //   389: aload_0
    //   390: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   393: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   396: ifnull +14458 -> 14854
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
    //   427: ifnull +16171 -> 16598
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
    //   527: ifne +1322 -> 1849
    //   530: aload_0
    //   531: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   534: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   537: istore 10
    //   539: aload_2
    //   540: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   543: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   546: ifne +14358 -> 14904
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
    //   594: ifeq +14276 -> 14870
    //   597: aload 22
    //   599: ifnull +14271 -> 14870
    //   602: aload 22
    //   604: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   607: ifnull +14263 -> 14870
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
    //   724: ifeq +14154 -> 14878
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
    //   954: ifnull +13930 -> 14884
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
    //   988: ifnull +13905 -> 14893
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
    //   1135: ifnull +13763 -> 14898
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
    //   1177: iload 10
    //   1179: ifne +8 -> 1187
    //   1182: aload_0
    //   1183: iconst_0
    //   1184: putfield 662	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   1187: aload_2
    //   1188: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1191: astore 27
    //   1193: new 125	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1200: aload_0
    //   1201: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1204: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: ldc_w 664
    //   1210: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: aload 26
    //   1215: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: ldc_w 666
    //   1221: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: aload_2
    //   1225: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1228: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1231: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 668
    //   1237: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: astore 26
    //   1242: aload_0
    //   1243: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1246: ifnull +14295 -> 15541
    //   1249: aload_0
    //   1250: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1253: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1256: istore_3
    //   1257: aload 26
    //   1259: iload_3
    //   1260: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1263: ldc_w 609
    //   1266: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: iload 4
    //   1271: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1274: ldc_w 571
    //   1277: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: aload_2
    //   1281: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1284: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1287: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: ldc_w 583
    //   1293: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: aload_2
    //   1297: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1300: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1303: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1306: ldc_w 588
    //   1309: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload_2
    //   1313: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1316: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1319: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1322: ldc_w 576
    //   1325: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: aload_2
    //   1329: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1332: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1335: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1338: ldc_w 581
    //   1341: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1347: aload_0
    //   1348: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1351: lsub
    //   1352: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1355: astore 26
    //   1357: aload 24
    //   1359: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1362: ifne +14184 -> 15546
    //   1365: new 125	java/lang/StringBuilder
    //   1368: dup
    //   1369: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1372: ldc_w 613
    //   1375: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: aload 24
    //   1380: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1386: astore 24
    //   1388: aload 27
    //   1390: aload 26
    //   1392: aload 24
    //   1394: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: ldc_w 611
    //   1400: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: aload 30
    //   1405: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1411: putfield 671	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   1414: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1417: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1420: aload_0
    //   1421: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1424: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1427: if_icmpne +37 -> 1464
    //   1430: aload_0
    //   1431: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1434: ifnull +30 -> 1464
    //   1437: aload_0
    //   1438: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1441: aload_0
    //   1442: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1445: aload_0
    //   1446: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1449: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1452: aload_2
    //   1453: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1456: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1459: invokeinterface 678 4 0
    //   1464: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1467: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1470: aload_0
    //   1471: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1474: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1477: if_icmpne +37 -> 1514
    //   1480: aload_0
    //   1481: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1484: ifnull +30 -> 1514
    //   1487: aload_0
    //   1488: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1491: aload_0
    //   1492: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1495: aload_0
    //   1496: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1499: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1502: aload_2
    //   1503: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1506: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1509: invokeinterface 678 4 0
    //   1514: iload 10
    //   1516: ifeq +64 -> 1580
    //   1519: aload_0
    //   1520: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   1523: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1526: astore 24
    //   1528: aload_0
    //   1529: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1532: astore 26
    //   1534: aload_0
    //   1535: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1538: ifeq +14046 -> 15584
    //   1541: aload_0
    //   1542: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1545: ifnull +14039 -> 15584
    //   1548: aload_0
    //   1549: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1552: ldc_w 680
    //   1555: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1558: ifeq +14026 -> 15584
    //   1561: iconst_1
    //   1562: istore 10
    //   1564: aload 24
    //   1566: aload 26
    //   1568: iload 10
    //   1570: aload_2
    //   1571: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1574: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1577: invokevirtual 684	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   1580: aload 29
    //   1582: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   1585: putfield 687	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1588: aload 29
    //   1590: aload_0
    //   1591: invokevirtual 690	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   1594: putfield 693	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1597: aload 29
    //   1599: aload 23
    //   1601: putfield 697	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1604: aload 29
    //   1606: aload 22
    //   1608: putfield 701	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   1611: aload 29
    //   1613: iload 4
    //   1615: putfield 704	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1618: aload 29
    //   1620: aload 25
    //   1622: putfield 708	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1625: aload 28
    //   1627: ifnonnull +13963 -> 15590
    //   1630: aconst_null
    //   1631: astore 22
    //   1633: aload 29
    //   1635: aload 22
    //   1637: putfield 711	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1640: aload 29
    //   1642: aconst_null
    //   1643: putfield 714	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1646: aload 29
    //   1648: aload_2
    //   1649: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1652: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1655: putfield 715	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1658: aload 29
    //   1660: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1663: aload_0
    //   1664: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1667: lsub
    //   1668: putfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1671: aload 29
    //   1673: aload_2
    //   1674: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1677: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1680: putfield 721	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1683: aload 29
    //   1685: aload 29
    //   1687: getfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1690: aload_2
    //   1691: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1694: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1697: lsub
    //   1698: putfield 724	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1701: aload 29
    //   1703: lload 12
    //   1705: putfield 727	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1708: aload 29
    //   1710: aload_0
    //   1711: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   1714: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1717: aload 29
    //   1719: aload_0
    //   1720: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1723: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1726: aload 29
    //   1728: aload_0
    //   1729: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   1732: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1735: aload 29
    //   1737: lconst_0
    //   1738: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1741: aload 29
    //   1743: aload_0
    //   1744: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   1747: putfield 742	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1750: aload 29
    //   1752: aload_2
    //   1753: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1756: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1759: putfield 745	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1762: aload 29
    //   1764: aload_0
    //   1765: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1768: invokestatic 748	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1771: putfield 750	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1774: aload 29
    //   1776: aload_0
    //   1777: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1780: putfield 753	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1783: aload_0
    //   1784: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1787: ifnull +13813 -> 15600
    //   1790: aload_0
    //   1791: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1794: ldc_w 680
    //   1797: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1800: ifeq +13800 -> 15600
    //   1803: iconst_1
    //   1804: istore 10
    //   1806: aload 29
    //   1808: iload 10
    //   1810: putfield 756	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1813: aload 29
    //   1815: aload_2
    //   1816: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1819: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1822: putfield 758	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1825: aload_2
    //   1826: aload 29
    //   1828: invokevirtual 762	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1831: aload_2
    //   1832: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1835: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1838: ifeq +11 -> 1849
    //   1841: aload_0
    //   1842: aload_1
    //   1843: aload_2
    //   1844: aload 29
    //   1846: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1849: aload_0
    //   1850: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1853: ifeq +13753 -> 15606
    //   1856: aload_0
    //   1857: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   1860: ifnull +10 -> 1870
    //   1863: aload_0
    //   1864: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   1867: invokevirtual 771	com/squareup/okhttp/Call:cancel	()V
    //   1870: aload_0
    //   1871: aconst_null
    //   1872: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   1875: iload 6
    //   1877: iconst_1
    //   1878: iadd
    //   1879: istore_3
    //   1880: goto -1675 -> 205
    //   1883: lload 12
    //   1885: lstore 14
    //   1887: lload 12
    //   1889: lstore 16
    //   1891: getstatic 775	com/tencent/component/network/downloader/impl/FastDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   1894: invokevirtual 781	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1897: checkcast 783	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   1900: astore 30
    //   1902: lload 12
    //   1904: lstore 14
    //   1906: lload 12
    //   1908: lstore 16
    //   1910: aload 30
    //   1912: aload_0
    //   1913: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   1916: putfield 784	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   1919: lload 12
    //   1921: lstore 14
    //   1923: lload 12
    //   1925: lstore 16
    //   1927: aload 30
    //   1929: aload_0
    //   1930: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   1933: putfield 787	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   1936: lload 12
    //   1938: lstore 14
    //   1940: lload 12
    //   1942: lstore 16
    //   1944: aload_0
    //   1945: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1948: ifnull +2595 -> 4543
    //   1951: lload 12
    //   1953: lstore 14
    //   1955: lload 12
    //   1957: lstore 16
    //   1959: aload_0
    //   1960: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1963: invokeinterface 656 1 0
    //   1968: astore 22
    //   1970: lload 12
    //   1972: lstore 14
    //   1974: lload 12
    //   1976: lstore 16
    //   1978: aload 30
    //   1980: aload 22
    //   1982: putfield 790	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   1985: lload 12
    //   1987: lstore 14
    //   1989: lload 12
    //   1991: lstore 16
    //   1993: aload 29
    //   1995: iload_3
    //   1996: putfield 793	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   1999: lload 12
    //   2001: lstore 14
    //   2003: lload 12
    //   2005: lstore 16
    //   2007: aload 29
    //   2009: aload_0
    //   2010: getfield 795	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2013: putfield 798	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   2016: lload 12
    //   2018: lstore 14
    //   2020: lload 12
    //   2022: lstore 16
    //   2024: aload_0
    //   2025: aload_0
    //   2026: aload_0
    //   2027: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2030: invokevirtual 801	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   2033: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2036: lload 12
    //   2038: lstore 14
    //   2040: lload 12
    //   2042: lstore 16
    //   2044: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2047: iconst_2
    //   2048: if_icmpeq +14608 -> 16656
    //   2051: lload 12
    //   2053: lstore 14
    //   2055: lload 12
    //   2057: lstore 16
    //   2059: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2062: iconst_3
    //   2063: if_icmpne +2486 -> 4549
    //   2066: goto +14590 -> 16656
    //   2069: lload 12
    //   2071: lstore 14
    //   2073: lload 12
    //   2075: lstore 16
    //   2077: aload_0
    //   2078: invokevirtual 804	com/tencent/component/network/downloader/impl/FastDownloadTask:enableIpv6Debug	()Z
    //   2081: istore 10
    //   2083: lload 12
    //   2085: lstore 14
    //   2087: lload 12
    //   2089: lstore 16
    //   2091: aload 30
    //   2093: getfield 790	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2096: ifnonnull +4459 -> 6555
    //   2099: lload 12
    //   2101: lstore 14
    //   2103: lload 12
    //   2105: lstore 16
    //   2107: aload_0
    //   2108: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2111: ldc_w 680
    //   2114: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2117: ifeq +18 -> 2135
    //   2120: lload 12
    //   2122: lstore 14
    //   2124: lload 12
    //   2126: lstore 16
    //   2128: aload_0
    //   2129: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2132: ifeq +4423 -> 6555
    //   2135: lload 12
    //   2137: lstore 14
    //   2139: lload 12
    //   2141: lstore 16
    //   2143: aload_0
    //   2144: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2147: ifnull +4408 -> 6555
    //   2150: lload 12
    //   2152: lstore 14
    //   2154: lload 12
    //   2156: lstore 16
    //   2158: aload_0
    //   2159: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2162: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2165: ifnull +4390 -> 6555
    //   2168: lload 12
    //   2170: lstore 14
    //   2172: lload 12
    //   2174: lstore 16
    //   2176: aload_0
    //   2177: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2180: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2183: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2186: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2189: ifne +4366 -> 6555
    //   2192: lload 12
    //   2194: lstore 14
    //   2196: lload 12
    //   2198: lstore 16
    //   2200: aload_0
    //   2201: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2204: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2207: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2210: astore 28
    //   2212: lload 12
    //   2214: lstore 14
    //   2216: lload 12
    //   2218: lstore 16
    //   2220: aload_0
    //   2221: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2224: astore 27
    //   2226: lload 12
    //   2228: lstore 14
    //   2230: lload 12
    //   2232: lstore 16
    //   2234: aload 28
    //   2236: bipush 58
    //   2238: invokestatic 808	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   2241: istore 4
    //   2243: iload 5
    //   2245: ifne +14417 -> 16662
    //   2248: aload 27
    //   2250: astore 22
    //   2252: iload 4
    //   2254: iconst_2
    //   2255: if_icmpge +150 -> 2405
    //   2258: lload 12
    //   2260: lstore 14
    //   2262: lload 12
    //   2264: lstore 16
    //   2266: aload_0
    //   2267: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   2270: istore 4
    //   2272: iload 4
    //   2274: ifle +2281 -> 4555
    //   2277: lload 12
    //   2279: lstore 14
    //   2281: lload 12
    //   2283: lstore 16
    //   2285: aload_0
    //   2286: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2289: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2292: iload 4
    //   2294: putfield 811	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2297: lload 12
    //   2299: lstore 14
    //   2301: iload 4
    //   2303: istore 6
    //   2305: lload 12
    //   2307: lstore 16
    //   2309: iload 4
    //   2311: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   2314: ifne +7 -> 2321
    //   2317: bipush 80
    //   2319: istore 6
    //   2321: lload 12
    //   2323: lstore 14
    //   2325: lload 12
    //   2327: lstore 16
    //   2329: new 125	java/lang/StringBuilder
    //   2332: dup
    //   2333: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2336: aload 28
    //   2338: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: ldc_w 813
    //   2344: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2347: iload 6
    //   2349: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2352: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2355: astore 23
    //   2357: lload 12
    //   2359: lstore 14
    //   2361: aload 23
    //   2363: astore 22
    //   2365: lload 12
    //   2367: lstore 16
    //   2369: aload_0
    //   2370: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2373: ifnull +32 -> 2405
    //   2376: lload 12
    //   2378: lstore 14
    //   2380: lload 12
    //   2382: lstore 16
    //   2384: aload_0
    //   2385: aload_0
    //   2386: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2389: aload_0
    //   2390: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2393: aload 23
    //   2395: invokevirtual 819	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2398: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2401: aload 23
    //   2403: astore 22
    //   2405: lload 12
    //   2407: lstore 14
    //   2409: lload 12
    //   2411: lstore 16
    //   2413: aload 29
    //   2415: aload_0
    //   2416: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2419: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2422: putfield 822	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2425: lload 12
    //   2427: lstore 14
    //   2429: lload 12
    //   2431: lstore 16
    //   2433: invokestatic 825	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   2436: ifeq +77 -> 2513
    //   2439: lload 12
    //   2441: lstore 14
    //   2443: lload 12
    //   2445: lstore 16
    //   2447: ldc 219
    //   2449: new 125	java/lang/StringBuilder
    //   2452: dup
    //   2453: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2456: ldc_w 827
    //   2459: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: aload 29
    //   2464: getfield 822	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2467: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2470: ldc_w 829
    //   2473: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: aload 22
    //   2478: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: ldc 151
    //   2483: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2486: aload_0
    //   2487: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2490: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2493: ldc 225
    //   2495: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2501: invokevirtual 174	java/lang/Thread:getId	()J
    //   2504: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2507: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2510: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2513: lload 12
    //   2515: lstore 14
    //   2517: lload 12
    //   2519: lstore 16
    //   2521: aload_0
    //   2522: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2525: ifnull +43 -> 2568
    //   2528: lload 12
    //   2530: lstore 14
    //   2532: lload 12
    //   2534: lstore 16
    //   2536: aload 29
    //   2538: aload_0
    //   2539: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2542: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2545: putfield 822	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2548: lload 12
    //   2550: lstore 14
    //   2552: lload 12
    //   2554: lstore 16
    //   2556: aload 29
    //   2558: aload_0
    //   2559: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2562: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2565: putfield 832	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2568: lload 12
    //   2570: lstore 14
    //   2572: lload 12
    //   2574: lstore 16
    //   2576: aload_0
    //   2577: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2580: ifeq +4301 -> 6881
    //   2583: iload 5
    //   2585: ifne +4296 -> 6881
    //   2588: lload 12
    //   2590: lstore 14
    //   2592: lload 12
    //   2594: lstore 16
    //   2596: aload_0
    //   2597: aload_0
    //   2598: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2601: aload_0
    //   2602: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2605: aload_0
    //   2606: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2609: aload_0
    //   2610: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2613: aload_0
    //   2614: getfield 795	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2617: invokestatic 838	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   2620: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2623: lload 12
    //   2625: lstore 14
    //   2627: lload 12
    //   2629: lstore 16
    //   2631: aload_0
    //   2632: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2635: ifnull +36 -> 2671
    //   2638: lload 12
    //   2640: lstore 14
    //   2642: lload 12
    //   2644: lstore 16
    //   2646: aload_0
    //   2647: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2650: aload_0
    //   2651: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2654: aload_0
    //   2655: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2658: aload_0
    //   2659: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2662: aload_0
    //   2663: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2666: invokeinterface 842 5 0
    //   2671: lload 12
    //   2673: lstore 14
    //   2675: lload 12
    //   2677: lstore 16
    //   2679: aload_0
    //   2680: aload_0
    //   2681: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2684: aload_0
    //   2685: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2688: aload_0
    //   2689: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2692: aload_0
    //   2693: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2696: invokevirtual 845	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;)V
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
    //   2724: aload 30
    //   2726: invokevirtual 849	com/tencent/component/network/downloader/impl/FastDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2729: lload 12
    //   2731: lstore 14
    //   2733: lload 12
    //   2735: lstore 16
    //   2737: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   2740: lload 20
    //   2742: lsub
    //   2743: lstore 12
    //   2745: lload 12
    //   2747: lstore 14
    //   2749: lload 12
    //   2751: lstore 16
    //   2753: aload_0
    //   2754: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2757: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2760: lload 12
    //   2762: lstore 14
    //   2764: lload 12
    //   2766: lstore 16
    //   2768: aload_0
    //   2769: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2772: ifnull +4149 -> 6921
    //   2775: lload 12
    //   2777: lstore 14
    //   2779: lload 12
    //   2781: lstore 16
    //   2783: aload_0
    //   2784: getfield 853	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2787: ifnonnull +18 -> 2805
    //   2790: lload 12
    //   2792: lstore 14
    //   2794: lload 12
    //   2796: lstore 16
    //   2798: aload_0
    //   2799: invokestatic 857	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2802: putfield 853	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2805: lload 12
    //   2807: lstore 14
    //   2809: lload 12
    //   2811: lstore 16
    //   2813: invokestatic 861	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   2816: astore 22
    //   2818: aload_0
    //   2819: getfield 853	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2822: aload_0
    //   2823: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2826: aload 22
    //   2828: invokevirtual 866	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   2831: astore 23
    //   2833: aconst_null
    //   2834: astore 25
    //   2836: aload 22
    //   2838: astore 24
    //   2840: aload 23
    //   2842: astore 22
    //   2844: aload 25
    //   2846: astore 23
    //   2848: aload_0
    //   2849: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2852: aload_0
    //   2853: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2856: lsub
    //   2857: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2860: aload 22
    //   2862: ifnonnull +8 -> 2870
    //   2865: aload 23
    //   2867: ifnull +11190 -> 14057
    //   2870: aload 22
    //   2872: ifnull +4118 -> 6990
    //   2875: aload 22
    //   2877: invokeinterface 872 1 0
    //   2882: ifnull +4108 -> 6990
    //   2885: aload 22
    //   2887: invokeinterface 872 1 0
    //   2892: invokeinterface 877 1 0
    //   2897: istore 4
    //   2899: aload_2
    //   2900: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2903: iload 4
    //   2905: putfield 878	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   2908: sipush 200
    //   2911: iload 4
    //   2913: if_icmpeq +11 -> 2924
    //   2916: sipush 206
    //   2919: iload 4
    //   2921: if_icmpne +9503 -> 12424
    //   2924: iload 4
    //   2926: istore 5
    //   2928: aload_0
    //   2929: aload 22
    //   2931: aload 23
    //   2933: aload_2
    //   2934: aload_1
    //   2935: iload 4
    //   2937: invokevirtual 882	com/tencent/component/network/downloader/impl/FastDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   2940: ifeq +9537 -> 12477
    //   2943: aload_2
    //   2944: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2947: invokevirtual 885	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   2950: aload_2
    //   2951: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2954: getfield 888	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   2957: ifeq +7149 -> 10106
    //   2960: aload_0
    //   2961: aload 22
    //   2963: aload 23
    //   2965: invokevirtual 892	com/tencent/component/network/downloader/impl/FastDownloadTask:getRetcode	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   2968: istore 5
    //   2970: aload_2
    //   2971: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2974: iload 5
    //   2976: putfield 895	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   2979: iload 5
    //   2981: invokestatic 898	com/tencent/component/network/module/base/Config:canRetCodeRetry	(I)Z
    //   2984: istore 10
    //   2986: iload 10
    //   2988: ifeq +4800 -> 7788
    //   2991: aload_2
    //   2992: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2995: lload 18
    //   2997: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3000: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3003: aload_2
    //   3004: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3007: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3010: aload_0
    //   3011: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3014: lsub
    //   3015: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3018: aload_2
    //   3019: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3022: aload_0
    //   3023: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   3026: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3029: aload_0
    //   3030: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3033: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3036: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3039: astore 27
    //   3041: aload_0
    //   3042: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3045: ifnull +3960 -> 7005
    //   3048: aload_0
    //   3049: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3052: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3055: ifnull +3950 -> 7005
    //   3058: aload_0
    //   3059: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3062: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3065: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   3068: astore 25
    //   3070: aload_0
    //   3071: aload_0
    //   3072: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3075: aload 22
    //   3077: aload 23
    //   3079: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   3082: astore 28
    //   3084: aload 24
    //   3086: ifnull +13544 -> 16630
    //   3089: aload 24
    //   3091: ldc_w 492
    //   3094: invokeinterface 498 2 0
    //   3099: checkcast 282	java/lang/String
    //   3102: astore 24
    //   3104: aload_2
    //   3105: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3108: aload 24
    //   3110: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3113: aload_0
    //   3114: lconst_0
    //   3115: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3118: aload_0
    //   3119: iconst_0
    //   3120: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3123: aload_0
    //   3124: lconst_0
    //   3125: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3128: aload_0
    //   3129: iconst_0
    //   3130: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3133: aload_2
    //   3134: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3137: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3140: ifeq +12 -> 3152
    //   3143: aload_1
    //   3144: invokeinterface 359 1 0
    //   3149: ifeq +31 -> 3180
    //   3152: aload_0
    //   3153: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3156: ifnull +24 -> 3180
    //   3159: aload_0
    //   3160: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3163: aload_0
    //   3164: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3167: aload_2
    //   3168: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3171: aload 22
    //   3173: aload 23
    //   3175: invokeinterface 523 5 0
    //   3180: aload_1
    //   3181: invokeinterface 359 1 0
    //   3186: ifne +1324 -> 4510
    //   3189: aload_0
    //   3190: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3193: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3196: istore 10
    //   3198: aload_2
    //   3199: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3202: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3205: ifne +3851 -> 7056
    //   3208: new 125	java/lang/StringBuilder
    //   3211: dup
    //   3212: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   3215: ldc_w 525
    //   3218: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3221: aload_0
    //   3222: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3225: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3228: ldc_w 527
    //   3231: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3234: aload_0
    //   3235: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3238: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3241: ldc_w 532
    //   3244: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3247: astore 30
    //   3249: aload_0
    //   3250: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3253: ifeq +3768 -> 7021
    //   3256: aload 23
    //   3258: ifnull +3763 -> 7021
    //   3261: aload 23
    //   3263: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3266: ifnull +3755 -> 7021
    //   3269: aload 23
    //   3271: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3274: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   3277: astore 26
    //   3279: aload 30
    //   3281: aload 26
    //   3283: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3286: ldc_w 543
    //   3289: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3292: aload 27
    //   3294: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3297: ldc_w 548
    //   3300: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3303: aload 25
    //   3305: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3308: ldc_w 550
    //   3311: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3314: aconst_null
    //   3315: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3318: ldc_w 552
    //   3321: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3324: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3327: invokevirtual 174	java/lang/Thread:getId	()J
    //   3330: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3333: ldc_w 554
    //   3336: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3342: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3345: ldc_w 556
    //   3348: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3351: aload_0
    //   3352: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3355: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3358: ldc_w 558
    //   3361: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3364: aload_0
    //   3365: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3368: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3371: ldc_w 560
    //   3374: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3377: astore 30
    //   3379: aload_0
    //   3380: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3383: ifeq +3646 -> 7029
    //   3386: aload_0
    //   3387: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3390: aload_0
    //   3391: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3394: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3397: astore 26
    //   3399: aload 30
    //   3401: aload 26
    //   3403: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3406: ldc_w 562
    //   3409: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: iload 10
    //   3414: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3417: ldc_w 564
    //   3420: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3423: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3426: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3429: ldc_w 571
    //   3432: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3435: aload_2
    //   3436: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3439: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3442: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3445: ldc_w 576
    //   3448: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3451: aload_2
    //   3452: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3455: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3458: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3461: ldc_w 581
    //   3464: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3467: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3470: aload_0
    //   3471: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3474: lsub
    //   3475: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3478: ldc_w 583
    //   3481: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3484: aload_2
    //   3485: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3488: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3491: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3494: ldc_w 588
    //   3497: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3500: aload_2
    //   3501: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3504: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3507: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3510: ldc_w 592
    //   3513: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3516: aload_2
    //   3517: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3520: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3523: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3526: ldc_w 597
    //   3529: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3532: aload_0
    //   3533: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   3536: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3539: ldc_w 599
    //   3542: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3545: aload_0
    //   3546: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   3549: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3552: ldc_w 604
    //   3555: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3558: aload_2
    //   3559: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3562: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3565: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3568: ldc_w 609
    //   3571: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3574: iload 4
    //   3576: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3579: ldc_w 611
    //   3582: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3585: aload 28
    //   3587: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3590: ldc_w 613
    //   3593: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3596: aload 24
    //   3598: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3601: ldc_w 615
    //   3604: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3607: astore 30
    //   3609: aload_0
    //   3610: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3613: ifnull +3422 -> 7035
    //   3616: aload_0
    //   3617: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3620: iconst_0
    //   3621: bipush 30
    //   3623: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   3626: astore 26
    //   3628: aload 30
    //   3630: aload 26
    //   3632: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3635: ldc_w 621
    //   3638: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3641: astore 26
    //   3643: aload_0
    //   3644: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3647: ifnull +3397 -> 7044
    //   3650: aload_0
    //   3651: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3654: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3657: istore 5
    //   3659: aload 26
    //   3661: iload 5
    //   3663: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3666: ldc_w 623
    //   3669: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3672: aload_2
    //   3673: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3676: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3679: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3682: ldc_w 628
    //   3685: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3688: lload 12
    //   3690: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3693: ldc_w 630
    //   3696: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3699: aload_0
    //   3700: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3703: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3706: ldc_w 599
    //   3709: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3712: aload_0
    //   3713: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3716: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3719: ldc_w 632
    //   3722: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3725: aload_0
    //   3726: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3729: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3732: ldc_w 599
    //   3735: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3738: aload_0
    //   3739: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3742: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3745: ldc_w 634
    //   3748: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3751: aload_0
    //   3752: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   3755: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3758: ldc_w 636
    //   3761: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3764: aload_0
    //   3765: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   3768: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3771: ldc_w 641
    //   3774: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3777: aload_0
    //   3778: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   3781: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3784: ldc_w 646
    //   3787: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3790: astore 30
    //   3792: aload_0
    //   3793: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3796: ifnull +3254 -> 7050
    //   3799: aload_0
    //   3800: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3803: invokeinterface 656 1 0
    //   3808: astore 26
    //   3810: aload 29
    //   3812: aload 30
    //   3814: aload 26
    //   3816: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3819: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3822: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3825: ldc_w 447
    //   3828: aload 29
    //   3830: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3833: aconst_null
    //   3834: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3837: iload 10
    //   3839: ifne +8 -> 3847
    //   3842: aload_0
    //   3843: iconst_0
    //   3844: putfield 662	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   3847: aload_2
    //   3848: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3851: astore 26
    //   3853: new 125	java/lang/StringBuilder
    //   3856: dup
    //   3857: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   3860: aload_0
    //   3861: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3864: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3867: ldc_w 664
    //   3870: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3873: aload 25
    //   3875: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3878: ldc_w 666
    //   3881: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3884: aload_2
    //   3885: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3888: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3891: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3894: ldc_w 668
    //   3897: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3900: astore 25
    //   3902: aload_0
    //   3903: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3906: ifnull +3790 -> 7696
    //   3909: aload_0
    //   3910: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3913: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3916: istore 5
    //   3918: aload 25
    //   3920: iload 5
    //   3922: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3925: ldc_w 609
    //   3928: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3931: iload 4
    //   3933: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3936: ldc_w 571
    //   3939: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3942: aload_2
    //   3943: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3946: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3949: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3952: ldc_w 583
    //   3955: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3958: aload_2
    //   3959: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3962: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3965: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3968: ldc_w 588
    //   3971: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3974: aload_2
    //   3975: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3978: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3981: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3984: ldc_w 576
    //   3987: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3990: aload_2
    //   3991: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3994: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3997: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4000: ldc_w 581
    //   4003: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4006: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4009: aload_0
    //   4010: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4013: lsub
    //   4014: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4017: astore 25
    //   4019: aload 24
    //   4021: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4024: ifne +3678 -> 7702
    //   4027: new 125	java/lang/StringBuilder
    //   4030: dup
    //   4031: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4034: ldc_w 613
    //   4037: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4040: aload 24
    //   4042: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4045: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4048: astore 24
    //   4050: aload 26
    //   4052: aload 25
    //   4054: aload 24
    //   4056: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4059: ldc_w 611
    //   4062: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4065: aload 28
    //   4067: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4070: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4073: putfield 671	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   4076: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4079: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4082: aload_0
    //   4083: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4086: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4089: if_icmpne +37 -> 4126
    //   4092: aload_0
    //   4093: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4096: ifnull +30 -> 4126
    //   4099: aload_0
    //   4100: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4103: aload_0
    //   4104: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4107: aload_0
    //   4108: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4111: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4114: aload_2
    //   4115: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4118: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4121: invokeinterface 678 4 0
    //   4126: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4129: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4132: aload_0
    //   4133: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4136: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4139: if_icmpne +37 -> 4176
    //   4142: aload_0
    //   4143: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4146: ifnull +30 -> 4176
    //   4149: aload_0
    //   4150: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4153: aload_0
    //   4154: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4157: aload_0
    //   4158: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4161: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4164: aload_2
    //   4165: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4168: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4171: invokeinterface 678 4 0
    //   4176: iload 10
    //   4178: ifeq +64 -> 4242
    //   4181: aload_0
    //   4182: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4185: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   4188: astore 24
    //   4190: aload_0
    //   4191: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4194: astore 25
    //   4196: aload_0
    //   4197: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4200: ifeq +3540 -> 7740
    //   4203: aload_0
    //   4204: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4207: ifnull +3533 -> 7740
    //   4210: aload_0
    //   4211: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4214: ldc_w 680
    //   4217: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4220: ifeq +3520 -> 7740
    //   4223: iconst_1
    //   4224: istore 10
    //   4226: aload 24
    //   4228: aload 25
    //   4230: iload 10
    //   4232: aload_2
    //   4233: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4236: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4239: invokevirtual 684	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   4242: aload 29
    //   4244: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   4247: putfield 687	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4250: aload 29
    //   4252: aload_0
    //   4253: invokevirtual 690	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   4256: putfield 693	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4259: aload 29
    //   4261: aload 22
    //   4263: putfield 697	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4266: aload 29
    //   4268: aload 23
    //   4270: putfield 701	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   4273: aload 29
    //   4275: iload 4
    //   4277: putfield 704	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4280: aload 29
    //   4282: aconst_null
    //   4283: putfield 708	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4286: aload 27
    //   4288: ifnonnull +3458 -> 7746
    //   4291: aconst_null
    //   4292: astore 22
    //   4294: aload 29
    //   4296: aload 22
    //   4298: putfield 711	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4301: aload 29
    //   4303: aconst_null
    //   4304: putfield 714	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4307: aload 29
    //   4309: aload_2
    //   4310: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4313: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4316: putfield 715	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4319: aload 29
    //   4321: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4324: aload_0
    //   4325: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4328: lsub
    //   4329: putfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4332: aload 29
    //   4334: aload_2
    //   4335: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4338: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4341: putfield 721	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4344: aload 29
    //   4346: aload 29
    //   4348: getfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4351: aload_2
    //   4352: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4355: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4358: lsub
    //   4359: putfield 724	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4362: aload 29
    //   4364: lload 12
    //   4366: putfield 727	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4369: aload 29
    //   4371: aload_0
    //   4372: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4375: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4378: aload 29
    //   4380: aload_0
    //   4381: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   4384: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4387: aload 29
    //   4389: aload_0
    //   4390: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   4393: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4396: aload 29
    //   4398: lconst_0
    //   4399: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4402: aload 29
    //   4404: aload_0
    //   4405: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   4408: putfield 742	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4411: aload 29
    //   4413: aload_2
    //   4414: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4417: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4420: putfield 745	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4423: aload 29
    //   4425: aload_0
    //   4426: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4429: invokestatic 748	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4432: putfield 750	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4435: aload 29
    //   4437: aload_0
    //   4438: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4441: putfield 753	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4444: aload_0
    //   4445: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4448: ifnull +3308 -> 7756
    //   4451: aload_0
    //   4452: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4455: ldc_w 680
    //   4458: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4461: ifeq +3295 -> 7756
    //   4464: iconst_1
    //   4465: istore 10
    //   4467: aload 29
    //   4469: iload 10
    //   4471: putfield 756	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4474: aload 29
    //   4476: aload_2
    //   4477: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4480: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4483: putfield 758	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4486: aload_2
    //   4487: aload 29
    //   4489: invokevirtual 762	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4492: aload_2
    //   4493: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4496: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4499: ifeq +11 -> 4510
    //   4502: aload_0
    //   4503: aload_1
    //   4504: aload_2
    //   4505: aload 29
    //   4507: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4510: aload_0
    //   4511: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4514: ifeq +3248 -> 7762
    //   4517: aload_0
    //   4518: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   4521: ifnull +10 -> 4531
    //   4524: aload_0
    //   4525: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   4528: invokevirtual 771	com/squareup/okhttp/Call:cancel	()V
    //   4531: aload_0
    //   4532: aconst_null
    //   4533: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   4536: iload_3
    //   4537: iconst_1
    //   4538: iadd
    //   4539: istore_3
    //   4540: goto -4335 -> 205
    //   4543: aconst_null
    //   4544: astore 22
    //   4546: goto -2576 -> 1970
    //   4549: iconst_0
    //   4550: istore 5
    //   4552: goto -2483 -> 2069
    //   4555: lload 12
    //   4557: lstore 14
    //   4559: lload 12
    //   4561: lstore 16
    //   4563: aload_0
    //   4564: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4567: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4570: getfield 811	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4573: istore 4
    //   4575: goto -2278 -> 2297
    //   4578: lload 12
    //   4580: lstore 14
    //   4582: lload 12
    //   4584: lstore 16
    //   4586: aload 23
    //   4588: bipush 58
    //   4590: invokestatic 808	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   4593: iconst_2
    //   4594: if_icmplt +1741 -> 6335
    //   4597: lload 12
    //   4599: lstore 14
    //   4601: lload 12
    //   4603: lstore 16
    //   4605: aload_0
    //   4606: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   4609: istore 4
    //   4611: iload 4
    //   4613: ifle +1699 -> 6312
    //   4616: lload 12
    //   4618: lstore 14
    //   4620: lload 12
    //   4622: lstore 16
    //   4624: aload_0
    //   4625: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4628: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4631: iload 4
    //   4633: putfield 811	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4636: lload 12
    //   4638: lstore 14
    //   4640: iload 4
    //   4642: istore 6
    //   4644: lload 12
    //   4646: lstore 16
    //   4648: iload 4
    //   4650: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   4653: ifne +7 -> 4660
    //   4656: bipush 80
    //   4658: istore 6
    //   4660: lload 12
    //   4662: lstore 14
    //   4664: lload 12
    //   4666: lstore 16
    //   4668: new 125	java/lang/StringBuilder
    //   4671: dup
    //   4672: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4675: ldc_w 900
    //   4678: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4681: aload 23
    //   4683: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4686: ldc_w 902
    //   4689: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4692: iload 6
    //   4694: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4697: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4700: astore 23
    //   4702: lload 12
    //   4704: lstore 14
    //   4706: aload 23
    //   4708: astore 22
    //   4710: lload 12
    //   4712: lstore 16
    //   4714: aload_0
    //   4715: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4718: ifnull -2313 -> 2405
    //   4721: lload 12
    //   4723: lstore 14
    //   4725: lload 12
    //   4727: lstore 16
    //   4729: aload_0
    //   4730: aload_0
    //   4731: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4734: aload_0
    //   4735: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4738: aload 23
    //   4740: invokevirtual 819	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4743: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4746: aload 23
    //   4748: astore 22
    //   4750: goto -2345 -> 2405
    //   4753: astore 22
    //   4755: aconst_null
    //   4756: astore 23
    //   4758: iload 7
    //   4760: istore 4
    //   4762: lload 16
    //   4764: lstore 12
    //   4766: aload_2
    //   4767: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4770: lload 18
    //   4772: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4775: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4778: aload_2
    //   4779: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4782: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4785: aload_0
    //   4786: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4789: lsub
    //   4790: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4793: aload_2
    //   4794: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4797: aload_0
    //   4798: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   4801: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4804: aload_0
    //   4805: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4808: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4811: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4814: astore 30
    //   4816: aload_0
    //   4817: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4820: ifnull +10812 -> 15632
    //   4823: aload_0
    //   4824: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4827: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4830: ifnull +10802 -> 15632
    //   4833: aload_0
    //   4834: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4837: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4840: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   4843: astore 27
    //   4845: aload_0
    //   4846: aload_0
    //   4847: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   4850: aload 26
    //   4852: aload 25
    //   4854: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   4857: astore 31
    //   4859: aload 24
    //   4861: ifnull +11729 -> 16590
    //   4864: aload 24
    //   4866: ldc_w 492
    //   4869: invokeinterface 498 2 0
    //   4874: checkcast 282	java/lang/String
    //   4877: astore 24
    //   4879: aload_2
    //   4880: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4883: aload 24
    //   4885: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   4888: aload_0
    //   4889: lconst_0
    //   4890: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4893: aload_0
    //   4894: iconst_0
    //   4895: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   4898: aload_0
    //   4899: lconst_0
    //   4900: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   4903: aload_0
    //   4904: iconst_0
    //   4905: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   4908: aload_2
    //   4909: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4912: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4915: ifeq +12 -> 4927
    //   4918: aload_1
    //   4919: invokeinterface 359 1 0
    //   4924: ifeq +31 -> 4955
    //   4927: aload_0
    //   4928: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4931: ifnull +24 -> 4955
    //   4934: aload_0
    //   4935: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4938: aload_0
    //   4939: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   4942: aload_2
    //   4943: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4946: aload 26
    //   4948: aload 25
    //   4950: invokeinterface 523 5 0
    //   4955: aload_1
    //   4956: invokeinterface 359 1 0
    //   4961: ifne +1322 -> 6283
    //   4964: aload_0
    //   4965: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4968: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4971: istore 10
    //   4973: aload_2
    //   4974: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4977: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4980: ifne +10702 -> 15682
    //   4983: new 125	java/lang/StringBuilder
    //   4986: dup
    //   4987: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4990: ldc_w 525
    //   4993: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4996: aload_0
    //   4997: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5000: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5003: ldc_w 527
    //   5006: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5009: aload_0
    //   5010: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5013: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5016: ldc_w 532
    //   5019: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5022: astore 32
    //   5024: aload_0
    //   5025: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5028: ifeq +10620 -> 15648
    //   5031: aload 25
    //   5033: ifnull +10615 -> 15648
    //   5036: aload 25
    //   5038: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5041: ifnull +10607 -> 15648
    //   5044: aload 25
    //   5046: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5049: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   5052: astore 28
    //   5054: aload 32
    //   5056: aload 28
    //   5058: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5061: ldc_w 543
    //   5064: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5067: aload 30
    //   5069: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5072: ldc_w 548
    //   5075: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5078: aload 27
    //   5080: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5083: ldc_w 550
    //   5086: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5089: aconst_null
    //   5090: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5093: ldc_w 552
    //   5096: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5099: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5102: invokevirtual 174	java/lang/Thread:getId	()J
    //   5105: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5108: ldc_w 554
    //   5111: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5114: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5120: ldc_w 556
    //   5123: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5126: aload_0
    //   5127: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5130: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5133: ldc_w 558
    //   5136: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5139: aload_0
    //   5140: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5143: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5146: ldc_w 560
    //   5149: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5152: astore 32
    //   5154: aload_0
    //   5155: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5158: ifeq +10498 -> 15656
    //   5161: aload_0
    //   5162: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5165: aload_0
    //   5166: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5169: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5172: astore 28
    //   5174: aload 32
    //   5176: aload 28
    //   5178: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5181: ldc_w 562
    //   5184: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5187: iload 10
    //   5189: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5192: ldc_w 564
    //   5195: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5198: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5201: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5204: ldc_w 571
    //   5207: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5210: aload_2
    //   5211: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5214: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5217: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5220: ldc_w 576
    //   5223: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5226: aload_2
    //   5227: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5230: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5233: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5236: ldc_w 581
    //   5239: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5242: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5245: aload_0
    //   5246: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5249: lsub
    //   5250: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5253: ldc_w 583
    //   5256: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5259: aload_2
    //   5260: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5263: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5266: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5269: ldc_w 588
    //   5272: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5275: aload_2
    //   5276: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5279: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5282: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5285: ldc_w 592
    //   5288: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5291: aload_2
    //   5292: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5295: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5298: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5301: ldc_w 597
    //   5304: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5307: aload_0
    //   5308: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   5311: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5314: ldc_w 599
    //   5317: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5320: aload_0
    //   5321: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   5324: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5327: ldc_w 604
    //   5330: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5333: aload_2
    //   5334: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5337: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5340: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5343: ldc_w 609
    //   5346: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5349: iload 4
    //   5351: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5354: ldc_w 611
    //   5357: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5360: aload 31
    //   5362: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5365: ldc_w 613
    //   5368: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5371: aload 24
    //   5373: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5376: ldc_w 615
    //   5379: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5382: astore 32
    //   5384: aload_0
    //   5385: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5388: ifnull +10274 -> 15662
    //   5391: aload_0
    //   5392: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5395: iconst_0
    //   5396: bipush 30
    //   5398: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   5401: astore 28
    //   5403: aload 32
    //   5405: aload 28
    //   5407: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5410: ldc_w 621
    //   5413: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5416: astore 28
    //   5418: aload_0
    //   5419: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5422: ifnull +10249 -> 15671
    //   5425: aload_0
    //   5426: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5429: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5432: istore_3
    //   5433: aload 28
    //   5435: iload_3
    //   5436: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5439: ldc_w 623
    //   5442: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5445: aload_2
    //   5446: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5449: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5452: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5455: ldc_w 628
    //   5458: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5461: lload 12
    //   5463: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5466: ldc_w 630
    //   5469: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5472: aload_0
    //   5473: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5476: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5479: ldc_w 599
    //   5482: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5485: aload_0
    //   5486: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   5489: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5492: ldc_w 632
    //   5495: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5498: aload_0
    //   5499: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   5502: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5505: ldc_w 599
    //   5508: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5511: aload_0
    //   5512: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   5515: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5518: ldc_w 634
    //   5521: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5524: aload_0
    //   5525: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   5528: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5531: ldc_w 636
    //   5534: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5537: aload_0
    //   5538: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   5541: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5544: ldc_w 641
    //   5547: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5550: aload_0
    //   5551: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   5554: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5557: ldc_w 646
    //   5560: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5563: astore 32
    //   5565: aload_0
    //   5566: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5569: ifnull +10107 -> 15676
    //   5572: aload_0
    //   5573: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5576: invokeinterface 656 1 0
    //   5581: astore 28
    //   5583: aload 29
    //   5585: aload 32
    //   5587: aload 28
    //   5589: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5592: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5595: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5598: ldc_w 447
    //   5601: aload 29
    //   5603: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5606: aload 23
    //   5608: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5611: iload 10
    //   5613: ifne +8 -> 5621
    //   5616: aload_0
    //   5617: iconst_0
    //   5618: putfield 662	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   5621: aload_2
    //   5622: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5625: astore 28
    //   5627: new 125	java/lang/StringBuilder
    //   5630: dup
    //   5631: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5634: aload_0
    //   5635: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5638: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5641: ldc_w 664
    //   5644: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5647: aload 27
    //   5649: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5652: ldc_w 666
    //   5655: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5658: aload_2
    //   5659: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5662: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5665: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5668: ldc_w 668
    //   5671: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5674: astore 27
    //   5676: aload_0
    //   5677: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5680: ifnull +10639 -> 16319
    //   5683: aload_0
    //   5684: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5687: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5690: istore_3
    //   5691: aload 27
    //   5693: iload_3
    //   5694: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5697: ldc_w 609
    //   5700: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5703: iload 4
    //   5705: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5708: ldc_w 571
    //   5711: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5714: aload_2
    //   5715: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5718: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5721: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5724: ldc_w 583
    //   5727: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5730: aload_2
    //   5731: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5734: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5737: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5740: ldc_w 588
    //   5743: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5746: aload_2
    //   5747: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5750: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5753: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5756: ldc_w 576
    //   5759: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5762: aload_2
    //   5763: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5766: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5769: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5772: ldc_w 581
    //   5775: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5778: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5781: aload_0
    //   5782: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5785: lsub
    //   5786: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5789: astore 27
    //   5791: aload 24
    //   5793: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5796: ifne +10528 -> 16324
    //   5799: new 125	java/lang/StringBuilder
    //   5802: dup
    //   5803: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5806: ldc_w 613
    //   5809: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5812: aload 24
    //   5814: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5817: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5820: astore 24
    //   5822: aload 28
    //   5824: aload 27
    //   5826: aload 24
    //   5828: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5831: ldc_w 611
    //   5834: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5837: aload 31
    //   5839: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5842: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5845: putfield 671	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   5848: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5851: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5854: aload_0
    //   5855: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5858: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5861: if_icmpne +37 -> 5898
    //   5864: aload_0
    //   5865: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5868: ifnull +30 -> 5898
    //   5871: aload_0
    //   5872: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5875: aload_0
    //   5876: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5879: aload_0
    //   5880: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5883: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5886: aload_2
    //   5887: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5890: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5893: invokeinterface 678 4 0
    //   5898: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5901: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5904: aload_0
    //   5905: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5908: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5911: if_icmpne +37 -> 5948
    //   5914: aload_0
    //   5915: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5918: ifnull +30 -> 5948
    //   5921: aload_0
    //   5922: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5925: aload_0
    //   5926: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5929: aload_0
    //   5930: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5933: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5936: aload_2
    //   5937: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5940: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5943: invokeinterface 678 4 0
    //   5948: iload 10
    //   5950: ifeq +64 -> 6014
    //   5953: aload_0
    //   5954: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5957: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   5960: astore 24
    //   5962: aload_0
    //   5963: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5966: astore 27
    //   5968: aload_0
    //   5969: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5972: ifeq +10390 -> 16362
    //   5975: aload_0
    //   5976: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5979: ifnull +10383 -> 16362
    //   5982: aload_0
    //   5983: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5986: ldc_w 680
    //   5989: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5992: ifeq +10370 -> 16362
    //   5995: iconst_1
    //   5996: istore 10
    //   5998: aload 24
    //   6000: aload 27
    //   6002: iload 10
    //   6004: aload_2
    //   6005: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6008: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6011: invokevirtual 684	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   6014: aload 29
    //   6016: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   6019: putfield 687	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   6022: aload 29
    //   6024: aload_0
    //   6025: invokevirtual 690	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   6028: putfield 693	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   6031: aload 29
    //   6033: aload 26
    //   6035: putfield 697	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   6038: aload 29
    //   6040: aload 25
    //   6042: putfield 701	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   6045: aload 29
    //   6047: iload 4
    //   6049: putfield 704	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   6052: aload 29
    //   6054: aload 23
    //   6056: putfield 708	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   6059: aload 30
    //   6061: ifnonnull +10307 -> 16368
    //   6064: aconst_null
    //   6065: astore 23
    //   6067: aload 29
    //   6069: aload 23
    //   6071: putfield 711	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   6074: aload 29
    //   6076: aconst_null
    //   6077: putfield 714	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   6080: aload 29
    //   6082: aload_2
    //   6083: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6086: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6089: putfield 715	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   6092: aload 29
    //   6094: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   6097: aload_0
    //   6098: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   6101: lsub
    //   6102: putfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6105: aload 29
    //   6107: aload_2
    //   6108: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6111: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6114: putfield 721	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6117: aload 29
    //   6119: aload 29
    //   6121: getfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6124: aload_2
    //   6125: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6128: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6131: lsub
    //   6132: putfield 724	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6135: aload 29
    //   6137: lload 12
    //   6139: putfield 727	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6142: aload 29
    //   6144: aload_0
    //   6145: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   6148: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6151: aload 29
    //   6153: aload_0
    //   6154: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   6157: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6160: aload 29
    //   6162: aload_0
    //   6163: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   6166: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   6169: aload 29
    //   6171: lconst_0
    //   6172: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   6175: aload 29
    //   6177: aload_0
    //   6178: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   6181: putfield 742	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6184: aload 29
    //   6186: aload_2
    //   6187: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6190: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6193: putfield 745	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6196: aload 29
    //   6198: aload_0
    //   6199: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6202: invokestatic 748	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6205: putfield 750	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6208: aload 29
    //   6210: aload_0
    //   6211: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6214: putfield 753	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6217: aload_0
    //   6218: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6221: ifnull +10157 -> 16378
    //   6224: aload_0
    //   6225: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6228: ldc_w 680
    //   6231: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6234: ifeq +10144 -> 16378
    //   6237: iconst_1
    //   6238: istore 10
    //   6240: aload 29
    //   6242: iload 10
    //   6244: putfield 756	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6247: aload 29
    //   6249: aload_2
    //   6250: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6253: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6256: putfield 758	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6259: aload_2
    //   6260: aload 29
    //   6262: invokevirtual 762	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6265: aload_2
    //   6266: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6269: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6272: ifeq +11 -> 6283
    //   6275: aload_0
    //   6276: aload_1
    //   6277: aload_2
    //   6278: aload 29
    //   6280: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6283: aload_0
    //   6284: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6287: ifeq +10097 -> 16384
    //   6290: aload_0
    //   6291: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6294: ifnull +10 -> 6304
    //   6297: aload_0
    //   6298: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6301: invokevirtual 771	com/squareup/okhttp/Call:cancel	()V
    //   6304: aload_0
    //   6305: aconst_null
    //   6306: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6309: aload 22
    //   6311: athrow
    //   6312: lload 12
    //   6314: lstore 14
    //   6316: lload 12
    //   6318: lstore 16
    //   6320: aload_0
    //   6321: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6324: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6327: getfield 811	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6330: istore 4
    //   6332: goto -1696 -> 4636
    //   6335: lload 12
    //   6337: lstore 14
    //   6339: aload 27
    //   6341: astore 22
    //   6343: lload 12
    //   6345: lstore 16
    //   6347: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6350: iconst_3
    //   6351: if_icmpne -3946 -> 2405
    //   6354: lload 12
    //   6356: lstore 14
    //   6358: aload 27
    //   6360: astore 22
    //   6362: lload 12
    //   6364: lstore 16
    //   6366: aload_0
    //   6367: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6370: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6373: getstatic 272	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6376: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6379: if_icmpeq -3974 -> 2405
    //   6382: lload 12
    //   6384: lstore 14
    //   6386: lload 12
    //   6388: lstore 16
    //   6390: aload_0
    //   6391: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6394: istore 4
    //   6396: iload 4
    //   6398: ifle +134 -> 6532
    //   6401: lload 12
    //   6403: lstore 14
    //   6405: lload 12
    //   6407: lstore 16
    //   6409: aload_0
    //   6410: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6413: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6416: iload 4
    //   6418: putfield 811	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6421: lload 12
    //   6423: lstore 14
    //   6425: lload 12
    //   6427: lstore 16
    //   6429: iload 4
    //   6431: istore 6
    //   6433: iload 4
    //   6435: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6438: ifne +7 -> 6445
    //   6441: bipush 80
    //   6443: istore 6
    //   6445: lload 12
    //   6447: lstore 14
    //   6449: lload 12
    //   6451: lstore 16
    //   6453: new 125	java/lang/StringBuilder
    //   6456: dup
    //   6457: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6460: aload 23
    //   6462: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6465: ldc_w 813
    //   6468: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6471: iload 6
    //   6473: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6476: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6479: astore 23
    //   6481: lload 12
    //   6483: lstore 14
    //   6485: aload 23
    //   6487: astore 22
    //   6489: lload 12
    //   6491: lstore 16
    //   6493: aload_0
    //   6494: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6497: ifnull -4092 -> 2405
    //   6500: lload 12
    //   6502: lstore 14
    //   6504: lload 12
    //   6506: lstore 16
    //   6508: aload_0
    //   6509: aload_0
    //   6510: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6513: aload_0
    //   6514: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6517: aload 23
    //   6519: invokevirtual 819	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6522: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6525: aload 23
    //   6527: astore 22
    //   6529: goto -4124 -> 2405
    //   6532: lload 12
    //   6534: lstore 14
    //   6536: lload 12
    //   6538: lstore 16
    //   6540: aload_0
    //   6541: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6544: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6547: getfield 811	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6550: istore 4
    //   6552: goto -131 -> 6421
    //   6555: lload 12
    //   6557: lstore 14
    //   6559: lload 12
    //   6561: lstore 16
    //   6563: aload_0
    //   6564: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6567: ldc_w 680
    //   6570: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6573: ifeq -4060 -> 2513
    //   6576: iload 5
    //   6578: ifeq -4065 -> 2513
    //   6581: iload 10
    //   6583: ifeq -4070 -> 2513
    //   6586: lload 12
    //   6588: lstore 14
    //   6590: lload 12
    //   6592: lstore 16
    //   6594: aload_0
    //   6595: aload_0
    //   6596: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6599: ldc_w 904
    //   6602: ldc_w 906
    //   6605: invokevirtual 819	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6608: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6611: lload 12
    //   6613: lstore 14
    //   6615: lload 12
    //   6617: lstore 16
    //   6619: aload_0
    //   6620: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6623: istore 4
    //   6625: iload 4
    //   6627: ifle +231 -> 6858
    //   6630: lload 12
    //   6632: lstore 14
    //   6634: lload 12
    //   6636: lstore 16
    //   6638: aload_0
    //   6639: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6642: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6645: iload 4
    //   6647: putfield 811	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6650: lload 12
    //   6652: lstore 14
    //   6654: lload 12
    //   6656: lstore 16
    //   6658: iload 4
    //   6660: istore 6
    //   6662: iload 4
    //   6664: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6667: ifne +7 -> 6674
    //   6670: bipush 80
    //   6672: istore 6
    //   6674: lload 12
    //   6676: lstore 14
    //   6678: lload 12
    //   6680: lstore 16
    //   6682: new 125	java/lang/StringBuilder
    //   6685: dup
    //   6686: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6689: ldc_w 900
    //   6692: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6695: ldc_w 908
    //   6698: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6701: ldc_w 902
    //   6704: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6707: iload 6
    //   6709: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6712: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6715: astore 22
    //   6717: lload 12
    //   6719: lstore 14
    //   6721: lload 12
    //   6723: lstore 16
    //   6725: aload_0
    //   6726: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6729: ifnull +28 -> 6757
    //   6732: lload 12
    //   6734: lstore 14
    //   6736: lload 12
    //   6738: lstore 16
    //   6740: aload_0
    //   6741: aload_0
    //   6742: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6745: aload_0
    //   6746: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6749: aload 22
    //   6751: invokevirtual 819	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6754: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6757: lload 12
    //   6759: lstore 14
    //   6761: lload 12
    //   6763: lstore 16
    //   6765: aload 29
    //   6767: aload_0
    //   6768: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6771: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   6774: putfield 822	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6777: lload 12
    //   6779: lstore 14
    //   6781: lload 12
    //   6783: lstore 16
    //   6785: invokestatic 825	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   6788: ifeq -4275 -> 2513
    //   6791: lload 12
    //   6793: lstore 14
    //   6795: lload 12
    //   6797: lstore 16
    //   6799: ldc 219
    //   6801: new 125	java/lang/StringBuilder
    //   6804: dup
    //   6805: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6808: ldc_w 827
    //   6811: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6814: aload 29
    //   6816: getfield 822	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6819: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6822: ldc_w 910
    //   6825: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6828: aload_0
    //   6829: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   6832: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6835: ldc 225
    //   6837: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6840: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6843: invokevirtual 174	java/lang/Thread:getId	()J
    //   6846: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6849: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6852: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6855: goto -4342 -> 2513
    //   6858: lload 12
    //   6860: lstore 14
    //   6862: lload 12
    //   6864: lstore 16
    //   6866: aload_0
    //   6867: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6870: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6873: getfield 811	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6876: istore 4
    //   6878: goto -228 -> 6650
    //   6881: lload 12
    //   6883: lstore 14
    //   6885: lload 12
    //   6887: lstore 16
    //   6889: aload_0
    //   6890: aload_0
    //   6891: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   6894: aload_0
    //   6895: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   6898: aload_0
    //   6899: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6902: aload_0
    //   6903: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6906: aload_0
    //   6907: getfield 795	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   6910: aload 30
    //   6912: invokestatic 914	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   6915: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   6918: goto -4295 -> 2623
    //   6921: lload 12
    //   6923: lstore 14
    //   6925: lload 12
    //   6927: lstore 16
    //   6929: aload_0
    //   6930: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6933: ifnull +9711 -> 16644
    //   6936: lload 12
    //   6938: lstore 14
    //   6940: lload 12
    //   6942: lstore 16
    //   6944: aload_0
    //   6945: aload_0
    //   6946: getfield 918	com/tencent/component/network/downloader/impl/FastDownloadTask:pokHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttp2Client;
    //   6949: aload_0
    //   6950: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6953: invokevirtual 924	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   6956: aload 30
    //   6958: invokevirtual 930	com/tencent/component/network/utils/http/base/QZoneHttp2Client:newCall	(Lcom/squareup/okhttp/Request;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lcom/squareup/okhttp/Call;
    //   6961: putfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6964: lload 12
    //   6966: lstore 14
    //   6968: lload 12
    //   6970: lstore 16
    //   6972: aload_0
    //   6973: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6976: invokevirtual 933	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   6979: astore 23
    //   6981: aconst_null
    //   6982: astore 22
    //   6984: aconst_null
    //   6985: astore 24
    //   6987: goto -4139 -> 2848
    //   6990: aload 23
    //   6992: ifnull +9646 -> 16638
    //   6995: aload 23
    //   6997: invokevirtual 936	com/squareup/okhttp/Response:code	()I
    //   7000: istore 4
    //   7002: goto -4103 -> 2899
    //   7005: aconst_null
    //   7006: astore 25
    //   7008: goto -3938 -> 3070
    //   7011: astore 24
    //   7013: ldc_w 428
    //   7016: astore 24
    //   7018: goto -3914 -> 3104
    //   7021: ldc_w 938
    //   7024: astore 26
    //   7026: goto -3747 -> 3279
    //   7029: aconst_null
    //   7030: astore 26
    //   7032: goto -3633 -> 3399
    //   7035: aload_0
    //   7036: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7039: astore 26
    //   7041: goto -3413 -> 3628
    //   7044: iconst_0
    //   7045: istore 5
    //   7047: goto -3388 -> 3659
    //   7050: aconst_null
    //   7051: astore 26
    //   7053: goto -3243 -> 3810
    //   7056: new 125	java/lang/StringBuilder
    //   7059: dup
    //   7060: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   7063: ldc_w 940
    //   7066: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7069: aload_0
    //   7070: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7073: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7076: ldc_w 527
    //   7079: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7082: aload_0
    //   7083: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7086: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7089: ldc_w 532
    //   7092: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7095: astore 30
    //   7097: aload_0
    //   7098: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7101: ifeq +560 -> 7661
    //   7104: aload 23
    //   7106: ifnull +555 -> 7661
    //   7109: aload 23
    //   7111: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7114: ifnull +547 -> 7661
    //   7117: aload 23
    //   7119: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7122: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   7125: astore 26
    //   7127: aload 30
    //   7129: aload 26
    //   7131: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7134: ldc_w 543
    //   7137: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7140: aload 27
    //   7142: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7145: ldc_w 548
    //   7148: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7151: aload 25
    //   7153: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7156: ldc_w 550
    //   7159: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7162: aconst_null
    //   7163: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7166: ldc_w 552
    //   7169: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7172: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7175: invokevirtual 174	java/lang/Thread:getId	()J
    //   7178: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7181: ldc_w 554
    //   7184: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7187: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7190: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7193: ldc_w 556
    //   7196: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7199: aload_0
    //   7200: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7203: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7206: ldc_w 558
    //   7209: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7212: aload_0
    //   7213: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7216: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7219: ldc_w 560
    //   7222: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7225: astore 30
    //   7227: aload_0
    //   7228: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7231: ifeq +438 -> 7669
    //   7234: aload_0
    //   7235: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7238: aload_0
    //   7239: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7242: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7245: astore 26
    //   7247: aload 30
    //   7249: aload 26
    //   7251: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7254: ldc_w 564
    //   7257: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7260: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7263: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7266: ldc_w 576
    //   7269: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7272: aload_2
    //   7273: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7276: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7279: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7282: ldc_w 581
    //   7285: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7288: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7291: aload_0
    //   7292: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7295: lsub
    //   7296: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7299: ldc_w 583
    //   7302: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7305: aload_2
    //   7306: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7309: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7312: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7315: ldc_w 588
    //   7318: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7321: aload_2
    //   7322: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7325: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7328: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7331: ldc_w 592
    //   7334: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7337: aload_2
    //   7338: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7341: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7344: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7347: ldc_w 597
    //   7350: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7353: aload_0
    //   7354: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   7357: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7360: ldc_w 599
    //   7363: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7366: aload_0
    //   7367: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   7370: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7373: ldc_w 942
    //   7376: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7379: iload 4
    //   7381: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7384: ldc_w 611
    //   7387: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7390: aload 28
    //   7392: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7395: ldc_w 571
    //   7398: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7401: aload_2
    //   7402: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7405: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7408: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7411: ldc_w 613
    //   7414: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7417: aload 24
    //   7419: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7422: ldc_w 615
    //   7425: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7428: astore 30
    //   7430: aload_0
    //   7431: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7434: ifnull +241 -> 7675
    //   7437: aload_0
    //   7438: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7441: iconst_0
    //   7442: bipush 30
    //   7444: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   7447: astore 26
    //   7449: aload 30
    //   7451: aload 26
    //   7453: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7456: ldc_w 621
    //   7459: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7462: astore 26
    //   7464: aload_0
    //   7465: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7468: ifnull +216 -> 7684
    //   7471: aload_0
    //   7472: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7475: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7478: istore 5
    //   7480: aload 26
    //   7482: iload 5
    //   7484: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7487: ldc_w 623
    //   7490: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7493: aload_2
    //   7494: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7497: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7500: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7503: ldc_w 628
    //   7506: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7509: lload 12
    //   7511: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7514: ldc_w 630
    //   7517: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7520: aload_0
    //   7521: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   7524: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7527: ldc_w 599
    //   7530: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7533: aload_0
    //   7534: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   7537: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7540: ldc_w 632
    //   7543: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7546: aload_0
    //   7547: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   7550: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7553: ldc_w 599
    //   7556: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7559: aload_0
    //   7560: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   7563: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7566: ldc_w 634
    //   7569: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7572: aload_0
    //   7573: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   7576: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7579: ldc_w 636
    //   7582: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7585: aload_0
    //   7586: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   7589: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7592: ldc_w 641
    //   7595: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7598: aload_0
    //   7599: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   7602: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7605: ldc_w 646
    //   7608: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7611: astore 30
    //   7613: aload_0
    //   7614: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7617: ifnull +73 -> 7690
    //   7620: aload_0
    //   7621: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7624: invokeinterface 656 1 0
    //   7629: astore 26
    //   7631: aload 29
    //   7633: aload 30
    //   7635: aload 26
    //   7637: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7640: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7643: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7646: ldc_w 447
    //   7649: aload 29
    //   7651: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7654: aconst_null
    //   7655: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7658: goto -3821 -> 3837
    //   7661: ldc_w 938
    //   7664: astore 26
    //   7666: goto -539 -> 7127
    //   7669: aconst_null
    //   7670: astore 26
    //   7672: goto -425 -> 7247
    //   7675: aload_0
    //   7676: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7679: astore 26
    //   7681: goto -232 -> 7449
    //   7684: iconst_0
    //   7685: istore 5
    //   7687: goto -207 -> 7480
    //   7690: aconst_null
    //   7691: astore 26
    //   7693: goto -62 -> 7631
    //   7696: iconst_0
    //   7697: istore 5
    //   7699: goto -3781 -> 3918
    //   7702: ldc_w 428
    //   7705: astore 24
    //   7707: goto -3657 -> 4050
    //   7710: astore 24
    //   7712: ldc 219
    //   7714: ldc_w 947
    //   7717: aload 24
    //   7719: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7722: goto -3596 -> 4126
    //   7725: astore 24
    //   7727: ldc 219
    //   7729: ldc_w 949
    //   7732: aload 24
    //   7734: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7737: goto -3561 -> 4176
    //   7740: iconst_0
    //   7741: istore 10
    //   7743: goto -3517 -> 4226
    //   7746: aload 27
    //   7748: invokevirtual 952	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7751: astore 22
    //   7753: goto -3459 -> 4294
    //   7756: iconst_0
    //   7757: istore 10
    //   7759: goto -3292 -> 4467
    //   7762: aload_0
    //   7763: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7766: ifnull +15 -> 7781
    //   7769: aload_0
    //   7770: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7773: invokevirtual 957	org/apache/http/client/methods/HttpGet:abort	()V
    //   7776: aload_0
    //   7777: aconst_null
    //   7778: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7781: aload_0
    //   7782: invokevirtual 960	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   7785: goto -3249 -> 4536
    //   7788: aload_2
    //   7789: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7792: lload 18
    //   7794: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7797: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   7800: aload_2
    //   7801: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7804: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7807: aload_0
    //   7808: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7811: lsub
    //   7812: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   7815: aload_2
    //   7816: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7819: aload_0
    //   7820: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   7823: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   7826: aload_0
    //   7827: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7830: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   7833: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   7836: astore 27
    //   7838: aload_0
    //   7839: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7842: ifnull +1488 -> 9330
    //   7845: aload_0
    //   7846: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7849: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7852: ifnull +1478 -> 9330
    //   7855: aload_0
    //   7856: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7859: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7862: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   7865: astore 25
    //   7867: aload_0
    //   7868: aload_0
    //   7869: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7872: aload 22
    //   7874: aload 23
    //   7876: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   7879: astore 28
    //   7881: aload 24
    //   7883: ifnull +8739 -> 16622
    //   7886: aload 24
    //   7888: ldc_w 492
    //   7891: invokeinterface 498 2 0
    //   7896: checkcast 282	java/lang/String
    //   7899: astore 24
    //   7901: aload_2
    //   7902: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7905: aload 24
    //   7907: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   7910: aload_0
    //   7911: lconst_0
    //   7912: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   7915: aload_0
    //   7916: iconst_0
    //   7917: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   7920: aload_0
    //   7921: lconst_0
    //   7922: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   7925: aload_0
    //   7926: iconst_0
    //   7927: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   7930: aload_2
    //   7931: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7934: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7937: ifeq +12 -> 7949
    //   7940: aload_1
    //   7941: invokeinterface 359 1 0
    //   7946: ifeq +31 -> 7977
    //   7949: aload_0
    //   7950: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   7953: ifnull +24 -> 7977
    //   7956: aload_0
    //   7957: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   7960: aload_0
    //   7961: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7964: aload_2
    //   7965: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   7968: aload 22
    //   7970: aload 23
    //   7972: invokeinterface 523 5 0
    //   7977: aload_1
    //   7978: invokeinterface 359 1 0
    //   7983: ifne +1320 -> 9303
    //   7986: aload_0
    //   7987: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7990: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   7993: istore 10
    //   7995: aload_2
    //   7996: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7999: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8002: ifne +1378 -> 9380
    //   8005: new 125	java/lang/StringBuilder
    //   8008: dup
    //   8009: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8012: ldc_w 525
    //   8015: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8018: aload_0
    //   8019: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8022: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8025: ldc_w 527
    //   8028: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8031: aload_0
    //   8032: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8035: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8038: ldc_w 532
    //   8041: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8044: astore 30
    //   8046: aload_0
    //   8047: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8050: ifeq +1296 -> 9346
    //   8053: aload 23
    //   8055: ifnull +1291 -> 9346
    //   8058: aload 23
    //   8060: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8063: ifnull +1283 -> 9346
    //   8066: aload 23
    //   8068: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8071: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   8074: astore 26
    //   8076: aload 30
    //   8078: aload 26
    //   8080: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8083: ldc_w 543
    //   8086: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8089: aload 27
    //   8091: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8094: ldc_w 548
    //   8097: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8100: aload 25
    //   8102: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8105: ldc_w 550
    //   8108: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8111: aconst_null
    //   8112: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8115: ldc_w 552
    //   8118: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8121: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8124: invokevirtual 174	java/lang/Thread:getId	()J
    //   8127: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8130: ldc_w 554
    //   8133: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8136: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8139: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8142: ldc_w 556
    //   8145: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8148: aload_0
    //   8149: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8152: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8155: ldc_w 558
    //   8158: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8161: aload_0
    //   8162: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8165: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8168: ldc_w 560
    //   8171: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8174: astore 30
    //   8176: aload_0
    //   8177: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8180: ifeq +1174 -> 9354
    //   8183: aload_0
    //   8184: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8187: aload_0
    //   8188: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8191: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8194: astore 26
    //   8196: aload 30
    //   8198: aload 26
    //   8200: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8203: ldc_w 562
    //   8206: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8209: iload 10
    //   8211: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8214: ldc_w 564
    //   8217: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8220: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8223: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8226: ldc_w 571
    //   8229: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8232: aload_2
    //   8233: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8236: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8239: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8242: ldc_w 576
    //   8245: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8248: aload_2
    //   8249: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8252: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8255: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8258: ldc_w 581
    //   8261: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8264: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8267: aload_0
    //   8268: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8271: lsub
    //   8272: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8275: ldc_w 583
    //   8278: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8281: aload_2
    //   8282: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8285: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8288: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8291: ldc_w 588
    //   8294: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8297: aload_2
    //   8298: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8301: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8304: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8307: ldc_w 592
    //   8310: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8313: aload_2
    //   8314: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8317: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8320: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8323: ldc_w 597
    //   8326: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8329: aload_0
    //   8330: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   8333: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8336: ldc_w 599
    //   8339: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8342: aload_0
    //   8343: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   8346: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8349: ldc_w 604
    //   8352: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8355: aload_2
    //   8356: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8359: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8362: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8365: ldc_w 609
    //   8368: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8371: iload 4
    //   8373: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8376: ldc_w 611
    //   8379: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8382: aload 28
    //   8384: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8387: ldc_w 613
    //   8390: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8393: aload 24
    //   8395: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8398: ldc_w 615
    //   8401: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8404: astore 30
    //   8406: aload_0
    //   8407: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8410: ifnull +950 -> 9360
    //   8413: aload_0
    //   8414: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8417: iconst_0
    //   8418: bipush 30
    //   8420: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   8423: astore 26
    //   8425: aload 30
    //   8427: aload 26
    //   8429: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8432: ldc_w 621
    //   8435: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8438: astore 26
    //   8440: aload_0
    //   8441: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8444: ifnull +925 -> 9369
    //   8447: aload_0
    //   8448: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8451: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8454: istore_3
    //   8455: aload 26
    //   8457: iload_3
    //   8458: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8461: ldc_w 623
    //   8464: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8467: aload_2
    //   8468: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8471: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8474: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8477: ldc_w 628
    //   8480: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8483: lload 12
    //   8485: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8488: ldc_w 630
    //   8491: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8494: aload_0
    //   8495: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8498: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8501: ldc_w 599
    //   8504: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8507: aload_0
    //   8508: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8511: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8514: ldc_w 632
    //   8517: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8520: aload_0
    //   8521: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8524: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8527: ldc_w 599
    //   8530: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8533: aload_0
    //   8534: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8537: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8540: ldc_w 634
    //   8543: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8546: aload_0
    //   8547: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   8550: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8553: ldc_w 636
    //   8556: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8559: aload_0
    //   8560: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   8563: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8566: ldc_w 641
    //   8569: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8572: aload_0
    //   8573: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   8576: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8579: ldc_w 646
    //   8582: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8585: astore 30
    //   8587: aload_0
    //   8588: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8591: ifnull +783 -> 9374
    //   8594: aload_0
    //   8595: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8598: invokeinterface 656 1 0
    //   8603: astore 26
    //   8605: aload 29
    //   8607: aload 30
    //   8609: aload 26
    //   8611: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8614: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8617: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8620: ldc_w 447
    //   8623: aload 29
    //   8625: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8628: aconst_null
    //   8629: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8632: iload 10
    //   8634: ifne +8 -> 8642
    //   8637: aload_0
    //   8638: iconst_0
    //   8639: putfield 662	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   8642: aload_2
    //   8643: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8646: astore 26
    //   8648: new 125	java/lang/StringBuilder
    //   8651: dup
    //   8652: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8655: aload_0
    //   8656: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8659: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8662: ldc_w 664
    //   8665: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8668: aload 25
    //   8670: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8673: ldc_w 666
    //   8676: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8679: aload_2
    //   8680: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8683: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8686: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8689: ldc_w 668
    //   8692: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8695: astore 25
    //   8697: aload_0
    //   8698: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8701: ifnull +1316 -> 10017
    //   8704: aload_0
    //   8705: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8708: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8711: istore_3
    //   8712: aload 25
    //   8714: iload_3
    //   8715: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8718: ldc_w 609
    //   8721: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8724: iload 4
    //   8726: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8729: ldc_w 571
    //   8732: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8735: aload_2
    //   8736: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8739: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8742: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8745: ldc_w 583
    //   8748: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8751: aload_2
    //   8752: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8755: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8758: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8761: ldc_w 588
    //   8764: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8767: aload_2
    //   8768: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8771: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8774: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8777: ldc_w 576
    //   8780: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8783: aload_2
    //   8784: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8787: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8790: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8793: ldc_w 581
    //   8796: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8799: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8802: aload_0
    //   8803: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8806: lsub
    //   8807: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8810: astore 25
    //   8812: aload 24
    //   8814: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8817: ifne +1205 -> 10022
    //   8820: new 125	java/lang/StringBuilder
    //   8823: dup
    //   8824: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8827: ldc_w 613
    //   8830: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8833: aload 24
    //   8835: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8838: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8841: astore 24
    //   8843: aload 26
    //   8845: aload 25
    //   8847: aload 24
    //   8849: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8852: ldc_w 611
    //   8855: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8858: aload 28
    //   8860: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8863: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8866: putfield 671	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   8869: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8872: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8875: aload_0
    //   8876: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8879: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8882: if_icmpne +37 -> 8919
    //   8885: aload_0
    //   8886: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8889: ifnull +30 -> 8919
    //   8892: aload_0
    //   8893: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8896: aload_0
    //   8897: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8900: aload_0
    //   8901: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8904: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   8907: aload_2
    //   8908: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8911: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8914: invokeinterface 678 4 0
    //   8919: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8922: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8925: aload_0
    //   8926: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8929: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8932: if_icmpne +37 -> 8969
    //   8935: aload_0
    //   8936: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8939: ifnull +30 -> 8969
    //   8942: aload_0
    //   8943: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8946: aload_0
    //   8947: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8950: aload_0
    //   8951: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8954: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   8957: aload_2
    //   8958: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8961: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8964: invokeinterface 678 4 0
    //   8969: iload 10
    //   8971: ifeq +64 -> 9035
    //   8974: aload_0
    //   8975: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8978: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   8981: astore 24
    //   8983: aload_0
    //   8984: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8987: astore 25
    //   8989: aload_0
    //   8990: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8993: ifeq +1067 -> 10060
    //   8996: aload_0
    //   8997: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9000: ifnull +1060 -> 10060
    //   9003: aload_0
    //   9004: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9007: ldc_w 680
    //   9010: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9013: ifeq +1047 -> 10060
    //   9016: iconst_1
    //   9017: istore 10
    //   9019: aload 24
    //   9021: aload 25
    //   9023: iload 10
    //   9025: aload_2
    //   9026: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9029: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9032: invokevirtual 684	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   9035: aload 29
    //   9037: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   9040: putfield 687	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   9043: aload 29
    //   9045: aload_0
    //   9046: invokevirtual 690	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   9049: putfield 693	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   9052: aload 29
    //   9054: aload 22
    //   9056: putfield 697	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   9059: aload 29
    //   9061: aload 23
    //   9063: putfield 701	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   9066: aload 29
    //   9068: iload 4
    //   9070: putfield 704	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   9073: aload 29
    //   9075: aconst_null
    //   9076: putfield 708	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   9079: aload 27
    //   9081: ifnonnull +985 -> 10066
    //   9084: aconst_null
    //   9085: astore 22
    //   9087: aload 29
    //   9089: aload 22
    //   9091: putfield 711	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   9094: aload 29
    //   9096: aconst_null
    //   9097: putfield 714	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9100: aload 29
    //   9102: aload_2
    //   9103: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9106: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9109: putfield 715	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9112: aload 29
    //   9114: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9117: aload_0
    //   9118: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9121: lsub
    //   9122: putfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9125: aload 29
    //   9127: aload_2
    //   9128: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9131: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9134: putfield 721	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9137: aload 29
    //   9139: aload 29
    //   9141: getfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9144: aload_2
    //   9145: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9148: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9151: lsub
    //   9152: putfield 724	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9155: aload 29
    //   9157: lload 12
    //   9159: putfield 727	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9162: aload 29
    //   9164: aload_0
    //   9165: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9168: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9171: aload 29
    //   9173: aload_0
    //   9174: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   9177: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9180: aload 29
    //   9182: aload_0
    //   9183: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   9186: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9189: aload 29
    //   9191: lconst_0
    //   9192: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9195: aload 29
    //   9197: aload_0
    //   9198: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   9201: putfield 742	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9204: aload 29
    //   9206: aload_2
    //   9207: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9210: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9213: putfield 745	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9216: aload 29
    //   9218: aload_0
    //   9219: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9222: invokestatic 748	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9225: putfield 750	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9228: aload 29
    //   9230: aload_0
    //   9231: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9234: putfield 753	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9237: aload_0
    //   9238: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9241: ifnull +835 -> 10076
    //   9244: aload_0
    //   9245: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9248: ldc_w 680
    //   9251: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9254: ifeq +822 -> 10076
    //   9257: iconst_1
    //   9258: istore 10
    //   9260: aload 29
    //   9262: iload 10
    //   9264: putfield 756	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9267: aload 29
    //   9269: aload_2
    //   9270: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9273: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9276: putfield 758	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9279: aload_2
    //   9280: aload 29
    //   9282: invokevirtual 762	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9285: aload_2
    //   9286: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9289: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9292: ifeq +11 -> 9303
    //   9295: aload_0
    //   9296: aload_1
    //   9297: aload_2
    //   9298: aload 29
    //   9300: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9303: aload_0
    //   9304: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9307: ifeq +775 -> 10082
    //   9310: aload_0
    //   9311: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   9314: ifnull +10 -> 9324
    //   9317: aload_0
    //   9318: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   9321: invokevirtual 771	com/squareup/okhttp/Call:cancel	()V
    //   9324: aload_0
    //   9325: aconst_null
    //   9326: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   9329: return
    //   9330: aconst_null
    //   9331: astore 25
    //   9333: goto -1466 -> 7867
    //   9336: astore 24
    //   9338: ldc_w 428
    //   9341: astore 24
    //   9343: goto -1442 -> 7901
    //   9346: ldc_w 938
    //   9349: astore 26
    //   9351: goto -1275 -> 8076
    //   9354: aconst_null
    //   9355: astore 26
    //   9357: goto -1161 -> 8196
    //   9360: aload_0
    //   9361: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9364: astore 26
    //   9366: goto -941 -> 8425
    //   9369: iconst_0
    //   9370: istore_3
    //   9371: goto -916 -> 8455
    //   9374: aconst_null
    //   9375: astore 26
    //   9377: goto -772 -> 8605
    //   9380: new 125	java/lang/StringBuilder
    //   9383: dup
    //   9384: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   9387: ldc_w 940
    //   9390: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9393: aload_0
    //   9394: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   9397: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9400: ldc_w 527
    //   9403: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9406: aload_0
    //   9407: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9410: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9413: ldc_w 532
    //   9416: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9419: astore 30
    //   9421: aload_0
    //   9422: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9425: ifeq +558 -> 9983
    //   9428: aload 23
    //   9430: ifnull +553 -> 9983
    //   9433: aload 23
    //   9435: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9438: ifnull +545 -> 9983
    //   9441: aload 23
    //   9443: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9446: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   9449: astore 26
    //   9451: aload 30
    //   9453: aload 26
    //   9455: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9458: ldc_w 543
    //   9461: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9464: aload 27
    //   9466: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9469: ldc_w 548
    //   9472: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9475: aload 25
    //   9477: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9480: ldc_w 550
    //   9483: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9486: aconst_null
    //   9487: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9490: ldc_w 552
    //   9493: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9496: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9499: invokevirtual 174	java/lang/Thread:getId	()J
    //   9502: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9505: ldc_w 554
    //   9508: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9511: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9514: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9517: ldc_w 556
    //   9520: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9523: aload_0
    //   9524: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9527: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9530: ldc_w 558
    //   9533: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9536: aload_0
    //   9537: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9540: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9543: ldc_w 560
    //   9546: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9549: astore 30
    //   9551: aload_0
    //   9552: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9555: ifeq +436 -> 9991
    //   9558: aload_0
    //   9559: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9562: aload_0
    //   9563: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9566: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9569: astore 26
    //   9571: aload 30
    //   9573: aload 26
    //   9575: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9578: ldc_w 564
    //   9581: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9584: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9587: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9590: ldc_w 576
    //   9593: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9596: aload_2
    //   9597: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9600: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9603: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9606: ldc_w 581
    //   9609: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9612: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9615: aload_0
    //   9616: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9619: lsub
    //   9620: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9623: ldc_w 583
    //   9626: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9629: aload_2
    //   9630: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9633: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9636: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9639: ldc_w 588
    //   9642: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9645: aload_2
    //   9646: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9649: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9652: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9655: ldc_w 592
    //   9658: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9661: aload_2
    //   9662: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9665: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9668: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9671: ldc_w 597
    //   9674: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9677: aload_0
    //   9678: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   9681: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9684: ldc_w 599
    //   9687: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9690: aload_0
    //   9691: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   9694: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9697: ldc_w 942
    //   9700: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9703: iload 4
    //   9705: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9708: ldc_w 611
    //   9711: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9714: aload 28
    //   9716: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9719: ldc_w 571
    //   9722: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9725: aload_2
    //   9726: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9729: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9732: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9735: ldc_w 613
    //   9738: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9741: aload 24
    //   9743: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9746: ldc_w 615
    //   9749: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9752: astore 30
    //   9754: aload_0
    //   9755: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9758: ifnull +239 -> 9997
    //   9761: aload_0
    //   9762: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9765: iconst_0
    //   9766: bipush 30
    //   9768: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   9771: astore 26
    //   9773: aload 30
    //   9775: aload 26
    //   9777: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9780: ldc_w 621
    //   9783: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9786: astore 26
    //   9788: aload_0
    //   9789: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9792: ifnull +214 -> 10006
    //   9795: aload_0
    //   9796: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9799: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9802: istore_3
    //   9803: aload 26
    //   9805: iload_3
    //   9806: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9809: ldc_w 623
    //   9812: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9815: aload_2
    //   9816: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9819: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9822: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9825: ldc_w 628
    //   9828: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9831: lload 12
    //   9833: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9836: ldc_w 630
    //   9839: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9842: aload_0
    //   9843: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9846: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9849: ldc_w 599
    //   9852: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9855: aload_0
    //   9856: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   9859: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9862: ldc_w 632
    //   9865: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9868: aload_0
    //   9869: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   9872: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9875: ldc_w 599
    //   9878: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9881: aload_0
    //   9882: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   9885: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9888: ldc_w 634
    //   9891: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9894: aload_0
    //   9895: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   9898: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9901: ldc_w 636
    //   9904: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9907: aload_0
    //   9908: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   9911: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9914: ldc_w 641
    //   9917: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9920: aload_0
    //   9921: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   9924: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9927: ldc_w 646
    //   9930: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9933: astore 30
    //   9935: aload_0
    //   9936: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9939: ifnull +72 -> 10011
    //   9942: aload_0
    //   9943: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9946: invokeinterface 656 1 0
    //   9951: astore 26
    //   9953: aload 29
    //   9955: aload 30
    //   9957: aload 26
    //   9959: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9962: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9965: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9968: ldc_w 447
    //   9971: aload 29
    //   9973: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9976: aconst_null
    //   9977: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9980: goto -1348 -> 8632
    //   9983: ldc_w 938
    //   9986: astore 26
    //   9988: goto -537 -> 9451
    //   9991: aconst_null
    //   9992: astore 26
    //   9994: goto -423 -> 9571
    //   9997: aload_0
    //   9998: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10001: astore 26
    //   10003: goto -230 -> 9773
    //   10006: iconst_0
    //   10007: istore_3
    //   10008: goto -205 -> 9803
    //   10011: aconst_null
    //   10012: astore 26
    //   10014: goto -61 -> 9953
    //   10017: iconst_0
    //   10018: istore_3
    //   10019: goto -1307 -> 8712
    //   10022: ldc_w 428
    //   10025: astore 24
    //   10027: goto -1184 -> 8843
    //   10030: astore 24
    //   10032: ldc 219
    //   10034: ldc_w 947
    //   10037: aload 24
    //   10039: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10042: goto -1123 -> 8919
    //   10045: astore 24
    //   10047: ldc 219
    //   10049: ldc_w 949
    //   10052: aload 24
    //   10054: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10057: goto -1088 -> 8969
    //   10060: iconst_0
    //   10061: istore 10
    //   10063: goto -1044 -> 9019
    //   10066: aload 27
    //   10068: invokevirtual 952	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10071: astore 22
    //   10073: goto -986 -> 9087
    //   10076: iconst_0
    //   10077: istore 10
    //   10079: goto -819 -> 9260
    //   10082: aload_0
    //   10083: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10086: ifnull +15 -> 10101
    //   10089: aload_0
    //   10090: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10093: invokevirtual 957	org/apache/http/client/methods/HttpGet:abort	()V
    //   10096: aload_0
    //   10097: aconst_null
    //   10098: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10101: aload_0
    //   10102: invokevirtual 960	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   10105: return
    //   10106: aload_2
    //   10107: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10110: lload 18
    //   10112: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10115: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   10118: aload_2
    //   10119: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10122: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10125: aload_0
    //   10126: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10129: lsub
    //   10130: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   10133: aload_2
    //   10134: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10137: aload_0
    //   10138: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   10141: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   10144: aload_0
    //   10145: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10148: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   10151: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   10154: astore 27
    //   10156: aload_0
    //   10157: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10160: ifnull +1488 -> 11648
    //   10163: aload_0
    //   10164: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10167: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10170: ifnull +1478 -> 11648
    //   10173: aload_0
    //   10174: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10177: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10180: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   10183: astore 25
    //   10185: aload_0
    //   10186: aload_0
    //   10187: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10190: aload 22
    //   10192: aload 23
    //   10194: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   10197: astore 28
    //   10199: aload 24
    //   10201: ifnull +6413 -> 16614
    //   10204: aload 24
    //   10206: ldc_w 492
    //   10209: invokeinterface 498 2 0
    //   10214: checkcast 282	java/lang/String
    //   10217: astore 24
    //   10219: aload_2
    //   10220: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10223: aload 24
    //   10225: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   10228: aload_0
    //   10229: lconst_0
    //   10230: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10233: aload_0
    //   10234: iconst_0
    //   10235: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10238: aload_0
    //   10239: lconst_0
    //   10240: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10243: aload_0
    //   10244: iconst_0
    //   10245: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10248: aload_2
    //   10249: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10252: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10255: ifeq +12 -> 10267
    //   10258: aload_1
    //   10259: invokeinterface 359 1 0
    //   10264: ifeq +31 -> 10295
    //   10267: aload_0
    //   10268: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10271: ifnull +24 -> 10295
    //   10274: aload_0
    //   10275: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10278: aload_0
    //   10279: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10282: aload_2
    //   10283: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   10286: aload 22
    //   10288: aload 23
    //   10290: invokeinterface 523 5 0
    //   10295: aload_1
    //   10296: invokeinterface 359 1 0
    //   10301: ifne +1320 -> 11621
    //   10304: aload_0
    //   10305: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10308: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10311: istore 10
    //   10313: aload_2
    //   10314: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10317: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10320: ifne +1378 -> 11698
    //   10323: new 125	java/lang/StringBuilder
    //   10326: dup
    //   10327: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   10330: ldc_w 525
    //   10333: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10336: aload_0
    //   10337: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10340: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10343: ldc_w 527
    //   10346: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10349: aload_0
    //   10350: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10353: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10356: ldc_w 532
    //   10359: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10362: astore 30
    //   10364: aload_0
    //   10365: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10368: ifeq +1296 -> 11664
    //   10371: aload 23
    //   10373: ifnull +1291 -> 11664
    //   10376: aload 23
    //   10378: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10381: ifnull +1283 -> 11664
    //   10384: aload 23
    //   10386: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10389: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   10392: astore 26
    //   10394: aload 30
    //   10396: aload 26
    //   10398: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10401: ldc_w 543
    //   10404: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10407: aload 27
    //   10409: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10412: ldc_w 548
    //   10415: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10418: aload 25
    //   10420: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10423: ldc_w 550
    //   10426: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10429: aconst_null
    //   10430: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10433: ldc_w 552
    //   10436: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10439: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10442: invokevirtual 174	java/lang/Thread:getId	()J
    //   10445: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10448: ldc_w 554
    //   10451: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10454: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10457: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10460: ldc_w 556
    //   10463: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10466: aload_0
    //   10467: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10470: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10473: ldc_w 558
    //   10476: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10479: aload_0
    //   10480: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10483: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10486: ldc_w 560
    //   10489: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10492: astore 30
    //   10494: aload_0
    //   10495: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10498: ifeq +1174 -> 11672
    //   10501: aload_0
    //   10502: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10505: aload_0
    //   10506: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10509: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10512: astore 26
    //   10514: aload 30
    //   10516: aload 26
    //   10518: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10521: ldc_w 562
    //   10524: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10527: iload 10
    //   10529: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10532: ldc_w 564
    //   10535: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10538: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10541: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10544: ldc_w 571
    //   10547: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10550: aload_2
    //   10551: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10554: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10557: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10560: ldc_w 576
    //   10563: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10566: aload_2
    //   10567: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10570: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10573: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10576: ldc_w 581
    //   10579: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10582: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10585: aload_0
    //   10586: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10589: lsub
    //   10590: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10593: ldc_w 583
    //   10596: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10599: aload_2
    //   10600: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10603: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10606: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10609: ldc_w 588
    //   10612: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10615: aload_2
    //   10616: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10619: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10622: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10625: ldc_w 592
    //   10628: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10631: aload_2
    //   10632: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10635: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10638: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10641: ldc_w 597
    //   10644: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10647: aload_0
    //   10648: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   10651: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10654: ldc_w 599
    //   10657: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10660: aload_0
    //   10661: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   10664: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10667: ldc_w 604
    //   10670: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10673: aload_2
    //   10674: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10677: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   10680: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10683: ldc_w 609
    //   10686: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10689: iload 4
    //   10691: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10694: ldc_w 611
    //   10697: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10700: aload 28
    //   10702: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10705: ldc_w 613
    //   10708: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10711: aload 24
    //   10713: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10716: ldc_w 615
    //   10719: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10722: astore 30
    //   10724: aload_0
    //   10725: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10728: ifnull +950 -> 11678
    //   10731: aload_0
    //   10732: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10735: iconst_0
    //   10736: bipush 30
    //   10738: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   10741: astore 26
    //   10743: aload 30
    //   10745: aload 26
    //   10747: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10750: ldc_w 621
    //   10753: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10756: astore 26
    //   10758: aload_0
    //   10759: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10762: ifnull +925 -> 11687
    //   10765: aload_0
    //   10766: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10769: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10772: istore_3
    //   10773: aload 26
    //   10775: iload_3
    //   10776: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10779: ldc_w 623
    //   10782: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10785: aload_2
    //   10786: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10789: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10792: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10795: ldc_w 628
    //   10798: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10801: lload 12
    //   10803: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10806: ldc_w 630
    //   10809: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10812: aload_0
    //   10813: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10816: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10819: ldc_w 599
    //   10822: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10825: aload_0
    //   10826: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10829: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10832: ldc_w 632
    //   10835: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10838: aload_0
    //   10839: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10842: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10845: ldc_w 599
    //   10848: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10851: aload_0
    //   10852: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10855: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10858: ldc_w 634
    //   10861: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10864: aload_0
    //   10865: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   10868: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10871: ldc_w 636
    //   10874: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10877: aload_0
    //   10878: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   10881: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10884: ldc_w 641
    //   10887: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10890: aload_0
    //   10891: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   10894: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10897: ldc_w 646
    //   10900: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10903: astore 30
    //   10905: aload_0
    //   10906: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10909: ifnull +783 -> 11692
    //   10912: aload_0
    //   10913: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10916: invokeinterface 656 1 0
    //   10921: astore 26
    //   10923: aload 29
    //   10925: aload 30
    //   10927: aload 26
    //   10929: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10932: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10935: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10938: ldc_w 447
    //   10941: aload 29
    //   10943: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10946: aconst_null
    //   10947: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10950: iload 10
    //   10952: ifne +8 -> 10960
    //   10955: aload_0
    //   10956: iconst_0
    //   10957: putfield 662	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   10960: aload_2
    //   10961: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10964: astore 26
    //   10966: new 125	java/lang/StringBuilder
    //   10969: dup
    //   10970: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   10973: aload_0
    //   10974: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10977: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10980: ldc_w 664
    //   10983: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10986: aload 25
    //   10988: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10991: ldc_w 666
    //   10994: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10997: aload_2
    //   10998: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11001: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11004: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11007: ldc_w 668
    //   11010: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11013: astore 25
    //   11015: aload_0
    //   11016: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11019: ifnull +1316 -> 12335
    //   11022: aload_0
    //   11023: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11026: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11029: istore_3
    //   11030: aload 25
    //   11032: iload_3
    //   11033: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11036: ldc_w 609
    //   11039: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11042: iload 4
    //   11044: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11047: ldc_w 571
    //   11050: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11053: aload_2
    //   11054: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11057: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11060: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11063: ldc_w 583
    //   11066: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11069: aload_2
    //   11070: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11073: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11076: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11079: ldc_w 588
    //   11082: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11085: aload_2
    //   11086: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11089: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11092: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11095: ldc_w 576
    //   11098: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11101: aload_2
    //   11102: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11105: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11108: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11111: ldc_w 581
    //   11114: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11117: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11120: aload_0
    //   11121: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11124: lsub
    //   11125: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11128: astore 25
    //   11130: aload 24
    //   11132: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11135: ifne +1205 -> 12340
    //   11138: new 125	java/lang/StringBuilder
    //   11141: dup
    //   11142: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11145: ldc_w 613
    //   11148: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11151: aload 24
    //   11153: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11156: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11159: astore 24
    //   11161: aload 26
    //   11163: aload 25
    //   11165: aload 24
    //   11167: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11170: ldc_w 611
    //   11173: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11176: aload 28
    //   11178: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11181: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11184: putfield 671	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   11187: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11190: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11193: aload_0
    //   11194: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11197: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11200: if_icmpne +37 -> 11237
    //   11203: aload_0
    //   11204: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11207: ifnull +30 -> 11237
    //   11210: aload_0
    //   11211: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11214: aload_0
    //   11215: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11218: aload_0
    //   11219: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11222: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11225: aload_2
    //   11226: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11229: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11232: invokeinterface 678 4 0
    //   11237: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11240: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11243: aload_0
    //   11244: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11247: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11250: if_icmpne +37 -> 11287
    //   11253: aload_0
    //   11254: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11257: ifnull +30 -> 11287
    //   11260: aload_0
    //   11261: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11264: aload_0
    //   11265: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11268: aload_0
    //   11269: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11272: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11275: aload_2
    //   11276: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11279: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11282: invokeinterface 678 4 0
    //   11287: iload 10
    //   11289: ifeq +64 -> 11353
    //   11292: aload_0
    //   11293: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11296: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   11299: astore 24
    //   11301: aload_0
    //   11302: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11305: astore 25
    //   11307: aload_0
    //   11308: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11311: ifeq +1067 -> 12378
    //   11314: aload_0
    //   11315: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11318: ifnull +1060 -> 12378
    //   11321: aload_0
    //   11322: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11325: ldc_w 680
    //   11328: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11331: ifeq +1047 -> 12378
    //   11334: iconst_1
    //   11335: istore 10
    //   11337: aload 24
    //   11339: aload 25
    //   11341: iload 10
    //   11343: aload_2
    //   11344: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11347: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11350: invokevirtual 684	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   11353: aload 29
    //   11355: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   11358: putfield 687	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   11361: aload 29
    //   11363: aload_0
    //   11364: invokevirtual 690	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   11367: putfield 693	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   11370: aload 29
    //   11372: aload 22
    //   11374: putfield 697	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   11377: aload 29
    //   11379: aload 23
    //   11381: putfield 701	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   11384: aload 29
    //   11386: iload 4
    //   11388: putfield 704	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   11391: aload 29
    //   11393: aconst_null
    //   11394: putfield 708	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   11397: aload 27
    //   11399: ifnonnull +985 -> 12384
    //   11402: aconst_null
    //   11403: astore 22
    //   11405: aload 29
    //   11407: aload 22
    //   11409: putfield 711	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   11412: aload 29
    //   11414: aconst_null
    //   11415: putfield 714	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   11418: aload 29
    //   11420: aload_2
    //   11421: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11424: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11427: putfield 715	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   11430: aload 29
    //   11432: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11435: aload_0
    //   11436: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11439: lsub
    //   11440: putfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11443: aload 29
    //   11445: aload_2
    //   11446: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11449: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11452: putfield 721	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   11455: aload 29
    //   11457: aload 29
    //   11459: getfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11462: aload_2
    //   11463: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11466: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11469: lsub
    //   11470: putfield 724	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   11473: aload 29
    //   11475: lload 12
    //   11477: putfield 727	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   11480: aload 29
    //   11482: aload_0
    //   11483: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11486: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   11489: aload 29
    //   11491: aload_0
    //   11492: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   11495: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11498: aload 29
    //   11500: aload_0
    //   11501: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11504: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11507: aload 29
    //   11509: lconst_0
    //   11510: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11513: aload 29
    //   11515: aload_0
    //   11516: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11519: putfield 742	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11522: aload 29
    //   11524: aload_2
    //   11525: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11528: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11531: putfield 745	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11534: aload 29
    //   11536: aload_0
    //   11537: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11540: invokestatic 748	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   11543: putfield 750	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11546: aload 29
    //   11548: aload_0
    //   11549: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11552: putfield 753	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11555: aload_0
    //   11556: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11559: ifnull +835 -> 12394
    //   11562: aload_0
    //   11563: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11566: ldc_w 680
    //   11569: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11572: ifeq +822 -> 12394
    //   11575: iconst_1
    //   11576: istore 10
    //   11578: aload 29
    //   11580: iload 10
    //   11582: putfield 756	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   11585: aload 29
    //   11587: aload_2
    //   11588: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11591: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11594: putfield 758	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11597: aload_2
    //   11598: aload 29
    //   11600: invokevirtual 762	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11603: aload_2
    //   11604: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11607: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11610: ifeq +11 -> 11621
    //   11613: aload_0
    //   11614: aload_1
    //   11615: aload_2
    //   11616: aload 29
    //   11618: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11621: aload_0
    //   11622: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11625: ifeq +775 -> 12400
    //   11628: aload_0
    //   11629: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   11632: ifnull +10 -> 11642
    //   11635: aload_0
    //   11636: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   11639: invokevirtual 771	com/squareup/okhttp/Call:cancel	()V
    //   11642: aload_0
    //   11643: aconst_null
    //   11644: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   11647: return
    //   11648: aconst_null
    //   11649: astore 25
    //   11651: goto -1466 -> 10185
    //   11654: astore 24
    //   11656: ldc_w 428
    //   11659: astore 24
    //   11661: goto -1442 -> 10219
    //   11664: ldc_w 938
    //   11667: astore 26
    //   11669: goto -1275 -> 10394
    //   11672: aconst_null
    //   11673: astore 26
    //   11675: goto -1161 -> 10514
    //   11678: aload_0
    //   11679: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11682: astore 26
    //   11684: goto -941 -> 10743
    //   11687: iconst_0
    //   11688: istore_3
    //   11689: goto -916 -> 10773
    //   11692: aconst_null
    //   11693: astore 26
    //   11695: goto -772 -> 10923
    //   11698: new 125	java/lang/StringBuilder
    //   11701: dup
    //   11702: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11705: ldc_w 940
    //   11708: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11711: aload_0
    //   11712: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11715: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11718: ldc_w 527
    //   11721: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11724: aload_0
    //   11725: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11728: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11731: ldc_w 532
    //   11734: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11737: astore 30
    //   11739: aload_0
    //   11740: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11743: ifeq +558 -> 12301
    //   11746: aload 23
    //   11748: ifnull +553 -> 12301
    //   11751: aload 23
    //   11753: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   11756: ifnull +545 -> 12301
    //   11759: aload 23
    //   11761: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   11764: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   11767: astore 26
    //   11769: aload 30
    //   11771: aload 26
    //   11773: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11776: ldc_w 543
    //   11779: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11782: aload 27
    //   11784: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11787: ldc_w 548
    //   11790: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11793: aload 25
    //   11795: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11798: ldc_w 550
    //   11801: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11804: aconst_null
    //   11805: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11808: ldc_w 552
    //   11811: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11814: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11817: invokevirtual 174	java/lang/Thread:getId	()J
    //   11820: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11823: ldc_w 554
    //   11826: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11829: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11832: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11835: ldc_w 556
    //   11838: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11841: aload_0
    //   11842: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   11845: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11848: ldc_w 558
    //   11851: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11854: aload_0
    //   11855: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   11858: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11861: ldc_w 560
    //   11864: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11867: astore 30
    //   11869: aload_0
    //   11870: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   11873: ifeq +436 -> 12309
    //   11876: aload_0
    //   11877: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11880: aload_0
    //   11881: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   11884: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   11887: astore 26
    //   11889: aload 30
    //   11891: aload 26
    //   11893: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11896: ldc_w 564
    //   11899: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11902: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   11905: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11908: ldc_w 576
    //   11911: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11914: aload_2
    //   11915: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11918: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11921: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11924: ldc_w 581
    //   11927: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11930: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11933: aload_0
    //   11934: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11937: lsub
    //   11938: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11941: ldc_w 583
    //   11944: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11947: aload_2
    //   11948: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11951: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11954: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11957: ldc_w 588
    //   11960: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11963: aload_2
    //   11964: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11967: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11970: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11973: ldc_w 592
    //   11976: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11979: aload_2
    //   11980: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11983: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   11986: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11989: ldc_w 597
    //   11992: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11995: aload_0
    //   11996: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   11999: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12002: ldc_w 599
    //   12005: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12008: aload_0
    //   12009: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   12012: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12015: ldc_w 942
    //   12018: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12021: iload 4
    //   12023: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12026: ldc_w 611
    //   12029: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12032: aload 28
    //   12034: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12037: ldc_w 571
    //   12040: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12043: aload_2
    //   12044: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12047: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12050: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12053: ldc_w 613
    //   12056: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12059: aload 24
    //   12061: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12064: ldc_w 615
    //   12067: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12070: astore 30
    //   12072: aload_0
    //   12073: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12076: ifnull +239 -> 12315
    //   12079: aload_0
    //   12080: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12083: iconst_0
    //   12084: bipush 30
    //   12086: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   12089: astore 26
    //   12091: aload 30
    //   12093: aload 26
    //   12095: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12098: ldc_w 621
    //   12101: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12104: astore 26
    //   12106: aload_0
    //   12107: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12110: ifnull +214 -> 12324
    //   12113: aload_0
    //   12114: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12117: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12120: istore_3
    //   12121: aload 26
    //   12123: iload_3
    //   12124: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12127: ldc_w 623
    //   12130: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12133: aload_2
    //   12134: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12137: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12140: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12143: ldc_w 628
    //   12146: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12149: lload 12
    //   12151: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12154: ldc_w 630
    //   12157: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12160: aload_0
    //   12161: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12164: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12167: ldc_w 599
    //   12170: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12173: aload_0
    //   12174: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12177: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12180: ldc_w 632
    //   12183: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12186: aload_0
    //   12187: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12190: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12193: ldc_w 599
    //   12196: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12199: aload_0
    //   12200: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12203: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12206: ldc_w 634
    //   12209: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12212: aload_0
    //   12213: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   12216: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12219: ldc_w 636
    //   12222: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12225: aload_0
    //   12226: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   12229: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12232: ldc_w 641
    //   12235: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12238: aload_0
    //   12239: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   12242: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12245: ldc_w 646
    //   12248: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12251: astore 30
    //   12253: aload_0
    //   12254: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12257: ifnull +72 -> 12329
    //   12260: aload_0
    //   12261: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12264: invokeinterface 656 1 0
    //   12269: astore 26
    //   12271: aload 29
    //   12273: aload 30
    //   12275: aload 26
    //   12277: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12280: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12283: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12286: ldc_w 447
    //   12289: aload 29
    //   12291: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12294: aconst_null
    //   12295: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12298: goto -1348 -> 10950
    //   12301: ldc_w 938
    //   12304: astore 26
    //   12306: goto -537 -> 11769
    //   12309: aconst_null
    //   12310: astore 26
    //   12312: goto -423 -> 11889
    //   12315: aload_0
    //   12316: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12319: astore 26
    //   12321: goto -230 -> 12091
    //   12324: iconst_0
    //   12325: istore_3
    //   12326: goto -205 -> 12121
    //   12329: aconst_null
    //   12330: astore 26
    //   12332: goto -61 -> 12271
    //   12335: iconst_0
    //   12336: istore_3
    //   12337: goto -1307 -> 11030
    //   12340: ldc_w 428
    //   12343: astore 24
    //   12345: goto -1184 -> 11161
    //   12348: astore 24
    //   12350: ldc 219
    //   12352: ldc_w 947
    //   12355: aload 24
    //   12357: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12360: goto -1123 -> 11237
    //   12363: astore 24
    //   12365: ldc 219
    //   12367: ldc_w 949
    //   12370: aload 24
    //   12372: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12375: goto -1088 -> 11287
    //   12378: iconst_0
    //   12379: istore 10
    //   12381: goto -1044 -> 11337
    //   12384: aload 27
    //   12386: invokevirtual 952	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   12389: astore 22
    //   12391: goto -986 -> 11405
    //   12394: iconst_0
    //   12395: istore 10
    //   12397: goto -819 -> 11578
    //   12400: aload_0
    //   12401: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12404: ifnull +15 -> 12419
    //   12407: aload_0
    //   12408: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12411: invokevirtual 957	org/apache/http/client/methods/HttpGet:abort	()V
    //   12414: aload_0
    //   12415: aconst_null
    //   12416: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12419: aload_0
    //   12420: invokevirtual 960	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   12423: return
    //   12424: sipush 416
    //   12427: iload 4
    //   12429: if_icmpne +1600 -> 14029
    //   12432: aload_0
    //   12433: ldc_w 962
    //   12436: invokevirtual 965	com/tencent/component/network/downloader/impl/FastDownloadTask:removeHttpParam	(Ljava/lang/String;)V
    //   12439: aload_2
    //   12440: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12443: bipush 7
    //   12445: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   12448: iload 4
    //   12450: istore 5
    //   12452: aload_0
    //   12453: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12456: ifnull +21 -> 12477
    //   12459: aload_0
    //   12460: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12463: aload_0
    //   12464: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12467: iconst_1
    //   12468: invokeinterface 969 3 0
    //   12473: iload 4
    //   12475: istore 5
    //   12477: aload_2
    //   12478: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12481: lload 18
    //   12483: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12486: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   12489: aload_2
    //   12490: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12493: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12496: aload_0
    //   12497: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12500: lsub
    //   12501: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   12504: aload_2
    //   12505: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12508: aload_0
    //   12509: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   12512: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   12515: aload_0
    //   12516: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12519: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   12522: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   12525: astore 27
    //   12527: aload_0
    //   12528: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12531: ifnull +1540 -> 14071
    //   12534: aload_0
    //   12535: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12538: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12541: ifnull +1530 -> 14071
    //   12544: aload_0
    //   12545: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12548: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12551: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   12554: astore 25
    //   12556: aload_0
    //   12557: aload_0
    //   12558: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12561: aload 22
    //   12563: aload 23
    //   12565: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   12568: astore 28
    //   12570: aload 24
    //   12572: ifnull +4034 -> 16606
    //   12575: aload 24
    //   12577: ldc_w 492
    //   12580: invokeinterface 498 2 0
    //   12585: checkcast 282	java/lang/String
    //   12588: astore 24
    //   12590: aload_2
    //   12591: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12594: aload 24
    //   12596: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   12599: aload_0
    //   12600: lconst_0
    //   12601: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12604: aload_0
    //   12605: iconst_0
    //   12606: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12609: aload_0
    //   12610: lconst_0
    //   12611: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12614: aload_0
    //   12615: iconst_0
    //   12616: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12619: aload_2
    //   12620: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12623: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12626: ifeq +12 -> 12638
    //   12629: aload_1
    //   12630: invokeinterface 359 1 0
    //   12635: ifeq +31 -> 12666
    //   12638: aload_0
    //   12639: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12642: ifnull +24 -> 12666
    //   12645: aload_0
    //   12646: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12649: aload_0
    //   12650: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12653: aload_2
    //   12654: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   12657: aload 22
    //   12659: aload 23
    //   12661: invokeinterface 523 5 0
    //   12666: aload_1
    //   12667: invokeinterface 359 1 0
    //   12672: ifne +1324 -> 13996
    //   12675: aload_0
    //   12676: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12679: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   12682: istore 10
    //   12684: aload_2
    //   12685: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12688: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12691: ifne +1431 -> 14122
    //   12694: new 125	java/lang/StringBuilder
    //   12697: dup
    //   12698: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   12701: ldc_w 525
    //   12704: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12707: aload_0
    //   12708: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12711: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12714: ldc_w 527
    //   12717: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12720: aload_0
    //   12721: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12724: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12727: ldc_w 532
    //   12730: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12733: astore 30
    //   12735: aload_0
    //   12736: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12739: ifeq +1348 -> 14087
    //   12742: aload 23
    //   12744: ifnull +1343 -> 14087
    //   12747: aload 23
    //   12749: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   12752: ifnull +1335 -> 14087
    //   12755: aload 23
    //   12757: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   12760: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   12763: astore 26
    //   12765: aload 30
    //   12767: aload 26
    //   12769: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12772: ldc_w 543
    //   12775: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12778: aload 27
    //   12780: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12783: ldc_w 548
    //   12786: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12789: aload 25
    //   12791: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12794: ldc_w 550
    //   12797: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12800: aconst_null
    //   12801: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12804: ldc_w 552
    //   12807: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12810: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12813: invokevirtual 174	java/lang/Thread:getId	()J
    //   12816: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12819: ldc_w 554
    //   12822: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12825: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12828: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12831: ldc_w 556
    //   12834: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12837: aload_0
    //   12838: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12841: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12844: ldc_w 558
    //   12847: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12850: aload_0
    //   12851: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12854: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12857: ldc_w 560
    //   12860: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12863: astore 30
    //   12865: aload_0
    //   12866: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12869: ifeq +1226 -> 14095
    //   12872: aload_0
    //   12873: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12876: aload_0
    //   12877: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12880: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   12883: astore 26
    //   12885: aload 30
    //   12887: aload 26
    //   12889: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12892: ldc_w 562
    //   12895: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12898: iload 10
    //   12900: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12903: ldc_w 564
    //   12906: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12909: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12912: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12915: ldc_w 571
    //   12918: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12921: aload_2
    //   12922: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12925: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12928: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12931: ldc_w 576
    //   12934: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12937: aload_2
    //   12938: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12941: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12944: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12947: ldc_w 581
    //   12950: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12953: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12956: aload_0
    //   12957: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12960: lsub
    //   12961: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12964: ldc_w 583
    //   12967: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12970: aload_2
    //   12971: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12974: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12977: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12980: ldc_w 588
    //   12983: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12986: aload_2
    //   12987: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12990: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12993: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12996: ldc_w 592
    //   12999: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13002: aload_2
    //   13003: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13006: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   13009: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13012: ldc_w 597
    //   13015: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13018: aload_0
    //   13019: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   13022: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13025: ldc_w 599
    //   13028: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13031: aload_0
    //   13032: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   13035: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13038: ldc_w 604
    //   13041: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13044: aload_2
    //   13045: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13048: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   13051: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13054: ldc_w 609
    //   13057: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13060: iload 5
    //   13062: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13065: ldc_w 611
    //   13068: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13071: aload 28
    //   13073: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13076: ldc_w 613
    //   13079: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13082: aload 24
    //   13084: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13087: ldc_w 615
    //   13090: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13093: astore 30
    //   13095: aload_0
    //   13096: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13099: ifnull +1002 -> 14101
    //   13102: aload_0
    //   13103: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13106: iconst_0
    //   13107: bipush 30
    //   13109: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   13112: astore 26
    //   13114: aload 30
    //   13116: aload 26
    //   13118: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13121: ldc_w 621
    //   13124: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13127: astore 26
    //   13129: aload_0
    //   13130: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13133: ifnull +977 -> 14110
    //   13136: aload_0
    //   13137: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13140: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13143: istore 4
    //   13145: aload 26
    //   13147: iload 4
    //   13149: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13152: ldc_w 623
    //   13155: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13158: aload_2
    //   13159: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13162: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13165: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13168: ldc_w 628
    //   13171: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13174: lload 12
    //   13176: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13179: ldc_w 630
    //   13182: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13185: aload_0
    //   13186: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13189: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13192: ldc_w 599
    //   13195: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13198: aload_0
    //   13199: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   13202: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13205: ldc_w 632
    //   13208: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13211: aload_0
    //   13212: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   13215: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13218: ldc_w 599
    //   13221: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13224: aload_0
    //   13225: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   13228: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13231: ldc_w 634
    //   13234: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13237: aload_0
    //   13238: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   13241: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13244: ldc_w 636
    //   13247: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13250: aload_0
    //   13251: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   13254: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13257: ldc_w 641
    //   13260: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13263: aload_0
    //   13264: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   13267: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13270: ldc_w 646
    //   13273: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13276: astore 30
    //   13278: aload_0
    //   13279: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13282: ifnull +834 -> 14116
    //   13285: aload_0
    //   13286: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13289: invokeinterface 656 1 0
    //   13294: astore 26
    //   13296: aload 29
    //   13298: aload 30
    //   13300: aload 26
    //   13302: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13305: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13308: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13311: ldc_w 447
    //   13314: aload 29
    //   13316: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13319: aconst_null
    //   13320: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   13323: iload 10
    //   13325: ifne +8 -> 13333
    //   13328: aload_0
    //   13329: iconst_0
    //   13330: putfield 662	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   13333: aload_2
    //   13334: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13337: astore 26
    //   13339: new 125	java/lang/StringBuilder
    //   13342: dup
    //   13343: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13346: aload_0
    //   13347: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13350: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13353: ldc_w 664
    //   13356: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13359: aload 25
    //   13361: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13364: ldc_w 666
    //   13367: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13370: aload_2
    //   13371: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13374: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13377: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13380: ldc_w 668
    //   13383: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13386: astore 25
    //   13388: aload_0
    //   13389: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13392: ifnull +1370 -> 14762
    //   13395: aload_0
    //   13396: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13399: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13402: istore 4
    //   13404: aload 25
    //   13406: iload 4
    //   13408: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13411: ldc_w 609
    //   13414: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13417: iload 5
    //   13419: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13422: ldc_w 571
    //   13425: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13428: aload_2
    //   13429: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13432: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13435: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13438: ldc_w 583
    //   13441: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13444: aload_2
    //   13445: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13448: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13451: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13454: ldc_w 588
    //   13457: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13460: aload_2
    //   13461: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13464: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13467: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13470: ldc_w 576
    //   13473: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13476: aload_2
    //   13477: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13480: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13483: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13486: ldc_w 581
    //   13489: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13492: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13495: aload_0
    //   13496: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13499: lsub
    //   13500: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13503: astore 25
    //   13505: aload 24
    //   13507: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13510: ifne +1258 -> 14768
    //   13513: new 125	java/lang/StringBuilder
    //   13516: dup
    //   13517: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13520: ldc_w 613
    //   13523: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13526: aload 24
    //   13528: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13531: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13534: astore 24
    //   13536: aload 26
    //   13538: aload 25
    //   13540: aload 24
    //   13542: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13545: ldc_w 611
    //   13548: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13551: aload 28
    //   13553: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13556: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13559: putfield 671	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   13562: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13565: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13568: aload_0
    //   13569: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13572: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13575: if_icmpne +37 -> 13612
    //   13578: aload_0
    //   13579: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13582: ifnull +30 -> 13612
    //   13585: aload_0
    //   13586: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13589: aload_0
    //   13590: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13593: aload_0
    //   13594: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13597: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   13600: aload_2
    //   13601: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13604: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13607: invokeinterface 678 4 0
    //   13612: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13615: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13618: aload_0
    //   13619: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13622: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13625: if_icmpne +37 -> 13662
    //   13628: aload_0
    //   13629: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13632: ifnull +30 -> 13662
    //   13635: aload_0
    //   13636: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13639: aload_0
    //   13640: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13643: aload_0
    //   13644: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13647: invokestatic 674	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   13650: aload_2
    //   13651: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13654: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13657: invokeinterface 678 4 0
    //   13662: iload 10
    //   13664: ifeq +64 -> 13728
    //   13667: aload_0
    //   13668: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13671: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   13674: astore 24
    //   13676: aload_0
    //   13677: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13680: astore 25
    //   13682: aload_0
    //   13683: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   13686: ifeq +1120 -> 14806
    //   13689: aload_0
    //   13690: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13693: ifnull +1113 -> 14806
    //   13696: aload_0
    //   13697: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13700: ldc_w 680
    //   13703: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13706: ifeq +1100 -> 14806
    //   13709: iconst_1
    //   13710: istore 10
    //   13712: aload 24
    //   13714: aload 25
    //   13716: iload 10
    //   13718: aload_2
    //   13719: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13722: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13725: invokevirtual 684	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   13728: aload 29
    //   13730: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   13733: putfield 687	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   13736: aload 29
    //   13738: aload_0
    //   13739: invokevirtual 690	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   13742: putfield 693	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   13745: aload 29
    //   13747: aload 22
    //   13749: putfield 697	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   13752: aload 29
    //   13754: aload 23
    //   13756: putfield 701	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   13759: aload 29
    //   13761: iload 5
    //   13763: putfield 704	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   13766: aload 29
    //   13768: aconst_null
    //   13769: putfield 708	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   13772: aload 27
    //   13774: ifnonnull +1038 -> 14812
    //   13777: aconst_null
    //   13778: astore 22
    //   13780: aload 29
    //   13782: aload 22
    //   13784: putfield 711	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   13787: aload 29
    //   13789: aconst_null
    //   13790: putfield 714	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   13793: aload 29
    //   13795: aload_2
    //   13796: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13799: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13802: putfield 715	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   13805: aload 29
    //   13807: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13810: aload_0
    //   13811: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13814: lsub
    //   13815: putfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13818: aload 29
    //   13820: aload_2
    //   13821: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13824: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13827: putfield 721	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   13830: aload 29
    //   13832: aload 29
    //   13834: getfield 718	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13837: aload_2
    //   13838: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13841: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13844: lsub
    //   13845: putfield 724	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   13848: aload 29
    //   13850: lload 12
    //   13852: putfield 727	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   13855: aload 29
    //   13857: aload_0
    //   13858: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13861: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   13864: aload 29
    //   13866: aload_0
    //   13867: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   13870: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   13873: aload 29
    //   13875: aload_0
    //   13876: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   13879: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   13882: aload 29
    //   13884: lconst_0
    //   13885: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   13888: aload 29
    //   13890: aload_0
    //   13891: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   13894: putfield 742	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   13897: aload 29
    //   13899: aload_2
    //   13900: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13903: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13906: putfield 745	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   13909: aload 29
    //   13911: aload_0
    //   13912: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13915: invokestatic 748	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   13918: putfield 750	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   13921: aload 29
    //   13923: aload_0
    //   13924: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   13927: putfield 753	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   13930: aload_0
    //   13931: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13934: ifnull +888 -> 14822
    //   13937: aload_0
    //   13938: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13941: ldc_w 680
    //   13944: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13947: ifeq +875 -> 14822
    //   13950: iconst_1
    //   13951: istore 10
    //   13953: aload 29
    //   13955: iload 10
    //   13957: putfield 756	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   13960: aload 29
    //   13962: aload_2
    //   13963: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13966: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13969: putfield 758	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   13972: aload_2
    //   13973: aload 29
    //   13975: invokevirtual 762	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   13978: aload_2
    //   13979: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13982: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13985: ifeq +11 -> 13996
    //   13988: aload_0
    //   13989: aload_1
    //   13990: aload_2
    //   13991: aload 29
    //   13993: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   13996: aload_0
    //   13997: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14000: ifeq +828 -> 14828
    //   14003: aload_0
    //   14004: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   14007: ifnull +10 -> 14017
    //   14010: aload_0
    //   14011: getfield 766	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   14014: invokevirtual 771	com/squareup/okhttp/Call:cancel	()V
    //   14017: aload_0
    //   14018: aconst_null
    //   14019: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   14022: iload_3
    //   14023: iconst_1
    //   14024: iadd
    //   14025: istore_3
    //   14026: goto -13821 -> 205
    //   14029: aload_2
    //   14030: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14033: iconst_3
    //   14034: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14037: goto -1589 -> 12448
    //   14040: astore 25
    //   14042: aload 22
    //   14044: astore 26
    //   14046: aload 23
    //   14048: astore 22
    //   14050: aload 26
    //   14052: astore 23
    //   14054: goto -13802 -> 252
    //   14057: aload_2
    //   14058: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14061: iconst_3
    //   14062: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14065: iconst_0
    //   14066: istore 5
    //   14068: goto -1591 -> 12477
    //   14071: aconst_null
    //   14072: astore 25
    //   14074: goto -1518 -> 12556
    //   14077: astore 24
    //   14079: ldc_w 428
    //   14082: astore 24
    //   14084: goto -1494 -> 12590
    //   14087: ldc_w 938
    //   14090: astore 26
    //   14092: goto -1327 -> 12765
    //   14095: aconst_null
    //   14096: astore 26
    //   14098: goto -1213 -> 12885
    //   14101: aload_0
    //   14102: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14105: astore 26
    //   14107: goto -993 -> 13114
    //   14110: iconst_0
    //   14111: istore 4
    //   14113: goto -968 -> 13145
    //   14116: aconst_null
    //   14117: astore 26
    //   14119: goto -823 -> 13296
    //   14122: new 125	java/lang/StringBuilder
    //   14125: dup
    //   14126: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   14129: ldc_w 940
    //   14132: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14135: aload_0
    //   14136: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   14139: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14142: ldc_w 527
    //   14145: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14148: aload_0
    //   14149: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14152: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14155: ldc_w 532
    //   14158: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14161: astore 30
    //   14163: aload_0
    //   14164: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14167: ifeq +560 -> 14727
    //   14170: aload 23
    //   14172: ifnull +555 -> 14727
    //   14175: aload 23
    //   14177: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   14180: ifnull +547 -> 14727
    //   14183: aload 23
    //   14185: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   14188: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   14191: astore 26
    //   14193: aload 30
    //   14195: aload 26
    //   14197: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14200: ldc_w 543
    //   14203: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14206: aload 27
    //   14208: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14211: ldc_w 548
    //   14214: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14217: aload 25
    //   14219: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14222: ldc_w 550
    //   14225: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14228: aconst_null
    //   14229: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14232: ldc_w 552
    //   14235: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14238: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14241: invokevirtual 174	java/lang/Thread:getId	()J
    //   14244: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14247: ldc_w 554
    //   14250: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14253: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   14256: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14259: ldc_w 556
    //   14262: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14265: aload_0
    //   14266: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14269: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14272: ldc_w 558
    //   14275: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14278: aload_0
    //   14279: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14282: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14285: ldc_w 560
    //   14288: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14291: astore 30
    //   14293: aload_0
    //   14294: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14297: ifeq +438 -> 14735
    //   14300: aload_0
    //   14301: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   14304: aload_0
    //   14305: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14308: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   14311: astore 26
    //   14313: aload 30
    //   14315: aload 26
    //   14317: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14320: ldc_w 564
    //   14323: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14326: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   14329: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14332: ldc_w 576
    //   14335: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14338: aload_2
    //   14339: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14342: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14345: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14348: ldc_w 581
    //   14351: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14354: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14357: aload_0
    //   14358: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14361: lsub
    //   14362: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14365: ldc_w 583
    //   14368: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14371: aload_2
    //   14372: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14375: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   14378: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14381: ldc_w 588
    //   14384: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14387: aload_2
    //   14388: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14391: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   14394: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14397: ldc_w 592
    //   14400: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14403: aload_2
    //   14404: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14407: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   14410: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14413: ldc_w 597
    //   14416: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14419: aload_0
    //   14420: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   14423: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14426: ldc_w 599
    //   14429: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14432: aload_0
    //   14433: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   14436: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14439: ldc_w 942
    //   14442: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14445: iload 5
    //   14447: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14450: ldc_w 611
    //   14453: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14456: aload 28
    //   14458: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14461: ldc_w 571
    //   14464: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14467: aload_2
    //   14468: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14471: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14474: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14477: ldc_w 613
    //   14480: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14483: aload 24
    //   14485: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14488: ldc_w 615
    //   14491: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14494: astore 30
    //   14496: aload_0
    //   14497: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14500: ifnull +241 -> 14741
    //   14503: aload_0
    //   14504: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14507: iconst_0
    //   14508: bipush 30
    //   14510: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   14513: astore 26
    //   14515: aload 30
    //   14517: aload 26
    //   14519: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14522: ldc_w 621
    //   14525: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14528: astore 26
    //   14530: aload_0
    //   14531: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14534: ifnull +216 -> 14750
    //   14537: aload_0
    //   14538: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14541: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14544: istore 4
    //   14546: aload 26
    //   14548: iload 4
    //   14550: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14553: ldc_w 623
    //   14556: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14559: aload_2
    //   14560: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14563: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14566: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14569: ldc_w 628
    //   14572: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14575: lload 12
    //   14577: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14580: ldc_w 630
    //   14583: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14586: aload_0
    //   14587: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   14590: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14593: ldc_w 599
    //   14596: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14599: aload_0
    //   14600: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   14603: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14606: ldc_w 632
    //   14609: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14612: aload_0
    //   14613: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   14616: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14619: ldc_w 599
    //   14622: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14625: aload_0
    //   14626: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   14629: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14632: ldc_w 634
    //   14635: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14638: aload_0
    //   14639: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   14642: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14645: ldc_w 636
    //   14648: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14651: aload_0
    //   14652: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   14655: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14658: ldc_w 641
    //   14661: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14664: aload_0
    //   14665: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   14668: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14671: ldc_w 646
    //   14674: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14677: astore 30
    //   14679: aload_0
    //   14680: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14683: ifnull +73 -> 14756
    //   14686: aload_0
    //   14687: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14690: invokeinterface 656 1 0
    //   14695: astore 26
    //   14697: aload 29
    //   14699: aload 30
    //   14701: aload 26
    //   14703: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14706: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14709: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   14712: ldc_w 447
    //   14715: aload 29
    //   14717: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   14720: aconst_null
    //   14721: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14724: goto -1401 -> 13323
    //   14727: ldc_w 938
    //   14730: astore 26
    //   14732: goto -539 -> 14193
    //   14735: aconst_null
    //   14736: astore 26
    //   14738: goto -425 -> 14313
    //   14741: aload_0
    //   14742: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14745: astore 26
    //   14747: goto -232 -> 14515
    //   14750: iconst_0
    //   14751: istore 4
    //   14753: goto -207 -> 14546
    //   14756: aconst_null
    //   14757: astore 26
    //   14759: goto -62 -> 14697
    //   14762: iconst_0
    //   14763: istore 4
    //   14765: goto -1361 -> 13404
    //   14768: ldc_w 428
    //   14771: astore 24
    //   14773: goto -1237 -> 13536
    //   14776: astore 24
    //   14778: ldc 219
    //   14780: ldc_w 947
    //   14783: aload 24
    //   14785: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14788: goto -1176 -> 13612
    //   14791: astore 24
    //   14793: ldc 219
    //   14795: ldc_w 949
    //   14798: aload 24
    //   14800: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14803: goto -1141 -> 13662
    //   14806: iconst_0
    //   14807: istore 10
    //   14809: goto -1097 -> 13712
    //   14812: aload 27
    //   14814: invokevirtual 952	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   14817: astore 22
    //   14819: goto -1039 -> 13780
    //   14822: iconst_0
    //   14823: istore 10
    //   14825: goto -872 -> 13953
    //   14828: aload_0
    //   14829: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   14832: ifnull +15 -> 14847
    //   14835: aload_0
    //   14836: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   14839: invokevirtual 957	org/apache/http/client/methods/HttpGet:abort	()V
    //   14842: aload_0
    //   14843: aconst_null
    //   14844: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   14847: aload_0
    //   14848: invokevirtual 960	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   14851: goto -829 -> 14022
    //   14854: aconst_null
    //   14855: astore 26
    //   14857: goto -14446 -> 411
    //   14860: astore 24
    //   14862: ldc_w 428
    //   14865: astore 24
    //   14867: goto -14422 -> 445
    //   14870: ldc_w 938
    //   14873: astore 27
    //   14875: goto -14255 -> 620
    //   14878: aconst_null
    //   14879: astore 27
    //   14881: goto -14141 -> 740
    //   14884: aload_0
    //   14885: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14888: astore 27
    //   14890: goto -13921 -> 969
    //   14893: iconst_0
    //   14894: istore_3
    //   14895: goto -13896 -> 999
    //   14898: aconst_null
    //   14899: astore 27
    //   14901: goto -13752 -> 1149
    //   14904: new 125	java/lang/StringBuilder
    //   14907: dup
    //   14908: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   14911: ldc_w 940
    //   14914: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14917: aload_0
    //   14918: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   14921: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14924: ldc_w 527
    //   14927: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14930: aload_0
    //   14931: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14934: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14937: ldc_w 532
    //   14940: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14943: astore 31
    //   14945: aload_0
    //   14946: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14949: ifeq +558 -> 15507
    //   14952: aload 22
    //   14954: ifnull +553 -> 15507
    //   14957: aload 22
    //   14959: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   14962: ifnull +545 -> 15507
    //   14965: aload 22
    //   14967: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   14970: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   14973: astore 27
    //   14975: aload 31
    //   14977: aload 27
    //   14979: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14982: ldc_w 543
    //   14985: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14988: aload 28
    //   14990: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14993: ldc_w 548
    //   14996: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14999: aload 26
    //   15001: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15004: ldc_w 550
    //   15007: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15010: aconst_null
    //   15011: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15014: ldc_w 552
    //   15017: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15020: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15023: invokevirtual 174	java/lang/Thread:getId	()J
    //   15026: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15029: ldc_w 554
    //   15032: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15035: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   15038: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15041: ldc_w 556
    //   15044: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15047: aload_0
    //   15048: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15051: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15054: ldc_w 558
    //   15057: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15060: aload_0
    //   15061: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15064: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15067: ldc_w 560
    //   15070: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15073: astore 31
    //   15075: aload_0
    //   15076: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15079: ifeq +436 -> 15515
    //   15082: aload_0
    //   15083: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15086: aload_0
    //   15087: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15090: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   15093: astore 27
    //   15095: aload 31
    //   15097: aload 27
    //   15099: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15102: ldc_w 564
    //   15105: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15108: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   15111: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15114: ldc_w 576
    //   15117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15120: aload_2
    //   15121: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15124: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   15127: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15130: ldc_w 581
    //   15133: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15136: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   15139: aload_0
    //   15140: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   15143: lsub
    //   15144: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15147: ldc_w 583
    //   15150: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15153: aload_2
    //   15154: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15157: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   15160: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15163: ldc_w 588
    //   15166: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15169: aload_2
    //   15170: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15173: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   15176: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15179: ldc_w 592
    //   15182: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15185: aload_2
    //   15186: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15189: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   15192: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15195: ldc_w 597
    //   15198: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15201: aload_0
    //   15202: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   15205: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15208: ldc_w 599
    //   15211: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15214: aload_0
    //   15215: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   15218: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15221: ldc_w 942
    //   15224: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15227: iload 4
    //   15229: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15232: ldc_w 611
    //   15235: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15238: aload 30
    //   15240: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15243: ldc_w 571
    //   15246: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15249: aload_2
    //   15250: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15253: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   15256: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15259: ldc_w 613
    //   15262: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15265: aload 24
    //   15267: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15270: ldc_w 615
    //   15273: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15276: astore 31
    //   15278: aload_0
    //   15279: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15282: ifnull +239 -> 15521
    //   15285: aload_0
    //   15286: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15289: iconst_0
    //   15290: bipush 30
    //   15292: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   15295: astore 27
    //   15297: aload 31
    //   15299: aload 27
    //   15301: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15304: ldc_w 621
    //   15307: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15310: astore 27
    //   15312: aload_0
    //   15313: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15316: ifnull +214 -> 15530
    //   15319: aload_0
    //   15320: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15323: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   15326: istore_3
    //   15327: aload 27
    //   15329: iload_3
    //   15330: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15333: ldc_w 623
    //   15336: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15339: aload_2
    //   15340: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15343: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   15346: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15349: ldc_w 628
    //   15352: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15355: lload 12
    //   15357: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15360: ldc_w 630
    //   15363: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15366: aload_0
    //   15367: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   15370: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15373: ldc_w 599
    //   15376: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15379: aload_0
    //   15380: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   15383: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15386: ldc_w 632
    //   15389: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15392: aload_0
    //   15393: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   15396: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15399: ldc_w 599
    //   15402: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15405: aload_0
    //   15406: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   15409: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15412: ldc_w 634
    //   15415: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15418: aload_0
    //   15419: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   15422: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15425: ldc_w 636
    //   15428: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15431: aload_0
    //   15432: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   15435: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15438: ldc_w 641
    //   15441: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15444: aload_0
    //   15445: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   15448: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15451: ldc_w 646
    //   15454: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15457: astore 31
    //   15459: aload_0
    //   15460: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15463: ifnull +72 -> 15535
    //   15466: aload_0
    //   15467: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15470: invokeinterface 656 1 0
    //   15475: astore 27
    //   15477: aload 29
    //   15479: aload 31
    //   15481: aload 27
    //   15483: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15486: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15489: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15492: ldc_w 447
    //   15495: aload 29
    //   15497: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15500: aconst_null
    //   15501: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15504: goto -14327 -> 1177
    //   15507: ldc_w 938
    //   15510: astore 27
    //   15512: goto -537 -> 14975
    //   15515: aconst_null
    //   15516: astore 27
    //   15518: goto -423 -> 15095
    //   15521: aload_0
    //   15522: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15525: astore 27
    //   15527: goto -230 -> 15297
    //   15530: iconst_0
    //   15531: istore_3
    //   15532: goto -205 -> 15327
    //   15535: aconst_null
    //   15536: astore 27
    //   15538: goto -61 -> 15477
    //   15541: iconst_0
    //   15542: istore_3
    //   15543: goto -14286 -> 1257
    //   15546: ldc_w 428
    //   15549: astore 24
    //   15551: goto -14163 -> 1388
    //   15554: astore 24
    //   15556: ldc 219
    //   15558: ldc_w 947
    //   15561: aload 24
    //   15563: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15566: goto -14102 -> 1464
    //   15569: astore 24
    //   15571: ldc 219
    //   15573: ldc_w 949
    //   15576: aload 24
    //   15578: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15581: goto -14067 -> 1514
    //   15584: iconst_0
    //   15585: istore 10
    //   15587: goto -14023 -> 1564
    //   15590: aload 28
    //   15592: invokevirtual 952	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   15595: astore 22
    //   15597: goto -13964 -> 1633
    //   15600: iconst_0
    //   15601: istore 10
    //   15603: goto -13797 -> 1806
    //   15606: aload_0
    //   15607: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15610: ifnull +15 -> 15625
    //   15613: aload_0
    //   15614: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15617: invokevirtual 957	org/apache/http/client/methods/HttpGet:abort	()V
    //   15620: aload_0
    //   15621: aconst_null
    //   15622: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15625: aload_0
    //   15626: invokevirtual 960	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   15629: goto -13754 -> 1875
    //   15632: aconst_null
    //   15633: astore 27
    //   15635: goto -10790 -> 4845
    //   15638: astore 24
    //   15640: ldc_w 428
    //   15643: astore 24
    //   15645: goto -10766 -> 4879
    //   15648: ldc_w 938
    //   15651: astore 28
    //   15653: goto -10599 -> 5054
    //   15656: aconst_null
    //   15657: astore 28
    //   15659: goto -10485 -> 5174
    //   15662: aload_0
    //   15663: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15666: astore 28
    //   15668: goto -10265 -> 5403
    //   15671: iconst_0
    //   15672: istore_3
    //   15673: goto -10240 -> 5433
    //   15676: aconst_null
    //   15677: astore 28
    //   15679: goto -10096 -> 5583
    //   15682: new 125	java/lang/StringBuilder
    //   15685: dup
    //   15686: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   15689: ldc_w 940
    //   15692: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15695: aload_0
    //   15696: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   15699: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15702: ldc_w 527
    //   15705: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15708: aload_0
    //   15709: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15712: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15715: ldc_w 532
    //   15718: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15721: astore 32
    //   15723: aload_0
    //   15724: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15727: ifeq +558 -> 16285
    //   15730: aload 25
    //   15732: ifnull +553 -> 16285
    //   15735: aload 25
    //   15737: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   15740: ifnull +545 -> 16285
    //   15743: aload 25
    //   15745: invokevirtual 538	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   15748: invokevirtual 541	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   15751: astore 28
    //   15753: aload 32
    //   15755: aload 28
    //   15757: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15760: ldc_w 543
    //   15763: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15766: aload 30
    //   15768: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15771: ldc_w 548
    //   15774: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15777: aload 27
    //   15779: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15782: ldc_w 550
    //   15785: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15788: aconst_null
    //   15789: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15792: ldc_w 552
    //   15795: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15798: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15801: invokevirtual 174	java/lang/Thread:getId	()J
    //   15804: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15807: ldc_w 554
    //   15810: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15813: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   15816: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15819: ldc_w 556
    //   15822: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15825: aload_0
    //   15826: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15829: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15832: ldc_w 558
    //   15835: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15838: aload_0
    //   15839: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15842: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15845: ldc_w 560
    //   15848: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15851: astore 32
    //   15853: aload_0
    //   15854: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15857: ifeq +436 -> 16293
    //   15860: aload_0
    //   15861: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15864: aload_0
    //   15865: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15868: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   15871: astore 28
    //   15873: aload 32
    //   15875: aload 28
    //   15877: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15880: ldc_w 564
    //   15883: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15886: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   15889: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15892: ldc_w 576
    //   15895: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15898: aload_2
    //   15899: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15902: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   15905: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15908: ldc_w 581
    //   15911: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15914: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   15917: aload_0
    //   15918: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   15921: lsub
    //   15922: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15925: ldc_w 583
    //   15928: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15931: aload_2
    //   15932: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15935: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   15938: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15941: ldc_w 588
    //   15944: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15947: aload_2
    //   15948: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15951: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   15954: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15957: ldc_w 592
    //   15960: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15963: aload_2
    //   15964: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15967: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   15970: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15973: ldc_w 597
    //   15976: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15979: aload_0
    //   15980: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   15983: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15986: ldc_w 599
    //   15989: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15992: aload_0
    //   15993: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   15996: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15999: ldc_w 942
    //   16002: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16005: iload 4
    //   16007: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16010: ldc_w 611
    //   16013: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16016: aload 31
    //   16018: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16021: ldc_w 571
    //   16024: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16027: aload_2
    //   16028: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16031: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   16034: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16037: ldc_w 613
    //   16040: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16043: aload 24
    //   16045: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16048: ldc_w 615
    //   16051: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16054: astore 32
    //   16056: aload_0
    //   16057: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16060: ifnull +239 -> 16299
    //   16063: aload_0
    //   16064: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16067: iconst_0
    //   16068: bipush 30
    //   16070: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   16073: astore 28
    //   16075: aload 32
    //   16077: aload 28
    //   16079: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16082: ldc_w 621
    //   16085: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16088: astore 28
    //   16090: aload_0
    //   16091: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16094: ifnull +214 -> 16308
    //   16097: aload_0
    //   16098: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16101: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   16104: istore_3
    //   16105: aload 28
    //   16107: iload_3
    //   16108: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16111: ldc_w 623
    //   16114: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16117: aload_2
    //   16118: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16121: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   16124: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16127: ldc_w 628
    //   16130: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16133: lload 12
    //   16135: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16138: ldc_w 630
    //   16141: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16144: aload_0
    //   16145: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   16148: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16151: ldc_w 599
    //   16154: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16157: aload_0
    //   16158: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   16161: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16164: ldc_w 632
    //   16167: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16170: aload_0
    //   16171: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   16174: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16177: ldc_w 599
    //   16180: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16183: aload_0
    //   16184: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   16187: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16190: ldc_w 634
    //   16193: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16196: aload_0
    //   16197: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   16200: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16203: ldc_w 636
    //   16206: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16209: aload_0
    //   16210: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   16213: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16216: ldc_w 641
    //   16219: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16222: aload_0
    //   16223: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   16226: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16229: ldc_w 646
    //   16232: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16235: astore 32
    //   16237: aload_0
    //   16238: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16241: ifnull +72 -> 16313
    //   16244: aload_0
    //   16245: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16248: invokeinterface 656 1 0
    //   16253: astore 28
    //   16255: aload 29
    //   16257: aload 32
    //   16259: aload 28
    //   16261: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16264: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16267: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16270: ldc_w 447
    //   16273: aload 29
    //   16275: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16278: aconst_null
    //   16279: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16282: goto -10671 -> 5611
    //   16285: ldc_w 938
    //   16288: astore 28
    //   16290: goto -537 -> 15753
    //   16293: aconst_null
    //   16294: astore 28
    //   16296: goto -423 -> 15873
    //   16299: aload_0
    //   16300: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16303: astore 28
    //   16305: goto -230 -> 16075
    //   16308: iconst_0
    //   16309: istore_3
    //   16310: goto -205 -> 16105
    //   16313: aconst_null
    //   16314: astore 28
    //   16316: goto -61 -> 16255
    //   16319: iconst_0
    //   16320: istore_3
    //   16321: goto -10630 -> 5691
    //   16324: ldc_w 428
    //   16327: astore 24
    //   16329: goto -10507 -> 5822
    //   16332: astore 24
    //   16334: ldc 219
    //   16336: ldc_w 947
    //   16339: aload 24
    //   16341: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16344: goto -10446 -> 5898
    //   16347: astore 24
    //   16349: ldc 219
    //   16351: ldc_w 949
    //   16354: aload 24
    //   16356: invokestatic 945	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16359: goto -10411 -> 5948
    //   16362: iconst_0
    //   16363: istore 10
    //   16365: goto -10367 -> 5998
    //   16368: aload 30
    //   16370: invokevirtual 952	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   16373: astore 23
    //   16375: goto -10308 -> 6067
    //   16378: iconst_0
    //   16379: istore 10
    //   16381: goto -10141 -> 6240
    //   16384: aload_0
    //   16385: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16388: ifnull +15 -> 16403
    //   16391: aload_0
    //   16392: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16395: invokevirtual 957	org/apache/http/client/methods/HttpGet:abort	()V
    //   16398: aload_0
    //   16399: aconst_null
    //   16400: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16403: aload_0
    //   16404: invokevirtual 960	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   16407: goto -10098 -> 6309
    //   16410: astore 23
    //   16412: aconst_null
    //   16413: astore 27
    //   16415: aload 22
    //   16417: astore 24
    //   16419: aload 23
    //   16421: astore 22
    //   16423: aload 27
    //   16425: astore 23
    //   16427: iload 7
    //   16429: istore 4
    //   16431: goto -11665 -> 4766
    //   16434: astore 25
    //   16436: aconst_null
    //   16437: astore 28
    //   16439: aload 22
    //   16441: astore 26
    //   16443: aload 23
    //   16445: astore 27
    //   16447: aload 25
    //   16449: astore 22
    //   16451: aload 28
    //   16453: astore 23
    //   16455: iload 7
    //   16457: istore 4
    //   16459: aload 27
    //   16461: astore 25
    //   16463: goto -11697 -> 4766
    //   16466: astore 25
    //   16468: aconst_null
    //   16469: astore 28
    //   16471: aload 22
    //   16473: astore 26
    //   16475: aload 23
    //   16477: astore 27
    //   16479: aload 25
    //   16481: astore 22
    //   16483: aload 28
    //   16485: astore 23
    //   16487: aload 27
    //   16489: astore 25
    //   16491: goto -11725 -> 4766
    //   16494: astore 25
    //   16496: aload 23
    //   16498: astore 26
    //   16500: aload 22
    //   16502: astore 27
    //   16504: aconst_null
    //   16505: astore 23
    //   16507: aload 25
    //   16509: astore 22
    //   16511: aload 27
    //   16513: astore 25
    //   16515: goto -11749 -> 4766
    //   16518: astore 28
    //   16520: aload 23
    //   16522: astore 26
    //   16524: aload 22
    //   16526: astore 27
    //   16528: aload 25
    //   16530: astore 23
    //   16532: aload 28
    //   16534: astore 22
    //   16536: iload 5
    //   16538: istore_3
    //   16539: aload 27
    //   16541: astore 25
    //   16543: goto -11777 -> 4766
    //   16546: astore 25
    //   16548: aconst_null
    //   16549: astore 26
    //   16551: aload 22
    //   16553: astore 24
    //   16555: aconst_null
    //   16556: astore 23
    //   16558: aload 26
    //   16560: astore 22
    //   16562: iload 8
    //   16564: istore 4
    //   16566: goto -16314 -> 252
    //   16569: astore 25
    //   16571: aload 22
    //   16573: astore 26
    //   16575: aload 23
    //   16577: astore 22
    //   16579: iload 8
    //   16581: istore 4
    //   16583: aload 26
    //   16585: astore 23
    //   16587: goto -16335 -> 252
    //   16590: ldc_w 428
    //   16593: astore 24
    //   16595: goto -11716 -> 4879
    //   16598: ldc_w 428
    //   16601: astore 24
    //   16603: goto -16158 -> 445
    //   16606: ldc_w 428
    //   16609: astore 24
    //   16611: goto -4021 -> 12590
    //   16614: ldc_w 428
    //   16617: astore 24
    //   16619: goto -6400 -> 10219
    //   16622: ldc_w 428
    //   16625: astore 24
    //   16627: goto -8726 -> 7901
    //   16630: ldc_w 428
    //   16633: astore 24
    //   16635: goto -13531 -> 3104
    //   16638: iconst_0
    //   16639: istore 4
    //   16641: goto -13742 -> 2899
    //   16644: aconst_null
    //   16645: astore 23
    //   16647: aconst_null
    //   16648: astore 22
    //   16650: aconst_null
    //   16651: astore 24
    //   16653: goto -13805 -> 2848
    //   16656: iconst_1
    //   16657: istore 5
    //   16659: goto -14590 -> 2069
    //   16662: aload 28
    //   16664: astore 23
    //   16666: iload 4
    //   16668: iconst_2
    //   16669: if_icmpge -12091 -> 4578
    //   16672: aload 28
    //   16674: astore 23
    //   16676: iload 10
    //   16678: ifeq -12100 -> 4578
    //   16681: ldc_w 908
    //   16684: astore 23
    //   16686: goto -12108 -> 4578
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	16689	0	this	FastDownloadTask
    //   0	16689	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	16689	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   29	16510	3	i	int
    //   246	16424	4	j	int
    //   263	16395	5	k	int
    //   275	6433	6	m	int
    //   177	16279	7	n	int
    //   180	16400	8	i1	int
    //   18	109	9	i2	int
    //   198	16479	10	bool1	boolean
    //   23	61	11	bool2	boolean
    //   26	16108	12	l1	long
    //   224	6743	14	l2	long
    //   228	6743	16	l3	long
    //   113	12369	18	l4	long
    //   188	2553	20	l5	long
    //   97	1	22	localException1	java.lang.Exception
    //   183	1	22	localObject1	Object
    //   215	16	22	localUnknownHostException	java.net.UnknownHostException
    //   236	4513	22	localObject2	Object
    //   4753	1557	22	localObject3	Object
    //   6341	10308	22	localObject4	Object
    //   242	16132	23	localObject5	Object
    //   16410	10	23	localObject6	Object
    //   16425	260	23	localObject7	Object
    //   166	6820	24	localObject8	Object
    //   7011	1	24	localException2	java.lang.Exception
    //   7016	690	24	str1	String
    //   7710	8	24	localException3	java.lang.Exception
    //   7725	162	24	localException4	java.lang.Exception
    //   7899	1121	24	localObject9	Object
    //   9336	1	24	localException5	java.lang.Exception
    //   9341	685	24	str2	String
    //   10030	8	24	localException6	java.lang.Exception
    //   10045	160	24	localException7	java.lang.Exception
    //   10217	1121	24	localObject10	Object
    //   11654	1	24	localException8	java.lang.Exception
    //   11659	685	24	str3	String
    //   12348	8	24	localException9	java.lang.Exception
    //   12363	213	24	localException10	java.lang.Exception
    //   12588	1125	24	localObject11	Object
    //   14077	1	24	localException11	java.lang.Exception
    //   14082	690	24	str4	String
    //   14776	8	24	localException12	java.lang.Exception
    //   14791	8	24	localException13	java.lang.Exception
    //   14860	1	24	localException14	java.lang.Exception
    //   14865	685	24	str5	String
    //   15554	8	24	localException15	java.lang.Exception
    //   15569	8	24	localException16	java.lang.Exception
    //   15638	1	24	localException17	java.lang.Exception
    //   15643	685	24	str6	String
    //   16332	8	24	localException18	java.lang.Exception
    //   16347	8	24	localException19	java.lang.Exception
    //   16417	235	24	localObject12	Object
    //   174	1	25	localObject13	Object
    //   233	1388	25	localThrowable1	java.lang.Throwable
    //   2834	10881	25	localObject14	Object
    //   14040	1	25	localThrowable2	java.lang.Throwable
    //   14072	1672	25	str7	String
    //   16434	14	25	localObject15	Object
    //   16461	1	25	localObject16	Object
    //   16466	14	25	localObject17	Object
    //   16489	1	25	localObject18	Object
    //   16494	14	25	localObject19	Object
    //   16513	29	25	localObject20	Object
    //   16546	1	25	localThrowable3	java.lang.Throwable
    //   16569	1	25	localThrowable4	java.lang.Throwable
    //   163	16421	26	localObject21	Object
    //   618	15922	27	localObject22	Object
    //   380	16104	28	localObject23	Object
    //   16518	155	28	localObject24	Object
    //   122	16152	29	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   423	15946	30	localObject25	Object
    //   588	15429	31	localObject26	Object
    //   5022	11236	32	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	83	97	java/lang/Exception
    //   190	200	215	java/net/UnknownHostException
    //   230	233	233	java/lang/Throwable
    //   1891	1902	233	java/lang/Throwable
    //   1910	1919	233	java/lang/Throwable
    //   1927	1936	233	java/lang/Throwable
    //   1944	1951	233	java/lang/Throwable
    //   1959	1970	233	java/lang/Throwable
    //   1978	1985	233	java/lang/Throwable
    //   1993	1999	233	java/lang/Throwable
    //   2007	2016	233	java/lang/Throwable
    //   2024	2036	233	java/lang/Throwable
    //   2044	2051	233	java/lang/Throwable
    //   2059	2066	233	java/lang/Throwable
    //   2077	2083	233	java/lang/Throwable
    //   2091	2099	233	java/lang/Throwable
    //   2107	2120	233	java/lang/Throwable
    //   2128	2135	233	java/lang/Throwable
    //   2143	2150	233	java/lang/Throwable
    //   2158	2168	233	java/lang/Throwable
    //   2176	2192	233	java/lang/Throwable
    //   2200	2212	233	java/lang/Throwable
    //   2220	2226	233	java/lang/Throwable
    //   2234	2243	233	java/lang/Throwable
    //   2266	2272	233	java/lang/Throwable
    //   2285	2297	233	java/lang/Throwable
    //   2309	2317	233	java/lang/Throwable
    //   2329	2357	233	java/lang/Throwable
    //   2369	2376	233	java/lang/Throwable
    //   2384	2401	233	java/lang/Throwable
    //   2413	2425	233	java/lang/Throwable
    //   2433	2439	233	java/lang/Throwable
    //   2447	2513	233	java/lang/Throwable
    //   2521	2528	233	java/lang/Throwable
    //   2536	2548	233	java/lang/Throwable
    //   2556	2568	233	java/lang/Throwable
    //   2576	2583	233	java/lang/Throwable
    //   2596	2623	233	java/lang/Throwable
    //   2631	2638	233	java/lang/Throwable
    //   2646	2671	233	java/lang/Throwable
    //   2679	2699	233	java/lang/Throwable
    //   2707	2729	233	java/lang/Throwable
    //   2737	2745	233	java/lang/Throwable
    //   2753	2760	233	java/lang/Throwable
    //   2768	2775	233	java/lang/Throwable
    //   2783	2790	233	java/lang/Throwable
    //   2798	2805	233	java/lang/Throwable
    //   2813	2818	233	java/lang/Throwable
    //   4563	4575	233	java/lang/Throwable
    //   4586	4597	233	java/lang/Throwable
    //   4605	4611	233	java/lang/Throwable
    //   4624	4636	233	java/lang/Throwable
    //   4648	4656	233	java/lang/Throwable
    //   4668	4702	233	java/lang/Throwable
    //   4714	4721	233	java/lang/Throwable
    //   4729	4746	233	java/lang/Throwable
    //   6320	6332	233	java/lang/Throwable
    //   6347	6354	233	java/lang/Throwable
    //   6366	6382	233	java/lang/Throwable
    //   6390	6396	233	java/lang/Throwable
    //   6409	6421	233	java/lang/Throwable
    //   6433	6441	233	java/lang/Throwable
    //   6453	6481	233	java/lang/Throwable
    //   6493	6500	233	java/lang/Throwable
    //   6508	6525	233	java/lang/Throwable
    //   6540	6552	233	java/lang/Throwable
    //   6563	6576	233	java/lang/Throwable
    //   6594	6611	233	java/lang/Throwable
    //   6619	6625	233	java/lang/Throwable
    //   6638	6650	233	java/lang/Throwable
    //   6662	6670	233	java/lang/Throwable
    //   6682	6717	233	java/lang/Throwable
    //   6725	6732	233	java/lang/Throwable
    //   6740	6757	233	java/lang/Throwable
    //   6765	6777	233	java/lang/Throwable
    //   6785	6791	233	java/lang/Throwable
    //   6799	6855	233	java/lang/Throwable
    //   6866	6878	233	java/lang/Throwable
    //   6889	6918	233	java/lang/Throwable
    //   6929	6936	233	java/lang/Throwable
    //   6944	6964	233	java/lang/Throwable
    //   6972	6981	233	java/lang/Throwable
    //   230	233	4753	finally
    //   1891	1902	4753	finally
    //   1910	1919	4753	finally
    //   1927	1936	4753	finally
    //   1944	1951	4753	finally
    //   1959	1970	4753	finally
    //   1978	1985	4753	finally
    //   1993	1999	4753	finally
    //   2007	2016	4753	finally
    //   2024	2036	4753	finally
    //   2044	2051	4753	finally
    //   2059	2066	4753	finally
    //   2077	2083	4753	finally
    //   2091	2099	4753	finally
    //   2107	2120	4753	finally
    //   2128	2135	4753	finally
    //   2143	2150	4753	finally
    //   2158	2168	4753	finally
    //   2176	2192	4753	finally
    //   2200	2212	4753	finally
    //   2220	2226	4753	finally
    //   2234	2243	4753	finally
    //   2266	2272	4753	finally
    //   2285	2297	4753	finally
    //   2309	2317	4753	finally
    //   2329	2357	4753	finally
    //   2369	2376	4753	finally
    //   2384	2401	4753	finally
    //   2413	2425	4753	finally
    //   2433	2439	4753	finally
    //   2447	2513	4753	finally
    //   2521	2528	4753	finally
    //   2536	2548	4753	finally
    //   2556	2568	4753	finally
    //   2576	2583	4753	finally
    //   2596	2623	4753	finally
    //   2631	2638	4753	finally
    //   2646	2671	4753	finally
    //   2679	2699	4753	finally
    //   2707	2729	4753	finally
    //   2737	2745	4753	finally
    //   2753	2760	4753	finally
    //   2768	2775	4753	finally
    //   2783	2790	4753	finally
    //   2798	2805	4753	finally
    //   2813	2818	4753	finally
    //   4563	4575	4753	finally
    //   4586	4597	4753	finally
    //   4605	4611	4753	finally
    //   4624	4636	4753	finally
    //   4648	4656	4753	finally
    //   4668	4702	4753	finally
    //   4714	4721	4753	finally
    //   4729	4746	4753	finally
    //   6320	6332	4753	finally
    //   6347	6354	4753	finally
    //   6366	6382	4753	finally
    //   6390	6396	4753	finally
    //   6409	6421	4753	finally
    //   6433	6441	4753	finally
    //   6453	6481	4753	finally
    //   6493	6500	4753	finally
    //   6508	6525	4753	finally
    //   6540	6552	4753	finally
    //   6563	6576	4753	finally
    //   6594	6611	4753	finally
    //   6619	6625	4753	finally
    //   6638	6650	4753	finally
    //   6662	6670	4753	finally
    //   6682	6717	4753	finally
    //   6725	6732	4753	finally
    //   6740	6757	4753	finally
    //   6765	6777	4753	finally
    //   6785	6791	4753	finally
    //   6799	6855	4753	finally
    //   6866	6878	4753	finally
    //   6889	6918	4753	finally
    //   6929	6936	4753	finally
    //   6944	6964	4753	finally
    //   6972	6981	4753	finally
    //   3089	3104	7011	java/lang/Exception
    //   4099	4126	7710	java/lang/Exception
    //   4149	4176	7725	java/lang/Exception
    //   7886	7901	9336	java/lang/Exception
    //   8892	8919	10030	java/lang/Exception
    //   8942	8969	10045	java/lang/Exception
    //   10204	10219	11654	java/lang/Exception
    //   11210	11237	12348	java/lang/Exception
    //   11260	11287	12363	java/lang/Exception
    //   2899	2908	14040	java/lang/Throwable
    //   2928	2986	14040	java/lang/Throwable
    //   12432	12448	14040	java/lang/Throwable
    //   12452	12473	14040	java/lang/Throwable
    //   14029	14037	14040	java/lang/Throwable
    //   12575	12590	14077	java/lang/Exception
    //   13585	13612	14776	java/lang/Exception
    //   13635	13662	14791	java/lang/Exception
    //   430	445	14860	java/lang/Exception
    //   1437	1464	15554	java/lang/Exception
    //   1487	1514	15569	java/lang/Exception
    //   4864	4879	15638	java/lang/Exception
    //   5871	5898	16332	java/lang/Exception
    //   5921	5948	16347	java/lang/Exception
    //   2818	2833	16410	finally
    //   2848	2860	16434	finally
    //   2875	2899	16434	finally
    //   6995	7002	16434	finally
    //   14057	14065	16434	finally
    //   2899	2908	16466	finally
    //   2928	2986	16466	finally
    //   12432	12448	16466	finally
    //   12452	12473	16466	finally
    //   14029	14037	16466	finally
    //   252	262	16494	finally
    //   265	274	16518	finally
    //   280	287	16518	finally
    //   293	306	16518	finally
    //   309	314	16518	finally
    //   323	332	16518	finally
    //   2818	2833	16546	java/lang/Throwable
    //   2848	2860	16569	java/lang/Throwable
    //   2875	2899	16569	java/lang/Throwable
    //   6995	7002	16569	java/lang/Throwable
    //   14057	14065	16569	java/lang/Throwable
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