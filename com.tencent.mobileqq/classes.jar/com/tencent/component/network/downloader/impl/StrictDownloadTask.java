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
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public class StrictDownloadTask
  extends DownloadTask
{
  private static final Object Extra_Lock = new Object();
  private static final int TIMEOUT_NO_NETWORK = 150000;
  private static List<DownloadGlobalStrategy.StrategyInfo> extraStrategys;
  private int ISP_COUNT = 4;
  int connect_retry = 0;
  long connect_time = 0L;
  int exe_retry = 0;
  long exe_time = 0L;
  private boolean mAPNProxy;
  private boolean mAllowProxy;
  private String mDomainWithPort;
  private int mOrigPort = 0;
  private String mRealUrl;
  private final long mTimeStamp = SystemClock.uptimeMillis();
  Response okResponse = null;
  HttpResponse response = null;
  long send_req_time = 0L;
  private int[] triedIsp = new int[this.ISP_COUNT];
  
  public StrictDownloadTask(Context paramContext, OkHttpClient paramOkHttpClient, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramOkHttpClient, paramQZoneHttpClient, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  private void addTriedIsp(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.ISP_COUNT)) {
      return;
    }
    this.triedIsp[(paramInt - 1)] = 1;
  }
  
  private String generateDownloadDescInfo(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "{" + "1.1" + "," + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramString1 + "," + paramString2 + "," + paramString3 + "," + paramString4 + "," + NetworkManager.getIspType() + "," + NetworkUtils.isNetworkAvailable(this.mContext) + "}";
  }
  
  private void initExtraStrategy()
  {
    if (extraStrategys == null) {
      synchronized (Extra_Lock)
      {
        if (extraStrategys == null)
        {
          extraStrategys = new ArrayList();
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = new DownloadGlobalStrategy.StrategyInfo(6, false, false, false, true);
          localStrategyInfo1.id = 6;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = new DownloadGlobalStrategy.StrategyInfo(7, false, false, false, true);
          localStrategyInfo2.id = 7;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo3 = new DownloadGlobalStrategy.StrategyInfo(8, false, false, false, true);
          localStrategyInfo3.id = 8;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo4 = new DownloadGlobalStrategy.StrategyInfo(9, false, false, false, true);
          localStrategyInfo4.id = 9;
          extraStrategys.add(localStrategyInfo1);
          extraStrategys.add(localStrategyInfo2);
          extraStrategys.add(localStrategyInfo3);
          extraStrategys.add(localStrategyInfo4);
        }
        return;
      }
    }
  }
  
  private int obtainUntriedIsp()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.ISP_COUNT)
      {
        if (this.triedIsp[i] == 0)
        {
          this.triedIsp[i] = 1;
          j = i + 1;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private void printfHttpDetail(HttpRequest paramHttpRequest, Request.Builder paramBuilder, HttpResponse paramHttpResponse, Response paramResponse)
  {
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n/****************************************************/\n");
    localStringBuffer.append("<---------Request Content--------->\n");
    int i;
    if (paramHttpRequest != null)
    {
      localStringBuffer.append(paramHttpRequest.getRequestLine()).append("\n");
      paramHttpRequest = paramHttpRequest.getAllHeaders();
      if (paramHttpRequest != null)
      {
        i = 0;
        while (i < paramHttpRequest.length)
        {
          localStringBuffer.append(paramHttpRequest[i].getName()).append(": ").append(paramHttpRequest[i].getValue()).append("\n");
          i += 1;
        }
      }
    }
    else if (paramBuilder != null)
    {
      localStringBuffer.append(paramBuilder.build().url()).append("\n");
      paramHttpRequest = paramBuilder.build().headers();
      if (paramHttpRequest != null)
      {
        i = 0;
        while (i < paramHttpRequest.size())
        {
          localStringBuffer.append(paramHttpRequest.name(i)).append(": ").append(paramHttpRequest.value(i)).append("\n");
          i += 1;
        }
      }
    }
    localStringBuffer.append("<---------Response Headers--------->\n");
    if (paramHttpResponse != null)
    {
      localStringBuffer.append(paramHttpResponse.getStatusLine()).append("\n");
      paramHttpRequest = paramHttpResponse.getAllHeaders();
      if (paramHttpRequest != null)
      {
        i = j;
        while (i < paramHttpRequest.length)
        {
          localStringBuffer.append(paramHttpRequest[i].getName()).append(": ").append(paramHttpRequest[i].getValue()).append("\n");
          i += 1;
        }
      }
    }
    else if (paramResponse != null)
    {
      localStringBuffer.append(paramResponse.code()).append("\n");
      paramHttpRequest = paramResponse.headers();
      if (paramHttpRequest != null)
      {
        i = k;
        while (i < paramHttpRequest.size())
        {
          localStringBuffer.append(paramHttpRequest.name(i)).append(": ").append(paramHttpRequest.value(i)).append("\n");
          i += 1;
        }
      }
    }
    localStringBuffer.append("/****************************************************/");
    QDLog.w("downloader", "Http Details:" + localStringBuffer.toString());
  }
  
  private boolean setStrategy(int paramInt)
  {
    int j = 80;
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.pDownloadStrategyLib == null)
    {
      this.pDownloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(getUrl(), getDomain(), this.mIsHttp2);
      initExtraStrategy();
      this.pDownloadStrategyLib.copyStrageList();
      this.pDownloadStrategyLib.enableUpdate(false);
      this.pDownloadStrategyLib.addStrategy(extraStrategys);
    }
    this.pOldStrategyInfo = this.pCurrStrategyInfo;
    if (this.pDownloadStrategyLib.getStrategyList() != null) {}
    for (int i = this.pDownloadStrategyLib.getStrategyList().size();; i = 0)
    {
      if (i == 0) {}
      String str;
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
          this.mAttemptCurrCount = 0;
        }
        i = j;
        if (this.mIsHttp2) {
          i = 443;
        }
        this.mStandardPort = i;
        this.pDownloadStrategyLib.setPort(this.mStandardPort);
        if (QDLog.isInfoEnable()) {
          QDLog.i("downloader_strategy", "downloader strategy: " + this.pCurrStrategyInfo.toString() + " currAttempCount:" + paramInt + " attemptStrategyCount:" + this.attemptStrategyCount + " best:" + this.pDownloadStrategyLib.getBestId() + " url:" + getUrl() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
        }
        this.mAllowProxy = this.pCurrStrategyInfo.allowProxy;
        this.mAPNProxy = this.pCurrStrategyInfo.useConfigApn;
        str = getDomain();
        i = this.pDownloadStrategyLib.getPort();
        paramInt = i;
        if (!Utils.isPortValid(i))
        {
          this.pDownloadStrategyLib.setPort(this.mStandardPort);
          paramInt = this.mStandardPort;
        }
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.pCurrStrategyInfo.id) {
          break label812;
        }
        i = paramInt;
        if (this.pOldStrategyInfo == null) {
          break;
        }
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.pOldStrategyInfo.id) {
          break;
        }
        i = paramInt;
        if (this.mIsHttp2) {
          break;
        }
        if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str))) {
          break label723;
        }
        i = this.pPortConfigStrategy.changePort(str, paramInt);
        if ((i != paramInt) && (Utils.isPortValid(i))) {
          break;
        }
      } while (!QDLog.isInfoEnable());
      QDLog.i("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
      return false;
      localObject2 = this.pDownloadStrategyLib.getBackupIP();
      localObject1 = localObject2;
      if (this.pBackupIPConfigStrategy != null)
      {
        localObject1 = localObject2;
        if (!this.pBackupIPConfigStrategy.isIPValid(str, (String)localObject2))
        {
          this.pDownloadStrategyLib.setBackupIP(null);
          localObject1 = this.pBackupIPConfigStrategy.resolveIP(str);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label774;
          }
          this.pDownloadStrategyLib.setBackupIP((String)localObject1);
        }
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
      for (;;)
      {
        addTriedIsp(NetworkManager.getIspType());
        return true;
        label723:
        if (!QDLog.isInfoEnable()) {
          break;
        }
        QDLog.i("downloader", "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
        return false;
        label774:
        if (!QDLog.isInfoEnable()) {
          break;
        }
        QDLog.i("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label812:
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pCurrStrategyInfo.id)
        {
          i = paramInt;
          if (this.pOldStrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pOldStrategyInfo.id)
            {
              i = paramInt;
              if (!this.mIsHttp2)
              {
                if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str))) {
                  break label1077;
                }
                i = this.pPortConfigStrategy.changePort(str, paramInt);
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
          localObject2 = DnsService.getInstance().getDomainIP(str);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = DnsService.getInstance().getDomainIP(str);
          }
          if ((localObject1 == null) || (((String)localObject1).equals(this.pDownloadStrategyLib.getBackupIP())) || (((String)localObject1).equals(this.pDownloadStrategyLib.getDirectIP())))
          {
            this.pDownloadStrategyLib.setDnsIP(null);
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            label1077:
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.pDownloadStrategyLib.setDnsIP((String)localObject1);
          this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
          this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
          continue;
        }
        if (6 == this.pCurrStrategyInfo.id)
        {
          if (this.pDirectIPConfigStrategy != null)
          {
            localObject2 = this.pDirectIPConfigStrategy.resolveIP(str);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = DnsService.getInstance().getDomainIP(str);
            }
          }
          if (localObject1 == null)
          {
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: direct ip is null. Pass! 6 threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
          this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, this.mStandardPort));
          continue;
        }
        if (7 == this.pCurrStrategyInfo.id)
        {
          localObject1 = localObject2;
          if (this.pBackupIPConfigStrategy != null)
          {
            localObject2 = this.pBackupIPConfigStrategy.resolveIP(str);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = DnsService.getInstance().getDomainIP(str);
            }
          }
          if (localObject1 == null)
          {
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: backup ip is null. Pass! 7 threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
          this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, this.mStandardPort));
          continue;
        }
        if (8 == this.pCurrStrategyInfo.id)
        {
          localObject1 = null;
          label1449:
          paramInt = obtainUntriedIsp();
          if (paramInt == 0) {}
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = DnsService.getInstance().getDomainIP(str);
            }
            if (localObject2 != null) {
              break label1564;
            }
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy:  ip is null. Pass! 8 threadId:" + Thread.currentThread().getId());
            return false;
            localObject2 = localObject1;
            if (this.pDirectIPConfigStrategy != null) {
              localObject2 = this.pDirectIPConfigStrategy.resolveIP(str, paramInt);
            }
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1449;
            }
            localObject1 = localObject2;
          }
          label1564:
          this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
          this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject2, this.mStandardPort));
        }
        else if (9 == this.pCurrStrategyInfo.id)
        {
          localObject1 = null;
          label1613:
          paramInt = obtainUntriedIsp();
          if (paramInt == 0) {}
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = DnsService.getInstance().getDomainIP(str);
            }
            if (localObject2 != null) {
              break label1728;
            }
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy:  ip is null. Pass! 9 threadId:" + Thread.currentThread().getId());
            return false;
            localObject2 = localObject1;
            if (this.pDirectIPConfigStrategy != null) {
              localObject2 = this.pDirectIPConfigStrategy.resolveIP(str, paramInt);
            }
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1613;
            }
            localObject1 = localObject2;
          }
          label1728:
          this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
          this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject2, this.mStandardPort));
        }
        else
        {
          if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.pCurrStrategyInfo.id)
          {
            i = paramInt;
            if (this.pOldStrategyInfo != null)
            {
              i = paramInt;
              if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.pOldStrategyInfo.id)
              {
                i = paramInt;
                if (!this.mIsHttp2)
                {
                  if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str))) {
                    break label2065;
                  }
                  i = this.pPortConfigStrategy.changePort(str, paramInt);
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
          }
          label2065:
          do
          {
            localObject2 = this.pDownloadStrategyLib.getDirectIP();
            localObject1 = localObject2;
            if (this.pDirectIPConfigStrategy != null)
            {
              localObject1 = localObject2;
              if (!this.pDirectIPConfigStrategy.isIPValid((String)localObject2, str))
              {
                this.pDownloadStrategyLib.setDirectIP(null);
                localObject1 = this.pDirectIPConfigStrategy.resolveIP(str);
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label2236;
                }
                this.pDownloadStrategyLib.setDirectIP((String)localObject1);
              }
            }
            if ((localObject1 != null) && (!((String)localObject1).equals(this.pDownloadStrategyLib.getBackupIP())) && (!((String)localObject1).equals(this.pDownloadStrategyLib.getDnsIP()))) {
              break label2274;
            }
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: Pass! Direct IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
            return false;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.pCurrStrategyInfo.id) {
              break label2150;
            }
            i = paramInt;
          } while (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != this.pCurrStrategyInfo.id);
          label2150:
          localObject1 = this.mContext;
          if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.pCurrStrategyInfo.id) {}
          for (boolean bool = true;; bool = false)
          {
            if (NetworkUtils.getProxy((Context)localObject1, bool) != null) {
              break label2229;
            }
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
            return false;
          }
          label2229:
          paramInt = this.mStandardPort;
          return true;
          label2236:
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
          label2274:
          this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
          this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
        }
      }
    }
  }
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 510
    //   5: astore 22
    //   7: iconst_2
    //   8: anewarray 37	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_2
    //   21: aastore
    //   22: invokestatic 516	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   25: istore 8
    //   27: lconst_0
    //   28: lstore 9
    //   30: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   33: lstore 15
    //   35: aload_1
    //   36: invokeinterface 521 1 0
    //   41: ifeq +11 -> 52
    //   44: aload_0
    //   45: aload_1
    //   46: aload_2
    //   47: aconst_null
    //   48: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   51: return
    //   52: aload_0
    //   53: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   56: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   59: ifne +30 -> 89
    //   62: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   65: lload 15
    //   67: lsub
    //   68: ldc2_w 526
    //   71: lcmp
    //   72: ifgt +17 -> 89
    //   75: ldc2_w 528
    //   78: invokestatic 533	java/lang/Thread:sleep	(J)V
    //   81: goto -29 -> 52
    //   84: astore 23
    //   86: goto -34 -> 52
    //   89: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   92: lload 15
    //   94: lsub
    //   95: ldc2_w 526
    //   98: lcmp
    //   99: ifle +74 -> 173
    //   102: aload 22
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   109: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   112: ifne +12 -> 124
    //   115: aload_2
    //   116: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   119: bipush 6
    //   121: invokevirtual 544	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   124: aload_2
    //   125: aload_0
    //   126: aload_2
    //   127: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   130: invokevirtual 547	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   133: aload_2
    //   134: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   137: getfield 550	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   140: iload_3
    //   141: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   144: ldc_w 510
    //   147: aload_2
    //   148: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   151: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   154: aload_1
    //   155: invokespecial 561	com/tencent/component/network/downloader/impl/StrictDownloadTask:generateDownloadDescInfo	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 564	com/tencent/component/network/downloader/DownloadResult:setDescInfo	(Ljava/lang/String;)V
    //   161: return
    //   162: astore_1
    //   163: ldc 227
    //   165: ldc_w 510
    //   168: aload_1
    //   169: invokestatic 568	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: return
    //   173: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   176: lstore 17
    //   178: new 570	com/tencent/component/network/downloader/DownloadReport
    //   181: dup
    //   182: invokespecial 571	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   185: astore 31
    //   187: aload 31
    //   189: iload 8
    //   191: putfield 572	com/tencent/component/network/downloader/DownloadReport:id	I
    //   194: aload 31
    //   196: aload_0
    //   197: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   200: putfield 574	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   203: aload 31
    //   205: aload_0
    //   206: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   209: putfield 577	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   212: aload 31
    //   214: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   217: putfield 585	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   220: aload_0
    //   221: aconst_null
    //   222: putfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   225: aload_0
    //   226: aconst_null
    //   227: putfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   230: aload_0
    //   231: aconst_null
    //   232: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   235: aload_0
    //   236: aconst_null
    //   237: putfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   240: aconst_null
    //   241: astore 27
    //   243: aconst_null
    //   244: astore 28
    //   246: aconst_null
    //   247: astore 26
    //   249: iconst_0
    //   250: istore 6
    //   252: iconst_0
    //   253: istore 7
    //   255: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   258: lstore 19
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   265: invokespecial 595	com/tencent/component/network/downloader/impl/StrictDownloadTask:setStrategy	(I)Z
    //   268: istore 21
    //   270: iload 21
    //   272: ifne +16 -> 288
    //   275: aload_0
    //   276: invokevirtual 598	com/tencent/component/network/downloader/impl/StrictDownloadTask:canAttempt	()Z
    //   279: ifne +11673 -> 11952
    //   282: aload 22
    //   284: astore_1
    //   285: goto -180 -> 105
    //   288: aconst_null
    //   289: astore 22
    //   291: aload 22
    //   293: ifnull +1490 -> 1783
    //   296: lload 9
    //   298: lstore 11
    //   300: aload 26
    //   302: astore 24
    //   304: lload 9
    //   306: lstore 13
    //   308: aload 28
    //   310: astore 23
    //   312: aload 22
    //   314: athrow
    //   315: astore 23
    //   317: lload 11
    //   319: lstore 9
    //   321: aload 24
    //   323: astore 22
    //   325: iload 7
    //   327: istore 4
    //   329: aload 23
    //   331: astore 24
    //   333: iload_3
    //   334: istore 5
    //   336: aload_2
    //   337: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   340: aload 24
    //   342: invokevirtual 601	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   345: iload_3
    //   346: istore 6
    //   348: iload_3
    //   349: istore 5
    //   351: aload_0
    //   352: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   355: ifnull +48 -> 403
    //   358: iload_3
    //   359: istore 6
    //   361: iload_3
    //   362: istore 5
    //   364: aload_0
    //   365: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   368: ldc_w 605
    //   371: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   374: ifeq +29 -> 403
    //   377: iload_3
    //   378: istore 5
    //   380: aload_0
    //   381: iconst_1
    //   382: putfield 611	com/tencent/component/network/downloader/impl/StrictDownloadTask:disableHttps	Z
    //   385: iload_3
    //   386: iconst_1
    //   387: isub
    //   388: istore 6
    //   390: iload 6
    //   392: istore 5
    //   394: ldc_w 613
    //   397: ldc_w 615
    //   400: invokestatic 617	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: iload 6
    //   405: iconst_1
    //   406: iadd
    //   407: istore 5
    //   409: aload_2
    //   410: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   413: lload 17
    //   415: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   418: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   421: aload_2
    //   422: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   425: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   428: aload_0
    //   429: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   432: lsub
    //   433: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   436: aload_2
    //   437: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   440: aload_0
    //   441: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   444: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   447: aload_0
    //   448: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   451: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   454: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   457: astore 27
    //   459: aload_0
    //   460: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   463: ifnull +9898 -> 10361
    //   466: aload_0
    //   467: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   470: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   473: ifnull +9888 -> 10361
    //   476: aload_0
    //   477: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   480: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   483: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   486: astore 25
    //   488: aload_0
    //   489: aload_0
    //   490: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   493: aload_0
    //   494: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   497: aload_0
    //   498: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   501: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   504: astore 28
    //   506: aload 25
    //   508: ifnull +9861 -> 10369
    //   511: aload 25
    //   513: astore 23
    //   515: aload 22
    //   517: ifnull +11446 -> 11963
    //   520: aload 22
    //   522: ldc_w 656
    //   525: invokeinterface 662 2 0
    //   530: checkcast 450	java/lang/String
    //   533: astore 22
    //   535: aload_2
    //   536: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   539: aload 22
    //   541: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   544: aload_2
    //   545: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   548: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   551: ifne +64 -> 615
    //   554: aload_0
    //   555: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   558: ifnull +28 -> 586
    //   561: aload_0
    //   562: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   565: aload_0
    //   566: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   569: aload_2
    //   570: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   577: aload_0
    //   578: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   581: invokeinterface 681 5 0
    //   586: aload_0
    //   587: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   590: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   593: ifne +22 -> 615
    //   596: aload_0
    //   597: aload_0
    //   598: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   601: iconst_1
    //   602: isub
    //   603: putfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   606: aload_2
    //   607: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   610: bipush 6
    //   612: invokevirtual 544	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   615: aload_1
    //   616: invokeinterface 521 1 0
    //   621: ifne +1124 -> 1745
    //   624: aload_2
    //   625: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   628: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   631: ifne +9790 -> 10421
    //   634: new 80	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   641: ldc_w 683
    //   644: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload_0
    //   648: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   651: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc_w 685
    //   657: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_0
    //   661: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   664: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   667: ldc_w 687
    //   670: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: astore 29
    //   675: aload_0
    //   676: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   679: ifeq +9708 -> 10387
    //   682: aload_0
    //   683: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   686: ifnull +9701 -> 10387
    //   689: aload_0
    //   690: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   693: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   696: ifnull +9691 -> 10387
    //   699: aload_0
    //   700: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   703: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   706: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   709: astore 26
    //   711: aload 29
    //   713: aload 26
    //   715: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: ldc_w 696
    //   721: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 27
    //   726: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   729: ldc_w 701
    //   732: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 25
    //   737: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc_w 703
    //   743: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: ldc_w 705
    //   749: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: ldc_w 707
    //   755: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   761: invokevirtual 342	java/lang/Thread:getId	()J
    //   764: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   767: ldc_w 709
    //   770: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   776: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: ldc_w 711
    //   782: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: aload_0
    //   786: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   789: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: ldc_w 713
    //   795: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_0
    //   799: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   802: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   805: ldc_w 715
    //   808: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: astore 26
    //   813: aload_0
    //   814: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   817: ifeq +9578 -> 10395
    //   820: aload_0
    //   821: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   824: aload_0
    //   825: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   828: invokestatic 498	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   831: astore 25
    //   833: aload 26
    //   835: aload 25
    //   837: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   840: ldc_w 717
    //   843: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: aload_0
    //   847: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   850: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   853: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   856: ldc_w 719
    //   859: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   865: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   868: ldc_w 726
    //   871: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload_2
    //   875: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   878: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   881: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: ldc_w 728
    //   887: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: aload_2
    //   891: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   894: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   897: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   900: ldc_w 733
    //   903: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   909: aload_0
    //   910: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   913: lsub
    //   914: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   917: ldc_w 735
    //   920: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: aload_2
    //   924: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   927: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   930: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   933: ldc_w 740
    //   936: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload_2
    //   940: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   943: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   946: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   949: ldc_w 744
    //   952: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload_2
    //   956: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   959: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   962: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   965: ldc_w 749
    //   968: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: aload_0
    //   972: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   975: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   978: ldc 91
    //   980: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload_0
    //   984: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   987: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   990: ldc_w 754
    //   993: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: iload 5
    //   998: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1001: ldc_w 756
    //   1004: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload_2
    //   1008: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1011: invokevirtual 547	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   1014: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1017: ldc_w 758
    //   1020: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: iload 4
    //   1025: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1028: ldc_w 760
    //   1031: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload 28
    //   1036: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: ldc_w 762
    //   1042: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload 22
    //   1047: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: ldc_w 764
    //   1053: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: astore 25
    //   1058: aload_0
    //   1059: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1062: ifnull +9339 -> 10401
    //   1065: aload_0
    //   1066: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1069: iconst_0
    //   1070: bipush 30
    //   1072: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   1075: astore 22
    //   1077: aload 25
    //   1079: aload 22
    //   1081: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 770
    //   1087: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: astore 22
    //   1092: aload_0
    //   1093: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1096: ifnull +9314 -> 10410
    //   1099: aload_0
    //   1100: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1103: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1106: istore_3
    //   1107: aload 22
    //   1109: iload_3
    //   1110: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1113: ldc_w 772
    //   1116: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: aload_2
    //   1120: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1123: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: ldc_w 777
    //   1132: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: lload 9
    //   1137: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1140: ldc_w 779
    //   1143: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: aload_0
    //   1147: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   1150: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1153: ldc 91
    //   1155: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: aload_0
    //   1159: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   1162: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1165: ldc_w 781
    //   1168: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: aload_0
    //   1172: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   1175: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1178: ldc 91
    //   1180: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: aload_0
    //   1184: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   1187: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1190: ldc_w 783
    //   1193: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_0
    //   1197: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   1200: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1203: ldc_w 785
    //   1206: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: aload_0
    //   1210: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   1213: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1216: ldc_w 790
    //   1219: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: aload_0
    //   1223: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   1226: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1229: ldc_w 795
    //   1232: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: astore 25
    //   1237: aload_0
    //   1238: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1241: ifnull +9174 -> 10415
    //   1244: aload_0
    //   1245: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1248: invokeinterface 805 1 0
    //   1253: astore 22
    //   1255: ldc_w 613
    //   1258: aload 25
    //   1260: aload 22
    //   1262: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1265: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1268: aload 24
    //   1270: invokestatic 568	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1273: aload_0
    //   1274: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1277: ifnull +53 -> 1330
    //   1280: getstatic 369	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1283: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1286: aload_0
    //   1287: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1290: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1293: if_icmpne +37 -> 1330
    //   1296: aload_0
    //   1297: getfield 396	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1300: ifnull +30 -> 1330
    //   1303: aload_0
    //   1304: getfield 396	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1307: aload_0
    //   1308: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1311: aload_0
    //   1312: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1315: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1318: aload_2
    //   1319: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1322: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1325: invokeinterface 812 4 0
    //   1330: aload_0
    //   1331: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1334: ifnull +53 -> 1387
    //   1337: getstatic 480	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1340: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1343: aload_0
    //   1344: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1347: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1350: if_icmpne +37 -> 1387
    //   1353: aload_0
    //   1354: getfield 464	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1357: ifnull +30 -> 1387
    //   1360: aload_0
    //   1361: getfield 464	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1364: aload_0
    //   1365: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1368: aload_0
    //   1369: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1372: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1375: aload_2
    //   1376: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1379: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1382: invokeinterface 812 4 0
    //   1387: aload 31
    //   1389: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   1392: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1395: aload 31
    //   1397: aload_0
    //   1398: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   1401: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1404: aload 31
    //   1406: aload_0
    //   1407: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   1410: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1413: aload 31
    //   1415: iload 4
    //   1417: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1420: aload 31
    //   1422: aload 24
    //   1424: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1427: aload 27
    //   1429: ifnonnull +9665 -> 11094
    //   1432: aconst_null
    //   1433: astore 22
    //   1435: aload 31
    //   1437: aload 22
    //   1439: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1442: aload_0
    //   1443: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1446: ifnull +9658 -> 11104
    //   1449: aload_0
    //   1450: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1453: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1456: ifnull +9648 -> 11104
    //   1459: aload_0
    //   1460: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1463: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1466: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   1469: astore 22
    //   1471: aload 31
    //   1473: aload 22
    //   1475: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   1478: aload 31
    //   1480: ldc_w 705
    //   1483: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1486: aload 31
    //   1488: aload_2
    //   1489: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1492: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1495: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1498: aload 31
    //   1500: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   1503: aload_0
    //   1504: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   1507: lsub
    //   1508: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1511: aload 31
    //   1513: aload_2
    //   1514: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1517: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1520: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1523: aload 31
    //   1525: aload 31
    //   1527: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1530: aload_2
    //   1531: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1534: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1537: lsub
    //   1538: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1541: aload 31
    //   1543: lload 9
    //   1545: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1548: aload 31
    //   1550: aload_0
    //   1551: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   1554: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1557: aload 31
    //   1559: aload_0
    //   1560: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   1563: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1566: aload 31
    //   1568: aload_0
    //   1569: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   1572: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1575: aload 31
    //   1577: lconst_0
    //   1578: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1581: aload 31
    //   1583: aload_0
    //   1584: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   1587: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1590: aload 31
    //   1592: aload_2
    //   1593: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1596: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1599: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1602: aload 31
    //   1604: aload_0
    //   1605: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1608: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1611: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1614: aload 31
    //   1616: aload_0
    //   1617: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   1620: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1623: aload_0
    //   1624: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1627: ifnull +9483 -> 11110
    //   1630: aload_0
    //   1631: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1634: ldc_w 880
    //   1637: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1640: ifeq +9470 -> 11110
    //   1643: iconst_1
    //   1644: istore 21
    //   1646: aload 31
    //   1648: iload 21
    //   1650: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1653: aload 31
    //   1655: aload_2
    //   1656: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1659: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1662: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1665: aload 31
    //   1667: getstatic 891	com/tencent/component/network/downloader/Downloader$DownloadMode:StrictMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   1670: invokevirtual 894	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   1673: putfield 897	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   1676: aload_0
    //   1677: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   1680: ifnull +28 -> 1708
    //   1683: aload_0
    //   1684: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   1687: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1690: ifnull +18 -> 1708
    //   1693: aload 31
    //   1695: aload_0
    //   1696: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   1699: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1702: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1705: putfield 899	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   1708: aload_2
    //   1709: aload 31
    //   1711: invokevirtual 903	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1714: aload_0
    //   1715: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   1718: aload_0
    //   1719: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   1722: iconst_1
    //   1723: isub
    //   1724: if_icmpeq +13 -> 1737
    //   1727: aload_2
    //   1728: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1731: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1734: ifeq +11 -> 1745
    //   1737: aload_0
    //   1738: aload_1
    //   1739: aload_2
    //   1740: aload 31
    //   1742: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1745: aload_0
    //   1746: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   1749: ifeq +9367 -> 11116
    //   1752: aload_0
    //   1753: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1756: ifnull +12 -> 1768
    //   1759: aload_0
    //   1760: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1763: invokeinterface 912 1 0
    //   1768: aload_0
    //   1769: aconst_null
    //   1770: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1773: aload 23
    //   1775: astore 22
    //   1777: iload 5
    //   1779: istore_3
    //   1780: goto -1505 -> 275
    //   1783: lload 9
    //   1785: lstore 11
    //   1787: aload 26
    //   1789: astore 24
    //   1791: lload 9
    //   1793: lstore 13
    //   1795: aload 28
    //   1797: astore 23
    //   1799: getstatic 916	com/tencent/component/network/downloader/impl/StrictDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   1802: invokevirtual 922	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1805: checkcast 924	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   1808: astore 32
    //   1810: lload 9
    //   1812: lstore 11
    //   1814: aload 26
    //   1816: astore 24
    //   1818: lload 9
    //   1820: lstore 13
    //   1822: aload 28
    //   1824: astore 23
    //   1826: aload 32
    //   1828: aload_0
    //   1829: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   1832: putfield 925	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   1835: lload 9
    //   1837: lstore 11
    //   1839: aload 26
    //   1841: astore 24
    //   1843: lload 9
    //   1845: lstore 13
    //   1847: aload 28
    //   1849: astore 23
    //   1851: aload 32
    //   1853: aload_0
    //   1854: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   1857: putfield 928	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   1860: lload 9
    //   1862: lstore 11
    //   1864: aload 26
    //   1866: astore 24
    //   1868: lload 9
    //   1870: lstore 13
    //   1872: aload 28
    //   1874: astore 23
    //   1876: aload_0
    //   1877: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1880: ifnull +2780 -> 4660
    //   1883: lload 9
    //   1885: lstore 11
    //   1887: aload 26
    //   1889: astore 24
    //   1891: lload 9
    //   1893: lstore 13
    //   1895: aload 28
    //   1897: astore 23
    //   1899: aload_0
    //   1900: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1903: invokeinterface 805 1 0
    //   1908: astore 22
    //   1910: lload 9
    //   1912: lstore 11
    //   1914: aload 26
    //   1916: astore 24
    //   1918: lload 9
    //   1920: lstore 13
    //   1922: aload 28
    //   1924: astore 23
    //   1926: aload 32
    //   1928: aload 22
    //   1930: putfield 932	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   1933: lload 9
    //   1935: lstore 11
    //   1937: aload 26
    //   1939: astore 24
    //   1941: lload 9
    //   1943: lstore 13
    //   1945: aload 28
    //   1947: astore 23
    //   1949: aload 31
    //   1951: iload_3
    //   1952: putfield 935	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   1955: lload 9
    //   1957: lstore 11
    //   1959: aload 26
    //   1961: astore 24
    //   1963: lload 9
    //   1965: lstore 13
    //   1967: aload 28
    //   1969: astore 23
    //   1971: aload_2
    //   1972: invokevirtual 938	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   1975: lload 9
    //   1977: lstore 11
    //   1979: aload 26
    //   1981: astore 24
    //   1983: lload 9
    //   1985: lstore 13
    //   1987: aload 28
    //   1989: astore 23
    //   1991: aload_0
    //   1992: aload_0
    //   1993: aload_0
    //   1994: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1997: invokevirtual 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   2000: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2003: lload 9
    //   2005: lstore 11
    //   2007: aload 26
    //   2009: astore 24
    //   2011: lload 9
    //   2013: lstore 13
    //   2015: aload 28
    //   2017: astore 23
    //   2019: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2022: iconst_2
    //   2023: if_icmpeq +9964 -> 11987
    //   2026: lload 9
    //   2028: lstore 11
    //   2030: aload 26
    //   2032: astore 24
    //   2034: lload 9
    //   2036: lstore 13
    //   2038: aload 28
    //   2040: astore 23
    //   2042: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2045: iconst_3
    //   2046: if_icmpne +2620 -> 4666
    //   2049: goto +9938 -> 11987
    //   2052: lload 9
    //   2054: lstore 11
    //   2056: aload 26
    //   2058: astore 24
    //   2060: lload 9
    //   2062: lstore 13
    //   2064: aload 28
    //   2066: astore 23
    //   2068: aload_0
    //   2069: invokevirtual 944	com/tencent/component/network/downloader/impl/StrictDownloadTask:enableIpv6Debug	()Z
    //   2072: istore 21
    //   2074: lload 9
    //   2076: lstore 11
    //   2078: aload 26
    //   2080: astore 24
    //   2082: lload 9
    //   2084: lstore 13
    //   2086: aload 28
    //   2088: astore 23
    //   2090: aload 32
    //   2092: getfield 932	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2095: ifnonnull +4549 -> 6644
    //   2098: lload 9
    //   2100: lstore 11
    //   2102: aload 26
    //   2104: astore 24
    //   2106: lload 9
    //   2108: lstore 13
    //   2110: aload 28
    //   2112: astore 23
    //   2114: aload_0
    //   2115: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2118: ldc_w 880
    //   2121: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2124: ifeq +26 -> 2150
    //   2127: lload 9
    //   2129: lstore 11
    //   2131: aload 26
    //   2133: astore 24
    //   2135: lload 9
    //   2137: lstore 13
    //   2139: aload 28
    //   2141: astore 23
    //   2143: aload_0
    //   2144: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   2147: ifeq +4497 -> 6644
    //   2150: lload 9
    //   2152: lstore 11
    //   2154: aload 26
    //   2156: astore 24
    //   2158: lload 9
    //   2160: lstore 13
    //   2162: aload 28
    //   2164: astore 23
    //   2166: aload_0
    //   2167: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2170: ifnull +4474 -> 6644
    //   2173: lload 9
    //   2175: lstore 11
    //   2177: aload 26
    //   2179: astore 24
    //   2181: lload 9
    //   2183: lstore 13
    //   2185: aload 28
    //   2187: astore 23
    //   2189: aload_0
    //   2190: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2193: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2196: ifnull +4448 -> 6644
    //   2199: lload 9
    //   2201: lstore 11
    //   2203: aload 26
    //   2205: astore 24
    //   2207: lload 9
    //   2209: lstore 13
    //   2211: aload 28
    //   2213: astore 23
    //   2215: aload_0
    //   2216: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2219: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2222: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2225: invokestatic 416	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2228: ifne +4416 -> 6644
    //   2231: lload 9
    //   2233: lstore 11
    //   2235: aload 26
    //   2237: astore 24
    //   2239: lload 9
    //   2241: lstore 13
    //   2243: aload 28
    //   2245: astore 23
    //   2247: aload_0
    //   2248: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2251: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2254: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2257: astore 30
    //   2259: lload 9
    //   2261: lstore 11
    //   2263: aload 26
    //   2265: astore 24
    //   2267: lload 9
    //   2269: lstore 13
    //   2271: aload 28
    //   2273: astore 23
    //   2275: aload_0
    //   2276: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2279: astore 29
    //   2281: lload 9
    //   2283: lstore 11
    //   2285: aload 26
    //   2287: astore 24
    //   2289: lload 9
    //   2291: lstore 13
    //   2293: aload 28
    //   2295: astore 23
    //   2297: aload 30
    //   2299: bipush 58
    //   2301: invokestatic 948	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   2304: istore 5
    //   2306: iload 4
    //   2308: ifne +9685 -> 11993
    //   2311: aload 29
    //   2313: astore 22
    //   2315: iload 5
    //   2317: iconst_2
    //   2318: if_icmpge +198 -> 2516
    //   2321: lload 9
    //   2323: lstore 11
    //   2325: aload 26
    //   2327: astore 24
    //   2329: lload 9
    //   2331: lstore 13
    //   2333: aload 28
    //   2335: astore 23
    //   2337: aload_0
    //   2338: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   2341: istore 4
    //   2343: iload 4
    //   2345: ifle +2327 -> 4672
    //   2348: lload 9
    //   2350: lstore 11
    //   2352: aload 26
    //   2354: astore 24
    //   2356: lload 9
    //   2358: lstore 13
    //   2360: aload 28
    //   2362: astore 23
    //   2364: aload_0
    //   2365: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2368: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2371: iload 4
    //   2373: putfield 951	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2376: lload 9
    //   2378: lstore 11
    //   2380: aload 26
    //   2382: astore 24
    //   2384: iload 4
    //   2386: istore 5
    //   2388: lload 9
    //   2390: lstore 13
    //   2392: aload 28
    //   2394: astore 23
    //   2396: iload 4
    //   2398: invokestatic 366	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   2401: ifne +7 -> 2408
    //   2404: bipush 80
    //   2406: istore 5
    //   2408: lload 9
    //   2410: lstore 11
    //   2412: aload 26
    //   2414: astore 24
    //   2416: lload 9
    //   2418: lstore 13
    //   2420: aload 28
    //   2422: astore 23
    //   2424: new 80	java/lang/StringBuilder
    //   2427: dup
    //   2428: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2431: aload 30
    //   2433: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: ldc_w 953
    //   2439: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: iload 5
    //   2444: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2447: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2450: astore 25
    //   2452: lload 9
    //   2454: lstore 11
    //   2456: aload 26
    //   2458: astore 24
    //   2460: aload 25
    //   2462: astore 22
    //   2464: lload 9
    //   2466: lstore 13
    //   2468: aload 28
    //   2470: astore 23
    //   2472: aload_0
    //   2473: getfield 955	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2476: ifnull +40 -> 2516
    //   2479: lload 9
    //   2481: lstore 11
    //   2483: aload 26
    //   2485: astore 24
    //   2487: lload 9
    //   2489: lstore 13
    //   2491: aload 28
    //   2493: astore 23
    //   2495: aload_0
    //   2496: aload_0
    //   2497: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2500: aload_0
    //   2501: getfield 955	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2504: aload 25
    //   2506: invokevirtual 959	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2509: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2512: aload 25
    //   2514: astore 22
    //   2516: lload 9
    //   2518: lstore 11
    //   2520: aload 26
    //   2522: astore 24
    //   2524: lload 9
    //   2526: lstore 13
    //   2528: aload 28
    //   2530: astore 23
    //   2532: aload 31
    //   2534: aload_0
    //   2535: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2538: invokevirtual 313	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2541: putfield 962	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2544: lload 9
    //   2546: lstore 11
    //   2548: aload 26
    //   2550: astore 24
    //   2552: lload 9
    //   2554: lstore 13
    //   2556: aload 28
    //   2558: astore 23
    //   2560: invokestatic 965	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   2563: ifeq +87 -> 2650
    //   2566: lload 9
    //   2568: lstore 11
    //   2570: aload 26
    //   2572: astore 24
    //   2574: lload 9
    //   2576: lstore 13
    //   2578: aload 28
    //   2580: astore 23
    //   2582: ldc 227
    //   2584: new 80	java/lang/StringBuilder
    //   2587: dup
    //   2588: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2591: ldc_w 967
    //   2594: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2597: aload 31
    //   2599: getfield 962	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2602: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2605: ldc_w 969
    //   2608: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2611: aload 22
    //   2613: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2616: ldc_w 324
    //   2619: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: aload_0
    //   2623: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2626: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: ldc_w 389
    //   2632: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2635: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2638: invokevirtual 342	java/lang/Thread:getId	()J
    //   2641: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2644: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2647: invokestatic 972	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2650: lload 9
    //   2652: lstore 11
    //   2654: aload 26
    //   2656: astore 24
    //   2658: lload 9
    //   2660: lstore 13
    //   2662: aload 28
    //   2664: astore 23
    //   2666: aload_0
    //   2667: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2670: ifnull +59 -> 2729
    //   2673: lload 9
    //   2675: lstore 11
    //   2677: aload 26
    //   2679: astore 24
    //   2681: lload 9
    //   2683: lstore 13
    //   2685: aload 28
    //   2687: astore 23
    //   2689: aload 31
    //   2691: aload_0
    //   2692: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2695: invokevirtual 313	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2698: putfield 962	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2701: lload 9
    //   2703: lstore 11
    //   2705: aload 26
    //   2707: astore 24
    //   2709: lload 9
    //   2711: lstore 13
    //   2713: aload 28
    //   2715: astore 23
    //   2717: aload 31
    //   2719: aload_0
    //   2720: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2723: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2726: putfield 975	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2729: lload 9
    //   2731: lstore 11
    //   2733: aload 26
    //   2735: astore 24
    //   2737: lload 9
    //   2739: lstore 13
    //   2741: aload 28
    //   2743: astore 23
    //   2745: aload_0
    //   2746: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   2749: ifeq +4341 -> 7090
    //   2752: lload 9
    //   2754: lstore 11
    //   2756: aload 26
    //   2758: astore 24
    //   2760: lload 9
    //   2762: lstore 13
    //   2764: aload 28
    //   2766: astore 23
    //   2768: aload_0
    //   2769: aload_0
    //   2770: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   2773: aload_0
    //   2774: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2777: aload_0
    //   2778: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2781: aload_0
    //   2782: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2785: invokestatic 981	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   2788: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2791: lload 9
    //   2793: lstore 11
    //   2795: aload 26
    //   2797: astore 24
    //   2799: lload 9
    //   2801: lstore 13
    //   2803: aload 28
    //   2805: astore 23
    //   2807: aload_0
    //   2808: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2811: ifnull +44 -> 2855
    //   2814: lload 9
    //   2816: lstore 11
    //   2818: aload 26
    //   2820: astore 24
    //   2822: lload 9
    //   2824: lstore 13
    //   2826: aload 28
    //   2828: astore 23
    //   2830: aload_0
    //   2831: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2834: aload_0
    //   2835: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2838: aload_0
    //   2839: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2842: aload_0
    //   2843: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2846: aload_0
    //   2847: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2850: invokeinterface 985 5 0
    //   2855: lload 9
    //   2857: lstore 11
    //   2859: aload 26
    //   2861: astore 24
    //   2863: lload 9
    //   2865: lstore 13
    //   2867: aload 28
    //   2869: astore 23
    //   2871: aload_0
    //   2872: aload_0
    //   2873: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2876: aload_0
    //   2877: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2880: aload_0
    //   2881: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2884: aload_0
    //   2885: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2888: invokevirtual 988	com/tencent/component/network/downloader/impl/StrictDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   2891: lload 9
    //   2893: lstore 11
    //   2895: aload 26
    //   2897: astore 24
    //   2899: lload 9
    //   2901: lstore 13
    //   2903: aload 28
    //   2905: astore 23
    //   2907: aload_0
    //   2908: aload_0
    //   2909: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2912: aload_0
    //   2913: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2916: aload_0
    //   2917: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2920: aload_0
    //   2921: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2924: aload 32
    //   2926: invokevirtual 992	com/tencent/component/network/downloader/impl/StrictDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2929: lload 9
    //   2931: lstore 11
    //   2933: aload 26
    //   2935: astore 24
    //   2937: lload 9
    //   2939: lstore 13
    //   2941: aload 28
    //   2943: astore 23
    //   2945: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   2948: lload 19
    //   2950: lsub
    //   2951: lstore 9
    //   2953: lload 9
    //   2955: lstore 11
    //   2957: aload 26
    //   2959: astore 24
    //   2961: lload 9
    //   2963: lstore 13
    //   2965: aload 28
    //   2967: astore 23
    //   2969: aload_0
    //   2970: lconst_0
    //   2971: putfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   2974: lload 9
    //   2976: lstore 11
    //   2978: aload 26
    //   2980: astore 24
    //   2982: lload 9
    //   2984: lstore 13
    //   2986: aload 28
    //   2988: astore 23
    //   2990: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   2993: lstore 19
    //   2995: lload 9
    //   2997: lstore 11
    //   2999: aload 26
    //   3001: astore 24
    //   3003: lload 9
    //   3005: lstore 13
    //   3007: aload 28
    //   3009: astore 23
    //   3011: aload_0
    //   3012: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3015: ifnull +4119 -> 7134
    //   3018: lload 9
    //   3020: lstore 11
    //   3022: aload 26
    //   3024: astore 24
    //   3026: lload 9
    //   3028: lstore 13
    //   3030: aload 28
    //   3032: astore 23
    //   3034: aload_0
    //   3035: getfield 996	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   3038: ifnonnull +26 -> 3064
    //   3041: lload 9
    //   3043: lstore 11
    //   3045: aload 26
    //   3047: astore 24
    //   3049: lload 9
    //   3051: lstore 13
    //   3053: aload 28
    //   3055: astore 23
    //   3057: aload_0
    //   3058: invokestatic 1000	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   3061: putfield 996	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   3064: lload 9
    //   3066: lstore 11
    //   3068: aload 26
    //   3070: astore 24
    //   3072: lload 9
    //   3074: lstore 13
    //   3076: aload 28
    //   3078: astore 23
    //   3080: invokestatic 1004	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   3083: astore 22
    //   3085: aload_0
    //   3086: aload_0
    //   3087: getfield 996	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   3090: aload_0
    //   3091: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3094: aload 22
    //   3096: invokevirtual 1009	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   3099: putfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3102: lload 9
    //   3104: lstore 11
    //   3106: aload 22
    //   3108: astore 24
    //   3110: lload 9
    //   3112: lstore 13
    //   3114: aload 22
    //   3116: astore 23
    //   3118: aload_0
    //   3119: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3122: lload 19
    //   3124: lsub
    //   3125: putfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   3128: lload 9
    //   3130: lstore 11
    //   3132: aload 22
    //   3134: astore 24
    //   3136: lload 9
    //   3138: lstore 13
    //   3140: aload 22
    //   3142: astore 23
    //   3144: aload_0
    //   3145: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3148: ifnonnull +26 -> 3174
    //   3151: lload 9
    //   3153: lstore 11
    //   3155: aload 22
    //   3157: astore 24
    //   3159: lload 9
    //   3161: lstore 13
    //   3163: aload 22
    //   3165: astore 23
    //   3167: aload_0
    //   3168: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3171: ifnull +6388 -> 9559
    //   3174: lload 9
    //   3176: lstore 11
    //   3178: aload 22
    //   3180: astore 24
    //   3182: lload 9
    //   3184: lstore 13
    //   3186: aload 22
    //   3188: astore 23
    //   3190: aload_0
    //   3191: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3194: ifnull +4037 -> 7231
    //   3197: lload 9
    //   3199: lstore 11
    //   3201: aload 22
    //   3203: astore 24
    //   3205: lload 9
    //   3207: lstore 13
    //   3209: aload 22
    //   3211: astore 23
    //   3213: aload_0
    //   3214: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3217: invokeinterface 213 1 0
    //   3222: invokeinterface 1014 1 0
    //   3227: istore 4
    //   3229: aload_2
    //   3230: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3233: iload 4
    //   3235: putfield 550	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   3238: sipush 200
    //   3241: iload 4
    //   3243: if_icmpeq +11 -> 3254
    //   3246: sipush 206
    //   3249: iload 4
    //   3251: if_icmpne +4803 -> 8054
    //   3254: iload 4
    //   3256: istore 5
    //   3258: aload_0
    //   3259: aload_0
    //   3260: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3263: aload_0
    //   3264: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3267: aload_2
    //   3268: aload_1
    //   3269: iload 4
    //   3271: invokevirtual 1018	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   3274: ifeq +4908 -> 8182
    //   3277: aload_2
    //   3278: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3281: invokevirtual 1021	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   3284: iload_3
    //   3285: iconst_1
    //   3286: iadd
    //   3287: istore 5
    //   3289: aload_2
    //   3290: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3293: lload 17
    //   3295: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3298: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3301: aload_2
    //   3302: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3305: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3308: aload_0
    //   3309: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   3312: lsub
    //   3313: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3316: aload_2
    //   3317: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3320: aload_0
    //   3321: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   3324: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3327: aload_0
    //   3328: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3331: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3334: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3337: astore 26
    //   3339: aload_0
    //   3340: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3343: ifnull +3939 -> 7282
    //   3346: aload_0
    //   3347: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3350: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3353: ifnull +3929 -> 7282
    //   3356: aload_0
    //   3357: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3360: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3363: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   3366: astore 24
    //   3368: aload_0
    //   3369: aload_0
    //   3370: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3373: aload_0
    //   3374: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3377: aload_0
    //   3378: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3381: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   3384: astore 27
    //   3386: aload 24
    //   3388: ifnull +3902 -> 7290
    //   3391: aload 24
    //   3393: astore 23
    //   3395: aload 22
    //   3397: ifnull +8582 -> 11979
    //   3400: aload 22
    //   3402: ldc_w 656
    //   3405: invokeinterface 662 2 0
    //   3410: checkcast 450	java/lang/String
    //   3413: astore 22
    //   3415: aload_2
    //   3416: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3419: aload 22
    //   3421: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3424: aload_2
    //   3425: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3428: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3431: ifne +64 -> 3495
    //   3434: aload_0
    //   3435: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3438: ifnull +28 -> 3466
    //   3441: aload_0
    //   3442: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3445: aload_0
    //   3446: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   3449: aload_2
    //   3450: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3453: aload_0
    //   3454: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3457: aload_0
    //   3458: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3461: invokeinterface 681 5 0
    //   3466: aload_0
    //   3467: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3470: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3473: ifne +22 -> 3495
    //   3476: aload_0
    //   3477: aload_0
    //   3478: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3481: iconst_1
    //   3482: isub
    //   3483: putfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3486: aload_2
    //   3487: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3490: bipush 6
    //   3492: invokevirtual 544	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3495: aload_1
    //   3496: invokeinterface 521 1 0
    //   3501: ifne +1122 -> 4623
    //   3504: aload_2
    //   3505: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3508: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3511: ifne +3831 -> 7342
    //   3514: new 80	java/lang/StringBuilder
    //   3517: dup
    //   3518: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   3521: ldc_w 683
    //   3524: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3527: aload_0
    //   3528: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   3531: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3534: ldc_w 685
    //   3537: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3540: aload_0
    //   3541: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   3544: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3547: ldc_w 687
    //   3550: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3553: astore 28
    //   3555: aload_0
    //   3556: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   3559: ifeq +3749 -> 7308
    //   3562: aload_0
    //   3563: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3566: ifnull +3742 -> 7308
    //   3569: aload_0
    //   3570: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3573: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3576: ifnull +3732 -> 7308
    //   3579: aload_0
    //   3580: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3583: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3586: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3589: astore 25
    //   3591: aload 28
    //   3593: aload 25
    //   3595: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: ldc_w 696
    //   3601: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3604: aload 26
    //   3606: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3609: ldc_w 701
    //   3612: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: aload 24
    //   3617: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3620: ldc_w 703
    //   3623: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3626: ldc_w 705
    //   3629: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3632: ldc_w 707
    //   3635: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3638: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3641: invokevirtual 342	java/lang/Thread:getId	()J
    //   3644: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3647: ldc_w 709
    //   3650: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3653: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3656: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3659: ldc_w 711
    //   3662: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3665: aload_0
    //   3666: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   3669: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3672: ldc_w 713
    //   3675: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3678: aload_0
    //   3679: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   3682: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3685: ldc_w 715
    //   3688: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3691: astore 25
    //   3693: aload_0
    //   3694: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   3697: ifeq +3619 -> 7316
    //   3700: aload_0
    //   3701: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3704: aload_0
    //   3705: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   3708: invokestatic 498	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3711: astore 24
    //   3713: aload 25
    //   3715: aload 24
    //   3717: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3720: ldc_w 717
    //   3723: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3726: aload_0
    //   3727: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3730: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3733: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3736: ldc_w 719
    //   3739: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3742: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3745: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3748: ldc_w 726
    //   3751: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3754: aload_2
    //   3755: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3758: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3761: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3764: ldc_w 728
    //   3767: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: aload_2
    //   3771: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3774: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3777: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3780: ldc_w 733
    //   3783: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3786: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3789: aload_0
    //   3790: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   3793: lsub
    //   3794: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3797: ldc_w 735
    //   3800: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3803: aload_2
    //   3804: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3807: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3810: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3813: ldc_w 740
    //   3816: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3819: aload_2
    //   3820: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3823: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3826: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3829: ldc_w 744
    //   3832: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3835: aload_2
    //   3836: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3839: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3842: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3845: ldc_w 749
    //   3848: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3851: aload_0
    //   3852: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3855: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3858: ldc 91
    //   3860: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3863: aload_0
    //   3864: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   3867: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3870: ldc_w 754
    //   3873: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3876: iload 5
    //   3878: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3881: ldc_w 756
    //   3884: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3887: aload_2
    //   3888: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3891: invokevirtual 547	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3894: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3897: ldc_w 758
    //   3900: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3903: iload 4
    //   3905: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3908: ldc_w 760
    //   3911: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3914: aload 27
    //   3916: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3919: ldc_w 762
    //   3922: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3925: aload 22
    //   3927: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3930: ldc_w 764
    //   3933: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3936: astore 24
    //   3938: aload_0
    //   3939: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   3942: ifnull +3380 -> 7322
    //   3945: aload_0
    //   3946: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   3949: iconst_0
    //   3950: bipush 30
    //   3952: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   3955: astore 22
    //   3957: aload 24
    //   3959: aload 22
    //   3961: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3964: ldc_w 770
    //   3967: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3970: astore 22
    //   3972: aload_0
    //   3973: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3976: ifnull +3355 -> 7331
    //   3979: aload_0
    //   3980: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3983: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3986: istore_3
    //   3987: aload 22
    //   3989: iload_3
    //   3990: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3993: ldc_w 772
    //   3996: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3999: aload_2
    //   4000: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4003: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4006: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4009: ldc_w 777
    //   4012: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: lload 9
    //   4017: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4020: ldc_w 779
    //   4023: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4026: aload_0
    //   4027: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   4030: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4033: ldc 91
    //   4035: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4038: aload_0
    //   4039: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   4042: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4045: ldc_w 781
    //   4048: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4051: aload_0
    //   4052: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   4055: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4058: ldc 91
    //   4060: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4063: aload_0
    //   4064: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   4067: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4070: ldc_w 783
    //   4073: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4076: aload_0
    //   4077: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   4080: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4083: ldc_w 785
    //   4086: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4089: aload_0
    //   4090: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   4093: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4096: ldc_w 790
    //   4099: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4102: aload_0
    //   4103: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   4106: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4109: ldc_w 795
    //   4112: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4115: astore 24
    //   4117: aload_0
    //   4118: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4121: ifnull +3215 -> 7336
    //   4124: aload_0
    //   4125: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4128: invokeinterface 805 1 0
    //   4133: astore 22
    //   4135: ldc_w 613
    //   4138: aload 24
    //   4140: aload 22
    //   4142: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4145: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4148: aconst_null
    //   4149: invokestatic 568	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4152: aload_0
    //   4153: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4156: ifnull +53 -> 4209
    //   4159: getstatic 369	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4162: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4165: aload_0
    //   4166: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4169: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4172: if_icmpne +37 -> 4209
    //   4175: aload_0
    //   4176: getfield 396	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4179: ifnull +30 -> 4209
    //   4182: aload_0
    //   4183: getfield 396	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4186: aload_0
    //   4187: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4190: aload_0
    //   4191: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4194: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4197: aload_2
    //   4198: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4201: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4204: invokeinterface 812 4 0
    //   4209: aload_0
    //   4210: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4213: ifnull +53 -> 4266
    //   4216: getstatic 480	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4219: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4222: aload_0
    //   4223: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4226: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4229: if_icmpne +37 -> 4266
    //   4232: aload_0
    //   4233: getfield 464	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4236: ifnull +30 -> 4266
    //   4239: aload_0
    //   4240: getfield 464	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4243: aload_0
    //   4244: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4247: aload_0
    //   4248: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4251: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4254: aload_2
    //   4255: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4258: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4261: invokeinterface 812 4 0
    //   4266: aload 31
    //   4268: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   4271: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4274: aload 31
    //   4276: aload_0
    //   4277: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   4280: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4283: aload 31
    //   4285: aload_0
    //   4286: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   4289: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4292: aload 31
    //   4294: iload 4
    //   4296: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4299: aload 31
    //   4301: aconst_null
    //   4302: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4305: aload 26
    //   4307: ifnonnull +3708 -> 8015
    //   4310: aconst_null
    //   4311: astore 22
    //   4313: aload 31
    //   4315: aload 22
    //   4317: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4320: aload_0
    //   4321: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4324: ifnull +3701 -> 8025
    //   4327: aload_0
    //   4328: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4331: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4334: ifnull +3691 -> 8025
    //   4337: aload_0
    //   4338: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4341: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4344: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   4347: astore 22
    //   4349: aload 31
    //   4351: aload 22
    //   4353: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   4356: aload 31
    //   4358: ldc_w 705
    //   4361: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4364: aload 31
    //   4366: aload_2
    //   4367: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4370: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4373: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4376: aload 31
    //   4378: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4381: aload_0
    //   4382: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   4385: lsub
    //   4386: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4389: aload 31
    //   4391: aload_2
    //   4392: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4395: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4398: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4401: aload 31
    //   4403: aload 31
    //   4405: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4408: aload_2
    //   4409: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4412: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4415: lsub
    //   4416: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4419: aload 31
    //   4421: lload 9
    //   4423: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4426: aload 31
    //   4428: aload_0
    //   4429: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   4432: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4435: aload 31
    //   4437: aload_0
    //   4438: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   4441: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4444: aload 31
    //   4446: aload_0
    //   4447: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   4450: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4453: aload 31
    //   4455: lconst_0
    //   4456: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4459: aload 31
    //   4461: aload_0
    //   4462: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   4465: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4468: aload 31
    //   4470: aload_2
    //   4471: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4474: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4477: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4480: aload 31
    //   4482: aload_0
    //   4483: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4486: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4489: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4492: aload 31
    //   4494: aload_0
    //   4495: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   4498: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4501: aload_0
    //   4502: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4505: ifnull +3526 -> 8031
    //   4508: aload_0
    //   4509: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4512: ldc_w 880
    //   4515: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4518: ifeq +3513 -> 8031
    //   4521: iconst_1
    //   4522: istore 21
    //   4524: aload 31
    //   4526: iload 21
    //   4528: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4531: aload 31
    //   4533: aload_2
    //   4534: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4537: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4540: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4543: aload 31
    //   4545: getstatic 891	com/tencent/component/network/downloader/Downloader$DownloadMode:StrictMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   4548: invokevirtual 894	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   4551: putfield 897	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   4554: aload_0
    //   4555: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   4558: ifnull +28 -> 4586
    //   4561: aload_0
    //   4562: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   4565: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4568: ifnull +18 -> 4586
    //   4571: aload 31
    //   4573: aload_0
    //   4574: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   4577: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4580: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4583: putfield 899	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   4586: aload_2
    //   4587: aload 31
    //   4589: invokevirtual 903	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4592: aload_0
    //   4593: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   4596: aload_0
    //   4597: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   4600: iconst_1
    //   4601: isub
    //   4602: if_icmpeq +13 -> 4615
    //   4605: aload_2
    //   4606: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4609: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4612: ifeq +11 -> 4623
    //   4615: aload_0
    //   4616: aload_1
    //   4617: aload_2
    //   4618: aload 31
    //   4620: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4623: aload_0
    //   4624: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   4627: ifeq +3410 -> 8037
    //   4630: aload_0
    //   4631: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4634: ifnull +12 -> 4646
    //   4637: aload_0
    //   4638: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4641: invokeinterface 912 1 0
    //   4646: aload_0
    //   4647: aconst_null
    //   4648: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   4651: aload 23
    //   4653: astore_1
    //   4654: iload 5
    //   4656: istore_3
    //   4657: goto -4552 -> 105
    //   4660: aconst_null
    //   4661: astore 22
    //   4663: goto -2753 -> 1910
    //   4666: iconst_0
    //   4667: istore 4
    //   4669: goto -2617 -> 2052
    //   4672: lload 9
    //   4674: lstore 11
    //   4676: aload 26
    //   4678: astore 24
    //   4680: lload 9
    //   4682: lstore 13
    //   4684: aload 28
    //   4686: astore 23
    //   4688: aload_0
    //   4689: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4692: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4695: getfield 951	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4698: istore 4
    //   4700: goto -2324 -> 2376
    //   4703: lload 9
    //   4705: lstore 11
    //   4707: aload 26
    //   4709: astore 24
    //   4711: lload 9
    //   4713: lstore 13
    //   4715: aload 28
    //   4717: astore 23
    //   4719: aload 25
    //   4721: bipush 58
    //   4723: invokestatic 948	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   4726: iconst_2
    //   4727: if_icmplt +1625 -> 6352
    //   4730: lload 9
    //   4732: lstore 11
    //   4734: aload 26
    //   4736: astore 24
    //   4738: lload 9
    //   4740: lstore 13
    //   4742: aload 28
    //   4744: astore 23
    //   4746: aload_0
    //   4747: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   4750: istore 4
    //   4752: iload 4
    //   4754: ifle +1567 -> 6321
    //   4757: lload 9
    //   4759: lstore 11
    //   4761: aload 26
    //   4763: astore 24
    //   4765: lload 9
    //   4767: lstore 13
    //   4769: aload 28
    //   4771: astore 23
    //   4773: aload_0
    //   4774: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4777: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4780: iload 4
    //   4782: putfield 951	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4785: lload 9
    //   4787: lstore 11
    //   4789: aload 26
    //   4791: astore 24
    //   4793: iload 4
    //   4795: istore 5
    //   4797: lload 9
    //   4799: lstore 13
    //   4801: aload 28
    //   4803: astore 23
    //   4805: iload 4
    //   4807: invokestatic 366	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   4810: ifne +7 -> 4817
    //   4813: bipush 80
    //   4815: istore 5
    //   4817: lload 9
    //   4819: lstore 11
    //   4821: aload 26
    //   4823: astore 24
    //   4825: lload 9
    //   4827: lstore 13
    //   4829: aload 28
    //   4831: astore 23
    //   4833: new 80	java/lang/StringBuilder
    //   4836: dup
    //   4837: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   4840: ldc_w 1023
    //   4843: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4846: aload 25
    //   4848: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4851: ldc_w 1025
    //   4854: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4857: iload 5
    //   4859: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4862: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4865: astore 25
    //   4867: lload 9
    //   4869: lstore 11
    //   4871: aload 26
    //   4873: astore 24
    //   4875: aload 25
    //   4877: astore 22
    //   4879: lload 9
    //   4881: lstore 13
    //   4883: aload 28
    //   4885: astore 23
    //   4887: aload_0
    //   4888: getfield 955	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4891: ifnull -2375 -> 2516
    //   4894: lload 9
    //   4896: lstore 11
    //   4898: aload 26
    //   4900: astore 24
    //   4902: lload 9
    //   4904: lstore 13
    //   4906: aload 28
    //   4908: astore 23
    //   4910: aload_0
    //   4911: aload_0
    //   4912: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4915: aload_0
    //   4916: getfield 955	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4919: aload 25
    //   4921: invokevirtual 959	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4924: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4927: aload 25
    //   4929: astore 22
    //   4931: goto -2415 -> 2516
    //   4934: astore 25
    //   4936: lload 13
    //   4938: lstore 9
    //   4940: aconst_null
    //   4941: astore 24
    //   4943: aload 23
    //   4945: astore 22
    //   4947: iload 6
    //   4949: istore 4
    //   4951: aload 25
    //   4953: astore 23
    //   4955: iload_3
    //   4956: iconst_1
    //   4957: iadd
    //   4958: istore_3
    //   4959: aload_2
    //   4960: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4963: lload 17
    //   4965: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4968: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4971: aload_2
    //   4972: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4975: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4978: aload_0
    //   4979: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   4982: lsub
    //   4983: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4986: aload_2
    //   4987: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4990: aload_0
    //   4991: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   4994: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4997: aload_0
    //   4998: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5001: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   5004: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   5007: astore 27
    //   5009: aload_0
    //   5010: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5013: ifnull +6120 -> 11133
    //   5016: aload_0
    //   5017: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5020: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5023: ifnull +6110 -> 11133
    //   5026: aload_0
    //   5027: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5030: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5033: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   5036: astore 25
    //   5038: aload_0
    //   5039: aload_0
    //   5040: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   5043: aload_0
    //   5044: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   5047: aload_0
    //   5048: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5051: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   5054: astore 28
    //   5056: aload 25
    //   5058: ifnull +6083 -> 11141
    //   5061: aload 22
    //   5063: ifnull +6892 -> 11955
    //   5066: aload 22
    //   5068: ldc_w 656
    //   5071: invokeinterface 662 2 0
    //   5076: checkcast 450	java/lang/String
    //   5079: astore 22
    //   5081: aload_2
    //   5082: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5085: aload 22
    //   5087: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   5090: aload_2
    //   5091: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5094: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5097: ifne +64 -> 5161
    //   5100: aload_0
    //   5101: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5104: ifnull +28 -> 5132
    //   5107: aload_0
    //   5108: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5111: aload_0
    //   5112: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   5115: aload_2
    //   5116: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   5119: aload_0
    //   5120: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   5123: aload_0
    //   5124: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5127: invokeinterface 681 5 0
    //   5132: aload_0
    //   5133: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5136: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5139: ifne +22 -> 5161
    //   5142: aload_0
    //   5143: aload_0
    //   5144: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5147: iconst_1
    //   5148: isub
    //   5149: putfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5152: aload_2
    //   5153: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5156: bipush 6
    //   5158: invokevirtual 544	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   5161: aload_1
    //   5162: invokeinterface 521 1 0
    //   5167: ifne +1123 -> 6290
    //   5170: aload_2
    //   5171: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5174: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5177: ifne +6011 -> 11188
    //   5180: new 80	java/lang/StringBuilder
    //   5183: dup
    //   5184: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   5187: ldc_w 683
    //   5190: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5193: aload_0
    //   5194: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   5197: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5200: ldc_w 685
    //   5203: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5206: aload_0
    //   5207: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   5210: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5213: ldc_w 687
    //   5216: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5219: astore 29
    //   5221: aload_0
    //   5222: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   5225: ifeq +5929 -> 11154
    //   5228: aload_0
    //   5229: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5232: ifnull +5922 -> 11154
    //   5235: aload_0
    //   5236: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5239: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5242: ifnull +5912 -> 11154
    //   5245: aload_0
    //   5246: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5249: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5252: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5255: astore 26
    //   5257: aload 29
    //   5259: aload 26
    //   5261: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5264: ldc_w 696
    //   5267: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5270: aload 27
    //   5272: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5275: ldc_w 701
    //   5278: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5281: aload 25
    //   5283: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5286: ldc_w 703
    //   5289: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5292: ldc_w 705
    //   5295: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5298: ldc_w 707
    //   5301: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5304: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5307: invokevirtual 342	java/lang/Thread:getId	()J
    //   5310: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5313: ldc_w 709
    //   5316: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5319: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5322: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5325: ldc_w 711
    //   5328: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5331: aload_0
    //   5332: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   5335: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5338: ldc_w 713
    //   5341: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5344: aload_0
    //   5345: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   5348: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5351: ldc_w 715
    //   5354: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5357: astore 26
    //   5359: aload_0
    //   5360: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   5363: ifeq +5799 -> 11162
    //   5366: aload_0
    //   5367: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5370: aload_0
    //   5371: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   5374: invokestatic 498	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5377: astore 25
    //   5379: aload 26
    //   5381: aload 25
    //   5383: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5386: ldc_w 717
    //   5389: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5392: aload_0
    //   5393: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5396: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5399: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5402: ldc_w 719
    //   5405: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5408: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5411: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5414: ldc_w 726
    //   5417: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5420: aload_2
    //   5421: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5424: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5427: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5430: ldc_w 728
    //   5433: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5436: aload_2
    //   5437: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5440: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5443: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5446: ldc_w 733
    //   5449: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5452: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   5455: aload_0
    //   5456: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   5459: lsub
    //   5460: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5463: ldc_w 735
    //   5466: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5469: aload_2
    //   5470: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5473: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5476: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5479: ldc_w 740
    //   5482: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5485: aload_2
    //   5486: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5489: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5492: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5495: ldc_w 744
    //   5498: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5501: aload_2
    //   5502: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5505: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5508: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5511: ldc_w 749
    //   5514: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5517: aload_0
    //   5518: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5521: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5524: ldc 91
    //   5526: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5529: aload_0
    //   5530: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   5533: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5536: ldc_w 754
    //   5539: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5542: iload_3
    //   5543: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5546: ldc_w 756
    //   5549: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5552: aload_2
    //   5553: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5556: invokevirtual 547	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5559: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5562: ldc_w 758
    //   5565: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5568: iload 4
    //   5570: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5573: ldc_w 760
    //   5576: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5579: aload 28
    //   5581: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5584: ldc_w 762
    //   5587: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5590: aload 22
    //   5592: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5595: ldc_w 764
    //   5598: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5601: astore 25
    //   5603: aload_0
    //   5604: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5607: ifnull +5561 -> 11168
    //   5610: aload_0
    //   5611: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5614: iconst_0
    //   5615: bipush 30
    //   5617: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   5620: astore 22
    //   5622: aload 25
    //   5624: aload 22
    //   5626: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5629: ldc_w 770
    //   5632: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5635: astore 22
    //   5637: aload_0
    //   5638: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5641: ifnull +5536 -> 11177
    //   5644: aload_0
    //   5645: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5648: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5651: istore_3
    //   5652: aload 22
    //   5654: iload_3
    //   5655: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5658: ldc_w 772
    //   5661: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5664: aload_2
    //   5665: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5668: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5671: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5674: ldc_w 777
    //   5677: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5680: lload 9
    //   5682: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5685: ldc_w 779
    //   5688: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5691: aload_0
    //   5692: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   5695: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5698: ldc 91
    //   5700: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5703: aload_0
    //   5704: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   5707: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5710: ldc_w 781
    //   5713: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5716: aload_0
    //   5717: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   5720: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5723: ldc 91
    //   5725: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5728: aload_0
    //   5729: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   5732: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5735: ldc_w 783
    //   5738: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5741: aload_0
    //   5742: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   5745: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5748: ldc_w 785
    //   5751: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5754: aload_0
    //   5755: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   5758: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5761: ldc_w 790
    //   5764: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5767: aload_0
    //   5768: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   5771: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5774: ldc_w 795
    //   5777: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5780: astore 25
    //   5782: aload_0
    //   5783: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5786: ifnull +5396 -> 11182
    //   5789: aload_0
    //   5790: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5793: invokeinterface 805 1 0
    //   5798: astore 22
    //   5800: ldc_w 613
    //   5803: aload 25
    //   5805: aload 22
    //   5807: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5810: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5813: aload 24
    //   5815: invokestatic 568	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5818: aload_0
    //   5819: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5822: ifnull +53 -> 5875
    //   5825: getstatic 369	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5828: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5831: aload_0
    //   5832: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5835: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5838: if_icmpne +37 -> 5875
    //   5841: aload_0
    //   5842: getfield 396	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5845: ifnull +30 -> 5875
    //   5848: aload_0
    //   5849: getfield 396	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5852: aload_0
    //   5853: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   5856: aload_0
    //   5857: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5860: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5863: aload_2
    //   5864: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5867: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5870: invokeinterface 812 4 0
    //   5875: aload_0
    //   5876: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5879: ifnull +53 -> 5932
    //   5882: getstatic 480	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5885: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5888: aload_0
    //   5889: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5892: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5895: if_icmpne +37 -> 5932
    //   5898: aload_0
    //   5899: getfield 464	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5902: ifnull +30 -> 5932
    //   5905: aload_0
    //   5906: getfield 464	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5909: aload_0
    //   5910: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   5913: aload_0
    //   5914: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5917: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5920: aload_2
    //   5921: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5924: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5927: invokeinterface 812 4 0
    //   5932: aload 31
    //   5934: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   5937: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5940: aload 31
    //   5942: aload_0
    //   5943: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   5946: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5949: aload 31
    //   5951: aload_0
    //   5952: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   5955: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   5958: aload 31
    //   5960: iload 4
    //   5962: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5965: aload 31
    //   5967: aload 24
    //   5969: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5972: aload 27
    //   5974: ifnonnull +5886 -> 11860
    //   5977: aconst_null
    //   5978: astore 22
    //   5980: aload 31
    //   5982: aload 22
    //   5984: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5987: aload_0
    //   5988: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5991: ifnull +5879 -> 11870
    //   5994: aload_0
    //   5995: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5998: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6001: ifnull +5869 -> 11870
    //   6004: aload_0
    //   6005: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6008: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6011: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   6014: astore 22
    //   6016: aload 31
    //   6018: aload 22
    //   6020: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   6023: aload 31
    //   6025: ldc_w 705
    //   6028: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   6031: aload 31
    //   6033: aload_2
    //   6034: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6037: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6040: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   6043: aload 31
    //   6045: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   6048: aload_0
    //   6049: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   6052: lsub
    //   6053: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6056: aload 31
    //   6058: aload_2
    //   6059: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6062: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6065: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6068: aload 31
    //   6070: aload 31
    //   6072: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6075: aload_2
    //   6076: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6079: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6082: lsub
    //   6083: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6086: aload 31
    //   6088: lload 9
    //   6090: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6093: aload 31
    //   6095: aload_0
    //   6096: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   6099: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6102: aload 31
    //   6104: aload_0
    //   6105: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   6108: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6111: aload 31
    //   6113: aload_0
    //   6114: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   6117: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   6120: aload 31
    //   6122: lconst_0
    //   6123: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   6126: aload 31
    //   6128: aload_0
    //   6129: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   6132: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6135: aload 31
    //   6137: aload_2
    //   6138: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6141: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6144: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6147: aload 31
    //   6149: aload_0
    //   6150: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   6153: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6156: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6159: aload 31
    //   6161: aload_0
    //   6162: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   6165: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6168: aload_0
    //   6169: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6172: ifnull +5704 -> 11876
    //   6175: aload_0
    //   6176: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6179: ldc_w 880
    //   6182: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6185: ifeq +5691 -> 11876
    //   6188: iconst_1
    //   6189: istore 21
    //   6191: aload 31
    //   6193: iload 21
    //   6195: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6198: aload 31
    //   6200: aload_2
    //   6201: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6204: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6207: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6210: aload 31
    //   6212: getstatic 891	com/tencent/component/network/downloader/Downloader$DownloadMode:StrictMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   6215: invokevirtual 894	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   6218: putfield 897	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   6221: aload_0
    //   6222: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   6225: ifnull +28 -> 6253
    //   6228: aload_0
    //   6229: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   6232: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6235: ifnull +18 -> 6253
    //   6238: aload 31
    //   6240: aload_0
    //   6241: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   6244: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6247: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6250: putfield 899	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   6253: aload_2
    //   6254: aload 31
    //   6256: invokevirtual 903	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6259: aload_0
    //   6260: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   6263: aload_0
    //   6264: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   6267: iconst_1
    //   6268: isub
    //   6269: if_icmpeq +13 -> 6282
    //   6272: aload_2
    //   6273: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6276: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6279: ifeq +11 -> 6290
    //   6282: aload_0
    //   6283: aload_1
    //   6284: aload_2
    //   6285: aload 31
    //   6287: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6290: aload_0
    //   6291: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   6294: ifeq +5588 -> 11882
    //   6297: aload_0
    //   6298: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6301: ifnull +12 -> 6313
    //   6304: aload_0
    //   6305: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6308: invokeinterface 912 1 0
    //   6313: aload_0
    //   6314: aconst_null
    //   6315: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   6318: aload 23
    //   6320: athrow
    //   6321: lload 9
    //   6323: lstore 11
    //   6325: aload 26
    //   6327: astore 24
    //   6329: lload 9
    //   6331: lstore 13
    //   6333: aload 28
    //   6335: astore 23
    //   6337: aload_0
    //   6338: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6341: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6344: getfield 951	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6347: istore 4
    //   6349: goto -1564 -> 4785
    //   6352: lload 9
    //   6354: lstore 11
    //   6356: aload 26
    //   6358: astore 24
    //   6360: aload 29
    //   6362: astore 22
    //   6364: lload 9
    //   6366: lstore 13
    //   6368: aload 28
    //   6370: astore 23
    //   6372: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6375: iconst_3
    //   6376: if_icmpne -3860 -> 2516
    //   6379: lload 9
    //   6381: lstore 11
    //   6383: aload 26
    //   6385: astore 24
    //   6387: aload 29
    //   6389: astore 22
    //   6391: lload 9
    //   6393: lstore 13
    //   6395: aload 28
    //   6397: astore 23
    //   6399: aload_0
    //   6400: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6403: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6406: getstatic 440	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6409: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6412: if_icmpeq -3896 -> 2516
    //   6415: lload 9
    //   6417: lstore 11
    //   6419: aload 26
    //   6421: astore 24
    //   6423: lload 9
    //   6425: lstore 13
    //   6427: aload 28
    //   6429: astore 23
    //   6431: aload_0
    //   6432: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   6435: istore 4
    //   6437: iload 4
    //   6439: ifle +174 -> 6613
    //   6442: lload 9
    //   6444: lstore 11
    //   6446: aload 26
    //   6448: astore 24
    //   6450: lload 9
    //   6452: lstore 13
    //   6454: aload 28
    //   6456: astore 23
    //   6458: aload_0
    //   6459: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6462: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6465: iload 4
    //   6467: putfield 951	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6470: lload 9
    //   6472: lstore 11
    //   6474: aload 26
    //   6476: astore 24
    //   6478: lload 9
    //   6480: lstore 13
    //   6482: aload 28
    //   6484: astore 23
    //   6486: iload 4
    //   6488: istore 5
    //   6490: iload 4
    //   6492: invokestatic 366	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6495: ifne +7 -> 6502
    //   6498: bipush 80
    //   6500: istore 5
    //   6502: lload 9
    //   6504: lstore 11
    //   6506: aload 26
    //   6508: astore 24
    //   6510: lload 9
    //   6512: lstore 13
    //   6514: aload 28
    //   6516: astore 23
    //   6518: new 80	java/lang/StringBuilder
    //   6521: dup
    //   6522: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6525: aload 25
    //   6527: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6530: ldc_w 953
    //   6533: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6536: iload 5
    //   6538: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6541: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6544: astore 25
    //   6546: lload 9
    //   6548: lstore 11
    //   6550: aload 26
    //   6552: astore 24
    //   6554: aload 25
    //   6556: astore 22
    //   6558: lload 9
    //   6560: lstore 13
    //   6562: aload 28
    //   6564: astore 23
    //   6566: aload_0
    //   6567: getfield 955	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6570: ifnull -4054 -> 2516
    //   6573: lload 9
    //   6575: lstore 11
    //   6577: aload 26
    //   6579: astore 24
    //   6581: lload 9
    //   6583: lstore 13
    //   6585: aload 28
    //   6587: astore 23
    //   6589: aload_0
    //   6590: aload_0
    //   6591: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6594: aload_0
    //   6595: getfield 955	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6598: aload 25
    //   6600: invokevirtual 959	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6603: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6606: aload 25
    //   6608: astore 22
    //   6610: goto -4094 -> 2516
    //   6613: lload 9
    //   6615: lstore 11
    //   6617: aload 26
    //   6619: astore 24
    //   6621: lload 9
    //   6623: lstore 13
    //   6625: aload 28
    //   6627: astore 23
    //   6629: aload_0
    //   6630: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6633: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6636: getfield 951	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6639: istore 4
    //   6641: goto -171 -> 6470
    //   6644: lload 9
    //   6646: lstore 11
    //   6648: aload 26
    //   6650: astore 24
    //   6652: lload 9
    //   6654: lstore 13
    //   6656: aload 28
    //   6658: astore 23
    //   6660: aload_0
    //   6661: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6664: ifnull -4014 -> 2650
    //   6667: lload 9
    //   6669: lstore 11
    //   6671: aload 26
    //   6673: astore 24
    //   6675: lload 9
    //   6677: lstore 13
    //   6679: aload 28
    //   6681: astore 23
    //   6683: aload_0
    //   6684: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6687: ldc_w 880
    //   6690: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6693: ifeq -4043 -> 2650
    //   6696: iload 4
    //   6698: ifeq -4048 -> 2650
    //   6701: iload 21
    //   6703: ifeq -4053 -> 2650
    //   6706: lload 9
    //   6708: lstore 11
    //   6710: aload 26
    //   6712: astore 24
    //   6714: lload 9
    //   6716: lstore 13
    //   6718: aload 28
    //   6720: astore 23
    //   6722: aload_0
    //   6723: aload_0
    //   6724: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6727: ldc_w 1027
    //   6730: ldc_w 1029
    //   6733: invokevirtual 959	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6736: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6739: lload 9
    //   6741: lstore 11
    //   6743: aload 26
    //   6745: astore 24
    //   6747: lload 9
    //   6749: lstore 13
    //   6751: aload 28
    //   6753: astore 23
    //   6755: aload_0
    //   6756: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   6759: istore 4
    //   6761: iload 4
    //   6763: ifle +296 -> 7059
    //   6766: lload 9
    //   6768: lstore 11
    //   6770: aload 26
    //   6772: astore 24
    //   6774: lload 9
    //   6776: lstore 13
    //   6778: aload 28
    //   6780: astore 23
    //   6782: aload_0
    //   6783: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6786: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6789: iload 4
    //   6791: putfield 951	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6794: lload 9
    //   6796: lstore 11
    //   6798: aload 26
    //   6800: astore 24
    //   6802: lload 9
    //   6804: lstore 13
    //   6806: aload 28
    //   6808: astore 23
    //   6810: iload 4
    //   6812: istore 5
    //   6814: iload 4
    //   6816: invokestatic 366	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6819: ifne +7 -> 6826
    //   6822: bipush 80
    //   6824: istore 5
    //   6826: lload 9
    //   6828: lstore 11
    //   6830: aload 26
    //   6832: astore 24
    //   6834: lload 9
    //   6836: lstore 13
    //   6838: aload 28
    //   6840: astore 23
    //   6842: new 80	java/lang/StringBuilder
    //   6845: dup
    //   6846: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6849: ldc_w 1023
    //   6852: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6855: ldc_w 1031
    //   6858: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6861: ldc_w 1025
    //   6864: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6867: iload 5
    //   6869: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6872: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6875: astore 22
    //   6877: lload 9
    //   6879: lstore 11
    //   6881: aload 26
    //   6883: astore 24
    //   6885: lload 9
    //   6887: lstore 13
    //   6889: aload 28
    //   6891: astore 23
    //   6893: aload_0
    //   6894: getfield 955	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6897: ifnull +36 -> 6933
    //   6900: lload 9
    //   6902: lstore 11
    //   6904: aload 26
    //   6906: astore 24
    //   6908: lload 9
    //   6910: lstore 13
    //   6912: aload 28
    //   6914: astore 23
    //   6916: aload_0
    //   6917: aload_0
    //   6918: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6921: aload_0
    //   6922: getfield 955	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6925: aload 22
    //   6927: invokevirtual 959	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6930: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6933: lload 9
    //   6935: lstore 11
    //   6937: aload 26
    //   6939: astore 24
    //   6941: lload 9
    //   6943: lstore 13
    //   6945: aload 28
    //   6947: astore 23
    //   6949: aload 31
    //   6951: aload_0
    //   6952: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6955: invokevirtual 313	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   6958: putfield 962	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6961: lload 9
    //   6963: lstore 11
    //   6965: aload 26
    //   6967: astore 24
    //   6969: lload 9
    //   6971: lstore 13
    //   6973: aload 28
    //   6975: astore 23
    //   6977: invokestatic 965	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   6980: ifeq -4330 -> 2650
    //   6983: lload 9
    //   6985: lstore 11
    //   6987: aload 26
    //   6989: astore 24
    //   6991: lload 9
    //   6993: lstore 13
    //   6995: aload 28
    //   6997: astore 23
    //   6999: ldc 227
    //   7001: new 80	java/lang/StringBuilder
    //   7004: dup
    //   7005: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   7008: ldc_w 967
    //   7011: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7014: aload 31
    //   7016: getfield 962	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   7019: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7022: ldc_w 1033
    //   7025: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7028: aload_0
    //   7029: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   7032: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7035: ldc_w 389
    //   7038: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7041: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7044: invokevirtual 342	java/lang/Thread:getId	()J
    //   7047: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7050: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7053: invokestatic 972	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   7056: goto -4406 -> 2650
    //   7059: lload 9
    //   7061: lstore 11
    //   7063: aload 26
    //   7065: astore 24
    //   7067: lload 9
    //   7069: lstore 13
    //   7071: aload 28
    //   7073: astore 23
    //   7075: aload_0
    //   7076: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7079: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7082: getfield 951	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   7085: istore 4
    //   7087: goto -293 -> 6794
    //   7090: lload 9
    //   7092: lstore 11
    //   7094: aload 26
    //   7096: astore 24
    //   7098: lload 9
    //   7100: lstore 13
    //   7102: aload 28
    //   7104: astore 23
    //   7106: aload_0
    //   7107: aload_0
    //   7108: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   7111: aload_0
    //   7112: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   7115: aload_0
    //   7116: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   7119: aload_0
    //   7120: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7123: aload 32
    //   7125: invokestatic 1037	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   7128: putfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7131: goto -4340 -> 2791
    //   7134: lload 9
    //   7136: lstore 11
    //   7138: aload 26
    //   7140: astore 24
    //   7142: aload 27
    //   7144: astore 22
    //   7146: lload 9
    //   7148: lstore 13
    //   7150: aload 28
    //   7152: astore 23
    //   7154: aload_0
    //   7155: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7158: ifnull -4056 -> 3102
    //   7161: lload 9
    //   7163: lstore 11
    //   7165: aload 26
    //   7167: astore 24
    //   7169: lload 9
    //   7171: lstore 13
    //   7173: aload 28
    //   7175: astore 23
    //   7177: aload_0
    //   7178: aload_0
    //   7179: getfield 1041	com/tencent/component/network/downloader/impl/StrictDownloadTask:pokHttpClient	Lokhttp3/OkHttpClient;
    //   7182: aload_0
    //   7183: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7186: invokevirtual 183	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   7189: invokevirtual 1047	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   7192: putfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   7195: lload 9
    //   7197: lstore 11
    //   7199: aload 26
    //   7201: astore 24
    //   7203: lload 9
    //   7205: lstore 13
    //   7207: aload 28
    //   7209: astore 23
    //   7211: aload_0
    //   7212: aload_0
    //   7213: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   7216: invokeinterface 1050 1 0
    //   7221: putfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   7224: aload 27
    //   7226: astore 22
    //   7228: goto -4126 -> 3102
    //   7231: lload 9
    //   7233: lstore 11
    //   7235: aload 22
    //   7237: astore 24
    //   7239: lload 9
    //   7241: lstore 13
    //   7243: aload 22
    //   7245: astore 23
    //   7247: aload_0
    //   7248: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   7251: ifnull +4695 -> 11946
    //   7254: lload 9
    //   7256: lstore 11
    //   7258: aload 22
    //   7260: astore 24
    //   7262: lload 9
    //   7264: lstore 13
    //   7266: aload 22
    //   7268: astore 23
    //   7270: aload_0
    //   7271: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   7274: invokevirtual 219	okhttp3/Response:code	()I
    //   7277: istore 4
    //   7279: goto -4050 -> 3229
    //   7282: ldc_w 705
    //   7285: astore 24
    //   7287: goto -3919 -> 3368
    //   7290: ldc_w 1052
    //   7293: astore 23
    //   7295: goto -3900 -> 3395
    //   7298: astore 22
    //   7300: ldc_w 510
    //   7303: astore 22
    //   7305: goto -3890 -> 3415
    //   7308: ldc_w 1054
    //   7311: astore 25
    //   7313: goto -3722 -> 3591
    //   7316: aconst_null
    //   7317: astore 24
    //   7319: goto -3606 -> 3713
    //   7322: aload_0
    //   7323: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7326: astore 22
    //   7328: goto -3371 -> 3957
    //   7331: iconst_0
    //   7332: istore_3
    //   7333: goto -3346 -> 3987
    //   7336: aconst_null
    //   7337: astore 22
    //   7339: goto -3204 -> 4135
    //   7342: new 80	java/lang/StringBuilder
    //   7345: dup
    //   7346: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   7349: ldc_w 1056
    //   7352: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7355: aload_0
    //   7356: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   7359: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7362: ldc_w 685
    //   7365: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7368: aload_0
    //   7369: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   7372: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7375: ldc_w 687
    //   7378: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7381: astore 28
    //   7383: aload_0
    //   7384: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   7387: ifeq +564 -> 7951
    //   7390: aload_0
    //   7391: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   7394: ifnull +557 -> 7951
    //   7397: aload_0
    //   7398: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   7401: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7404: ifnull +547 -> 7951
    //   7407: aload_0
    //   7408: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   7411: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7414: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7417: astore 25
    //   7419: aload 28
    //   7421: aload 25
    //   7423: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7426: ldc_w 696
    //   7429: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7432: aload 26
    //   7434: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7437: ldc_w 701
    //   7440: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7443: aload 24
    //   7445: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7448: ldc_w 703
    //   7451: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7454: ldc_w 705
    //   7457: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7460: ldc_w 707
    //   7463: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7466: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7469: invokevirtual 342	java/lang/Thread:getId	()J
    //   7472: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7475: ldc_w 709
    //   7478: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7481: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7484: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7487: ldc_w 711
    //   7490: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7493: aload_0
    //   7494: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   7497: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7500: ldc_w 713
    //   7503: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7506: aload_0
    //   7507: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   7510: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7513: ldc_w 715
    //   7516: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7519: astore 25
    //   7521: aload_0
    //   7522: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   7525: ifeq +434 -> 7959
    //   7528: aload_0
    //   7529: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   7532: aload_0
    //   7533: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   7536: invokestatic 498	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7539: astore 24
    //   7541: aload 25
    //   7543: aload 24
    //   7545: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7548: ldc_w 719
    //   7551: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7554: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7557: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7560: ldc_w 728
    //   7563: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7566: aload_2
    //   7567: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7570: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7573: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7576: ldc_w 733
    //   7579: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7582: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   7585: aload_0
    //   7586: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   7589: lsub
    //   7590: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7593: ldc_w 735
    //   7596: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7599: aload_2
    //   7600: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7603: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7606: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7609: ldc_w 740
    //   7612: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7615: aload_2
    //   7616: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7619: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7622: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7625: ldc_w 744
    //   7628: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7631: aload_2
    //   7632: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7635: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7638: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7641: ldc_w 749
    //   7644: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7647: aload_0
    //   7648: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   7651: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7654: ldc 91
    //   7656: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7659: aload_0
    //   7660: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   7663: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7666: ldc_w 754
    //   7669: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7672: iload 5
    //   7674: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7677: ldc_w 1058
    //   7680: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7683: iload 4
    //   7685: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7688: ldc_w 726
    //   7691: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7694: aload_2
    //   7695: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7698: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7701: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7704: ldc_w 760
    //   7707: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7710: aload 27
    //   7712: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7715: ldc_w 762
    //   7718: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7721: aload 22
    //   7723: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7726: ldc_w 764
    //   7729: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7732: astore 24
    //   7734: aload_0
    //   7735: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7738: ifnull +227 -> 7965
    //   7741: aload_0
    //   7742: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7745: iconst_0
    //   7746: bipush 30
    //   7748: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   7751: astore 22
    //   7753: aload 24
    //   7755: aload 22
    //   7757: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7760: ldc_w 770
    //   7763: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7766: astore 22
    //   7768: aload_0
    //   7769: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7772: ifnull +202 -> 7974
    //   7775: aload_0
    //   7776: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7779: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7782: istore_3
    //   7783: aload 22
    //   7785: iload_3
    //   7786: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7789: ldc_w 772
    //   7792: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7795: aload_2
    //   7796: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7799: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7802: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7805: ldc_w 777
    //   7808: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7811: lload 9
    //   7813: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7816: ldc_w 779
    //   7819: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7822: aload_0
    //   7823: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   7826: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7829: ldc 91
    //   7831: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7834: aload_0
    //   7835: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   7838: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7841: ldc_w 781
    //   7844: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7847: aload_0
    //   7848: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   7851: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7854: ldc 91
    //   7856: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7859: aload_0
    //   7860: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   7863: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7866: ldc_w 783
    //   7869: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7872: aload_0
    //   7873: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   7876: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7879: ldc_w 785
    //   7882: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7885: aload_0
    //   7886: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   7889: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7892: ldc_w 790
    //   7895: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7898: aload_0
    //   7899: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   7902: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7905: ldc_w 795
    //   7908: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7911: astore 24
    //   7913: aload_0
    //   7914: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7917: ifnull +62 -> 7979
    //   7920: aload_0
    //   7921: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7924: invokeinterface 805 1 0
    //   7929: astore 22
    //   7931: ldc_w 613
    //   7934: aload 24
    //   7936: aload 22
    //   7938: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7941: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7944: aconst_null
    //   7945: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7948: goto -3796 -> 4152
    //   7951: ldc_w 1054
    //   7954: astore 25
    //   7956: goto -537 -> 7419
    //   7959: aconst_null
    //   7960: astore 24
    //   7962: goto -421 -> 7541
    //   7965: aload_0
    //   7966: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7969: astore 22
    //   7971: goto -218 -> 7753
    //   7974: iconst_0
    //   7975: istore_3
    //   7976: goto -193 -> 7783
    //   7979: aconst_null
    //   7980: astore 22
    //   7982: goto -51 -> 7931
    //   7985: astore 22
    //   7987: ldc 227
    //   7989: ldc_w 1061
    //   7992: aload 22
    //   7994: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7997: goto -3788 -> 4209
    //   8000: astore 22
    //   8002: ldc 227
    //   8004: ldc_w 1062
    //   8007: aload 22
    //   8009: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8012: goto -3746 -> 4266
    //   8015: aload 26
    //   8017: invokevirtual 1065	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8020: astore 22
    //   8022: goto -3709 -> 4313
    //   8025: aconst_null
    //   8026: astore 22
    //   8028: goto -3679 -> 4349
    //   8031: iconst_0
    //   8032: istore 21
    //   8034: goto -3510 -> 4524
    //   8037: aload_0
    //   8038: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8041: ifnull -3390 -> 4651
    //   8044: aload_0
    //   8045: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8048: invokevirtual 1070	org/apache/http/client/methods/HttpGet:abort	()V
    //   8051: goto -3400 -> 4651
    //   8054: aload_0
    //   8055: aload_0
    //   8056: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8059: aload_0
    //   8060: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   8063: aload_0
    //   8064: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8067: aload_0
    //   8068: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8071: invokespecial 1072	com/tencent/component/network/downloader/impl/StrictDownloadTask:printfHttpDetail	(Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)V
    //   8074: aload_0
    //   8075: aload_0
    //   8076: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8079: aload_0
    //   8080: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8083: invokevirtual 1076	com/tencent/component/network/downloader/impl/StrictDownloadTask:getRetryFlag	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;)I
    //   8086: ifne +8 -> 8094
    //   8089: aload_0
    //   8090: iconst_0
    //   8091: invokevirtual 1079	com/tencent/component/network/downloader/impl/StrictDownloadTask:setAttemptCount	(I)V
    //   8094: sipush 404
    //   8097: iload 4
    //   8099: if_icmpne +46 -> 8145
    //   8102: aload_0
    //   8103: aload_0
    //   8104: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8107: aload_0
    //   8108: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8111: invokevirtual 1082	com/tencent/component/network/downloader/impl/StrictDownloadTask:getXErrorCode	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;)I
    //   8114: istore 5
    //   8116: iload 5
    //   8118: sipush -6101
    //   8121: if_icmpeq +19 -> 8140
    //   8124: iload 5
    //   8126: sipush -5062
    //   8129: if_icmpeq +11 -> 8140
    //   8132: iload 5
    //   8134: sipush -5023
    //   8137: if_icmpne +8 -> 8145
    //   8140: aload_0
    //   8141: iconst_0
    //   8142: invokevirtual 1079	com/tencent/component/network/downloader/impl/StrictDownloadTask:setAttemptCount	(I)V
    //   8145: aload_2
    //   8146: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8149: iconst_3
    //   8150: invokevirtual 544	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   8153: iload 4
    //   8155: istore 5
    //   8157: aload_0
    //   8158: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8161: ifnull +21 -> 8182
    //   8164: aload_0
    //   8165: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8168: aload_0
    //   8169: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8172: iconst_1
    //   8173: invokeinterface 1086 3 0
    //   8178: iload 4
    //   8180: istore 5
    //   8182: iload_3
    //   8183: iconst_1
    //   8184: iadd
    //   8185: istore 4
    //   8187: aload_2
    //   8188: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8191: lload 17
    //   8193: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8196: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   8199: aload_2
    //   8200: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8203: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8206: aload_0
    //   8207: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   8210: lsub
    //   8211: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8214: aload_2
    //   8215: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8218: aload_0
    //   8219: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   8222: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8225: aload_0
    //   8226: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8229: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8232: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8235: astore 26
    //   8237: aload_0
    //   8238: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8241: ifnull +1348 -> 9589
    //   8244: aload_0
    //   8245: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8248: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8251: ifnull +1338 -> 9589
    //   8254: aload_0
    //   8255: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8258: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8261: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   8264: astore 24
    //   8266: aload_0
    //   8267: aload_0
    //   8268: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8271: aload_0
    //   8272: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8275: aload_0
    //   8276: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8279: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   8282: astore 27
    //   8284: aload 24
    //   8286: ifnull +1311 -> 9597
    //   8289: aload 24
    //   8291: astore 23
    //   8293: aload 22
    //   8295: ifnull +3676 -> 11971
    //   8298: aload 22
    //   8300: ldc_w 656
    //   8303: invokeinterface 662 2 0
    //   8308: checkcast 450	java/lang/String
    //   8311: astore 22
    //   8313: aload_2
    //   8314: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8317: aload 22
    //   8319: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8322: aload_2
    //   8323: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8326: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8329: ifne +64 -> 8393
    //   8332: aload_0
    //   8333: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8336: ifnull +28 -> 8364
    //   8339: aload_0
    //   8340: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8343: aload_0
    //   8344: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8347: aload_2
    //   8348: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   8351: aload_0
    //   8352: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8355: aload_0
    //   8356: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8359: invokeinterface 681 5 0
    //   8364: aload_0
    //   8365: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8368: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8371: ifne +22 -> 8393
    //   8374: aload_0
    //   8375: aload_0
    //   8376: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8379: iconst_1
    //   8380: isub
    //   8381: putfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8384: aload_2
    //   8385: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8388: bipush 6
    //   8390: invokevirtual 544	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   8393: aload_1
    //   8394: invokeinterface 521 1 0
    //   8399: ifne +1122 -> 9521
    //   8402: aload_2
    //   8403: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8406: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8409: ifne +1240 -> 9649
    //   8412: new 80	java/lang/StringBuilder
    //   8415: dup
    //   8416: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   8419: ldc_w 683
    //   8422: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8425: aload_0
    //   8426: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8429: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8432: ldc_w 685
    //   8435: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8438: aload_0
    //   8439: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   8442: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8445: ldc_w 687
    //   8448: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8451: astore 28
    //   8453: aload_0
    //   8454: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   8457: ifeq +1158 -> 9615
    //   8460: aload_0
    //   8461: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8464: ifnull +1151 -> 9615
    //   8467: aload_0
    //   8468: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8471: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8474: ifnull +1141 -> 9615
    //   8477: aload_0
    //   8478: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8481: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8484: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8487: astore 25
    //   8489: aload 28
    //   8491: aload 25
    //   8493: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8496: ldc_w 696
    //   8499: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8502: aload 26
    //   8504: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8507: ldc_w 701
    //   8510: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8513: aload 24
    //   8515: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8518: ldc_w 703
    //   8521: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8524: ldc_w 705
    //   8527: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8530: ldc_w 707
    //   8533: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8536: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8539: invokevirtual 342	java/lang/Thread:getId	()J
    //   8542: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8545: ldc_w 709
    //   8548: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8551: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8554: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8557: ldc_w 711
    //   8560: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8563: aload_0
    //   8564: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   8567: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8570: ldc_w 713
    //   8573: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8576: aload_0
    //   8577: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   8580: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8583: ldc_w 715
    //   8586: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8589: astore 25
    //   8591: aload_0
    //   8592: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   8595: ifeq +1028 -> 9623
    //   8598: aload_0
    //   8599: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8602: aload_0
    //   8603: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   8606: invokestatic 498	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8609: astore 24
    //   8611: aload 25
    //   8613: aload 24
    //   8615: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8618: ldc_w 717
    //   8621: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8624: aload_0
    //   8625: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8628: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8631: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8634: ldc_w 719
    //   8637: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8640: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8643: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8646: ldc_w 726
    //   8649: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8652: aload_2
    //   8653: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8656: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8659: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8662: ldc_w 728
    //   8665: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8668: aload_2
    //   8669: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8672: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8675: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8678: ldc_w 733
    //   8681: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8684: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8687: aload_0
    //   8688: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   8691: lsub
    //   8692: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8695: ldc_w 735
    //   8698: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8701: aload_2
    //   8702: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8705: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8708: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8711: ldc_w 740
    //   8714: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8717: aload_2
    //   8718: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8721: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8724: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8727: ldc_w 744
    //   8730: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8733: aload_2
    //   8734: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8737: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8740: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8743: ldc_w 749
    //   8746: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8749: aload_0
    //   8750: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8753: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8756: ldc 91
    //   8758: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8761: aload_0
    //   8762: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   8765: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8768: ldc_w 754
    //   8771: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8774: iload 4
    //   8776: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8779: ldc_w 756
    //   8782: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8785: aload_2
    //   8786: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8789: invokevirtual 547	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8792: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8795: ldc_w 758
    //   8798: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8801: iload 5
    //   8803: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8806: ldc_w 760
    //   8809: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8812: aload 27
    //   8814: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8817: ldc_w 762
    //   8820: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8823: aload 22
    //   8825: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8828: ldc_w 764
    //   8831: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8834: astore 24
    //   8836: aload_0
    //   8837: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8840: ifnull +789 -> 9629
    //   8843: aload_0
    //   8844: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8847: iconst_0
    //   8848: bipush 30
    //   8850: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   8853: astore 22
    //   8855: aload 24
    //   8857: aload 22
    //   8859: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8862: ldc_w 770
    //   8865: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8868: astore 22
    //   8870: aload_0
    //   8871: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8874: ifnull +764 -> 9638
    //   8877: aload_0
    //   8878: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8881: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8884: istore_3
    //   8885: aload 22
    //   8887: iload_3
    //   8888: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8891: ldc_w 772
    //   8894: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8897: aload_2
    //   8898: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8901: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8904: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8907: ldc_w 777
    //   8910: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8913: lload 9
    //   8915: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8918: ldc_w 779
    //   8921: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8924: aload_0
    //   8925: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   8928: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8931: ldc 91
    //   8933: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8936: aload_0
    //   8937: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   8940: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8943: ldc_w 781
    //   8946: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8949: aload_0
    //   8950: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   8953: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8956: ldc 91
    //   8958: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8961: aload_0
    //   8962: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   8965: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8968: ldc_w 783
    //   8971: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8974: aload_0
    //   8975: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   8978: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8981: ldc_w 785
    //   8984: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8987: aload_0
    //   8988: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   8991: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8994: ldc_w 790
    //   8997: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9000: aload_0
    //   9001: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   9004: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9007: ldc_w 795
    //   9010: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9013: astore 24
    //   9015: aload_0
    //   9016: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9019: ifnull +624 -> 9643
    //   9022: aload_0
    //   9023: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9026: invokeinterface 805 1 0
    //   9031: astore 22
    //   9033: ldc_w 613
    //   9036: aload 24
    //   9038: aload 22
    //   9040: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9043: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9046: aconst_null
    //   9047: invokestatic 568	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9050: aload_0
    //   9051: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9054: ifnull +53 -> 9107
    //   9057: getstatic 369	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9060: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9063: aload_0
    //   9064: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9067: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9070: if_icmpne +37 -> 9107
    //   9073: aload_0
    //   9074: getfield 396	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9077: ifnull +30 -> 9107
    //   9080: aload_0
    //   9081: getfield 396	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9084: aload_0
    //   9085: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   9088: aload_0
    //   9089: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9092: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9095: aload_2
    //   9096: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9099: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9102: invokeinterface 812 4 0
    //   9107: aload_0
    //   9108: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9111: ifnull +53 -> 9164
    //   9114: getstatic 480	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9117: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9120: aload_0
    //   9121: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9124: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9127: if_icmpne +37 -> 9164
    //   9130: aload_0
    //   9131: getfield 464	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9134: ifnull +30 -> 9164
    //   9137: aload_0
    //   9138: getfield 464	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9141: aload_0
    //   9142: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   9145: aload_0
    //   9146: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9149: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9152: aload_2
    //   9153: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9156: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9159: invokeinterface 812 4 0
    //   9164: aload 31
    //   9166: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   9169: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   9172: aload 31
    //   9174: aload_0
    //   9175: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   9178: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   9181: aload 31
    //   9183: aload_0
    //   9184: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   9187: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   9190: aload 31
    //   9192: iload 5
    //   9194: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   9197: aload 31
    //   9199: aconst_null
    //   9200: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   9203: aload 26
    //   9205: ifnonnull +1117 -> 10322
    //   9208: aconst_null
    //   9209: astore 22
    //   9211: aload 31
    //   9213: aload 22
    //   9215: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   9218: aload_0
    //   9219: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9222: ifnull +1110 -> 10332
    //   9225: aload_0
    //   9226: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9229: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   9232: ifnull +1100 -> 10332
    //   9235: aload_0
    //   9236: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9239: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   9242: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   9245: astore 22
    //   9247: aload 31
    //   9249: aload 22
    //   9251: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   9254: aload 31
    //   9256: ldc_w 705
    //   9259: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9262: aload 31
    //   9264: aload_2
    //   9265: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9268: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9271: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9274: aload 31
    //   9276: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   9279: aload_0
    //   9280: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   9283: lsub
    //   9284: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9287: aload 31
    //   9289: aload_2
    //   9290: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9293: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9296: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9299: aload 31
    //   9301: aload 31
    //   9303: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9306: aload_2
    //   9307: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9310: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9313: lsub
    //   9314: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9317: aload 31
    //   9319: lload 9
    //   9321: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9324: aload 31
    //   9326: aload_0
    //   9327: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   9330: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9333: aload 31
    //   9335: aload_0
    //   9336: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   9339: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9342: aload 31
    //   9344: aload_0
    //   9345: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   9348: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9351: aload 31
    //   9353: lconst_0
    //   9354: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9357: aload 31
    //   9359: aload_0
    //   9360: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   9363: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9366: aload 31
    //   9368: aload_2
    //   9369: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9372: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9375: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9378: aload 31
    //   9380: aload_0
    //   9381: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   9384: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9387: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9390: aload 31
    //   9392: aload_0
    //   9393: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9396: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9399: aload_0
    //   9400: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9403: ifnull +935 -> 10338
    //   9406: aload_0
    //   9407: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9410: ldc_w 880
    //   9413: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9416: ifeq +922 -> 10338
    //   9419: iconst_1
    //   9420: istore 21
    //   9422: aload 31
    //   9424: iload 21
    //   9426: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9429: aload 31
    //   9431: aload_2
    //   9432: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9435: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9438: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9441: aload 31
    //   9443: getstatic 891	com/tencent/component/network/downloader/Downloader$DownloadMode:StrictMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   9446: invokevirtual 894	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   9449: putfield 897	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   9452: aload_0
    //   9453: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   9456: ifnull +28 -> 9484
    //   9459: aload_0
    //   9460: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   9463: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9466: ifnull +18 -> 9484
    //   9469: aload 31
    //   9471: aload_0
    //   9472: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   9475: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9478: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9481: putfield 899	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   9484: aload_2
    //   9485: aload 31
    //   9487: invokevirtual 903	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9490: aload_0
    //   9491: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   9494: aload_0
    //   9495: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   9498: iconst_1
    //   9499: isub
    //   9500: if_icmpeq +13 -> 9513
    //   9503: aload_2
    //   9504: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9507: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9510: ifeq +11 -> 9521
    //   9513: aload_0
    //   9514: aload_1
    //   9515: aload_2
    //   9516: aload 31
    //   9518: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9521: aload_0
    //   9522: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9525: ifeq +819 -> 10344
    //   9528: aload_0
    //   9529: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   9532: ifnull +12 -> 9544
    //   9535: aload_0
    //   9536: getfield 907	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   9539: invokeinterface 912 1 0
    //   9544: aload_0
    //   9545: aconst_null
    //   9546: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   9549: aload 23
    //   9551: astore 22
    //   9553: iload 4
    //   9555: istore_3
    //   9556: goto -9281 -> 275
    //   9559: lload 9
    //   9561: lstore 11
    //   9563: aload 22
    //   9565: astore 24
    //   9567: lload 9
    //   9569: lstore 13
    //   9571: aload 22
    //   9573: astore 23
    //   9575: aload_2
    //   9576: invokevirtual 539	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9579: iconst_3
    //   9580: invokevirtual 544	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   9583: iconst_0
    //   9584: istore 5
    //   9586: goto -1404 -> 8182
    //   9589: ldc_w 705
    //   9592: astore 24
    //   9594: goto -1328 -> 8266
    //   9597: ldc_w 1052
    //   9600: astore 23
    //   9602: goto -1309 -> 8293
    //   9605: astore 22
    //   9607: ldc_w 510
    //   9610: astore 22
    //   9612: goto -1299 -> 8313
    //   9615: ldc_w 1054
    //   9618: astore 25
    //   9620: goto -1131 -> 8489
    //   9623: aconst_null
    //   9624: astore 24
    //   9626: goto -1015 -> 8611
    //   9629: aload_0
    //   9630: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9633: astore 22
    //   9635: goto -780 -> 8855
    //   9638: iconst_0
    //   9639: istore_3
    //   9640: goto -755 -> 8885
    //   9643: aconst_null
    //   9644: astore 22
    //   9646: goto -613 -> 9033
    //   9649: new 80	java/lang/StringBuilder
    //   9652: dup
    //   9653: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   9656: ldc_w 1056
    //   9659: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9662: aload_0
    //   9663: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   9666: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9669: ldc_w 685
    //   9672: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9675: aload_0
    //   9676: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9679: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9682: ldc_w 687
    //   9685: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9688: astore 28
    //   9690: aload_0
    //   9691: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9694: ifeq +564 -> 10258
    //   9697: aload_0
    //   9698: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   9701: ifnull +557 -> 10258
    //   9704: aload_0
    //   9705: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   9708: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9711: ifnull +547 -> 10258
    //   9714: aload_0
    //   9715: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   9718: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9721: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9724: astore 25
    //   9726: aload 28
    //   9728: aload 25
    //   9730: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9733: ldc_w 696
    //   9736: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9739: aload 26
    //   9741: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9744: ldc_w 701
    //   9747: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9750: aload 24
    //   9752: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9755: ldc_w 703
    //   9758: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9761: ldc_w 705
    //   9764: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9767: ldc_w 707
    //   9770: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9773: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9776: invokevirtual 342	java/lang/Thread:getId	()J
    //   9779: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9782: ldc_w 709
    //   9785: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9788: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9791: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9794: ldc_w 711
    //   9797: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9800: aload_0
    //   9801: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   9804: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9807: ldc_w 713
    //   9810: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9813: aload_0
    //   9814: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   9817: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9820: ldc_w 715
    //   9823: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9826: astore 25
    //   9828: aload_0
    //   9829: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   9832: ifeq +434 -> 10266
    //   9835: aload_0
    //   9836: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   9839: aload_0
    //   9840: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   9843: invokestatic 498	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9846: astore 24
    //   9848: aload 25
    //   9850: aload 24
    //   9852: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9855: ldc_w 719
    //   9858: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9861: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9864: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9867: ldc_w 728
    //   9870: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9873: aload_2
    //   9874: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9877: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9880: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9883: ldc_w 733
    //   9886: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9889: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   9892: aload_0
    //   9893: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   9896: lsub
    //   9897: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9900: ldc_w 735
    //   9903: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9906: aload_2
    //   9907: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9910: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9913: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9916: ldc_w 740
    //   9919: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9922: aload_2
    //   9923: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9926: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9929: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9932: ldc_w 744
    //   9935: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9938: aload_2
    //   9939: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9942: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9945: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9948: ldc_w 749
    //   9951: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9954: aload_0
    //   9955: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   9958: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9961: ldc 91
    //   9963: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9966: aload_0
    //   9967: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   9970: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9973: ldc_w 754
    //   9976: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9979: iload 4
    //   9981: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9984: ldc_w 1058
    //   9987: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9990: iload 5
    //   9992: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9995: ldc_w 726
    //   9998: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10001: aload_2
    //   10002: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10005: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10008: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10011: ldc_w 760
    //   10014: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10017: aload 27
    //   10019: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10022: ldc_w 762
    //   10025: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10028: aload 22
    //   10030: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10033: ldc_w 764
    //   10036: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10039: astore 24
    //   10041: aload_0
    //   10042: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10045: ifnull +227 -> 10272
    //   10048: aload_0
    //   10049: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10052: iconst_0
    //   10053: bipush 30
    //   10055: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   10058: astore 22
    //   10060: aload 24
    //   10062: aload 22
    //   10064: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10067: ldc_w 770
    //   10070: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10073: astore 22
    //   10075: aload_0
    //   10076: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10079: ifnull +202 -> 10281
    //   10082: aload_0
    //   10083: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10086: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10089: istore_3
    //   10090: aload 22
    //   10092: iload_3
    //   10093: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10096: ldc_w 772
    //   10099: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10102: aload_2
    //   10103: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10106: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10109: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10112: ldc_w 777
    //   10115: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10118: lload 9
    //   10120: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10123: ldc_w 779
    //   10126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10129: aload_0
    //   10130: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   10133: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10136: ldc 91
    //   10138: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10141: aload_0
    //   10142: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   10145: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10148: ldc_w 781
    //   10151: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10154: aload_0
    //   10155: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   10158: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10161: ldc 91
    //   10163: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10166: aload_0
    //   10167: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   10170: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10173: ldc_w 783
    //   10176: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10179: aload_0
    //   10180: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   10183: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10186: ldc_w 785
    //   10189: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10192: aload_0
    //   10193: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   10196: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10199: ldc_w 790
    //   10202: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10205: aload_0
    //   10206: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   10209: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10212: ldc_w 795
    //   10215: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10218: astore 24
    //   10220: aload_0
    //   10221: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10224: ifnull +62 -> 10286
    //   10227: aload_0
    //   10228: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10231: invokeinterface 805 1 0
    //   10236: astore 22
    //   10238: ldc_w 613
    //   10241: aload 24
    //   10243: aload 22
    //   10245: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10248: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10251: aconst_null
    //   10252: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10255: goto -1205 -> 9050
    //   10258: ldc_w 1054
    //   10261: astore 25
    //   10263: goto -537 -> 9726
    //   10266: aconst_null
    //   10267: astore 24
    //   10269: goto -421 -> 9848
    //   10272: aload_0
    //   10273: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10276: astore 22
    //   10278: goto -218 -> 10060
    //   10281: iconst_0
    //   10282: istore_3
    //   10283: goto -193 -> 10090
    //   10286: aconst_null
    //   10287: astore 22
    //   10289: goto -51 -> 10238
    //   10292: astore 22
    //   10294: ldc 227
    //   10296: ldc_w 1061
    //   10299: aload 22
    //   10301: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10304: goto -1197 -> 9107
    //   10307: astore 22
    //   10309: ldc 227
    //   10311: ldc_w 1062
    //   10314: aload 22
    //   10316: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10319: goto -1155 -> 9164
    //   10322: aload 26
    //   10324: invokevirtual 1065	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10327: astore 22
    //   10329: goto -1118 -> 9211
    //   10332: aconst_null
    //   10333: astore 22
    //   10335: goto -1088 -> 9247
    //   10338: iconst_0
    //   10339: istore 21
    //   10341: goto -919 -> 9422
    //   10344: aload_0
    //   10345: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10348: ifnull -799 -> 9549
    //   10351: aload_0
    //   10352: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10355: invokevirtual 1070	org/apache/http/client/methods/HttpGet:abort	()V
    //   10358: goto -809 -> 9549
    //   10361: ldc_w 705
    //   10364: astore 25
    //   10366: goto -9878 -> 488
    //   10369: ldc_w 1052
    //   10372: astore 23
    //   10374: goto -9859 -> 515
    //   10377: astore 22
    //   10379: ldc_w 510
    //   10382: astore 22
    //   10384: goto -9849 -> 535
    //   10387: ldc_w 1054
    //   10390: astore 26
    //   10392: goto -9681 -> 711
    //   10395: aconst_null
    //   10396: astore 25
    //   10398: goto -9565 -> 833
    //   10401: aload_0
    //   10402: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10405: astore 22
    //   10407: goto -9330 -> 1077
    //   10410: iconst_0
    //   10411: istore_3
    //   10412: goto -9305 -> 1107
    //   10415: aconst_null
    //   10416: astore 22
    //   10418: goto -9163 -> 1255
    //   10421: new 80	java/lang/StringBuilder
    //   10424: dup
    //   10425: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   10428: ldc_w 1056
    //   10431: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10434: aload_0
    //   10435: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   10438: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10441: ldc_w 685
    //   10444: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10447: aload_0
    //   10448: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10451: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10454: ldc_w 687
    //   10457: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10460: astore 29
    //   10462: aload_0
    //   10463: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10466: ifeq +564 -> 11030
    //   10469: aload_0
    //   10470: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   10473: ifnull +557 -> 11030
    //   10476: aload_0
    //   10477: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   10480: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10483: ifnull +547 -> 11030
    //   10486: aload_0
    //   10487: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   10490: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10493: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   10496: astore 26
    //   10498: aload 29
    //   10500: aload 26
    //   10502: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10505: ldc_w 696
    //   10508: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10511: aload 27
    //   10513: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10516: ldc_w 701
    //   10519: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10522: aload 25
    //   10524: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10527: ldc_w 703
    //   10530: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10533: ldc_w 705
    //   10536: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10539: ldc_w 707
    //   10542: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10545: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10548: invokevirtual 342	java/lang/Thread:getId	()J
    //   10551: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10554: ldc_w 709
    //   10557: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10560: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10563: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10566: ldc_w 711
    //   10569: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10572: aload_0
    //   10573: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   10576: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10579: ldc_w 713
    //   10582: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10585: aload_0
    //   10586: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   10589: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10592: ldc_w 715
    //   10595: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10598: astore 26
    //   10600: aload_0
    //   10601: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   10604: ifeq +434 -> 11038
    //   10607: aload_0
    //   10608: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   10611: aload_0
    //   10612: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   10615: invokestatic 498	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10618: astore 25
    //   10620: aload 26
    //   10622: aload 25
    //   10624: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10627: ldc_w 719
    //   10630: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10633: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10636: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10639: ldc_w 728
    //   10642: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10645: aload_2
    //   10646: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10649: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10652: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10655: ldc_w 733
    //   10658: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10661: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   10664: aload_0
    //   10665: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   10668: lsub
    //   10669: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10672: ldc_w 735
    //   10675: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10678: aload_2
    //   10679: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10682: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10685: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10688: ldc_w 740
    //   10691: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10694: aload_2
    //   10695: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10698: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10701: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10704: ldc_w 744
    //   10707: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10710: aload_2
    //   10711: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10714: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10717: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10720: ldc_w 749
    //   10723: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10726: aload_0
    //   10727: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   10730: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10733: ldc 91
    //   10735: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10738: aload_0
    //   10739: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   10742: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10745: ldc_w 754
    //   10748: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10751: iload 5
    //   10753: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10756: ldc_w 1058
    //   10759: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10762: iload 4
    //   10764: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10767: ldc_w 726
    //   10770: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10773: aload_2
    //   10774: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10777: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10780: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10783: ldc_w 760
    //   10786: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10789: aload 28
    //   10791: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10794: ldc_w 762
    //   10797: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10800: aload 22
    //   10802: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10805: ldc_w 764
    //   10808: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10811: astore 25
    //   10813: aload_0
    //   10814: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10817: ifnull +227 -> 11044
    //   10820: aload_0
    //   10821: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10824: iconst_0
    //   10825: bipush 30
    //   10827: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   10830: astore 22
    //   10832: aload 25
    //   10834: aload 22
    //   10836: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10839: ldc_w 770
    //   10842: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10845: astore 22
    //   10847: aload_0
    //   10848: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10851: ifnull +202 -> 11053
    //   10854: aload_0
    //   10855: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10858: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10861: istore_3
    //   10862: aload 22
    //   10864: iload_3
    //   10865: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10868: ldc_w 772
    //   10871: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10874: aload_2
    //   10875: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10878: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10881: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10884: ldc_w 777
    //   10887: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10890: lload 9
    //   10892: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10895: ldc_w 779
    //   10898: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10901: aload_0
    //   10902: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   10905: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10908: ldc 91
    //   10910: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10913: aload_0
    //   10914: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   10917: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10920: ldc_w 781
    //   10923: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10926: aload_0
    //   10927: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   10930: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10933: ldc 91
    //   10935: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10938: aload_0
    //   10939: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   10942: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10945: ldc_w 783
    //   10948: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10951: aload_0
    //   10952: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   10955: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10958: ldc_w 785
    //   10961: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10964: aload_0
    //   10965: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   10968: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10971: ldc_w 790
    //   10974: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10977: aload_0
    //   10978: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   10981: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10984: ldc_w 795
    //   10987: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10990: astore 25
    //   10992: aload_0
    //   10993: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10996: ifnull +62 -> 11058
    //   10999: aload_0
    //   11000: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11003: invokeinterface 805 1 0
    //   11008: astore 22
    //   11010: ldc_w 613
    //   11013: aload 25
    //   11015: aload 22
    //   11017: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11020: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11023: aconst_null
    //   11024: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11027: goto -9754 -> 1273
    //   11030: ldc_w 1054
    //   11033: astore 26
    //   11035: goto -537 -> 10498
    //   11038: aconst_null
    //   11039: astore 25
    //   11041: goto -421 -> 10620
    //   11044: aload_0
    //   11045: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11048: astore 22
    //   11050: goto -218 -> 10832
    //   11053: iconst_0
    //   11054: istore_3
    //   11055: goto -193 -> 10862
    //   11058: aconst_null
    //   11059: astore 22
    //   11061: goto -51 -> 11010
    //   11064: astore 22
    //   11066: ldc 227
    //   11068: ldc_w 1061
    //   11071: aload 22
    //   11073: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11076: goto -9746 -> 1330
    //   11079: astore 22
    //   11081: ldc 227
    //   11083: ldc_w 1062
    //   11086: aload 22
    //   11088: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11091: goto -9704 -> 1387
    //   11094: aload 27
    //   11096: invokevirtual 1065	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   11099: astore 22
    //   11101: goto -9666 -> 1435
    //   11104: aconst_null
    //   11105: astore 22
    //   11107: goto -9636 -> 1471
    //   11110: iconst_0
    //   11111: istore 21
    //   11113: goto -9467 -> 1646
    //   11116: aload_0
    //   11117: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11120: ifnull -9347 -> 1773
    //   11123: aload_0
    //   11124: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11127: invokevirtual 1070	org/apache/http/client/methods/HttpGet:abort	()V
    //   11130: goto -9357 -> 1773
    //   11133: ldc_w 705
    //   11136: astore 25
    //   11138: goto -6100 -> 5038
    //   11141: goto -6080 -> 5061
    //   11144: astore 22
    //   11146: ldc_w 510
    //   11149: astore 22
    //   11151: goto -6070 -> 5081
    //   11154: ldc_w 1054
    //   11157: astore 26
    //   11159: goto -5902 -> 5257
    //   11162: aconst_null
    //   11163: astore 25
    //   11165: goto -5786 -> 5379
    //   11168: aload_0
    //   11169: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11172: astore 22
    //   11174: goto -5552 -> 5622
    //   11177: iconst_0
    //   11178: istore_3
    //   11179: goto -5527 -> 5652
    //   11182: aconst_null
    //   11183: astore 22
    //   11185: goto -5385 -> 5800
    //   11188: new 80	java/lang/StringBuilder
    //   11191: dup
    //   11192: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   11195: ldc_w 1056
    //   11198: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11201: aload_0
    //   11202: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   11205: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11208: ldc_w 685
    //   11211: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11214: aload_0
    //   11215: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   11218: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11221: ldc_w 687
    //   11224: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11227: astore 29
    //   11229: aload_0
    //   11230: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   11233: ifeq +563 -> 11796
    //   11236: aload_0
    //   11237: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   11240: ifnull +556 -> 11796
    //   11243: aload_0
    //   11244: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   11247: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11250: ifnull +546 -> 11796
    //   11253: aload_0
    //   11254: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   11257: invokevirtual 691	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11260: invokevirtual 694	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11263: astore 26
    //   11265: aload 29
    //   11267: aload 26
    //   11269: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11272: ldc_w 696
    //   11275: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11278: aload 27
    //   11280: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11283: ldc_w 701
    //   11286: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11289: aload 25
    //   11291: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11294: ldc_w 703
    //   11297: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11300: ldc_w 705
    //   11303: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11306: ldc_w 707
    //   11309: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11312: invokestatic 339	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11315: invokevirtual 342	java/lang/Thread:getId	()J
    //   11318: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11321: ldc_w 709
    //   11324: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11327: invokestatic 329	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11330: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11333: ldc_w 711
    //   11336: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11339: aload_0
    //   11340: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   11343: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11346: ldc_w 713
    //   11349: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11352: aload_0
    //   11353: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   11356: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11359: ldc_w 715
    //   11362: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11365: astore 26
    //   11367: aload_0
    //   11368: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   11371: ifeq +433 -> 11804
    //   11374: aload_0
    //   11375: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   11378: aload_0
    //   11379: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   11382: invokestatic 498	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   11385: astore 25
    //   11387: aload 26
    //   11389: aload 25
    //   11391: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11394: ldc_w 719
    //   11397: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11400: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   11403: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11406: ldc_w 728
    //   11409: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11412: aload_2
    //   11413: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11416: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11419: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11422: ldc_w 733
    //   11425: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11428: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   11431: aload_0
    //   11432: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   11435: lsub
    //   11436: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11439: ldc_w 735
    //   11442: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11445: aload_2
    //   11446: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11449: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11452: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11455: ldc_w 740
    //   11458: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11461: aload_2
    //   11462: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11465: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11468: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11471: ldc_w 744
    //   11474: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11477: aload_2
    //   11478: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11481: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   11484: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11487: ldc_w 749
    //   11490: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11493: aload_0
    //   11494: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   11497: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11500: ldc 91
    //   11502: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11505: aload_0
    //   11506: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   11509: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11512: ldc_w 754
    //   11515: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11518: iload_3
    //   11519: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11522: ldc_w 1058
    //   11525: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11528: iload 4
    //   11530: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11533: ldc_w 726
    //   11536: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11539: aload_2
    //   11540: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11543: getfield 559	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11546: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11549: ldc_w 760
    //   11552: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11555: aload 28
    //   11557: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11560: ldc_w 762
    //   11563: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11566: aload 22
    //   11568: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11571: ldc_w 764
    //   11574: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11577: astore 25
    //   11579: aload_0
    //   11580: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11583: ifnull +227 -> 11810
    //   11586: aload_0
    //   11587: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11590: iconst_0
    //   11591: bipush 30
    //   11593: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   11596: astore 22
    //   11598: aload 25
    //   11600: aload 22
    //   11602: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11605: ldc_w 770
    //   11608: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11611: astore 22
    //   11613: aload_0
    //   11614: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11617: ifnull +202 -> 11819
    //   11620: aload_0
    //   11621: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11624: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11627: istore_3
    //   11628: aload 22
    //   11630: iload_3
    //   11631: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11634: ldc_w 772
    //   11637: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11640: aload_2
    //   11641: invokevirtual 554	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11644: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11647: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11650: ldc_w 777
    //   11653: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11656: lload 9
    //   11658: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11661: ldc_w 779
    //   11664: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11667: aload_0
    //   11668: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   11671: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11674: ldc 91
    //   11676: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11679: aload_0
    //   11680: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   11683: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11686: ldc_w 781
    //   11689: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11692: aload_0
    //   11693: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   11696: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11699: ldc 91
    //   11701: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11704: aload_0
    //   11705: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   11708: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11711: ldc_w 783
    //   11714: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11717: aload_0
    //   11718: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   11721: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11724: ldc_w 785
    //   11727: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11730: aload_0
    //   11731: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   11734: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11737: ldc_w 790
    //   11740: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11743: aload_0
    //   11744: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   11747: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11750: ldc_w 795
    //   11753: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11756: astore 25
    //   11758: aload_0
    //   11759: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11762: ifnull +62 -> 11824
    //   11765: aload_0
    //   11766: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11769: invokeinterface 805 1 0
    //   11774: astore 22
    //   11776: ldc_w 613
    //   11779: aload 25
    //   11781: aload 22
    //   11783: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11786: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11789: aconst_null
    //   11790: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11793: goto -5975 -> 5818
    //   11796: ldc_w 1054
    //   11799: astore 26
    //   11801: goto -536 -> 11265
    //   11804: aconst_null
    //   11805: astore 25
    //   11807: goto -420 -> 11387
    //   11810: aload_0
    //   11811: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11814: astore 22
    //   11816: goto -218 -> 11598
    //   11819: iconst_0
    //   11820: istore_3
    //   11821: goto -193 -> 11628
    //   11824: aconst_null
    //   11825: astore 22
    //   11827: goto -51 -> 11776
    //   11830: astore 22
    //   11832: ldc 227
    //   11834: ldc_w 1061
    //   11837: aload 22
    //   11839: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11842: goto -5967 -> 5875
    //   11845: astore 22
    //   11847: ldc 227
    //   11849: ldc_w 1062
    //   11852: aload 22
    //   11854: invokestatic 1060	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11857: goto -5925 -> 5932
    //   11860: aload 27
    //   11862: invokevirtual 1065	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   11865: astore 22
    //   11867: goto -5887 -> 5980
    //   11870: aconst_null
    //   11871: astore 22
    //   11873: goto -5857 -> 6016
    //   11876: iconst_0
    //   11877: istore 21
    //   11879: goto -5688 -> 6191
    //   11882: aload_0
    //   11883: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11886: ifnull -5568 -> 6318
    //   11889: aload_0
    //   11890: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11893: invokevirtual 1070	org/apache/http/client/methods/HttpGet:abort	()V
    //   11896: goto -5578 -> 6318
    //   11899: astore 23
    //   11901: aconst_null
    //   11902: astore 24
    //   11904: iload 6
    //   11906: istore 4
    //   11908: goto -6953 -> 4955
    //   11911: astore 23
    //   11913: aconst_null
    //   11914: astore 24
    //   11916: goto -6961 -> 4955
    //   11919: astore 23
    //   11921: iload 5
    //   11923: istore_3
    //   11924: goto -6969 -> 4955
    //   11927: astore 24
    //   11929: iload 7
    //   11931: istore 4
    //   11933: goto -11600 -> 333
    //   11936: astore 24
    //   11938: goto -11605 -> 333
    //   11941: astore 22
    //   11943: goto -11652 -> 291
    //   11946: iconst_0
    //   11947: istore 4
    //   11949: goto -8720 -> 3229
    //   11952: goto -11917 -> 35
    //   11955: ldc_w 510
    //   11958: astore 22
    //   11960: goto -6879 -> 5081
    //   11963: ldc_w 510
    //   11966: astore 22
    //   11968: goto -11433 -> 535
    //   11971: ldc_w 510
    //   11974: astore 22
    //   11976: goto -3663 -> 8313
    //   11979: ldc_w 510
    //   11982: astore 22
    //   11984: goto -8569 -> 3415
    //   11987: iconst_1
    //   11988: istore 4
    //   11990: goto -9938 -> 2052
    //   11993: aload 30
    //   11995: astore 25
    //   11997: iload 5
    //   11999: iconst_2
    //   12000: if_icmpge -7297 -> 4703
    //   12003: aload 30
    //   12005: astore 25
    //   12007: iload 21
    //   12009: ifeq -7306 -> 4703
    //   12012: ldc_w 1031
    //   12015: astore 25
    //   12017: goto -7314 -> 4703
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12020	0	this	StrictDownloadTask
    //   0	12020	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	12020	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   1	11923	3	i	int
    //   327	11662	4	j	int
    //   334	11667	5	k	int
    //   250	11655	6	m	int
    //   253	11677	7	n	int
    //   25	165	8	i1	int
    //   28	11629	9	l1	long
    //   298	9264	11	l2	long
    //   306	9264	13	l3	long
    //   33	60	15	l4	long
    //   176	8016	17	l5	long
    //   258	2865	19	l6	long
    //   268	11740	21	bool	boolean
    //   5	7262	22	localObject1	Object
    //   7298	1	22	localException1	java.lang.Exception
    //   7303	678	22	localObject2	Object
    //   7985	8	22	localException2	java.lang.Exception
    //   8000	8	22	localException3	java.lang.Exception
    //   8020	1552	22	localObject3	Object
    //   9605	1	22	localException4	java.lang.Exception
    //   9610	678	22	localObject4	Object
    //   10292	8	22	localException5	java.lang.Exception
    //   10307	8	22	localException6	java.lang.Exception
    //   10327	7	22	str1	String
    //   10377	1	22	localException7	java.lang.Exception
    //   10382	678	22	localObject5	Object
    //   11064	8	22	localException8	java.lang.Exception
    //   11079	8	22	localException9	java.lang.Exception
    //   11099	7	22	str2	String
    //   11144	1	22	localException10	java.lang.Exception
    //   11149	677	22	localObject6	Object
    //   11830	8	22	localException11	java.lang.Exception
    //   11845	8	22	localException12	java.lang.Exception
    //   11865	7	22	str3	String
    //   11941	1	22	localThrowable1	java.lang.Throwable
    //   11958	25	22	str4	String
    //   84	1	23	localException13	java.lang.Exception
    //   310	1	23	localObject7	Object
    //   315	15	23	localThrowable2	java.lang.Throwable
    //   513	9860	23	localObject8	Object
    //   11899	1	23	localObject9	Object
    //   11911	1	23	localObject10	Object
    //   11919	1	23	localObject11	Object
    //   302	11613	24	localObject12	Object
    //   11927	1	24	localThrowable3	java.lang.Throwable
    //   11936	1	24	localThrowable4	java.lang.Throwable
    //   486	4442	25	localObject13	Object
    //   4934	18	25	localObject14	Object
    //   5036	6980	25	localObject15	Object
    //   247	11553	26	localObject16	Object
    //   241	11620	27	localObject17	Object
    //   244	11312	28	localObject18	Object
    //   673	10593	29	localObject19	Object
    //   2257	9747	30	str5	String
    //   185	9332	31	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   1808	5316	32	localRequestOptions	com.tencent.component.network.utils.http.HttpUtil.RequestOptions
    // Exception table:
    //   from	to	target	type
    //   75	81	84	java/lang/Exception
    //   105	124	162	java/lang/Throwable
    //   124	161	162	java/lang/Throwable
    //   312	315	315	java/lang/Throwable
    //   1799	1810	315	java/lang/Throwable
    //   1826	1835	315	java/lang/Throwable
    //   1851	1860	315	java/lang/Throwable
    //   1876	1883	315	java/lang/Throwable
    //   1899	1910	315	java/lang/Throwable
    //   1926	1933	315	java/lang/Throwable
    //   1949	1955	315	java/lang/Throwable
    //   1971	1975	315	java/lang/Throwable
    //   1991	2003	315	java/lang/Throwable
    //   2019	2026	315	java/lang/Throwable
    //   2042	2049	315	java/lang/Throwable
    //   2068	2074	315	java/lang/Throwable
    //   2090	2098	315	java/lang/Throwable
    //   2114	2127	315	java/lang/Throwable
    //   2143	2150	315	java/lang/Throwable
    //   2166	2173	315	java/lang/Throwable
    //   2189	2199	315	java/lang/Throwable
    //   2215	2231	315	java/lang/Throwable
    //   2247	2259	315	java/lang/Throwable
    //   2275	2281	315	java/lang/Throwable
    //   2297	2306	315	java/lang/Throwable
    //   2337	2343	315	java/lang/Throwable
    //   2364	2376	315	java/lang/Throwable
    //   2396	2404	315	java/lang/Throwable
    //   2424	2452	315	java/lang/Throwable
    //   2472	2479	315	java/lang/Throwable
    //   2495	2512	315	java/lang/Throwable
    //   2532	2544	315	java/lang/Throwable
    //   2560	2566	315	java/lang/Throwable
    //   2582	2650	315	java/lang/Throwable
    //   2666	2673	315	java/lang/Throwable
    //   2689	2701	315	java/lang/Throwable
    //   2717	2729	315	java/lang/Throwable
    //   2745	2752	315	java/lang/Throwable
    //   2768	2791	315	java/lang/Throwable
    //   2807	2814	315	java/lang/Throwable
    //   2830	2855	315	java/lang/Throwable
    //   2871	2891	315	java/lang/Throwable
    //   2907	2929	315	java/lang/Throwable
    //   2945	2953	315	java/lang/Throwable
    //   2969	2974	315	java/lang/Throwable
    //   2990	2995	315	java/lang/Throwable
    //   3011	3018	315	java/lang/Throwable
    //   3034	3041	315	java/lang/Throwable
    //   3057	3064	315	java/lang/Throwable
    //   3080	3085	315	java/lang/Throwable
    //   3118	3128	315	java/lang/Throwable
    //   3144	3151	315	java/lang/Throwable
    //   3167	3174	315	java/lang/Throwable
    //   3190	3197	315	java/lang/Throwable
    //   3213	3229	315	java/lang/Throwable
    //   4688	4700	315	java/lang/Throwable
    //   4719	4730	315	java/lang/Throwable
    //   4746	4752	315	java/lang/Throwable
    //   4773	4785	315	java/lang/Throwable
    //   4805	4813	315	java/lang/Throwable
    //   4833	4867	315	java/lang/Throwable
    //   4887	4894	315	java/lang/Throwable
    //   4910	4927	315	java/lang/Throwable
    //   6337	6349	315	java/lang/Throwable
    //   6372	6379	315	java/lang/Throwable
    //   6399	6415	315	java/lang/Throwable
    //   6431	6437	315	java/lang/Throwable
    //   6458	6470	315	java/lang/Throwable
    //   6490	6498	315	java/lang/Throwable
    //   6518	6546	315	java/lang/Throwable
    //   6566	6573	315	java/lang/Throwable
    //   6589	6606	315	java/lang/Throwable
    //   6629	6641	315	java/lang/Throwable
    //   6660	6667	315	java/lang/Throwable
    //   6683	6696	315	java/lang/Throwable
    //   6722	6739	315	java/lang/Throwable
    //   6755	6761	315	java/lang/Throwable
    //   6782	6794	315	java/lang/Throwable
    //   6814	6822	315	java/lang/Throwable
    //   6842	6877	315	java/lang/Throwable
    //   6893	6900	315	java/lang/Throwable
    //   6916	6933	315	java/lang/Throwable
    //   6949	6961	315	java/lang/Throwable
    //   6977	6983	315	java/lang/Throwable
    //   6999	7056	315	java/lang/Throwable
    //   7075	7087	315	java/lang/Throwable
    //   7106	7131	315	java/lang/Throwable
    //   7154	7161	315	java/lang/Throwable
    //   7177	7195	315	java/lang/Throwable
    //   7211	7224	315	java/lang/Throwable
    //   7247	7254	315	java/lang/Throwable
    //   7270	7279	315	java/lang/Throwable
    //   9575	9583	315	java/lang/Throwable
    //   312	315	4934	finally
    //   1799	1810	4934	finally
    //   1826	1835	4934	finally
    //   1851	1860	4934	finally
    //   1876	1883	4934	finally
    //   1899	1910	4934	finally
    //   1926	1933	4934	finally
    //   1949	1955	4934	finally
    //   1971	1975	4934	finally
    //   1991	2003	4934	finally
    //   2019	2026	4934	finally
    //   2042	2049	4934	finally
    //   2068	2074	4934	finally
    //   2090	2098	4934	finally
    //   2114	2127	4934	finally
    //   2143	2150	4934	finally
    //   2166	2173	4934	finally
    //   2189	2199	4934	finally
    //   2215	2231	4934	finally
    //   2247	2259	4934	finally
    //   2275	2281	4934	finally
    //   2297	2306	4934	finally
    //   2337	2343	4934	finally
    //   2364	2376	4934	finally
    //   2396	2404	4934	finally
    //   2424	2452	4934	finally
    //   2472	2479	4934	finally
    //   2495	2512	4934	finally
    //   2532	2544	4934	finally
    //   2560	2566	4934	finally
    //   2582	2650	4934	finally
    //   2666	2673	4934	finally
    //   2689	2701	4934	finally
    //   2717	2729	4934	finally
    //   2745	2752	4934	finally
    //   2768	2791	4934	finally
    //   2807	2814	4934	finally
    //   2830	2855	4934	finally
    //   2871	2891	4934	finally
    //   2907	2929	4934	finally
    //   2945	2953	4934	finally
    //   2969	2974	4934	finally
    //   2990	2995	4934	finally
    //   3011	3018	4934	finally
    //   3034	3041	4934	finally
    //   3057	3064	4934	finally
    //   3080	3085	4934	finally
    //   3118	3128	4934	finally
    //   3144	3151	4934	finally
    //   3167	3174	4934	finally
    //   3190	3197	4934	finally
    //   3213	3229	4934	finally
    //   4688	4700	4934	finally
    //   4719	4730	4934	finally
    //   4746	4752	4934	finally
    //   4773	4785	4934	finally
    //   4805	4813	4934	finally
    //   4833	4867	4934	finally
    //   4887	4894	4934	finally
    //   4910	4927	4934	finally
    //   6337	6349	4934	finally
    //   6372	6379	4934	finally
    //   6399	6415	4934	finally
    //   6431	6437	4934	finally
    //   6458	6470	4934	finally
    //   6490	6498	4934	finally
    //   6518	6546	4934	finally
    //   6566	6573	4934	finally
    //   6589	6606	4934	finally
    //   6629	6641	4934	finally
    //   6660	6667	4934	finally
    //   6683	6696	4934	finally
    //   6722	6739	4934	finally
    //   6755	6761	4934	finally
    //   6782	6794	4934	finally
    //   6814	6822	4934	finally
    //   6842	6877	4934	finally
    //   6893	6900	4934	finally
    //   6916	6933	4934	finally
    //   6949	6961	4934	finally
    //   6977	6983	4934	finally
    //   6999	7056	4934	finally
    //   7075	7087	4934	finally
    //   7106	7131	4934	finally
    //   7154	7161	4934	finally
    //   7177	7195	4934	finally
    //   7211	7224	4934	finally
    //   7247	7254	4934	finally
    //   7270	7279	4934	finally
    //   9575	9583	4934	finally
    //   3400	3415	7298	java/lang/Exception
    //   4182	4209	7985	java/lang/Exception
    //   4239	4266	8000	java/lang/Exception
    //   8298	8313	9605	java/lang/Exception
    //   9080	9107	10292	java/lang/Exception
    //   9137	9164	10307	java/lang/Exception
    //   520	535	10377	java/lang/Exception
    //   1303	1330	11064	java/lang/Exception
    //   1360	1387	11079	java/lang/Exception
    //   5066	5081	11144	java/lang/Exception
    //   5848	5875	11830	java/lang/Exception
    //   5905	5932	11845	java/lang/Exception
    //   3085	3102	11899	finally
    //   3229	3238	11911	finally
    //   3258	3284	11911	finally
    //   8054	8094	11911	finally
    //   8102	8116	11911	finally
    //   8140	8145	11911	finally
    //   8145	8153	11911	finally
    //   8157	8178	11911	finally
    //   336	345	11919	finally
    //   351	358	11919	finally
    //   364	377	11919	finally
    //   380	385	11919	finally
    //   394	403	11919	finally
    //   3085	3102	11927	java/lang/Throwable
    //   3229	3238	11936	java/lang/Throwable
    //   3258	3284	11936	java/lang/Throwable
    //   8054	8094	11936	java/lang/Throwable
    //   8102	8116	11936	java/lang/Throwable
    //   8140	8145	11936	java/lang/Throwable
    //   8145	8153	11936	java/lang/Throwable
    //   8157	8178	11936	java/lang/Throwable
    //   260	270	11941	java/lang/Throwable
  }
  
  protected void initTask()
  {
    super.initTask();
    this.mDomainWithPort = Utils.getDominWithPort(getUrl());
    this.mOrigPort = Utils.getPort(getUrl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.StrictDownloadTask
 * JD-Core Version:    0.7.0.1
 */