import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

final class bdwu
  extends SubAccountObserver
{
  bdwu(QQAppInterface paramQQAppInterface) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() thread.name=" + Thread.currentThread().getName());
    }
    paramString1 = (bdxc)this.a.getManager(61);
    int j;
    if ((paramString3 != null) && (paramString3.length() > 0))
    {
      j = 1;
      i = j;
      if (paramString1 != null) {
        paramString1.a(paramString2, paramString3, false);
      }
    }
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        paramString1.f(paramString2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwu
 * JD-Core Version:    0.7.0.1
 */