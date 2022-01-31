import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class avnq
  extends AnimatorListenerAdapter
{
  boolean jdField_a_of_type_Boolean = false;
  
  avnq(avno paramavno) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationEnd");
    if (this.jdField_a_of_type_Boolean) {
      avno.a(this.jdField_a_of_type_Avno, 8);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationStart");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avnq
 * JD-Core Version:    0.7.0.1
 */