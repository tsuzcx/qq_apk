import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;

public class aymq
  extends aypr
{
  public aymq(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      if (!paramBundle.getBoolean("param_need_switch_online_status")) {
        AccountOnlineStateActivity.a(this.a, true, 0);
      }
      return;
    }
    AccountOnlineStateActivity.a(this.a, true, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymq
 * JD-Core Version:    0.7.0.1
 */