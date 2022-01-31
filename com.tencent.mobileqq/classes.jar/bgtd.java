import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.utils.WnsUtil;

public class bgtd
{
  private static volatile bgtd a;
  public BaseLibInfo a;
  public EngineVersion a;
  
  public bgtd()
  {
    a();
    b();
  }
  
  public static bgtd a()
  {
    if (jdField_a_of_type_Bgtd == null) {}
    try
    {
      if (jdField_a_of_type_Bgtd == null) {
        jdField_a_of_type_Bgtd = new bgtd();
      }
      return jdField_a_of_type_Bgtd;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo = new BaseLibInfo();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibUrl = "assets://mini";
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibVersion = WnsUtil.getGameEngineVersion("1.14.0.00225");
    QMLog.i("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo start");
    long l = System.currentTimeMillis();
    QMLog.i("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo cost=" + (System.currentTimeMillis() - l));
    if (new boolean[] { false }[0] != 0) {}
    for (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibDesc = ("{'file_length':" + new long[] { 0L }[0] + "}");; this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibDesc = "{'file_length':-1}")
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibKey = null;
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibType = 2;
      return;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion = new EngineVersion(WnsUtil.getGameEngineVersion("1.14.0.00225"));
  }
  
  private boolean c()
  {
    String str = AppLoaderFactory.g().getMiniAppEnv().getContext().getPackageName();
    QMLog.i("LocalGameEngine", "[MiniEng]isQQSpeedPackage " + str);
    return (!TextUtils.isEmpty(str)) && (str.toLowerCase().startsWith("com.tencent.qqspeed"));
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtd
 * JD-Core Version:    0.7.0.1
 */