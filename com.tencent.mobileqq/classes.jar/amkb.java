import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class amkb
  implements Animation.AnimationListener
{
  public amkb(SpecailCareListActivity paramSpecailCareListActivity, amkn paramamkn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Amkn.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131368212);
    paramAnimation.setMargins(0, (int)(36.0F * SpecailCareListActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), (int)(30.0F * SpecailCareListActivity.j(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
    this.jdField_a_of_type_Amkn.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Amkn.a.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkb
 * JD-Core Version:    0.7.0.1
 */