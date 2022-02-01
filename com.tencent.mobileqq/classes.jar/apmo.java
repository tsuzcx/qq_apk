import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class apmo
  implements Animator.AnimatorListener
{
  apmo(apmh paramapmh, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    apmh.b(this.jdField_a_of_type_Apmh).scrollTo(0, 0);
    apmh.b(this.jdField_a_of_type_Apmh).setAlpha(1.0F);
    apmh.b(this.jdField_a_of_type_Apmh).setBackgroundColor(apmh.a(this.jdField_a_of_type_Apmh).getResources().getColor(apmh.a()));
    paramAnimator = this.jdField_a_of_type_Apmh.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_Apmh.a.getMeasuredWidth();; f = this.jdField_a_of_type_Apmh.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_Apmh.a.setAlpha(0.0F);
      this.jdField_a_of_type_Apmh.a.setVisibility(0);
      this.jdField_a_of_type_Apmh.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmo
 * JD-Core Version:    0.7.0.1
 */