import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.Button;
import android.widget.ImageView;
import dov.com.qq.im.ae.AECMShowCameraUnit.6;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;

public class bmvo
  implements ValueAnimator.AnimatorUpdateListener
{
  public bmvo(AECMShowCameraUnit.6 param6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    bmvk.a(this.a.this$0).setAlpha(paramValueAnimator.floatValue());
    bmvk.a(this.a.this$0).setAlpha(paramValueAnimator.floatValue() * 255.0F);
    bmvk.a(this.a.this$0).setAlpha(1.0F - paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvo
 * JD-Core Version:    0.7.0.1
 */