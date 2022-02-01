import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;

public class aote
  implements ValueAnimator.AnimatorUpdateListener
{
  public aote(ARVideoRecordButtonView paramARVideoRecordButtonView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    ARVideoRecordButtonView.b(this.a, paramValueAnimator.floatValue());
    ARVideoRecordButtonView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aote
 * JD-Core Version:    0.7.0.1
 */