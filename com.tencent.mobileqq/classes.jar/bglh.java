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

public abstract class bglh
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<bglr> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static bglh a(QQAppInterface paramQQAppInterface)
  {
    return new bgmh(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, bglq parambglq)
  {
    a(paramContext, parambglq, null);
  }
  
  public static void a(Context paramContext, bglq parambglq, bgln parambgln)
  {
    Object localObject;
    if (parambglq.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambglq.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    parambgln = new bgli(parambgln);
    if (((paramContext instanceof Activity)) && (parambglq.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, parambglq.jdField_a_of_type_AndroidAppDialog, parambglq.jdField_d_of_type_JavaLangString, parambglq.jdField_b_of_type_JavaLangString, parambglq.jdField_b_of_type_Boolean, parambglq.jdField_c_of_type_Int).show();
    }
    if (parambglq.jdField_a_of_type_Aqyd != null) {
      if (TextUtils.equals(parambglq.jdField_a_of_type_Aqyd.jdField_a_of_type_JavaLangString, parambglq.jdField_b_of_type_JavaLangString))
      {
        parambglq.jdField_a_of_type_Aqyd.b();
        parambglq.jdField_a_of_type_Aqyd.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramContext, parambglq, parambgln);
      return;
      aqyc.a(parambglq.jdField_b_of_type_JavaLangString);
    }
    ((bglh)((QQAppInterface)localObject).getManager(27)).a(paramContext, parambglq, parambgln);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(ajya.a(2131705841))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), ajya.a(2131705843) + paramString2 + ajya.a(2131705842), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + ajya.a(2131705844), 0).show();
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
  
  public static void b(Context paramContext, bglq parambglq)
  {
    bgll localbgll = new bgll();
    parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambglq.jdField_a_of_type_Aqyd != null) {
      parambglq.jdField_a_of_type_Aqyd.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambglq, localbgll);
      return;
    }
    ((bglh)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambglq, localbgll);
  }
  
  public static void c(Context paramContext, bglq parambglq)
  {
    bglm localbglm = new bglm();
    parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambglq.jdField_a_of_type_Aqyd != null) {
      parambglq.jdField_a_of_type_Aqyd.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambglq, localbglm);
      return;
    }
    ((bglh)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambglq, localbglm);
  }
  
  private static void c(Context paramContext, bglq parambglq, bglo parambglo)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bglr(paramContext, parambglq, parambglo));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bglr(paramContext, parambglq, parambglo));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new bglj();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, parambglq, parambglo);
  }
  
  static void d(Context paramContext, bglq parambglq)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        a(parambglq.jdField_a_of_type_JavaUtilList);
        parambglq.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, parambglq.jdField_a_of_type_JavaLangClass);
        if (TextUtils.isEmpty(parambglq.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
        {
          parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambglq.jdField_a_of_type_JavaLangString);
          parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambglq.jdField_a_of_type_JavaLangString);
        }
        parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambglq.jdField_a_of_type_JavaLangString);
        parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqr.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        parambglq.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, parambglq.jdField_d_of_type_JavaLangString, parambglq.jdField_b_of_type_JavaLangString, parambglq.jdField_c_of_type_JavaLangString, parambglq.jdField_e_of_type_JavaLangString, parambglq.jdField_a_of_type_AndroidContentIntent, parambglq.jdField_b_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!parambglq.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130771997, 2130772001);
          return;
          PluginProxyActivity.openActivity(paramContext, parambglq.jdField_d_of_type_JavaLangString, parambglq.jdField_b_of_type_JavaLangString, parambglq.jdField_c_of_type_JavaLangString, parambglq.jdField_e_of_type_JavaLangString, parambglq.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((parambglq.jdField_a_of_type_AndroidAppDialog != null) && ((parambglq.jdField_a_of_type_AndroidAppDialog instanceof bcqv)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772097, 2130772097);
        return;
      }
    } while ((parambglq.jdField_d_of_type_Int <= 0) || (parambglq.jdField_e_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(parambglq.jdField_d_of_type_Int, parambglq.jdField_e_of_type_Int);
  }
  
  private static void d(Context paramContext, bglq parambglq, bglo parambglo)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      parambglo.a(false, paramContext, parambglq);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(parambglq.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (parambglo == null);
    parambglq.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    parambglq.a(localPluginBaseInfo);
    parambglo.a(true, paramContext, parambglq);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(parambglq.jdField_b_of_type_JavaLangString, new bglk(parambglo, parambglq, paramContext));
  }
  
  static void e(Context paramContext, bglq parambglq)
  {
    a(parambglq.jdField_a_of_type_JavaUtilList);
    parambglq.a();
    if ((TextUtils.isEmpty(parambglq.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambglq.jdField_a_of_type_JavaLangString)))
    {
      parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambglq.jdField_a_of_type_JavaLangString);
      parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambglq.jdField_a_of_type_JavaLangString);
    }
    parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambglq.jdField_a_of_type_JavaLangString);
    parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqr.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambglq.jdField_d_of_type_JavaLangString, parambglq.jdField_b_of_type_JavaLangString, parambglq.jdField_c_of_type_JavaLangString, parambglq.jdField_e_of_type_JavaLangString, parambglq.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, bglq parambglq)
  {
    a(parambglq.jdField_a_of_type_JavaUtilList);
    parambglq.a();
    if ((TextUtils.isEmpty(parambglq.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambglq.jdField_a_of_type_JavaLangString)))
    {
      parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambglq.jdField_a_of_type_JavaLangString);
      parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambglq.jdField_a_of_type_JavaLangString);
    }
    parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambglq.jdField_a_of_type_JavaLangString);
    parambglq.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", axqr.class.getName());
    if (parambglq.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, parambglq.jdField_d_of_type_JavaLangString, parambglq.jdField_b_of_type_JavaLangString, parambglq.jdField_c_of_type_JavaLangString, parambglq.jdField_e_of_type_JavaLangString, parambglq.jdField_a_of_type_AndroidContentIntent, parambglq.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, parambglq), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, bglq parambglq, bglo parambglo);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bglh
 * JD-Core Version:    0.7.0.1
 */