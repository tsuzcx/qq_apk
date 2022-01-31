import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView.1.1;

public class bhjf
  implements bgmc<Void>
{
  public bhjf(InnerWebView.1.1 param1) {}
  
  public Void a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    int i;
    do
    {
      return null;
      parambgls = (AppBrandPageContainer)parambgls;
      i = parambgls.d();
      bool = parambgls.c();
      parambgls = parambgls.a();
    } while ((parambgls == null) || (parambgls.a() == null));
    parambgls = parambgls.a();
    if ((!bool) && ((i > 1) || (this.a.jdField_a_of_type_Bhje.a.canGoBack()))) {}
    for (boolean bool = true;; bool = false)
    {
      parambgls.a(bool).c(this.a.jdField_a_of_type_JavaLangString);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjf
 * JD-Core Version:    0.7.0.1
 */