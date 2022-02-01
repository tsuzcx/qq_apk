import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class axwf
  extends axvs
{
  axwf(axwc paramaxwc) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission");
      }
      axwc.b(this.a);
      int i = this.a.a();
      if ((axwc.a(this.a)) && (i > 40001) && (!axwj.a.contains(Integer.valueOf(i))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission cur status: " + axwc.a(this.a) + " is disabled, updateAutoStatus()");
        }
        axwc.c(this.a);
      }
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    boolean bool1 = paramBundle.getBoolean("from_register", false);
    boolean bool2 = axvj.a(axwc.a(this.a).getOnlineStatus(), axwc.a(this.a).getExtOnlineStatus());
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, new Object[] { "[status][autoMgr] receiveReqOnlineStatusPermission isSuccess=", Boolean.valueOf(paramBoolean), " isFromRegister :", Boolean.valueOf(bool1), " isSmart=", Boolean.valueOf(bool2) });
    }
    if ((paramBoolean) && (bool1) && (bool2)) {
      this.a.a("enableList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwf
 * JD-Core Version:    0.7.0.1
 */