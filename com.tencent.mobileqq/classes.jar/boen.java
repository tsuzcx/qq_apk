import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import dov.com.qq.im.aeeditor.view.timebar.ScaleView;

public class boen
  implements ScaleGestureDetector.OnScaleGestureListener
{
  public boen(ScaleView paramScaleView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.a.a(paramScaleGestureDetector.getScaleFactor());
    if (ScaleView.a(this.a) != null) {
      ScaleView.a(this.a).a();
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
 * Qualified Name:     boen
 * JD-Core Version:    0.7.0.1
 */