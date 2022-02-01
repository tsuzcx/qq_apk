import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout;

public class baeq
  implements ValueAnimator.AnimatorUpdateListener
{
  public baeq(VasProfileTagView paramVasProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (PointF)paramValueAnimator.getAnimatedValue();
    VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, paramValueAnimator.x, paramValueAnimator.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baeq
 * JD-Core Version:    0.7.0.1
 */