import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager.6;
import cooperation.plugin.PluginInfo;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public abstract class bmgk
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<bmgu> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static bmgk a(QQAppInterface paramQQAppInterface)
  {
    return new bmhk(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, bmgt parambmgt)
  {
    a(paramContext, parambmgt, null);
  }
  
  public static void a(Context paramContext, bmgt parambmgt, bmgq parambmgq)
  {
    Object localObject;
    if (parambmgt.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambmgt.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    parambmgq = new bmgl(parambmgq);
    if (((paramContext instanceof Activity)) && (parambmgt.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, parambmgt.jdField_a_of_type_AndroidAppDialog, parambmgt.jdField_d_of_type_JavaLangString, parambmgt.jdField_b_of_type_JavaLangString, parambmgt.jdField_b_of_type_Boolean, parambmgt.jdField_c_of_type_Int).show();
    }
    if (parambmgt.jdField_a_of_type_Avsk != null) {
      if (TextUtils.equals(parambmgt.jdField_a_of_type_Avsk.jdField_a_of_type_JavaLangString, parambmgt.jdField_b_of_type_JavaLangString))
      {
        parambmgt.jdField_a_of_type_Avsk.b();
        parambmgt.jdField_a_of_type_Avsk.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramContext, parambmgt, parambmgq);
      return;
      avsj.a(parambmgt.jdField_b_of_type_JavaLangString);
    }
    ((bmgk)((QQAppInterface)localObject).getManager(27)).a(paramContext, parambmgt, parambmgq);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(anzj.a(2131704733))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), anzj.a(2131704735) + paramString2 + anzj.a(2131704734), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + anzj.a(2131704736), 0).show();
  }
  
  static void a(List<RemoteCommand> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        RemoteCommand localRemoteCommand = (RemoteCommand)paramList.get(i);
        if ((localRemoteCommand != null) && (!localPluginCommunicationHandler.containsCmd(localRemoteCommand.getCmd()))) {
          localPluginCommunicationHandler.register((RemoteCommand)paramList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public static void b(Context paramContext, bmgt parambmgt)
  {
    bmgo localbmgo = new bmgo();
    parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambmgt.jdField_a_of_type_Avsk != null) {
      parambmgt.jdField_a_of_type_Avsk.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambmgt, localbmgo);
      return;
    }
    ((bmgk)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambmgt, localbmgo);
  }
  
  public static void c(Context paramContext, bmgt parambmgt)
  {
    bmgp localbmgp = new bmgp();
    parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambmgt.jdField_a_of_type_Avsk != null) {
      parambmgt.jdField_a_of_type_Avsk.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambmgt, localbmgp);
      return;
    }
    ((bmgk)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambmgt, localbmgp);
  }
  
  private static void c(Context paramContext, bmgt parambmgt, bmgr parambmgr)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bmgu(paramContext, parambmgt, parambmgr));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bmgu(paramContext, parambmgt, parambmgr));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new bmgm();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, parambmgt, parambmgr);
  }
  
  static void d(Context paramContext, bmgt parambmgt)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        a(parambmgt.jdField_a_of_type_JavaUtilList);
        parambmgt.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, parambmgt.jdField_a_of_type_JavaLangClass);
        if (TextUtils.isEmpty(parambmgt.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
        {
          parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambmgt.jdField_a_of_type_JavaLangString);
          parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambmgt.jdField_a_of_type_JavaLangString);
        }
        parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambmgt.jdField_a_of_type_JavaLangString);
        parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdle.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        parambmgt.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, parambmgt.jdField_d_of_type_JavaLangString, parambmgt.jdField_b_of_type_JavaLangString, parambmgt.jdField_c_of_type_JavaLangString, parambmgt.jdField_e_of_type_JavaLangString, parambmgt.jdField_a_of_type_AndroidContentIntent, parambmgt.jdField_b_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!parambmgt.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130771997, 2130772001);
          return;
          PluginProxyActivity.openActivity(paramContext, parambmgt.jdField_d_of_type_JavaLangString, parambmgt.jdField_b_of_type_JavaLangString, parambmgt.jdField_c_of_type_JavaLangString, parambmgt.jdField_e_of_type_JavaLangString, parambmgt.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((parambmgt.jdField_a_of_type_AndroidAppDialog != null) && ((parambmgt.jdField_a_of_type_AndroidAppDialog instanceof bjcj)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772100, 2130772100);
        return;
      }
    } while ((parambmgt.jdField_d_of_type_Int <= 0) || (parambmgt.jdField_e_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(parambmgt.jdField_d_of_type_Int, parambmgt.jdField_e_of_type_Int);
  }
  
  private static void d(Context paramContext, bmgt parambmgt, bmgr parambmgr)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      parambmgr.a(false, paramContext, parambmgt);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(parambmgt.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (parambmgr == null);
    parambmgt.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    parambmgt.a(localPluginBaseInfo);
    parambmgr.a(true, paramContext, parambmgt);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(parambmgt.jdField_b_of_type_JavaLangString, new bmgn(parambmgr, parambmgt, paramContext));
  }
  
  static void e(Context paramContext, bmgt parambmgt)
  {
    a(parambmgt.jdField_a_of_type_JavaUtilList);
    parambmgt.a();
    if ((TextUtils.isEmpty(parambmgt.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambmgt.jdField_a_of_type_JavaLangString)))
    {
      parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambmgt.jdField_a_of_type_JavaLangString);
      parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambmgt.jdField_a_of_type_JavaLangString);
    }
    parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambmgt.jdField_a_of_type_JavaLangString);
    parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdle.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambmgt.jdField_d_of_type_JavaLangString, parambmgt.jdField_b_of_type_JavaLangString, parambmgt.jdField_c_of_type_JavaLangString, parambmgt.jdField_e_of_type_JavaLangString, parambmgt.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, bmgt parambmgt)
  {
    a(parambmgt.jdField_a_of_type_JavaUtilList);
    parambmgt.a();
    if ((TextUtils.isEmpty(parambmgt.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambmgt.jdField_a_of_type_JavaLangString)))
    {
      parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambmgt.jdField_a_of_type_JavaLangString);
      parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambmgt.jdField_a_of_type_JavaLangString);
    }
    parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambmgt.jdField_a_of_type_JavaLangString);
    parambmgt.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdle.class.getName());
    if (parambmgt.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, parambmgt.jdField_d_of_type_JavaLangString, parambmgt.jdField_b_of_type_JavaLangString, parambmgt.jdField_c_of_type_JavaLangString, parambmgt.jdField_e_of_type_JavaLangString, parambmgt.jdField_a_of_type_AndroidContentIntent, parambmgt.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, parambmgt), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, bmgt parambmgt, bmgr parambmgr);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgk
 * JD-Core Version:    0.7.0.1
 */