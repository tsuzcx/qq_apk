import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkys
{
  public static ArrayList<Object> a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.opt(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject.getClass() == JSONObject.class) {
          localArrayList.add(a((JSONObject)localObject));
        } else if (localObject.getClass() == JSONArray.class) {
          localArrayList.add(a((JSONArray)localObject));
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<String, Object> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localLinkedHashMap;
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = localIterator.next() + "";
      Object localObject = paramJSONObject.get(str);
      if (localObject != null) {
        if (localObject.getClass() == JSONObject.class) {
          localLinkedHashMap.put(str, a((JSONObject)localObject));
        } else if (localObject.getClass() == JSONArray.class) {
          localLinkedHashMap.put(str, a((JSONArray)localObject));
        } else {
          localLinkedHashMap.put(str, localObject);
        }
      }
    }
    return localLinkedHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkys
 * JD-Core Version:    0.7.0.1
 */