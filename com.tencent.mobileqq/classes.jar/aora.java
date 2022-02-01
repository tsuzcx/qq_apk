import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.qphone.base.util.QLog;

public class aora
  extends aojs
{
  public aora(HiddenChatFragment paramHiddenChatFragment) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 512) && (paramBoolean))
    {
      paramString2 = ((TroopManager)HiddenChatFragment.a(this.a).getManager(52)).b(paramString1);
      aorg.a(HiddenChatFragment.a(this.a), paramString2);
      this.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onSetHiddenChatSwitch troopUin=" + paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aora
 * JD-Core Version:    0.7.0.1
 */