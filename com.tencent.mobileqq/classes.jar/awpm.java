import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import java.util.HashSet;

public class awpm
  implements Animator.AnimatorListener
{
  public awpm(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, awpp paramawpp, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.remove(Long.valueOf(this.jdField_a_of_type_Awpp.a));
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.remove(Long.valueOf(this.jdField_a_of_type_Awpp.a));
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpm
 * JD-Core Version:    0.7.0.1
 */