import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;

public class bjdi
  extends aofu
{
  public bjdi(JoinTroopPreVerificationFragment paramJoinTroopPreVerificationFragment) {}
  
  protected void onGetJoinTroopTokenForThirdApp(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.a.d();
    QLog.i("TroopAbility.PreVerification", 1, "onGetJoinTroopTokenForThirdApp, isSuccess: " + paramBoolean + " token: " + paramString1 + ", troopUin: " + paramString2);
    if (paramBoolean)
    {
      paramString2 = TroopInfoActivity.a(String.valueOf(paramString2), 32);
      paramString2.putString("authSig", paramString1);
      paramString2.putString("appid", this.a.c);
      paramString2.putBoolean("fromThirdAppByOpenSDK", true);
      paramString2.putInt("action", 3);
      paramString2.putString("pkg_name", this.a.d);
      paramString2.putString("app_name", this.a.jdField_a_of_type_JavaLangString);
      TroopUtils.openTroopInfoActivity(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString2, 2);
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.a.a(anvx.a(2131705360));
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdi
 * JD-Core Version:    0.7.0.1
 */