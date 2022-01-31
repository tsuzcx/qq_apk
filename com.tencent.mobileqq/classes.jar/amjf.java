import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amjf
  extends amie<amje>
{
  public int a()
  {
    return 76;
  }
  
  @NonNull
  public amje a()
  {
    return new amje();
  }
  
  @NonNull
  public amje a(alzs[] paramArrayOfalzs)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    batg.a().a(localQQAppInterface.getApplication(), paramArrayOfalzs, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfalzs);
    }
    return new amje();
  }
  
  public Class<amje> a()
  {
    return amje.class;
  }
  
  @NonNull
  public amje b()
  {
    return new amje();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjf
 * JD-Core Version:    0.7.0.1
 */