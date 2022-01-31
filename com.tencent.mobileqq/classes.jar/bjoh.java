import android.app.Application;
import android.support.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class bjoh
  extends bjoj
{
  private static bjoh jdField_a_of_type_Bjoh;
  private Application jdField_a_of_type_AndroidAppApplication;
  
  public bjoh(@NonNull Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  @NonNull
  public static bjoh a(@NonNull Application paramApplication)
  {
    if (jdField_a_of_type_Bjoh == null) {
      jdField_a_of_type_Bjoh = new bjoh(paramApplication);
    }
    return jdField_a_of_type_Bjoh;
  }
  
  @NonNull
  public <T extends bjof> T a(@NonNull Class<T> paramClass)
  {
    if (bjoe.class.isAssignableFrom(paramClass)) {
      try
      {
        bjof localbjof = (bjof)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidAppApplication });
        return localbjof;
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
 * Qualified Name:     bjoh
 * JD-Core Version:    0.7.0.1
 */