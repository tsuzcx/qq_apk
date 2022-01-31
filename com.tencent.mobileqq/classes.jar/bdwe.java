import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import org.json.JSONException;
import org.json.JSONObject;

public class bdwe
  implements bdhd
{
  public bdwe(bdwa parambdwa) {}
  
  public void onSoftKeyboardClosed()
  {
    if (bdwa.c(this.a) != 0)
    {
      bdgl.a(bdwa.a(this.a).a(), bdwa.c(this.a), 0.0F, 1.0F, 1.0F);
      bdwa.b(this.a, 0);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)bdwa.a(this.a).getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(bdwa.a(this.a).getWindowToken(), 0);
    this.a.a(true);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    try
    {
      bdwa.a(this.a, paramInt);
      if ((bdwa.a(this.a) != null) && (bdwa.a(this.a).a() != null)) {}
      for (Object localObject = bdwa.a(this.a).a().a();; localObject = null)
      {
        if ((localObject != null) && (bdyn.a((Context)localObject)) && (bdyn.a((Activity)localObject))) {
          bdwa.a(this.a, bdwa.b(this.a) + bdyn.c(bdwa.a(this.a).a().a()));
        }
        bdwa.a(this.a);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("inputId", bdwa.a(this.a));
        ((JSONObject)localObject).put("height", paramInt);
        if ((bdwa.a(this.a) != null) && (bdwa.a(this.a).a() != null)) {
          bdwa.a(this.a).a().b("onKeyboardShow", ((JSONObject)localObject).toString());
        }
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdwe
 * JD-Core Version:    0.7.0.1
 */