import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.open.agent.OpenCardContainer;

public class bffu
  implements ValueAnimator.AnimatorUpdateListener
{
  public bffu(OpenCardContainer paramOpenCardContainer, ImageView paramImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = i;
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffu
 * JD-Core Version:    0.7.0.1
 */