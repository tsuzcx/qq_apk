import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class bgwx
  extends QIPCModule
{
  private bgwx()
  {
    super("AECameraLaunchServer");
  }
  
  public static bgwx a()
  {
    return bgwz.a();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("AECameraLaunchServer", 1, "in launch ae camera onCall.");
    if (MobileQQ.sMobileQQ != null)
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        bbmy.a(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131651967), 1).a();
        return null;
      }
      paramInt = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", bgww.a.a());
      if (paramInt == bgww.a.a()) {
        paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
      }
      paramBundle.putInt("AECAMERA_MODE", 200);
      paramBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt);
      paramBundle.putString("KEY_CURRENT_SELECT_ID", paramBundle.getString("widgetid"));
      bgxa.a(MobileQQ.sMobileQQ, paramBundle);
      return null;
    }
    QLog.e("AECameraLaunchServer", 1, "no mobile qq.");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgwx
 * JD-Core Version:    0.7.0.1
 */