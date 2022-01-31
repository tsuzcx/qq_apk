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
    //   279: ifne +11414 -> 11693
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
    //   463: ifnull +9639 -> 10102
    //   466: aload_0
    //   467: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   470: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   473: ifnull +9629 -> 10102
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
    //   508: ifnull +9602 -> 10110
    //   511: aload 25
    //   513: astore 23
    //   515: aload 22
    //   517: ifnull +11187 -> 11704
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
    //   631: ifne +9531 -> 10162
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
    //   679: ifeq +9449 -> 10128
    //   682: aload_0
    //   683: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   686: ifnull +9442 -> 10128
    //   689: aload_0
    //   690: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   693: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   696: ifnull +9432 -> 10128
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
    //   817: ifeq +9319 -> 10136
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
    //   1062: ifnull +9080 -> 10142
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
    //   1096: ifnull +9055 -> 10151
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
    //   1241: ifnull +8915 -> 10156
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
    //   1415: ifnonnull +9420 -> 10835
    //   1418: aconst_null
    //   1419: astore 22
    //   1421: aload 31
    //   1423: aload 22
    //   1425: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1428: aload_0
    //   1429: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1432: ifnull +9413 -> 10845
    //   1435: aload_0
    //   1436: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1439: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1442: ifnull +9403 -> 10845
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
    //   1613: ifnull +9238 -> 10851
    //   1616: aload_0
    //   1617: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1620: ldc_w 880
    //   1623: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1626: ifeq +9225 -> 10851
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
    //   1692: ifeq +9165 -> 10857
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
    //   1821: ifnull +2721 -> 4542
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
    //   1964: if_icmpeq +9764 -> 11728
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
    //   1987: if_icmpne +2561 -> 4548
    //   1990: goto +9738 -> 11728
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
    //   2036: ifnonnull +4431 -> 6467
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
    //   2088: ifeq +4379 -> 6467
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
    //   2111: ifnull +4356 -> 6467
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
    //   2137: ifnull +4330 -> 6467
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
    //   2169: ifne +4298 -> 6467
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
    //   2249: ifne +9485 -> 11734
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
    //   2286: ifle +2268 -> 4554
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
    //   2690: ifeq +4200 -> 6890
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
    //   2911: lconst_0
    //   2912: putfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   2915: lload 9
    //   2917: lstore 11
    //   2919: aload 26
    //   2921: astore 24
    //   2923: lload 9
    //   2925: lstore 13
    //   2927: aload 28
    //   2929: astore 23
    //   2931: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   2934: lstore 19
    //   2936: lload 9
    //   2938: lstore 11
    //   2940: aload 26
    //   2942: astore 24
    //   2944: lload 9
    //   2946: lstore 13
    //   2948: aload 28
    //   2950: astore 23
    //   2952: aload_0
    //   2953: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2956: ifnull +3978 -> 6934
    //   2959: lload 9
    //   2961: lstore 11
    //   2963: aload 26
    //   2965: astore 24
    //   2967: lload 9
    //   2969: lstore 13
    //   2971: aload 28
    //   2973: astore 23
    //   2975: aload_0
    //   2976: getfield 982	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2979: ifnonnull +26 -> 3005
    //   2982: lload 9
    //   2984: lstore 11
    //   2986: aload 26
    //   2988: astore 24
    //   2990: lload 9
    //   2992: lstore 13
    //   2994: aload 28
    //   2996: astore 23
    //   2998: aload_0
    //   2999: invokestatic 986	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   3002: putfield 982	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   3005: lload 9
    //   3007: lstore 11
    //   3009: aload 26
    //   3011: astore 24
    //   3013: lload 9
    //   3015: lstore 13
    //   3017: aload 28
    //   3019: astore 23
    //   3021: invokestatic 990	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   3024: astore 22
    //   3026: aload_0
    //   3027: aload_0
    //   3028: getfield 982	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   3031: aload_0
    //   3032: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3035: aload 22
    //   3037: invokevirtual 995	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   3040: putfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3043: lload 9
    //   3045: lstore 11
    //   3047: aload 22
    //   3049: astore 24
    //   3051: lload 9
    //   3053: lstore 13
    //   3055: aload 22
    //   3057: astore 23
    //   3059: aload_0
    //   3060: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3063: lload 19
    //   3065: lsub
    //   3066: putfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   3069: lload 9
    //   3071: lstore 11
    //   3073: aload 22
    //   3075: astore 24
    //   3077: lload 9
    //   3079: lstore 13
    //   3081: aload 22
    //   3083: astore 23
    //   3085: aload_0
    //   3086: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3089: ifnonnull +26 -> 3115
    //   3092: lload 9
    //   3094: lstore 11
    //   3096: aload 22
    //   3098: astore 24
    //   3100: lload 9
    //   3102: lstore 13
    //   3104: aload 22
    //   3106: astore 23
    //   3108: aload_0
    //   3109: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3112: ifnull +6188 -> 9300
    //   3115: lload 9
    //   3117: lstore 11
    //   3119: aload 22
    //   3121: astore 24
    //   3123: lload 9
    //   3125: lstore 13
    //   3127: aload 22
    //   3129: astore 23
    //   3131: aload_0
    //   3132: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3135: ifnull +3896 -> 7031
    //   3138: lload 9
    //   3140: lstore 11
    //   3142: aload 22
    //   3144: astore 24
    //   3146: lload 9
    //   3148: lstore 13
    //   3150: aload 22
    //   3152: astore 23
    //   3154: aload_0
    //   3155: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3158: invokeinterface 212 1 0
    //   3163: invokeinterface 1000 1 0
    //   3168: istore 4
    //   3170: aload_2
    //   3171: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3174: iload 4
    //   3176: putfield 549	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   3179: sipush 200
    //   3182: iload 4
    //   3184: if_icmpeq +11 -> 3195
    //   3187: sipush 206
    //   3190: iload 4
    //   3192: if_icmpne +4662 -> 7854
    //   3195: iload 4
    //   3197: istore 5
    //   3199: aload_0
    //   3200: aload_0
    //   3201: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3204: aload_0
    //   3205: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3208: aload_2
    //   3209: aload_1
    //   3210: iload 4
    //   3212: invokevirtual 1004	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   3215: ifeq +4767 -> 7982
    //   3218: aload_2
    //   3219: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3222: invokevirtual 1007	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   3225: iload_3
    //   3226: iconst_1
    //   3227: iadd
    //   3228: istore 5
    //   3230: aload_2
    //   3231: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3234: lload 17
    //   3236: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3239: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3242: aload_2
    //   3243: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3246: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3249: aload_0
    //   3250: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   3253: lsub
    //   3254: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3257: aload_2
    //   3258: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3261: aload_0
    //   3262: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   3265: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3268: aload_0
    //   3269: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3272: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3275: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3278: astore 26
    //   3280: aload_0
    //   3281: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3284: ifnull +3798 -> 7082
    //   3287: aload_0
    //   3288: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3291: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3294: ifnull +3788 -> 7082
    //   3297: aload_0
    //   3298: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3301: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3304: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   3307: astore 24
    //   3309: aload_0
    //   3310: aload_0
    //   3311: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3314: aload_0
    //   3315: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3318: aload_0
    //   3319: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3322: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   3325: astore 27
    //   3327: aload 24
    //   3329: ifnull +3761 -> 7090
    //   3332: aload 24
    //   3334: astore 23
    //   3336: aload 22
    //   3338: ifnull +8382 -> 11720
    //   3341: aload 22
    //   3343: ldc_w 656
    //   3346: invokeinterface 662 2 0
    //   3351: checkcast 449	java/lang/String
    //   3354: astore 22
    //   3356: aload_2
    //   3357: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3360: aload 22
    //   3362: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3365: aload_2
    //   3366: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3369: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3372: ifne +64 -> 3436
    //   3375: aload_0
    //   3376: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3379: ifnull +28 -> 3407
    //   3382: aload_0
    //   3383: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3386: aload_0
    //   3387: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   3390: aload_2
    //   3391: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3394: aload_0
    //   3395: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   3398: aload_0
    //   3399: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3402: invokeinterface 681 5 0
    //   3407: aload_0
    //   3408: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3411: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3414: ifne +22 -> 3436
    //   3417: aload_0
    //   3418: aload_0
    //   3419: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3422: iconst_1
    //   3423: isub
    //   3424: putfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3427: aload_2
    //   3428: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3431: bipush 6
    //   3433: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3436: aload_1
    //   3437: invokeinterface 520 1 0
    //   3442: ifne +1065 -> 4507
    //   3445: aload_2
    //   3446: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3449: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3452: ifne +3690 -> 7142
    //   3455: new 80	java/lang/StringBuilder
    //   3458: dup
    //   3459: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   3462: ldc_w 683
    //   3465: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3468: aload_0
    //   3469: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   3472: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3475: ldc_w 685
    //   3478: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3481: aload_0
    //   3482: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   3485: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3488: ldc_w 687
    //   3491: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3494: astore 28
    //   3496: aload_0
    //   3497: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   3500: ifeq +3608 -> 7108
    //   3503: aload_0
    //   3504: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3507: ifnull +3601 -> 7108
    //   3510: aload_0
    //   3511: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3514: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3517: ifnull +3591 -> 7108
    //   3520: aload_0
    //   3521: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   3524: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3527: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   3530: astore 25
    //   3532: aload 28
    //   3534: aload 25
    //   3536: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3539: ldc_w 696
    //   3542: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3545: aload 26
    //   3547: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3550: ldc_w 701
    //   3553: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3556: aload 24
    //   3558: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3561: ldc_w 703
    //   3564: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: ldc_w 705
    //   3570: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3573: ldc_w 707
    //   3576: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3582: invokevirtual 341	java/lang/Thread:getId	()J
    //   3585: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3588: ldc_w 709
    //   3591: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3594: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3597: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3600: ldc_w 711
    //   3603: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3606: aload_0
    //   3607: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   3610: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3613: ldc_w 713
    //   3616: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3619: aload_0
    //   3620: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   3623: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3626: ldc_w 715
    //   3629: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3632: astore 25
    //   3634: aload_0
    //   3635: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   3638: ifeq +3478 -> 7116
    //   3641: aload_0
    //   3642: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3645: aload_0
    //   3646: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   3649: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3652: astore 24
    //   3654: aload 25
    //   3656: aload 24
    //   3658: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3661: ldc_w 717
    //   3664: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3667: aload_0
    //   3668: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3671: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3674: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3677: ldc_w 719
    //   3680: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3683: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3686: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3689: ldc_w 726
    //   3692: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3695: aload_2
    //   3696: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3699: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3702: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3705: ldc_w 728
    //   3708: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3711: aload_2
    //   3712: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3715: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3718: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3721: ldc_w 733
    //   3724: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3730: aload_0
    //   3731: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   3734: lsub
    //   3735: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3738: ldc_w 735
    //   3741: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3744: aload_2
    //   3745: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3748: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3751: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3754: ldc_w 740
    //   3757: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3760: aload_2
    //   3761: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3764: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3767: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3770: ldc_w 744
    //   3773: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3776: aload_2
    //   3777: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3780: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3783: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3786: ldc_w 749
    //   3789: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3792: aload_0
    //   3793: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3796: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3799: ldc 91
    //   3801: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3804: aload_0
    //   3805: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   3808: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3811: ldc_w 754
    //   3814: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3817: iload 5
    //   3819: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3822: ldc_w 756
    //   3825: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3828: aload_2
    //   3829: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3832: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3835: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3838: ldc_w 758
    //   3841: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3844: iload 4
    //   3846: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3849: ldc_w 760
    //   3852: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3855: aload 27
    //   3857: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3860: ldc_w 762
    //   3863: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3866: aload 22
    //   3868: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3871: ldc_w 764
    //   3874: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: astore 24
    //   3879: aload_0
    //   3880: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   3883: ifnull +3239 -> 7122
    //   3886: aload_0
    //   3887: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   3890: iconst_0
    //   3891: bipush 30
    //   3893: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   3896: astore 22
    //   3898: aload 24
    //   3900: aload 22
    //   3902: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3905: ldc_w 770
    //   3908: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3911: astore 22
    //   3913: aload_0
    //   3914: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3917: ifnull +3214 -> 7131
    //   3920: aload_0
    //   3921: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3924: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3927: istore_3
    //   3928: aload 22
    //   3930: iload_3
    //   3931: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3934: ldc_w 772
    //   3937: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3940: aload_2
    //   3941: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3944: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3947: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3950: ldc_w 777
    //   3953: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3956: lload 9
    //   3958: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3961: ldc_w 779
    //   3964: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3967: aload_0
    //   3968: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   3971: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3974: ldc 91
    //   3976: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3979: aload_0
    //   3980: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   3983: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3986: ldc_w 781
    //   3989: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3992: aload_0
    //   3993: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   3996: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3999: ldc 91
    //   4001: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4004: aload_0
    //   4005: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   4008: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4011: ldc_w 783
    //   4014: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4017: aload_0
    //   4018: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   4021: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4024: ldc_w 785
    //   4027: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4030: aload_0
    //   4031: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   4034: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4037: ldc_w 790
    //   4040: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4043: aload_0
    //   4044: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   4047: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4050: ldc_w 795
    //   4053: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4056: astore 24
    //   4058: aload_0
    //   4059: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4062: ifnull +3074 -> 7136
    //   4065: aload_0
    //   4066: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4069: invokeinterface 805 1 0
    //   4074: astore 22
    //   4076: ldc_w 613
    //   4079: aload 24
    //   4081: aload 22
    //   4083: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4086: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4089: aconst_null
    //   4090: invokestatic 567	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4093: getstatic 368	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4096: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4099: aload_0
    //   4100: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4103: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4106: if_icmpne +37 -> 4143
    //   4109: aload_0
    //   4110: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4113: ifnull +30 -> 4143
    //   4116: aload_0
    //   4117: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4120: aload_0
    //   4121: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4124: aload_0
    //   4125: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4128: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4131: aload_2
    //   4132: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4135: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4138: invokeinterface 812 4 0
    //   4143: getstatic 479	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4146: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4149: aload_0
    //   4150: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4153: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4156: if_icmpne +37 -> 4193
    //   4159: aload_0
    //   4160: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4163: ifnull +30 -> 4193
    //   4166: aload_0
    //   4167: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4170: aload_0
    //   4171: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4174: aload_0
    //   4175: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4178: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4181: aload_2
    //   4182: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4185: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4188: invokeinterface 812 4 0
    //   4193: aload 31
    //   4195: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   4198: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4201: aload 31
    //   4203: aload_0
    //   4204: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   4207: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4210: aload 31
    //   4212: aload_0
    //   4213: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   4216: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4219: aload 31
    //   4221: iload 4
    //   4223: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4226: aload 31
    //   4228: aconst_null
    //   4229: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4232: aload 26
    //   4234: ifnonnull +3581 -> 7815
    //   4237: aconst_null
    //   4238: astore 22
    //   4240: aload 31
    //   4242: aload 22
    //   4244: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4247: aload_0
    //   4248: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4251: ifnull +3574 -> 7825
    //   4254: aload_0
    //   4255: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4258: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4261: ifnull +3564 -> 7825
    //   4264: aload_0
    //   4265: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4268: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4271: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   4274: astore 22
    //   4276: aload 31
    //   4278: aload 22
    //   4280: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   4283: aload 31
    //   4285: ldc_w 705
    //   4288: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4291: aload 31
    //   4293: aload_2
    //   4294: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4297: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4300: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4303: aload 31
    //   4305: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4308: aload_0
    //   4309: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   4312: lsub
    //   4313: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4316: aload 31
    //   4318: aload_2
    //   4319: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4322: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4325: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4328: aload 31
    //   4330: aload 31
    //   4332: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4335: aload_2
    //   4336: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4339: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4342: lsub
    //   4343: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4346: aload 31
    //   4348: lload 9
    //   4350: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4353: aload 31
    //   4355: aload_0
    //   4356: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   4359: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4362: aload 31
    //   4364: aload_0
    //   4365: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   4368: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4371: aload 31
    //   4373: aload_0
    //   4374: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   4377: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4380: aload 31
    //   4382: lconst_0
    //   4383: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4386: aload 31
    //   4388: aload_0
    //   4389: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   4392: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4395: aload 31
    //   4397: aload_2
    //   4398: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4401: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4404: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4407: aload 31
    //   4409: aload_0
    //   4410: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4413: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4416: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4419: aload 31
    //   4421: aload_0
    //   4422: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   4425: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4428: aload_0
    //   4429: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4432: ifnull +3399 -> 7831
    //   4435: aload_0
    //   4436: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4439: ldc_w 880
    //   4442: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4445: ifeq +3386 -> 7831
    //   4448: iconst_1
    //   4449: istore 21
    //   4451: aload 31
    //   4453: iload 21
    //   4455: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4458: aload 31
    //   4460: aload_2
    //   4461: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4464: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4467: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4470: aload_2
    //   4471: aload 31
    //   4473: invokevirtual 889	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4476: aload_0
    //   4477: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   4480: aload_0
    //   4481: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   4484: iconst_1
    //   4485: isub
    //   4486: if_icmpeq +13 -> 4499
    //   4489: aload_2
    //   4490: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4493: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4496: ifeq +11 -> 4507
    //   4499: aload_0
    //   4500: aload_1
    //   4501: aload_2
    //   4502: aload 31
    //   4504: invokevirtual 524	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4507: aload_0
    //   4508: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   4511: ifeq +3326 -> 7837
    //   4514: aload_0
    //   4515: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   4518: ifnull +10 -> 4528
    //   4521: aload_0
    //   4522: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   4525: invokevirtual 898	com/squareup/okhttp/Call:cancel	()V
    //   4528: aload_0
    //   4529: aconst_null
    //   4530: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   4533: aload 23
    //   4535: astore_1
    //   4536: iload 5
    //   4538: istore_3
    //   4539: goto -4434 -> 105
    //   4542: aconst_null
    //   4543: astore 22
    //   4545: goto -2694 -> 1851
    //   4548: iconst_0
    //   4549: istore 4
    //   4551: goto -2558 -> 1993
    //   4554: lload 9
    //   4556: lstore 11
    //   4558: aload 26
    //   4560: astore 24
    //   4562: lload 9
    //   4564: lstore 13
    //   4566: aload 28
    //   4568: astore 23
    //   4570: aload_0
    //   4571: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4574: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4577: getfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4580: istore 4
    //   4582: goto -2265 -> 2317
    //   4585: lload 9
    //   4587: lstore 11
    //   4589: aload 26
    //   4591: astore 24
    //   4593: lload 9
    //   4595: lstore 13
    //   4597: aload 28
    //   4599: astore 23
    //   4601: aload 25
    //   4603: bipush 58
    //   4605: invokestatic 934	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   4608: iconst_2
    //   4609: if_icmplt +1566 -> 6175
    //   4612: lload 9
    //   4614: lstore 11
    //   4616: aload 26
    //   4618: astore 24
    //   4620: lload 9
    //   4622: lstore 13
    //   4624: aload 28
    //   4626: astore 23
    //   4628: aload_0
    //   4629: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   4632: istore 4
    //   4634: iload 4
    //   4636: ifle +1508 -> 6144
    //   4639: lload 9
    //   4641: lstore 11
    //   4643: aload 26
    //   4645: astore 24
    //   4647: lload 9
    //   4649: lstore 13
    //   4651: aload 28
    //   4653: astore 23
    //   4655: aload_0
    //   4656: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4659: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4662: iload 4
    //   4664: putfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4667: lload 9
    //   4669: lstore 11
    //   4671: aload 26
    //   4673: astore 24
    //   4675: iload 4
    //   4677: istore 5
    //   4679: lload 9
    //   4681: lstore 13
    //   4683: aload 28
    //   4685: astore 23
    //   4687: iload 4
    //   4689: invokestatic 365	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   4692: ifne +7 -> 4699
    //   4695: bipush 80
    //   4697: istore 5
    //   4699: lload 9
    //   4701: lstore 11
    //   4703: aload 26
    //   4705: astore 24
    //   4707: lload 9
    //   4709: lstore 13
    //   4711: aload 28
    //   4713: astore 23
    //   4715: new 80	java/lang/StringBuilder
    //   4718: dup
    //   4719: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   4722: ldc_w 1009
    //   4725: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4728: aload 25
    //   4730: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4733: ldc_w 1011
    //   4736: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4739: iload 5
    //   4741: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4744: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4747: astore 25
    //   4749: lload 9
    //   4751: lstore 11
    //   4753: aload 26
    //   4755: astore 24
    //   4757: aload 25
    //   4759: astore 22
    //   4761: lload 9
    //   4763: lstore 13
    //   4765: aload 28
    //   4767: astore 23
    //   4769: aload_0
    //   4770: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4773: ifnull -2316 -> 2457
    //   4776: lload 9
    //   4778: lstore 11
    //   4780: aload 26
    //   4782: astore 24
    //   4784: lload 9
    //   4786: lstore 13
    //   4788: aload 28
    //   4790: astore 23
    //   4792: aload_0
    //   4793: aload_0
    //   4794: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4797: aload_0
    //   4798: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4801: aload 25
    //   4803: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4806: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4809: aload 25
    //   4811: astore 22
    //   4813: goto -2356 -> 2457
    //   4816: astore 25
    //   4818: lload 13
    //   4820: lstore 9
    //   4822: aconst_null
    //   4823: astore 24
    //   4825: aload 23
    //   4827: astore 22
    //   4829: iload 6
    //   4831: istore 4
    //   4833: aload 25
    //   4835: astore 23
    //   4837: iload_3
    //   4838: iconst_1
    //   4839: iadd
    //   4840: istore_3
    //   4841: aload_2
    //   4842: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4845: lload 17
    //   4847: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4850: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4853: aload_2
    //   4854: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4857: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4860: aload_0
    //   4861: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   4864: lsub
    //   4865: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4868: aload_2
    //   4869: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4872: aload_0
    //   4873: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   4876: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4879: aload_0
    //   4880: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   4883: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4886: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4889: astore 27
    //   4891: aload_0
    //   4892: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4895: ifnull +5979 -> 10874
    //   4898: aload_0
    //   4899: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4902: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4905: ifnull +5969 -> 10874
    //   4908: aload_0
    //   4909: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4912: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4915: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   4918: astore 25
    //   4920: aload_0
    //   4921: aload_0
    //   4922: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   4925: aload_0
    //   4926: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   4929: aload_0
    //   4930: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   4933: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   4936: astore 28
    //   4938: aload 25
    //   4940: ifnull +5942 -> 10882
    //   4943: aload 22
    //   4945: ifnull +6751 -> 11696
    //   4948: aload 22
    //   4950: ldc_w 656
    //   4953: invokeinterface 662 2 0
    //   4958: checkcast 449	java/lang/String
    //   4961: astore 22
    //   4963: aload_2
    //   4964: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4967: aload 22
    //   4969: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   4972: aload_2
    //   4973: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4976: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4979: ifne +64 -> 5043
    //   4982: aload_0
    //   4983: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4986: ifnull +28 -> 5014
    //   4989: aload_0
    //   4990: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4993: aload_0
    //   4994: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   4997: aload_2
    //   4998: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   5001: aload_0
    //   5002: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   5005: aload_0
    //   5006: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   5009: invokeinterface 681 5 0
    //   5014: aload_0
    //   5015: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5018: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5021: ifne +22 -> 5043
    //   5024: aload_0
    //   5025: aload_0
    //   5026: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5029: iconst_1
    //   5030: isub
    //   5031: putfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5034: aload_2
    //   5035: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5038: bipush 6
    //   5040: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   5043: aload_1
    //   5044: invokeinterface 520 1 0
    //   5049: ifne +1066 -> 6115
    //   5052: aload_2
    //   5053: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5056: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5059: ifne +5870 -> 10929
    //   5062: new 80	java/lang/StringBuilder
    //   5065: dup
    //   5066: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   5069: ldc_w 683
    //   5072: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5075: aload_0
    //   5076: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   5079: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5082: ldc_w 685
    //   5085: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5088: aload_0
    //   5089: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   5092: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5095: ldc_w 687
    //   5098: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5101: astore 29
    //   5103: aload_0
    //   5104: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   5107: ifeq +5788 -> 10895
    //   5110: aload_0
    //   5111: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   5114: ifnull +5781 -> 10895
    //   5117: aload_0
    //   5118: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   5121: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5124: ifnull +5771 -> 10895
    //   5127: aload_0
    //   5128: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   5131: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5134: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   5137: astore 26
    //   5139: aload 29
    //   5141: aload 26
    //   5143: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5146: ldc_w 696
    //   5149: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5152: aload 27
    //   5154: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5157: ldc_w 701
    //   5160: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5163: aload 25
    //   5165: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5168: ldc_w 703
    //   5171: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5174: ldc_w 705
    //   5177: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5180: ldc_w 707
    //   5183: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5186: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5189: invokevirtual 341	java/lang/Thread:getId	()J
    //   5192: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5195: ldc_w 709
    //   5198: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5201: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5204: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5207: ldc_w 711
    //   5210: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5213: aload_0
    //   5214: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   5217: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5220: ldc_w 713
    //   5223: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5226: aload_0
    //   5227: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   5230: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5233: ldc_w 715
    //   5236: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5239: astore 26
    //   5241: aload_0
    //   5242: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   5245: ifeq +5658 -> 10903
    //   5248: aload_0
    //   5249: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5252: aload_0
    //   5253: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   5256: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5259: astore 25
    //   5261: aload 26
    //   5263: aload 25
    //   5265: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5268: ldc_w 717
    //   5271: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5274: aload_0
    //   5275: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5278: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5281: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5284: ldc_w 719
    //   5287: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5290: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5293: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5296: ldc_w 726
    //   5299: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5302: aload_2
    //   5303: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5306: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5309: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5312: ldc_w 728
    //   5315: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5318: aload_2
    //   5319: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5322: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5325: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5328: ldc_w 733
    //   5331: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5334: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   5337: aload_0
    //   5338: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   5341: lsub
    //   5342: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5345: ldc_w 735
    //   5348: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5351: aload_2
    //   5352: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5355: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5358: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5361: ldc_w 740
    //   5364: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5367: aload_2
    //   5368: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5371: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5374: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5377: ldc_w 744
    //   5380: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5383: aload_2
    //   5384: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5387: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5390: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5393: ldc_w 749
    //   5396: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5399: aload_0
    //   5400: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5403: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5406: ldc 91
    //   5408: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5411: aload_0
    //   5412: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   5415: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5418: ldc_w 754
    //   5421: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5424: iload_3
    //   5425: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5428: ldc_w 756
    //   5431: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5434: aload_2
    //   5435: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5438: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5441: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5444: ldc_w 758
    //   5447: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5450: iload 4
    //   5452: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5455: ldc_w 760
    //   5458: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5461: aload 28
    //   5463: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5466: ldc_w 762
    //   5469: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5472: aload 22
    //   5474: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5477: ldc_w 764
    //   5480: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5483: astore 25
    //   5485: aload_0
    //   5486: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5489: ifnull +5420 -> 10909
    //   5492: aload_0
    //   5493: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5496: iconst_0
    //   5497: bipush 30
    //   5499: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   5502: astore 22
    //   5504: aload 25
    //   5506: aload 22
    //   5508: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5511: ldc_w 770
    //   5514: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5517: astore 22
    //   5519: aload_0
    //   5520: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5523: ifnull +5395 -> 10918
    //   5526: aload_0
    //   5527: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5530: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5533: istore_3
    //   5534: aload 22
    //   5536: iload_3
    //   5537: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5540: ldc_w 772
    //   5543: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5546: aload_2
    //   5547: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5550: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5553: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5556: ldc_w 777
    //   5559: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5562: lload 9
    //   5564: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5567: ldc_w 779
    //   5570: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5573: aload_0
    //   5574: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   5577: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5580: ldc 91
    //   5582: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5585: aload_0
    //   5586: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   5589: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5592: ldc_w 781
    //   5595: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5598: aload_0
    //   5599: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   5602: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5605: ldc 91
    //   5607: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5610: aload_0
    //   5611: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   5614: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5617: ldc_w 783
    //   5620: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5623: aload_0
    //   5624: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   5627: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5630: ldc_w 785
    //   5633: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5636: aload_0
    //   5637: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   5640: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5643: ldc_w 790
    //   5646: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5649: aload_0
    //   5650: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   5653: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5656: ldc_w 795
    //   5659: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5662: astore 25
    //   5664: aload_0
    //   5665: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5668: ifnull +5255 -> 10923
    //   5671: aload_0
    //   5672: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5675: invokeinterface 805 1 0
    //   5680: astore 22
    //   5682: ldc_w 613
    //   5685: aload 25
    //   5687: aload 22
    //   5689: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5692: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5695: aload 24
    //   5697: invokestatic 567	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5700: getstatic 368	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5703: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5706: aload_0
    //   5707: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5710: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5713: if_icmpne +37 -> 5750
    //   5716: aload_0
    //   5717: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5720: ifnull +30 -> 5750
    //   5723: aload_0
    //   5724: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5727: aload_0
    //   5728: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   5731: aload_0
    //   5732: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5735: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5738: aload_2
    //   5739: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5742: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5745: invokeinterface 812 4 0
    //   5750: getstatic 479	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5753: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5756: aload_0
    //   5757: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5760: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5763: if_icmpne +37 -> 5800
    //   5766: aload_0
    //   5767: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5770: ifnull +30 -> 5800
    //   5773: aload_0
    //   5774: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5777: aload_0
    //   5778: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   5781: aload_0
    //   5782: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5785: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5788: aload_2
    //   5789: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5792: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5795: invokeinterface 812 4 0
    //   5800: aload 31
    //   5802: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   5805: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5808: aload 31
    //   5810: aload_0
    //   5811: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   5814: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5817: aload 31
    //   5819: aload_0
    //   5820: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   5823: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   5826: aload 31
    //   5828: iload 4
    //   5830: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5833: aload 31
    //   5835: aload 24
    //   5837: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5840: aload 27
    //   5842: ifnonnull +5759 -> 11601
    //   5845: aconst_null
    //   5846: astore 22
    //   5848: aload 31
    //   5850: aload 22
    //   5852: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5855: aload_0
    //   5856: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5859: ifnull +5752 -> 11611
    //   5862: aload_0
    //   5863: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5866: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5869: ifnull +5742 -> 11611
    //   5872: aload_0
    //   5873: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5876: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5879: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   5882: astore 22
    //   5884: aload 31
    //   5886: aload 22
    //   5888: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   5891: aload 31
    //   5893: ldc_w 705
    //   5896: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5899: aload 31
    //   5901: aload_2
    //   5902: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5905: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5908: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5911: aload 31
    //   5913: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   5916: aload_0
    //   5917: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   5920: lsub
    //   5921: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5924: aload 31
    //   5926: aload_2
    //   5927: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5930: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5933: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   5936: aload 31
    //   5938: aload 31
    //   5940: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5943: aload_2
    //   5944: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5947: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5950: lsub
    //   5951: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5954: aload 31
    //   5956: lload 9
    //   5958: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5961: aload 31
    //   5963: aload_0
    //   5964: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   5967: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5970: aload 31
    //   5972: aload_0
    //   5973: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   5976: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5979: aload 31
    //   5981: aload_0
    //   5982: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   5985: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5988: aload 31
    //   5990: lconst_0
    //   5991: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5994: aload 31
    //   5996: aload_0
    //   5997: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   6000: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6003: aload 31
    //   6005: aload_2
    //   6006: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6009: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6012: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6015: aload 31
    //   6017: aload_0
    //   6018: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   6021: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6024: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6027: aload 31
    //   6029: aload_0
    //   6030: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   6033: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6036: aload_0
    //   6037: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6040: ifnull +5577 -> 11617
    //   6043: aload_0
    //   6044: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6047: ldc_w 880
    //   6050: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6053: ifeq +5564 -> 11617
    //   6056: iconst_1
    //   6057: istore 21
    //   6059: aload 31
    //   6061: iload 21
    //   6063: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6066: aload 31
    //   6068: aload_2
    //   6069: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6072: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6075: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6078: aload_2
    //   6079: aload 31
    //   6081: invokevirtual 889	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6084: aload_0
    //   6085: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   6088: aload_0
    //   6089: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   6092: iconst_1
    //   6093: isub
    //   6094: if_icmpeq +13 -> 6107
    //   6097: aload_2
    //   6098: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6101: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6104: ifeq +11 -> 6115
    //   6107: aload_0
    //   6108: aload_1
    //   6109: aload_2
    //   6110: aload 31
    //   6112: invokevirtual 524	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6115: aload_0
    //   6116: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   6119: ifeq +5504 -> 11623
    //   6122: aload_0
    //   6123: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6126: ifnull +10 -> 6136
    //   6129: aload_0
    //   6130: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6133: invokevirtual 898	com/squareup/okhttp/Call:cancel	()V
    //   6136: aload_0
    //   6137: aconst_null
    //   6138: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6141: aload 23
    //   6143: athrow
    //   6144: lload 9
    //   6146: lstore 11
    //   6148: aload 26
    //   6150: astore 24
    //   6152: lload 9
    //   6154: lstore 13
    //   6156: aload 28
    //   6158: astore 23
    //   6160: aload_0
    //   6161: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6164: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6167: getfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6170: istore 4
    //   6172: goto -1505 -> 4667
    //   6175: lload 9
    //   6177: lstore 11
    //   6179: aload 26
    //   6181: astore 24
    //   6183: aload 29
    //   6185: astore 22
    //   6187: lload 9
    //   6189: lstore 13
    //   6191: aload 28
    //   6193: astore 23
    //   6195: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6198: iconst_3
    //   6199: if_icmpne -3742 -> 2457
    //   6202: lload 9
    //   6204: lstore 11
    //   6206: aload 26
    //   6208: astore 24
    //   6210: aload 29
    //   6212: astore 22
    //   6214: lload 9
    //   6216: lstore 13
    //   6218: aload 28
    //   6220: astore 23
    //   6222: aload_0
    //   6223: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6226: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6229: getstatic 439	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6232: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6235: if_icmpeq -3778 -> 2457
    //   6238: lload 9
    //   6240: lstore 11
    //   6242: aload 26
    //   6244: astore 24
    //   6246: lload 9
    //   6248: lstore 13
    //   6250: aload 28
    //   6252: astore 23
    //   6254: aload_0
    //   6255: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   6258: istore 4
    //   6260: iload 4
    //   6262: ifle +174 -> 6436
    //   6265: lload 9
    //   6267: lstore 11
    //   6269: aload 26
    //   6271: astore 24
    //   6273: lload 9
    //   6275: lstore 13
    //   6277: aload 28
    //   6279: astore 23
    //   6281: aload_0
    //   6282: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6285: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6288: iload 4
    //   6290: putfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6293: lload 9
    //   6295: lstore 11
    //   6297: aload 26
    //   6299: astore 24
    //   6301: lload 9
    //   6303: lstore 13
    //   6305: aload 28
    //   6307: astore 23
    //   6309: iload 4
    //   6311: istore 5
    //   6313: iload 4
    //   6315: invokestatic 365	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6318: ifne +7 -> 6325
    //   6321: bipush 80
    //   6323: istore 5
    //   6325: lload 9
    //   6327: lstore 11
    //   6329: aload 26
    //   6331: astore 24
    //   6333: lload 9
    //   6335: lstore 13
    //   6337: aload 28
    //   6339: astore 23
    //   6341: new 80	java/lang/StringBuilder
    //   6344: dup
    //   6345: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6348: aload 25
    //   6350: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6353: ldc_w 939
    //   6356: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6359: iload 5
    //   6361: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6364: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6367: astore 25
    //   6369: lload 9
    //   6371: lstore 11
    //   6373: aload 26
    //   6375: astore 24
    //   6377: aload 25
    //   6379: astore 22
    //   6381: lload 9
    //   6383: lstore 13
    //   6385: aload 28
    //   6387: astore 23
    //   6389: aload_0
    //   6390: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6393: ifnull -3936 -> 2457
    //   6396: lload 9
    //   6398: lstore 11
    //   6400: aload 26
    //   6402: astore 24
    //   6404: lload 9
    //   6406: lstore 13
    //   6408: aload 28
    //   6410: astore 23
    //   6412: aload_0
    //   6413: aload_0
    //   6414: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6417: aload_0
    //   6418: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6421: aload 25
    //   6423: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6426: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6429: aload 25
    //   6431: astore 22
    //   6433: goto -3976 -> 2457
    //   6436: lload 9
    //   6438: lstore 11
    //   6440: aload 26
    //   6442: astore 24
    //   6444: lload 9
    //   6446: lstore 13
    //   6448: aload 28
    //   6450: astore 23
    //   6452: aload_0
    //   6453: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6456: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6459: getfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6462: istore 4
    //   6464: goto -171 -> 6293
    //   6467: lload 9
    //   6469: lstore 11
    //   6471: aload 26
    //   6473: astore 24
    //   6475: lload 9
    //   6477: lstore 13
    //   6479: aload 28
    //   6481: astore 23
    //   6483: aload_0
    //   6484: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6487: ldc_w 880
    //   6490: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6493: ifeq -3902 -> 2591
    //   6496: iload 4
    //   6498: ifeq -3907 -> 2591
    //   6501: iload 21
    //   6503: ifeq -3912 -> 2591
    //   6506: lload 9
    //   6508: lstore 11
    //   6510: aload 26
    //   6512: astore 24
    //   6514: lload 9
    //   6516: lstore 13
    //   6518: aload 28
    //   6520: astore 23
    //   6522: aload_0
    //   6523: aload_0
    //   6524: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6527: ldc_w 1013
    //   6530: ldc_w 1015
    //   6533: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6536: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6539: lload 9
    //   6541: lstore 11
    //   6543: aload 26
    //   6545: astore 24
    //   6547: lload 9
    //   6549: lstore 13
    //   6551: aload 28
    //   6553: astore 23
    //   6555: aload_0
    //   6556: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   6559: istore 4
    //   6561: iload 4
    //   6563: ifle +296 -> 6859
    //   6566: lload 9
    //   6568: lstore 11
    //   6570: aload 26
    //   6572: astore 24
    //   6574: lload 9
    //   6576: lstore 13
    //   6578: aload 28
    //   6580: astore 23
    //   6582: aload_0
    //   6583: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6586: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6589: iload 4
    //   6591: putfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6594: lload 9
    //   6596: lstore 11
    //   6598: aload 26
    //   6600: astore 24
    //   6602: lload 9
    //   6604: lstore 13
    //   6606: aload 28
    //   6608: astore 23
    //   6610: iload 4
    //   6612: istore 5
    //   6614: iload 4
    //   6616: invokestatic 365	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6619: ifne +7 -> 6626
    //   6622: bipush 80
    //   6624: istore 5
    //   6626: lload 9
    //   6628: lstore 11
    //   6630: aload 26
    //   6632: astore 24
    //   6634: lload 9
    //   6636: lstore 13
    //   6638: aload 28
    //   6640: astore 23
    //   6642: new 80	java/lang/StringBuilder
    //   6645: dup
    //   6646: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6649: ldc_w 1009
    //   6652: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6655: ldc_w 1017
    //   6658: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6661: ldc_w 1011
    //   6664: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6667: iload 5
    //   6669: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6672: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6675: astore 22
    //   6677: lload 9
    //   6679: lstore 11
    //   6681: aload 26
    //   6683: astore 24
    //   6685: lload 9
    //   6687: lstore 13
    //   6689: aload 28
    //   6691: astore 23
    //   6693: aload_0
    //   6694: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6697: ifnull +36 -> 6733
    //   6700: lload 9
    //   6702: lstore 11
    //   6704: aload 26
    //   6706: astore 24
    //   6708: lload 9
    //   6710: lstore 13
    //   6712: aload 28
    //   6714: astore 23
    //   6716: aload_0
    //   6717: aload_0
    //   6718: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6721: aload_0
    //   6722: getfield 941	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6725: aload 22
    //   6727: invokevirtual 945	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6730: putfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6733: lload 9
    //   6735: lstore 11
    //   6737: aload 26
    //   6739: astore 24
    //   6741: lload 9
    //   6743: lstore 13
    //   6745: aload 28
    //   6747: astore 23
    //   6749: aload 31
    //   6751: aload_0
    //   6752: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6755: invokevirtual 312	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   6758: putfield 948	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6761: lload 9
    //   6763: lstore 11
    //   6765: aload 26
    //   6767: astore 24
    //   6769: lload 9
    //   6771: lstore 13
    //   6773: aload 28
    //   6775: astore 23
    //   6777: invokestatic 951	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   6780: ifeq -4189 -> 2591
    //   6783: lload 9
    //   6785: lstore 11
    //   6787: aload 26
    //   6789: astore 24
    //   6791: lload 9
    //   6793: lstore 13
    //   6795: aload 28
    //   6797: astore 23
    //   6799: ldc 226
    //   6801: new 80	java/lang/StringBuilder
    //   6804: dup
    //   6805: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6808: ldc_w 953
    //   6811: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6814: aload 31
    //   6816: getfield 948	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   6819: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6822: ldc_w 1019
    //   6825: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6828: aload_0
    //   6829: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   6832: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6835: ldc_w 388
    //   6838: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6841: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6844: invokevirtual 341	java/lang/Thread:getId	()J
    //   6847: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6850: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6853: invokestatic 958	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6856: goto -4265 -> 2591
    //   6859: lload 9
    //   6861: lstore 11
    //   6863: aload 26
    //   6865: astore 24
    //   6867: lload 9
    //   6869: lstore 13
    //   6871: aload 28
    //   6873: astore 23
    //   6875: aload_0
    //   6876: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6879: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6882: getfield 937	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6885: istore 4
    //   6887: goto -293 -> 6594
    //   6890: lload 9
    //   6892: lstore 11
    //   6894: aload 26
    //   6896: astore 24
    //   6898: lload 9
    //   6900: lstore 13
    //   6902: aload 28
    //   6904: astore 23
    //   6906: aload_0
    //   6907: aload_0
    //   6908: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   6911: aload_0
    //   6912: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   6915: aload_0
    //   6916: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   6919: aload_0
    //   6920: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6923: aload 32
    //   6925: invokestatic 1023	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   6928: putfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   6931: goto -4199 -> 2732
    //   6934: lload 9
    //   6936: lstore 11
    //   6938: aload 26
    //   6940: astore 24
    //   6942: aload 27
    //   6944: astore 22
    //   6946: lload 9
    //   6948: lstore 13
    //   6950: aload 28
    //   6952: astore 23
    //   6954: aload_0
    //   6955: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6958: ifnull -3915 -> 3043
    //   6961: lload 9
    //   6963: lstore 11
    //   6965: aload 26
    //   6967: astore 24
    //   6969: lload 9
    //   6971: lstore 13
    //   6973: aload 28
    //   6975: astore 23
    //   6977: aload_0
    //   6978: aload_0
    //   6979: getfield 1027	com/tencent/component/network/downloader/impl/StrictDownloadTask:pokHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttp2Client;
    //   6982: aload_0
    //   6983: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   6986: invokevirtual 183	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   6989: aload 32
    //   6991: invokevirtual 1033	com/tencent/component/network/utils/http/base/QZoneHttp2Client:newCall	(Lcom/squareup/okhttp/Request;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lcom/squareup/okhttp/Call;
    //   6994: putfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   6997: lload 9
    //   6999: lstore 11
    //   7001: aload 26
    //   7003: astore 24
    //   7005: lload 9
    //   7007: lstore 13
    //   7009: aload 28
    //   7011: astore 23
    //   7013: aload_0
    //   7014: aload_0
    //   7015: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   7018: invokevirtual 1036	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   7021: putfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7024: aload 27
    //   7026: astore 22
    //   7028: goto -3985 -> 3043
    //   7031: lload 9
    //   7033: lstore 11
    //   7035: aload 22
    //   7037: astore 24
    //   7039: lload 9
    //   7041: lstore 13
    //   7043: aload 22
    //   7045: astore 23
    //   7047: aload_0
    //   7048: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7051: ifnull +4636 -> 11687
    //   7054: lload 9
    //   7056: lstore 11
    //   7058: aload 22
    //   7060: astore 24
    //   7062: lload 9
    //   7064: lstore 13
    //   7066: aload 22
    //   7068: astore 23
    //   7070: aload_0
    //   7071: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7074: invokevirtual 218	com/squareup/okhttp/Response:code	()I
    //   7077: istore 4
    //   7079: goto -3909 -> 3170
    //   7082: ldc_w 705
    //   7085: astore 24
    //   7087: goto -3778 -> 3309
    //   7090: ldc_w 1038
    //   7093: astore 23
    //   7095: goto -3759 -> 3336
    //   7098: astore 22
    //   7100: ldc_w 509
    //   7103: astore 22
    //   7105: goto -3749 -> 3356
    //   7108: ldc_w 1040
    //   7111: astore 25
    //   7113: goto -3581 -> 3532
    //   7116: aconst_null
    //   7117: astore 24
    //   7119: goto -3465 -> 3654
    //   7122: aload_0
    //   7123: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7126: astore 22
    //   7128: goto -3230 -> 3898
    //   7131: iconst_0
    //   7132: istore_3
    //   7133: goto -3205 -> 3928
    //   7136: aconst_null
    //   7137: astore 22
    //   7139: goto -3063 -> 4076
    //   7142: new 80	java/lang/StringBuilder
    //   7145: dup
    //   7146: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   7149: ldc_w 1042
    //   7152: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7155: aload_0
    //   7156: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   7159: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7162: ldc_w 685
    //   7165: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7168: aload_0
    //   7169: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   7172: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7175: ldc_w 687
    //   7178: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7181: astore 28
    //   7183: aload_0
    //   7184: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   7187: ifeq +564 -> 7751
    //   7190: aload_0
    //   7191: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7194: ifnull +557 -> 7751
    //   7197: aload_0
    //   7198: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7201: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7204: ifnull +547 -> 7751
    //   7207: aload_0
    //   7208: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7211: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7214: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   7217: astore 25
    //   7219: aload 28
    //   7221: aload 25
    //   7223: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7226: ldc_w 696
    //   7229: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7232: aload 26
    //   7234: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7237: ldc_w 701
    //   7240: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7243: aload 24
    //   7245: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7248: ldc_w 703
    //   7251: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7254: ldc_w 705
    //   7257: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7260: ldc_w 707
    //   7263: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7266: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7269: invokevirtual 341	java/lang/Thread:getId	()J
    //   7272: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7275: ldc_w 709
    //   7278: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7281: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7284: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7287: ldc_w 711
    //   7290: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7293: aload_0
    //   7294: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   7297: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7300: ldc_w 713
    //   7303: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7306: aload_0
    //   7307: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   7310: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7313: ldc_w 715
    //   7316: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7319: astore 25
    //   7321: aload_0
    //   7322: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   7325: ifeq +434 -> 7759
    //   7328: aload_0
    //   7329: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   7332: aload_0
    //   7333: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   7336: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7339: astore 24
    //   7341: aload 25
    //   7343: aload 24
    //   7345: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7348: ldc_w 719
    //   7351: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7354: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7357: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7360: ldc_w 728
    //   7363: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7366: aload_2
    //   7367: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7370: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7373: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7376: ldc_w 733
    //   7379: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7382: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   7385: aload_0
    //   7386: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   7389: lsub
    //   7390: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7393: ldc_w 735
    //   7396: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7399: aload_2
    //   7400: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7403: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7406: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7409: ldc_w 740
    //   7412: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7415: aload_2
    //   7416: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7419: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7422: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7425: ldc_w 744
    //   7428: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7431: aload_2
    //   7432: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7435: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7438: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7441: ldc_w 749
    //   7444: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7447: aload_0
    //   7448: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   7451: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7454: ldc 91
    //   7456: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7459: aload_0
    //   7460: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   7463: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7466: ldc_w 754
    //   7469: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7472: iload 5
    //   7474: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7477: ldc_w 1044
    //   7480: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7483: iload 4
    //   7485: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7488: ldc_w 726
    //   7491: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7494: aload_2
    //   7495: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7498: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7501: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7504: ldc_w 760
    //   7507: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7510: aload 27
    //   7512: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7515: ldc_w 762
    //   7518: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7521: aload 22
    //   7523: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7526: ldc_w 764
    //   7529: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7532: astore 24
    //   7534: aload_0
    //   7535: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7538: ifnull +227 -> 7765
    //   7541: aload_0
    //   7542: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7545: iconst_0
    //   7546: bipush 30
    //   7548: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   7551: astore 22
    //   7553: aload 24
    //   7555: aload 22
    //   7557: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7560: ldc_w 770
    //   7563: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7566: astore 22
    //   7568: aload_0
    //   7569: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7572: ifnull +202 -> 7774
    //   7575: aload_0
    //   7576: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7579: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7582: istore_3
    //   7583: aload 22
    //   7585: iload_3
    //   7586: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7589: ldc_w 772
    //   7592: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7595: aload_2
    //   7596: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7599: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7602: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7605: ldc_w 777
    //   7608: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7611: lload 9
    //   7613: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7616: ldc_w 779
    //   7619: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7622: aload_0
    //   7623: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   7626: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7629: ldc 91
    //   7631: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7634: aload_0
    //   7635: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   7638: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7641: ldc_w 781
    //   7644: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7647: aload_0
    //   7648: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   7651: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7654: ldc 91
    //   7656: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7659: aload_0
    //   7660: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   7663: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7666: ldc_w 783
    //   7669: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7672: aload_0
    //   7673: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   7676: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7679: ldc_w 785
    //   7682: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7685: aload_0
    //   7686: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   7689: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7692: ldc_w 790
    //   7695: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7698: aload_0
    //   7699: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   7702: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7705: ldc_w 795
    //   7708: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7711: astore 24
    //   7713: aload_0
    //   7714: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7717: ifnull +62 -> 7779
    //   7720: aload_0
    //   7721: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7724: invokeinterface 805 1 0
    //   7729: astore 22
    //   7731: ldc_w 613
    //   7734: aload 24
    //   7736: aload 22
    //   7738: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7741: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7744: aconst_null
    //   7745: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7748: goto -3655 -> 4093
    //   7751: ldc_w 1040
    //   7754: astore 25
    //   7756: goto -537 -> 7219
    //   7759: aconst_null
    //   7760: astore 24
    //   7762: goto -421 -> 7341
    //   7765: aload_0
    //   7766: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7769: astore 22
    //   7771: goto -218 -> 7553
    //   7774: iconst_0
    //   7775: istore_3
    //   7776: goto -193 -> 7583
    //   7779: aconst_null
    //   7780: astore 22
    //   7782: goto -51 -> 7731
    //   7785: astore 22
    //   7787: ldc 226
    //   7789: ldc_w 1047
    //   7792: aload 22
    //   7794: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7797: goto -3654 -> 4143
    //   7800: astore 22
    //   7802: ldc 226
    //   7804: ldc_w 1048
    //   7807: aload 22
    //   7809: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7812: goto -3619 -> 4193
    //   7815: aload 26
    //   7817: invokevirtual 1051	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7820: astore 22
    //   7822: goto -3582 -> 4240
    //   7825: aconst_null
    //   7826: astore 22
    //   7828: goto -3552 -> 4276
    //   7831: iconst_0
    //   7832: istore 21
    //   7834: goto -3383 -> 4451
    //   7837: aload_0
    //   7838: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7841: ifnull -3308 -> 4533
    //   7844: aload_0
    //   7845: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7848: invokevirtual 1056	org/apache/http/client/methods/HttpGet:abort	()V
    //   7851: goto -3318 -> 4533
    //   7854: aload_0
    //   7855: aload_0
    //   7856: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7859: aload_0
    //   7860: getfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   7863: aload_0
    //   7864: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   7867: aload_0
    //   7868: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7871: invokespecial 1058	com/tencent/component/network/downloader/impl/StrictDownloadTask:printfHttpDetail	(Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)V
    //   7874: aload_0
    //   7875: aload_0
    //   7876: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   7879: aload_0
    //   7880: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7883: invokevirtual 1062	com/tencent/component/network/downloader/impl/StrictDownloadTask:getRetryFlag	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   7886: ifne +8 -> 7894
    //   7889: aload_0
    //   7890: iconst_0
    //   7891: invokevirtual 1065	com/tencent/component/network/downloader/impl/StrictDownloadTask:setAttemptCount	(I)V
    //   7894: sipush 404
    //   7897: iload 4
    //   7899: if_icmpne +46 -> 7945
    //   7902: aload_0
    //   7903: aload_0
    //   7904: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   7907: aload_0
    //   7908: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   7911: invokevirtual 1068	com/tencent/component/network/downloader/impl/StrictDownloadTask:getXErrorCode	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   7914: istore 5
    //   7916: iload 5
    //   7918: sipush -6101
    //   7921: if_icmpeq +19 -> 7940
    //   7924: iload 5
    //   7926: sipush -5062
    //   7929: if_icmpeq +11 -> 7940
    //   7932: iload 5
    //   7934: sipush -5023
    //   7937: if_icmpne +8 -> 7945
    //   7940: aload_0
    //   7941: iconst_0
    //   7942: invokevirtual 1065	com/tencent/component/network/downloader/impl/StrictDownloadTask:setAttemptCount	(I)V
    //   7945: aload_2
    //   7946: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7949: iconst_3
    //   7950: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   7953: iload 4
    //   7955: istore 5
    //   7957: aload_0
    //   7958: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   7961: ifnull +21 -> 7982
    //   7964: aload_0
    //   7965: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   7968: aload_0
    //   7969: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   7972: iconst_1
    //   7973: invokeinterface 1072 3 0
    //   7978: iload 4
    //   7980: istore 5
    //   7982: iload_3
    //   7983: iconst_1
    //   7984: iadd
    //   7985: istore 4
    //   7987: aload_2
    //   7988: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7991: lload 17
    //   7993: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   7996: invokevirtual 627	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   7999: aload_2
    //   8000: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8003: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8006: aload_0
    //   8007: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   8010: lsub
    //   8011: putfield 630	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8014: aload_2
    //   8015: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8018: aload_0
    //   8019: getfield 633	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   8022: putfield 636	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8025: aload_0
    //   8026: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8029: invokestatic 641	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8032: invokevirtual 645	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8035: astore 26
    //   8037: aload_0
    //   8038: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8041: ifnull +1289 -> 9330
    //   8044: aload_0
    //   8045: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8048: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8051: ifnull +1279 -> 9330
    //   8054: aload_0
    //   8055: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8058: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8061: invokevirtual 650	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   8064: astore 24
    //   8066: aload_0
    //   8067: aload_0
    //   8068: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8071: aload_0
    //   8072: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8075: aload_0
    //   8076: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8079: invokevirtual 654	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   8082: astore 27
    //   8084: aload 24
    //   8086: ifnull +1252 -> 9338
    //   8089: aload 24
    //   8091: astore 23
    //   8093: aload 22
    //   8095: ifnull +3617 -> 11712
    //   8098: aload 22
    //   8100: ldc_w 656
    //   8103: invokeinterface 662 2 0
    //   8108: checkcast 449	java/lang/String
    //   8111: astore 22
    //   8113: aload_2
    //   8114: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8117: aload 22
    //   8119: putfield 665	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8122: aload_2
    //   8123: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8126: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8129: ifne +64 -> 8193
    //   8132: aload_0
    //   8133: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8136: ifnull +28 -> 8164
    //   8139: aload_0
    //   8140: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8143: aload_0
    //   8144: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8147: aload_2
    //   8148: invokevirtual 675	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   8151: aload_0
    //   8152: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8155: aload_0
    //   8156: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8159: invokeinterface 681 5 0
    //   8164: aload_0
    //   8165: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8168: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8171: ifne +22 -> 8193
    //   8174: aload_0
    //   8175: aload_0
    //   8176: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8179: iconst_1
    //   8180: isub
    //   8181: putfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8184: aload_2
    //   8185: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8188: bipush 6
    //   8190: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   8193: aload_1
    //   8194: invokeinterface 520 1 0
    //   8199: ifne +1065 -> 9264
    //   8202: aload_2
    //   8203: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8206: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8209: ifne +1181 -> 9390
    //   8212: new 80	java/lang/StringBuilder
    //   8215: dup
    //   8216: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   8219: ldc_w 683
    //   8222: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8225: aload_0
    //   8226: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8229: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8232: ldc_w 685
    //   8235: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8238: aload_0
    //   8239: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   8242: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8245: ldc_w 687
    //   8248: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8251: astore 28
    //   8253: aload_0
    //   8254: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   8257: ifeq +1099 -> 9356
    //   8260: aload_0
    //   8261: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8264: ifnull +1092 -> 9356
    //   8267: aload_0
    //   8268: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8271: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8274: ifnull +1082 -> 9356
    //   8277: aload_0
    //   8278: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   8281: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8284: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   8287: astore 25
    //   8289: aload 28
    //   8291: aload 25
    //   8293: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8296: ldc_w 696
    //   8299: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8302: aload 26
    //   8304: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8307: ldc_w 701
    //   8310: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8313: aload 24
    //   8315: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8318: ldc_w 703
    //   8321: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8324: ldc_w 705
    //   8327: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8330: ldc_w 707
    //   8333: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8336: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8339: invokevirtual 341	java/lang/Thread:getId	()J
    //   8342: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8345: ldc_w 709
    //   8348: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8351: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8354: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8357: ldc_w 711
    //   8360: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8363: aload_0
    //   8364: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   8367: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8370: ldc_w 713
    //   8373: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8376: aload_0
    //   8377: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   8380: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8383: ldc_w 715
    //   8386: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8389: astore 25
    //   8391: aload_0
    //   8392: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   8395: ifeq +969 -> 9364
    //   8398: aload_0
    //   8399: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8402: aload_0
    //   8403: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   8406: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8409: astore 24
    //   8411: aload 25
    //   8413: aload 24
    //   8415: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8418: ldc_w 717
    //   8421: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8424: aload_0
    //   8425: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8428: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8431: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8434: ldc_w 719
    //   8437: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8440: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8443: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8446: ldc_w 726
    //   8449: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8452: aload_2
    //   8453: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8456: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8459: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8462: ldc_w 728
    //   8465: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8468: aload_2
    //   8469: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8472: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8475: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8478: ldc_w 733
    //   8481: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8484: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8487: aload_0
    //   8488: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   8491: lsub
    //   8492: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8495: ldc_w 735
    //   8498: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8501: aload_2
    //   8502: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8505: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8508: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8511: ldc_w 740
    //   8514: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8517: aload_2
    //   8518: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8521: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8524: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8527: ldc_w 744
    //   8530: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8533: aload_2
    //   8534: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8537: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8540: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8543: ldc_w 749
    //   8546: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8549: aload_0
    //   8550: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8553: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8556: ldc 91
    //   8558: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8561: aload_0
    //   8562: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   8565: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8568: ldc_w 754
    //   8571: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8574: iload 4
    //   8576: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8579: ldc_w 756
    //   8582: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8585: aload_2
    //   8586: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8589: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8592: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8595: ldc_w 758
    //   8598: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8601: iload 5
    //   8603: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8606: ldc_w 760
    //   8609: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8612: aload 27
    //   8614: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8617: ldc_w 762
    //   8620: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8623: aload 22
    //   8625: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8628: ldc_w 764
    //   8631: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8634: astore 24
    //   8636: aload_0
    //   8637: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8640: ifnull +730 -> 9370
    //   8643: aload_0
    //   8644: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8647: iconst_0
    //   8648: bipush 30
    //   8650: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   8653: astore 22
    //   8655: aload 24
    //   8657: aload 22
    //   8659: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8662: ldc_w 770
    //   8665: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8668: astore 22
    //   8670: aload_0
    //   8671: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8674: ifnull +705 -> 9379
    //   8677: aload_0
    //   8678: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8681: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8684: istore_3
    //   8685: aload 22
    //   8687: iload_3
    //   8688: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8691: ldc_w 772
    //   8694: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8697: aload_2
    //   8698: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8701: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8704: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8707: ldc_w 777
    //   8710: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8713: lload 9
    //   8715: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8718: ldc_w 779
    //   8721: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8724: aload_0
    //   8725: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   8728: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8731: ldc 91
    //   8733: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8736: aload_0
    //   8737: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   8740: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8743: ldc_w 781
    //   8746: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8749: aload_0
    //   8750: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   8753: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8756: ldc 91
    //   8758: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8761: aload_0
    //   8762: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   8765: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8768: ldc_w 783
    //   8771: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8774: aload_0
    //   8775: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   8778: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8781: ldc_w 785
    //   8784: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8787: aload_0
    //   8788: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   8791: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8794: ldc_w 790
    //   8797: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8800: aload_0
    //   8801: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   8804: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8807: ldc_w 795
    //   8810: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8813: astore 24
    //   8815: aload_0
    //   8816: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8819: ifnull +565 -> 9384
    //   8822: aload_0
    //   8823: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8826: invokeinterface 805 1 0
    //   8831: astore 22
    //   8833: ldc_w 613
    //   8836: aload 24
    //   8838: aload 22
    //   8840: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8843: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8846: aconst_null
    //   8847: invokestatic 567	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8850: getstatic 368	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8853: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8856: aload_0
    //   8857: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8860: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8863: if_icmpne +37 -> 8900
    //   8866: aload_0
    //   8867: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8870: ifnull +30 -> 8900
    //   8873: aload_0
    //   8874: getfield 395	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8877: aload_0
    //   8878: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   8881: aload_0
    //   8882: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8885: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   8888: aload_2
    //   8889: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8892: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8895: invokeinterface 812 4 0
    //   8900: getstatic 479	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8903: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8906: aload_0
    //   8907: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8910: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8913: if_icmpne +37 -> 8950
    //   8916: aload_0
    //   8917: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8920: ifnull +30 -> 8950
    //   8923: aload_0
    //   8924: getfield 463	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   8927: aload_0
    //   8928: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   8931: aload_0
    //   8932: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8935: invokestatic 808	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   8938: aload_2
    //   8939: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8942: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8945: invokeinterface 812 4 0
    //   8950: aload 31
    //   8952: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   8955: putfield 815	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   8958: aload 31
    //   8960: aload_0
    //   8961: getfield 818	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   8964: putfield 821	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   8967: aload 31
    //   8969: aload_0
    //   8970: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8973: putfield 822	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   8976: aload 31
    //   8978: iload 5
    //   8980: putfield 823	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   8983: aload 31
    //   8985: aconst_null
    //   8986: putfield 827	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   8989: aload 26
    //   8991: ifnonnull +1072 -> 10063
    //   8994: aconst_null
    //   8995: astore 22
    //   8997: aload 31
    //   8999: aload 22
    //   9001: putfield 830	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   9004: aload_0
    //   9005: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9008: ifnull +1065 -> 10073
    //   9011: aload_0
    //   9012: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9015: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   9018: ifnull +1055 -> 10073
    //   9021: aload_0
    //   9022: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9025: invokevirtual 649	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   9028: getfield 833	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   9031: astore 22
    //   9033: aload 31
    //   9035: aload 22
    //   9037: putfield 836	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   9040: aload 31
    //   9042: ldc_w 705
    //   9045: putfield 839	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9048: aload 31
    //   9050: aload_2
    //   9051: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9054: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9057: putfield 840	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9060: aload 31
    //   9062: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   9065: aload_0
    //   9066: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   9069: lsub
    //   9070: putfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9073: aload 31
    //   9075: aload_2
    //   9076: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9079: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9082: putfield 846	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9085: aload 31
    //   9087: aload 31
    //   9089: getfield 843	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9092: aload_2
    //   9093: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9096: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9099: lsub
    //   9100: putfield 849	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9103: aload 31
    //   9105: lload 9
    //   9107: putfield 852	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9110: aload 31
    //   9112: aload_0
    //   9113: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   9116: putfield 855	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9119: aload 31
    //   9121: aload_0
    //   9122: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   9125: putfield 858	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9128: aload 31
    //   9130: aload_0
    //   9131: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   9134: putfield 861	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9137: aload 31
    //   9139: lconst_0
    //   9140: putfield 864	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9143: aload 31
    //   9145: aload_0
    //   9146: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   9149: putfield 867	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9152: aload 31
    //   9154: aload_2
    //   9155: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9158: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9161: putfield 870	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9164: aload 31
    //   9166: aload_0
    //   9167: invokevirtual 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   9170: invokestatic 873	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9173: putfield 875	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9176: aload 31
    //   9178: aload_0
    //   9179: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9182: putfield 878	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9185: aload_0
    //   9186: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9189: ifnull +890 -> 10079
    //   9192: aload_0
    //   9193: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9196: ldc_w 880
    //   9199: invokevirtual 608	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9202: ifeq +877 -> 10079
    //   9205: iconst_1
    //   9206: istore 21
    //   9208: aload 31
    //   9210: iload 21
    //   9212: putfield 883	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9215: aload 31
    //   9217: aload_2
    //   9218: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9221: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9224: putfield 885	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9227: aload_2
    //   9228: aload 31
    //   9230: invokevirtual 889	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9233: aload_0
    //   9234: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   9237: aload_0
    //   9238: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   9241: iconst_1
    //   9242: isub
    //   9243: if_icmpeq +13 -> 9256
    //   9246: aload_2
    //   9247: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9250: invokevirtual 668	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9253: ifeq +11 -> 9264
    //   9256: aload_0
    //   9257: aload_1
    //   9258: aload_2
    //   9259: aload 31
    //   9261: invokevirtual 524	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9264: aload_0
    //   9265: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9268: ifeq +817 -> 10085
    //   9271: aload_0
    //   9272: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   9275: ifnull +10 -> 9285
    //   9278: aload_0
    //   9279: getfield 893	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lcom/squareup/okhttp/Call;
    //   9282: invokevirtual 898	com/squareup/okhttp/Call:cancel	()V
    //   9285: aload_0
    //   9286: aconst_null
    //   9287: putfield 593	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lcom/squareup/okhttp/Request$Builder;
    //   9290: aload 23
    //   9292: astore 22
    //   9294: iload 4
    //   9296: istore_3
    //   9297: goto -9022 -> 275
    //   9300: lload 9
    //   9302: lstore 11
    //   9304: aload 22
    //   9306: astore 24
    //   9308: lload 9
    //   9310: lstore 13
    //   9312: aload 22
    //   9314: astore 23
    //   9316: aload_2
    //   9317: invokevirtual 538	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9320: iconst_3
    //   9321: invokevirtual 543	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   9324: iconst_0
    //   9325: istore 5
    //   9327: goto -1345 -> 7982
    //   9330: ldc_w 705
    //   9333: astore 24
    //   9335: goto -1269 -> 8066
    //   9338: ldc_w 1038
    //   9341: astore 23
    //   9343: goto -1250 -> 8093
    //   9346: astore 22
    //   9348: ldc_w 509
    //   9351: astore 22
    //   9353: goto -1240 -> 8113
    //   9356: ldc_w 1040
    //   9359: astore 25
    //   9361: goto -1072 -> 8289
    //   9364: aconst_null
    //   9365: astore 24
    //   9367: goto -956 -> 8411
    //   9370: aload_0
    //   9371: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9374: astore 22
    //   9376: goto -721 -> 8655
    //   9379: iconst_0
    //   9380: istore_3
    //   9381: goto -696 -> 8685
    //   9384: aconst_null
    //   9385: astore 22
    //   9387: goto -554 -> 8833
    //   9390: new 80	java/lang/StringBuilder
    //   9393: dup
    //   9394: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   9397: ldc_w 1042
    //   9400: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9403: aload_0
    //   9404: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   9407: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9410: ldc_w 685
    //   9413: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9416: aload_0
    //   9417: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9420: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9423: ldc_w 687
    //   9426: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9429: astore 28
    //   9431: aload_0
    //   9432: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9435: ifeq +564 -> 9999
    //   9438: aload_0
    //   9439: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   9442: ifnull +557 -> 9999
    //   9445: aload_0
    //   9446: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   9449: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9452: ifnull +547 -> 9999
    //   9455: aload_0
    //   9456: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   9459: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9462: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   9465: astore 25
    //   9467: aload 28
    //   9469: aload 25
    //   9471: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9474: ldc_w 696
    //   9477: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9480: aload 26
    //   9482: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9485: ldc_w 701
    //   9488: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9491: aload 24
    //   9493: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9496: ldc_w 703
    //   9499: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9502: ldc_w 705
    //   9505: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9508: ldc_w 707
    //   9511: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9514: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9517: invokevirtual 341	java/lang/Thread:getId	()J
    //   9520: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9523: ldc_w 709
    //   9526: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9529: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9532: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9535: ldc_w 711
    //   9538: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9541: aload_0
    //   9542: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   9545: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9548: ldc_w 713
    //   9551: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9554: aload_0
    //   9555: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   9558: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9561: ldc_w 715
    //   9564: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9567: astore 25
    //   9569: aload_0
    //   9570: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   9573: ifeq +434 -> 10007
    //   9576: aload_0
    //   9577: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   9580: aload_0
    //   9581: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   9584: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9587: astore 24
    //   9589: aload 25
    //   9591: aload 24
    //   9593: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9596: ldc_w 719
    //   9599: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9602: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9605: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9608: ldc_w 728
    //   9611: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9614: aload_2
    //   9615: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9618: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9621: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9624: ldc_w 733
    //   9627: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9630: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   9633: aload_0
    //   9634: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   9637: lsub
    //   9638: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9641: ldc_w 735
    //   9644: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9647: aload_2
    //   9648: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9651: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9654: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9657: ldc_w 740
    //   9660: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9663: aload_2
    //   9664: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9667: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9670: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9673: ldc_w 744
    //   9676: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9679: aload_2
    //   9680: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9683: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9686: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9689: ldc_w 749
    //   9692: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9695: aload_0
    //   9696: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   9699: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9702: ldc 91
    //   9704: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9707: aload_0
    //   9708: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   9711: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9714: ldc_w 754
    //   9717: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9720: iload 4
    //   9722: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9725: ldc_w 1044
    //   9728: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9731: iload 5
    //   9733: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9736: ldc_w 726
    //   9739: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9742: aload_2
    //   9743: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9746: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9749: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9752: ldc_w 760
    //   9755: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9758: aload 27
    //   9760: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9763: ldc_w 762
    //   9766: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9769: aload 22
    //   9771: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9774: ldc_w 764
    //   9777: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9780: astore 24
    //   9782: aload_0
    //   9783: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9786: ifnull +227 -> 10013
    //   9789: aload_0
    //   9790: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9793: iconst_0
    //   9794: bipush 30
    //   9796: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   9799: astore 22
    //   9801: aload 24
    //   9803: aload 22
    //   9805: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9808: ldc_w 770
    //   9811: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9814: astore 22
    //   9816: aload_0
    //   9817: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9820: ifnull +202 -> 10022
    //   9823: aload_0
    //   9824: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9827: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9830: istore_3
    //   9831: aload 22
    //   9833: iload_3
    //   9834: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9837: ldc_w 772
    //   9840: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9843: aload_2
    //   9844: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9847: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9850: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9853: ldc_w 777
    //   9856: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9859: lload 9
    //   9861: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9864: ldc_w 779
    //   9867: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9870: aload_0
    //   9871: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   9874: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9877: ldc 91
    //   9879: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9882: aload_0
    //   9883: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   9886: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9889: ldc_w 781
    //   9892: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9895: aload_0
    //   9896: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   9899: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9902: ldc 91
    //   9904: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9907: aload_0
    //   9908: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   9911: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9914: ldc_w 783
    //   9917: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9920: aload_0
    //   9921: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   9924: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9927: ldc_w 785
    //   9930: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9933: aload_0
    //   9934: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   9937: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9940: ldc_w 790
    //   9943: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9946: aload_0
    //   9947: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   9950: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9953: ldc_w 795
    //   9956: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9959: astore 24
    //   9961: aload_0
    //   9962: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9965: ifnull +62 -> 10027
    //   9968: aload_0
    //   9969: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9972: invokeinterface 805 1 0
    //   9977: astore 22
    //   9979: ldc_w 613
    //   9982: aload 24
    //   9984: aload 22
    //   9986: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9989: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9992: aconst_null
    //   9993: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9996: goto -1146 -> 8850
    //   9999: ldc_w 1040
    //   10002: astore 25
    //   10004: goto -537 -> 9467
    //   10007: aconst_null
    //   10008: astore 24
    //   10010: goto -421 -> 9589
    //   10013: aload_0
    //   10014: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10017: astore 22
    //   10019: goto -218 -> 9801
    //   10022: iconst_0
    //   10023: istore_3
    //   10024: goto -193 -> 9831
    //   10027: aconst_null
    //   10028: astore 22
    //   10030: goto -51 -> 9979
    //   10033: astore 22
    //   10035: ldc 226
    //   10037: ldc_w 1047
    //   10040: aload 22
    //   10042: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10045: goto -1145 -> 8900
    //   10048: astore 22
    //   10050: ldc 226
    //   10052: ldc_w 1048
    //   10055: aload 22
    //   10057: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10060: goto -1110 -> 8950
    //   10063: aload 26
    //   10065: invokevirtual 1051	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10068: astore 22
    //   10070: goto -1073 -> 8997
    //   10073: aconst_null
    //   10074: astore 22
    //   10076: goto -1043 -> 9033
    //   10079: iconst_0
    //   10080: istore 21
    //   10082: goto -874 -> 9208
    //   10085: aload_0
    //   10086: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10089: ifnull -799 -> 9290
    //   10092: aload_0
    //   10093: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10096: invokevirtual 1056	org/apache/http/client/methods/HttpGet:abort	()V
    //   10099: goto -809 -> 9290
    //   10102: ldc_w 705
    //   10105: astore 25
    //   10107: goto -9619 -> 488
    //   10110: ldc_w 1038
    //   10113: astore 23
    //   10115: goto -9600 -> 515
    //   10118: astore 22
    //   10120: ldc_w 509
    //   10123: astore 22
    //   10125: goto -9590 -> 535
    //   10128: ldc_w 1040
    //   10131: astore 26
    //   10133: goto -9422 -> 711
    //   10136: aconst_null
    //   10137: astore 25
    //   10139: goto -9306 -> 833
    //   10142: aload_0
    //   10143: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10146: astore 22
    //   10148: goto -9071 -> 1077
    //   10151: iconst_0
    //   10152: istore_3
    //   10153: goto -9046 -> 1107
    //   10156: aconst_null
    //   10157: astore 22
    //   10159: goto -8904 -> 1255
    //   10162: new 80	java/lang/StringBuilder
    //   10165: dup
    //   10166: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   10169: ldc_w 1042
    //   10172: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10175: aload_0
    //   10176: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   10179: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10182: ldc_w 685
    //   10185: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10188: aload_0
    //   10189: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10192: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10195: ldc_w 687
    //   10198: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10201: astore 29
    //   10203: aload_0
    //   10204: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10207: ifeq +564 -> 10771
    //   10210: aload_0
    //   10211: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10214: ifnull +557 -> 10771
    //   10217: aload_0
    //   10218: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10221: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10224: ifnull +547 -> 10771
    //   10227: aload_0
    //   10228: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10231: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10234: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   10237: astore 26
    //   10239: aload 29
    //   10241: aload 26
    //   10243: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10246: ldc_w 696
    //   10249: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10252: aload 27
    //   10254: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10257: ldc_w 701
    //   10260: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10263: aload 25
    //   10265: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10268: ldc_w 703
    //   10271: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10274: ldc_w 705
    //   10277: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10280: ldc_w 707
    //   10283: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10286: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10289: invokevirtual 341	java/lang/Thread:getId	()J
    //   10292: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10295: ldc_w 709
    //   10298: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10301: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10304: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10307: ldc_w 711
    //   10310: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10313: aload_0
    //   10314: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   10317: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10320: ldc_w 713
    //   10323: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10326: aload_0
    //   10327: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   10330: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10333: ldc_w 715
    //   10336: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10339: astore 26
    //   10341: aload_0
    //   10342: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   10345: ifeq +434 -> 10779
    //   10348: aload_0
    //   10349: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   10352: aload_0
    //   10353: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   10356: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10359: astore 25
    //   10361: aload 26
    //   10363: aload 25
    //   10365: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10368: ldc_w 719
    //   10371: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10374: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10377: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10380: ldc_w 728
    //   10383: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10386: aload_2
    //   10387: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10390: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10393: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10396: ldc_w 733
    //   10399: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10402: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   10405: aload_0
    //   10406: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   10409: lsub
    //   10410: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10413: ldc_w 735
    //   10416: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10419: aload_2
    //   10420: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10423: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10426: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10429: ldc_w 740
    //   10432: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10435: aload_2
    //   10436: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10439: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10442: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10445: ldc_w 744
    //   10448: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10451: aload_2
    //   10452: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10455: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10458: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10461: ldc_w 749
    //   10464: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10467: aload_0
    //   10468: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   10471: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10474: ldc 91
    //   10476: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10479: aload_0
    //   10480: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   10483: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10486: ldc_w 754
    //   10489: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10492: iload 5
    //   10494: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10497: ldc_w 1044
    //   10500: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10503: iload 4
    //   10505: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10508: ldc_w 726
    //   10511: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10514: aload_2
    //   10515: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10518: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10521: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10524: ldc_w 760
    //   10527: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10530: aload 28
    //   10532: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10535: ldc_w 762
    //   10538: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10541: aload 22
    //   10543: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10546: ldc_w 764
    //   10549: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10552: astore 25
    //   10554: aload_0
    //   10555: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10558: ifnull +227 -> 10785
    //   10561: aload_0
    //   10562: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10565: iconst_0
    //   10566: bipush 30
    //   10568: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   10571: astore 22
    //   10573: aload 25
    //   10575: aload 22
    //   10577: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10580: ldc_w 770
    //   10583: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10586: astore 22
    //   10588: aload_0
    //   10589: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10592: ifnull +202 -> 10794
    //   10595: aload_0
    //   10596: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10599: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10602: istore_3
    //   10603: aload 22
    //   10605: iload_3
    //   10606: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10609: ldc_w 772
    //   10612: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10615: aload_2
    //   10616: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10619: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10622: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10625: ldc_w 777
    //   10628: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10631: lload 9
    //   10633: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10636: ldc_w 779
    //   10639: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10642: aload_0
    //   10643: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   10646: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10649: ldc 91
    //   10651: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10654: aload_0
    //   10655: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   10658: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10661: ldc_w 781
    //   10664: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10667: aload_0
    //   10668: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   10671: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10674: ldc 91
    //   10676: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10679: aload_0
    //   10680: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   10683: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10686: ldc_w 783
    //   10689: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10692: aload_0
    //   10693: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   10696: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10699: ldc_w 785
    //   10702: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10705: aload_0
    //   10706: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   10709: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10712: ldc_w 790
    //   10715: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10718: aload_0
    //   10719: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   10722: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10725: ldc_w 795
    //   10728: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10731: astore 25
    //   10733: aload_0
    //   10734: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10737: ifnull +62 -> 10799
    //   10740: aload_0
    //   10741: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10744: invokeinterface 805 1 0
    //   10749: astore 22
    //   10751: ldc_w 613
    //   10754: aload 25
    //   10756: aload 22
    //   10758: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10761: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10764: aconst_null
    //   10765: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10768: goto -9495 -> 1273
    //   10771: ldc_w 1040
    //   10774: astore 26
    //   10776: goto -537 -> 10239
    //   10779: aconst_null
    //   10780: astore 25
    //   10782: goto -421 -> 10361
    //   10785: aload_0
    //   10786: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10789: astore 22
    //   10791: goto -218 -> 10573
    //   10794: iconst_0
    //   10795: istore_3
    //   10796: goto -193 -> 10603
    //   10799: aconst_null
    //   10800: astore 22
    //   10802: goto -51 -> 10751
    //   10805: astore 22
    //   10807: ldc 226
    //   10809: ldc_w 1047
    //   10812: aload 22
    //   10814: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10817: goto -9494 -> 1323
    //   10820: astore 22
    //   10822: ldc 226
    //   10824: ldc_w 1048
    //   10827: aload 22
    //   10829: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10832: goto -9459 -> 1373
    //   10835: aload 27
    //   10837: invokevirtual 1051	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10840: astore 22
    //   10842: goto -9421 -> 1421
    //   10845: aconst_null
    //   10846: astore 22
    //   10848: goto -9391 -> 1457
    //   10851: iconst_0
    //   10852: istore 21
    //   10854: goto -9222 -> 1632
    //   10857: aload_0
    //   10858: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10861: ifnull -9147 -> 1714
    //   10864: aload_0
    //   10865: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10868: invokevirtual 1056	org/apache/http/client/methods/HttpGet:abort	()V
    //   10871: goto -9157 -> 1714
    //   10874: ldc_w 705
    //   10877: astore 25
    //   10879: goto -5959 -> 4920
    //   10882: goto -5939 -> 4943
    //   10885: astore 22
    //   10887: ldc_w 509
    //   10890: astore 22
    //   10892: goto -5929 -> 4963
    //   10895: ldc_w 1040
    //   10898: astore 26
    //   10900: goto -5761 -> 5139
    //   10903: aconst_null
    //   10904: astore 25
    //   10906: goto -5645 -> 5261
    //   10909: aload_0
    //   10910: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10913: astore 22
    //   10915: goto -5411 -> 5504
    //   10918: iconst_0
    //   10919: istore_3
    //   10920: goto -5386 -> 5534
    //   10923: aconst_null
    //   10924: astore 22
    //   10926: goto -5244 -> 5682
    //   10929: new 80	java/lang/StringBuilder
    //   10932: dup
    //   10933: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   10936: ldc_w 1042
    //   10939: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10942: aload_0
    //   10943: invokevirtual 250	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   10946: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10949: ldc_w 685
    //   10952: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10955: aload_0
    //   10956: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10959: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10962: ldc_w 687
    //   10965: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10968: astore 29
    //   10970: aload_0
    //   10971: getfield 256	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10974: ifeq +563 -> 11537
    //   10977: aload_0
    //   10978: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10981: ifnull +556 -> 11537
    //   10984: aload_0
    //   10985: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10988: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10991: ifnull +546 -> 11537
    //   10994: aload_0
    //   10995: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lcom/squareup/okhttp/Response;
    //   10998: invokevirtual 691	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   11001: invokevirtual 694	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   11004: astore 26
    //   11006: aload 29
    //   11008: aload 26
    //   11010: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11013: ldc_w 696
    //   11016: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11019: aload 27
    //   11021: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11024: ldc_w 701
    //   11027: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11030: aload 25
    //   11032: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11035: ldc_w 703
    //   11038: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11041: ldc_w 705
    //   11044: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11047: ldc_w 707
    //   11050: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11053: invokestatic 338	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11056: invokevirtual 341	java/lang/Thread:getId	()J
    //   11059: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11062: ldc_w 709
    //   11065: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11068: invokestatic 328	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11071: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11074: ldc_w 711
    //   11077: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11080: aload_0
    //   11081: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   11084: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11087: ldc_w 713
    //   11090: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11093: aload_0
    //   11094: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   11097: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11100: ldc_w 715
    //   11103: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11106: astore 26
    //   11108: aload_0
    //   11109: getfield 352	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   11112: ifeq +433 -> 11545
    //   11115: aload_0
    //   11116: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   11119: aload_0
    //   11120: getfield 357	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   11123: invokestatic 497	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   11126: astore 25
    //   11128: aload 26
    //   11130: aload 25
    //   11132: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11135: ldc_w 719
    //   11138: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11141: invokestatic 724	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   11144: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11147: ldc_w 728
    //   11150: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11153: aload_2
    //   11154: invokevirtual 621	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11157: getfield 731	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11160: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11163: ldc_w 733
    //   11166: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11169: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   11172: aload_0
    //   11173: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   11176: lsub
    //   11177: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11180: ldc_w 735
    //   11183: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11186: aload_2
    //   11187: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11190: getfield 738	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11193: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11196: ldc_w 740
    //   11199: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11202: aload_2
    //   11203: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11206: getfield 742	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11209: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11212: ldc_w 744
    //   11215: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11218: aload_2
    //   11219: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11222: getfield 747	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   11225: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11228: ldc_w 749
    //   11231: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11234: aload_0
    //   11235: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   11238: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11241: ldc 91
    //   11243: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11246: aload_0
    //   11247: getfield 752	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   11250: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11253: ldc_w 754
    //   11256: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11259: iload_3
    //   11260: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11263: ldc_w 1044
    //   11266: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11269: iload 4
    //   11271: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11274: ldc_w 726
    //   11277: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11280: aload_2
    //   11281: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11284: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11287: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11290: ldc_w 760
    //   11293: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11296: aload 28
    //   11298: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11301: ldc_w 762
    //   11304: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11307: aload 22
    //   11309: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11312: ldc_w 764
    //   11315: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11318: astore 25
    //   11320: aload_0
    //   11321: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11324: ifnull +227 -> 11551
    //   11327: aload_0
    //   11328: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11331: iconst_0
    //   11332: bipush 30
    //   11334: invokevirtual 768	java/lang/String:substring	(II)Ljava/lang/String;
    //   11337: astore 22
    //   11339: aload 25
    //   11341: aload 22
    //   11343: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11346: ldc_w 770
    //   11349: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11352: astore 22
    //   11354: aload_0
    //   11355: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11358: ifnull +202 -> 11560
    //   11361: aload_0
    //   11362: getfield 279	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11365: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11368: istore_3
    //   11369: aload 22
    //   11371: iload_3
    //   11372: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11375: ldc_w 772
    //   11378: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11381: aload_2
    //   11382: invokevirtual 553	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11385: getfield 775	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11388: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11391: ldc_w 777
    //   11394: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11397: lload 9
    //   11399: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11402: ldc_w 779
    //   11405: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11408: aload_0
    //   11409: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   11412: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11415: ldc 91
    //   11417: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11420: aload_0
    //   11421: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   11424: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11427: ldc_w 781
    //   11430: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11433: aload_0
    //   11434: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   11437: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11440: ldc 91
    //   11442: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11445: aload_0
    //   11446: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   11449: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11452: ldc_w 783
    //   11455: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11458: aload_0
    //   11459: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   11462: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11465: ldc_w 785
    //   11468: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11471: aload_0
    //   11472: getfield 788	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   11475: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11478: ldc_w 790
    //   11481: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11484: aload_0
    //   11485: invokevirtual 793	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   11488: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11491: ldc_w 795
    //   11494: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11497: astore 25
    //   11499: aload_0
    //   11500: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11503: ifnull +62 -> 11565
    //   11506: aload_0
    //   11507: getfield 799	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11510: invokeinterface 805 1 0
    //   11515: astore 22
    //   11517: ldc_w 613
    //   11520: aload 25
    //   11522: aload 22
    //   11524: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11527: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11530: aconst_null
    //   11531: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11534: goto -5834 -> 5700
    //   11537: ldc_w 1040
    //   11540: astore 26
    //   11542: goto -536 -> 11006
    //   11545: aconst_null
    //   11546: astore 25
    //   11548: goto -420 -> 11128
    //   11551: aload_0
    //   11552: getfield 603	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11555: astore 22
    //   11557: goto -218 -> 11339
    //   11560: iconst_0
    //   11561: istore_3
    //   11562: goto -193 -> 11369
    //   11565: aconst_null
    //   11566: astore 22
    //   11568: goto -51 -> 11517
    //   11571: astore 22
    //   11573: ldc 226
    //   11575: ldc_w 1047
    //   11578: aload 22
    //   11580: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11583: goto -5833 -> 5750
    //   11586: astore 22
    //   11588: ldc 226
    //   11590: ldc_w 1048
    //   11593: aload 22
    //   11595: invokestatic 1046	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11598: goto -5798 -> 5800
    //   11601: aload 27
    //   11603: invokevirtual 1051	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   11606: astore 22
    //   11608: goto -5760 -> 5848
    //   11611: aconst_null
    //   11612: astore 22
    //   11614: goto -5730 -> 5884
    //   11617: iconst_0
    //   11618: istore 21
    //   11620: goto -5561 -> 6059
    //   11623: aload_0
    //   11624: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11627: ifnull -5486 -> 6141
    //   11630: aload_0
    //   11631: getfield 589	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   11634: invokevirtual 1056	org/apache/http/client/methods/HttpGet:abort	()V
    //   11637: goto -5496 -> 6141
    //   11640: astore 23
    //   11642: aconst_null
    //   11643: astore 24
    //   11645: iload 6
    //   11647: istore 4
    //   11649: goto -6812 -> 4837
    //   11652: astore 23
    //   11654: aconst_null
    //   11655: astore 24
    //   11657: goto -6820 -> 4837
    //   11660: astore 23
    //   11662: iload 5
    //   11664: istore_3
    //   11665: goto -6828 -> 4837
    //   11668: astore 24
    //   11670: iload 7
    //   11672: istore 4
    //   11674: goto -11341 -> 333
    //   11677: astore 24
    //   11679: goto -11346 -> 333
    //   11682: astore 22
    //   11684: goto -11393 -> 291
    //   11687: iconst_0
    //   11688: istore 4
    //   11690: goto -8520 -> 3170
    //   11693: goto -11658 -> 35
    //   11696: ldc_w 509
    //   11699: astore 22
    //   11701: goto -6738 -> 4963
    //   11704: ldc_w 509
    //   11707: astore 22
    //   11709: goto -11174 -> 535
    //   11712: ldc_w 509
    //   11715: astore 22
    //   11717: goto -3604 -> 8113
    //   11720: ldc_w 509
    //   11723: astore 22
    //   11725: goto -8369 -> 3356
    //   11728: iconst_1
    //   11729: istore 4
    //   11731: goto -9738 -> 1993
    //   11734: aload 30
    //   11736: astore 25
    //   11738: iload 5
    //   11740: iconst_2
    //   11741: if_icmpge -7156 -> 4585
    //   11744: aload 30
    //   11746: astore 25
    //   11748: iload 21
    //   11750: ifeq -7165 -> 4585
    //   11753: ldc_w 1017
    //   11756: astore 25
    //   11758: goto -7173 -> 4585
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11761	0	this	StrictDownloadTask
    //   0	11761	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	11761	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   1	11664	3	i	int
    //   327	11403	4	j	int
    //   334	11408	5	k	int
    //   250	11396	6	m	int
    //   253	11418	7	n	int
    //   25	165	8	i1	int
    //   28	11370	9	l1	long
    //   298	9005	11	l2	long
    //   306	9005	13	l3	long
    //   33	60	15	l4	long
    //   176	7816	17	l5	long
    //   258	2806	19	l6	long
    //   268	11481	21	bool	boolean
    //   5	7062	22	localObject1	Object
    //   7098	1	22	localException1	java.lang.Exception
    //   7103	678	22	localObject2	Object
    //   7785	8	22	localException2	java.lang.Exception
    //   7800	8	22	localException3	java.lang.Exception
    //   7820	1493	22	localObject3	Object
    //   9346	1	22	localException4	java.lang.Exception
    //   9351	678	22	localObject4	Object
    //   10033	8	22	localException5	java.lang.Exception
    //   10048	8	22	localException6	java.lang.Exception
    //   10068	7	22	str1	String
    //   10118	1	22	localException7	java.lang.Exception
    //   10123	678	22	localObject5	Object
    //   10805	8	22	localException8	java.lang.Exception
    //   10820	8	22	localException9	java.lang.Exception
    //   10840	7	22	str2	String
    //   10885	1	22	localException10	java.lang.Exception
    //   10890	677	22	localObject6	Object
    //   11571	8	22	localException11	java.lang.Exception
    //   11586	8	22	localException12	java.lang.Exception
    //   11606	7	22	str3	String
    //   11682	1	22	localThrowable1	java.lang.Throwable
    //   11699	25	22	str4	String
    //   84	1	23	localException13	java.lang.Exception
    //   310	1	23	localObject7	Object
    //   315	15	23	localThrowable2	java.lang.Throwable
    //   513	9601	23	localObject8	Object
    //   11640	1	23	localObject9	Object
    //   11652	1	23	localObject10	Object
    //   11660	1	23	localObject11	Object
    //   302	11354	24	localObject12	Object
    //   11668	1	24	localThrowable3	java.lang.Throwable
    //   11677	1	24	localThrowable4	java.lang.Throwable
    //   486	4324	25	localObject13	Object
    //   4816	18	25	localObject14	Object
    //   4918	6839	25	localObject15	Object
    //   247	11294	26	localObject16	Object
    //   241	11361	27	localObject17	Object
    //   244	11053	28	localObject18	Object
    //   673	10334	29	localObject19	Object
    //   2198	9547	30	str5	String
    //   185	9075	31	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   1749	5241	32	localRequestOptions	com.tencent.component.network.utils.http.HttpUtil.RequestOptions
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
    //   2910	2915	315	java/lang/Throwable
    //   2931	2936	315	java/lang/Throwable
    //   2952	2959	315	java/lang/Throwable
    //   2975	2982	315	java/lang/Throwable
    //   2998	3005	315	java/lang/Throwable
    //   3021	3026	315	java/lang/Throwable
    //   3059	3069	315	java/lang/Throwable
    //   3085	3092	315	java/lang/Throwable
    //   3108	3115	315	java/lang/Throwable
    //   3131	3138	315	java/lang/Throwable
    //   3154	3170	315	java/lang/Throwable
    //   4570	4582	315	java/lang/Throwable
    //   4601	4612	315	java/lang/Throwable
    //   4628	4634	315	java/lang/Throwable
    //   4655	4667	315	java/lang/Throwable
    //   4687	4695	315	java/lang/Throwable
    //   4715	4749	315	java/lang/Throwable
    //   4769	4776	315	java/lang/Throwable
    //   4792	4809	315	java/lang/Throwable
    //   6160	6172	315	java/lang/Throwable
    //   6195	6202	315	java/lang/Throwable
    //   6222	6238	315	java/lang/Throwable
    //   6254	6260	315	java/lang/Throwable
    //   6281	6293	315	java/lang/Throwable
    //   6313	6321	315	java/lang/Throwable
    //   6341	6369	315	java/lang/Throwable
    //   6389	6396	315	java/lang/Throwable
    //   6412	6429	315	java/lang/Throwable
    //   6452	6464	315	java/lang/Throwable
    //   6483	6496	315	java/lang/Throwable
    //   6522	6539	315	java/lang/Throwable
    //   6555	6561	315	java/lang/Throwable
    //   6582	6594	315	java/lang/Throwable
    //   6614	6622	315	java/lang/Throwable
    //   6642	6677	315	java/lang/Throwable
    //   6693	6700	315	java/lang/Throwable
    //   6716	6733	315	java/lang/Throwable
    //   6749	6761	315	java/lang/Throwable
    //   6777	6783	315	java/lang/Throwable
    //   6799	6856	315	java/lang/Throwable
    //   6875	6887	315	java/lang/Throwable
    //   6906	6931	315	java/lang/Throwable
    //   6954	6961	315	java/lang/Throwable
    //   6977	6997	315	java/lang/Throwable
    //   7013	7024	315	java/lang/Throwable
    //   7047	7054	315	java/lang/Throwable
    //   7070	7079	315	java/lang/Throwable
    //   9316	9324	315	java/lang/Throwable
    //   312	315	4816	finally
    //   1740	1751	4816	finally
    //   1767	1776	4816	finally
    //   1792	1801	4816	finally
    //   1817	1824	4816	finally
    //   1840	1851	4816	finally
    //   1867	1874	4816	finally
    //   1890	1896	4816	finally
    //   1912	1916	4816	finally
    //   1932	1944	4816	finally
    //   1960	1967	4816	finally
    //   1983	1990	4816	finally
    //   2009	2015	4816	finally
    //   2031	2039	4816	finally
    //   2055	2068	4816	finally
    //   2084	2091	4816	finally
    //   2107	2114	4816	finally
    //   2130	2140	4816	finally
    //   2156	2172	4816	finally
    //   2188	2200	4816	finally
    //   2216	2222	4816	finally
    //   2238	2247	4816	finally
    //   2278	2284	4816	finally
    //   2305	2317	4816	finally
    //   2337	2345	4816	finally
    //   2365	2393	4816	finally
    //   2413	2420	4816	finally
    //   2436	2453	4816	finally
    //   2473	2485	4816	finally
    //   2501	2507	4816	finally
    //   2523	2591	4816	finally
    //   2607	2614	4816	finally
    //   2630	2642	4816	finally
    //   2658	2670	4816	finally
    //   2686	2693	4816	finally
    //   2709	2732	4816	finally
    //   2748	2755	4816	finally
    //   2771	2796	4816	finally
    //   2812	2832	4816	finally
    //   2848	2870	4816	finally
    //   2886	2894	4816	finally
    //   2910	2915	4816	finally
    //   2931	2936	4816	finally
    //   2952	2959	4816	finally
    //   2975	2982	4816	finally
    //   2998	3005	4816	finally
    //   3021	3026	4816	finally
    //   3059	3069	4816	finally
    //   3085	3092	4816	finally
    //   3108	3115	4816	finally
    //   3131	3138	4816	finally
    //   3154	3170	4816	finally
    //   4570	4582	4816	finally
    //   4601	4612	4816	finally
    //   4628	4634	4816	finally
    //   4655	4667	4816	finally
    //   4687	4695	4816	finally
    //   4715	4749	4816	finally
    //   4769	4776	4816	finally
    //   4792	4809	4816	finally
    //   6160	6172	4816	finally
    //   6195	6202	4816	finally
    //   6222	6238	4816	finally
    //   6254	6260	4816	finally
    //   6281	6293	4816	finally
    //   6313	6321	4816	finally
    //   6341	6369	4816	finally
    //   6389	6396	4816	finally
    //   6412	6429	4816	finally
    //   6452	6464	4816	finally
    //   6483	6496	4816	finally
    //   6522	6539	4816	finally
    //   6555	6561	4816	finally
    //   6582	6594	4816	finally
    //   6614	6622	4816	finally
    //   6642	6677	4816	finally
    //   6693	6700	4816	finally
    //   6716	6733	4816	finally
    //   6749	6761	4816	finally
    //   6777	6783	4816	finally
    //   6799	6856	4816	finally
    //   6875	6887	4816	finally
    //   6906	6931	4816	finally
    //   6954	6961	4816	finally
    //   6977	6997	4816	finally
    //   7013	7024	4816	finally
    //   7047	7054	4816	finally
    //   7070	7079	4816	finally
    //   9316	9324	4816	finally
    //   3341	3356	7098	java/lang/Exception
    //   4116	4143	7785	java/lang/Exception
    //   4166	4193	7800	java/lang/Exception
    //   8098	8113	9346	java/lang/Exception
    //   8873	8900	10033	java/lang/Exception
    //   8923	8950	10048	java/lang/Exception
    //   520	535	10118	java/lang/Exception
    //   1296	1323	10805	java/lang/Exception
    //   1346	1373	10820	java/lang/Exception
    //   4948	4963	10885	java/lang/Exception
    //   5723	5750	11571	java/lang/Exception
    //   5773	5800	11586	java/lang/Exception
    //   3026	3043	11640	finally
    //   3170	3179	11652	finally
    //   3199	3225	11652	finally
    //   7854	7894	11652	finally
    //   7902	7916	11652	finally
    //   7940	7945	11652	finally
    //   7945	7953	11652	finally
    //   7957	7978	11652	finally
    //   336	345	11660	finally
    //   351	358	11660	finally
    //   364	377	11660	finally
    //   380	385	11660	finally
    //   394	403	11660	finally
    //   3026	3043	11668	java/lang/Throwable
    //   3170	3179	11677	java/lang/Throwable
    //   3199	3225	11677	java/lang/Throwable
    //   7854	7894	11677	java/lang/Throwable
    //   7902	7916	11677	java/lang/Throwable
    //   7940	7945	11677	java/lang/Throwable
    //   7945	7953	11677	java/lang/Throwable
    //   7957	7978	11677	java/lang/Throwable
    //   260	270	11682	java/lang/Throwable
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