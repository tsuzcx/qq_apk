import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import org.json.JSONException;
import org.json.JSONObject;

public class bfcn
  implements belg
{
  public bfcn(bfcj parambfcj) {}
  
  public void onSoftKeyboardClosed()
  {
    if (bfcj.c(this.a) != 0)
    {
      bekn.a(bfcj.a(this.a).a(), bfcj.c(this.a), 0.0F, 1.0F, 1.0F);
      bfcj.b(this.a, 0);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)bfcj.a(this.a).getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(bfcj.a(this.a).getWindowToken(), 0);
    this.a.a(true);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    try
    {
      bfcj.a(this.a, paramInt);
      if ((bfcj.a(this.a) != null) && (bfcj.a(this.a).a() != null)) {}
      for (Object localObject = bfcj.a(this.a).a().a();; localObject = null)
      {
        if ((localObject != null) && (bffu.a((Context)localObject)) && (bffu.a((Activity)localObject))) {
          bfcj.a(this.a, bfcj.b(this.a) + bffu.c(bfcj.a(this.a).a().a()));
        }
        bfcj.a(this.a);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("inputId", bfcj.a(this.a));
        ((JSONObject)localObject).put("height", paramInt);
        if ((bfcj.a(this.a) != null) && (bfcj.a(this.a).a() != null)) {
          bfcj.a(this.a).a().b("onKeyboardShow", ((JSONObject)localObject).toString());
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
 * Qualified Name:     bfcn
 * JD-Core Version:    0.7.0.1
 */