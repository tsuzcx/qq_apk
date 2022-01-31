import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bhgw
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bhgw(bhgv parambhgv) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    bhgv.a(this.a, 1.0F - f + bhgv.b(this.a));
    if (bhgv.a(this.a) == 0) {
      bhgv.a(this.a, Math.max(bhgv.c(this.a), Math.min(1.5F, bhgv.b(this.a))));
    }
    for (;;)
    {
      bhgv.b(this.a, bhgv.b(this.a) / bhgv.d(this.a));
      if (bhgv.a(this.a) != null) {
        bhgv.a(this.a).a(bhgv.b(this.a));
      }
      return true;
      bhgv.a(this.a, Math.max(bhgv.c(this.a), Math.min(1.0F, bhgv.b(this.a))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhgw
 * JD-Core Version:    0.7.0.1
 */