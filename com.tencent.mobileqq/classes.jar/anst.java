import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule.1;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class anst
  extends QIPCModule
{
  private static anst a;
  
  private anst(String paramString)
  {
    super(paramString);
  }
  
  public static anst a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anst("EmoticonIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonIPCModule", 2, "onCall action = " + paramString);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonIPCModule", 2, "cannot get QQAppInterface.");
      }
      return null;
    }
    ThreadManager.post(new EmoticonIPCModule.1(this, paramBundle, paramString, ((bbrg)((QQAppInterface)localAppRuntime).getManager(235)).a, paramInt), 5, null, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anst
 * JD-Core Version:    0.7.0.1
 */