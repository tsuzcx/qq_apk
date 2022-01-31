import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

class arwp
  implements apqc
{
  arwp(arwl paramarwl) {}
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (arwl.a(this.a)))
    {
      arwl.a(this.a).removeView(arwl.a(this.a));
      arwl.a(this.a, false);
      paramKeyEvent = this.a.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.a.getWindow().setAttributes(paramKeyEvent);
      arwl.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwp
 * JD-Core Version:    0.7.0.1
 */