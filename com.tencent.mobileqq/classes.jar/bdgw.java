import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Field;

public class bdgw
{
  public static Object a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      Log.e("ReflectionUtil", "ClassNotFoundException: ");
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      Log.e("ReflectionUtil", "IllegalAccessException: ");
      paramString.printStackTrace();
      return null;
    }
    catch (InstantiationException paramString)
    {
      Log.e("ReflectionUtil", "InstantiationException: ");
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      paramString1 = Class.forName(paramString1);
      paramString1 = paramString1.getField(paramString2).get(paramString1);
      return paramString1;
    }
    catch (NoSuchFieldException paramString1)
    {
      Log.w("ReflectionUtil", "NoSuchFieldException: " + paramString1.getMessage());
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      Log.w("ReflectionUtil", "IllegalAccessException: " + paramString1.getMessage());
      return null;
    }
    catch (ClassNotFoundException paramString1)
    {
      Log.w("ReflectionUtil", "ClassNotFoundException: " + paramString1.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdgw
 * JD-Core Version:    0.7.0.1
 */