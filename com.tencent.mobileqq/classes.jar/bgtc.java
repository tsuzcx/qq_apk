import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import cooperation.qqreader.VipProxyRreLoadReaderProcess;
import mqq.app.AppRuntime;

public class bgtc
{
  private static bgtc a;
  
  private int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (bgkq)paramQQAppInterface.getManager(27);
    if (paramQQAppInterface == null)
    {
      bgvo.e("QRPluginManager", "PluginManager is NOT ready");
      return 0;
    }
    paramQQAppInterface = paramQQAppInterface.a("qqreaderplugin.apk");
    if (paramQQAppInterface == null)
    {
      bgvo.e("QRPluginManager", "ReaderPlugin is NOT found");
      return 0;
    }
    return paramQQAppInterface.mState;
  }
  
  public static bgtc a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bgtc();
      }
      return a;
    }
    finally {}
  }
  
  private void b()
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      bgvo.a("QRPluginManager", "checkMainProcess: 老插件的加载逻辑必须在主进程调用");
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
    axqw.b(paramQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, paramInt, "", "", "", "");
  }
  
  private void c(Context paramContext)
  {
    bgvo.e("QRPluginManager", "load plugin start");
    Intent localIntent = new Intent(paramContext, VipProxyRreLoadReaderProcess.class);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("is_preload_reader_plugin", false);
    bgkz localbgkz = new bgkz(0);
    localbgkz.b = "qqreaderplugin.apk";
    localbgkz.d = "qqreader";
    localbgkz.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbgkz.e = "com.qqreader.ReaderPreloadReaderProcess";
    localbgkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    bgkq.b(paramContext, localbgkz);
    bgvo.e("QRPluginManager", "load plugin end");
  }
  
  private void d(Context paramContext)
  {
    bgsz.a(paramContext, new Intent(), "com.qqreader.pureader.EmptyActivity", new bgte(this));
  }
  
  public void a()
  {
    b();
    ((bgkq)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).a("qqreaderplugin.apk");
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
    bgvo.c("QRPluginManager", "launchPlugin: plugin state=" + i + ", launchType=" + paramInt);
    if (i == 4) {
      b(paramContext, paramInt);
    }
    while ((i != -1) && (i != -2) && (i != 0)) {
      return;
    }
    ((bgkq)localQQAppInterface.getManager(27)).installPlugin("qqreaderplugin.apk", new bgtd(this, localQQAppInterface, paramContext, paramInt));
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
 * Qualified Name:     bgtc
 * JD-Core Version:    0.7.0.1
 */