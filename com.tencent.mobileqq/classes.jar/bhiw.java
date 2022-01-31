import android.text.TextUtils;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class bhiw
{
  public static Object a(Object paramObject, String paramString, boolean paramBoolean, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Class localClass = paramObject.getClass();
    if ((paramBoolean) || (paramArrayOfClass != null)) {}
    try
    {
      if (paramArrayOfClass.length == 0) {
        paramString = localClass.getMethod(paramString, new Class[0]);
      }
      while ((paramVarArgs == null) || (paramVarArgs.length == 0))
      {
        return paramString.invoke(paramObject, new Object[0]);
        paramString = localClass.getMethod(paramString, paramArrayOfClass);
        continue;
        if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0)) {
          paramString = localClass.getDeclaredMethod(paramString, new Class[0]);
        } else {
          paramString = localClass.getDeclaredMethod(paramString, paramArrayOfClass);
        }
      }
      paramObject = paramString.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (NoSuchMethodException paramObject)
    {
      QMLog.e("JarReflectUtil", "NoSuchMethodException: " + paramObject.getMessage());
      paramObject.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      QMLog.e("JarReflectUtil", "InvocationTargetException: " + paramObject.getMessage());
      paramObject.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
      QMLog.e("JarReflectUtil", "IllegalAccessException: " + paramObject.getMessage());
      return null;
    }
    catch (NullPointerException paramObject)
    {
      paramObject.printStackTrace();
      QMLog.e("JarReflectUtil", "NullPointerException: " + paramObject.getMessage());
    }
    return null;
  }
  
  public static Object a(String paramString, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
        return paramString.newInstance();
      }
      paramString = paramString.getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      QMLog.e("JarReflectUtil", "ClassNotFoundException: " + paramString.getMessage());
      paramString.printStackTrace();
      return null;
    }
    catch (InstantiationException paramString)
    {
      QMLog.e("JarReflectUtil", "InstantiationException: " + paramString.getMessage());
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      QMLog.e("JarReflectUtil", "IllegalAccessException: " + paramString.getMessage());
      paramString.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      QMLog.e("JarReflectUtil", "NoSuchMethodException: " + paramString.getMessage());
      paramString.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      QMLog.e("JarReflectUtil", "InvocationTargetException: " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Class[] a(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhiw
 * JD-Core Version:    0.7.0.1
 */