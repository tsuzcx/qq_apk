import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class amzu
  extends amyi<amzt>
{
  public int a()
  {
    return 26;
  }
  
  @NonNull
  public amzt a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ajtu localajtu = (ajtu)localQQAppInterface.a(16);
    if (localajtu != null) {
      localajtu.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new amzt();
  }
  
  @NonNull
  public amzt a(ampi[] paramArrayOfampi)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ajtu localajtu = (ajtu)localQQAppInterface.a(16);
    if (localajtu != null) {
      localajtu.a(localQQAppInterface, paramArrayOfampi[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfampi[0]);
    }
    return new amzt();
  }
  
  public Class<amzt> a()
  {
    return amzt.class;
  }
  
  @NonNull
  public amzt b()
  {
    return new amzt();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzu
 * JD-Core Version:    0.7.0.1
 */