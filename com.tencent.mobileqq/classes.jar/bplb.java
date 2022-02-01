import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class bplb
  implements GestureDetector.OnGestureListener
{
  bplb(bpla parambpla) {}
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (bpla.a(this.a) != null) {
      bpla.a(this.a).a();
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
        bpla.a(this.a, bpla.a(this.a) + paramFloat1);
        if (bpla.a(this.a) < bpla.b(this.a)) {
          bpla.a(this.a, bpla.b(this.a));
        }
        if (bpla.a(this.a) > bpla.c(this.a)) {
          bpla.a(this.a, bpla.c(this.a));
        }
        paramFloat1 = bpla.a(this.a);
        paramFloat2 = bpla.d(this.a);
        bpla.b(this.a, bpla.a(this.a));
        if (a(paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      if (bpla.a(this.a) != null) {
        bpla.a(this.a).a();
      }
    } while (bpla.a(this.a) == null);
    bpla.a(this.a).a(this.a.f(), this.a.g());
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bplb
 * JD-Core Version:    0.7.0.1
 */