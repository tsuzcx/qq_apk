import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amzj
  extends amyi<amzi>
{
  public int a()
  {
    return 76;
  }
  
  @NonNull
  public amzi a()
  {
    return new amzi();
  }
  
  @NonNull
  public amzi a(ampi[] paramArrayOfampi)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfampi = paramArrayOfampi[0].a;
    bbwa.a().a(localQQAppInterface.getApplication(), paramArrayOfampi, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfampi);
    }
    return new amzi();
  }
  
  public Class<amzi> a()
  {
    return amzi.class;
  }
  
  @NonNull
  public amzi b()
  {
    return new amzi();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzj
 * JD-Core Version:    0.7.0.1
 */