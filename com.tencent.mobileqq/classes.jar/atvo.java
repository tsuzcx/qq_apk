import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class atvo
  extends auxl
{
  public atvo(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramNearbyPeopleCard != null))
    {
      byte[] arrayOfByte = paramNearbyPeopleCard.vTempChatSig;
      String str = paramNearbyPeopleCard.nickname;
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "onNearbyCardDownload " + paramNearbyPeopleCard.uin + " " + str);
      }
      Bundle localBundle = LoginWelcomeManager.a(this.a).getBundle("request");
      localBundle.putString("uin", paramNearbyPeopleCard.uin);
      localBundle.putByteArray("sig", arrayOfByte);
      localBundle.putString("nick", str);
      localBundle.putString("tinyId", String.valueOf(paramNearbyPeopleCard.tinyId));
    }
    for (;;)
    {
      this.a.b();
      LoginWelcomeManager.a(this.a).removeObserver(this);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "onNearbyCardDownload err" + paramBoolean1 + " " + paramNearbyPeopleCard);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvo
 * JD-Core Version:    0.7.0.1
 */