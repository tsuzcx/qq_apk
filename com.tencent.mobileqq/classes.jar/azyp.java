import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;

public class azyp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private azyp(InputMethodGuard paramInputMethodGuard) {}
  
  private int a()
  {
    if (axlk.b > 0) {
      return axlk.b;
    }
    return ((WindowManager)this.a.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  public void onGlobalLayout()
  {
    boolean bool = InputMethodGuard.a(this.a);
    Rect localRect = new Rect();
    ((Activity)this.a.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = a();
    int j = i - localRect.bottom;
    if (Math.abs(j) > i / 5)
    {
      InputMethodGuard.a(this.a, true);
      InputMethodGuard.a(this.a, j);
    }
    for (;;)
    {
      if ((InputMethodGuard.a(this.a) != null) && ((bool != InputMethodGuard.a(this.a)) || (InputMethodGuard.b(this.a)))) {
        InputMethodGuard.a(this.a).a(InputMethodGuard.a(this.a), InputMethodGuard.a(this.a));
      }
      if (InputMethodGuard.b(this.a)) {
        InputMethodGuard.b(this.a, false);
      }
      return;
      InputMethodGuard.a(this.a, false);
      InputMethodGuard.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azyp
 * JD-Core Version:    0.7.0.1
 */