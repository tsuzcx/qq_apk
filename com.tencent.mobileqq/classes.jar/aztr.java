import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aztr
  extends QIPCModule
{
  private static aztr jdField_a_of_type_Aztr;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  private aztr(String paramString)
  {
    super(paramString);
  }
  
  public static aztr a()
  {
    if (jdField_a_of_type_Aztr != null) {
      return jdField_a_of_type_Aztr;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aztr == null) {
        jdField_a_of_type_Aztr = new aztr("REAL_NAME");
      }
      aztr localaztr = jdField_a_of_type_Aztr;
      return localaztr;
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
        paramBundle = (ampt)paramString.getBusinessHandler(4);
        if (paramBundle != null)
        {
          if (paramInt == 0) {}
          for (boolean bool = true;; bool = false)
          {
            if (bool) {
              paramString.getPreferences().edit().putBoolean("has_auth_real_name_av", bool).commit();
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
    ((ampt)paramString.getBusinessHandler(4)).f();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztr
 * JD-Core Version:    0.7.0.1
 */