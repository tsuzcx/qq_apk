package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HippyUtils
{
  public static final String BASE_API_PROVIDER_CLASS_NAME = "com.tencent.hippy.qq.app.HippyQQAPIProvider";
  public static final String GAMECENTER_API_PROVIDER_CLASS_NAME = "com.tencent.hippy.qq.app.GameCenterApiProvider";
  private static final String HIPPY_FONE_FOLDER = "hippy_font";
  private static final String HIPPY_FONT_DIR;
  private static final String TAG = "HippyUtils";
  private static HashMap<String, Constructor<?>> gProviderConstructorMap = new HashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("hippy_font");
    localStringBuilder.append(File.separator);
    HIPPY_FONT_DIR = localStringBuilder.toString();
  }
  
  private static void addApiProvider(List<HippyAPIProvider> paramList, String paramString)
  {
    if (paramList != null) {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (!bool)
        {
          try
          {
            Constructor localConstructor2 = (Constructor)gProviderConstructorMap.get(paramString);
            Constructor localConstructor1 = localConstructor2;
            if (localConstructor2 == null)
            {
              localConstructor1 = Class.forName(paramString).getConstructor(new Class[0]);
              gProviderConstructorMap.put(paramString, localConstructor1);
            }
            paramString = localConstructor1.newInstance(new Object[0]);
            if ((paramString instanceof HippyAPIProvider)) {
              paramList.add((HippyAPIProvider)paramString);
            }
          }
          catch (Throwable paramList)
          {
            paramString = new StringBuilder();
            paramString.append("addApiProvider e:");
            paramString.append(paramList);
            QLog.e("HippyUtils", 1, paramString.toString());
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public static void addBaseApiProvider(List<HippyAPIProvider> paramList)
  {
    addApiProvider(paramList, "com.tencent.hippy.qq.app.HippyQQAPIProvider");
  }
  
  public static void addGameCenterApiProvider(List<HippyAPIProvider> paramList)
  {
    addApiProvider(paramList, "com.tencent.hippy.qq.app.GameCenterApiProvider");
  }
  
  public static AppInterface getAppInterface()
  {
    AppRuntime localAppRuntime2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime localAppRuntime1 = localAppRuntime2;
    if (MobileQQ.sProcessId == 7)
    {
      localAppRuntime1 = localAppRuntime2;
      if (localAppRuntime2 != null) {
        localAppRuntime1 = localAppRuntime2.getAppRuntime("modular_web");
      }
    }
    if ((localAppRuntime1 instanceof AppInterface)) {
      return (AppInterface)localAppRuntime1;
    }
    return null;
  }
  
  public static String getHippyFontRootDir()
  {
    return HIPPY_FONT_DIR;
  }
  
  public static void gotoBrowserActivity(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  public static void gotoGamePubAccountErrorUrl(Activity paramActivity, String paramString)
  {
    paramString = new WadlReportBuilder();
    paramString.a("dc00087").h("771").c("206612").a(1, "76918").a(11, "1").a(12, "160");
    paramString.a(24, GamePubAccountHelper.a());
    paramString.a(-4);
    paramString.a();
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterAIO(paramActivity);
  }
  
  public static void preloadHippyInToolProcess(Intent paramIntent)
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
      localStringBuilder.append("preloadHippyInToolProcess sendBroadcast:");
      localStringBuilder.append(paramIntent);
      QLog.e("HippyUtils", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyUtils
 * JD-Core Version:    0.7.0.1
 */