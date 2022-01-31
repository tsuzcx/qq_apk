import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.ArrayList;
import java.util.List;

public class bfbg
  extends bfbi
{
  public static volatile boolean a;
  private List<String> a;
  
  public bfbg()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    try
    {
      if ((!jdField_a_of_type_Boolean) && (Build.VERSION.SDK_INT >= 28))
      {
        jdField_a_of_type_Boolean = true;
        WebView.setDataDirectorySuffix(beqb.a().b());
      }
      this.jdField_a_of_type_Bfcb = new AppBrandPageContainer(this, this.jdField_a_of_type_Bfbj);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        betc.d("AppBrandRuntime", "setDataDirectorySuffix error", localThrowable);
      }
    }
  }
  
  public void a(bfdt parambfdt)
  {
    super.a(parambfdt);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      betc.d("AppBrandRuntime", "loadSubPkgAppService url is null.");
      return;
    }
    if (this.jdField_a_of_type_Bekp == null)
    {
      betc.d("AppBrandRuntime", "loadSubPkgAppService ApkgInfo is null.");
      return;
    }
    String str = this.jdField_a_of_type_Bekp.c(paramString);
    if (TextUtils.isEmpty(str))
    {
      betc.d("AppBrandRuntime", "loadSubPkgAppService subPkgRoot is null.");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      betc.d("AppBrandRuntime", "loadSubPkgAppService has loaded.");
      return;
    }
    str = this.jdField_a_of_type_Bekp.e(str);
    if (TextUtils.isEmpty(str))
    {
      betc.d("AppBrandRuntime", "loadSubPkgAppService appServiceJsStr is null.");
      return;
    }
    this.jdField_a_of_type_Bfdt.a(str, new bfbh(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbg
 * JD-Core Version:    0.7.0.1
 */