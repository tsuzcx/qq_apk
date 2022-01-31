import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bhdm
{
  public String a;
  public String b;
  
  public bhdm() {}
  
  public bhdm(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static bhdm a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    bhdm localbhdm = new bhdm();
    localbhdm.a = paramJSONObject.optString("content");
    localbhdm.b = paramJSONObject.optString("url");
    return localbhdm;
  }
  
  public static ArrayList<bhdm> a(ArrayList<BottomContentItem> paramArrayList)
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
        bhdm localbhdm = new bhdm();
        localbhdm.a = localBottomContentItem.content;
        localbhdm.b = localBottomContentItem.url;
        localArrayList.add(localbhdm);
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
 * Qualified Name:     bhdm
 * JD-Core Version:    0.7.0.1
 */