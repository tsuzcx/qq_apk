import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bncq
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bncq(bncp parambncp) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    bncp.a(this.a, 1.0F - f + bncp.b(this.a));
    if (bncp.a(this.a) == 0) {
      bncp.a(this.a, Math.max(bncp.c(this.a), Math.min(1.5F, bncp.b(this.a))));
    }
    for (;;)
    {
      bncp.b(this.a, bncp.b(this.a) / bncp.d(this.a));
      if (bncp.a(this.a) != null) {
        bncp.a(this.a).a(bncp.b(this.a));
      }
      return true;
      bncp.a(this.a, Math.max(bncp.c(this.a), Math.min(1.0F, bncp.b(this.a))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncq
 * JD-Core Version:    0.7.0.1
 */