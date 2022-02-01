package com.tencent.livesdk.servicefactory.builder.web;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.falco.base.libapi.web.WebCookieInterface;
import com.tencent.falco.base.libapi.web.WebInterface.JavascriptInterfaceAdapter;
import com.tencent.falco.base.libapi.web.WebInterface.WebComponentAdapter;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.UriUtil;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;
import java.util.List;
import java.util.Map;

public class WebServiceBuilder$BaseWebComponentAdapter
  implements WebCookieInterface, WebInterface.JavascriptInterfaceAdapter, WebInterface.WebComponentAdapter
{
  private ServiceAccessor serviceManager;
  
  public WebServiceBuilder$BaseWebComponentAdapter(ServiceAccessor paramServiceAccessor)
  {
    this.serviceManager = paramServiceAccessor;
  }
  
  public ActivityLifeService getActivityLifeService()
  {
    return (ActivityLifeService)this.serviceManager.getService(ActivityLifeService.class);
  }
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public FloatWindowConfigServiceInterface getFloatWindowConfig()
  {
    return (FloatWindowConfigServiceInterface)this.serviceManager.getService(FloatWindowConfigServiceInterface.class);
  }
  
  public FloatWindowPermissionInterface getFloatWindowPermission()
  {
    return (FloatWindowPermissionInterface)this.serviceManager.getService(FloatWindowPermissionInterface.class);
  }
  
  public HostProxyInterface getHostProxy()
  {
    return (HostProxyInterface)this.serviceManager.getService(HostProxyInterface.class);
  }
  
  public HostProxyInterface getHostProxyInterface()
  {
    return (HostProxyInterface)this.serviceManager.getService(HostProxyInterface.class);
  }
  
  public ImageLoaderInterface getImageLoader()
  {
    return (ImageLoaderInterface)this.serviceManager.getService(ImageLoaderInterface.class);
  }
  
  public WebInterface.JavascriptInterfaceAdapter getJSAdapter()
  {
    return new WebServiceBuilder.BaseWebComponentAdapter.1(this);
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)this.serviceManager.getService(LogInterface.class);
  }
  
  public ToastInterface getToast()
  {
    return (ToastInterface)this.serviceManager.getService(ToastInterface.class);
  }
  
  public long getUid()
  {
    LoginServiceInterface localLoginServiceInterface = (LoginServiceInterface)ServiceAccessorMgr.getInstance().getUserAccessor().getService(LoginServiceInterface.class);
    if ((localLoginServiceInterface != null) && (localLoginServiceInterface.getLoginInfo() != null)) {
      return localLoginServiceInterface.getLoginInfo().uid;
    }
    return 0L;
  }
  
  public WebCookieInterface getWebCookie()
  {
    return this;
  }
  
  public void handleTNowUrl(Uri paramUri, Bundle paramBundle) {}
  
  public void openSharePage(Map<String, String> paramMap) {}
  
  @SuppressLint({"DefaultLocale"})
  public void writeCookie(String paramString, List<String> paramList)
  {
    Object localObject = (LoginServiceInterface)ServiceAccessorMgr.getInstance().getUserAccessor().getService(LoginServiceInterface.class);
    if ((localObject != null) && (((LoginServiceInterface)localObject).getLoginInfo() != null))
    {
      LoginInfo localLoginInfo = ((LoginServiceInterface)localObject).getLoginInfo();
      long l2 = localLoginInfo.uid;
      long l1;
      if (localLoginInfo.tinyid != 0L) {
        l1 = localLoginInfo.tinyid;
      } else {
        l1 = l2;
      }
      String str1;
      if (localLoginInfo.a2 == null) {
        str1 = "";
      } else {
        str1 = HexUtil.bytesToHexString(localLoginInfo.a2);
      }
      int i = WebServiceBuilder.1.$SwitchMap$com$tencent$falco$base$libapi$login$LoginType[localObject.getLoginInfo().loginType.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          i = -1;
        } else {
          i = 0;
        }
      }
      else {
        i = 1;
      }
      int j = ((AppGeneralInfoService)this.serviceManager.getService(AppGeneralInfoService.class)).getVersionCode();
      localObject = ((AppGeneralInfoService)this.serviceManager.getService(AppGeneralInfoService.class)).getVersionName();
      int k = ((AppGeneralInfoService)this.serviceManager.getService(AppGeneralInfoService.class)).getClientType();
      String str2 = ((AppGeneralInfoService)this.serviceManager.getService(AppGeneralInfoService.class)).getChannelID();
      String str3 = ((AppGeneralInfoService)this.serviceManager.getService(AppGeneralInfoService.class)).getDeviceID();
      paramString = UriUtil.getTopLevelDomainInLowerCase(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(";Domain=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(";Path=/;");
      paramString = localStringBuilder.toString();
      paramList.add(String.format("%s=%s%s", new Object[] { "__client_exchange_appid", "", paramString }));
      paramList.add(String.format("%s=%d%s", new Object[] { "ilive_uin", Long.valueOf(l2), paramString }));
      paramList.add(String.format("%s=%d%s", new Object[] { "ilive_tinyid", Long.valueOf(l1), paramString }));
      paramList.add(String.format("%s=%d%s", new Object[] { "versioncode", Integer.valueOf(j), paramString }));
      paramList.add(String.format("%s=%s%s", new Object[] { "versionname", localObject, paramString }));
      paramList.add(String.format("%s=%d%s", new Object[] { "__client_type", Integer.valueOf(k), paramString }));
      paramList.add(String.format("%s=%s%s", new Object[] { "ilive_a2", str1, paramString }));
      paramList.add(String.format("%s=%s%s", new Object[] { "channel_id", str2, paramString }));
      paramList.add(String.format("%s=%d%s", new Object[] { "ilive_uid_type", Integer.valueOf(i), paramString }));
      paramList.add(String.format("%s=%s%s", new Object[] { "ilive_deviceID", str3, paramString }));
      paramList.add(String.format("%s=%s%s", new Object[] { "originalId", localLoginInfo.openId, paramString }));
      paramList.add(String.format("%s=%s%s", new Object[] { "originalKey", localLoginInfo.access_token, paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.web.WebServiceBuilder.BaseWebComponentAdapter
 * JD-Core Version:    0.7.0.1
 */