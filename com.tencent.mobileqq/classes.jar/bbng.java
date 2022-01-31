import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bbng
  extends bbnf
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    int i = 0;
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        if (i >= paramJSONObject.length()) {
          break label283;
        }
        localJSONObject = paramJSONObject.getJSONObject(i);
        int j = localJSONObject.getInt("type");
        if (j == 5)
        {
          if (localJSONObject.has("file_path")) {
            localTroopFeedItem.linkUrl = localJSONObject.getString("file_path");
          }
          localTroopFeedItem.type = 0;
          if (localJSONObject.has("sharesize")) {
            localTroopFeedItem.ex_1 = ("" + localJSONObject.getLong("sharesize"));
          }
          boolean bool = localJSONObject.has("bus_id");
          if (bool) {}
          try
          {
            localTroopFeedItem.content = ("" + localJSONObject.getLong("bus_id"));
            if (!localJSONObject.has("sharefile")) {
              break label308;
            }
            localTroopFeedItem.title = localJSONObject.getString("sharefile");
          }
          catch (JSONException localJSONException)
          {
            localTroopFeedItem.content = ("" + localJSONObject.getString("bus_id"));
            continue;
          }
        }
        if (j != 3) {
          break label308;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      if (localJSONObject.has("pic_id"))
      {
        localTroopFeedItem.picPath = ("http://gdynamic.qpic.cn/gdynamic/" + localJSONObject.getString("pic_id") + "/109");
        break label308;
        label283:
        if ((bdje.a(localTroopFeedItem.linkUrl)) || (bdje.a(localTroopFeedItem.content))) {
          break;
        }
        return localTroopFeedItem;
      }
      label308:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbng
 * JD-Core Version:    0.7.0.1
 */