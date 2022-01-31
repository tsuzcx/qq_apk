import android.os.Bundle;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class bhgi
  implements bhgs
{
  public bhgi(MiniAppLivePlayer paramMiniAppLivePlayer, bgkd parambgkd) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    QMLog.d("MiniAppLivePlayer", "onPlayEvent code:" + paramInt);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("livePlayerId", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePlayer.jdField_a_of_type_Long);
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.get("EVT_MSG"));
      this.jdField_a_of_type_Bgkd.a.a("onLivePlayerEvent", localJSONObject.toString(), this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePlayer.jdField_a_of_type_Int);
      QMLog.e("MiniAppLivePlayer", "operate start evaluateSubcribeJS onLivePlayerEvent = " + localJSONObject.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("VIDEO_BITRATE", paramBundle.get("VIDEO_BITRATE"));
      localJSONObject2.put("AUDIO_BITRATE", paramBundle.get("AUDIO_BITRATE"));
      localJSONObject2.put("VIDEO_FPS", paramBundle.get("VIDEO_FPS"));
      localJSONObject2.put("VIDEO_GOP", paramBundle.get("VIDEO_GOP"));
      localJSONObject2.put("NET_SPEED", paramBundle.get("NET_SPEED"));
      localJSONObject2.put("NET_JITTER", paramBundle.get("NET_JITTER"));
      localJSONObject2.put("VIDEO_WIDTH", paramBundle.get("VIDEO_WIDTH"));
      localJSONObject2.put("VIDEO_HEIGHT", paramBundle.get("VIDEO_HEIGHT"));
      localJSONObject1.put("livePlayerId", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePlayer.jdField_a_of_type_Long);
      localJSONObject1.put("info", localJSONObject2);
      this.jdField_a_of_type_Bgkd.a.a("onLivePlayerNetStatus", localJSONObject1.toString(), this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePlayer.jdField_a_of_type_Int);
      QMLog.e("MiniAppLivePlayer", "operate start evaluateSubcribeJS onLivePlayerNetStatus = " + localJSONObject1.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgi
 * JD-Core Version:    0.7.0.1
 */