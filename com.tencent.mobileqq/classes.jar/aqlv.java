import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aqlv
  implements View.OnTouchListener
{
  aqlv(aqlu paramaqlu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      aqlu.a(this.a, paramMotionEvent.getY());
      mvk.a(paramView, 0.5F);
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
        mvk.a(paramView, 1.0F);
        aqlu.b(this.a, paramMotionEvent.getY());
        if (aqlu.a(this.a) - aqlu.b(this.a) <= 50.0F) {
          break;
        }
      } while (aqlu.a(this.a) == null);
      aqlu.a(this.a).c();
      return true;
      label101:
      if (paramMotionEvent.getAction() == 3) {
        mvk.a(paramView, 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlv
 * JD-Core Version:    0.7.0.1
 */