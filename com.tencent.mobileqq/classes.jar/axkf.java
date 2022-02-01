import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class axkf
  extends AnimatorListenerAdapter
{
  public axkf(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiAIOFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment, this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiAIOFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment, this.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkf
 * JD-Core Version:    0.7.0.1
 */