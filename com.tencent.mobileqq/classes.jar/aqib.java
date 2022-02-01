import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class aqib
  extends AnimatorListenerAdapter
{
  aqib(aqhx paramaqhx, aqih paramaqih) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Aqhx.d != null) && (this.jdField_a_of_type_Aqhx.e != null))
    {
      this.jdField_a_of_type_Aqhx.d.setVisibility(4);
      this.jdField_a_of_type_Aqhx.e.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Aqhx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      paramAnimator.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_Aqhx.a("show pendant, " + this.jdField_a_of_type_Aqhx.jdField_a_of_type_Long);
      paramAnimator.b();
    }
    if (this.jdField_a_of_type_Aqhx.c != null) {
      this.jdField_a_of_type_Aqhx.c.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Aqhx.d != null) && (this.jdField_a_of_type_Aqhx.e != null))
    {
      this.jdField_a_of_type_Aqhx.d.setVisibility(0);
      this.jdField_a_of_type_Aqhx.e.setVisibility(4);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Aqhx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      this.jdField_a_of_type_Aqhx.a("stop show pendant, " + this.jdField_a_of_type_Aqhx.jdField_a_of_type_Long);
      paramAnimator.jdField_a_of_type_Long = this.jdField_a_of_type_Aqhx.jdField_a_of_type_Long;
      paramAnimator.a();
    }
    if ((this.jdField_a_of_type_Aqhx.c != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Aqih.e))) {
      this.jdField_a_of_type_Aqhx.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqib
 * JD-Core Version:    0.7.0.1
 */