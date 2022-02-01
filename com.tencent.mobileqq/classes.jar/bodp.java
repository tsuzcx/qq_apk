import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class bodp
  implements GestureDetector.OnGestureListener
{
  bodp(bodo parambodo) {}
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (bodo.a(this.a) != null) {
      bodo.a(this.a).a();
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
        bodo.a(this.a, bodo.a(this.a) + paramFloat1);
        if (bodo.a(this.a) < bodo.b(this.a)) {
          bodo.a(this.a, bodo.b(this.a));
        }
        if (bodo.a(this.a) > bodo.c(this.a)) {
          bodo.a(this.a, bodo.c(this.a));
        }
        paramFloat1 = bodo.a(this.a);
        paramFloat2 = bodo.d(this.a);
        bodo.b(this.a, bodo.a(this.a));
        if (a(paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      if (bodo.a(this.a) != null) {
        bodo.a(this.a).a();
      }
    } while (bodo.a(this.a) == null);
    bodo.a(this.a).a(this.a.f(), this.a.g());
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodp
 * JD-Core Version:    0.7.0.1
 */