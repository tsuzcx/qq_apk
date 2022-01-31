import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.open.agent.OpenCardContainer;

public class bbxz
  extends AnimatorListenerAdapter
{
  public bbxz(OpenCardContainer paramOpenCardContainer, ImageView paramImageView) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = -1;
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbxz
 * JD-Core Version:    0.7.0.1
 */