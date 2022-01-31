import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineVersion;

public class beus
{
  private static volatile beus a;
  public BaseLibInfo a;
  public EngineVersion a;
  
  public beus()
  {
    a();
    b();
  }
  
  public static beus a()
  {
    if (jdField_a_of_type_Beus == null) {}
    try
    {
      if (jdField_a_of_type_Beus == null) {
        jdField_a_of_type_Beus = new beus();
      }
      return jdField_a_of_type_Beus;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo = new BaseLibInfo();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibUrl = "assets://mini";
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibVersion = bfhp.a("1.13.0.00013");
    betc.b("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo start");
    long l = System.currentTimeMillis();
    betc.b("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo cost=" + (System.currentTimeMillis() - l));
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
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion = new EngineVersion(bfhp.a("1.13.0.00013"));
  }
  
  private boolean c()
  {
    String str = MiniAppEnv.g().getContext().getPackageName();
    betc.b("LocalGameEngine", "[MiniEng]isQQSpeedPackage " + str);
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
 * Qualified Name:     beus
 * JD-Core Version:    0.7.0.1
 */