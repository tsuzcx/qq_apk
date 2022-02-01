import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;

public class awtg
  extends GestureDetector.SimpleOnGestureListener
{
  private awtg(StuffContainerView paramStuffContainerView) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.a.a == null) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f2;
    if ((paramMotionEvent2 != null) && (paramMotionEvent1 != null))
    {
      float f1 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      f2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
      if (Math.abs(f1) <= Math.abs(f2)) {
        break label143;
      }
      if (Math.abs(Math.asin(Math.abs(f2) / Math.sqrt(f2 * f2 + f1 * f1))) < 0.5235987755982988D)
      {
        if (f1 >= 0.0F) {
          break label128;
        }
        this.a.a.g();
      }
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label128:
      this.a.a.j();
      continue;
      label143:
      if (f2 > 0.0F) {
        this.a.a.h();
      } else {
        this.a.a.i();
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.f();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtg
 * JD-Core Version:    0.7.0.1
 */