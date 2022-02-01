import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class aory
  implements aosg
{
  private void a(QQAppInterface paramQQAppInterface, String paramString, aosb paramaosb)
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
    } while (paramaosb == null);
    paramaosb.a(str);
    return;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = new aosa(this, localTicketManager, paramQQAppInterface, paramString, paramaosb);
    localTicketManager.getPskey(str, 16L, new String[] { paramString }, paramQQAppInterface);
  }
  
  public void a(Bundle paramBundle, aosi paramaosi)
  {
    QQAppInterface localQQAppInterface = aori.a();
    if (localQQAppInterface == null)
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, app interface is null");
      paramaosi.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    paramBundle = paramBundle.getString("domain", "");
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, domain is empty");
      paramaosi.a(EIPCResult.createResult(0, new Bundle()));
      return;
    }
    a(localQQAppInterface, paramBundle, new aorz(this, paramaosi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aory
 * JD-Core Version:    0.7.0.1
 */