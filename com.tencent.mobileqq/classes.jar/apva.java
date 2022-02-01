import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class apva
  implements apvi
{
  private void a(QQAppInterface paramQQAppInterface, String paramString, apvd paramapvd)
  {
    if (paramQQAppInterface == null) {}
    TicketManager localTicketManager;
    do
    {
      return;
      localTicketManager = (TicketManager)paramQQAppInterface.getManager(2);
      str = localTicketManager.getPskey(paramQQAppInterface.getCurrentAccountUin(), paramString);
      if (TextUtils.isEmpty(str)) {
        break;
      }
    } while (paramapvd == null);
    paramapvd.a(str);
    return;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = new apvc(this, localTicketManager, paramQQAppInterface, paramString, paramapvd);
    localTicketManager.getPskey(str, 16L, new String[] { paramString }, paramQQAppInterface);
  }
  
  public void a(Bundle paramBundle, apvk paramapvk)
  {
    QQAppInterface localQQAppInterface = apuj.a();
    if (localQQAppInterface == null)
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, app interface is null");
      paramapvk.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    paramBundle = paramBundle.getString("domain", "");
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, domain is empty");
      paramapvk.a(EIPCResult.createResult(0, new Bundle()));
      return;
    }
    a(localQQAppInterface, paramBundle, new apvb(this, paramapvk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apva
 * JD-Core Version:    0.7.0.1
 */