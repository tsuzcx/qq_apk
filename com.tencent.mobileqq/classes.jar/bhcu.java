import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class bhcu
  implements bgln
{
  public bhcu(bhcq parambhcq) {}
  
  public void onSoftKeyboardClosed()
  {
    if (bhcq.c(this.a) != 0)
    {
      bgkq.a(bhcq.a(this.a).a(), bhcq.c(this.a), 0.0F, 1.0F, 1.0F);
      bhcq.b(this.a, 0);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)bhcq.a(this.a).getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(bhcq.a(this.a).getWindowToken(), 0);
    this.a.a(true);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    try
    {
      bhcq.a(this.a, paramInt);
      if ((bhcq.a(this.a) != null) && (bhcq.a(this.a).a() != null)) {}
      for (Object localObject = bhcq.a(this.a).a().a();; localObject = null)
      {
        if ((localObject != null) && (DisplayUtil.hasNavBar((Context)localObject)) && (DisplayUtil.isNavigationBarExist((Activity)localObject))) {
          bhcq.a(this.a, bhcq.b(this.a) + DisplayUtil.getNavigationBarHeight(bhcq.a(this.a).a().a()));
        }
        bhcq.a(this.a);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("inputId", bhcq.a(this.a));
        ((JSONObject)localObject).put("height", paramInt);
        if ((bhcq.a(this.a) != null) && (bhcq.a(this.a).a() != null)) {
          bhcq.a(this.a).a().b("onKeyboardShow", ((JSONObject)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcu
 * JD-Core Version:    0.7.0.1
 */