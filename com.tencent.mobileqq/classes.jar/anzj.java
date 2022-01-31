import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class anzj
  implements Animator.AnimatorListener
{
  anzj(anzc paramanzc, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    anzc.b(this.jdField_a_of_type_Anzc).scrollTo(0, 0);
    anzc.b(this.jdField_a_of_type_Anzc).setAlpha(1.0F);
    anzc.b(this.jdField_a_of_type_Anzc).setBackgroundColor(anzc.a(this.jdField_a_of_type_Anzc).getResources().getColor(anzc.a()));
    paramAnimator = this.jdField_a_of_type_Anzc.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_Anzc.a.getMeasuredWidth();; f = this.jdField_a_of_type_Anzc.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_Anzc.a.setAlpha(0.0F);
      this.jdField_a_of_type_Anzc.a.setVisibility(0);
      this.jdField_a_of_type_Anzc.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzj
 * JD-Core Version:    0.7.0.1
 */