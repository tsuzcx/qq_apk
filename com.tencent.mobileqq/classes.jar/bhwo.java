import android.support.annotation.NonNull;

public class bhwo
  implements bhwn
{
  @NonNull
  public <T extends bhwk> T a(@NonNull Class<T> paramClass)
  {
    try
    {
      bhwk localbhwk = (bhwk)paramClass.newInstance();
      return localbhwk;
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
 * Qualified Name:     bhwo
 * JD-Core Version:    0.7.0.1
 */