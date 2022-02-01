import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfhy
  extends bfht
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    int j = 0;
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 12;
    for (;;)
    {
      int i;
      try
      {
        localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
        paramJSONObject = paramJSONObject.getJSONObject("vote");
        if (paramJSONObject != null)
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("opts");
          i = 0;
          if ((i >= localJSONArray.length()) || (j > 1))
          {
            paramJSONObject = paramJSONObject.getJSONArray("title");
            if (paramJSONObject.length() > 0) {
              localTroopFeedItem.title = paramJSONObject.getJSONObject(0).getString("value");
            }
          }
          else
          {
            Object localObject = localJSONArray.getJSONArray(i);
            k = j;
            if (((JSONArray)localObject).length() <= 0) {
              break label177;
            }
            localObject = ((JSONArray)localObject).getJSONObject(0);
            if (j == 0) {
              localTroopFeedItem.content = ((JSONObject)localObject).getString("value");
            } else {
              localTroopFeedItem.ex_1 = ((JSONObject)localObject).getString("value");
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      return localTroopFeedItem;
      int k = j + 1;
      label177:
      i += 1;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhy
 * JD-Core Version:    0.7.0.1
 */