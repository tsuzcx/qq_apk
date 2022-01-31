import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class amjq
  extends amie<amjp>
{
  public int a()
  {
    return 26;
  }
  
  @NonNull
  public amjp a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ajfs localajfs = (ajfs)localQQAppInterface.a(16);
    if (localajfs != null) {
      localajfs.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new amjp();
  }
  
  @NonNull
  public amjp a(alzs[] paramArrayOfalzs)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ajfs localajfs = (ajfs)localQQAppInterface.a(16);
    if (localajfs != null) {
      localajfs.a(localQQAppInterface, paramArrayOfalzs[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfalzs[0]);
    }
    return new amjp();
  }
  
  public Class<amjp> a()
  {
    return amjp.class;
  }
  
  @NonNull
  public amjp b()
  {
    return new amjp();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjq
 * JD-Core Version:    0.7.0.1
 */