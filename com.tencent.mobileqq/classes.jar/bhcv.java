import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bhcv
{
  public String a;
  public String b;
  
  public bhcv() {}
  
  public bhcv(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static bhcv a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    bhcv localbhcv = new bhcv();
    localbhcv.a = paramJSONObject.optString("content");
    localbhcv.b = paramJSONObject.optString("url");
    return localbhcv;
  }
  
  public static ArrayList<bhcv> a(ArrayList<BottomContentItem> paramArrayList)
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
        bhcv localbhcv = new bhcv();
        localbhcv.a = localBottomContentItem.content;
        localbhcv.b = localBottomContentItem.url;
        localArrayList.add(localbhcv);
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
 * Qualified Name:     bhcv
 * JD-Core Version:    0.7.0.1
 */