import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class apir
  implements View.OnTouchListener
{
  apir(apiq paramapiq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      apiq.a(this.a, paramMotionEvent.getY());
      mum.a(paramView, 0.5F);
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
        mum.a(paramView, 1.0F);
        apiq.b(this.a, paramMotionEvent.getY());
        if (apiq.a(this.a) - apiq.b(this.a) <= 50.0F) {
          break;
        }
      } while (apiq.a(this.a) == null);
      apiq.a(this.a).c();
      return true;
      label101:
      if (paramMotionEvent.getAction() == 3) {
        mum.a(paramView, 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apir
 * JD-Core Version:    0.7.0.1
 */