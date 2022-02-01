package com.tencent.gamecenter.wadl.util;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlResCallBack;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WadlProxyServiceWrap
{
  protected WadlProxyServiceWrap()
  {
    QLog.i("WadlProxyServiceWrap", 1, "WadlProxyServiceWrap new instance");
  }
  
  public void a()
  {
    QLog.d("WadlProxyServiceWrap", 1, "doQueryAllTask");
    IQQGameDownloadService localIQQGameDownloadService = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localIQQGameDownloadService != null) {
      localIQQGameDownloadService.doQueryAllTask();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPauseAction from=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",appId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).doPauseAction(paramInt, paramString);
    }
  }
  
  public void a(WadlParams paramWadlParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchAction wadlParams=");
    localStringBuilder.append(paramWadlParams);
    QLog.i("WadlProxyServiceWrap", 1, localStringBuilder.toString());
    int i = paramWadlParams.c;
    if (i != 2)
    {
      if (i != 3) {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 10) {
              if (i == 12) {
                break label101;
              }
            }
          }
          else {
            c(paramWadlParams);
          }
        }
        else
        {
          b(paramWadlParams.h, paramWadlParams.e);
          return;
        }
      }
      a(paramWadlParams.h, paramWadlParams.e);
      return;
    }
    label101:
    if ((!paramWadlParams.b) && (paramWadlParams.g))
    {
      if (!TextUtils.isEmpty(paramWadlParams.G))
      {
        GameCenterUtil.a(paramWadlParams.e, "DELAY_LIST");
        GameCenterUtil.a(paramWadlParams.e, paramWadlParams.G, "DELAY_APPID_DETAIL_");
        GameCenterBroadcastReceiver.a();
      }
      return;
    }
    b(paramWadlParams);
  }
  
  public void a(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("registerWadlServiceCallBack callback=");
    ((StringBuilder)localObject).append(paramWadlProxyServiceCallBackInterface);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).registerWadlServiceCallBack(paramWadlProxyServiceCallBackInterface);
    }
  }
  
  public void a(WadlResCallBack paramWadlResCallBack)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("registerResCallBack callback=");
    ((StringBuilder)localObject).append(paramWadlResCallBack);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).registerResCallBack(paramWadlResCallBack);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doQueryActionByVia via=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).doQueryActionByVia(paramString);
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doQueryAction apps=");
    ((StringBuilder)localObject).append(paramArrayList);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).doQueryAction(paramArrayList);
    }
  }
  
  public void b()
  {
    QLog.d("WadlProxyServiceWrap", 1, "doQueryAllRes");
    IQQGameDownloadService localIQQGameDownloadService = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localIQQGameDownloadService != null) {
      localIQQGameDownloadService.doQueryAllRes();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doResumeAction from=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",appId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).doResumeAction(paramInt, paramString);
    }
  }
  
  public void b(WadlParams paramWadlParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDownloadAction wadlParams=");
    ((StringBuilder)localObject).append(paramWadlParams);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    if (paramWadlParams == null) {
      return;
    }
    if (!paramWadlParams.b)
    {
      if (TextUtils.isEmpty(paramWadlParams.i)) {
        paramWadlParams.i = "10000144";
      }
      if (TextUtils.isEmpty(paramWadlParams.A)) {
        paramWadlParams.A = "biz_src_zf_games";
      }
      if (TextUtils.isEmpty(paramWadlParams.u)) {
        paramWadlParams.u = paramWadlParams.m;
      }
      GameCenterUtil.b(paramWadlParams.e, "DELAY_LIST");
      GameCenterUtil.c(paramWadlParams.e, "DELAY_APPID_DETAIL_");
      if ((paramWadlParams.h == 1) || (paramWadlParams.h == 2))
      {
        paramWadlParams.c(8);
        if (paramWadlParams.h == 1) {
          paramWadlParams.c(4);
        }
      }
    }
    else
    {
      paramWadlParams.b(1);
    }
    if (TextUtils.isEmpty(paramWadlParams.k))
    {
      localObject = new WadlReportBuilder();
      ((WadlReportBuilder)localObject).a("dc00087").h("558").c("202982").b(paramWadlParams.e).a(1, "55801").a(11, "4").a(12, "430");
      ((WadlReportBuilder)localObject).a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid url:");
      ((StringBuilder)localObject).append(paramWadlParams);
      QLog.i("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).doDownloadAction(paramWadlParams);
    }
  }
  
  public void b(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unRegisterWadlServiceCallBack callback=");
    ((StringBuilder)localObject).append(paramWadlProxyServiceCallBackInterface);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).unRegisterWadlServiceCallBack(paramWadlProxyServiceCallBackInterface);
    }
  }
  
  public void b(WadlResCallBack paramWadlResCallBack)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("registerResCallBack callback=");
    ((StringBuilder)localObject).append(paramWadlResCallBack);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).unRegisterResCallBack(paramWadlResCallBack);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPauseResAction resId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).doPauseResAction(paramString);
    }
  }
  
  public void c()
  {
    QLog.d("WadlProxyServiceWrap", 1, "destroy");
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).destroy();
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).destroy();
  }
  
  public void c(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("deleteDownload from=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",appId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).deleteDownload(paramInt, paramString);
    }
  }
  
  public void c(WadlParams paramWadlParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doInstallAction wadlParams=");
    ((StringBuilder)localObject).append(paramWadlParams);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    if (paramWadlParams == null) {
      return;
    }
    if (TextUtils.isEmpty(paramWadlParams.A)) {
      paramWadlParams.A = "biz_src_zf_games";
    }
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).doInstallAction(paramWadlParams);
    }
  }
  
  public void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doResumeResAction resId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).doResumeResAction(paramString);
    }
  }
  
  public void d(WadlParams paramWadlParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchResAction wadlParams=");
    localStringBuilder.append(paramWadlParams);
    QLog.i("WadlProxyServiceWrap", 1, localStringBuilder.toString());
    int i = paramWadlParams.c;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 10) {
            return;
          }
          d(paramWadlParams.a());
          return;
        }
        c(paramWadlParams.a());
        return;
      }
      b(paramWadlParams.a());
      return;
    }
    b(paramWadlParams);
  }
  
  public void d(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("deleteResDownload resId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WadlProxyServiceWrap", 1, ((StringBuilder)localObject).toString());
    localObject = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
    if (localObject != null) {
      ((IQQGameDownloadService)localObject).deleteResDownload(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap
 * JD-Core Version:    0.7.0.1
 */