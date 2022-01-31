import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

@bghi(a="GpkgLoadAsyncTask")
public class bgvd
  extends bhhm
{
  private bgun jdField_a_of_type_Bgun;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public bgvd(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  private void b(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (paramMiniAppInfo.appId == null))
    {
      QMLog.e("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig failed " + paramMiniAppInfo);
      a(2002, "配置错误");
      return;
    }
    if ((this.jdField_a_of_type_Bgun != null) && (paramMiniAppInfo.appId.equals(this.jdField_a_of_type_Bgun.appId)))
    {
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig appid " + paramMiniAppInfo.appId + " has loaded.");
      c();
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramMiniAppInfo.appId)))
    {
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig appid " + paramMiniAppInfo.appId + " is loading.");
      return;
    }
    QMLog.i("GpkgLoadAsyncTask", "[Gpkg] start loadGpkgByConfig appid:" + paramMiniAppInfo.appId);
    this.jdField_a_of_type_JavaLangString = paramMiniAppInfo.appId;
    this.jdField_a_of_type_Bgun = null;
    bgud.a(paramMiniAppInfo, new bgve(this, System.currentTimeMillis()));
  }
  
  public bgun a()
  {
    return this.jdField_a_of_type_Bgun;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public void a()
  {
    QMLog.i("GpkgLoadAsyncTask", "executeAsync(). " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void b()
  {
    QMLog.i("GpkgLoadAsyncTask", "[Gpkg]" + this + " reset ");
    super.b();
    this.jdField_a_of_type_Bgun = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvd
 * JD-Core Version:    0.7.0.1
 */