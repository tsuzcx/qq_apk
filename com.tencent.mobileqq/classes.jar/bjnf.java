import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bjnf
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bjnf(bjne parambjne) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    bjne.a(this.a, 1.0F - f + bjne.b(this.a));
    if (bjne.a(this.a) == 0) {
      bjne.a(this.a, Math.max(bjne.c(this.a), Math.min(1.5F, bjne.b(this.a))));
    }
    for (;;)
    {
      bjne.b(this.a, bjne.b(this.a) / bjne.d(this.a));
      if (bjne.a(this.a) != null) {
        bjne.a(this.a).a(bjne.b(this.a));
      }
      return true;
      bjne.a(this.a, Math.max(bjne.c(this.a), Math.min(1.0F, bjne.b(this.a))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjnf
 * JD-Core Version:    0.7.0.1
 */