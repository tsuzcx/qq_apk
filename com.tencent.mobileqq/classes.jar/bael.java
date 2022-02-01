import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;

public class bael
  extends AnimatorListenerAdapter
{
  public bael(VasProfileTagView paramVasProfileTagView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VasProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
    this.jdField_a_of_type_AndroidViewView.setTranslationY(0.0F);
    VasProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView, false);
    if (VasProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView) == 0) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView.b();
    }
    VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView, VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bael
 * JD-Core Version:    0.7.0.1
 */