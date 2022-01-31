import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aori
  extends aopw<aorh>
{
  public int a()
  {
    return 26;
  }
  
  @NonNull
  public aorh a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    allf localallf = (allf)localQQAppInterface.a(16);
    if (localallf != null) {
      localallf.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new aorh();
  }
  
  @NonNull
  public aorh a(aogf[] paramArrayOfaogf)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    allf localallf = (allf)localQQAppInterface.a(16);
    if (localallf != null) {
      localallf.a(localQQAppInterface, paramArrayOfaogf[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfaogf[0]);
    }
    return new aorh();
  }
  
  public Class<aorh> a()
  {
    return aorh.class;
  }
  
  @NonNull
  public aorh b()
  {
    return new aorh();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aori
 * JD-Core Version:    0.7.0.1
 */