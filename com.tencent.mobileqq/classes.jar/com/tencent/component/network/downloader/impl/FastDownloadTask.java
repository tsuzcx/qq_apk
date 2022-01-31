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
    //   170: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
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
    //   219: ifnull +1745 -> 1964
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
    //   386: ifnull +14962 -> 15348
    //   389: aload_0
    //   390: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   393: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   396: ifnull +14952 -> 15348
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
    //   420: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   423: astore 30
    //   425: aload 24
    //   427: ifnull +16653 -> 17080
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
    //   527: ifne +1401 -> 1928
    //   530: aload_0
    //   531: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   534: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   537: istore 10
    //   539: aload_2
    //   540: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   543: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   546: ifne +14852 -> 15398
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
    //   594: ifeq +14770 -> 15364
    //   597: aload 22
    //   599: ifnull +14765 -> 15364
    //   602: aload 22
    //   604: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   607: ifnull +14757 -> 15364
    //   610: aload 22
    //   612: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   615: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
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
    //   724: ifeq +14648 -> 15372
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
    //   954: ifnull +14424 -> 15378
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
    //   988: ifnull +14399 -> 15387
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
    //   1135: ifnull +14257 -> 15392
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
    //   1274: ifnull +14761 -> 16035
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
    //   1390: ifne +14650 -> 16040
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
    //   1442: aload_0
    //   1443: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1446: ifnull +53 -> 1499
    //   1449: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1452: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1455: aload_0
    //   1456: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1459: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1462: if_icmpne +37 -> 1499
    //   1465: aload_0
    //   1466: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1469: ifnull +30 -> 1499
    //   1472: aload_0
    //   1473: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1476: aload_0
    //   1477: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1480: aload_0
    //   1481: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1484: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1487: aload_2
    //   1488: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1491: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1494: invokeinterface 684 4 0
    //   1499: aload_0
    //   1500: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1503: ifnull +53 -> 1556
    //   1506: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1509: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1512: aload_0
    //   1513: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1516: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1519: if_icmpne +37 -> 1556
    //   1522: aload_0
    //   1523: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1526: ifnull +30 -> 1556
    //   1529: aload_0
    //   1530: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1533: aload_0
    //   1534: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1537: aload_0
    //   1538: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1541: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1544: aload_2
    //   1545: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1548: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1551: invokeinterface 684 4 0
    //   1556: iload 10
    //   1558: ifeq +64 -> 1622
    //   1561: aload_0
    //   1562: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   1565: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1568: astore 24
    //   1570: aload_0
    //   1571: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1574: astore 26
    //   1576: aload_0
    //   1577: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1580: ifeq +14498 -> 16078
    //   1583: aload_0
    //   1584: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1587: ifnull +14491 -> 16078
    //   1590: aload_0
    //   1591: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1594: ldc_w 686
    //   1597: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1600: ifeq +14478 -> 16078
    //   1603: iconst_1
    //   1604: istore 10
    //   1606: aload 24
    //   1608: aload 26
    //   1610: iload 10
    //   1612: aload_2
    //   1613: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1616: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1619: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   1622: aload 29
    //   1624: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   1627: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1630: aload 29
    //   1632: aload_0
    //   1633: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   1636: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1639: aload 29
    //   1641: aload 23
    //   1643: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1646: aload 29
    //   1648: aload 22
    //   1650: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   1653: aload 29
    //   1655: iload 4
    //   1657: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1660: aload 29
    //   1662: aload 25
    //   1664: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1667: aload 28
    //   1669: ifnonnull +14415 -> 16084
    //   1672: aconst_null
    //   1673: astore 23
    //   1675: aload 29
    //   1677: aload 23
    //   1679: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1682: aload 29
    //   1684: aconst_null
    //   1685: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1688: aload 29
    //   1690: aload_2
    //   1691: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1694: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1697: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1700: aload 29
    //   1702: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1705: aload_0
    //   1706: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1709: lsub
    //   1710: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1713: aload 29
    //   1715: aload_2
    //   1716: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1719: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1722: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1725: aload 29
    //   1727: aload 29
    //   1729: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1732: aload_2
    //   1733: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1736: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1739: lsub
    //   1740: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1743: aload 29
    //   1745: lload 12
    //   1747: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1750: aload 29
    //   1752: aload_0
    //   1753: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   1756: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1759: aload 29
    //   1761: aload_0
    //   1762: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1765: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1768: aload 29
    //   1770: aload_0
    //   1771: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   1774: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1777: aload 29
    //   1779: lconst_0
    //   1780: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1783: aload 29
    //   1785: aload_0
    //   1786: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   1789: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1792: aload 29
    //   1794: aload_2
    //   1795: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1798: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1801: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1804: aload 29
    //   1806: aload_0
    //   1807: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1810: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1813: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1816: aload 29
    //   1818: aload_0
    //   1819: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1822: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1825: aload_0
    //   1826: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1829: ifnull +14265 -> 16094
    //   1832: aload_0
    //   1833: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1836: ldc_w 686
    //   1839: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1842: ifeq +14252 -> 16094
    //   1845: iconst_1
    //   1846: istore 10
    //   1848: aload 29
    //   1850: iload 10
    //   1852: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1855: aload 29
    //   1857: aload_2
    //   1858: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1861: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1864: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1867: aload 29
    //   1869: getstatic 770	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   1872: invokevirtual 773	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   1875: putfield 776	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   1878: aload 22
    //   1880: ifnull +24 -> 1904
    //   1883: aload 22
    //   1885: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1888: ifnull +16 -> 1904
    //   1891: aload 29
    //   1893: aload 22
    //   1895: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1898: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1901: putfield 778	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   1904: aload_2
    //   1905: aload 29
    //   1907: invokevirtual 782	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1910: aload_2
    //   1911: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1914: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1917: ifeq +11 -> 1928
    //   1920: aload_0
    //   1921: aload_1
    //   1922: aload_2
    //   1923: aload 29
    //   1925: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1928: aload_0
    //   1929: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1932: ifeq +14168 -> 16100
    //   1935: aload_0
    //   1936: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1939: ifnull +12 -> 1951
    //   1942: aload_0
    //   1943: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1946: invokeinterface 791 1 0
    //   1951: aload_0
    //   1952: aconst_null
    //   1953: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1956: iload 6
    //   1958: iconst_1
    //   1959: iadd
    //   1960: istore_3
    //   1961: goto -1756 -> 205
    //   1964: lload 12
    //   1966: lstore 14
    //   1968: lload 12
    //   1970: lstore 16
    //   1972: getstatic 795	com/tencent/component/network/downloader/impl/FastDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   1975: invokevirtual 801	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1978: checkcast 803	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   1981: astore 30
    //   1983: lload 12
    //   1985: lstore 14
    //   1987: lload 12
    //   1989: lstore 16
    //   1991: aload 30
    //   1993: aload_0
    //   1994: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   1997: putfield 804	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   2000: lload 12
    //   2002: lstore 14
    //   2004: lload 12
    //   2006: lstore 16
    //   2008: aload 30
    //   2010: aload_0
    //   2011: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   2014: putfield 807	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   2017: lload 12
    //   2019: lstore 14
    //   2021: lload 12
    //   2023: lstore 16
    //   2025: aload_0
    //   2026: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2029: ifnull +2681 -> 4710
    //   2032: lload 12
    //   2034: lstore 14
    //   2036: lload 12
    //   2038: lstore 16
    //   2040: aload_0
    //   2041: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2044: invokeinterface 656 1 0
    //   2049: astore 22
    //   2051: lload 12
    //   2053: lstore 14
    //   2055: lload 12
    //   2057: lstore 16
    //   2059: aload 30
    //   2061: aload 22
    //   2063: putfield 810	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2066: lload 12
    //   2068: lstore 14
    //   2070: lload 12
    //   2072: lstore 16
    //   2074: aload 29
    //   2076: iload_3
    //   2077: putfield 813	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   2080: lload 12
    //   2082: lstore 14
    //   2084: lload 12
    //   2086: lstore 16
    //   2088: aload 29
    //   2090: aload_0
    //   2091: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2094: putfield 818	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   2097: lload 12
    //   2099: lstore 14
    //   2101: lload 12
    //   2103: lstore 16
    //   2105: aload_0
    //   2106: aload_0
    //   2107: aload_0
    //   2108: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2111: invokevirtual 821	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   2114: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2117: lload 12
    //   2119: lstore 14
    //   2121: lload 12
    //   2123: lstore 16
    //   2125: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2128: iconst_2
    //   2129: if_icmpeq +15009 -> 17138
    //   2132: lload 12
    //   2134: lstore 14
    //   2136: lload 12
    //   2138: lstore 16
    //   2140: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2143: iconst_3
    //   2144: if_icmpne +2572 -> 4716
    //   2147: goto +14991 -> 17138
    //   2150: lload 12
    //   2152: lstore 14
    //   2154: lload 12
    //   2156: lstore 16
    //   2158: aload_0
    //   2159: invokevirtual 824	com/tencent/component/network/downloader/impl/FastDownloadTask:enableIpv6Debug	()Z
    //   2162: istore 10
    //   2164: lload 12
    //   2166: lstore 14
    //   2168: lload 12
    //   2170: lstore 16
    //   2172: aload 30
    //   2174: getfield 810	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2177: ifnonnull +4626 -> 6803
    //   2180: lload 12
    //   2182: lstore 14
    //   2184: lload 12
    //   2186: lstore 16
    //   2188: aload_0
    //   2189: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2192: ldc_w 686
    //   2195: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2198: ifeq +18 -> 2216
    //   2201: lload 12
    //   2203: lstore 14
    //   2205: lload 12
    //   2207: lstore 16
    //   2209: aload_0
    //   2210: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2213: ifeq +4590 -> 6803
    //   2216: lload 12
    //   2218: lstore 14
    //   2220: lload 12
    //   2222: lstore 16
    //   2224: aload_0
    //   2225: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2228: ifnull +4575 -> 6803
    //   2231: lload 12
    //   2233: lstore 14
    //   2235: lload 12
    //   2237: lstore 16
    //   2239: aload_0
    //   2240: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2243: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2246: ifnull +4557 -> 6803
    //   2249: lload 12
    //   2251: lstore 14
    //   2253: lload 12
    //   2255: lstore 16
    //   2257: aload_0
    //   2258: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2261: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2264: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2267: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2270: ifne +4533 -> 6803
    //   2273: lload 12
    //   2275: lstore 14
    //   2277: lload 12
    //   2279: lstore 16
    //   2281: aload_0
    //   2282: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2285: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2288: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2291: astore 28
    //   2293: lload 12
    //   2295: lstore 14
    //   2297: lload 12
    //   2299: lstore 16
    //   2301: aload_0
    //   2302: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2305: astore 27
    //   2307: lload 12
    //   2309: lstore 14
    //   2311: lload 12
    //   2313: lstore 16
    //   2315: aload 28
    //   2317: bipush 58
    //   2319: invokestatic 828	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   2322: istore 4
    //   2324: iload 5
    //   2326: ifne +14818 -> 17144
    //   2329: aload 27
    //   2331: astore 22
    //   2333: iload 4
    //   2335: iconst_2
    //   2336: if_icmpge +150 -> 2486
    //   2339: lload 12
    //   2341: lstore 14
    //   2343: lload 12
    //   2345: lstore 16
    //   2347: aload_0
    //   2348: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   2351: istore 4
    //   2353: iload 4
    //   2355: ifle +2367 -> 4722
    //   2358: lload 12
    //   2360: lstore 14
    //   2362: lload 12
    //   2364: lstore 16
    //   2366: aload_0
    //   2367: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2370: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2373: iload 4
    //   2375: putfield 831	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2378: lload 12
    //   2380: lstore 14
    //   2382: iload 4
    //   2384: istore 6
    //   2386: lload 12
    //   2388: lstore 16
    //   2390: iload 4
    //   2392: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   2395: ifne +7 -> 2402
    //   2398: bipush 80
    //   2400: istore 6
    //   2402: lload 12
    //   2404: lstore 14
    //   2406: lload 12
    //   2408: lstore 16
    //   2410: new 125	java/lang/StringBuilder
    //   2413: dup
    //   2414: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2417: aload 28
    //   2419: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2422: ldc_w 833
    //   2425: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2428: iload 6
    //   2430: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2433: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2436: astore 23
    //   2438: lload 12
    //   2440: lstore 14
    //   2442: aload 23
    //   2444: astore 22
    //   2446: lload 12
    //   2448: lstore 16
    //   2450: aload_0
    //   2451: getfield 835	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2454: ifnull +32 -> 2486
    //   2457: lload 12
    //   2459: lstore 14
    //   2461: lload 12
    //   2463: lstore 16
    //   2465: aload_0
    //   2466: aload_0
    //   2467: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2470: aload_0
    //   2471: getfield 835	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2474: aload 23
    //   2476: invokevirtual 839	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2479: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2482: aload 23
    //   2484: astore 22
    //   2486: lload 12
    //   2488: lstore 14
    //   2490: lload 12
    //   2492: lstore 16
    //   2494: aload 29
    //   2496: aload_0
    //   2497: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2500: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2503: putfield 842	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2506: lload 12
    //   2508: lstore 14
    //   2510: lload 12
    //   2512: lstore 16
    //   2514: invokestatic 845	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   2517: ifeq +77 -> 2594
    //   2520: lload 12
    //   2522: lstore 14
    //   2524: lload 12
    //   2526: lstore 16
    //   2528: ldc 219
    //   2530: new 125	java/lang/StringBuilder
    //   2533: dup
    //   2534: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2537: ldc_w 847
    //   2540: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2543: aload 29
    //   2545: getfield 842	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2548: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2551: ldc_w 849
    //   2554: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2557: aload 22
    //   2559: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2562: ldc 151
    //   2564: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2567: aload_0
    //   2568: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2571: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: ldc 225
    //   2576: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2579: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2582: invokevirtual 174	java/lang/Thread:getId	()J
    //   2585: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2588: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2591: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2594: lload 12
    //   2596: lstore 14
    //   2598: lload 12
    //   2600: lstore 16
    //   2602: aload_0
    //   2603: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2606: ifnull +43 -> 2649
    //   2609: lload 12
    //   2611: lstore 14
    //   2613: lload 12
    //   2615: lstore 16
    //   2617: aload 29
    //   2619: aload_0
    //   2620: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2623: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2626: putfield 842	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2629: lload 12
    //   2631: lstore 14
    //   2633: lload 12
    //   2635: lstore 16
    //   2637: aload 29
    //   2639: aload_0
    //   2640: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2643: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2646: putfield 852	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2649: lload 12
    //   2651: lstore 14
    //   2653: lload 12
    //   2655: lstore 16
    //   2657: aload_0
    //   2658: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2661: ifeq +4483 -> 7144
    //   2664: iload 5
    //   2666: ifne +4478 -> 7144
    //   2669: lload 12
    //   2671: lstore 14
    //   2673: lload 12
    //   2675: lstore 16
    //   2677: aload_0
    //   2678: aload_0
    //   2679: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2682: aload_0
    //   2683: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2686: aload_0
    //   2687: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2690: aload_0
    //   2691: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2694: aload_0
    //   2695: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2698: invokestatic 858	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   2701: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2704: lload 12
    //   2706: lstore 14
    //   2708: lload 12
    //   2710: lstore 16
    //   2712: aload_0
    //   2713: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2716: ifnull +36 -> 2752
    //   2719: lload 12
    //   2721: lstore 14
    //   2723: lload 12
    //   2725: lstore 16
    //   2727: aload_0
    //   2728: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2731: aload_0
    //   2732: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2735: aload_0
    //   2736: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2739: aload_0
    //   2740: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2743: aload_0
    //   2744: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2747: invokeinterface 862 5 0
    //   2752: lload 12
    //   2754: lstore 14
    //   2756: lload 12
    //   2758: lstore 16
    //   2760: aload_0
    //   2761: aload_0
    //   2762: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2765: aload_0
    //   2766: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2769: aload_0
    //   2770: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2773: aload_0
    //   2774: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2777: invokevirtual 865	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   2780: lload 12
    //   2782: lstore 14
    //   2784: lload 12
    //   2786: lstore 16
    //   2788: aload_0
    //   2789: aload_0
    //   2790: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2793: aload_0
    //   2794: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2797: aload_0
    //   2798: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2801: aload_0
    //   2802: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2805: aload 30
    //   2807: invokevirtual 869	com/tencent/component/network/downloader/impl/FastDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2810: lload 12
    //   2812: lstore 14
    //   2814: lload 12
    //   2816: lstore 16
    //   2818: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   2821: lload 20
    //   2823: lsub
    //   2824: lstore 12
    //   2826: lload 12
    //   2828: lstore 14
    //   2830: lload 12
    //   2832: lstore 16
    //   2834: aload_0
    //   2835: lconst_0
    //   2836: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2839: lload 12
    //   2841: lstore 14
    //   2843: lload 12
    //   2845: lstore 16
    //   2847: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2850: lstore 20
    //   2852: lload 12
    //   2854: lstore 14
    //   2856: lload 12
    //   2858: lstore 16
    //   2860: aload_0
    //   2861: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2864: ifnull +4320 -> 7184
    //   2867: lload 12
    //   2869: lstore 14
    //   2871: lload 12
    //   2873: lstore 16
    //   2875: aload_0
    //   2876: getfield 873	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2879: ifnonnull +18 -> 2897
    //   2882: lload 12
    //   2884: lstore 14
    //   2886: lload 12
    //   2888: lstore 16
    //   2890: aload_0
    //   2891: invokestatic 877	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2894: putfield 873	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2897: lload 12
    //   2899: lstore 14
    //   2901: lload 12
    //   2903: lstore 16
    //   2905: invokestatic 881	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   2908: astore 22
    //   2910: aload_0
    //   2911: getfield 873	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2914: aload_0
    //   2915: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2918: aload 22
    //   2920: invokevirtual 886	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   2923: astore 23
    //   2925: aconst_null
    //   2926: astore 25
    //   2928: aload 22
    //   2930: astore 24
    //   2932: aload 25
    //   2934: astore 22
    //   2936: aload_0
    //   2937: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2940: lload 20
    //   2942: lsub
    //   2943: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2946: aload 23
    //   2948: ifnonnull +8 -> 2956
    //   2951: aload 22
    //   2953: ifnull +11598 -> 14551
    //   2956: aload 23
    //   2958: ifnull +4295 -> 7253
    //   2961: aload 23
    //   2963: invokeinterface 892 1 0
    //   2968: ifnull +4285 -> 7253
    //   2971: aload 23
    //   2973: invokeinterface 892 1 0
    //   2978: invokeinterface 897 1 0
    //   2983: istore 4
    //   2985: aload_2
    //   2986: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2989: iload 4
    //   2991: putfield 898	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   2994: sipush 200
    //   2997: iload 4
    //   2999: if_icmpeq +11 -> 3010
    //   3002: sipush 206
    //   3005: iload 4
    //   3007: if_icmpne +9842 -> 12849
    //   3010: iload 4
    //   3012: istore 5
    //   3014: aload_0
    //   3015: aload 23
    //   3017: aload 22
    //   3019: aload_2
    //   3020: aload_1
    //   3021: iload 4
    //   3023: invokevirtual 902	com/tencent/component/network/downloader/impl/FastDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   3026: ifeq +9876 -> 12902
    //   3029: aload_2
    //   3030: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3033: invokevirtual 905	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   3036: aload_2
    //   3037: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3040: getfield 908	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   3043: ifeq +7407 -> 10450
    //   3046: aload_0
    //   3047: aload 23
    //   3049: aload 22
    //   3051: invokevirtual 912	com/tencent/component/network/downloader/impl/FastDownloadTask:getRetcode	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;)I
    //   3054: istore 5
    //   3056: aload_2
    //   3057: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3060: iload 5
    //   3062: putfield 915	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   3065: iload 5
    //   3067: invokestatic 918	com/tencent/component/network/module/base/Config:canRetCodeRetry	(I)Z
    //   3070: istore 10
    //   3072: iload 10
    //   3074: ifeq +4977 -> 8051
    //   3077: aload_2
    //   3078: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3081: lload 18
    //   3083: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3086: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3089: aload_2
    //   3090: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3093: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3096: aload_0
    //   3097: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3100: lsub
    //   3101: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3104: aload_2
    //   3105: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3108: aload_0
    //   3109: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   3112: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3115: aload_0
    //   3116: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3119: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3122: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3125: astore 27
    //   3127: aload_0
    //   3128: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3131: ifnull +4137 -> 7268
    //   3134: aload_0
    //   3135: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3138: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3141: ifnull +4127 -> 7268
    //   3144: aload_0
    //   3145: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3148: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3151: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   3154: astore 25
    //   3156: aload_0
    //   3157: aload_0
    //   3158: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3161: aload 23
    //   3163: aload 22
    //   3165: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   3168: astore 28
    //   3170: aload 24
    //   3172: ifnull +13940 -> 17112
    //   3175: aload 24
    //   3177: ldc_w 492
    //   3180: invokeinterface 498 2 0
    //   3185: checkcast 282	java/lang/String
    //   3188: astore 24
    //   3190: aload_2
    //   3191: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3194: aload 24
    //   3196: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3199: aload_0
    //   3200: lconst_0
    //   3201: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3204: aload_0
    //   3205: iconst_0
    //   3206: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3209: aload_0
    //   3210: lconst_0
    //   3211: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3214: aload_0
    //   3215: iconst_0
    //   3216: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3219: aload_2
    //   3220: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3223: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3226: ifeq +12 -> 3238
    //   3229: aload_1
    //   3230: invokeinterface 359 1 0
    //   3235: ifeq +31 -> 3266
    //   3238: aload_0
    //   3239: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3242: ifnull +24 -> 3266
    //   3245: aload_0
    //   3246: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3249: aload_0
    //   3250: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3253: aload_2
    //   3254: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3257: aload 23
    //   3259: aload 22
    //   3261: invokeinterface 523 5 0
    //   3266: aload_1
    //   3267: invokeinterface 359 1 0
    //   3272: ifne +1403 -> 4675
    //   3275: aload_0
    //   3276: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3279: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3282: istore 10
    //   3284: aload_2
    //   3285: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3288: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3291: ifne +4028 -> 7319
    //   3294: new 125	java/lang/StringBuilder
    //   3297: dup
    //   3298: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   3301: ldc_w 525
    //   3304: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3307: aload_0
    //   3308: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3311: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3314: ldc_w 527
    //   3317: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3320: aload_0
    //   3321: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3324: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3327: ldc_w 532
    //   3330: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3333: astore 30
    //   3335: aload_0
    //   3336: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3339: ifeq +3945 -> 7284
    //   3342: aload 22
    //   3344: ifnull +3940 -> 7284
    //   3347: aload 22
    //   3349: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3352: ifnull +3932 -> 7284
    //   3355: aload 22
    //   3357: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3360: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3363: astore 26
    //   3365: aload 30
    //   3367: aload 26
    //   3369: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3372: ldc_w 543
    //   3375: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3378: aload 27
    //   3380: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3383: ldc_w 548
    //   3386: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3389: aload 25
    //   3391: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3394: ldc_w 550
    //   3397: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3400: aconst_null
    //   3401: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3404: ldc_w 552
    //   3407: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3410: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3413: invokevirtual 174	java/lang/Thread:getId	()J
    //   3416: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3419: ldc_w 554
    //   3422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3428: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3431: ldc_w 556
    //   3434: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3437: aload_0
    //   3438: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3441: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3444: ldc_w 558
    //   3447: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3450: aload_0
    //   3451: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3454: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3457: ldc_w 560
    //   3460: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: astore 30
    //   3465: aload_0
    //   3466: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3469: ifeq +3823 -> 7292
    //   3472: aload_0
    //   3473: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3476: aload_0
    //   3477: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3480: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3483: astore 26
    //   3485: aload 30
    //   3487: aload 26
    //   3489: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3492: ldc_w 562
    //   3495: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3498: iload 10
    //   3500: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3503: ldc_w 564
    //   3506: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3509: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3512: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3515: ldc_w 571
    //   3518: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3521: aload_2
    //   3522: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3525: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3528: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3531: ldc_w 576
    //   3534: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3537: aload_2
    //   3538: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3541: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3544: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3547: ldc_w 581
    //   3550: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3553: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3556: aload_0
    //   3557: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3560: lsub
    //   3561: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3564: ldc_w 583
    //   3567: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3570: aload_2
    //   3571: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3574: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3577: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3580: ldc_w 588
    //   3583: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3586: aload_2
    //   3587: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3590: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3593: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3596: ldc_w 592
    //   3599: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3602: aload_2
    //   3603: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3606: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3609: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3612: ldc_w 597
    //   3615: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3618: aload_0
    //   3619: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   3622: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3625: ldc_w 599
    //   3628: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: aload_0
    //   3632: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   3635: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3638: ldc_w 604
    //   3641: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3644: aload_2
    //   3645: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3648: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3651: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3654: ldc_w 609
    //   3657: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3660: iload 4
    //   3662: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3665: ldc_w 611
    //   3668: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3671: aload 28
    //   3673: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3676: ldc_w 613
    //   3679: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3682: aload 24
    //   3684: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3687: ldc_w 615
    //   3690: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3693: astore 30
    //   3695: aload_0
    //   3696: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3699: ifnull +3599 -> 7298
    //   3702: aload_0
    //   3703: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3706: iconst_0
    //   3707: bipush 30
    //   3709: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   3712: astore 26
    //   3714: aload 30
    //   3716: aload 26
    //   3718: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3721: ldc_w 621
    //   3724: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: astore 26
    //   3729: aload_0
    //   3730: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3733: ifnull +3574 -> 7307
    //   3736: aload_0
    //   3737: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3740: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3743: istore 5
    //   3745: aload 26
    //   3747: iload 5
    //   3749: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3752: ldc_w 623
    //   3755: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3758: aload_2
    //   3759: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3762: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3765: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3768: ldc_w 628
    //   3771: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3774: lload 12
    //   3776: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3779: ldc_w 630
    //   3782: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3785: aload_0
    //   3786: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3789: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3792: ldc_w 599
    //   3795: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3798: aload_0
    //   3799: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3802: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3805: ldc_w 632
    //   3808: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3811: aload_0
    //   3812: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3815: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3818: ldc_w 599
    //   3821: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3824: aload_0
    //   3825: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3828: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3831: ldc_w 634
    //   3834: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3837: aload_0
    //   3838: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   3841: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3844: ldc_w 636
    //   3847: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: aload_0
    //   3851: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   3854: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3857: ldc_w 641
    //   3860: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3863: aload_0
    //   3864: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   3867: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3870: ldc_w 646
    //   3873: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3876: astore 30
    //   3878: aload_0
    //   3879: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3882: ifnull +3431 -> 7313
    //   3885: aload_0
    //   3886: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3889: invokeinterface 656 1 0
    //   3894: astore 26
    //   3896: aload 29
    //   3898: aload 30
    //   3900: aload 26
    //   3902: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3905: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3908: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3911: ldc_w 447
    //   3914: aload 29
    //   3916: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3919: aconst_null
    //   3920: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3923: aload_0
    //   3924: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3927: ifnull +24 -> 3951
    //   3930: aload_0
    //   3931: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3934: ldc_w 439
    //   3937: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3940: ifeq +11 -> 3951
    //   3943: aload_0
    //   3944: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   3947: iconst_0
    //   3948: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   3951: iload 10
    //   3953: ifne +8 -> 3961
    //   3956: aload_0
    //   3957: iconst_0
    //   3958: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   3961: aload_2
    //   3962: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3965: astore 26
    //   3967: new 125	java/lang/StringBuilder
    //   3970: dup
    //   3971: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   3974: aload_0
    //   3975: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3978: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3981: ldc_w 670
    //   3984: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3987: aload 25
    //   3989: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3992: ldc_w 672
    //   3995: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3998: aload_2
    //   3999: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4002: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4005: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4008: ldc_w 674
    //   4011: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4014: astore 25
    //   4016: aload_0
    //   4017: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4020: ifnull +3939 -> 7959
    //   4023: aload_0
    //   4024: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4027: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4030: istore 5
    //   4032: aload 25
    //   4034: iload 5
    //   4036: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4039: ldc_w 609
    //   4042: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4045: iload 4
    //   4047: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4050: ldc_w 571
    //   4053: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4056: aload_2
    //   4057: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4060: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4063: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4066: ldc_w 583
    //   4069: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4072: aload_2
    //   4073: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4076: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4079: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4082: ldc_w 588
    //   4085: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4088: aload_2
    //   4089: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4092: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4095: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4098: ldc_w 576
    //   4101: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4104: aload_2
    //   4105: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4108: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4111: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4114: ldc_w 581
    //   4117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4120: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4123: aload_0
    //   4124: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4127: lsub
    //   4128: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4131: astore 25
    //   4133: aload 24
    //   4135: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4138: ifne +3827 -> 7965
    //   4141: new 125	java/lang/StringBuilder
    //   4144: dup
    //   4145: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4148: ldc_w 613
    //   4151: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4154: aload 24
    //   4156: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4159: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4162: astore 24
    //   4164: aload 26
    //   4166: aload 25
    //   4168: aload 24
    //   4170: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4173: ldc_w 611
    //   4176: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4179: aload 28
    //   4181: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4184: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4187: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   4190: aload_0
    //   4191: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4194: ifnull +53 -> 4247
    //   4197: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4200: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4203: aload_0
    //   4204: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4207: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4210: if_icmpne +37 -> 4247
    //   4213: aload_0
    //   4214: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4217: ifnull +30 -> 4247
    //   4220: aload_0
    //   4221: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4224: aload_0
    //   4225: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4228: aload_0
    //   4229: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4232: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4235: aload_2
    //   4236: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4239: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4242: invokeinterface 684 4 0
    //   4247: aload_0
    //   4248: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4251: ifnull +53 -> 4304
    //   4254: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4257: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4260: aload_0
    //   4261: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4264: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4267: if_icmpne +37 -> 4304
    //   4270: aload_0
    //   4271: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4274: ifnull +30 -> 4304
    //   4277: aload_0
    //   4278: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4281: aload_0
    //   4282: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4285: aload_0
    //   4286: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4289: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4292: aload_2
    //   4293: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4296: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4299: invokeinterface 684 4 0
    //   4304: iload 10
    //   4306: ifeq +64 -> 4370
    //   4309: aload_0
    //   4310: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4313: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   4316: astore 24
    //   4318: aload_0
    //   4319: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4322: astore 25
    //   4324: aload_0
    //   4325: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4328: ifeq +3675 -> 8003
    //   4331: aload_0
    //   4332: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4335: ifnull +3668 -> 8003
    //   4338: aload_0
    //   4339: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4342: ldc_w 686
    //   4345: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4348: ifeq +3655 -> 8003
    //   4351: iconst_1
    //   4352: istore 10
    //   4354: aload 24
    //   4356: aload 25
    //   4358: iload 10
    //   4360: aload_2
    //   4361: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4364: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4367: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   4370: aload 29
    //   4372: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   4375: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4378: aload 29
    //   4380: aload_0
    //   4381: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   4384: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4387: aload 29
    //   4389: aload 23
    //   4391: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4394: aload 29
    //   4396: aload 22
    //   4398: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   4401: aload 29
    //   4403: iload 4
    //   4405: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4408: aload 29
    //   4410: aconst_null
    //   4411: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4414: aload 27
    //   4416: ifnonnull +3593 -> 8009
    //   4419: aconst_null
    //   4420: astore 23
    //   4422: aload 29
    //   4424: aload 23
    //   4426: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4429: aload 29
    //   4431: aconst_null
    //   4432: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4435: aload 29
    //   4437: aload_2
    //   4438: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4441: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4444: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4447: aload 29
    //   4449: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4452: aload_0
    //   4453: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4456: lsub
    //   4457: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4460: aload 29
    //   4462: aload_2
    //   4463: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4466: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4469: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4472: aload 29
    //   4474: aload 29
    //   4476: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4479: aload_2
    //   4480: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4483: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4486: lsub
    //   4487: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4490: aload 29
    //   4492: lload 12
    //   4494: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4497: aload 29
    //   4499: aload_0
    //   4500: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4503: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4506: aload 29
    //   4508: aload_0
    //   4509: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   4512: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4515: aload 29
    //   4517: aload_0
    //   4518: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   4521: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4524: aload 29
    //   4526: lconst_0
    //   4527: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4530: aload 29
    //   4532: aload_0
    //   4533: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   4536: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4539: aload 29
    //   4541: aload_2
    //   4542: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4545: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4548: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4551: aload 29
    //   4553: aload_0
    //   4554: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4557: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4560: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4563: aload 29
    //   4565: aload_0
    //   4566: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4569: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4572: aload_0
    //   4573: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4576: ifnull +3443 -> 8019
    //   4579: aload_0
    //   4580: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4583: ldc_w 686
    //   4586: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4589: ifeq +3430 -> 8019
    //   4592: iconst_1
    //   4593: istore 10
    //   4595: aload 29
    //   4597: iload 10
    //   4599: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4602: aload 29
    //   4604: aload_2
    //   4605: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4608: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4611: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4614: aload 29
    //   4616: getstatic 770	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   4619: invokevirtual 773	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   4622: putfield 776	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   4625: aload 22
    //   4627: ifnull +24 -> 4651
    //   4630: aload 22
    //   4632: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4635: ifnull +16 -> 4651
    //   4638: aload 29
    //   4640: aload 22
    //   4642: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4645: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4648: putfield 778	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   4651: aload_2
    //   4652: aload 29
    //   4654: invokevirtual 782	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4657: aload_2
    //   4658: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4661: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4664: ifeq +11 -> 4675
    //   4667: aload_0
    //   4668: aload_1
    //   4669: aload_2
    //   4670: aload 29
    //   4672: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4675: aload_0
    //   4676: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4679: ifeq +3346 -> 8025
    //   4682: aload_0
    //   4683: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4686: ifnull +12 -> 4698
    //   4689: aload_0
    //   4690: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4693: invokeinterface 791 1 0
    //   4698: aload_0
    //   4699: aconst_null
    //   4700: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   4703: iload_3
    //   4704: iconst_1
    //   4705: iadd
    //   4706: istore_3
    //   4707: goto -4502 -> 205
    //   4710: aconst_null
    //   4711: astore 22
    //   4713: goto -2662 -> 2051
    //   4716: iconst_0
    //   4717: istore 5
    //   4719: goto -2569 -> 2150
    //   4722: lload 12
    //   4724: lstore 14
    //   4726: lload 12
    //   4728: lstore 16
    //   4730: aload_0
    //   4731: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4734: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4737: getfield 831	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4740: istore 4
    //   4742: goto -2364 -> 2378
    //   4745: lload 12
    //   4747: lstore 14
    //   4749: lload 12
    //   4751: lstore 16
    //   4753: aload 23
    //   4755: bipush 58
    //   4757: invokestatic 828	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   4760: iconst_2
    //   4761: if_icmplt +1822 -> 6583
    //   4764: lload 12
    //   4766: lstore 14
    //   4768: lload 12
    //   4770: lstore 16
    //   4772: aload_0
    //   4773: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   4776: istore 4
    //   4778: iload 4
    //   4780: ifle +1780 -> 6560
    //   4783: lload 12
    //   4785: lstore 14
    //   4787: lload 12
    //   4789: lstore 16
    //   4791: aload_0
    //   4792: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4795: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4798: iload 4
    //   4800: putfield 831	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4803: lload 12
    //   4805: lstore 14
    //   4807: iload 4
    //   4809: istore 6
    //   4811: lload 12
    //   4813: lstore 16
    //   4815: iload 4
    //   4817: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   4820: ifne +7 -> 4827
    //   4823: bipush 80
    //   4825: istore 6
    //   4827: lload 12
    //   4829: lstore 14
    //   4831: lload 12
    //   4833: lstore 16
    //   4835: new 125	java/lang/StringBuilder
    //   4838: dup
    //   4839: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4842: ldc_w 920
    //   4845: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4848: aload 23
    //   4850: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4853: ldc_w 922
    //   4856: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4859: iload 6
    //   4861: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4864: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4867: astore 23
    //   4869: lload 12
    //   4871: lstore 14
    //   4873: aload 23
    //   4875: astore 22
    //   4877: lload 12
    //   4879: lstore 16
    //   4881: aload_0
    //   4882: getfield 835	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4885: ifnull -2399 -> 2486
    //   4888: lload 12
    //   4890: lstore 14
    //   4892: lload 12
    //   4894: lstore 16
    //   4896: aload_0
    //   4897: aload_0
    //   4898: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4901: aload_0
    //   4902: getfield 835	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4905: aload 23
    //   4907: invokevirtual 839	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4910: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4913: aload 23
    //   4915: astore 22
    //   4917: goto -2431 -> 2486
    //   4920: astore 22
    //   4922: aconst_null
    //   4923: astore 23
    //   4925: iload 7
    //   4927: istore 4
    //   4929: lload 16
    //   4931: lstore 12
    //   4933: aload_2
    //   4934: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4937: lload 18
    //   4939: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4942: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4945: aload_2
    //   4946: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4949: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4952: aload_0
    //   4953: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4956: lsub
    //   4957: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4960: aload_2
    //   4961: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4964: aload_0
    //   4965: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   4968: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4971: aload_0
    //   4972: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4975: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4978: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4981: astore 30
    //   4983: aload_0
    //   4984: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4987: ifnull +11139 -> 16126
    //   4990: aload_0
    //   4991: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4994: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4997: ifnull +11129 -> 16126
    //   5000: aload_0
    //   5001: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5004: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5007: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   5010: astore 27
    //   5012: aload_0
    //   5013: aload_0
    //   5014: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   5017: aload 26
    //   5019: aload 25
    //   5021: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   5024: astore 31
    //   5026: aload 24
    //   5028: ifnull +12044 -> 17072
    //   5031: aload 24
    //   5033: ldc_w 492
    //   5036: invokeinterface 498 2 0
    //   5041: checkcast 282	java/lang/String
    //   5044: astore 24
    //   5046: aload_2
    //   5047: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5050: aload 24
    //   5052: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   5055: aload_0
    //   5056: lconst_0
    //   5057: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5060: aload_0
    //   5061: iconst_0
    //   5062: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   5065: aload_0
    //   5066: lconst_0
    //   5067: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   5070: aload_0
    //   5071: iconst_0
    //   5072: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   5075: aload_2
    //   5076: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5079: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5082: ifeq +12 -> 5094
    //   5085: aload_1
    //   5086: invokeinterface 359 1 0
    //   5091: ifeq +31 -> 5122
    //   5094: aload_0
    //   5095: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5098: ifnull +24 -> 5122
    //   5101: aload_0
    //   5102: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5105: aload_0
    //   5106: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5109: aload_2
    //   5110: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   5113: aload 26
    //   5115: aload 25
    //   5117: invokeinterface 523 5 0
    //   5122: aload_1
    //   5123: invokeinterface 359 1 0
    //   5128: ifne +1401 -> 6529
    //   5131: aload_0
    //   5132: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5135: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5138: istore 10
    //   5140: aload_2
    //   5141: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5144: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5147: ifne +11029 -> 16176
    //   5150: new 125	java/lang/StringBuilder
    //   5153: dup
    //   5154: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5157: ldc_w 525
    //   5160: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5163: aload_0
    //   5164: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5167: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5170: ldc_w 527
    //   5173: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5176: aload_0
    //   5177: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5180: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5183: ldc_w 532
    //   5186: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5189: astore 32
    //   5191: aload_0
    //   5192: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5195: ifeq +10947 -> 16142
    //   5198: aload 25
    //   5200: ifnull +10942 -> 16142
    //   5203: aload 25
    //   5205: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5208: ifnull +10934 -> 16142
    //   5211: aload 25
    //   5213: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5216: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5219: astore 28
    //   5221: aload 32
    //   5223: aload 28
    //   5225: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5228: ldc_w 543
    //   5231: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5234: aload 30
    //   5236: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5239: ldc_w 548
    //   5242: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5245: aload 27
    //   5247: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5250: ldc_w 550
    //   5253: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5256: aconst_null
    //   5257: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5260: ldc_w 552
    //   5263: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5266: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5269: invokevirtual 174	java/lang/Thread:getId	()J
    //   5272: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5275: ldc_w 554
    //   5278: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5281: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5284: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5287: ldc_w 556
    //   5290: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5293: aload_0
    //   5294: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5297: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5300: ldc_w 558
    //   5303: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5306: aload_0
    //   5307: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5310: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5313: ldc_w 560
    //   5316: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5319: astore 32
    //   5321: aload_0
    //   5322: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5325: ifeq +10825 -> 16150
    //   5328: aload_0
    //   5329: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5332: aload_0
    //   5333: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5336: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5339: astore 28
    //   5341: aload 32
    //   5343: aload 28
    //   5345: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5348: ldc_w 562
    //   5351: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5354: iload 10
    //   5356: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5359: ldc_w 564
    //   5362: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5365: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5368: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5371: ldc_w 571
    //   5374: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5377: aload_2
    //   5378: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5381: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5384: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5387: ldc_w 576
    //   5390: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5393: aload_2
    //   5394: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5397: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5400: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5403: ldc_w 581
    //   5406: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5409: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5412: aload_0
    //   5413: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5416: lsub
    //   5417: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5420: ldc_w 583
    //   5423: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5426: aload_2
    //   5427: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5430: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5433: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5436: ldc_w 588
    //   5439: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5442: aload_2
    //   5443: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5446: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5449: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5452: ldc_w 592
    //   5455: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5458: aload_2
    //   5459: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5462: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5465: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5468: ldc_w 597
    //   5471: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5474: aload_0
    //   5475: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   5478: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5481: ldc_w 599
    //   5484: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5487: aload_0
    //   5488: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   5491: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5494: ldc_w 604
    //   5497: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5500: aload_2
    //   5501: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5504: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5507: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5510: ldc_w 609
    //   5513: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5516: iload 4
    //   5518: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5521: ldc_w 611
    //   5524: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5527: aload 31
    //   5529: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5532: ldc_w 613
    //   5535: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5538: aload 24
    //   5540: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5543: ldc_w 615
    //   5546: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5549: astore 32
    //   5551: aload_0
    //   5552: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5555: ifnull +10601 -> 16156
    //   5558: aload_0
    //   5559: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5562: iconst_0
    //   5563: bipush 30
    //   5565: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   5568: astore 28
    //   5570: aload 32
    //   5572: aload 28
    //   5574: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5577: ldc_w 621
    //   5580: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5583: astore 28
    //   5585: aload_0
    //   5586: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5589: ifnull +10576 -> 16165
    //   5592: aload_0
    //   5593: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5596: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5599: istore_3
    //   5600: aload 28
    //   5602: iload_3
    //   5603: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5606: ldc_w 623
    //   5609: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5612: aload_2
    //   5613: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5616: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5619: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5622: ldc_w 628
    //   5625: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5628: lload 12
    //   5630: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5633: ldc_w 630
    //   5636: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5639: aload_0
    //   5640: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5643: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5646: ldc_w 599
    //   5649: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5652: aload_0
    //   5653: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   5656: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5659: ldc_w 632
    //   5662: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5665: aload_0
    //   5666: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   5669: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5672: ldc_w 599
    //   5675: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5678: aload_0
    //   5679: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   5682: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5685: ldc_w 634
    //   5688: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5691: aload_0
    //   5692: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   5695: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5698: ldc_w 636
    //   5701: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5704: aload_0
    //   5705: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   5708: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5711: ldc_w 641
    //   5714: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5717: aload_0
    //   5718: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   5721: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5724: ldc_w 646
    //   5727: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5730: astore 32
    //   5732: aload_0
    //   5733: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5736: ifnull +10434 -> 16170
    //   5739: aload_0
    //   5740: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5743: invokeinterface 656 1 0
    //   5748: astore 28
    //   5750: aload 29
    //   5752: aload 32
    //   5754: aload 28
    //   5756: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5759: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5762: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5765: ldc_w 447
    //   5768: aload 29
    //   5770: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5773: aload 23
    //   5775: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5778: aload_0
    //   5779: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5782: ifnull +24 -> 5806
    //   5785: aload_0
    //   5786: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5789: ldc_w 439
    //   5792: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5795: ifeq +11 -> 5806
    //   5798: aload_0
    //   5799: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5802: iconst_0
    //   5803: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   5806: iload 10
    //   5808: ifne +8 -> 5816
    //   5811: aload_0
    //   5812: iconst_0
    //   5813: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   5816: aload_2
    //   5817: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5820: astore 28
    //   5822: new 125	java/lang/StringBuilder
    //   5825: dup
    //   5826: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5829: aload_0
    //   5830: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5833: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5836: ldc_w 670
    //   5839: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5842: aload 27
    //   5844: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5847: ldc_w 672
    //   5850: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5853: aload_2
    //   5854: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5857: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5860: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5863: ldc_w 674
    //   5866: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5869: astore 27
    //   5871: aload_0
    //   5872: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5875: ifnull +10938 -> 16813
    //   5878: aload_0
    //   5879: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5882: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5885: istore_3
    //   5886: aload 27
    //   5888: iload_3
    //   5889: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5892: ldc_w 609
    //   5895: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5898: iload 4
    //   5900: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5903: ldc_w 571
    //   5906: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5909: aload_2
    //   5910: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5913: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5916: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5919: ldc_w 583
    //   5922: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5925: aload_2
    //   5926: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5929: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5932: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5935: ldc_w 588
    //   5938: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5941: aload_2
    //   5942: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5945: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5948: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5951: ldc_w 576
    //   5954: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5957: aload_2
    //   5958: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5961: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5964: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5967: ldc_w 581
    //   5970: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5973: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5976: aload_0
    //   5977: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5980: lsub
    //   5981: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5984: astore 27
    //   5986: aload 24
    //   5988: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5991: ifne +10827 -> 16818
    //   5994: new 125	java/lang/StringBuilder
    //   5997: dup
    //   5998: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6001: ldc_w 613
    //   6004: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6007: aload 24
    //   6009: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6012: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6015: astore 24
    //   6017: aload 28
    //   6019: aload 27
    //   6021: aload 24
    //   6023: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6026: ldc_w 611
    //   6029: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6032: aload 31
    //   6034: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6037: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6040: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   6043: aload_0
    //   6044: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6047: ifnull +53 -> 6100
    //   6050: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6053: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6056: aload_0
    //   6057: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6060: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6063: if_icmpne +37 -> 6100
    //   6066: aload_0
    //   6067: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6070: ifnull +30 -> 6100
    //   6073: aload_0
    //   6074: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6077: aload_0
    //   6078: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6081: aload_0
    //   6082: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6085: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   6088: aload_2
    //   6089: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6092: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6095: invokeinterface 684 4 0
    //   6100: aload_0
    //   6101: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6104: ifnull +53 -> 6157
    //   6107: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6110: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6113: aload_0
    //   6114: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6117: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6120: if_icmpne +37 -> 6157
    //   6123: aload_0
    //   6124: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6127: ifnull +30 -> 6157
    //   6130: aload_0
    //   6131: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6134: aload_0
    //   6135: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6138: aload_0
    //   6139: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6142: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   6145: aload_2
    //   6146: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6149: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6152: invokeinterface 684 4 0
    //   6157: iload 10
    //   6159: ifeq +64 -> 6223
    //   6162: aload_0
    //   6163: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   6166: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   6169: astore 24
    //   6171: aload_0
    //   6172: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6175: astore 27
    //   6177: aload_0
    //   6178: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6181: ifeq +10675 -> 16856
    //   6184: aload_0
    //   6185: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6188: ifnull +10668 -> 16856
    //   6191: aload_0
    //   6192: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6195: ldc_w 686
    //   6198: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6201: ifeq +10655 -> 16856
    //   6204: iconst_1
    //   6205: istore 10
    //   6207: aload 24
    //   6209: aload 27
    //   6211: iload 10
    //   6213: aload_2
    //   6214: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6217: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6220: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   6223: aload 29
    //   6225: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   6228: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   6231: aload 29
    //   6233: aload_0
    //   6234: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   6237: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   6240: aload 29
    //   6242: aload 26
    //   6244: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   6247: aload 29
    //   6249: aload 25
    //   6251: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   6254: aload 29
    //   6256: iload 4
    //   6258: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   6261: aload 29
    //   6263: aload 23
    //   6265: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   6268: aload 30
    //   6270: ifnonnull +10592 -> 16862
    //   6273: aconst_null
    //   6274: astore 23
    //   6276: aload 29
    //   6278: aload 23
    //   6280: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   6283: aload 29
    //   6285: aconst_null
    //   6286: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   6289: aload 29
    //   6291: aload_2
    //   6292: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6295: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6298: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   6301: aload 29
    //   6303: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   6306: aload_0
    //   6307: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   6310: lsub
    //   6311: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6314: aload 29
    //   6316: aload_2
    //   6317: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6320: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6323: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6326: aload 29
    //   6328: aload 29
    //   6330: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6333: aload_2
    //   6334: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6337: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6340: lsub
    //   6341: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6344: aload 29
    //   6346: lload 12
    //   6348: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6351: aload 29
    //   6353: aload_0
    //   6354: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   6357: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6360: aload 29
    //   6362: aload_0
    //   6363: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   6366: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6369: aload 29
    //   6371: aload_0
    //   6372: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   6375: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   6378: aload 29
    //   6380: lconst_0
    //   6381: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   6384: aload 29
    //   6386: aload_0
    //   6387: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   6390: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6393: aload 29
    //   6395: aload_2
    //   6396: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6399: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6402: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6405: aload 29
    //   6407: aload_0
    //   6408: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6411: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6414: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6417: aload 29
    //   6419: aload_0
    //   6420: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6423: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6426: aload_0
    //   6427: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6430: ifnull +10442 -> 16872
    //   6433: aload_0
    //   6434: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6437: ldc_w 686
    //   6440: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6443: ifeq +10429 -> 16872
    //   6446: iconst_1
    //   6447: istore 10
    //   6449: aload 29
    //   6451: iload 10
    //   6453: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6456: aload 29
    //   6458: aload_2
    //   6459: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6462: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6465: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6468: aload 29
    //   6470: getstatic 770	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   6473: invokevirtual 773	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   6476: putfield 776	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   6479: aload 25
    //   6481: ifnull +24 -> 6505
    //   6484: aload 25
    //   6486: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6489: ifnull +16 -> 6505
    //   6492: aload 29
    //   6494: aload 25
    //   6496: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6499: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6502: putfield 778	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   6505: aload_2
    //   6506: aload 29
    //   6508: invokevirtual 782	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6511: aload_2
    //   6512: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6515: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6518: ifeq +11 -> 6529
    //   6521: aload_0
    //   6522: aload_1
    //   6523: aload_2
    //   6524: aload 29
    //   6526: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6529: aload_0
    //   6530: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6533: ifeq +10345 -> 16878
    //   6536: aload_0
    //   6537: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6540: ifnull +12 -> 6552
    //   6543: aload_0
    //   6544: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6547: invokeinterface 791 1 0
    //   6552: aload_0
    //   6553: aconst_null
    //   6554: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   6557: aload 22
    //   6559: athrow
    //   6560: lload 12
    //   6562: lstore 14
    //   6564: lload 12
    //   6566: lstore 16
    //   6568: aload_0
    //   6569: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6572: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6575: getfield 831	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6578: istore 4
    //   6580: goto -1777 -> 4803
    //   6583: lload 12
    //   6585: lstore 14
    //   6587: aload 27
    //   6589: astore 22
    //   6591: lload 12
    //   6593: lstore 16
    //   6595: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6598: iconst_3
    //   6599: if_icmpne -4113 -> 2486
    //   6602: lload 12
    //   6604: lstore 14
    //   6606: aload 27
    //   6608: astore 22
    //   6610: lload 12
    //   6612: lstore 16
    //   6614: aload_0
    //   6615: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6618: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6621: getstatic 272	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6624: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6627: if_icmpeq -4141 -> 2486
    //   6630: lload 12
    //   6632: lstore 14
    //   6634: lload 12
    //   6636: lstore 16
    //   6638: aload_0
    //   6639: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6642: istore 4
    //   6644: iload 4
    //   6646: ifle +134 -> 6780
    //   6649: lload 12
    //   6651: lstore 14
    //   6653: lload 12
    //   6655: lstore 16
    //   6657: aload_0
    //   6658: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6661: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6664: iload 4
    //   6666: putfield 831	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6669: lload 12
    //   6671: lstore 14
    //   6673: lload 12
    //   6675: lstore 16
    //   6677: iload 4
    //   6679: istore 6
    //   6681: iload 4
    //   6683: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6686: ifne +7 -> 6693
    //   6689: bipush 80
    //   6691: istore 6
    //   6693: lload 12
    //   6695: lstore 14
    //   6697: lload 12
    //   6699: lstore 16
    //   6701: new 125	java/lang/StringBuilder
    //   6704: dup
    //   6705: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6708: aload 23
    //   6710: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6713: ldc_w 833
    //   6716: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6719: iload 6
    //   6721: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6724: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6727: astore 23
    //   6729: lload 12
    //   6731: lstore 14
    //   6733: aload 23
    //   6735: astore 22
    //   6737: lload 12
    //   6739: lstore 16
    //   6741: aload_0
    //   6742: getfield 835	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6745: ifnull -4259 -> 2486
    //   6748: lload 12
    //   6750: lstore 14
    //   6752: lload 12
    //   6754: lstore 16
    //   6756: aload_0
    //   6757: aload_0
    //   6758: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6761: aload_0
    //   6762: getfield 835	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6765: aload 23
    //   6767: invokevirtual 839	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6770: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6773: aload 23
    //   6775: astore 22
    //   6777: goto -4291 -> 2486
    //   6780: lload 12
    //   6782: lstore 14
    //   6784: lload 12
    //   6786: lstore 16
    //   6788: aload_0
    //   6789: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6792: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6795: getfield 831	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6798: istore 4
    //   6800: goto -131 -> 6669
    //   6803: lload 12
    //   6805: lstore 14
    //   6807: lload 12
    //   6809: lstore 16
    //   6811: aload_0
    //   6812: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6815: ifnull -4221 -> 2594
    //   6818: lload 12
    //   6820: lstore 14
    //   6822: lload 12
    //   6824: lstore 16
    //   6826: aload_0
    //   6827: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6830: ldc_w 686
    //   6833: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6836: ifeq -4242 -> 2594
    //   6839: iload 5
    //   6841: ifeq -4247 -> 2594
    //   6844: iload 10
    //   6846: ifeq -4252 -> 2594
    //   6849: lload 12
    //   6851: lstore 14
    //   6853: lload 12
    //   6855: lstore 16
    //   6857: aload_0
    //   6858: aload_0
    //   6859: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6862: ldc_w 924
    //   6865: ldc_w 926
    //   6868: invokevirtual 839	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6871: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6874: lload 12
    //   6876: lstore 14
    //   6878: lload 12
    //   6880: lstore 16
    //   6882: aload_0
    //   6883: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6886: istore 4
    //   6888: iload 4
    //   6890: ifle +231 -> 7121
    //   6893: lload 12
    //   6895: lstore 14
    //   6897: lload 12
    //   6899: lstore 16
    //   6901: aload_0
    //   6902: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6905: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6908: iload 4
    //   6910: putfield 831	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6913: lload 12
    //   6915: lstore 14
    //   6917: lload 12
    //   6919: lstore 16
    //   6921: iload 4
    //   6923: istore 6
    //   6925: iload 4
    //   6927: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6930: ifne +7 -> 6937
    //   6933: bipush 80
    //   6935: istore 6
    //   6937: lload 12
    //   6939: lstore 14
    //   6941: lload 12
    //   6943: lstore 16
    //   6945: new 125	java/lang/StringBuilder
    //   6948: dup
    //   6949: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6952: ldc_w 920
    //   6955: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6958: ldc_w 928
    //   6961: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6964: ldc_w 922
    //   6967: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6970: iload 6
    //   6972: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6975: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6978: astore 22
    //   6980: lload 12
    //   6982: lstore 14
    //   6984: lload 12
    //   6986: lstore 16
    //   6988: aload_0
    //   6989: getfield 835	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6992: ifnull +28 -> 7020
    //   6995: lload 12
    //   6997: lstore 14
    //   6999: lload 12
    //   7001: lstore 16
    //   7003: aload_0
    //   7004: aload_0
    //   7005: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7008: aload_0
    //   7009: getfield 835	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   7012: aload 22
    //   7014: invokevirtual 839	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7017: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7020: lload 12
    //   7022: lstore 14
    //   7024: lload 12
    //   7026: lstore 16
    //   7028: aload 29
    //   7030: aload_0
    //   7031: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7034: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   7037: putfield 842	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   7040: lload 12
    //   7042: lstore 14
    //   7044: lload 12
    //   7046: lstore 16
    //   7048: invokestatic 845	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   7051: ifeq -4457 -> 2594
    //   7054: lload 12
    //   7056: lstore 14
    //   7058: lload 12
    //   7060: lstore 16
    //   7062: ldc 219
    //   7064: new 125	java/lang/StringBuilder
    //   7067: dup
    //   7068: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   7071: ldc_w 847
    //   7074: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7077: aload 29
    //   7079: getfield 842	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   7082: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7085: ldc_w 930
    //   7088: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7091: aload_0
    //   7092: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7095: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7098: ldc 225
    //   7100: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7103: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7106: invokevirtual 174	java/lang/Thread:getId	()J
    //   7109: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7112: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7115: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   7118: goto -4524 -> 2594
    //   7121: lload 12
    //   7123: lstore 14
    //   7125: lload 12
    //   7127: lstore 16
    //   7129: aload_0
    //   7130: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7133: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7136: getfield 831	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   7139: istore 4
    //   7141: goto -228 -> 6913
    //   7144: lload 12
    //   7146: lstore 14
    //   7148: lload 12
    //   7150: lstore 16
    //   7152: aload_0
    //   7153: aload_0
    //   7154: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7157: aload_0
    //   7158: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7161: aload_0
    //   7162: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   7165: aload_0
    //   7166: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7169: aload_0
    //   7170: getfield 815	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   7173: aload 30
    //   7175: invokestatic 934	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   7178: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7181: goto -4477 -> 2704
    //   7184: lload 12
    //   7186: lstore 14
    //   7188: lload 12
    //   7190: lstore 16
    //   7192: aload_0
    //   7193: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7196: ifnull +9930 -> 17126
    //   7199: lload 12
    //   7201: lstore 14
    //   7203: lload 12
    //   7205: lstore 16
    //   7207: aload_0
    //   7208: aload_0
    //   7209: getfield 938	com/tencent/component/network/downloader/impl/FastDownloadTask:pokHttpClient	Lokhttp3/OkHttpClient;
    //   7212: aload_0
    //   7213: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7216: invokevirtual 944	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   7219: invokevirtual 950	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   7222: putfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   7225: lload 12
    //   7227: lstore 14
    //   7229: lload 12
    //   7231: lstore 16
    //   7233: aload_0
    //   7234: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   7237: invokeinterface 953 1 0
    //   7242: astore 22
    //   7244: aconst_null
    //   7245: astore 23
    //   7247: aconst_null
    //   7248: astore 24
    //   7250: goto -4314 -> 2936
    //   7253: aload 22
    //   7255: ifnull +9865 -> 17120
    //   7258: aload 22
    //   7260: invokevirtual 956	okhttp3/Response:code	()I
    //   7263: istore 4
    //   7265: goto -4280 -> 2985
    //   7268: aconst_null
    //   7269: astore 25
    //   7271: goto -4115 -> 3156
    //   7274: astore 24
    //   7276: ldc_w 428
    //   7279: astore 24
    //   7281: goto -4091 -> 3190
    //   7284: ldc_w 958
    //   7287: astore 26
    //   7289: goto -3924 -> 3365
    //   7292: aconst_null
    //   7293: astore 26
    //   7295: goto -3810 -> 3485
    //   7298: aload_0
    //   7299: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7302: astore 26
    //   7304: goto -3590 -> 3714
    //   7307: iconst_0
    //   7308: istore 5
    //   7310: goto -3565 -> 3745
    //   7313: aconst_null
    //   7314: astore 26
    //   7316: goto -3420 -> 3896
    //   7319: new 125	java/lang/StringBuilder
    //   7322: dup
    //   7323: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   7326: ldc_w 960
    //   7329: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7332: aload_0
    //   7333: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7336: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7339: ldc_w 527
    //   7342: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7345: aload_0
    //   7346: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7349: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7352: ldc_w 532
    //   7355: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7358: astore 30
    //   7360: aload_0
    //   7361: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7364: ifeq +560 -> 7924
    //   7367: aload 22
    //   7369: ifnull +555 -> 7924
    //   7372: aload 22
    //   7374: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7377: ifnull +547 -> 7924
    //   7380: aload 22
    //   7382: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7385: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7388: astore 26
    //   7390: aload 30
    //   7392: aload 26
    //   7394: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7397: ldc_w 543
    //   7400: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7403: aload 27
    //   7405: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7408: ldc_w 548
    //   7411: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7414: aload 25
    //   7416: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7419: ldc_w 550
    //   7422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7425: aconst_null
    //   7426: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7429: ldc_w 552
    //   7432: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7435: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7438: invokevirtual 174	java/lang/Thread:getId	()J
    //   7441: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7444: ldc_w 554
    //   7447: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7450: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7453: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7456: ldc_w 556
    //   7459: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7462: aload_0
    //   7463: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7466: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7469: ldc_w 558
    //   7472: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7475: aload_0
    //   7476: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7479: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7482: ldc_w 560
    //   7485: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7488: astore 30
    //   7490: aload_0
    //   7491: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7494: ifeq +438 -> 7932
    //   7497: aload_0
    //   7498: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7501: aload_0
    //   7502: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7505: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7508: astore 26
    //   7510: aload 30
    //   7512: aload 26
    //   7514: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7517: ldc_w 564
    //   7520: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7523: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7526: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7529: ldc_w 576
    //   7532: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7535: aload_2
    //   7536: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7539: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7542: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7545: ldc_w 581
    //   7548: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7551: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7554: aload_0
    //   7555: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7558: lsub
    //   7559: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7562: ldc_w 583
    //   7565: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7568: aload_2
    //   7569: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7572: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7575: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7578: ldc_w 588
    //   7581: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7584: aload_2
    //   7585: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7588: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7591: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7594: ldc_w 592
    //   7597: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7600: aload_2
    //   7601: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7604: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7607: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7610: ldc_w 597
    //   7613: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7616: aload_0
    //   7617: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   7620: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7623: ldc_w 599
    //   7626: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7629: aload_0
    //   7630: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   7633: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7636: ldc_w 962
    //   7639: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7642: iload 4
    //   7644: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7647: ldc_w 611
    //   7650: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7653: aload 28
    //   7655: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7658: ldc_w 571
    //   7661: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7664: aload_2
    //   7665: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7668: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7671: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7674: ldc_w 613
    //   7677: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7680: aload 24
    //   7682: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7685: ldc_w 615
    //   7688: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7691: astore 30
    //   7693: aload_0
    //   7694: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7697: ifnull +241 -> 7938
    //   7700: aload_0
    //   7701: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7704: iconst_0
    //   7705: bipush 30
    //   7707: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   7710: astore 26
    //   7712: aload 30
    //   7714: aload 26
    //   7716: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7719: ldc_w 621
    //   7722: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7725: astore 26
    //   7727: aload_0
    //   7728: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7731: ifnull +216 -> 7947
    //   7734: aload_0
    //   7735: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7738: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7741: istore 5
    //   7743: aload 26
    //   7745: iload 5
    //   7747: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7750: ldc_w 623
    //   7753: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7756: aload_2
    //   7757: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7760: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7763: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7766: ldc_w 628
    //   7769: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7772: lload 12
    //   7774: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7777: ldc_w 630
    //   7780: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7783: aload_0
    //   7784: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   7787: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7790: ldc_w 599
    //   7793: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7796: aload_0
    //   7797: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   7800: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7803: ldc_w 632
    //   7806: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7809: aload_0
    //   7810: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   7813: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7816: ldc_w 599
    //   7819: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7822: aload_0
    //   7823: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   7826: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7829: ldc_w 634
    //   7832: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7835: aload_0
    //   7836: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   7839: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7842: ldc_w 636
    //   7845: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7848: aload_0
    //   7849: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   7852: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7855: ldc_w 641
    //   7858: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7861: aload_0
    //   7862: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   7865: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7868: ldc_w 646
    //   7871: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7874: astore 30
    //   7876: aload_0
    //   7877: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7880: ifnull +73 -> 7953
    //   7883: aload_0
    //   7884: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7887: invokeinterface 656 1 0
    //   7892: astore 26
    //   7894: aload 29
    //   7896: aload 30
    //   7898: aload 26
    //   7900: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7903: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7906: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7909: ldc_w 447
    //   7912: aload 29
    //   7914: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7917: aconst_null
    //   7918: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7921: goto -3970 -> 3951
    //   7924: ldc_w 958
    //   7927: astore 26
    //   7929: goto -539 -> 7390
    //   7932: aconst_null
    //   7933: astore 26
    //   7935: goto -425 -> 7510
    //   7938: aload_0
    //   7939: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7942: astore 26
    //   7944: goto -232 -> 7712
    //   7947: iconst_0
    //   7948: istore 5
    //   7950: goto -207 -> 7743
    //   7953: aconst_null
    //   7954: astore 26
    //   7956: goto -62 -> 7894
    //   7959: iconst_0
    //   7960: istore 5
    //   7962: goto -3930 -> 4032
    //   7965: ldc_w 428
    //   7968: astore 24
    //   7970: goto -3806 -> 4164
    //   7973: astore 24
    //   7975: ldc 219
    //   7977: ldc_w 967
    //   7980: aload 24
    //   7982: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7985: goto -3738 -> 4247
    //   7988: astore 24
    //   7990: ldc 219
    //   7992: ldc_w 969
    //   7995: aload 24
    //   7997: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8000: goto -3696 -> 4304
    //   8003: iconst_0
    //   8004: istore 10
    //   8006: goto -3652 -> 4354
    //   8009: aload 27
    //   8011: invokevirtual 972	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8014: astore 23
    //   8016: goto -3594 -> 4422
    //   8019: iconst_0
    //   8020: istore 10
    //   8022: goto -3427 -> 4595
    //   8025: aload_0
    //   8026: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8029: ifnull +15 -> 8044
    //   8032: aload_0
    //   8033: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8036: invokevirtual 977	org/apache/http/client/methods/HttpGet:abort	()V
    //   8039: aload_0
    //   8040: aconst_null
    //   8041: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8044: aload_0
    //   8045: invokevirtual 980	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   8048: goto -3345 -> 4703
    //   8051: aload_2
    //   8052: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8055: lload 18
    //   8057: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8060: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   8063: aload_2
    //   8064: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8067: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8070: aload_0
    //   8071: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8074: lsub
    //   8075: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8078: aload_2
    //   8079: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8082: aload_0
    //   8083: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   8086: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8089: aload_0
    //   8090: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8093: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8096: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8099: astore 27
    //   8101: aload_0
    //   8102: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8105: ifnull +1569 -> 9674
    //   8108: aload_0
    //   8109: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8112: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8115: ifnull +1559 -> 9674
    //   8118: aload_0
    //   8119: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8122: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8125: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   8128: astore 25
    //   8130: aload_0
    //   8131: aload_0
    //   8132: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8135: aload 23
    //   8137: aload 22
    //   8139: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   8142: astore 28
    //   8144: aload 24
    //   8146: ifnull +8958 -> 17104
    //   8149: aload 24
    //   8151: ldc_w 492
    //   8154: invokeinterface 498 2 0
    //   8159: checkcast 282	java/lang/String
    //   8162: astore 24
    //   8164: aload_2
    //   8165: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8168: aload 24
    //   8170: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8173: aload_0
    //   8174: lconst_0
    //   8175: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8178: aload_0
    //   8179: iconst_0
    //   8180: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8183: aload_0
    //   8184: lconst_0
    //   8185: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8188: aload_0
    //   8189: iconst_0
    //   8190: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8193: aload_2
    //   8194: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8197: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8200: ifeq +12 -> 8212
    //   8203: aload_1
    //   8204: invokeinterface 359 1 0
    //   8209: ifeq +31 -> 8240
    //   8212: aload_0
    //   8213: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8216: ifnull +24 -> 8240
    //   8219: aload_0
    //   8220: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8223: aload_0
    //   8224: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8227: aload_2
    //   8228: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   8231: aload 23
    //   8233: aload 22
    //   8235: invokeinterface 523 5 0
    //   8240: aload_1
    //   8241: invokeinterface 359 1 0
    //   8246: ifne +1399 -> 9645
    //   8249: aload_0
    //   8250: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8253: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8256: istore 10
    //   8258: aload_2
    //   8259: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8262: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8265: ifne +1459 -> 9724
    //   8268: new 125	java/lang/StringBuilder
    //   8271: dup
    //   8272: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8275: ldc_w 525
    //   8278: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8281: aload_0
    //   8282: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8285: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8288: ldc_w 527
    //   8291: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8294: aload_0
    //   8295: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8298: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8301: ldc_w 532
    //   8304: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8307: astore 30
    //   8309: aload_0
    //   8310: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8313: ifeq +1377 -> 9690
    //   8316: aload 22
    //   8318: ifnull +1372 -> 9690
    //   8321: aload 22
    //   8323: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8326: ifnull +1364 -> 9690
    //   8329: aload 22
    //   8331: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8334: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8337: astore 26
    //   8339: aload 30
    //   8341: aload 26
    //   8343: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8346: ldc_w 543
    //   8349: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8352: aload 27
    //   8354: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8357: ldc_w 548
    //   8360: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8363: aload 25
    //   8365: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8368: ldc_w 550
    //   8371: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8374: aconst_null
    //   8375: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8378: ldc_w 552
    //   8381: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8384: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8387: invokevirtual 174	java/lang/Thread:getId	()J
    //   8390: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8393: ldc_w 554
    //   8396: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8399: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8402: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8405: ldc_w 556
    //   8408: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8411: aload_0
    //   8412: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8415: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8418: ldc_w 558
    //   8421: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8424: aload_0
    //   8425: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8428: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8431: ldc_w 560
    //   8434: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8437: astore 30
    //   8439: aload_0
    //   8440: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8443: ifeq +1255 -> 9698
    //   8446: aload_0
    //   8447: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8450: aload_0
    //   8451: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8454: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8457: astore 26
    //   8459: aload 30
    //   8461: aload 26
    //   8463: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8466: ldc_w 562
    //   8469: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8472: iload 10
    //   8474: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8477: ldc_w 564
    //   8480: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8483: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8486: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8489: ldc_w 571
    //   8492: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8495: aload_2
    //   8496: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8499: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8502: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8505: ldc_w 576
    //   8508: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8511: aload_2
    //   8512: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8515: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8518: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8521: ldc_w 581
    //   8524: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8527: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8530: aload_0
    //   8531: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8534: lsub
    //   8535: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8538: ldc_w 583
    //   8541: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8544: aload_2
    //   8545: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8548: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8551: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8554: ldc_w 588
    //   8557: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8560: aload_2
    //   8561: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8564: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8567: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8570: ldc_w 592
    //   8573: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8576: aload_2
    //   8577: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8580: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8583: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8586: ldc_w 597
    //   8589: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8592: aload_0
    //   8593: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   8596: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8599: ldc_w 599
    //   8602: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8605: aload_0
    //   8606: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   8609: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8612: ldc_w 604
    //   8615: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8618: aload_2
    //   8619: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8622: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8625: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8628: ldc_w 609
    //   8631: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8634: iload 4
    //   8636: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8639: ldc_w 611
    //   8642: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8645: aload 28
    //   8647: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8650: ldc_w 613
    //   8653: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8656: aload 24
    //   8658: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8661: ldc_w 615
    //   8664: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8667: astore 30
    //   8669: aload_0
    //   8670: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8673: ifnull +1031 -> 9704
    //   8676: aload_0
    //   8677: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8680: iconst_0
    //   8681: bipush 30
    //   8683: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   8686: astore 26
    //   8688: aload 30
    //   8690: aload 26
    //   8692: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8695: ldc_w 621
    //   8698: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8701: astore 26
    //   8703: aload_0
    //   8704: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8707: ifnull +1006 -> 9713
    //   8710: aload_0
    //   8711: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8714: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8717: istore_3
    //   8718: aload 26
    //   8720: iload_3
    //   8721: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8724: ldc_w 623
    //   8727: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8730: aload_2
    //   8731: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8734: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8737: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8740: ldc_w 628
    //   8743: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8746: lload 12
    //   8748: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8751: ldc_w 630
    //   8754: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8757: aload_0
    //   8758: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8761: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8764: ldc_w 599
    //   8767: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8770: aload_0
    //   8771: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8774: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8777: ldc_w 632
    //   8780: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8783: aload_0
    //   8784: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8787: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8790: ldc_w 599
    //   8793: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8796: aload_0
    //   8797: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8800: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8803: ldc_w 634
    //   8806: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8809: aload_0
    //   8810: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   8813: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8816: ldc_w 636
    //   8819: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8822: aload_0
    //   8823: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   8826: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8829: ldc_w 641
    //   8832: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8835: aload_0
    //   8836: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   8839: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8842: ldc_w 646
    //   8845: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8848: astore 30
    //   8850: aload_0
    //   8851: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8854: ifnull +864 -> 9718
    //   8857: aload_0
    //   8858: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8861: invokeinterface 656 1 0
    //   8866: astore 26
    //   8868: aload 29
    //   8870: aload 30
    //   8872: aload 26
    //   8874: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8877: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8880: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8883: ldc_w 447
    //   8886: aload 29
    //   8888: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8891: aconst_null
    //   8892: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8895: aload_0
    //   8896: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8899: ifnull +24 -> 8923
    //   8902: aload_0
    //   8903: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8906: ldc_w 439
    //   8909: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8912: ifeq +11 -> 8923
    //   8915: aload_0
    //   8916: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8919: iconst_0
    //   8920: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   8923: iload 10
    //   8925: ifne +8 -> 8933
    //   8928: aload_0
    //   8929: iconst_0
    //   8930: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   8933: aload_2
    //   8934: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8937: astore 26
    //   8939: new 125	java/lang/StringBuilder
    //   8942: dup
    //   8943: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8946: aload_0
    //   8947: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8950: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8953: ldc_w 670
    //   8956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8959: aload 25
    //   8961: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8964: ldc_w 672
    //   8967: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8970: aload_2
    //   8971: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8974: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8977: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8980: ldc_w 674
    //   8983: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8986: astore 25
    //   8988: aload_0
    //   8989: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8992: ifnull +1369 -> 10361
    //   8995: aload_0
    //   8996: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8999: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9002: istore_3
    //   9003: aload 25
    //   9005: iload_3
    //   9006: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9009: ldc_w 609
    //   9012: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9015: iload 4
    //   9017: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9020: ldc_w 571
    //   9023: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9026: aload_2
    //   9027: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9030: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9033: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9036: ldc_w 583
    //   9039: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9042: aload_2
    //   9043: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9046: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9049: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9052: ldc_w 588
    //   9055: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9058: aload_2
    //   9059: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9062: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9065: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9068: ldc_w 576
    //   9071: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9074: aload_2
    //   9075: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9078: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9081: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9084: ldc_w 581
    //   9087: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9090: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9093: aload_0
    //   9094: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9097: lsub
    //   9098: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9101: astore 25
    //   9103: aload 24
    //   9105: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9108: ifne +1258 -> 10366
    //   9111: new 125	java/lang/StringBuilder
    //   9114: dup
    //   9115: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   9118: ldc_w 613
    //   9121: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9124: aload 24
    //   9126: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9129: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9132: astore 24
    //   9134: aload 26
    //   9136: aload 25
    //   9138: aload 24
    //   9140: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9143: ldc_w 611
    //   9146: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9149: aload 28
    //   9151: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9154: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9157: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   9160: aload_0
    //   9161: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9164: ifnull +53 -> 9217
    //   9167: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9170: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9173: aload_0
    //   9174: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9177: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9180: if_icmpne +37 -> 9217
    //   9183: aload_0
    //   9184: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9187: ifnull +30 -> 9217
    //   9190: aload_0
    //   9191: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9194: aload_0
    //   9195: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9198: aload_0
    //   9199: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9202: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9205: aload_2
    //   9206: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9209: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9212: invokeinterface 684 4 0
    //   9217: aload_0
    //   9218: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9221: ifnull +53 -> 9274
    //   9224: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9227: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9230: aload_0
    //   9231: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9234: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9237: if_icmpne +37 -> 9274
    //   9240: aload_0
    //   9241: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9244: ifnull +30 -> 9274
    //   9247: aload_0
    //   9248: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9251: aload_0
    //   9252: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9255: aload_0
    //   9256: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9259: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9262: aload_2
    //   9263: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9266: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9269: invokeinterface 684 4 0
    //   9274: iload 10
    //   9276: ifeq +64 -> 9340
    //   9279: aload_0
    //   9280: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9283: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   9286: astore 24
    //   9288: aload_0
    //   9289: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9292: astore 25
    //   9294: aload_0
    //   9295: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9298: ifeq +1106 -> 10404
    //   9301: aload_0
    //   9302: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9305: ifnull +1099 -> 10404
    //   9308: aload_0
    //   9309: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9312: ldc_w 686
    //   9315: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9318: ifeq +1086 -> 10404
    //   9321: iconst_1
    //   9322: istore 10
    //   9324: aload 24
    //   9326: aload 25
    //   9328: iload 10
    //   9330: aload_2
    //   9331: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9334: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9337: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   9340: aload 29
    //   9342: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   9345: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   9348: aload 29
    //   9350: aload_0
    //   9351: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   9354: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   9357: aload 29
    //   9359: aload 23
    //   9361: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   9364: aload 29
    //   9366: aload 22
    //   9368: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   9371: aload 29
    //   9373: iload 4
    //   9375: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   9378: aload 29
    //   9380: aconst_null
    //   9381: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   9384: aload 27
    //   9386: ifnonnull +1024 -> 10410
    //   9389: aconst_null
    //   9390: astore 23
    //   9392: aload 29
    //   9394: aload 23
    //   9396: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   9399: aload 29
    //   9401: aconst_null
    //   9402: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9405: aload 29
    //   9407: aload_2
    //   9408: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9411: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9414: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9417: aload 29
    //   9419: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9422: aload_0
    //   9423: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9426: lsub
    //   9427: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9430: aload 29
    //   9432: aload_2
    //   9433: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9436: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9439: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9442: aload 29
    //   9444: aload 29
    //   9446: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9449: aload_2
    //   9450: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9453: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9456: lsub
    //   9457: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9460: aload 29
    //   9462: lload 12
    //   9464: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9467: aload 29
    //   9469: aload_0
    //   9470: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9473: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9476: aload 29
    //   9478: aload_0
    //   9479: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   9482: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9485: aload 29
    //   9487: aload_0
    //   9488: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   9491: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9494: aload 29
    //   9496: lconst_0
    //   9497: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9500: aload 29
    //   9502: aload_0
    //   9503: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   9506: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9509: aload 29
    //   9511: aload_2
    //   9512: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9515: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9518: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9521: aload 29
    //   9523: aload_0
    //   9524: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9527: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9530: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9533: aload 29
    //   9535: aload_0
    //   9536: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9539: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9542: aload_0
    //   9543: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9546: ifnull +874 -> 10420
    //   9549: aload_0
    //   9550: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9553: ldc_w 686
    //   9556: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9559: ifeq +861 -> 10420
    //   9562: iconst_1
    //   9563: istore 10
    //   9565: aload 29
    //   9567: iload 10
    //   9569: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9572: aload 29
    //   9574: aload_2
    //   9575: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9578: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9581: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9584: aload 29
    //   9586: getstatic 770	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   9589: invokevirtual 773	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   9592: putfield 776	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   9595: aload 22
    //   9597: ifnull +24 -> 9621
    //   9600: aload 22
    //   9602: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9605: ifnull +16 -> 9621
    //   9608: aload 29
    //   9610: aload 22
    //   9612: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9615: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9618: putfield 778	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   9621: aload_2
    //   9622: aload 29
    //   9624: invokevirtual 782	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9627: aload_2
    //   9628: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9631: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9634: ifeq +11 -> 9645
    //   9637: aload_0
    //   9638: aload_1
    //   9639: aload_2
    //   9640: aload 29
    //   9642: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9645: aload_0
    //   9646: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9649: ifeq +777 -> 10426
    //   9652: aload_0
    //   9653: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   9656: ifnull +12 -> 9668
    //   9659: aload_0
    //   9660: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   9663: invokeinterface 791 1 0
    //   9668: aload_0
    //   9669: aconst_null
    //   9670: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   9673: return
    //   9674: aconst_null
    //   9675: astore 25
    //   9677: goto -1547 -> 8130
    //   9680: astore 24
    //   9682: ldc_w 428
    //   9685: astore 24
    //   9687: goto -1523 -> 8164
    //   9690: ldc_w 958
    //   9693: astore 26
    //   9695: goto -1356 -> 8339
    //   9698: aconst_null
    //   9699: astore 26
    //   9701: goto -1242 -> 8459
    //   9704: aload_0
    //   9705: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9708: astore 26
    //   9710: goto -1022 -> 8688
    //   9713: iconst_0
    //   9714: istore_3
    //   9715: goto -997 -> 8718
    //   9718: aconst_null
    //   9719: astore 26
    //   9721: goto -853 -> 8868
    //   9724: new 125	java/lang/StringBuilder
    //   9727: dup
    //   9728: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   9731: ldc_w 960
    //   9734: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9737: aload_0
    //   9738: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   9741: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9744: ldc_w 527
    //   9747: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9750: aload_0
    //   9751: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9754: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9757: ldc_w 532
    //   9760: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9763: astore 30
    //   9765: aload_0
    //   9766: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9769: ifeq +558 -> 10327
    //   9772: aload 22
    //   9774: ifnull +553 -> 10327
    //   9777: aload 22
    //   9779: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9782: ifnull +545 -> 10327
    //   9785: aload 22
    //   9787: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9790: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9793: astore 26
    //   9795: aload 30
    //   9797: aload 26
    //   9799: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9802: ldc_w 543
    //   9805: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9808: aload 27
    //   9810: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9813: ldc_w 548
    //   9816: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9819: aload 25
    //   9821: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9824: ldc_w 550
    //   9827: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9830: aconst_null
    //   9831: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9834: ldc_w 552
    //   9837: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9840: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9843: invokevirtual 174	java/lang/Thread:getId	()J
    //   9846: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9849: ldc_w 554
    //   9852: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9855: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9858: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9861: ldc_w 556
    //   9864: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9867: aload_0
    //   9868: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9871: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9874: ldc_w 558
    //   9877: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9880: aload_0
    //   9881: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9884: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9887: ldc_w 560
    //   9890: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9893: astore 30
    //   9895: aload_0
    //   9896: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9899: ifeq +436 -> 10335
    //   9902: aload_0
    //   9903: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9906: aload_0
    //   9907: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9910: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9913: astore 26
    //   9915: aload 30
    //   9917: aload 26
    //   9919: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9922: ldc_w 564
    //   9925: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9928: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9931: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9934: ldc_w 576
    //   9937: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9940: aload_2
    //   9941: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9944: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9947: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9950: ldc_w 581
    //   9953: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9956: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9959: aload_0
    //   9960: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9963: lsub
    //   9964: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9967: ldc_w 583
    //   9970: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9973: aload_2
    //   9974: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9977: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9980: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9983: ldc_w 588
    //   9986: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9989: aload_2
    //   9990: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9993: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9996: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9999: ldc_w 592
    //   10002: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10005: aload_2
    //   10006: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10009: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10012: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10015: ldc_w 597
    //   10018: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10021: aload_0
    //   10022: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   10025: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10028: ldc_w 599
    //   10031: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10034: aload_0
    //   10035: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   10038: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10041: ldc_w 962
    //   10044: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10047: iload 4
    //   10049: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10052: ldc_w 611
    //   10055: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10058: aload 28
    //   10060: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10063: ldc_w 571
    //   10066: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10069: aload_2
    //   10070: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10073: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10076: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10079: ldc_w 613
    //   10082: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10085: aload 24
    //   10087: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10090: ldc_w 615
    //   10093: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10096: astore 30
    //   10098: aload_0
    //   10099: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10102: ifnull +239 -> 10341
    //   10105: aload_0
    //   10106: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10109: iconst_0
    //   10110: bipush 30
    //   10112: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   10115: astore 26
    //   10117: aload 30
    //   10119: aload 26
    //   10121: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10124: ldc_w 621
    //   10127: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10130: astore 26
    //   10132: aload_0
    //   10133: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10136: ifnull +214 -> 10350
    //   10139: aload_0
    //   10140: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10143: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10146: istore_3
    //   10147: aload 26
    //   10149: iload_3
    //   10150: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10153: ldc_w 623
    //   10156: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10159: aload_2
    //   10160: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10163: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10166: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10169: ldc_w 628
    //   10172: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10175: lload 12
    //   10177: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10180: ldc_w 630
    //   10183: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10186: aload_0
    //   10187: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10190: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10193: ldc_w 599
    //   10196: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10199: aload_0
    //   10200: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10203: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10206: ldc_w 632
    //   10209: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10212: aload_0
    //   10213: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10216: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10219: ldc_w 599
    //   10222: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10225: aload_0
    //   10226: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10229: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10232: ldc_w 634
    //   10235: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10238: aload_0
    //   10239: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   10242: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10245: ldc_w 636
    //   10248: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10251: aload_0
    //   10252: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   10255: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10258: ldc_w 641
    //   10261: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10264: aload_0
    //   10265: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   10268: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10271: ldc_w 646
    //   10274: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10277: astore 30
    //   10279: aload_0
    //   10280: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10283: ifnull +72 -> 10355
    //   10286: aload_0
    //   10287: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10290: invokeinterface 656 1 0
    //   10295: astore 26
    //   10297: aload 29
    //   10299: aload 30
    //   10301: aload 26
    //   10303: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10306: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10309: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10312: ldc_w 447
    //   10315: aload 29
    //   10317: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10320: aconst_null
    //   10321: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10324: goto -1401 -> 8923
    //   10327: ldc_w 958
    //   10330: astore 26
    //   10332: goto -537 -> 9795
    //   10335: aconst_null
    //   10336: astore 26
    //   10338: goto -423 -> 9915
    //   10341: aload_0
    //   10342: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10345: astore 26
    //   10347: goto -230 -> 10117
    //   10350: iconst_0
    //   10351: istore_3
    //   10352: goto -205 -> 10147
    //   10355: aconst_null
    //   10356: astore 26
    //   10358: goto -61 -> 10297
    //   10361: iconst_0
    //   10362: istore_3
    //   10363: goto -1360 -> 9003
    //   10366: ldc_w 428
    //   10369: astore 24
    //   10371: goto -1237 -> 9134
    //   10374: astore 24
    //   10376: ldc 219
    //   10378: ldc_w 967
    //   10381: aload 24
    //   10383: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10386: goto -1169 -> 9217
    //   10389: astore 24
    //   10391: ldc 219
    //   10393: ldc_w 969
    //   10396: aload 24
    //   10398: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10401: goto -1127 -> 9274
    //   10404: iconst_0
    //   10405: istore 10
    //   10407: goto -1083 -> 9324
    //   10410: aload 27
    //   10412: invokevirtual 972	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10415: astore 23
    //   10417: goto -1025 -> 9392
    //   10420: iconst_0
    //   10421: istore 10
    //   10423: goto -858 -> 9565
    //   10426: aload_0
    //   10427: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10430: ifnull +15 -> 10445
    //   10433: aload_0
    //   10434: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10437: invokevirtual 977	org/apache/http/client/methods/HttpGet:abort	()V
    //   10440: aload_0
    //   10441: aconst_null
    //   10442: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10445: aload_0
    //   10446: invokevirtual 980	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   10449: return
    //   10450: aload_2
    //   10451: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10454: lload 18
    //   10456: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10459: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   10462: aload_2
    //   10463: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10466: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10469: aload_0
    //   10470: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10473: lsub
    //   10474: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   10477: aload_2
    //   10478: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10481: aload_0
    //   10482: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   10485: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   10488: aload_0
    //   10489: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10492: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   10495: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   10498: astore 27
    //   10500: aload_0
    //   10501: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10504: ifnull +1569 -> 12073
    //   10507: aload_0
    //   10508: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10511: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10514: ifnull +1559 -> 12073
    //   10517: aload_0
    //   10518: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10521: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10524: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   10527: astore 25
    //   10529: aload_0
    //   10530: aload_0
    //   10531: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10534: aload 23
    //   10536: aload 22
    //   10538: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   10541: astore 28
    //   10543: aload 24
    //   10545: ifnull +6551 -> 17096
    //   10548: aload 24
    //   10550: ldc_w 492
    //   10553: invokeinterface 498 2 0
    //   10558: checkcast 282	java/lang/String
    //   10561: astore 24
    //   10563: aload_2
    //   10564: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10567: aload 24
    //   10569: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   10572: aload_0
    //   10573: lconst_0
    //   10574: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10577: aload_0
    //   10578: iconst_0
    //   10579: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10582: aload_0
    //   10583: lconst_0
    //   10584: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10587: aload_0
    //   10588: iconst_0
    //   10589: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10592: aload_2
    //   10593: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10596: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10599: ifeq +12 -> 10611
    //   10602: aload_1
    //   10603: invokeinterface 359 1 0
    //   10608: ifeq +31 -> 10639
    //   10611: aload_0
    //   10612: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10615: ifnull +24 -> 10639
    //   10618: aload_0
    //   10619: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10622: aload_0
    //   10623: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10626: aload_2
    //   10627: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   10630: aload 23
    //   10632: aload 22
    //   10634: invokeinterface 523 5 0
    //   10639: aload_1
    //   10640: invokeinterface 359 1 0
    //   10645: ifne +1399 -> 12044
    //   10648: aload_0
    //   10649: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10652: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10655: istore 10
    //   10657: aload_2
    //   10658: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10661: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10664: ifne +1459 -> 12123
    //   10667: new 125	java/lang/StringBuilder
    //   10670: dup
    //   10671: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   10674: ldc_w 525
    //   10677: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10680: aload_0
    //   10681: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10684: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10687: ldc_w 527
    //   10690: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10693: aload_0
    //   10694: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10697: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10700: ldc_w 532
    //   10703: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10706: astore 30
    //   10708: aload_0
    //   10709: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10712: ifeq +1377 -> 12089
    //   10715: aload 22
    //   10717: ifnull +1372 -> 12089
    //   10720: aload 22
    //   10722: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10725: ifnull +1364 -> 12089
    //   10728: aload 22
    //   10730: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10733: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   10736: astore 26
    //   10738: aload 30
    //   10740: aload 26
    //   10742: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10745: ldc_w 543
    //   10748: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10751: aload 27
    //   10753: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10756: ldc_w 548
    //   10759: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10762: aload 25
    //   10764: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10767: ldc_w 550
    //   10770: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10773: aconst_null
    //   10774: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10777: ldc_w 552
    //   10780: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10783: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10786: invokevirtual 174	java/lang/Thread:getId	()J
    //   10789: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10792: ldc_w 554
    //   10795: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10798: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10801: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10804: ldc_w 556
    //   10807: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10810: aload_0
    //   10811: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10814: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10817: ldc_w 558
    //   10820: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10823: aload_0
    //   10824: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10827: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10830: ldc_w 560
    //   10833: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10836: astore 30
    //   10838: aload_0
    //   10839: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10842: ifeq +1255 -> 12097
    //   10845: aload_0
    //   10846: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10849: aload_0
    //   10850: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10853: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10856: astore 26
    //   10858: aload 30
    //   10860: aload 26
    //   10862: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10865: ldc_w 562
    //   10868: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10871: iload 10
    //   10873: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10876: ldc_w 564
    //   10879: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10882: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10885: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10888: ldc_w 571
    //   10891: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10894: aload_2
    //   10895: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10898: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10901: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10904: ldc_w 576
    //   10907: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10910: aload_2
    //   10911: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10914: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10917: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10920: ldc_w 581
    //   10923: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10926: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10929: aload_0
    //   10930: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10933: lsub
    //   10934: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10937: ldc_w 583
    //   10940: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10943: aload_2
    //   10944: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10947: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10950: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10953: ldc_w 588
    //   10956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10959: aload_2
    //   10960: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10963: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10966: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10969: ldc_w 592
    //   10972: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10975: aload_2
    //   10976: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10979: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10982: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10985: ldc_w 597
    //   10988: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10991: aload_0
    //   10992: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   10995: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10998: ldc_w 599
    //   11001: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11004: aload_0
    //   11005: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   11008: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11011: ldc_w 604
    //   11014: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11017: aload_2
    //   11018: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11021: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   11024: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11027: ldc_w 609
    //   11030: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11033: iload 4
    //   11035: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11038: ldc_w 611
    //   11041: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11044: aload 28
    //   11046: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11049: ldc_w 613
    //   11052: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11055: aload 24
    //   11057: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11060: ldc_w 615
    //   11063: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11066: astore 30
    //   11068: aload_0
    //   11069: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11072: ifnull +1031 -> 12103
    //   11075: aload_0
    //   11076: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11079: iconst_0
    //   11080: bipush 30
    //   11082: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   11085: astore 26
    //   11087: aload 30
    //   11089: aload 26
    //   11091: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11094: ldc_w 621
    //   11097: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11100: astore 26
    //   11102: aload_0
    //   11103: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11106: ifnull +1006 -> 12112
    //   11109: aload_0
    //   11110: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11113: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11116: istore_3
    //   11117: aload 26
    //   11119: iload_3
    //   11120: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11123: ldc_w 623
    //   11126: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11129: aload_2
    //   11130: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11133: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11136: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11139: ldc_w 628
    //   11142: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11145: lload 12
    //   11147: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11150: ldc_w 630
    //   11153: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11156: aload_0
    //   11157: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11160: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11163: ldc_w 599
    //   11166: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11169: aload_0
    //   11170: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   11173: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11176: ldc_w 632
    //   11179: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11182: aload_0
    //   11183: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   11186: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11189: ldc_w 599
    //   11192: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11195: aload_0
    //   11196: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   11199: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11202: ldc_w 634
    //   11205: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11208: aload_0
    //   11209: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   11212: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11215: ldc_w 636
    //   11218: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11221: aload_0
    //   11222: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11225: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11228: ldc_w 641
    //   11231: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11234: aload_0
    //   11235: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11238: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11241: ldc_w 646
    //   11244: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11247: astore 30
    //   11249: aload_0
    //   11250: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11253: ifnull +864 -> 12117
    //   11256: aload_0
    //   11257: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11260: invokeinterface 656 1 0
    //   11265: astore 26
    //   11267: aload 29
    //   11269: aload 30
    //   11271: aload 26
    //   11273: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11276: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11279: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   11282: ldc_w 447
    //   11285: aload 29
    //   11287: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   11290: aconst_null
    //   11291: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11294: aload_0
    //   11295: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11298: ifnull +24 -> 11322
    //   11301: aload_0
    //   11302: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11305: ldc_w 439
    //   11308: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11311: ifeq +11 -> 11322
    //   11314: aload_0
    //   11315: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11318: iconst_0
    //   11319: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   11322: iload 10
    //   11324: ifne +8 -> 11332
    //   11327: aload_0
    //   11328: iconst_0
    //   11329: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   11332: aload_2
    //   11333: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11336: astore 26
    //   11338: new 125	java/lang/StringBuilder
    //   11341: dup
    //   11342: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11345: aload_0
    //   11346: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11349: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11352: ldc_w 670
    //   11355: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11358: aload 25
    //   11360: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11363: ldc_w 672
    //   11366: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11369: aload_2
    //   11370: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11373: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11376: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11379: ldc_w 674
    //   11382: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11385: astore 25
    //   11387: aload_0
    //   11388: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11391: ifnull +1369 -> 12760
    //   11394: aload_0
    //   11395: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11398: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11401: istore_3
    //   11402: aload 25
    //   11404: iload_3
    //   11405: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11408: ldc_w 609
    //   11411: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11414: iload 4
    //   11416: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11419: ldc_w 571
    //   11422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11425: aload_2
    //   11426: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11429: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11432: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11435: ldc_w 583
    //   11438: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11441: aload_2
    //   11442: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11445: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11448: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11451: ldc_w 588
    //   11454: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11457: aload_2
    //   11458: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11461: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11464: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11467: ldc_w 576
    //   11470: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11473: aload_2
    //   11474: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11477: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11480: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11483: ldc_w 581
    //   11486: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11489: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11492: aload_0
    //   11493: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11496: lsub
    //   11497: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11500: astore 25
    //   11502: aload 24
    //   11504: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11507: ifne +1258 -> 12765
    //   11510: new 125	java/lang/StringBuilder
    //   11513: dup
    //   11514: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11517: ldc_w 613
    //   11520: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11523: aload 24
    //   11525: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11528: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11531: astore 24
    //   11533: aload 26
    //   11535: aload 25
    //   11537: aload 24
    //   11539: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11542: ldc_w 611
    //   11545: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11548: aload 28
    //   11550: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11553: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11556: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   11559: aload_0
    //   11560: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11563: ifnull +53 -> 11616
    //   11566: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11569: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11572: aload_0
    //   11573: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11576: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11579: if_icmpne +37 -> 11616
    //   11582: aload_0
    //   11583: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11586: ifnull +30 -> 11616
    //   11589: aload_0
    //   11590: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11593: aload_0
    //   11594: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11597: aload_0
    //   11598: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11601: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11604: aload_2
    //   11605: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11608: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11611: invokeinterface 684 4 0
    //   11616: aload_0
    //   11617: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11620: ifnull +53 -> 11673
    //   11623: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11626: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11629: aload_0
    //   11630: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11633: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11636: if_icmpne +37 -> 11673
    //   11639: aload_0
    //   11640: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11643: ifnull +30 -> 11673
    //   11646: aload_0
    //   11647: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11650: aload_0
    //   11651: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11654: aload_0
    //   11655: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11658: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11661: aload_2
    //   11662: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11665: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11668: invokeinterface 684 4 0
    //   11673: iload 10
    //   11675: ifeq +64 -> 11739
    //   11678: aload_0
    //   11679: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11682: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   11685: astore 24
    //   11687: aload_0
    //   11688: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11691: astore 25
    //   11693: aload_0
    //   11694: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11697: ifeq +1106 -> 12803
    //   11700: aload_0
    //   11701: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11704: ifnull +1099 -> 12803
    //   11707: aload_0
    //   11708: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11711: ldc_w 686
    //   11714: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11717: ifeq +1086 -> 12803
    //   11720: iconst_1
    //   11721: istore 10
    //   11723: aload 24
    //   11725: aload 25
    //   11727: iload 10
    //   11729: aload_2
    //   11730: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11733: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11736: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   11739: aload 29
    //   11741: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   11744: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   11747: aload 29
    //   11749: aload_0
    //   11750: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   11753: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   11756: aload 29
    //   11758: aload 23
    //   11760: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   11763: aload 29
    //   11765: aload 22
    //   11767: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   11770: aload 29
    //   11772: iload 4
    //   11774: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   11777: aload 29
    //   11779: aconst_null
    //   11780: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   11783: aload 27
    //   11785: ifnonnull +1024 -> 12809
    //   11788: aconst_null
    //   11789: astore 23
    //   11791: aload 29
    //   11793: aload 23
    //   11795: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   11798: aload 29
    //   11800: aconst_null
    //   11801: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   11804: aload 29
    //   11806: aload_2
    //   11807: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11810: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11813: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   11816: aload 29
    //   11818: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11821: aload_0
    //   11822: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11825: lsub
    //   11826: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11829: aload 29
    //   11831: aload_2
    //   11832: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11835: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11838: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   11841: aload 29
    //   11843: aload 29
    //   11845: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11848: aload_2
    //   11849: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11852: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11855: lsub
    //   11856: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   11859: aload 29
    //   11861: lload 12
    //   11863: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   11866: aload 29
    //   11868: aload_0
    //   11869: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11872: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   11875: aload 29
    //   11877: aload_0
    //   11878: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   11881: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11884: aload 29
    //   11886: aload_0
    //   11887: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11890: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11893: aload 29
    //   11895: lconst_0
    //   11896: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11899: aload 29
    //   11901: aload_0
    //   11902: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11905: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11908: aload 29
    //   11910: aload_2
    //   11911: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11914: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11917: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11920: aload 29
    //   11922: aload_0
    //   11923: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11926: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   11929: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11932: aload 29
    //   11934: aload_0
    //   11935: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11938: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11941: aload_0
    //   11942: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11945: ifnull +874 -> 12819
    //   11948: aload_0
    //   11949: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11952: ldc_w 686
    //   11955: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11958: ifeq +861 -> 12819
    //   11961: iconst_1
    //   11962: istore 10
    //   11964: aload 29
    //   11966: iload 10
    //   11968: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   11971: aload 29
    //   11973: aload_2
    //   11974: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11977: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11980: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11983: aload 29
    //   11985: getstatic 770	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   11988: invokevirtual 773	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   11991: putfield 776	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   11994: aload 22
    //   11996: ifnull +24 -> 12020
    //   11999: aload 22
    //   12001: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12004: ifnull +16 -> 12020
    //   12007: aload 29
    //   12009: aload 22
    //   12011: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12014: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12017: putfield 778	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   12020: aload_2
    //   12021: aload 29
    //   12023: invokevirtual 782	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   12026: aload_2
    //   12027: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12030: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12033: ifeq +11 -> 12044
    //   12036: aload_0
    //   12037: aload_1
    //   12038: aload_2
    //   12039: aload 29
    //   12041: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   12044: aload_0
    //   12045: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12048: ifeq +777 -> 12825
    //   12051: aload_0
    //   12052: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   12055: ifnull +12 -> 12067
    //   12058: aload_0
    //   12059: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   12062: invokeinterface 791 1 0
    //   12067: aload_0
    //   12068: aconst_null
    //   12069: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   12072: return
    //   12073: aconst_null
    //   12074: astore 25
    //   12076: goto -1547 -> 10529
    //   12079: astore 24
    //   12081: ldc_w 428
    //   12084: astore 24
    //   12086: goto -1523 -> 10563
    //   12089: ldc_w 958
    //   12092: astore 26
    //   12094: goto -1356 -> 10738
    //   12097: aconst_null
    //   12098: astore 26
    //   12100: goto -1242 -> 10858
    //   12103: aload_0
    //   12104: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12107: astore 26
    //   12109: goto -1022 -> 11087
    //   12112: iconst_0
    //   12113: istore_3
    //   12114: goto -997 -> 11117
    //   12117: aconst_null
    //   12118: astore 26
    //   12120: goto -853 -> 11267
    //   12123: new 125	java/lang/StringBuilder
    //   12126: dup
    //   12127: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   12130: ldc_w 960
    //   12133: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12136: aload_0
    //   12137: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12140: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12143: ldc_w 527
    //   12146: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12149: aload_0
    //   12150: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12153: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12156: ldc_w 532
    //   12159: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12162: astore 30
    //   12164: aload_0
    //   12165: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12168: ifeq +558 -> 12726
    //   12171: aload 22
    //   12173: ifnull +553 -> 12726
    //   12176: aload 22
    //   12178: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12181: ifnull +545 -> 12726
    //   12184: aload 22
    //   12186: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12189: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12192: astore 26
    //   12194: aload 30
    //   12196: aload 26
    //   12198: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12201: ldc_w 543
    //   12204: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12207: aload 27
    //   12209: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12212: ldc_w 548
    //   12215: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12218: aload 25
    //   12220: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12223: ldc_w 550
    //   12226: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12229: aconst_null
    //   12230: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12233: ldc_w 552
    //   12236: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12239: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12242: invokevirtual 174	java/lang/Thread:getId	()J
    //   12245: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12248: ldc_w 554
    //   12251: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12254: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12257: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12260: ldc_w 556
    //   12263: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12266: aload_0
    //   12267: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12270: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12273: ldc_w 558
    //   12276: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12279: aload_0
    //   12280: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12283: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12286: ldc_w 560
    //   12289: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12292: astore 30
    //   12294: aload_0
    //   12295: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12298: ifeq +436 -> 12734
    //   12301: aload_0
    //   12302: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12305: aload_0
    //   12306: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12309: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   12312: astore 26
    //   12314: aload 30
    //   12316: aload 26
    //   12318: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12321: ldc_w 564
    //   12324: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12327: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12330: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12333: ldc_w 576
    //   12336: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12339: aload_2
    //   12340: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12343: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12346: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12349: ldc_w 581
    //   12352: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12355: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12358: aload_0
    //   12359: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12362: lsub
    //   12363: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12366: ldc_w 583
    //   12369: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12372: aload_2
    //   12373: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12376: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12379: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12382: ldc_w 588
    //   12385: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12388: aload_2
    //   12389: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12392: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12395: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12398: ldc_w 592
    //   12401: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12404: aload_2
    //   12405: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12408: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12411: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12414: ldc_w 597
    //   12417: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12420: aload_0
    //   12421: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   12424: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12427: ldc_w 599
    //   12430: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12433: aload_0
    //   12434: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   12437: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12440: ldc_w 962
    //   12443: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12446: iload 4
    //   12448: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12451: ldc_w 611
    //   12454: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12457: aload 28
    //   12459: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12462: ldc_w 571
    //   12465: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12468: aload_2
    //   12469: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12472: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12475: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12478: ldc_w 613
    //   12481: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12484: aload 24
    //   12486: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12489: ldc_w 615
    //   12492: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12495: astore 30
    //   12497: aload_0
    //   12498: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12501: ifnull +239 -> 12740
    //   12504: aload_0
    //   12505: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12508: iconst_0
    //   12509: bipush 30
    //   12511: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   12514: astore 26
    //   12516: aload 30
    //   12518: aload 26
    //   12520: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12523: ldc_w 621
    //   12526: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12529: astore 26
    //   12531: aload_0
    //   12532: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12535: ifnull +214 -> 12749
    //   12538: aload_0
    //   12539: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12542: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12545: istore_3
    //   12546: aload 26
    //   12548: iload_3
    //   12549: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12552: ldc_w 623
    //   12555: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12558: aload_2
    //   12559: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12562: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12565: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12568: ldc_w 628
    //   12571: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12574: lload 12
    //   12576: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12579: ldc_w 630
    //   12582: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12585: aload_0
    //   12586: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12589: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12592: ldc_w 599
    //   12595: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12598: aload_0
    //   12599: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12602: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12605: ldc_w 632
    //   12608: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12611: aload_0
    //   12612: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12615: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12618: ldc_w 599
    //   12621: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12624: aload_0
    //   12625: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12628: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12631: ldc_w 634
    //   12634: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12637: aload_0
    //   12638: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   12641: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12644: ldc_w 636
    //   12647: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12650: aload_0
    //   12651: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   12654: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12657: ldc_w 641
    //   12660: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12663: aload_0
    //   12664: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   12667: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12670: ldc_w 646
    //   12673: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12676: astore 30
    //   12678: aload_0
    //   12679: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12682: ifnull +72 -> 12754
    //   12685: aload_0
    //   12686: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12689: invokeinterface 656 1 0
    //   12694: astore 26
    //   12696: aload 29
    //   12698: aload 30
    //   12700: aload 26
    //   12702: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12705: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12708: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12711: ldc_w 447
    //   12714: aload 29
    //   12716: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12719: aconst_null
    //   12720: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12723: goto -1401 -> 11322
    //   12726: ldc_w 958
    //   12729: astore 26
    //   12731: goto -537 -> 12194
    //   12734: aconst_null
    //   12735: astore 26
    //   12737: goto -423 -> 12314
    //   12740: aload_0
    //   12741: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12744: astore 26
    //   12746: goto -230 -> 12516
    //   12749: iconst_0
    //   12750: istore_3
    //   12751: goto -205 -> 12546
    //   12754: aconst_null
    //   12755: astore 26
    //   12757: goto -61 -> 12696
    //   12760: iconst_0
    //   12761: istore_3
    //   12762: goto -1360 -> 11402
    //   12765: ldc_w 428
    //   12768: astore 24
    //   12770: goto -1237 -> 11533
    //   12773: astore 24
    //   12775: ldc 219
    //   12777: ldc_w 967
    //   12780: aload 24
    //   12782: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12785: goto -1169 -> 11616
    //   12788: astore 24
    //   12790: ldc 219
    //   12792: ldc_w 969
    //   12795: aload 24
    //   12797: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12800: goto -1127 -> 11673
    //   12803: iconst_0
    //   12804: istore 10
    //   12806: goto -1083 -> 11723
    //   12809: aload 27
    //   12811: invokevirtual 972	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   12814: astore 23
    //   12816: goto -1025 -> 11791
    //   12819: iconst_0
    //   12820: istore 10
    //   12822: goto -858 -> 11964
    //   12825: aload_0
    //   12826: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12829: ifnull +15 -> 12844
    //   12832: aload_0
    //   12833: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12836: invokevirtual 977	org/apache/http/client/methods/HttpGet:abort	()V
    //   12839: aload_0
    //   12840: aconst_null
    //   12841: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12844: aload_0
    //   12845: invokevirtual 980	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   12848: return
    //   12849: sipush 416
    //   12852: iload 4
    //   12854: if_icmpne +1681 -> 14535
    //   12857: aload_0
    //   12858: ldc_w 982
    //   12861: invokevirtual 985	com/tencent/component/network/downloader/impl/FastDownloadTask:removeHttpParam	(Ljava/lang/String;)V
    //   12864: aload_2
    //   12865: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12868: bipush 7
    //   12870: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   12873: iload 4
    //   12875: istore 5
    //   12877: aload_0
    //   12878: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12881: ifnull +21 -> 12902
    //   12884: aload_0
    //   12885: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12888: aload_0
    //   12889: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12892: iconst_1
    //   12893: invokeinterface 988 3 0
    //   12898: iload 4
    //   12900: istore 5
    //   12902: aload_2
    //   12903: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12906: lload 18
    //   12908: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12911: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   12914: aload_2
    //   12915: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12918: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12921: aload_0
    //   12922: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12925: lsub
    //   12926: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   12929: aload_2
    //   12930: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12933: aload_0
    //   12934: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   12937: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   12940: aload_0
    //   12941: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12944: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   12947: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   12950: astore 27
    //   12952: aload_0
    //   12953: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12956: ifnull +1609 -> 14565
    //   12959: aload_0
    //   12960: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12963: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12966: ifnull +1599 -> 14565
    //   12969: aload_0
    //   12970: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12973: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12976: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   12979: astore 25
    //   12981: aload_0
    //   12982: aload_0
    //   12983: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12986: aload 23
    //   12988: aload 22
    //   12990: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   12993: astore 28
    //   12995: aload 24
    //   12997: ifnull +4091 -> 17088
    //   13000: aload 24
    //   13002: ldc_w 492
    //   13005: invokeinterface 498 2 0
    //   13010: checkcast 282	java/lang/String
    //   13013: astore 24
    //   13015: aload_2
    //   13016: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13019: aload 24
    //   13021: putfield 507	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   13024: aload_0
    //   13025: lconst_0
    //   13026: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13029: aload_0
    //   13030: iconst_0
    //   13031: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   13034: aload_0
    //   13035: lconst_0
    //   13036: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   13039: aload_0
    //   13040: iconst_0
    //   13041: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   13044: aload_2
    //   13045: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13048: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13051: ifeq +12 -> 13063
    //   13054: aload_1
    //   13055: invokeinterface 359 1 0
    //   13060: ifeq +31 -> 13091
    //   13063: aload_0
    //   13064: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   13067: ifnull +24 -> 13091
    //   13070: aload_0
    //   13071: getfield 514	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   13074: aload_0
    //   13075: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13078: aload_2
    //   13079: invokevirtual 517	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   13082: aload 23
    //   13084: aload 22
    //   13086: invokeinterface 523 5 0
    //   13091: aload_1
    //   13092: invokeinterface 359 1 0
    //   13097: ifne +1403 -> 14500
    //   13100: aload_0
    //   13101: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13104: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   13107: istore 10
    //   13109: aload_2
    //   13110: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13113: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13116: ifne +1500 -> 14616
    //   13119: new 125	java/lang/StringBuilder
    //   13122: dup
    //   13123: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13126: ldc_w 525
    //   13129: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13132: aload_0
    //   13133: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13136: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13139: ldc_w 527
    //   13142: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13145: aload_0
    //   13146: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   13149: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13152: ldc_w 532
    //   13155: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13158: astore 30
    //   13160: aload_0
    //   13161: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   13164: ifeq +1417 -> 14581
    //   13167: aload 22
    //   13169: ifnull +1412 -> 14581
    //   13172: aload 22
    //   13174: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   13177: ifnull +1404 -> 14581
    //   13180: aload 22
    //   13182: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   13185: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   13188: astore 26
    //   13190: aload 30
    //   13192: aload 26
    //   13194: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13197: ldc_w 543
    //   13200: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13203: aload 27
    //   13205: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13208: ldc_w 548
    //   13211: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13214: aload 25
    //   13216: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13219: ldc_w 550
    //   13222: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13225: aconst_null
    //   13226: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13229: ldc_w 552
    //   13232: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13235: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13238: invokevirtual 174	java/lang/Thread:getId	()J
    //   13241: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13244: ldc_w 554
    //   13247: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13250: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   13253: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13256: ldc_w 556
    //   13259: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13262: aload_0
    //   13263: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13266: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13269: ldc_w 558
    //   13272: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13275: aload_0
    //   13276: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13279: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13282: ldc_w 560
    //   13285: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13288: astore 30
    //   13290: aload_0
    //   13291: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13294: ifeq +1295 -> 14589
    //   13297: aload_0
    //   13298: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13301: aload_0
    //   13302: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13305: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   13308: astore 26
    //   13310: aload 30
    //   13312: aload 26
    //   13314: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13317: ldc_w 562
    //   13320: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13323: iload 10
    //   13325: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13328: ldc_w 564
    //   13331: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13334: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   13337: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13340: ldc_w 571
    //   13343: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13346: aload_2
    //   13347: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13350: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13353: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13356: ldc_w 576
    //   13359: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13362: aload_2
    //   13363: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13366: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13369: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13372: ldc_w 581
    //   13375: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13378: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13381: aload_0
    //   13382: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13385: lsub
    //   13386: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13389: ldc_w 583
    //   13392: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13395: aload_2
    //   13396: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13399: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13402: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13405: ldc_w 588
    //   13408: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13411: aload_2
    //   13412: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13415: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13418: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13421: ldc_w 592
    //   13424: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13427: aload_2
    //   13428: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13431: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   13434: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13437: ldc_w 597
    //   13440: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13443: aload_0
    //   13444: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   13447: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13450: ldc_w 599
    //   13453: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13456: aload_0
    //   13457: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   13460: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13463: ldc_w 604
    //   13466: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13469: aload_2
    //   13470: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13473: invokevirtual 607	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   13476: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13479: ldc_w 609
    //   13482: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13485: iload 5
    //   13487: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13490: ldc_w 611
    //   13493: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13496: aload 28
    //   13498: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13501: ldc_w 613
    //   13504: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13507: aload 24
    //   13509: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13512: ldc_w 615
    //   13515: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13518: astore 30
    //   13520: aload_0
    //   13521: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13524: ifnull +1071 -> 14595
    //   13527: aload_0
    //   13528: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13531: iconst_0
    //   13532: bipush 30
    //   13534: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   13537: astore 26
    //   13539: aload 30
    //   13541: aload 26
    //   13543: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13546: ldc_w 621
    //   13549: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13552: astore 26
    //   13554: aload_0
    //   13555: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13558: ifnull +1046 -> 14604
    //   13561: aload_0
    //   13562: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13565: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13568: istore 4
    //   13570: aload 26
    //   13572: iload 4
    //   13574: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13577: ldc_w 623
    //   13580: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13583: aload_2
    //   13584: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13587: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13590: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13593: ldc_w 628
    //   13596: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13599: lload 12
    //   13601: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13604: ldc_w 630
    //   13607: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13610: aload_0
    //   13611: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13614: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13617: ldc_w 599
    //   13620: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13623: aload_0
    //   13624: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   13627: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13630: ldc_w 632
    //   13633: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13636: aload_0
    //   13637: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   13640: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13643: ldc_w 599
    //   13646: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13649: aload_0
    //   13650: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   13653: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13656: ldc_w 634
    //   13659: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13662: aload_0
    //   13663: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   13666: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13669: ldc_w 636
    //   13672: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13675: aload_0
    //   13676: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   13679: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13682: ldc_w 641
    //   13685: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13688: aload_0
    //   13689: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   13692: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13695: ldc_w 646
    //   13698: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13701: astore 30
    //   13703: aload_0
    //   13704: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13707: ifnull +903 -> 14610
    //   13710: aload_0
    //   13711: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13714: invokeinterface 656 1 0
    //   13719: astore 26
    //   13721: aload 29
    //   13723: aload 30
    //   13725: aload 26
    //   13727: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13730: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13733: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13736: ldc_w 447
    //   13739: aload 29
    //   13741: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13744: aconst_null
    //   13745: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   13748: aload_0
    //   13749: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13752: ifnull +24 -> 13776
    //   13755: aload_0
    //   13756: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13759: ldc_w 439
    //   13762: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13765: ifeq +11 -> 13776
    //   13768: aload_0
    //   13769: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13772: iconst_0
    //   13773: invokestatic 665	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   13776: iload 10
    //   13778: ifne +8 -> 13786
    //   13781: aload_0
    //   13782: iconst_0
    //   13783: putfield 668	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   13786: aload_2
    //   13787: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13790: astore 26
    //   13792: new 125	java/lang/StringBuilder
    //   13795: dup
    //   13796: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13799: aload_0
    //   13800: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13803: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13806: ldc_w 670
    //   13809: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13812: aload 25
    //   13814: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13817: ldc_w 672
    //   13820: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13823: aload_2
    //   13824: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13827: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13830: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13833: ldc_w 674
    //   13836: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13839: astore 25
    //   13841: aload_0
    //   13842: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13845: ifnull +1411 -> 15256
    //   13848: aload_0
    //   13849: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13852: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13855: istore 4
    //   13857: aload 25
    //   13859: iload 4
    //   13861: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13864: ldc_w 609
    //   13867: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13870: iload 5
    //   13872: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13875: ldc_w 571
    //   13878: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13881: aload_2
    //   13882: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13885: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13888: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13891: ldc_w 583
    //   13894: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13897: aload_2
    //   13898: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13901: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13904: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13907: ldc_w 588
    //   13910: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13913: aload_2
    //   13914: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13917: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13920: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13923: ldc_w 576
    //   13926: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13929: aload_2
    //   13930: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13933: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13936: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13939: ldc_w 581
    //   13942: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13945: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13948: aload_0
    //   13949: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13952: lsub
    //   13953: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13956: astore 25
    //   13958: aload 24
    //   13960: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13963: ifne +1299 -> 15262
    //   13966: new 125	java/lang/StringBuilder
    //   13969: dup
    //   13970: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13973: ldc_w 613
    //   13976: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13979: aload 24
    //   13981: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13984: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13987: astore 24
    //   13989: aload 26
    //   13991: aload 25
    //   13993: aload 24
    //   13995: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13998: ldc_w 611
    //   14001: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14004: aload 28
    //   14006: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14009: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14012: putfield 677	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   14015: aload_0
    //   14016: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14019: ifnull +53 -> 14072
    //   14022: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14025: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14028: aload_0
    //   14029: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14032: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14035: if_icmpne +37 -> 14072
    //   14038: aload_0
    //   14039: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14042: ifnull +30 -> 14072
    //   14045: aload_0
    //   14046: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14049: aload_0
    //   14050: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14053: aload_0
    //   14054: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14057: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   14060: aload_2
    //   14061: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14064: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14067: invokeinterface 684 4 0
    //   14072: aload_0
    //   14073: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14076: ifnull +53 -> 14129
    //   14079: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14082: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14085: aload_0
    //   14086: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14089: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14092: if_icmpne +37 -> 14129
    //   14095: aload_0
    //   14096: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14099: ifnull +30 -> 14129
    //   14102: aload_0
    //   14103: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14106: aload_0
    //   14107: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14110: aload_0
    //   14111: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14114: invokestatic 680	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   14117: aload_2
    //   14118: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14121: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14124: invokeinterface 684 4 0
    //   14129: iload 10
    //   14131: ifeq +64 -> 14195
    //   14134: aload_0
    //   14135: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   14138: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   14141: astore 24
    //   14143: aload_0
    //   14144: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14147: astore 25
    //   14149: aload_0
    //   14150: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14153: ifeq +1147 -> 15300
    //   14156: aload_0
    //   14157: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14160: ifnull +1140 -> 15300
    //   14163: aload_0
    //   14164: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14167: ldc_w 686
    //   14170: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14173: ifeq +1127 -> 15300
    //   14176: iconst_1
    //   14177: istore 10
    //   14179: aload 24
    //   14181: aload 25
    //   14183: iload 10
    //   14185: aload_2
    //   14186: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14189: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14192: invokevirtual 690	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   14195: aload 29
    //   14197: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   14200: putfield 693	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   14203: aload 29
    //   14205: aload_0
    //   14206: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   14209: putfield 699	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   14212: aload 29
    //   14214: aload 23
    //   14216: putfield 703	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   14219: aload 29
    //   14221: aload 22
    //   14223: putfield 707	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   14226: aload 29
    //   14228: iload 5
    //   14230: putfield 710	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   14233: aload 29
    //   14235: aconst_null
    //   14236: putfield 714	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   14239: aload 27
    //   14241: ifnonnull +1065 -> 15306
    //   14244: aconst_null
    //   14245: astore 23
    //   14247: aload 29
    //   14249: aload 23
    //   14251: putfield 717	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   14254: aload 29
    //   14256: aconst_null
    //   14257: putfield 720	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   14260: aload 29
    //   14262: aload_2
    //   14263: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14266: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14269: putfield 721	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   14272: aload 29
    //   14274: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14277: aload_0
    //   14278: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14281: lsub
    //   14282: putfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14285: aload 29
    //   14287: aload_2
    //   14288: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14291: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14294: putfield 727	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   14297: aload 29
    //   14299: aload 29
    //   14301: getfield 724	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14304: aload_2
    //   14305: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14308: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14311: lsub
    //   14312: putfield 730	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   14315: aload 29
    //   14317: lload 12
    //   14319: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   14322: aload 29
    //   14324: aload_0
    //   14325: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   14328: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   14331: aload 29
    //   14333: aload_0
    //   14334: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   14337: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   14340: aload 29
    //   14342: aload_0
    //   14343: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   14346: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   14349: aload 29
    //   14351: lconst_0
    //   14352: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   14355: aload 29
    //   14357: aload_0
    //   14358: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   14361: putfield 748	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   14364: aload 29
    //   14366: aload_2
    //   14367: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14370: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14373: putfield 751	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   14376: aload 29
    //   14378: aload_0
    //   14379: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14382: invokestatic 754	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   14385: putfield 756	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   14388: aload 29
    //   14390: aload_0
    //   14391: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14394: putfield 759	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   14397: aload_0
    //   14398: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14401: ifnull +915 -> 15316
    //   14404: aload_0
    //   14405: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14408: ldc_w 686
    //   14411: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14414: ifeq +902 -> 15316
    //   14417: iconst_1
    //   14418: istore 10
    //   14420: aload 29
    //   14422: iload 10
    //   14424: putfield 762	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   14427: aload 29
    //   14429: aload_2
    //   14430: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14433: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14436: putfield 764	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   14439: aload 29
    //   14441: getstatic 770	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   14444: invokevirtual 773	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   14447: putfield 776	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   14450: aload 22
    //   14452: ifnull +24 -> 14476
    //   14455: aload 22
    //   14457: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14460: ifnull +16 -> 14476
    //   14463: aload 29
    //   14465: aload 22
    //   14467: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14470: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   14473: putfield 778	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   14476: aload_2
    //   14477: aload 29
    //   14479: invokevirtual 782	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14482: aload_2
    //   14483: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14486: invokevirtual 510	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14489: ifeq +11 -> 14500
    //   14492: aload_0
    //   14493: aload_1
    //   14494: aload_2
    //   14495: aload 29
    //   14497: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14500: aload_0
    //   14501: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14504: ifeq +818 -> 15322
    //   14507: aload_0
    //   14508: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   14511: ifnull +12 -> 14523
    //   14514: aload_0
    //   14515: getfield 786	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   14518: invokeinterface 791 1 0
    //   14523: aload_0
    //   14524: aconst_null
    //   14525: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   14528: iload_3
    //   14529: iconst_1
    //   14530: iadd
    //   14531: istore_3
    //   14532: goto -14327 -> 205
    //   14535: aload_2
    //   14536: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14539: iconst_3
    //   14540: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14543: goto -1670 -> 12873
    //   14546: astore 25
    //   14548: goto -14296 -> 252
    //   14551: aload_2
    //   14552: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14555: iconst_3
    //   14556: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14559: iconst_0
    //   14560: istore 5
    //   14562: goto -1660 -> 12902
    //   14565: aconst_null
    //   14566: astore 25
    //   14568: goto -1587 -> 12981
    //   14571: astore 24
    //   14573: ldc_w 428
    //   14576: astore 24
    //   14578: goto -1563 -> 13015
    //   14581: ldc_w 958
    //   14584: astore 26
    //   14586: goto -1396 -> 13190
    //   14589: aconst_null
    //   14590: astore 26
    //   14592: goto -1282 -> 13310
    //   14595: aload_0
    //   14596: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14599: astore 26
    //   14601: goto -1062 -> 13539
    //   14604: iconst_0
    //   14605: istore 4
    //   14607: goto -1037 -> 13570
    //   14610: aconst_null
    //   14611: astore 26
    //   14613: goto -892 -> 13721
    //   14616: new 125	java/lang/StringBuilder
    //   14619: dup
    //   14620: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   14623: ldc_w 960
    //   14626: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14629: aload_0
    //   14630: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   14633: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14636: ldc_w 527
    //   14639: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14642: aload_0
    //   14643: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14646: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14649: ldc_w 532
    //   14652: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14655: astore 30
    //   14657: aload_0
    //   14658: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14661: ifeq +560 -> 15221
    //   14664: aload 22
    //   14666: ifnull +555 -> 15221
    //   14669: aload 22
    //   14671: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14674: ifnull +547 -> 15221
    //   14677: aload 22
    //   14679: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14682: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   14685: astore 26
    //   14687: aload 30
    //   14689: aload 26
    //   14691: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14694: ldc_w 543
    //   14697: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14700: aload 27
    //   14702: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14705: ldc_w 548
    //   14708: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14711: aload 25
    //   14713: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14716: ldc_w 550
    //   14719: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14722: aconst_null
    //   14723: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14726: ldc_w 552
    //   14729: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14732: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14735: invokevirtual 174	java/lang/Thread:getId	()J
    //   14738: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14741: ldc_w 554
    //   14744: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14747: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   14750: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14753: ldc_w 556
    //   14756: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14759: aload_0
    //   14760: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14763: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14766: ldc_w 558
    //   14769: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14772: aload_0
    //   14773: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14776: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14779: ldc_w 560
    //   14782: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14785: astore 30
    //   14787: aload_0
    //   14788: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14791: ifeq +438 -> 15229
    //   14794: aload_0
    //   14795: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   14798: aload_0
    //   14799: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14802: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   14805: astore 26
    //   14807: aload 30
    //   14809: aload 26
    //   14811: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14814: ldc_w 564
    //   14817: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14820: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   14823: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14826: ldc_w 576
    //   14829: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14832: aload_2
    //   14833: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14836: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14839: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14842: ldc_w 581
    //   14845: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14848: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14851: aload_0
    //   14852: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14855: lsub
    //   14856: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14859: ldc_w 583
    //   14862: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14865: aload_2
    //   14866: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14869: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   14872: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14875: ldc_w 588
    //   14878: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14881: aload_2
    //   14882: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14885: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   14888: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14891: ldc_w 592
    //   14894: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14897: aload_2
    //   14898: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14901: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   14904: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14907: ldc_w 597
    //   14910: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14913: aload_0
    //   14914: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   14917: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14920: ldc_w 599
    //   14923: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14926: aload_0
    //   14927: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   14930: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14933: ldc_w 962
    //   14936: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14939: iload 5
    //   14941: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14944: ldc_w 611
    //   14947: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14950: aload 28
    //   14952: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14955: ldc_w 571
    //   14958: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14961: aload_2
    //   14962: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14965: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14968: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14971: ldc_w 613
    //   14974: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14977: aload 24
    //   14979: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14982: ldc_w 615
    //   14985: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14988: astore 30
    //   14990: aload_0
    //   14991: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14994: ifnull +241 -> 15235
    //   14997: aload_0
    //   14998: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15001: iconst_0
    //   15002: bipush 30
    //   15004: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   15007: astore 26
    //   15009: aload 30
    //   15011: aload 26
    //   15013: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15016: ldc_w 621
    //   15019: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15022: astore 26
    //   15024: aload_0
    //   15025: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15028: ifnull +216 -> 15244
    //   15031: aload_0
    //   15032: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15035: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   15038: istore 4
    //   15040: aload 26
    //   15042: iload 4
    //   15044: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15047: ldc_w 623
    //   15050: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15053: aload_2
    //   15054: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15057: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   15060: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15063: ldc_w 628
    //   15066: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15069: lload 12
    //   15071: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15074: ldc_w 630
    //   15077: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15080: aload_0
    //   15081: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   15084: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15087: ldc_w 599
    //   15090: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15093: aload_0
    //   15094: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   15097: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15100: ldc_w 632
    //   15103: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15106: aload_0
    //   15107: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   15110: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15113: ldc_w 599
    //   15116: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15119: aload_0
    //   15120: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   15123: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15126: ldc_w 634
    //   15129: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15132: aload_0
    //   15133: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   15136: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15139: ldc_w 636
    //   15142: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15145: aload_0
    //   15146: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   15149: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15152: ldc_w 641
    //   15155: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15158: aload_0
    //   15159: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   15162: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15165: ldc_w 646
    //   15168: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15171: astore 30
    //   15173: aload_0
    //   15174: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15177: ifnull +73 -> 15250
    //   15180: aload_0
    //   15181: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15184: invokeinterface 656 1 0
    //   15189: astore 26
    //   15191: aload 29
    //   15193: aload 30
    //   15195: aload 26
    //   15197: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15200: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15203: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15206: ldc_w 447
    //   15209: aload 29
    //   15211: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15214: aconst_null
    //   15215: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15218: goto -1442 -> 13776
    //   15221: ldc_w 958
    //   15224: astore 26
    //   15226: goto -539 -> 14687
    //   15229: aconst_null
    //   15230: astore 26
    //   15232: goto -425 -> 14807
    //   15235: aload_0
    //   15236: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15239: astore 26
    //   15241: goto -232 -> 15009
    //   15244: iconst_0
    //   15245: istore 4
    //   15247: goto -207 -> 15040
    //   15250: aconst_null
    //   15251: astore 26
    //   15253: goto -62 -> 15191
    //   15256: iconst_0
    //   15257: istore 4
    //   15259: goto -1402 -> 13857
    //   15262: ldc_w 428
    //   15265: astore 24
    //   15267: goto -1278 -> 13989
    //   15270: astore 24
    //   15272: ldc 219
    //   15274: ldc_w 967
    //   15277: aload 24
    //   15279: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15282: goto -1210 -> 14072
    //   15285: astore 24
    //   15287: ldc 219
    //   15289: ldc_w 969
    //   15292: aload 24
    //   15294: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15297: goto -1168 -> 14129
    //   15300: iconst_0
    //   15301: istore 10
    //   15303: goto -1124 -> 14179
    //   15306: aload 27
    //   15308: invokevirtual 972	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   15311: astore 23
    //   15313: goto -1066 -> 14247
    //   15316: iconst_0
    //   15317: istore 10
    //   15319: goto -899 -> 14420
    //   15322: aload_0
    //   15323: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15326: ifnull +15 -> 15341
    //   15329: aload_0
    //   15330: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15333: invokevirtual 977	org/apache/http/client/methods/HttpGet:abort	()V
    //   15336: aload_0
    //   15337: aconst_null
    //   15338: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15341: aload_0
    //   15342: invokevirtual 980	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   15345: goto -817 -> 14528
    //   15348: aconst_null
    //   15349: astore 26
    //   15351: goto -14940 -> 411
    //   15354: astore 24
    //   15356: ldc_w 428
    //   15359: astore 24
    //   15361: goto -14916 -> 445
    //   15364: ldc_w 958
    //   15367: astore 27
    //   15369: goto -14749 -> 620
    //   15372: aconst_null
    //   15373: astore 27
    //   15375: goto -14635 -> 740
    //   15378: aload_0
    //   15379: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15382: astore 27
    //   15384: goto -14415 -> 969
    //   15387: iconst_0
    //   15388: istore_3
    //   15389: goto -14390 -> 999
    //   15392: aconst_null
    //   15393: astore 27
    //   15395: goto -14246 -> 1149
    //   15398: new 125	java/lang/StringBuilder
    //   15401: dup
    //   15402: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   15405: ldc_w 960
    //   15408: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15411: aload_0
    //   15412: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   15415: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15418: ldc_w 527
    //   15421: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15424: aload_0
    //   15425: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15428: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15431: ldc_w 532
    //   15434: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15437: astore 31
    //   15439: aload_0
    //   15440: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15443: ifeq +558 -> 16001
    //   15446: aload 22
    //   15448: ifnull +553 -> 16001
    //   15451: aload 22
    //   15453: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   15456: ifnull +545 -> 16001
    //   15459: aload 22
    //   15461: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   15464: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   15467: astore 27
    //   15469: aload 31
    //   15471: aload 27
    //   15473: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15476: ldc_w 543
    //   15479: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15482: aload 28
    //   15484: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15487: ldc_w 548
    //   15490: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15493: aload 26
    //   15495: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15498: ldc_w 550
    //   15501: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15504: aconst_null
    //   15505: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15508: ldc_w 552
    //   15511: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15514: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15517: invokevirtual 174	java/lang/Thread:getId	()J
    //   15520: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15523: ldc_w 554
    //   15526: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15529: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   15532: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15535: ldc_w 556
    //   15538: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15541: aload_0
    //   15542: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15545: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15548: ldc_w 558
    //   15551: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15554: aload_0
    //   15555: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15558: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15561: ldc_w 560
    //   15564: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15567: astore 31
    //   15569: aload_0
    //   15570: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15573: ifeq +436 -> 16009
    //   15576: aload_0
    //   15577: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15580: aload_0
    //   15581: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15584: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   15587: astore 27
    //   15589: aload 31
    //   15591: aload 27
    //   15593: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15596: ldc_w 564
    //   15599: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15602: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   15605: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15608: ldc_w 576
    //   15611: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15614: aload_2
    //   15615: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15618: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   15621: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15624: ldc_w 581
    //   15627: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15630: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   15633: aload_0
    //   15634: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   15637: lsub
    //   15638: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15641: ldc_w 583
    //   15644: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15647: aload_2
    //   15648: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15651: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   15654: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15657: ldc_w 588
    //   15660: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15663: aload_2
    //   15664: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15667: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   15670: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15673: ldc_w 592
    //   15676: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15679: aload_2
    //   15680: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15683: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   15686: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15689: ldc_w 597
    //   15692: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15695: aload_0
    //   15696: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   15699: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15702: ldc_w 599
    //   15705: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15708: aload_0
    //   15709: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   15712: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15715: ldc_w 962
    //   15718: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15721: iload 4
    //   15723: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15726: ldc_w 611
    //   15729: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15732: aload 30
    //   15734: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15737: ldc_w 571
    //   15740: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15743: aload_2
    //   15744: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15747: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   15750: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15753: ldc_w 613
    //   15756: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15759: aload 24
    //   15761: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15764: ldc_w 615
    //   15767: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15770: astore 31
    //   15772: aload_0
    //   15773: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15776: ifnull +239 -> 16015
    //   15779: aload_0
    //   15780: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15783: iconst_0
    //   15784: bipush 30
    //   15786: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   15789: astore 27
    //   15791: aload 31
    //   15793: aload 27
    //   15795: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15798: ldc_w 621
    //   15801: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15804: astore 27
    //   15806: aload_0
    //   15807: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15810: ifnull +214 -> 16024
    //   15813: aload_0
    //   15814: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15817: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   15820: istore_3
    //   15821: aload 27
    //   15823: iload_3
    //   15824: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15827: ldc_w 623
    //   15830: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15833: aload_2
    //   15834: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15837: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   15840: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15843: ldc_w 628
    //   15846: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15849: lload 12
    //   15851: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15854: ldc_w 630
    //   15857: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15860: aload_0
    //   15861: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   15864: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15867: ldc_w 599
    //   15870: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15873: aload_0
    //   15874: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   15877: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15880: ldc_w 632
    //   15883: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15886: aload_0
    //   15887: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   15890: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15893: ldc_w 599
    //   15896: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15899: aload_0
    //   15900: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   15903: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15906: ldc_w 634
    //   15909: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15912: aload_0
    //   15913: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   15916: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15919: ldc_w 636
    //   15922: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15925: aload_0
    //   15926: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   15929: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15932: ldc_w 641
    //   15935: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15938: aload_0
    //   15939: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   15942: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15945: ldc_w 646
    //   15948: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15951: astore 31
    //   15953: aload_0
    //   15954: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15957: ifnull +72 -> 16029
    //   15960: aload_0
    //   15961: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15964: invokeinterface 656 1 0
    //   15969: astore 27
    //   15971: aload 29
    //   15973: aload 31
    //   15975: aload 27
    //   15977: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15980: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15983: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15986: ldc_w 447
    //   15989: aload 29
    //   15991: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15994: aconst_null
    //   15995: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15998: goto -14793 -> 1205
    //   16001: ldc_w 958
    //   16004: astore 27
    //   16006: goto -537 -> 15469
    //   16009: aconst_null
    //   16010: astore 27
    //   16012: goto -423 -> 15589
    //   16015: aload_0
    //   16016: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16019: astore 27
    //   16021: goto -230 -> 15791
    //   16024: iconst_0
    //   16025: istore_3
    //   16026: goto -205 -> 15821
    //   16029: aconst_null
    //   16030: astore 27
    //   16032: goto -61 -> 15971
    //   16035: iconst_0
    //   16036: istore_3
    //   16037: goto -14752 -> 1285
    //   16040: ldc_w 428
    //   16043: astore 24
    //   16045: goto -14629 -> 1416
    //   16048: astore 24
    //   16050: ldc 219
    //   16052: ldc_w 967
    //   16055: aload 24
    //   16057: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16060: goto -14561 -> 1499
    //   16063: astore 24
    //   16065: ldc 219
    //   16067: ldc_w 969
    //   16070: aload 24
    //   16072: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16075: goto -14519 -> 1556
    //   16078: iconst_0
    //   16079: istore 10
    //   16081: goto -14475 -> 1606
    //   16084: aload 28
    //   16086: invokevirtual 972	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   16089: astore 23
    //   16091: goto -14416 -> 1675
    //   16094: iconst_0
    //   16095: istore 10
    //   16097: goto -14249 -> 1848
    //   16100: aload_0
    //   16101: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16104: ifnull +15 -> 16119
    //   16107: aload_0
    //   16108: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16111: invokevirtual 977	org/apache/http/client/methods/HttpGet:abort	()V
    //   16114: aload_0
    //   16115: aconst_null
    //   16116: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16119: aload_0
    //   16120: invokevirtual 980	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   16123: goto -14167 -> 1956
    //   16126: aconst_null
    //   16127: astore 27
    //   16129: goto -11117 -> 5012
    //   16132: astore 24
    //   16134: ldc_w 428
    //   16137: astore 24
    //   16139: goto -11093 -> 5046
    //   16142: ldc_w 958
    //   16145: astore 28
    //   16147: goto -10926 -> 5221
    //   16150: aconst_null
    //   16151: astore 28
    //   16153: goto -10812 -> 5341
    //   16156: aload_0
    //   16157: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16160: astore 28
    //   16162: goto -10592 -> 5570
    //   16165: iconst_0
    //   16166: istore_3
    //   16167: goto -10567 -> 5600
    //   16170: aconst_null
    //   16171: astore 28
    //   16173: goto -10423 -> 5750
    //   16176: new 125	java/lang/StringBuilder
    //   16179: dup
    //   16180: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   16183: ldc_w 960
    //   16186: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16189: aload_0
    //   16190: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   16193: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16196: ldc_w 527
    //   16199: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16202: aload_0
    //   16203: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   16206: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16209: ldc_w 532
    //   16212: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16215: astore 32
    //   16217: aload_0
    //   16218: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   16221: ifeq +558 -> 16779
    //   16224: aload 25
    //   16226: ifnull +553 -> 16779
    //   16229: aload 25
    //   16231: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   16234: ifnull +545 -> 16779
    //   16237: aload 25
    //   16239: invokevirtual 538	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   16242: invokevirtual 541	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   16245: astore 28
    //   16247: aload 32
    //   16249: aload 28
    //   16251: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16254: ldc_w 543
    //   16257: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16260: aload 30
    //   16262: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16265: ldc_w 548
    //   16268: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16271: aload 27
    //   16273: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16276: ldc_w 550
    //   16279: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16282: aconst_null
    //   16283: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16286: ldc_w 552
    //   16289: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16292: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16295: invokevirtual 174	java/lang/Thread:getId	()J
    //   16298: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16301: ldc_w 554
    //   16304: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16307: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   16310: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16313: ldc_w 556
    //   16316: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16319: aload_0
    //   16320: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16323: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16326: ldc_w 558
    //   16329: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16332: aload_0
    //   16333: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16336: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16339: ldc_w 560
    //   16342: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16345: astore 32
    //   16347: aload_0
    //   16348: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16351: ifeq +436 -> 16787
    //   16354: aload_0
    //   16355: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   16358: aload_0
    //   16359: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16362: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   16365: astore 28
    //   16367: aload 32
    //   16369: aload 28
    //   16371: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16374: ldc_w 564
    //   16377: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16380: invokestatic 569	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   16383: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16386: ldc_w 576
    //   16389: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16392: aload_2
    //   16393: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   16396: getfield 579	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   16399: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16402: ldc_w 581
    //   16405: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16408: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   16411: aload_0
    //   16412: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   16415: lsub
    //   16416: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16419: ldc_w 583
    //   16422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16425: aload_2
    //   16426: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16429: getfield 586	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   16432: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16435: ldc_w 588
    //   16438: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16441: aload_2
    //   16442: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16445: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   16448: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16451: ldc_w 592
    //   16454: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16457: aload_2
    //   16458: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16461: getfield 595	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   16464: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16467: ldc_w 597
    //   16470: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16473: aload_0
    //   16474: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   16477: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16480: ldc_w 599
    //   16483: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16486: aload_0
    //   16487: invokevirtual 602	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   16490: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16493: ldc_w 962
    //   16496: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16499: iload 4
    //   16501: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16504: ldc_w 611
    //   16507: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16510: aload 31
    //   16512: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16515: ldc_w 571
    //   16518: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16521: aload_2
    //   16522: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16525: getfield 574	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   16528: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16531: ldc_w 613
    //   16534: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16537: aload 24
    //   16539: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16542: ldc_w 615
    //   16545: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16548: astore 32
    //   16550: aload_0
    //   16551: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16554: ifnull +239 -> 16793
    //   16557: aload_0
    //   16558: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16561: iconst_0
    //   16562: bipush 30
    //   16564: invokevirtual 619	java/lang/String:substring	(II)Ljava/lang/String;
    //   16567: astore 28
    //   16569: aload 32
    //   16571: aload 28
    //   16573: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16576: ldc_w 621
    //   16579: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16582: astore 28
    //   16584: aload_0
    //   16585: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16588: ifnull +214 -> 16802
    //   16591: aload_0
    //   16592: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16595: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   16598: istore_3
    //   16599: aload 28
    //   16601: iload_3
    //   16602: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16605: ldc_w 623
    //   16608: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16611: aload_2
    //   16612: invokevirtual 502	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16615: getfield 626	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   16618: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16621: ldc_w 628
    //   16624: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16627: lload 12
    //   16629: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16632: ldc_w 630
    //   16635: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16638: aload_0
    //   16639: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   16642: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16645: ldc_w 599
    //   16648: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16651: aload_0
    //   16652: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   16655: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16658: ldc_w 632
    //   16661: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16664: aload_0
    //   16665: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   16668: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16671: ldc_w 599
    //   16674: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16677: aload_0
    //   16678: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   16681: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16684: ldc_w 634
    //   16687: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16690: aload_0
    //   16691: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   16694: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16697: ldc_w 636
    //   16700: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16703: aload_0
    //   16704: getfield 639	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   16707: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16710: ldc_w 641
    //   16713: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16716: aload_0
    //   16717: invokevirtual 644	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   16720: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16723: ldc_w 646
    //   16726: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16729: astore 32
    //   16731: aload_0
    //   16732: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16735: ifnull +72 -> 16807
    //   16738: aload_0
    //   16739: getfield 650	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16742: invokeinterface 656 1 0
    //   16747: astore 28
    //   16749: aload 29
    //   16751: aload 32
    //   16753: aload 28
    //   16755: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16758: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16761: putfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16764: ldc_w 447
    //   16767: aload 29
    //   16769: getfield 659	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16772: aconst_null
    //   16773: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16776: goto -10970 -> 5806
    //   16779: ldc_w 958
    //   16782: astore 28
    //   16784: goto -537 -> 16247
    //   16787: aconst_null
    //   16788: astore 28
    //   16790: goto -423 -> 16367
    //   16793: aload_0
    //   16794: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16797: astore 28
    //   16799: goto -230 -> 16569
    //   16802: iconst_0
    //   16803: istore_3
    //   16804: goto -205 -> 16599
    //   16807: aconst_null
    //   16808: astore 28
    //   16810: goto -61 -> 16749
    //   16813: iconst_0
    //   16814: istore_3
    //   16815: goto -10929 -> 5886
    //   16818: ldc_w 428
    //   16821: astore 24
    //   16823: goto -10806 -> 6017
    //   16826: astore 24
    //   16828: ldc 219
    //   16830: ldc_w 967
    //   16833: aload 24
    //   16835: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16838: goto -10738 -> 6100
    //   16841: astore 24
    //   16843: ldc 219
    //   16845: ldc_w 969
    //   16848: aload 24
    //   16850: invokestatic 965	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16853: goto -10696 -> 6157
    //   16856: iconst_0
    //   16857: istore 10
    //   16859: goto -10652 -> 6207
    //   16862: aload 30
    //   16864: invokevirtual 972	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   16867: astore 23
    //   16869: goto -10593 -> 6276
    //   16872: iconst_0
    //   16873: istore 10
    //   16875: goto -10426 -> 6449
    //   16878: aload_0
    //   16879: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16882: ifnull +15 -> 16897
    //   16885: aload_0
    //   16886: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16889: invokevirtual 977	org/apache/http/client/methods/HttpGet:abort	()V
    //   16892: aload_0
    //   16893: aconst_null
    //   16894: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16897: aload_0
    //   16898: invokevirtual 980	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   16901: goto -10344 -> 6557
    //   16904: astore 23
    //   16906: aconst_null
    //   16907: astore 27
    //   16909: aload 22
    //   16911: astore 24
    //   16913: aload 23
    //   16915: astore 22
    //   16917: aload 27
    //   16919: astore 23
    //   16921: iload 7
    //   16923: istore 4
    //   16925: goto -11992 -> 4933
    //   16928: astore 25
    //   16930: aconst_null
    //   16931: astore 28
    //   16933: aload 23
    //   16935: astore 26
    //   16937: aload 22
    //   16939: astore 27
    //   16941: aload 25
    //   16943: astore 22
    //   16945: aload 28
    //   16947: astore 23
    //   16949: iload 7
    //   16951: istore 4
    //   16953: aload 27
    //   16955: astore 25
    //   16957: goto -12024 -> 4933
    //   16960: astore 25
    //   16962: aconst_null
    //   16963: astore 28
    //   16965: aload 23
    //   16967: astore 26
    //   16969: aload 22
    //   16971: astore 27
    //   16973: aload 25
    //   16975: astore 22
    //   16977: aload 28
    //   16979: astore 23
    //   16981: aload 27
    //   16983: astore 25
    //   16985: goto -12052 -> 4933
    //   16988: astore 25
    //   16990: aload 23
    //   16992: astore 26
    //   16994: aload 22
    //   16996: astore 27
    //   16998: aconst_null
    //   16999: astore 23
    //   17001: aload 25
    //   17003: astore 22
    //   17005: aload 27
    //   17007: astore 25
    //   17009: goto -12076 -> 4933
    //   17012: astore 28
    //   17014: aload 23
    //   17016: astore 26
    //   17018: aload 22
    //   17020: astore 27
    //   17022: aload 25
    //   17024: astore 23
    //   17026: aload 28
    //   17028: astore 22
    //   17030: iload 5
    //   17032: istore_3
    //   17033: aload 27
    //   17035: astore 25
    //   17037: goto -12104 -> 4933
    //   17040: astore 25
    //   17042: aconst_null
    //   17043: astore 26
    //   17045: aload 22
    //   17047: astore 24
    //   17049: aconst_null
    //   17050: astore 23
    //   17052: aload 26
    //   17054: astore 22
    //   17056: iload 8
    //   17058: istore 4
    //   17060: goto -16808 -> 252
    //   17063: astore 25
    //   17065: iload 8
    //   17067: istore 4
    //   17069: goto -16817 -> 252
    //   17072: ldc_w 428
    //   17075: astore 24
    //   17077: goto -12031 -> 5046
    //   17080: ldc_w 428
    //   17083: astore 24
    //   17085: goto -16640 -> 445
    //   17088: ldc_w 428
    //   17091: astore 24
    //   17093: goto -4078 -> 13015
    //   17096: ldc_w 428
    //   17099: astore 24
    //   17101: goto -6538 -> 10563
    //   17104: ldc_w 428
    //   17107: astore 24
    //   17109: goto -8945 -> 8164
    //   17112: ldc_w 428
    //   17115: astore 24
    //   17117: goto -13927 -> 3190
    //   17120: iconst_0
    //   17121: istore 4
    //   17123: goto -14138 -> 2985
    //   17126: aconst_null
    //   17127: astore 22
    //   17129: aconst_null
    //   17130: astore 23
    //   17132: aconst_null
    //   17133: astore 24
    //   17135: goto -14199 -> 2936
    //   17138: iconst_1
    //   17139: istore 5
    //   17141: goto -14991 -> 2150
    //   17144: aload 28
    //   17146: astore 23
    //   17148: iload 4
    //   17150: iconst_2
    //   17151: if_icmpge -12406 -> 4745
    //   17154: aload 28
    //   17156: astore 23
    //   17158: iload 10
    //   17160: ifeq -12415 -> 4745
    //   17163: ldc_w 928
    //   17166: astore 23
    //   17168: goto -12423 -> 4745
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17171	0	this	FastDownloadTask
    //   0	17171	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	17171	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   29	17004	3	i	int
    //   246	16906	4	j	int
    //   263	16877	5	k	int
    //   275	6696	6	m	int
    //   177	16773	7	n	int
    //   180	16886	8	i1	int
    //   18	109	9	i2	int
    //   198	16961	10	bool1	boolean
    //   23	61	11	bool2	boolean
    //   26	16602	12	l1	long
    //   224	7004	14	l2	long
    //   228	7004	16	l3	long
    //   113	12794	18	l4	long
    //   188	2753	20	l5	long
    //   97	1	22	localException1	java.lang.Exception
    //   183	1	22	localObject1	Object
    //   215	16	22	localUnknownHostException	java.net.UnknownHostException
    //   236	4680	22	localObject2	Object
    //   4920	1638	22	localObject3	Object
    //   6589	10539	22	localObject4	Object
    //   242	16626	23	localObject5	Object
    //   16904	10	23	localObject6	Object
    //   16919	248	23	localObject7	Object
    //   166	7083	24	localObject8	Object
    //   7274	1	24	localException2	java.lang.Exception
    //   7279	690	24	str1	String
    //   7973	8	24	localException3	java.lang.Exception
    //   7988	162	24	localException4	java.lang.Exception
    //   8162	1163	24	localObject9	Object
    //   9680	1	24	localException5	java.lang.Exception
    //   9685	685	24	str2	String
    //   10374	8	24	localException6	java.lang.Exception
    //   10389	160	24	localException7	java.lang.Exception
    //   10561	1163	24	localObject10	Object
    //   12079	1	24	localException8	java.lang.Exception
    //   12084	685	24	str3	String
    //   12773	8	24	localException9	java.lang.Exception
    //   12788	213	24	localException10	java.lang.Exception
    //   13013	1167	24	localObject11	Object
    //   14571	1	24	localException11	java.lang.Exception
    //   14576	690	24	str4	String
    //   15270	8	24	localException12	java.lang.Exception
    //   15285	8	24	localException13	java.lang.Exception
    //   15354	1	24	localException14	java.lang.Exception
    //   15359	685	24	str5	String
    //   16048	8	24	localException15	java.lang.Exception
    //   16063	8	24	localException16	java.lang.Exception
    //   16132	1	24	localException17	java.lang.Exception
    //   16137	685	24	str6	String
    //   16826	8	24	localException18	java.lang.Exception
    //   16841	8	24	localException19	java.lang.Exception
    //   16911	223	24	localObject12	Object
    //   174	1	25	localObject13	Object
    //   233	1430	25	localThrowable1	java.lang.Throwable
    //   2926	11256	25	localObject14	Object
    //   14546	1	25	localThrowable2	java.lang.Throwable
    //   14566	1672	25	str7	String
    //   16928	14	25	localObject15	Object
    //   16955	1	25	localObject16	Object
    //   16960	14	25	localObject17	Object
    //   16983	1	25	localObject18	Object
    //   16988	14	25	localObject19	Object
    //   17007	29	25	localObject20	Object
    //   17040	1	25	localThrowable3	java.lang.Throwable
    //   17063	1	25	localThrowable4	java.lang.Throwable
    //   163	16890	26	localObject21	Object
    //   618	16416	27	localObject22	Object
    //   380	16598	28	localObject23	Object
    //   17012	143	28	localObject24	Object
    //   122	16646	29	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   423	16440	30	localObject25	Object
    //   588	15923	31	localObject26	Object
    //   5189	11563	32	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	83	97	java/lang/Exception
    //   190	200	215	java/net/UnknownHostException
    //   230	233	233	java/lang/Throwable
    //   1972	1983	233	java/lang/Throwable
    //   1991	2000	233	java/lang/Throwable
    //   2008	2017	233	java/lang/Throwable
    //   2025	2032	233	java/lang/Throwable
    //   2040	2051	233	java/lang/Throwable
    //   2059	2066	233	java/lang/Throwable
    //   2074	2080	233	java/lang/Throwable
    //   2088	2097	233	java/lang/Throwable
    //   2105	2117	233	java/lang/Throwable
    //   2125	2132	233	java/lang/Throwable
    //   2140	2147	233	java/lang/Throwable
    //   2158	2164	233	java/lang/Throwable
    //   2172	2180	233	java/lang/Throwable
    //   2188	2201	233	java/lang/Throwable
    //   2209	2216	233	java/lang/Throwable
    //   2224	2231	233	java/lang/Throwable
    //   2239	2249	233	java/lang/Throwable
    //   2257	2273	233	java/lang/Throwable
    //   2281	2293	233	java/lang/Throwable
    //   2301	2307	233	java/lang/Throwable
    //   2315	2324	233	java/lang/Throwable
    //   2347	2353	233	java/lang/Throwable
    //   2366	2378	233	java/lang/Throwable
    //   2390	2398	233	java/lang/Throwable
    //   2410	2438	233	java/lang/Throwable
    //   2450	2457	233	java/lang/Throwable
    //   2465	2482	233	java/lang/Throwable
    //   2494	2506	233	java/lang/Throwable
    //   2514	2520	233	java/lang/Throwable
    //   2528	2594	233	java/lang/Throwable
    //   2602	2609	233	java/lang/Throwable
    //   2617	2629	233	java/lang/Throwable
    //   2637	2649	233	java/lang/Throwable
    //   2657	2664	233	java/lang/Throwable
    //   2677	2704	233	java/lang/Throwable
    //   2712	2719	233	java/lang/Throwable
    //   2727	2752	233	java/lang/Throwable
    //   2760	2780	233	java/lang/Throwable
    //   2788	2810	233	java/lang/Throwable
    //   2818	2826	233	java/lang/Throwable
    //   2834	2839	233	java/lang/Throwable
    //   2847	2852	233	java/lang/Throwable
    //   2860	2867	233	java/lang/Throwable
    //   2875	2882	233	java/lang/Throwable
    //   2890	2897	233	java/lang/Throwable
    //   2905	2910	233	java/lang/Throwable
    //   4730	4742	233	java/lang/Throwable
    //   4753	4764	233	java/lang/Throwable
    //   4772	4778	233	java/lang/Throwable
    //   4791	4803	233	java/lang/Throwable
    //   4815	4823	233	java/lang/Throwable
    //   4835	4869	233	java/lang/Throwable
    //   4881	4888	233	java/lang/Throwable
    //   4896	4913	233	java/lang/Throwable
    //   6568	6580	233	java/lang/Throwable
    //   6595	6602	233	java/lang/Throwable
    //   6614	6630	233	java/lang/Throwable
    //   6638	6644	233	java/lang/Throwable
    //   6657	6669	233	java/lang/Throwable
    //   6681	6689	233	java/lang/Throwable
    //   6701	6729	233	java/lang/Throwable
    //   6741	6748	233	java/lang/Throwable
    //   6756	6773	233	java/lang/Throwable
    //   6788	6800	233	java/lang/Throwable
    //   6811	6818	233	java/lang/Throwable
    //   6826	6839	233	java/lang/Throwable
    //   6857	6874	233	java/lang/Throwable
    //   6882	6888	233	java/lang/Throwable
    //   6901	6913	233	java/lang/Throwable
    //   6925	6933	233	java/lang/Throwable
    //   6945	6980	233	java/lang/Throwable
    //   6988	6995	233	java/lang/Throwable
    //   7003	7020	233	java/lang/Throwable
    //   7028	7040	233	java/lang/Throwable
    //   7048	7054	233	java/lang/Throwable
    //   7062	7118	233	java/lang/Throwable
    //   7129	7141	233	java/lang/Throwable
    //   7152	7181	233	java/lang/Throwable
    //   7192	7199	233	java/lang/Throwable
    //   7207	7225	233	java/lang/Throwable
    //   7233	7244	233	java/lang/Throwable
    //   230	233	4920	finally
    //   1972	1983	4920	finally
    //   1991	2000	4920	finally
    //   2008	2017	4920	finally
    //   2025	2032	4920	finally
    //   2040	2051	4920	finally
    //   2059	2066	4920	finally
    //   2074	2080	4920	finally
    //   2088	2097	4920	finally
    //   2105	2117	4920	finally
    //   2125	2132	4920	finally
    //   2140	2147	4920	finally
    //   2158	2164	4920	finally
    //   2172	2180	4920	finally
    //   2188	2201	4920	finally
    //   2209	2216	4920	finally
    //   2224	2231	4920	finally
    //   2239	2249	4920	finally
    //   2257	2273	4920	finally
    //   2281	2293	4920	finally
    //   2301	2307	4920	finally
    //   2315	2324	4920	finally
    //   2347	2353	4920	finally
    //   2366	2378	4920	finally
    //   2390	2398	4920	finally
    //   2410	2438	4920	finally
    //   2450	2457	4920	finally
    //   2465	2482	4920	finally
    //   2494	2506	4920	finally
    //   2514	2520	4920	finally
    //   2528	2594	4920	finally
    //   2602	2609	4920	finally
    //   2617	2629	4920	finally
    //   2637	2649	4920	finally
    //   2657	2664	4920	finally
    //   2677	2704	4920	finally
    //   2712	2719	4920	finally
    //   2727	2752	4920	finally
    //   2760	2780	4920	finally
    //   2788	2810	4920	finally
    //   2818	2826	4920	finally
    //   2834	2839	4920	finally
    //   2847	2852	4920	finally
    //   2860	2867	4920	finally
    //   2875	2882	4920	finally
    //   2890	2897	4920	finally
    //   2905	2910	4920	finally
    //   4730	4742	4920	finally
    //   4753	4764	4920	finally
    //   4772	4778	4920	finally
    //   4791	4803	4920	finally
    //   4815	4823	4920	finally
    //   4835	4869	4920	finally
    //   4881	4888	4920	finally
    //   4896	4913	4920	finally
    //   6568	6580	4920	finally
    //   6595	6602	4920	finally
    //   6614	6630	4920	finally
    //   6638	6644	4920	finally
    //   6657	6669	4920	finally
    //   6681	6689	4920	finally
    //   6701	6729	4920	finally
    //   6741	6748	4920	finally
    //   6756	6773	4920	finally
    //   6788	6800	4920	finally
    //   6811	6818	4920	finally
    //   6826	6839	4920	finally
    //   6857	6874	4920	finally
    //   6882	6888	4920	finally
    //   6901	6913	4920	finally
    //   6925	6933	4920	finally
    //   6945	6980	4920	finally
    //   6988	6995	4920	finally
    //   7003	7020	4920	finally
    //   7028	7040	4920	finally
    //   7048	7054	4920	finally
    //   7062	7118	4920	finally
    //   7129	7141	4920	finally
    //   7152	7181	4920	finally
    //   7192	7199	4920	finally
    //   7207	7225	4920	finally
    //   7233	7244	4920	finally
    //   3175	3190	7274	java/lang/Exception
    //   4220	4247	7973	java/lang/Exception
    //   4277	4304	7988	java/lang/Exception
    //   8149	8164	9680	java/lang/Exception
    //   9190	9217	10374	java/lang/Exception
    //   9247	9274	10389	java/lang/Exception
    //   10548	10563	12079	java/lang/Exception
    //   11589	11616	12773	java/lang/Exception
    //   11646	11673	12788	java/lang/Exception
    //   2985	2994	14546	java/lang/Throwable
    //   3014	3072	14546	java/lang/Throwable
    //   12857	12873	14546	java/lang/Throwable
    //   12877	12898	14546	java/lang/Throwable
    //   14535	14543	14546	java/lang/Throwable
    //   13000	13015	14571	java/lang/Exception
    //   14045	14072	15270	java/lang/Exception
    //   14102	14129	15285	java/lang/Exception
    //   430	445	15354	java/lang/Exception
    //   1472	1499	16048	java/lang/Exception
    //   1529	1556	16063	java/lang/Exception
    //   5031	5046	16132	java/lang/Exception
    //   6073	6100	16826	java/lang/Exception
    //   6130	6157	16841	java/lang/Exception
    //   2910	2925	16904	finally
    //   2936	2946	16928	finally
    //   2961	2985	16928	finally
    //   7258	7265	16928	finally
    //   14551	14559	16928	finally
    //   2985	2994	16960	finally
    //   3014	3072	16960	finally
    //   12857	12873	16960	finally
    //   12877	12898	16960	finally
    //   14535	14543	16960	finally
    //   252	262	16988	finally
    //   265	274	17012	finally
    //   280	287	17012	finally
    //   293	306	17012	finally
    //   309	314	17012	finally
    //   323	332	17012	finally
    //   2910	2925	17040	java/lang/Throwable
    //   2936	2946	17063	java/lang/Throwable
    //   2961	2985	17063	java/lang/Throwable
    //   7258	7265	17063	java/lang/Throwable
    //   14551	14559	17063	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.FastDownloadTask
 * JD-Core Version:    0.7.0.1
 */