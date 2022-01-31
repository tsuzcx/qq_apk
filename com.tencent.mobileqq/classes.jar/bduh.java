import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.ArrayList;
import java.util.List;

public class bduh
  extends bduj
{
  public static volatile boolean a;
  private List<String> a;
  
  public bduh()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    try
    {
      if ((!jdField_a_of_type_Boolean) && (Build.VERSION.SDK_INT >= 28))
      {
        jdField_a_of_type_Boolean = true;
        WebView.setDataDirectorySuffix(bdle.a().b());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("AppBrandRuntime", "setDataDirectorySuffix error", localThrowable);
    }
  }
  
  public void a(bdwp parambdwp)
  {
    super.a(parambdwp);
    parambdwp = new AppBrandPageContainer(this, this.jdField_a_of_type_Bduk);
    parambdwp.a(null);
    this.jdField_a_of_type_Bdvc = parambdwp;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bdnw.d("AppBrandRuntime", "loadSubPkgAppService url is null.");
      return;
    }
    if (this.jdField_a_of_type_Bdfx == null)
    {
      bdnw.d("AppBrandRuntime", "loadSubPkgAppService ApkgInfo is null.");
      return;
    }
    String str = this.jdField_a_of_type_Bdfx.c(paramString);
    if (TextUtils.isEmpty(str))
    {
      bdnw.d("AppBrandRuntime", "loadSubPkgAppService subPkgRoot is null.");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      bdnw.d("AppBrandRuntime", "loadSubPkgAppService has loaded.");
      return;
    }
    str = this.jdField_a_of_type_Bdfx.e(str);
    if (TextUtils.isEmpty(str))
    {
      bdnw.d("AppBrandRuntime", "loadSubPkgAppService appServiceJsStr is null.");
      return;
    }
    this.jdField_a_of_type_Bdwp.a(str, new bdui(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bduh
 * JD-Core Version:    0.7.0.1
 */