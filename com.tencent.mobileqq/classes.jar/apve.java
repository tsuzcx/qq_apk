import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class apve
  implements apvl
{
  public EIPCResult a(Bundle paramBundle)
  {
    Object localObject = apuj.a();
    if (localObject == null)
    {
      QLog.e("ArkApp.GetPSKeyHandler", 1, "GetPSKeyHandler.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    paramBundle = paramBundle.getString("Domain", "");
    localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getPskey(((QQAppInterface)localObject).getCurrentAccountUin(), paramBundle);
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("ArkApp.GetPSKeyHandler", 1, "GetPSKeyHandler.onCall, pskey is empty, domain=" + paramBundle);
      localBundle.putString("PSKey", "");
    }
    for (;;)
    {
      return EIPCResult.createResult(0, localBundle);
      localBundle.putString("PSKey", (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apve
 * JD-Core Version:    0.7.0.1
 */