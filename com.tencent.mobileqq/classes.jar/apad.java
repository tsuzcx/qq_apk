import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager.1.1;
import com.tencent.qphone.base.util.QLog;

public class apad
  extends awhw
{
  apad(apac paramapac) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    aufv localaufv = (aufv)this.a.a.getManager(11);
    int i = localaufv.d();
    String str1 = this.a.a.getCurrentAccountUin();
    String str2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + apac.b(str2) + " | currentUin = " + apac.b(str1));
    }
    if (localaufv.c()) {
      if (TextUtils.isEmpty(str2)) {
        apac.a(this.a).removeCallbacksAndMessages(null);
      }
    }
    do
    {
      do
      {
        apac.a(this.a).sendEmptyMessage(1);
        do
        {
          return;
        } while (str1.equals(str2));
        apac.a(this.a).removeCallbacksAndMessages(null);
        apac.a(this.a).sendEmptyMessage(2);
        apac.a(this.a).sendEmptyMessage(1);
        return;
      } while ((i != 5) && (i != 1) && ((i != 6) || (localaufv.a() == null) || (localaufv.a().lastUsedFlag != 3L)) && ((i != 7) || (localaufv.a() == null) || (!localaufv.a().isStopFindMatch)));
      if ((i == 5) || (i == 1)) {
        ThreadManager.excute(new ContactSyncManager.1.1(this), 16, null, false);
      }
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.a.a.getCurrentAccountUin())));
    apac.a(this.a).removeCallbacksAndMessages(null);
    apac.a(this.a).sendEmptyMessage(2);
  }
  
  protected void d(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean + " | updateFlag = " + paramInt);
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apad
 * JD-Core Version:    0.7.0.1
 */