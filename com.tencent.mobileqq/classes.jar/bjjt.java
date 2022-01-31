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

public abstract class bjjt
  extends bjlw
{
  public static void a(Activity paramActivity, bjjz parambjjz)
  {
    if (parambjjz.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambjjz.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new bjju();
    if ((parambjjz.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, parambjjz.jdField_a_of_type_AndroidAppDialog, parambjjz.d, parambjjz.jdField_b_of_type_JavaLangString, parambjjz.jdField_a_of_type_Boolean, parambjjz.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, parambjjz, (bjjy)localObject);
      return;
    }
    ((bjjt)((QQAppInterface)localAppRuntime).getManager(175)).a(paramActivity, parambjjz, (bjjy)localObject);
  }
  
  public static void a(Context paramContext, bjjz parambjjz)
  {
    bjjv localbjjv = new bjjv();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambjjz, localbjjv);
      return;
    }
    ((bjjt)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambjjz, localbjjv);
  }
  
  static void b(Activity paramActivity, bjjz parambjjz)
  {
    if ((parambjjz == null) || (paramActivity == null) || (parambjjz.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      parambjjz.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, parambjjz.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(parambjjz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambjjz.jdField_a_of_type_JavaLangString);
        parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambjjz.jdField_a_of_type_JavaLangString);
      }
      parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambjjz.jdField_a_of_type_JavaLangString);
      parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azmc.class.getName());
      try
      {
        File localFile = new File(bjls.a(paramActivity), parambjjz.jdField_b_of_type_JavaLangString);
        PluginProxyActivity.openActivityForResult(paramActivity, parambjjz.d, parambjjz.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), parambjjz.e, parambjjz.jdField_a_of_type_AndroidContentIntent, parambjjz.jdField_b_of_type_Int);
        if ((parambjjz.jdField_a_of_type_AndroidAppDialog != null) && ((parambjjz.jdField_a_of_type_AndroidAppDialog instanceof beqe)) && (paramActivity != null))
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
  
  public static void b(Context paramContext, bjjz parambjjz)
  {
    bjjw localbjjw = new bjjw();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambjjz, localbjjw);
      return;
    }
    ((bjjt)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambjjz, localbjjw);
  }
  
  private static void b(Context paramContext, bjjz parambjjz, bjjy parambjjy)
  {
    bjlk.a(paramContext, new bjjx(paramContext, parambjjz, parambjjy));
  }
  
  static void c(Context paramContext, bjjz parambjjz)
  {
    if ((TextUtils.isEmpty(parambjjz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambjjz.jdField_a_of_type_JavaLangString)))
    {
      parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambjjz.jdField_a_of_type_JavaLangString);
      parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambjjz.jdField_a_of_type_JavaLangString);
    }
    parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambjjz.jdField_a_of_type_JavaLangString);
    parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azmc.class.getName());
    Object localObject = parambjjz.jdField_b_of_type_JavaLangString;
    localObject = new File(bjls.a(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambjjz.d, parambjjz.jdField_b_of_type_JavaLangString, ((File)localObject).getCanonicalPath(), parambjjz.e, parambjjz.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void d(Context paramContext, bjjz parambjjz)
  {
    if ((TextUtils.isEmpty(parambjjz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambjjz.jdField_a_of_type_JavaLangString)))
    {
      parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambjjz.jdField_a_of_type_JavaLangString);
      parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambjjz.jdField_a_of_type_JavaLangString);
    }
    parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambjjz.jdField_a_of_type_JavaLangString);
    parambjjz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azmc.class.getName());
    Object localObject = parambjjz.jdField_b_of_type_JavaLangString;
    localObject = new File(bjls.a(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (parambjjz.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, parambjjz.d, parambjjz.jdField_b_of_type_JavaLangString, (String)localObject, parambjjz.e, parambjjz.jdField_a_of_type_AndroidContentIntent, parambjjz.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, parambjjz, (String)localObject), 5, null, false);
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
  
  public abstract void a(Context paramContext, bjjz parambjjz, bjjy parambjjy);
  
  public abstract void a(bjka parambjka, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, bjkd parambjkd, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjjt
 * JD-Core Version:    0.7.0.1
 */