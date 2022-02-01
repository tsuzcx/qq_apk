import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arkn
  extends arjj<arkm>
{
  @NonNull
  public arkm a()
  {
    return new arkm();
  }
  
  @NonNull
  public arkm a(aqxa[] paramArrayOfaqxa)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    bhyi.a().a(localQQAppInterface.getApplication(), paramArrayOfaqxa, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfaqxa);
    }
    return new arkm();
  }
  
  @NonNull
  public arkm b()
  {
    return new arkm();
  }
  
  public Class<arkm> clazz()
  {
    return arkm.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 76;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkn
 * JD-Core Version:    0.7.0.1
 */