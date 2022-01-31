import android.app.Application;
import android.support.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class bjoy
  extends bjpa
{
  private static bjoy jdField_a_of_type_Bjoy;
  private Application jdField_a_of_type_AndroidAppApplication;
  
  public bjoy(@NonNull Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  @NonNull
  public static bjoy a(@NonNull Application paramApplication)
  {
    if (jdField_a_of_type_Bjoy == null) {
      jdField_a_of_type_Bjoy = new bjoy(paramApplication);
    }
    return jdField_a_of_type_Bjoy;
  }
  
  @NonNull
  public <T extends bjow> T a(@NonNull Class<T> paramClass)
  {
    if (bjov.class.isAssignableFrom(paramClass)) {
      try
      {
        bjow localbjow = (bjow)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidAppApplication });
        return localbjow;
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
 * Qualified Name:     bjoy
 * JD-Core Version:    0.7.0.1
 */