import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class azos
  extends azou
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 18;
    try
    {
      localTroopFeedItem.title = (paramJSONObject.getString("album_name") + ajyc.a(2131715306) + paramJSONObject.getString("photo_num") + ajyc.a(2131715308));
      localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
      paramJSONObject = paramJSONObject.getJSONArray("content");
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          if (localJSONObject.getInt("type") == 3) {
            localTroopFeedItem.picPath = (localJSONObject.getString("pic_url") + "200");
          }
        }
        else
        {
          return localTroopFeedItem;
        }
        i += 1;
      }
      return null;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azos
 * JD-Core Version:    0.7.0.1
 */