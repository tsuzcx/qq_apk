import android.os.Bundle;
import org.json.JSONObject;

class bmng
  implements bmnh
{
  bmng(bmnd parambmnd) {}
  
  public void a(JSONObject paramJSONObject, Bundle paramBundle)
  {
    paramJSONObject.put("event_video_album_state", paramBundle.getString("event_video_album_state"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmng
 * JD-Core Version:    0.7.0.1
 */