import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class bhhb
  implements bgpu
{
  public bhhb(bhgx parambhgx) {}
  
  public void onSoftKeyboardClosed()
  {
    if (bhgx.c(this.a) != 0)
    {
      bgox.a(bhgx.a(this.a).a(), bhgx.c(this.a), 0.0F, 1.0F, 1.0F);
      bhgx.b(this.a, 0);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)bhgx.a(this.a).getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(bhgx.a(this.a).getWindowToken(), 0);
    this.a.a(true);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    try
    {
      bhgx.a(this.a, paramInt);
      if ((bhgx.a(this.a) != null) && (bhgx.a(this.a).a() != null)) {}
      for (Object localObject = bhgx.a(this.a).a().a();; localObject = null)
      {
        if ((localObject != null) && (DisplayUtil.hasNavBar((Context)localObject)) && (DisplayUtil.isNavigationBarExist((Activity)localObject))) {
          bhgx.a(this.a, bhgx.b(this.a) + DisplayUtil.getNavigationBarHeight(bhgx.a(this.a).a().a()));
        }
        bhgx.a(this.a);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("inputId", bhgx.a(this.a));
        ((JSONObject)localObject).put("height", paramInt);
        if ((bhgx.a(this.a) != null) && (bhgx.a(this.a).a() != null)) {
          bhgx.a(this.a).a().b("onKeyboardShow", ((JSONObject)localObject).toString());
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
 * Qualified Name:     bhhb
 * JD-Core Version:    0.7.0.1
 */