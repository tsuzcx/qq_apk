import android.app.Application;
import android.support.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class bmai
  extends bmak
{
  private static bmai jdField_a_of_type_Bmai;
  private Application jdField_a_of_type_AndroidAppApplication;
  
  public bmai(@NonNull Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  @NonNull
  public static bmai a(@NonNull Application paramApplication)
  {
    if (jdField_a_of_type_Bmai == null) {
      jdField_a_of_type_Bmai = new bmai(paramApplication);
    }
    return jdField_a_of_type_Bmai;
  }
  
  @NonNull
  public <T extends bmag> T a(@NonNull Class<T> paramClass)
  {
    if (bmaf.class.isAssignableFrom(paramClass)) {
      try
      {
        bmag localbmag = (bmag)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidAppApplication });
        return localbmag;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmai
 * JD-Core Version:    0.7.0.1
 */