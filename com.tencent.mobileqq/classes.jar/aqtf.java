import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class aqtf
  implements Animator.AnimatorListener
{
  aqtf(aqsy paramaqsy, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aqsy.b(this.jdField_a_of_type_Aqsy).scrollTo(0, 0);
    aqsy.b(this.jdField_a_of_type_Aqsy).setAlpha(1.0F);
    aqsy.b(this.jdField_a_of_type_Aqsy).setBackgroundColor(aqsy.a(this.jdField_a_of_type_Aqsy).getResources().getColor(aqsy.a()));
    paramAnimator = this.jdField_a_of_type_Aqsy.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_Aqsy.a.getMeasuredWidth();; f = this.jdField_a_of_type_Aqsy.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_Aqsy.a.setAlpha(0.0F);
      this.jdField_a_of_type_Aqsy.a.setVisibility(0);
      this.jdField_a_of_type_Aqsy.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtf
 * JD-Core Version:    0.7.0.1
 */