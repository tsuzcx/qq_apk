import android.app.Application;
import android.support.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class bmeu
  extends bmew
{
  private static bmeu jdField_a_of_type_Bmeu;
  private Application jdField_a_of_type_AndroidAppApplication;
  
  public bmeu(@NonNull Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  @NonNull
  public static bmeu a(@NonNull Application paramApplication)
  {
    if (jdField_a_of_type_Bmeu == null) {
      jdField_a_of_type_Bmeu = new bmeu(paramApplication);
    }
    return jdField_a_of_type_Bmeu;
  }
  
  @NonNull
  public <T extends bmes> T a(@NonNull Class<T> paramClass)
  {
    if (bmer.class.isAssignableFrom(paramClass)) {
      try
      {
        bmes localbmes = (bmes)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidAppApplication });
        return localbmes;
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
 * Qualified Name:     bmeu
 * JD-Core Version:    0.7.0.1
 */