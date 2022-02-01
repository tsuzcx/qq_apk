import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class apvm
  implements apvl
{
  public EIPCResult a(Bundle paramBundle)
  {
    if (apuj.a() == null)
    {
      QLog.e("ArkApp.LaunchMiniappHandler", 1, "LaunchMiniappHandler.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    if (!aptq.a(paramBundle.getString("url")))
    {
      QLog.e("ArkApp.LaunchMiniappHandler", 1, "LaunchMiniappHandler.onCall, launch failed");
      return EIPCResult.createResult(-102, new Bundle());
    }
    return EIPCResult.createResult(0, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvm
 * JD-Core Version:    0.7.0.1
 */