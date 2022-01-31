import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bdys
{
  public static <T> JSONArray a(List<T> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localJSONArray;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject != null) {
        if (a(localObject)) {
          localJSONArray.put(localObject);
        } else if ((localObject instanceof List)) {
          localJSONArray.put(a((List)localObject));
        } else {
          localJSONArray.put(a(localObject));
        }
      }
    }
    return localJSONArray;
  }
  
  public static <T> JSONObject a(T paramT)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramT == null) {
      return localJSONObject;
    }
    Field[] arrayOfField = paramT.getClass().getDeclaredFields();
    if ((arrayOfField == null) || (arrayOfField.length == 0)) {
      return localJSONObject;
    }
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = arrayOfField[i];
      if (localObject1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = (bdyh)((Field)localObject1).getAnnotation(bdyh.class);
        if (localObject2 != null)
        {
          localObject2 = ((bdyh)localObject2).a();
          if (!a((String)localObject2))
          {
            try
            {
              localObject1 = ((Field)localObject1).get(paramT);
              if (localObject1 == null) {
                continue;
              }
              if (a(localObject1)) {
                localJSONObject.put((String)localObject2, localObject1);
              }
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
              continue;
              if (!(localJSONException instanceof List)) {
                break label178;
              }
              localJSONObject.put((String)localObject2, a((List)localJSONException));
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              localIllegalAccessException.printStackTrace();
            }
            continue;
            label178:
            localJSONObject.put((String)localObject2, a(localIllegalAccessException));
          }
        }
      }
    }
    return localJSONObject;
  }
  
  private static boolean a(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof Long)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Character)) || ((paramObject instanceof Short));
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdys
 * JD-Core Version:    0.7.0.1
 */