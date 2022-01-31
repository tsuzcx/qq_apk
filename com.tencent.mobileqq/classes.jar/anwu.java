import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class anwu
  implements ValueAnimator.AnimatorUpdateListener
{
  public anwu(QIMCameraSegmentCaptureButtonLayout paramQIMCameraSegmentCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.b = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwu
 * JD-Core Version:    0.7.0.1
 */