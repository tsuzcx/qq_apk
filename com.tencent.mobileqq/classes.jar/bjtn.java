import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import org.json.JSONException;
import org.json.JSONObject;

class bjtn
  extends BroadcastReceiver
{
  private bjtn(bjtl parambjtl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (bjtl.a(this.a).getContext() == null) {
      return;
    }
    paramContext = new JSONObject();
    for (;;)
    {
      try
      {
        String str1 = paramIntent.getStringExtra("file_path");
        String str2 = paramIntent.getStringExtra("video_thumb_path");
        long l = paramIntent.getLongExtra("video_duration", 0L);
        boolean bool = paramIntent.getBooleanExtra("is_video", false);
        paramContext.put("filePath", ((IMiniAppFileManager)bjtl.b(this.a).getManager(IMiniAppFileManager.class)).getWxFilePath(str1));
        if (!bool) {
          continue;
        }
        i = 1;
        paramContext.put("isVideo", i);
        if (bool)
        {
          paramContext.put("videoDuration", (l + 999L) / 1000L);
          paramContext.put("cover", ((IMiniAppFileManager)bjtl.c(this.a).getManager(IMiniAppFileManager.class)).getWxFilePath(str2));
        }
      }
      catch (JSONException paramIntent)
      {
        int i;
        paramIntent.printStackTrace();
        continue;
      }
      QLog.e("LaunchCameraPlugin", 1, "data: " + paramContext);
      bjtl.a(this.a, "custom_event_checkin_onCameraInfoEvent", paramContext.toString());
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtn
 * JD-Core Version:    0.7.0.1
 */