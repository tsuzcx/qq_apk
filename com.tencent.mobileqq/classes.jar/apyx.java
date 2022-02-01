import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class apyx
  implements apyt
{
  private WtloginObserver a;
  
  private void a(long paramLong1, long paramLong2, apza paramapza)
  {
    QQAppInterface localQQAppInterface = apxv.a();
    if (localQQAppInterface == null) {
      paramapza.a(null, 0L, null, null);
    }
    if (this.a == null) {
      this.a = new apyz(this, paramapza);
    }
    ((WtloginManager)localQQAppInterface.getManager(1)).getOpenKeyWithoutPasswd(localQQAppInterface.c(), paramLong1, paramLong2, this.a);
  }
  
  public void a(Bundle paramBundle, apyv paramapyv)
  {
    if (apxv.a() == null)
    {
      QLog.e("ArkApp.LoginHandler", 1, "LoginHandler.onCall, qq app is null");
      paramapyv.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    long l1 = paramBundle.getLong("srcAppID", 0L);
    long l2 = paramBundle.getLong("dstAppID", 0L);
    if ((l1 == 0L) || (l2 == 0L))
    {
      paramapyv.a(EIPCResult.createResult(0, new Bundle()));
      return;
    }
    a(l1, l2, new apyy(this, paramapyv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyx
 * JD-Core Version:    0.7.0.1
 */