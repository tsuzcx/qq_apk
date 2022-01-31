import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import java.util.Map;

@begt(a="ApkgLoadAsyncTask")
public class bfdj
  extends bfeq
{
  private bejy jdField_a_of_type_Bejy;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private boolean jdField_a_of_type_Boolean;
  
  public bfdj(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public bejy a()
  {
    return this.jdField_a_of_type_Bejy;
  }
  
  public void a() {}
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    bexz.a(206, "", a().getMiniAppInfoForReport());
    besl.b("AppRuntimeLoader", "ApkgLoadAsyncTask start loadApkgByConfig");
    if ((this.jdField_a_of_type_Boolean) && (paramMiniAppInfo != null) && (paramMiniAppInfo.supportNativeRenderMode()))
    {
      besl.b("AppRuntimeLoader", "ApkgLoadAsyncTask use flutter url:" + (String)paramMiniAppInfo.renderInfo.a.get(Integer.valueOf(1)));
      paramMiniAppInfo.downloadUrl = ((String)paramMiniAppInfo.renderInfo.a.get(Integer.valueOf(1)));
    }
    beip.a().a(a(), this.jdField_a_of_type_Boolean, paramMiniAppInfo, new bfdk(this, paramMiniAppInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    super.c();
    bexz.a(207, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdj
 * JD-Core Version:    0.7.0.1
 */