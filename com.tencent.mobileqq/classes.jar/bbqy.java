import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class bbqy
  implements Animator.AnimatorListener
{
  bbqy(bbqv parambbqv, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bbqv.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Bbqv.a.setAlpha(1.0F);
    }
    for (;;)
    {
      bbqv.b(this.jdField_a_of_type_Bbqv, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Bbqv.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bbqv.b(this.jdField_a_of_type_Bbqv, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      bbqv.a(this.jdField_a_of_type_Bbqv, false);
      this.jdField_a_of_type_Bbqv.a(false, new View[] { bbqv.a(this.jdField_a_of_type_Bbqv) });
    }
    bbqv.a(this.jdField_a_of_type_Bbqv);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bbqv.b(this.jdField_a_of_type_Bbqv, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      bbqv.a(this.jdField_a_of_type_Bbqv, true);
      if (bbqv.a(this.jdField_a_of_type_Bbqv) == 1) {
        this.jdField_a_of_type_Bbqv.a(true, new View[] { bbqv.a(this.jdField_a_of_type_Bbqv) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbqy
 * JD-Core Version:    0.7.0.1
 */