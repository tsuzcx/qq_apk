import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class axpl
  extends aocm
{
  axpl(axpk paramaxpk) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("NearbyNewRedDotManager", 1, "RedpointObserver.onDataChange: isSucc=" + paramBoolean);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null)
    {
      QLog.i("NearbyNewRedDotManager", 1, "RedpointObserver.onDataChange: is destroy");
      return;
    }
    List localList = this.a.a(localQQAppInterface);
    axpk.a(this.a, localQQAppInterface, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpl
 * JD-Core Version:    0.7.0.1
 */