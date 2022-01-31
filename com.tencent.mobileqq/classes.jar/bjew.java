import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bjew
{
  public String a;
  public String b;
  
  public bjew() {}
  
  public bjew(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static bjew a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    bjew localbjew = new bjew();
    localbjew.a = paramJSONObject.optString("content");
    localbjew.b = paramJSONObject.optString("url");
    return localbjew;
  }
  
  public static ArrayList<bjew> a(ArrayList<BottomContentItem> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      BottomContentItem localBottomContentItem = (BottomContentItem)paramArrayList.next();
      if (localBottomContentItem != null)
      {
        bjew localbjew = new bjew();
        localbjew.a = localBottomContentItem.content;
        localbjew.b = localBottomContentItem.url;
        localArrayList.add(localbjew);
      }
    }
    return localArrayList;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.a);
      localJSONObject.put("url", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QZLog.e("BottomItem", "convert json error", localJSONException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjew
 * JD-Core Version:    0.7.0.1
 */