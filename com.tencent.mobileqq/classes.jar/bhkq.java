import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class bhkq
  implements bhlb
{
  public bhkq(MiniAppLivePlayer paramMiniAppLivePlayer, bgok parambgok) {}
  
  public void a(int paramInt)
  {
    QMLog.d("MiniAppLivePlayer", "onAudioVolumeEvaluationNotify code:" + paramInt);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("livePlayerId", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePlayer.jdField_a_of_type_Long);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("volume", paramInt);
      localJSONObject1.put("info", localJSONObject2);
      this.jdField_a_of_type_Bgok.a.a("onLivePlayerAudioVolumeNotify", localJSONObject1.toString(), this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePlayer.jdField_a_of_type_Int);
      if (QMLog.isColorLevel()) {
        QMLog.e("MiniAppLivePlayer", "onAudioVolumeEvaluationNotify resultObj.toString() = " + localJSONObject1.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkq
 * JD-Core Version:    0.7.0.1
 */