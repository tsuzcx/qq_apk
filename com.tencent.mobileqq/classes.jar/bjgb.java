import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class bjgb
  implements Animator.AnimatorListener
{
  bjgb(bjfy parambjfy, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bjfy.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Bjfy.a.setAlpha(1.0F);
    }
    for (;;)
    {
      bjfy.b(this.jdField_a_of_type_Bjfy, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Bjfy.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bjfy.b(this.jdField_a_of_type_Bjfy, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      bjfy.a(this.jdField_a_of_type_Bjfy, false);
      this.jdField_a_of_type_Bjfy.a(false, new View[] { bjfy.a(this.jdField_a_of_type_Bjfy) });
    }
    bjfy.a(this.jdField_a_of_type_Bjfy);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bjfy.b(this.jdField_a_of_type_Bjfy, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      bjfy.a(this.jdField_a_of_type_Bjfy, true);
      if (bjfy.a(this.jdField_a_of_type_Bjfy) == 1) {
        this.jdField_a_of_type_Bjfy.a(true, new View[] { bjfy.a(this.jdField_a_of_type_Bjfy) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgb
 * JD-Core Version:    0.7.0.1
 */