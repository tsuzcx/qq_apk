package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

public class ViewModelProvider
{
  private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
  private final ViewModelProvider.Factory mFactory;
  private final ViewModelStore mViewModelStore;
  
  public ViewModelProvider(@NonNull ViewModelStore paramViewModelStore, @NonNull ViewModelProvider.Factory paramFactory)
  {
    this.mFactory = paramFactory;
    this.mViewModelStore = paramViewModelStore;
  }
  
  public ViewModelProvider(@NonNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    this(localViewModelStore, paramViewModelStoreOwner);
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
      localStringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
      localStringBuilder.append(str);
      return get(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    Object localObject = this.mViewModelStore.get(paramString);
    if (paramClass.isInstance(localObject))
    {
      paramString = this.mFactory;
      if ((paramString instanceof ViewModelProvider.OnRequeryFactory)) {
        ((ViewModelProvider.OnRequeryFactory)paramString).onRequery((ViewModel)localObject);
      }
      return localObject;
    }
    localObject = this.mFactory;
    if ((localObject instanceof ViewModelProvider.KeyedFactory)) {
      paramClass = ((ViewModelProvider.KeyedFactory)localObject).create(paramString, paramClass);
    } else {
      paramClass = ((ViewModelProvider.Factory)localObject).create(paramClass);
    }
    this.mViewModelStore.put(paramString, paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider
 * JD-Core Version:    0.7.0.1
 */