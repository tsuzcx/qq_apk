import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.cache.MiniCacheFreeManager.1;
import com.tencent.qqmini.sdk.core.cache.MiniCacheFreeManager.2;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import java.io.File;

public class bgiv
{
  public static void a(Activity paramActivity, String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2)
  {
    bgkk.a(new MiniCacheFreeManager.1(paramActivity, paramString2, paramString1, paramMiniAppInfo));
  }
  
  public static void a(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    a(paramString, paramMiniAppInfo, true);
  }
  
  public static void a(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    a(paramString, paramMiniAppInfo, paramBoolean, null);
  }
  
  public static void a(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgjs parambgjs)
  {
    ThreadManager.a(new MiniCacheFreeManager.2(paramMiniAppInfo, paramString, paramBoolean), 16, parambgjs, true);
  }
  
  private static void d(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return;
      paramString = bgiy.a(AppLoaderFactory.g().getContext().getCacheDir().getAbsolutePath(), paramString, paramMiniAppInfo.appId);
    } while (!new File(paramString).exists());
    bgkv.a(paramString, false);
    QMLog.i("MiniCacheFreeManager", "clearStorageCache finish. " + paramMiniAppInfo.appId);
  }
  
  private static void e(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    String str;
    do
    {
      return;
      str = bgrb.a(paramMiniAppInfo);
    } while (!new File(str).exists());
    bgkv.a(str, false);
    QMLog.i("MiniCacheFreeManager", "clearPkg finish: " + paramMiniAppInfo.appId);
  }
  
  private static void e(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while (!AppLoaderFactory.g().getContext().getSharedPreferences(paramMiniAppInfo.appId + "_" + paramString, 4).edit().clear().commit()) {
      return;
    }
    QMLog.i("MiniCacheFreeManager", "clearAuthSp finish. " + paramMiniAppInfo.appId);
  }
  
  private static void f(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return;
    }
    bgjm.a();
    bgjm.a(paramMiniAppInfo.appId);
    QMLog.i("MiniCacheFreeManager", "clearFileCache finish. " + paramMiniAppInfo.appId);
  }
  
  private static void g(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while (!StorageUtil.getPreference().edit().putBoolean(paramMiniAppInfo.appId + "_debug", false).commit()) {
      return;
    }
    QMLog.i("MiniCacheFreeManager", "clearDebugSp finish. " + paramMiniAppInfo.appId);
  }
  
  private static void h(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().stopMiniApp(paramMiniAppInfo);
    QMLog.i("MiniCacheFreeManager", "kill process. " + paramMiniAppInfo.appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgiv
 * JD-Core Version:    0.7.0.1
 */