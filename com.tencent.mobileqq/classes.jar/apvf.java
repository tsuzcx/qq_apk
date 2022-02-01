import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class apvf
  implements apvl
{
  public EIPCResult a(Bundle paramBundle)
  {
    paramBundle = apuj.a();
    if (paramBundle == null)
    {
      QLog.e("ArkApp.GetSKeyHandler", 1, "GetSKeyHandler.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    paramBundle = ((TicketManager)paramBundle.getManager(2)).getSkey(paramBundle.getCurrentAccountUin());
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.e("ArkApp.GetSKeyHandler", 1, "GetSKeyHandler.onCall, skey is empty");
      localBundle.putString("SKey", "");
    }
    for (;;)
    {
      return EIPCResult.createResult(0, localBundle);
      localBundle.putString("SKey", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvf
 * JD-Core Version:    0.7.0.1
 */