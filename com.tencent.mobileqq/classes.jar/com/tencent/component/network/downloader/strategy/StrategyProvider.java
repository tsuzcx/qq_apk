package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.HttpUtil.ClientOptions;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class StrategyProvider
{
  private static final String TAG = "StrategyProvider";
  public static IPConfigStrategy backupIPConfigStrategy;
  public static IPConfigStrategy directIPConfigStrategy;
  public static PortConfigStrategy portConfigStrategy;
  private static HttpClient sHttpClient = null;
  private static final ThreadLocal<HttpUtil.RequestOptions> sRequestOptions = new StrategyProvider.1();
  private static HttpUtil.ClientOptions soptions = new HttpUtil.ClientOptions(true);
  
  public static StrategyProvider.ExecuteResult exeHttpRequest(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt, StrategyProvider.RequestProcessor paramRequestProcessor, HttpRequest paramHttpRequest, DownloadResult paramDownloadResult, DownloadReport paramDownloadReport, Proxy paramProxy, HttpUtil.ClientOptions paramClientOptions)
  {
    StrategyProvider.ExecuteResult localExecuteResult = new StrategyProvider.ExecuteResult();
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    paramHttpRequest = null;
    Object localObject1 = localObject5;
    Object localObject3 = localObject6;
    for (;;)
    {
      try
      {
        paramStrategyLib = generateStrategyInfo(paramString, paramStrategyLib, paramInt);
        if (paramStrategyLib == null)
        {
          localExecuteResult.request = null;
          localExecuteResult.response = null;
          localExecuteResult.strategyInfo = paramStrategyLib;
          return null;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        HttpUtil.RequestOptions localRequestOptions = (HttpUtil.RequestOptions)sRequestOptions.get();
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localRequestOptions.allowProxy = paramStrategyLib.allowProxy;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localRequestOptions.apnProxy = paramStrategyLib.useConfigApn;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localRequestOptions.mobileProxy = paramProxy;
        if (paramStrategyLib == null) {
          break label790;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (paramStrategyLib.getIPInfo() == null) {
          break label790;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (TextUtils.isEmpty(paramStrategyLib.getIPInfo().ip)) {
          break label790;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramProxy = paramStrategyLib.getIPInfo().ip;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (Utils.count(paramProxy, ':') >= 2) {
          break label784;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramInt = Utils.getPort(paramString);
        if (paramInt <= 0) {
          continue;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramStrategyLib.getIPInfo().port = paramInt;
        int i = paramInt;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (!Utils.isPortValid(paramInt)) {
          i = 80;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        String str = paramProxy + ":" + i;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localObject4 = paramString.replaceFirst(Utils.getDominWithPort(paramString), str);
        paramProxy = (Proxy)localObject4;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (QDLog.isInfoEnable())
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = localObject5;
          localObject2 = paramStrategyLib;
          localObject3 = localObject6;
          QDLog.i("StrategyProvider", "downloader strategy run: " + paramStrategyLib.toString() + " domain:" + str + " url:" + paramString + " threadId:" + Thread.currentThread().getId());
          paramProxy = (Proxy)localObject4;
        }
        localObject4 = paramProxy;
        if (paramDownloadReport != null)
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = localObject5;
          localObject2 = paramStrategyLib;
          localObject3 = localObject6;
          paramDownloadReport.strategyInfo = paramStrategyLib.toString();
          localObject4 = paramProxy;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramDownloadReport = HttpUtil.createHttpGet(Global.getContext(), paramString, Utils.getDomin(paramString), (String)localObject4, localRequestOptions);
        if (paramRequestProcessor != null)
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = paramDownloadReport;
          localObject2 = paramStrategyLib;
          localObject3 = paramDownloadReport;
          paramRequestProcessor.prepareRequest(paramString, paramDownloadReport);
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        paramString = HttpUtil.createHttpContext();
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        localExecuteResult.context = paramString;
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        paramString = obtainHttpClient(paramClientOptions).execute(paramDownloadReport, paramString);
        localExecuteResult.request = paramDownloadReport;
        localExecuteResult.response = paramString;
        localExecuteResult.strategyInfo = paramStrategyLib;
      }
      catch (Throwable paramString)
      {
        if (paramDownloadResult == null) {
          continue;
        }
        localObject2 = paramHttpRequest;
        localObject3 = localObject1;
        paramDownloadResult.getStatus().setFailed(paramString);
        localObject2 = paramHttpRequest;
        localObject3 = localObject1;
        localExecuteResult.exception = paramString;
        localExecuteResult.request = ((HttpGet)localObject1);
        localExecuteResult.response = null;
        localExecuteResult.strategyInfo = paramHttpRequest;
        continue;
      }
      finally
      {
        localExecuteResult.request = ((HttpGet)localObject3);
        localExecuteResult.response = null;
        localExecuteResult.strategyInfo = ((DownloadGlobalStrategy.StrategyInfo)localObject2);
      }
      return localExecuteResult;
      paramHttpRequest = paramStrategyLib;
      localObject1 = localObject5;
      localObject2 = paramStrategyLib;
      localObject3 = localObject6;
      paramInt = paramStrategyLib.getIPInfo().port;
      continue;
      label784:
      paramProxy = paramString;
      continue;
      label790:
      Object localObject4 = paramString;
    }
  }
  
  public static DownloadGlobalStrategy.StrategyInfo generateStrategyInfo(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt)
  {
    int i = 80;
    if ((TextUtils.isEmpty(paramString)) || (paramStrategyLib == null) || (paramInt < 0)) {
      return null;
    }
    Object localObject = paramStrategyLib.getOldStrategyInfo();
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = paramStrategyLib.getStrategyInfo(paramInt);
    paramStrategyLib.setOldStrategyInfo(localStrategyInfo);
    if (QDLog.isInfoEnable()) {
      QDLog.i("StrategyProvider", "downloader strategy: " + localStrategyInfo.toString() + " currAttempCount:" + paramInt + " best:" + paramStrategyLib.getBestId() + " url:" + paramString + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
    }
    String str = Utils.getDomin(paramString);
    paramInt = paramStrategyLib.getPort();
    if (!Utils.isPortValid(paramInt))
    {
      paramStrategyLib.setPort(80);
      paramInt = i;
    }
    label1038:
    label1183:
    for (;;)
    {
      if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == localStrategyInfo.id)
      {
        i = paramInt;
        if (localObject != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
          {
            if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
              break label416;
            }
            i = portConfigStrategy.changePort(str, paramInt);
            if ((i == paramInt) || (!Utils.isPortValid(i)))
            {
              if (QDLog.isInfoEnable()) {
                QDLog.i("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              }
              return null;
            }
          }
        }
        paramString = paramStrategyLib.getBackupIP();
        if ((backupIPConfigStrategy == null) || (backupIPConfigStrategy.isIPValid(paramString, str))) {
          break label1279;
        }
        paramStrategyLib.setBackupIP(null);
        paramString = backupIPConfigStrategy.resolveIP(str);
        if (!TextUtils.isEmpty(paramString)) {
          paramStrategyLib.setBackupIP(paramString);
        }
      }
      label416:
      label719:
      label1276:
      label1279:
      for (;;)
      {
        if ((paramString == null) || (paramString.equals(paramStrategyLib.getDirectIP())) || (paramString.equals(paramStrategyLib.getDnsIP())))
        {
          if (QDLog.isInfoEnable()) {
            QDLog.i("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          }
          return null;
          if (QDLog.isInfoEnable()) {
            QDLog.i("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          }
          return null;
          if (QDLog.isInfoEnable()) {
            QDLog.i("StrategyProvider", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
          }
          return null;
        }
        paramStrategyLib = localStrategyInfo.clone();
        paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
        return paramStrategyLib;
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == localStrategyInfo.id)
        {
          i = paramInt;
          if (localObject != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
            {
              if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
                break label719;
              }
              i = portConfigStrategy.changePort(str, paramInt);
              if ((i == paramInt) || (!Utils.isPortValid(i)))
              {
                if (QDLog.isInfoEnable()) {
                  QDLog.i("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                }
                return null;
              }
            }
          }
          paramString = DnsService.getInstance().getDomainIP(str);
          if ((paramString == null) || (paramString.equals(paramStrategyLib.getBackupIP())) || (paramString.equals(paramStrategyLib.getDirectIP())))
          {
            if (QDLog.isInfoEnable()) {
              QDLog.i("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            }
            return null;
            if (QDLog.isInfoEnable()) {
              QDLog.i("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            }
            return null;
          }
          paramStrategyLib.setDnsIP(paramString);
          paramStrategyLib = localStrategyInfo.clone();
          paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
        if (DownloadGlobalStrategy.Strategy_DomainDirect.id == localStrategyInfo.id)
        {
          i = paramInt;
          if (localObject != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DomainDirect.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
            {
              if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
                break label1038;
              }
              i = portConfigStrategy.changePort(str, paramInt);
              if ((i == paramInt) || (!Utils.isPortValid(i)))
              {
                if (QDLog.isInfoEnable()) {
                  QDLog.i("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                }
                return null;
              }
            }
          }
          localObject = paramStrategyLib.getDirectIP();
          paramString = (String)localObject;
          if (directIPConfigStrategy == null) {
            break label1276;
          }
          paramString = (String)localObject;
          if (directIPConfigStrategy.isIPValid((String)localObject, str)) {
            break label1276;
          }
          localObject = directIPConfigStrategy.resolveIP(str);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label1183;
          }
          paramStrategyLib.setDirectIP((String)localObject);
          paramString = (String)localObject;
        }
        for (;;)
        {
          if ((paramString == null) || (paramString.equals(paramStrategyLib.getBackupIP())) || (paramString.equals(paramStrategyLib.getDnsIP())))
          {
            if (QDLog.isInfoEnable()) {
              QDLog.i("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            }
            return null;
            if (QDLog.isInfoEnable()) {
              QDLog.i("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            }
            return null;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id != localStrategyInfo.id)
            {
              i = paramInt;
              if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != localStrategyInfo.id) {
                break;
              }
            }
            paramString = Global.getContext();
            if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo.id) {}
            for (boolean bool = true; NetworkUtils.getProxy(paramString, bool) == null; bool = false)
            {
              if (QDLog.isInfoEnable()) {
                QDLog.i("StrategyProvider", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
              }
              return null;
            }
            return localStrategyInfo;
            if (QDLog.isInfoEnable()) {
              QDLog.i("StrategyProvider", "downloader strategy: resolve ip failed! threadId:" + Thread.currentThread().getId());
            }
            paramString = (String)localObject;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == localStrategyInfo.id) {
              break label1276;
            }
            paramString = (String)localObject;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo.id) {
              break label1276;
            }
            return null;
          }
          paramStrategyLib = localStrategyInfo.clone();
          paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
      }
    }
  }
  
  private static void initHttpClient(QZoneHttpClient paramQZoneHttpClient) {}
  
  private static HttpClient obtainHttpClient(HttpUtil.ClientOptions paramClientOptions)
  {
    if (sHttpClient != null) {
      return sHttpClient;
    }
    if (paramClientOptions != null) {}
    for (;;)
    {
      try
      {
        sHttpClient = HttpUtil.createHttpClient(paramClientOptions);
        return sHttpClient;
      }
      finally {}
      paramClientOptions = soptions;
    }
  }
  
  public static void onIPDownloadResult(String paramString, IPInfo paramIPInfo, boolean paramBoolean)
  {
    String str = Utils.getDomin(paramString);
    if ((TextUtils.isEmpty(str)) || (paramIPInfo == null)) {
      return;
    }
    if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null) {
      DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().onIPAccessResult(str, paramIPInfo.ip, paramBoolean);
    }
    if (DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy() != null) {
      DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy().onIPAccessResult(str, paramIPInfo.ip, paramBoolean);
    }
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = new DownloadGlobalStrategy.StrategyInfo(false, false, false);
    localStrategyInfo.id = 0;
    localStrategyInfo.setIPInfo(paramIPInfo);
    DownloadGlobalStrategy.getInstance(Global.getContext()).report(Global.getContext(), paramString, str, localStrategyInfo, paramBoolean);
  }
  
  public static List<IPInfo> provideIPList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject2;
    do
    {
      return null;
      localObject2 = Utils.getDomin(paramString);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = DownloadGlobalStrategy.getInstance(Global.getContext()).getBestStrategyInfo(paramString, (String)localObject2);
    int i;
    if ((localObject3 != null) && (((DownloadGlobalStrategy.StrategyInfo)localObject3).getIPInfo() != null) && (((DownloadGlobalStrategy.StrategyInfo)localObject3).isIPValid()))
    {
      paramString = ((DownloadGlobalStrategy.StrategyInfo)localObject3).getIPInfo().ip;
      ((List)localObject1).add(paramString);
      if (((DownloadGlobalStrategy.StrategyInfo)localObject3).getIPInfo().port != 0)
      {
        i = ((DownloadGlobalStrategy.StrategyInfo)localObject3).getIPInfo().port;
        localArrayList2.add(Integer.valueOf(i));
      }
    }
    for (;;)
    {
      if (DownloaderFactory.getInstance(Global.getContext()).getPortStrategy() != null)
      {
        if (localArrayList2.size() <= 0) {
          break label407;
        }
        i = DownloaderFactory.getInstance(Global.getContext()).getPortStrategy().changePort((String)localObject2, ((Integer)localArrayList2.get(0)).intValue());
        if (i != ((Integer)localArrayList2.get(0)).intValue()) {
          localArrayList2.add(Integer.valueOf(i));
        }
      }
      for (;;)
      {
        if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null)
        {
          localObject3 = DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().resolveIP((String)localObject2);
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equalsIgnoreCase(paramString))) {
            ((List)localObject1).add(localObject3);
          }
        }
        if (DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy() != null)
        {
          localObject2 = DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy().resolveIP((String)localObject2);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equalsIgnoreCase(paramString))) {
            ((List)localObject1).add(localObject2);
          }
        }
        paramString = ((List)localObject1).iterator();
        while (paramString.hasNext())
        {
          localObject1 = (String)paramString.next();
          localObject2 = localArrayList2.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList1.add(new IPInfo((String)localObject1, ((Integer)((Iterator)localObject2).next()).intValue()));
          }
        }
        i = 80;
        break;
        label407:
        localArrayList2.add(Integer.valueOf(80));
      }
      return localArrayList1;
      paramString = null;
    }
  }
  
  public static DownloadGlobalStrategy.StrategyLib provideStrategyLib(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = Utils.getDomin(paramString);
    return DownloadGlobalStrategy.getInstance(Global.getContext()).getStrategyLib(paramString, str, false);
  }
  
  public static List<IPInfo> provideVideoIPList(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return localObject;
      str = Utils.getDomin(paramString);
    } while (TextUtils.isEmpty(str));
    paramString = new ArrayList();
    label117:
    for (;;)
    {
      try
      {
        if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() == null) {
          break label117;
        }
        localObject = DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().resolveVideoIP(str);
        if (localObject == null) {
          break label117;
        }
        int i = ((List)localObject).size();
        if (i <= 0) {
          break label117;
        }
        paramString = (String)localObject;
        return paramString;
      }
      catch (Exception localException)
      {
        localObject = paramString;
      }
      if (!QDLog.isInfoEnable()) {
        break;
      }
      QDLog.i("StrategyProvider", "provide video ip list error = " + localException.toString());
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.StrategyProvider
 * JD-Core Version:    0.7.0.1
 */