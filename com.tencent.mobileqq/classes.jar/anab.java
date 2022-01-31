import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class anab
  extends amyp<anaa>
{
  public int a()
  {
    return 26;
  }
  
  @NonNull
  public anaa a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ajts localajts = (ajts)localQQAppInterface.a(16);
    if (localajts != null) {
      localajts.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new anaa();
  }
  
  @NonNull
  public anaa a(amph[] paramArrayOfamph)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ajts localajts = (ajts)localQQAppInterface.a(16);
    if (localajts != null) {
      localajts.a(localQQAppInterface, paramArrayOfamph[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfamph[0]);
    }
    return new anaa();
  }
  
  public Class<anaa> a()
  {
    return anaa.class;
  }
  
  @NonNull
  public anaa b()
  {
    return new anaa();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anab
 * JD-Core Version:    0.7.0.1
 */