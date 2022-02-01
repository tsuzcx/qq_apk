import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class aqkj
  implements View.OnKeyListener
{
  aqkj(aqki paramaqki) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkj
 * JD-Core Version:    0.7.0.1
 */