import android.os.Bundle;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class atvq
  extends alzr
{
  public atvq(LoginWelcomeManager paramLoginWelcomeManager, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("result", i);
      this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString);
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvq
 * JD-Core Version:    0.7.0.1
 */