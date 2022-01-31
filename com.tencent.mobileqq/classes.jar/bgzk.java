import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

@bglp(a="GpkgLoadAsyncTask")
public class bgzk
  extends bhlt
{
  private bgyu jdField_a_of_type_Bgyu;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public bgzk(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  private void b(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (paramMiniAppInfo.appId == null))
    {
      QMLog.e("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig failed " + paramMiniAppInfo);
      a(2002, "配置错误");
      return;
    }
    if ((this.jdField_a_of_type_Bgyu != null) && (paramMiniAppInfo.appId.equals(this.jdField_a_of_type_Bgyu.appId)))
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
    this.jdField_a_of_type_Bgyu = null;
    bgyk.a(paramMiniAppInfo, new bgzl(this, System.currentTimeMillis()));
  }
  
  public bgyu a()
  {
    return this.jdField_a_of_type_Bgyu;
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
    this.jdField_a_of_type_Bgyu = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzk
 * JD-Core Version:    0.7.0.1
 */