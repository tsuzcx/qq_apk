import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class bazm
  extends AnimatorListenerAdapter
{
  boolean jdField_a_of_type_Boolean = false;
  
  bazm(bazk parambazk) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationEnd");
    if (this.jdField_a_of_type_Boolean) {
      bazk.a(this.jdField_a_of_type_Bazk, 8);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationStart");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazm
 * JD-Core Version:    0.7.0.1
 */