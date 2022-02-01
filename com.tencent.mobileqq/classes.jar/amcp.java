import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class amcp
  implements Animation.AnimationListener
{
  public amcp(SpecailCareListActivity paramSpecailCareListActivity, amdg paramamdg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Amdg.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131368381);
    paramAnimation.setMargins(0, (int)(24.0F * SpecailCareListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
    this.jdField_a_of_type_Amdg.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Amdg.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcp
 * JD-Core Version:    0.7.0.1
 */