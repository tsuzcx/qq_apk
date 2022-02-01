import com.tencent.mobileqq.data.OpenID;
import com.tencent.open.agent.TroopAbilityPreVerificationFragment;
import com.tencent.qphone.base.util.QLog;

public class bjgc
  extends nwk
{
  public bjgc(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    QLog.d("TroopAbility.PreVerification", 1, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID);
    if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
    {
      if (!paramOpenID.openID.equals(this.a.b))
      {
        this.a.d();
        TroopAbilityPreVerificationFragment.a(this.a);
        return;
      }
      this.a.c();
      return;
    }
    this.a.c(anvx.a(2131714493));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgc
 * JD-Core Version:    0.7.0.1
 */