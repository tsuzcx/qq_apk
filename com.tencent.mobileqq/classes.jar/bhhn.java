import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bhhn
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bhhn(bhhm parambhhm) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    bhhm.a(this.a, 1.0F - f + bhhm.b(this.a));
    if (bhhm.a(this.a) == 0) {
      bhhm.a(this.a, Math.max(bhhm.c(this.a), Math.min(1.5F, bhhm.b(this.a))));
    }
    for (;;)
    {
      bhhm.b(this.a, bhhm.b(this.a) / bhhm.d(this.a));
      if (bhhm.a(this.a) != null) {
        bhhm.a(this.a).a(bhhm.b(this.a));
      }
      return true;
      bhhm.a(this.a, Math.max(bhhm.c(this.a), Math.min(1.0F, bhhm.b(this.a))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhhn
 * JD-Core Version:    0.7.0.1
 */