import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class avob
  extends QIPCModule
{
  private static avob jdField_a_of_type_Avob;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  private avob(String paramString)
  {
    super(paramString);
  }
  
  public static avob a()
  {
    if (jdField_a_of_type_Avob != null) {
      return jdField_a_of_type_Avob;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Avob == null) {
        jdField_a_of_type_Avob = new avob("REAL_NAME");
      }
      avob localavob = jdField_a_of_type_Avob;
      return localavob;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "onCall s: " + paramString);
    }
    if (paramBundle == null) {}
    do
    {
      do
      {
        return null;
        paramInt = paramBundle.getInt("result");
        if (QLog.isColorLevel()) {
          QLog.i("RealName", 2, "result is : " + paramInt);
        }
      } while (paramInt == 0);
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramString == null);
    ((ajuf)paramString.a(4)).e();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avob
 * JD-Core Version:    0.7.0.1
 */