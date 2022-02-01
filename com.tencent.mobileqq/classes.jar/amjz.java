import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class amjz
  implements Animation.AnimationListener
{
  public amjz(SpecailCareListActivity paramSpecailCareListActivity, amkn paramamkn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Amkn.a.getLayoutParams());
    paramAnimation.addRule(15);
    paramAnimation.setMargins((int)(12.0F * SpecailCareListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
    this.jdField_a_of_type_Amkn.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Amkn.a.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjz
 * JD-Core Version:    0.7.0.1
 */