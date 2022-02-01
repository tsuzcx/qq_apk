import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.util.Pair;
import cooperation.qqreader.VipProxyRreLoadReaderProcess;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class bmec
{
  private static bmec jdField_a_of_type_Bmec;
  private OnPluginInstallListener.Stub jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener$Stub = new bmed(this);
  private Pair<WeakReference<Context>, Integer> jdField_a_of_type_ComTencentUtilPair;
  
  private int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (blvy)paramQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
    if (paramQQAppInterface == null)
    {
      bmgm.e("QRPluginManager", "PluginManager is NOT ready");
      return 0;
    }
    paramQQAppInterface = paramQQAppInterface.a("qqreaderplugin.apk");
    if (paramQQAppInterface == null)
    {
      bmgm.e("QRPluginManager", "ReaderPlugin is NOT found");
      return 0;
    }
    return paramQQAppInterface.mState;
  }
  
  public static bmec a()
  {
    if (jdField_a_of_type_Bmec == null) {}
    try
    {
      if (jdField_a_of_type_Bmec == null) {
        jdField_a_of_type_Bmec = new bmec();
      }
      return jdField_a_of_type_Bmec;
    }
    finally {}
  }
  
  private void b()
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      bmgm.a("QRPluginManager", "checkMainProcess: 老插件的加载逻辑必须在主进程调用");
    }
  }
  
  private void b(Context paramContext, int paramInt)
  {
    if (paramInt == 2)
    {
      d(paramContext);
      return;
    }
    c(paramContext);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    bdla.b(paramQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, paramInt, "", "", "", "");
  }
  
  private void c(Context paramContext)
  {
    bmgm.e("QRPluginManager", "load plugin start");
    Intent localIntent = new Intent(paramContext, VipProxyRreLoadReaderProcess.class);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("params_uin_for_reader", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("is_preload_reader_plugin", false);
    blwh localblwh = new blwh(0);
    localblwh.b = "qqreaderplugin.apk";
    localblwh.d = "qqreader";
    localblwh.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localblwh.e = "com.qqreader.ReaderPreloadReaderProcess";
    localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    blvy.b(paramContext, localblwh);
    bmgm.e("QRPluginManager", "load plugin end");
  }
  
  private void d(Context paramContext)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    bmea.a(paramContext, localIntent, "com.qqreader.pureader.EmptyActivity", new bmee(this));
  }
  
  public void a()
  {
    b();
    ((blvy)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MGR_PLUGIN)).a("qqreaderplugin.apk");
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, 2);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i = a(localQQAppInterface);
    bmgm.c("QRPluginManager", "launchPlugin: plugin state=" + i + ", launchType=" + paramInt);
    if (i == 4)
    {
      this.jdField_a_of_type_ComTencentUtilPair = null;
      b(paramContext, paramInt);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentUtilPair = new Pair(new WeakReference(paramContext), Integer.valueOf(paramInt));
    } while (i == 1);
    ((blvy)localQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN)).installPlugin("qqreaderplugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener$Stub);
  }
  
  public boolean a()
  {
    b();
    return a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()) == 4;
  }
  
  public void b(Context paramContext)
  {
    a(paramContext, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmec
 * JD-Core Version:    0.7.0.1
 */