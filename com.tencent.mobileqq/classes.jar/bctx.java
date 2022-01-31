import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class bctx
  implements Animator.AnimatorListener
{
  bctx(bctu parambctu, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bctu.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Bctu.a.setAlpha(1.0F);
    }
    for (;;)
    {
      bctu.b(this.jdField_a_of_type_Bctu, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Bctu.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bctu.b(this.jdField_a_of_type_Bctu, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      bctu.a(this.jdField_a_of_type_Bctu, false);
      this.jdField_a_of_type_Bctu.a(false, new View[] { bctu.a(this.jdField_a_of_type_Bctu) });
    }
    bctu.a(this.jdField_a_of_type_Bctu);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bctu.b(this.jdField_a_of_type_Bctu, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      bctu.a(this.jdField_a_of_type_Bctu, true);
      if (bctu.a(this.jdField_a_of_type_Bctu) == 1) {
        this.jdField_a_of_type_Bctu.a(true, new View[] { bctu.a(this.jdField_a_of_type_Bctu) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bctx
 * JD-Core Version:    0.7.0.1
 */