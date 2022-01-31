import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class atgx
{
  public static <T> T a(String paramString, Class<T> paramClass)
  {
    if ((a(paramString)) || (paramClass == null)) {
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString), paramClass);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static <T> T a(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null)) {
      return null;
    }
    try
    {
      Object localObject1 = paramClass.newInstance();
      if (localObject1 == null) {
        return null;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        localInstantiationException.printStackTrace();
        Object localObject2 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Object localObject3;
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
        localObject3 = null;
      }
      Field[] arrayOfField = paramClass.getDeclaredFields();
      if ((arrayOfField == null) || (arrayOfField.length == 0)) {
        return null;
      }
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Field localField = arrayOfField[i];
        if (localField == null) {}
        for (;;)
        {
          i += 1;
          break;
          int k = localField.getModifiers();
          if ((!Modifier.isStatic(k)) || (!Modifier.isFinal(k)))
          {
            paramClass = localField.getName();
            localObject4 = (atgw)localField.getAnnotation(atgw.class);
            if (localObject4 != null) {
              paramClass = ((atgw)localObject4).a();
            }
            if ((!a(paramClass)) && (paramJSONObject.has(paramClass)))
            {
              try
              {
                localObject4 = localField.getType().getSimpleName();
                localField.setAccessible(true);
                if ("int".equals(localObject4)) {
                  localField.set(localObject3, Integer.valueOf(paramJSONObject.optInt(paramClass)));
                }
              }
              catch (IllegalAccessException paramJSONObject)
              {
                paramJSONObject.printStackTrace();
                return null;
              }
              if ("boolean".equals(localObject4))
              {
                localField.set(localObject3, Boolean.valueOf(paramJSONObject.optBoolean(paramClass)));
              }
              else if ("long".equals(localObject4))
              {
                localField.set(localObject3, Long.valueOf(paramJSONObject.optLong(paramClass)));
              }
              else if ("double".equals(localObject4))
              {
                localField.set(localObject3, Double.valueOf(paramJSONObject.optDouble(paramClass)));
              }
              else if ("float".equals(localObject4))
              {
                localField.set(localObject3, Float.valueOf((float)paramJSONObject.optDouble(paramClass)));
              }
              else if ("String".equals(localObject4))
              {
                localField.set(localObject3, paramJSONObject.optString(paramClass));
              }
              else
              {
                if (!"Object".equals(localObject4)) {
                  break label382;
                }
                localField.set(localObject3, new Object());
              }
            }
          }
        }
        label382:
        Object localObject4 = paramJSONObject.opt(paramClass);
        if ((localObject4 instanceof JSONObject)) {
          paramClass = a((JSONObject)localObject4, localField.getType());
        }
        for (;;)
        {
          localField.set(localObject3, paramClass);
          break;
          if ((localObject4 instanceof JSONArray))
          {
            paramClass = (ParameterizedType)localField.getGenericType();
            paramClass = a((JSONArray)localObject4, paramClass.getActualTypeArguments()[0]);
          }
          else
          {
            a("convertFromJSONObject unknown field " + paramClass);
            paramClass = null;
          }
        }
      }
      return localObject3;
    }
  }
  
  public static <T> List<T> a(String paramString, Type paramType)
  {
    if ((a(paramString)) || (paramType == null)) {
      return null;
    }
    try
    {
      paramString = a(new JSONArray(paramString), paramType);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static <T> List<T> a(JSONArray paramJSONArray, Type paramType)
  {
    if ((paramJSONArray == null) || (paramType == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    if (i < j)
    {
      Object localObject = paramJSONArray.opt(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof JSONObject))
        {
          Class localClass = (Class)paramType;
          localArrayList.add(a((JSONObject)localObject, localClass));
        }
        else if ((localObject instanceof JSONArray))
        {
          localArrayList.add(a((JSONArray)localObject, ((ParameterizedType)paramType).getActualTypeArguments()[0]));
        }
        else
        {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
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
        Object localObject2 = (atgw)((Field)localObject1).getAnnotation(atgw.class);
        if (localObject2 != null)
        {
          localObject2 = ((atgw)localObject2).a();
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
  
  private static void a(String paramString)
  {
    QLog.d("JSONConverter", 2, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atgx
 * JD-Core Version:    0.7.0.1
 */