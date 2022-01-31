import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import java.util.Map;

@behk(a="ApkgLoadAsyncTask")
public class bfea
  extends bffh
{
  private bekp jdField_a_of_type_Bekp;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private boolean jdField_a_of_type_Boolean;
  
  public bfea(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public bekp a()
  {
    return this.jdField_a_of_type_Bekp;
  }
  
  public void a() {}
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    beyq.a(206, "", a().getMiniAppInfoForReport());
    betc.b("AppRuntimeLoader", "ApkgLoadAsyncTask start loadApkgByConfig");
    if ((this.jdField_a_of_type_Boolean) && (paramMiniAppInfo != null) && (paramMiniAppInfo.supportNativeRenderMode()))
    {
      betc.b("AppRuntimeLoader", "ApkgLoadAsyncTask use flutter url:" + (String)paramMiniAppInfo.renderInfo.a.get(Integer.valueOf(1)));
      paramMiniAppInfo.downloadUrl = ((String)paramMiniAppInfo.renderInfo.a.get(Integer.valueOf(1)));
    }
    bejg.a().a(a(), this.jdField_a_of_type_Boolean, paramMiniAppInfo, new bfeb(this, paramMiniAppInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    super.c();
    beyq.a(207, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfea
 * JD-Core Version:    0.7.0.1
 */