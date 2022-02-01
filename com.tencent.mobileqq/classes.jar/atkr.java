import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class atkr
{
  public static Object a(Map<String, Object> paramMap, Class<?> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    if (paramMap == null) {
      return localObject2;
    }
    localObject2 = localObject1;
    for (;;)
    {
      Field localField;
      try
      {
        localObject1 = paramClass.newInstance();
        localObject2 = localObject1;
        Field[] arrayOfField = localObject1.getClass().getDeclaredFields();
        localObject2 = localObject1;
        int j = arrayOfField.length;
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        localField = arrayOfField[i];
        localObject2 = localObject1;
        int k = localField.getModifiers();
        localObject2 = localObject1;
        if (Modifier.isStatic(k)) {
          break label195;
        }
        localObject2 = localObject1;
        if (Modifier.isFinal(k)) {
          break label195;
        }
        localObject2 = localObject1;
        localField.setAccessible(true);
        localObject2 = localObject1;
        if (paramMap.containsKey(localField.getName()))
        {
          localObject2 = localObject1;
          localField.set(localObject1, paramMap.get(localField.getName()));
        }
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
        return localObject2;
      }
      localObject2 = localObject1;
      QLog.e("QFlutter.ModelUtils", 1, String.format("mapToObject, %s.%s is null", new Object[] { paramClass.getSimpleName(), localField.getName() }));
      label195:
      i += 1;
    }
  }
  
  public static Map a(Object paramObject)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localHashMap = new HashMap();
      try
      {
        Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
        int j = arrayOfField.length;
        int i = 0;
        for (;;)
        {
          localObject = localHashMap;
          if (i >= j) {
            break;
          }
          localObject = arrayOfField[i];
          ((Field)localObject).setAccessible(true);
          localHashMap.put(((Field)localObject).getName(), ((Field)localObject).get(paramObject));
          i += 1;
        }
        return localHashMap;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atkr
 * JD-Core Version:    0.7.0.1
 */