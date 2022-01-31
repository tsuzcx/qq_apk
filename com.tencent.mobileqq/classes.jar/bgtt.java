import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import cooperation.qqreader.VipProxyRreLoadReaderProcess;
import mqq.app.AppRuntime;

public class bgtt
{
  private static bgtt a;
  
  private int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (bglh)paramQQAppInterface.getManager(27);
    if (paramQQAppInterface == null)
    {
      bgwf.e("QRPluginManager", "PluginManager is NOT ready");
      return 0;
    }
    paramQQAppInterface = paramQQAppInterface.a("qqreaderplugin.apk");
    if (paramQQAppInterface == null)
    {
      bgwf.e("QRPluginManager", "ReaderPlugin is NOT found");
      return 0;
    }
    return paramQQAppInterface.mState;
  }
  
  public static bgtt a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bgtt();
      }
      return a;
    }
    finally {}
  }
  
  private void b()
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      bgwf.a("QRPluginManager", "checkMainProcess: 老插件的加载逻辑必须在主进程调用");
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
    axqy.b(paramQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, paramInt, "", "", "", "");
  }
  
  private void c(Context paramContext)
  {
    bgwf.e("QRPluginManager", "load plugin start");
    Intent localIntent = new Intent(paramContext, VipProxyRreLoadReaderProcess.class);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("is_preload_reader_plugin", false);
    bglq localbglq = new bglq(0);
    localbglq.b = "qqreaderplugin.apk";
    localbglq.d = "qqreader";
    localbglq.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbglq.e = "com.qqreader.ReaderPreloadReaderProcess";
    localbglq.jdField_a_of_type_AndroidContentIntent = localIntent;
    bglh.b(paramContext, localbglq);
    bgwf.e("QRPluginManager", "load plugin end");
  }
  
  private void d(Context paramContext)
  {
    bgtq.a(paramContext, new Intent(), "com.qqreader.pureader.EmptyActivity", new bgtv(this));
  }
  
  public void a()
  {
    b();
    ((bglh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).a("qqreaderplugin.apk");
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
    bgwf.c("QRPluginManager", "launchPlugin: plugin state=" + i + ", launchType=" + paramInt);
    if (i == 4) {
      b(paramContext, paramInt);
    }
    while ((i != -1) && (i != -2) && (i != 0)) {
      return;
    }
    ((bglh)localQQAppInterface.getManager(27)).installPlugin("qqreaderplugin.apk", new bgtu(this, localQQAppInterface, paramContext, paramInt));
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
 * Qualified Name:     bgtt
 * JD-Core Version:    0.7.0.1
 */