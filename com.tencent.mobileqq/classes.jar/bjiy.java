import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bjiy
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bjiy(bjix parambjix) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    bjix.a(this.a, 1.0F - f + bjix.b(this.a));
    if (bjix.a(this.a) == 0) {
      bjix.a(this.a, Math.max(bjix.c(this.a), Math.min(1.5F, bjix.b(this.a))));
    }
    for (;;)
    {
      bjix.b(this.a, bjix.b(this.a) / bjix.d(this.a));
      if (bjix.a(this.a) != null) {
        bjix.a(this.a).a(bjix.b(this.a));
      }
      return true;
      bjix.a(this.a, Math.max(bjix.c(this.a), Math.min(1.0F, bjix.b(this.a))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjiy
 * JD-Core Version:    0.7.0.1
 */