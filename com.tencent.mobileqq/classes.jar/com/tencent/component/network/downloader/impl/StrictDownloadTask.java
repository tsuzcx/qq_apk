package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
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
import com.tencent.component.network.utils.http.base.QZoneHttp2Client;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.util.ArrayList;
import java.util.List;
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
  
  public StrictDownloadTask(Context paramContext, QZoneHttp2Client paramQZoneHttp2Client, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramQZoneHttp2Client, paramQZoneHttpClient, paramString1, paramString2, paramBoolean1, paramBoolean2);
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
      localStringBuffer.append(paramBuilder.build().urlString()).append("\n");
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
    //   2: ldc_w 509
    //   5: astore 22
    //   7: iconst_2
    //   8: anewarray 37	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_2
    //   21: aastore
    //   22: invokestatic 515	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   25: istore 8
    //   27: lconst_0
    //   28: lstore 9
    //   30: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   33: lstore 15
    //   35: aload_1
    //   36: invokeinterface 520 1 0
    //   41: ifeq +11 -> 52
    //   44: aload_0
    //   45: aload_1
    //   46: aload_2
    //   47: aconst_null
    //   48: invokevirtual 524	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   51: return
    //   52: aload_0
    //   53: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   56: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   59: ifne +30 -> 89
    //   62: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   65: lload 15
    //   67: lsub
    //   68: ldc2_w 525
    //   71: lcmp
    //   72: ifgt +17 -> 89
    //   75: ldc2_w 527
    //   78: invokestatic 532	java/lang/Thread:sleep	(J)V
    //   81: goto -29 -> 52
    //   84: astore 23
    //   86: goto -34 -> 52
    //   89: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   92: lload 15
    //   94: lsub
    //   95: ldc2_w 525
    //   98: lcmp
    //   99: ifle +74 -> 173
    //   102: aload 22
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   109: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   112: ifne +12 -> 124
    //   115: aload_2
    //   116: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   119: bipush 6
    //   121: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   124: aload_2
    //   125: aload_0
    //   126: aload_2
    //   127: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   130: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   133: aload_2
    //   134: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   137: getfield 549	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   140: iload_3
    //   141: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   144: ldc_w 509
    //   147: aload_2
    //   148: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   151: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   154: aload_1
    //   155: invokespecial 560	com/tencent/component/network/downloader/impl/StrictDownloadTask:generateDownloadDescInfo	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 563	com/tencent/component/network/downloader/DownloadResult:setDescInfo	(Ljava/lang/String;)V
    //   161: return
    //   162: astore_1
    //   163: ldc 226
    //   165: ldc_w 509
    //   168: aload_1
    //   169: invokestatic 567	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: return
    //   173: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   176: lstore 17
    //   178: new 569	com/tencent/component/network/downloader/DownloadReport
    //   181: dup
    //   182: invokespecial 570	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   185: astore 31
    //   187: aload 31
    //   189: iload 8
    //   191: putfield 571	com/tencent/component/network/downloader/DownloadReport:id	I
    //   194: aload 31
    //   196: aload_0
    //   197: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   200: putfield 574	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   203: aload 31
    //   205: aload_0
    //   206: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
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
    //   232: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   235: aload_0
    //   236: aconst_null
    //   237: putfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
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
    //   262: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   265: invokespecial 595	com/tencent/component/network/downloader/impl/StrictDownloadTask:setStrategy	(I)Z
    //   268: istore 21
    //   270: iload 21
    //   272: ifne +16 -> 288
    //   275: aload_0
    //   276: invokevirtual 598	com/tencent/component/network/downloader/impl/StrictDownloadTask:canAttempt	()Z
    //   279: ifne +11397 -> 11676
    //   282: aload 22
    //   284: astore_1
    //   285: goto -180 -> 105
    //   288: aconst_null
    //   289: astore 22
    //   291: aload 22
    //   293: ifnull +1431 -> 1724
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
    //   337: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
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
    //   460: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   463: ifnull +9622 -> 10085
    //   466: aload_0
    //   467: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   470: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   473: ifnull +9612 -> 10085
    //   476: aload_0
    //   477: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   480: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   483: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   486: astore 25
    //   488: aload_0
    //   489: aload_0
    //   490: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   493: aload_0
    //   494: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   497: aload_0
    //   498: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   501: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   504: astore 28
    //   506: aload 25
    //   508: ifnull +9585 -> 10093
    //   511: aload 25
    //   513: astore 23
    //   515: aload 22
    //   517: ifnull +11170 -> 11687
    //   520: aload 22
    //   522: ldc_w 656
    //   525: invokeinterface 662 2 0
    //   530: checkcast 449	java/lang/String
    //   533: astore 22
    //   535: aload_2
    //   536: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   539: aload 22
    //   541: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   544: aload_2
    //   545: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   548: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   551: ifne +64 -> 615
    //   554: aload_0
    //   555: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   558: ifnull +28 -> 586
    //   561: aload_0
    //   562: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   565: aload_0
    //   566: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   569: aload_2
    //   570: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   577: aload_0
    //   578: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   581: invokeinterface 681 5 0
    //   586: aload_0
    //   587: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   590: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   593: ifne +22 -> 615
    //   596: aload_0
    //   597: aload_0
    //   598: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   601: iconst_1
    //   602: isub
    //   603: putfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   606: aload_2
    //   607: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   610: bipush 6
    //   612: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   615: aload_1
    //   616: invokeinterface 520 1 0
    //   621: ifne +1067 -> 1688
    //   624: aload_2
    //   625: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   628: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   631: ifne +9514 -> 10145
    //   634: new 80	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   641: ldc_w 683
    //   644: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload_0
    //   648: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   651: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc_w 685
    //   657: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_0
    //   661: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   664: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   667: ldc_w 687
    //   670: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: astore 29
    //   675: aload_0
    //   676: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   679: ifeq +9432 -> 10111
    //   682: aload_0
    //   683: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   686: ifnull +9425 -> 10111
    //   689: aload_0
    //   690: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   693: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   696: ifnull +9415 -> 10111
    //   699: aload_0
    //   700: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   703: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   706: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
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
    //   758: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   761: invokevirtual 341	java/lang/Thread:getId	()J
    //   764: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   767: ldc_w 709
    //   770: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   776: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: ldc_w 711
    //   782: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: aload_0
    //   786: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   789: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: ldc_w 713
    //   795: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_0
    //   799: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   802: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   805: ldc_w 715
    //   808: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: astore 26
    //   813: aload_0
    //   814: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   817: ifeq +9302 -> 10119
    //   820: aload_0
    //   821: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   824: aload_0
    //   825: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   828: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
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
    //   875: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   878: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   881: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: ldc_w 728
    //   887: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: aload_2
    //   891: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   894: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   897: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   900: ldc_w 733
    //   903: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   909: aload_0
    //   910: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   913: lsub
    //   914: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   917: ldc_w 735
    //   920: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: aload_2
    //   924: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   927: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   930: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   933: ldc_w 740
    //   936: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload_2
    //   940: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   943: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   946: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   949: ldc_w 744
    //   952: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload_2
    //   956: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   959: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   962: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   965: ldc_w 749
    //   968: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: aload_0
    //   972: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
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
    //   1008: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1011: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
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
    //   1062: ifnull +9063 -> 10125
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
    //   1093: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1096: ifnull +9038 -> 10134
    //   1099: aload_0
    //   1100: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1103: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1106: istore_3
    //   1107: aload 22
    //   1109: iload_3
    //   1110: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1113: ldc_w 772
    //   1116: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: aload_2
    //   1120: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1123: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: ldc_w 777
    //   1132: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: lload 9
    //   1137: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1140: ldc_w 779
    //   1143: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: aload_0
    //   1147: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   1150: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1153: ldc 91
    //   1155: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: aload_0
    //   1159: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   1162: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1165: ldc_w 781
    //   1168: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: aload_0
    //   1172: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   1175: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1178: ldc 91
    //   1180: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: aload_0
    //   1184: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   1187: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1190: ldc_w 783
    //   1193: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_0
    //   1197: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   1200: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1203: ldc_w 785
    //   1206: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: aload_0
    //   1210: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   1213: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
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
    //   1241: ifnull +8898 -> 10139
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
    //   1270: invokestatic 567	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1273: getstatic 368	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1276: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1279: aload_0
    //   1280: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1283: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1286: if_icmpne +37 -> 1323
    //   1289: aload_0
    //   1290: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1293: ifnull +30 -> 1323
    //   1296: aload_0
    //   1297: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1300: aload_0
    //   1301: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1304: aload_0
    //   1305: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1308: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1311: aload_2
    //   1312: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1315: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1318: invokeinterface 812 4 0
    //   1323: getstatic 479	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1326: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1329: aload_0
    //   1330: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1333: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1336: if_icmpne +37 -> 1373
    //   1339: aload_0
    //   1340: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1343: ifnull +30 -> 1373
    //   1346: aload_0
    //   1347: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1350: aload_0
    //   1351: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1354: aload_0
    //   1355: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1358: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1361: aload_2
    //   1362: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1365: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1368: invokeinterface 812 4 0
    //   1373: aload 31
    //   1375: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   1378: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1381: aload 31
    //   1383: aload_0
    //   1384: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   1387: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1390: aload 31
    //   1392: aload_0
    //   1393: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   1396: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1399: aload 31
    //   1401: iload 4
    //   1403: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1406: aload 31
    //   1408: aload 24
    //   1410: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1413: aload 27
    //   1415: ifnonnull +9403 -> 10818
    //   1418: aconst_null
    //   1419: astore 22
    //   1421: aload 31
    //   1423: aload 22
    //   1425: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1428: aload_0
    //   1429: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1432: ifnull +9396 -> 10828
    //   1435: aload_0
    //   1436: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1439: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1442: ifnull +9386 -> 10828
    //   1445: aload_0
    //   1446: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1449: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1452: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   1455: astore 22
    //   1457: aload 31
    //   1459: aload 22
    //   1461: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   1464: aload 31
    //   1466: ldc_w 705
    //   1469: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1472: aload 31
    //   1474: aload_2
    //   1475: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1478: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1481: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1484: aload 31
    //   1486: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   1489: aload_0
    //   1490: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   1493: lsub
    //   1494: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1497: aload 31
    //   1499: aload_2
    //   1500: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1503: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1506: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1509: aload 31
    //   1511: aload 31
    //   1513: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1516: aload_2
    //   1517: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1520: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1523: lsub
    //   1524: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1527: aload 31
    //   1529: lload 9
    //   1531: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1534: aload 31
    //   1536: aload_0
    //   1537: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   1540: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1543: aload 31
    //   1545: aload_0
    //   1546: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   1549: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1552: aload 31
    //   1554: aload_0
    //   1555: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   1558: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1561: aload 31
    //   1563: lconst_0
    //   1564: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1567: aload 31
    //   1569: aload_0
    //   1570: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   1573: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1576: aload 31
    //   1578: aload_2
    //   1579: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1582: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1585: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1588: aload 31
    //   1590: aload_0
    //   1591: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1594: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1597: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1600: aload 31
    //   1602: aload_0
    //   1603: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   1606: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1609: aload_0
    //   1610: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1613: ifnull +9221 -> 10834
    //   1616: aload_0
    //   1617: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1620: ldc_w 880
    //   1623: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1626: ifeq +9208 -> 10834
    //   1629: iconst_1
    //   1630: istore 21
    //   1632: aload 31
    //   1634: iload 21
    //   1636: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1639: aload 31
    //   1641: aload_2
    //   1642: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1645: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1648: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1651: aload_2
    //   1652: aload 31
    //   1654: invokevirtual 889	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1657: aload_0
    //   1658: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   1661: aload_0
    //   1662: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   1665: iconst_1
    //   1666: isub
    //   1667: if_icmpeq +13 -> 1680
    //   1670: aload_2
    //   1671: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1674: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1677: ifeq +11 -> 1688
    //   1680: aload_0
    //   1681: aload_1
    //   1682: aload_2
    //   1683: aload 31
    //   1685: invokevirtual 524	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1688: aload_0
    //   1689: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   1692: ifeq +9148 -> 10840
    //   1695: aload_0
    //   1696: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   1699: ifnull +10 -> 1709
    //   1702: aload_0
    //   1703: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   1706: invokevirtual 898	com/squareup/okhttp/Call:cancel	()V
    //   1709: aload_0
    //   1710: aconst_null
    //   1711: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   1714: aload 23
    //   1716: astore 22
    //   1718: iload 5
    //   1720: istore_3
    //   1721: goto -1446 -> 275
    //   1724: lload 9
    //   1726: lstore 11
    //   1728: aload 26
    //   1730: astore 24
    //   1732: lload 9
    //   1734: lstore 13
    //   1736: aload 28
    //   1738: astore 23
    //   1740: getstatic 902	com/tencent/component/network/downloader/impl/StrictDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   1743: invokevirtual 908	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1746: checkcast 910	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   1749: astore 32
    //   1751: lload 9
    //   1753: lstore 11
    //   1755: aload 26
    //   1757: astore 24
    //   1759: lload 9
    //   1761: lstore 13
    //   1763: aload 28
    //   1765: astore 23
    //   1767: aload 32
    //   1769: aload_0
    //   1770: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   1773: putfield 911	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   1776: lload 9
    //   1778: lstore 11
    //   1780: aload 26
    //   1782: astore 24
    //   1784: lload 9
    //   1786: lstore 13
    //   1788: aload 28
    //   1790: astore 23
    //   1792: aload 32
    //   1794: aload_0
    //   1795: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   1798: putfield 914	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   1801: lload 9
    //   1803: lstore 11
    //   1805: aload 26
    //   1807: astore 24
    //   1809: lload 9
    //   1811: lstore 13
    //   1813: aload 28
    //   1815: astore 23
    //   1817: aload_0
    //   1818: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1821: ifnull +2704 -> 4525
    //   1824: lload 9
    //   1826: lstore 11
    //   1828: aload 26
    //   1830: astore 24
    //   1832: lload 9
    //   1834: lstore 13
    //   1836: aload 28
    //   1838: astore 23
    //   1840: aload_0
    //   1841: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1844: invokeinterface 805 1 0
    //   1849: astore 22
    //   1851: lload 9
    //   1853: lstore 11
    //   1855: aload 26
    //   1857: astore 24
    //   1859: lload 9
    //   1861: lstore 13
    //   1863: aload 28
    //   1865: astore 23
    //   1867: aload 32
    //   1869: aload 22
    //   1871: putfield 918	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   1874: lload 9
    //   1876: lstore 11
    //   1878: aload 26
    //   1880: astore 24
    //   1882: lload 9
    //   1884: lstore 13
    //   1886: aload 28
    //   1888: astore 23
    //   1890: aload 31
    //   1892: iload_3
    //   1893: putfield 921	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   1896: lload 9
    //   1898: lstore 11
    //   1900: aload 26
    //   1902: astore 24
    //   1904: lload 9
    //   1906: lstore 13
    //   1908: aload 28
    //   1910: astore 23
    //   1912: aload_2
    //   1913: invokevirtual 924	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   1916: lload 9
    //   1918: lstore 11
    //   1920: aload 26
    //   1922: astore 24
    //   1924: lload 9
    //   1926: lstore 13
    //   1928: aload 28
    //   1930: astore 23
    //   1932: aload_0
    //   1933: aload_0
    //   1934: aload_0
    //   1935: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1938: invokevirtual 927	com/tencent/component/network/downloader/impl/StrictDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   1941: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1944: lload 9
    //   1946: lstore 11
    //   1948: aload 26
    //   1950: astore 24
    //   1952: lload 9
    //   1954: lstore 13
    //   1956: aload 28
    //   1958: astore 23
    //   1960: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   1963: iconst_2
    //   1964: if_icmpeq +9747 -> 11711
    //   1967: lload 9
    //   1969: lstore 11
    //   1971: aload 26
    //   1973: astore 24
    //   1975: lload 9
    //   1977: lstore 13
    //   1979: aload 28
    //   1981: astore 23
    //   1983: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   1986: iconst_3
    //   1987: if_icmpne +2544 -> 4531
    //   1990: goto +9721 -> 11711
    //   1993: lload 9
    //   1995: lstore 11
    //   1997: aload 26
    //   1999: astore 24
    //   2001: lload 9
    //   2003: lstore 13
    //   2005: aload 28
    //   2007: astore 23
    //   2009: aload_0
    //   2010: invokevirtual 930	com/tencent/component/network/downloader/impl/StrictDownloadTask:enableIpv6Debug	()Z
    //   2013: istore 21
    //   2015: lload 9
    //   2017: lstore 11
    //   2019: aload 26
    //   2021: astore 24
    //   2023: lload 9
    //   2025: lstore 13
    //   2027: aload 28
    //   2029: astore 23
    //   2031: aload 32
    //   2033: getfield 918	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2036: ifnonnull +4414 -> 6450
    //   2039: lload 9
    //   2041: lstore 11
    //   2043: aload 26
    //   2045: astore 24
    //   2047: lload 9
    //   2049: lstore 13
    //   2051: aload 28
    //   2053: astore 23
    //   2055: aload_0
    //   2056: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2059: ldc_w 880
    //   2062: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2065: ifeq +26 -> 2091
    //   2068: lload 9
    //   2070: lstore 11
    //   2072: aload 26
    //   2074: astore 24
    //   2076: lload 9
    //   2078: lstore 13
    //   2080: aload 28
    //   2082: astore 23
    //   2084: aload_0
    //   2085: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   2088: ifeq +4362 -> 6450
    //   2091: lload 9
    //   2093: lstore 11
    //   2095: aload 26
    //   2097: astore 24
    //   2099: lload 9
    //   2101: lstore 13
    //   2103: aload 28
    //   2105: astore 23
    //   2107: aload_0
    //   2108: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2111: ifnull +4339 -> 6450
    //   2114: lload 9
    //   2116: lstore 11
    //   2118: aload 26
    //   2120: astore 24
    //   2122: lload 9
    //   2124: lstore 13
    //   2126: aload 28
    //   2128: astore 23
    //   2130: aload_0
    //   2131: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2134: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2137: ifnull +4313 -> 6450
    //   2140: lload 9
    //   2142: lstore 11
    //   2144: aload 26
    //   2146: astore 24
    //   2148: lload 9
    //   2150: lstore 13
    //   2152: aload 28
    //   2154: astore 23
    //   2156: aload_0
    //   2157: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2160: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2163: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2166: invokestatic 415	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2169: ifne +4281 -> 6450
    //   2172: lload 9
    //   2174: lstore 11
    //   2176: aload 26
    //   2178: astore 24
    //   2180: lload 9
    //   2182: lstore 13
    //   2184: aload 28
    //   2186: astore 23
    //   2188: aload_0
    //   2189: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2192: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2195: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2198: astore 30
    //   2200: lload 9
    //   2202: lstore 11
    //   2204: aload 26
    //   2206: astore 24
    //   2208: lload 9
    //   2210: lstore 13
    //   2212: aload 28
    //   2214: astore 23
    //   2216: aload_0
    //   2217: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2220: astore 29
    //   2222: lload 9
    //   2224: lstore 11
    //   2226: aload 26
    //   2228: astore 24
    //   2230: lload 9
    //   2232: lstore 13
    //   2234: aload 28
    //   2236: astore 23
    //   2238: aload 30
    //   2240: bipush 58
    //   2242: invokestatic 934	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   2245: istore 5
    //   2247: iload 4
    //   2249: ifne +9468 -> 11717
    //   2252: aload 29
    //   2254: astore 22
    //   2256: iload 5
    //   2258: iconst_2
    //   2259: if_icmpge +198 -> 2457
    //   2262: lload 9
    //   2264: lstore 11
    //   2266: aload 26
    //   2268: astore 24
    //   2270: lload 9
    //   2272: lstore 13
    //   2274: aload 28
    //   2276: astore 23
    //   2278: aload_0
    //   2279: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   2282: istore 4
    //   2284: iload 4
    //   2286: ifle +2251 -> 4537
    //   2289: lload 9
    //   2291: lstore 11
    //   2293: aload 26
    //   2295: astore 24
    //   2297: lload 9
    //   2299: lstore 13
    //   2301: aload 28
    //   2303: astore 23
    //   2305: aload_0
    //   2306: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2309: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2312: iload 4
    //   2314: putfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2317: lload 9
    //   2319: lstore 11
    //   2321: aload 26
    //   2323: astore 24
    //   2325: iload 4
    //   2327: istore 5
    //   2329: lload 9
    //   2331: lstore 13
    //   2333: aload 28
    //   2335: astore 23
    //   2337: iload 4
    //   2339: invokestatic 365	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   2342: ifne +7 -> 2349
    //   2345: bipush 80
    //   2347: istore 5
    //   2349: lload 9
    //   2351: lstore 11
    //   2353: aload 26
    //   2355: astore 24
    //   2357: lload 9
    //   2359: lstore 13
    //   2361: aload 28
    //   2363: astore 23
    //   2365: new 80	java/lang/StringBuilder
    //   2368: dup
    //   2369: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2372: aload 30
    //   2374: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: ldc_w 939
    //   2380: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2383: iload 5
    //   2385: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2388: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2391: astore 25
    //   2393: lload 9
    //   2395: lstore 11
    //   2397: aload 26
    //   2399: astore 24
    //   2401: aload 25
    //   2403: astore 22
    //   2405: lload 9
    //   2407: lstore 13
    //   2409: aload 28
    //   2411: astore 23
    //   2413: aload_0
    //   2414: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2417: ifnull +40 -> 2457
    //   2420: lload 9
    //   2422: lstore 11
    //   2424: aload 26
    //   2426: astore 24
    //   2428: lload 9
    //   2430: lstore 13
    //   2432: aload 28
    //   2434: astore 23
    //   2436: aload_0
    //   2437: aload_0
    //   2438: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2441: aload_0
    //   2442: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2445: aload 25
    //   2447: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2450: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2453: aload 25
    //   2455: astore 22
    //   2457: lload 9
    //   2459: lstore 11
    //   2461: aload 26
    //   2463: astore 24
    //   2465: lload 9
    //   2467: lstore 13
    //   2469: aload 28
    //   2471: astore 23
    //   2473: aload 31
    //   2475: aload_0
    //   2476: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2479: invokevirtual 312	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2482: putfield 948	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2485: lload 9
    //   2487: lstore 11
    //   2489: aload 26
    //   2491: astore 24
    //   2493: lload 9
    //   2495: lstore 13
    //   2497: aload 28
    //   2499: astore 23
    //   2501: invokestatic 951	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   2504: ifeq +87 -> 2591
    //   2507: lload 9
    //   2509: lstore 11
    //   2511: aload 26
    //   2513: astore 24
    //   2515: lload 9
    //   2517: lstore 13
    //   2519: aload 28
    //   2521: astore 23
    //   2523: ldc 226
    //   2525: new 80	java/lang/StringBuilder
    //   2528: dup
    //   2529: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2532: ldc_w 953
    //   2535: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2538: aload 31
    //   2540: getfield 948	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2543: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: ldc_w 955
    //   2549: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2552: aload 22
    //   2554: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2557: ldc_w 323
    //   2560: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: aload_0
    //   2564: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2567: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: ldc_w 388
    //   2573: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2576: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2579: invokevirtual 341	java/lang/Thread:getId	()J
    //   2582: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2585: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2588: invokestatic 958	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2591: lload 9
    //   2593: lstore 11
    //   2595: aload 26
    //   2597: astore 24
    //   2599: lload 9
    //   2601: lstore 13
    //   2603: aload 28
    //   2605: astore 23
    //   2607: aload_0
    //   2608: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2611: ifnull +59 -> 2670
    //   2614: lload 9
    //   2616: lstore 11
    //   2618: aload 26
    //   2620: astore 24
    //   2622: lload 9
    //   2624: lstore 13
    //   2626: aload 28
    //   2628: astore 23
    //   2630: aload 31
    //   2632: aload_0
    //   2633: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2636: invokevirtual 312	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2639: putfield 948	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2642: lload 9
    //   2644: lstore 11
    //   2646: aload 26
    //   2648: astore 24
    //   2650: lload 9
    //   2652: lstore 13
    //   2654: aload 28
    //   2656: astore 23
    //   2658: aload 31
    //   2660: aload_0
    //   2661: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2664: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2667: putfield 961	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2670: lload 9
    //   2672: lstore 11
    //   2674: aload 26
    //   2676: astore 24
    //   2678: lload 9
    //   2680: lstore 13
    //   2682: aload 28
    //   2684: astore 23
    //   2686: aload_0
    //   2687: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   2690: ifeq +4183 -> 6873
    //   2693: lload 9
    //   2695: lstore 11
    //   2697: aload 26
    //   2699: astore 24
    //   2701: lload 9
    //   2703: lstore 13
    //   2705: aload 28
    //   2707: astore 23
    //   2709: aload_0
    //   2710: aload_0
    //   2711: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   2714: aload_0
    //   2715: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2718: aload_0
    //   2719: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2722: aload_0
    //   2723: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   2726: invokestatic 967	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   2729: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2732: lload 9
    //   2734: lstore 11
    //   2736: aload 26
    //   2738: astore 24
    //   2740: lload 9
    //   2742: lstore 13
    //   2744: aload 28
    //   2746: astore 23
    //   2748: aload_0
    //   2749: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2752: ifnull +44 -> 2796
    //   2755: lload 9
    //   2757: lstore 11
    //   2759: aload 26
    //   2761: astore 24
    //   2763: lload 9
    //   2765: lstore 13
    //   2767: aload 28
    //   2769: astore 23
    //   2771: aload_0
    //   2772: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2775: aload_0
    //   2776: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2779: aload_0
    //   2780: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2783: aload_0
    //   2784: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2787: aload_0
    //   2788: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2791: invokeinterface 971 5 0
    //   2796: lload 9
    //   2798: lstore 11
    //   2800: aload 26
    //   2802: astore 24
    //   2804: lload 9
    //   2806: lstore 13
    //   2808: aload 28
    //   2810: astore 23
    //   2812: aload_0
    //   2813: aload_0
    //   2814: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2817: aload_0
    //   2818: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2821: aload_0
    //   2822: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2825: aload_0
    //   2826: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2829: invokevirtual 974	com/tencent/component/network/downloader/impl/StrictDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;)V
    //   2832: lload 9
    //   2834: lstore 11
    //   2836: aload 26
    //   2838: astore 24
    //   2840: lload 9
    //   2842: lstore 13
    //   2844: aload 28
    //   2846: astore 23
    //   2848: aload_0
    //   2849: aload_0
    //   2850: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2853: aload_0
    //   2854: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   2857: aload_0
    //   2858: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2861: aload_0
    //   2862: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   2865: aload 32
    //   2867: invokevirtual 978	com/tencent/component/network/downloader/impl/StrictDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2870: lload 9
    //   2872: lstore 11
    //   2874: aload 26
    //   2876: astore 24
    //   2878: lload 9
    //   2880: lstore 13
    //   2882: aload 28
    //   2884: astore 23
    //   2886: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   2889: lload 19
    //   2891: lsub
    //   2892: lstore 9
    //   2894: lload 9
    //   2896: lstore 11
    //   2898: aload 26
    //   2900: astore 24
    //   2902: lload 9
    //   2904: lstore 13
    //   2906: aload 28
    //   2908: astore 23
    //   2910: aload_0
    //   2911: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   2914: putfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   2917: lload 9
    //   2919: lstore 11
    //   2921: aload 26
    //   2923: astore 24
    //   2925: lload 9
    //   2927: lstore 13
    //   2929: aload 28
    //   2931: astore 23
    //   2933: aload_0
    //   2934: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2937: ifnull +3980 -> 6917
    //   2940: lload 9
    //   2942: lstore 11
    //   2944: aload 26
    //   2946: astore 24
    //   2948: lload 9
    //   2950: lstore 13
    //   2952: aload 28
    //   2954: astore 23
    //   2956: aload_0
    //   2957: getfield 982	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2960: ifnonnull +26 -> 2986
    //   2963: lload 9
    //   2965: lstore 11
    //   2967: aload 26
    //   2969: astore 24
    //   2971: lload 9
    //   2973: lstore 13
    //   2975: aload 28
    //   2977: astore 23
    //   2979: aload_0
    //   2980: invokestatic 986	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2983: putfield 982	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2986: lload 9
    //   2988: lstore 11
    //   2990: aload 26
    //   2992: astore 24
    //   2994: lload 9
    //   2996: lstore 13
    //   2998: aload 28
    //   3000: astore 23
    //   3002: invokestatic 990	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   3005: astore 22
    //   3007: aload_0
    //   3008: aload_0
    //   3009: getfield 982	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   3012: aload_0
    //   3013: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3016: aload 22
    //   3018: invokevirtual 995	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   3021: putfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3024: lload 9
    //   3026: lstore 11
    //   3028: aload 22
    //   3030: astore 24
    //   3032: lload 9
    //   3034: lstore 13
    //   3036: aload 22
    //   3038: astore 23
    //   3040: aload_0
    //   3041: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3044: aload_0
    //   3045: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   3048: lsub
    //   3049: putfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   3052: lload 9
    //   3054: lstore 11
    //   3056: aload 22
    //   3058: astore 24
    //   3060: lload 9
    //   3062: lstore 13
    //   3064: aload 22
    //   3066: astore 23
    //   3068: aload_0
    //   3069: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3072: ifnonnull +26 -> 3098
    //   3075: lload 9
    //   3077: lstore 11
    //   3079: aload 22
    //   3081: astore 24
    //   3083: lload 9
    //   3085: lstore 13
    //   3087: aload 22
    //   3089: astore 23
    //   3091: aload_0
    //   3092: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3095: ifnull +6188 -> 9283
    //   3098: lload 9
    //   3100: lstore 11
    //   3102: aload 22
    //   3104: astore 24
    //   3106: lload 9
    //   3108: lstore 13
    //   3110: aload 22
    //   3112: astore 23
    //   3114: aload_0
    //   3115: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3118: ifnull +3896 -> 7014
    //   3121: lload 9
    //   3123: lstore 11
    //   3125: aload 22
    //   3127: astore 24
    //   3129: lload 9
    //   3131: lstore 13
    //   3133: aload 22
    //   3135: astore 23
    //   3137: aload_0
    //   3138: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3141: invokeinterface 212 1 0
    //   3146: invokeinterface 1000 1 0
    //   3151: istore 4
    //   3153: aload_2
    //   3154: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3157: iload 4
    //   3159: putfield 549	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   3162: sipush 200
    //   3165: iload 4
    //   3167: if_icmpeq +11 -> 3178
    //   3170: sipush 206
    //   3173: iload 4
    //   3175: if_icmpne +4662 -> 7837
    //   3178: iload 4
    //   3180: istore 5
    //   3182: aload_0
    //   3183: aload_0
    //   3184: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3187: aload_0
    //   3188: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3191: aload_2
    //   3192: aload_1
    //   3193: iload 4
    //   3195: invokevirtual 1004	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   3198: ifeq +4767 -> 7965
    //   3201: aload_2
    //   3202: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3205: invokevirtual 1007	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   3208: iload_3
    //   3209: iconst_1
    //   3210: iadd
    //   3211: istore 5
    //   3213: aload_2
    //   3214: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3217: lload 17
    //   3219: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3222: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3225: aload_2
    //   3226: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3229: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3232: aload_0
    //   3233: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   3236: lsub
    //   3237: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3240: aload_2
    //   3241: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3244: aload_0
    //   3245: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   3248: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3251: aload_0
    //   3252: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3255: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3258: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3261: astore 26
    //   3263: aload_0
    //   3264: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3267: ifnull +3798 -> 7065
    //   3270: aload_0
    //   3271: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3274: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3277: ifnull +3788 -> 7065
    //   3280: aload_0
    //   3281: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3284: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3287: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   3290: astore 24
    //   3292: aload_0
    //   3293: aload_0
    //   3294: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3297: aload_0
    //   3298: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3301: aload_0
    //   3302: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3305: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   3308: astore 27
    //   3310: aload 24
    //   3312: ifnull +3761 -> 7073
    //   3315: aload 24
    //   3317: astore 23
    //   3319: aload 22
    //   3321: ifnull +8382 -> 11703
    //   3324: aload 22
    //   3326: ldc_w 656
    //   3329: invokeinterface 662 2 0
    //   3334: checkcast 449	java/lang/String
    //   3337: astore 22
    //   3339: aload_2
    //   3340: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3343: aload 22
    //   3345: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3348: aload_2
    //   3349: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3352: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3355: ifne +64 -> 3419
    //   3358: aload_0
    //   3359: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3362: ifnull +28 -> 3390
    //   3365: aload_0
    //   3366: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3369: aload_0
    //   3370: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   3373: aload_2
    //   3374: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3377: aload_0
    //   3378: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3381: aload_0
    //   3382: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3385: invokeinterface 681 5 0
    //   3390: aload_0
    //   3391: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3394: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3397: ifne +22 -> 3419
    //   3400: aload_0
    //   3401: aload_0
    //   3402: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3405: iconst_1
    //   3406: isub
    //   3407: putfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3410: aload_2
    //   3411: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3414: bipush 6
    //   3416: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3419: aload_1
    //   3420: invokeinterface 520 1 0
    //   3425: ifne +1065 -> 4490
    //   3428: aload_2
    //   3429: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3432: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3435: ifne +3690 -> 7125
    //   3438: new 80	java/lang/StringBuilder
    //   3441: dup
    //   3442: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   3445: ldc_w 683
    //   3448: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3451: aload_0
    //   3452: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   3455: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3458: ldc_w 685
    //   3461: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3464: aload_0
    //   3465: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   3468: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3471: ldc_w 687
    //   3474: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3477: astore 28
    //   3479: aload_0
    //   3480: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   3483: ifeq +3608 -> 7091
    //   3486: aload_0
    //   3487: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3490: ifnull +3601 -> 7091
    //   3493: aload_0
    //   3494: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3497: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3500: ifnull +3591 -> 7091
    //   3503: aload_0
    //   3504: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3507: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3510: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   3513: astore 25
    //   3515: aload 28
    //   3517: aload 25
    //   3519: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3522: ldc_w 696
    //   3525: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3528: aload 26
    //   3530: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3533: ldc_w 701
    //   3536: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3539: aload 24
    //   3541: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3544: ldc_w 703
    //   3547: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3550: ldc_w 705
    //   3553: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3556: ldc_w 707
    //   3559: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3562: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3565: invokevirtual 341	java/lang/Thread:getId	()J
    //   3568: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3571: ldc_w 709
    //   3574: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3577: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3580: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3583: ldc_w 711
    //   3586: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3589: aload_0
    //   3590: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   3593: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3596: ldc_w 713
    //   3599: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3602: aload_0
    //   3603: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   3606: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3609: ldc_w 715
    //   3612: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: astore 25
    //   3617: aload_0
    //   3618: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   3621: ifeq +3478 -> 7099
    //   3624: aload_0
    //   3625: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3628: aload_0
    //   3629: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   3632: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3635: astore 24
    //   3637: aload 25
    //   3639: aload 24
    //   3641: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3644: ldc_w 717
    //   3647: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3650: aload_0
    //   3651: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3654: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3657: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3660: ldc_w 719
    //   3663: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3666: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3669: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3672: ldc_w 726
    //   3675: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3678: aload_2
    //   3679: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3682: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3685: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3688: ldc_w 728
    //   3691: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3694: aload_2
    //   3695: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3698: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3701: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3704: ldc_w 733
    //   3707: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3710: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3713: aload_0
    //   3714: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   3717: lsub
    //   3718: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3721: ldc_w 735
    //   3724: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: aload_2
    //   3728: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3731: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3734: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3737: ldc_w 740
    //   3740: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3743: aload_2
    //   3744: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3747: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3750: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3753: ldc_w 744
    //   3756: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3759: aload_2
    //   3760: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3763: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3766: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3769: ldc_w 749
    //   3772: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3775: aload_0
    //   3776: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3779: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3782: ldc 91
    //   3784: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3787: aload_0
    //   3788: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   3791: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3794: ldc_w 754
    //   3797: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3800: iload 5
    //   3802: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3805: ldc_w 756
    //   3808: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3811: aload_2
    //   3812: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3815: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3818: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3821: ldc_w 758
    //   3824: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3827: iload 4
    //   3829: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3832: ldc_w 760
    //   3835: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3838: aload 27
    //   3840: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3843: ldc_w 762
    //   3846: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3849: aload 22
    //   3851: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3854: ldc_w 764
    //   3857: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3860: astore 24
    //   3862: aload_0
    //   3863: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   3866: ifnull +3239 -> 7105
    //   3869: aload_0
    //   3870: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   3873: iconst_0
    //   3874: bipush 30
    //   3876: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   3879: astore 22
    //   3881: aload 24
    //   3883: aload 22
    //   3885: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3888: ldc_w 770
    //   3891: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3894: astore 22
    //   3896: aload_0
    //   3897: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3900: ifnull +3214 -> 7114
    //   3903: aload_0
    //   3904: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3907: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3910: istore_3
    //   3911: aload 22
    //   3913: iload_3
    //   3914: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3917: ldc_w 772
    //   3920: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3923: aload_2
    //   3924: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3927: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3930: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3933: ldc_w 777
    //   3936: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3939: lload 9
    //   3941: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3944: ldc_w 779
    //   3947: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3950: aload_0
    //   3951: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   3954: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3957: ldc 91
    //   3959: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3962: aload_0
    //   3963: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   3966: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3969: ldc_w 781
    //   3972: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3975: aload_0
    //   3976: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   3979: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3982: ldc 91
    //   3984: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3987: aload_0
    //   3988: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   3991: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3994: ldc_w 783
    //   3997: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4000: aload_0
    //   4001: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   4004: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4007: ldc_w 785
    //   4010: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4013: aload_0
    //   4014: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   4017: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4020: ldc_w 790
    //   4023: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4026: aload_0
    //   4027: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   4030: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4033: ldc_w 795
    //   4036: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4039: astore 24
    //   4041: aload_0
    //   4042: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4045: ifnull +3074 -> 7119
    //   4048: aload_0
    //   4049: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4052: invokeinterface 805 1 0
    //   4057: astore 22
    //   4059: ldc_w 613
    //   4062: aload 24
    //   4064: aload 22
    //   4066: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4069: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4072: aconst_null
    //   4073: invokestatic 567	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4076: getstatic 368	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4079: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4082: aload_0
    //   4083: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4086: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4089: if_icmpne +37 -> 4126
    //   4092: aload_0
    //   4093: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4096: ifnull +30 -> 4126
    //   4099: aload_0
    //   4100: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4103: aload_0
    //   4104: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4107: aload_0
    //   4108: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4111: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4114: aload_2
    //   4115: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4118: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4121: invokeinterface 812 4 0
    //   4126: getstatic 479	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4129: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4132: aload_0
    //   4133: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4136: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4139: if_icmpne +37 -> 4176
    //   4142: aload_0
    //   4143: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4146: ifnull +30 -> 4176
    //   4149: aload_0
    //   4150: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4153: aload_0
    //   4154: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4157: aload_0
    //   4158: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4161: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4164: aload_2
    //   4165: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4168: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4171: invokeinterface 812 4 0
    //   4176: aload 31
    //   4178: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   4181: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4184: aload 31
    //   4186: aload_0
    //   4187: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   4190: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4193: aload 31
    //   4195: aload_0
    //   4196: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   4199: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4202: aload 31
    //   4204: iload 4
    //   4206: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4209: aload 31
    //   4211: aconst_null
    //   4212: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4215: aload 26
    //   4217: ifnonnull +3581 -> 7798
    //   4220: aconst_null
    //   4221: astore 22
    //   4223: aload 31
    //   4225: aload 22
    //   4227: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4230: aload_0
    //   4231: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4234: ifnull +3574 -> 7808
    //   4237: aload_0
    //   4238: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4241: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4244: ifnull +3564 -> 7808
    //   4247: aload_0
    //   4248: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4251: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4254: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   4257: astore 22
    //   4259: aload 31
    //   4261: aload 22
    //   4263: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   4266: aload 31
    //   4268: ldc_w 705
    //   4271: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4274: aload 31
    //   4276: aload_2
    //   4277: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4280: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4283: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4286: aload 31
    //   4288: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4291: aload_0
    //   4292: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   4295: lsub
    //   4296: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4299: aload 31
    //   4301: aload_2
    //   4302: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4305: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4308: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4311: aload 31
    //   4313: aload 31
    //   4315: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4318: aload_2
    //   4319: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4322: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4325: lsub
    //   4326: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4329: aload 31
    //   4331: lload 9
    //   4333: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4336: aload 31
    //   4338: aload_0
    //   4339: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   4342: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4345: aload 31
    //   4347: aload_0
    //   4348: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   4351: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4354: aload 31
    //   4356: aload_0
    //   4357: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   4360: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4363: aload 31
    //   4365: lconst_0
    //   4366: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4369: aload 31
    //   4371: aload_0
    //   4372: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   4375: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4378: aload 31
    //   4380: aload_2
    //   4381: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4384: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4387: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4390: aload 31
    //   4392: aload_0
    //   4393: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4396: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4399: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4402: aload 31
    //   4404: aload_0
    //   4405: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   4408: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4411: aload_0
    //   4412: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4415: ifnull +3399 -> 7814
    //   4418: aload_0
    //   4419: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4422: ldc_w 880
    //   4425: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4428: ifeq +3386 -> 7814
    //   4431: iconst_1
    //   4432: istore 21
    //   4434: aload 31
    //   4436: iload 21
    //   4438: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4441: aload 31
    //   4443: aload_2
    //   4444: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4447: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4450: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4453: aload_2
    //   4454: aload 31
    //   4456: invokevirtual 889	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4459: aload_0
    //   4460: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   4463: aload_0
    //   4464: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   4467: iconst_1
    //   4468: isub
    //   4469: if_icmpeq +13 -> 4482
    //   4472: aload_2
    //   4473: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4476: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4479: ifeq +11 -> 4490
    //   4482: aload_0
    //   4483: aload_1
    //   4484: aload_2
    //   4485: aload 31
    //   4487: invokevirtual 524	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4490: aload_0
    //   4491: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   4494: ifeq +3326 -> 7820
    //   4497: aload_0
    //   4498: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   4501: ifnull +10 -> 4511
    //   4504: aload_0
    //   4505: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   4508: invokevirtual 898	com/squareup/okhttp/Call:cancel	()V
    //   4511: aload_0
    //   4512: aconst_null
    //   4513: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   4516: aload 23
    //   4518: astore_1
    //   4519: iload 5
    //   4521: istore_3
    //   4522: goto -4417 -> 105
    //   4525: aconst_null
    //   4526: astore 22
    //   4528: goto -2677 -> 1851
    //   4531: iconst_0
    //   4532: istore 4
    //   4534: goto -2541 -> 1993
    //   4537: lload 9
    //   4539: lstore 11
    //   4541: aload 26
    //   4543: astore 24
    //   4545: lload 9
    //   4547: lstore 13
    //   4549: aload 28
    //   4551: astore 23
    //   4553: aload_0
    //   4554: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4557: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4560: getfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4563: istore 4
    //   4565: goto -2248 -> 2317
    //   4568: lload 9
    //   4570: lstore 11
    //   4572: aload 26
    //   4574: astore 24
    //   4576: lload 9
    //   4578: lstore 13
    //   4580: aload 28
    //   4582: astore 23
    //   4584: aload 25
    //   4586: bipush 58
    //   4588: invokestatic 934	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   4591: iconst_2
    //   4592: if_icmplt +1566 -> 6158
    //   4595: lload 9
    //   4597: lstore 11
    //   4599: aload 26
    //   4601: astore 24
    //   4603: lload 9
    //   4605: lstore 13
    //   4607: aload 28
    //   4609: astore 23
    //   4611: aload_0
    //   4612: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   4615: istore 4
    //   4617: iload 4
    //   4619: ifle +1508 -> 6127
    //   4622: lload 9
    //   4624: lstore 11
    //   4626: aload 26
    //   4628: astore 24
    //   4630: lload 9
    //   4632: lstore 13
    //   4634: aload 28
    //   4636: astore 23
    //   4638: aload_0
    //   4639: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4642: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4645: iload 4
    //   4647: putfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4650: lload 9
    //   4652: lstore 11
    //   4654: aload 26
    //   4656: astore 24
    //   4658: iload 4
    //   4660: istore 5
    //   4662: lload 9
    //   4664: lstore 13
    //   4666: aload 28
    //   4668: astore 23
    //   4670: iload 4
    //   4672: invokestatic 365	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   4675: ifne +7 -> 4682
    //   4678: bipush 80
    //   4680: istore 5
    //   4682: lload 9
    //   4684: lstore 11
    //   4686: aload 26
    //   4688: astore 24
    //   4690: lload 9
    //   4692: lstore 13
    //   4694: aload 28
    //   4696: astore 23
    //   4698: new 80	java/lang/StringBuilder
    //   4701: dup
    //   4702: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   4705: ldc_w 1009
    //   4708: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4711: aload 25
    //   4713: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4716: ldc_w 1011
    //   4719: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4722: iload 5
    //   4724: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4727: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4730: astore 25
    //   4732: lload 9
    //   4734: lstore 11
    //   4736: aload 26
    //   4738: astore 24
    //   4740: aload 25
    //   4742: astore 22
    //   4744: lload 9
    //   4746: lstore 13
    //   4748: aload 28
    //   4750: astore 23
    //   4752: aload_0
    //   4753: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4756: ifnull -2299 -> 2457
    //   4759: lload 9
    //   4761: lstore 11
    //   4763: aload 26
    //   4765: astore 24
    //   4767: lload 9
    //   4769: lstore 13
    //   4771: aload 28
    //   4773: astore 23
    //   4775: aload_0
    //   4776: aload_0
    //   4777: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4780: aload_0
    //   4781: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4784: aload 25
    //   4786: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4789: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4792: aload 25
    //   4794: astore 22
    //   4796: goto -2339 -> 2457
    //   4799: astore 25
    //   4801: lload 13
    //   4803: lstore 9
    //   4805: aconst_null
    //   4806: astore 24
    //   4808: aload 23
    //   4810: astore 22
    //   4812: iload 6
    //   4814: istore 4
    //   4816: aload 25
    //   4818: astore 23
    //   4820: iload_3
    //   4821: iconst_1
    //   4822: iadd
    //   4823: istore_3
    //   4824: aload_2
    //   4825: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4828: lload 17
    //   4830: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4833: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4836: aload_2
    //   4837: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4840: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4843: aload_0
    //   4844: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   4847: lsub
    //   4848: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4851: aload_2
    //   4852: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4855: aload_0
    //   4856: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   4859: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4862: aload_0
    //   4863: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   4866: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4869: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4872: astore 27
    //   4874: aload_0
    //   4875: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4878: ifnull +5979 -> 10857
    //   4881: aload_0
    //   4882: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4885: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4888: ifnull +5969 -> 10857
    //   4891: aload_0
    //   4892: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4895: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4898: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   4901: astore 25
    //   4903: aload_0
    //   4904: aload_0
    //   4905: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   4908: aload_0
    //   4909: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   4912: aload_0
    //   4913: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   4916: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   4919: astore 28
    //   4921: aload 25
    //   4923: ifnull +5942 -> 10865
    //   4926: aload 22
    //   4928: ifnull +6751 -> 11679
    //   4931: aload 22
    //   4933: ldc_w 656
    //   4936: invokeinterface 662 2 0
    //   4941: checkcast 449	java/lang/String
    //   4944: astore 22
    //   4946: aload_2
    //   4947: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4950: aload 22
    //   4952: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   4955: aload_2
    //   4956: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4959: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4962: ifne +64 -> 5026
    //   4965: aload_0
    //   4966: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4969: ifnull +28 -> 4997
    //   4972: aload_0
    //   4973: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4976: aload_0
    //   4977: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   4980: aload_2
    //   4981: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4984: aload_0
    //   4985: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   4988: aload_0
    //   4989: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   4992: invokeinterface 681 5 0
    //   4997: aload_0
    //   4998: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5001: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5004: ifne +22 -> 5026
    //   5007: aload_0
    //   5008: aload_0
    //   5009: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5012: iconst_1
    //   5013: isub
    //   5014: putfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5017: aload_2
    //   5018: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5021: bipush 6
    //   5023: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   5026: aload_1
    //   5027: invokeinterface 520 1 0
    //   5032: ifne +1066 -> 6098
    //   5035: aload_2
    //   5036: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5039: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5042: ifne +5870 -> 10912
    //   5045: new 80	java/lang/StringBuilder
    //   5048: dup
    //   5049: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   5052: ldc_w 683
    //   5055: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5058: aload_0
    //   5059: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   5062: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5065: ldc_w 685
    //   5068: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5071: aload_0
    //   5072: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   5075: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5078: ldc_w 687
    //   5081: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5084: astore 29
    //   5086: aload_0
    //   5087: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   5090: ifeq +5788 -> 10878
    //   5093: aload_0
    //   5094: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   5097: ifnull +5781 -> 10878
    //   5100: aload_0
    //   5101: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   5104: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5107: ifnull +5771 -> 10878
    //   5110: aload_0
    //   5111: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   5114: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5117: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   5120: astore 26
    //   5122: aload 29
    //   5124: aload 26
    //   5126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5129: ldc_w 696
    //   5132: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5135: aload 27
    //   5137: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5140: ldc_w 701
    //   5143: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5146: aload 25
    //   5148: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5151: ldc_w 703
    //   5154: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5157: ldc_w 705
    //   5160: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5163: ldc_w 707
    //   5166: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5169: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5172: invokevirtual 341	java/lang/Thread:getId	()J
    //   5175: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5178: ldc_w 709
    //   5181: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5184: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5187: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5190: ldc_w 711
    //   5193: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5196: aload_0
    //   5197: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   5200: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5203: ldc_w 713
    //   5206: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5209: aload_0
    //   5210: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   5213: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5216: ldc_w 715
    //   5219: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5222: astore 26
    //   5224: aload_0
    //   5225: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   5228: ifeq +5658 -> 10886
    //   5231: aload_0
    //   5232: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5235: aload_0
    //   5236: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   5239: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5242: astore 25
    //   5244: aload 26
    //   5246: aload 25
    //   5248: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5251: ldc_w 717
    //   5254: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5257: aload_0
    //   5258: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5261: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5264: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5267: ldc_w 719
    //   5270: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5273: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5276: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5279: ldc_w 726
    //   5282: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5285: aload_2
    //   5286: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5289: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5292: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5295: ldc_w 728
    //   5298: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5301: aload_2
    //   5302: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5305: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5308: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5311: ldc_w 733
    //   5314: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5317: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   5320: aload_0
    //   5321: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   5324: lsub
    //   5325: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5328: ldc_w 735
    //   5331: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5334: aload_2
    //   5335: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5338: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5341: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5344: ldc_w 740
    //   5347: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5350: aload_2
    //   5351: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5354: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5357: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5360: ldc_w 744
    //   5363: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5366: aload_2
    //   5367: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5370: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5373: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5376: ldc_w 749
    //   5379: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5382: aload_0
    //   5383: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5386: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5389: ldc 91
    //   5391: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5394: aload_0
    //   5395: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   5398: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5401: ldc_w 754
    //   5404: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5407: iload_3
    //   5408: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5411: ldc_w 756
    //   5414: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5417: aload_2
    //   5418: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5421: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5424: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5427: ldc_w 758
    //   5430: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5433: iload 4
    //   5435: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5438: ldc_w 760
    //   5441: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5444: aload 28
    //   5446: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5449: ldc_w 762
    //   5452: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5455: aload 22
    //   5457: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5460: ldc_w 764
    //   5463: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5466: astore 25
    //   5468: aload_0
    //   5469: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5472: ifnull +5420 -> 10892
    //   5475: aload_0
    //   5476: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5479: iconst_0
    //   5480: bipush 30
    //   5482: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   5485: astore 22
    //   5487: aload 25
    //   5489: aload 22
    //   5491: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5494: ldc_w 770
    //   5497: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5500: astore 22
    //   5502: aload_0
    //   5503: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5506: ifnull +5395 -> 10901
    //   5509: aload_0
    //   5510: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5513: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5516: istore_3
    //   5517: aload 22
    //   5519: iload_3
    //   5520: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5523: ldc_w 772
    //   5526: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5529: aload_2
    //   5530: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5533: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5536: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5539: ldc_w 777
    //   5542: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5545: lload 9
    //   5547: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5550: ldc_w 779
    //   5553: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5556: aload_0
    //   5557: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   5560: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5563: ldc 91
    //   5565: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5568: aload_0
    //   5569: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   5572: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5575: ldc_w 781
    //   5578: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5581: aload_0
    //   5582: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   5585: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5588: ldc 91
    //   5590: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5593: aload_0
    //   5594: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   5597: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5600: ldc_w 783
    //   5603: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5606: aload_0
    //   5607: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   5610: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5613: ldc_w 785
    //   5616: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5619: aload_0
    //   5620: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   5623: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5626: ldc_w 790
    //   5629: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5632: aload_0
    //   5633: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   5636: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5639: ldc_w 795
    //   5642: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5645: astore 25
    //   5647: aload_0
    //   5648: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5651: ifnull +5255 -> 10906
    //   5654: aload_0
    //   5655: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5658: invokeinterface 805 1 0
    //   5663: astore 22
    //   5665: ldc_w 613
    //   5668: aload 25
    //   5670: aload 22
    //   5672: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5675: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5678: aload 24
    //   5680: invokestatic 567	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5683: getstatic 368	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5686: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5689: aload_0
    //   5690: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5693: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5696: if_icmpne +37 -> 5733
    //   5699: aload_0
    //   5700: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5703: ifnull +30 -> 5733
    //   5706: aload_0
    //   5707: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5710: aload_0
    //   5711: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   5714: aload_0
    //   5715: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5718: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5721: aload_2
    //   5722: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5725: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5728: invokeinterface 812 4 0
    //   5733: getstatic 479	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5736: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5739: aload_0
    //   5740: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5743: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5746: if_icmpne +37 -> 5783
    //   5749: aload_0
    //   5750: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5753: ifnull +30 -> 5783
    //   5756: aload_0
    //   5757: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5760: aload_0
    //   5761: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   5764: aload_0
    //   5765: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5768: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5771: aload_2
    //   5772: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5775: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5778: invokeinterface 812 4 0
    //   5783: aload 31
    //   5785: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   5788: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5791: aload 31
    //   5793: aload_0
    //   5794: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   5797: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5800: aload 31
    //   5802: aload_0
    //   5803: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   5806: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   5809: aload 31
    //   5811: iload 4
    //   5813: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5816: aload 31
    //   5818: aload 24
    //   5820: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5823: aload 27
    //   5825: ifnonnull +5759 -> 11584
    //   5828: aconst_null
    //   5829: astore 22
    //   5831: aload 31
    //   5833: aload 22
    //   5835: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5838: aload_0
    //   5839: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5842: ifnull +5752 -> 11594
    //   5845: aload_0
    //   5846: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5849: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5852: ifnull +5742 -> 11594
    //   5855: aload_0
    //   5856: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5859: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5862: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   5865: astore 22
    //   5867: aload 31
    //   5869: aload 22
    //   5871: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   5874: aload 31
    //   5876: ldc_w 705
    //   5879: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5882: aload 31
    //   5884: aload_2
    //   5885: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5888: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5891: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5894: aload 31
    //   5896: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   5899: aload_0
    //   5900: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   5903: lsub
    //   5904: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5907: aload 31
    //   5909: aload_2
    //   5910: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5913: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5916: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   5919: aload 31
    //   5921: aload 31
    //   5923: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5926: aload_2
    //   5927: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5930: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5933: lsub
    //   5934: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5937: aload 31
    //   5939: lload 9
    //   5941: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5944: aload 31
    //   5946: aload_0
    //   5947: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   5950: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5953: aload 31
    //   5955: aload_0
    //   5956: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   5959: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5962: aload 31
    //   5964: aload_0
    //   5965: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   5968: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5971: aload 31
    //   5973: lconst_0
    //   5974: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5977: aload 31
    //   5979: aload_0
    //   5980: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   5983: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   5986: aload 31
    //   5988: aload_2
    //   5989: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5992: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5995: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5998: aload 31
    //   6000: aload_0
    //   6001: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   6004: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6007: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6010: aload 31
    //   6012: aload_0
    //   6013: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   6016: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6019: aload_0
    //   6020: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6023: ifnull +5577 -> 11600
    //   6026: aload_0
    //   6027: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6030: ldc_w 880
    //   6033: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6036: ifeq +5564 -> 11600
    //   6039: iconst_1
    //   6040: istore 21
    //   6042: aload 31
    //   6044: iload 21
    //   6046: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6049: aload 31
    //   6051: aload_2
    //   6052: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6055: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6058: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6061: aload_2
    //   6062: aload 31
    //   6064: invokevirtual 889	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6067: aload_0
    //   6068: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   6071: aload_0
    //   6072: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   6075: iconst_1
    //   6076: isub
    //   6077: if_icmpeq +13 -> 6090
    //   6080: aload_2
    //   6081: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6084: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6087: ifeq +11 -> 6098
    //   6090: aload_0
    //   6091: aload_1
    //   6092: aload_2
    //   6093: aload 31
    //   6095: invokevirtual 524	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6098: aload_0
    //   6099: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   6102: ifeq +5504 -> 11606
    //   6105: aload_0
    //   6106: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6109: ifnull +10 -> 6119
    //   6112: aload_0
    //   6113: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6116: invokevirtual 898	com/squareup/okhttp/Call:cancel	()V
    //   6119: aload_0
    //   6120: aconst_null
    //   6121: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6124: aload 23
    //   6126: athrow
    //   6127: lload 9
    //   6129: lstore 11
    //   6131: aload 26
    //   6133: astore 24
    //   6135: lload 9
    //   6137: lstore 13
    //   6139: aload 28
    //   6141: astore 23
    //   6143: aload_0
    //   6144: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6147: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6150: getfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6153: istore 4
    //   6155: goto -1505 -> 4650
    //   6158: lload 9
    //   6160: lstore 11
    //   6162: aload 26
    //   6164: astore 24
    //   6166: aload 29
    //   6168: astore 22
    //   6170: lload 9
    //   6172: lstore 13
    //   6174: aload 28
    //   6176: astore 23
    //   6178: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6181: iconst_3
    //   6182: if_icmpne -3725 -> 2457
    //   6185: lload 9
    //   6187: lstore 11
    //   6189: aload 26
    //   6191: astore 24
    //   6193: aload 29
    //   6195: astore 22
    //   6197: lload 9
    //   6199: lstore 13
    //   6201: aload 28
    //   6203: astore 23
    //   6205: aload_0
    //   6206: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6209: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6212: getstatic 439	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6215: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6218: if_icmpeq -3761 -> 2457
    //   6221: lload 9
    //   6223: lstore 11
    //   6225: aload 26
    //   6227: astore 24
    //   6229: lload 9
    //   6231: lstore 13
    //   6233: aload 28
    //   6235: astore 23
    //   6237: aload_0
    //   6238: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   6241: istore 4
    //   6243: iload 4
    //   6245: ifle +174 -> 6419
    //   6248: lload 9
    //   6250: lstore 11
    //   6252: aload 26
    //   6254: astore 24
    //   6256: lload 9
    //   6258: lstore 13
    //   6260: aload 28
    //   6262: astore 23
    //   6264: aload_0
    //   6265: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6268: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6271: iload 4
    //   6273: putfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6276: lload 9
    //   6278: lstore 11
    //   6280: aload 26
    //   6282: astore 24
    //   6284: lload 9
    //   6286: lstore 13
    //   6288: aload 28
    //   6290: astore 23
    //   6292: iload 4
    //   6294: istore 5
    //   6296: iload 4
    //   6298: invokestatic 365	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6301: ifne +7 -> 6308
    //   6304: bipush 80
    //   6306: istore 5
    //   6308: lload 9
    //   6310: lstore 11
    //   6312: aload 26
    //   6314: astore 24
    //   6316: lload 9
    //   6318: lstore 13
    //   6320: aload 28
    //   6322: astore 23
    //   6324: new 80	java/lang/StringBuilder
    //   6327: dup
    //   6328: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6331: aload 25
    //   6333: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6336: ldc_w 939
    //   6339: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6342: iload 5
    //   6344: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6347: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6350: astore 25
    //   6352: lload 9
    //   6354: lstore 11
    //   6356: aload 26
    //   6358: astore 24
    //   6360: aload 25
    //   6362: astore 22
    //   6364: lload 9
    //   6366: lstore 13
    //   6368: aload 28
    //   6370: astore 23
    //   6372: aload_0
    //   6373: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6376: ifnull -3919 -> 2457
    //   6379: lload 9
    //   6381: lstore 11
    //   6383: aload 26
    //   6385: astore 24
    //   6387: lload 9
    //   6389: lstore 13
    //   6391: aload 28
    //   6393: astore 23
    //   6395: aload_0
    //   6396: aload_0
    //   6397: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6400: aload_0
    //   6401: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6404: aload 25
    //   6406: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6409: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6412: aload 25
    //   6414: astore 22
    //   6416: goto -3959 -> 2457
    //   6419: lload 9
    //   6421: lstore 11
    //   6423: aload 26
    //   6425: astore 24
    //   6427: lload 9
    //   6429: lstore 13
    //   6431: aload 28
    //   6433: astore 23
    //   6435: aload_0
    //   6436: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6439: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6442: getfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6445: istore 4
    //   6447: goto -171 -> 6276
    //   6450: lload 9
    //   6452: lstore 11
    //   6454: aload 26
    //   6456: astore 24
    //   6458: lload 9
    //   6460: lstore 13
    //   6462: aload 28
    //   6464: astore 23
    //   6466: aload_0
    //   6467: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6470: ldc_w 880
    //   6473: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6476: ifeq -3885 -> 2591
    //   6479: iload 4
    //   6481: ifeq -3890 -> 2591
    //   6484: iload 21
    //   6486: ifeq -3895 -> 2591
    //   6489: lload 9
    //   6491: lstore 11
    //   6493: aload 26
    //   6495: astore 24
    //   6497: lload 9
    //   6499: lstore 13
    //   6501: aload 28
    //   6503: astore 23
    //   6505: aload_0
    //   6506: aload_0
    //   6507: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6510: ldc_w 1013
    //   6513: ldc_w 1015
    //   6516: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6519: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6522: lload 9
    //   6524: lstore 11
    //   6526: aload 26
    //   6528: astore 24
    //   6530: lload 9
    //   6532: lstore 13
    //   6534: aload 28
    //   6536: astore 23
    //   6538: aload_0
    //   6539: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   6542: istore 4
    //   6544: iload 4
    //   6546: ifle +296 -> 6842
    //   6549: lload 9
    //   6551: lstore 11
    //   6553: aload 26
    //   6555: astore 24
    //   6557: lload 9
    //   6559: lstore 13
    //   6561: aload 28
    //   6563: astore 23
    //   6565: aload_0
    //   6566: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6569: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6572: iload 4
    //   6574: putfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6577: lload 9
    //   6579: lstore 11
    //   6581: aload 26
    //   6583: astore 24
    //   6585: lload 9
    //   6587: lstore 13
    //   6589: aload 28
    //   6591: astore 23
    //   6593: iload 4
    //   6595: istore 5
    //   6597: iload 4
    //   6599: invokestatic 365	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6602: ifne +7 -> 6609
    //   6605: bipush 80
    //   6607: istore 5
    //   6609: lload 9
    //   6611: lstore 11
    //   6613: aload 26
    //   6615: astore 24
    //   6617: lload 9
    //   6619: lstore 13
    //   6621: aload 28
    //   6623: astore 23
    //   6625: new 80	java/lang/StringBuilder
    //   6628: dup
    //   6629: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6632: ldc_w 1009
    //   6635: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6638: ldc_w 1017
    //   6641: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6644: ldc_w 1011
    //   6647: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6650: iload 5
    //   6652: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6655: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6658: astore 22
    //   6660: lload 9
    //   6662: lstore 11
    //   6664: aload 26
    //   6666: astore 24
    //   6668: lload 9
    //   6670: lstore 13
    //   6672: aload 28
    //   6674: astore 23
    //   6676: aload_0
    //   6677: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6680: ifnull +36 -> 6716
    //   6683: lload 9
    //   6685: lstore 11
    //   6687: aload 26
    //   6689: astore 24
    //   6691: lload 9
    //   6693: lstore 13
    //   6695: aload 28
    //   6697: astore 23
    //   6699: aload_0
    //   6700: aload_0
    //   6701: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6704: aload_0
    //   6705: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6708: aload 22
    //   6710: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6713: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6716: lload 9
    //   6718: lstore 11
    //   6720: aload 26
    //   6722: astore 24
    //   6724: lload 9
    //   6726: lstore 13
    //   6728: aload 28
    //   6730: astore 23
    //   6732: aload 31
    //   6734: aload_0
    //   6735: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6738: invokevirtual 312	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   6741: putfield 948	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6744: lload 9
    //   6746: lstore 11
    //   6748: aload 26
    //   6750: astore 24
    //   6752: lload 9
    //   6754: lstore 13
    //   6756: aload 28
    //   6758: astore 23
    //   6760: invokestatic 951	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   6763: ifeq -4172 -> 2591
    //   6766: lload 9
    //   6768: lstore 11
    //   6770: aload 26
    //   6772: astore 24
    //   6774: lload 9
    //   6776: lstore 13
    //   6778: aload 28
    //   6780: astore 23
    //   6782: ldc 226
    //   6784: new 80	java/lang/StringBuilder
    //   6787: dup
    //   6788: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6791: ldc_w 953
    //   6794: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6797: aload 31
    //   6799: getfield 948	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6802: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6805: ldc_w 1019
    //   6808: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6811: aload_0
    //   6812: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   6815: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6818: ldc_w 388
    //   6821: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6824: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6827: invokevirtual 341	java/lang/Thread:getId	()J
    //   6830: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6833: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6836: invokestatic 958	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6839: goto -4248 -> 2591
    //   6842: lload 9
    //   6844: lstore 11
    //   6846: aload 26
    //   6848: astore 24
    //   6850: lload 9
    //   6852: lstore 13
    //   6854: aload 28
    //   6856: astore 23
    //   6858: aload_0
    //   6859: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6862: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6865: getfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6868: istore 4
    //   6870: goto -293 -> 6577
    //   6873: lload 9
    //   6875: lstore 11
    //   6877: aload 26
    //   6879: astore 24
    //   6881: lload 9
    //   6883: lstore 13
    //   6885: aload 28
    //   6887: astore 23
    //   6889: aload_0
    //   6890: aload_0
    //   6891: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   6894: aload_0
    //   6895: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   6898: aload_0
    //   6899: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   6902: aload_0
    //   6903: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6906: aload 32
    //   6908: invokestatic 1023	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   6911: putfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   6914: goto -4182 -> 2732
    //   6917: lload 9
    //   6919: lstore 11
    //   6921: aload 26
    //   6923: astore 24
    //   6925: aload 27
    //   6927: astore 22
    //   6929: lload 9
    //   6931: lstore 13
    //   6933: aload 28
    //   6935: astore 23
    //   6937: aload_0
    //   6938: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6941: ifnull -3917 -> 3024
    //   6944: lload 9
    //   6946: lstore 11
    //   6948: aload 26
    //   6950: astore 24
    //   6952: lload 9
    //   6954: lstore 13
    //   6956: aload 28
    //   6958: astore 23
    //   6960: aload_0
    //   6961: aload_0
    //   6962: getfield 1027	com/tencent/component/network/downloader/impl/StrictDownloadTask:pokHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttp2Client;
    //   6965: aload_0
    //   6966: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6969: invokevirtual 183	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   6972: aload 32
    //   6974: invokevirtual 1033	com/tencent/component/network/utils/http/base/QZoneHttp2Client:newCall	(Lcom/squareup/okhttp/Request;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lcom/squareup/okhttp/Call;
    //   6977: putfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6980: lload 9
    //   6982: lstore 11
    //   6984: aload 26
    //   6986: astore 24
    //   6988: lload 9
    //   6990: lstore 13
    //   6992: aload 28
    //   6994: astore 23
    //   6996: aload_0
    //   6997: aload_0
    //   6998: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   7001: invokevirtual 1036	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   7004: putfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7007: aload 27
    //   7009: astore 22
    //   7011: goto -3987 -> 3024
    //   7014: lload 9
    //   7016: lstore 11
    //   7018: aload 22
    //   7020: astore 24
    //   7022: lload 9
    //   7024: lstore 13
    //   7026: aload 22
    //   7028: astore 23
    //   7030: aload_0
    //   7031: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7034: ifnull +4636 -> 11670
    //   7037: lload 9
    //   7039: lstore 11
    //   7041: aload 22
    //   7043: astore 24
    //   7045: lload 9
    //   7047: lstore 13
    //   7049: aload 22
    //   7051: astore 23
    //   7053: aload_0
    //   7054: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7057: invokevirtual 218	com/squareup/okhttp/Response:code	()I
    //   7060: istore 4
    //   7062: goto -3909 -> 3153
    //   7065: ldc_w 705
    //   7068: astore 24
    //   7070: goto -3778 -> 3292
    //   7073: ldc_w 1038
    //   7076: astore 23
    //   7078: goto -3759 -> 3319
    //   7081: astore 22
    //   7083: ldc_w 509
    //   7086: astore 22
    //   7088: goto -3749 -> 3339
    //   7091: ldc_w 1040
    //   7094: astore 25
    //   7096: goto -3581 -> 3515
    //   7099: aconst_null
    //   7100: astore 24
    //   7102: goto -3465 -> 3637
    //   7105: aload_0
    //   7106: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7109: astore 22
    //   7111: goto -3230 -> 3881
    //   7114: iconst_0
    //   7115: istore_3
    //   7116: goto -3205 -> 3911
    //   7119: aconst_null
    //   7120: astore 22
    //   7122: goto -3063 -> 4059
    //   7125: new 80	java/lang/StringBuilder
    //   7128: dup
    //   7129: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   7132: ldc_w 1042
    //   7135: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7138: aload_0
    //   7139: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   7142: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7145: ldc_w 685
    //   7148: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7151: aload_0
    //   7152: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   7155: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7158: ldc_w 687
    //   7161: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7164: astore 28
    //   7166: aload_0
    //   7167: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   7170: ifeq +564 -> 7734
    //   7173: aload_0
    //   7174: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7177: ifnull +557 -> 7734
    //   7180: aload_0
    //   7181: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7184: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7187: ifnull +547 -> 7734
    //   7190: aload_0
    //   7191: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7194: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7197: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   7200: astore 25
    //   7202: aload 28
    //   7204: aload 25
    //   7206: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7209: ldc_w 696
    //   7212: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7215: aload 26
    //   7217: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7220: ldc_w 701
    //   7223: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7226: aload 24
    //   7228: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7231: ldc_w 703
    //   7234: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7237: ldc_w 705
    //   7240: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7243: ldc_w 707
    //   7246: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7249: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7252: invokevirtual 341	java/lang/Thread:getId	()J
    //   7255: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7258: ldc_w 709
    //   7261: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7264: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7267: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7270: ldc_w 711
    //   7273: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7276: aload_0
    //   7277: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   7280: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7283: ldc_w 713
    //   7286: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7289: aload_0
    //   7290: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   7293: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7296: ldc_w 715
    //   7299: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7302: astore 25
    //   7304: aload_0
    //   7305: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   7308: ifeq +434 -> 7742
    //   7311: aload_0
    //   7312: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   7315: aload_0
    //   7316: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   7319: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7322: astore 24
    //   7324: aload 25
    //   7326: aload 24
    //   7328: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7331: ldc_w 719
    //   7334: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7337: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7340: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7343: ldc_w 728
    //   7346: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7349: aload_2
    //   7350: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7353: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7356: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7359: ldc_w 733
    //   7362: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7365: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   7368: aload_0
    //   7369: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   7372: lsub
    //   7373: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7376: ldc_w 735
    //   7379: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7382: aload_2
    //   7383: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7386: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7389: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7392: ldc_w 740
    //   7395: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7398: aload_2
    //   7399: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7402: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7405: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7408: ldc_w 744
    //   7411: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7414: aload_2
    //   7415: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7418: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7421: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7424: ldc_w 749
    //   7427: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7430: aload_0
    //   7431: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   7434: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7437: ldc 91
    //   7439: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7442: aload_0
    //   7443: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   7446: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7449: ldc_w 754
    //   7452: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7455: iload 5
    //   7457: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7460: ldc_w 1044
    //   7463: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7466: iload 4
    //   7468: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7471: ldc_w 726
    //   7474: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7477: aload_2
    //   7478: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7481: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7484: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7487: ldc_w 760
    //   7490: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7493: aload 27
    //   7495: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7498: ldc_w 762
    //   7501: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7504: aload 22
    //   7506: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7509: ldc_w 764
    //   7512: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7515: astore 24
    //   7517: aload_0
    //   7518: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7521: ifnull +227 -> 7748
    //   7524: aload_0
    //   7525: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7528: iconst_0
    //   7529: bipush 30
    //   7531: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   7534: astore 22
    //   7536: aload 24
    //   7538: aload 22
    //   7540: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7543: ldc_w 770
    //   7546: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7549: astore 22
    //   7551: aload_0
    //   7552: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7555: ifnull +202 -> 7757
    //   7558: aload_0
    //   7559: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7562: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7565: istore_3
    //   7566: aload 22
    //   7568: iload_3
    //   7569: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7572: ldc_w 772
    //   7575: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7578: aload_2
    //   7579: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7582: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7585: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7588: ldc_w 777
    //   7591: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7594: lload 9
    //   7596: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7599: ldc_w 779
    //   7602: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7605: aload_0
    //   7606: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   7609: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7612: ldc 91
    //   7614: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7617: aload_0
    //   7618: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   7621: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7624: ldc_w 781
    //   7627: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7630: aload_0
    //   7631: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   7634: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7637: ldc 91
    //   7639: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7642: aload_0
    //   7643: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   7646: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7649: ldc_w 783
    //   7652: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7655: aload_0
    //   7656: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   7659: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7662: ldc_w 785
    //   7665: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7668: aload_0
    //   7669: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   7672: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7675: ldc_w 790
    //   7678: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7681: aload_0
    //   7682: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   7685: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7688: ldc_w 795
    //   7691: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7694: astore 24
    //   7696: aload_0
    //   7697: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7700: ifnull +62 -> 7762
    //   7703: aload_0
    //   7704: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7707: invokeinterface 805 1 0
    //   7712: astore 22
    //   7714: ldc_w 613
    //   7717: aload 24
    //   7719: aload 22
    //   7721: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7724: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7727: aconst_null
    //   7728: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7731: goto -3655 -> 4076
    //   7734: ldc_w 1040
    //   7737: astore 25
    //   7739: goto -537 -> 7202
    //   7742: aconst_null
    //   7743: astore 24
    //   7745: goto -421 -> 7324
    //   7748: aload_0
    //   7749: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7752: astore 22
    //   7754: goto -218 -> 7536
    //   7757: iconst_0
    //   7758: istore_3
    //   7759: goto -193 -> 7566
    //   7762: aconst_null
    //   7763: astore 22
    //   7765: goto -51 -> 7714
    //   7768: astore 22
    //   7770: ldc 226
    //   7772: ldc_w 1047
    //   7775: aload 22
    //   7777: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7780: goto -3654 -> 4126
    //   7783: astore 22
    //   7785: ldc 226
    //   7787: ldc_w 1048
    //   7790: aload 22
    //   7792: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7795: goto -3619 -> 4176
    //   7798: aload 26
    //   7800: invokevirtual 1051	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7803: astore 22
    //   7805: goto -3582 -> 4223
    //   7808: aconst_null
    //   7809: astore 22
    //   7811: goto -3552 -> 4259
    //   7814: iconst_0
    //   7815: istore 21
    //   7817: goto -3383 -> 4434
    //   7820: aload_0
    //   7821: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7824: ifnull -3308 -> 4516
    //   7827: aload_0
    //   7828: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7831: invokevirtual 1056	org/apache/http/client/methods/HttpGet:abort	()V
    //   7834: goto -3318 -> 4516
    //   7837: aload_0
    //   7838: aload_0
    //   7839: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7842: aload_0
    //   7843: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   7846: aload_0
    //   7847: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   7850: aload_0
    //   7851: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7854: invokespecial 1058	com/tencent/component/network/downloader/impl/StrictDownloadTask:printfHttpDetail	(Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)V
    //   7857: aload_0
    //   7858: aload_0
    //   7859: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   7862: aload_0
    //   7863: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7866: invokevirtual 1062	com/tencent/component/network/downloader/impl/StrictDownloadTask:getRetryFlag	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   7869: ifne +8 -> 7877
    //   7872: aload_0
    //   7873: iconst_0
    //   7874: invokevirtual 1065	com/tencent/component/network/downloader/impl/StrictDownloadTask:setAttemptCount	(I)V
    //   7877: sipush 404
    //   7880: iload 4
    //   7882: if_icmpne +46 -> 7928
    //   7885: aload_0
    //   7886: aload_0
    //   7887: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   7890: aload_0
    //   7891: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7894: invokevirtual 1068	com/tencent/component/network/downloader/impl/StrictDownloadTask:getXErrorCode	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   7897: istore 5
    //   7899: iload 5
    //   7901: sipush -6101
    //   7904: if_icmpeq +19 -> 7923
    //   7907: iload 5
    //   7909: sipush -5062
    //   7912: if_icmpeq +11 -> 7923
    //   7915: iload 5
    //   7917: sipush -5023
    //   7920: if_icmpne +8 -> 7928
    //   7923: aload_0
    //   7924: iconst_0
    //   7925: invokevirtual 1065	com/tencent/component/network/downloader/impl/StrictDownloadTask:setAttemptCount	(I)V
    //   7928: aload_2
    //   7929: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7932: iconst_3
    //   7933: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   7936: iload 4
    //   7938: istore 5
    //   7940: aload_0
    //   7941: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   7944: ifnull +21 -> 7965
    //   7947: aload_0
    //   7948: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   7951: aload_0
    //   7952: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   7955: iconst_1
    //   7956: invokeinterface 1072 3 0
    //   7961: iload 4
    //   7963: istore 5
    //   7965: iload_3
    //   7966: iconst_1
    //   7967: iadd
    //   7968: istore 4
    //   7970: aload_2
    //   7971: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7974: lload 17
    //   7976: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   7979: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   7982: aload_2
    //   7983: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7986: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   7989: aload_0
    //   7990: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   7993: lsub
    //   7994: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   7997: aload_2
    //   7998: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8001: aload_0
    //   8002: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   8005: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8008: aload_0
    //   8009: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8012: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8015: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8018: astore 26
    //   8020: aload_0
    //   8021: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8024: ifnull +1289 -> 9313
    //   8027: aload_0
    //   8028: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8031: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8034: ifnull +1279 -> 9313
    //   8037: aload_0
    //   8038: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8041: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8044: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   8047: astore 24
    //   8049: aload_0
    //   8050: aload_0
    //   8051: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8054: aload_0
    //   8055: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8058: aload_0
    //   8059: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8062: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   8065: astore 27
    //   8067: aload 24
    //   8069: ifnull +1252 -> 9321
    //   8072: aload 24
    //   8074: astore 23
    //   8076: aload 22
    //   8078: ifnull +3617 -> 11695
    //   8081: aload 22
    //   8083: ldc_w 656
    //   8086: invokeinterface 662 2 0
    //   8091: checkcast 449	java/lang/String
    //   8094: astore 22
    //   8096: aload_2
    //   8097: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8100: aload 22
    //   8102: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8105: aload_2
    //   8106: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8109: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8112: ifne +64 -> 8176
    //   8115: aload_0
    //   8116: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8119: ifnull +28 -> 8147
    //   8122: aload_0
    //   8123: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8126: aload_0
    //   8127: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8130: aload_2
    //   8131: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   8134: aload_0
    //   8135: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8138: aload_0
    //   8139: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8142: invokeinterface 681 5 0
    //   8147: aload_0
    //   8148: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8151: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8154: ifne +22 -> 8176
    //   8157: aload_0
    //   8158: aload_0
    //   8159: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8162: iconst_1
    //   8163: isub
    //   8164: putfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8167: aload_2
    //   8168: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8171: bipush 6
    //   8173: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   8176: aload_1
    //   8177: invokeinterface 520 1 0
    //   8182: ifne +1065 -> 9247
    //   8185: aload_2
    //   8186: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8189: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8192: ifne +1181 -> 9373
    //   8195: new 80	java/lang/StringBuilder
    //   8198: dup
    //   8199: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   8202: ldc_w 683
    //   8205: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8208: aload_0
    //   8209: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8212: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8215: ldc_w 685
    //   8218: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8221: aload_0
    //   8222: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   8225: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8228: ldc_w 687
    //   8231: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8234: astore 28
    //   8236: aload_0
    //   8237: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   8240: ifeq +1099 -> 9339
    //   8243: aload_0
    //   8244: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8247: ifnull +1092 -> 9339
    //   8250: aload_0
    //   8251: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8254: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8257: ifnull +1082 -> 9339
    //   8260: aload_0
    //   8261: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8264: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8267: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   8270: astore 25
    //   8272: aload 28
    //   8274: aload 25
    //   8276: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8279: ldc_w 696
    //   8282: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8285: aload 26
    //   8287: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8290: ldc_w 701
    //   8293: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8296: aload 24
    //   8298: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8301: ldc_w 703
    //   8304: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8307: ldc_w 705
    //   8310: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8313: ldc_w 707
    //   8316: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8319: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8322: invokevirtual 341	java/lang/Thread:getId	()J
    //   8325: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8328: ldc_w 709
    //   8331: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8334: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8337: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8340: ldc_w 711
    //   8343: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8346: aload_0
    //   8347: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   8350: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8353: ldc_w 713
    //   8356: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8359: aload_0
    //   8360: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   8363: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8366: ldc_w 715
    //   8369: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8372: astore 25
    //   8374: aload_0
    //   8375: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   8378: ifeq +969 -> 9347
    //   8381: aload_0
    //   8382: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8385: aload_0
    //   8386: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   8389: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8392: astore 24
    //   8394: aload 25
    //   8396: aload 24
    //   8398: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8401: ldc_w 717
    //   8404: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8407: aload_0
    //   8408: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8411: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8414: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8417: ldc_w 719
    //   8420: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8423: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8426: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8429: ldc_w 726
    //   8432: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8435: aload_2
    //   8436: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8439: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8442: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8445: ldc_w 728
    //   8448: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8451: aload_2
    //   8452: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8455: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8458: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8461: ldc_w 733
    //   8464: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8467: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8470: aload_0
    //   8471: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   8474: lsub
    //   8475: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8478: ldc_w 735
    //   8481: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8484: aload_2
    //   8485: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8488: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8491: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8494: ldc_w 740
    //   8497: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8500: aload_2
    //   8501: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8504: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8507: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8510: ldc_w 744
    //   8513: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8516: aload_2
    //   8517: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8520: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8523: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8526: ldc_w 749
    //   8529: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8532: aload_0
    //   8533: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8536: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8539: ldc 91
    //   8541: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8544: aload_0
    //   8545: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   8548: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8551: ldc_w 754
    //   8554: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8557: iload 4
    //   8559: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8562: ldc_w 756
    //   8565: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8568: aload_2
    //   8569: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8572: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8575: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8578: ldc_w 758
    //   8581: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8584: iload 5
    //   8586: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8589: ldc_w 760
    //   8592: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8595: aload 27
    //   8597: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8600: ldc_w 762
    //   8603: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8606: aload 22
    //   8608: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8611: ldc_w 764
    //   8614: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8617: astore 24
    //   8619: aload_0
    //   8620: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8623: ifnull +730 -> 9353
    //   8626: aload_0
    //   8627: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8630: iconst_0
    //   8631: bipush 30
    //   8633: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   8636: astore 22
    //   8638: aload 24
    //   8640: aload 22
    //   8642: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8645: ldc_w 770
    //   8648: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8651: astore 22
    //   8653: aload_0
    //   8654: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8657: ifnull +705 -> 9362
    //   8660: aload_0
    //   8661: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8664: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8667: istore_3
    //   8668: aload 22
    //   8670: iload_3
    //   8671: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8674: ldc_w 772
    //   8677: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8680: aload_2
    //   8681: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8684: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8687: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8690: ldc_w 777
    //   8693: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8696: lload 9
    //   8698: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8701: ldc_w 779
    //   8704: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8707: aload_0
    //   8708: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   8711: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8714: ldc 91
    //   8716: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8719: aload_0
    //   8720: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   8723: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8726: ldc_w 781
    //   8729: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8732: aload_0
    //   8733: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   8736: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8739: ldc 91
    //   8741: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8744: aload_0
    //   8745: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   8748: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8751: ldc_w 783
    //   8754: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8757: aload_0
    //   8758: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   8761: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8764: ldc_w 785
    //   8767: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8770: aload_0
    //   8771: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   8774: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8777: ldc_w 790
    //   8780: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8783: aload_0
    //   8784: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   8787: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8790: ldc_w 795
    //   8793: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8796: astore 24
    //   8798: aload_0
    //   8799: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8802: ifnull +565 -> 9367
    //   8805: aload_0
    //   8806: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8809: invokeinterface 805 1 0
    //   8814: astore 22
    //   8816: ldc_w 613
    //   8819: aload 24
    //   8821: aload 22
    //   8823: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8826: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8829: aconst_null
    //   8830: invokestatic 567	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8833: getstatic 368	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8836: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8839: aload_0
    //   8840: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8843: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8846: if_icmpne +37 -> 8883
    //   8849: aload_0
    //   8850: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8853: ifnull +30 -> 8883
    //   8856: aload_0
    //   8857: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8860: aload_0
    //   8861: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   8864: aload_0
    //   8865: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8868: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   8871: aload_2
    //   8872: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8875: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8878: invokeinterface 812 4 0
    //   8883: getstatic 479	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8886: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8889: aload_0
    //   8890: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8893: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8896: if_icmpne +37 -> 8933
    //   8899: aload_0
    //   8900: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8903: ifnull +30 -> 8933
    //   8906: aload_0
    //   8907: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8910: aload_0
    //   8911: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   8914: aload_0
    //   8915: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8918: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   8921: aload_2
    //   8922: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8925: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8928: invokeinterface 812 4 0
    //   8933: aload 31
    //   8935: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   8938: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   8941: aload 31
    //   8943: aload_0
    //   8944: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   8947: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   8950: aload 31
    //   8952: aload_0
    //   8953: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8956: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   8959: aload 31
    //   8961: iload 5
    //   8963: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   8966: aload 31
    //   8968: aconst_null
    //   8969: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   8972: aload 26
    //   8974: ifnonnull +1072 -> 10046
    //   8977: aconst_null
    //   8978: astore 22
    //   8980: aload 31
    //   8982: aload 22
    //   8984: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   8987: aload_0
    //   8988: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8991: ifnull +1065 -> 10056
    //   8994: aload_0
    //   8995: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8998: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   9001: ifnull +1055 -> 10056
    //   9004: aload_0
    //   9005: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9008: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   9011: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   9014: astore 22
    //   9016: aload 31
    //   9018: aload 22
    //   9020: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   9023: aload 31
    //   9025: ldc_w 705
    //   9028: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9031: aload 31
    //   9033: aload_2
    //   9034: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9037: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9040: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9043: aload 31
    //   9045: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   9048: aload_0
    //   9049: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   9052: lsub
    //   9053: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9056: aload 31
    //   9058: aload_2
    //   9059: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9062: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9065: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9068: aload 31
    //   9070: aload 31
    //   9072: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9075: aload_2
    //   9076: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9079: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9082: lsub
    //   9083: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9086: aload 31
    //   9088: lload 9
    //   9090: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9093: aload 31
    //   9095: aload_0
    //   9096: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   9099: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9102: aload 31
    //   9104: aload_0
    //   9105: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   9108: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9111: aload 31
    //   9113: aload_0
    //   9114: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   9117: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9120: aload 31
    //   9122: lconst_0
    //   9123: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9126: aload 31
    //   9128: aload_0
    //   9129: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   9132: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9135: aload 31
    //   9137: aload_2
    //   9138: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9141: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9144: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9147: aload 31
    //   9149: aload_0
    //   9150: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   9153: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9156: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9159: aload 31
    //   9161: aload_0
    //   9162: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9165: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9168: aload_0
    //   9169: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9172: ifnull +890 -> 10062
    //   9175: aload_0
    //   9176: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9179: ldc_w 880
    //   9182: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9185: ifeq +877 -> 10062
    //   9188: iconst_1
    //   9189: istore 21
    //   9191: aload 31
    //   9193: iload 21
    //   9195: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9198: aload 31
    //   9200: aload_2
    //   9201: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9204: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9207: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9210: aload_2
    //   9211: aload 31
    //   9213: invokevirtual 889	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9216: aload_0
    //   9217: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   9220: aload_0
    //   9221: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   9224: iconst_1
    //   9225: isub
    //   9226: if_icmpeq +13 -> 9239
    //   9229: aload_2
    //   9230: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9233: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9236: ifeq +11 -> 9247
    //   9239: aload_0
    //   9240: aload_1
    //   9241: aload_2
    //   9242: aload 31
    //   9244: invokevirtual 524	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9247: aload_0
    //   9248: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9251: ifeq +817 -> 10068
    //   9254: aload_0
    //   9255: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   9258: ifnull +10 -> 9268
    //   9261: aload_0
    //   9262: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   9265: invokevirtual 898	com/squareup/okhttp/Call:cancel	()V
    //   9268: aload_0
    //   9269: aconst_null
    //   9270: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   9273: aload 23
    //   9275: astore 22
    //   9277: iload 4
    //   9279: istore_3
    //   9280: goto -9005 -> 275
    //   9283: lload 9
    //   9285: lstore 11
    //   9287: aload 22
    //   9289: astore 24
    //   9291: lload 9
    //   9293: lstore 13
    //   9295: aload 22
    //   9297: astore 23
    //   9299: aload_2
    //   9300: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9303: iconst_3
    //   9304: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   9307: iconst_0
    //   9308: istore 5
    //   9310: goto -1345 -> 7965
    //   9313: ldc_w 705
    //   9316: astore 24
    //   9318: goto -1269 -> 8049
    //   9321: ldc_w 1038
    //   9324: astore 23
    //   9326: goto -1250 -> 8076
    //   9329: astore 22
    //   9331: ldc_w 509
    //   9334: astore 22
    //   9336: goto -1240 -> 8096
    //   9339: ldc_w 1040
    //   9342: astore 25
    //   9344: goto -1072 -> 8272
    //   9347: aconst_null
    //   9348: astore 24
    //   9350: goto -956 -> 8394
    //   9353: aload_0
    //   9354: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9357: astore 22
    //   9359: goto -721 -> 8638
    //   9362: iconst_0
    //   9363: istore_3
    //   9364: goto -696 -> 8668
    //   9367: aconst_null
    //   9368: astore 22
    //   9370: goto -554 -> 8816
    //   9373: new 80	java/lang/StringBuilder
    //   9376: dup
    //   9377: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   9380: ldc_w 1042
    //   9383: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9386: aload_0
    //   9387: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   9390: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9393: ldc_w 685
    //   9396: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9399: aload_0
    //   9400: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9403: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9406: ldc_w 687
    //   9409: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9412: astore 28
    //   9414: aload_0
    //   9415: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9418: ifeq +564 -> 9982
    //   9421: aload_0
    //   9422: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   9425: ifnull +557 -> 9982
    //   9428: aload_0
    //   9429: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   9432: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9435: ifnull +547 -> 9982
    //   9438: aload_0
    //   9439: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   9442: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9445: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   9448: astore 25
    //   9450: aload 28
    //   9452: aload 25
    //   9454: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9457: ldc_w 696
    //   9460: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9463: aload 26
    //   9465: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9468: ldc_w 701
    //   9471: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9474: aload 24
    //   9476: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9479: ldc_w 703
    //   9482: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9485: ldc_w 705
    //   9488: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9491: ldc_w 707
    //   9494: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9497: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9500: invokevirtual 341	java/lang/Thread:getId	()J
    //   9503: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9506: ldc_w 709
    //   9509: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9512: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9515: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9518: ldc_w 711
    //   9521: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9524: aload_0
    //   9525: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   9528: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9531: ldc_w 713
    //   9534: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9537: aload_0
    //   9538: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   9541: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9544: ldc_w 715
    //   9547: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9550: astore 25
    //   9552: aload_0
    //   9553: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   9556: ifeq +434 -> 9990
    //   9559: aload_0
    //   9560: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   9563: aload_0
    //   9564: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   9567: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9570: astore 24
    //   9572: aload 25
    //   9574: aload 24
    //   9576: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9579: ldc_w 719
    //   9582: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9585: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9588: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9591: ldc_w 728
    //   9594: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9597: aload_2
    //   9598: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9601: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9604: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9607: ldc_w 733
    //   9610: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9613: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   9616: aload_0
    //   9617: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   9620: lsub
    //   9621: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9624: ldc_w 735
    //   9627: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9630: aload_2
    //   9631: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9634: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9637: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9640: ldc_w 740
    //   9643: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9646: aload_2
    //   9647: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9650: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9653: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9656: ldc_w 744
    //   9659: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9662: aload_2
    //   9663: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9666: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9669: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9672: ldc_w 749
    //   9675: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9678: aload_0
    //   9679: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   9682: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9685: ldc 91
    //   9687: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9690: aload_0
    //   9691: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   9694: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9697: ldc_w 754
    //   9700: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9703: iload 4
    //   9705: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9708: ldc_w 1044
    //   9711: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9714: iload 5
    //   9716: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9719: ldc_w 726
    //   9722: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9725: aload_2
    //   9726: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9729: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9732: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9735: ldc_w 760
    //   9738: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9741: aload 27
    //   9743: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9746: ldc_w 762
    //   9749: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9752: aload 22
    //   9754: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9757: ldc_w 764
    //   9760: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9763: astore 24
    //   9765: aload_0
    //   9766: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9769: ifnull +227 -> 9996
    //   9772: aload_0
    //   9773: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9776: iconst_0
    //   9777: bipush 30
    //   9779: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   9782: astore 22
    //   9784: aload 24
    //   9786: aload 22
    //   9788: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9791: ldc_w 770
    //   9794: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9797: astore 22
    //   9799: aload_0
    //   9800: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9803: ifnull +202 -> 10005
    //   9806: aload_0
    //   9807: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9810: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9813: istore_3
    //   9814: aload 22
    //   9816: iload_3
    //   9817: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9820: ldc_w 772
    //   9823: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9826: aload_2
    //   9827: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9830: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9833: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9836: ldc_w 777
    //   9839: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9842: lload 9
    //   9844: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9847: ldc_w 779
    //   9850: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9853: aload_0
    //   9854: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   9857: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9860: ldc 91
    //   9862: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9865: aload_0
    //   9866: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   9869: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9872: ldc_w 781
    //   9875: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9878: aload_0
    //   9879: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   9882: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9885: ldc 91
    //   9887: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9890: aload_0
    //   9891: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   9894: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9897: ldc_w 783
    //   9900: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9903: aload_0
    //   9904: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   9907: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9910: ldc_w 785
    //   9913: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9916: aload_0
    //   9917: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   9920: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9923: ldc_w 790
    //   9926: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9929: aload_0
    //   9930: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   9933: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9936: ldc_w 795
    //   9939: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9942: astore 24
    //   9944: aload_0
    //   9945: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9948: ifnull +62 -> 10010
    //   9951: aload_0
    //   9952: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9955: invokeinterface 805 1 0
    //   9960: astore 22
    //   9962: ldc_w 613
    //   9965: aload 24
    //   9967: aload 22
    //   9969: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9972: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9975: aconst_null
    //   9976: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9979: goto -1146 -> 8833
    //   9982: ldc_w 1040
    //   9985: astore 25
    //   9987: goto -537 -> 9450
    //   9990: aconst_null
    //   9991: astore 24
    //   9993: goto -421 -> 9572
    //   9996: aload_0
    //   9997: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10000: astore 22
    //   10002: goto -218 -> 9784
    //   10005: iconst_0
    //   10006: istore_3
    //   10007: goto -193 -> 9814
    //   10010: aconst_null
    //   10011: astore 22
    //   10013: goto -51 -> 9962
    //   10016: astore 22
    //   10018: ldc 226
    //   10020: ldc_w 1047
    //   10023: aload 22
    //   10025: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10028: goto -1145 -> 8883
    //   10031: astore 22
    //   10033: ldc 226
    //   10035: ldc_w 1048
    //   10038: aload 22
    //   10040: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10043: goto -1110 -> 8933
    //   10046: aload 26
    //   10048: invokevirtual 1051	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10051: astore 22
    //   10053: goto -1073 -> 8980
    //   10056: aconst_null
    //   10057: astore 22
    //   10059: goto -1043 -> 9016
    //   10062: iconst_0
    //   10063: istore 21
    //   10065: goto -874 -> 9191
    //   10068: aload_0
    //   10069: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10072: ifnull -799 -> 9273
    //   10075: aload_0
    //   10076: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10079: invokevirtual 1056	org/apache/http/client/methods/HttpGet:abort	()V
    //   10082: goto -809 -> 9273
    //   10085: ldc_w 705
    //   10088: astore 25
    //   10090: goto -9602 -> 488
    //   10093: ldc_w 1038
    //   10096: astore 23
    //   10098: goto -9583 -> 515
    //   10101: astore 22
    //   10103: ldc_w 509
    //   10106: astore 22
    //   10108: goto -9573 -> 535
    //   10111: ldc_w 1040
    //   10114: astore 26
    //   10116: goto -9405 -> 711
    //   10119: aconst_null
    //   10120: astore 25
    //   10122: goto -9289 -> 833
    //   10125: aload_0
    //   10126: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10129: astore 22
    //   10131: goto -9054 -> 1077
    //   10134: iconst_0
    //   10135: istore_3
    //   10136: goto -9029 -> 1107
    //   10139: aconst_null
    //   10140: astore 22
    //   10142: goto -8887 -> 1255
    //   10145: new 80	java/lang/StringBuilder
    //   10148: dup
    //   10149: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   10152: ldc_w 1042
    //   10155: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10158: aload_0
    //   10159: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   10162: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10165: ldc_w 685
    //   10168: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10171: aload_0
    //   10172: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10175: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10178: ldc_w 687
    //   10181: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10184: astore 29
    //   10186: aload_0
    //   10187: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10190: ifeq +564 -> 10754
    //   10193: aload_0
    //   10194: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10197: ifnull +557 -> 10754
    //   10200: aload_0
    //   10201: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10204: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10207: ifnull +547 -> 10754
    //   10210: aload_0
    //   10211: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10214: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10217: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   10220: astore 26
    //   10222: aload 29
    //   10224: aload 26
    //   10226: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10229: ldc_w 696
    //   10232: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10235: aload 27
    //   10237: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10240: ldc_w 701
    //   10243: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10246: aload 25
    //   10248: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10251: ldc_w 703
    //   10254: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10257: ldc_w 705
    //   10260: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10263: ldc_w 707
    //   10266: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10269: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10272: invokevirtual 341	java/lang/Thread:getId	()J
    //   10275: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10278: ldc_w 709
    //   10281: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10284: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10287: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10290: ldc_w 711
    //   10293: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10296: aload_0
    //   10297: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   10300: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10303: ldc_w 713
    //   10306: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10309: aload_0
    //   10310: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   10313: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10316: ldc_w 715
    //   10319: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10322: astore 26
    //   10324: aload_0
    //   10325: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   10328: ifeq +434 -> 10762
    //   10331: aload_0
    //   10332: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   10335: aload_0
    //   10336: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   10339: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10342: astore 25
    //   10344: aload 26
    //   10346: aload 25
    //   10348: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10351: ldc_w 719
    //   10354: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10357: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10360: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10363: ldc_w 728
    //   10366: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10369: aload_2
    //   10370: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10373: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10376: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10379: ldc_w 733
    //   10382: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10385: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   10388: aload_0
    //   10389: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   10392: lsub
    //   10393: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10396: ldc_w 735
    //   10399: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10402: aload_2
    //   10403: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10406: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10409: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10412: ldc_w 740
    //   10415: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10418: aload_2
    //   10419: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10422: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10425: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10428: ldc_w 744
    //   10431: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10434: aload_2
    //   10435: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10438: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10441: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10444: ldc_w 749
    //   10447: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10450: aload_0
    //   10451: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   10454: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10457: ldc 91
    //   10459: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10462: aload_0
    //   10463: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   10466: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10469: ldc_w 754
    //   10472: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10475: iload 5
    //   10477: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10480: ldc_w 1044
    //   10483: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10486: iload 4
    //   10488: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10491: ldc_w 726
    //   10494: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10497: aload_2
    //   10498: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10501: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10504: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10507: ldc_w 760
    //   10510: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10513: aload 28
    //   10515: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10518: ldc_w 762
    //   10521: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10524: aload 22
    //   10526: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10529: ldc_w 764
    //   10532: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10535: astore 25
    //   10537: aload_0
    //   10538: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10541: ifnull +227 -> 10768
    //   10544: aload_0
    //   10545: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10548: iconst_0
    //   10549: bipush 30
    //   10551: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   10554: astore 22
    //   10556: aload 25
    //   10558: aload 22
    //   10560: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10563: ldc_w 770
    //   10566: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10569: astore 22
    //   10571: aload_0
    //   10572: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10575: ifnull +202 -> 10777
    //   10578: aload_0
    //   10579: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10582: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10585: istore_3
    //   10586: aload 22
    //   10588: iload_3
    //   10589: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10592: ldc_w 772
    //   10595: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10598: aload_2
    //   10599: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10602: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10605: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10608: ldc_w 777
    //   10611: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10614: lload 9
    //   10616: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10619: ldc_w 779
    //   10622: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10625: aload_0
    //   10626: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   10629: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10632: ldc 91
    //   10634: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10637: aload_0
    //   10638: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   10641: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10644: ldc_w 781
    //   10647: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10650: aload_0
    //   10651: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   10654: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10657: ldc 91
    //   10659: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10662: aload_0
    //   10663: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   10666: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10669: ldc_w 783
    //   10672: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10675: aload_0
    //   10676: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   10679: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10682: ldc_w 785
    //   10685: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10688: aload_0
    //   10689: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   10692: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10695: ldc_w 790
    //   10698: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10701: aload_0
    //   10702: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   10705: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10708: ldc_w 795
    //   10711: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10714: astore 25
    //   10716: aload_0
    //   10717: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10720: ifnull +62 -> 10782
    //   10723: aload_0
    //   10724: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10727: invokeinterface 805 1 0
    //   10732: astore 22
    //   10734: ldc_w 613
    //   10737: aload 25
    //   10739: aload 22
    //   10741: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10744: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10747: aconst_null
    //   10748: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10751: goto -9478 -> 1273
    //   10754: ldc_w 1040
    //   10757: astore 26
    //   10759: goto -537 -> 10222
    //   10762: aconst_null
    //   10763: astore 25
    //   10765: goto -421 -> 10344
    //   10768: aload_0
    //   10769: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10772: astore 22
    //   10774: goto -218 -> 10556
    //   10777: iconst_0
    //   10778: istore_3
    //   10779: goto -193 -> 10586
    //   10782: aconst_null
    //   10783: astore 22
    //   10785: goto -51 -> 10734
    //   10788: astore 22
    //   10790: ldc 226
    //   10792: ldc_w 1047
    //   10795: aload 22
    //   10797: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10800: goto -9477 -> 1323
    //   10803: astore 22
    //   10805: ldc 226
    //   10807: ldc_w 1048
    //   10810: aload 22
    //   10812: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10815: goto -9442 -> 1373
    //   10818: aload 27
    //   10820: invokevirtual 1051	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10823: astore 22
    //   10825: goto -9404 -> 1421
    //   10828: aconst_null
    //   10829: astore 22
    //   10831: goto -9374 -> 1457
    //   10834: iconst_0
    //   10835: istore 21
    //   10837: goto -9205 -> 1632
    //   10840: aload_0
    //   10841: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10844: ifnull -9130 -> 1714
    //   10847: aload_0
    //   10848: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10851: invokevirtual 1056	org/apache/http/client/methods/HttpGet:abort	()V
    //   10854: goto -9140 -> 1714
    //   10857: ldc_w 705
    //   10860: astore 25
    //   10862: goto -5959 -> 4903
    //   10865: goto -5939 -> 4926
    //   10868: astore 22
    //   10870: ldc_w 509
    //   10873: astore 22
    //   10875: goto -5929 -> 4946
    //   10878: ldc_w 1040
    //   10881: astore 26
    //   10883: goto -5761 -> 5122
    //   10886: aconst_null
    //   10887: astore 25
    //   10889: goto -5645 -> 5244
    //   10892: aload_0
    //   10893: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10896: astore 22
    //   10898: goto -5411 -> 5487
    //   10901: iconst_0
    //   10902: istore_3
    //   10903: goto -5386 -> 5517
    //   10906: aconst_null
    //   10907: astore 22
    //   10909: goto -5244 -> 5665
    //   10912: new 80	java/lang/StringBuilder
    //   10915: dup
    //   10916: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   10919: ldc_w 1042
    //   10922: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10925: aload_0
    //   10926: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   10929: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10932: ldc_w 685
    //   10935: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10938: aload_0
    //   10939: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10942: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10945: ldc_w 687
    //   10948: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10951: astore 29
    //   10953: aload_0
    //   10954: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10957: ifeq +563 -> 11520
    //   10960: aload_0
    //   10961: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10964: ifnull +556 -> 11520
    //   10967: aload_0
    //   10968: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10971: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10974: ifnull +546 -> 11520
    //   10977: aload_0
    //   10978: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10981: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10984: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   10987: astore 26
    //   10989: aload 29
    //   10991: aload 26
    //   10993: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10996: ldc_w 696
    //   10999: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11002: aload 27
    //   11004: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11007: ldc_w 701
    //   11010: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11013: aload 25
    //   11015: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11018: ldc_w 703
    //   11021: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11024: ldc_w 705
    //   11027: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11030: ldc_w 707
    //   11033: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11036: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11039: invokevirtual 341	java/lang/Thread:getId	()J
    //   11042: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11045: ldc_w 709
    //   11048: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11051: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11054: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11057: ldc_w 711
    //   11060: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11063: aload_0
    //   11064: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   11067: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11070: ldc_w 713
    //   11073: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11076: aload_0
    //   11077: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   11080: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11083: ldc_w 715
    //   11086: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11089: astore 26
    //   11091: aload_0
    //   11092: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   11095: ifeq +433 -> 11528
    //   11098: aload_0
    //   11099: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   11102: aload_0
    //   11103: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   11106: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   11109: astore 25
    //   11111: aload 26
    //   11113: aload 25
    //   11115: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11118: ldc_w 719
    //   11121: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11124: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   11127: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11130: ldc_w 728
    //   11133: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11136: aload_2
    //   11137: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11140: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11143: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11146: ldc_w 733
    //   11149: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11152: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   11155: aload_0
    //   11156: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   11159: lsub
    //   11160: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11163: ldc_w 735
    //   11166: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11169: aload_2
    //   11170: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11173: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11176: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11179: ldc_w 740
    //   11182: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11185: aload_2
    //   11186: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11189: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11192: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11195: ldc_w 744
    //   11198: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11201: aload_2
    //   11202: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11205: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   11208: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11211: ldc_w 749
    //   11214: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11217: aload_0
    //   11218: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   11221: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11224: ldc 91
    //   11226: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11229: aload_0
    //   11230: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   11233: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11236: ldc_w 754
    //   11239: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11242: iload_3
    //   11243: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11246: ldc_w 1044
    //   11249: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11252: iload 4
    //   11254: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11257: ldc_w 726
    //   11260: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11263: aload_2
    //   11264: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11267: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11270: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11273: ldc_w 760
    //   11276: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11279: aload 28
    //   11281: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11284: ldc_w 762
    //   11287: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11290: aload 22
    //   11292: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11295: ldc_w 764
    //   11298: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11301: astore 25
    //   11303: aload_0
    //   11304: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11307: ifnull +227 -> 11534
    //   11310: aload_0
    //   11311: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11314: iconst_0
    //   11315: bipush 30
    //   11317: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   11320: astore 22
    //   11322: aload 25
    //   11324: aload 22
    //   11326: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11329: ldc_w 770
    //   11332: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11335: astore 22
    //   11337: aload_0
    //   11338: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11341: ifnull +202 -> 11543
    //   11344: aload_0
    //   11345: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11348: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11351: istore_3
    //   11352: aload 22
    //   11354: iload_3
    //   11355: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11358: ldc_w 772
    //   11361: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11364: aload_2
    //   11365: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11368: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11371: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11374: ldc_w 777
    //   11377: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11380: lload 9
    //   11382: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11385: ldc_w 779
    //   11388: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11391: aload_0
    //   11392: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   11395: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11398: ldc 91
    //   11400: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11403: aload_0
    //   11404: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   11407: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11410: ldc_w 781
    //   11413: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11416: aload_0
    //   11417: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   11420: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11423: ldc 91
    //   11425: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11428: aload_0
    //   11429: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   11432: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11435: ldc_w 783
    //   11438: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11441: aload_0
    //   11442: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   11445: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11448: ldc_w 785
    //   11451: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11454: aload_0
    //   11455: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   11458: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11461: ldc_w 790
    //   11464: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11467: aload_0
    //   11468: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   11471: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11474: ldc_w 795
    //   11477: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11480: astore 25
    //   11482: aload_0
    //   11483: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11486: ifnull +62 -> 11548
    //   11489: aload_0
    //   11490: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11493: invokeinterface 805 1 0
    //   11498: astore 22
    //   11500: ldc_w 613
    //   11503: aload 25
    //   11505: aload 22
    //   11507: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11510: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11513: aconst_null
    //   11514: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11517: goto -5834 -> 5683
    //   11520: ldc_w 1040
    //   11523: astore 26
    //   11525: goto -536 -> 10989
    //   11528: aconst_null
    //   11529: astore 25
    //   11531: goto -420 -> 11111
    //   11534: aload_0
    //   11535: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11538: astore 22
    //   11540: goto -218 -> 11322
    //   11543: iconst_0
    //   11544: istore_3
    //   11545: goto -193 -> 11352
    //   11548: aconst_null
    //   11549: astore 22
    //   11551: goto -51 -> 11500
    //   11554: astore 22
    //   11556: ldc 226
    //   11558: ldc_w 1047
    //   11561: aload 22
    //   11563: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11566: goto -5833 -> 5733
    //   11569: astore 22
    //   11571: ldc 226
    //   11573: ldc_w 1048
    //   11576: aload 22
    //   11578: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11581: goto -5798 -> 5783
    //   11584: aload 27
    //   11586: invokevirtual 1051	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   11589: astore 22
    //   11591: goto -5760 -> 5831
    //   11594: aconst_null
    //   11595: astore 22
    //   11597: goto -5730 -> 5867
    //   11600: iconst_0
    //   11601: istore 21
    //   11603: goto -5561 -> 6042
    //   11606: aload_0
    //   11607: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11610: ifnull -5486 -> 6124
    //   11613: aload_0
    //   11614: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11617: invokevirtual 1056	org/apache/http/client/methods/HttpGet:abort	()V
    //   11620: goto -5496 -> 6124
    //   11623: astore 23
    //   11625: aconst_null
    //   11626: astore 24
    //   11628: iload 6
    //   11630: istore 4
    //   11632: goto -6812 -> 4820
    //   11635: astore 23
    //   11637: aconst_null
    //   11638: astore 24
    //   11640: goto -6820 -> 4820
    //   11643: astore 23
    //   11645: iload 5
    //   11647: istore_3
    //   11648: goto -6828 -> 4820
    //   11651: astore 24
    //   11653: iload 7
    //   11655: istore 4
    //   11657: goto -11324 -> 333
    //   11660: astore 24
    //   11662: goto -11329 -> 333
    //   11665: astore 22
    //   11667: goto -11376 -> 291
    //   11670: iconst_0
    //   11671: istore 4
    //   11673: goto -8520 -> 3153
    //   11676: goto -11641 -> 35
    //   11679: ldc_w 509
    //   11682: astore 22
    //   11684: goto -6738 -> 4946
    //   11687: ldc_w 509
    //   11690: astore 22
    //   11692: goto -11157 -> 535
    //   11695: ldc_w 509
    //   11698: astore 22
    //   11700: goto -3604 -> 8096
    //   11703: ldc_w 509
    //   11706: astore 22
    //   11708: goto -8369 -> 3339
    //   11711: iconst_1
    //   11712: istore 4
    //   11714: goto -9721 -> 1993
    //   11717: aload 30
    //   11719: astore 25
    //   11721: iload 5
    //   11723: iconst_2
    //   11724: if_icmpge -7156 -> 4568
    //   11727: aload 30
    //   11729: astore 25
    //   11731: iload 21
    //   11733: ifeq -7165 -> 4568
    //   11736: ldc_w 1017
    //   11739: astore 25
    //   11741: goto -7173 -> 4568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11744	0	this	StrictDownloadTask
    //   0	11744	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	11744	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   1	11647	3	i	int
    //   327	11386	4	j	int
    //   334	11391	5	k	int
    //   250	11379	6	m	int
    //   253	11401	7	n	int
    //   25	165	8	i1	int
    //   28	11353	9	l1	long
    //   298	8988	11	l2	long
    //   306	8988	13	l3	long
    //   33	60	15	l4	long
    //   176	7799	17	l5	long
    //   258	2632	19	l6	long
    //   268	11464	21	bool	boolean
    //   5	7045	22	localObject1	Object
    //   7081	1	22	localException1	java.lang.Exception
    //   7086	678	22	localObject2	Object
    //   7768	8	22	localException2	java.lang.Exception
    //   7783	8	22	localException3	java.lang.Exception
    //   7803	1493	22	localObject3	Object
    //   9329	1	22	localException4	java.lang.Exception
    //   9334	678	22	localObject4	Object
    //   10016	8	22	localException5	java.lang.Exception
    //   10031	8	22	localException6	java.lang.Exception
    //   10051	7	22	str1	String
    //   10101	1	22	localException7	java.lang.Exception
    //   10106	678	22	localObject5	Object
    //   10788	8	22	localException8	java.lang.Exception
    //   10803	8	22	localException9	java.lang.Exception
    //   10823	7	22	str2	String
    //   10868	1	22	localException10	java.lang.Exception
    //   10873	677	22	localObject6	Object
    //   11554	8	22	localException11	java.lang.Exception
    //   11569	8	22	localException12	java.lang.Exception
    //   11589	7	22	str3	String
    //   11665	1	22	localThrowable1	java.lang.Throwable
    //   11682	25	22	str4	String
    //   84	1	23	localException13	java.lang.Exception
    //   310	1	23	localObject7	Object
    //   315	15	23	localThrowable2	java.lang.Throwable
    //   513	9584	23	localObject8	Object
    //   11623	1	23	localObject9	Object
    //   11635	1	23	localObject10	Object
    //   11643	1	23	localObject11	Object
    //   302	11337	24	localObject12	Object
    //   11651	1	24	localThrowable3	java.lang.Throwable
    //   11660	1	24	localThrowable4	java.lang.Throwable
    //   486	4307	25	localObject13	Object
    //   4799	18	25	localObject14	Object
    //   4901	6839	25	localObject15	Object
    //   247	11277	26	localObject16	Object
    //   241	11344	27	localObject17	Object
    //   244	11036	28	localObject18	Object
    //   673	10317	29	localObject19	Object
    //   2198	9530	30	str5	String
    //   185	9058	31	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   1749	5224	32	localRequestOptions	com.tencent.component.network.utils.http.HttpUtil.RequestOptions
    // Exception table:
    //   from	to	target	type
    //   75	81	84	java/lang/Exception
    //   105	124	162	java/lang/Throwable
    //   124	161	162	java/lang/Throwable
    //   312	315	315	java/lang/Throwable
    //   1740	1751	315	java/lang/Throwable
    //   1767	1776	315	java/lang/Throwable
    //   1792	1801	315	java/lang/Throwable
    //   1817	1824	315	java/lang/Throwable
    //   1840	1851	315	java/lang/Throwable
    //   1867	1874	315	java/lang/Throwable
    //   1890	1896	315	java/lang/Throwable
    //   1912	1916	315	java/lang/Throwable
    //   1932	1944	315	java/lang/Throwable
    //   1960	1967	315	java/lang/Throwable
    //   1983	1990	315	java/lang/Throwable
    //   2009	2015	315	java/lang/Throwable
    //   2031	2039	315	java/lang/Throwable
    //   2055	2068	315	java/lang/Throwable
    //   2084	2091	315	java/lang/Throwable
    //   2107	2114	315	java/lang/Throwable
    //   2130	2140	315	java/lang/Throwable
    //   2156	2172	315	java/lang/Throwable
    //   2188	2200	315	java/lang/Throwable
    //   2216	2222	315	java/lang/Throwable
    //   2238	2247	315	java/lang/Throwable
    //   2278	2284	315	java/lang/Throwable
    //   2305	2317	315	java/lang/Throwable
    //   2337	2345	315	java/lang/Throwable
    //   2365	2393	315	java/lang/Throwable
    //   2413	2420	315	java/lang/Throwable
    //   2436	2453	315	java/lang/Throwable
    //   2473	2485	315	java/lang/Throwable
    //   2501	2507	315	java/lang/Throwable
    //   2523	2591	315	java/lang/Throwable
    //   2607	2614	315	java/lang/Throwable
    //   2630	2642	315	java/lang/Throwable
    //   2658	2670	315	java/lang/Throwable
    //   2686	2693	315	java/lang/Throwable
    //   2709	2732	315	java/lang/Throwable
    //   2748	2755	315	java/lang/Throwable
    //   2771	2796	315	java/lang/Throwable
    //   2812	2832	315	java/lang/Throwable
    //   2848	2870	315	java/lang/Throwable
    //   2886	2894	315	java/lang/Throwable
    //   2910	2917	315	java/lang/Throwable
    //   2933	2940	315	java/lang/Throwable
    //   2956	2963	315	java/lang/Throwable
    //   2979	2986	315	java/lang/Throwable
    //   3002	3007	315	java/lang/Throwable
    //   3040	3052	315	java/lang/Throwable
    //   3068	3075	315	java/lang/Throwable
    //   3091	3098	315	java/lang/Throwable
    //   3114	3121	315	java/lang/Throwable
    //   3137	3153	315	java/lang/Throwable
    //   4553	4565	315	java/lang/Throwable
    //   4584	4595	315	java/lang/Throwable
    //   4611	4617	315	java/lang/Throwable
    //   4638	4650	315	java/lang/Throwable
    //   4670	4678	315	java/lang/Throwable
    //   4698	4732	315	java/lang/Throwable
    //   4752	4759	315	java/lang/Throwable
    //   4775	4792	315	java/lang/Throwable
    //   6143	6155	315	java/lang/Throwable
    //   6178	6185	315	java/lang/Throwable
    //   6205	6221	315	java/lang/Throwable
    //   6237	6243	315	java/lang/Throwable
    //   6264	6276	315	java/lang/Throwable
    //   6296	6304	315	java/lang/Throwable
    //   6324	6352	315	java/lang/Throwable
    //   6372	6379	315	java/lang/Throwable
    //   6395	6412	315	java/lang/Throwable
    //   6435	6447	315	java/lang/Throwable
    //   6466	6479	315	java/lang/Throwable
    //   6505	6522	315	java/lang/Throwable
    //   6538	6544	315	java/lang/Throwable
    //   6565	6577	315	java/lang/Throwable
    //   6597	6605	315	java/lang/Throwable
    //   6625	6660	315	java/lang/Throwable
    //   6676	6683	315	java/lang/Throwable
    //   6699	6716	315	java/lang/Throwable
    //   6732	6744	315	java/lang/Throwable
    //   6760	6766	315	java/lang/Throwable
    //   6782	6839	315	java/lang/Throwable
    //   6858	6870	315	java/lang/Throwable
    //   6889	6914	315	java/lang/Throwable
    //   6937	6944	315	java/lang/Throwable
    //   6960	6980	315	java/lang/Throwable
    //   6996	7007	315	java/lang/Throwable
    //   7030	7037	315	java/lang/Throwable
    //   7053	7062	315	java/lang/Throwable
    //   9299	9307	315	java/lang/Throwable
    //   312	315	4799	finally
    //   1740	1751	4799	finally
    //   1767	1776	4799	finally
    //   1792	1801	4799	finally
    //   1817	1824	4799	finally
    //   1840	1851	4799	finally
    //   1867	1874	4799	finally
    //   1890	1896	4799	finally
    //   1912	1916	4799	finally
    //   1932	1944	4799	finally
    //   1960	1967	4799	finally
    //   1983	1990	4799	finally
    //   2009	2015	4799	finally
    //   2031	2039	4799	finally
    //   2055	2068	4799	finally
    //   2084	2091	4799	finally
    //   2107	2114	4799	finally
    //   2130	2140	4799	finally
    //   2156	2172	4799	finally
    //   2188	2200	4799	finally
    //   2216	2222	4799	finally
    //   2238	2247	4799	finally
    //   2278	2284	4799	finally
    //   2305	2317	4799	finally
    //   2337	2345	4799	finally
    //   2365	2393	4799	finally
    //   2413	2420	4799	finally
    //   2436	2453	4799	finally
    //   2473	2485	4799	finally
    //   2501	2507	4799	finally
    //   2523	2591	4799	finally
    //   2607	2614	4799	finally
    //   2630	2642	4799	finally
    //   2658	2670	4799	finally
    //   2686	2693	4799	finally
    //   2709	2732	4799	finally
    //   2748	2755	4799	finally
    //   2771	2796	4799	finally
    //   2812	2832	4799	finally
    //   2848	2870	4799	finally
    //   2886	2894	4799	finally
    //   2910	2917	4799	finally
    //   2933	2940	4799	finally
    //   2956	2963	4799	finally
    //   2979	2986	4799	finally
    //   3002	3007	4799	finally
    //   3040	3052	4799	finally
    //   3068	3075	4799	finally
    //   3091	3098	4799	finally
    //   3114	3121	4799	finally
    //   3137	3153	4799	finally
    //   4553	4565	4799	finally
    //   4584	4595	4799	finally
    //   4611	4617	4799	finally
    //   4638	4650	4799	finally
    //   4670	4678	4799	finally
    //   4698	4732	4799	finally
    //   4752	4759	4799	finally
    //   4775	4792	4799	finally
    //   6143	6155	4799	finally
    //   6178	6185	4799	finally
    //   6205	6221	4799	finally
    //   6237	6243	4799	finally
    //   6264	6276	4799	finally
    //   6296	6304	4799	finally
    //   6324	6352	4799	finally
    //   6372	6379	4799	finally
    //   6395	6412	4799	finally
    //   6435	6447	4799	finally
    //   6466	6479	4799	finally
    //   6505	6522	4799	finally
    //   6538	6544	4799	finally
    //   6565	6577	4799	finally
    //   6597	6605	4799	finally
    //   6625	6660	4799	finally
    //   6676	6683	4799	finally
    //   6699	6716	4799	finally
    //   6732	6744	4799	finally
    //   6760	6766	4799	finally
    //   6782	6839	4799	finally
    //   6858	6870	4799	finally
    //   6889	6914	4799	finally
    //   6937	6944	4799	finally
    //   6960	6980	4799	finally
    //   6996	7007	4799	finally
    //   7030	7037	4799	finally
    //   7053	7062	4799	finally
    //   9299	9307	4799	finally
    //   3324	3339	7081	java/lang/Exception
    //   4099	4126	7768	java/lang/Exception
    //   4149	4176	7783	java/lang/Exception
    //   8081	8096	9329	java/lang/Exception
    //   8856	8883	10016	java/lang/Exception
    //   8906	8933	10031	java/lang/Exception
    //   520	535	10101	java/lang/Exception
    //   1296	1323	10788	java/lang/Exception
    //   1346	1373	10803	java/lang/Exception
    //   4931	4946	10868	java/lang/Exception
    //   5706	5733	11554	java/lang/Exception
    //   5756	5783	11569	java/lang/Exception
    //   3007	3024	11623	finally
    //   3153	3162	11635	finally
    //   3182	3208	11635	finally
    //   7837	7877	11635	finally
    //   7885	7899	11635	finally
    //   7923	7928	11635	finally
    //   7928	7936	11635	finally
    //   7940	7961	11635	finally
    //   336	345	11643	finally
    //   351	358	11643	finally
    //   364	377	11643	finally
    //   380	385	11643	finally
    //   394	403	11643	finally
    //   3007	3024	11651	java/lang/Throwable
    //   3153	3162	11660	java/lang/Throwable
    //   3182	3208	11660	java/lang/Throwable
    //   7837	7877	11660	java/lang/Throwable
    //   7885	7899	11660	java/lang/Throwable
    //   7923	7928	11660	java/lang/Throwable
    //   7928	7936	11660	java/lang/Throwable
    //   7940	7961	11660	java/lang/Throwable
    //   260	270	11665	java/lang/Throwable
  }
  
  protected void initTask()
  {
    super.initTask();
    this.mDomainWithPort = Utils.getDominWithPort(getUrl());
    this.mOrigPort = Utils.getPort(getUrl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.StrictDownloadTask
 * JD-Core Version:    0.7.0.1
 */