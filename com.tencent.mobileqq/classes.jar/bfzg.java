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

public abstract class bfzg
  extends bgbj
{
  public static void a(Activity paramActivity, bfzm parambfzm)
  {
    if (parambfzm.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambfzm.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new bfzh();
    if ((parambfzm.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, parambfzm.jdField_a_of_type_AndroidAppDialog, parambfzm.d, parambfzm.jdField_b_of_type_JavaLangString, parambfzm.jdField_a_of_type_Boolean, parambfzm.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, parambfzm, (bfzl)localObject);
      return;
    }
    ((bfzg)((QQAppInterface)localAppRuntime).getManager(175)).a(paramActivity, parambfzm, (bfzl)localObject);
  }
  
  public static void a(Context paramContext, bfzm parambfzm)
  {
    bfzi localbfzi = new bfzi();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambfzm, localbfzi);
      return;
    }
    ((bfzg)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambfzm, localbfzi);
  }
  
  static void b(Activity paramActivity, bfzm parambfzm)
  {
    if ((parambfzm == null) || (paramActivity == null) || (parambfzm.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      parambfzm.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, parambfzm.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(parambfzm.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambfzm.jdField_a_of_type_JavaLangString);
        parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambfzm.jdField_a_of_type_JavaLangString);
      }
      parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambfzm.jdField_a_of_type_JavaLangString);
      parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", awqq.class.getName());
      try
      {
        File localFile = new File(bgbf.a(paramActivity), parambfzm.jdField_b_of_type_JavaLangString);
        PluginProxyActivity.openActivityForResult(paramActivity, parambfzm.d, parambfzm.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), parambfzm.e, parambfzm.jdField_a_of_type_AndroidContentIntent, parambfzm.jdField_b_of_type_Int);
        if ((parambfzm.jdField_a_of_type_AndroidAppDialog != null) && ((parambfzm.jdField_a_of_type_AndroidAppDialog instanceof bbni)) && (paramActivity != null))
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
  
  public static void b(Context paramContext, bfzm parambfzm)
  {
    bfzj localbfzj = new bfzj();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambfzm, localbfzj);
      return;
    }
    ((bfzg)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambfzm, localbfzj);
  }
  
  private static void b(Context paramContext, bfzm parambfzm, bfzl parambfzl)
  {
    bgax.a(paramContext, new bfzk(paramContext, parambfzm, parambfzl));
  }
  
  static void c(Context paramContext, bfzm parambfzm)
  {
    if ((TextUtils.isEmpty(parambfzm.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambfzm.jdField_a_of_type_JavaLangString)))
    {
      parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambfzm.jdField_a_of_type_JavaLangString);
      parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambfzm.jdField_a_of_type_JavaLangString);
    }
    parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambfzm.jdField_a_of_type_JavaLangString);
    parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", awqq.class.getName());
    Object localObject = parambfzm.jdField_b_of_type_JavaLangString;
    localObject = new File(bgbf.a(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambfzm.d, parambfzm.jdField_b_of_type_JavaLangString, ((File)localObject).getCanonicalPath(), parambfzm.e, parambfzm.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void d(Context paramContext, bfzm parambfzm)
  {
    if ((TextUtils.isEmpty(parambfzm.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambfzm.jdField_a_of_type_JavaLangString)))
    {
      parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambfzm.jdField_a_of_type_JavaLangString);
      parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambfzm.jdField_a_of_type_JavaLangString);
    }
    parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambfzm.jdField_a_of_type_JavaLangString);
    parambfzm.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", awqq.class.getName());
    Object localObject = parambfzm.jdField_b_of_type_JavaLangString;
    localObject = new File(bgbf.a(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (parambfzm.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, parambfzm.d, parambfzm.jdField_b_of_type_JavaLangString, (String)localObject, parambfzm.e, parambfzm.jdField_a_of_type_AndroidContentIntent, parambfzm.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, parambfzm, (String)localObject), 5, null, false);
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
  
  public abstract void a(Context paramContext, bfzm parambfzm, bfzl parambfzl);
  
  public abstract void a(bfzn parambfzn, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, bfzq parambfzq, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfzg
 * JD-Core Version:    0.7.0.1
 */