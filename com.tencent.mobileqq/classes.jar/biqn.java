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

public abstract class biqn
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<biqx> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static biqn a(QQAppInterface paramQQAppInterface)
  {
    return new birn(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, biqw parambiqw)
  {
    a(paramContext, parambiqw, null);
  }
  
  public static void a(Context paramContext, biqw parambiqw, biqt parambiqt)
  {
    Object localObject;
    if (parambiqw.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), parambiqw.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    parambiqt = new biqo(parambiqt);
    if (((paramContext instanceof Activity)) && (parambiqw.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, parambiqw.jdField_a_of_type_AndroidAppDialog, parambiqw.jdField_d_of_type_JavaLangString, parambiqw.jdField_b_of_type_JavaLangString, parambiqw.jdField_b_of_type_Boolean, parambiqw.jdField_c_of_type_Int).show();
    }
    if (parambiqw.jdField_a_of_type_Asta != null) {
      if (TextUtils.equals(parambiqw.jdField_a_of_type_Asta.jdField_a_of_type_JavaLangString, parambiqw.jdField_b_of_type_JavaLangString))
      {
        parambiqw.jdField_a_of_type_Asta.b();
        parambiqw.jdField_a_of_type_Asta.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramContext, parambiqw, parambiqt);
      return;
      assz.a(parambiqw.jdField_b_of_type_JavaLangString);
    }
    ((biqn)((QQAppInterface)localObject).getManager(27)).a(paramContext, parambiqw, parambiqt);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(alud.a(2131706225))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), alud.a(2131706227) + paramString2 + alud.a(2131706226), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + alud.a(2131706228), 0).show();
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
  
  public static void b(Context paramContext, biqw parambiqw)
  {
    biqr localbiqr = new biqr();
    parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambiqw.jdField_a_of_type_Asta != null) {
      parambiqw.jdField_a_of_type_Asta.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambiqw, localbiqr);
      return;
    }
    ((biqn)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambiqw, localbiqr);
  }
  
  public static void c(Context paramContext, biqw parambiqw)
  {
    biqs localbiqs = new biqs();
    parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (parambiqw.jdField_a_of_type_Asta != null) {
      parambiqw.jdField_a_of_type_Asta.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, parambiqw, localbiqs);
      return;
    }
    ((biqn)((QQAppInterface)localAppRuntime).getManager(27)).a(paramContext, parambiqw, localbiqs);
  }
  
  private static void c(Context paramContext, biqw parambiqw, biqu parambiqu)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new biqx(paramContext, parambiqw, parambiqu));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new biqx(paramContext, parambiqw, parambiqu));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new biqp();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, parambiqw, parambiqu);
  }
  
  static void d(Context paramContext, biqw parambiqw)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        a(parambiqw.jdField_a_of_type_JavaUtilList);
        parambiqw.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, parambiqw.jdField_a_of_type_JavaLangClass);
        if (TextUtils.isEmpty(parambiqw.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
        {
          parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambiqw.jdField_a_of_type_JavaLangString);
          parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambiqw.jdField_a_of_type_JavaLangString);
        }
        parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambiqw.jdField_a_of_type_JavaLangString);
        parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azql.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        parambiqw.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, parambiqw.jdField_d_of_type_JavaLangString, parambiqw.jdField_b_of_type_JavaLangString, parambiqw.jdField_c_of_type_JavaLangString, parambiqw.jdField_e_of_type_JavaLangString, parambiqw.jdField_a_of_type_AndroidContentIntent, parambiqw.jdField_b_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!parambiqw.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130771997, 2130772001);
          return;
          PluginProxyActivity.openActivity(paramContext, parambiqw.jdField_d_of_type_JavaLangString, parambiqw.jdField_b_of_type_JavaLangString, parambiqw.jdField_c_of_type_JavaLangString, parambiqw.jdField_e_of_type_JavaLangString, parambiqw.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((parambiqw.jdField_a_of_type_AndroidAppDialog != null) && ((parambiqw.jdField_a_of_type_AndroidAppDialog instanceof beun)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772097, 2130772097);
        return;
      }
    } while ((parambiqw.jdField_d_of_type_Int <= 0) || (parambiqw.jdField_e_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(parambiqw.jdField_d_of_type_Int, parambiqw.jdField_e_of_type_Int);
  }
  
  private static void d(Context paramContext, biqw parambiqw, biqu parambiqu)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      parambiqu.a(false, paramContext, parambiqw);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(parambiqw.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (parambiqu == null);
    parambiqw.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    parambiqw.a(localPluginBaseInfo);
    parambiqu.a(true, paramContext, parambiqw);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(parambiqw.jdField_b_of_type_JavaLangString, new biqq(parambiqu, parambiqw, paramContext));
  }
  
  static void e(Context paramContext, biqw parambiqw)
  {
    a(parambiqw.jdField_a_of_type_JavaUtilList);
    parambiqw.a();
    if ((TextUtils.isEmpty(parambiqw.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambiqw.jdField_a_of_type_JavaLangString)))
    {
      parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambiqw.jdField_a_of_type_JavaLangString);
      parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambiqw.jdField_a_of_type_JavaLangString);
    }
    parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambiqw.jdField_a_of_type_JavaLangString);
    parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azql.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, parambiqw.jdField_d_of_type_JavaLangString, parambiqw.jdField_b_of_type_JavaLangString, parambiqw.jdField_c_of_type_JavaLangString, parambiqw.jdField_e_of_type_JavaLangString, parambiqw.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, biqw parambiqw)
  {
    a(parambiqw.jdField_a_of_type_JavaUtilList);
    parambiqw.a();
    if ((TextUtils.isEmpty(parambiqw.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(parambiqw.jdField_a_of_type_JavaLangString)))
    {
      parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("uin", parambiqw.jdField_a_of_type_JavaLangString);
      parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", parambiqw.jdField_a_of_type_JavaLangString);
    }
    parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", parambiqw.jdField_a_of_type_JavaLangString);
    parambiqw.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", azql.class.getName());
    if (parambiqw.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, parambiqw.jdField_d_of_type_JavaLangString, parambiqw.jdField_b_of_type_JavaLangString, parambiqw.jdField_c_of_type_JavaLangString, parambiqw.jdField_e_of_type_JavaLangString, parambiqw.jdField_a_of_type_AndroidContentIntent, parambiqw.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, parambiqw), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, biqw parambiqw, biqu parambiqu);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biqn
 * JD-Core Version:    0.7.0.1
 */