import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import org.json.JSONObject;

class bhjm
  implements bgmc<Void>
{
  bhjm(bhjl parambhjl, String paramString) {}
  
  public Void a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    for (;;)
    {
      return null;
      parambgls = (AppBrandPageContainer)parambgls;
      Object localObject = parambgls.a();
      if ((localObject != null) && (((AppBrandPage)localObject).a() != null)) {
        ((AppBrandPage)localObject).a().a((byte)0);
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("htmlId", this.jdField_a_of_type_Bhjl.a.a);
        ((JSONObject)localObject).put("src", this.jdField_a_of_type_JavaLangString);
        int i = bgml.a(InnerWebView.a(this.jdField_a_of_type_Bhjl.a)).a();
        if ((parambgls.a() != null) && (parambgls.a().a() != null))
        {
          parambgls.a().a().a("onWebviewStartLoad", ((JSONObject)localObject).toString(), i);
          return null;
        }
      }
      catch (Exception parambgls)
      {
        QMLog.e("Action", "onPageStarted error." + parambgls);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjm
 * JD-Core Version:    0.7.0.1
 */