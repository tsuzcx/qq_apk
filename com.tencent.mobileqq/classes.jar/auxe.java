import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class auxe
  extends QIPCModule
{
  private static volatile auxe a;
  public static volatile boolean a;
  
  private auxe(String paramString)
  {
    super(paramString);
  }
  
  public static auxe a()
  {
    if (jdField_a_of_type_Auxe == null) {}
    try
    {
      if (jdField_a_of_type_Auxe == null) {
        jdField_a_of_type_Auxe = new auxe("FlutterSubQIPCModule");
      }
      return jdField_a_of_type_Auxe;
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
    boolean bool1;
    if ("ACTION_INSTALL_RESULT".equals(paramString))
    {
      bool1 = paramBundle.getBoolean("KEY_INSTALL_RESULT");
      paramString = paramBundle.getString("KEY_INSTALL_DIR");
      boolean bool2 = paramBundle.getBoolean("KEY_IS_ENGINE_EXIST");
      boolean bool3 = paramBundle.getBoolean("KEY_IS_APP_EXIST");
      QLog.d("FlutterSubQIPCModule", 1, String.format("install finish isSuccess: %s, installDir: %s, isEngineExist: %s, isAppExist: %s", new Object[] { Boolean.valueOf(bool1), paramString, Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
      auxj.a().a(bool1, paramString, bool2, bool3);
    }
    for (;;)
    {
      return null;
      if ("ACTION_PREDOWNLOAD_RESULT".equals(paramString))
      {
        bool1 = paramBundle.getBoolean("KEY_INSTALL_RESULT");
        QLog.d("FlutterSubQIPCModule", 1, "predownload finish isSuccess=" + bool1);
        LocalMultiProcConfig.putBool("qzone_flutter_predownload_success", bool1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxe
 * JD-Core Version:    0.7.0.1
 */