import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.ArrayList;
import java.util.List;

public class bfap
  extends bfar
{
  public static volatile boolean a;
  private List<String> a;
  
  public bfap()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    try
    {
      if ((!jdField_a_of_type_Boolean) && (Build.VERSION.SDK_INT >= 28))
      {
        jdField_a_of_type_Boolean = true;
        WebView.setDataDirectorySuffix(bepk.a().b());
      }
      this.jdField_a_of_type_Bfbk = new AppBrandPageContainer(this, this.jdField_a_of_type_Bfas);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        besl.d("AppBrandRuntime", "setDataDirectorySuffix error", localThrowable);
      }
    }
  }
  
  public void a(bfdc parambfdc)
  {
    super.a(parambfdc);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      besl.d("AppBrandRuntime", "loadSubPkgAppService url is null.");
      return;
    }
    if (this.jdField_a_of_type_Bejy == null)
    {
      besl.d("AppBrandRuntime", "loadSubPkgAppService ApkgInfo is null.");
      return;
    }
    String str = this.jdField_a_of_type_Bejy.c(paramString);
    if (TextUtils.isEmpty(str))
    {
      besl.d("AppBrandRuntime", "loadSubPkgAppService subPkgRoot is null.");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      besl.d("AppBrandRuntime", "loadSubPkgAppService has loaded.");
      return;
    }
    str = this.jdField_a_of_type_Bejy.e(str);
    if (TextUtils.isEmpty(str))
    {
      besl.d("AppBrandRuntime", "loadSubPkgAppService appServiceJsStr is null.");
      return;
    }
    this.jdField_a_of_type_Bfdc.a(str, new bfaq(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfap
 * JD-Core Version:    0.7.0.1
 */