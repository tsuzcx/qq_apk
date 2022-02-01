import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bmbo
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bmbo(bmbn parambmbn) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    bmbn.a(this.a, 1.0F - f + bmbn.b(this.a));
    if (bmbn.a(this.a) == 0) {
      bmbn.a(this.a, Math.max(bmbn.c(this.a), Math.min(1.5F, bmbn.b(this.a))));
    }
    for (;;)
    {
      bmbn.b(this.a, bmbn.b(this.a) / bmbn.d(this.a));
      if (bmbn.a(this.a) != null) {
        bmbn.a(this.a).a(bmbn.b(this.a));
      }
      return true;
      bmbn.a(this.a, Math.max(bmbn.c(this.a), Math.min(1.0F, bmbn.b(this.a))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbo
 * JD-Core Version:    0.7.0.1
 */