package com.tencent.comic.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import mqq.app.ISecurityFileHelper;

@QAPI(process={"all"})
public abstract interface IQQComicUtil
  extends QRouteApi
{
  public abstract String addParamToUrl(String paramString1, String paramString2);
  
  public abstract void fetchReportInfo(Intent paramIntent, boolean paramBoolean);
  
  public abstract String getActionId();
  
  public abstract Intent getBackgroundQQComicIntent(AppRuntime paramAppRuntime);
  
  public abstract Class getComicJumpActivityClass();
  
  public abstract ISecurityFileHelper getComicSecurityFileHelper();
  
  public abstract QIPCModule getIpcModule();
  
  public abstract Class<? extends Activity> getProxyActivityClass(String paramString);
  
  public abstract String getUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract boolean handleParam(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent);
  
  public abstract void initMagnifierSDK(AppRuntime paramAppRuntime);
  
  public abstract boolean initPluginBeforeEnter(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent);
  
  public abstract void initUrlMap(Intent paramIntent);
  
  public abstract boolean isVideoUrl(String paramString, Intent paramIntent);
  
  public abstract void notifyFirstInObservableChanged(Context paramContext);
  
  public abstract void openQQBrowserActivityForComic(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void preloadQQBoodoComic(AppRuntime paramAppRuntime);
  
  public abstract void reportClickEventTo644(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs);
  
  public abstract void setDefaultComicTab(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicUtil
 * JD-Core Version:    0.7.0.1
 */