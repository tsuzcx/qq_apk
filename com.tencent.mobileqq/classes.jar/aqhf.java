import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqhf
  extends aqgc<aqhe>
{
  @NonNull
  public aqhe a()
  {
    return new aqhe();
  }
  
  @NonNull
  public aqhe a(aptx[] paramArrayOfaptx)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    bgny.a().a(localQQAppInterface.getApplication(), paramArrayOfaptx, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfaptx);
    }
    return new aqhe();
  }
  
  @NonNull
  public aqhe b()
  {
    return new aqhe();
  }
  
  public Class<aqhe> clazz()
  {
    return aqhe.class;
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
 * Qualified Name:     aqhf
 * JD-Core Version:    0.7.0.1
 */