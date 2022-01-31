import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bjal
{
  public static AppInterface a()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
      if ((localObject instanceof PeakAppInterface))
      {
        localObject = (PeakAppInterface)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("CaptureContext", 1, "getAppRuntime fail, ", localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjal
 * JD-Core Version:    0.7.0.1
 */