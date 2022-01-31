import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class benx
  implements View.OnKeyListener
{
  benx(benw parambenw) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      benw.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benx
 * JD-Core Version:    0.7.0.1
 */