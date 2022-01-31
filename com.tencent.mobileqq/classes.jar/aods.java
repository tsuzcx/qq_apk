import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class aods
  implements Animator.AnimatorListener
{
  aods(aodl paramaodl, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aodl.b(this.jdField_a_of_type_Aodl).scrollTo(0, 0);
    aodl.b(this.jdField_a_of_type_Aodl).setAlpha(1.0F);
    aodl.b(this.jdField_a_of_type_Aodl).setBackgroundColor(aodl.a(this.jdField_a_of_type_Aodl).getResources().getColor(aodl.a()));
    paramAnimator = this.jdField_a_of_type_Aodl.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_Aodl.a.getMeasuredWidth();; f = this.jdField_a_of_type_Aodl.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_Aodl.a.setAlpha(0.0F);
      this.jdField_a_of_type_Aodl.a.setVisibility(0);
      this.jdField_a_of_type_Aodl.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aods
 * JD-Core Version:    0.7.0.1
 */