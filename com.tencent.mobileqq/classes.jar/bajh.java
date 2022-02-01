import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

public class bajh
  extends AnimatorListenerAdapter
{
  public bajh(VasProfileTagView paramVasProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VasProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView);
    paramAnimator = (RatioLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramAnimator != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.getAnimation() != null) {
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if ((paramAnimator.a != this.jdField_a_of_type_AndroidGraphicsPointF.x) || (paramAnimator.b != this.jdField_a_of_type_AndroidGraphicsPointF.y))
      {
        paramAnimator.a = this.jdField_a_of_type_AndroidGraphicsPointF.x;
        paramAnimator.b = this.jdField_a_of_type_AndroidGraphicsPointF.y;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
        this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
        this.jdField_a_of_type_AndroidViewView.setTranslationY(0.0F);
        if ((this.jdField_a_of_type_AndroidViewView instanceof VipTagView)) {
          ((VipTagView)this.jdField_a_of_type_AndroidViewView).setShakingState(true);
        }
      }
      VasProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView, false);
      if (VasProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView) == 0) {
        if (!this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView.b())
        {
          paramAnimator = VasProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).a.getLabelList();
          if (paramAnimator != null)
          {
            if ((VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView)[(VasProfileTagView.a().length - 1)] == null) || (paramAnimator.size() != 0)) {
              break label255;
            }
            VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (VasProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView))
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView.b(VasProfileTagView.d(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView));
        VasProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView, false);
      }
      return;
      label255:
      VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajh
 * JD-Core Version:    0.7.0.1
 */