import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper.2;
import cooperation.qqfav.QfavHelper.4;
import cooperation.qqfav.QfavPluginProxyActivity;
import cooperation.qqfav.QfavPluginProxyReceiver;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public final class biqv
{
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static SharedPreferences a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_AndroidContentSharedPreferences == null) {
        jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("shared_prefs_qfav", 4);
      }
      paramContext = jdField_a_of_type_AndroidContentSharedPreferences;
      return paramContext;
    }
    finally {}
  }
  
  public static ClassLoader a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    try
    {
      localObject = PluginStatic.getOrCreateClassLoader((Context)localObject, "qqfav.apk");
      QLog.i("qqfavQfavHelper#getClassLoader", 1, "Exception =" + QLog.getStackTraceString(localException1));
    }
    catch (Exception localException1)
    {
      try
      {
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
        return localObject;
      }
      catch (Exception localException2)
      {
        break label24;
      }
      localException1 = localException1;
      localObject = null;
    }
    label24:
    return localObject;
  }
  
  public static Object a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName(paramString);
        if (localClass == null) {
          QLog.i("qqfavQfavHelper#createInstance", 1, "className =" + paramString + ",cls == null");
        }
        paramArrayOfClass = localClass.getDeclaredConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
        if (paramArrayOfClass != null) {
          break;
        }
        QLog.i("qqfavQfavHelper#createInstance", 4, "className =" + paramString + ",retObj == null");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localObject = a();
        if (localObject != null)
        {
          localObject = ((ClassLoader)localObject).loadClass(paramString);
          continue;
        }
      }
      catch (Exception paramString)
      {
        QLog.i("qqfavQfavHelper#createInstance", 1, "Exception =" + QLog.getStackTraceString(paramString));
        return null;
      }
      Object localObject = null;
    }
    return paramArrayOfClass;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    return (AppRuntime)a("com.qqfav.QfavAppInterface", new Class[] { BaseApplicationImpl.class, String.class }, new Object[] { paramBaseApplicationImpl, "qqfav" });
  }
  
  public static void a(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getApplication();
    }
    try
    {
      new QfavHelper.4((Context)localObject, paramOnPluginInstallListener).start();
      return;
    }
    catch (Throwable paramContext)
    {
      do
      {
        paramContext.printStackTrace();
      } while (paramOnPluginInstallListener == null);
      try
      {
        paramOnPluginInstallListener.onInstallError("qqfav.apk", -1);
        return;
      }
      catch (RemoteException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramBoolean1, paramString2, paramBoolean2, 2131692401);
  }
  
  @TargetApi(9)
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    QQToast localQQToast = new QQToast(paramContext);
    localQQToast.d(2000);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    if (paramBoolean1)
    {
      localQQToast.b(2);
      localQQToast.a(QQToast.a(2));
      localQQToast.c(paramInt);
      if (!a(paramContext).getBoolean("pref_first_collection_" + str, true)) {}
    }
    for (;;)
    {
      try
      {
        paramString2 = paramContext.getString(2131692442);
        if (!paramBoolean2) {
          continue;
        }
        paramString1 = paramContext.getString(2131692437);
        paramString1 = bdcd.a(paramContext, 230, paramString2, paramString1, 2131690648, 2131692440, new biqw(), null);
        if (paramContext != BaseApplicationImpl.getContext()) {
          break label636;
        }
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        paramString1.getWindow().setType(2038);
        paramInt = 1;
        int j = 1;
        int i = j;
        if (paramInt != 0)
        {
          i = j;
          if (Build.VERSION.SDK_INT >= 23)
          {
            i = j;
            if (!Settings.canDrawOverlays(paramContext)) {
              i = 0;
            }
          }
        }
        if ((paramInt == 0) || (i != 0)) {
          continue;
        }
        paramString1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        paramString1.addFlags(268435456);
        BaseApplicationImpl.getApplication().startActivity(paramString1);
      }
      catch (Throwable paramString1)
      {
        QLog.e("qqfav", 1, "First collection guide error. Uin=" + str + ", flag=" + a(paramContext).getBoolean(new StringBuilder().append("pref_first_collection_").append(str).toString(), true));
        continue;
        a(paramContext).edit().putBoolean("pref_first_collection_" + str, false).apply();
        continue;
      }
      localQQToast.b(paramContext.getResources().getDimensionPixelSize(2131298914) - (int)(5.0F * paramContext.getResources().getDisplayMetrics().density));
      return;
      paramString1 = paramContext.getString(2131692441);
      continue;
      if (Build.VERSION.SDK_INT > 24)
      {
        paramString1.getWindow().setType(2003);
        paramInt = 1;
      }
      else
      {
        paramString1.getWindow().setType(2005);
        paramInt = 0;
        continue;
        paramString1.getWindow().setType(2003);
        paramInt = 1;
        continue;
        paramString1.setMessageCount(null).show();
        if (9 > Build.VERSION.SDK_INT)
        {
          a(paramContext).edit().putBoolean("pref_first_collection_" + str, false).commit();
          if (QLog.isColorLevel()) {
            QLog.d("qqfav", 2, "First collection guide shown. Uin=" + str + ", flag=" + a(paramContext).getBoolean(new StringBuilder().append("pref_first_collection_").append(str).toString(), true));
          }
        }
        else
        {
          localQQToast.b(1);
          localQQToast.a(QQToast.a(1));
          if (paramString2 == null)
          {
            localQQToast.c(2131692402);
          }
          else
          {
            localQQToast.a(paramString2);
            continue;
            label636:
            paramInt = 0;
          }
        }
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      if (!((BaseApplicationImpl)localObject).getSharedPreferences("QfavNeedReupload", i).getBoolean(paramAppRuntime.getAccount() + "QfavNeedReupload", false)) {
        break label111;
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "reuploadQfavItems: flag=true");
      }
      localObject = new Intent("com.tencent.mobileqq.ACTION_QFAVIPC_BROADCAST");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("nOperation", 5);
      QfavPluginProxyReceiver.a(paramAppRuntime, (Intent)localObject);
    }
    label111:
    while (!QLog.isColorLevel())
    {
      return;
      i = 0;
      break;
    }
    QLog.i("qqfav", 2, "reuploadQfavItems: flag=false");
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 3);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean a(Activity paramActivity, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 7);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    paramIntent.setFlags(paramIntent.getFlags() & 0xFBFFFFFF & 0xDFFFFFFF);
    return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    if (paramIntent == null) {}
    for (paramIntent = new Intent();; paramIntent = new Intent(paramIntent))
    {
      paramIntent.putExtra("nOperation", 2);
      paramIntent.putExtra("bShowProgress", paramBoolean);
      paramIntent.putExtra("begin", System.currentTimeMillis());
      birl.a(paramString);
      if (!biri.a().a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "openPluginActivityForResult need pending data." + paramIntent.toString());
        }
        byte[] arrayOfByte = biri.a().a();
        if ((arrayOfByte == null) && (QLog.isColorLevel())) {
          QLog.d("qqfav", 2, "openPluginActivityForResult pending data error.");
        }
        paramIntent.putExtra("pendingData", arrayOfByte);
      }
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.endsWith(":qqfav"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 6);
    localIntent.putExtra("lId", paramLong);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 6);
    localIntent.putExtra("lId", paramLong);
    localIntent.putExtra("backUpFavData", paramArrayOfByte);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    return (paramChatMessage != null) && ((aogs.c.equals(paramChatMessage.ark_app_message.appName)) || ("com.tencent.structmsg".equals(paramChatMessage.ark_app_message.appName)));
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    Object localObject2 = new QfavHelper.2();
    if (paramBoolean) {}
    synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new biqx((Runnable)localObject2));
      localObject2 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (??? == localObject2) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "wait(sPluginInstalled) qqfav.apk");
        }
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait(5000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "qqfav.apk, sPluginInstalled = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      ??? = localObject2;
    }
  }
  
  public static byte[] a(boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("bPublicAccount", paramBoolean);
      localObject = ((JSONObject)localObject).toString().getBytes();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.i("qqfav", 2, "publicAccountLinkBizData: JSONException error");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     biqv
 * JD-Core Version:    0.7.0.1
 */