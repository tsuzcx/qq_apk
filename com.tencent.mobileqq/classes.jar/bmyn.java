import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bmyn
{
  public String a;
  public String b;
  
  public bmyn() {}
  
  public bmyn(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static bmyn a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    bmyn localbmyn = new bmyn();
    localbmyn.a = paramJSONObject.optString("content");
    localbmyn.b = paramJSONObject.optString("url");
    return localbmyn;
  }
  
  public static ArrayList<bmyn> a(ArrayList<BottomContentItem> paramArrayList)
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
        bmyn localbmyn = new bmyn();
        localbmyn.a = localBottomContentItem.content;
        localbmyn.b = localBottomContentItem.url;
        localArrayList.add(localbmyn);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyn
 * JD-Core Version:    0.7.0.1
 */