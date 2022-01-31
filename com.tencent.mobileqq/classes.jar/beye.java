import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class beye
  implements Animator.AnimatorListener
{
  beye(beyb parambeyb, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Beyb.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Beyb.a.setAlpha(1.0F);
    }
    for (;;)
    {
      beyb.b(this.jdField_a_of_type_Beyb, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Beyb.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    beyb.b(this.jdField_a_of_type_Beyb, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      beyb.a(this.jdField_a_of_type_Beyb, false);
      this.jdField_a_of_type_Beyb.a(false, new View[] { beyb.a(this.jdField_a_of_type_Beyb) });
    }
    beyb.a(this.jdField_a_of_type_Beyb);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    beyb.b(this.jdField_a_of_type_Beyb, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      beyb.a(this.jdField_a_of_type_Beyb, true);
      if (beyb.a(this.jdField_a_of_type_Beyb) == 1) {
        this.jdField_a_of_type_Beyb.a(true, new View[] { beyb.a(this.jdField_a_of_type_Beyb) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beye
 * JD-Core Version:    0.7.0.1
 */