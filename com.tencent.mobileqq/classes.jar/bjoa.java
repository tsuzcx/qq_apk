import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager.4;
import cooperation.qzone.plugin.PluginRecord;
import java.io.File;
import mqq.app.AppRuntime;

public abstract class bjoa
  extends bjqd
{
  public static void a(Activity paramActivity, bjog parambjog)
  {
    if (parambjog.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambjog.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new bjob();
    if ((parambjog.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, parambjog.jdField_a_of_type_AndroidAppDialog, parambjog.d, parambjog.jdField_b_of_type_JavaLangString, parambjog.jdField_a_of_type_Boolean, parambjog.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, parambjog, (bjof)localObject);
      return;
    }
    ((bjoa)((QQAppInterface)localAppRuntime).getManager(175)).a(paramActivity, parambjog, (bjof)localObject);
  }
  
  public static void a(Context paramContext, bjog parambjog)
  {
    bjoc localbjoc = new bjoc();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambjog, localbjoc);
      return;
    }
    ((bjoa)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambjog, localbjoc);
  }
  
  static void b(Activity paramActivity, bjog parambjog)
  {
    if ((parambjog == null) || (paramActivity == null) || (parambjog.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      parambjog.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, parambjog.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(parambjog.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambjog.jdField_a_of_type_JavaLangString);
        parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambjog.jdField_a_of_type_JavaLangString);
      }
      parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambjog.jdField_a_of_type_JavaLangString);
      parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azql.class.getName());
      try
      {
        File localFile = new File(bjpz.a(paramActivity), parambjog.jdField_b_of_type_JavaLangString);
        PluginProxyActivity.openActivityForResult(paramActivity, parambjog.d, parambjog.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), parambjog.e, parambjog.jdField_a_of_type_AndroidContentIntent, parambjog.jdField_b_of_type_Int);
        if ((parambjog.jdField_a_of_type_AndroidAppDialog != null) && ((parambjog.jdField_a_of_type_AndroidAppDialog instanceof beun)) && (paramActivity != null))
        {
          paramActivity.overridePendingTransition(2130772097, 2130772097);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("feilongzou", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  public static void b(Context paramContext, bjog parambjog)
  {
    bjod localbjod = new bjod();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambjog, localbjod);
      return;
    }
    ((bjoa)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambjog, localbjod);
  }
  
  private static void b(Context paramContext, bjog parambjog, bjof parambjof)
  {
    bjpr.a(paramContext, new bjoe(paramContext, parambjog, parambjof));
  }
  
  static void c(Context paramContext, bjog parambjog)
  {
    if ((TextUtils.isEmpty(parambjog.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambjog.jdField_a_of_type_JavaLangString)))
    {
      parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambjog.jdField_a_of_type_JavaLangString);
      parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambjog.jdField_a_of_type_JavaLangString);
    }
    parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambjog.jdField_a_of_type_JavaLangString);
    parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azql.class.getName());
    Object localObject = parambjog.jdField_b_of_type_JavaLangString;
    localObject = new File(bjpz.a(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambjog.d, parambjog.jdField_b_of_type_JavaLangString, ((File)localObject).getCanonicalPath(), parambjog.e, parambjog.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void d(Context paramContext, bjog parambjog)
  {
    if ((TextUtils.isEmpty(parambjog.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambjog.jdField_a_of_type_JavaLangString)))
    {
      parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambjog.jdField_a_of_type_JavaLangString);
      parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambjog.jdField_a_of_type_JavaLangString);
    }
    parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambjog.jdField_a_of_type_JavaLangString);
    parambjog.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azql.class.getName());
    Object localObject = parambjog.jdField_b_of_type_JavaLangString;
    localObject = new File(bjpz.a(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (parambjog.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, parambjog.d, parambjog.jdField_b_of_type_JavaLangString, (String)localObject, parambjog.e, parambjog.jdField_a_of_type_AndroidContentIntent, parambjog.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, parambjog, (String)localObject), 5, null, false);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PluginDebug", 2, "doLaunchPluginService", paramContext);
      }
    }
  }
  
  public abstract PluginRecord a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, bjog parambjog, bjof parambjof);
  
  public abstract void a(bjoh parambjoh, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, bjok parambjok, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjoa
 * JD-Core Version:    0.7.0.1
 */