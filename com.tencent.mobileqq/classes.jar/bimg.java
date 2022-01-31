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

public abstract class bimg
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<bimq> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static bimg a(QQAppInterface paramQQAppInterface)
  {
    return new bing(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, bimp parambimp)
  {
    a(paramContext, parambimp, null);
  }
  
  public static void a(Context paramContext, bimp parambimp, bimm parambimm)
  {
    Object localObject;
    if (parambimp.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambimp.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    parambimm = new bimh(parambimm);
    if (((paramContext instanceof Activity)) && (parambimp.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, parambimp.jdField_a_of_type_AndroidAppDialog, parambimp.jdField_d_of_type_JavaLangString, parambimp.jdField_b_of_type_JavaLangString, parambimp.jdField_b_of_type_Boolean, parambimp.jdField_c_of_type_Int).show();
    }
    if (parambimp.jdField_a_of_type_Asor != null) {
      if (TextUtils.equals(parambimp.jdField_a_of_type_Asor.jdField_a_of_type_JavaLangString, parambimp.jdField_b_of_type_JavaLangString))
      {
        parambimp.jdField_a_of_type_Asor.b();
        parambimp.jdField_a_of_type_Asor.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramContext, parambimp, parambimm);
      return;
      asoq.a(parambimp.jdField_b_of_type_JavaLangString);
    }
    ((bimg)((QQAppInterface)localObject).getManager(27)).a(paramContext, parambimp, parambimm);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(alpo.a(2131706213))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), alpo.a(2131706215) + paramString2 + alpo.a(2131706214), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + alpo.a(2131706216), 0).show();
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
  
  public static void b(Context paramContext, bimp parambimp)
  {
    bimk localbimk = new bimk();
    parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambimp.jdField_a_of_type_Asor != null) {
      parambimp.jdField_a_of_type_Asor.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambimp, localbimk);
      return;
    }
    ((bimg)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambimp, localbimk);
  }
  
  public static void c(Context paramContext, bimp parambimp)
  {
    biml localbiml = new biml();
    parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambimp.jdField_a_of_type_Asor != null) {
      parambimp.jdField_a_of_type_Asor.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambimp, localbiml);
      return;
    }
    ((bimg)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambimp, localbiml);
  }
  
  private static void c(Context paramContext, bimp parambimp, bimn parambimn)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bimq(paramContext, parambimp, parambimn));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new bimq(paramContext, parambimp, parambimn));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new bimi();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, parambimp, parambimn);
  }
  
  static void d(Context paramContext, bimp parambimp)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        a(parambimp.jdField_a_of_type_JavaUtilList);
        parambimp.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, parambimp.jdField_a_of_type_JavaLangClass);
        if (TextUtils.isEmpty(parambimp.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
        {
          parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambimp.jdField_a_of_type_JavaLangString);
          parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambimp.jdField_a_of_type_JavaLangString);
        }
        parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambimp.jdField_a_of_type_JavaLangString);
        parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azmc.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        parambimp.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, parambimp.jdField_d_of_type_JavaLangString, parambimp.jdField_b_of_type_JavaLangString, parambimp.jdField_c_of_type_JavaLangString, parambimp.jdField_e_of_type_JavaLangString, parambimp.jdField_a_of_type_AndroidContentIntent, parambimp.jdField_b_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!parambimp.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130771997, 2130772001);
          return;
          PluginProxyActivity.openActivity(paramContext, parambimp.jdField_d_of_type_JavaLangString, parambimp.jdField_b_of_type_JavaLangString, parambimp.jdField_c_of_type_JavaLangString, parambimp.jdField_e_of_type_JavaLangString, parambimp.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((parambimp.jdField_a_of_type_AndroidAppDialog != null) && ((parambimp.jdField_a_of_type_AndroidAppDialog instanceof beqe)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772097, 2130772097);
        return;
      }
    } while ((parambimp.jdField_d_of_type_Int <= 0) || (parambimp.jdField_e_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(parambimp.jdField_d_of_type_Int, parambimp.jdField_e_of_type_Int);
  }
  
  private static void d(Context paramContext, bimp parambimp, bimn parambimn)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      parambimn.a(false, paramContext, parambimp);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(parambimp.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (parambimn == null);
    parambimp.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    parambimp.a(localPluginBaseInfo);
    parambimn.a(true, paramContext, parambimp);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(parambimp.jdField_b_of_type_JavaLangString, new bimj(parambimn, parambimp, paramContext));
  }
  
  static void e(Context paramContext, bimp parambimp)
  {
    a(parambimp.jdField_a_of_type_JavaUtilList);
    parambimp.a();
    if ((TextUtils.isEmpty(parambimp.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambimp.jdField_a_of_type_JavaLangString)))
    {
      parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambimp.jdField_a_of_type_JavaLangString);
      parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambimp.jdField_a_of_type_JavaLangString);
    }
    parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambimp.jdField_a_of_type_JavaLangString);
    parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azmc.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambimp.jdField_d_of_type_JavaLangString, parambimp.jdField_b_of_type_JavaLangString, parambimp.jdField_c_of_type_JavaLangString, parambimp.jdField_e_of_type_JavaLangString, parambimp.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, bimp parambimp)
  {
    a(parambimp.jdField_a_of_type_JavaUtilList);
    parambimp.a();
    if ((TextUtils.isEmpty(parambimp.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambimp.jdField_a_of_type_JavaLangString)))
    {
      parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambimp.jdField_a_of_type_JavaLangString);
      parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambimp.jdField_a_of_type_JavaLangString);
    }
    parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambimp.jdField_a_of_type_JavaLangString);
    parambimp.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azmc.class.getName());
    if (parambimp.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, parambimp.jdField_d_of_type_JavaLangString, parambimp.jdField_b_of_type_JavaLangString, parambimp.jdField_c_of_type_JavaLangString, parambimp.jdField_e_of_type_JavaLangString, parambimp.jdField_a_of_type_AndroidContentIntent, parambimp.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, parambimp), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, bimp parambimp, bimn parambimn);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimg
 * JD-Core Version:    0.7.0.1
 */