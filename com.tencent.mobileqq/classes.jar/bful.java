import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bful
{
  public String a;
  public String b;
  
  public bful() {}
  
  public bful(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static bful a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    bful localbful = new bful();
    localbful.a = paramJSONObject.optString("content");
    localbful.b = paramJSONObject.optString("url");
    return localbful;
  }
  
  public static ArrayList<bful> a(ArrayList<BottomContentItem> paramArrayList)
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
        bful localbful = new bful();
        localbful.a = localBottomContentItem.content;
        localbful.b = localBottomContentItem.url;
        localArrayList.add(localbful);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bful
 * JD-Core Version:    0.7.0.1
 */