import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class apux
  implements apvl
{
  private int a()
  {
    int i = -1;
    if (lfl.a(BaseApplicationImpl.getContext())) {
      i = 1;
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return i;
      if (AudioHelper.a(BaseApplicationImpl.getContext())) {
        return 2;
      }
      localQQAppInterface = apuj.a();
    } while (localQQAppInterface == null);
    if (localQQAppInterface.getLoudSpeakerState()) {
      return 4;
    }
    return 3;
  }
  
  public EIPCResult a(Bundle paramBundle)
  {
    if (apuj.a() == null)
    {
      QLog.e("ArkApp.GetAudioOutputModeHandler", 1, "GetAudioOutputModeHandler.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    int i = a();
    paramBundle = new Bundle();
    paramBundle.putInt("mode", i);
    return EIPCResult.createResult(0, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apux
 * JD-Core Version:    0.7.0.1
 */