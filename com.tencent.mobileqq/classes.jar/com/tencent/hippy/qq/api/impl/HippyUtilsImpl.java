package com.tencent.hippy.qq.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.hippy.qq.app.GameCenterApiProvider;
import com.tencent.hippy.qq.app.HippyQQAPIProvider;
import com.tencent.hippy.qq.exception.QQHippyException;
import com.tencent.hippy.qq.utils.HippyCommonUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.hippy.api.impl.VasApiProvider;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class HippyUtilsImpl
  implements IHippyUtils
{
  private static final String TAG = "WebProcessReceiverImpl";
  
  public Throwable createHippyException(String paramString, Throwable paramThrowable)
  {
    return new QQHippyException(paramString, paramThrowable);
  }
  
  public AppInterface getAppInterface()
  {
    return HippyCommonUtils.getAppInterface();
  }
  
  public HippyAPIProvider getBaseHippyAPIProvider()
  {
    return new HippyQQAPIProvider();
  }
  
  public HippyAPIProvider getGameCenterHippyAPIProvider()
  {
    return new GameCenterApiProvider();
  }
  
  public int getHippyPreloadBusinessID()
  {
    return 10097;
  }
  
  public boolean getHippySoDownload()
  {
    return ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySoDownload();
  }
  
  public HippyAPIProvider getVasHippyAPIProvider()
  {
    return new VasApiProvider();
  }
  
  public void gotoBrowserActivity(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  public void gotoGameCenterErrorUrl(Activity paramActivity, String paramString)
  {
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startGameCenterActivity(paramActivity, paramString);
  }
  
  public void gotoGamePubAccountErrorUrl(Activity paramActivity, String paramString)
  {
    paramString = new WadlReportBuilder();
    paramString.a("dc00087").h("771").c("206612").a(1, "76918").a(11, "1").a(12, "160");
    paramString.a(24, GamePubAccountHelper.a());
    paramString.a(-4);
    paramString.a();
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterAIO(paramActivity);
  }
  
  public boolean isDomainMatch(String paramString1, String paramString2)
  {
    return AuthorizeConfig.b(paramString1, paramString2);
  }
  
  public boolean isGameCenterPreloadByTab()
  {
    return ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isGameCenterPreloadByTab();
  }
  
  public boolean isUpdateHippyJsBundleByHttp()
  {
    return ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp();
  }
  
  public void preloadHippyInToolProcess(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      paramIntent.putExtra("from", 306);
      paramIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
      paramIntent.setPackage(MobileQQ.getContext().getPackageName());
      MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(paramIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable paramIntent)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndPreloadHippyPage sendBroadcast:");
      localStringBuilder.append(paramIntent);
      QLog.e("WebProcessReceiverImpl", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyUtilsImpl
 * JD-Core Version:    0.7.0.1
 */