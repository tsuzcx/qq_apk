package com.tencent.hippy.qq.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

@QAPI(process={"all"})
public abstract interface IHippyUtils
  extends QRouteApi
{
  public abstract Throwable createHippyException(String paramString, Throwable paramThrowable);
  
  public abstract AppInterface getAppInterface();
  
  public abstract HippyAPIProvider getBaseHippyAPIProvider();
  
  public abstract HippyAPIProvider getGameCenterHippyAPIProvider();
  
  public abstract int getHippyPreloadBusinessID();
  
  public abstract boolean getHippySoDownload();
  
  public abstract HippyAPIProvider getVasHippyAPIProvider();
  
  public abstract void gotoBrowserActivity(Activity paramActivity, String paramString);
  
  public abstract void gotoGameCenterErrorUrl(Activity paramActivity, String paramString);
  
  public abstract void gotoGamePubAccountErrorUrl(Activity paramActivity, String paramString);
  
  public abstract boolean isDomainMatch(String paramString1, String paramString2);
  
  public abstract boolean isGameCenterPreloadByTab();
  
  public abstract boolean isUpdateHippyJsBundleByHttp();
  
  public abstract void preloadHippyInToolProcess(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippyUtils
 * JD-Core Version:    0.7.0.1
 */