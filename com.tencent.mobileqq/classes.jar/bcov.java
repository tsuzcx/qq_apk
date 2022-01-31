import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class bcov
  implements View.OnKeyListener
{
  bcov(bcou parambcou) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      bcou.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcov
 * JD-Core Version:    0.7.0.1
 */