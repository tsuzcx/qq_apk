package com.tencent.falco.base.libapi.web;

import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;

public abstract interface WebInterface$WebComponentAdapter
{
  public abstract ActivityLifeService getActivityLifeService();
  
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract FloatWindowConfigServiceInterface getFloatWindowConfig();
  
  public abstract FloatWindowPermissionInterface getFloatWindowPermission();
  
  public abstract HostProxyInterface getHostProxy();
  
  public abstract HostProxyInterface getHostProxyInterface();
  
  public abstract ImageLoaderInterface getImageLoader();
  
  public abstract WebInterface.JavascriptInterfaceAdapter getJSAdapter();
  
  public abstract LogInterface getLog();
  
  public abstract ToastInterface getToast();
  
  public abstract long getUid();
  
  public abstract WebCookieInterface getWebCookie();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.web.WebInterface.WebComponentAdapter
 * JD-Core Version:    0.7.0.1
 */