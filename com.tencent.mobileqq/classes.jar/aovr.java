import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aovr
  extends aouf<aovq>
{
  public int a()
  {
    return 26;
  }
  
  @NonNull
  public aovq a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    alpu localalpu = (alpu)localQQAppInterface.a(16);
    if (localalpu != null) {
      localalpu.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new aovq();
  }
  
  @NonNull
  public aovq a(aoko[] paramArrayOfaoko)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    alpu localalpu = (alpu)localQQAppInterface.a(16);
    if (localalpu != null) {
      localalpu.a(localQQAppInterface, paramArrayOfaoko[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfaoko[0]);
    }
    return new aovq();
  }
  
  public Class<aovq> a()
  {
    return aovq.class;
  }
  
  @NonNull
  public aovq b()
  {
    return new aovq();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovr
 * JD-Core Version:    0.7.0.1
 */