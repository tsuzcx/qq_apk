import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class azix
  extends azik
{
  azix(aziu paramaziu) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission");
      }
      aziu.b(this.a);
      int i = this.a.a();
      if ((aziu.a(this.a)) && (i > 40001) && (!azjb.a.contains(Integer.valueOf(i))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission cur status: " + aziu.a(this.a) + " is disabled, updateAutoStatus()");
        }
        aziu.c(this.a);
      }
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    boolean bool1 = paramBundle.getBoolean("from_register", false);
    boolean bool2 = azib.a(aziu.a(this.a).getOnlineStatus(), aziu.a(this.a).getExtOnlineStatus());
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, new Object[] { "[status][autoMgr] receiveReqOnlineStatusPermission isSuccess=", Boolean.valueOf(paramBoolean), " isFromRegister :", Boolean.valueOf(bool1), " isSmart=", Boolean.valueOf(bool2) });
    }
    if ((paramBoolean) && (bool1) && (bool2)) {
      this.a.a("enableList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azix
 * JD-Core Version:    0.7.0.1
 */