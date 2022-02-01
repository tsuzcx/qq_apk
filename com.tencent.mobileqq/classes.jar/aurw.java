import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.DispatchKeyEventListener;

class aurw
  implements EmoticonMainPanel.DispatchKeyEventListener
{
  aurw(aurs paramaurs) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (aurs.a(this.a)))
    {
      aurs.a(this.a).removeView(aurs.a(this.a));
      aurs.a(this.a, false);
      paramKeyEvent = this.a.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.a.getWindow().setAttributes(paramKeyEvent);
      aurs.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurw
 * JD-Core Version:    0.7.0.1
 */