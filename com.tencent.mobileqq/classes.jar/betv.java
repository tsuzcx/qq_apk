import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class betv
  implements Animator.AnimatorListener
{
  betv(bets parambets, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bets.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Bets.a.setAlpha(1.0F);
    }
    for (;;)
    {
      bets.b(this.jdField_a_of_type_Bets, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Bets.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bets.b(this.jdField_a_of_type_Bets, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      bets.a(this.jdField_a_of_type_Bets, false);
      this.jdField_a_of_type_Bets.a(false, new View[] { bets.a(this.jdField_a_of_type_Bets) });
    }
    bets.a(this.jdField_a_of_type_Bets);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bets.b(this.jdField_a_of_type_Bets, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      bets.a(this.jdField_a_of_type_Bets, true);
      if (bets.a(this.jdField_a_of_type_Bets) == 1) {
        this.jdField_a_of_type_Bets.a(true, new View[] { bets.a(this.jdField_a_of_type_Bets) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betv
 * JD-Core Version:    0.7.0.1
 */