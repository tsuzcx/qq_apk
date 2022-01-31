import android.os.Bundle;
import org.json.JSONObject;

class bgjq
  implements bgjt
{
  bgjq(bgjp parambgjp) {}
  
  public void a(JSONObject paramJSONObject, Bundle paramBundle)
  {
    paramJSONObject.put("recommend_on", paramBundle.getString("recommend_on"));
    paramJSONObject.put("recommendPush_on", paramBundle.getString("recommendPush_on"));
    paramJSONObject.put("recommendNotification_on", paramBundle.getString("recommendNotification_on"));
    paramJSONObject.put("recommendChatCachePhoto_on", paramBundle.getString("recommendChatCachePhoto_on"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgjq
 * JD-Core Version:    0.7.0.1
 */