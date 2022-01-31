import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class auot
  extends QIPCModule
{
  private static auot jdField_a_of_type_Auot;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  private auot(String paramString)
  {
    super(paramString);
  }
  
  public static auot a()
  {
    if (jdField_a_of_type_Auot != null) {
      return jdField_a_of_type_Auot;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Auot == null) {
        jdField_a_of_type_Auot = new auot("REAL_NAME");
      }
      auot localauot = jdField_a_of_type_Auot;
      return localauot;
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
    ((ajgd)paramString.a(4)).e();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auot
 * JD-Core Version:    0.7.0.1
 */