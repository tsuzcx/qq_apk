import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class apvn
  implements apvi
{
  private WtloginObserver a;
  
  private void a(long paramLong1, long paramLong2, apvq paramapvq)
  {
    QQAppInterface localQQAppInterface = apuj.a();
    if (localQQAppInterface == null)
    {
      paramapvq.a(null, 0L, null, null);
      return;
    }
    if (this.a == null) {
      this.a = new apvp(this, paramapvq);
    }
    ((WtloginManager)localQQAppInterface.getManager(1)).getOpenKeyWithoutPasswd(localQQAppInterface.getCurrentUin(), paramLong1, paramLong2, this.a);
  }
  
  public void a(Bundle paramBundle, apvk paramapvk)
  {
    if (apuj.a() == null)
    {
      QLog.e("ArkApp.LoginHandler", 1, "LoginHandler.onCall, qq app is null");
      paramapvk.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    long l1 = paramBundle.getLong("srcAppID", 0L);
    long l2 = paramBundle.getLong("dstAppID", 0L);
    if ((l1 == 0L) || (l2 == 0L))
    {
      paramapvk.a(EIPCResult.createResult(0, new Bundle()));
      return;
    }
    a(l1, l2, new apvo(this, paramapvk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvn
 * JD-Core Version:    0.7.0.1
 */