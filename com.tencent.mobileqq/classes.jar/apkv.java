import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class apkv
  implements apld
{
  private void a(String paramString, apky paramapky)
  {
    QQAppInterface localQQAppInterface = apkf.a();
    TicketManager localTicketManager = (TicketManager)localQQAppInterface.getManager(2);
    String str = localTicketManager.getPskey(localQQAppInterface.getCurrentAccountUin(), paramString);
    if (!TextUtils.isEmpty(str))
    {
      if (paramapky != null) {
        paramapky.a(str);
      }
      return;
    }
    str = localQQAppInterface.getCurrentAccountUin();
    paramapky = new apkx(this, localTicketManager, localQQAppInterface, paramString, paramapky);
    localTicketManager.GetPskey(str, 16L, new String[] { paramString }, paramapky);
  }
  
  public void a(Bundle paramBundle, aplf paramaplf)
  {
    if (apkf.a() == null)
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, app interface is null");
      paramaplf.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    paramBundle = paramBundle.getString("domain", "");
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, domain is empty");
      paramaplf.a(EIPCResult.createResult(0, new Bundle()));
      return;
    }
    a(paramBundle, new apkw(this, paramaplf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkv
 * JD-Core Version:    0.7.0.1
 */