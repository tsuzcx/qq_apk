import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public abstract class blvy
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<blwi> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static blvy a(QQAppInterface paramQQAppInterface)
  {
    return new blwy(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, blwh paramblwh)
  {
    a(paramContext, paramblwh, null);
  }
  
  public static void a(Context paramContext, blwh paramblwh, blwe paramblwe)
  {
    Object localObject;
    if (paramblwh.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramblwh.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    paramblwe = new blvz(paramblwe);
    if (((paramContext instanceof Activity)) && (paramblwh.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, paramblwh.jdField_a_of_type_AndroidAppDialog, paramblwh.jdField_d_of_type_JavaLangString, paramblwh.jdField_b_of_type_JavaLangString, paramblwh.jdField_b_of_type_Boolean, paramblwh.jdField_c_of_type_Int).show();
    }
    if (paramblwh.jdField_a_of_type_Avlg != null) {
      if (TextUtils.equals(paramblwh.jdField_a_of_type_Avlg.jdField_a_of_type_JavaLangString, paramblwh.jdField_b_of_type_JavaLangString))
      {
        paramblwh.jdField_a_of_type_Avlg.b();
        paramblwh.jdField_a_of_type_Avlg.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramContext, paramblwh, paramblwe);
      return;
      avlf.a(paramblwh.jdField_b_of_type_JavaLangString);
    }
    ((blvy)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN)).a(paramContext, paramblwh, paramblwe);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(anvx.a(2131705314))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), anvx.a(2131705316) + paramString2 + anvx.a(2131705315), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + anvx.a(2131705317), 0).show();
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
  
  public static void b(Context paramContext, blwh paramblwh)
  {
    blwc localblwc = new blwc();
    paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramblwh.jdField_a_of_type_Avlg != null) {
      paramblwh.jdField_a_of_type_Avlg.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramblwh, localblwc);
      return;
    }
    ((blvy)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MGR_PLUGIN)).a(paramContext, paramblwh, localblwc);
  }
  
  public static void c(Context paramContext, blwh paramblwh)
  {
    blwd localblwd = new blwd();
    paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramblwh.jdField_a_of_type_Avlg != null) {
      paramblwh.jdField_a_of_type_Avlg.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramblwh, localblwd);
      return;
    }
    ((blvy)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MGR_PLUGIN)).a(paramContext, paramblwh, localblwd);
  }
  
  private static void c(Context paramContext, blwh paramblwh, blwf paramblwf)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new blwi(paramContext, paramblwh, paramblwf));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new blwi(paramContext, paramblwh, paramblwf));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new blwa();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, paramblwh, paramblwf);
  }
  
  static void d(Context paramContext, blwh paramblwh)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        a(paramblwh.jdField_a_of_type_JavaUtilList);
        paramblwh.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, paramblwh.jdField_a_of_type_JavaLangClass);
        if (TextUtils.isEmpty(paramblwh.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
        {
          paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramblwh.jdField_a_of_type_JavaLangString);
          paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramblwh.jdField_a_of_type_JavaLangString);
        }
        paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramblwh.jdField_a_of_type_JavaLangString);
        paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdkt.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        paramblwh.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, paramblwh.jdField_d_of_type_JavaLangString, paramblwh.jdField_b_of_type_JavaLangString, paramblwh.jdField_c_of_type_JavaLangString, paramblwh.jdField_e_of_type_JavaLangString, paramblwh.jdField_a_of_type_AndroidContentIntent, paramblwh.jdField_b_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!paramblwh.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130771997, 2130772001);
          return;
          PluginProxyActivity.openActivity(paramContext, paramblwh.jdField_d_of_type_JavaLangString, paramblwh.jdField_b_of_type_JavaLangString, paramblwh.jdField_c_of_type_JavaLangString, paramblwh.jdField_e_of_type_JavaLangString, paramblwh.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((paramblwh.jdField_a_of_type_AndroidAppDialog != null) && ((paramblwh.jdField_a_of_type_AndroidAppDialog instanceof bitc)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772106, 2130772106);
        return;
      }
    } while ((paramblwh.jdField_d_of_type_Int <= 0) || (paramblwh.jdField_e_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(paramblwh.jdField_d_of_type_Int, paramblwh.jdField_e_of_type_Int);
  }
  
  private static void d(Context paramContext, blwh paramblwh, blwf paramblwf)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      paramblwf.a(false, paramContext, paramblwh);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(paramblwh.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (paramblwf == null);
    paramblwh.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    paramblwh.a(localPluginBaseInfo);
    paramblwf.a(true, paramContext, paramblwh);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(paramblwh.jdField_b_of_type_JavaLangString, new blwb(paramblwf, paramblwh, paramContext));
  }
  
  static void e(Context paramContext, blwh paramblwh)
  {
    a(paramblwh.jdField_a_of_type_JavaUtilList);
    paramblwh.a();
    if ((TextUtils.isEmpty(paramblwh.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramblwh.jdField_a_of_type_JavaLangString)))
    {
      paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramblwh.jdField_a_of_type_JavaLangString);
      paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramblwh.jdField_a_of_type_JavaLangString);
    }
    paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramblwh.jdField_a_of_type_JavaLangString);
    paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdkt.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramblwh.jdField_d_of_type_JavaLangString, paramblwh.jdField_b_of_type_JavaLangString, paramblwh.jdField_c_of_type_JavaLangString, paramblwh.jdField_e_of_type_JavaLangString, paramblwh.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, blwh paramblwh)
  {
    a(paramblwh.jdField_a_of_type_JavaUtilList);
    paramblwh.a();
    if ((TextUtils.isEmpty(paramblwh.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramblwh.jdField_a_of_type_JavaLangString)))
    {
      paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramblwh.jdField_a_of_type_JavaLangString);
      paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramblwh.jdField_a_of_type_JavaLangString);
    }
    paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramblwh.jdField_a_of_type_JavaLangString);
    paramblwh.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bdkt.class.getName());
    if (paramblwh.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, paramblwh.jdField_d_of_type_JavaLangString, paramblwh.jdField_b_of_type_JavaLangString, paramblwh.jdField_c_of_type_JavaLangString, paramblwh.jdField_e_of_type_JavaLangString, paramblwh.jdField_a_of_type_AndroidContentIntent, paramblwh.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, paramblwh), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, blwh paramblwh, blwf paramblwf);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvy
 * JD-Core Version:    0.7.0.1
 */