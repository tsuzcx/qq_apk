import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager.1.1;
import com.tencent.qphone.base.util.QLog;

public class arcz
  extends aywi
{
  public arcz(ContactSyncManager paramContactSyncManager) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    awmz localawmz = (awmz)this.a.a.getManager(11);
    int i = localawmz.d();
    String str1 = this.a.a.getCurrentAccountUin();
    String str2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + ContactSyncManager.b(str2) + " | currentUin = " + ContactSyncManager.b(str1));
    }
    if (localawmz.d()) {
      if (TextUtils.isEmpty(str2)) {
        ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
      }
    }
    do
    {
      do
      {
        ContactSyncManager.a(this.a).sendEmptyMessage(1);
        do
        {
          return;
        } while (str1.equals(str2));
        ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
        ContactSyncManager.a(this.a).sendEmptyMessage(2);
        ContactSyncManager.a(this.a).sendEmptyMessage(1);
        return;
      } while ((i != 5) && (i != 1) && ((i != 6) || (localawmz.a() == null) || (localawmz.a().lastUsedFlag != 3L)) && ((i != 7) || (localawmz.a() == null) || (!localawmz.a().isStopFindMatch)));
      if ((i == 5) || (i == 1)) {
        ThreadManager.excute(new ContactSyncManager.1.1(this), 16, null, false);
      }
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.a.a.getCurrentAccountUin())));
    ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
    ContactSyncManager.a(this.a).sendEmptyMessage(2);
  }
  
  protected void e(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean + " | updateFlag = " + paramInt);
    }
    this.a.b(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcz
 * JD-Core Version:    0.7.0.1
 */