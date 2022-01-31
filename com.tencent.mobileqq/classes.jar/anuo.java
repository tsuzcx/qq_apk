import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class anuo
  extends WtloginObserver
{
  anuo(anul paramanul, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    boolean bool2 = true;
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      paramWUserSigInfo = this.jdField_a_of_type_AndroidOsBundle;
      if (paramDevlockInfo.AllowSet != 1) {
        break label85;
      }
      bool1 = true;
      paramWUserSigInfo.putBoolean("hasSecurityPhoneNumber", bool1);
      paramWUserSigInfo = this.jdField_a_of_type_AndroidOsBundle;
      if (paramDevlockInfo.DevSetup != 1) {
        break label91;
      }
    }
    label85:
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramWUserSigInfo.putBoolean("devlockIsOpen", bool1);
      this.b.putBundle("response", this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anuo
 * JD-Core Version:    0.7.0.1
 */