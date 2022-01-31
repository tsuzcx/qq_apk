import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.util.QIMFlowCameraJsApiPlugin;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.ShortVideoTravellerManager.TravellerVideoItem;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aoyz
  extends Client.onRemoteRespObserver
{
  public aoyz(QIMFlowCameraJsApiPlugin paramQIMFlowCameraJsApiPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    int i = 0;
    if ((paramBundle != null) && (paramBundle.getInt("respkey") == QIMFlowCameraJsApiPlugin.a(this.a).key))
    {
      str = paramBundle.getString("cmd");
      if (!"get_traveller_video_list".equals(str)) {
        break label185;
      }
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      paramBundle.setClassLoader(ShortVideoTravellerManager.TravellerVideoItem.class.getClassLoader());
      paramBundle = paramBundle.getParcelableArrayList("getDemoVideoList");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("IPC_CMD_GET_TRAVELLER_VIDEO_LIST size=");
        if (paramBundle != null) {
          i = paramBundle.size();
        }
        QLog.d("QIMFlowCameraJsApiPlugin", 2, i);
      }
      paramBundle = this.a.a(paramBundle);
      if ((!TextUtils.isEmpty(str)) && (paramBundle != null)) {
        localObject = new JSONObject();
      }
    }
    label185:
    while (!"download_video_from_web".equals(str)) {
      try
      {
        Object localObject;
        ((JSONObject)localObject).put("list", paramBundle);
        this.a.callJs(str, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    String str = paramBundle.getString("callbackid");
    i = paramBundle.getInt("download_res_code");
    int j = paramBundle.getInt("videoId");
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("result", i);
      paramBundle.put("videoId", String.valueOf(j));
      this.a.callJs(str, new String[] { paramBundle.toString() });
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoyz
 * JD-Core Version:    0.7.0.1
 */