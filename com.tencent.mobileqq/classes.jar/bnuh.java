import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bnuh
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bnuh(bnud parambnud) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if (bnud.a(this.a) != null) {
      bnud.a(this.a).a("onActionScale", new float[] { f });
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnuh
 * JD-Core Version:    0.7.0.1
 */