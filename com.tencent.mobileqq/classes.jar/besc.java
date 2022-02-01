import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class besc
  extends berz
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    Object localObject;
    try
    {
      localObject = paramJSONObject.getJSONArray("content");
      if (((JSONArray)localObject).length() <= 0) {
        break label333;
      }
      localObject = ((JSONArray)localObject).getJSONObject(0);
      int i = ((JSONObject)localObject).getInt("type");
      if (i == 5)
      {
        if (((JSONObject)localObject).has("file_path")) {
          localTroopFeedItem.linkUrl = ((JSONObject)localObject).getString("file_path");
        }
        localTroopFeedItem.type = 131;
        if (((JSONObject)localObject).has("sharesize")) {
          localTroopFeedItem.ex_1 = ("" + ((JSONObject)localObject).getLong("sharesize"));
        }
        boolean bool = ((JSONObject)localObject).has("bus_id");
        if (bool) {}
        try
        {
          localTroopFeedItem.content = ("" + ((JSONObject)localObject).getLong("bus_id"));
          if (((JSONObject)localObject).has("sharefile")) {
            localTroopFeedItem.title = ((JSONObject)localObject).getString("sharefile");
          }
          if (((JSONObject)localObject).has("shareexpire")) {
            localTroopFeedItem.shareExpire = ((JSONObject)localObject).getLong("shareexpire");
          }
          if (!((JSONObject)localObject).has("sharefromuin")) {
            break label333;
          }
          localTroopFeedItem.shareFromUin = ((JSONObject)localObject).getString("sharefromuin");
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            localTroopFeedItem.content = ("" + ((JSONObject)localObject).getString("bus_id"));
          }
        }
      }
      if (i != 4) {
        break label333;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return null;
    }
    localTroopFeedItem.type = 132;
    localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
    localTroopFeedItem.title = ((JSONObject)localObject).getString("musicname");
    localTroopFeedItem.ex_1 = ((JSONObject)localObject).getString("musicid");
    localTroopFeedItem.picPath = ((JSONObject)localObject).getString("pic_url");
    label333:
    return localTroopFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besc
 * JD-Core Version:    0.7.0.1
 */