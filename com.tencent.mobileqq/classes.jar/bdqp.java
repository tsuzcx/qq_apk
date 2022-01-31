import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@bdcu(a="GpkgLoadAsyncTask")
public class bdqp
  extends bdxy
{
  private bdpy jdField_a_of_type_Bdpy;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String c;
  
  public bdqp(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, parambdlq);
  }
  
  public bdpy a()
  {
    return this.jdField_a_of_type_Bdpy;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId == null))
    {
      bdnw.d("GameRuntimeLoader", "[Gpkg] loadGpkgByConfig failed " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a(2002, "配置错误");
      return;
    }
    if ((this.jdField_a_of_type_Bdpy != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId.equals(this.jdField_a_of_type_Bdpy.d)))
    {
      bdnw.d("GameRuntimeLoader", "[Gpkg] loadGpkgByConfig appid " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId + " has loaded.");
      c();
      return;
    }
    if ((this.c != null) && (this.c.equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId)))
    {
      bdnw.c("GameRuntimeLoader", "[Gpkg] loadGpkgByConfig appid " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId + " is loading.");
      return;
    }
    bdnw.b("GameRuntimeLoader", "[Gpkg] start loadGpkgByConfig appid:" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    this.c = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
    this.jdField_a_of_type_Bdpy = null;
    long l = System.currentTimeMillis();
    bdpp.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, new bdqq(this, l));
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void b()
  {
    bdnw.b("GameRuntimeLoader", "[Gpkg]" + this + " reset ");
    super.b();
    this.jdField_a_of_type_Bdpy = null;
    this.c = null;
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqp
 * JD-Core Version:    0.7.0.1
 */