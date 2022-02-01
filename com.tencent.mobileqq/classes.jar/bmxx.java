import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class bmxx
  extends GestureDetector.SimpleOnGestureListener
{
  protected bmxx(bmxa parambmxa) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((!bmxa.a(this.a)) && (System.currentTimeMillis() - bmxa.a(this.a) > 5000L))
    {
      this.a.a.a(196614, new Object[0]);
      bmxa.a(this.a, System.currentTimeMillis());
      this.a.e(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxx
 * JD-Core Version:    0.7.0.1
 */