import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class blxl
{
  public String a;
  public String b;
  
  public blxl() {}
  
  public blxl(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static blxl a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    blxl localblxl = new blxl();
    localblxl.a = paramJSONObject.optString("content");
    localblxl.b = paramJSONObject.optString("url");
    return localblxl;
  }
  
  public static ArrayList<blxl> a(ArrayList<BottomContentItem> paramArrayList)
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
        blxl localblxl = new blxl();
        localblxl.a = localBottomContentItem.content;
        localblxl.b = localBottomContentItem.url;
        localArrayList.add(localblxl);
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
 * Qualified Name:     blxl
 * JD-Core Version:    0.7.0.1
 */