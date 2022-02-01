import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;

public class azpn
  implements Animator.AnimatorListener
{
  public azpn(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ObjectAnimator paramObjectAnimator) {}
  
  private ImageView a(ObjectAnimator paramObjectAnimator)
  {
    return (ImageView)paramObjectAnimator.getTarget();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = a(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
    if (paramAnimator != null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b) {
        break label37;
      }
    }
    label37:
    for (int i = 2130845636;; i = 2130845628)
    {
      paramAnimator.setImageResource(i);
      paramAnimator.setRotation(0.0F);
      return;
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = a(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
    if (paramAnimator != null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b) {
        break label37;
      }
    }
    label37:
    for (int i = 2130845636;; i = 2130845628)
    {
      paramAnimator.setImageResource(i);
      paramAnimator.setRotation(0.0F);
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpn
 * JD-Core Version:    0.7.0.1
 */