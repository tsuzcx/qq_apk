import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.mobileqq.app.BaseActivity;

public class bagb
  extends badc<FrameLayout>
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FriendCardApolloViewController jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController;
  protected boolean a;
  
  public bagb(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  public int a()
  {
    return 1020;
  }
  
  public String a()
  {
    return "ProfileCmShowComponent";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onWindowFocusGained");
    }
    if ((!this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.a())))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.a(false);
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController = new FriendCardApolloViewController((FriendProfileCardActivity)paramBaseActivity, (View)this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onCreate");
    }
  }
  
  public boolean a(azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onDataUpdate");
    }
    boolean bool = super.a(paramazxr);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
    }
    return bool;
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onResume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.b();
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.c();
    }
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.d();
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onDestroy");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.e();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCmShowComponent", 0, "handleMessage MSG_REFRESH_APOLLO");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagb
 * JD-Core Version:    0.7.0.1
 */