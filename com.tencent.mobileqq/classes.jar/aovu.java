import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager.1.1;
import com.tencent.qphone.base.util.QLog;

public class aovu
  extends awdn
{
  aovu(aovt paramaovt) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    aubm localaubm = (aubm)this.a.a.getManager(11);
    int i = localaubm.d();
    String str1 = this.a.a.getCurrentAccountUin();
    String str2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + aovt.b(str2) + " | currentUin = " + aovt.b(str1));
    }
    if (localaubm.c()) {
      if (TextUtils.isEmpty(str2)) {
        aovt.a(this.a).removeCallbacksAndMessages(null);
      }
    }
    do
    {
      do
      {
        aovt.a(this.a).sendEmptyMessage(1);
        do
        {
          return;
        } while (str1.equals(str2));
        aovt.a(this.a).removeCallbacksAndMessages(null);
        aovt.a(this.a).sendEmptyMessage(2);
        aovt.a(this.a).sendEmptyMessage(1);
        return;
      } while ((i != 5) && (i != 1) && ((i != 6) || (localaubm.a() == null) || (localaubm.a().lastUsedFlag != 3L)) && ((i != 7) || (localaubm.a() == null) || (!localaubm.a().isStopFindMatch)));
      if ((i == 5) || (i == 1)) {
        ThreadManager.excute(new ContactSyncManager.1.1(this), 16, null, false);
      }
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.a.a.getCurrentAccountUin())));
    aovt.a(this.a).removeCallbacksAndMessages(null);
    aovt.a(this.a).sendEmptyMessage(2);
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
 * Qualified Name:     aovu
 * JD-Core Version:    0.7.0.1
 */