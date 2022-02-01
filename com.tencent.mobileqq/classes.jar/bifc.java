import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class bifc
  implements Animator.AnimatorListener
{
  bifc(biez parambiez, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Biez.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Biez.a.setAlpha(1.0F);
    }
    for (;;)
    {
      biez.b(this.jdField_a_of_type_Biez, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Biez.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    biez.b(this.jdField_a_of_type_Biez, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      biez.a(this.jdField_a_of_type_Biez, false);
      this.jdField_a_of_type_Biez.a(false, new View[] { biez.a(this.jdField_a_of_type_Biez) });
    }
    biez.a(this.jdField_a_of_type_Biez);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    biez.b(this.jdField_a_of_type_Biez, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      biez.a(this.jdField_a_of_type_Biez, true);
      if (biez.a(this.jdField_a_of_type_Biez) == 1) {
        this.jdField_a_of_type_Biez.a(true, new View[] { biez.a(this.jdField_a_of_type_Biez) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifc
 * JD-Core Version:    0.7.0.1
 */