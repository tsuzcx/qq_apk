import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class aufz
  extends AnimatorListenerAdapter
{
  public aufz(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aufz
 * JD-Core Version:    0.7.0.1
 */