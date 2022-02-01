import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class bazf
  extends QIPCModule
{
  private static bazf jdField_a_of_type_Bazf;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  private bazf(String paramString)
  {
    super(paramString);
  }
  
  public static bazf a()
  {
    if (jdField_a_of_type_Bazf != null) {
      return jdField_a_of_type_Bazf;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bazf == null) {
        jdField_a_of_type_Bazf = new bazf("REAL_NAME");
      }
      bazf localbazf = jdField_a_of_type_Bazf;
      return localbazf;
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
      return null;
      paramInt = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("source");
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "result is : " + paramInt);
      }
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle != null) && (paramString != null) && (TextUtils.equals(paramBundle, "avgame")))
      {
        paramBundle = (anvl)paramString.a(4);
        if (paramBundle != null)
        {
          if (paramInt == 0) {}
          for (boolean bool = true;; bool = false)
          {
            if (bool) {
              paramString.getPreferences().edit().putBoolean("has_auth_real_name", bool).commit();
            }
            if (QLog.isColorLevel()) {
              QLog.i("RealName", 2, "notifyUI");
            }
            paramBundle.notifyUI(15, true, new Object[] { Boolean.valueOf(bool) });
            return null;
          }
        }
      }
    } while ((paramInt == 0) || (paramString == null));
    ((anvl)paramString.a(4)).f();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazf
 * JD-Core Version:    0.7.0.1
 */