import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicProxyActivity;
import cooperation.comic.VipProxyPreLoadComicProcess;
import cooperation.comic.utils.QQComicPluginBridge.1;
import cooperation.plugin.PluginInfo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Observer;
import mqq.app.AppRuntime;

public class bmcx
{
  public static bmce a;
  public static bmci a;
  public static bmcv a;
  public static bmde a;
  private static final Object a;
  public static volatile boolean a;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static bmcj a(bioy parambioy, bmcf parambmcf)
  {
    if (jdField_a_of_type_Bmci == null) {
      return null;
    }
    return jdField_a_of_type_Bmci.a(parambioy, parambmcf);
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "load plugin start");
    }
    if (!QIPCServerHelper.getInstance().isModuleRunning("comic_plugin.apk")) {
      VasWebviewUtil.reportVasStatus("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Intent localIntent = new Intent(paramContext, VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    bmcw.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    a(localIntent);
    if ((bhyk.a() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)bhyk.a());
    }
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "comic_plugin.apk";
    localbmgt.d = "comic_plugin";
    localbmgt.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbmgt.e = "com.qqcomic.app.VipPreloadComicProcess";
    localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
    bmgk.b(paramContext, localbmgt);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "load plugin end");
    }
  }
  
  public static void a(Intent paramIntent)
  {
    boolean bool7 = false;
    int i = 0;
    boolean bool5 = true;
    if (paramIntent == null) {
      return;
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.comic_plugin_profile.name(), "");
    if (QLog.isColorLevel()) {
      QLog.d("QQComicPluginBridge", 2, "parseDPC config = " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        arrayOfInteger = new Integer[7];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        arrayOfInteger[2] = Integer.valueOf(1);
        if (DeviceProfileManager.a(str, arrayOfInteger, new anwm()) >= arrayOfInteger.length)
        {
          i = arrayOfInteger[0].intValue();
          if (i == 1) {
            bool1 = true;
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          boolean bool6;
          try
          {
            i = arrayOfInteger[1].intValue();
            if (i == 1) {
              bool2 = true;
            }
          }
          catch (Exception localException2)
          {
            Integer[] arrayOfInteger;
            int j;
            bool2 = true;
            bool3 = bool1;
            i = 0;
            bool1 = false;
            bool4 = false;
            continue;
          }
          try
          {
            i = arrayOfInteger[2].intValue();
            if (i == 1) {
              bool3 = true;
            }
          }
          catch (Exception localException3)
          {
            bool5 = true;
            bool3 = bool1;
            i = 0;
            bool4 = bool2;
            bool1 = false;
            bool2 = bool5;
            continue;
          }
          try
          {
            i = arrayOfInteger[3].intValue();
            if (i == 1) {
              bool4 = true;
            }
          }
          catch (Exception localException4)
          {
            bool6 = false;
            bool4 = bool1;
            bool5 = bool2;
            i = 0;
            bool1 = bool6;
            bool2 = bool3;
            bool3 = bool4;
            bool4 = bool5;
            continue;
          }
          try
          {
            i = arrayOfInteger[5].intValue();
          }
          catch (Exception localException5)
          {
            bool5 = bool1;
            bool6 = bool2;
            i = 0;
            bool1 = bool4;
            bool2 = bool3;
            bool3 = bool5;
            bool4 = bool6;
            continue;
          }
          try
          {
            j = arrayOfInteger[6].intValue();
            if (j == 1)
            {
              bool6 = bool4;
              bool7 = bool3;
              bool4 = bool2;
              bool3 = bool1;
              bool2 = bool7;
              bool1 = bool6;
              paramIntent.putExtra("isSetHardWareLayerForWebview", bool4);
              paramIntent.putExtra("isHandleNavigationBar", bool2);
              paramIntent.putExtra("isCloseHardAcc", bool1);
              paramIntent.putExtra("bitDepthFlag", i);
              paramIntent.putExtra("skipBitmapReuse", bool5);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QQComicDebug", 2, "parseDPC isPreloadInMiddlePage = " + bool3 + " , isSetHardWareLayerForWebview = " + bool4 + " , isHandleNavigationBar = " + bool2 + " , isCloseHardAcc = " + bool1 + " , bitDepthFlag = " + i + " , skipBitmapReuse = " + bool5);
              return;
              bool1 = false;
              continue;
              bool2 = false;
              continue;
              bool3 = false;
              continue;
              bool4 = false;
              continue;
            }
            bool5 = false;
            continue;
            localException1 = localException1;
            bool2 = true;
            bool3 = false;
            bool4 = false;
            bool1 = false;
            i = 0;
          }
          catch (Exception localException6)
          {
            bool5 = bool1;
            bool6 = bool2;
            bool1 = bool4;
            bool2 = bool3;
            bool3 = bool5;
            bool4 = bool6;
          }
        }
        localException1.printStackTrace();
        bool5 = bool7;
        continue;
        bool1 = false;
        bool2 = true;
        bool3 = false;
        bool4 = false;
        bool5 = false;
        continue;
      }
      boolean bool1 = false;
      boolean bool2 = true;
      boolean bool3 = false;
      boolean bool4 = false;
      i = 0;
      bool5 = bool7;
    }
  }
  
  public static void a(Observer paramObserver)
  {
    if (jdField_a_of_type_Bmcv == null) {
      jdField_a_of_type_Bmcv = new bmcv();
    }
    for (;;)
    {
      jdField_a_of_type_Bmcv.addObserver(paramObserver);
      return;
      jdField_a_of_type_Bmcv.deleteObservers();
    }
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent, String paramString, avsk paramavsk)
  {
    if ((!jdField_a_of_type_Boolean) || (paramActivity == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramIntent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
    if ((paramActivity instanceof BasePluginActivity))
    {
      paramActivity.startActivity(paramIntent);
      return true;
    }
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("params_remote_connect_at_launch", true);
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "comic_plugin.apk";
    localbmgt.d = "comic_plugin";
    localbmgt.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbmgt.e = paramString;
    localbmgt.jdField_a_of_type_JavaLangClass = VipComicProxyActivity.a(paramString);
    localbmgt.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbmgt.c = 10000;
    localbmgt.jdField_a_of_type_Avsk = paramavsk;
    bmgk.a(paramActivity, localbmgt);
    return true;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    boolean bool = false;
    if (jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!(paramAppRuntime instanceof QQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQComicPluginBridge", 2, "Not in main process, QQComic is NOT installed");
          }
          return jdField_a_of_type_Boolean;
        }
        paramAppRuntime = (bmgk)paramAppRuntime.getManager(27);
        if (paramAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
      return false;
      paramAppRuntime = paramAppRuntime.a("comic_plugin.apk");
      if (paramAppRuntime != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQComicPluginBridge", 2, "QQComic is NOT found");
    return false;
    if (paramAppRuntime.mState == 4) {}
    for (bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return jdField_a_of_type_Boolean;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, bmda arg2)
  {
    boolean bool = false;
    if (a(paramAppRuntime))
    {
      jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        paramAppRuntime = (bmgk)paramAppRuntime.getManager(27);
        if (paramAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
      return false;
      ThreadManager.executeOnNetWorkThread(new QQComicPluginBridge.1(paramAppRuntime, ???));
    } while (!paramBoolean);
    PluginInfo localPluginInfo = paramAppRuntime.a("comic_plugin.apk");
    if ((localPluginInfo != null) && (localPluginInfo.mState != 4)) {}
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicPluginBridge", 2, "QQComic is waiting for installation");
        }
        try
        {
          jdField_a_of_type_JavaLangObject.wait();
          if (QLog.isColorLevel()) {
            QLog.d("QQComicPluginBridge", 2, "QQComic installation is finished");
          }
          paramAppRuntime = paramAppRuntime.a("comic_plugin.apk");
          if ((paramAppRuntime != null) && (paramAppRuntime.mState == 4))
          {
            paramBoolean = true;
            jdField_a_of_type_Boolean = paramBoolean;
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder().append("QQComic is ");
              if (!jdField_a_of_type_Boolean) {
                break label235;
              }
              paramAppRuntime = "installed";
              QLog.d("QQComicPluginBridge", 2, paramAppRuntime);
            }
            return jdField_a_of_type_Boolean;
          }
        }
        catch (InterruptedException localInterruptedException) {}
      }
      paramBoolean = false;
      continue;
      label235:
      paramAppRuntime = "NOT installed";
    }
  }
  
  public static void b(Observer paramObserver)
  {
    if (jdField_a_of_type_Bmde == null) {
      jdField_a_of_type_Bmde = new bmde();
    }
    for (;;)
    {
      jdField_a_of_type_Bmde.addObserver(paramObserver);
      return;
      jdField_a_of_type_Bmde.deleteObservers();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcx
 * JD-Core Version:    0.7.0.1
 */