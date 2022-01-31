import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class belj
{
  private static Object a(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof JSONObject)) {
      localObject = a((JSONObject)paramObject);
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (!(paramObject instanceof JSONArray));
    return a((JSONArray)paramObject);
  }
  
  private static String a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        if (i > 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        localStringBuilder.append(str1).append("=").append(str2).append("&");
      }
      if (localStringBuilder.length() <= 0) {
        break label84;
      }
    }
    catch (Exception paramJSONObject)
    {
      return null;
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    label84:
    return localStringBuilder.toString();
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      if (!paramJSONArray.isNull(i)) {
        localArrayList.add(a(paramJSONArray.opt(i)));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = paramJSONObject.opt(str);
        if (!paramJSONObject.isNull(str)) {
          localHashMap.put(str, a(localObject));
        }
      }
    }
    return localHashMap;
  }
  
  public static JSONArray a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    int k = 0;
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramJSONArray1.length()) {
        break;
      }
      localJSONArray.put(paramJSONArray1.get(i));
      i += 1;
    }
    while (j < paramJSONArray2.length())
    {
      localJSONArray.put(paramJSONArray2.get(j));
      j += 1;
    }
    return localJSONArray;
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static JSONObject a(Map<String, List<String>> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, a((List)paramMap.get(str)));
      }
      catch (JSONException localJSONException) {}
    }
    return localJSONObject;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramObject);
      return localJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      betc.d("JSONUtil", "", paramJSONObject);
    }
    return localJSONObject;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static int[] a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramJSONArray.length()];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = paramJSONArray.optInt(i);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static String[] a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    String[] arrayOfString = new String[paramJSONArray.length()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = paramJSONArray.optString(i);
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String[][] a(JSONObject paramJSONObject, String paramString)
  {
    String[][] arrayOfString = (String[][])null;
    Object localObject1 = arrayOfString;
    localObject2 = arrayOfString;
    try
    {
      if (paramJSONObject.has(paramString))
      {
        localObject1 = arrayOfString;
        paramString = paramJSONObject.getJSONArray(paramString);
        localObject1 = arrayOfString;
        paramJSONObject = new String[paramString.length()][];
        int i = 0;
        for (;;)
        {
          localObject1 = paramJSONObject;
          localObject2 = paramJSONObject;
          if (i >= paramString.length()) {
            break;
          }
          localObject1 = paramJSONObject;
          localObject2 = paramString.getJSONArray(i);
          localObject1 = paramJSONObject;
          paramJSONObject[i] = new String[((JSONArray)localObject2).length()];
          int j = 0;
          for (;;)
          {
            localObject1 = paramJSONObject;
            if (j >= ((JSONArray)localObject2).length()) {
              break;
            }
            localObject1 = paramJSONObject;
            paramJSONObject[i][j] = ((JSONArray)localObject2).getString(j);
            j += 1;
          }
          i += 1;
        }
      }
      return localObject2;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      localObject2 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     belj
 * JD-Core Version:    0.7.0.1
 */