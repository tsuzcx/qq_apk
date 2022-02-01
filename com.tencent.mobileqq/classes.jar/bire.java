import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class bire
  implements View.OnKeyListener
{
  bire(bird parambird) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      bird.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bire
 * JD-Core Version:    0.7.0.1
 */