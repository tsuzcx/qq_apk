import android.support.annotation.NonNull;

public class bmew
  implements bmev
{
  @NonNull
  public <T extends bmes> T a(@NonNull Class<T> paramClass)
  {
    try
    {
      bmes localbmes = (bmes)paramClass.newInstance();
      return localbmes;
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
 * Qualified Name:     bmew
 * JD-Core Version:    0.7.0.1
 */