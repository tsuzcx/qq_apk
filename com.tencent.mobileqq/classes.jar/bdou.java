import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineVersion;

public class bdou
{
  private static volatile bdou a;
  public BaseLibInfo a;
  public EngineVersion a;
  
  public bdou()
  {
    a();
    b();
  }
  
  public static bdou a()
  {
    if (jdField_a_of_type_Bdou == null) {}
    try
    {
      if (jdField_a_of_type_Bdou == null) {
        jdField_a_of_type_Bdou = new bdou();
      }
      return jdField_a_of_type_Bdou;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo = new BaseLibInfo();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibUrl = "assets://mini";
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibVersion = bdzi.a("1.10.0.00173");
    bdnw.b("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo start");
    long l = System.currentTimeMillis();
    bdnw.b("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo cost=" + (System.currentTimeMillis() - l));
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
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion = new EngineVersion(bdzi.a("1.10.0.00173"));
  }
  
  private boolean c()
  {
    String str = MiniAppEnv.g().getContext().getPackageName();
    bdnw.b("LocalGameEngine", "[MiniEng]isQQSpeedPackage " + str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdou
 * JD-Core Version:    0.7.0.1
 */