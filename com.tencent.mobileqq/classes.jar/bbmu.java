import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class bbmu
{
  private static Class<?> jdField_a_of_type_JavaLangClass;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static Method b;
  private static Method c;
  private static Method d;
  
  static
  {
    try
    {
      jdField_a_of_type_JavaLangClass = Class.forName("android.os.ServiceManager");
      jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("getService", new Class[] { String.class });
      b = jdField_a_of_type_JavaLangClass.getDeclaredMethod("addService", new Class[] { String.class, IBinder.class });
      c = jdField_a_of_type_JavaLangClass.getDeclaredMethod("checkService", new Class[] { String.class });
      d = jdField_a_of_type_JavaLangClass.getDeclaredMethod("listServices", new Class[0]);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
  
  public static IBinder a(String paramString)
  {
    return (IBinder)a(jdField_a_of_type_JavaLangReflectMethod, new Object[] { paramString });
  }
  
  private static Object a(Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(null, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalArgumentException paramMethod)
    {
      paramMethod.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramMethod)
    {
      paramMethod.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmu
 * JD-Core Version:    0.7.0.1
 */