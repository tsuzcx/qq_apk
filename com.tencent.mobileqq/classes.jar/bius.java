import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.util.Pair;
import cooperation.qqreader.VipProxyRreLoadReaderProcess;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class bius
{
  private static bius jdField_a_of_type_Bius;
  private OnPluginInstallListener.Stub jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener$Stub = new biut(this);
  private Pair<WeakReference<Context>, Integer> jdField_a_of_type_ComTencentUtilPair;
  
  private int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (bimg)paramQQAppInterface.getManager(27);
    if (paramQQAppInterface == null)
    {
      bixe.e("QRPluginManager", "PluginManager is NOT ready");
      return 0;
    }
    paramQQAppInterface = paramQQAppInterface.a("qqreaderplugin.apk");
    if (paramQQAppInterface == null)
    {
      bixe.e("QRPluginManager", "ReaderPlugin is NOT found");
      return 0;
    }
    return paramQQAppInterface.mState;
  }
  
  public static bius a()
  {
    if (jdField_a_of_type_Bius == null) {}
    try
    {
      if (jdField_a_of_type_Bius == null) {
        jdField_a_of_type_Bius = new bius();
      }
      return jdField_a_of_type_Bius;
    }
    finally {}
  }
  
  private void b()
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      bixe.a("QRPluginManager", "checkMainProcess: 老插件的加载逻辑必须在主进程调用");
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
    azmj.b(paramQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, paramInt, "", "", "", "");
  }
  
  private void c(Context paramContext)
  {
    bixe.e("QRPluginManager", "load plugin start");
    Intent localIntent = new Intent(paramContext, VipProxyRreLoadReaderProcess.class);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("params_uin_for_reader", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("is_preload_reader_plugin", false);
    bimp localbimp = new bimp(0);
    localbimp.b = "qqreaderplugin.apk";
    localbimp.d = "qqreader";
    localbimp.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbimp.e = "com.qqreader.ReaderPreloadReaderProcess";
    localbimp.jdField_a_of_type_AndroidContentIntent = localIntent;
    bimg.b(paramContext, localbimp);
    bixe.e("QRPluginManager", "load plugin end");
  }
  
  private void d(Context paramContext)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    biup.a(paramContext, localIntent, "com.qqreader.pureader.EmptyActivity", new biuu(this));
  }
  
  public void a()
  {
    b();
    ((bimg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).a("qqreaderplugin.apk");
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
    bixe.c("QRPluginManager", "launchPlugin: plugin state=" + i + ", launchType=" + paramInt);
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
    ((bimg)localQQAppInterface.getManager(27)).installPlugin("qqreaderplugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener$Stub);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bius
 * JD-Core Version:    0.7.0.1
 */