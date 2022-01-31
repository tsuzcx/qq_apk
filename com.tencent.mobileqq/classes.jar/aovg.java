import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aovg
  extends aouf<aovf>
{
  public int a()
  {
    return 76;
  }
  
  @NonNull
  public aovf a()
  {
    return new aovf();
  }
  
  @NonNull
  public aovf a(aoko[] paramArrayOfaoko)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    bdzy.a().a(localQQAppInterface.getApplication(), paramArrayOfaoko, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfaoko);
    }
    return new aovf();
  }
  
  public Class<aovf> a()
  {
    return aovf.class;
  }
  
  @NonNull
  public aovf b()
  {
    return new aovf();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovg
 * JD-Core Version:    0.7.0.1
 */