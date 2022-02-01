import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ayqe
  extends aypr
{
  ayqe(ayqb paramayqb) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission");
      }
      ayqb.b(this.a);
      int i = this.a.a();
      if ((ayqb.a(this.a)) && (i > 40001) && (!ayqi.a.contains(Integer.valueOf(i))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission cur status: " + ayqb.a(this.a) + " is disabled, updateAutoStatus()");
        }
        ayqb.c(this.a);
      }
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    boolean bool1 = paramBundle.getBoolean("from_register", false);
    boolean bool2 = aypi.a(ayqb.a(this.a).getOnlineStatus(), ayqb.a(this.a).getExtOnlineStatus());
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, new Object[] { "[status][autoMgr] receiveReqOnlineStatusPermission isSuccess=", Boolean.valueOf(paramBoolean), " isFromRegister :", Boolean.valueOf(bool1), " isSmart=", Boolean.valueOf(bool2) });
    }
    if ((paramBoolean) && (bool1) && (bool2)) {
      this.a.a("enableList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqe
 * JD-Core Version:    0.7.0.1
 */