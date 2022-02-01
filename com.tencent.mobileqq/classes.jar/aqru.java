import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class aqru
{
  private static Class<?> jdField_a_of_type_JavaLangClass;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static boolean jdField_a_of_type_Boolean;
  private static Method jdField_b_of_type_JavaLangReflectMethod;
  private static boolean jdField_b_of_type_Boolean;
  
  @RequiresApi(api=16)
  private static void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      jdField_a_of_type_JavaLangReflectMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
      jdField_a_of_type_JavaLangReflectMethod.setAccessible(true);
      arrayOfClass = Activity.class.getDeclaredClasses();
      jdField_a_of_type_JavaLangClass = null;
      j = arrayOfClass.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Class[] arrayOfClass;
        int j;
        int i;
        Class localClass;
        if (QLog.isColorLevel())
        {
          QLog.e("SwipeLayoutUtils", 2, localThrowable, new Object[0]);
          continue;
          i += 1;
        }
      }
    }
    if (i < j)
    {
      localClass = arrayOfClass[i];
      if (localClass.getSimpleName().contains("TranslucentConversionListener")) {
        jdField_a_of_type_JavaLangClass = localClass;
      }
    }
    else
    {
      jdField_b_of_type_JavaLangReflectMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { jdField_a_of_type_JavaLangClass, ActivityOptions.class });
      jdField_b_of_type_JavaLangReflectMethod.setAccessible(true);
      jdField_b_of_type_Boolean = true;
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramActivity, new Object[0]);
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public static void a(Activity paramActivity, InvocationHandler paramInvocationHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b(paramActivity, paramInvocationHandler);
      return;
    }
    b(paramActivity);
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    a();
    return jdField_b_of_type_Boolean;
  }
  
  public static void b(Activity paramActivity)
  {
    Object localObject = null;
    for (;;)
    {
      int i;
      try
      {
        Class[] arrayOfClass = Activity.class.getDeclaredClasses();
        int j = arrayOfClass.length;
        i = 0;
        if (i < j)
        {
          Class localClass = arrayOfClass[i];
          if (localClass.getSimpleName().contains("TranslucentConversionListener")) {
            localObject = localClass;
          }
        }
        else
        {
          localObject = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject });
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramActivity, new Object[] { null });
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        return;
      }
      i += 1;
    }
  }
  
  @RequiresApi(api=16)
  private static void b(Activity paramActivity, InvocationHandler paramInvocationHandler)
  {
    
    try
    {
      Object localObject = jdField_a_of_type_JavaLangReflectMethod.invoke(paramActivity, new Object[0]);
      Class localClass = jdField_a_of_type_JavaLangClass;
      paramInvocationHandler = Proxy.newProxyInstance(jdField_a_of_type_JavaLangClass.getClassLoader(), new Class[] { localClass }, paramInvocationHandler);
      jdField_b_of_type_JavaLangReflectMethod.invoke(paramActivity, new Object[] { paramInvocationHandler, localObject });
      return;
    }
    catch (Throwable paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqru
 * JD-Core Version:    0.7.0.1
 */