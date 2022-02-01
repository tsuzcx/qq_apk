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

public abstract class bkkq
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<bkla> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static bkkq a(QQAppInterface paramQQAppInterface)
  {
    return new bklq(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, bkkz parambkkz)
  {
    a(paramContext, parambkkz, null);
  }
  
  public static void a(Context paramContext, bkkz parambkkz, bkkw parambkkw)
  {
    Object localObject;
    if (parambkkz.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambkkz.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    parambkkw = new bkkr(parambkkw);
    if (((paramContext instanceof Activity)) && (parambkkz.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, parambkkz.jdField_a_of_type_AndroidAppDialog, parambkkz.jdField_d_of_type_JavaLangString, parambkkz.jdField_b_of_type_JavaLangString, parambkkz.jdField_b_of_type_Boolean, parambkkz.jdField_c_of_type_Int).show();
    }
    if (parambkkz.jdField_a_of_type_Aufm != null) {
      if (TextUtils.equals(parambkkz.jdField_a_of_type_Aufm.jdField_a_of_type_JavaLangString, parambkkz.jdField_b_of_type_JavaLangString))
      {
        parambkkz.jdField_a_of_type_Aufm.b();
        parambkkz.jdField_a_of_type_Aufm.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramContext, parambkkz, parambkkw);
      return;
      aufl.a(parambkkz.jdField_b_of_type_JavaLangString);
    }
    ((bkkq)((QQAppInterface)localObject).getManager(27)).a(paramContext, parambkkz, parambkkw);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(amtj.a(2131704963))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), amtj.a(2131704965) + paramString2 + amtj.a(2131704964), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + amtj.a(2131704966), 0).show();
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
  
  public static void b(Context paramContext, bkkz parambkkz)
  {
    bkku localbkku = new bkku();
    parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambkkz.jdField_a_of_type_Aufm != null) {
      parambkkz.jdField_a_of_type_Aufm.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambkkz, localbkku);
      return;
    }
    ((bkkq)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambkkz, localbkku);
  }
  
  public static void c(Context paramContext, bkkz parambkkz)
  {
    bkkv localbkkv = new bkkv();
    parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambkkz.jdField_a_of_type_Aufm != null) {
      parambkkz.jdField_a_of_type_Aufm.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambkkz, localbkkv);
      return;
    }
    ((bkkq)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambkkz, localbkkv);
  }
  
  private static void c(Context paramContext, bkkz parambkkz, bkkx parambkkx)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bkla(paramContext, parambkkz, parambkkx));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bkla(paramContext, parambkkz, parambkkx));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new bkks();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, parambkkz, parambkkx);
  }
  
  static void d(Context paramContext, bkkz parambkkz)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        a(parambkkz.jdField_a_of_type_JavaUtilList);
        parambkkz.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, parambkkz.jdField_a_of_type_JavaLangClass);
        if (TextUtils.isEmpty(parambkkz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
        {
          parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambkkz.jdField_a_of_type_JavaLangString);
          parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambkkz.jdField_a_of_type_JavaLangString);
        }
        parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambkkz.jdField_a_of_type_JavaLangString);
        parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcdy.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        parambkkz.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, parambkkz.jdField_d_of_type_JavaLangString, parambkkz.jdField_b_of_type_JavaLangString, parambkkz.jdField_c_of_type_JavaLangString, parambkkz.jdField_e_of_type_JavaLangString, parambkkz.jdField_a_of_type_AndroidContentIntent, parambkkz.jdField_b_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!parambkkz.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130771997, 2130772001);
          return;
          PluginProxyActivity.openActivity(paramContext, parambkkz.jdField_d_of_type_JavaLangString, parambkkz.jdField_b_of_type_JavaLangString, parambkkz.jdField_c_of_type_JavaLangString, parambkkz.jdField_e_of_type_JavaLangString, parambkkz.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((parambkkz.jdField_a_of_type_AndroidAppDialog != null) && ((parambkkz.jdField_a_of_type_AndroidAppDialog instanceof bhik)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772106, 2130772106);
        return;
      }
    } while ((parambkkz.jdField_d_of_type_Int <= 0) || (parambkkz.jdField_e_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(parambkkz.jdField_d_of_type_Int, parambkkz.jdField_e_of_type_Int);
  }
  
  private static void d(Context paramContext, bkkz parambkkz, bkkx parambkkx)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      parambkkx.a(false, paramContext, parambkkz);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(parambkkz.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (parambkkx == null);
    parambkkz.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    parambkkz.a(localPluginBaseInfo);
    parambkkx.a(true, paramContext, parambkkz);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(parambkkz.jdField_b_of_type_JavaLangString, new bkkt(parambkkx, parambkkz, paramContext));
  }
  
  static void e(Context paramContext, bkkz parambkkz)
  {
    a(parambkkz.jdField_a_of_type_JavaUtilList);
    parambkkz.a();
    if ((TextUtils.isEmpty(parambkkz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambkkz.jdField_a_of_type_JavaLangString)))
    {
      parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambkkz.jdField_a_of_type_JavaLangString);
      parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambkkz.jdField_a_of_type_JavaLangString);
    }
    parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambkkz.jdField_a_of_type_JavaLangString);
    parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcdy.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambkkz.jdField_d_of_type_JavaLangString, parambkkz.jdField_b_of_type_JavaLangString, parambkkz.jdField_c_of_type_JavaLangString, parambkkz.jdField_e_of_type_JavaLangString, parambkkz.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, bkkz parambkkz)
  {
    a(parambkkz.jdField_a_of_type_JavaUtilList);
    parambkkz.a();
    if ((TextUtils.isEmpty(parambkkz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambkkz.jdField_a_of_type_JavaLangString)))
    {
      parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambkkz.jdField_a_of_type_JavaLangString);
      parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambkkz.jdField_a_of_type_JavaLangString);
    }
    parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambkkz.jdField_a_of_type_JavaLangString);
    parambkkz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcdy.class.getName());
    if (parambkkz.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, parambkkz.jdField_d_of_type_JavaLangString, parambkkz.jdField_b_of_type_JavaLangString, parambkkz.jdField_c_of_type_JavaLangString, parambkkz.jdField_e_of_type_JavaLangString, parambkkz.jdField_a_of_type_AndroidContentIntent, parambkkz.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, parambkkz), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, bkkz parambkkz, bkkx parambkkx);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkq
 * JD-Core Version:    0.7.0.1
 */