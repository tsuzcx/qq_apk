import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@begt(a="GpkgLoadAsyncTask")
public class bewc
  extends bfeq
{
  private bevc jdField_a_of_type_Bevc;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String c;
  
  public bewc(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public bevc a()
  {
    return this.jdField_a_of_type_Bevc;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId == null))
    {
      besl.d("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig failed " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a(2002, "配置错误");
      return;
    }
    if ((this.jdField_a_of_type_Bevc != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId.equals(this.jdField_a_of_type_Bevc.d)))
    {
      besl.d("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig appid " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId + " has loaded.");
      c();
      return;
    }
    if ((this.c != null) && (this.c.equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId)))
    {
      besl.c("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig appid " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId + " is loading.");
      return;
    }
    besl.b("GpkgLoadAsyncTask", "[Gpkg] start loadGpkgByConfig appid:" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    this.c = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
    this.jdField_a_of_type_Bevc = null;
    long l = System.currentTimeMillis();
    beut.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, new bewd(this, l));
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void b()
  {
    besl.b("GpkgLoadAsyncTask", "[Gpkg]" + this + " reset ");
    super.b();
    this.jdField_a_of_type_Bevc = null;
    this.c = null;
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewc
 * JD-Core Version:    0.7.0.1
 */