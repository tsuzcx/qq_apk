import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class bijm
  extends GestureDetector.SimpleOnGestureListener
{
  private bijm(bijd parambijd) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((bijd.a(this.a) != biwo.c) && (System.currentTimeMillis() - bijd.a(this.a) > 5000L))
    {
      bijd.a(this.a).a(196614, new Object[0]);
      bijd.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijm
 * JD-Core Version:    0.7.0.1
 */