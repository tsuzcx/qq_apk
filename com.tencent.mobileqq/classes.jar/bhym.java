import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class bhym
  implements ScaleGestureDetector.OnScaleGestureListener
{
  bhym(bhyi parambhyi) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if (bhyi.a(this.a) != null) {
      bhyi.a(this.a).a("onActionScale", new float[] { f });
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhym
 * JD-Core Version:    0.7.0.1
 */