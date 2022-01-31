import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Map;

@bghi(a="ApkgLoadAsyncTask")
public class bhdu
  extends bhhm
{
  private bgjw jdField_a_of_type_Bgjw;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private boolean jdField_a_of_type_Boolean;
  
  public bhdu(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  public bgjw a()
  {
    return this.jdField_a_of_type_Bgjw;
  }
  
  public void a() {}
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    bgxl.a(206, "", a().getMiniAppInfoForReport());
    QMLog.i("BaseRuntimeLoader", "ApkgLoadAsyncTask start loadApkgByConfig");
    if ((this.jdField_a_of_type_Boolean) && (paramMiniAppInfo != null) && (paramMiniAppInfo.supportNativeRenderMode()))
    {
      QMLog.i("BaseRuntimeLoader", "ApkgLoadAsyncTask use flutter url:" + (String)paramMiniAppInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)));
      paramMiniAppInfo.downloadUrl = ((String)paramMiniAppInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)));
    }
    bgjh.a().a(a(), this.jdField_a_of_type_Boolean, paramMiniAppInfo, new bhdv(this, paramMiniAppInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    super.c();
    bgxl.a(207, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdu
 * JD-Core Version:    0.7.0.1
 */