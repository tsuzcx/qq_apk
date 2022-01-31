import android.view.KeyEvent;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout.DispatchKeyEventListener;

class bdhg
  implements MyLinearLayout.DispatchKeyEventListener
{
  bdhg(bdhc parambdhc) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.b))
    {
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhg
 * JD-Core Version:    0.7.0.1
 */