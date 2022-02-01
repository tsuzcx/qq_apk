import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.open.agent.CardContainer;

public class bjlt
  extends AnimatorListenerAdapter
{
  public bjlt(CardContainer paramCardContainer, ImageView paramImageView) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = -1;
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjlt
 * JD-Core Version:    0.7.0.1
 */