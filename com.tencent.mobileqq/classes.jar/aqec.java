import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class aqec
  implements Animator.AnimatorListener
{
  aqec(aqdv paramaqdv, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aqdv.b(this.jdField_a_of_type_Aqdv).scrollTo(0, 0);
    aqdv.b(this.jdField_a_of_type_Aqdv).setAlpha(1.0F);
    aqdv.b(this.jdField_a_of_type_Aqdv).setBackgroundColor(aqdv.a(this.jdField_a_of_type_Aqdv).getResources().getColor(aqdv.a()));
    paramAnimator = this.jdField_a_of_type_Aqdv.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_Aqdv.a.getMeasuredWidth();; f = this.jdField_a_of_type_Aqdv.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_Aqdv.a.setAlpha(0.0F);
      this.jdField_a_of_type_Aqdv.a.setVisibility(0);
      this.jdField_a_of_type_Aqdv.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqec
 * JD-Core Version:    0.7.0.1
 */