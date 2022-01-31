import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class biru
  extends QIPCModule
{
  private biru()
  {
    super("AECameraLaunchServer");
  }
  
  public static biru a()
  {
    return birw.a();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("AECameraLaunchServer", 1, "in launch ae camera onCall.");
    if (MobileQQ.sMobileQQ != null)
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        bcql.a(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131717771), 1).a();
        return null;
      }
      paramInt = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", birt.a.a());
      if (paramInt == birt.a.a()) {
        paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
      }
      paramBundle.putInt("AECAMERA_MODE", 200);
      paramBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt);
      paramBundle.putString("KEY_CURRENT_SELECT_ID", paramBundle.getString("widgetid"));
      birx.a(MobileQQ.sMobileQQ, paramBundle);
      return null;
    }
    QLog.e("AECameraLaunchServer", 1, "no mobile qq.");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biru
 * JD-Core Version:    0.7.0.1
 */