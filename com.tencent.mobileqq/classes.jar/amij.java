import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class amij
  implements Animator.AnimatorListener
{
  amij(amic paramamic, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    amic.b(this.jdField_a_of_type_Amic).scrollTo(0, 0);
    amic.b(this.jdField_a_of_type_Amic).setAlpha(1.0F);
    amic.b(this.jdField_a_of_type_Amic).setBackgroundColor(amic.a(this.jdField_a_of_type_Amic).getResources().getColor(amic.a()));
    paramAnimator = this.jdField_a_of_type_Amic.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_Amic.a.getMeasuredWidth();; f = this.jdField_a_of_type_Amic.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_Amic.a.setAlpha(0.0F);
      this.jdField_a_of_type_Amic.a.setVisibility(0);
      this.jdField_a_of_type_Amic.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amij
 * JD-Core Version:    0.7.0.1
 */