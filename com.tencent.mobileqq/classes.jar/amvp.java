import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity.1.1;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity.1.2;

public class amvp
  extends ajjh
{
  public amvp(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new BaseMsgBoxActivity.1.2(this, paramBoolean, paramString1, paramString2));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new BaseMsgBoxActivity.1.1(this, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amvp
 * JD-Core Version:    0.7.0.1
 */