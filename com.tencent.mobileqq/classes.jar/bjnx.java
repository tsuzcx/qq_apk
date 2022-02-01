import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.open.agent.OpenCardContainer;

public class bjnx
  implements ValueAnimator.AnimatorUpdateListener
{
  public bjnx(OpenCardContainer paramOpenCardContainer, ImageView paramImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = i;
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjnx
 * JD-Core Version:    0.7.0.1
 */