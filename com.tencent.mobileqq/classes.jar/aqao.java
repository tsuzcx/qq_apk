import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class aqao
  extends QIPCModule
{
  private static volatile aqao a;
  public static volatile boolean a;
  
  private aqao(String paramString)
  {
    super(paramString);
  }
  
  public static aqao a()
  {
    if (jdField_a_of_type_Aqao == null) {}
    try
    {
      if (jdField_a_of_type_Aqao == null) {
        jdField_a_of_type_Aqao = new aqao("FlutterSubQIPCModule");
      }
      return jdField_a_of_type_Aqao;
    }
    finally {}
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      QIPCClientHelper.getInstance().register(a());
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FlutterSubQIPCModule", 1, "register", localException);
    }
  }
  
  public static void b()
  {
    try
    {
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        jdField_a_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FlutterSubQIPCModule", 1, "unregister", localException);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("ACTION_INSTALL_RESULT".equals(paramString))
    {
      boolean bool1 = paramBundle.getBoolean("KEY_INSTALL_RESULT");
      paramString = paramBundle.getString("KEY_INSTALL_DIR");
      boolean bool2 = paramBundle.getBoolean("KEY_IS_ENGINE_EXIST");
      boolean bool3 = paramBundle.getBoolean("KEY_IS_APP_EXIST");
      if (QLog.isColorLevel()) {
        QLog.d("FlutterSubQIPCModule", 2, String.format("install finish isSuccess: %s, engineDir: %s, isEngineExist: %s, isAppExist: %s", new Object[] { Boolean.valueOf(bool1), paramString, Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
      }
      aqai.a(bool1, paramString, bool2, bool3);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqao
 * JD-Core Version:    0.7.0.1
 */