import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bfyl
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bfyl(bfyk parambfyk) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    bfyk.a(this.a, 1.0F - f + bfyk.b(this.a));
    if (bfyk.a(this.a) == 0) {
      bfyk.a(this.a, Math.max(bfyk.c(this.a), Math.min(1.5F, bfyk.b(this.a))));
    }
    for (;;)
    {
      bfyk.b(this.a, bfyk.b(this.a) / bfyk.d(this.a));
      if (bfyk.a(this.a) != null) {
        bfyk.a(this.a).a(bfyk.b(this.a));
      }
      return true;
      bfyk.a(this.a, Math.max(bfyk.c(this.a), Math.min(1.0F, bfyk.b(this.a))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfyl
 * JD-Core Version:    0.7.0.1
 */