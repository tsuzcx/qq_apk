import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class axfl
  extends AnimatorListenerAdapter
{
  boolean jdField_a_of_type_Boolean = false;
  
  axfl(axfj paramaxfj) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationEnd");
    if (this.jdField_a_of_type_Boolean) {
      axfj.a(this.jdField_a_of_type_Axfj, 8);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationStart");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axfl
 * JD-Core Version:    0.7.0.1
 */