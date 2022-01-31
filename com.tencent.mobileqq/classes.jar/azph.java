import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class azph
{
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCEnvironmentInit", 2, "tryConnect");
    }
    try
    {
      Method localMethod = BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.qipc.QIPCEnvironmentInit").getDeclaredMethod("initEnvironment", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QIPCEnvironmentInit", 2, "tryConnect", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azph
 * JD-Core Version:    0.7.0.1
 */