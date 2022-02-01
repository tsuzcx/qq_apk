package com.tencent.comic.hippy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.api.hippy.BoodoModuleProxy;
import com.tencent.comic.api.hippy.IBoodoHippyApiBuilder;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.comic.data.BoodoHippyConfig;
import com.tencent.comic.utils.AppHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.lang.reflect.Constructor;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class BoodoHippyBirdge
{
  private static final String TAG = "BoodoHippyBirdge";
  public static boolean sBoodoRuntimeReady;
  public static IBoodoHippyApiBuilder sHippyApiBuilder;
  
  public static boolean checkBoodoRuntimeReady()
  {
    return sBoodoRuntimeReady;
  }
  
  public static void checkInitBoodoPluginImpl()
  {
    try
    {
      Constructor localConstructor = PluginStatic.getOrCreateClassLoader(AppHelper.a(), "comic_plugin.apk").loadClass("com.qqcomic.app.BoodoPluginTask").getDeclaredConstructor(new Class[0]);
      localConstructor.setAccessible(true);
      localConstructor.newInstance(new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("BoodoHippyBirdge", 1, localException, new Object[0]);
      return;
    }
    catch (InstantiationException localInstantiationException)
    {
      QLog.e("BoodoHippyBirdge", 1, localInstantiationException, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("BoodoHippyBirdge", 1, localIllegalAccessException, new Object[0]);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QLog.e("BoodoHippyBirdge", 1, localClassNotFoundException, new Object[0]);
    }
  }
  
  public static void checkPluginInstall(Context paramContext, BoodoHippyBirdge.ICheckPluginListener paramICheckPluginListener)
  {
    if (MobileQQ.sProcessId != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, "checkPluginInstall not in ProcessQQ");
      }
      paramContext = new Bundle();
      QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "check_qqcomic_plugin", paramContext, new BoodoHippyBirdge.1(paramICheckPluginListener));
      return;
    }
    Object localObject2 = null;
    AppRuntime localAppRuntime = AppHelper.b();
    Object localObject1 = localObject2;
    if (localAppRuntime != null)
    {
      localObject1 = localObject2;
      if ((localAppRuntime instanceof BaseQQAppInterface)) {
        localObject1 = (BaseQQAppInterface)localAppRuntime;
      }
    }
    checkPluginInstall(paramContext, (AppRuntime)localObject1, paramICheckPluginListener);
  }
  
  public static void checkPluginInstall(Context paramContext, AppRuntime paramAppRuntime, BoodoHippyBirdge.ICheckPluginListener paramICheckPluginListener)
  {
    if (paramAppRuntime == null)
    {
      if (paramICheckPluginListener != null) {
        paramICheckPluginListener.onResult(-1, null);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BoodoHippyBirdge", 2, "checkPluginInstall");
    }
    ThreadManagerV2.excute(new BoodoHippyBirdge.2(paramAppRuntime, paramICheckPluginListener, paramContext), 16, null, false);
  }
  
  public static void checkStartBoodoHippy(Context paramContext, Bundle paramBundle)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkStartBoodoHippy bundle:");
        ((StringBuilder)localObject).append(paramBundle.toString());
        QLog.d("BoodoHippyBirdge", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent(paramContext, VipComicJumpActivity.class);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("jumpto", "com.tencent.hippy.qq.fragment.CommonHippyFragment");
      localJSONObject.put("comic", "");
      ((Intent)localObject).putExtra("options", localJSONObject.toString());
      ((Intent)localObject).putExtra("click_start_time", System.currentTimeMillis());
      ((Intent)localObject).putExtra("hippy_bundle", paramBundle);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (JSONException paramContext)
    {
      QLog.e("BoodoHippyBirdge", 1, paramContext, new Object[0]);
    }
  }
  
  public static BoodoModuleProxy createBoodoModuleImp()
  {
    IBoodoHippyApiBuilder localIBoodoHippyApiBuilder = sHippyApiBuilder;
    if (localIBoodoHippyApiBuilder != null) {
      return localIBoodoHippyApiBuilder.createBoodoModuleImp();
    }
    QLog.i("BoodoHippyBirdge", 1, "createBoodoModuleImp");
    return null;
  }
  
  public static HippyAPIProvider createBoodoProvider()
  {
    IBoodoHippyApiBuilder localIBoodoHippyApiBuilder = sHippyApiBuilder;
    if (localIBoodoHippyApiBuilder != null) {
      return localIBoodoHippyApiBuilder.createBoodoProvider();
    }
    QLog.i("BoodoHippyBirdge", 1, "getBoodoProvider");
    return null;
  }
  
  public static boolean isBoodoModule(String paramString)
  {
    if ("QQBoodoComic".equals(paramString)) {
      return true;
    }
    if (!QQComicConfBean.b().mAllModules.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, new Object[] { "isBoodoModule moduleName:", paramString });
      }
      return QQComicConfBean.b().mAllModules.contains(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.hippy.BoodoHippyBirdge
 * JD-Core Version:    0.7.0.1
 */