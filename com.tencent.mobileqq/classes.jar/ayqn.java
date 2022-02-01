import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.profile.view.BreatheEffectView;

public class ayqn
  implements ValueAnimator.AnimatorUpdateListener
{
  public ayqn(BreatheEffectView paramBreatheEffectView, Drawable paramDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Rect)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramValueAnimator);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.invalidate(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqn
 * JD-Core Version:    0.7.0.1
 */