import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class besg
  implements View.OnKeyListener
{
  besg(besf parambesf) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      besf.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besg
 * JD-Core Version:    0.7.0.1
 */