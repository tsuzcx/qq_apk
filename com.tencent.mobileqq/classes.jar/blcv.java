import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class blcv
  implements View.OnKeyListener
{
  blcv(blcs paramblcs) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 4)) {
      this.a.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcv
 * JD-Core Version:    0.7.0.1
 */