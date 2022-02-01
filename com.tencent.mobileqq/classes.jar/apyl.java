import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class apyl
  implements apyt
{
  private void a(String paramString, apyo paramapyo)
  {
    QQAppInterface localQQAppInterface = apxv.a();
    TicketManager localTicketManager = (TicketManager)localQQAppInterface.getManager(2);
    String str = localTicketManager.getPskey(localQQAppInterface.getCurrentAccountUin(), paramString);
    if (!TextUtils.isEmpty(str))
    {
      if (paramapyo != null) {
        paramapyo.a(str);
      }
      return;
    }
    str = localQQAppInterface.getCurrentAccountUin();
    paramapyo = new apyn(this, localTicketManager, localQQAppInterface, paramString, paramapyo);
    localTicketManager.getPskey(str, 16L, new String[] { paramString }, paramapyo);
  }
  
  public void a(Bundle paramBundle, apyv paramapyv)
  {
    if (apxv.a() == null)
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, app interface is null");
      paramapyv.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    paramBundle = paramBundle.getString("domain", "");
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, domain is empty");
      paramapyv.a(EIPCResult.createResult(0, new Bundle()));
      return;
    }
    a(paramBundle, new apym(this, paramapyv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyl
 * JD-Core Version:    0.7.0.1
 */