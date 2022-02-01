package androidx.lifecycle;

import androidx.annotation.NonNull;

public class ViewModelProvider$NewInstanceFactory
  implements ViewModelProvider.Factory
{
  private static NewInstanceFactory sInstance;
  
  @NonNull
  static NewInstanceFactory getInstance()
  {
    if (sInstance == null) {
      sInstance = new NewInstanceFactory();
    }
    return sInstance;
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    try
    {
      ViewModel localViewModel = (ViewModel)paramClass.newInstance();
      return localViewModel;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create an instance of ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create an instance of ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider.NewInstanceFactory
 * JD-Core Version:    0.7.0.1
 */