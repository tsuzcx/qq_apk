import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class biwx
  implements Animator.AnimatorListener
{
  biwx(biwu parambiwu, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Biwu.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Biwu.a.setAlpha(1.0F);
    }
    for (;;)
    {
      biwu.b(this.jdField_a_of_type_Biwu, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Biwu.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    biwu.b(this.jdField_a_of_type_Biwu, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      biwu.a(this.jdField_a_of_type_Biwu, false);
      this.jdField_a_of_type_Biwu.a(false, new View[] { biwu.a(this.jdField_a_of_type_Biwu) });
    }
    biwu.a(this.jdField_a_of_type_Biwu);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    biwu.b(this.jdField_a_of_type_Biwu, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      biwu.a(this.jdField_a_of_type_Biwu, true);
      if (biwu.a(this.jdField_a_of_type_Biwu) == 1) {
        this.jdField_a_of_type_Biwu.a(true, new View[] { biwu.a(this.jdField_a_of_type_Biwu) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biwx
 * JD-Core Version:    0.7.0.1
 */