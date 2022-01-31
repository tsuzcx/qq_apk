import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebview;
import java.util.ArrayList;
import java.util.List;

public class bhew
  extends bhey
{
  public static volatile boolean a;
  private List<String> a;
  
  public bhew()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    try
    {
      if ((!jdField_a_of_type_Boolean) && (Build.VERSION.SDK_INT >= 28))
      {
        jdField_a_of_type_Boolean = true;
        WebView.setDataDirectorySuffix(AppLoaderFactory.g().getProcessName());
      }
      this.jdField_a_of_type_Bhfv = new AppBrandPageContainer(this, this.jdField_a_of_type_Bhez);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("AppBrandRuntime", "setDataDirectorySuffix error", localThrowable);
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bhhq != null) {
      this.jdField_a_of_type_Bhhq.a(a());
    }
  }
  
  public bhfi a()
  {
    Object localObject = ((AppBrandPageContainer)this.jdField_a_of_type_Bhfv).a();
    if (localObject == null)
    {
      QMLog.e("AppBrandRuntime", "Failed to get embedded state, AppBrandPage is null");
      return null;
    }
    localObject = ((AppBrandPage)localObject).a();
    if (localObject == null)
    {
      QMLog.e("AppBrandRuntime", "Failed to get embedded state, PageWebview is null");
      return null;
    }
    return ((PageWebview)localObject).a();
  }
  
  public ShareState a()
  {
    Object localObject = ((AppBrandPageContainer)this.jdField_a_of_type_Bhfv).a();
    if (localObject == null)
    {
      QMLog.e("AppBrandRuntime", "Failed to get share state, AppBrandPage is null");
      return null;
    }
    localObject = ((AppBrandPage)localObject).a();
    if (localObject == null)
    {
      QMLog.e("AppBrandRuntime", "Failed to get share state, PageWebview is null");
      return null;
    }
    return ((PageWebview)localObject).a();
  }
  
  public void a(bhhq parambhhq)
  {
    super.a(parambhhq);
    f();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("AppBrandRuntime", "loadSubPkgAppService url is null.");
      return;
    }
    if (this.jdField_a_of_type_Bgod == null)
    {
      QMLog.e("AppBrandRuntime", "loadSubPkgAppService ApkgInfo is null.");
      return;
    }
    String str = this.jdField_a_of_type_Bgod.getRootPath(paramString);
    if (TextUtils.isEmpty(str))
    {
      QMLog.e("AppBrandRuntime", "loadSubPkgAppService subPkgRoot is null.");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      QMLog.e("AppBrandRuntime", "loadSubPkgAppService has loaded.");
      return;
    }
    str = this.jdField_a_of_type_Bgod.d(str);
    if (TextUtils.isEmpty(str))
    {
      QMLog.e("AppBrandRuntime", "loadSubPkgAppService appServiceJsStr is null.");
      return;
    }
    this.jdField_a_of_type_Bhhq.a(str, new bhex(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhew
 * JD-Core Version:    0.7.0.1
 */