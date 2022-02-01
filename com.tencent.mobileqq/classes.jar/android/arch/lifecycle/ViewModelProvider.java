package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public class ViewModelProvider
{
  private static final String DEFAULT_KEY = "android.arch.lifecycle.ViewModelProvider.DefaultKey";
  private final ViewModelProvider.Factory mFactory;
  private final ViewModelStore mViewModelStore;
  
  public ViewModelProvider(@NonNull ViewModelStore paramViewModelStore, @NonNull ViewModelProvider.Factory paramFactory)
  {
    this.mFactory = paramFactory;
    this.mViewModelStore = paramViewModelStore;
  }
  
  public ViewModelProvider(@NonNull ViewModelStoreOwner paramViewModelStoreOwner, @NonNull ViewModelProvider.Factory paramFactory)
  {
    this(paramViewModelStoreOwner.getViewModelStore(), paramFactory);
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
      localStringBuilder.append(str);
      return get(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    ViewModel localViewModel = this.mViewModelStore.get(paramString);
    if (paramClass.isInstance(localViewModel)) {
      return localViewModel;
    }
    paramClass = this.mFactory.create(paramClass);
    this.mViewModelStore.put(paramString, paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelProvider
 * JD-Core Version:    0.7.0.1
 */