import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class bhmh
  implements Animator.AnimatorListener
{
  bhmh(bhme parambhme, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bhme.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Bhme.a.setAlpha(1.0F);
    }
    for (;;)
    {
      bhme.b(this.jdField_a_of_type_Bhme, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Bhme.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bhme.b(this.jdField_a_of_type_Bhme, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      bhme.a(this.jdField_a_of_type_Bhme, false);
      this.jdField_a_of_type_Bhme.a(false, new View[] { bhme.a(this.jdField_a_of_type_Bhme) });
    }
    bhme.a(this.jdField_a_of_type_Bhme);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bhme.b(this.jdField_a_of_type_Bhme, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      bhme.a(this.jdField_a_of_type_Bhme, true);
      if (bhme.a(this.jdField_a_of_type_Bhme) == 1) {
        this.jdField_a_of_type_Bhme.a(true, new View[] { bhme.a(this.jdField_a_of_type_Bhme) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmh
 * JD-Core Version:    0.7.0.1
 */