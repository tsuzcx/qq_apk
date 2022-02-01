import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class anbb
  extends QIPCModule
{
  private static anbb a;
  
  private anbb()
  {
    super("SignInModule");
  }
  
  public static anbb a()
  {
    if (a == null) {
      a = new anbb();
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = paramBundle.getInt("type", 1);
    int i = paramBundle.getInt("result", 2);
    int j = paramBundle.getInt("day", 1);
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "SignInModule onCall type = " + paramInt + ",result = " + i + ",day = " + j);
    }
    if (i == 0)
    {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramString != null)
      {
        paramString.getPreferences();
        paramString = (amov)paramString.getBusinessHandler(2);
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "get oidb0x922 by web");
        }
        paramString.c(0);
        paramString.l();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbb
 * JD-Core Version:    0.7.0.1
 */