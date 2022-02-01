import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aqhw
  extends aqgc<aqhv>
{
  @NonNull
  public aqhv a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ampi localampi = (ampi)localQQAppInterface.getBusinessHandler(16);
    if (localampi != null) {
      localampi.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new aqhv();
  }
  
  @NonNull
  public aqhv a(aptx[] paramArrayOfaptx)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ampi localampi = (ampi)localQQAppInterface.getBusinessHandler(16);
    if (localampi != null) {
      localampi.a(localQQAppInterface, paramArrayOfaptx[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfaptx[0]);
    }
    return new aqhv();
  }
  
  @NonNull
  public aqhv b()
  {
    return new aqhv();
  }
  
  public Class<aqhv> clazz()
  {
    return aqhv.class;
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
 * Qualified Name:     aqhw
 * JD-Core Version:    0.7.0.1
 */