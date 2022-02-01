import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class bmnx
  implements GestureDetector.OnGestureListener
{
  bmnx(bmnw parambmnw) {}
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (bmnw.a(this.a) != null) {
      bmnw.a(this.a).a();
    }
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    do
    {
      synchronized (this.a)
      {
        bmnw.a(this.a, bmnw.a(this.a) + paramFloat1);
        if (bmnw.a(this.a) < bmnw.b(this.a)) {
          bmnw.a(this.a, bmnw.b(this.a));
        }
        if (bmnw.a(this.a) > bmnw.c(this.a)) {
          bmnw.a(this.a, bmnw.c(this.a));
        }
        paramFloat1 = bmnw.a(this.a);
        paramFloat2 = bmnw.d(this.a);
        bmnw.b(this.a, bmnw.a(this.a));
        if (a(paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      if (bmnw.a(this.a) != null) {
        bmnw.a(this.a).a();
      }
    } while (bmnw.a(this.a) == null);
    bmnw.a(this.a).a(this.a.f(), this.a.g());
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnx
 * JD-Core Version:    0.7.0.1
 */