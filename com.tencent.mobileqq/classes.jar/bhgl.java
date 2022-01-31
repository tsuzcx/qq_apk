import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePusher;
import org.json.JSONException;
import org.json.JSONObject;

public class bhgl
  implements bhhc
{
  public bhgl(MiniAppLivePusher paramMiniAppLivePusher, bgkd parambgkd) {}
  
  public void a()
  {
    QMLog.e("MiniAppLivePusher", "onBGMStart");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher.jdField_a_of_type_Long);
      this.jdField_a_of_type_Bgkd.a.a("onLivePusherBGMStart", localJSONObject.toString(), this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePusher", "onBGMComplete, errCode:" + paramInt);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher.jdField_a_of_type_Long);
      localJSONObject.put("errCode", paramInt);
      this.jdField_a_of_type_Bgkd.a.a("onLivePusherBGMComplete", localJSONObject.toString(), this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QMLog.isColorLevel()) {
      QMLog.e("MiniAppLivePusher", "onBGMProgress progress:" + paramLong1 + ",duration:" + paramLong2);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher.jdField_a_of_type_Long);
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      this.jdField_a_of_type_Bgkd.a.a("onLivePusherBGMProgress", localJSONObject.toString(), this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgl
 * JD-Core Version:    0.7.0.1
 */