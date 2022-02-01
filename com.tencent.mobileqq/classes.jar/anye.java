import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class anye
  implements awza
{
  anye(anyb paramanyb) {}
  
  public void a(int paramInt)
  {
    boolean bool1 = anyb.b(this.a);
    anyb.a(this.a, false);
    boolean bool2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onBindStateChanged last:" + bool1 + "  now:" + bool2);
    }
    if (bool1 != bool2) {
      ((FriendListHandler)anyb.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(92, true, null);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anye
 * JD-Core Version:    0.7.0.1
 */