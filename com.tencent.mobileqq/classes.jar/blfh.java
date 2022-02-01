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

public abstract class blfh
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<blfr> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static blfh a(QQAppInterface paramQQAppInterface)
  {
    return new blgh(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, blfq paramblfq)
  {
    a(paramContext, paramblfq, null);
  }
  
  public static void a(Context paramContext, blfq paramblfq, blfn paramblfn)
  {
    Object localObject;
    if (paramblfq.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramblfq.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    paramblfn = new blfi(paramblfn);
    if (((paramContext instanceof Activity)) && (paramblfq.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, paramblfq.jdField_a_of_type_AndroidAppDialog, paramblfq.jdField_d_of_type_JavaLangString, paramblfq.jdField_b_of_type_JavaLangString, paramblfq.jdField_b_of_type_Boolean, paramblfq.jdField_c_of_type_Int).show();
    }
    if (paramblfq.jdField_a_of_type_Avaj != null) {
      if (TextUtils.equals(paramblfq.jdField_a_of_type_Avaj.jdField_a_of_type_JavaLangString, paramblfq.jdField_b_of_type_JavaLangString))
      {
        paramblfq.jdField_a_of_type_Avaj.b();
        paramblfq.jdField_a_of_type_Avaj.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramContext, paramblfq, paramblfn);
      return;
      avai.a(paramblfq.jdField_b_of_type_JavaLangString);
    }
    ((blfh)((QQAppInterface)localObject).getManager(27)).a(paramContext, paramblfq, paramblfn);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(anni.a(2131704626))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), anni.a(2131704628) + paramString2 + anni.a(2131704627), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + anni.a(2131704629), 0).show();
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
  
  public static void b(Context paramContext, blfq paramblfq)
  {
    blfl localblfl = new blfl();
    paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramblfq.jdField_a_of_type_Avaj != null) {
      paramblfq.jdField_a_of_type_Avaj.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramblfq, localblfl);
      return;
    }
    ((blfh)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, paramblfq, localblfl);
  }
  
  public static void c(Context paramContext, blfq paramblfq)
  {
    blfm localblfm = new blfm();
    paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramblfq.jdField_a_of_type_Avaj != null) {
      paramblfq.jdField_a_of_type_Avaj.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramblfq, localblfm);
      return;
    }
    ((blfh)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, paramblfq, localblfm);
  }
  
  private static void c(Context paramContext, blfq paramblfq, blfo paramblfo)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new blfr(paramContext, paramblfq, paramblfo));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new blfr(paramContext, paramblfq, paramblfo));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new blfj();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, paramblfq, paramblfo);
  }
  
  static void d(Context paramContext, blfq paramblfq)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        a(paramblfq.jdField_a_of_type_JavaUtilList);
        paramblfq.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, paramblfq.jdField_a_of_type_JavaLangClass);
        if (TextUtils.isEmpty(paramblfq.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
        {
          paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramblfq.jdField_a_of_type_JavaLangString);
          paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramblfq.jdField_a_of_type_JavaLangString);
        }
        paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramblfq.jdField_a_of_type_JavaLangString);
        paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcsm.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        paramblfq.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, paramblfq.jdField_d_of_type_JavaLangString, paramblfq.jdField_b_of_type_JavaLangString, paramblfq.jdField_c_of_type_JavaLangString, paramblfq.jdField_e_of_type_JavaLangString, paramblfq.jdField_a_of_type_AndroidContentIntent, paramblfq.jdField_b_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!paramblfq.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130771997, 2130772001);
          return;
          PluginProxyActivity.openActivity(paramContext, paramblfq.jdField_d_of_type_JavaLangString, paramblfq.jdField_b_of_type_JavaLangString, paramblfq.jdField_c_of_type_JavaLangString, paramblfq.jdField_e_of_type_JavaLangString, paramblfq.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((paramblfq.jdField_a_of_type_AndroidAppDialog != null) && ((paramblfq.jdField_a_of_type_AndroidAppDialog instanceof bibl)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772100, 2130772100);
        return;
      }
    } while ((paramblfq.jdField_d_of_type_Int <= 0) || (paramblfq.jdField_e_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(paramblfq.jdField_d_of_type_Int, paramblfq.jdField_e_of_type_Int);
  }
  
  private static void d(Context paramContext, blfq paramblfq, blfo paramblfo)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      paramblfo.a(false, paramContext, paramblfq);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(paramblfq.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (paramblfo == null);
    paramblfq.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    paramblfq.a(localPluginBaseInfo);
    paramblfo.a(true, paramContext, paramblfq);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(paramblfq.jdField_b_of_type_JavaLangString, new blfk(paramblfo, paramblfq, paramContext));
  }
  
  static void e(Context paramContext, blfq paramblfq)
  {
    a(paramblfq.jdField_a_of_type_JavaUtilList);
    paramblfq.a();
    if ((TextUtils.isEmpty(paramblfq.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramblfq.jdField_a_of_type_JavaLangString)))
    {
      paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramblfq.jdField_a_of_type_JavaLangString);
      paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramblfq.jdField_a_of_type_JavaLangString);
    }
    paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramblfq.jdField_a_of_type_JavaLangString);
    paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcsm.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramblfq.jdField_d_of_type_JavaLangString, paramblfq.jdField_b_of_type_JavaLangString, paramblfq.jdField_c_of_type_JavaLangString, paramblfq.jdField_e_of_type_JavaLangString, paramblfq.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, blfq paramblfq)
  {
    a(paramblfq.jdField_a_of_type_JavaUtilList);
    paramblfq.a();
    if ((TextUtils.isEmpty(paramblfq.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramblfq.jdField_a_of_type_JavaLangString)))
    {
      paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramblfq.jdField_a_of_type_JavaLangString);
      paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramblfq.jdField_a_of_type_JavaLangString);
    }
    paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramblfq.jdField_a_of_type_JavaLangString);
    paramblfq.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", bcsm.class.getName());
    if (paramblfq.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, paramblfq.jdField_d_of_type_JavaLangString, paramblfq.jdField_b_of_type_JavaLangString, paramblfq.jdField_c_of_type_JavaLangString, paramblfq.jdField_e_of_type_JavaLangString, paramblfq.jdField_a_of_type_AndroidContentIntent, paramblfq.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, paramblfq), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, blfq paramblfq, blfo paramblfo);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfh
 * JD-Core Version:    0.7.0.1
 */