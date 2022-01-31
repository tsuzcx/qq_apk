import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class biiv
  extends GestureDetector.SimpleOnGestureListener
{
  private biiv(biim parambiim) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((biim.a(this.a) != bivx.c) && (System.currentTimeMillis() - biim.a(this.a) > 5000L))
    {
      biim.a(this.a).a(196614, new Object[0]);
      biim.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biiv
 * JD-Core Version:    0.7.0.1
 */