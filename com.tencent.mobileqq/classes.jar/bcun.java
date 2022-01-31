import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatView;

public class bcun
  implements Animator.AnimatorListener
{
  public bcun(QUSHalfScreenFloatView paramQUSHalfScreenFloatView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
    this.a.e = false;
    if (this.a.jdField_a_of_type_Bklp != null) {
      this.a.jdField_a_of_type_Bklp.hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
    this.a.e = false;
    if (this.a.jdField_a_of_type_Bklp != null) {
      this.a.jdField_a_of_type_Bklp.hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcun
 * JD-Core Version:    0.7.0.1
 */