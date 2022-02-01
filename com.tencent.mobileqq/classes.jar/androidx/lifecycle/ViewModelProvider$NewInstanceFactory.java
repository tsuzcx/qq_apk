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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider.NewInstanceFactory
 * JD-Core Version:    0.7.0.1
 */