import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.open.agent.CardContainer;

public class bdae
  implements ValueAnimator.AnimatorUpdateListener
{
  public bdae(CardContainer paramCardContainer, ImageView paramImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = i;
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdae
 * JD-Core Version:    0.7.0.1
 */