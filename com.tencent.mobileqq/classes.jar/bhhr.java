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

public abstract class bhhr
  extends bhju
{
  public static void a(Activity paramActivity, bhhx parambhhx)
  {
    if (parambhhx.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambhhx.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new bhhs();
    if ((parambhhx.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, parambhhx.jdField_a_of_type_AndroidAppDialog, parambhhx.d, parambhhx.jdField_b_of_type_JavaLangString, parambhhx.jdField_a_of_type_Boolean, parambhhx.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, parambhhx, (bhhw)localObject);
      return;
    }
    ((bhhr)((QQAppInterface)localAppRuntime).getManager(175)).a(paramActivity, parambhhx, (bhhw)localObject);
  }
  
  public static void a(Context paramContext, bhhx parambhhx)
  {
    bhht localbhht = new bhht();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambhhx, localbhht);
      return;
    }
    ((bhhr)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambhhx, localbhht);
  }
  
  static void b(Activity paramActivity, bhhx parambhhx)
  {
    if ((parambhhx == null) || (paramActivity == null) || (parambhhx.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      parambhhx.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, parambhhx.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(parambhhx.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambhhx.jdField_a_of_type_JavaLangString);
        parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambhhx.jdField_a_of_type_JavaLangString);
      }
      parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambhhx.jdField_a_of_type_JavaLangString);
      parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqp.class.getName());
      try
      {
        File localFile = new File(bhjq.a(paramActivity), parambhhx.jdField_b_of_type_JavaLangString);
        PluginProxyActivity.openActivityForResult(paramActivity, parambhhx.d, parambhhx.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), parambhhx.e, parambhhx.jdField_a_of_type_AndroidContentIntent, parambhhx.jdField_b_of_type_Int);
        if ((parambhhx.jdField_a_of_type_AndroidAppDialog != null) && ((parambhhx.jdField_a_of_type_AndroidAppDialog instanceof bcqg)) && (paramActivity != null))
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
  
  public static void b(Context paramContext, bhhx parambhhx)
  {
    bhhu localbhhu = new bhhu();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambhhx, localbhhu);
      return;
    }
    ((bhhr)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambhhx, localbhhu);
  }
  
  private static void b(Context paramContext, bhhx parambhhx, bhhw parambhhw)
  {
    bhji.a(paramContext, new bhhv(paramContext, parambhhx, parambhhw));
  }
  
  static void c(Context paramContext, bhhx parambhhx)
  {
    if ((TextUtils.isEmpty(parambhhx.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambhhx.jdField_a_of_type_JavaLangString)))
    {
      parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambhhx.jdField_a_of_type_JavaLangString);
      parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambhhx.jdField_a_of_type_JavaLangString);
    }
    parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambhhx.jdField_a_of_type_JavaLangString);
    parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqp.class.getName());
    Object localObject = parambhhx.jdField_b_of_type_JavaLangString;
    localObject = new File(bhjq.a(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambhhx.d, parambhhx.jdField_b_of_type_JavaLangString, ((File)localObject).getCanonicalPath(), parambhhx.e, parambhhx.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void d(Context paramContext, bhhx parambhhx)
  {
    if ((TextUtils.isEmpty(parambhhx.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambhhx.jdField_a_of_type_JavaLangString)))
    {
      parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambhhx.jdField_a_of_type_JavaLangString);
      parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambhhx.jdField_a_of_type_JavaLangString);
    }
    parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambhhx.jdField_a_of_type_JavaLangString);
    parambhhx.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqp.class.getName());
    Object localObject = parambhhx.jdField_b_of_type_JavaLangString;
    localObject = new File(bhjq.a(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (parambhhx.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, parambhhx.d, parambhhx.jdField_b_of_type_JavaLangString, (String)localObject, parambhhx.e, parambhhx.jdField_a_of_type_AndroidContentIntent, parambhhx.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, parambhhx, (String)localObject), 5, null, false);
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
  
  public abstract void a(Context paramContext, bhhx parambhhx, bhhw parambhhw);
  
  public abstract void a(bhhy parambhhy, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, bhib parambhib, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhhr
 * JD-Core Version:    0.7.0.1
 */