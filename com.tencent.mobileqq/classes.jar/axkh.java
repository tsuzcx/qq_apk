import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class axkh
  extends QIPCModule
{
  private static axkh jdField_a_of_type_Axkh;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  private axkh(String paramString)
  {
    super(paramString);
  }
  
  public static axkh a()
  {
    if (jdField_a_of_type_Axkh != null) {
      return jdField_a_of_type_Axkh;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Axkh == null) {
        jdField_a_of_type_Axkh = new axkh("REAL_NAME");
      }
      axkh localaxkh = jdField_a_of_type_Axkh;
      return localaxkh;
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
    ((alqf)paramString.a(4)).e();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axkh
 * JD-Core Version:    0.7.0.1
 */