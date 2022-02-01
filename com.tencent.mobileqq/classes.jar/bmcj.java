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

public abstract class bmcj
  extends bmem
{
  public static void a(Activity paramActivity, bmcp parambmcp)
  {
    if (parambmcp.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambmcp.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new bmck();
    if ((parambmcp.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, parambmcp.jdField_a_of_type_AndroidAppDialog, parambmcp.d, parambmcp.jdField_b_of_type_JavaLangString, parambmcp.jdField_a_of_type_Boolean, parambmcp.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, parambmcp, (bmco)localObject);
      return;
    }
    ((bmcj)((QQAppInterface)localAppRuntime).getManager(175)).a(paramActivity, parambmcp, (bmco)localObject);
  }
  
  public static void a(Context paramContext, bmcp parambmcp)
  {
    bmcl localbmcl = new bmcl();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambmcp, localbmcl);
      return;
    }
    ((bmcj)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambmcp, localbmcl);
  }
  
  static void b(Activity paramActivity, bmcp parambmcp)
  {
    if ((parambmcp == null) || (paramActivity == null) || (parambmcp.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      parambmcp.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, parambmcp.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(parambmcp.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambmcp.jdField_a_of_type_JavaLangString);
        parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambmcp.jdField_a_of_type_JavaLangString);
      }
      parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambmcp.jdField_a_of_type_JavaLangString);
      parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcsm.class.getName());
      try
      {
        File localFile = new File(bmei.a(paramActivity), parambmcp.jdField_b_of_type_JavaLangString);
        PluginProxyActivity.openActivityForResult(paramActivity, parambmcp.d, parambmcp.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), parambmcp.e, parambmcp.jdField_a_of_type_AndroidContentIntent, parambmcp.jdField_b_of_type_Int);
        if ((parambmcp.jdField_a_of_type_AndroidAppDialog != null) && ((parambmcp.jdField_a_of_type_AndroidAppDialog instanceof bibl)) && (paramActivity != null))
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
  
  public static void b(Context paramContext, bmcp parambmcp)
  {
    bmcm localbmcm = new bmcm();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, parambmcp, localbmcm);
      return;
    }
    ((bmcj)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, parambmcp, localbmcm);
  }
  
  private static void b(Context paramContext, bmcp parambmcp, bmco parambmco)
  {
    bmea.a(paramContext, new bmcn(paramContext, parambmcp, parambmco));
  }
  
  static void c(Context paramContext, bmcp parambmcp)
  {
    if ((TextUtils.isEmpty(parambmcp.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambmcp.jdField_a_of_type_JavaLangString)))
    {
      parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambmcp.jdField_a_of_type_JavaLangString);
      parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambmcp.jdField_a_of_type_JavaLangString);
    }
    parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambmcp.jdField_a_of_type_JavaLangString);
    parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcsm.class.getName());
    Object localObject = parambmcp.jdField_b_of_type_JavaLangString;
    localObject = new File(bmei.a(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambmcp.d, parambmcp.jdField_b_of_type_JavaLangString, ((File)localObject).getCanonicalPath(), parambmcp.e, parambmcp.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void d(Context paramContext, bmcp parambmcp)
  {
    if ((TextUtils.isEmpty(parambmcp.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambmcp.jdField_a_of_type_JavaLangString)))
    {
      parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambmcp.jdField_a_of_type_JavaLangString);
      parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambmcp.jdField_a_of_type_JavaLangString);
    }
    parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambmcp.jdField_a_of_type_JavaLangString);
    parambmcp.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcsm.class.getName());
    Object localObject = parambmcp.jdField_b_of_type_JavaLangString;
    localObject = new File(bmei.a(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (parambmcp.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, parambmcp.d, parambmcp.jdField_b_of_type_JavaLangString, (String)localObject, parambmcp.e, parambmcp.jdField_a_of_type_AndroidContentIntent, parambmcp.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, parambmcp, (String)localObject), 5, null, false);
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
  
  public abstract void a(Context paramContext, bmcp parambmcp, bmco parambmco);
  
  public abstract void a(bmcq parambmcq, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, bmct parambmct, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcj
 * JD-Core Version:    0.7.0.1
 */