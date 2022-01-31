import android.app.Activity;
import android.content.Context;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.widget.MiniAppTextArea;
import org.json.JSONException;
import org.json.JSONObject;

public class bfci
  implements belg
{
  public bfci(MiniAppTextArea paramMiniAppTextArea) {}
  
  public void onSoftKeyboardClosed()
  {
    MiniAppTextArea.a(this.a, false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = null;
    try
    {
      PageWebviewContainer localPageWebviewContainer;
      Object localObject;
      int i;
      if (MiniAppTextArea.a(this.a) != null)
      {
        localPageWebviewContainer = MiniAppTextArea.a(this.a).a();
        MiniAppTextArea.a(this.a).setCurInputId(MiniAppTextArea.d(this.a));
        MiniAppTextArea.a(this.a, paramInt);
        localObject = localMiniAppTextArea;
        if (MiniAppTextArea.a(this.a) != null)
        {
          localObject = localMiniAppTextArea;
          if (MiniAppTextArea.a(this.a).a() != null) {
            localObject = MiniAppTextArea.a(this.a).a().a();
          }
        }
        if ((bffu.a((Context)localObject)) && (bffu.a((Activity)localObject)))
        {
          localMiniAppTextArea = this.a;
          paramInt = MiniAppTextArea.b(this.a);
          MiniAppTextArea.a(localMiniAppTextArea, bffu.c((Context)localObject) + paramInt);
        }
        MiniAppTextArea.c(this.a);
        if (this.a.isFocused())
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("inputId", MiniAppTextArea.d(this.a));
          i = MiniAppTextArea.b(this.a);
          if (!MiniAppTextArea.b(this.a)) {
            break label250;
          }
        }
      }
      label250:
      for (paramInt = MiniAppTextArea.c(this.a);; paramInt = 0)
      {
        ((JSONObject)localObject).put("height", (int)((paramInt + i) / bffu.a(this.a.getContext()) + 0.5F));
        localPageWebviewContainer.b("onKeyboardShow", ((JSONObject)localObject).toString());
        return;
        localPageWebviewContainer = null;
        break;
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
 * Qualified Name:     bfci
 * JD-Core Version:    0.7.0.1
 */