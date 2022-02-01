import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.photoplus.PhotoPlusModule.1;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class bkkj
  extends QIPCModule
{
  private static bkkj a;
  
  private bkkj()
  {
    super("PhotoPlusModule");
  }
  
  public static bkkj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bkkj();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusModule", 2, "[onCall] action = " + paramString + ", params = " + paramBundle + ", callbackId=" + paramInt);
    }
    paramBundle = BaseApplicationImpl.sApplication.getRuntime();
    if (!QQAppInterface.class.isInstance(paramBundle)) {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPlusModule", 2, "[onCall] get app failed.");
      }
    }
    do
    {
      return null;
      paramBundle = (PhotoPlusManager)paramBundle.getManager(169);
      if ("action_get_sticker_templates".equals(paramString))
      {
        paramBundle.b(true);
        ThreadManager.postImmediately(new PhotoPlusModule.1(this, paramBundle, paramInt), null, true);
        return null;
      }
      if ("action_exit_sticker".equals(paramString))
      {
        paramBundle.b(false);
        return null;
      }
    } while (!"action_jump_to_shortvideo".equals(paramString));
    paramBundle.c(true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkj
 * JD-Core Version:    0.7.0.1
 */