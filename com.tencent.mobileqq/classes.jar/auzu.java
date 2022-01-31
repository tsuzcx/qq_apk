import android.graphics.PointF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

public class auzu
  implements Animation.AnimationListener
{
  public auzu(ProfileTagView paramProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView;
    paramAnimation.i -= 1;
    paramAnimation = (RatioLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramAnimation != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.getAnimation() != null) {
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if ((paramAnimation.a != this.jdField_a_of_type_AndroidGraphicsPointF.x) || (paramAnimation.b != this.jdField_a_of_type_AndroidGraphicsPointF.y))
      {
        paramAnimation.a = this.jdField_a_of_type_AndroidGraphicsPointF.x;
        paramAnimation.b = this.jdField_a_of_type_AndroidGraphicsPointF.y;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
        if ((this.jdField_a_of_type_AndroidViewView instanceof VipTagView)) {
          ((VipTagView)this.jdField_a_of_type_AndroidViewView).setShakingState(true);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b = false;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.i == 0) {
        if (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b())
        {
          paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_Auuw.a.getLabelList();
          if (paramAnimation != null)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView[(ProfileTagView.a().length - 1)] == null) || (paramAnimation.size() != 0)) {
              break label244;
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.e)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.g(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_Auuw);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.e = false;
      }
      return;
      label244:
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzu
 * JD-Core Version:    0.7.0.1
 */