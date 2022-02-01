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
      catch (InvocationTargetException localInvocationTargetException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException);
      }
      catch (InstantiationException localInstantiationException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), localIllegalAccessException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), localNoSuchMethodException);
      }
    }
    return super.create(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
 * JD-Core Version:    0.7.0.1
 */