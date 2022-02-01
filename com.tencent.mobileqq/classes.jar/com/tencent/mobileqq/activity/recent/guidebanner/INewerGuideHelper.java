package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface INewerGuideHelper
  extends QRouteApi
{
  public abstract int getBannerId();
  
  public abstract NewerGuideBannerHandler getNewerGuideHandler(AppInterface paramAppInterface);
  
  public abstract NewerGuideBannerManager getNewerGuideManager(AppRuntime paramAppRuntime);
  
  public abstract void hideNewerGuideBanner(AppRuntime paramAppRuntime);
  
  public abstract <T> boolean isMayKnowRecentBaseData(T paramT);
  
  public abstract void notifyClickCloseBanner(NewerGuideBannerViewModel paramNewerGuideBannerViewModel);
  
  public abstract void showNewerGuideBanner(AppInterface paramAppInterface, Object paramObject);
  
  public abstract void startBrowser(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
 * JD-Core Version:    0.7.0.1
 */