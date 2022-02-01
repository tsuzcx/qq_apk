import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader.ColorScreenListener.1;
import com.tencent.qphone.base.util.QLog;

public class ayvv
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  public int a;
  public long a;
  private boolean a;
  public long b;
  
  public ayvv(ProfileColorScreenComponent.ColorScreenLoader paramColorScreenLoader, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.b = ((ProfileColorScreenComponent.ColorScreenLoader.a(paramColorScreenLoader).jdField_a_of_type_Int + 1) * paramLong);
    if (Build.VERSION.SDK_INT == 15) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onAnimationEnd: " + ProfileColorScreenComponent.ColorScreenLoader.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader));
    }
    ProfileColorScreenComponent.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader.this$0).setVisibility(8);
    ProfileColorScreenComponent.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader.this$0).post(new ProfileColorScreenComponent.ColorScreenLoader.ColorScreenListener.1(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileColorScreenComponent", 2, "onAnimationStart: " + ProfileColorScreenComponent.ColorScreenLoader.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader));
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        float f = (paramValueAnimator.getAnimatedFraction() + this.jdField_a_of_type_Int) * (float)this.jdField_a_of_type_Long;
        if (f <= (float)ProfileColorScreenComponent.ColorScreenLoader.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader).jdField_a_of_type_Long)
        {
          ProfileColorScreenComponent.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader.this$0).setAlpha(f / (float)ProfileColorScreenComponent.ColorScreenLoader.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader).jdField_a_of_type_Long);
          return;
        }
        if ((this.b > 0L) && ((float)this.b - f <= (float)ProfileColorScreenComponent.ColorScreenLoader.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader).b))
        {
          ProfileColorScreenComponent.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader.this$0).setAlpha(((float)this.b - f) / (float)ProfileColorScreenComponent.ColorScreenLoader.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader).b);
          return;
        }
      }
      catch (Exception paramValueAnimator)
      {
        this.jdField_a_of_type_Boolean = true;
        QLog.e("ProfileColorScreenComponent", 1, "onAnimationUpdate: ", paramValueAnimator);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvv
 * JD-Core Version:    0.7.0.1
 */