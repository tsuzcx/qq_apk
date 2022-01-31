import android.support.annotation.NonNull;

public class bjpa
  implements bjoz
{
  @NonNull
  public <T extends bjow> T a(@NonNull Class<T> paramClass)
  {
    try
    {
      bjow localbjow = (bjow)paramClass.newInstance();
      return localbjow;
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
 * Qualified Name:     bjpa
 * JD-Core Version:    0.7.0.1
 */