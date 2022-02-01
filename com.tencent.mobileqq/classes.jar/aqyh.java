import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aqyh
  extends aqwr<aqyg>
{
  @NonNull
  public aqyg a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    anjd localanjd = (anjd)localQQAppInterface.a(16);
    if (localanjd != null) {
      localanjd.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new aqyg();
  }
  
  @NonNull
  public aqyg a(aqlg[] paramArrayOfaqlg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    anjd localanjd = (anjd)localQQAppInterface.a(16);
    if (localanjd != null) {
      localanjd.a(localQQAppInterface, paramArrayOfaqlg[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfaqlg[0]);
    }
    return new aqyg();
  }
  
  @NonNull
  public aqyg b()
  {
    return new aqyg();
  }
  
  public Class<aqyg> clazz()
  {
    return aqyg.class;
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
 * Qualified Name:     aqyh
 * JD-Core Version:    0.7.0.1
 */