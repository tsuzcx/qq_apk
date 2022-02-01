import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arnh
  extends armf<arng>
{
  @NonNull
  public arng a()
  {
    return new arng();
  }
  
  @NonNull
  public arng a(araj[] paramArrayOfaraj)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    biho.a().a(localQQAppInterface.getApplication(), paramArrayOfaraj, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfaraj);
    }
    return new arng();
  }
  
  @NonNull
  public arng b()
  {
    return new arng();
  }
  
  public Class<arng> clazz()
  {
    return arng.class;
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
 * Qualified Name:     arnh
 * JD-Core Version:    0.7.0.1
 */