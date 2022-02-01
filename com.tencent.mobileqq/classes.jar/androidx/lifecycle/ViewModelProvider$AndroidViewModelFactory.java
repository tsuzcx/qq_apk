package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider$AndroidViewModelFactory
  extends ViewModelProvider.NewInstanceFactory
{
  private static AndroidViewModelFactory sInstance;
  private Application mApplication;
  
  public ViewModelProvider$AndroidViewModelFactory(@NonNull Application paramApplication)
  {
    this.mApplication = paramApplication;
  }
  
  @NonNull
  public static AndroidViewModelFactory getInstance(@NonNull Application paramApplication)
  {
    if (sInstance == null) {
      sInstance = new AndroidViewModelFactory(paramApplication);
    }
    return sInstance;
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    if (AndroidViewModel.class.isAssignableFrom(paramClass)) {
      try
      {
        ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.mApplication });
        return localViewModel;
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
    return super.create(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
 * JD-Core Version:    0.7.0.1
 */