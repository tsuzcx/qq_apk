import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;

public class bexi
  implements ValueAnimator.AnimatorUpdateListener
{
  public bexi(FloatingScreenContainer paramFloatingScreenContainer, WindowManager.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.alpha = (paramValueAnimator.floatValue() * 1.0F + 0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexi
 * JD-Core Version:    0.7.0.1
 */