import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@behk(a="GpkgLoadAsyncTask")
public class bewt
  extends bffh
{
  private bevt jdField_a_of_type_Bevt;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String c;
  
  public bewt(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public bevt a()
  {
    return this.jdField_a_of_type_Bevt;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId == null))
    {
      betc.d("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig failed " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a(2002, "配置错误");
      return;
    }
    if ((this.jdField_a_of_type_Bevt != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId.equals(this.jdField_a_of_type_Bevt.d)))
    {
      betc.d("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig appid " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId + " has loaded.");
      c();
      return;
    }
    if ((this.c != null) && (this.c.equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId)))
    {
      betc.c("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig appid " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId + " is loading.");
      return;
    }
    betc.b("GpkgLoadAsyncTask", "[Gpkg] start loadGpkgByConfig appid:" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    this.c = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
    this.jdField_a_of_type_Bevt = null;
    long l = System.currentTimeMillis();
    bevk.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, new bewu(this, l));
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void b()
  {
    betc.b("GpkgLoadAsyncTask", "[Gpkg]" + this + " reset ");
    super.b();
    this.jdField_a_of_type_Bevt = null;
    this.c = null;
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewt
 * JD-Core Version:    0.7.0.1
 */