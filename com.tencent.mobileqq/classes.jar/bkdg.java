import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class bkdg
  implements View.OnKeyListener
{
  bkdg(bkdd parambkdd) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 4)) {
      this.a.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdg
 * JD-Core Version:    0.7.0.1
 */