import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.RelativeLayout;

class bcum
  implements Animator.AnimatorListener
{
  bcum(bcuj parambcuj, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bcuj.a != null)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label41;
      }
      this.jdField_a_of_type_Bcuj.a.setAlpha(1.0F);
    }
    for (;;)
    {
      bcuj.b(this.jdField_a_of_type_Bcuj, this.jdField_a_of_type_Int);
      return;
      label41:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Bcuj.a.setAlpha(0.0F);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bcuj.b(this.jdField_a_of_type_Bcuj, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1)
    {
      bcuj.a(this.jdField_a_of_type_Bcuj, false);
      this.jdField_a_of_type_Bcuj.a(false, new View[] { bcuj.a(this.jdField_a_of_type_Bcuj) });
    }
    bcuj.a(this.jdField_a_of_type_Bcuj);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bcuj.b(this.jdField_a_of_type_Bcuj, 2);
    if (this.jdField_a_of_type_Int == 0)
    {
      bcuj.a(this.jdField_a_of_type_Bcuj, true);
      if (bcuj.a(this.jdField_a_of_type_Bcuj) == 1) {
        this.jdField_a_of_type_Bcuj.a(true, new View[] { bcuj.a(this.jdField_a_of_type_Bcuj) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcum
 * JD-Core Version:    0.7.0.1
 */