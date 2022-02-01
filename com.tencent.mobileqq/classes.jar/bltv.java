import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoPluginInstallerActivity;
import cooperation.groupvideo.GVideoProxyActivity;
import cooperation.plugin.PluginInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class bltv
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.gvideo.com.tencent.av.app.GroupVideoAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("GroupVideoLog", 1, "*createGroupVideoAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "group_video_plugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.gvideo.com.tencent.av.app.GroupVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    if ((paramAppRuntime == null) || (paramServiceConnection == null)) {
      return;
    }
    try
    {
      paramAppRuntime.getApplication().unbindService(paramServiceConnection);
      return;
    }
    catch (IllegalArgumentException paramAppRuntime)
    {
      QLog.d("GroupVideoHelper", 2, "unbindService error" + paramAppRuntime.getMessage());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Class paramClass, ServiceConnection paramServiceConnection, String paramString)
  {
    if ((paramAppRuntime == null) || (paramServiceConnection == null)) {
      return;
    }
    paramClass = new Intent(paramAppRuntime.getApplication(), paramClass);
    paramClass.putExtra("useSkinEngine", 1);
    paramClass.putExtra("userQqResources", 2);
    blwh localblwh = new blwh(1);
    localblwh.b = "group_video_plugin.apk";
    localblwh.d = PluginInfo.k;
    localblwh.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblwh.e = paramString;
    localblwh.jdField_a_of_type_AndroidContentIntent = paramClass;
    localblwh.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blvy.c(paramAppRuntime.getApplication(), localblwh);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if ("com.tencent.mobileqq:groupvideo".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramAppInterface == null) || (paramActivity == null)) {
      return false;
    }
    if ((paramIntent != null) && (paramIntent.getIntExtra("Type", 0) == 0)) {
      paramIntent.putExtra("isInviteMode", true);
    }
    for (;;)
    {
      GVideoProxyActivity.a(paramActivity, paramIntent, GVideoProxyActivity.a(paramActivity), "com.gvideo.com.tencent.av.ui.GroupVideoActivity", paramAppInterface.getCurrentAccountUin(), paramInt);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    if ((paramQQAppInterface == null) || (!(paramContext instanceof Activity))) {
      return false;
    }
    paramContext = (Activity)paramContext;
    blvy localblvy = (blvy)paramQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
    if (localblvy == null) {
      return false;
    }
    if (localblvy.isPlugininstalled("group_video_plugin.apk")) {
      return a(paramQQAppInterface, paramContext, paramIntent, paramInt);
    }
    paramIntent.setClass(paramContext, GVideoPluginInstallerActivity.class);
    paramContext.startActivityForResult(paramIntent, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltv
 * JD-Core Version:    0.7.0.1
 */