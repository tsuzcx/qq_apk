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

public abstract class bhii
  extends bhkl
{
  public static void a(Activity paramActivity, bhio parambhio)
  {
    if (parambhio.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambhio.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new bhij();
    if ((parambhio.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, parambhio.jdField_a_of_type_AndroidAppDialog, parambhio.d, parambhio.jdField_b_of_type_JavaLangString, parambhio.jdField_a_of_type_Boolean, parambhio.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, parambhio, (bhin)localObject);
      return;
    }
    ((bhii)((QQAppInterface)localAppRuntime).getManager(175)).a(paramActivity, parambhio, (bhin)localObject);
  }
  
  public static void a(Context paramContext, bhio parambhio)
  {
    bhik localbhik = new bhik();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambhio, localbhik);
      return;
    }
    ((bhii)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambhio, localbhik);
  }
  
  static void b(Activity paramActivity, bhio parambhio)
  {
    if ((parambhio == null) || (paramActivity == null) || (parambhio.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      parambhio.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, parambhio.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(parambhio.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambhio.jdField_a_of_type_JavaLangString);
        parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambhio.jdField_a_of_type_JavaLangString);
      }
      parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambhio.jdField_a_of_type_JavaLangString);
      parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqr.class.getName());
      try
      {
        File localFile = new File(bhkh.a(paramActivity), parambhio.jdField_b_of_type_JavaLangString);
        PluginProxyActivity.openActivityForResult(paramActivity, parambhio.d, parambhio.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), parambhio.e, parambhio.jdField_a_of_type_AndroidContentIntent, parambhio.jdField_b_of_type_Int);
        if ((parambhio.jdField_a_of_type_AndroidAppDialog != null) && ((parambhio.jdField_a_of_type_AndroidAppDialog instanceof bcqv)) && (paramActivity != null))
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
  
  public static void b(Context paramContext, bhio parambhio)
  {
    bhil localbhil = new bhil();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambhio, localbhil);
      return;
    }
    ((bhii)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambhio, localbhil);
  }
  
  private static void b(Context paramContext, bhio parambhio, bhin parambhin)
  {
    bhjz.a(paramContext, new bhim(paramContext, parambhio, parambhin));
  }
  
  static void c(Context paramContext, bhio parambhio)
  {
    if ((TextUtils.isEmpty(parambhio.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambhio.jdField_a_of_type_JavaLangString)))
    {
      parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambhio.jdField_a_of_type_JavaLangString);
      parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambhio.jdField_a_of_type_JavaLangString);
    }
    parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambhio.jdField_a_of_type_JavaLangString);
    parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqr.class.getName());
    Object localObject = parambhio.jdField_b_of_type_JavaLangString;
    localObject = new File(bhkh.a(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambhio.d, parambhio.jdField_b_of_type_JavaLangString, ((File)localObject).getCanonicalPath(), parambhio.e, parambhio.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void d(Context paramContext, bhio parambhio)
  {
    if ((TextUtils.isEmpty(parambhio.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambhio.jdField_a_of_type_JavaLangString)))
    {
      parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambhio.jdField_a_of_type_JavaLangString);
      parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambhio.jdField_a_of_type_JavaLangString);
    }
    parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambhio.jdField_a_of_type_JavaLangString);
    parambhio.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqr.class.getName());
    Object localObject = parambhio.jdField_b_of_type_JavaLangString;
    localObject = new File(bhkh.a(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (parambhio.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, parambhio.d, parambhio.jdField_b_of_type_JavaLangString, (String)localObject, parambhio.e, parambhio.jdField_a_of_type_AndroidContentIntent, parambhio.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, parambhio, (String)localObject), 5, null, false);
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
  
  public abstract void a(Context paramContext, bhio parambhio, bhin parambhin);
  
  public abstract void a(bhip parambhip, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, bhis parambhis, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhii
 * JD-Core Version:    0.7.0.1
 */