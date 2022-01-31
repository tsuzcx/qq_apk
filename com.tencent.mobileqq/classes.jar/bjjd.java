import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bjjd
{
  public String a;
  public String b;
  
  public bjjd() {}
  
  public bjjd(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static bjjd a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    bjjd localbjjd = new bjjd();
    localbjjd.a = paramJSONObject.optString("content");
    localbjjd.b = paramJSONObject.optString("url");
    return localbjjd;
  }
  
  public static ArrayList<bjjd> a(ArrayList<BottomContentItem> paramArrayList)
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
        bjjd localbjjd = new bjjd();
        localbjjd.a = localBottomContentItem.content;
        localbjjd.b = localBottomContentItem.url;
        localArrayList.add(localbjjd);
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
 * Qualified Name:     bjjd
 * JD-Core Version:    0.7.0.1
 */