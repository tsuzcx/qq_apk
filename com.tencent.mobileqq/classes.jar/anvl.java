import com.tencent.mobileqq.app.FriendsManager.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class anvl
  extends AccountObserver
{
  anvl(anvk paramanvk) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.executeOnSubThread(new FriendsManager.1.1(this, paramString2, paramString1));
  }
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "onOnlineStatusChanged isSuccess = " + paramBoolean1 + " ,curStatus =  , isUserSet = " + paramStatus + " ,isFriendListChang = " + paramBoolean3 + " ,timeStamp = " + paramLong + " ,isGatherListChange = " + paramBoolean4);
    }
    anvk.a(this.a).mAutomator.a(paramBoolean3, paramLong, paramBoolean4);
    if (!paramBoolean3)
    {
      aobu localaobu = new aobu(anvk.a(this.a));
      anvk.a(this.a).mAutomator.a(101, localaobu);
    }
    ((azbv)anvk.a(this.a).getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a(paramBoolean1, paramStatus);
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    super.onOnlineStatusPush(paramStatus, paramLong);
    ((azbv)anvk.a(this.a).getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvl
 * JD-Core Version:    0.7.0.1
 */