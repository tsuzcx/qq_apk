import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import org.json.JSONObject;

class bhfi
  implements bghv<Void>
{
  bhfi(bhfe parambhfe, String paramString) {}
  
  public Void a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (!(parambghl instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    for (;;)
    {
      return null;
      parambghl = (AppBrandPageContainer)parambghl;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("htmlId", this.jdField_a_of_type_Bhfe.a.a);
        localJSONObject.put("src", this.jdField_a_of_type_JavaLangString);
        int i = bgie.a(InnerWebView.a(this.jdField_a_of_type_Bhfe.a)).a();
        if ((parambghl.a() != null) && (parambghl.a().a() != null))
        {
          parambghl.a().a().a("onWebviewError", localJSONObject.toString(), i);
          return null;
        }
      }
      catch (Exception parambghl)
      {
        QMLog.e("Action", "onPageStarted error." + parambghl);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfi
 * JD-Core Version:    0.7.0.1
 */