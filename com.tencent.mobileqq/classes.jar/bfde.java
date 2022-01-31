import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import org.json.JSONException;
import org.json.JSONObject;

public class bfde
  implements belx
{
  public bfde(bfda parambfda) {}
  
  public void onSoftKeyboardClosed()
  {
    if (bfda.c(this.a) != 0)
    {
      bele.a(bfda.a(this.a).a(), bfda.c(this.a), 0.0F, 1.0F, 1.0F);
      bfda.b(this.a, 0);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)bfda.a(this.a).getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(bfda.a(this.a).getWindowToken(), 0);
    this.a.a(true);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    try
    {
      bfda.a(this.a, paramInt);
      if ((bfda.a(this.a) != null) && (bfda.a(this.a).a() != null)) {}
      for (Object localObject = bfda.a(this.a).a().a();; localObject = null)
      {
        if ((localObject != null) && (bfgl.a((Context)localObject)) && (bfgl.a((Activity)localObject))) {
          bfda.a(this.a, bfda.b(this.a) + bfgl.c(bfda.a(this.a).a().a()));
        }
        bfda.a(this.a);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("inputId", bfda.a(this.a));
        ((JSONObject)localObject).put("height", paramInt);
        if ((bfda.a(this.a) != null) && (bfda.a(this.a).a() != null)) {
          bfda.a(this.a).a().b("onKeyboardShow", ((JSONObject)localObject).toString());
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
 * Qualified Name:     bfde
 * JD-Core Version:    0.7.0.1
 */