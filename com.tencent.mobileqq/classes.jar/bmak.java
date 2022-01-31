import android.support.annotation.NonNull;

public class bmak
  implements bmaj
{
  @NonNull
  public <T extends bmag> T a(@NonNull Class<T> paramClass)
  {
    try
    {
      bmag localbmag = (bmag)paramClass.newInstance();
      return localbmag;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmak
 * JD-Core Version:    0.7.0.1
 */