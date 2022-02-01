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
    //   97: astore 20
    //   99: ldc 219
    //   101: ldc_w 389
    //   104: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -24 -> 83
    //   110: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   113: lstore 14
    //   115: new 394	com/tencent/component/network/downloader/DownloadReport
    //   118: dup
    //   119: invokespecial 395	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   122: astore 28
    //   124: aload 28
    //   126: iload 9
    //   128: putfield 396	com/tencent/component/network/downloader/DownloadReport:id	I
    //   131: aload 28
    //   133: aload_0
    //   134: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   137: putfield 399	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   140: aload 28
    //   142: aload_0
    //   143: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   146: putfield 402	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   149: aload 28
    //   151: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   154: putfield 410	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   162: aconst_null
    //   163: astore 24
    //   165: aconst_null
    //   166: astore 22
    //   168: aload_0
    //   169: aconst_null
    //   170: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   173: aconst_null
    //   174: astore 23
    //   176: iconst_0
    //   177: istore 7
    //   179: iconst_0
    //   180: istore 8
    //   182: aconst_null
    //   183: astore 20
    //   185: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   188: lstore 16
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
    //   215: astore 20
    //   217: aload 20
    //   219: ifnull +1774 -> 1993
    //   222: aload 20
    //   224: athrow
    //   225: astore 23
    //   227: aconst_null
    //   228: astore 20
    //   230: aconst_null
    //   231: astore 22
    //   233: aconst_null
    //   234: astore 21
    //   236: iload 8
    //   238: istore 4
    //   240: ldc 219
    //   242: ldc_w 428
    //   245: aload 23
    //   247: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: iload_3
    //   251: istore 5
    //   253: aload_2
    //   254: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   257: aload 23
    //   259: invokevirtual 435	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   262: iload_3
    //   263: istore 6
    //   265: iload_3
    //   266: istore 5
    //   268: aload_0
    //   269: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   272: ifnull +48 -> 320
    //   275: iload_3
    //   276: istore 6
    //   278: iload_3
    //   279: istore 5
    //   281: aload_0
    //   282: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   285: ldc_w 439
    //   288: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   291: ifeq +29 -> 320
    //   294: iload_3
    //   295: istore 5
    //   297: aload_0
    //   298: iconst_1
    //   299: putfield 445	com/tencent/component/network/downloader/impl/FastDownloadTask:disableHttps	Z
    //   302: iload_3
    //   303: iconst_1
    //   304: isub
    //   305: istore 6
    //   307: iload 6
    //   309: istore 5
    //   311: ldc_w 447
    //   314: ldc_w 449
    //   317: invokestatic 451	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_2
    //   321: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   324: lload 14
    //   326: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   329: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   332: aload_2
    //   333: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   336: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   339: aload_0
    //   340: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   343: lsub
    //   344: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   347: aload_2
    //   348: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   351: aload_0
    //   352: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   355: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   358: aload_0
    //   359: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   362: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   365: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   368: astore 27
    //   370: aload_0
    //   371: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   374: ifnull +14848 -> 15222
    //   377: aload_0
    //   378: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   381: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   384: ifnull +14838 -> 15222
    //   387: aload_0
    //   388: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   391: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   394: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   397: astore 25
    //   399: aload_0
    //   400: aload_0
    //   401: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   404: aload 21
    //   406: aload 20
    //   408: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   411: astore 29
    //   413: ldc_w 428
    //   416: astore 24
    //   418: aload 22
    //   420: ifnull +16729 -> 17149
    //   423: aload 22
    //   425: ldc_w 492
    //   428: invokeinterface 498 2 0
    //   433: checkcast 282	java/lang/String
    //   436: astore 26
    //   438: aload 26
    //   440: astore 24
    //   442: aload 22
    //   444: ldc_w 500
    //   447: invokeinterface 498 2 0
    //   452: checkcast 282	java/lang/String
    //   455: astore 22
    //   457: aload_2
    //   458: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   461: aload 24
    //   463: putfield 509	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   466: aload_0
    //   467: lconst_0
    //   468: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   471: aload_0
    //   472: iconst_0
    //   473: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   476: aload_0
    //   477: lconst_0
    //   478: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   481: aload_0
    //   482: iconst_0
    //   483: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   486: aload_2
    //   487: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   490: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   493: ifeq +12 -> 505
    //   496: aload_1
    //   497: invokeinterface 359 1 0
    //   502: ifeq +31 -> 533
    //   505: aload_0
    //   506: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   509: ifnull +24 -> 533
    //   512: aload_0
    //   513: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   516: aload_0
    //   517: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   520: aload_2
    //   521: invokevirtual 519	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   524: aload 21
    //   526: aload 20
    //   528: invokeinterface 525 5 0
    //   533: aload_1
    //   534: invokeinterface 359 1 0
    //   539: ifne +1418 -> 1957
    //   542: aload_0
    //   543: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   546: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   549: istore 10
    //   551: aload_2
    //   552: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   555: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   558: ifne +14714 -> 15272
    //   561: new 125	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 527
    //   571: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_0
    //   575: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   578: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: ldc_w 529
    //   584: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_0
    //   588: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   591: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   594: ldc_w 534
    //   597: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: astore 30
    //   602: aload_0
    //   603: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   606: ifeq +14632 -> 15238
    //   609: aload 20
    //   611: ifnull +14627 -> 15238
    //   614: aload 20
    //   616: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   619: ifnull +14619 -> 15238
    //   622: aload 20
    //   624: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   627: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   630: astore 26
    //   632: aload 30
    //   634: aload 26
    //   636: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 545
    //   642: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload 27
    //   647: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   650: ldc_w 550
    //   653: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 25
    //   658: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: ldc_w 552
    //   664: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aconst_null
    //   668: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: ldc_w 554
    //   674: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   680: invokevirtual 174	java/lang/Thread:getId	()J
    //   683: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   686: ldc_w 556
    //   689: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   695: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 558
    //   701: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload_0
    //   705: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   708: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   711: ldc_w 560
    //   714: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload_0
    //   718: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   721: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   724: ldc_w 562
    //   727: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: astore 30
    //   732: aload_0
    //   733: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   736: ifeq +14510 -> 15246
    //   739: aload_0
    //   740: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   743: aload_0
    //   744: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   747: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   750: astore 26
    //   752: aload 30
    //   754: aload 26
    //   756: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   759: ldc_w 564
    //   762: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: iload 10
    //   767: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   770: ldc_w 566
    //   773: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: aload 22
    //   778: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: ldc_w 568
    //   784: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   790: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   793: ldc_w 575
    //   796: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_2
    //   800: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   803: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   806: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: ldc_w 580
    //   812: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload_2
    //   816: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   819: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   822: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   825: ldc_w 585
    //   828: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   834: aload_0
    //   835: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   838: lsub
    //   839: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   842: ldc_w 587
    //   845: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_2
    //   849: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   852: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   855: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   858: ldc_w 592
    //   861: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload_2
    //   865: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   868: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   871: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   874: ldc_w 596
    //   877: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload_2
    //   881: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   884: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   887: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   890: ldc_w 601
    //   893: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload_0
    //   897: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   900: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   903: ldc_w 603
    //   906: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload_0
    //   910: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   913: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: ldc_w 608
    //   919: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload_2
    //   923: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   926: invokevirtual 611	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   929: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   932: ldc_w 613
    //   935: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: iload 4
    //   940: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   943: ldc_w 615
    //   946: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload 29
    //   951: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: ldc_w 617
    //   957: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload 24
    //   962: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: ldc_w 619
    //   968: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: astore 30
    //   973: aload_0
    //   974: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   977: ifnull +14275 -> 15252
    //   980: aload_0
    //   981: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   984: iconst_0
    //   985: bipush 30
    //   987: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   990: astore 26
    //   992: aload 30
    //   994: aload 26
    //   996: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: ldc_w 625
    //   1002: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: astore 26
    //   1007: aload_0
    //   1008: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1011: ifnull +14250 -> 15261
    //   1014: aload_0
    //   1015: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1018: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1021: istore_3
    //   1022: aload 26
    //   1024: iload_3
    //   1025: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1028: ldc_w 627
    //   1031: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload_2
    //   1035: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1038: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1041: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: ldc_w 632
    //   1047: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: lload 12
    //   1052: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1055: ldc_w 634
    //   1058: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload_0
    //   1062: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   1065: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1068: ldc_w 603
    //   1071: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_0
    //   1075: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   1078: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1081: ldc_w 636
    //   1084: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload_0
    //   1088: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   1091: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1094: ldc_w 603
    //   1097: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: aload_0
    //   1101: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   1104: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1107: ldc_w 638
    //   1110: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: aload_0
    //   1114: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1117: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1120: ldc_w 640
    //   1123: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload_0
    //   1127: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   1130: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1133: ldc_w 645
    //   1136: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: aload_0
    //   1140: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   1143: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1146: ldc_w 650
    //   1149: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: astore 30
    //   1154: aload_0
    //   1155: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1158: ifnull +14108 -> 15266
    //   1161: aload_0
    //   1162: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1165: invokeinterface 660 1 0
    //   1170: astore 26
    //   1172: aload 28
    //   1174: aload 30
    //   1176: aload 26
    //   1178: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1187: ldc_w 447
    //   1190: aload 28
    //   1192: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1195: aload 23
    //   1197: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1200: aload_0
    //   1201: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1204: ifnull +24 -> 1228
    //   1207: aload_0
    //   1208: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1211: ldc_w 439
    //   1214: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1217: ifeq +11 -> 1228
    //   1220: aload_0
    //   1221: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1224: iconst_0
    //   1225: invokestatic 669	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   1228: iload 10
    //   1230: ifne +8 -> 1238
    //   1233: aload_0
    //   1234: iconst_0
    //   1235: putfield 672	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   1238: aload_2
    //   1239: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1242: astore 26
    //   1244: new 125	java/lang/StringBuilder
    //   1247: dup
    //   1248: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1251: aload_0
    //   1252: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1255: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: ldc_w 674
    //   1261: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload 25
    //   1266: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: ldc_w 676
    //   1272: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: aload_2
    //   1276: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1279: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1282: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: ldc_w 678
    //   1288: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: astore 25
    //   1293: aload_0
    //   1294: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1297: ifnull +14623 -> 15920
    //   1300: aload_0
    //   1301: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1304: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1307: istore_3
    //   1308: aload 25
    //   1310: iload_3
    //   1311: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1314: ldc_w 613
    //   1317: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: iload 4
    //   1322: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1325: ldc_w 575
    //   1328: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: aload_2
    //   1332: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1335: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1338: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: ldc_w 587
    //   1344: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: aload_2
    //   1348: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1351: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1354: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1357: ldc_w 592
    //   1360: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: aload_2
    //   1364: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1367: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1370: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1373: ldc_w 580
    //   1376: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: aload_2
    //   1380: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1383: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1386: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1389: ldc_w 585
    //   1392: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1398: aload_0
    //   1399: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1402: lsub
    //   1403: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1406: astore 25
    //   1408: aload 24
    //   1410: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1413: ifne +14512 -> 15925
    //   1416: new 125	java/lang/StringBuilder
    //   1419: dup
    //   1420: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1423: ldc_w 617
    //   1426: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: aload 24
    //   1431: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: astore 24
    //   1439: aload 26
    //   1441: aload 25
    //   1443: aload 24
    //   1445: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: ldc_w 615
    //   1451: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: aload 29
    //   1456: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1462: putfield 681	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   1465: aload_0
    //   1466: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1469: ifnull +56 -> 1525
    //   1472: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1475: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1478: aload_0
    //   1479: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1482: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1485: if_icmpne +40 -> 1525
    //   1488: aload_0
    //   1489: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1492: ifnull +33 -> 1525
    //   1495: aload 22
    //   1497: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1500: ifne +14433 -> 15933
    //   1503: aload_0
    //   1504: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1507: aload_0
    //   1508: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1511: aload 22
    //   1513: aload_2
    //   1514: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1517: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1520: invokeinterface 685 4 0
    //   1525: aload_0
    //   1526: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1529: ifnull +56 -> 1585
    //   1532: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1535: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1538: aload_0
    //   1539: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1542: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1545: if_icmpne +40 -> 1585
    //   1548: aload_0
    //   1549: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1552: ifnull +33 -> 1585
    //   1555: aload 22
    //   1557: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1560: ifne +14418 -> 15978
    //   1563: aload_0
    //   1564: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1567: aload_0
    //   1568: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1571: aload 22
    //   1573: aload_2
    //   1574: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1577: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1580: invokeinterface 685 4 0
    //   1585: iload 10
    //   1587: ifeq +64 -> 1651
    //   1590: aload_0
    //   1591: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   1594: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1597: astore 22
    //   1599: aload_0
    //   1600: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1603: astore 24
    //   1605: aload_0
    //   1606: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1609: ifeq +14414 -> 16023
    //   1612: aload_0
    //   1613: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1616: ifnull +14407 -> 16023
    //   1619: aload_0
    //   1620: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1623: ldc_w 687
    //   1626: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1629: ifeq +14394 -> 16023
    //   1632: iconst_1
    //   1633: istore 10
    //   1635: aload 22
    //   1637: aload 24
    //   1639: iload 10
    //   1641: aload_2
    //   1642: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1645: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1648: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   1651: aload 28
    //   1653: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   1656: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1659: aload 28
    //   1661: aload_0
    //   1662: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   1665: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1668: aload 28
    //   1670: aload 21
    //   1672: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1675: aload 28
    //   1677: aload 20
    //   1679: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   1682: aload 28
    //   1684: iload 4
    //   1686: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1689: aload 28
    //   1691: aload 23
    //   1693: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1696: aload 27
    //   1698: ifnonnull +14331 -> 16029
    //   1701: aconst_null
    //   1702: astore 21
    //   1704: aload 28
    //   1706: aload 21
    //   1708: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1711: aload 28
    //   1713: aconst_null
    //   1714: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1717: aload 28
    //   1719: aload_2
    //   1720: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1723: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1726: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1729: aload 28
    //   1731: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1734: aload_0
    //   1735: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1738: lsub
    //   1739: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1742: aload 28
    //   1744: aload_2
    //   1745: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1748: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1751: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1754: aload 28
    //   1756: aload 28
    //   1758: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1761: aload_2
    //   1762: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1765: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1768: lsub
    //   1769: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1772: aload 28
    //   1774: lload 12
    //   1776: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1779: aload 28
    //   1781: aload_0
    //   1782: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   1785: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1788: aload 28
    //   1790: aload_0
    //   1791: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1794: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1797: aload 28
    //   1799: aload_0
    //   1800: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   1803: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1806: aload 28
    //   1808: lconst_0
    //   1809: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1812: aload 28
    //   1814: aload_0
    //   1815: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   1818: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1821: aload 28
    //   1823: aload_2
    //   1824: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1827: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1830: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1833: aload 28
    //   1835: aload_0
    //   1836: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1839: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1842: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1845: aload 28
    //   1847: aload_0
    //   1848: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1851: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1854: aload_0
    //   1855: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1858: ifnull +14181 -> 16039
    //   1861: aload_0
    //   1862: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1865: ldc_w 687
    //   1868: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1871: ifeq +14168 -> 16039
    //   1874: iconst_1
    //   1875: istore 10
    //   1877: aload 28
    //   1879: iload 10
    //   1881: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1884: aload 28
    //   1886: aload_2
    //   1887: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1890: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1893: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1896: aload 28
    //   1898: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   1901: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   1904: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   1907: aload 20
    //   1909: ifnull +24 -> 1933
    //   1912: aload 20
    //   1914: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1917: ifnull +16 -> 1933
    //   1920: aload 28
    //   1922: aload 20
    //   1924: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1927: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1930: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   1933: aload_2
    //   1934: aload 28
    //   1936: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1939: aload_2
    //   1940: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1943: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1946: ifeq +11 -> 1957
    //   1949: aload_0
    //   1950: aload_1
    //   1951: aload_2
    //   1952: aload 28
    //   1954: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1957: aload_0
    //   1958: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1961: ifeq +14084 -> 16045
    //   1964: aload_0
    //   1965: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1968: ifnull +12 -> 1980
    //   1971: aload_0
    //   1972: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1975: invokeinterface 792 1 0
    //   1980: aload_0
    //   1981: aconst_null
    //   1982: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1985: iload 6
    //   1987: iconst_1
    //   1988: iadd
    //   1989: istore_3
    //   1990: goto -1785 -> 205
    //   1993: aload_2
    //   1994: invokevirtual 795	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   1997: getstatic 799	com/tencent/component/network/downloader/impl/FastDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   2000: invokevirtual 805	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   2003: checkcast 807	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   2006: astore 27
    //   2008: aload 27
    //   2010: aload_0
    //   2011: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   2014: putfield 808	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   2017: aload 27
    //   2019: aload_0
    //   2020: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   2023: putfield 811	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   2026: aload_0
    //   2027: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2030: ifnull +2390 -> 4420
    //   2033: aload_0
    //   2034: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2037: invokeinterface 660 1 0
    //   2042: astore 20
    //   2044: aload 27
    //   2046: aload 20
    //   2048: putfield 814	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2051: aload 28
    //   2053: iload_3
    //   2054: putfield 817	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   2057: aload 28
    //   2059: aload_0
    //   2060: getfield 819	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2063: putfield 822	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   2066: aload_0
    //   2067: aload_0
    //   2068: aload_0
    //   2069: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2072: invokevirtual 825	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   2075: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2078: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2081: iconst_2
    //   2082: if_icmpeq +15150 -> 17232
    //   2085: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2088: iconst_3
    //   2089: if_icmpne +2337 -> 4426
    //   2092: goto +15140 -> 17232
    //   2095: aload_0
    //   2096: invokevirtual 828	com/tencent/component/network/downloader/impl/FastDownloadTask:enableIpv6Debug	()Z
    //   2099: istore 10
    //   2101: aload 27
    //   2103: getfield 814	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2106: ifnonnull +4300 -> 6406
    //   2109: aload_0
    //   2110: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2113: ldc_w 687
    //   2116: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2119: ifeq +10 -> 2129
    //   2122: aload_0
    //   2123: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2126: ifeq +4280 -> 6406
    //   2129: aload_0
    //   2130: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2133: ifnull +4273 -> 6406
    //   2136: aload_0
    //   2137: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2140: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2143: ifnull +4263 -> 6406
    //   2146: aload_0
    //   2147: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2150: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2153: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2156: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2159: ifne +4247 -> 6406
    //   2162: aload_0
    //   2163: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2166: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2169: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2172: astore 26
    //   2174: aload_0
    //   2175: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2178: astore 25
    //   2180: aload 26
    //   2182: bipush 58
    //   2184: invokestatic 832	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   2187: istore 4
    //   2189: iload 5
    //   2191: ifne +15047 -> 17238
    //   2194: aload 25
    //   2196: astore 20
    //   2198: iload 4
    //   2200: iconst_2
    //   2201: if_icmpge +102 -> 2303
    //   2204: aload_0
    //   2205: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   2208: istore 4
    //   2210: iload 4
    //   2212: ifle +2220 -> 4432
    //   2215: aload_0
    //   2216: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2219: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2222: iload 4
    //   2224: putfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2227: iload 4
    //   2229: istore 6
    //   2231: iload 4
    //   2233: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   2236: ifne +7 -> 2243
    //   2239: bipush 80
    //   2241: istore 6
    //   2243: new 125	java/lang/StringBuilder
    //   2246: dup
    //   2247: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2250: aload 26
    //   2252: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: ldc_w 837
    //   2258: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: iload 6
    //   2263: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2266: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2269: astore 21
    //   2271: aload 21
    //   2273: astore 20
    //   2275: aload_0
    //   2276: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2279: ifnull +24 -> 2303
    //   2282: aload_0
    //   2283: aload_0
    //   2284: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2287: aload_0
    //   2288: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2291: aload 21
    //   2293: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2296: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2299: aload 21
    //   2301: astore 20
    //   2303: aload 28
    //   2305: aload_0
    //   2306: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2309: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2312: putfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2315: invokestatic 849	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   2318: ifeq +69 -> 2387
    //   2321: ldc 219
    //   2323: new 125	java/lang/StringBuilder
    //   2326: dup
    //   2327: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2330: ldc_w 851
    //   2333: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: aload 28
    //   2338: getfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2341: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2344: ldc_w 853
    //   2347: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: aload 20
    //   2352: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2355: ldc 151
    //   2357: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: aload_0
    //   2361: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2364: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: ldc 225
    //   2369: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2372: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2375: invokevirtual 174	java/lang/Thread:getId	()J
    //   2378: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2381: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2384: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2387: aload_0
    //   2388: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2391: ifnull +27 -> 2418
    //   2394: aload 28
    //   2396: aload_0
    //   2397: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2400: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2403: putfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2406: aload 28
    //   2408: aload_0
    //   2409: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2412: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2415: putfield 856	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2418: aload_0
    //   2419: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2422: ifeq +4221 -> 6643
    //   2425: iload 5
    //   2427: ifne +4216 -> 6643
    //   2430: aload_0
    //   2431: aload_0
    //   2432: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2435: aload_0
    //   2436: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2439: aload_0
    //   2440: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2443: aload_0
    //   2444: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2447: aload_0
    //   2448: getfield 819	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2451: invokestatic 862	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   2454: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2457: aload_0
    //   2458: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2461: ifnull +28 -> 2489
    //   2464: aload_0
    //   2465: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2468: aload_0
    //   2469: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2472: aload_0
    //   2473: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2476: aload_0
    //   2477: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2480: aload_0
    //   2481: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2484: invokeinterface 866 5 0
    //   2489: aload_0
    //   2490: aload_0
    //   2491: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2494: aload_0
    //   2495: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2498: aload_0
    //   2499: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2502: aload_0
    //   2503: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2506: invokevirtual 869	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   2509: aload_0
    //   2510: aload_0
    //   2511: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2514: aload_0
    //   2515: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2518: aload_0
    //   2519: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2522: aload_0
    //   2523: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2526: aload 27
    //   2528: invokevirtual 873	com/tencent/component/network/downloader/impl/FastDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2531: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   2534: lstore 18
    //   2536: lload 18
    //   2538: lload 16
    //   2540: lsub
    //   2541: lstore 12
    //   2543: aload_0
    //   2544: lconst_0
    //   2545: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2548: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2551: lstore 16
    //   2553: aload_0
    //   2554: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2557: ifnull +4118 -> 6675
    //   2560: aload_0
    //   2561: getfield 877	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2564: ifnonnull +10 -> 2574
    //   2567: aload_0
    //   2568: invokestatic 881	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2571: putfield 877	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2574: invokestatic 885	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   2577: astore 20
    //   2579: aload_0
    //   2580: getfield 877	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2583: aload_0
    //   2584: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2587: aload 20
    //   2589: invokevirtual 890	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   2592: astore 21
    //   2594: aconst_null
    //   2595: astore 23
    //   2597: aload 20
    //   2599: astore 22
    //   2601: aload 23
    //   2603: astore 20
    //   2605: aload_0
    //   2606: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2609: lload 16
    //   2611: lsub
    //   2612: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2615: aload 21
    //   2617: ifnonnull +8 -> 2625
    //   2620: aload 20
    //   2622: ifnull +11732 -> 14354
    //   2625: aload 21
    //   2627: ifnull +4093 -> 6720
    //   2630: aload 21
    //   2632: invokeinterface 896 1 0
    //   2637: ifnull +4083 -> 6720
    //   2640: aload 21
    //   2642: invokeinterface 896 1 0
    //   2647: invokeinterface 901 1 0
    //   2652: istore 4
    //   2654: aload_2
    //   2655: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2658: iload 4
    //   2660: putfield 902	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   2663: sipush 200
    //   2666: iload 4
    //   2668: if_icmpeq +11 -> 2679
    //   2671: sipush 206
    //   2674: iload 4
    //   2676: if_icmpne +9935 -> 12611
    //   2679: iload 4
    //   2681: istore 5
    //   2683: aload_0
    //   2684: aload 21
    //   2686: aload 20
    //   2688: aload_2
    //   2689: aload_1
    //   2690: iload 4
    //   2692: invokevirtual 906	com/tencent/component/network/downloader/impl/FastDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   2695: ifeq +9969 -> 12664
    //   2698: aload_2
    //   2699: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2702: invokevirtual 909	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   2705: aload_2
    //   2706: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2709: getfield 912	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   2712: ifeq +7388 -> 10100
    //   2715: aload_0
    //   2716: aload 21
    //   2718: aload 20
    //   2720: invokevirtual 916	com/tencent/component/network/downloader/impl/FastDownloadTask:getRetcode	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;)I
    //   2723: istore 5
    //   2725: aload_2
    //   2726: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2729: iload 5
    //   2731: putfield 919	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   2734: iload 5
    //   2736: invokestatic 922	com/tencent/component/network/module/base/Config:canRetCodeRetry	(I)Z
    //   2739: istore 10
    //   2741: iload 10
    //   2743: ifeq +4846 -> 7589
    //   2746: aload_2
    //   2747: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2750: lload 14
    //   2752: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2755: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   2758: aload_2
    //   2759: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2762: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2765: aload_0
    //   2766: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   2769: lsub
    //   2770: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   2773: aload_2
    //   2774: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2777: aload_0
    //   2778: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   2781: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   2784: aload_0
    //   2785: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2788: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   2791: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2794: astore 26
    //   2796: aload_0
    //   2797: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2800: ifnull +3935 -> 6735
    //   2803: aload_0
    //   2804: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2807: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2810: ifnull +3925 -> 6735
    //   2813: aload_0
    //   2814: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2817: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2820: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2823: astore 24
    //   2825: aload_0
    //   2826: aload_0
    //   2827: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2830: aload 21
    //   2832: aload 20
    //   2834: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   2837: astore 27
    //   2839: ldc_w 428
    //   2842: astore 23
    //   2844: aload 22
    //   2846: ifnull +14355 -> 17201
    //   2849: aload 22
    //   2851: ldc_w 492
    //   2854: invokeinterface 498 2 0
    //   2859: checkcast 282	java/lang/String
    //   2862: astore 25
    //   2864: aload 25
    //   2866: astore 23
    //   2868: aload 22
    //   2870: ldc_w 500
    //   2873: invokeinterface 498 2 0
    //   2878: checkcast 282	java/lang/String
    //   2881: astore 22
    //   2883: aload_2
    //   2884: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2887: aload 23
    //   2889: putfield 509	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   2892: aload_0
    //   2893: lconst_0
    //   2894: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   2897: aload_0
    //   2898: iconst_0
    //   2899: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   2902: aload_0
    //   2903: lconst_0
    //   2904: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   2907: aload_0
    //   2908: iconst_0
    //   2909: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   2912: aload_2
    //   2913: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2916: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2919: ifeq +12 -> 2931
    //   2922: aload_1
    //   2923: invokeinterface 359 1 0
    //   2928: ifeq +31 -> 2959
    //   2931: aload_0
    //   2932: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2935: ifnull +24 -> 2959
    //   2938: aload_0
    //   2939: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2942: aload_0
    //   2943: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2946: aload_2
    //   2947: invokevirtual 519	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2950: aload 21
    //   2952: aload 20
    //   2954: invokeinterface 525 5 0
    //   2959: aload_1
    //   2960: invokeinterface 359 1 0
    //   2965: ifne +1420 -> 4385
    //   2968: aload_0
    //   2969: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2972: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2975: istore 10
    //   2977: aload_2
    //   2978: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2981: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2984: ifne +3802 -> 6786
    //   2987: new 125	java/lang/StringBuilder
    //   2990: dup
    //   2991: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   2994: ldc_w 527
    //   2997: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3000: aload_0
    //   3001: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3004: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3007: ldc_w 529
    //   3010: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3013: aload_0
    //   3014: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3017: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3020: ldc_w 534
    //   3023: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3026: astore 29
    //   3028: aload_0
    //   3029: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3032: ifeq +3719 -> 6751
    //   3035: aload 20
    //   3037: ifnull +3714 -> 6751
    //   3040: aload 20
    //   3042: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3045: ifnull +3706 -> 6751
    //   3048: aload 20
    //   3050: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3053: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3056: astore 25
    //   3058: aload 29
    //   3060: aload 25
    //   3062: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3065: ldc_w 545
    //   3068: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: aload 26
    //   3073: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3076: ldc_w 550
    //   3079: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3082: aload 24
    //   3084: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3087: ldc_w 552
    //   3090: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3093: aconst_null
    //   3094: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3097: ldc_w 554
    //   3100: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3106: invokevirtual 174	java/lang/Thread:getId	()J
    //   3109: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3112: ldc_w 556
    //   3115: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3118: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3121: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3124: ldc_w 558
    //   3127: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3130: aload_0
    //   3131: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3134: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3137: ldc_w 560
    //   3140: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3143: aload_0
    //   3144: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3147: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3150: ldc_w 562
    //   3153: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3156: astore 29
    //   3158: aload_0
    //   3159: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3162: ifeq +3597 -> 6759
    //   3165: aload_0
    //   3166: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3169: aload_0
    //   3170: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3173: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3176: astore 25
    //   3178: aload 29
    //   3180: aload 25
    //   3182: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3185: ldc_w 564
    //   3188: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3191: iload 10
    //   3193: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3196: ldc_w 566
    //   3199: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3202: aload 22
    //   3204: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3207: ldc_w 568
    //   3210: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3213: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3216: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3219: ldc_w 575
    //   3222: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3225: aload_2
    //   3226: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3229: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3232: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3235: ldc_w 580
    //   3238: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3241: aload_2
    //   3242: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3245: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3248: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3251: ldc_w 585
    //   3254: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3257: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3260: aload_0
    //   3261: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3264: lsub
    //   3265: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3268: ldc_w 587
    //   3271: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3274: aload_2
    //   3275: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3278: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3281: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3284: ldc_w 592
    //   3287: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3290: aload_2
    //   3291: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3294: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3297: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3300: ldc_w 596
    //   3303: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3306: aload_2
    //   3307: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3310: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3313: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3316: ldc_w 601
    //   3319: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3322: aload_0
    //   3323: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   3326: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3329: ldc_w 603
    //   3332: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3335: aload_0
    //   3336: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   3339: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3342: ldc_w 608
    //   3345: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3348: aload_2
    //   3349: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3352: invokevirtual 611	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3355: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3358: ldc_w 613
    //   3361: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3364: iload 4
    //   3366: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3369: ldc_w 615
    //   3372: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3375: aload 27
    //   3377: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3380: ldc_w 617
    //   3383: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3386: aload 23
    //   3388: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3391: ldc_w 619
    //   3394: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3397: astore 29
    //   3399: aload_0
    //   3400: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3403: ifnull +3362 -> 6765
    //   3406: aload_0
    //   3407: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3410: iconst_0
    //   3411: bipush 30
    //   3413: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   3416: astore 25
    //   3418: aload 29
    //   3420: aload 25
    //   3422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: ldc_w 625
    //   3428: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3431: astore 25
    //   3433: aload_0
    //   3434: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3437: ifnull +3337 -> 6774
    //   3440: aload_0
    //   3441: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3444: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3447: istore 5
    //   3449: aload 25
    //   3451: iload 5
    //   3453: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3456: ldc_w 627
    //   3459: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3462: aload_2
    //   3463: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3466: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3469: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3472: ldc_w 632
    //   3475: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3478: lload 12
    //   3480: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3483: ldc_w 634
    //   3486: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3489: aload_0
    //   3490: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3493: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3496: ldc_w 603
    //   3499: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3502: aload_0
    //   3503: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3506: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3509: ldc_w 636
    //   3512: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3515: aload_0
    //   3516: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3519: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3522: ldc_w 603
    //   3525: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3528: aload_0
    //   3529: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3532: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3535: ldc_w 638
    //   3538: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3541: aload_0
    //   3542: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   3545: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3548: ldc_w 640
    //   3551: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3554: aload_0
    //   3555: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   3558: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3561: ldc_w 645
    //   3564: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: aload_0
    //   3568: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   3571: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3574: ldc_w 650
    //   3577: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3580: astore 29
    //   3582: aload_0
    //   3583: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3586: ifnull +3194 -> 6780
    //   3589: aload_0
    //   3590: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3593: invokeinterface 660 1 0
    //   3598: astore 25
    //   3600: aload 28
    //   3602: aload 29
    //   3604: aload 25
    //   3606: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3609: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3612: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3615: ldc_w 447
    //   3618: aload 28
    //   3620: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3623: aconst_null
    //   3624: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3627: aload_0
    //   3628: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3631: ifnull +24 -> 3655
    //   3634: aload_0
    //   3635: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3638: ldc_w 439
    //   3641: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3644: ifeq +11 -> 3655
    //   3647: aload_0
    //   3648: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   3651: iconst_0
    //   3652: invokestatic 669	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   3655: iload 10
    //   3657: ifne +8 -> 3665
    //   3660: aload_0
    //   3661: iconst_0
    //   3662: putfield 672	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   3665: aload_2
    //   3666: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3669: astore 25
    //   3671: new 125	java/lang/StringBuilder
    //   3674: dup
    //   3675: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   3678: aload_0
    //   3679: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3682: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3685: ldc_w 674
    //   3688: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3691: aload 24
    //   3693: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: ldc_w 676
    //   3699: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3702: aload_2
    //   3703: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3706: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3709: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3712: ldc_w 678
    //   3715: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3718: astore 24
    //   3720: aload_0
    //   3721: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3724: ifnull +3713 -> 7437
    //   3727: aload_0
    //   3728: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3731: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3734: istore 5
    //   3736: aload 24
    //   3738: iload 5
    //   3740: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3743: ldc_w 613
    //   3746: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3749: iload 4
    //   3751: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3754: ldc_w 575
    //   3757: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3760: aload_2
    //   3761: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3764: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3767: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: ldc_w 587
    //   3773: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3776: aload_2
    //   3777: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3780: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3783: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3786: ldc_w 592
    //   3789: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3792: aload_2
    //   3793: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3796: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3799: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3802: ldc_w 580
    //   3805: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3808: aload_2
    //   3809: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3812: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3815: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3818: ldc_w 585
    //   3821: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3824: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3827: aload_0
    //   3828: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3831: lsub
    //   3832: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3835: astore 24
    //   3837: aload 23
    //   3839: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3842: ifne +3601 -> 7443
    //   3845: new 125	java/lang/StringBuilder
    //   3848: dup
    //   3849: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   3852: ldc_w 617
    //   3855: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3858: aload 23
    //   3860: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3863: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3866: astore 23
    //   3868: aload 25
    //   3870: aload 24
    //   3872: aload 23
    //   3874: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: ldc_w 615
    //   3880: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3883: aload 27
    //   3885: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3888: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3891: putfield 681	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   3894: aload_0
    //   3895: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3898: ifnull +56 -> 3954
    //   3901: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3904: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3907: aload_0
    //   3908: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3911: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3914: if_icmpne +40 -> 3954
    //   3917: aload_0
    //   3918: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3921: ifnull +33 -> 3954
    //   3924: aload 22
    //   3926: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3929: ifne +3522 -> 7451
    //   3932: aload_0
    //   3933: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3936: aload_0
    //   3937: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   3940: aload 22
    //   3942: aload_2
    //   3943: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3946: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3949: invokeinterface 685 4 0
    //   3954: aload_0
    //   3955: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3958: ifnull +56 -> 4014
    //   3961: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3964: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3967: aload_0
    //   3968: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3971: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3974: if_icmpne +40 -> 4014
    //   3977: aload_0
    //   3978: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3981: ifnull +33 -> 4014
    //   3984: aload 22
    //   3986: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3989: ifne +3507 -> 7496
    //   3992: aload_0
    //   3993: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3996: aload_0
    //   3997: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4000: aload 22
    //   4002: aload_2
    //   4003: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4006: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4009: invokeinterface 685 4 0
    //   4014: iload 10
    //   4016: ifeq +64 -> 4080
    //   4019: aload_0
    //   4020: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4023: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   4026: astore 22
    //   4028: aload_0
    //   4029: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4032: astore 23
    //   4034: aload_0
    //   4035: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4038: ifeq +3503 -> 7541
    //   4041: aload_0
    //   4042: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4045: ifnull +3496 -> 7541
    //   4048: aload_0
    //   4049: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4052: ldc_w 687
    //   4055: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4058: ifeq +3483 -> 7541
    //   4061: iconst_1
    //   4062: istore 10
    //   4064: aload 22
    //   4066: aload 23
    //   4068: iload 10
    //   4070: aload_2
    //   4071: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4074: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4077: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   4080: aload 28
    //   4082: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   4085: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4088: aload 28
    //   4090: aload_0
    //   4091: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   4094: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4097: aload 28
    //   4099: aload 21
    //   4101: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4104: aload 28
    //   4106: aload 20
    //   4108: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   4111: aload 28
    //   4113: iload 4
    //   4115: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4118: aload 28
    //   4120: aconst_null
    //   4121: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4124: aload 26
    //   4126: ifnonnull +3421 -> 7547
    //   4129: aconst_null
    //   4130: astore 21
    //   4132: aload 28
    //   4134: aload 21
    //   4136: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4139: aload 28
    //   4141: aconst_null
    //   4142: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4145: aload 28
    //   4147: aload_2
    //   4148: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4151: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4154: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4157: aload 28
    //   4159: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4162: aload_0
    //   4163: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4166: lsub
    //   4167: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4170: aload 28
    //   4172: aload_2
    //   4173: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4176: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4179: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4182: aload 28
    //   4184: aload 28
    //   4186: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4189: aload_2
    //   4190: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4193: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4196: lsub
    //   4197: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4200: aload 28
    //   4202: lload 12
    //   4204: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4207: aload 28
    //   4209: aload_0
    //   4210: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4213: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4216: aload 28
    //   4218: aload_0
    //   4219: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   4222: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4225: aload 28
    //   4227: aload_0
    //   4228: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   4231: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4234: aload 28
    //   4236: lconst_0
    //   4237: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4240: aload 28
    //   4242: aload_0
    //   4243: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   4246: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4249: aload 28
    //   4251: aload_2
    //   4252: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4255: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4258: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4261: aload 28
    //   4263: aload_0
    //   4264: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4267: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4270: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4273: aload 28
    //   4275: aload_0
    //   4276: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4279: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4282: aload_0
    //   4283: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4286: ifnull +3271 -> 7557
    //   4289: aload_0
    //   4290: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4293: ldc_w 687
    //   4296: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4299: ifeq +3258 -> 7557
    //   4302: iconst_1
    //   4303: istore 10
    //   4305: aload 28
    //   4307: iload 10
    //   4309: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4312: aload 28
    //   4314: aload_2
    //   4315: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4318: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4321: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4324: aload 28
    //   4326: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   4329: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   4332: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   4335: aload 20
    //   4337: ifnull +24 -> 4361
    //   4340: aload 20
    //   4342: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4345: ifnull +16 -> 4361
    //   4348: aload 28
    //   4350: aload 20
    //   4352: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4355: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4358: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   4361: aload_2
    //   4362: aload 28
    //   4364: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4367: aload_2
    //   4368: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4371: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4374: ifeq +11 -> 4385
    //   4377: aload_0
    //   4378: aload_1
    //   4379: aload_2
    //   4380: aload 28
    //   4382: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4385: aload_0
    //   4386: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4389: ifeq +3174 -> 7563
    //   4392: aload_0
    //   4393: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4396: ifnull +12 -> 4408
    //   4399: aload_0
    //   4400: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4403: invokeinterface 792 1 0
    //   4408: aload_0
    //   4409: aconst_null
    //   4410: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   4413: iload_3
    //   4414: iconst_1
    //   4415: iadd
    //   4416: istore_3
    //   4417: goto -4212 -> 205
    //   4420: aconst_null
    //   4421: astore 20
    //   4423: goto -2379 -> 2044
    //   4426: iconst_0
    //   4427: istore 5
    //   4429: goto -2334 -> 2095
    //   4432: aload_0
    //   4433: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4436: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4439: getfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4442: istore 4
    //   4444: goto -2217 -> 2227
    //   4447: aload 21
    //   4449: bipush 58
    //   4451: invokestatic 832	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   4454: iconst_2
    //   4455: if_icmplt +1803 -> 6258
    //   4458: aload_0
    //   4459: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   4462: istore 4
    //   4464: iload 4
    //   4466: ifle +1777 -> 6243
    //   4469: aload_0
    //   4470: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4473: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4476: iload 4
    //   4478: putfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4481: iload 4
    //   4483: istore 6
    //   4485: iload 4
    //   4487: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   4490: ifne +7 -> 4497
    //   4493: bipush 80
    //   4495: istore 6
    //   4497: new 125	java/lang/StringBuilder
    //   4500: dup
    //   4501: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4504: ldc_w 924
    //   4507: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4510: aload 21
    //   4512: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4515: ldc_w 926
    //   4518: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4521: iload 6
    //   4523: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4526: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4529: astore 21
    //   4531: aload 21
    //   4533: astore 20
    //   4535: aload_0
    //   4536: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4539: ifnull -2236 -> 2303
    //   4542: aload_0
    //   4543: aload_0
    //   4544: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4547: aload_0
    //   4548: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4551: aload 21
    //   4553: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4556: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4559: aload 21
    //   4561: astore 20
    //   4563: goto -2260 -> 2303
    //   4566: astore 20
    //   4568: aconst_null
    //   4569: astore 21
    //   4571: iload 7
    //   4573: istore 4
    //   4575: aload_2
    //   4576: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4579: lload 14
    //   4581: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4584: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4587: aload_2
    //   4588: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4591: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4594: aload_0
    //   4595: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4598: lsub
    //   4599: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4602: aload_2
    //   4603: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4606: aload_0
    //   4607: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   4610: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4613: aload_0
    //   4614: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4617: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4620: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4623: astore 29
    //   4625: aload_0
    //   4626: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4629: ifnull +11442 -> 16071
    //   4632: aload_0
    //   4633: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4636: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4639: ifnull +11432 -> 16071
    //   4642: aload_0
    //   4643: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4646: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4649: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   4652: astore 26
    //   4654: aload_0
    //   4655: aload_0
    //   4656: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   4659: aload 24
    //   4661: aload 23
    //   4663: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   4666: astore 30
    //   4668: ldc_w 428
    //   4671: astore 25
    //   4673: aload 22
    //   4675: ifnull +12461 -> 17136
    //   4678: aload 22
    //   4680: ldc_w 492
    //   4683: invokeinterface 498 2 0
    //   4688: checkcast 282	java/lang/String
    //   4691: astore 27
    //   4693: aload 27
    //   4695: astore 25
    //   4697: aload 22
    //   4699: ldc_w 500
    //   4702: invokeinterface 498 2 0
    //   4707: checkcast 282	java/lang/String
    //   4710: astore 22
    //   4712: aload_2
    //   4713: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4716: aload 25
    //   4718: putfield 509	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   4721: aload_0
    //   4722: lconst_0
    //   4723: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4726: aload_0
    //   4727: iconst_0
    //   4728: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   4731: aload_0
    //   4732: lconst_0
    //   4733: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   4736: aload_0
    //   4737: iconst_0
    //   4738: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   4741: aload_2
    //   4742: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4745: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4748: ifeq +12 -> 4760
    //   4751: aload_1
    //   4752: invokeinterface 359 1 0
    //   4757: ifeq +31 -> 4788
    //   4760: aload_0
    //   4761: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4764: ifnull +24 -> 4788
    //   4767: aload_0
    //   4768: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4771: aload_0
    //   4772: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   4775: aload_2
    //   4776: invokevirtual 519	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4779: aload 24
    //   4781: aload 23
    //   4783: invokeinterface 525 5 0
    //   4788: aload_1
    //   4789: invokeinterface 359 1 0
    //   4794: ifne +1418 -> 6212
    //   4797: aload_0
    //   4798: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4801: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4804: istore 10
    //   4806: aload_2
    //   4807: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4810: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4813: ifne +11308 -> 16121
    //   4816: new 125	java/lang/StringBuilder
    //   4819: dup
    //   4820: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   4823: ldc_w 527
    //   4826: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4829: aload_0
    //   4830: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   4833: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4836: ldc_w 529
    //   4839: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4842: aload_0
    //   4843: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4846: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4849: ldc_w 534
    //   4852: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4855: astore 31
    //   4857: aload_0
    //   4858: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4861: ifeq +11226 -> 16087
    //   4864: aload 23
    //   4866: ifnull +11221 -> 16087
    //   4869: aload 23
    //   4871: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4874: ifnull +11213 -> 16087
    //   4877: aload 23
    //   4879: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4882: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4885: astore 27
    //   4887: aload 31
    //   4889: aload 27
    //   4891: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4894: ldc_w 545
    //   4897: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4900: aload 29
    //   4902: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4905: ldc_w 550
    //   4908: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4911: aload 26
    //   4913: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4916: ldc_w 552
    //   4919: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4922: aconst_null
    //   4923: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4926: ldc_w 554
    //   4929: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4932: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4935: invokevirtual 174	java/lang/Thread:getId	()J
    //   4938: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4941: ldc_w 556
    //   4944: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4947: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4950: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4953: ldc_w 558
    //   4956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4959: aload_0
    //   4960: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   4963: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4966: ldc_w 560
    //   4969: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4972: aload_0
    //   4973: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   4976: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4979: ldc_w 562
    //   4982: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4985: astore 31
    //   4987: aload_0
    //   4988: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   4991: ifeq +11104 -> 16095
    //   4994: aload_0
    //   4995: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4998: aload_0
    //   4999: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5002: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5005: astore 27
    //   5007: aload 31
    //   5009: aload 27
    //   5011: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5014: ldc_w 564
    //   5017: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5020: iload 10
    //   5022: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5025: ldc_w 566
    //   5028: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5031: aload 22
    //   5033: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5036: ldc_w 568
    //   5039: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5042: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5045: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5048: ldc_w 575
    //   5051: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5054: aload_2
    //   5055: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5058: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5061: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5064: ldc_w 580
    //   5067: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5070: aload_2
    //   5071: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5074: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5077: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5080: ldc_w 585
    //   5083: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5086: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5089: aload_0
    //   5090: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5093: lsub
    //   5094: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5097: ldc_w 587
    //   5100: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5103: aload_2
    //   5104: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5107: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5110: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5113: ldc_w 592
    //   5116: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5119: aload_2
    //   5120: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5123: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5126: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5129: ldc_w 596
    //   5132: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5135: aload_2
    //   5136: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5139: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5142: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5145: ldc_w 601
    //   5148: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5151: aload_0
    //   5152: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   5155: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5158: ldc_w 603
    //   5161: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5164: aload_0
    //   5165: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   5168: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5171: ldc_w 608
    //   5174: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5177: aload_2
    //   5178: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5181: invokevirtual 611	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5184: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5187: ldc_w 613
    //   5190: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5193: iload 4
    //   5195: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5198: ldc_w 615
    //   5201: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5204: aload 30
    //   5206: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5209: ldc_w 617
    //   5212: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5215: aload 25
    //   5217: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5220: ldc_w 619
    //   5223: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5226: astore 31
    //   5228: aload_0
    //   5229: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5232: ifnull +10869 -> 16101
    //   5235: aload_0
    //   5236: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5239: iconst_0
    //   5240: bipush 30
    //   5242: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   5245: astore 27
    //   5247: aload 31
    //   5249: aload 27
    //   5251: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5254: ldc_w 625
    //   5257: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5260: astore 27
    //   5262: aload_0
    //   5263: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5266: ifnull +10844 -> 16110
    //   5269: aload_0
    //   5270: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5273: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5276: istore_3
    //   5277: aload 27
    //   5279: iload_3
    //   5280: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5283: ldc_w 627
    //   5286: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5289: aload_2
    //   5290: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5293: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5296: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5299: ldc_w 632
    //   5302: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5305: lload 12
    //   5307: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5310: ldc_w 634
    //   5313: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5316: aload_0
    //   5317: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5320: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5323: ldc_w 603
    //   5326: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5329: aload_0
    //   5330: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   5333: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5336: ldc_w 636
    //   5339: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5342: aload_0
    //   5343: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   5346: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5349: ldc_w 603
    //   5352: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5355: aload_0
    //   5356: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   5359: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5362: ldc_w 638
    //   5365: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5368: aload_0
    //   5369: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   5372: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5375: ldc_w 640
    //   5378: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5381: aload_0
    //   5382: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   5385: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5388: ldc_w 645
    //   5391: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5394: aload_0
    //   5395: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   5398: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5401: ldc_w 650
    //   5404: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5407: astore 31
    //   5409: aload_0
    //   5410: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5413: ifnull +10702 -> 16115
    //   5416: aload_0
    //   5417: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5420: invokeinterface 660 1 0
    //   5425: astore 27
    //   5427: aload 28
    //   5429: aload 31
    //   5431: aload 27
    //   5433: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5436: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5439: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5442: ldc_w 447
    //   5445: aload 28
    //   5447: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5450: aload 21
    //   5452: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5455: aload_0
    //   5456: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5459: ifnull +24 -> 5483
    //   5462: aload_0
    //   5463: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5466: ldc_w 439
    //   5469: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5472: ifeq +11 -> 5483
    //   5475: aload_0
    //   5476: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5479: iconst_0
    //   5480: invokestatic 669	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   5483: iload 10
    //   5485: ifne +8 -> 5493
    //   5488: aload_0
    //   5489: iconst_0
    //   5490: putfield 672	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   5493: aload_2
    //   5494: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5497: astore 27
    //   5499: new 125	java/lang/StringBuilder
    //   5502: dup
    //   5503: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5506: aload_0
    //   5507: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5510: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5513: ldc_w 674
    //   5516: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5519: aload 26
    //   5521: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5524: ldc_w 676
    //   5527: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5530: aload_2
    //   5531: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5534: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5537: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5540: ldc_w 678
    //   5543: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5546: astore 26
    //   5548: aload_0
    //   5549: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5552: ifnull +11217 -> 16769
    //   5555: aload_0
    //   5556: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5559: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5562: istore_3
    //   5563: aload 26
    //   5565: iload_3
    //   5566: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5569: ldc_w 613
    //   5572: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5575: iload 4
    //   5577: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5580: ldc_w 575
    //   5583: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5586: aload_2
    //   5587: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5590: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5593: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5596: ldc_w 587
    //   5599: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5602: aload_2
    //   5603: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5606: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5609: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5612: ldc_w 592
    //   5615: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5618: aload_2
    //   5619: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5622: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5625: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5628: ldc_w 580
    //   5631: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5634: aload_2
    //   5635: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5638: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5641: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5644: ldc_w 585
    //   5647: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5650: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5653: aload_0
    //   5654: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5657: lsub
    //   5658: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5661: astore 26
    //   5663: aload 25
    //   5665: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5668: ifne +11106 -> 16774
    //   5671: new 125	java/lang/StringBuilder
    //   5674: dup
    //   5675: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   5678: ldc_w 617
    //   5681: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5684: aload 25
    //   5686: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5689: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5692: astore 25
    //   5694: aload 27
    //   5696: aload 26
    //   5698: aload 25
    //   5700: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5703: ldc_w 615
    //   5706: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5709: aload 30
    //   5711: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5714: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5717: putfield 681	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   5720: aload_0
    //   5721: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5724: ifnull +56 -> 5780
    //   5727: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5730: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5733: aload_0
    //   5734: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5737: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5740: if_icmpne +40 -> 5780
    //   5743: aload_0
    //   5744: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5747: ifnull +33 -> 5780
    //   5750: aload 22
    //   5752: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5755: ifne +11027 -> 16782
    //   5758: aload_0
    //   5759: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5762: aload_0
    //   5763: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5766: aload 22
    //   5768: aload_2
    //   5769: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5772: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5775: invokeinterface 685 4 0
    //   5780: aload_0
    //   5781: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5784: ifnull +56 -> 5840
    //   5787: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5790: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5793: aload_0
    //   5794: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5797: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5800: if_icmpne +40 -> 5840
    //   5803: aload_0
    //   5804: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5807: ifnull +33 -> 5840
    //   5810: aload 22
    //   5812: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5815: ifne +11012 -> 16827
    //   5818: aload_0
    //   5819: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5822: aload_0
    //   5823: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5826: aload 22
    //   5828: aload_2
    //   5829: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5832: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5835: invokeinterface 685 4 0
    //   5840: iload 10
    //   5842: ifeq +64 -> 5906
    //   5845: aload_0
    //   5846: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5849: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   5852: astore 22
    //   5854: aload_0
    //   5855: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5858: astore 25
    //   5860: aload_0
    //   5861: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5864: ifeq +11008 -> 16872
    //   5867: aload_0
    //   5868: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5871: ifnull +11001 -> 16872
    //   5874: aload_0
    //   5875: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5878: ldc_w 687
    //   5881: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5884: ifeq +10988 -> 16872
    //   5887: iconst_1
    //   5888: istore 10
    //   5890: aload 22
    //   5892: aload 25
    //   5894: iload 10
    //   5896: aload_2
    //   5897: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5900: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5903: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   5906: aload 28
    //   5908: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   5911: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5914: aload 28
    //   5916: aload_0
    //   5917: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   5920: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5923: aload 28
    //   5925: aload 24
    //   5927: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   5930: aload 28
    //   5932: aload 23
    //   5934: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   5937: aload 28
    //   5939: iload 4
    //   5941: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5944: aload 28
    //   5946: aload 21
    //   5948: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5951: aload 29
    //   5953: ifnonnull +10925 -> 16878
    //   5956: aconst_null
    //   5957: astore 21
    //   5959: aload 28
    //   5961: aload 21
    //   5963: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5966: aload 28
    //   5968: aconst_null
    //   5969: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5972: aload 28
    //   5974: aload_2
    //   5975: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5978: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5981: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5984: aload 28
    //   5986: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5989: aload_0
    //   5990: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5993: lsub
    //   5994: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5997: aload 28
    //   5999: aload_2
    //   6000: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6003: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6006: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6009: aload 28
    //   6011: aload 28
    //   6013: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6016: aload_2
    //   6017: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6020: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6023: lsub
    //   6024: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6027: aload 28
    //   6029: lload 12
    //   6031: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6034: aload 28
    //   6036: aload_0
    //   6037: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   6040: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6043: aload 28
    //   6045: aload_0
    //   6046: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   6049: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6052: aload 28
    //   6054: aload_0
    //   6055: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   6058: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   6061: aload 28
    //   6063: lconst_0
    //   6064: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   6067: aload 28
    //   6069: aload_0
    //   6070: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   6073: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6076: aload 28
    //   6078: aload_2
    //   6079: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6082: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6085: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6088: aload 28
    //   6090: aload_0
    //   6091: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6094: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6097: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6100: aload 28
    //   6102: aload_0
    //   6103: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6106: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6109: aload_0
    //   6110: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6113: ifnull +10775 -> 16888
    //   6116: aload_0
    //   6117: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6120: ldc_w 687
    //   6123: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6126: ifeq +10762 -> 16888
    //   6129: iconst_1
    //   6130: istore 10
    //   6132: aload 28
    //   6134: iload 10
    //   6136: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6139: aload 28
    //   6141: aload_2
    //   6142: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6145: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6148: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6151: aload 28
    //   6153: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   6156: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   6159: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   6162: aload 23
    //   6164: ifnull +24 -> 6188
    //   6167: aload 23
    //   6169: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6172: ifnull +16 -> 6188
    //   6175: aload 28
    //   6177: aload 23
    //   6179: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6182: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6185: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   6188: aload_2
    //   6189: aload 28
    //   6191: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6194: aload_2
    //   6195: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6198: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6201: ifeq +11 -> 6212
    //   6204: aload_0
    //   6205: aload_1
    //   6206: aload_2
    //   6207: aload 28
    //   6209: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6212: aload_0
    //   6213: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6216: ifeq +10678 -> 16894
    //   6219: aload_0
    //   6220: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6223: ifnull +12 -> 6235
    //   6226: aload_0
    //   6227: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6230: invokeinterface 792 1 0
    //   6235: aload_0
    //   6236: aconst_null
    //   6237: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   6240: aload 20
    //   6242: athrow
    //   6243: aload_0
    //   6244: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6247: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6250: getfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6253: istore 4
    //   6255: goto -1774 -> 4481
    //   6258: aload 25
    //   6260: astore 20
    //   6262: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6265: iconst_3
    //   6266: if_icmpne -3963 -> 2303
    //   6269: aload 25
    //   6271: astore 20
    //   6273: aload_0
    //   6274: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6277: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6280: getstatic 272	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6283: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6286: if_icmpeq -3983 -> 2303
    //   6289: aload_0
    //   6290: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6293: istore 4
    //   6295: iload 4
    //   6297: ifle +94 -> 6391
    //   6300: aload_0
    //   6301: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6304: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6307: iload 4
    //   6309: putfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6312: iload 4
    //   6314: istore 6
    //   6316: iload 4
    //   6318: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6321: ifne +7 -> 6328
    //   6324: bipush 80
    //   6326: istore 6
    //   6328: new 125	java/lang/StringBuilder
    //   6331: dup
    //   6332: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6335: aload 21
    //   6337: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6340: ldc_w 837
    //   6343: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6346: iload 6
    //   6348: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6351: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6354: astore 21
    //   6356: aload 21
    //   6358: astore 20
    //   6360: aload_0
    //   6361: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6364: ifnull -4061 -> 2303
    //   6367: aload_0
    //   6368: aload_0
    //   6369: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6372: aload_0
    //   6373: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6376: aload 21
    //   6378: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6381: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6384: aload 21
    //   6386: astore 20
    //   6388: goto -4085 -> 2303
    //   6391: aload_0
    //   6392: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6395: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6398: getfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6401: istore 4
    //   6403: goto -91 -> 6312
    //   6406: aload_0
    //   6407: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6410: ifnull -4023 -> 2387
    //   6413: aload_0
    //   6414: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6417: ldc_w 687
    //   6420: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6423: ifeq -4036 -> 2387
    //   6426: iload 5
    //   6428: ifeq -4041 -> 2387
    //   6431: iload 10
    //   6433: ifeq -4046 -> 2387
    //   6436: aload_0
    //   6437: aload_0
    //   6438: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6441: ldc_w 928
    //   6444: ldc_w 930
    //   6447: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6450: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6453: aload_0
    //   6454: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6457: istore 4
    //   6459: iload 4
    //   6461: ifle +167 -> 6628
    //   6464: aload_0
    //   6465: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6468: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6471: iload 4
    //   6473: putfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6476: iload 4
    //   6478: istore 6
    //   6480: iload 4
    //   6482: invokestatic 200	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6485: ifne +7 -> 6492
    //   6488: bipush 80
    //   6490: istore 6
    //   6492: new 125	java/lang/StringBuilder
    //   6495: dup
    //   6496: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6499: ldc_w 924
    //   6502: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6505: ldc_w 932
    //   6508: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6511: ldc_w 926
    //   6514: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6517: iload 6
    //   6519: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6522: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6525: astore 20
    //   6527: aload_0
    //   6528: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6531: ifnull +20 -> 6551
    //   6534: aload_0
    //   6535: aload_0
    //   6536: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6539: aload_0
    //   6540: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6543: aload 20
    //   6545: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6548: putfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6551: aload 28
    //   6553: aload_0
    //   6554: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6557: invokevirtual 137	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   6560: putfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6563: invokestatic 849	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   6566: ifeq -4179 -> 2387
    //   6569: ldc 219
    //   6571: new 125	java/lang/StringBuilder
    //   6574: dup
    //   6575: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6578: ldc_w 851
    //   6581: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6584: aload 28
    //   6586: getfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6589: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6592: ldc_w 934
    //   6595: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6598: aload_0
    //   6599: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   6602: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6605: ldc 225
    //   6607: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6610: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6613: invokevirtual 174	java/lang/Thread:getId	()J
    //   6616: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6619: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6622: invokestatic 392	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6625: goto -4238 -> 2387
    //   6628: aload_0
    //   6629: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6632: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6635: getfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6638: istore 4
    //   6640: goto -164 -> 6476
    //   6643: aload_0
    //   6644: aload_0
    //   6645: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   6648: aload_0
    //   6649: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   6652: aload_0
    //   6653: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6656: aload_0
    //   6657: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6660: aload_0
    //   6661: getfield 819	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   6664: aload 27
    //   6666: invokestatic 938	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   6669: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   6672: goto -4215 -> 2457
    //   6675: aload_0
    //   6676: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   6679: ifnull +10541 -> 17220
    //   6682: aload_0
    //   6683: aload_0
    //   6684: getfield 942	com/tencent/component/network/downloader/impl/FastDownloadTask:pokHttpClient	Lokhttp3/OkHttpClient;
    //   6687: aload_0
    //   6688: getfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   6691: invokevirtual 948	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   6694: invokevirtual 954	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   6697: putfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6700: aload_0
    //   6701: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6704: invokeinterface 957 1 0
    //   6709: astore 20
    //   6711: aconst_null
    //   6712: astore 22
    //   6714: aconst_null
    //   6715: astore 21
    //   6717: goto -4112 -> 2605
    //   6720: aload 20
    //   6722: ifnull +10492 -> 17214
    //   6725: aload 20
    //   6727: invokevirtual 960	okhttp3/Response:code	()I
    //   6730: istore 4
    //   6732: goto -4078 -> 2654
    //   6735: aconst_null
    //   6736: astore 24
    //   6738: goto -3913 -> 2825
    //   6741: astore 22
    //   6743: ldc_w 428
    //   6746: astore 22
    //   6748: goto -3865 -> 2883
    //   6751: ldc_w 962
    //   6754: astore 25
    //   6756: goto -3698 -> 3058
    //   6759: aconst_null
    //   6760: astore 25
    //   6762: goto -3584 -> 3178
    //   6765: aload_0
    //   6766: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6769: astore 25
    //   6771: goto -3353 -> 3418
    //   6774: iconst_0
    //   6775: istore 5
    //   6777: goto -3328 -> 3449
    //   6780: aconst_null
    //   6781: astore 25
    //   6783: goto -3183 -> 3600
    //   6786: new 125	java/lang/StringBuilder
    //   6789: dup
    //   6790: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   6793: ldc_w 964
    //   6796: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6799: aload_0
    //   6800: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   6803: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6806: ldc_w 529
    //   6809: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6812: aload_0
    //   6813: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6816: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6819: ldc_w 534
    //   6822: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6825: astore 29
    //   6827: aload_0
    //   6828: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6831: ifeq +571 -> 7402
    //   6834: aload 20
    //   6836: ifnull +566 -> 7402
    //   6839: aload 20
    //   6841: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6844: ifnull +558 -> 7402
    //   6847: aload 20
    //   6849: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6852: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6855: astore 25
    //   6857: aload 29
    //   6859: aload 25
    //   6861: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6864: ldc_w 545
    //   6867: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6870: aload 26
    //   6872: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6875: ldc_w 550
    //   6878: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6881: aload 24
    //   6883: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6886: ldc_w 552
    //   6889: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6892: aconst_null
    //   6893: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6896: ldc_w 554
    //   6899: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6902: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6905: invokevirtual 174	java/lang/Thread:getId	()J
    //   6908: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6911: ldc_w 556
    //   6914: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6917: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6920: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6923: ldc_w 558
    //   6926: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6929: aload_0
    //   6930: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   6933: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6936: ldc_w 560
    //   6939: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6942: aload_0
    //   6943: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   6946: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6949: ldc_w 562
    //   6952: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6955: astore 29
    //   6957: aload_0
    //   6958: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   6961: ifeq +449 -> 7410
    //   6964: aload_0
    //   6965: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   6968: aload_0
    //   6969: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   6972: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   6975: astore 25
    //   6977: aload 29
    //   6979: aload 25
    //   6981: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6984: ldc_w 568
    //   6987: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6990: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6993: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6996: ldc_w 566
    //   6999: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7002: aload 22
    //   7004: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7007: ldc_w 580
    //   7010: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7013: aload_2
    //   7014: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7017: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7020: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7023: ldc_w 585
    //   7026: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7029: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7032: aload_0
    //   7033: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7036: lsub
    //   7037: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7040: ldc_w 587
    //   7043: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7046: aload_2
    //   7047: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7050: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7053: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7056: ldc_w 592
    //   7059: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7062: aload_2
    //   7063: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7066: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7069: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7072: ldc_w 596
    //   7075: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7078: aload_2
    //   7079: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7082: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7085: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7088: ldc_w 601
    //   7091: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7094: aload_0
    //   7095: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   7098: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7101: ldc_w 603
    //   7104: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7107: aload_0
    //   7108: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   7111: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7114: ldc_w 966
    //   7117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7120: iload 4
    //   7122: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7125: ldc_w 615
    //   7128: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7131: aload 27
    //   7133: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7136: ldc_w 575
    //   7139: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7142: aload_2
    //   7143: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7146: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7149: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7152: ldc_w 617
    //   7155: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7158: aload 23
    //   7160: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7163: ldc_w 619
    //   7166: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7169: astore 29
    //   7171: aload_0
    //   7172: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7175: ifnull +241 -> 7416
    //   7178: aload_0
    //   7179: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7182: iconst_0
    //   7183: bipush 30
    //   7185: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   7188: astore 25
    //   7190: aload 29
    //   7192: aload 25
    //   7194: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7197: ldc_w 625
    //   7200: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7203: astore 25
    //   7205: aload_0
    //   7206: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7209: ifnull +216 -> 7425
    //   7212: aload_0
    //   7213: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7216: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7219: istore 5
    //   7221: aload 25
    //   7223: iload 5
    //   7225: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7228: ldc_w 627
    //   7231: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7234: aload_2
    //   7235: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7238: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7241: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7244: ldc_w 632
    //   7247: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7250: lload 12
    //   7252: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7255: ldc_w 634
    //   7258: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7261: aload_0
    //   7262: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   7265: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7268: ldc_w 603
    //   7271: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7274: aload_0
    //   7275: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   7278: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7281: ldc_w 636
    //   7284: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7287: aload_0
    //   7288: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   7291: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7294: ldc_w 603
    //   7297: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7300: aload_0
    //   7301: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   7304: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7307: ldc_w 638
    //   7310: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7313: aload_0
    //   7314: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   7317: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7320: ldc_w 640
    //   7323: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7326: aload_0
    //   7327: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   7330: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7333: ldc_w 645
    //   7336: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7339: aload_0
    //   7340: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   7343: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7346: ldc_w 650
    //   7349: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7352: astore 29
    //   7354: aload_0
    //   7355: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7358: ifnull +73 -> 7431
    //   7361: aload_0
    //   7362: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7365: invokeinterface 660 1 0
    //   7370: astore 25
    //   7372: aload 28
    //   7374: aload 29
    //   7376: aload 25
    //   7378: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7381: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7384: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7387: ldc_w 447
    //   7390: aload 28
    //   7392: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7395: aconst_null
    //   7396: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7399: goto -3744 -> 3655
    //   7402: ldc_w 962
    //   7405: astore 25
    //   7407: goto -550 -> 6857
    //   7410: aconst_null
    //   7411: astore 25
    //   7413: goto -436 -> 6977
    //   7416: aload_0
    //   7417: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7420: astore 25
    //   7422: goto -232 -> 7190
    //   7425: iconst_0
    //   7426: istore 5
    //   7428: goto -207 -> 7221
    //   7431: aconst_null
    //   7432: astore 25
    //   7434: goto -62 -> 7372
    //   7437: iconst_0
    //   7438: istore 5
    //   7440: goto -3704 -> 3736
    //   7443: ldc_w 428
    //   7446: astore 23
    //   7448: goto -3580 -> 3868
    //   7451: aload_0
    //   7452: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7455: aload_0
    //   7456: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   7459: aload_0
    //   7460: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7463: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   7466: aload_2
    //   7467: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7470: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7473: invokeinterface 685 4 0
    //   7478: goto -3524 -> 3954
    //   7481: astore 23
    //   7483: ldc 219
    //   7485: ldc_w 974
    //   7488: aload 23
    //   7490: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7493: goto -3539 -> 3954
    //   7496: aload_0
    //   7497: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7500: aload_0
    //   7501: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   7504: aload_0
    //   7505: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7508: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   7511: aload_2
    //   7512: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7515: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7518: invokeinterface 685 4 0
    //   7523: goto -3509 -> 4014
    //   7526: astore 22
    //   7528: ldc 219
    //   7530: ldc_w 976
    //   7533: aload 22
    //   7535: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7538: goto -3524 -> 4014
    //   7541: iconst_0
    //   7542: istore 10
    //   7544: goto -3480 -> 4064
    //   7547: aload 26
    //   7549: invokevirtual 979	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7552: astore 21
    //   7554: goto -3422 -> 4132
    //   7557: iconst_0
    //   7558: istore 10
    //   7560: goto -3255 -> 4305
    //   7563: aload_0
    //   7564: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7567: ifnull +15 -> 7582
    //   7570: aload_0
    //   7571: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7574: invokevirtual 984	org/apache/http/client/methods/HttpGet:abort	()V
    //   7577: aload_0
    //   7578: aconst_null
    //   7579: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7582: aload_0
    //   7583: invokevirtual 987	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   7586: goto -3173 -> 4413
    //   7589: aload_2
    //   7590: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7593: lload 14
    //   7595: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7598: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   7601: aload_2
    //   7602: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7605: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7608: aload_0
    //   7609: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7612: lsub
    //   7613: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   7616: aload_2
    //   7617: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7620: aload_0
    //   7621: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   7624: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   7627: aload_0
    //   7628: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7631: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   7634: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   7637: astore 26
    //   7639: aload_0
    //   7640: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7643: ifnull +1610 -> 9253
    //   7646: aload_0
    //   7647: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7650: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7653: ifnull +1600 -> 9253
    //   7656: aload_0
    //   7657: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7660: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7663: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   7666: astore 24
    //   7668: aload_0
    //   7669: aload_0
    //   7670: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7673: aload 21
    //   7675: aload 20
    //   7677: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   7680: astore 27
    //   7682: ldc_w 428
    //   7685: astore 23
    //   7687: aload 22
    //   7689: ifnull +9499 -> 17188
    //   7692: aload 22
    //   7694: ldc_w 492
    //   7697: invokeinterface 498 2 0
    //   7702: checkcast 282	java/lang/String
    //   7705: astore 25
    //   7707: aload 25
    //   7709: astore 23
    //   7711: aload 22
    //   7713: ldc_w 500
    //   7716: invokeinterface 498 2 0
    //   7721: checkcast 282	java/lang/String
    //   7724: astore 22
    //   7726: aload_2
    //   7727: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7730: aload 23
    //   7732: putfield 509	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   7735: aload_0
    //   7736: lconst_0
    //   7737: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   7740: aload_0
    //   7741: iconst_0
    //   7742: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   7745: aload_0
    //   7746: lconst_0
    //   7747: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   7750: aload_0
    //   7751: iconst_0
    //   7752: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   7755: aload_2
    //   7756: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7759: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7762: ifeq +12 -> 7774
    //   7765: aload_1
    //   7766: invokeinterface 359 1 0
    //   7771: ifeq +31 -> 7802
    //   7774: aload_0
    //   7775: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   7778: ifnull +24 -> 7802
    //   7781: aload_0
    //   7782: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   7785: aload_0
    //   7786: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7789: aload_2
    //   7790: invokevirtual 519	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   7793: aload 21
    //   7795: aload 20
    //   7797: invokeinterface 525 5 0
    //   7802: aload_1
    //   7803: invokeinterface 359 1 0
    //   7808: ifne +1416 -> 9224
    //   7811: aload_0
    //   7812: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7815: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   7818: istore 10
    //   7820: aload_2
    //   7821: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7824: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7827: ifne +1476 -> 9303
    //   7830: new 125	java/lang/StringBuilder
    //   7833: dup
    //   7834: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   7837: ldc_w 527
    //   7840: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7843: aload_0
    //   7844: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7847: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7850: ldc_w 529
    //   7853: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7856: aload_0
    //   7857: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7860: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7863: ldc_w 534
    //   7866: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7869: astore 29
    //   7871: aload_0
    //   7872: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7875: ifeq +1394 -> 9269
    //   7878: aload 20
    //   7880: ifnull +1389 -> 9269
    //   7883: aload 20
    //   7885: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7888: ifnull +1381 -> 9269
    //   7891: aload 20
    //   7893: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7896: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7899: astore 25
    //   7901: aload 29
    //   7903: aload 25
    //   7905: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7908: ldc_w 545
    //   7911: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7914: aload 26
    //   7916: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7919: ldc_w 550
    //   7922: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7925: aload 24
    //   7927: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7930: ldc_w 552
    //   7933: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7936: aconst_null
    //   7937: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7940: ldc_w 554
    //   7943: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7946: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7949: invokevirtual 174	java/lang/Thread:getId	()J
    //   7952: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7955: ldc_w 556
    //   7958: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7961: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7964: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7967: ldc_w 558
    //   7970: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7973: aload_0
    //   7974: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7977: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7980: ldc_w 560
    //   7983: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7986: aload_0
    //   7987: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7990: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7993: ldc_w 562
    //   7996: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7999: astore 29
    //   8001: aload_0
    //   8002: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8005: ifeq +1272 -> 9277
    //   8008: aload_0
    //   8009: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8012: aload_0
    //   8013: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8016: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8019: astore 25
    //   8021: aload 29
    //   8023: aload 25
    //   8025: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8028: ldc_w 564
    //   8031: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8034: iload 10
    //   8036: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8039: ldc_w 566
    //   8042: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8045: aload 22
    //   8047: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8050: ldc_w 568
    //   8053: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8056: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8059: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8062: ldc_w 575
    //   8065: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8068: aload_2
    //   8069: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8072: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8075: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8078: ldc_w 580
    //   8081: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8084: aload_2
    //   8085: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8088: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8091: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8094: ldc_w 585
    //   8097: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8100: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8103: aload_0
    //   8104: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8107: lsub
    //   8108: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8111: ldc_w 587
    //   8114: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8117: aload_2
    //   8118: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8121: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8124: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8127: ldc_w 592
    //   8130: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8133: aload_2
    //   8134: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8137: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8140: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8143: ldc_w 596
    //   8146: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8149: aload_2
    //   8150: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8153: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8156: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8159: ldc_w 601
    //   8162: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8165: aload_0
    //   8166: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   8169: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8172: ldc_w 603
    //   8175: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8178: aload_0
    //   8179: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   8182: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8185: ldc_w 608
    //   8188: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8191: aload_2
    //   8192: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8195: invokevirtual 611	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8198: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8201: ldc_w 613
    //   8204: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8207: iload 4
    //   8209: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8212: ldc_w 615
    //   8215: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8218: aload 27
    //   8220: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8223: ldc_w 617
    //   8226: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8229: aload 23
    //   8231: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8234: ldc_w 619
    //   8237: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8240: astore 29
    //   8242: aload_0
    //   8243: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8246: ifnull +1037 -> 9283
    //   8249: aload_0
    //   8250: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8253: iconst_0
    //   8254: bipush 30
    //   8256: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   8259: astore 25
    //   8261: aload 29
    //   8263: aload 25
    //   8265: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8268: ldc_w 625
    //   8271: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8274: astore 25
    //   8276: aload_0
    //   8277: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8280: ifnull +1012 -> 9292
    //   8283: aload_0
    //   8284: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8287: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8290: istore_3
    //   8291: aload 25
    //   8293: iload_3
    //   8294: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8297: ldc_w 627
    //   8300: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8303: aload_2
    //   8304: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8307: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8310: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8313: ldc_w 632
    //   8316: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8319: lload 12
    //   8321: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8324: ldc_w 634
    //   8327: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8330: aload_0
    //   8331: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8334: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8337: ldc_w 603
    //   8340: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8343: aload_0
    //   8344: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8347: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8350: ldc_w 636
    //   8353: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8356: aload_0
    //   8357: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8360: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8363: ldc_w 603
    //   8366: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8369: aload_0
    //   8370: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8373: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8376: ldc_w 638
    //   8379: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8382: aload_0
    //   8383: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   8386: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8389: ldc_w 640
    //   8392: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8395: aload_0
    //   8396: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   8399: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8402: ldc_w 645
    //   8405: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8408: aload_0
    //   8409: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   8412: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8415: ldc_w 650
    //   8418: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8421: astore 29
    //   8423: aload_0
    //   8424: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8427: ifnull +870 -> 9297
    //   8430: aload_0
    //   8431: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8434: invokeinterface 660 1 0
    //   8439: astore 25
    //   8441: aload 28
    //   8443: aload 29
    //   8445: aload 25
    //   8447: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8450: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8453: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8456: ldc_w 447
    //   8459: aload 28
    //   8461: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8464: aconst_null
    //   8465: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8468: aload_0
    //   8469: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8472: ifnull +24 -> 8496
    //   8475: aload_0
    //   8476: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8479: ldc_w 439
    //   8482: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8485: ifeq +11 -> 8496
    //   8488: aload_0
    //   8489: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8492: iconst_0
    //   8493: invokestatic 669	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   8496: iload 10
    //   8498: ifne +8 -> 8506
    //   8501: aload_0
    //   8502: iconst_0
    //   8503: putfield 672	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   8506: aload_2
    //   8507: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8510: astore 25
    //   8512: new 125	java/lang/StringBuilder
    //   8515: dup
    //   8516: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8519: aload_0
    //   8520: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8523: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8526: ldc_w 674
    //   8529: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8532: aload 24
    //   8534: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8537: ldc_w 676
    //   8540: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8543: aload_2
    //   8544: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8547: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8550: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8553: ldc_w 678
    //   8556: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8559: astore 24
    //   8561: aload_0
    //   8562: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8565: ifnull +1386 -> 9951
    //   8568: aload_0
    //   8569: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8572: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8575: istore_3
    //   8576: aload 24
    //   8578: iload_3
    //   8579: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8582: ldc_w 613
    //   8585: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8588: iload 4
    //   8590: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8593: ldc_w 575
    //   8596: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8599: aload_2
    //   8600: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8603: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8606: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8609: ldc_w 587
    //   8612: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8615: aload_2
    //   8616: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8619: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8622: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8625: ldc_w 592
    //   8628: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8631: aload_2
    //   8632: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8635: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8638: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8641: ldc_w 580
    //   8644: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8647: aload_2
    //   8648: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8651: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8654: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8657: ldc_w 585
    //   8660: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8663: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8666: aload_0
    //   8667: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8670: lsub
    //   8671: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8674: astore 24
    //   8676: aload 23
    //   8678: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8681: ifne +1275 -> 9956
    //   8684: new 125	java/lang/StringBuilder
    //   8687: dup
    //   8688: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   8691: ldc_w 617
    //   8694: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8697: aload 23
    //   8699: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8702: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8705: astore 23
    //   8707: aload 25
    //   8709: aload 24
    //   8711: aload 23
    //   8713: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8716: ldc_w 615
    //   8719: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8722: aload 27
    //   8724: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8727: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8730: putfield 681	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   8733: aload_0
    //   8734: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8737: ifnull +56 -> 8793
    //   8740: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8743: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8746: aload_0
    //   8747: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8750: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8753: if_icmpne +40 -> 8793
    //   8756: aload_0
    //   8757: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8760: ifnull +33 -> 8793
    //   8763: aload 22
    //   8765: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8768: ifne +1196 -> 9964
    //   8771: aload_0
    //   8772: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8775: aload_0
    //   8776: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8779: aload 22
    //   8781: aload_2
    //   8782: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8785: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8788: invokeinterface 685 4 0
    //   8793: aload_0
    //   8794: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8797: ifnull +56 -> 8853
    //   8800: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8803: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8806: aload_0
    //   8807: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8810: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8813: if_icmpne +40 -> 8853
    //   8816: aload_0
    //   8817: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8820: ifnull +33 -> 8853
    //   8823: aload 22
    //   8825: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8828: ifne +1181 -> 10009
    //   8831: aload_0
    //   8832: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8835: aload_0
    //   8836: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8839: aload 22
    //   8841: aload_2
    //   8842: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8845: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8848: invokeinterface 685 4 0
    //   8853: iload 10
    //   8855: ifeq +64 -> 8919
    //   8858: aload_0
    //   8859: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8862: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   8865: astore 22
    //   8867: aload_0
    //   8868: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8871: astore 23
    //   8873: aload_0
    //   8874: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8877: ifeq +1177 -> 10054
    //   8880: aload_0
    //   8881: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8884: ifnull +1170 -> 10054
    //   8887: aload_0
    //   8888: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8891: ldc_w 687
    //   8894: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8897: ifeq +1157 -> 10054
    //   8900: iconst_1
    //   8901: istore 10
    //   8903: aload 22
    //   8905: aload 23
    //   8907: iload 10
    //   8909: aload_2
    //   8910: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8913: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8916: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   8919: aload 28
    //   8921: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   8924: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   8927: aload 28
    //   8929: aload_0
    //   8930: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   8933: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   8936: aload 28
    //   8938: aload 21
    //   8940: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   8943: aload 28
    //   8945: aload 20
    //   8947: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   8950: aload 28
    //   8952: iload 4
    //   8954: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   8957: aload 28
    //   8959: aconst_null
    //   8960: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   8963: aload 26
    //   8965: ifnonnull +1095 -> 10060
    //   8968: aconst_null
    //   8969: astore 21
    //   8971: aload 28
    //   8973: aload 21
    //   8975: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   8978: aload 28
    //   8980: aconst_null
    //   8981: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   8984: aload 28
    //   8986: aload_2
    //   8987: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8990: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8993: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   8996: aload 28
    //   8998: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9001: aload_0
    //   9002: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9005: lsub
    //   9006: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9009: aload 28
    //   9011: aload_2
    //   9012: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9015: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9018: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9021: aload 28
    //   9023: aload 28
    //   9025: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9028: aload_2
    //   9029: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9032: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9035: lsub
    //   9036: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9039: aload 28
    //   9041: lload 12
    //   9043: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9046: aload 28
    //   9048: aload_0
    //   9049: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9052: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9055: aload 28
    //   9057: aload_0
    //   9058: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   9061: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9064: aload 28
    //   9066: aload_0
    //   9067: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   9070: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9073: aload 28
    //   9075: lconst_0
    //   9076: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9079: aload 28
    //   9081: aload_0
    //   9082: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   9085: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9088: aload 28
    //   9090: aload_2
    //   9091: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9094: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9097: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9100: aload 28
    //   9102: aload_0
    //   9103: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9106: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9109: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9112: aload 28
    //   9114: aload_0
    //   9115: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9118: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9121: aload_0
    //   9122: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9125: ifnull +945 -> 10070
    //   9128: aload_0
    //   9129: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9132: ldc_w 687
    //   9135: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9138: ifeq +932 -> 10070
    //   9141: iconst_1
    //   9142: istore 10
    //   9144: aload 28
    //   9146: iload 10
    //   9148: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9151: aload 28
    //   9153: aload_2
    //   9154: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9157: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9160: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9163: aload 28
    //   9165: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   9168: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   9171: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   9174: aload 20
    //   9176: ifnull +24 -> 9200
    //   9179: aload 20
    //   9181: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9184: ifnull +16 -> 9200
    //   9187: aload 28
    //   9189: aload 20
    //   9191: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9194: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9197: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   9200: aload_2
    //   9201: aload 28
    //   9203: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9206: aload_2
    //   9207: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9210: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9213: ifeq +11 -> 9224
    //   9216: aload_0
    //   9217: aload_1
    //   9218: aload_2
    //   9219: aload 28
    //   9221: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9224: aload_0
    //   9225: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9228: ifeq +848 -> 10076
    //   9231: aload_0
    //   9232: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   9235: ifnull +12 -> 9247
    //   9238: aload_0
    //   9239: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   9242: invokeinterface 792 1 0
    //   9247: aload_0
    //   9248: aconst_null
    //   9249: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   9252: return
    //   9253: aconst_null
    //   9254: astore 24
    //   9256: goto -1588 -> 7668
    //   9259: astore 22
    //   9261: ldc_w 428
    //   9264: astore 22
    //   9266: goto -1540 -> 7726
    //   9269: ldc_w 962
    //   9272: astore 25
    //   9274: goto -1373 -> 7901
    //   9277: aconst_null
    //   9278: astore 25
    //   9280: goto -1259 -> 8021
    //   9283: aload_0
    //   9284: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9287: astore 25
    //   9289: goto -1028 -> 8261
    //   9292: iconst_0
    //   9293: istore_3
    //   9294: goto -1003 -> 8291
    //   9297: aconst_null
    //   9298: astore 25
    //   9300: goto -859 -> 8441
    //   9303: new 125	java/lang/StringBuilder
    //   9306: dup
    //   9307: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   9310: ldc_w 964
    //   9313: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9316: aload_0
    //   9317: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   9320: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9323: ldc_w 529
    //   9326: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9329: aload_0
    //   9330: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9333: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9336: ldc_w 534
    //   9339: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9342: astore 29
    //   9344: aload_0
    //   9345: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9348: ifeq +569 -> 9917
    //   9351: aload 20
    //   9353: ifnull +564 -> 9917
    //   9356: aload 20
    //   9358: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9361: ifnull +556 -> 9917
    //   9364: aload 20
    //   9366: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9369: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9372: astore 25
    //   9374: aload 29
    //   9376: aload 25
    //   9378: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9381: ldc_w 545
    //   9384: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9387: aload 26
    //   9389: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9392: ldc_w 550
    //   9395: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9398: aload 24
    //   9400: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9403: ldc_w 552
    //   9406: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9409: aconst_null
    //   9410: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9413: ldc_w 554
    //   9416: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9419: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9422: invokevirtual 174	java/lang/Thread:getId	()J
    //   9425: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9428: ldc_w 556
    //   9431: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9434: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9437: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9440: ldc_w 558
    //   9443: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9446: aload_0
    //   9447: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9450: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9453: ldc_w 560
    //   9456: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9459: aload_0
    //   9460: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9463: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9466: ldc_w 562
    //   9469: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9472: astore 29
    //   9474: aload_0
    //   9475: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9478: ifeq +447 -> 9925
    //   9481: aload_0
    //   9482: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9485: aload_0
    //   9486: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9489: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9492: astore 25
    //   9494: aload 29
    //   9496: aload 25
    //   9498: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9501: ldc_w 568
    //   9504: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9507: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9510: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9513: ldc_w 566
    //   9516: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9519: aload 22
    //   9521: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9524: ldc_w 580
    //   9527: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9530: aload_2
    //   9531: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9534: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9537: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9540: ldc_w 585
    //   9543: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9546: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9549: aload_0
    //   9550: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9553: lsub
    //   9554: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9557: ldc_w 587
    //   9560: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9563: aload_2
    //   9564: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9567: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9570: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9573: ldc_w 592
    //   9576: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9579: aload_2
    //   9580: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9583: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9586: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9589: ldc_w 596
    //   9592: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9595: aload_2
    //   9596: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9599: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9602: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9605: ldc_w 601
    //   9608: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9611: aload_0
    //   9612: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   9615: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9618: ldc_w 603
    //   9621: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9624: aload_0
    //   9625: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   9628: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9631: ldc_w 966
    //   9634: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9637: iload 4
    //   9639: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9642: ldc_w 615
    //   9645: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9648: aload 27
    //   9650: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9653: ldc_w 575
    //   9656: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9659: aload_2
    //   9660: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9663: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9666: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9669: ldc_w 617
    //   9672: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9675: aload 23
    //   9677: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9680: ldc_w 619
    //   9683: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9686: astore 29
    //   9688: aload_0
    //   9689: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9692: ifnull +239 -> 9931
    //   9695: aload_0
    //   9696: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9699: iconst_0
    //   9700: bipush 30
    //   9702: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   9705: astore 25
    //   9707: aload 29
    //   9709: aload 25
    //   9711: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9714: ldc_w 625
    //   9717: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9720: astore 25
    //   9722: aload_0
    //   9723: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9726: ifnull +214 -> 9940
    //   9729: aload_0
    //   9730: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9733: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9736: istore_3
    //   9737: aload 25
    //   9739: iload_3
    //   9740: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9743: ldc_w 627
    //   9746: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9749: aload_2
    //   9750: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9753: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9756: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9759: ldc_w 632
    //   9762: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9765: lload 12
    //   9767: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9770: ldc_w 634
    //   9773: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9776: aload_0
    //   9777: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9780: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9783: ldc_w 603
    //   9786: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9789: aload_0
    //   9790: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   9793: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9796: ldc_w 636
    //   9799: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9802: aload_0
    //   9803: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   9806: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9809: ldc_w 603
    //   9812: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9815: aload_0
    //   9816: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   9819: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9822: ldc_w 638
    //   9825: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9828: aload_0
    //   9829: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   9832: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9835: ldc_w 640
    //   9838: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9841: aload_0
    //   9842: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   9845: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9848: ldc_w 645
    //   9851: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9854: aload_0
    //   9855: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   9858: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9861: ldc_w 650
    //   9864: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9867: astore 29
    //   9869: aload_0
    //   9870: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9873: ifnull +72 -> 9945
    //   9876: aload_0
    //   9877: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9880: invokeinterface 660 1 0
    //   9885: astore 25
    //   9887: aload 28
    //   9889: aload 29
    //   9891: aload 25
    //   9893: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9896: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9899: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9902: ldc_w 447
    //   9905: aload 28
    //   9907: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9910: aconst_null
    //   9911: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9914: goto -1418 -> 8496
    //   9917: ldc_w 962
    //   9920: astore 25
    //   9922: goto -548 -> 9374
    //   9925: aconst_null
    //   9926: astore 25
    //   9928: goto -434 -> 9494
    //   9931: aload_0
    //   9932: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9935: astore 25
    //   9937: goto -230 -> 9707
    //   9940: iconst_0
    //   9941: istore_3
    //   9942: goto -205 -> 9737
    //   9945: aconst_null
    //   9946: astore 25
    //   9948: goto -61 -> 9887
    //   9951: iconst_0
    //   9952: istore_3
    //   9953: goto -1377 -> 8576
    //   9956: ldc_w 428
    //   9959: astore 23
    //   9961: goto -1254 -> 8707
    //   9964: aload_0
    //   9965: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9968: aload_0
    //   9969: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9972: aload_0
    //   9973: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9976: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9979: aload_2
    //   9980: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9983: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9986: invokeinterface 685 4 0
    //   9991: goto -1198 -> 8793
    //   9994: astore 23
    //   9996: ldc 219
    //   9998: ldc_w 974
    //   10001: aload 23
    //   10003: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10006: goto -1213 -> 8793
    //   10009: aload_0
    //   10010: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10013: aload_0
    //   10014: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   10017: aload_0
    //   10018: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10021: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   10024: aload_2
    //   10025: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10028: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10031: invokeinterface 685 4 0
    //   10036: goto -1183 -> 8853
    //   10039: astore 22
    //   10041: ldc 219
    //   10043: ldc_w 976
    //   10046: aload 22
    //   10048: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10051: goto -1198 -> 8853
    //   10054: iconst_0
    //   10055: istore 10
    //   10057: goto -1154 -> 8903
    //   10060: aload 26
    //   10062: invokevirtual 979	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10065: astore 21
    //   10067: goto -1096 -> 8971
    //   10070: iconst_0
    //   10071: istore 10
    //   10073: goto -929 -> 9144
    //   10076: aload_0
    //   10077: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10080: ifnull +15 -> 10095
    //   10083: aload_0
    //   10084: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10087: invokevirtual 984	org/apache/http/client/methods/HttpGet:abort	()V
    //   10090: aload_0
    //   10091: aconst_null
    //   10092: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10095: aload_0
    //   10096: invokevirtual 987	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   10099: return
    //   10100: aload_2
    //   10101: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10104: lload 14
    //   10106: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10109: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   10112: aload_2
    //   10113: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10116: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10119: aload_0
    //   10120: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10123: lsub
    //   10124: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   10127: aload_2
    //   10128: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10131: aload_0
    //   10132: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   10135: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   10138: aload_0
    //   10139: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10142: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   10145: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   10148: astore 26
    //   10150: aload_0
    //   10151: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10154: ifnull +1610 -> 11764
    //   10157: aload_0
    //   10158: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10161: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10164: ifnull +1600 -> 11764
    //   10167: aload_0
    //   10168: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10171: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10174: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   10177: astore 24
    //   10179: aload_0
    //   10180: aload_0
    //   10181: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10184: aload 21
    //   10186: aload 20
    //   10188: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   10191: astore 27
    //   10193: ldc_w 428
    //   10196: astore 23
    //   10198: aload 22
    //   10200: ifnull +6975 -> 17175
    //   10203: aload 22
    //   10205: ldc_w 492
    //   10208: invokeinterface 498 2 0
    //   10213: checkcast 282	java/lang/String
    //   10216: astore 25
    //   10218: aload 25
    //   10220: astore 23
    //   10222: aload 22
    //   10224: ldc_w 500
    //   10227: invokeinterface 498 2 0
    //   10232: checkcast 282	java/lang/String
    //   10235: astore 22
    //   10237: aload_2
    //   10238: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10241: aload 23
    //   10243: putfield 509	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   10246: aload_0
    //   10247: lconst_0
    //   10248: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10251: aload_0
    //   10252: iconst_0
    //   10253: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10256: aload_0
    //   10257: lconst_0
    //   10258: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10261: aload_0
    //   10262: iconst_0
    //   10263: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10266: aload_2
    //   10267: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10270: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10273: ifeq +12 -> 10285
    //   10276: aload_1
    //   10277: invokeinterface 359 1 0
    //   10282: ifeq +31 -> 10313
    //   10285: aload_0
    //   10286: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10289: ifnull +24 -> 10313
    //   10292: aload_0
    //   10293: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10296: aload_0
    //   10297: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10300: aload_2
    //   10301: invokevirtual 519	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   10304: aload 21
    //   10306: aload 20
    //   10308: invokeinterface 525 5 0
    //   10313: aload_1
    //   10314: invokeinterface 359 1 0
    //   10319: ifne +1416 -> 11735
    //   10322: aload_0
    //   10323: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10326: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10329: istore 10
    //   10331: aload_2
    //   10332: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10335: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10338: ifne +1476 -> 11814
    //   10341: new 125	java/lang/StringBuilder
    //   10344: dup
    //   10345: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   10348: ldc_w 527
    //   10351: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10354: aload_0
    //   10355: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10358: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10361: ldc_w 529
    //   10364: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10367: aload_0
    //   10368: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10371: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10374: ldc_w 534
    //   10377: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10380: astore 29
    //   10382: aload_0
    //   10383: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10386: ifeq +1394 -> 11780
    //   10389: aload 20
    //   10391: ifnull +1389 -> 11780
    //   10394: aload 20
    //   10396: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10399: ifnull +1381 -> 11780
    //   10402: aload 20
    //   10404: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10407: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   10410: astore 25
    //   10412: aload 29
    //   10414: aload 25
    //   10416: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10419: ldc_w 545
    //   10422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10425: aload 26
    //   10427: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10430: ldc_w 550
    //   10433: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10436: aload 24
    //   10438: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10441: ldc_w 552
    //   10444: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10447: aconst_null
    //   10448: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10451: ldc_w 554
    //   10454: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10457: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10460: invokevirtual 174	java/lang/Thread:getId	()J
    //   10463: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10466: ldc_w 556
    //   10469: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10472: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10475: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10478: ldc_w 558
    //   10481: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10484: aload_0
    //   10485: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10488: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10491: ldc_w 560
    //   10494: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10497: aload_0
    //   10498: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10501: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10504: ldc_w 562
    //   10507: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10510: astore 29
    //   10512: aload_0
    //   10513: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10516: ifeq +1272 -> 11788
    //   10519: aload_0
    //   10520: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10523: aload_0
    //   10524: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10527: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10530: astore 25
    //   10532: aload 29
    //   10534: aload 25
    //   10536: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10539: ldc_w 564
    //   10542: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10545: iload 10
    //   10547: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10550: ldc_w 566
    //   10553: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10556: aload 22
    //   10558: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10561: ldc_w 568
    //   10564: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10567: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10570: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10573: ldc_w 575
    //   10576: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10579: aload_2
    //   10580: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10583: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10586: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10589: ldc_w 580
    //   10592: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10595: aload_2
    //   10596: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10599: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10602: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10605: ldc_w 585
    //   10608: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10611: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10614: aload_0
    //   10615: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10618: lsub
    //   10619: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10622: ldc_w 587
    //   10625: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10628: aload_2
    //   10629: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10632: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10635: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10638: ldc_w 592
    //   10641: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10644: aload_2
    //   10645: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10648: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10651: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10654: ldc_w 596
    //   10657: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10660: aload_2
    //   10661: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10664: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10667: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10670: ldc_w 601
    //   10673: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10676: aload_0
    //   10677: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   10680: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10683: ldc_w 603
    //   10686: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10689: aload_0
    //   10690: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   10693: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10696: ldc_w 608
    //   10699: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10702: aload_2
    //   10703: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10706: invokevirtual 611	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   10709: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10712: ldc_w 613
    //   10715: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10718: iload 4
    //   10720: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10723: ldc_w 615
    //   10726: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10729: aload 27
    //   10731: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10734: ldc_w 617
    //   10737: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10740: aload 23
    //   10742: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10745: ldc_w 619
    //   10748: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10751: astore 29
    //   10753: aload_0
    //   10754: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10757: ifnull +1037 -> 11794
    //   10760: aload_0
    //   10761: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10764: iconst_0
    //   10765: bipush 30
    //   10767: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   10770: astore 25
    //   10772: aload 29
    //   10774: aload 25
    //   10776: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10779: ldc_w 625
    //   10782: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10785: astore 25
    //   10787: aload_0
    //   10788: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10791: ifnull +1012 -> 11803
    //   10794: aload_0
    //   10795: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10798: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10801: istore_3
    //   10802: aload 25
    //   10804: iload_3
    //   10805: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10808: ldc_w 627
    //   10811: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10814: aload_2
    //   10815: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10818: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10821: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10824: ldc_w 632
    //   10827: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10830: lload 12
    //   10832: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10835: ldc_w 634
    //   10838: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10841: aload_0
    //   10842: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10845: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10848: ldc_w 603
    //   10851: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10854: aload_0
    //   10855: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10858: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10861: ldc_w 636
    //   10864: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10867: aload_0
    //   10868: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10871: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10874: ldc_w 603
    //   10877: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10880: aload_0
    //   10881: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10884: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10887: ldc_w 638
    //   10890: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10893: aload_0
    //   10894: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   10897: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10900: ldc_w 640
    //   10903: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10906: aload_0
    //   10907: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   10910: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10913: ldc_w 645
    //   10916: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10919: aload_0
    //   10920: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   10923: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10926: ldc_w 650
    //   10929: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10932: astore 29
    //   10934: aload_0
    //   10935: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10938: ifnull +870 -> 11808
    //   10941: aload_0
    //   10942: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10945: invokeinterface 660 1 0
    //   10950: astore 25
    //   10952: aload 28
    //   10954: aload 29
    //   10956: aload 25
    //   10958: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10961: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10964: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10967: ldc_w 447
    //   10970: aload 28
    //   10972: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10975: aconst_null
    //   10976: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10979: aload_0
    //   10980: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10983: ifnull +24 -> 11007
    //   10986: aload_0
    //   10987: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10990: ldc_w 439
    //   10993: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10996: ifeq +11 -> 11007
    //   10999: aload_0
    //   11000: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11003: iconst_0
    //   11004: invokestatic 669	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   11007: iload 10
    //   11009: ifne +8 -> 11017
    //   11012: aload_0
    //   11013: iconst_0
    //   11014: putfield 672	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   11017: aload_2
    //   11018: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11021: astore 25
    //   11023: new 125	java/lang/StringBuilder
    //   11026: dup
    //   11027: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11030: aload_0
    //   11031: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11034: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11037: ldc_w 674
    //   11040: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11043: aload 24
    //   11045: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11048: ldc_w 676
    //   11051: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11054: aload_2
    //   11055: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11058: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11061: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11064: ldc_w 678
    //   11067: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11070: astore 24
    //   11072: aload_0
    //   11073: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11076: ifnull +1386 -> 12462
    //   11079: aload_0
    //   11080: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11083: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11086: istore_3
    //   11087: aload 24
    //   11089: iload_3
    //   11090: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11093: ldc_w 613
    //   11096: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11099: iload 4
    //   11101: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11104: ldc_w 575
    //   11107: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11110: aload_2
    //   11111: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11114: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11120: ldc_w 587
    //   11123: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11126: aload_2
    //   11127: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11130: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11133: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11136: ldc_w 592
    //   11139: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11142: aload_2
    //   11143: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11146: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11149: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11152: ldc_w 580
    //   11155: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11158: aload_2
    //   11159: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11162: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11165: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11168: ldc_w 585
    //   11171: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11174: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11177: aload_0
    //   11178: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11181: lsub
    //   11182: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11185: astore 24
    //   11187: aload 23
    //   11189: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11192: ifne +1275 -> 12467
    //   11195: new 125	java/lang/StringBuilder
    //   11198: dup
    //   11199: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11202: ldc_w 617
    //   11205: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11208: aload 23
    //   11210: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11213: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11216: astore 23
    //   11218: aload 25
    //   11220: aload 24
    //   11222: aload 23
    //   11224: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11227: ldc_w 615
    //   11230: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11233: aload 27
    //   11235: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11238: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11241: putfield 681	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   11244: aload_0
    //   11245: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11248: ifnull +56 -> 11304
    //   11251: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11254: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11257: aload_0
    //   11258: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11261: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11264: if_icmpne +40 -> 11304
    //   11267: aload_0
    //   11268: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11271: ifnull +33 -> 11304
    //   11274: aload 22
    //   11276: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11279: ifne +1196 -> 12475
    //   11282: aload_0
    //   11283: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11286: aload_0
    //   11287: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11290: aload 22
    //   11292: aload_2
    //   11293: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11296: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11299: invokeinterface 685 4 0
    //   11304: aload_0
    //   11305: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11308: ifnull +56 -> 11364
    //   11311: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11314: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11317: aload_0
    //   11318: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11321: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11324: if_icmpne +40 -> 11364
    //   11327: aload_0
    //   11328: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11331: ifnull +33 -> 11364
    //   11334: aload 22
    //   11336: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11339: ifne +1181 -> 12520
    //   11342: aload_0
    //   11343: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11346: aload_0
    //   11347: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11350: aload 22
    //   11352: aload_2
    //   11353: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11356: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11359: invokeinterface 685 4 0
    //   11364: iload 10
    //   11366: ifeq +64 -> 11430
    //   11369: aload_0
    //   11370: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11373: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   11376: astore 22
    //   11378: aload_0
    //   11379: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11382: astore 23
    //   11384: aload_0
    //   11385: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11388: ifeq +1177 -> 12565
    //   11391: aload_0
    //   11392: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11395: ifnull +1170 -> 12565
    //   11398: aload_0
    //   11399: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11402: ldc_w 687
    //   11405: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11408: ifeq +1157 -> 12565
    //   11411: iconst_1
    //   11412: istore 10
    //   11414: aload 22
    //   11416: aload 23
    //   11418: iload 10
    //   11420: aload_2
    //   11421: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11424: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11427: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   11430: aload 28
    //   11432: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   11435: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   11438: aload 28
    //   11440: aload_0
    //   11441: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   11444: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   11447: aload 28
    //   11449: aload 21
    //   11451: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   11454: aload 28
    //   11456: aload 20
    //   11458: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   11461: aload 28
    //   11463: iload 4
    //   11465: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   11468: aload 28
    //   11470: aconst_null
    //   11471: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   11474: aload 26
    //   11476: ifnonnull +1095 -> 12571
    //   11479: aconst_null
    //   11480: astore 21
    //   11482: aload 28
    //   11484: aload 21
    //   11486: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   11489: aload 28
    //   11491: aconst_null
    //   11492: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   11495: aload 28
    //   11497: aload_2
    //   11498: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11501: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11504: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   11507: aload 28
    //   11509: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11512: aload_0
    //   11513: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11516: lsub
    //   11517: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11520: aload 28
    //   11522: aload_2
    //   11523: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11526: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11529: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   11532: aload 28
    //   11534: aload 28
    //   11536: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11539: aload_2
    //   11540: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11543: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11546: lsub
    //   11547: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   11550: aload 28
    //   11552: lload 12
    //   11554: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   11557: aload 28
    //   11559: aload_0
    //   11560: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11563: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   11566: aload 28
    //   11568: aload_0
    //   11569: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   11572: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11575: aload 28
    //   11577: aload_0
    //   11578: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11581: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11584: aload 28
    //   11586: lconst_0
    //   11587: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11590: aload 28
    //   11592: aload_0
    //   11593: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11596: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11599: aload 28
    //   11601: aload_2
    //   11602: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11605: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11608: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11611: aload 28
    //   11613: aload_0
    //   11614: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11617: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   11620: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11623: aload 28
    //   11625: aload_0
    //   11626: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11629: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11632: aload_0
    //   11633: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11636: ifnull +945 -> 12581
    //   11639: aload_0
    //   11640: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11643: ldc_w 687
    //   11646: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11649: ifeq +932 -> 12581
    //   11652: iconst_1
    //   11653: istore 10
    //   11655: aload 28
    //   11657: iload 10
    //   11659: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   11662: aload 28
    //   11664: aload_2
    //   11665: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11668: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11671: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11674: aload 28
    //   11676: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   11679: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   11682: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   11685: aload 20
    //   11687: ifnull +24 -> 11711
    //   11690: aload 20
    //   11692: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11695: ifnull +16 -> 11711
    //   11698: aload 28
    //   11700: aload 20
    //   11702: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11705: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11708: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   11711: aload_2
    //   11712: aload 28
    //   11714: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11717: aload_2
    //   11718: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11721: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11724: ifeq +11 -> 11735
    //   11727: aload_0
    //   11728: aload_1
    //   11729: aload_2
    //   11730: aload 28
    //   11732: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11735: aload_0
    //   11736: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11739: ifeq +848 -> 12587
    //   11742: aload_0
    //   11743: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   11746: ifnull +12 -> 11758
    //   11749: aload_0
    //   11750: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   11753: invokeinterface 792 1 0
    //   11758: aload_0
    //   11759: aconst_null
    //   11760: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   11763: return
    //   11764: aconst_null
    //   11765: astore 24
    //   11767: goto -1588 -> 10179
    //   11770: astore 22
    //   11772: ldc_w 428
    //   11775: astore 22
    //   11777: goto -1540 -> 10237
    //   11780: ldc_w 962
    //   11783: astore 25
    //   11785: goto -1373 -> 10412
    //   11788: aconst_null
    //   11789: astore 25
    //   11791: goto -1259 -> 10532
    //   11794: aload_0
    //   11795: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11798: astore 25
    //   11800: goto -1028 -> 10772
    //   11803: iconst_0
    //   11804: istore_3
    //   11805: goto -1003 -> 10802
    //   11808: aconst_null
    //   11809: astore 25
    //   11811: goto -859 -> 10952
    //   11814: new 125	java/lang/StringBuilder
    //   11817: dup
    //   11818: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   11821: ldc_w 964
    //   11824: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11827: aload_0
    //   11828: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11831: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11834: ldc_w 529
    //   11837: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11840: aload_0
    //   11841: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11844: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11847: ldc_w 534
    //   11850: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11853: astore 29
    //   11855: aload_0
    //   11856: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11859: ifeq +569 -> 12428
    //   11862: aload 20
    //   11864: ifnull +564 -> 12428
    //   11867: aload 20
    //   11869: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11872: ifnull +556 -> 12428
    //   11875: aload 20
    //   11877: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11880: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11883: astore 25
    //   11885: aload 29
    //   11887: aload 25
    //   11889: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11892: ldc_w 545
    //   11895: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11898: aload 26
    //   11900: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11903: ldc_w 550
    //   11906: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11909: aload 24
    //   11911: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11914: ldc_w 552
    //   11917: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11920: aconst_null
    //   11921: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11924: ldc_w 554
    //   11927: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11930: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11933: invokevirtual 174	java/lang/Thread:getId	()J
    //   11936: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11939: ldc_w 556
    //   11942: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11945: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11948: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11951: ldc_w 558
    //   11954: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11957: aload_0
    //   11958: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   11961: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11964: ldc_w 560
    //   11967: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11970: aload_0
    //   11971: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   11974: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11977: ldc_w 562
    //   11980: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11983: astore 29
    //   11985: aload_0
    //   11986: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   11989: ifeq +447 -> 12436
    //   11992: aload_0
    //   11993: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11996: aload_0
    //   11997: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12000: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   12003: astore 25
    //   12005: aload 29
    //   12007: aload 25
    //   12009: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12012: ldc_w 568
    //   12015: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12018: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12021: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12024: ldc_w 566
    //   12027: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12030: aload 22
    //   12032: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12035: ldc_w 580
    //   12038: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12041: aload_2
    //   12042: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12045: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12048: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12051: ldc_w 585
    //   12054: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12057: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12060: aload_0
    //   12061: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12064: lsub
    //   12065: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12068: ldc_w 587
    //   12071: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12074: aload_2
    //   12075: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12078: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12081: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12084: ldc_w 592
    //   12087: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12090: aload_2
    //   12091: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12094: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12097: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12100: ldc_w 596
    //   12103: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12106: aload_2
    //   12107: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12110: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12113: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12116: ldc_w 601
    //   12119: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12122: aload_0
    //   12123: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   12126: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12129: ldc_w 603
    //   12132: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12135: aload_0
    //   12136: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   12139: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12142: ldc_w 966
    //   12145: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12148: iload 4
    //   12150: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12153: ldc_w 615
    //   12156: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12159: aload 27
    //   12161: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12164: ldc_w 575
    //   12167: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12170: aload_2
    //   12171: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12174: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12177: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12180: ldc_w 617
    //   12183: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12186: aload 23
    //   12188: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12191: ldc_w 619
    //   12194: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12197: astore 29
    //   12199: aload_0
    //   12200: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12203: ifnull +239 -> 12442
    //   12206: aload_0
    //   12207: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12210: iconst_0
    //   12211: bipush 30
    //   12213: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   12216: astore 25
    //   12218: aload 29
    //   12220: aload 25
    //   12222: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12225: ldc_w 625
    //   12228: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12231: astore 25
    //   12233: aload_0
    //   12234: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12237: ifnull +214 -> 12451
    //   12240: aload_0
    //   12241: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12244: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12247: istore_3
    //   12248: aload 25
    //   12250: iload_3
    //   12251: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12254: ldc_w 627
    //   12257: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12260: aload_2
    //   12261: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12264: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12267: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12270: ldc_w 632
    //   12273: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12276: lload 12
    //   12278: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12281: ldc_w 634
    //   12284: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12287: aload_0
    //   12288: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12291: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12294: ldc_w 603
    //   12297: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12300: aload_0
    //   12301: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12304: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12307: ldc_w 636
    //   12310: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12313: aload_0
    //   12314: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12317: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12320: ldc_w 603
    //   12323: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12326: aload_0
    //   12327: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12330: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12333: ldc_w 638
    //   12336: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12339: aload_0
    //   12340: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   12343: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12346: ldc_w 640
    //   12349: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12352: aload_0
    //   12353: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   12356: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12359: ldc_w 645
    //   12362: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12365: aload_0
    //   12366: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   12369: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12372: ldc_w 650
    //   12375: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12378: astore 29
    //   12380: aload_0
    //   12381: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12384: ifnull +72 -> 12456
    //   12387: aload_0
    //   12388: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12391: invokeinterface 660 1 0
    //   12396: astore 25
    //   12398: aload 28
    //   12400: aload 29
    //   12402: aload 25
    //   12404: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12407: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12410: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12413: ldc_w 447
    //   12416: aload 28
    //   12418: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12421: aconst_null
    //   12422: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12425: goto -1418 -> 11007
    //   12428: ldc_w 962
    //   12431: astore 25
    //   12433: goto -548 -> 11885
    //   12436: aconst_null
    //   12437: astore 25
    //   12439: goto -434 -> 12005
    //   12442: aload_0
    //   12443: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12446: astore 25
    //   12448: goto -230 -> 12218
    //   12451: iconst_0
    //   12452: istore_3
    //   12453: goto -205 -> 12248
    //   12456: aconst_null
    //   12457: astore 25
    //   12459: goto -61 -> 12398
    //   12462: iconst_0
    //   12463: istore_3
    //   12464: goto -1377 -> 11087
    //   12467: ldc_w 428
    //   12470: astore 23
    //   12472: goto -1254 -> 11218
    //   12475: aload_0
    //   12476: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   12479: aload_0
    //   12480: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   12483: aload_0
    //   12484: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12487: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   12490: aload_2
    //   12491: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12494: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12497: invokeinterface 685 4 0
    //   12502: goto -1198 -> 11304
    //   12505: astore 23
    //   12507: ldc 219
    //   12509: ldc_w 974
    //   12512: aload 23
    //   12514: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12517: goto -1213 -> 11304
    //   12520: aload_0
    //   12521: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   12524: aload_0
    //   12525: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   12528: aload_0
    //   12529: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12532: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   12535: aload_2
    //   12536: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12539: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12542: invokeinterface 685 4 0
    //   12547: goto -1183 -> 11364
    //   12550: astore 22
    //   12552: ldc 219
    //   12554: ldc_w 976
    //   12557: aload 22
    //   12559: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12562: goto -1198 -> 11364
    //   12565: iconst_0
    //   12566: istore 10
    //   12568: goto -1154 -> 11414
    //   12571: aload 26
    //   12573: invokevirtual 979	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   12576: astore 21
    //   12578: goto -1096 -> 11482
    //   12581: iconst_0
    //   12582: istore 10
    //   12584: goto -929 -> 11655
    //   12587: aload_0
    //   12588: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12591: ifnull +15 -> 12606
    //   12594: aload_0
    //   12595: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12598: invokevirtual 984	org/apache/http/client/methods/HttpGet:abort	()V
    //   12601: aload_0
    //   12602: aconst_null
    //   12603: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12606: aload_0
    //   12607: invokevirtual 987	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   12610: return
    //   12611: sipush 416
    //   12614: iload 4
    //   12616: if_icmpne +1722 -> 14338
    //   12619: aload_0
    //   12620: ldc_w 989
    //   12623: invokevirtual 992	com/tencent/component/network/downloader/impl/FastDownloadTask:removeHttpParam	(Ljava/lang/String;)V
    //   12626: aload_2
    //   12627: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12630: bipush 7
    //   12632: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   12635: iload 4
    //   12637: istore 5
    //   12639: aload_0
    //   12640: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12643: ifnull +21 -> 12664
    //   12646: aload_0
    //   12647: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12650: aload_0
    //   12651: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12654: iconst_1
    //   12655: invokeinterface 995 3 0
    //   12660: iload 4
    //   12662: istore 5
    //   12664: aload_2
    //   12665: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12668: lload 14
    //   12670: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12673: invokevirtual 461	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   12676: aload_2
    //   12677: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12680: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12683: aload_0
    //   12684: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12687: lsub
    //   12688: putfield 464	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   12691: aload_2
    //   12692: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12695: aload_0
    //   12696: getfield 467	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   12699: putfield 470	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   12702: aload_0
    //   12703: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12706: invokestatic 475	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   12709: invokevirtual 479	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   12712: astore 26
    //   12714: aload_0
    //   12715: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12718: ifnull +1650 -> 14368
    //   12721: aload_0
    //   12722: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12725: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12728: ifnull +1640 -> 14368
    //   12731: aload_0
    //   12732: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12735: invokevirtual 483	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12738: getfield 486	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   12741: astore 24
    //   12743: aload_0
    //   12744: aload_0
    //   12745: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12748: aload 21
    //   12750: aload 20
    //   12752: invokevirtual 490	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   12755: astore 27
    //   12757: ldc_w 428
    //   12760: astore 23
    //   12762: aload 22
    //   12764: ifnull +4398 -> 17162
    //   12767: aload 22
    //   12769: ldc_w 492
    //   12772: invokeinterface 498 2 0
    //   12777: checkcast 282	java/lang/String
    //   12780: astore 25
    //   12782: aload 25
    //   12784: astore 23
    //   12786: aload 22
    //   12788: ldc_w 500
    //   12791: invokeinterface 498 2 0
    //   12796: checkcast 282	java/lang/String
    //   12799: astore 22
    //   12801: aload_2
    //   12802: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12805: aload 23
    //   12807: putfield 509	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   12810: aload_0
    //   12811: lconst_0
    //   12812: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12815: aload_0
    //   12816: iconst_0
    //   12817: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12820: aload_0
    //   12821: lconst_0
    //   12822: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12825: aload_0
    //   12826: iconst_0
    //   12827: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12830: aload_2
    //   12831: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12834: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12837: ifeq +12 -> 12849
    //   12840: aload_1
    //   12841: invokeinterface 359 1 0
    //   12846: ifeq +31 -> 12877
    //   12849: aload_0
    //   12850: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12853: ifnull +24 -> 12877
    //   12856: aload_0
    //   12857: getfield 516	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12860: aload_0
    //   12861: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12864: aload_2
    //   12865: invokevirtual 519	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   12868: aload 21
    //   12870: aload 20
    //   12872: invokeinterface 525 5 0
    //   12877: aload_1
    //   12878: invokeinterface 359 1 0
    //   12883: ifne +1420 -> 14303
    //   12886: aload_0
    //   12887: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12890: invokestatic 367	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   12893: istore 10
    //   12895: aload_2
    //   12896: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12899: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12902: ifne +1517 -> 14419
    //   12905: new 125	java/lang/StringBuilder
    //   12908: dup
    //   12909: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   12912: ldc_w 527
    //   12915: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12918: aload_0
    //   12919: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12922: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12925: ldc_w 529
    //   12928: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12931: aload_0
    //   12932: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12935: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12938: ldc_w 534
    //   12941: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12944: astore 29
    //   12946: aload_0
    //   12947: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12950: ifeq +1434 -> 14384
    //   12953: aload 20
    //   12955: ifnull +1429 -> 14384
    //   12958: aload 20
    //   12960: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12963: ifnull +1421 -> 14384
    //   12966: aload 20
    //   12968: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12971: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12974: astore 25
    //   12976: aload 29
    //   12978: aload 25
    //   12980: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12983: ldc_w 545
    //   12986: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12989: aload 26
    //   12991: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12994: ldc_w 550
    //   12997: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13000: aload 24
    //   13002: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13005: ldc_w 552
    //   13008: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13011: aconst_null
    //   13012: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13015: ldc_w 554
    //   13018: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13021: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13024: invokevirtual 174	java/lang/Thread:getId	()J
    //   13027: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13030: ldc_w 556
    //   13033: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13036: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   13039: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13042: ldc_w 558
    //   13045: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13048: aload_0
    //   13049: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13052: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13055: ldc_w 560
    //   13058: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13061: aload_0
    //   13062: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13065: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13068: ldc_w 562
    //   13071: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13074: astore 29
    //   13076: aload_0
    //   13077: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13080: ifeq +1312 -> 14392
    //   13083: aload_0
    //   13084: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13087: aload_0
    //   13088: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13091: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   13094: astore 25
    //   13096: aload 29
    //   13098: aload 25
    //   13100: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13103: ldc_w 564
    //   13106: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13109: iload 10
    //   13111: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13114: ldc_w 566
    //   13117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13120: aload 22
    //   13122: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13125: ldc_w 568
    //   13128: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13131: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   13134: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13137: ldc_w 575
    //   13140: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13143: aload_2
    //   13144: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13147: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13150: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13153: ldc_w 580
    //   13156: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13159: aload_2
    //   13160: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13163: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13166: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13169: ldc_w 585
    //   13172: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13175: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13178: aload_0
    //   13179: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13182: lsub
    //   13183: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13186: ldc_w 587
    //   13189: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13192: aload_2
    //   13193: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13196: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13199: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13202: ldc_w 592
    //   13205: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13208: aload_2
    //   13209: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13212: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13215: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13218: ldc_w 596
    //   13221: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13224: aload_2
    //   13225: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13228: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   13231: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13234: ldc_w 601
    //   13237: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13240: aload_0
    //   13241: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   13244: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13247: ldc_w 603
    //   13250: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13253: aload_0
    //   13254: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   13257: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13260: ldc_w 608
    //   13263: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13266: aload_2
    //   13267: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13270: invokevirtual 611	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   13273: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13276: ldc_w 613
    //   13279: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13282: iload 5
    //   13284: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13287: ldc_w 615
    //   13290: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13293: aload 27
    //   13295: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13298: ldc_w 617
    //   13301: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13304: aload 23
    //   13306: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13309: ldc_w 619
    //   13312: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13315: astore 29
    //   13317: aload_0
    //   13318: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13321: ifnull +1077 -> 14398
    //   13324: aload_0
    //   13325: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13328: iconst_0
    //   13329: bipush 30
    //   13331: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   13334: astore 25
    //   13336: aload 29
    //   13338: aload 25
    //   13340: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13343: ldc_w 625
    //   13346: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13349: astore 25
    //   13351: aload_0
    //   13352: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13355: ifnull +1052 -> 14407
    //   13358: aload_0
    //   13359: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13362: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13365: istore 4
    //   13367: aload 25
    //   13369: iload 4
    //   13371: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13374: ldc_w 627
    //   13377: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13380: aload_2
    //   13381: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13384: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13387: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13390: ldc_w 632
    //   13393: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13396: lload 12
    //   13398: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13401: ldc_w 634
    //   13404: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13407: aload_0
    //   13408: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13411: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13414: ldc_w 603
    //   13417: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13420: aload_0
    //   13421: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   13424: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13427: ldc_w 636
    //   13430: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13433: aload_0
    //   13434: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   13437: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13440: ldc_w 603
    //   13443: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13446: aload_0
    //   13447: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   13450: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13453: ldc_w 638
    //   13456: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13459: aload_0
    //   13460: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   13463: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13466: ldc_w 640
    //   13469: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13472: aload_0
    //   13473: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   13476: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13479: ldc_w 645
    //   13482: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13485: aload_0
    //   13486: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   13489: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13492: ldc_w 650
    //   13495: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13498: astore 29
    //   13500: aload_0
    //   13501: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13504: ifnull +909 -> 14413
    //   13507: aload_0
    //   13508: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13511: invokeinterface 660 1 0
    //   13516: astore 25
    //   13518: aload 28
    //   13520: aload 29
    //   13522: aload 25
    //   13524: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13527: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13530: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13533: ldc_w 447
    //   13536: aload 28
    //   13538: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13541: aconst_null
    //   13542: invokestatic 432	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   13545: aload_0
    //   13546: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13549: ifnull +24 -> 13573
    //   13552: aload_0
    //   13553: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13556: ldc_w 439
    //   13559: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13562: ifeq +11 -> 13573
    //   13565: aload_0
    //   13566: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13569: iconst_0
    //   13570: invokestatic 669	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   13573: iload 10
    //   13575: ifne +8 -> 13583
    //   13578: aload_0
    //   13579: iconst_0
    //   13580: putfield 672	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   13583: aload_2
    //   13584: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13587: astore 25
    //   13589: new 125	java/lang/StringBuilder
    //   13592: dup
    //   13593: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13596: aload_0
    //   13597: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13600: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13603: ldc_w 674
    //   13606: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13609: aload 24
    //   13611: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13614: ldc_w 676
    //   13617: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13620: aload_2
    //   13621: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13624: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13627: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13630: ldc_w 678
    //   13633: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13636: astore 24
    //   13638: aload_0
    //   13639: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13642: ifnull +1428 -> 15070
    //   13645: aload_0
    //   13646: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13649: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13652: istore 4
    //   13654: aload 24
    //   13656: iload 4
    //   13658: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13661: ldc_w 613
    //   13664: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13667: iload 5
    //   13669: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13672: ldc_w 575
    //   13675: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13678: aload_2
    //   13679: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13682: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13685: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13688: ldc_w 587
    //   13691: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13694: aload_2
    //   13695: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13698: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13701: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13704: ldc_w 592
    //   13707: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13710: aload_2
    //   13711: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13714: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13717: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13720: ldc_w 580
    //   13723: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13726: aload_2
    //   13727: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13730: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13733: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13736: ldc_w 585
    //   13739: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13742: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13745: aload_0
    //   13746: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13749: lsub
    //   13750: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13753: astore 24
    //   13755: aload 23
    //   13757: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13760: ifne +1316 -> 15076
    //   13763: new 125	java/lang/StringBuilder
    //   13766: dup
    //   13767: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   13770: ldc_w 617
    //   13773: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13776: aload 23
    //   13778: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13781: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13784: astore 23
    //   13786: aload 25
    //   13788: aload 24
    //   13790: aload 23
    //   13792: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13795: ldc_w 615
    //   13798: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13801: aload 27
    //   13803: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13806: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13809: putfield 681	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   13812: aload_0
    //   13813: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13816: ifnull +56 -> 13872
    //   13819: getstatic 203	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13822: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13825: aload_0
    //   13826: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13829: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13832: if_icmpne +40 -> 13872
    //   13835: aload_0
    //   13836: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13839: ifnull +33 -> 13872
    //   13842: aload 22
    //   13844: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13847: ifne +1237 -> 15084
    //   13850: aload_0
    //   13851: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13854: aload_0
    //   13855: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13858: aload 22
    //   13860: aload_2
    //   13861: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13864: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13867: invokeinterface 685 4 0
    //   13872: aload_0
    //   13873: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13876: ifnull +56 -> 13932
    //   13879: getstatic 297	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13882: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13885: aload_0
    //   13886: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13889: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13892: if_icmpne +40 -> 13932
    //   13895: aload_0
    //   13896: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13899: ifnull +33 -> 13932
    //   13902: aload 22
    //   13904: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13907: ifne +1222 -> 15129
    //   13910: aload_0
    //   13911: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13914: aload_0
    //   13915: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13918: aload 22
    //   13920: aload_2
    //   13921: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13924: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13927: invokeinterface 685 4 0
    //   13932: iload 10
    //   13934: ifeq +64 -> 13998
    //   13937: aload_0
    //   13938: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13941: invokestatic 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   13944: astore 22
    //   13946: aload_0
    //   13947: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13950: astore 23
    //   13952: aload_0
    //   13953: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   13956: ifeq +1218 -> 15174
    //   13959: aload_0
    //   13960: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13963: ifnull +1211 -> 15174
    //   13966: aload_0
    //   13967: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13970: ldc_w 687
    //   13973: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13976: ifeq +1198 -> 15174
    //   13979: iconst_1
    //   13980: istore 10
    //   13982: aload 22
    //   13984: aload 23
    //   13986: iload 10
    //   13988: aload_2
    //   13989: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13992: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13995: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   13998: aload 28
    //   14000: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   14003: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   14006: aload 28
    //   14008: aload_0
    //   14009: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   14012: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   14015: aload 28
    //   14017: aload 21
    //   14019: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   14022: aload 28
    //   14024: aload 20
    //   14026: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   14029: aload 28
    //   14031: iload 5
    //   14033: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   14036: aload 28
    //   14038: aconst_null
    //   14039: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   14042: aload 26
    //   14044: ifnonnull +1136 -> 15180
    //   14047: aconst_null
    //   14048: astore 21
    //   14050: aload 28
    //   14052: aload 21
    //   14054: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   14057: aload 28
    //   14059: aconst_null
    //   14060: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   14063: aload 28
    //   14065: aload_2
    //   14066: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14069: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14072: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   14075: aload 28
    //   14077: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14080: aload_0
    //   14081: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14084: lsub
    //   14085: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14088: aload 28
    //   14090: aload_2
    //   14091: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14094: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14097: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   14100: aload 28
    //   14102: aload 28
    //   14104: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14107: aload_2
    //   14108: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14111: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14114: lsub
    //   14115: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   14118: aload 28
    //   14120: lload 12
    //   14122: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   14125: aload 28
    //   14127: aload_0
    //   14128: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   14131: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   14134: aload 28
    //   14136: aload_0
    //   14137: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   14140: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   14143: aload 28
    //   14145: aload_0
    //   14146: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   14149: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   14152: aload 28
    //   14154: lconst_0
    //   14155: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   14158: aload 28
    //   14160: aload_0
    //   14161: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   14164: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   14167: aload 28
    //   14169: aload_2
    //   14170: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14173: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14176: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   14179: aload 28
    //   14181: aload_0
    //   14182: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14185: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   14188: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   14191: aload 28
    //   14193: aload_0
    //   14194: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14197: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   14200: aload_0
    //   14201: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14204: ifnull +986 -> 15190
    //   14207: aload_0
    //   14208: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14211: ldc_w 687
    //   14214: invokevirtual 442	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14217: ifeq +973 -> 15190
    //   14220: iconst_1
    //   14221: istore 10
    //   14223: aload 28
    //   14225: iload 10
    //   14227: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   14230: aload 28
    //   14232: aload_2
    //   14233: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14236: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14239: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   14242: aload 28
    //   14244: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   14247: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   14250: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   14253: aload 20
    //   14255: ifnull +24 -> 14279
    //   14258: aload 20
    //   14260: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14263: ifnull +16 -> 14279
    //   14266: aload 28
    //   14268: aload 20
    //   14270: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14273: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   14276: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   14279: aload_2
    //   14280: aload 28
    //   14282: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14285: aload_2
    //   14286: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14289: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14292: ifeq +11 -> 14303
    //   14295: aload_0
    //   14296: aload_1
    //   14297: aload_2
    //   14298: aload 28
    //   14300: invokevirtual 363	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14303: aload_0
    //   14304: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14307: ifeq +889 -> 15196
    //   14310: aload_0
    //   14311: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   14314: ifnull +12 -> 14326
    //   14317: aload_0
    //   14318: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   14321: invokeinterface 792 1 0
    //   14326: aload_0
    //   14327: aconst_null
    //   14328: putfield 418	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   14331: iload_3
    //   14332: iconst_1
    //   14333: iadd
    //   14334: istore_3
    //   14335: goto -14130 -> 205
    //   14338: aload_2
    //   14339: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14342: iconst_3
    //   14343: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14346: goto -1711 -> 12635
    //   14349: astore 23
    //   14351: goto -14111 -> 240
    //   14354: aload_2
    //   14355: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14358: iconst_3
    //   14359: invokevirtual 381	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14362: iconst_0
    //   14363: istore 5
    //   14365: goto -1701 -> 12664
    //   14368: aconst_null
    //   14369: astore 24
    //   14371: goto -1628 -> 12743
    //   14374: astore 22
    //   14376: ldc_w 428
    //   14379: astore 22
    //   14381: goto -1580 -> 12801
    //   14384: ldc_w 962
    //   14387: astore 25
    //   14389: goto -1413 -> 12976
    //   14392: aconst_null
    //   14393: astore 25
    //   14395: goto -1299 -> 13096
    //   14398: aload_0
    //   14399: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14402: astore 25
    //   14404: goto -1068 -> 13336
    //   14407: iconst_0
    //   14408: istore 4
    //   14410: goto -1043 -> 13367
    //   14413: aconst_null
    //   14414: astore 25
    //   14416: goto -898 -> 13518
    //   14419: new 125	java/lang/StringBuilder
    //   14422: dup
    //   14423: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   14426: ldc_w 964
    //   14429: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14432: aload_0
    //   14433: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   14436: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14439: ldc_w 529
    //   14442: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14445: aload_0
    //   14446: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14449: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14452: ldc_w 534
    //   14455: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14458: astore 29
    //   14460: aload_0
    //   14461: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14464: ifeq +571 -> 15035
    //   14467: aload 20
    //   14469: ifnull +566 -> 15035
    //   14472: aload 20
    //   14474: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14477: ifnull +558 -> 15035
    //   14480: aload 20
    //   14482: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14485: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   14488: astore 25
    //   14490: aload 29
    //   14492: aload 25
    //   14494: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14497: ldc_w 545
    //   14500: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14503: aload 26
    //   14505: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14508: ldc_w 550
    //   14511: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14514: aload 24
    //   14516: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14519: ldc_w 552
    //   14522: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14525: aconst_null
    //   14526: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14529: ldc_w 554
    //   14532: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14535: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14538: invokevirtual 174	java/lang/Thread:getId	()J
    //   14541: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14544: ldc_w 556
    //   14547: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14550: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   14553: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14556: ldc_w 558
    //   14559: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14562: aload_0
    //   14563: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14566: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14569: ldc_w 560
    //   14572: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14575: aload_0
    //   14576: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14579: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14582: ldc_w 562
    //   14585: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14588: astore 29
    //   14590: aload_0
    //   14591: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14594: ifeq +449 -> 15043
    //   14597: aload_0
    //   14598: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   14601: aload_0
    //   14602: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14605: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   14608: astore 25
    //   14610: aload 29
    //   14612: aload 25
    //   14614: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14617: ldc_w 568
    //   14620: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14623: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   14626: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14629: ldc_w 566
    //   14632: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14635: aload 22
    //   14637: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14640: ldc_w 580
    //   14643: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14646: aload_2
    //   14647: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14650: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14653: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14656: ldc_w 585
    //   14659: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14662: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14665: aload_0
    //   14666: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14669: lsub
    //   14670: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14673: ldc_w 587
    //   14676: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14679: aload_2
    //   14680: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14683: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   14686: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14689: ldc_w 592
    //   14692: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14695: aload_2
    //   14696: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14699: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   14702: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14705: ldc_w 596
    //   14708: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14711: aload_2
    //   14712: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14715: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   14718: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14721: ldc_w 601
    //   14724: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14727: aload_0
    //   14728: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   14731: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14734: ldc_w 603
    //   14737: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14740: aload_0
    //   14741: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   14744: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14747: ldc_w 966
    //   14750: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14753: iload 5
    //   14755: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14758: ldc_w 615
    //   14761: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14764: aload 27
    //   14766: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14769: ldc_w 575
    //   14772: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14775: aload_2
    //   14776: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14779: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14782: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14785: ldc_w 617
    //   14788: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14791: aload 23
    //   14793: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14796: ldc_w 619
    //   14799: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14802: astore 29
    //   14804: aload_0
    //   14805: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14808: ifnull +241 -> 15049
    //   14811: aload_0
    //   14812: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14815: iconst_0
    //   14816: bipush 30
    //   14818: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   14821: astore 25
    //   14823: aload 29
    //   14825: aload 25
    //   14827: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14830: ldc_w 625
    //   14833: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14836: astore 25
    //   14838: aload_0
    //   14839: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14842: ifnull +216 -> 15058
    //   14845: aload_0
    //   14846: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14849: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14852: istore 4
    //   14854: aload 25
    //   14856: iload 4
    //   14858: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14861: ldc_w 627
    //   14864: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14867: aload_2
    //   14868: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14871: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14874: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14877: ldc_w 632
    //   14880: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14883: lload 12
    //   14885: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14888: ldc_w 634
    //   14891: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14894: aload_0
    //   14895: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   14898: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14901: ldc_w 603
    //   14904: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14907: aload_0
    //   14908: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   14911: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14914: ldc_w 636
    //   14917: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14920: aload_0
    //   14921: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   14924: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14927: ldc_w 603
    //   14930: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14933: aload_0
    //   14934: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   14937: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14940: ldc_w 638
    //   14943: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14946: aload_0
    //   14947: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   14950: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14953: ldc_w 640
    //   14956: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14959: aload_0
    //   14960: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   14963: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14966: ldc_w 645
    //   14969: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14972: aload_0
    //   14973: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   14976: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14979: ldc_w 650
    //   14982: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14985: astore 29
    //   14987: aload_0
    //   14988: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14991: ifnull +73 -> 15064
    //   14994: aload_0
    //   14995: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14998: invokeinterface 660 1 0
    //   15003: astore 25
    //   15005: aload 28
    //   15007: aload 29
    //   15009: aload 25
    //   15011: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15014: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15017: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15020: ldc_w 447
    //   15023: aload 28
    //   15025: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15028: aconst_null
    //   15029: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15032: goto -1459 -> 13573
    //   15035: ldc_w 962
    //   15038: astore 25
    //   15040: goto -550 -> 14490
    //   15043: aconst_null
    //   15044: astore 25
    //   15046: goto -436 -> 14610
    //   15049: aload_0
    //   15050: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15053: astore 25
    //   15055: goto -232 -> 14823
    //   15058: iconst_0
    //   15059: istore 4
    //   15061: goto -207 -> 14854
    //   15064: aconst_null
    //   15065: astore 25
    //   15067: goto -62 -> 15005
    //   15070: iconst_0
    //   15071: istore 4
    //   15073: goto -1419 -> 13654
    //   15076: ldc_w 428
    //   15079: astore 23
    //   15081: goto -1295 -> 13786
    //   15084: aload_0
    //   15085: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   15088: aload_0
    //   15089: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   15092: aload_0
    //   15093: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15096: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   15099: aload_2
    //   15100: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   15103: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   15106: invokeinterface 685 4 0
    //   15111: goto -1239 -> 13872
    //   15114: astore 23
    //   15116: ldc 219
    //   15118: ldc_w 974
    //   15121: aload 23
    //   15123: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15126: goto -1254 -> 13872
    //   15129: aload_0
    //   15130: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   15133: aload_0
    //   15134: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   15137: aload_0
    //   15138: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15141: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   15144: aload_2
    //   15145: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   15148: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   15151: invokeinterface 685 4 0
    //   15156: goto -1224 -> 13932
    //   15159: astore 22
    //   15161: ldc 219
    //   15163: ldc_w 976
    //   15166: aload 22
    //   15168: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15171: goto -1239 -> 13932
    //   15174: iconst_0
    //   15175: istore 10
    //   15177: goto -1195 -> 13982
    //   15180: aload 26
    //   15182: invokevirtual 979	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   15185: astore 21
    //   15187: goto -1137 -> 14050
    //   15190: iconst_0
    //   15191: istore 10
    //   15193: goto -970 -> 14223
    //   15196: aload_0
    //   15197: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15200: ifnull +15 -> 15215
    //   15203: aload_0
    //   15204: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15207: invokevirtual 984	org/apache/http/client/methods/HttpGet:abort	()V
    //   15210: aload_0
    //   15211: aconst_null
    //   15212: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15215: aload_0
    //   15216: invokevirtual 987	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   15219: goto -888 -> 14331
    //   15222: aconst_null
    //   15223: astore 25
    //   15225: goto -14826 -> 399
    //   15228: astore 22
    //   15230: ldc_w 428
    //   15233: astore 22
    //   15235: goto -14778 -> 457
    //   15238: ldc_w 962
    //   15241: astore 26
    //   15243: goto -14611 -> 632
    //   15246: aconst_null
    //   15247: astore 26
    //   15249: goto -14497 -> 752
    //   15252: aload_0
    //   15253: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15256: astore 26
    //   15258: goto -14266 -> 992
    //   15261: iconst_0
    //   15262: istore_3
    //   15263: goto -14241 -> 1022
    //   15266: aconst_null
    //   15267: astore 26
    //   15269: goto -14097 -> 1172
    //   15272: new 125	java/lang/StringBuilder
    //   15275: dup
    //   15276: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   15279: ldc_w 964
    //   15282: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15285: aload_0
    //   15286: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   15289: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15292: ldc_w 529
    //   15295: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15298: aload_0
    //   15299: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15302: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15305: ldc_w 534
    //   15308: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15311: astore 30
    //   15313: aload_0
    //   15314: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15317: ifeq +569 -> 15886
    //   15320: aload 20
    //   15322: ifnull +564 -> 15886
    //   15325: aload 20
    //   15327: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   15330: ifnull +556 -> 15886
    //   15333: aload 20
    //   15335: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   15338: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   15341: astore 26
    //   15343: aload 30
    //   15345: aload 26
    //   15347: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15350: ldc_w 545
    //   15353: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15356: aload 27
    //   15358: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15361: ldc_w 550
    //   15364: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15367: aload 25
    //   15369: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15372: ldc_w 552
    //   15375: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15378: aconst_null
    //   15379: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15382: ldc_w 554
    //   15385: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15388: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15391: invokevirtual 174	java/lang/Thread:getId	()J
    //   15394: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15397: ldc_w 556
    //   15400: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15403: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   15406: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15409: ldc_w 558
    //   15412: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15415: aload_0
    //   15416: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15419: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15422: ldc_w 560
    //   15425: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15428: aload_0
    //   15429: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15432: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15435: ldc_w 562
    //   15438: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15441: astore 30
    //   15443: aload_0
    //   15444: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15447: ifeq +447 -> 15894
    //   15450: aload_0
    //   15451: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15454: aload_0
    //   15455: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15458: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   15461: astore 26
    //   15463: aload 30
    //   15465: aload 26
    //   15467: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15470: ldc_w 568
    //   15473: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15476: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   15479: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15482: ldc_w 566
    //   15485: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15488: aload 22
    //   15490: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15493: ldc_w 580
    //   15496: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15499: aload_2
    //   15500: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15503: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   15506: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15509: ldc_w 585
    //   15512: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15515: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   15518: aload_0
    //   15519: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   15522: lsub
    //   15523: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15526: ldc_w 587
    //   15529: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15532: aload_2
    //   15533: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15536: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   15539: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15542: ldc_w 592
    //   15545: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15548: aload_2
    //   15549: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15552: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   15555: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15558: ldc_w 596
    //   15561: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15564: aload_2
    //   15565: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15568: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   15571: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15574: ldc_w 601
    //   15577: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15580: aload_0
    //   15581: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   15584: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15587: ldc_w 603
    //   15590: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15593: aload_0
    //   15594: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   15597: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15600: ldc_w 966
    //   15603: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15606: iload 4
    //   15608: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15611: ldc_w 615
    //   15614: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15617: aload 29
    //   15619: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15622: ldc_w 575
    //   15625: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15628: aload_2
    //   15629: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15632: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   15635: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15638: ldc_w 617
    //   15641: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15644: aload 24
    //   15646: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15649: ldc_w 619
    //   15652: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15655: astore 30
    //   15657: aload_0
    //   15658: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15661: ifnull +239 -> 15900
    //   15664: aload_0
    //   15665: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15668: iconst_0
    //   15669: bipush 30
    //   15671: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   15674: astore 26
    //   15676: aload 30
    //   15678: aload 26
    //   15680: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15683: ldc_w 625
    //   15686: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15689: astore 26
    //   15691: aload_0
    //   15692: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15695: ifnull +214 -> 15909
    //   15698: aload_0
    //   15699: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15702: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   15705: istore_3
    //   15706: aload 26
    //   15708: iload_3
    //   15709: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15712: ldc_w 627
    //   15715: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15718: aload_2
    //   15719: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15722: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   15725: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15728: ldc_w 632
    //   15731: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15734: lload 12
    //   15736: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15739: ldc_w 634
    //   15742: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15745: aload_0
    //   15746: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   15749: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15752: ldc_w 603
    //   15755: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15758: aload_0
    //   15759: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   15762: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15765: ldc_w 636
    //   15768: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15771: aload_0
    //   15772: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   15775: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15778: ldc_w 603
    //   15781: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15784: aload_0
    //   15785: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   15788: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15791: ldc_w 638
    //   15794: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15797: aload_0
    //   15798: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   15801: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15804: ldc_w 640
    //   15807: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15810: aload_0
    //   15811: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   15814: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15817: ldc_w 645
    //   15820: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15823: aload_0
    //   15824: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   15827: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15830: ldc_w 650
    //   15833: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15836: astore 30
    //   15838: aload_0
    //   15839: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15842: ifnull +72 -> 15914
    //   15845: aload_0
    //   15846: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15849: invokeinterface 660 1 0
    //   15854: astore 26
    //   15856: aload 28
    //   15858: aload 30
    //   15860: aload 26
    //   15862: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15865: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15868: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15871: ldc_w 447
    //   15874: aload 28
    //   15876: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15879: aconst_null
    //   15880: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15883: goto -14655 -> 1228
    //   15886: ldc_w 962
    //   15889: astore 26
    //   15891: goto -548 -> 15343
    //   15894: aconst_null
    //   15895: astore 26
    //   15897: goto -434 -> 15463
    //   15900: aload_0
    //   15901: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15904: astore 26
    //   15906: goto -230 -> 15676
    //   15909: iconst_0
    //   15910: istore_3
    //   15911: goto -205 -> 15706
    //   15914: aconst_null
    //   15915: astore 26
    //   15917: goto -61 -> 15856
    //   15920: iconst_0
    //   15921: istore_3
    //   15922: goto -14614 -> 1308
    //   15925: ldc_w 428
    //   15928: astore 24
    //   15930: goto -14491 -> 1439
    //   15933: aload_0
    //   15934: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   15937: aload_0
    //   15938: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   15941: aload_0
    //   15942: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15945: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   15948: aload_2
    //   15949: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   15952: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   15955: invokeinterface 685 4 0
    //   15960: goto -14435 -> 1525
    //   15963: astore 24
    //   15965: ldc 219
    //   15967: ldc_w 974
    //   15970: aload 24
    //   15972: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15975: goto -14450 -> 1525
    //   15978: aload_0
    //   15979: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   15982: aload_0
    //   15983: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   15986: aload_0
    //   15987: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15990: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   15993: aload_2
    //   15994: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   15997: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   16000: invokeinterface 685 4 0
    //   16005: goto -14420 -> 1585
    //   16008: astore 22
    //   16010: ldc 219
    //   16012: ldc_w 976
    //   16015: aload 22
    //   16017: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16020: goto -14435 -> 1585
    //   16023: iconst_0
    //   16024: istore 10
    //   16026: goto -14391 -> 1635
    //   16029: aload 27
    //   16031: invokevirtual 979	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   16034: astore 21
    //   16036: goto -14332 -> 1704
    //   16039: iconst_0
    //   16040: istore 10
    //   16042: goto -14165 -> 1877
    //   16045: aload_0
    //   16046: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16049: ifnull +15 -> 16064
    //   16052: aload_0
    //   16053: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16056: invokevirtual 984	org/apache/http/client/methods/HttpGet:abort	()V
    //   16059: aload_0
    //   16060: aconst_null
    //   16061: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16064: aload_0
    //   16065: invokevirtual 987	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   16068: goto -14083 -> 1985
    //   16071: aconst_null
    //   16072: astore 26
    //   16074: goto -11420 -> 4654
    //   16077: astore 22
    //   16079: ldc_w 428
    //   16082: astore 22
    //   16084: goto -11372 -> 4712
    //   16087: ldc_w 962
    //   16090: astore 27
    //   16092: goto -11205 -> 4887
    //   16095: aconst_null
    //   16096: astore 27
    //   16098: goto -11091 -> 5007
    //   16101: aload_0
    //   16102: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16105: astore 27
    //   16107: goto -10860 -> 5247
    //   16110: iconst_0
    //   16111: istore_3
    //   16112: goto -10835 -> 5277
    //   16115: aconst_null
    //   16116: astore 27
    //   16118: goto -10691 -> 5427
    //   16121: new 125	java/lang/StringBuilder
    //   16124: dup
    //   16125: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   16128: ldc_w 964
    //   16131: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16134: aload_0
    //   16135: invokevirtual 70	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   16138: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16141: ldc_w 529
    //   16144: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16147: aload_0
    //   16148: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   16151: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16154: ldc_w 534
    //   16157: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16160: astore 31
    //   16162: aload_0
    //   16163: getfield 73	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   16166: ifeq +569 -> 16735
    //   16169: aload 23
    //   16171: ifnull +564 -> 16735
    //   16174: aload 23
    //   16176: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   16179: ifnull +556 -> 16735
    //   16182: aload 23
    //   16184: invokevirtual 540	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   16187: invokevirtual 543	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   16190: astore 27
    //   16192: aload 31
    //   16194: aload 27
    //   16196: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16199: ldc_w 545
    //   16202: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16205: aload 29
    //   16207: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16210: ldc_w 550
    //   16213: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16216: aload 26
    //   16218: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16221: ldc_w 552
    //   16224: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16227: aconst_null
    //   16228: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16231: ldc_w 554
    //   16234: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16237: invokestatic 171	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16240: invokevirtual 174	java/lang/Thread:getId	()J
    //   16243: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16246: ldc_w 556
    //   16249: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16252: invokestatic 158	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   16255: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16258: ldc_w 558
    //   16261: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16264: aload_0
    //   16265: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16268: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16271: ldc_w 560
    //   16274: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16277: aload_0
    //   16278: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16281: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16284: ldc_w 562
    //   16287: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16290: astore 31
    //   16292: aload_0
    //   16293: getfield 187	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16296: ifeq +447 -> 16743
    //   16299: aload_0
    //   16300: getfield 61	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   16303: aload_0
    //   16304: getfield 192	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16307: invokestatic 322	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   16310: astore 27
    //   16312: aload 31
    //   16314: aload 27
    //   16316: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16319: ldc_w 568
    //   16322: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16325: invokestatic 573	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   16328: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16331: ldc_w 566
    //   16334: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16337: aload 22
    //   16339: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16342: ldc_w 580
    //   16345: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16348: aload_2
    //   16349: invokevirtual 455	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   16352: getfield 583	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   16355: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16358: ldc_w 585
    //   16361: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16364: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   16367: aload_0
    //   16368: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   16371: lsub
    //   16372: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16375: ldc_w 587
    //   16378: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16381: aload_2
    //   16382: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16385: getfield 590	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   16388: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16391: ldc_w 592
    //   16394: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16397: aload_2
    //   16398: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16401: getfield 594	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   16404: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16407: ldc_w 596
    //   16410: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16413: aload_2
    //   16414: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16417: getfield 599	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   16420: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16423: ldc_w 601
    //   16426: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16429: aload_0
    //   16430: invokevirtual 421	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   16433: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16436: ldc_w 603
    //   16439: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16442: aload_0
    //   16443: invokevirtual 606	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   16446: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16449: ldc_w 966
    //   16452: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16455: iload 4
    //   16457: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16460: ldc_w 615
    //   16463: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16466: aload 30
    //   16468: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16471: ldc_w 575
    //   16474: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16477: aload_2
    //   16478: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16481: getfield 578	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   16484: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16487: ldc_w 617
    //   16490: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16493: aload 25
    //   16495: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16498: ldc_w 619
    //   16501: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16504: astore 31
    //   16506: aload_0
    //   16507: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16510: ifnull +239 -> 16749
    //   16513: aload_0
    //   16514: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16517: iconst_0
    //   16518: bipush 30
    //   16520: invokevirtual 623	java/lang/String:substring	(II)Ljava/lang/String;
    //   16523: astore 27
    //   16525: aload 31
    //   16527: aload 27
    //   16529: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16532: ldc_w 625
    //   16535: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16538: astore 27
    //   16540: aload_0
    //   16541: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16544: ifnull +214 -> 16758
    //   16547: aload_0
    //   16548: getfield 81	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16551: getfield 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   16554: istore_3
    //   16555: aload 27
    //   16557: iload_3
    //   16558: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16561: ldc_w 627
    //   16564: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16567: aload_2
    //   16568: invokevirtual 504	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16571: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   16574: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16577: ldc_w 632
    //   16580: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16583: lload 12
    //   16585: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16588: ldc_w 634
    //   16591: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16594: aload_0
    //   16595: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   16598: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16601: ldc_w 603
    //   16604: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16607: aload_0
    //   16608: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   16611: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16614: ldc_w 636
    //   16617: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16620: aload_0
    //   16621: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   16624: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16627: ldc_w 603
    //   16630: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16633: aload_0
    //   16634: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   16637: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16640: ldc_w 638
    //   16643: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16646: aload_0
    //   16647: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   16650: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16653: ldc_w 640
    //   16656: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16659: aload_0
    //   16660: getfield 643	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   16663: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16666: ldc_w 645
    //   16669: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16672: aload_0
    //   16673: invokevirtual 648	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   16676: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16679: ldc_w 650
    //   16682: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16685: astore 31
    //   16687: aload_0
    //   16688: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16691: ifnull +72 -> 16763
    //   16694: aload_0
    //   16695: getfield 654	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16698: invokeinterface 660 1 0
    //   16703: astore 27
    //   16705: aload 28
    //   16707: aload 31
    //   16709: aload 27
    //   16711: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16714: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16717: putfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16720: ldc_w 447
    //   16723: aload 28
    //   16725: getfield 663	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16728: aconst_null
    //   16729: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16732: goto -11249 -> 5483
    //   16735: ldc_w 962
    //   16738: astore 27
    //   16740: goto -548 -> 16192
    //   16743: aconst_null
    //   16744: astore 27
    //   16746: goto -434 -> 16312
    //   16749: aload_0
    //   16750: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16753: astore 27
    //   16755: goto -230 -> 16525
    //   16758: iconst_0
    //   16759: istore_3
    //   16760: goto -205 -> 16555
    //   16763: aconst_null
    //   16764: astore 27
    //   16766: goto -61 -> 16705
    //   16769: iconst_0
    //   16770: istore_3
    //   16771: goto -11208 -> 5563
    //   16774: ldc_w 428
    //   16777: astore 25
    //   16779: goto -11085 -> 5694
    //   16782: aload_0
    //   16783: getfield 232	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   16786: aload_0
    //   16787: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   16790: aload_0
    //   16791: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16794: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   16797: aload_2
    //   16798: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   16801: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   16804: invokeinterface 685 4 0
    //   16809: goto -11029 -> 5780
    //   16812: astore 25
    //   16814: ldc 219
    //   16816: ldc_w 974
    //   16819: aload 25
    //   16821: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16824: goto -11044 -> 5780
    //   16827: aload_0
    //   16828: getfield 300	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   16831: aload_0
    //   16832: invokevirtual 53	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   16835: aload_0
    //   16836: getfield 437	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16839: invokestatic 972	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   16842: aload_2
    //   16843: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   16846: invokevirtual 512	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   16849: invokeinterface 685 4 0
    //   16854: goto -11014 -> 5840
    //   16857: astore 22
    //   16859: ldc 219
    //   16861: ldc_w 976
    //   16864: aload 22
    //   16866: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16869: goto -11029 -> 5840
    //   16872: iconst_0
    //   16873: istore 10
    //   16875: goto -10985 -> 5890
    //   16878: aload 29
    //   16880: invokevirtual 979	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   16883: astore 21
    //   16885: goto -10926 -> 5959
    //   16888: iconst_0
    //   16889: istore 10
    //   16891: goto -10759 -> 6132
    //   16894: aload_0
    //   16895: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16898: ifnull +15 -> 16913
    //   16901: aload_0
    //   16902: getfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16905: invokevirtual 984	org/apache/http/client/methods/HttpGet:abort	()V
    //   16908: aload_0
    //   16909: aconst_null
    //   16910: putfield 414	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16913: aload_0
    //   16914: invokevirtual 987	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   16917: goto -10677 -> 6240
    //   16920: astore 27
    //   16922: goto -12225 -> 4697
    //   16925: astore 20
    //   16927: aconst_null
    //   16928: astore 21
    //   16930: iload 7
    //   16932: istore 4
    //   16934: goto -12359 -> 4575
    //   16937: astore 21
    //   16939: aconst_null
    //   16940: astore 25
    //   16942: aload 20
    //   16944: astore 22
    //   16946: aload 21
    //   16948: astore 20
    //   16950: aload 25
    //   16952: astore 21
    //   16954: iload 7
    //   16956: istore 4
    //   16958: goto -12383 -> 4575
    //   16961: astore 25
    //   16963: aconst_null
    //   16964: astore 26
    //   16966: aload 20
    //   16968: astore 23
    //   16970: aload 21
    //   16972: astore 24
    //   16974: aload 25
    //   16976: astore 20
    //   16978: aload 26
    //   16980: astore 21
    //   16982: iload 7
    //   16984: istore 4
    //   16986: goto -12411 -> 4575
    //   16989: astore 25
    //   16991: aload 20
    //   16993: astore 23
    //   16995: aload 21
    //   16997: astore 24
    //   16999: aconst_null
    //   17000: astore 21
    //   17002: aload 25
    //   17004: astore 20
    //   17006: goto -12431 -> 4575
    //   17009: astore 25
    //   17011: aload 20
    //   17013: astore 23
    //   17015: aload 21
    //   17017: astore 24
    //   17019: aconst_null
    //   17020: astore 21
    //   17022: aload 25
    //   17024: astore 20
    //   17026: goto -12451 -> 4575
    //   17029: astore 26
    //   17031: aload 20
    //   17033: astore 24
    //   17035: aload 21
    //   17037: astore 25
    //   17039: aload 23
    //   17041: astore 21
    //   17043: aload 26
    //   17045: astore 20
    //   17047: iload 5
    //   17049: istore_3
    //   17050: aload 24
    //   17052: astore 23
    //   17054: aload 25
    //   17056: astore 24
    //   17058: goto -12483 -> 4575
    //   17061: astore 26
    //   17063: goto -16621 -> 442
    //   17066: astore 23
    //   17068: aconst_null
    //   17069: astore 20
    //   17071: aconst_null
    //   17072: astore 21
    //   17074: aconst_null
    //   17075: astore 22
    //   17077: iload 8
    //   17079: istore 4
    //   17081: goto -16841 -> 240
    //   17084: astore 23
    //   17086: aconst_null
    //   17087: astore 24
    //   17089: aconst_null
    //   17090: astore 21
    //   17092: aload 20
    //   17094: astore 22
    //   17096: aload 24
    //   17098: astore 20
    //   17100: iload 8
    //   17102: istore 4
    //   17104: goto -16864 -> 240
    //   17107: astore 23
    //   17109: iload 8
    //   17111: istore 4
    //   17113: goto -16873 -> 240
    //   17116: astore 25
    //   17118: goto -4332 -> 12786
    //   17121: astore 25
    //   17123: goto -6901 -> 10222
    //   17126: astore 25
    //   17128: goto -9417 -> 7711
    //   17131: astore 25
    //   17133: goto -14265 -> 2868
    //   17136: ldc_w 428
    //   17139: astore 22
    //   17141: ldc_w 428
    //   17144: astore 25
    //   17146: goto -12434 -> 4712
    //   17149: ldc_w 428
    //   17152: astore 22
    //   17154: ldc_w 428
    //   17157: astore 24
    //   17159: goto -16702 -> 457
    //   17162: ldc_w 428
    //   17165: astore 22
    //   17167: ldc_w 428
    //   17170: astore 23
    //   17172: goto -4371 -> 12801
    //   17175: ldc_w 428
    //   17178: astore 22
    //   17180: ldc_w 428
    //   17183: astore 23
    //   17185: goto -6948 -> 10237
    //   17188: ldc_w 428
    //   17191: astore 22
    //   17193: ldc_w 428
    //   17196: astore 23
    //   17198: goto -9472 -> 7726
    //   17201: ldc_w 428
    //   17204: astore 22
    //   17206: ldc_w 428
    //   17209: astore 23
    //   17211: goto -14328 -> 2883
    //   17214: iconst_0
    //   17215: istore 4
    //   17217: goto -14563 -> 2654
    //   17220: aconst_null
    //   17221: astore 20
    //   17223: aconst_null
    //   17224: astore 22
    //   17226: aconst_null
    //   17227: astore 21
    //   17229: goto -14624 -> 2605
    //   17232: iconst_1
    //   17233: istore 5
    //   17235: goto -15140 -> 2095
    //   17238: aload 26
    //   17240: astore 21
    //   17242: iload 4
    //   17244: iconst_2
    //   17245: if_icmpge -12798 -> 4447
    //   17248: aload 26
    //   17250: astore 21
    //   17252: iload 10
    //   17254: ifeq -12807 -> 4447
    //   17257: ldc_w 932
    //   17260: astore 21
    //   17262: goto -12815 -> 4447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17265	0	this	FastDownloadTask
    //   0	17265	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	17265	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   29	17021	3	i	int
    //   238	17008	4	j	int
    //   251	16983	5	k	int
    //   263	6255	6	m	int
    //   177	16806	7	n	int
    //   180	16930	8	i1	int
    //   18	109	9	i2	int
    //   198	17055	10	bool1	boolean
    //   23	61	11	bool2	boolean
    //   26	16558	12	l1	long
    //   113	12556	14	l2	long
    //   188	2422	16	l3	long
    //   2534	3	18	l4	long
    //   97	1	20	localException1	java.lang.Exception
    //   183	1	20	localObject1	Object
    //   215	8	20	localUnknownHostException	java.net.UnknownHostException
    //   228	4334	20	localObject2	Object
    //   4566	1675	20	localObject3	Object
    //   6260	9074	20	localObject4	Object
    //   16925	18	20	localObject5	Object
    //   16948	274	20	localObject6	Object
    //   234	16695	21	localObject7	Object
    //   16937	10	21	localObject8	Object
    //   16952	309	21	localObject9	Object
    //   166	6547	22	localObject10	Object
    //   6741	1	22	localException2	java.lang.Exception
    //   6746	257	22	str1	String
    //   7526	186	22	localException3	java.lang.Exception
    //   7724	1180	22	localObject11	Object
    //   9259	1	22	localException4	java.lang.Exception
    //   9264	256	22	str2	String
    //   10039	184	22	localException5	java.lang.Exception
    //   10235	1180	22	localObject12	Object
    //   11770	1	22	localException6	java.lang.Exception
    //   11775	256	22	str3	String
    //   12550	237	22	localException7	java.lang.Exception
    //   12799	1184	22	localObject13	Object
    //   14374	1	22	localException8	java.lang.Exception
    //   14379	257	22	str4	String
    //   15159	8	22	localException9	java.lang.Exception
    //   15228	1	22	localException10	java.lang.Exception
    //   15233	256	22	str5	String
    //   16008	8	22	localException11	java.lang.Exception
    //   16077	1	22	localException12	java.lang.Exception
    //   16082	256	22	str6	String
    //   16857	8	22	localException13	java.lang.Exception
    //   16944	281	22	localObject14	Object
    //   174	1	23	localObject15	Object
    //   225	1467	23	localThrowable1	java.lang.Throwable
    //   2595	4852	23	localObject16	Object
    //   7481	8	23	localException14	java.lang.Exception
    //   7685	2275	23	localObject17	Object
    //   9994	8	23	localException15	java.lang.Exception
    //   10196	2275	23	localObject18	Object
    //   12505	8	23	localException16	java.lang.Exception
    //   12760	1225	23	localObject19	Object
    //   14349	443	23	localThrowable2	java.lang.Throwable
    //   15079	1	23	str7	String
    //   15114	1069	23	localException17	java.lang.Exception
    //   16968	85	23	localObject20	Object
    //   17066	1	23	localThrowable3	java.lang.Throwable
    //   17084	1	23	localThrowable4	java.lang.Throwable
    //   17107	1	23	localThrowable5	java.lang.Throwable
    //   17170	40	23	str8	String
    //   163	15766	24	localObject21	Object
    //   15963	8	24	localException18	java.lang.Exception
    //   16972	186	24	localObject22	Object
    //   397	16381	25	localObject23	Object
    //   16812	8	25	localException19	java.lang.Exception
    //   16940	11	25	localObject24	Object
    //   16961	14	25	localObject25	Object
    //   16989	14	25	localObject26	Object
    //   17009	14	25	localObject27	Object
    //   17037	18	25	localObject28	Object
    //   17116	1	25	localException20	java.lang.Exception
    //   17121	1	25	localException21	java.lang.Exception
    //   17126	1	25	localException22	java.lang.Exception
    //   17131	1	25	localException23	java.lang.Exception
    //   17144	1	25	str9	String
    //   436	16543	26	localObject29	Object
    //   17029	15	26	localObject30	Object
    //   17061	188	26	localException24	java.lang.Exception
    //   368	16397	27	localObject31	Object
    //   16920	1	27	localException25	java.lang.Exception
    //   122	16602	28	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   411	16468	29	localObject32	Object
    //   600	15867	30	localObject33	Object
    //   4855	11853	31	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	83	97	java/lang/Exception
    //   190	200	215	java/net/UnknownHostException
    //   222	225	225	java/lang/Throwable
    //   1993	2044	225	java/lang/Throwable
    //   2044	2092	225	java/lang/Throwable
    //   2095	2129	225	java/lang/Throwable
    //   2129	2189	225	java/lang/Throwable
    //   2204	2210	225	java/lang/Throwable
    //   2215	2227	225	java/lang/Throwable
    //   2231	2239	225	java/lang/Throwable
    //   2243	2271	225	java/lang/Throwable
    //   2275	2299	225	java/lang/Throwable
    //   2303	2387	225	java/lang/Throwable
    //   2387	2418	225	java/lang/Throwable
    //   2418	2425	225	java/lang/Throwable
    //   2430	2457	225	java/lang/Throwable
    //   2457	2489	225	java/lang/Throwable
    //   2489	2536	225	java/lang/Throwable
    //   4432	4444	225	java/lang/Throwable
    //   4447	4464	225	java/lang/Throwable
    //   4469	4481	225	java/lang/Throwable
    //   4485	4493	225	java/lang/Throwable
    //   4497	4531	225	java/lang/Throwable
    //   4535	4559	225	java/lang/Throwable
    //   6243	6255	225	java/lang/Throwable
    //   6262	6269	225	java/lang/Throwable
    //   6273	6295	225	java/lang/Throwable
    //   6300	6312	225	java/lang/Throwable
    //   6316	6324	225	java/lang/Throwable
    //   6328	6356	225	java/lang/Throwable
    //   6360	6384	225	java/lang/Throwable
    //   6391	6403	225	java/lang/Throwable
    //   6406	6426	225	java/lang/Throwable
    //   6436	6459	225	java/lang/Throwable
    //   6464	6476	225	java/lang/Throwable
    //   6480	6488	225	java/lang/Throwable
    //   6492	6551	225	java/lang/Throwable
    //   6551	6625	225	java/lang/Throwable
    //   6628	6640	225	java/lang/Throwable
    //   6643	6672	225	java/lang/Throwable
    //   222	225	4566	finally
    //   1993	2044	4566	finally
    //   2044	2092	4566	finally
    //   2095	2129	4566	finally
    //   2129	2189	4566	finally
    //   2204	2210	4566	finally
    //   2215	2227	4566	finally
    //   2231	2239	4566	finally
    //   2243	2271	4566	finally
    //   2275	2299	4566	finally
    //   2303	2387	4566	finally
    //   2387	2418	4566	finally
    //   2418	2425	4566	finally
    //   2430	2457	4566	finally
    //   2457	2489	4566	finally
    //   2489	2536	4566	finally
    //   4432	4444	4566	finally
    //   4447	4464	4566	finally
    //   4469	4481	4566	finally
    //   4485	4493	4566	finally
    //   4497	4531	4566	finally
    //   4535	4559	4566	finally
    //   6243	6255	4566	finally
    //   6262	6269	4566	finally
    //   6273	6295	4566	finally
    //   6300	6312	4566	finally
    //   6316	6324	4566	finally
    //   6328	6356	4566	finally
    //   6360	6384	4566	finally
    //   6391	6403	4566	finally
    //   6406	6426	4566	finally
    //   6436	6459	4566	finally
    //   6464	6476	4566	finally
    //   6480	6488	4566	finally
    //   6492	6551	4566	finally
    //   6551	6625	4566	finally
    //   6628	6640	4566	finally
    //   6643	6672	4566	finally
    //   2868	2883	6741	java/lang/Exception
    //   3924	3954	7481	java/lang/Exception
    //   7451	7478	7481	java/lang/Exception
    //   3984	4014	7526	java/lang/Exception
    //   7496	7523	7526	java/lang/Exception
    //   7711	7726	9259	java/lang/Exception
    //   8763	8793	9994	java/lang/Exception
    //   9964	9991	9994	java/lang/Exception
    //   8823	8853	10039	java/lang/Exception
    //   10009	10036	10039	java/lang/Exception
    //   10222	10237	11770	java/lang/Exception
    //   11274	11304	12505	java/lang/Exception
    //   12475	12502	12505	java/lang/Exception
    //   11334	11364	12550	java/lang/Exception
    //   12520	12547	12550	java/lang/Exception
    //   2654	2663	14349	java/lang/Throwable
    //   2683	2741	14349	java/lang/Throwable
    //   12619	12635	14349	java/lang/Throwable
    //   12639	12660	14349	java/lang/Throwable
    //   14338	14346	14349	java/lang/Throwable
    //   12786	12801	14374	java/lang/Exception
    //   13842	13872	15114	java/lang/Exception
    //   15084	15111	15114	java/lang/Exception
    //   13902	13932	15159	java/lang/Exception
    //   15129	15156	15159	java/lang/Exception
    //   442	457	15228	java/lang/Exception
    //   1495	1525	15963	java/lang/Exception
    //   15933	15960	15963	java/lang/Exception
    //   1555	1585	16008	java/lang/Exception
    //   15978	16005	16008	java/lang/Exception
    //   4697	4712	16077	java/lang/Exception
    //   5750	5780	16812	java/lang/Exception
    //   16782	16809	16812	java/lang/Exception
    //   5810	5840	16857	java/lang/Exception
    //   16827	16854	16857	java/lang/Exception
    //   4678	4693	16920	java/lang/Exception
    //   2543	2574	16925	finally
    //   2574	2579	16925	finally
    //   6675	6711	16925	finally
    //   2579	2594	16937	finally
    //   2605	2615	16961	finally
    //   2630	2654	16961	finally
    //   6725	6732	16961	finally
    //   14354	14362	16961	finally
    //   2654	2663	16989	finally
    //   2683	2741	16989	finally
    //   12619	12635	16989	finally
    //   12639	12660	16989	finally
    //   14338	14346	16989	finally
    //   240	250	17009	finally
    //   253	262	17029	finally
    //   268	275	17029	finally
    //   281	294	17029	finally
    //   297	302	17029	finally
    //   311	320	17029	finally
    //   423	438	17061	java/lang/Exception
    //   2543	2574	17066	java/lang/Throwable
    //   2574	2579	17066	java/lang/Throwable
    //   6675	6711	17066	java/lang/Throwable
    //   2579	2594	17084	java/lang/Throwable
    //   2605	2615	17107	java/lang/Throwable
    //   2630	2654	17107	java/lang/Throwable
    //   6725	6732	17107	java/lang/Throwable
    //   14354	14362	17107	java/lang/Throwable
    //   12767	12782	17116	java/lang/Exception
    //   10203	10218	17121	java/lang/Exception
    //   7692	7707	17126	java/lang/Exception
    //   2849	2864	17131	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.FastDownloadTask
 * JD-Core Version:    0.7.0.1
 */