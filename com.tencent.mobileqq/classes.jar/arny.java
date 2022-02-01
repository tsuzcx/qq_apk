import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class arny
  extends armf<arnx>
{
  @NonNull
  public arnx a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    anva localanva = (anva)localQQAppInterface.a(16);
    if (localanva != null) {
      localanva.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new arnx();
  }
  
  @NonNull
  public arnx a(araj[] paramArrayOfaraj)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    anva localanva = (anva)localQQAppInterface.a(16);
    if (localanva != null) {
      localanva.a(localQQAppInterface, paramArrayOfaraj[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfaraj[0]);
    }
    return new arnx();
  }
  
  @NonNull
  public arnx b()
  {
    return new arnx();
  }
  
  public Class<arnx> clazz()
  {
    return arnx.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arny
 * JD-Core Version:    0.7.0.1
 */