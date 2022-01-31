import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import java.util.Map;

@bdcu(a="ApkgLoadAsyncTask")
public class bdwv
  extends bdxy
{
  private bdfx jdField_a_of_type_Bdfx;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private boolean jdField_a_of_type_Boolean;
  
  public bdwv(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, parambdlq);
  }
  
  public bdfx a()
  {
    return this.jdField_a_of_type_Bdfx;
  }
  
  public void a() {}
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    bdsc.a(206, "", a().getMiniAppInfoForReport());
    bdnw.b("AppRuntimeLoader", "ApkgLoadAsyncTask start loadApkgByConfig");
    if ((this.jdField_a_of_type_Boolean) && (paramMiniAppInfo != null) && (paramMiniAppInfo.supportNativeRenderMode()))
    {
      bdnw.b("AppRuntimeLoader", "ApkgLoadAsyncTask use flutter url:" + (String)paramMiniAppInfo.renderInfo.a.get(Integer.valueOf(1)));
      paramMiniAppInfo.downloadUrl = ((String)paramMiniAppInfo.renderInfo.a.get(Integer.valueOf(1)));
    }
    bdep.a().a(a(), this.jdField_a_of_type_Boolean, paramMiniAppInfo, new bdww(this, paramMiniAppInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    super.c();
    bdsc.a(207, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdwv
 * JD-Core Version:    0.7.0.1
 */