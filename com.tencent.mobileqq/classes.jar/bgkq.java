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

public abstract class bgkq
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<bgla> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static bgkq a(QQAppInterface paramQQAppInterface)
  {
    return new bglq(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, bgkz parambgkz)
  {
    a(paramContext, parambgkz, null);
  }
  
  public static void a(Context paramContext, bgkz parambgkz, bgkw parambgkw)
  {
    Object localObject;
    if (parambgkz.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambgkz.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    parambgkw = new bgkr(parambgkw);
    if (((paramContext instanceof Activity)) && (parambgkz.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, parambgkz.jdField_a_of_type_AndroidAppDialog, parambgkz.jdField_d_of_type_JavaLangString, parambgkz.jdField_b_of_type_JavaLangString, parambgkz.jdField_b_of_type_Boolean, parambgkz.jdField_c_of_type_Int).show();
    }
    if (parambgkz.jdField_a_of_type_Aqyb != null) {
      if (TextUtils.equals(parambgkz.jdField_a_of_type_Aqyb.jdField_a_of_type_JavaLangString, parambgkz.jdField_b_of_type_JavaLangString))
      {
        parambgkz.jdField_a_of_type_Aqyb.b();
        parambgkz.jdField_a_of_type_Aqyb.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramContext, parambgkz, parambgkw);
      return;
      aqya.a(parambgkz.jdField_b_of_type_JavaLangString);
    }
    ((bgkq)((QQAppInterface)localObject).getManager(27)).a(paramContext, parambgkz, parambgkw);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(ajyc.a(2131705830))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), ajyc.a(2131705832) + paramString2 + ajyc.a(2131705831), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + ajyc.a(2131705833), 0).show();
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
  
  public static void b(Context paramContext, bgkz parambgkz)
  {
    bgku localbgku = new bgku();
    parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambgkz.jdField_a_of_type_Aqyb != null) {
      parambgkz.jdField_a_of_type_Aqyb.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambgkz, localbgku);
      return;
    }
    ((bgkq)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambgkz, localbgku);
  }
  
  public static void c(Context paramContext, bgkz parambgkz)
  {
    bgkv localbgkv = new bgkv();
    parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambgkz.jdField_a_of_type_Aqyb != null) {
      parambgkz.jdField_a_of_type_Aqyb.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambgkz, localbgkv);
      return;
    }
    ((bgkq)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambgkz, localbgkv);
  }
  
  private static void c(Context paramContext, bgkz parambgkz, bgkx parambgkx)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bgla(paramContext, parambgkz, parambgkx));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bgla(paramContext, parambgkz, parambgkx));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new bgks();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, parambgkz, parambgkx);
  }
  
  static void d(Context paramContext, bgkz parambgkz)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        a(parambgkz.jdField_a_of_type_JavaUtilList);
        parambgkz.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, parambgkz.jdField_a_of_type_JavaLangClass);
        if (TextUtils.isEmpty(parambgkz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
        {
          parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambgkz.jdField_a_of_type_JavaLangString);
          parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambgkz.jdField_a_of_type_JavaLangString);
        }
        parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambgkz.jdField_a_of_type_JavaLangString);
        parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqp.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        parambgkz.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, parambgkz.jdField_d_of_type_JavaLangString, parambgkz.jdField_b_of_type_JavaLangString, parambgkz.jdField_c_of_type_JavaLangString, parambgkz.jdField_e_of_type_JavaLangString, parambgkz.jdField_a_of_type_AndroidContentIntent, parambgkz.jdField_b_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!parambgkz.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130771997, 2130772001);
          return;
          PluginProxyActivity.openActivity(paramContext, parambgkz.jdField_d_of_type_JavaLangString, parambgkz.jdField_b_of_type_JavaLangString, parambgkz.jdField_c_of_type_JavaLangString, parambgkz.jdField_e_of_type_JavaLangString, parambgkz.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((parambgkz.jdField_a_of_type_AndroidAppDialog != null) && ((parambgkz.jdField_a_of_type_AndroidAppDialog instanceof bcqg)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772097, 2130772097);
        return;
      }
    } while ((parambgkz.jdField_d_of_type_Int <= 0) || (parambgkz.jdField_e_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(parambgkz.jdField_d_of_type_Int, parambgkz.jdField_e_of_type_Int);
  }
  
  private static void d(Context paramContext, bgkz parambgkz, bgkx parambgkx)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      parambgkx.a(false, paramContext, parambgkz);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(parambgkz.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (parambgkx == null);
    parambgkz.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    parambgkz.a(localPluginBaseInfo);
    parambgkx.a(true, paramContext, parambgkz);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(parambgkz.jdField_b_of_type_JavaLangString, new bgkt(parambgkx, parambgkz, paramContext));
  }
  
  static void e(Context paramContext, bgkz parambgkz)
  {
    a(parambgkz.jdField_a_of_type_JavaUtilList);
    parambgkz.a();
    if ((TextUtils.isEmpty(parambgkz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambgkz.jdField_a_of_type_JavaLangString)))
    {
      parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambgkz.jdField_a_of_type_JavaLangString);
      parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambgkz.jdField_a_of_type_JavaLangString);
    }
    parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambgkz.jdField_a_of_type_JavaLangString);
    parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqp.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambgkz.jdField_d_of_type_JavaLangString, parambgkz.jdField_b_of_type_JavaLangString, parambgkz.jdField_c_of_type_JavaLangString, parambgkz.jdField_e_of_type_JavaLangString, parambgkz.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, bgkz parambgkz)
  {
    a(parambgkz.jdField_a_of_type_JavaUtilList);
    parambgkz.a();
    if ((TextUtils.isEmpty(parambgkz.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambgkz.jdField_a_of_type_JavaLangString)))
    {
      parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambgkz.jdField_a_of_type_JavaLangString);
      parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambgkz.jdField_a_of_type_JavaLangString);
    }
    parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambgkz.jdField_a_of_type_JavaLangString);
    parambgkz.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqp.class.getName());
    if (parambgkz.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, parambgkz.jdField_d_of_type_JavaLangString, parambgkz.jdField_b_of_type_JavaLangString, parambgkz.jdField_c_of_type_JavaLangString, parambgkz.jdField_e_of_type_JavaLangString, parambgkz.jdField_a_of_type_AndroidContentIntent, parambgkz.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, parambgkz), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, bgkz parambgkz, bgkx parambgkx);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkq
 * JD-Core Version:    0.7.0.1
 */