import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;

public class ayuk
  implements GestureDetector.OnGestureListener
{
  public ayuk(OverCoverFrameLayout paramOverCoverFrameLayout) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) <= this.a.e) {}
    while ((this.a.a != null) && (this.a.a.a())) {
      return false;
    }
    if (paramFloat2 < 0.0F) {
      this.a.a();
    }
    for (;;)
    {
      return true;
      this.a.b();
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) <= this.a.d) {}
    while ((this.a.a != null) && (this.a.a.a())) {
      return false;
    }
    if (paramFloat2 > 0.0F) {
      this.a.a();
    }
    for (;;)
    {
      return true;
      this.a.b();
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuk
 * JD-Core Version:    0.7.0.1
 */