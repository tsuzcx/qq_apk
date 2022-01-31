import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class amii
  implements Animator.AnimatorListener
{
  amii(amib paramamib, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    amib.b(this.jdField_a_of_type_Amib).scrollTo(0, 0);
    amib.b(this.jdField_a_of_type_Amib).setAlpha(1.0F);
    amib.b(this.jdField_a_of_type_Amib).setBackgroundColor(amib.a(this.jdField_a_of_type_Amib).getResources().getColor(amib.a()));
    paramAnimator = this.jdField_a_of_type_Amib.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_Amib.a.getMeasuredWidth();; f = this.jdField_a_of_type_Amib.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_Amib.a.setAlpha(0.0F);
      this.jdField_a_of_type_Amib.a.setVisibility(0);
      this.jdField_a_of_type_Amib.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amii
 * JD-Core Version:    0.7.0.1
 */