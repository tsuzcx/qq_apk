import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class aqhm
  implements Animator.AnimatorListener
{
  aqhm(aqhk paramaqhk, aqhr paramaqhr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "onAnimationCancel " + this.jdField_a_of_type_Aqhr.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aqhk.a(this.jdField_a_of_type_Aqhr);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "onAnimationEnd " + this.jdField_a_of_type_Aqhr.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aqhk.a(this.jdField_a_of_type_Aqhr);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "onAnimationRepeat " + this.jdField_a_of_type_Aqhr.jdField_a_of_type_Long);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "onAnimationStart " + this.jdField_a_of_type_Aqhr.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhm
 * JD-Core Version:    0.7.0.1
 */