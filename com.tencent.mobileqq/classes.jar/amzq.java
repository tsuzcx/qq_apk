import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amzq
  extends amyp<amzp>
{
  public int a()
  {
    return 76;
  }
  
  @NonNull
  public amzp a()
  {
    return new amzp();
  }
  
  @NonNull
  public amzp a(amph[] paramArrayOfamph)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfamph = paramArrayOfamph[0].a;
    bbwo.a().a(localQQAppInterface.getApplication(), paramArrayOfamph, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfamph);
    }
    return new amzp();
  }
  
  public Class<amzp> a()
  {
    return amzp.class;
  }
  
  @NonNull
  public amzp b()
  {
    return new amzp();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzq
 * JD-Core Version:    0.7.0.1
 */