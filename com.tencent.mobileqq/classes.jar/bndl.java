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

public abstract class bndl
  extends bnfo
{
  public static void a(Activity paramActivity, bndr parambndr)
  {
    if (parambndr.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambndr.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new bndm();
    if ((parambndr.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, parambndr.jdField_a_of_type_AndroidAppDialog, parambndr.d, parambndr.jdField_b_of_type_JavaLangString, parambndr.jdField_a_of_type_Boolean, parambndr.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, parambndr, (bndq)localObject);
      return;
    }
    ((bndl)((QQAppInterface)localAppRuntime).getManager(175)).a(paramActivity, parambndr, (bndq)localObject);
  }
  
  public static void a(Context paramContext, bndr parambndr)
  {
    bndn localbndn = new bndn();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambndr, localbndn);
      return;
    }
    ((bndl)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambndr, localbndn);
  }
  
  static void b(Activity paramActivity, bndr parambndr)
  {
    if ((parambndr == null) || (paramActivity == null) || (parambndr.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      parambndr.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, parambndr.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(parambndr.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambndr.jdField_a_of_type_JavaLangString);
        parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambndr.jdField_a_of_type_JavaLangString);
      }
      parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambndr.jdField_a_of_type_JavaLangString);
      parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdle.class.getName());
      try
      {
        File localFile = new File(bnfk.a(paramActivity), parambndr.jdField_b_of_type_JavaLangString);
        PluginProxyActivity.openActivityForResult(paramActivity, parambndr.d, parambndr.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), parambndr.e, parambndr.jdField_a_of_type_AndroidContentIntent, parambndr.jdField_b_of_type_Int);
        if ((parambndr.jdField_a_of_type_AndroidAppDialog != null) && ((parambndr.jdField_a_of_type_AndroidAppDialog instanceof bjcj)) && (paramActivity != null))
        {
          paramActivity.overridePendingTransition(2130772100, 2130772100);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("feilongzou", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  public static void b(Context paramContext, bndr parambndr)
  {
    bndo localbndo = new bndo();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambndr, localbndo);
      return;
    }
    ((bndl)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambndr, localbndo);
  }
  
  private static void b(Context paramContext, bndr parambndr, bndq parambndq)
  {
    bnfc.a(paramContext, new bndp(paramContext, parambndr, parambndq));
  }
  
  static void c(Context paramContext, bndr parambndr)
  {
    if ((TextUtils.isEmpty(parambndr.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambndr.jdField_a_of_type_JavaLangString)))
    {
      parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambndr.jdField_a_of_type_JavaLangString);
      parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambndr.jdField_a_of_type_JavaLangString);
    }
    parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambndr.jdField_a_of_type_JavaLangString);
    parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdle.class.getName());
    Object localObject = parambndr.jdField_b_of_type_JavaLangString;
    localObject = new File(bnfk.a(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambndr.d, parambndr.jdField_b_of_type_JavaLangString, ((File)localObject).getCanonicalPath(), parambndr.e, parambndr.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void d(Context paramContext, bndr parambndr)
  {
    if ((TextUtils.isEmpty(parambndr.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambndr.jdField_a_of_type_JavaLangString)))
    {
      parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambndr.jdField_a_of_type_JavaLangString);
      parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambndr.jdField_a_of_type_JavaLangString);
    }
    parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambndr.jdField_a_of_type_JavaLangString);
    parambndr.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdle.class.getName());
    Object localObject = parambndr.jdField_b_of_type_JavaLangString;
    localObject = new File(bnfk.a(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (parambndr.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, parambndr.d, parambndr.jdField_b_of_type_JavaLangString, (String)localObject, parambndr.e, parambndr.jdField_a_of_type_AndroidContentIntent, parambndr.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, parambndr, (String)localObject), 5, null, false);
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
  
  public abstract void a(Context paramContext, bndr parambndr, bndq parambndq);
  
  public abstract void a(bnds parambnds, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, bndv parambndv, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndl
 * JD-Core Version:    0.7.0.1
 */