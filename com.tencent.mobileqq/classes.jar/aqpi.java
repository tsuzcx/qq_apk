import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aqpi
  implements View.OnTouchListener
{
  aqpi(aqph paramaqph) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      aqph.a(this.a, paramMotionEvent.getY());
      mvd.a(paramView, 0.5F);
    }
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
        if (paramMotionEvent.getAction() != 1) {
          break label101;
        }
        mvd.a(paramView, 1.0F);
        aqph.b(this.a, paramMotionEvent.getY());
        if (aqph.a(this.a) - aqph.b(this.a) <= 50.0F) {
          break;
        }
      } while (aqph.a(this.a) == null);
      aqph.a(this.a).c();
      return true;
      label101:
      if (paramMotionEvent.getAction() == 3) {
        mvd.a(paramView, 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpi
 * JD-Core Version:    0.7.0.1
 */