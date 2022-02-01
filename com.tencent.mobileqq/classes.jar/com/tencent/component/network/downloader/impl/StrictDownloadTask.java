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
    if (paramInt > 0)
    {
      if (paramInt > this.ISP_COUNT) {
        return;
      }
      this.triedIsp[(paramInt - 1)] = 1;
    }
  }
  
  private String generateDownloadDescInfo(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("1.1");
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(",");
    localStringBuilder.append(NetworkManager.getIspType());
    localStringBuilder.append(",");
    localStringBuilder.append(NetworkUtils.isNetworkAvailable(this.mContext));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
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
    int i = 0;
    while (i < this.ISP_COUNT)
    {
      int[] arrayOfInt = this.triedIsp;
      if (arrayOfInt[i] == 0)
      {
        arrayOfInt[i] = 1;
        return i + 1;
      }
      i += 1;
    }
    return 0;
  }
  
  private void printfHttpDetail(HttpRequest paramHttpRequest, Request.Builder paramBuilder, HttpResponse paramHttpResponse, Response paramResponse)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n/****************************************************/\n");
    localStringBuffer.append("<---------Request Content--------->\n");
    int k = 0;
    int j = 0;
    int i;
    if (paramHttpRequest != null)
    {
      localStringBuffer.append(paramHttpRequest.getRequestLine());
      localStringBuffer.append("\n");
      paramHttpRequest = paramHttpRequest.getAllHeaders();
      if (paramHttpRequest != null)
      {
        i = 0;
        while (i < paramHttpRequest.length)
        {
          localStringBuffer.append(paramHttpRequest[i].getName());
          localStringBuffer.append(": ");
          localStringBuffer.append(paramHttpRequest[i].getValue());
          localStringBuffer.append("\n");
          i += 1;
        }
      }
    }
    else if (paramBuilder != null)
    {
      localStringBuffer.append(paramBuilder.build().url());
      localStringBuffer.append("\n");
      paramHttpRequest = paramBuilder.build().headers();
      if (paramHttpRequest != null)
      {
        i = 0;
        while (i < paramHttpRequest.size())
        {
          localStringBuffer.append(paramHttpRequest.name(i));
          localStringBuffer.append(": ");
          localStringBuffer.append(paramHttpRequest.value(i));
          localStringBuffer.append("\n");
          i += 1;
        }
      }
    }
    localStringBuffer.append("<---------Response Headers--------->\n");
    if (paramHttpResponse != null)
    {
      localStringBuffer.append(paramHttpResponse.getStatusLine());
      localStringBuffer.append("\n");
      paramHttpRequest = paramHttpResponse.getAllHeaders();
      if (paramHttpRequest != null)
      {
        i = j;
        while (i < paramHttpRequest.length)
        {
          localStringBuffer.append(paramHttpRequest[i].getName());
          localStringBuffer.append(": ");
          localStringBuffer.append(paramHttpRequest[i].getValue());
          localStringBuffer.append("\n");
          i += 1;
        }
      }
    }
    else if (paramResponse != null)
    {
      localStringBuffer.append(paramResponse.code());
      localStringBuffer.append("\n");
      paramHttpRequest = paramResponse.headers();
      if (paramHttpRequest != null)
      {
        i = k;
        while (i < paramHttpRequest.size())
        {
          localStringBuffer.append(paramHttpRequest.name(i));
          localStringBuffer.append(": ");
          localStringBuffer.append(paramHttpRequest.value(i));
          localStringBuffer.append("\n");
          i += 1;
        }
      }
    }
    localStringBuffer.append("/****************************************************/");
    paramHttpRequest = new StringBuilder();
    paramHttpRequest.append("Http Details:");
    paramHttpRequest.append(localStringBuffer.toString());
    QDLog.w("downloader", paramHttpRequest.toString());
  }
  
  private boolean setStrategy(int paramInt)
  {
    if (this.pDownloadStrategyLib == null)
    {
      this.pDownloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(getUrl(), getDomain(), this.mIsHttp2);
      initExtraStrategy();
      this.pDownloadStrategyLib.copyStrageList();
      this.pDownloadStrategyLib.enableUpdate(false);
      this.pDownloadStrategyLib.addStrategy(extraStrategys);
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
      this.mAttemptCurrCount = 0;
    }
    int i = j;
    if (this.mIsHttp2) {
      i = 443;
    }
    this.mStandardPort = i;
    this.pDownloadStrategyLib.setPort(this.mStandardPort);
    if (QDLog.isInfoEnable())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloader strategy: ");
      ((StringBuilder)localObject1).append(this.pCurrStrategyInfo.toString());
      ((StringBuilder)localObject1).append(" currAttempCount:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" attemptStrategyCount:");
      ((StringBuilder)localObject1).append(this.attemptStrategyCount);
      ((StringBuilder)localObject1).append(" best:");
      ((StringBuilder)localObject1).append(this.pDownloadStrategyLib.getBestId());
      ((StringBuilder)localObject1).append(" url:");
      ((StringBuilder)localObject1).append(getUrl());
      ((StringBuilder)localObject1).append(" Apn:");
      ((StringBuilder)localObject1).append(NetworkManager.getApnValue());
      ((StringBuilder)localObject1).append(" ISP:");
      ((StringBuilder)localObject1).append(NetworkManager.getIspType());
      ((StringBuilder)localObject1).append(" threadid:");
      ((StringBuilder)localObject1).append(Thread.currentThread().getId());
      QDLog.i("downloader_strategy", ((StringBuilder)localObject1).toString());
    }
    this.mAllowProxy = this.pCurrStrategyInfo.allowProxy;
    this.mAPNProxy = this.pCurrStrategyInfo.useConfigApn;
    String str = getDomain();
    i = this.pDownloadStrategyLib.getPort();
    paramInt = i;
    if (!Utils.isPortValid(i))
    {
      this.pDownloadStrategyLib.setPort(this.mStandardPort);
      paramInt = this.mStandardPort;
    }
    i = DownloadGlobalStrategy.Strategy_BACKUPIP.id;
    j = this.pCurrStrategyInfo.id;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (i == j)
    {
      i = paramInt;
      if (this.pOldStrategyInfo != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.pOldStrategyInfo.id)
        {
          i = paramInt;
          if (!this.mIsHttp2) {
            if ((this.pPortConfigStrategy != null) && (this.pPortConfigStrategy.supportExtraPort(str)))
            {
              i = this.pPortConfigStrategy.changePort(str, paramInt);
              if ((i != paramInt) && (Utils.isPortValid(i))) {
                break label774;
              }
              if (QDLog.isInfoEnable())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("downloader strategy: Pass! port:");
                ((StringBuilder)localObject1).append(paramInt);
                ((StringBuilder)localObject1).append(" newport:");
                ((StringBuilder)localObject1).append(i);
                ((StringBuilder)localObject1).append(" threadId:");
                ((StringBuilder)localObject1).append(Thread.currentThread().getId());
                QDLog.i("downloader", ((StringBuilder)localObject1).toString());
              }
              return false;
            }
            else
            {
              if (QDLog.isInfoEnable())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("downloader strategy: Pass! Not support !");
                ((StringBuilder)localObject1).append(this.mStandardPort);
                ((StringBuilder)localObject1).append(". threadId:");
                ((StringBuilder)localObject1).append(Thread.currentThread().getId());
                QDLog.i("downloader", ((StringBuilder)localObject1).toString());
              }
              return false;
            }
          }
        }
      }
      label774:
      localObject2 = this.pDownloadStrategyLib.getBackupIP();
      localObject1 = localObject2;
      if (this.pBackupIPConfigStrategy != null)
      {
        localObject1 = localObject2;
        if (!this.pBackupIPConfigStrategy.isIPValid(str, (String)localObject2))
        {
          this.pDownloadStrategyLib.setBackupIP(null);
          localObject1 = this.pBackupIPConfigStrategy.resolveIP(str);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.pDownloadStrategyLib.setBackupIP((String)localObject1);
          }
          else
          {
            if (QDLog.isInfoEnable())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("downloader strategy: backup ip is null. Pass! threadId:");
              ((StringBuilder)localObject1).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject1).toString());
            }
            return false;
          }
        }
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
    }
    else if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pCurrStrategyInfo.id)
    {
      i = paramInt;
      if (this.pOldStrategyInfo != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pOldStrategyInfo.id)
        {
          i = paramInt;
          if (!this.mIsHttp2) {
            if ((this.pPortConfigStrategy != null) && (this.pPortConfigStrategy.supportExtraPort(str)))
            {
              i = this.pPortConfigStrategy.changePort(str, paramInt);
              if ((i != paramInt) && (Utils.isPortValid(i))) {
                break label1181;
              }
              if (QDLog.isInfoEnable())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("downloader strategy: Pass! port:");
                ((StringBuilder)localObject1).append(paramInt);
                ((StringBuilder)localObject1).append(" newport:");
                ((StringBuilder)localObject1).append(i);
                ((StringBuilder)localObject1).append(" threadId:");
                ((StringBuilder)localObject1).append(Thread.currentThread().getId());
                QDLog.i("downloader", ((StringBuilder)localObject1).toString());
              }
              return false;
            }
            else
            {
              if (QDLog.isInfoEnable())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("downloader strategy: Pass! Not support !");
                ((StringBuilder)localObject1).append(this.mStandardPort);
                ((StringBuilder)localObject1).append(". threadId:");
                ((StringBuilder)localObject1).append(Thread.currentThread().getId());
                QDLog.i("downloader", ((StringBuilder)localObject1).toString());
              }
              return false;
            }
          }
        }
      }
      label1181:
      localObject2 = DnsService.getInstance().getDomainIP(str);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = DnsService.getInstance().getDomainIP(str);
      }
      if ((localObject1 != null) && (!((String)localObject1).equals(this.pDownloadStrategyLib.getBackupIP())) && (!((String)localObject1).equals(this.pDownloadStrategyLib.getDirectIP())))
      {
        this.pDownloadStrategyLib.setDnsIP((String)localObject1);
        this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
        this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
      }
      else
      {
        this.pDownloadStrategyLib.setDnsIP(null);
        if (QDLog.isInfoEnable())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloader strategy: Pass! Domain IP 重复. threadId:");
          ((StringBuilder)localObject1).append(Thread.currentThread().getId());
          QDLog.i("downloader", ((StringBuilder)localObject1).toString());
        }
        return false;
      }
    }
    else if (6 == this.pCurrStrategyInfo.id)
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
        if (QDLog.isInfoEnable())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloader strategy: direct ip is null. Pass! 6 threadId:");
          ((StringBuilder)localObject1).append(Thread.currentThread().getId());
          QDLog.i("downloader", ((StringBuilder)localObject1).toString());
        }
        return false;
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, this.mStandardPort));
    }
    else if (7 == this.pCurrStrategyInfo.id)
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
        if (QDLog.isInfoEnable())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloader strategy: backup ip is null. Pass! 7 threadId:");
          ((StringBuilder)localObject1).append(Thread.currentThread().getId());
          QDLog.i("downloader", ((StringBuilder)localObject1).toString());
        }
        return false;
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, this.mStandardPort));
    }
    else if (8 == this.pCurrStrategyInfo.id)
    {
      localObject1 = localObject3;
      do
      {
        paramInt = obtainUntriedIsp();
        if (paramInt == 0) {
          break;
        }
        localObject2 = localObject1;
        if (this.pDirectIPConfigStrategy != null) {
          localObject2 = this.pDirectIPConfigStrategy.resolveIP(str, paramInt);
        }
        localObject1 = localObject2;
      } while (TextUtils.isEmpty((CharSequence)localObject2));
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = DnsService.getInstance().getDomainIP(str);
      }
      if (localObject2 == null)
      {
        if (QDLog.isInfoEnable())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloader strategy:  ip is null. Pass! 8 threadId:");
          ((StringBuilder)localObject1).append(Thread.currentThread().getId());
          QDLog.i("downloader", ((StringBuilder)localObject1).toString());
        }
        return false;
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject2, this.mStandardPort));
    }
    else if (9 == this.pCurrStrategyInfo.id)
    {
      localObject1 = localObject4;
      do
      {
        paramInt = obtainUntriedIsp();
        if (paramInt == 0) {
          break;
        }
        localObject2 = localObject1;
        if (this.pDirectIPConfigStrategy != null) {
          localObject2 = this.pDirectIPConfigStrategy.resolveIP(str, paramInt);
        }
        localObject1 = localObject2;
      } while (TextUtils.isEmpty((CharSequence)localObject2));
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = DnsService.getInstance().getDomainIP(str);
      }
      if (localObject2 == null)
      {
        if (QDLog.isInfoEnable())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloader strategy:  ip is null. Pass! 9 threadId:");
          ((StringBuilder)localObject1).append(Thread.currentThread().getId());
          QDLog.i("downloader", ((StringBuilder)localObject1).toString());
        }
        return false;
      }
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
            if (!this.mIsHttp2) {
              if ((this.pPortConfigStrategy != null) && (this.pPortConfigStrategy.supportExtraPort(str)))
              {
                i = this.pPortConfigStrategy.changePort(str, paramInt);
                if ((i != paramInt) && (Utils.isPortValid(i))) {
                  break label2267;
                }
                if (QDLog.isInfoEnable())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("downloader strategy: Pass! port:");
                  ((StringBuilder)localObject1).append(paramInt);
                  ((StringBuilder)localObject1).append(" newport:");
                  ((StringBuilder)localObject1).append(i);
                  ((StringBuilder)localObject1).append(" threadId:");
                  ((StringBuilder)localObject1).append(Thread.currentThread().getId());
                  QDLog.i("downloader", ((StringBuilder)localObject1).toString());
                }
                return false;
              }
              else
              {
                if (QDLog.isInfoEnable())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("downloader strategy: Pass! Not support !");
                  ((StringBuilder)localObject1).append(this.mStandardPort);
                  ((StringBuilder)localObject1).append(". threadId:");
                  ((StringBuilder)localObject1).append(Thread.currentThread().getId());
                  QDLog.i("downloader", ((StringBuilder)localObject1).toString());
                }
                return false;
              }
            }
          }
        }
      }
      else
      {
        if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.pCurrStrategyInfo.id) {
          break label2519;
        }
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.pCurrStrategyInfo.id) {
          break label2519;
        }
      }
      label2267:
      localObject2 = this.pDownloadStrategyLib.getDirectIP();
      localObject1 = localObject2;
      if (this.pDirectIPConfigStrategy != null)
      {
        localObject1 = localObject2;
        if (!this.pDirectIPConfigStrategy.isIPValid((String)localObject2, str))
        {
          this.pDownloadStrategyLib.setDirectIP(null);
          localObject1 = this.pDirectIPConfigStrategy.resolveIP(str);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.pDownloadStrategyLib.setDirectIP((String)localObject1);
          }
          else
          {
            if (QDLog.isInfoEnable())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("downloader strategy: direct ip is null. Pass! threadId:");
              ((StringBuilder)localObject1).append(Thread.currentThread().getId());
              QDLog.i("downloader", ((StringBuilder)localObject1).toString());
            }
            return false;
          }
        }
      }
      if ((localObject1 == null) || (((String)localObject1).equals(this.pDownloadStrategyLib.getBackupIP())) || (((String)localObject1).equals(this.pDownloadStrategyLib.getDnsIP()))) {
        break label2471;
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
    }
    addTriedIsp(NetworkManager.getIspType());
    return true;
    label2471:
    if (QDLog.isInfoEnable())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloader strategy: Pass! Direct IP 重复. threadId:");
      ((StringBuilder)localObject1).append(Thread.currentThread().getId());
      QDLog.i("downloader", ((StringBuilder)localObject1).toString());
    }
    return false;
    label2519:
    localObject1 = this.mContext;
    if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.pCurrStrategyInfo.id) {
      bool = true;
    } else {
      bool = false;
    }
    if (NetworkUtils.getProxy((Context)localObject1, bool) == null)
    {
      if (QDLog.isInfoEnable())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downloader strategy: proxy is null. Pass! threadId:");
        ((StringBuilder)localObject1).append(Thread.currentThread().getId());
        QDLog.i("downloader", ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    paramInt = this.mStandardPort;
    return true;
  }
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 24
    //   3: aload_2
    //   4: astore 23
    //   6: ldc_w 510
    //   9: astore 28
    //   11: iconst_2
    //   12: anewarray 37	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload 23
    //   26: aastore
    //   27: invokestatic 516	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   30: istore 6
    //   32: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   35: lstore 12
    //   37: ldc_w 510
    //   40: astore 22
    //   42: lconst_0
    //   43: lstore 8
    //   45: iconst_0
    //   46: istore_3
    //   47: aload_1
    //   48: invokeinterface 521 1 0
    //   53: ifeq +13 -> 66
    //   56: aload_0
    //   57: aload 24
    //   59: aload 23
    //   61: aconst_null
    //   62: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   65: return
    //   66: aload_0
    //   67: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   70: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   73: ifne +28 -> 101
    //   76: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   79: lload 12
    //   81: lsub
    //   82: ldc2_w 526
    //   85: lcmp
    //   86: ifgt +15 -> 101
    //   89: ldc2_w 528
    //   92: invokestatic 533	java/lang/Thread:sleep	(J)V
    //   95: goto -29 -> 66
    //   98: goto -32 -> 66
    //   101: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   104: lload 12
    //   106: lsub
    //   107: ldc2_w 526
    //   110: lcmp
    //   111: ifle +13 -> 124
    //   114: ldc 230
    //   116: astore 25
    //   118: aload 22
    //   120: astore_1
    //   121: goto +10519 -> 10640
    //   124: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   127: lstore 14
    //   129: new 535	com/tencent/component/network/downloader/DownloadReport
    //   132: dup
    //   133: invokespecial 536	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   136: astore 27
    //   138: aload 27
    //   140: iload 6
    //   142: putfield 537	com/tencent/component/network/downloader/DownloadReport:id	I
    //   145: aload 27
    //   147: aload_0
    //   148: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   151: putfield 539	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   154: aload 27
    //   156: aload_0
    //   157: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   160: putfield 542	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   163: aload 27
    //   165: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   168: putfield 550	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   186: aload_0
    //   187: aconst_null
    //   188: putfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   191: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   194: lstore 10
    //   196: aload_0
    //   197: aload_0
    //   198: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   201: invokespecial 560	com/tencent/component/network/downloader/impl/StrictDownloadTask:setStrategy	(I)Z
    //   204: istore 20
    //   206: iload 20
    //   208: ifne +10 -> 218
    //   211: ldc 230
    //   213: astore 25
    //   215: goto +10415 -> 10630
    //   218: aconst_null
    //   219: astore 22
    //   221: goto +5 -> 226
    //   224: astore 22
    //   226: ldc_w 562
    //   229: astore 25
    //   231: ldc_w 564
    //   234: astore 30
    //   236: aload 22
    //   238: ifnonnull +7584 -> 7822
    //   241: getstatic 568	com/tencent/component/network/downloader/impl/StrictDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   244: invokevirtual 574	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   247: checkcast 576	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   250: astore 26
    //   252: aload 26
    //   254: aload_0
    //   255: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   258: putfield 577	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   261: aload 26
    //   263: aload_0
    //   264: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   267: putfield 580	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   270: aload_0
    //   271: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   274: astore 22
    //   276: aload 22
    //   278: ifnull +79 -> 357
    //   281: aload_0
    //   282: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   285: invokeinterface 590 1 0
    //   290: astore 22
    //   292: goto +68 -> 360
    //   295: astore 23
    //   297: ldc_w 562
    //   300: astore 29
    //   302: ldc 230
    //   304: astore 26
    //   306: iload_3
    //   307: istore 4
    //   309: ldc 91
    //   311: astore 22
    //   313: iconst_0
    //   314: istore_3
    //   315: aconst_null
    //   316: astore 25
    //   318: aload 27
    //   320: astore 24
    //   322: aconst_null
    //   323: astore 28
    //   325: aload 29
    //   327: astore 27
    //   329: goto +10425 -> 10754
    //   332: astore 22
    //   334: ldc 230
    //   336: astore 23
    //   338: ldc 91
    //   340: astore 24
    //   342: iconst_0
    //   343: istore 5
    //   345: aconst_null
    //   346: astore 26
    //   348: iload_3
    //   349: istore 4
    //   351: iload 5
    //   353: istore_3
    //   354: goto +7532 -> 7886
    //   357: aconst_null
    //   358: astore 22
    //   360: aload 26
    //   362: aload 22
    //   364: putfield 594	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   367: aload 27
    //   369: iload_3
    //   370: putfield 597	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   373: aload_2
    //   374: invokevirtual 602	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   377: aload_0
    //   378: aload_0
    //   379: aload_0
    //   380: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   383: invokevirtual 605	com/tencent/component/network/downloader/impl/StrictDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   386: putfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   389: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   392: istore 4
    //   394: iload 4
    //   396: iconst_2
    //   397: if_icmpeq +94 -> 491
    //   400: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   403: istore 4
    //   405: iload 4
    //   407: iconst_3
    //   408: if_icmpne +6 -> 414
    //   411: goto +80 -> 491
    //   414: iconst_0
    //   415: istore 4
    //   417: goto +77 -> 494
    //   420: astore 22
    //   422: iload_3
    //   423: istore 4
    //   425: ldc 230
    //   427: astore 26
    //   429: ldc_w 562
    //   432: astore 29
    //   434: ldc 91
    //   436: astore 31
    //   438: aconst_null
    //   439: astore 28
    //   441: iconst_0
    //   442: istore_3
    //   443: aconst_null
    //   444: astore 25
    //   446: aload 22
    //   448: astore 23
    //   450: aload 27
    //   452: astore 24
    //   454: aload 31
    //   456: astore 22
    //   458: aload 29
    //   460: astore 27
    //   462: goto +10292 -> 10754
    //   465: astore 22
    //   467: iload_3
    //   468: istore 4
    //   470: iconst_0
    //   471: istore_3
    //   472: ldc 230
    //   474: astore 23
    //   476: ldc 91
    //   478: astore 24
    //   480: ldc_w 562
    //   483: astore 25
    //   485: aconst_null
    //   486: astore 26
    //   488: goto +7398 -> 7886
    //   491: iconst_1
    //   492: istore 4
    //   494: aload_0
    //   495: invokevirtual 615	com/tencent/component/network/downloader/impl/StrictDownloadTask:enableIpv6Debug	()Z
    //   498: istore 20
    //   500: aload 26
    //   502: getfield 594	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   505: astore 22
    //   507: aload 22
    //   509: ifnonnull +671 -> 1180
    //   512: aload_0
    //   513: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   516: astore 22
    //   518: aload 22
    //   520: ldc_w 617
    //   523: invokevirtual 620	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   526: ifeq +10 -> 536
    //   529: aload_0
    //   530: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   533: ifeq +647 -> 1180
    //   536: aload_0
    //   537: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   540: ifnull +640 -> 1180
    //   543: aload_0
    //   544: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   547: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   550: ifnull +630 -> 1180
    //   553: aload_0
    //   554: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   557: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   560: getfield 627	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   563: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   566: ifne +614 -> 1180
    //   569: aload_0
    //   570: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   573: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   576: getfield 627	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   579: astore 23
    //   581: aload_0
    //   582: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   585: astore 24
    //   587: aload 23
    //   589: bipush 58
    //   591: invokestatic 631	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   594: istore 5
    //   596: iload 4
    //   598: ifne +12743 -> 13341
    //   601: iload 5
    //   603: iconst_2
    //   604: if_icmpge +12764 -> 13368
    //   607: aload_0
    //   608: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   611: istore 4
    //   613: iload 4
    //   615: ifle +18 -> 633
    //   618: aload_0
    //   619: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   622: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   625: iload 4
    //   627: putfield 634	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   630: goto +15 -> 645
    //   633: aload_0
    //   634: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   637: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   640: getfield 634	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   643: istore 4
    //   645: iload 4
    //   647: istore 5
    //   649: iload 4
    //   651: invokestatic 366	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   654: ifne +7 -> 661
    //   657: bipush 80
    //   659: istore 5
    //   661: new 80	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   668: astore 22
    //   670: aload 22
    //   672: aload 23
    //   674: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload 22
    //   680: ldc_w 636
    //   683: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 22
    //   689: iload 5
    //   691: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload 22
    //   697: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: astore 23
    //   702: aload 23
    //   704: astore 22
    //   706: aload_0
    //   707: getfield 638	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   710: ifnull +330 -> 1040
    //   713: aload_0
    //   714: aload_0
    //   715: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   718: aload_0
    //   719: getfield 638	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   722: aload 23
    //   724: invokevirtual 642	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   727: putfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   730: aload 23
    //   732: astore 22
    //   734: goto +306 -> 1040
    //   737: aload 22
    //   739: bipush 58
    //   741: invokestatic 631	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   744: iconst_2
    //   745: if_icmplt +142 -> 887
    //   748: aload_0
    //   749: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   752: istore 4
    //   754: iload 4
    //   756: ifle +18 -> 774
    //   759: aload_0
    //   760: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   763: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   766: iload 4
    //   768: putfield 634	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   771: goto +15 -> 786
    //   774: aload_0
    //   775: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   778: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   781: getfield 634	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   784: istore 4
    //   786: iload 4
    //   788: istore 5
    //   790: iload 4
    //   792: invokestatic 366	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   795: ifne +7 -> 802
    //   798: bipush 80
    //   800: istore 5
    //   802: new 80	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   809: astore 23
    //   811: aload 23
    //   813: ldc_w 644
    //   816: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 23
    //   822: aload 22
    //   824: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: aload 23
    //   830: ldc_w 646
    //   833: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: aload 23
    //   839: iload 5
    //   841: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 23
    //   847: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: astore 23
    //   852: aload 23
    //   854: astore 22
    //   856: aload_0
    //   857: getfield 638	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   860: ifnull +180 -> 1040
    //   863: aload_0
    //   864: aload_0
    //   865: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   868: aload_0
    //   869: getfield 638	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   872: aload 23
    //   874: invokevirtual 642	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   877: putfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   880: aload 23
    //   882: astore 22
    //   884: goto +156 -> 1040
    //   887: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   890: iconst_3
    //   891: if_icmpne +12477 -> 13368
    //   894: aload_0
    //   895: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   898: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   901: getstatic 438	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   904: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   907: if_icmpeq +12461 -> 13368
    //   910: aload_0
    //   911: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   914: istore 4
    //   916: iload 4
    //   918: ifle +18 -> 936
    //   921: aload_0
    //   922: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   925: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   928: iload 4
    //   930: putfield 634	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   933: goto +15 -> 948
    //   936: aload_0
    //   937: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   940: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   943: getfield 634	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   946: istore 4
    //   948: iload 4
    //   950: istore 5
    //   952: iload 4
    //   954: invokestatic 366	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   957: ifne +7 -> 964
    //   960: bipush 80
    //   962: istore 5
    //   964: new 80	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   971: astore 23
    //   973: aload 23
    //   975: aload 22
    //   977: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: aload 23
    //   983: ldc_w 636
    //   986: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload 23
    //   992: iload 5
    //   994: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: aload 23
    //   1000: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1003: astore 23
    //   1005: aload 23
    //   1007: astore 22
    //   1009: aload_0
    //   1010: getfield 638	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   1013: ifnull +27 -> 1040
    //   1016: aload_0
    //   1017: aload_0
    //   1018: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1021: aload_0
    //   1022: getfield 638	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   1025: aload 23
    //   1027: invokevirtual 642	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1030: putfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1033: aload 23
    //   1035: astore 22
    //   1037: goto +3 -> 1040
    //   1040: aload 27
    //   1042: aload_0
    //   1043: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1046: invokevirtual 311	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1049: putfield 649	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1052: invokestatic 652	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   1055: ifeq +402 -> 1457
    //   1058: new 80	java/lang/StringBuilder
    //   1061: dup
    //   1062: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1065: astore 23
    //   1067: aload 23
    //   1069: ldc_w 654
    //   1072: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 23
    //   1078: aload 27
    //   1080: getfield 649	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1083: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 23
    //   1089: ldc_w 656
    //   1092: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload 23
    //   1098: aload 22
    //   1100: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: aload 23
    //   1106: ldc_w 322
    //   1109: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: aload 23
    //   1115: aload_0
    //   1116: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1119: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: pop
    //   1123: aload 23
    //   1125: ldc_w 389
    //   1128: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload 23
    //   1134: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1137: invokevirtual 340	java/lang/Thread:getId	()J
    //   1140: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1143: pop
    //   1144: ldc 230
    //   1146: aload 23
    //   1148: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: invokestatic 659	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1154: goto +303 -> 1457
    //   1157: astore 22
    //   1159: goto +13 -> 1172
    //   1162: astore 22
    //   1164: iload_3
    //   1165: istore 4
    //   1167: goto -697 -> 470
    //   1170: astore 22
    //   1172: goto -750 -> 422
    //   1175: astore 22
    //   1177: goto -710 -> 467
    //   1180: aload_0
    //   1181: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1184: astore 22
    //   1186: aload 22
    //   1188: ifnull +269 -> 1457
    //   1191: aload_0
    //   1192: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1195: ldc_w 617
    //   1198: invokevirtual 620	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1201: ifeq +256 -> 1457
    //   1204: iload 4
    //   1206: ifeq +251 -> 1457
    //   1209: iload 20
    //   1211: ifeq +246 -> 1457
    //   1214: aload_0
    //   1215: aload_0
    //   1216: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1219: ldc_w 661
    //   1222: ldc_w 663
    //   1225: invokevirtual 642	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1228: putfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1231: aload_0
    //   1232: getfield 48	com/tencent/component/network/downloader/impl/StrictDownloadTask:mOrigPort	I
    //   1235: istore 4
    //   1237: iload 4
    //   1239: ifle +18 -> 1257
    //   1242: aload_0
    //   1243: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1246: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1249: iload 4
    //   1251: putfield 634	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   1254: goto +15 -> 1269
    //   1257: aload_0
    //   1258: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1261: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1264: getfield 634	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   1267: istore 4
    //   1269: iload 4
    //   1271: istore 5
    //   1273: iload 4
    //   1275: invokestatic 366	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   1278: ifne +7 -> 1285
    //   1281: bipush 80
    //   1283: istore 5
    //   1285: new 80	java/lang/StringBuilder
    //   1288: dup
    //   1289: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1292: astore 22
    //   1294: aload 22
    //   1296: ldc_w 644
    //   1299: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: aload 22
    //   1305: ldc_w 665
    //   1308: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: pop
    //   1312: aload 22
    //   1314: ldc_w 646
    //   1317: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload 22
    //   1323: iload 5
    //   1325: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1328: pop
    //   1329: aload 22
    //   1331: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1334: astore 22
    //   1336: aload_0
    //   1337: getfield 638	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   1340: ifnull +20 -> 1360
    //   1343: aload_0
    //   1344: aload_0
    //   1345: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1348: aload_0
    //   1349: getfield 638	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   1352: aload 22
    //   1354: invokevirtual 642	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1357: putfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1360: aload 27
    //   1362: aload_0
    //   1363: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1366: invokevirtual 311	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1369: putfield 649	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1372: invokestatic 652	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   1375: ifeq +82 -> 1457
    //   1378: new 80	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1385: astore 22
    //   1387: aload 22
    //   1389: ldc_w 654
    //   1392: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: aload 22
    //   1398: aload 27
    //   1400: getfield 649	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1403: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: pop
    //   1407: aload 22
    //   1409: ldc_w 667
    //   1412: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: pop
    //   1416: aload 22
    //   1418: aload_0
    //   1419: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1422: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: aload 22
    //   1428: ldc_w 389
    //   1431: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: aload 22
    //   1437: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1440: invokevirtual 340	java/lang/Thread:getId	()J
    //   1443: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1446: pop
    //   1447: ldc 230
    //   1449: aload 22
    //   1451: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1454: invokestatic 659	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1457: iload_3
    //   1458: istore 5
    //   1460: aload_0
    //   1461: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1464: astore 22
    //   1466: aload 22
    //   1468: ifnull +27 -> 1495
    //   1471: aload 27
    //   1473: aload_0
    //   1474: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1477: invokevirtual 311	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1480: putfield 649	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1483: aload 27
    //   1485: aload_0
    //   1486: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1489: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1492: putfield 670	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   1495: aload_0
    //   1496: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   1499: istore 20
    //   1501: iload 20
    //   1503: ifeq +29 -> 1532
    //   1506: aload_0
    //   1507: aload_0
    //   1508: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   1511: aload_0
    //   1512: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1515: aload_0
    //   1516: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1519: aload_0
    //   1520: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1523: invokestatic 676	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   1526: putfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1529: goto +28 -> 1557
    //   1532: aload_0
    //   1533: aload_0
    //   1534: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   1537: aload_0
    //   1538: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1541: aload_0
    //   1542: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1545: aload_0
    //   1546: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   1549: aload 26
    //   1551: invokestatic 680	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   1554: putfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1557: aload_0
    //   1558: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1561: astore 22
    //   1563: aload 22
    //   1565: ifnull +31 -> 1596
    //   1568: aload_0
    //   1569: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1572: aload_0
    //   1573: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1576: aload_0
    //   1577: getfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1580: aload_0
    //   1581: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1584: aload_0
    //   1585: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1588: invokeinterface 690 5 0
    //   1593: goto +3 -> 1596
    //   1596: aload_0
    //   1597: aload_0
    //   1598: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1601: aload_0
    //   1602: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1605: aload_0
    //   1606: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1609: aload_0
    //   1610: getfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1613: invokevirtual 693	com/tencent/component/network/downloader/impl/StrictDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   1616: aload_0
    //   1617: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   1620: astore 22
    //   1622: aload_0
    //   1623: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   1626: astore 23
    //   1628: aload_0
    //   1629: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1632: astore 25
    //   1634: aload_0
    //   1635: getfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1638: astore 33
    //   1640: ldc 91
    //   1642: astore 24
    //   1644: lload 14
    //   1646: lstore 16
    //   1648: aload 27
    //   1650: astore 31
    //   1652: ldc_w 695
    //   1655: astore 32
    //   1657: ldc 230
    //   1659: astore 29
    //   1661: iload 5
    //   1663: istore_3
    //   1664: aload_0
    //   1665: aload 22
    //   1667: aload 23
    //   1669: aload 25
    //   1671: aload 33
    //   1673: aload 26
    //   1675: invokevirtual 699	com/tencent/component/network/downloader/impl/StrictDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   1678: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   1681: lstore 18
    //   1683: lload 18
    //   1685: lload 10
    //   1687: lsub
    //   1688: lstore 8
    //   1690: aload_0
    //   1691: lconst_0
    //   1692: putfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   1695: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   1698: lstore 18
    //   1700: aload_0
    //   1701: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1704: astore 22
    //   1706: aload 22
    //   1708: ifnull +162 -> 1870
    //   1711: aload_0
    //   1712: getfield 703	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   1715: astore 22
    //   1717: aload 22
    //   1719: ifnonnull +51 -> 1770
    //   1722: aload_0
    //   1723: invokestatic 707	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   1726: putfield 703	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   1729: goto +41 -> 1770
    //   1732: astore 23
    //   1734: iload_3
    //   1735: istore 4
    //   1737: aload 24
    //   1739: astore 22
    //   1741: ldc_w 562
    //   1744: astore 27
    //   1746: aconst_null
    //   1747: astore 28
    //   1749: iconst_0
    //   1750: istore_3
    //   1751: aconst_null
    //   1752: astore 25
    //   1754: aload 31
    //   1756: astore 24
    //   1758: aload 29
    //   1760: astore 26
    //   1762: goto +8992 -> 10754
    //   1765: astore 22
    //   1767: goto +100 -> 1867
    //   1770: invokestatic 711	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   1773: astore 22
    //   1775: aload_0
    //   1776: getfield 703	com/tencent/component/network/downloader/impl/StrictDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   1779: astore 23
    //   1781: aload_0
    //   1782: aload 23
    //   1784: aload_0
    //   1785: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   1788: aload 22
    //   1790: invokevirtual 716	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   1793: putfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   1796: goto +136 -> 1932
    //   1799: astore 23
    //   1801: goto +10 -> 1811
    //   1804: astore 23
    //   1806: goto +14 -> 1820
    //   1809: astore 23
    //   1811: aload 23
    //   1813: astore 24
    //   1815: goto +21 -> 1836
    //   1818: astore 23
    //   1820: aload 22
    //   1822: astore 26
    //   1824: aload 23
    //   1826: astore 22
    //   1828: goto +5850 -> 7678
    //   1831: astore 24
    //   1833: aconst_null
    //   1834: astore 22
    //   1836: iconst_0
    //   1837: istore_3
    //   1838: aload 22
    //   1840: astore 28
    //   1842: iload 5
    //   1844: istore 4
    //   1846: ldc_w 562
    //   1849: astore 27
    //   1851: ldc 91
    //   1853: astore 22
    //   1855: aconst_null
    //   1856: astore 25
    //   1858: aload 29
    //   1860: astore 23
    //   1862: goto +8876 -> 10738
    //   1865: astore 22
    //   1867: goto +5998 -> 7865
    //   1870: lload 8
    //   1872: lstore 10
    //   1874: aload_0
    //   1875: getfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1878: astore 22
    //   1880: aload 22
    //   1882: ifnull +47 -> 1929
    //   1885: aload_0
    //   1886: aload_0
    //   1887: getfield 720	com/tencent/component/network/downloader/impl/StrictDownloadTask:pokHttpClient	Lokhttp3/OkHttpClient;
    //   1890: aload_0
    //   1891: getfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1894: invokevirtual 183	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   1897: invokevirtual 726	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   1900: putfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1903: aload_0
    //   1904: aload_0
    //   1905: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1908: invokeinterface 735 1 0
    //   1913: putfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   1916: goto +13 -> 1929
    //   1919: astore 24
    //   1921: goto -88 -> 1833
    //   1924: astore 22
    //   1926: goto -59 -> 1867
    //   1929: aconst_null
    //   1930: astore 22
    //   1932: lload 8
    //   1934: lstore 10
    //   1936: aload_0
    //   1937: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   1940: lload 18
    //   1942: lsub
    //   1943: putfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   1946: aload_0
    //   1947: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   1950: astore 23
    //   1952: aload 23
    //   1954: ifnonnull +49 -> 2003
    //   1957: aload_0
    //   1958: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   1961: ifnull +6 -> 1967
    //   1964: goto +39 -> 2003
    //   1967: aload_2
    //   1968: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1971: iconst_3
    //   1972: invokevirtual 744	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   1975: lload 10
    //   1977: lstore 8
    //   1979: iconst_0
    //   1980: istore 4
    //   1982: goto +2936 -> 4918
    //   1985: astore 23
    //   1987: goto -176 -> 1811
    //   1990: astore 23
    //   1992: aload 22
    //   1994: astore 26
    //   1996: aload 23
    //   1998: astore 22
    //   2000: goto -172 -> 1828
    //   2003: aload_0
    //   2004: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   2007: astore 23
    //   2009: aload 23
    //   2011: ifnull +22 -> 2033
    //   2014: aload_0
    //   2015: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   2018: invokeinterface 213 1 0
    //   2023: invokeinterface 749 1 0
    //   2028: istore 4
    //   2030: goto +29 -> 2059
    //   2033: aload_0
    //   2034: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2037: astore 23
    //   2039: aload 23
    //   2041: ifnull +15 -> 2056
    //   2044: aload_0
    //   2045: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2048: invokevirtual 219	okhttp3/Response:code	()I
    //   2051: istore 4
    //   2053: goto -23 -> 2030
    //   2056: iconst_0
    //   2057: istore 4
    //   2059: aload_2
    //   2060: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2063: iload 4
    //   2065: putfield 752	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   2068: sipush 200
    //   2071: iload 4
    //   2073: if_icmpeq +174 -> 2247
    //   2076: sipush 206
    //   2079: iload 4
    //   2081: if_icmpne +6 -> 2087
    //   2084: goto +163 -> 2247
    //   2087: aload_0
    //   2088: aload_0
    //   2089: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2092: aload_0
    //   2093: getfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2096: aload_0
    //   2097: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   2100: aload_0
    //   2101: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2104: invokespecial 754	com/tencent/component/network/downloader/impl/StrictDownloadTask:printfHttpDetail	(Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)V
    //   2107: aload_0
    //   2108: aload_0
    //   2109: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   2112: aload_0
    //   2113: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2116: invokevirtual 758	com/tencent/component/network/downloader/impl/StrictDownloadTask:getRetryFlag	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;)I
    //   2119: ifne +8 -> 2127
    //   2122: aload_0
    //   2123: iconst_0
    //   2124: invokevirtual 761	com/tencent/component/network/downloader/impl/StrictDownloadTask:setAttemptCount	(I)V
    //   2127: sipush 404
    //   2130: iload 4
    //   2132: if_icmpne +46 -> 2178
    //   2135: aload_0
    //   2136: aload_0
    //   2137: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   2140: aload_0
    //   2141: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2144: invokevirtual 764	com/tencent/component/network/downloader/impl/StrictDownloadTask:getXErrorCode	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;)I
    //   2147: istore 7
    //   2149: iload 7
    //   2151: sipush -6101
    //   2154: if_icmpeq +19 -> 2173
    //   2157: iload 7
    //   2159: sipush -5062
    //   2162: if_icmpeq +11 -> 2173
    //   2165: iload 7
    //   2167: sipush -5023
    //   2170: if_icmpne +8 -> 2178
    //   2173: aload_0
    //   2174: iconst_0
    //   2175: invokevirtual 761	com/tencent/component/network/downloader/impl/StrictDownloadTask:setAttemptCount	(I)V
    //   2178: aload_2
    //   2179: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2182: iconst_3
    //   2183: invokevirtual 744	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   2186: aload_0
    //   2187: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2190: ifnull +17 -> 2207
    //   2193: aload_0
    //   2194: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2197: aload_0
    //   2198: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2201: iconst_1
    //   2202: invokeinterface 768 3 0
    //   2207: goto +2707 -> 4914
    //   2210: astore 24
    //   2212: lload 10
    //   2214: lstore 8
    //   2216: iload 4
    //   2218: istore_3
    //   2219: aload 22
    //   2221: astore 28
    //   2223: goto -381 -> 1842
    //   2226: astore 23
    //   2228: aload 22
    //   2230: astore 26
    //   2232: lload 10
    //   2234: lstore 8
    //   2236: aload 23
    //   2238: astore 22
    //   2240: iload 4
    //   2242: istore 5
    //   2244: goto +5343 -> 7587
    //   2247: aload_0
    //   2248: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   2251: astore 23
    //   2253: aload_0
    //   2254: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2257: astore 26
    //   2259: iload 4
    //   2261: istore 7
    //   2263: aload 22
    //   2265: astore 25
    //   2267: aload_0
    //   2268: aload 23
    //   2270: aload 26
    //   2272: aload_2
    //   2273: aload_1
    //   2274: iload 7
    //   2276: invokevirtual 772	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   2279: istore 20
    //   2281: iload 20
    //   2283: ifeq +2631 -> 4914
    //   2286: aload_2
    //   2287: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2290: invokevirtual 775	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   2293: iload_3
    //   2294: iconst_1
    //   2295: iadd
    //   2296: istore 5
    //   2298: aload_2
    //   2299: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2302: lload 16
    //   2304: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   2307: invokevirtual 785	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   2310: aload_2
    //   2311: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2314: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   2317: aload_0
    //   2318: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   2321: lsub
    //   2322: putfield 788	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   2325: aload_2
    //   2326: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2329: aload_0
    //   2330: getfield 791	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   2333: putfield 794	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   2336: aload_0
    //   2337: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   2340: invokestatic 799	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   2343: invokevirtual 803	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2346: astore 27
    //   2348: aload_0
    //   2349: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2352: ifnull +28 -> 2380
    //   2355: aload_0
    //   2356: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2359: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2362: ifnull +18 -> 2380
    //   2365: aload_0
    //   2366: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2369: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2372: invokevirtual 804	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   2375: astore 23
    //   2377: goto +8 -> 2385
    //   2380: ldc_w 806
    //   2383: astore 23
    //   2385: aload_0
    //   2386: aload_0
    //   2387: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2390: aload_0
    //   2391: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   2394: aload_0
    //   2395: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2398: invokevirtual 810	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   2401: astore 33
    //   2403: aload 23
    //   2405: ifnull +10 -> 2415
    //   2408: aload 23
    //   2410: astore 22
    //   2412: goto +8 -> 2420
    //   2415: ldc_w 812
    //   2418: astore 22
    //   2420: aload 25
    //   2422: ifnull +21 -> 2443
    //   2425: aload 25
    //   2427: ldc_w 814
    //   2430: invokeinterface 820 2 0
    //   2435: checkcast 448	java/lang/String
    //   2438: astore 25
    //   2440: goto +8 -> 2448
    //   2443: ldc_w 510
    //   2446: astore 25
    //   2448: aload_2
    //   2449: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2452: aload 25
    //   2454: putfield 829	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   2457: aload_2
    //   2458: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2461: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2464: ifne +70 -> 2534
    //   2467: aload_0
    //   2468: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2471: ifnull +31 -> 2502
    //   2474: aload_0
    //   2475: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2478: aload_0
    //   2479: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2482: aload_2
    //   2483: invokevirtual 835	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2486: aload_0
    //   2487: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   2490: aload_0
    //   2491: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2494: invokeinterface 839 5 0
    //   2499: goto +3 -> 2502
    //   2502: aload_0
    //   2503: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   2506: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2509: ifne +25 -> 2534
    //   2512: aload_0
    //   2513: aload_0
    //   2514: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   2517: iconst_1
    //   2518: isub
    //   2519: putfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   2522: aload_2
    //   2523: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2526: bipush 6
    //   2528: invokevirtual 744	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   2531: goto +3 -> 2534
    //   2534: aload 25
    //   2536: astore 26
    //   2538: aload_1
    //   2539: invokeinterface 521 1 0
    //   2544: ifne +2272 -> 4816
    //   2547: aload_2
    //   2548: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2551: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2554: ifne +887 -> 3441
    //   2557: new 80	java/lang/StringBuilder
    //   2560: dup
    //   2561: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   2564: astore 34
    //   2566: aload 34
    //   2568: ldc_w 841
    //   2571: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: pop
    //   2575: aload 34
    //   2577: aload_0
    //   2578: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   2581: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2584: pop
    //   2585: aload 34
    //   2587: ldc_w 843
    //   2590: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2593: pop
    //   2594: aload 34
    //   2596: aload_0
    //   2597: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   2600: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2603: pop
    //   2604: aload 34
    //   2606: ldc_w 845
    //   2609: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2612: pop
    //   2613: aload_0
    //   2614: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   2617: ifeq +37 -> 2654
    //   2620: aload_0
    //   2621: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2624: astore 25
    //   2626: aload 25
    //   2628: ifnull +26 -> 2654
    //   2631: aload 25
    //   2633: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2636: ifnull +18 -> 2654
    //   2639: aload_0
    //   2640: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   2643: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2646: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   2649: astore 25
    //   2651: goto +8 -> 2659
    //   2654: ldc_w 854
    //   2657: astore 25
    //   2659: aload 34
    //   2661: aload 25
    //   2663: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2666: pop
    //   2667: aload 34
    //   2669: ldc_w 856
    //   2672: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2675: pop
    //   2676: aload 34
    //   2678: aload 27
    //   2680: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2683: pop
    //   2684: aload 34
    //   2686: ldc_w 861
    //   2689: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2692: pop
    //   2693: aload 34
    //   2695: aload 23
    //   2697: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2700: pop
    //   2701: aload 34
    //   2703: aload 32
    //   2705: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2708: pop
    //   2709: aload 34
    //   2711: ldc_w 806
    //   2714: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2717: pop
    //   2718: aload 34
    //   2720: ldc_w 562
    //   2723: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2726: pop
    //   2727: aload 34
    //   2729: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2732: invokevirtual 340	java/lang/Thread:getId	()J
    //   2735: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2738: pop
    //   2739: aload 34
    //   2741: ldc_w 863
    //   2744: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: pop
    //   2748: aload 34
    //   2750: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2753: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2756: pop
    //   2757: aload 34
    //   2759: ldc_w 865
    //   2762: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2765: pop
    //   2766: aload 34
    //   2768: aload_0
    //   2769: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   2772: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2775: pop
    //   2776: aload 34
    //   2778: ldc_w 867
    //   2781: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: pop
    //   2785: aload 34
    //   2787: aload_0
    //   2788: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   2791: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2794: pop
    //   2795: aload 34
    //   2797: ldc_w 869
    //   2800: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: pop
    //   2804: aload_0
    //   2805: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   2808: ifeq +19 -> 2827
    //   2811: aload_0
    //   2812: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   2815: aload_0
    //   2816: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   2819: invokestatic 500	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   2822: astore 23
    //   2824: goto +6 -> 2830
    //   2827: aconst_null
    //   2828: astore 23
    //   2830: aload 34
    //   2832: aload 23
    //   2834: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2837: pop
    //   2838: aload 34
    //   2840: ldc_w 871
    //   2843: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2846: pop
    //   2847: aload 34
    //   2849: aload_0
    //   2850: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   2853: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2856: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2859: pop
    //   2860: aload 34
    //   2862: ldc_w 873
    //   2865: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2868: pop
    //   2869: aload 34
    //   2871: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2874: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2877: pop
    //   2878: aload 34
    //   2880: ldc_w 875
    //   2883: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2886: pop
    //   2887: aload 34
    //   2889: aload_2
    //   2890: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2893: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2896: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2899: pop
    //   2900: aload 34
    //   2902: ldc_w 880
    //   2905: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2908: pop
    //   2909: aload 34
    //   2911: aload_2
    //   2912: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2915: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2918: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2921: pop
    //   2922: aload 34
    //   2924: ldc_w 885
    //   2927: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2930: pop
    //   2931: aload 34
    //   2933: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   2936: aload_0
    //   2937: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   2940: lsub
    //   2941: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2944: pop
    //   2945: aload 34
    //   2947: ldc_w 887
    //   2950: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2953: pop
    //   2954: aload 34
    //   2956: aload_2
    //   2957: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2960: getfield 890	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2963: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2966: pop
    //   2967: aload 34
    //   2969: ldc_w 892
    //   2972: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2975: pop
    //   2976: aload 34
    //   2978: aload_2
    //   2979: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2982: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2985: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2988: pop
    //   2989: aload 34
    //   2991: ldc_w 896
    //   2994: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2997: pop
    //   2998: aload 34
    //   3000: aload_2
    //   3001: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3004: getfield 899	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3007: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3010: pop
    //   3011: aload 34
    //   3013: ldc_w 901
    //   3016: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3019: pop
    //   3020: aload 34
    //   3022: aload_0
    //   3023: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3026: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3029: pop
    //   3030: aload 34
    //   3032: aload 24
    //   3034: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3037: pop
    //   3038: aload 34
    //   3040: aload_0
    //   3041: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   3044: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3047: pop
    //   3048: aload 34
    //   3050: ldc_w 906
    //   3053: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3056: pop
    //   3057: aload 34
    //   3059: iload 5
    //   3061: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3064: pop
    //   3065: aload 34
    //   3067: ldc_w 908
    //   3070: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: pop
    //   3074: aload 34
    //   3076: aload_2
    //   3077: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3080: invokevirtual 911	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3083: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3086: pop
    //   3087: aload 34
    //   3089: ldc_w 913
    //   3092: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3095: pop
    //   3096: aload 34
    //   3098: iload 7
    //   3100: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3103: pop
    //   3104: aload 34
    //   3106: ldc_w 915
    //   3109: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3112: pop
    //   3113: aload 34
    //   3115: aload 33
    //   3117: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3120: pop
    //   3121: aload 34
    //   3123: ldc_w 917
    //   3126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3129: pop
    //   3130: aload 34
    //   3132: aload 26
    //   3134: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3137: pop
    //   3138: aload 34
    //   3140: ldc_w 919
    //   3143: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3146: pop
    //   3147: aload_0
    //   3148: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   3151: astore 25
    //   3153: aload 25
    //   3155: astore 23
    //   3157: aload 25
    //   3159: ifnull +13 -> 3172
    //   3162: aload 25
    //   3164: iconst_0
    //   3165: bipush 30
    //   3167: invokevirtual 923	java/lang/String:substring	(II)Ljava/lang/String;
    //   3170: astore 23
    //   3172: aload 34
    //   3174: aload 23
    //   3176: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3179: pop
    //   3180: aload 34
    //   3182: ldc_w 925
    //   3185: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3188: pop
    //   3189: aload_0
    //   3190: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3193: ifnull +14 -> 3207
    //   3196: aload_0
    //   3197: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3200: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3203: istore_3
    //   3204: goto +5 -> 3209
    //   3207: iconst_0
    //   3208: istore_3
    //   3209: aload 34
    //   3211: iload_3
    //   3212: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3215: pop
    //   3216: aload 34
    //   3218: ldc_w 927
    //   3221: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3224: pop
    //   3225: aload 34
    //   3227: aload_2
    //   3228: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3231: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3234: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3237: pop
    //   3238: aload 34
    //   3240: ldc_w 932
    //   3243: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3246: pop
    //   3247: aload 34
    //   3249: lload 10
    //   3251: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3254: pop
    //   3255: aload 34
    //   3257: ldc_w 934
    //   3260: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3263: pop
    //   3264: aload 34
    //   3266: aload_0
    //   3267: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   3270: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3273: pop
    //   3274: aload 34
    //   3276: aload 24
    //   3278: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: pop
    //   3282: aload 34
    //   3284: aload_0
    //   3285: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   3288: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3291: pop
    //   3292: aload 34
    //   3294: ldc_w 936
    //   3297: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3300: pop
    //   3301: aload 34
    //   3303: aload_0
    //   3304: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   3307: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3310: pop
    //   3311: aload 34
    //   3313: aload 24
    //   3315: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3318: pop
    //   3319: aload 34
    //   3321: aload_0
    //   3322: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   3325: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3328: pop
    //   3329: aload 34
    //   3331: ldc_w 938
    //   3334: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3337: pop
    //   3338: aload 34
    //   3340: aload_0
    //   3341: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   3344: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3347: pop
    //   3348: aload 34
    //   3350: ldc_w 940
    //   3353: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3356: pop
    //   3357: aload 34
    //   3359: aload_0
    //   3360: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   3363: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3366: pop
    //   3367: aload 34
    //   3369: ldc_w 945
    //   3372: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3375: pop
    //   3376: aload 34
    //   3378: aload_0
    //   3379: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   3382: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3385: pop
    //   3386: aload 34
    //   3388: ldc_w 950
    //   3391: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3394: pop
    //   3395: aload_0
    //   3396: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3399: ifnull +17 -> 3416
    //   3402: aload_0
    //   3403: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3406: invokeinterface 590 1 0
    //   3411: astore 23
    //   3413: goto +6 -> 3419
    //   3416: aconst_null
    //   3417: astore 23
    //   3419: aload 34
    //   3421: aload 23
    //   3423: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3426: pop
    //   3427: aload 30
    //   3429: aload 34
    //   3431: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3434: aconst_null
    //   3435: invokestatic 954	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3438: goto +840 -> 4278
    //   3441: new 80	java/lang/StringBuilder
    //   3444: dup
    //   3445: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   3448: astore 34
    //   3450: aload 34
    //   3452: ldc_w 956
    //   3455: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3458: pop
    //   3459: aload 34
    //   3461: aload_0
    //   3462: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   3465: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3468: pop
    //   3469: aload 34
    //   3471: ldc_w 843
    //   3474: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3477: pop
    //   3478: aload 34
    //   3480: aload_0
    //   3481: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   3484: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3487: pop
    //   3488: aload 34
    //   3490: ldc_w 845
    //   3493: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3496: pop
    //   3497: aload_0
    //   3498: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   3501: ifeq +37 -> 3538
    //   3504: aload_0
    //   3505: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3508: astore 25
    //   3510: aload 25
    //   3512: ifnull +26 -> 3538
    //   3515: aload 25
    //   3517: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3520: ifnull +18 -> 3538
    //   3523: aload_0
    //   3524: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   3527: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3530: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3533: astore 25
    //   3535: goto +8 -> 3543
    //   3538: ldc_w 854
    //   3541: astore 25
    //   3543: aload 34
    //   3545: aload 25
    //   3547: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3550: pop
    //   3551: aload 34
    //   3553: ldc_w 856
    //   3556: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3559: pop
    //   3560: aload 34
    //   3562: aload 27
    //   3564: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3567: pop
    //   3568: aload 34
    //   3570: ldc_w 861
    //   3573: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3576: pop
    //   3577: aload 34
    //   3579: aload 23
    //   3581: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3584: pop
    //   3585: aload 34
    //   3587: aload 32
    //   3589: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3592: pop
    //   3593: aload 34
    //   3595: ldc_w 806
    //   3598: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3601: pop
    //   3602: aload 34
    //   3604: ldc_w 562
    //   3607: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3610: pop
    //   3611: aload 34
    //   3613: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3616: invokevirtual 340	java/lang/Thread:getId	()J
    //   3619: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3622: pop
    //   3623: aload 34
    //   3625: ldc_w 863
    //   3628: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: pop
    //   3632: aload 34
    //   3634: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3637: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3640: pop
    //   3641: aload 34
    //   3643: ldc_w 865
    //   3646: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3649: pop
    //   3650: aload 34
    //   3652: aload_0
    //   3653: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   3656: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3659: pop
    //   3660: aload 34
    //   3662: ldc_w 867
    //   3665: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3668: pop
    //   3669: aload 34
    //   3671: aload_0
    //   3672: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   3675: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3678: pop
    //   3679: aload 34
    //   3681: ldc_w 869
    //   3684: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3687: pop
    //   3688: aload_0
    //   3689: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   3692: ifeq +19 -> 3711
    //   3695: aload_0
    //   3696: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   3699: aload_0
    //   3700: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   3703: invokestatic 500	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3706: astore 23
    //   3708: goto +6 -> 3714
    //   3711: aconst_null
    //   3712: astore 23
    //   3714: aload 34
    //   3716: aload 23
    //   3718: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3721: pop
    //   3722: aload 34
    //   3724: ldc_w 873
    //   3727: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3730: pop
    //   3731: aload 34
    //   3733: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3736: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3739: pop
    //   3740: aload 34
    //   3742: ldc_w 880
    //   3745: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3748: pop
    //   3749: aload 34
    //   3751: aload_2
    //   3752: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3755: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3758: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3761: pop
    //   3762: aload 34
    //   3764: ldc_w 885
    //   3767: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: pop
    //   3771: aload 34
    //   3773: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   3776: aload_0
    //   3777: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   3780: lsub
    //   3781: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3784: pop
    //   3785: aload 34
    //   3787: ldc_w 887
    //   3790: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3793: pop
    //   3794: aload 34
    //   3796: aload_2
    //   3797: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3800: getfield 890	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3803: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3806: pop
    //   3807: aload 34
    //   3809: ldc_w 892
    //   3812: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3815: pop
    //   3816: aload 34
    //   3818: aload_2
    //   3819: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3822: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3825: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3828: pop
    //   3829: aload 34
    //   3831: ldc_w 896
    //   3834: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3837: pop
    //   3838: aload 34
    //   3840: aload_2
    //   3841: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3844: getfield 899	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3847: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3850: pop
    //   3851: aload 34
    //   3853: ldc_w 901
    //   3856: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3859: pop
    //   3860: aload 34
    //   3862: aload_0
    //   3863: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   3866: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3869: pop
    //   3870: aload 34
    //   3872: aload 24
    //   3874: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: pop
    //   3878: aload 34
    //   3880: aload_0
    //   3881: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   3884: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3887: pop
    //   3888: aload 34
    //   3890: ldc_w 906
    //   3893: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3896: pop
    //   3897: aload 34
    //   3899: iload 5
    //   3901: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3904: pop
    //   3905: aload 34
    //   3907: ldc_w 958
    //   3910: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3913: pop
    //   3914: aload 34
    //   3916: iload 7
    //   3918: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3921: pop
    //   3922: aload 34
    //   3924: ldc_w 875
    //   3927: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3930: pop
    //   3931: aload 34
    //   3933: aload_2
    //   3934: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3937: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3940: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3943: pop
    //   3944: aload 34
    //   3946: ldc_w 915
    //   3949: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3952: pop
    //   3953: aload 34
    //   3955: aload 33
    //   3957: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3960: pop
    //   3961: aload 34
    //   3963: ldc_w 917
    //   3966: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3969: pop
    //   3970: aload 34
    //   3972: aload 26
    //   3974: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3977: pop
    //   3978: aload 34
    //   3980: ldc_w 919
    //   3983: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3986: pop
    //   3987: aload_0
    //   3988: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   3991: astore 25
    //   3993: aload 25
    //   3995: astore 23
    //   3997: aload 25
    //   3999: ifnull +13 -> 4012
    //   4002: aload 25
    //   4004: iconst_0
    //   4005: bipush 30
    //   4007: invokevirtual 923	java/lang/String:substring	(II)Ljava/lang/String;
    //   4010: astore 23
    //   4012: aload 34
    //   4014: aload 23
    //   4016: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4019: pop
    //   4020: aload 34
    //   4022: ldc_w 925
    //   4025: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4028: pop
    //   4029: aload_0
    //   4030: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4033: ifnull +14 -> 4047
    //   4036: aload_0
    //   4037: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4040: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4043: istore_3
    //   4044: goto +5 -> 4049
    //   4047: iconst_0
    //   4048: istore_3
    //   4049: aload 34
    //   4051: iload_3
    //   4052: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4055: pop
    //   4056: aload 34
    //   4058: ldc_w 927
    //   4061: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4064: pop
    //   4065: aload 34
    //   4067: aload_2
    //   4068: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4071: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4074: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4077: pop
    //   4078: aload 34
    //   4080: ldc_w 932
    //   4083: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4086: pop
    //   4087: aload 34
    //   4089: lload 10
    //   4091: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4094: pop
    //   4095: aload 34
    //   4097: ldc_w 934
    //   4100: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4103: pop
    //   4104: aload 34
    //   4106: aload_0
    //   4107: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   4110: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4113: pop
    //   4114: aload 34
    //   4116: aload 24
    //   4118: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4121: pop
    //   4122: aload 34
    //   4124: aload_0
    //   4125: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   4128: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4131: pop
    //   4132: aload 34
    //   4134: ldc_w 936
    //   4137: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4140: pop
    //   4141: aload 34
    //   4143: aload_0
    //   4144: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   4147: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4150: pop
    //   4151: aload 34
    //   4153: aload 24
    //   4155: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4158: pop
    //   4159: aload 34
    //   4161: aload_0
    //   4162: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   4165: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4168: pop
    //   4169: aload 34
    //   4171: ldc_w 938
    //   4174: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4177: pop
    //   4178: aload 34
    //   4180: aload_0
    //   4181: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   4184: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4187: pop
    //   4188: aload 34
    //   4190: ldc_w 940
    //   4193: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4196: pop
    //   4197: aload 34
    //   4199: aload_0
    //   4200: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   4203: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4206: pop
    //   4207: aload 34
    //   4209: ldc_w 945
    //   4212: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4215: pop
    //   4216: aload 34
    //   4218: aload_0
    //   4219: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   4222: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4225: pop
    //   4226: aload 34
    //   4228: ldc_w 950
    //   4231: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4234: pop
    //   4235: aload_0
    //   4236: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4239: ifnull +17 -> 4256
    //   4242: aload_0
    //   4243: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4246: invokeinterface 590 1 0
    //   4251: astore 23
    //   4253: goto +6 -> 4259
    //   4256: aconst_null
    //   4257: astore 23
    //   4259: aload 34
    //   4261: aload 23
    //   4263: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4266: pop
    //   4267: aload 30
    //   4269: aload 34
    //   4271: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4274: aconst_null
    //   4275: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4278: aload_0
    //   4279: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4282: ifnull +71 -> 4353
    //   4285: getstatic 369	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4288: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4291: aload_0
    //   4292: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4295: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4298: if_icmpne +55 -> 4353
    //   4301: aload_0
    //   4302: getfield 400	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4305: ifnull +48 -> 4353
    //   4308: aload_0
    //   4309: getfield 400	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4312: aload_0
    //   4313: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4316: aload_0
    //   4317: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4320: invokestatic 963	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4323: aload_2
    //   4324: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4327: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4330: invokeinterface 967 4 0
    //   4335: goto +18 -> 4353
    //   4338: astore 23
    //   4340: aload 29
    //   4342: ldc_w 968
    //   4345: aload 23
    //   4347: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4350: goto +3 -> 4353
    //   4353: aload_0
    //   4354: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4357: ifnull +68 -> 4425
    //   4360: getstatic 478	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4363: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4366: aload_0
    //   4367: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4370: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4373: if_icmpne +52 -> 4425
    //   4376: aload_0
    //   4377: getfield 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4380: ifnull +45 -> 4425
    //   4383: aload_0
    //   4384: getfield 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4387: aload_0
    //   4388: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4391: aload_0
    //   4392: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4395: invokestatic 963	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4398: aload_2
    //   4399: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4402: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4405: invokeinterface 967 4 0
    //   4410: goto +15 -> 4425
    //   4413: astore 23
    //   4415: ldc 230
    //   4417: ldc_w 969
    //   4420: aload 23
    //   4422: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4425: aload 31
    //   4427: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   4430: putfield 972	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4433: aload 31
    //   4435: aload_0
    //   4436: getfield 975	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   4439: putfield 978	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4442: aload 31
    //   4444: aload_0
    //   4445: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   4448: putfield 979	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4451: aload 31
    //   4453: iload 4
    //   4455: putfield 980	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4458: aload 31
    //   4460: aconst_null
    //   4461: putfield 984	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4464: aload 27
    //   4466: ifnonnull +9 -> 4475
    //   4469: aconst_null
    //   4470: astore 23
    //   4472: goto +10 -> 4482
    //   4475: aload 27
    //   4477: invokevirtual 987	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   4480: astore 23
    //   4482: aload 31
    //   4484: aload 23
    //   4486: putfield 990	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4489: aload_0
    //   4490: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4493: ifnull +28 -> 4521
    //   4496: aload_0
    //   4497: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4500: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4503: ifnull +18 -> 4521
    //   4506: aload_0
    //   4507: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4510: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4513: getfield 627	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   4516: astore 23
    //   4518: goto +6 -> 4524
    //   4521: aconst_null
    //   4522: astore 23
    //   4524: aload 31
    //   4526: aload 23
    //   4528: putfield 993	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   4531: aload 31
    //   4533: ldc_w 806
    //   4536: putfield 996	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4539: aload 31
    //   4541: aload_2
    //   4542: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4545: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4548: putfield 997	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4551: aload 31
    //   4553: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4556: aload_0
    //   4557: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   4560: lsub
    //   4561: putfield 1000	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4564: aload 31
    //   4566: aload_2
    //   4567: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4570: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4573: putfield 1003	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4576: aload 31
    //   4578: aload 31
    //   4580: getfield 1000	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4583: aload_2
    //   4584: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4587: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4590: lsub
    //   4591: putfield 1006	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4594: aload 31
    //   4596: lload 10
    //   4598: putfield 1009	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4601: aload 31
    //   4603: aload_0
    //   4604: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   4607: putfield 1012	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4610: aload 31
    //   4612: aload_0
    //   4613: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   4616: putfield 1015	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4619: aload 31
    //   4621: aload_0
    //   4622: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   4625: putfield 1018	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4628: aload 31
    //   4630: lconst_0
    //   4631: putfield 1021	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4634: aload 31
    //   4636: aload_0
    //   4637: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   4640: putfield 1024	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4643: aload 31
    //   4645: aload_2
    //   4646: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4649: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4652: putfield 1027	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4655: aload 31
    //   4657: aload_0
    //   4658: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   4661: invokestatic 1030	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4664: putfield 1032	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4667: aload 31
    //   4669: aload_0
    //   4670: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   4673: putfield 1035	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4676: aload_0
    //   4677: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   4680: astore 23
    //   4682: aload 23
    //   4684: ifnull +20 -> 4704
    //   4687: aload 23
    //   4689: ldc_w 617
    //   4692: invokevirtual 620	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4695: ifeq +9 -> 4704
    //   4698: iconst_1
    //   4699: istore 20
    //   4701: goto +6 -> 4707
    //   4704: iconst_0
    //   4705: istore 20
    //   4707: aload 31
    //   4709: iload 20
    //   4711: putfield 1038	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4714: aload 31
    //   4716: aload_2
    //   4717: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4720: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4723: putfield 1040	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4726: aload 31
    //   4728: getstatic 1046	com/tencent/component/network/downloader/Downloader$DownloadMode:StrictMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   4731: invokevirtual 1049	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   4734: putfield 1052	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   4737: aload_0
    //   4738: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   4741: astore 23
    //   4743: aload 23
    //   4745: ifnull +26 -> 4771
    //   4748: aload 23
    //   4750: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4753: ifnull +18 -> 4771
    //   4756: aload 31
    //   4758: aload_0
    //   4759: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   4762: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4765: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4768: putfield 1054	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   4771: aload_2
    //   4772: astore 23
    //   4774: aload 23
    //   4776: aload 31
    //   4778: invokevirtual 1058	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4781: aload_0
    //   4782: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   4785: aload_0
    //   4786: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   4789: iconst_1
    //   4790: isub
    //   4791: if_icmpeq +13 -> 4804
    //   4794: aload_2
    //   4795: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4798: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4801: ifeq +15 -> 4816
    //   4804: aload_0
    //   4805: aload_1
    //   4806: aload 23
    //   4808: aload 31
    //   4810: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4813: goto +3 -> 4816
    //   4816: aload_2
    //   4817: astore 23
    //   4819: aload_0
    //   4820: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   4823: ifeq +27 -> 4850
    //   4826: aload_0
    //   4827: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4830: ifnull +12 -> 4842
    //   4833: aload_0
    //   4834: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4837: invokeinterface 1061 1 0
    //   4842: aload_0
    //   4843: aconst_null
    //   4844: putfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   4847: goto +17 -> 4864
    //   4850: aload_0
    //   4851: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   4854: ifnull +10 -> 4864
    //   4857: aload_0
    //   4858: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   4861: invokevirtual 1066	org/apache/http/client/methods/HttpGet:abort	()V
    //   4864: iload 5
    //   4866: istore_3
    //   4867: ldc 230
    //   4869: astore 25
    //   4871: aload 22
    //   4873: astore_1
    //   4874: goto +5766 -> 10640
    //   4877: astore 24
    //   4879: goto -2667 -> 2212
    //   4882: astore 22
    //   4884: lload 10
    //   4886: lstore 8
    //   4888: ldc_w 562
    //   4891: astore 23
    //   4893: aload 25
    //   4895: astore 26
    //   4897: aload 23
    //   4899: astore 25
    //   4901: iload_3
    //   4902: istore 4
    //   4904: aload 29
    //   4906: astore 23
    //   4908: iload 7
    //   4910: istore_3
    //   4911: goto +2908 -> 7819
    //   4914: lload 10
    //   4916: lstore 8
    //   4918: aload 22
    //   4920: astore 24
    //   4922: iload_3
    //   4923: iconst_1
    //   4924: iadd
    //   4925: istore 5
    //   4927: aload_2
    //   4928: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4931: lload 16
    //   4933: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4936: invokevirtual 785	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4939: aload_2
    //   4940: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4943: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   4946: aload_0
    //   4947: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   4950: lsub
    //   4951: putfield 788	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4954: aload_2
    //   4955: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4958: aload_0
    //   4959: getfield 791	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   4962: putfield 794	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4965: aload_0
    //   4966: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   4969: invokestatic 799	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4972: invokevirtual 803	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4975: astore 27
    //   4977: aload_0
    //   4978: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4981: ifnull +28 -> 5009
    //   4984: aload_0
    //   4985: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4988: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4991: ifnull +18 -> 5009
    //   4994: aload_0
    //   4995: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4998: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5001: invokevirtual 804	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   5004: astore 23
    //   5006: goto +8 -> 5014
    //   5009: ldc_w 806
    //   5012: astore 23
    //   5014: aload_0
    //   5015: aload_0
    //   5016: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   5019: aload_0
    //   5020: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   5023: aload_0
    //   5024: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5027: invokevirtual 810	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   5030: astore 25
    //   5032: aload 23
    //   5034: ifnull +10 -> 5044
    //   5037: aload 23
    //   5039: astore 22
    //   5041: goto +8 -> 5049
    //   5044: ldc_w 812
    //   5047: astore 22
    //   5049: aload 24
    //   5051: ifnull +21 -> 5072
    //   5054: aload 24
    //   5056: ldc_w 814
    //   5059: invokeinterface 820 2 0
    //   5064: checkcast 448	java/lang/String
    //   5067: astore 24
    //   5069: goto +8 -> 5077
    //   5072: ldc_w 510
    //   5075: astore 24
    //   5077: aload_2
    //   5078: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5081: aload 24
    //   5083: putfield 829	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   5086: aload_2
    //   5087: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5090: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5093: ifne +70 -> 5163
    //   5096: aload_0
    //   5097: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5100: ifnull +31 -> 5131
    //   5103: aload_0
    //   5104: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5107: aload_0
    //   5108: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   5111: aload_2
    //   5112: invokevirtual 835	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   5115: aload_0
    //   5116: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   5119: aload_0
    //   5120: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5123: invokeinterface 839 5 0
    //   5128: goto +3 -> 5131
    //   5131: aload_0
    //   5132: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5135: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5138: ifne +25 -> 5163
    //   5141: aload_0
    //   5142: aload_0
    //   5143: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5146: iconst_1
    //   5147: isub
    //   5148: putfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5151: aload_2
    //   5152: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5155: bipush 6
    //   5157: invokevirtual 744	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   5160: goto +3 -> 5163
    //   5163: ldc 91
    //   5165: astore 29
    //   5167: aload 24
    //   5169: astore 26
    //   5171: aload_1
    //   5172: invokeinterface 521 1 0
    //   5177: ifne +2278 -> 7455
    //   5180: aload_2
    //   5181: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5184: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5187: ifne +887 -> 6074
    //   5190: new 80	java/lang/StringBuilder
    //   5193: dup
    //   5194: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   5197: astore 33
    //   5199: aload 33
    //   5201: ldc_w 841
    //   5204: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5207: pop
    //   5208: aload 33
    //   5210: aload_0
    //   5211: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   5214: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5217: pop
    //   5218: aload 33
    //   5220: ldc_w 843
    //   5223: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5226: pop
    //   5227: aload 33
    //   5229: aload_0
    //   5230: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   5233: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5236: pop
    //   5237: aload 33
    //   5239: ldc_w 845
    //   5242: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5245: pop
    //   5246: aload_0
    //   5247: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   5250: ifeq +37 -> 5287
    //   5253: aload_0
    //   5254: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5257: astore 24
    //   5259: aload 24
    //   5261: ifnull +26 -> 5287
    //   5264: aload 24
    //   5266: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5269: ifnull +18 -> 5287
    //   5272: aload_0
    //   5273: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   5276: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5279: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5282: astore 24
    //   5284: goto +8 -> 5292
    //   5287: ldc_w 854
    //   5290: astore 24
    //   5292: aload 33
    //   5294: aload 24
    //   5296: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5299: pop
    //   5300: aload 33
    //   5302: ldc_w 856
    //   5305: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5308: pop
    //   5309: aload 33
    //   5311: aload 27
    //   5313: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5316: pop
    //   5317: aload 33
    //   5319: ldc_w 861
    //   5322: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5325: pop
    //   5326: aload 33
    //   5328: aload 23
    //   5330: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5333: pop
    //   5334: aload 33
    //   5336: aload 32
    //   5338: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5341: pop
    //   5342: aload 33
    //   5344: ldc_w 806
    //   5347: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5350: pop
    //   5351: aload 33
    //   5353: ldc_w 562
    //   5356: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5359: pop
    //   5360: aload 33
    //   5362: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5365: invokevirtual 340	java/lang/Thread:getId	()J
    //   5368: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5371: pop
    //   5372: aload 33
    //   5374: ldc_w 863
    //   5377: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5380: pop
    //   5381: aload 33
    //   5383: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5386: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5389: pop
    //   5390: aload 33
    //   5392: ldc_w 865
    //   5395: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5398: pop
    //   5399: aload 33
    //   5401: aload_0
    //   5402: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   5405: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5408: pop
    //   5409: aload 33
    //   5411: ldc_w 867
    //   5414: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5417: pop
    //   5418: aload 33
    //   5420: aload_0
    //   5421: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   5424: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5427: pop
    //   5428: aload 33
    //   5430: ldc_w 869
    //   5433: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5436: pop
    //   5437: aload_0
    //   5438: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   5441: ifeq +19 -> 5460
    //   5444: aload_0
    //   5445: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5448: aload_0
    //   5449: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   5452: invokestatic 500	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5455: astore 23
    //   5457: goto +6 -> 5463
    //   5460: aconst_null
    //   5461: astore 23
    //   5463: aload 33
    //   5465: aload 23
    //   5467: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5470: pop
    //   5471: aload 33
    //   5473: ldc_w 871
    //   5476: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5479: pop
    //   5480: aload 33
    //   5482: aload_0
    //   5483: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   5486: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5489: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5492: pop
    //   5493: aload 33
    //   5495: ldc_w 873
    //   5498: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5501: pop
    //   5502: aload 33
    //   5504: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5507: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5510: pop
    //   5511: aload 33
    //   5513: ldc_w 875
    //   5516: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5519: pop
    //   5520: aload 33
    //   5522: aload_2
    //   5523: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5526: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5529: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5532: pop
    //   5533: aload 33
    //   5535: ldc_w 880
    //   5538: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5541: pop
    //   5542: aload 33
    //   5544: aload_2
    //   5545: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5548: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5551: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5554: pop
    //   5555: aload 33
    //   5557: ldc_w 885
    //   5560: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5563: pop
    //   5564: aload 33
    //   5566: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   5569: aload_0
    //   5570: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   5573: lsub
    //   5574: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5577: pop
    //   5578: aload 33
    //   5580: ldc_w 887
    //   5583: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5586: pop
    //   5587: aload 33
    //   5589: aload_2
    //   5590: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5593: getfield 890	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5596: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5599: pop
    //   5600: aload 33
    //   5602: ldc_w 892
    //   5605: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: pop
    //   5609: aload 33
    //   5611: aload_2
    //   5612: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5615: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5618: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5621: pop
    //   5622: aload 33
    //   5624: ldc_w 896
    //   5627: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5630: pop
    //   5631: aload 33
    //   5633: aload_2
    //   5634: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5637: getfield 899	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5640: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5643: pop
    //   5644: aload 33
    //   5646: ldc_w 901
    //   5649: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5652: pop
    //   5653: aload 33
    //   5655: aload_0
    //   5656: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   5659: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5662: pop
    //   5663: aload 33
    //   5665: aload 29
    //   5667: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5670: pop
    //   5671: aload 33
    //   5673: aload_0
    //   5674: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   5677: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5680: pop
    //   5681: aload 33
    //   5683: ldc_w 906
    //   5686: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5689: pop
    //   5690: aload 33
    //   5692: iload 5
    //   5694: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5697: pop
    //   5698: aload 33
    //   5700: ldc_w 908
    //   5703: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5706: pop
    //   5707: aload 33
    //   5709: aload_2
    //   5710: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5713: invokevirtual 911	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5716: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5719: pop
    //   5720: aload 33
    //   5722: ldc_w 913
    //   5725: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5728: pop
    //   5729: aload 33
    //   5731: iload 4
    //   5733: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5736: pop
    //   5737: aload 33
    //   5739: ldc_w 915
    //   5742: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5745: pop
    //   5746: aload 33
    //   5748: aload 25
    //   5750: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5753: pop
    //   5754: aload 33
    //   5756: ldc_w 917
    //   5759: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5762: pop
    //   5763: aload 33
    //   5765: aload 26
    //   5767: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5770: pop
    //   5771: aload 33
    //   5773: ldc_w 919
    //   5776: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5779: pop
    //   5780: aload_0
    //   5781: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   5784: astore 24
    //   5786: aload 24
    //   5788: astore 23
    //   5790: aload 24
    //   5792: ifnull +13 -> 5805
    //   5795: aload 24
    //   5797: iconst_0
    //   5798: bipush 30
    //   5800: invokevirtual 923	java/lang/String:substring	(II)Ljava/lang/String;
    //   5803: astore 23
    //   5805: aload 33
    //   5807: aload 23
    //   5809: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5812: pop
    //   5813: aload 33
    //   5815: ldc_w 925
    //   5818: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5821: pop
    //   5822: aload_0
    //   5823: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5826: ifnull +14 -> 5840
    //   5829: aload_0
    //   5830: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5833: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5836: istore_3
    //   5837: goto +5 -> 5842
    //   5840: iconst_0
    //   5841: istore_3
    //   5842: aload 33
    //   5844: iload_3
    //   5845: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5848: pop
    //   5849: aload 33
    //   5851: ldc_w 927
    //   5854: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5857: pop
    //   5858: aload 33
    //   5860: aload_2
    //   5861: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5864: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5867: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5870: pop
    //   5871: aload 33
    //   5873: ldc_w 932
    //   5876: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5879: pop
    //   5880: aload 33
    //   5882: lload 8
    //   5884: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5887: pop
    //   5888: aload 33
    //   5890: ldc_w 934
    //   5893: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5896: pop
    //   5897: aload 33
    //   5899: aload_0
    //   5900: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   5903: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5906: pop
    //   5907: aload 33
    //   5909: aload 29
    //   5911: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5914: pop
    //   5915: aload 33
    //   5917: aload_0
    //   5918: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   5921: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5924: pop
    //   5925: aload 33
    //   5927: ldc_w 936
    //   5930: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5933: pop
    //   5934: aload 33
    //   5936: aload_0
    //   5937: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   5940: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5943: pop
    //   5944: aload 33
    //   5946: aload 29
    //   5948: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5951: pop
    //   5952: aload 33
    //   5954: aload_0
    //   5955: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   5958: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5961: pop
    //   5962: aload 33
    //   5964: ldc_w 938
    //   5967: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5970: pop
    //   5971: aload 33
    //   5973: aload_0
    //   5974: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   5977: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5980: pop
    //   5981: aload 33
    //   5983: ldc_w 940
    //   5986: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5989: pop
    //   5990: aload 33
    //   5992: aload_0
    //   5993: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   5996: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5999: pop
    //   6000: aload 33
    //   6002: ldc_w 945
    //   6005: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6008: pop
    //   6009: aload 33
    //   6011: aload_0
    //   6012: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   6015: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6018: pop
    //   6019: aload 33
    //   6021: ldc_w 950
    //   6024: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6027: pop
    //   6028: aload_0
    //   6029: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6032: ifnull +17 -> 6049
    //   6035: aload_0
    //   6036: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6039: invokeinterface 590 1 0
    //   6044: astore 23
    //   6046: goto +6 -> 6052
    //   6049: aconst_null
    //   6050: astore 23
    //   6052: aload 33
    //   6054: aload 23
    //   6056: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6059: pop
    //   6060: aload 30
    //   6062: aload 33
    //   6064: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6067: aconst_null
    //   6068: invokestatic 954	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6071: goto +840 -> 6911
    //   6074: new 80	java/lang/StringBuilder
    //   6077: dup
    //   6078: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   6081: astore 33
    //   6083: aload 33
    //   6085: ldc_w 956
    //   6088: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6091: pop
    //   6092: aload 33
    //   6094: aload_0
    //   6095: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   6098: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6101: pop
    //   6102: aload 33
    //   6104: ldc_w 843
    //   6107: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6110: pop
    //   6111: aload 33
    //   6113: aload_0
    //   6114: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   6117: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6120: pop
    //   6121: aload 33
    //   6123: ldc_w 845
    //   6126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6129: pop
    //   6130: aload_0
    //   6131: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   6134: ifeq +37 -> 6171
    //   6137: aload_0
    //   6138: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   6141: astore 24
    //   6143: aload 24
    //   6145: ifnull +26 -> 6171
    //   6148: aload 24
    //   6150: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6153: ifnull +18 -> 6171
    //   6156: aload_0
    //   6157: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   6160: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6163: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6166: astore 24
    //   6168: goto +8 -> 6176
    //   6171: ldc_w 854
    //   6174: astore 24
    //   6176: aload 33
    //   6178: aload 24
    //   6180: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6183: pop
    //   6184: aload 33
    //   6186: ldc_w 856
    //   6189: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6192: pop
    //   6193: aload 33
    //   6195: aload 27
    //   6197: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6200: pop
    //   6201: aload 33
    //   6203: ldc_w 861
    //   6206: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6209: pop
    //   6210: aload 33
    //   6212: aload 23
    //   6214: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6217: pop
    //   6218: aload 33
    //   6220: aload 32
    //   6222: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6225: pop
    //   6226: aload 33
    //   6228: ldc_w 806
    //   6231: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6234: pop
    //   6235: aload 33
    //   6237: ldc_w 562
    //   6240: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6243: pop
    //   6244: aload 33
    //   6246: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6249: invokevirtual 340	java/lang/Thread:getId	()J
    //   6252: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6255: pop
    //   6256: aload 33
    //   6258: ldc_w 863
    //   6261: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6264: pop
    //   6265: aload 33
    //   6267: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6270: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6273: pop
    //   6274: aload 33
    //   6276: ldc_w 865
    //   6279: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6282: pop
    //   6283: aload 33
    //   6285: aload_0
    //   6286: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   6289: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6292: pop
    //   6293: aload 33
    //   6295: ldc_w 867
    //   6298: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6301: pop
    //   6302: aload 33
    //   6304: aload_0
    //   6305: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   6308: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6311: pop
    //   6312: aload 33
    //   6314: ldc_w 869
    //   6317: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6320: pop
    //   6321: aload_0
    //   6322: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   6325: ifeq +19 -> 6344
    //   6328: aload_0
    //   6329: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   6332: aload_0
    //   6333: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   6336: invokestatic 500	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   6339: astore 23
    //   6341: goto +6 -> 6347
    //   6344: aconst_null
    //   6345: astore 23
    //   6347: aload 33
    //   6349: aload 23
    //   6351: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6354: pop
    //   6355: aload 33
    //   6357: ldc_w 873
    //   6360: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6363: pop
    //   6364: aload 33
    //   6366: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6369: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6372: pop
    //   6373: aload 33
    //   6375: ldc_w 880
    //   6378: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6381: pop
    //   6382: aload 33
    //   6384: aload_2
    //   6385: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6388: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6391: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6394: pop
    //   6395: aload 33
    //   6397: ldc_w 885
    //   6400: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6403: pop
    //   6404: aload 33
    //   6406: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   6409: aload_0
    //   6410: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   6413: lsub
    //   6414: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6417: pop
    //   6418: aload 33
    //   6420: ldc_w 887
    //   6423: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6426: pop
    //   6427: aload 33
    //   6429: aload_2
    //   6430: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6433: getfield 890	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6436: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6439: pop
    //   6440: aload 33
    //   6442: ldc_w 892
    //   6445: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6448: pop
    //   6449: aload 33
    //   6451: aload_2
    //   6452: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6455: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6458: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6461: pop
    //   6462: aload 33
    //   6464: ldc_w 896
    //   6467: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6470: pop
    //   6471: aload 33
    //   6473: aload_2
    //   6474: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6477: getfield 899	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6480: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6483: pop
    //   6484: aload 33
    //   6486: ldc_w 901
    //   6489: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6492: pop
    //   6493: aload 33
    //   6495: aload_0
    //   6496: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   6499: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6502: pop
    //   6503: aload 33
    //   6505: aload 29
    //   6507: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6510: pop
    //   6511: aload 33
    //   6513: aload_0
    //   6514: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   6517: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6520: pop
    //   6521: aload 33
    //   6523: ldc_w 906
    //   6526: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6529: pop
    //   6530: aload 33
    //   6532: iload 5
    //   6534: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6537: pop
    //   6538: aload 33
    //   6540: ldc_w 958
    //   6543: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6546: pop
    //   6547: aload 33
    //   6549: iload 4
    //   6551: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6554: pop
    //   6555: aload 33
    //   6557: ldc_w 875
    //   6560: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6563: pop
    //   6564: aload 33
    //   6566: aload_2
    //   6567: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6570: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6573: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6576: pop
    //   6577: aload 33
    //   6579: ldc_w 915
    //   6582: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6585: pop
    //   6586: aload 33
    //   6588: aload 25
    //   6590: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6593: pop
    //   6594: aload 33
    //   6596: ldc_w 917
    //   6599: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6602: pop
    //   6603: aload 33
    //   6605: aload 26
    //   6607: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6610: pop
    //   6611: aload 33
    //   6613: ldc_w 919
    //   6616: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6619: pop
    //   6620: aload_0
    //   6621: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6624: astore 24
    //   6626: aload 24
    //   6628: astore 23
    //   6630: aload 24
    //   6632: ifnull +13 -> 6645
    //   6635: aload 24
    //   6637: iconst_0
    //   6638: bipush 30
    //   6640: invokevirtual 923	java/lang/String:substring	(II)Ljava/lang/String;
    //   6643: astore 23
    //   6645: aload 33
    //   6647: aload 23
    //   6649: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6652: pop
    //   6653: aload 33
    //   6655: ldc_w 925
    //   6658: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6661: pop
    //   6662: aload_0
    //   6663: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6666: ifnull +14 -> 6680
    //   6669: aload_0
    //   6670: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6673: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6676: istore_3
    //   6677: goto +5 -> 6682
    //   6680: iconst_0
    //   6681: istore_3
    //   6682: aload 33
    //   6684: iload_3
    //   6685: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6688: pop
    //   6689: aload 33
    //   6691: ldc_w 927
    //   6694: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6697: pop
    //   6698: aload 33
    //   6700: aload_2
    //   6701: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6704: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6707: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6710: pop
    //   6711: aload 33
    //   6713: ldc_w 932
    //   6716: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6719: pop
    //   6720: aload 33
    //   6722: lload 8
    //   6724: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6727: pop
    //   6728: aload 33
    //   6730: ldc_w 934
    //   6733: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6736: pop
    //   6737: aload 33
    //   6739: aload_0
    //   6740: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   6743: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6746: pop
    //   6747: aload 33
    //   6749: aload 29
    //   6751: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6754: pop
    //   6755: aload 33
    //   6757: aload_0
    //   6758: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   6761: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6764: pop
    //   6765: aload 33
    //   6767: ldc_w 936
    //   6770: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6773: pop
    //   6774: aload 33
    //   6776: aload_0
    //   6777: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   6780: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6783: pop
    //   6784: aload 33
    //   6786: aload 29
    //   6788: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6791: pop
    //   6792: aload 33
    //   6794: aload_0
    //   6795: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   6798: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6801: pop
    //   6802: aload 33
    //   6804: ldc_w 938
    //   6807: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6810: pop
    //   6811: aload 33
    //   6813: aload_0
    //   6814: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   6817: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6820: pop
    //   6821: aload 33
    //   6823: ldc_w 940
    //   6826: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6829: pop
    //   6830: aload 33
    //   6832: aload_0
    //   6833: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   6836: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6839: pop
    //   6840: aload 33
    //   6842: ldc_w 945
    //   6845: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6848: pop
    //   6849: aload 33
    //   6851: aload_0
    //   6852: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   6855: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6858: pop
    //   6859: aload 33
    //   6861: ldc_w 950
    //   6864: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6867: pop
    //   6868: aload_0
    //   6869: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6872: ifnull +17 -> 6889
    //   6875: aload_0
    //   6876: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6879: invokeinterface 590 1 0
    //   6884: astore 23
    //   6886: goto +6 -> 6892
    //   6889: aconst_null
    //   6890: astore 23
    //   6892: aload 33
    //   6894: aload 23
    //   6896: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6899: pop
    //   6900: aload 30
    //   6902: aload 33
    //   6904: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6907: aconst_null
    //   6908: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6911: aload_0
    //   6912: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6915: ifnull +71 -> 6986
    //   6918: getstatic 369	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6921: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6924: aload_0
    //   6925: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6928: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6931: if_icmpne +55 -> 6986
    //   6934: aload_0
    //   6935: getfield 400	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6938: ifnull +48 -> 6986
    //   6941: aload_0
    //   6942: getfield 400	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6945: aload_0
    //   6946: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   6949: aload_0
    //   6950: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   6953: invokestatic 963	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   6956: aload_2
    //   6957: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6960: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6963: invokeinterface 967 4 0
    //   6968: goto +18 -> 6986
    //   6971: astore 23
    //   6973: ldc 230
    //   6975: ldc_w 968
    //   6978: aload 23
    //   6980: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6983: goto +3 -> 6986
    //   6986: aload_0
    //   6987: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6990: ifnull +68 -> 7058
    //   6993: getstatic 478	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6996: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6999: aload_0
    //   7000: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7003: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7006: if_icmpne +52 -> 7058
    //   7009: aload_0
    //   7010: getfield 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7013: ifnull +45 -> 7058
    //   7016: aload_0
    //   7017: getfield 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7020: aload_0
    //   7021: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   7024: aload_0
    //   7025: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7028: invokestatic 963	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   7031: aload_2
    //   7032: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7035: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7038: invokeinterface 967 4 0
    //   7043: goto +15 -> 7058
    //   7046: astore 23
    //   7048: ldc 230
    //   7050: ldc_w 969
    //   7053: aload 23
    //   7055: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7058: aload 31
    //   7060: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   7063: putfield 972	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   7066: aload 31
    //   7068: aload_0
    //   7069: getfield 975	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   7072: putfield 978	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   7075: aload 31
    //   7077: aload_0
    //   7078: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   7081: putfield 979	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   7084: aload 31
    //   7086: iload 4
    //   7088: putfield 980	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   7091: aload 31
    //   7093: aconst_null
    //   7094: putfield 984	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   7097: aload 27
    //   7099: ifnonnull +9 -> 7108
    //   7102: aconst_null
    //   7103: astore 23
    //   7105: goto +10 -> 7115
    //   7108: aload 27
    //   7110: invokevirtual 987	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7113: astore 23
    //   7115: aload 31
    //   7117: aload 23
    //   7119: putfield 990	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   7122: aload_0
    //   7123: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7126: ifnull +28 -> 7154
    //   7129: aload_0
    //   7130: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7133: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7136: ifnull +18 -> 7154
    //   7139: aload_0
    //   7140: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7143: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7146: getfield 627	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   7149: astore 23
    //   7151: goto +6 -> 7157
    //   7154: aconst_null
    //   7155: astore 23
    //   7157: aload 31
    //   7159: aload 23
    //   7161: putfield 993	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   7164: aload 31
    //   7166: ldc_w 806
    //   7169: putfield 996	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   7172: aload 31
    //   7174: aload_2
    //   7175: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7178: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7181: putfield 997	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   7184: aload 31
    //   7186: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   7189: aload_0
    //   7190: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   7193: lsub
    //   7194: putfield 1000	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   7197: aload 31
    //   7199: aload_2
    //   7200: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7203: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7206: putfield 1003	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   7209: aload 31
    //   7211: aload 31
    //   7213: getfield 1000	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   7216: aload_2
    //   7217: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7220: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7223: lsub
    //   7224: putfield 1006	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   7227: aload 31
    //   7229: lload 8
    //   7231: putfield 1009	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   7234: aload 31
    //   7236: aload_0
    //   7237: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   7240: putfield 1012	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   7243: aload 31
    //   7245: aload_0
    //   7246: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   7249: putfield 1015	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   7252: aload 31
    //   7254: aload_0
    //   7255: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   7258: putfield 1018	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   7261: aload 31
    //   7263: lconst_0
    //   7264: putfield 1021	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   7267: aload 31
    //   7269: aload_0
    //   7270: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   7273: putfield 1024	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   7276: aload 31
    //   7278: aload_2
    //   7279: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7282: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7285: putfield 1027	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   7288: aload 31
    //   7290: aload_0
    //   7291: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   7294: invokestatic 1030	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   7297: putfield 1032	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   7300: aload 31
    //   7302: aload_0
    //   7303: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   7306: putfield 1035	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   7309: aload_0
    //   7310: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7313: astore 23
    //   7315: aload 23
    //   7317: ifnull +20 -> 7337
    //   7320: aload 23
    //   7322: ldc_w 617
    //   7325: invokevirtual 620	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7328: ifeq +9 -> 7337
    //   7331: iconst_1
    //   7332: istore 20
    //   7334: goto +6 -> 7340
    //   7337: iconst_0
    //   7338: istore 20
    //   7340: aload 31
    //   7342: iload 20
    //   7344: putfield 1038	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   7347: aload 31
    //   7349: aload_2
    //   7350: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7353: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7356: putfield 1040	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   7359: aload 31
    //   7361: getstatic 1046	com/tencent/component/network/downloader/Downloader$DownloadMode:StrictMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   7364: invokevirtual 1049	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   7367: putfield 1052	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   7370: aload_0
    //   7371: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   7374: astore 23
    //   7376: aload 23
    //   7378: ifnull +26 -> 7404
    //   7381: aload 23
    //   7383: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7386: ifnull +18 -> 7404
    //   7389: aload 31
    //   7391: aload_0
    //   7392: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   7395: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7398: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7401: putfield 1054	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   7404: aload_2
    //   7405: astore 23
    //   7407: aload 23
    //   7409: aload 31
    //   7411: invokevirtual 1058	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   7414: aload_0
    //   7415: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   7418: aload_0
    //   7419: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   7422: iconst_1
    //   7423: isub
    //   7424: if_icmpeq +19 -> 7443
    //   7427: aload_2
    //   7428: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7431: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7434: ifeq +6 -> 7440
    //   7437: goto +6 -> 7443
    //   7440: goto +15 -> 7455
    //   7443: aload_0
    //   7444: aload_1
    //   7445: aload 23
    //   7447: aload 31
    //   7449: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   7452: goto +3 -> 7455
    //   7455: aload_2
    //   7456: astore 23
    //   7458: aload_0
    //   7459: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   7462: ifeq +27 -> 7489
    //   7465: aload_0
    //   7466: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   7469: ifnull +12 -> 7481
    //   7472: aload_0
    //   7473: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   7476: invokeinterface 1061 1 0
    //   7481: aload_0
    //   7482: aconst_null
    //   7483: putfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7486: goto +17 -> 7503
    //   7489: aload_0
    //   7490: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7493: ifnull +10 -> 7503
    //   7496: aload_0
    //   7497: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7500: invokevirtual 1066	org/apache/http/client/methods/HttpGet:abort	()V
    //   7503: aload_1
    //   7504: astore 24
    //   7506: ldc 230
    //   7508: astore 25
    //   7510: iload 5
    //   7512: istore_3
    //   7513: goto +3117 -> 10630
    //   7516: astore 23
    //   7518: goto +10 -> 7528
    //   7521: astore 23
    //   7523: goto +48 -> 7571
    //   7526: astore 23
    //   7528: aload 22
    //   7530: astore 28
    //   7532: iload_3
    //   7533: istore 5
    //   7535: lload 10
    //   7537: lstore 8
    //   7539: aload 24
    //   7541: astore 22
    //   7543: ldc_w 562
    //   7546: astore 27
    //   7548: aconst_null
    //   7549: astore 25
    //   7551: iload 4
    //   7553: istore_3
    //   7554: aload 23
    //   7556: astore 24
    //   7558: iload 5
    //   7560: istore 4
    //   7562: aload 29
    //   7564: astore 23
    //   7566: goto +3172 -> 10738
    //   7569: astore 23
    //   7571: lload 10
    //   7573: lstore 8
    //   7575: iload 4
    //   7577: istore 5
    //   7579: aload 22
    //   7581: astore 26
    //   7583: aload 23
    //   7585: astore 22
    //   7587: ldc_w 562
    //   7590: astore 25
    //   7592: iload_3
    //   7593: istore 4
    //   7595: aload 29
    //   7597: astore 23
    //   7599: iload 5
    //   7601: istore_3
    //   7602: goto +284 -> 7886
    //   7605: astore 23
    //   7607: lload 10
    //   7609: lstore 8
    //   7611: aconst_null
    //   7612: astore 25
    //   7614: aload 22
    //   7616: astore 28
    //   7618: iload_3
    //   7619: istore 4
    //   7621: goto +215 -> 7836
    //   7624: astore 23
    //   7626: lload 10
    //   7628: lstore 8
    //   7630: aload 22
    //   7632: astore 26
    //   7634: aload 23
    //   7636: astore 22
    //   7638: goto +27 -> 7665
    //   7641: astore 22
    //   7643: goto +10 -> 7653
    //   7646: astore 22
    //   7648: goto +14 -> 7662
    //   7651: astore 22
    //   7653: aload 22
    //   7655: astore 23
    //   7657: goto +50 -> 7707
    //   7660: astore 22
    //   7662: aconst_null
    //   7663: astore 26
    //   7665: goto +13 -> 7678
    //   7668: astore 22
    //   7670: goto +33 -> 7703
    //   7673: astore 22
    //   7675: aconst_null
    //   7676: astore 26
    //   7678: iload_3
    //   7679: istore 4
    //   7681: aload 29
    //   7683: astore 23
    //   7685: goto +194 -> 7879
    //   7688: astore 22
    //   7690: goto +13 -> 7703
    //   7693: astore 22
    //   7695: iload_3
    //   7696: istore 4
    //   7698: goto +26 -> 7724
    //   7701: astore 22
    //   7703: aload 22
    //   7705: astore 23
    //   7707: aconst_null
    //   7708: astore 28
    //   7710: aconst_null
    //   7711: astore 25
    //   7713: iload_3
    //   7714: istore 4
    //   7716: goto +120 -> 7836
    //   7719: astore 22
    //   7721: iload_3
    //   7722: istore 4
    //   7724: ldc 230
    //   7726: astore 23
    //   7728: aconst_null
    //   7729: astore 26
    //   7731: ldc 91
    //   7733: astore 24
    //   7735: goto +144 -> 7879
    //   7738: astore 22
    //   7740: goto +20 -> 7760
    //   7743: astore 22
    //   7745: goto +53 -> 7798
    //   7748: astore 22
    //   7750: goto +10 -> 7760
    //   7753: astore 22
    //   7755: goto +43 -> 7798
    //   7758: astore 22
    //   7760: aload 27
    //   7762: astore 24
    //   7764: aconst_null
    //   7765: astore 28
    //   7767: ldc 230
    //   7769: astore 26
    //   7771: iload_3
    //   7772: istore 4
    //   7774: aload 22
    //   7776: astore 23
    //   7778: aload 28
    //   7780: astore 25
    //   7782: iconst_0
    //   7783: istore_3
    //   7784: ldc_w 562
    //   7787: astore 27
    //   7789: ldc 91
    //   7791: astore 22
    //   7793: goto +2961 -> 10754
    //   7796: astore 22
    //   7798: iload_3
    //   7799: istore 4
    //   7801: ldc 230
    //   7803: astore 23
    //   7805: aconst_null
    //   7806: astore 26
    //   7808: ldc 91
    //   7810: astore 24
    //   7812: iconst_0
    //   7813: istore_3
    //   7814: ldc_w 562
    //   7817: astore 25
    //   7819: goto +67 -> 7886
    //   7822: aload 22
    //   7824: athrow
    //   7825: astore 23
    //   7827: aconst_null
    //   7828: astore 28
    //   7830: aconst_null
    //   7831: astore 25
    //   7833: iload_3
    //   7834: istore 4
    //   7836: ldc 230
    //   7838: astore 26
    //   7840: ldc_w 564
    //   7843: astore 30
    //   7845: aload 27
    //   7847: astore 24
    //   7849: ldc_w 562
    //   7852: astore 27
    //   7854: ldc 91
    //   7856: astore 22
    //   7858: iconst_0
    //   7859: istore_3
    //   7860: goto +2894 -> 10754
    //   7863: astore 22
    //   7865: ldc 230
    //   7867: astore 23
    //   7869: ldc 91
    //   7871: astore 24
    //   7873: aconst_null
    //   7874: astore 26
    //   7876: iload_3
    //   7877: istore 4
    //   7879: ldc_w 562
    //   7882: astore 25
    //   7884: iconst_0
    //   7885: istore_3
    //   7886: aload 27
    //   7888: astore 31
    //   7890: aload_2
    //   7891: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7894: aload 22
    //   7896: invokevirtual 1069	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   7899: aload_0
    //   7900: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7903: astore 27
    //   7905: aload 27
    //   7907: ifnull +116 -> 8023
    //   7910: aload_0
    //   7911: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   7914: astore 27
    //   7916: aload 27
    //   7918: ldc_w 1071
    //   7921: invokevirtual 620	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7924: ifeq +99 -> 8023
    //   7927: aload_0
    //   7928: iconst_1
    //   7929: putfield 1074	com/tencent/component/network/downloader/impl/StrictDownloadTask:disableHttps	Z
    //   7932: iload 4
    //   7934: iconst_1
    //   7935: isub
    //   7936: istore 4
    //   7938: ldc_w 564
    //   7941: ldc_w 1076
    //   7944: invokestatic 1078	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7947: goto +76 -> 8023
    //   7950: astore 28
    //   7952: aload 25
    //   7954: astore 27
    //   7956: ldc_w 564
    //   7959: astore 30
    //   7961: aload 22
    //   7963: astore 25
    //   7965: aload 24
    //   7967: astore 22
    //   7969: aload 28
    //   7971: astore 24
    //   7973: aload 26
    //   7975: astore 28
    //   7977: goto +2761 -> 10738
    //   7980: astore 27
    //   7982: goto +5 -> 7987
    //   7985: astore 27
    //   7987: ldc_w 564
    //   7990: astore 30
    //   7992: aload 24
    //   7994: astore 28
    //   7996: aload 22
    //   7998: astore 29
    //   8000: aload 27
    //   8002: astore 24
    //   8004: aload 28
    //   8006: astore 22
    //   8008: aload 26
    //   8010: astore 28
    //   8012: aload 25
    //   8014: astore 27
    //   8016: aload 29
    //   8018: astore 25
    //   8020: goto +2718 -> 10738
    //   8023: aload 22
    //   8025: astore 29
    //   8027: iload 4
    //   8029: iconst_1
    //   8030: iadd
    //   8031: istore 4
    //   8033: aload_2
    //   8034: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8037: lload 14
    //   8039: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8042: invokevirtual 785	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   8045: aload_2
    //   8046: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8049: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8052: aload_0
    //   8053: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   8056: lsub
    //   8057: putfield 788	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8060: aload_2
    //   8061: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8064: aload_0
    //   8065: getfield 791	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   8068: putfield 794	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8071: aload_0
    //   8072: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8075: invokestatic 799	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8078: invokevirtual 803	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8081: astore 33
    //   8083: aload_0
    //   8084: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8087: ifnull +28 -> 8115
    //   8090: aload_0
    //   8091: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8094: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8097: ifnull +18 -> 8115
    //   8100: aload_0
    //   8101: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8104: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8107: invokevirtual 804	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   8110: astore 27
    //   8112: goto +8 -> 8120
    //   8115: ldc_w 806
    //   8118: astore 27
    //   8120: aload_0
    //   8121: aload_0
    //   8122: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8125: aload_0
    //   8126: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8129: aload_0
    //   8130: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8133: invokevirtual 810	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   8136: astore 30
    //   8138: aload 27
    //   8140: ifnull +10 -> 8150
    //   8143: aload 27
    //   8145: astore 22
    //   8147: goto +8 -> 8155
    //   8150: ldc_w 812
    //   8153: astore 22
    //   8155: aload 26
    //   8157: ifnull +21 -> 8178
    //   8160: aload 26
    //   8162: ldc_w 814
    //   8165: invokeinterface 820 2 0
    //   8170: checkcast 448	java/lang/String
    //   8173: astore 26
    //   8175: goto +8 -> 8183
    //   8178: ldc_w 510
    //   8181: astore 26
    //   8183: aload_2
    //   8184: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8187: aload 26
    //   8189: putfield 829	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8192: aload_2
    //   8193: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8196: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8199: ifne +70 -> 8269
    //   8202: aload_0
    //   8203: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8206: ifnull +31 -> 8237
    //   8209: aload_0
    //   8210: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8213: aload_0
    //   8214: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8217: aload_2
    //   8218: invokevirtual 835	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   8221: aload_0
    //   8222: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   8225: aload_0
    //   8226: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8229: invokeinterface 839 5 0
    //   8234: goto +3 -> 8237
    //   8237: aload_0
    //   8238: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8241: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8244: ifne +25 -> 8269
    //   8247: aload_0
    //   8248: aload_0
    //   8249: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8252: iconst_1
    //   8253: isub
    //   8254: putfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8257: aload_2
    //   8258: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8261: bipush 6
    //   8263: invokevirtual 744	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   8266: goto +3 -> 8269
    //   8269: aload 26
    //   8271: astore 32
    //   8273: aload_1
    //   8274: invokeinterface 521 1 0
    //   8279: ifne +2293 -> 10572
    //   8282: aload_2
    //   8283: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8286: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8289: ifne +891 -> 9180
    //   8292: new 80	java/lang/StringBuilder
    //   8295: dup
    //   8296: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   8299: astore 34
    //   8301: aload 34
    //   8303: ldc_w 841
    //   8306: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8309: pop
    //   8310: aload 34
    //   8312: aload_0
    //   8313: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   8316: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8319: pop
    //   8320: aload 34
    //   8322: ldc_w 843
    //   8325: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8328: pop
    //   8329: aload 34
    //   8331: aload_0
    //   8332: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   8335: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8338: pop
    //   8339: aload 34
    //   8341: ldc_w 845
    //   8344: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8347: pop
    //   8348: aload_0
    //   8349: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   8352: ifeq +37 -> 8389
    //   8355: aload_0
    //   8356: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8359: astore 26
    //   8361: aload 26
    //   8363: ifnull +26 -> 8389
    //   8366: aload 26
    //   8368: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8371: ifnull +18 -> 8389
    //   8374: aload_0
    //   8375: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   8378: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8381: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8384: astore 26
    //   8386: goto +8 -> 8394
    //   8389: ldc_w 854
    //   8392: astore 26
    //   8394: aload 34
    //   8396: aload 26
    //   8398: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8401: pop
    //   8402: aload 34
    //   8404: ldc_w 856
    //   8407: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8410: pop
    //   8411: aload 34
    //   8413: aload 33
    //   8415: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8418: pop
    //   8419: aload 34
    //   8421: ldc_w 861
    //   8424: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8427: pop
    //   8428: aload 34
    //   8430: aload 27
    //   8432: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8435: pop
    //   8436: aload 34
    //   8438: ldc_w 695
    //   8441: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8444: pop
    //   8445: aload 34
    //   8447: ldc_w 806
    //   8450: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8453: pop
    //   8454: aload 34
    //   8456: aload 25
    //   8458: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8461: pop
    //   8462: aload 34
    //   8464: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8467: invokevirtual 340	java/lang/Thread:getId	()J
    //   8470: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8473: pop
    //   8474: aload 34
    //   8476: ldc_w 863
    //   8479: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8482: pop
    //   8483: aload 34
    //   8485: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8488: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8491: pop
    //   8492: aload 34
    //   8494: ldc_w 865
    //   8497: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8500: pop
    //   8501: aload 34
    //   8503: aload_0
    //   8504: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   8507: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8510: pop
    //   8511: aload 34
    //   8513: ldc_w 867
    //   8516: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8519: pop
    //   8520: aload 34
    //   8522: aload_0
    //   8523: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   8526: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8529: pop
    //   8530: aload 34
    //   8532: ldc_w 869
    //   8535: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8538: pop
    //   8539: aload_0
    //   8540: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   8543: ifeq +19 -> 8562
    //   8546: aload_0
    //   8547: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8550: aload_0
    //   8551: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   8554: invokestatic 500	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8557: astore 25
    //   8559: goto +6 -> 8565
    //   8562: aconst_null
    //   8563: astore 25
    //   8565: aload 34
    //   8567: aload 25
    //   8569: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8572: pop
    //   8573: aload 34
    //   8575: ldc_w 871
    //   8578: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8581: pop
    //   8582: aload 34
    //   8584: aload_0
    //   8585: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   8588: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8591: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8594: pop
    //   8595: aload 34
    //   8597: ldc_w 873
    //   8600: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8603: pop
    //   8604: aload 34
    //   8606: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8609: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8612: pop
    //   8613: aload 34
    //   8615: ldc_w 875
    //   8618: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8621: pop
    //   8622: aload 34
    //   8624: aload_2
    //   8625: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8628: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8631: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8634: pop
    //   8635: aload 34
    //   8637: ldc_w 880
    //   8640: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8643: pop
    //   8644: aload 34
    //   8646: aload_2
    //   8647: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8650: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8653: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8656: pop
    //   8657: aload 34
    //   8659: ldc_w 885
    //   8662: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8665: pop
    //   8666: aload 34
    //   8668: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   8671: aload_0
    //   8672: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   8675: lsub
    //   8676: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8679: pop
    //   8680: aload 34
    //   8682: ldc_w 887
    //   8685: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8688: pop
    //   8689: aload 34
    //   8691: aload_2
    //   8692: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8695: getfield 890	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8698: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8701: pop
    //   8702: aload 34
    //   8704: ldc_w 892
    //   8707: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8710: pop
    //   8711: aload 34
    //   8713: aload_2
    //   8714: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8717: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8720: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8723: pop
    //   8724: aload 34
    //   8726: ldc_w 896
    //   8729: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8732: pop
    //   8733: aload 34
    //   8735: aload_2
    //   8736: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8739: getfield 899	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8742: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8745: pop
    //   8746: aload 34
    //   8748: ldc_w 901
    //   8751: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8754: pop
    //   8755: aload 34
    //   8757: aload_0
    //   8758: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   8761: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8764: pop
    //   8765: aload 34
    //   8767: aload 24
    //   8769: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8772: pop
    //   8773: aload 34
    //   8775: aload_0
    //   8776: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   8779: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8782: pop
    //   8783: aload 34
    //   8785: ldc_w 906
    //   8788: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8791: pop
    //   8792: aload 34
    //   8794: iload 4
    //   8796: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8799: pop
    //   8800: aload 34
    //   8802: ldc_w 908
    //   8805: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8808: pop
    //   8809: aload 34
    //   8811: aload_2
    //   8812: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8815: invokevirtual 911	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8818: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8821: pop
    //   8822: aload 34
    //   8824: ldc_w 913
    //   8827: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8830: pop
    //   8831: aload 34
    //   8833: iload_3
    //   8834: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8837: pop
    //   8838: aload 34
    //   8840: ldc_w 915
    //   8843: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8846: pop
    //   8847: aload 34
    //   8849: aload 30
    //   8851: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8854: pop
    //   8855: aload 34
    //   8857: ldc_w 917
    //   8860: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8863: pop
    //   8864: aload 34
    //   8866: aload 32
    //   8868: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8871: pop
    //   8872: aload 34
    //   8874: ldc_w 919
    //   8877: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8880: pop
    //   8881: aload_0
    //   8882: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   8885: astore 26
    //   8887: aload 26
    //   8889: astore 25
    //   8891: aload 26
    //   8893: ifnull +13 -> 8906
    //   8896: aload 26
    //   8898: iconst_0
    //   8899: bipush 30
    //   8901: invokevirtual 923	java/lang/String:substring	(II)Ljava/lang/String;
    //   8904: astore 25
    //   8906: aload 34
    //   8908: aload 25
    //   8910: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8913: pop
    //   8914: aload 34
    //   8916: ldc_w 925
    //   8919: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8922: pop
    //   8923: aload_0
    //   8924: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8927: ifnull +15 -> 8942
    //   8930: aload_0
    //   8931: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8934: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8937: istore 5
    //   8939: goto +6 -> 8945
    //   8942: iconst_0
    //   8943: istore 5
    //   8945: aload 34
    //   8947: iload 5
    //   8949: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8952: pop
    //   8953: aload 34
    //   8955: ldc_w 927
    //   8958: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8961: pop
    //   8962: aload 34
    //   8964: aload_2
    //   8965: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8968: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8971: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8974: pop
    //   8975: aload 34
    //   8977: ldc_w 932
    //   8980: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8983: pop
    //   8984: aload 34
    //   8986: lload 8
    //   8988: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8991: pop
    //   8992: aload 34
    //   8994: ldc_w 934
    //   8997: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9000: pop
    //   9001: aload 34
    //   9003: aload_0
    //   9004: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   9007: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9010: pop
    //   9011: aload 34
    //   9013: aload 24
    //   9015: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9018: pop
    //   9019: aload 34
    //   9021: aload_0
    //   9022: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   9025: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9028: pop
    //   9029: aload 34
    //   9031: ldc_w 936
    //   9034: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9037: pop
    //   9038: aload 34
    //   9040: aload_0
    //   9041: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   9044: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9047: pop
    //   9048: aload 34
    //   9050: aload 24
    //   9052: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9055: pop
    //   9056: aload 34
    //   9058: aload_0
    //   9059: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   9062: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9065: pop
    //   9066: aload 34
    //   9068: ldc_w 938
    //   9071: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9074: pop
    //   9075: aload 34
    //   9077: aload_0
    //   9078: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   9081: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9084: pop
    //   9085: aload 34
    //   9087: ldc_w 940
    //   9090: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9093: pop
    //   9094: aload 34
    //   9096: aload_0
    //   9097: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   9100: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9103: pop
    //   9104: aload 34
    //   9106: ldc_w 945
    //   9109: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9112: pop
    //   9113: aload 34
    //   9115: aload_0
    //   9116: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   9119: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9122: pop
    //   9123: aload 34
    //   9125: ldc_w 950
    //   9128: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9131: pop
    //   9132: aload_0
    //   9133: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9136: ifnull +17 -> 9153
    //   9139: aload_0
    //   9140: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9143: invokeinterface 590 1 0
    //   9148: astore 24
    //   9150: goto +6 -> 9156
    //   9153: aconst_null
    //   9154: astore 24
    //   9156: aload 34
    //   9158: aload 24
    //   9160: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9163: pop
    //   9164: ldc_w 564
    //   9167: aload 34
    //   9169: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9172: aload 29
    //   9174: invokestatic 954	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9177: goto +843 -> 10020
    //   9180: new 80	java/lang/StringBuilder
    //   9183: dup
    //   9184: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   9187: astore 34
    //   9189: aload 34
    //   9191: ldc_w 956
    //   9194: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9197: pop
    //   9198: aload 34
    //   9200: aload_0
    //   9201: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   9204: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9207: pop
    //   9208: aload 34
    //   9210: ldc_w 843
    //   9213: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9216: pop
    //   9217: aload 34
    //   9219: aload_0
    //   9220: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9223: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9226: pop
    //   9227: aload 34
    //   9229: ldc_w 845
    //   9232: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9235: pop
    //   9236: aload_0
    //   9237: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   9240: ifeq +37 -> 9277
    //   9243: aload_0
    //   9244: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   9247: astore 26
    //   9249: aload 26
    //   9251: ifnull +26 -> 9277
    //   9254: aload 26
    //   9256: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9259: ifnull +18 -> 9277
    //   9262: aload_0
    //   9263: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   9266: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9269: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9272: astore 26
    //   9274: goto +8 -> 9282
    //   9277: ldc_w 854
    //   9280: astore 26
    //   9282: aload 34
    //   9284: aload 26
    //   9286: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9289: pop
    //   9290: aload 34
    //   9292: ldc_w 856
    //   9295: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9298: pop
    //   9299: aload 34
    //   9301: aload 33
    //   9303: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9306: pop
    //   9307: aload 34
    //   9309: ldc_w 861
    //   9312: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9315: pop
    //   9316: aload 34
    //   9318: aload 27
    //   9320: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9323: pop
    //   9324: aload 34
    //   9326: ldc_w 695
    //   9329: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9332: pop
    //   9333: aload 34
    //   9335: ldc_w 806
    //   9338: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9341: pop
    //   9342: aload 34
    //   9344: aload 25
    //   9346: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9349: pop
    //   9350: aload 34
    //   9352: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9355: invokevirtual 340	java/lang/Thread:getId	()J
    //   9358: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9361: pop
    //   9362: aload 34
    //   9364: ldc_w 863
    //   9367: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9370: pop
    //   9371: aload 34
    //   9373: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9376: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9379: pop
    //   9380: aload 34
    //   9382: ldc_w 865
    //   9385: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9388: pop
    //   9389: aload 34
    //   9391: aload_0
    //   9392: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   9395: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9398: pop
    //   9399: aload 34
    //   9401: ldc_w 867
    //   9404: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9407: pop
    //   9408: aload 34
    //   9410: aload_0
    //   9411: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   9414: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9417: pop
    //   9418: aload 34
    //   9420: ldc_w 869
    //   9423: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9426: pop
    //   9427: aload_0
    //   9428: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   9431: ifeq +19 -> 9450
    //   9434: aload_0
    //   9435: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   9438: aload_0
    //   9439: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   9442: invokestatic 500	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9445: astore 25
    //   9447: goto +6 -> 9453
    //   9450: aconst_null
    //   9451: astore 25
    //   9453: aload 34
    //   9455: aload 25
    //   9457: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9460: pop
    //   9461: aload 34
    //   9463: ldc_w 873
    //   9466: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9469: pop
    //   9470: aload 34
    //   9472: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9475: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9478: pop
    //   9479: aload 34
    //   9481: ldc_w 880
    //   9484: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9487: pop
    //   9488: aload 34
    //   9490: aload_2
    //   9491: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9494: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9497: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9500: pop
    //   9501: aload 34
    //   9503: ldc_w 885
    //   9506: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9509: pop
    //   9510: aload 34
    //   9512: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   9515: aload_0
    //   9516: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   9519: lsub
    //   9520: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9523: pop
    //   9524: aload 34
    //   9526: ldc_w 887
    //   9529: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9532: pop
    //   9533: aload 34
    //   9535: aload_2
    //   9536: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9539: getfield 890	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9542: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9545: pop
    //   9546: aload 34
    //   9548: ldc_w 892
    //   9551: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9554: pop
    //   9555: aload 34
    //   9557: aload_2
    //   9558: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9561: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9564: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9567: pop
    //   9568: aload 34
    //   9570: ldc_w 896
    //   9573: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9576: pop
    //   9577: aload 34
    //   9579: aload_2
    //   9580: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9583: getfield 899	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9586: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9589: pop
    //   9590: aload 34
    //   9592: ldc_w 901
    //   9595: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9598: pop
    //   9599: aload 34
    //   9601: aload_0
    //   9602: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   9605: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9608: pop
    //   9609: aload 34
    //   9611: aload 24
    //   9613: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9616: pop
    //   9617: aload 34
    //   9619: aload_0
    //   9620: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   9623: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9626: pop
    //   9627: aload 34
    //   9629: ldc_w 906
    //   9632: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9635: pop
    //   9636: aload 34
    //   9638: iload 4
    //   9640: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9643: pop
    //   9644: aload 34
    //   9646: ldc_w 958
    //   9649: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9652: pop
    //   9653: aload 34
    //   9655: iload_3
    //   9656: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9659: pop
    //   9660: aload 34
    //   9662: ldc_w 875
    //   9665: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9668: pop
    //   9669: aload 34
    //   9671: aload_2
    //   9672: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9675: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9678: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9681: pop
    //   9682: aload 34
    //   9684: ldc_w 915
    //   9687: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9690: pop
    //   9691: aload 34
    //   9693: aload 30
    //   9695: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9698: pop
    //   9699: aload 34
    //   9701: ldc_w 917
    //   9704: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9707: pop
    //   9708: aload 34
    //   9710: aload 32
    //   9712: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9715: pop
    //   9716: aload 34
    //   9718: ldc_w 919
    //   9721: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9724: pop
    //   9725: aload_0
    //   9726: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   9729: astore 26
    //   9731: aload 26
    //   9733: astore 25
    //   9735: aload 26
    //   9737: ifnull +13 -> 9750
    //   9740: aload 26
    //   9742: iconst_0
    //   9743: bipush 30
    //   9745: invokevirtual 923	java/lang/String:substring	(II)Ljava/lang/String;
    //   9748: astore 25
    //   9750: aload 34
    //   9752: aload 25
    //   9754: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9757: pop
    //   9758: aload 34
    //   9760: ldc_w 925
    //   9763: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9766: pop
    //   9767: aload_0
    //   9768: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9771: ifnull +15 -> 9786
    //   9774: aload_0
    //   9775: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9778: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9781: istore 5
    //   9783: goto +6 -> 9789
    //   9786: iconst_0
    //   9787: istore 5
    //   9789: aload 34
    //   9791: iload 5
    //   9793: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9796: pop
    //   9797: aload 34
    //   9799: ldc_w 927
    //   9802: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9805: pop
    //   9806: aload 34
    //   9808: aload_2
    //   9809: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9812: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9815: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9818: pop
    //   9819: aload 34
    //   9821: ldc_w 932
    //   9824: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9827: pop
    //   9828: aload 34
    //   9830: lload 8
    //   9832: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9835: pop
    //   9836: aload 34
    //   9838: ldc_w 934
    //   9841: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9844: pop
    //   9845: aload 34
    //   9847: aload_0
    //   9848: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   9851: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9854: pop
    //   9855: aload 34
    //   9857: aload 24
    //   9859: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9862: pop
    //   9863: aload 34
    //   9865: aload_0
    //   9866: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   9869: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9872: pop
    //   9873: aload 34
    //   9875: ldc_w 936
    //   9878: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9881: pop
    //   9882: aload 34
    //   9884: aload_0
    //   9885: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   9888: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9891: pop
    //   9892: aload 34
    //   9894: aload 24
    //   9896: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9899: pop
    //   9900: aload 34
    //   9902: aload_0
    //   9903: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   9906: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9909: pop
    //   9910: aload 34
    //   9912: ldc_w 938
    //   9915: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9918: pop
    //   9919: aload 34
    //   9921: aload_0
    //   9922: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   9925: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9928: pop
    //   9929: aload 34
    //   9931: ldc_w 940
    //   9934: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9937: pop
    //   9938: aload 34
    //   9940: aload_0
    //   9941: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   9944: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9947: pop
    //   9948: aload 34
    //   9950: ldc_w 945
    //   9953: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9956: pop
    //   9957: aload 34
    //   9959: aload_0
    //   9960: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   9963: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9966: pop
    //   9967: aload 34
    //   9969: ldc_w 950
    //   9972: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9975: pop
    //   9976: aload_0
    //   9977: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9980: ifnull +17 -> 9997
    //   9983: aload_0
    //   9984: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9987: invokeinterface 590 1 0
    //   9992: astore 24
    //   9994: goto +6 -> 10000
    //   9997: aconst_null
    //   9998: astore 24
    //   10000: aload 34
    //   10002: aload 24
    //   10004: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10007: pop
    //   10008: ldc_w 564
    //   10011: aload 34
    //   10013: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10016: aconst_null
    //   10017: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10020: aload_0
    //   10021: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10024: ifnull +71 -> 10095
    //   10027: getstatic 369	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10030: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10033: aload_0
    //   10034: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10037: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10040: if_icmpne +55 -> 10095
    //   10043: aload_0
    //   10044: getfield 400	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10047: ifnull +48 -> 10095
    //   10050: aload_0
    //   10051: getfield 400	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10054: aload_0
    //   10055: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   10058: aload_0
    //   10059: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10062: invokestatic 963	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   10065: aload_2
    //   10066: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10069: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10072: invokeinterface 967 4 0
    //   10077: goto +18 -> 10095
    //   10080: astore 24
    //   10082: aload 23
    //   10084: ldc_w 968
    //   10087: aload 24
    //   10089: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10092: goto +3 -> 10095
    //   10095: aload_0
    //   10096: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10099: ifnull +68 -> 10167
    //   10102: getstatic 478	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10105: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10108: aload_0
    //   10109: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10112: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10115: if_icmpne +52 -> 10167
    //   10118: aload_0
    //   10119: getfield 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10122: ifnull +45 -> 10167
    //   10125: aload_0
    //   10126: getfield 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10129: aload_0
    //   10130: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   10133: aload_0
    //   10134: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10137: invokestatic 963	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   10140: aload_2
    //   10141: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10144: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10147: invokeinterface 967 4 0
    //   10152: goto +15 -> 10167
    //   10155: astore 24
    //   10157: aload 23
    //   10159: ldc_w 969
    //   10162: aload 24
    //   10164: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10167: aload 31
    //   10169: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   10172: putfield 972	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   10175: aload 31
    //   10177: aload_0
    //   10178: getfield 975	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   10181: putfield 978	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   10184: aload 31
    //   10186: aload_0
    //   10187: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   10190: putfield 979	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   10193: aload 31
    //   10195: iload_3
    //   10196: putfield 980	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   10199: aload 31
    //   10201: aload 29
    //   10203: putfield 984	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   10206: aload 33
    //   10208: ifnonnull +9 -> 10217
    //   10211: aconst_null
    //   10212: astore 24
    //   10214: goto +10 -> 10224
    //   10217: aload 33
    //   10219: invokevirtual 987	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10222: astore 24
    //   10224: aload 31
    //   10226: aload 24
    //   10228: putfield 990	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   10231: aload_0
    //   10232: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10235: ifnull +28 -> 10263
    //   10238: aload_0
    //   10239: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10242: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10245: ifnull +18 -> 10263
    //   10248: aload_0
    //   10249: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10252: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10255: getfield 627	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   10258: astore 24
    //   10260: goto +6 -> 10266
    //   10263: aconst_null
    //   10264: astore 24
    //   10266: aload 31
    //   10268: aload 24
    //   10270: putfield 993	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   10273: aload 31
    //   10275: ldc_w 806
    //   10278: putfield 996	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   10281: aload 31
    //   10283: aload_2
    //   10284: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10287: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10290: putfield 997	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   10293: aload 31
    //   10295: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   10298: aload_0
    //   10299: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   10302: lsub
    //   10303: putfield 1000	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   10306: aload 31
    //   10308: aload_2
    //   10309: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10312: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10315: putfield 1003	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   10318: aload 31
    //   10320: aload 31
    //   10322: getfield 1000	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   10325: aload_2
    //   10326: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10329: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10332: lsub
    //   10333: putfield 1006	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   10336: aload 31
    //   10338: lload 8
    //   10340: putfield 1009	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   10343: aload 31
    //   10345: aload_0
    //   10346: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   10349: putfield 1012	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   10352: aload 31
    //   10354: aload_0
    //   10355: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   10358: putfield 1015	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   10361: aload 31
    //   10363: aload_0
    //   10364: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   10367: putfield 1018	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   10370: aload 31
    //   10372: lconst_0
    //   10373: putfield 1021	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   10376: aload 31
    //   10378: aload_0
    //   10379: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   10382: putfield 1024	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   10385: aload 31
    //   10387: aload_2
    //   10388: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10391: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10394: putfield 1027	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   10397: aload 31
    //   10399: aload_0
    //   10400: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   10403: invokestatic 1030	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   10406: putfield 1032	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   10409: aload 31
    //   10411: aload_0
    //   10412: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10415: putfield 1035	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   10418: aload_0
    //   10419: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   10422: astore 24
    //   10424: aload 24
    //   10426: ifnull +20 -> 10446
    //   10429: aload 24
    //   10431: ldc_w 617
    //   10434: invokevirtual 620	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10437: ifeq +9 -> 10446
    //   10440: iconst_1
    //   10441: istore 20
    //   10443: goto +6 -> 10449
    //   10446: iconst_0
    //   10447: istore 20
    //   10449: aload 31
    //   10451: iload 20
    //   10453: putfield 1038	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   10456: aload 31
    //   10458: aload_2
    //   10459: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10462: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10465: putfield 1040	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   10468: aload 31
    //   10470: getstatic 1046	com/tencent/component/network/downloader/Downloader$DownloadMode:StrictMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   10473: invokevirtual 1049	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   10476: putfield 1052	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   10479: aload_0
    //   10480: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   10483: astore 24
    //   10485: aload 24
    //   10487: ifnull +26 -> 10513
    //   10490: aload 24
    //   10492: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10495: ifnull +18 -> 10513
    //   10498: aload 31
    //   10500: aload_0
    //   10501: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   10504: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10507: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   10510: putfield 1054	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   10513: aload_2
    //   10514: astore 24
    //   10516: aload 24
    //   10518: aload 31
    //   10520: invokevirtual 1058	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   10523: aload_0
    //   10524: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   10527: aload_0
    //   10528: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   10531: iconst_1
    //   10532: isub
    //   10533: if_icmpeq +23 -> 10556
    //   10536: aload_2
    //   10537: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10540: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10543: ifeq +6 -> 10549
    //   10546: goto +10 -> 10556
    //   10549: aload 23
    //   10551: astore 25
    //   10553: goto +23 -> 10576
    //   10556: aload_0
    //   10557: aload_1
    //   10558: aload 24
    //   10560: aload 31
    //   10562: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   10565: aload 23
    //   10567: astore 25
    //   10569: goto +7 -> 10576
    //   10572: aload 23
    //   10574: astore 25
    //   10576: aload_2
    //   10577: astore 23
    //   10579: aload_1
    //   10580: astore 24
    //   10582: aload_0
    //   10583: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   10586: ifeq +27 -> 10613
    //   10589: aload_0
    //   10590: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   10593: ifnull +12 -> 10605
    //   10596: aload_0
    //   10597: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   10600: invokeinterface 1061 1 0
    //   10605: aload_0
    //   10606: aconst_null
    //   10607: putfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   10610: goto +17 -> 10627
    //   10613: aload_0
    //   10614: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10617: ifnull +10 -> 10627
    //   10620: aload_0
    //   10621: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10624: invokevirtual 1066	org/apache/http/client/methods/HttpGet:abort	()V
    //   10627: iload 4
    //   10629: istore_3
    //   10630: aload_0
    //   10631: invokevirtual 1081	com/tencent/component/network/downloader/impl/StrictDownloadTask:canAttempt	()Z
    //   10634: ifne +74 -> 10708
    //   10637: aload 22
    //   10639: astore_1
    //   10640: aload_0
    //   10641: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   10644: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10647: ifne +12 -> 10659
    //   10650: aload_2
    //   10651: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10654: bipush 6
    //   10656: invokevirtual 744	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   10659: aload 23
    //   10661: aload_0
    //   10662: aload_2
    //   10663: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10666: invokevirtual 911	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   10669: aload_2
    //   10670: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10673: getfield 752	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   10676: iload_3
    //   10677: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10680: aload 28
    //   10682: aload_2
    //   10683: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10686: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10689: aload_1
    //   10690: invokespecial 1083	com/tencent/component/network/downloader/impl/StrictDownloadTask:generateDownloadDescInfo	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10693: invokevirtual 1086	com/tencent/component/network/downloader/DownloadResult:setDescInfo	(Ljava/lang/String;)V
    //   10696: return
    //   10697: astore_1
    //   10698: aload 25
    //   10700: ldc_w 510
    //   10703: aload_1
    //   10704: invokestatic 954	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10707: return
    //   10708: goto -10661 -> 47
    //   10711: astore 29
    //   10713: aload 25
    //   10715: astore 27
    //   10717: ldc_w 564
    //   10720: astore 30
    //   10722: aload 22
    //   10724: astore 25
    //   10726: aload 26
    //   10728: astore 28
    //   10730: aload 24
    //   10732: astore 22
    //   10734: aload 29
    //   10736: astore 24
    //   10738: aload 24
    //   10740: astore 29
    //   10742: aload 23
    //   10744: astore 26
    //   10746: aload 31
    //   10748: astore 24
    //   10750: aload 29
    //   10752: astore 23
    //   10754: iload 4
    //   10756: iconst_1
    //   10757: iadd
    //   10758: istore 4
    //   10760: aload_2
    //   10761: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10764: lload 14
    //   10766: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   10769: invokevirtual 785	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   10772: aload_2
    //   10773: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10776: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   10779: aload_0
    //   10780: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   10783: lsub
    //   10784: putfield 788	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   10787: aload_2
    //   10788: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10791: aload_0
    //   10792: getfield 791	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTaskStartTimeStamp	J
    //   10795: putfield 794	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   10798: aload_0
    //   10799: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   10802: invokestatic 799	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   10805: invokevirtual 803	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   10808: astore 33
    //   10810: aload_0
    //   10811: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10814: ifnull +28 -> 10842
    //   10817: aload_0
    //   10818: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10821: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10824: ifnull +18 -> 10842
    //   10827: aload_0
    //   10828: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10831: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10834: invokevirtual 804	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   10837: astore 29
    //   10839: goto +8 -> 10847
    //   10842: ldc_w 806
    //   10845: astore 29
    //   10847: aload_0
    //   10848: aload_0
    //   10849: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10852: aload_0
    //   10853: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   10856: aload_0
    //   10857: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   10860: invokevirtual 810	com/tencent/component/network/downloader/impl/StrictDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   10863: astore 32
    //   10865: aload 28
    //   10867: ifnull +21 -> 10888
    //   10870: aload 28
    //   10872: ldc_w 814
    //   10875: invokeinterface 820 2 0
    //   10880: checkcast 448	java/lang/String
    //   10883: astore 28
    //   10885: goto +8 -> 10893
    //   10888: ldc_w 510
    //   10891: astore 28
    //   10893: aload_2
    //   10894: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10897: aload 28
    //   10899: putfield 829	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   10902: aload_2
    //   10903: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10906: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10909: ifne +70 -> 10979
    //   10912: aload_0
    //   10913: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10916: ifnull +31 -> 10947
    //   10919: aload_0
    //   10920: getfield 684	com/tencent/component/network/downloader/impl/StrictDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10923: aload_0
    //   10924: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   10927: aload_2
    //   10928: invokevirtual 835	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   10931: aload_0
    //   10932: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   10935: aload_0
    //   10936: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   10939: invokeinterface 839 5 0
    //   10944: goto +3 -> 10947
    //   10947: aload_0
    //   10948: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   10951: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10954: ifne +25 -> 10979
    //   10957: aload_0
    //   10958: aload_0
    //   10959: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   10962: iconst_1
    //   10963: isub
    //   10964: putfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   10967: aload_2
    //   10968: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10971: bipush 6
    //   10973: invokevirtual 744	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   10976: goto +3 -> 10979
    //   10979: aload 22
    //   10981: astore 31
    //   10983: aload_1
    //   10984: invokeinterface 521 1 0
    //   10989: ifne +2273 -> 13262
    //   10992: aload_2
    //   10993: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10996: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10999: ifne +890 -> 11889
    //   11002: new 80	java/lang/StringBuilder
    //   11005: dup
    //   11006: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   11009: astore 34
    //   11011: aload 34
    //   11013: ldc_w 841
    //   11016: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11019: pop
    //   11020: aload 34
    //   11022: aload_0
    //   11023: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   11026: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11029: pop
    //   11030: aload 34
    //   11032: ldc_w 843
    //   11035: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11038: pop
    //   11039: aload 34
    //   11041: aload_0
    //   11042: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   11045: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11048: pop
    //   11049: aload 34
    //   11051: ldc_w 845
    //   11054: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11057: pop
    //   11058: aload_0
    //   11059: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   11062: ifeq +37 -> 11099
    //   11065: aload_0
    //   11066: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   11069: astore 22
    //   11071: aload 22
    //   11073: ifnull +26 -> 11099
    //   11076: aload 22
    //   11078: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11081: ifnull +18 -> 11099
    //   11084: aload_0
    //   11085: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   11088: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11091: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11094: astore 22
    //   11096: goto +8 -> 11104
    //   11099: ldc_w 854
    //   11102: astore 22
    //   11104: aload 34
    //   11106: aload 22
    //   11108: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11111: pop
    //   11112: aload 34
    //   11114: ldc_w 856
    //   11117: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11120: pop
    //   11121: aload 34
    //   11123: aload 33
    //   11125: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11128: pop
    //   11129: aload 34
    //   11131: ldc_w 861
    //   11134: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11137: pop
    //   11138: aload 34
    //   11140: aload 29
    //   11142: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11145: pop
    //   11146: aload 34
    //   11148: ldc_w 695
    //   11151: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11154: pop
    //   11155: aload 34
    //   11157: ldc_w 806
    //   11160: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11163: pop
    //   11164: aload 34
    //   11166: aload 27
    //   11168: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11171: pop
    //   11172: aload 34
    //   11174: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11177: invokevirtual 340	java/lang/Thread:getId	()J
    //   11180: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11183: pop
    //   11184: aload 34
    //   11186: ldc_w 863
    //   11189: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11192: pop
    //   11193: aload 34
    //   11195: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11198: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11201: pop
    //   11202: aload 34
    //   11204: ldc_w 865
    //   11207: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11210: pop
    //   11211: aload 34
    //   11213: aload_0
    //   11214: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   11217: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11220: pop
    //   11221: aload 34
    //   11223: ldc_w 867
    //   11226: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11229: pop
    //   11230: aload 34
    //   11232: aload_0
    //   11233: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   11236: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11239: pop
    //   11240: aload 34
    //   11242: ldc_w 869
    //   11245: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11248: pop
    //   11249: aload_0
    //   11250: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   11253: ifeq +19 -> 11272
    //   11256: aload_0
    //   11257: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   11260: aload_0
    //   11261: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   11264: invokestatic 500	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   11267: astore 22
    //   11269: goto +6 -> 11275
    //   11272: aconst_null
    //   11273: astore 22
    //   11275: aload 34
    //   11277: aload 22
    //   11279: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11282: pop
    //   11283: aload 34
    //   11285: ldc_w 871
    //   11288: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11291: pop
    //   11292: aload 34
    //   11294: aload_0
    //   11295: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   11298: invokestatic 110	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   11301: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11304: pop
    //   11305: aload 34
    //   11307: ldc_w 873
    //   11310: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11313: pop
    //   11314: aload 34
    //   11316: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   11319: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11322: pop
    //   11323: aload 34
    //   11325: ldc_w 875
    //   11328: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11331: pop
    //   11332: aload 34
    //   11334: aload_2
    //   11335: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11338: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11341: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11344: pop
    //   11345: aload 34
    //   11347: ldc_w 880
    //   11350: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11353: pop
    //   11354: aload 34
    //   11356: aload_2
    //   11357: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11360: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11363: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11366: pop
    //   11367: aload 34
    //   11369: ldc_w 885
    //   11372: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11375: pop
    //   11376: aload 34
    //   11378: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   11381: aload_0
    //   11382: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   11385: lsub
    //   11386: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11389: pop
    //   11390: aload 34
    //   11392: ldc_w 887
    //   11395: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11398: pop
    //   11399: aload 34
    //   11401: aload_2
    //   11402: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11405: getfield 890	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11408: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11411: pop
    //   11412: aload 34
    //   11414: ldc_w 892
    //   11417: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11420: pop
    //   11421: aload 34
    //   11423: aload_2
    //   11424: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11427: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11430: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11433: pop
    //   11434: aload 34
    //   11436: ldc_w 896
    //   11439: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11442: pop
    //   11443: aload 34
    //   11445: aload_2
    //   11446: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11449: getfield 899	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   11452: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11455: pop
    //   11456: aload 34
    //   11458: ldc_w 901
    //   11461: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11464: pop
    //   11465: aload 34
    //   11467: aload_0
    //   11468: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   11471: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11474: pop
    //   11475: aload 34
    //   11477: aload 31
    //   11479: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11482: pop
    //   11483: aload 34
    //   11485: aload_0
    //   11486: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   11489: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11492: pop
    //   11493: aload 34
    //   11495: ldc_w 906
    //   11498: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11501: pop
    //   11502: aload 34
    //   11504: iload 4
    //   11506: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11509: pop
    //   11510: aload 34
    //   11512: ldc_w 908
    //   11515: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11518: pop
    //   11519: aload 34
    //   11521: aload_2
    //   11522: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11525: invokevirtual 911	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   11528: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11531: pop
    //   11532: aload 34
    //   11534: ldc_w 913
    //   11537: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11540: pop
    //   11541: aload 34
    //   11543: iload_3
    //   11544: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11547: pop
    //   11548: aload 34
    //   11550: ldc_w 915
    //   11553: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11556: pop
    //   11557: aload 34
    //   11559: aload 32
    //   11561: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11564: pop
    //   11565: aload 34
    //   11567: ldc_w 917
    //   11570: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11573: pop
    //   11574: aload 34
    //   11576: aload 28
    //   11578: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11581: pop
    //   11582: aload 34
    //   11584: ldc_w 919
    //   11587: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11590: pop
    //   11591: aload_0
    //   11592: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   11595: astore 27
    //   11597: aload 27
    //   11599: astore 22
    //   11601: aload 27
    //   11603: ifnull +13 -> 11616
    //   11606: aload 27
    //   11608: iconst_0
    //   11609: bipush 30
    //   11611: invokevirtual 923	java/lang/String:substring	(II)Ljava/lang/String;
    //   11614: astore 22
    //   11616: aload 34
    //   11618: aload 22
    //   11620: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11623: pop
    //   11624: aload 34
    //   11626: ldc_w 925
    //   11629: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11632: pop
    //   11633: aload_0
    //   11634: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11637: ifnull +15 -> 11652
    //   11640: aload_0
    //   11641: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11644: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11647: istore 4
    //   11649: goto +6 -> 11655
    //   11652: iconst_0
    //   11653: istore 4
    //   11655: aload 34
    //   11657: iload 4
    //   11659: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11662: pop
    //   11663: aload 34
    //   11665: ldc_w 927
    //   11668: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11671: pop
    //   11672: aload 34
    //   11674: aload_2
    //   11675: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11678: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11681: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11684: pop
    //   11685: aload 34
    //   11687: ldc_w 932
    //   11690: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11693: pop
    //   11694: aload 34
    //   11696: lload 8
    //   11698: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11701: pop
    //   11702: aload 34
    //   11704: ldc_w 934
    //   11707: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11710: pop
    //   11711: aload 34
    //   11713: aload_0
    //   11714: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   11717: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11720: pop
    //   11721: aload 34
    //   11723: aload 31
    //   11725: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11728: pop
    //   11729: aload 34
    //   11731: aload_0
    //   11732: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   11735: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11738: pop
    //   11739: aload 34
    //   11741: ldc_w 936
    //   11744: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11747: pop
    //   11748: aload 34
    //   11750: aload_0
    //   11751: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   11754: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11757: pop
    //   11758: aload 34
    //   11760: aload 31
    //   11762: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11765: pop
    //   11766: aload 34
    //   11768: aload_0
    //   11769: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   11772: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11775: pop
    //   11776: aload 34
    //   11778: ldc_w 938
    //   11781: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11784: pop
    //   11785: aload 34
    //   11787: aload_0
    //   11788: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   11791: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11794: pop
    //   11795: aload 34
    //   11797: ldc_w 940
    //   11800: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11803: pop
    //   11804: aload 34
    //   11806: aload_0
    //   11807: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   11810: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11813: pop
    //   11814: aload 34
    //   11816: ldc_w 945
    //   11819: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11822: pop
    //   11823: aload 34
    //   11825: aload_0
    //   11826: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   11829: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11832: pop
    //   11833: aload 34
    //   11835: ldc_w 950
    //   11838: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11841: pop
    //   11842: aload_0
    //   11843: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11846: ifnull +17 -> 11863
    //   11849: aload_0
    //   11850: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11853: invokeinterface 590 1 0
    //   11858: astore 22
    //   11860: goto +6 -> 11866
    //   11863: aconst_null
    //   11864: astore 22
    //   11866: aload 34
    //   11868: aload 22
    //   11870: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11873: pop
    //   11874: aload 30
    //   11876: aload 34
    //   11878: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11881: aload 25
    //   11883: invokestatic 954	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11886: goto +841 -> 12727
    //   11889: new 80	java/lang/StringBuilder
    //   11892: dup
    //   11893: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   11896: astore 34
    //   11898: aload 34
    //   11900: ldc_w 956
    //   11903: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11906: pop
    //   11907: aload 34
    //   11909: aload_0
    //   11910: invokevirtual 251	com/tencent/component/network/downloader/impl/StrictDownloadTask:getUrl	()Ljava/lang/String;
    //   11913: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11916: pop
    //   11917: aload 34
    //   11919: ldc_w 843
    //   11922: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11925: pop
    //   11926: aload 34
    //   11928: aload_0
    //   11929: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   11932: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11935: pop
    //   11936: aload 34
    //   11938: ldc_w 845
    //   11941: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11944: pop
    //   11945: aload_0
    //   11946: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   11949: ifeq +37 -> 11986
    //   11952: aload_0
    //   11953: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   11956: astore 22
    //   11958: aload 22
    //   11960: ifnull +26 -> 11986
    //   11963: aload 22
    //   11965: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11968: ifnull +18 -> 11986
    //   11971: aload_0
    //   11972: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   11975: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11978: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11981: astore 22
    //   11983: goto +8 -> 11991
    //   11986: ldc_w 854
    //   11989: astore 22
    //   11991: aload 34
    //   11993: aload 22
    //   11995: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11998: pop
    //   11999: aload 34
    //   12001: ldc_w 856
    //   12004: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12007: pop
    //   12008: aload 34
    //   12010: aload 33
    //   12012: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12015: pop
    //   12016: aload 34
    //   12018: ldc_w 861
    //   12021: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12024: pop
    //   12025: aload 34
    //   12027: aload 29
    //   12029: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12032: pop
    //   12033: aload 34
    //   12035: ldc_w 695
    //   12038: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12041: pop
    //   12042: aload 34
    //   12044: ldc_w 806
    //   12047: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12050: pop
    //   12051: aload 34
    //   12053: aload 27
    //   12055: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12058: pop
    //   12059: aload 34
    //   12061: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12064: invokevirtual 340	java/lang/Thread:getId	()J
    //   12067: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12070: pop
    //   12071: aload 34
    //   12073: ldc_w 863
    //   12076: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12079: pop
    //   12080: aload 34
    //   12082: invokestatic 327	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12085: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12088: pop
    //   12089: aload 34
    //   12091: ldc_w 865
    //   12094: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12097: pop
    //   12098: aload 34
    //   12100: aload_0
    //   12101: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   12104: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12107: pop
    //   12108: aload 34
    //   12110: ldc_w 867
    //   12113: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12116: pop
    //   12117: aload 34
    //   12119: aload_0
    //   12120: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   12123: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12126: pop
    //   12127: aload 34
    //   12129: ldc_w 869
    //   12132: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12135: pop
    //   12136: aload_0
    //   12137: getfield 353	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAllowProxy	Z
    //   12140: ifeq +19 -> 12159
    //   12143: aload_0
    //   12144: getfield 104	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContext	Landroid/content/Context;
    //   12147: aload_0
    //   12148: getfield 358	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAPNProxy	Z
    //   12151: invokestatic 500	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   12154: astore 22
    //   12156: goto +6 -> 12162
    //   12159: aconst_null
    //   12160: astore 22
    //   12162: aload 34
    //   12164: aload 22
    //   12166: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12169: pop
    //   12170: aload 34
    //   12172: ldc_w 873
    //   12175: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12178: pop
    //   12179: aload 34
    //   12181: invokestatic 612	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12184: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12187: pop
    //   12188: aload 34
    //   12190: ldc_w 880
    //   12193: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12196: pop
    //   12197: aload 34
    //   12199: aload_2
    //   12200: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12203: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12206: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12209: pop
    //   12210: aload 34
    //   12212: ldc_w 885
    //   12215: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12218: pop
    //   12219: aload 34
    //   12221: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   12224: aload_0
    //   12225: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   12228: lsub
    //   12229: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12232: pop
    //   12233: aload 34
    //   12235: ldc_w 887
    //   12238: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12241: pop
    //   12242: aload 34
    //   12244: aload_2
    //   12245: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12248: getfield 890	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12251: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12254: pop
    //   12255: aload 34
    //   12257: ldc_w 892
    //   12260: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12263: pop
    //   12264: aload 34
    //   12266: aload_2
    //   12267: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12270: getfield 894	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12273: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12276: pop
    //   12277: aload 34
    //   12279: ldc_w 896
    //   12282: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12285: pop
    //   12286: aload 34
    //   12288: aload_2
    //   12289: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12292: getfield 899	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12295: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12298: pop
    //   12299: aload 34
    //   12301: ldc_w 901
    //   12304: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12307: pop
    //   12308: aload 34
    //   12310: aload_0
    //   12311: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   12314: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12317: pop
    //   12318: aload 34
    //   12320: aload 31
    //   12322: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12325: pop
    //   12326: aload 34
    //   12328: aload_0
    //   12329: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   12332: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12335: pop
    //   12336: aload 34
    //   12338: ldc_w 906
    //   12341: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12344: pop
    //   12345: aload 34
    //   12347: iload 4
    //   12349: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12352: pop
    //   12353: aload 34
    //   12355: ldc_w 958
    //   12358: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12361: pop
    //   12362: aload 34
    //   12364: iload_3
    //   12365: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12368: pop
    //   12369: aload 34
    //   12371: ldc_w 875
    //   12374: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12377: pop
    //   12378: aload 34
    //   12380: aload_2
    //   12381: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12384: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12387: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12390: pop
    //   12391: aload 34
    //   12393: ldc_w 915
    //   12396: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12399: pop
    //   12400: aload 34
    //   12402: aload 32
    //   12404: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12407: pop
    //   12408: aload 34
    //   12410: ldc_w 917
    //   12413: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12416: pop
    //   12417: aload 34
    //   12419: aload 28
    //   12421: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12424: pop
    //   12425: aload 34
    //   12427: ldc_w 919
    //   12430: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12433: pop
    //   12434: aload_0
    //   12435: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   12438: astore 22
    //   12440: aload 22
    //   12442: ifnull +16 -> 12458
    //   12445: aload 22
    //   12447: iconst_0
    //   12448: bipush 30
    //   12450: invokevirtual 923	java/lang/String:substring	(II)Ljava/lang/String;
    //   12453: astore 22
    //   12455: goto +3 -> 12458
    //   12458: aload 34
    //   12460: aload 22
    //   12462: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12465: pop
    //   12466: aload 34
    //   12468: ldc_w 925
    //   12471: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12474: pop
    //   12475: aload_0
    //   12476: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12479: ifnull +15 -> 12494
    //   12482: aload_0
    //   12483: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12486: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12489: istore 4
    //   12491: goto +6 -> 12497
    //   12494: iconst_0
    //   12495: istore 4
    //   12497: aload 34
    //   12499: iload 4
    //   12501: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12504: pop
    //   12505: aload 34
    //   12507: ldc_w 927
    //   12510: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12513: pop
    //   12514: aload 34
    //   12516: aload_2
    //   12517: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12520: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12523: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12526: pop
    //   12527: aload 34
    //   12529: ldc_w 932
    //   12532: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12535: pop
    //   12536: aload 34
    //   12538: lload 8
    //   12540: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12543: pop
    //   12544: aload 34
    //   12546: ldc_w 934
    //   12549: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12552: pop
    //   12553: aload 34
    //   12555: aload_0
    //   12556: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   12559: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12562: pop
    //   12563: aload 34
    //   12565: aload 31
    //   12567: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12570: pop
    //   12571: aload 34
    //   12573: aload_0
    //   12574: getfield 68	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_retry	I
    //   12577: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12580: pop
    //   12581: aload 34
    //   12583: ldc_w 936
    //   12586: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12589: pop
    //   12590: aload 34
    //   12592: aload_0
    //   12593: getfield 70	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_time	J
    //   12596: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12599: pop
    //   12600: aload 34
    //   12602: aload 31
    //   12604: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12607: pop
    //   12608: aload 34
    //   12610: aload_0
    //   12611: getfield 72	com/tencent/component/network/downloader/impl/StrictDownloadTask:exe_retry	I
    //   12614: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12617: pop
    //   12618: aload 34
    //   12620: ldc_w 938
    //   12623: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12626: pop
    //   12627: aload 34
    //   12629: aload_0
    //   12630: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   12633: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12636: pop
    //   12637: aload 34
    //   12639: ldc_w 940
    //   12642: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12645: pop
    //   12646: aload 34
    //   12648: aload_0
    //   12649: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   12652: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12655: pop
    //   12656: aload 34
    //   12658: ldc_w 945
    //   12661: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12664: pop
    //   12665: aload 34
    //   12667: aload_0
    //   12668: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   12671: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12674: pop
    //   12675: aload 34
    //   12677: ldc_w 950
    //   12680: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12683: pop
    //   12684: aload_0
    //   12685: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12688: ifnull +17 -> 12705
    //   12691: aload_0
    //   12692: getfield 584	com/tencent/component/network/downloader/impl/StrictDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12695: invokeinterface 590 1 0
    //   12700: astore 22
    //   12702: goto +6 -> 12708
    //   12705: aconst_null
    //   12706: astore 22
    //   12708: aload 34
    //   12710: aload 22
    //   12712: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12715: pop
    //   12716: aload 30
    //   12718: aload 34
    //   12720: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12723: aconst_null
    //   12724: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12727: iconst_0
    //   12728: istore 21
    //   12730: aload_0
    //   12731: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12734: ifnull +71 -> 12805
    //   12737: getstatic 369	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12740: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12743: aload_0
    //   12744: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12747: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12750: if_icmpne +55 -> 12805
    //   12753: aload_0
    //   12754: getfield 400	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   12757: ifnull +48 -> 12805
    //   12760: aload_0
    //   12761: getfield 400	com/tencent/component/network/downloader/impl/StrictDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   12764: aload_0
    //   12765: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   12768: aload_0
    //   12769: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   12772: invokestatic 963	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   12775: aload_2
    //   12776: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12779: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12782: invokeinterface 967 4 0
    //   12787: goto +18 -> 12805
    //   12790: astore 22
    //   12792: aload 26
    //   12794: ldc_w 968
    //   12797: aload 22
    //   12799: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12802: goto +3 -> 12805
    //   12805: aload_0
    //   12806: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12809: ifnull +68 -> 12877
    //   12812: getstatic 478	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12815: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12818: aload_0
    //   12819: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12822: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12825: if_icmpne +52 -> 12877
    //   12828: aload_0
    //   12829: getfield 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   12832: ifnull +45 -> 12877
    //   12835: aload_0
    //   12836: getfield 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   12839: aload_0
    //   12840: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   12843: aload_0
    //   12844: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   12847: invokestatic 963	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   12850: aload_2
    //   12851: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12854: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12857: invokeinterface 967 4 0
    //   12862: goto +15 -> 12877
    //   12865: astore 22
    //   12867: aload 26
    //   12869: ldc_w 969
    //   12872: aload 22
    //   12874: invokestatic 960	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12877: aload 24
    //   12879: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   12882: putfield 972	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   12885: aload 24
    //   12887: aload_0
    //   12888: getfield 975	com/tencent/component/network/downloader/impl/StrictDownloadTask:mContentLength	J
    //   12891: putfield 978	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   12894: aload 24
    //   12896: aload_0
    //   12897: getfield 64	com/tencent/component/network/downloader/impl/StrictDownloadTask:response	Lorg/apache/http/HttpResponse;
    //   12900: putfield 979	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   12903: aload 24
    //   12905: iload_3
    //   12906: putfield 980	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   12909: aload 24
    //   12911: aload 25
    //   12913: putfield 984	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   12916: aload 33
    //   12918: ifnonnull +9 -> 12927
    //   12921: aconst_null
    //   12922: astore 22
    //   12924: goto +10 -> 12934
    //   12927: aload 33
    //   12929: invokevirtual 987	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   12932: astore 22
    //   12934: aload 24
    //   12936: aload 22
    //   12938: putfield 990	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   12941: aload_0
    //   12942: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12945: ifnull +28 -> 12973
    //   12948: aload_0
    //   12949: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12952: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12955: ifnull +18 -> 12973
    //   12958: aload_0
    //   12959: getfield 280	com/tencent/component/network/downloader/impl/StrictDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12962: invokevirtual 624	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12965: getfield 627	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   12968: astore 22
    //   12970: goto +6 -> 12976
    //   12973: aconst_null
    //   12974: astore 22
    //   12976: aload 24
    //   12978: aload 22
    //   12980: putfield 993	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   12983: aload 24
    //   12985: ldc_w 806
    //   12988: putfield 996	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   12991: aload 24
    //   12993: aload_2
    //   12994: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12997: getfield 930	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13000: putfield 997	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   13003: aload 24
    //   13005: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   13008: aload_0
    //   13009: getfield 56	com/tencent/component/network/downloader/impl/StrictDownloadTask:mTimeStamp	J
    //   13012: lsub
    //   13013: putfield 1000	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13016: aload 24
    //   13018: aload_2
    //   13019: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13022: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13025: putfield 1003	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   13028: aload 24
    //   13030: aload 24
    //   13032: getfield 1000	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13035: aload_2
    //   13036: invokevirtual 779	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13039: getfield 883	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13042: lsub
    //   13043: putfield 1006	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   13046: aload 24
    //   13048: lload 8
    //   13050: putfield 1009	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   13053: aload 24
    //   13055: aload_0
    //   13056: getfield 66	com/tencent/component/network/downloader/impl/StrictDownloadTask:connect_time	J
    //   13059: putfield 1012	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   13062: aload 24
    //   13064: aload_0
    //   13065: getfield 74	com/tencent/component/network/downloader/impl/StrictDownloadTask:send_req_time	J
    //   13068: putfield 1015	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   13071: aload 24
    //   13073: aload_0
    //   13074: getfield 943	com/tencent/component/network/downloader/impl/StrictDownloadTask:t_recv_data	J
    //   13077: putfield 1018	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   13080: aload 24
    //   13082: lconst_0
    //   13083: putfield 1021	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   13086: aload 24
    //   13088: aload_0
    //   13089: invokevirtual 948	com/tencent/component/network/downloader/impl/StrictDownloadTask:getTaskConcurrentCount	()I
    //   13092: putfield 1024	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   13095: aload 24
    //   13097: aload_2
    //   13098: invokevirtual 824	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13101: getfield 878	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13104: putfield 1027	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   13107: aload 24
    //   13109: aload_0
    //   13110: invokevirtual 254	com/tencent/component/network/downloader/impl/StrictDownloadTask:getDomain	()Ljava/lang/String;
    //   13113: invokestatic 1030	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   13116: putfield 1032	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   13119: aload 24
    //   13121: aload_0
    //   13122: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   13125: putfield 1035	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   13128: aload_0
    //   13129: getfield 607	com/tencent/component/network/downloader/impl/StrictDownloadTask:mRealUrl	Ljava/lang/String;
    //   13132: astore 22
    //   13134: iload 21
    //   13136: istore 20
    //   13138: aload 22
    //   13140: ifnull +21 -> 13161
    //   13143: iload 21
    //   13145: istore 20
    //   13147: aload 22
    //   13149: ldc_w 617
    //   13152: invokevirtual 620	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13155: ifeq +6 -> 13161
    //   13158: iconst_1
    //   13159: istore 20
    //   13161: aload 24
    //   13163: iload 20
    //   13165: putfield 1038	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   13168: aload 24
    //   13170: aload_2
    //   13171: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13174: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13177: putfield 1040	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   13180: aload 24
    //   13182: getstatic 1046	com/tencent/component/network/downloader/Downloader$DownloadMode:StrictMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   13185: invokevirtual 1049	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   13188: putfield 1052	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   13191: aload_0
    //   13192: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   13195: astore 22
    //   13197: aload 22
    //   13199: ifnull +26 -> 13225
    //   13202: aload 22
    //   13204: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   13207: ifnull +18 -> 13225
    //   13210: aload 24
    //   13212: aload_0
    //   13213: getfield 62	com/tencent/component/network/downloader/impl/StrictDownloadTask:okResponse	Lokhttp3/Response;
    //   13216: invokevirtual 849	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   13219: invokevirtual 852	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   13222: putfield 1054	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   13225: aload_2
    //   13226: aload 24
    //   13228: invokevirtual 1058	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   13231: aload_0
    //   13232: getfield 301	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptCurrCount	I
    //   13235: aload_0
    //   13236: getfield 904	com/tencent/component/network/downloader/impl/StrictDownloadTask:mAttemptTotalCount	I
    //   13239: iconst_1
    //   13240: isub
    //   13241: if_icmpeq +13 -> 13254
    //   13244: aload_2
    //   13245: invokevirtual 739	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13248: invokevirtual 832	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13251: ifeq +11 -> 13262
    //   13254: aload_0
    //   13255: aload_1
    //   13256: aload_2
    //   13257: aload 24
    //   13259: invokevirtual 525	com/tencent/component/network/downloader/impl/StrictDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   13262: aload_0
    //   13263: getfield 257	com/tencent/component/network/downloader/impl/StrictDownloadTask:mIsHttp2	Z
    //   13266: ifeq +27 -> 13293
    //   13269: aload_0
    //   13270: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   13273: ifnull +12 -> 13285
    //   13276: aload_0
    //   13277: getfield 730	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestCall	Lokhttp3/Call;
    //   13280: invokeinterface 1061 1 0
    //   13285: aload_0
    //   13286: aconst_null
    //   13287: putfield 558	com/tencent/component/network/downloader/impl/StrictDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   13290: goto +17 -> 13307
    //   13293: aload_0
    //   13294: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   13297: ifnull +10 -> 13307
    //   13300: aload_0
    //   13301: getfield 554	com/tencent/component/network/downloader/impl/StrictDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   13304: invokevirtual 1066	org/apache/http/client/methods/HttpGet:abort	()V
    //   13307: goto +6 -> 13313
    //   13310: aload 23
    //   13312: athrow
    //   13313: goto -3 -> 13310
    //   13316: astore 25
    //   13318: goto -13220 -> 98
    //   13321: astore 25
    //   13323: goto -10880 -> 2443
    //   13326: astore 24
    //   13328: goto -8256 -> 5072
    //   13331: astore 26
    //   13333: goto -5155 -> 8178
    //   13336: astore 28
    //   13338: goto -2450 -> 10888
    //   13341: aload 23
    //   13343: astore 22
    //   13345: iload 5
    //   13347: iconst_2
    //   13348: if_icmpge -12611 -> 737
    //   13351: aload 23
    //   13353: astore 22
    //   13355: iload 20
    //   13357: ifeq -12620 -> 737
    //   13360: ldc_w 665
    //   13363: astore 22
    //   13365: goto -12628 -> 737
    //   13368: aload 24
    //   13370: astore 22
    //   13372: goto -12332 -> 1040
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	13375	0	this	StrictDownloadTask
    //   0	13375	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	13375	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   46	12860	3	i	int
    //   307	12193	4	j	int
    //   343	13006	5	k	int
    //   30	111	6	m	int
    //   2147	2762	7	n	int
    //   43	13006	8	l1	long
    //   194	7433	10	l2	long
    //   35	70	12	l3	long
    //   127	10638	14	l4	long
    //   1646	3286	16	l5	long
    //   1681	260	18	l6	long
    //   204	13152	20	bool1	boolean
    //   12728	416	21	bool2	boolean
    //   40	180	22	str1	String
    //   224	13	22	localThrowable1	java.lang.Throwable
    //   274	38	22	localObject1	Object
    //   332	1	22	localThrowable2	java.lang.Throwable
    //   358	5	22	localObject2	Object
    //   420	27	22	localObject3	Object
    //   456	1	22	localObject4	Object
    //   465	1	22	localThrowable3	java.lang.Throwable
    //   505	594	22	localObject5	Object
    //   1157	1	22	localObject6	Object
    //   1162	1	22	localThrowable4	java.lang.Throwable
    //   1170	1	22	localObject7	Object
    //   1175	1	22	localThrowable5	java.lang.Throwable
    //   1184	556	22	localObject8	Object
    //   1765	1	22	localThrowable6	java.lang.Throwable
    //   1773	81	22	localObject9	Object
    //   1865	1	22	localThrowable7	java.lang.Throwable
    //   1878	3	22	localBuilder	Request.Builder
    //   1924	1	22	localThrowable8	java.lang.Throwable
    //   1930	2942	22	localObject10	Object
    //   4882	37	22	localThrowable9	java.lang.Throwable
    //   5039	2598	22	localObject11	Object
    //   7641	1	22	localObject12	Object
    //   7646	1	22	localThrowable10	java.lang.Throwable
    //   7651	3	22	localObject13	Object
    //   7660	1	22	localThrowable11	java.lang.Throwable
    //   7668	1	22	localObject14	Object
    //   7673	1	22	localThrowable12	java.lang.Throwable
    //   7688	1	22	localObject15	Object
    //   7693	1	22	localThrowable13	java.lang.Throwable
    //   7701	3	22	localObject16	Object
    //   7719	1	22	localThrowable14	java.lang.Throwable
    //   7738	1	22	localObject17	Object
    //   7743	1	22	localThrowable15	java.lang.Throwable
    //   7748	1	22	localObject18	Object
    //   7753	1	22	localThrowable16	java.lang.Throwable
    //   7758	17	22	localObject19	Object
    //   7791	1	22	str2	String
    //   7796	27	22	localThrowable17	java.lang.Throwable
    //   7856	1	22	str3	String
    //   7863	99	22	localThrowable18	java.lang.Throwable
    //   7967	4744	22	localObject20	Object
    //   12790	8	22	localException1	java.lang.Exception
    //   12865	8	22	localException2	java.lang.Exception
    //   12922	449	22	localObject21	Object
    //   4	56	23	localDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   295	1	23	localObject22	Object
    //   336	1332	23	localObject23	Object
    //   1732	1	23	localObject24	Object
    //   1779	4	23	localQZoneHttpClient	QZoneHttpClient
    //   1799	1	23	localObject25	Object
    //   1804	1	23	localThrowable19	java.lang.Throwable
    //   1809	3	23	localObject26	Object
    //   1818	7	23	localThrowable20	java.lang.Throwable
    //   1860	93	23	localObject27	Object
    //   1985	1	23	localObject28	Object
    //   1990	7	23	localThrowable21	java.lang.Throwable
    //   2007	33	23	localObject29	Object
    //   2226	11	23	localThrowable22	java.lang.Throwable
    //   2251	2011	23	localObject30	Object
    //   4338	8	23	localException3	java.lang.Exception
    //   4413	8	23	localException4	java.lang.Exception
    //   4470	2425	23	localObject31	Object
    //   6971	8	23	localException5	java.lang.Exception
    //   7046	8	23	localException6	java.lang.Exception
    //   7103	354	23	localObject32	Object
    //   7516	1	23	localObject33	Object
    //   7521	1	23	localThrowable23	java.lang.Throwable
    //   7526	29	23	localObject34	Object
    //   7564	1	23	localObject35	Object
    //   7569	15	23	localThrowable24	java.lang.Throwable
    //   7597	1	23	localObject36	Object
    //   7605	1	23	localObject37	Object
    //   7624	11	23	localThrowable25	java.lang.Throwable
    //   7655	149	23	localObject38	Object
    //   7825	1	23	localObject39	Object
    //   7867	5485	23	localObject40	Object
    //   1	1813	24	localObject41	Object
    //   1831	1	24	localObject42	Object
    //   1919	1	24	localObject43	Object
    //   2210	1944	24	str4	String
    //   4877	1	24	localObject44	Object
    //   4920	5083	24	localObject45	Object
    //   10080	8	24	localException7	java.lang.Exception
    //   10155	8	24	localException8	java.lang.Exception
    //   10212	3046	24	localObject46	Object
    //   13326	43	24	localException9	java.lang.Exception
    //   116	12796	25	localObject47	Object
    //   13316	1	25	localException10	java.lang.Exception
    //   13321	1	25	localException11	java.lang.Exception
    //   250	12618	26	localObject48	Object
    //   13331	1	26	localException12	java.lang.Exception
    //   136	7819	27	localObject49	Object
    //   7980	1	27	localObject50	Object
    //   7985	16	27	localObject51	Object
    //   8014	4040	27	localObject52	Object
    //   9	7820	28	localObject53	Object
    //   7950	20	28	localObject54	Object
    //   7975	4445	28	localObject55	Object
    //   13336	1	28	localException13	java.lang.Exception
    //   300	9902	29	localObject56	Object
    //   10711	24	29	localObject57	Object
    //   10740	1288	29	localObject58	Object
    //   234	12483	30	str5	String
    //   436	12167	31	localObject59	Object
    //   1655	10748	32	localObject60	Object
    //   1638	11290	33	localObject61	Object
    //   2564	10155	34	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   196	206	224	java/lang/Throwable
    //   281	292	295	finally
    //   281	292	332	java/lang/Throwable
    //   400	405	420	finally
    //   400	405	465	java/lang/Throwable
    //   518	536	1157	finally
    //   536	596	1157	finally
    //   607	613	1157	finally
    //   618	630	1157	finally
    //   633	645	1157	finally
    //   649	657	1157	finally
    //   661	702	1157	finally
    //   706	730	1157	finally
    //   737	754	1157	finally
    //   759	771	1157	finally
    //   774	786	1157	finally
    //   790	798	1157	finally
    //   802	852	1157	finally
    //   856	880	1157	finally
    //   887	916	1157	finally
    //   921	933	1157	finally
    //   936	948	1157	finally
    //   952	960	1157	finally
    //   964	1005	1157	finally
    //   1009	1033	1157	finally
    //   1040	1154	1157	finally
    //   1191	1204	1157	finally
    //   1214	1237	1157	finally
    //   1242	1254	1157	finally
    //   1257	1269	1157	finally
    //   1273	1281	1157	finally
    //   1285	1360	1157	finally
    //   1360	1457	1157	finally
    //   1471	1495	1157	finally
    //   1506	1529	1157	finally
    //   1568	1593	1157	finally
    //   518	536	1162	java/lang/Throwable
    //   536	596	1162	java/lang/Throwable
    //   607	613	1162	java/lang/Throwable
    //   618	630	1162	java/lang/Throwable
    //   633	645	1162	java/lang/Throwable
    //   649	657	1162	java/lang/Throwable
    //   661	702	1162	java/lang/Throwable
    //   706	730	1162	java/lang/Throwable
    //   737	754	1162	java/lang/Throwable
    //   759	771	1162	java/lang/Throwable
    //   774	786	1162	java/lang/Throwable
    //   790	798	1162	java/lang/Throwable
    //   802	852	1162	java/lang/Throwable
    //   856	880	1162	java/lang/Throwable
    //   887	916	1162	java/lang/Throwable
    //   921	933	1162	java/lang/Throwable
    //   936	948	1162	java/lang/Throwable
    //   952	960	1162	java/lang/Throwable
    //   964	1005	1162	java/lang/Throwable
    //   1009	1033	1162	java/lang/Throwable
    //   1040	1154	1162	java/lang/Throwable
    //   1191	1204	1162	java/lang/Throwable
    //   1214	1237	1162	java/lang/Throwable
    //   1242	1254	1162	java/lang/Throwable
    //   1257	1269	1162	java/lang/Throwable
    //   1273	1281	1162	java/lang/Throwable
    //   1285	1360	1162	java/lang/Throwable
    //   1360	1457	1162	java/lang/Throwable
    //   1471	1495	1162	java/lang/Throwable
    //   1506	1529	1162	java/lang/Throwable
    //   1568	1593	1162	java/lang/Throwable
    //   512	518	1170	finally
    //   512	518	1175	java/lang/Throwable
    //   1722	1729	1732	finally
    //   1722	1729	1765	java/lang/Throwable
    //   1781	1796	1799	finally
    //   1781	1796	1804	java/lang/Throwable
    //   1775	1781	1809	finally
    //   1775	1781	1818	java/lang/Throwable
    //   1711	1717	1831	finally
    //   1770	1775	1831	finally
    //   1711	1717	1865	java/lang/Throwable
    //   1770	1775	1865	java/lang/Throwable
    //   1885	1916	1919	finally
    //   1885	1916	1924	java/lang/Throwable
    //   1957	1964	1985	finally
    //   1967	1975	1985	finally
    //   2014	2030	1985	finally
    //   2044	2053	1985	finally
    //   1957	1964	1990	java/lang/Throwable
    //   1967	1975	1990	java/lang/Throwable
    //   2014	2030	1990	java/lang/Throwable
    //   2044	2053	1990	java/lang/Throwable
    //   2087	2127	2210	finally
    //   2135	2149	2210	finally
    //   2173	2178	2210	finally
    //   2178	2207	2210	finally
    //   2087	2127	2226	java/lang/Throwable
    //   2135	2149	2226	java/lang/Throwable
    //   2173	2178	2226	java/lang/Throwable
    //   2178	2207	2226	java/lang/Throwable
    //   4308	4335	4338	java/lang/Exception
    //   4383	4410	4413	java/lang/Exception
    //   2286	2293	4877	finally
    //   2286	2293	4882	java/lang/Throwable
    //   6941	6968	6971	java/lang/Exception
    //   7016	7043	7046	java/lang/Exception
    //   2267	2281	7516	finally
    //   2267	2281	7521	java/lang/Throwable
    //   2059	2068	7526	finally
    //   2247	2259	7526	finally
    //   2059	2068	7569	java/lang/Throwable
    //   2247	2259	7569	java/lang/Throwable
    //   1936	1952	7605	finally
    //   2003	2009	7605	finally
    //   2033	2039	7605	finally
    //   1936	1952	7624	java/lang/Throwable
    //   2003	2009	7624	java/lang/Throwable
    //   2033	2039	7624	java/lang/Throwable
    //   1874	1880	7641	finally
    //   1874	1880	7646	java/lang/Throwable
    //   1690	1706	7651	finally
    //   1690	1706	7660	java/lang/Throwable
    //   1664	1683	7668	finally
    //   1664	1683	7673	java/lang/Throwable
    //   1180	1186	7688	finally
    //   1460	1466	7688	finally
    //   1495	1501	7688	finally
    //   1532	1557	7688	finally
    //   1557	1563	7688	finally
    //   1596	1640	7688	finally
    //   1180	1186	7693	java/lang/Throwable
    //   1460	1466	7693	java/lang/Throwable
    //   1495	1501	7693	java/lang/Throwable
    //   1532	1557	7693	java/lang/Throwable
    //   1557	1563	7693	java/lang/Throwable
    //   1596	1640	7693	java/lang/Throwable
    //   500	507	7701	finally
    //   500	507	7719	java/lang/Throwable
    //   494	500	7738	finally
    //   494	500	7743	java/lang/Throwable
    //   252	276	7748	finally
    //   360	394	7748	finally
    //   252	276	7753	java/lang/Throwable
    //   360	394	7753	java/lang/Throwable
    //   241	252	7758	finally
    //   241	252	7796	java/lang/Throwable
    //   7822	7825	7825	finally
    //   7822	7825	7863	java/lang/Throwable
    //   7938	7947	7950	finally
    //   7916	7932	7980	finally
    //   7910	7916	7985	finally
    //   10050	10077	10080	java/lang/Exception
    //   10125	10152	10155	java/lang/Exception
    //   10640	10659	10697	java/lang/Throwable
    //   10659	10696	10697	java/lang/Throwable
    //   7890	7905	10711	finally
    //   12760	12787	12790	java/lang/Exception
    //   12835	12862	12865	java/lang/Exception
    //   89	95	13316	java/lang/Exception
    //   2425	2440	13321	java/lang/Exception
    //   5054	5069	13326	java/lang/Exception
    //   8160	8175	13331	java/lang/Exception
    //   10870	10885	13336	java/lang/Exception
  }
  
  protected void initTask()
  {
    super.initTask();
    this.mDomainWithPort = Utils.getDominWithPort(getUrl());
    this.mOrigPort = Utils.getPort(getUrl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.StrictDownloadTask
 * JD-Core Version:    0.7.0.1
 */