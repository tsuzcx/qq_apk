import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class axfy
  extends QIPCModule
{
  private static axfy jdField_a_of_type_Axfy;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  private axfy(String paramString)
  {
    super(paramString);
  }
  
  public static axfy a()
  {
    if (jdField_a_of_type_Axfy != null) {
      return jdField_a_of_type_Axfy;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Axfy == null) {
        jdField_a_of_type_Axfy = new axfy("REAL_NAME");
      }
      axfy localaxfy = jdField_a_of_type_Axfy;
      return localaxfy;
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
    ((allq)paramString.a(4)).e();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axfy
 * JD-Core Version:    0.7.0.1
 */