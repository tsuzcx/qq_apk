import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class brfl
  implements ValueAnimator.AnimatorUpdateListener
{
  public brfl(QIMCameraSegmentCaptureButtonLayout paramQIMCameraSegmentCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brfl
 * JD-Core Version:    0.7.0.1
 */