import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import org.json.JSONObject;

class bhff
  implements bghv<Void>
{
  bhff(bhfe parambhfe, String paramString) {}
  
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
      Object localObject = parambghl.a();
      if ((localObject != null) && (((AppBrandPage)localObject).a() != null)) {
        ((AppBrandPage)localObject).a().a((byte)0);
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("htmlId", this.jdField_a_of_type_Bhfe.a.a);
        ((JSONObject)localObject).put("src", this.jdField_a_of_type_JavaLangString);
        int i = bgie.a(InnerWebView.a(this.jdField_a_of_type_Bhfe.a)).a();
        if ((parambghl.a() != null) && (parambghl.a().a() != null))
        {
          parambghl.a().a().a("onWebviewStartLoad", ((JSONObject)localObject).toString(), i);
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
 * Qualified Name:     bhff
 * JD-Core Version:    0.7.0.1
 */