import android.support.annotation.NonNull;

public class bjoj
  implements bjoi
{
  @NonNull
  public <T extends bjof> T a(@NonNull Class<T> paramClass)
  {
    try
    {
      bjof localbjof = (bjof)paramClass.newInstance();
      return localbjof;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Cannot create an instance of " + paramClass, localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Cannot create an instance of " + paramClass, localIllegalAccessException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjoj
 * JD-Core Version:    0.7.0.1
 */