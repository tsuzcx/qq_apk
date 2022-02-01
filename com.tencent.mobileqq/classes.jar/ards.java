import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class ards
  extends WtloginObserver
{
  ards(arcu paramarcu, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    boolean bool2 = true;
    paramWUserSigInfo = new Bundle();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (paramDevlockInfo.DevSetup != 1) {
        break label90;
      }
      bool1 = true;
      paramWUserSigInfo.putBoolean("auth_dev_open", bool1);
      if (paramDevlockInfo.AllowSet != 1) {
        break label96;
      }
    }
    label90:
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramWUserSigInfo.putBoolean("allow_set", bool1);
      paramWUserSigInfo.putString("phone_num", paramDevlockInfo.Mobile);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramWUserSigInfo);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ards
 * JD-Core Version:    0.7.0.1
 */