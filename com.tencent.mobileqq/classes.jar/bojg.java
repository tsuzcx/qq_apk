import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class bojg
  implements GestureDetector.OnGestureListener
{
  bojg(bojf parambojf) {}
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (bojf.a(this.a) != null) {
      bojf.a(this.a).a();
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
        bojf.a(this.a, bojf.a(this.a) + paramFloat1);
        if (bojf.a(this.a) < bojf.b(this.a)) {
          bojf.a(this.a, bojf.b(this.a));
        }
        if (bojf.a(this.a) > bojf.c(this.a)) {
          bojf.a(this.a, bojf.c(this.a));
        }
        paramFloat1 = bojf.a(this.a);
        paramFloat2 = bojf.d(this.a);
        bojf.b(this.a, bojf.a(this.a));
        if (a(paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      if (bojf.a(this.a) != null) {
        bojf.a(this.a).a();
      }
    } while (bojf.a(this.a) == null);
    bojf.a(this.a).a(this.a.f(), this.a.g());
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojg
 * JD-Core Version:    0.7.0.1
 */