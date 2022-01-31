import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.widget.MiniAppTextArea;

public class bfcw
  implements View.OnFocusChangeListener
{
  public bfcw(MiniAppTextArea paramMiniAppTextArea) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!MiniAppTextArea.a(this.a))
    {
      if (!paramBoolean) {
        break label98;
      }
      localInputMethodManager = (InputMethodManager)MiniAppTextArea.a(this.a).getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(paramView, 0);
      }
      if (MiniAppTextArea.b(this.a))
      {
        i = MiniAppTextArea.a(this.a);
        j = MiniAppTextArea.b(this.a);
        k = MiniAppTextArea.c(this.a);
        MiniAppTextArea.a(this.a, i - j - k);
      }
    }
    label98:
    while (!MiniAppTextArea.b(this.a))
    {
      InputMethodManager localInputMethodManager;
      int i;
      int j;
      int k;
      return;
    }
    MiniAppTextArea.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcw
 * JD-Core Version:    0.7.0.1
 */