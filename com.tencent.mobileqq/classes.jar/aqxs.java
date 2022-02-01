import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqxs
  extends aqwr<aqxr>
{
  @NonNull
  public aqxr a()
  {
    return new aqxr();
  }
  
  @NonNull
  public aqxr a(aqlg[] paramArrayOfaqlg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    bhgz.a().a(localQQAppInterface.getApplication(), paramArrayOfaqlg, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfaqlg);
    }
    return new aqxr();
  }
  
  @NonNull
  public aqxr b()
  {
    return new aqxr();
  }
  
  public Class<aqxr> clazz()
  {
    return aqxr.class;
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
 * Qualified Name:     aqxs
 * JD-Core Version:    0.7.0.1
 */