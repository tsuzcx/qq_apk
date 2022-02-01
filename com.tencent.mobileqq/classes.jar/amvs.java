import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class amvs
  implements avsz
{
  amvs(amvo paramamvo) {}
  
  public void a(int paramInt)
  {
    boolean bool1 = amvo.b(this.a);
    amvo.a(this.a, false);
    boolean bool2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onBindStateChanged last:" + bool1 + "  now:" + bool2);
    }
    if (bool1 != bool2) {
      ((FriendListHandler)amvo.a(this.a).getBusinessHandler(1)).notifyUI(92, true, null);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvs
 * JD-Core Version:    0.7.0.1
 */