import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import org.json.JSONObject;

class bhjp
  implements bgmc<Void>
{
  bhjp(bhjl parambhjl, String paramString) {}
  
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
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("htmlId", this.jdField_a_of_type_Bhjl.a.a);
        localJSONObject.put("src", this.jdField_a_of_type_JavaLangString);
        int i = bgml.a(InnerWebView.a(this.jdField_a_of_type_Bhjl.a)).a();
        if ((parambgls.a() != null) && (parambgls.a().a() != null))
        {
          parambgls.a().a().a("onWebviewError", localJSONObject.toString(), i);
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
 * Qualified Name:     bhjp
 * JD-Core Version:    0.7.0.1
 */