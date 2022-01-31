import android.app.Application;
import android.support.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class bhwm
  extends bhwo
{
  private static bhwm jdField_a_of_type_Bhwm;
  private Application jdField_a_of_type_AndroidAppApplication;
  
  public bhwm(@NonNull Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  @NonNull
  public static bhwm a(@NonNull Application paramApplication)
  {
    if (jdField_a_of_type_Bhwm == null) {
      jdField_a_of_type_Bhwm = new bhwm(paramApplication);
    }
    return jdField_a_of_type_Bhwm;
  }
  
  @NonNull
  public <T extends bhwk> T a(@NonNull Class<T> paramClass)
  {
    if (bhwj.class.isAssignableFrom(paramClass)) {
      try
      {
        bhwk localbhwk = (bhwk)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidAppApplication });
        return localbhwk;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localInstantiationException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localInvocationTargetException);
      }
    }
    return super.a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhwm
 * JD-Core Version:    0.7.0.1
 */