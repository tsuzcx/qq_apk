import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoqx
  extends aopw<aoqw>
{
  public int a()
  {
    return 76;
  }
  
  @NonNull
  public aoqw a()
  {
    return new aoqw();
  }
  
  @NonNull
  public aoqw a(aogf[] paramArrayOfaogf)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    bdvp.a().a(localQQAppInterface.getApplication(), paramArrayOfaogf, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfaogf);
    }
    return new aoqw();
  }
  
  public Class<aoqw> a()
  {
    return aoqw.class;
  }
  
  @NonNull
  public aoqw b()
  {
    return new aoqw();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqx
 * JD-Core Version:    0.7.0.1
 */