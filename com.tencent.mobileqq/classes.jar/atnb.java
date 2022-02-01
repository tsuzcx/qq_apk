import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.DispatchKeyEventListener;

class atnb
  implements EmoticonMainPanel.DispatchKeyEventListener
{
  atnb(atmx paramatmx) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (atmx.a(this.a)))
    {
      atmx.a(this.a).removeView(atmx.a(this.a));
      atmx.a(this.a, false);
      paramKeyEvent = this.a.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.a.getWindow().setAttributes(paramKeyEvent);
      atmx.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnb
 * JD-Core Version:    0.7.0.1
 */