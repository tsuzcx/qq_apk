import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class apex
  extends AnimatorListenerAdapter
{
  apex(apet paramapet, apfd paramapfd) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Apet.d != null) && (this.jdField_a_of_type_Apet.e != null))
    {
      this.jdField_a_of_type_Apet.d.setVisibility(4);
      this.jdField_a_of_type_Apet.e.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Apet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      paramAnimator.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_Apet.a("show pendant, " + this.jdField_a_of_type_Apet.jdField_a_of_type_Long);
      paramAnimator.b();
    }
    if (this.jdField_a_of_type_Apet.c != null) {
      this.jdField_a_of_type_Apet.c.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Apet.d != null) && (this.jdField_a_of_type_Apet.e != null))
    {
      this.jdField_a_of_type_Apet.d.setVisibility(0);
      this.jdField_a_of_type_Apet.e.setVisibility(4);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Apet.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      this.jdField_a_of_type_Apet.a("stop show pendant, " + this.jdField_a_of_type_Apet.jdField_a_of_type_Long);
      paramAnimator.jdField_a_of_type_Long = this.jdField_a_of_type_Apet.jdField_a_of_type_Long;
      paramAnimator.a();
    }
    if ((this.jdField_a_of_type_Apet.c != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Apfd.e))) {
      this.jdField_a_of_type_Apet.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apex
 * JD-Core Version:    0.7.0.1
 */