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
  
  public ViewModelProvider(@NonNull ViewModelStoreOwner paramViewModelStoreOwner) {}
  
  public ViewModelProvider(@NonNull ViewModelStoreOwner paramViewModelStoreOwner, @NonNull ViewModelProvider.Factory paramFactory)
  {
    this(paramViewModelStoreOwner.getViewModelStore(), paramFactory);
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    ViewModel localViewModel = this.mViewModelStore.get(paramString);
    if (paramClass.isInstance(localViewModel))
    {
      if ((this.mFactory instanceof ViewModelProvider.OnRequeryFactory)) {
        ((ViewModelProvider.OnRequeryFactory)this.mFactory).onRequery(localViewModel);
      }
      return localViewModel;
    }
    if ((localViewModel == null) || ((this.mFactory instanceof ViewModelProvider.KeyedFactory))) {}
    for (paramClass = ((ViewModelProvider.KeyedFactory)this.mFactory).create(paramString, paramClass);; paramClass = this.mFactory.create(paramClass))
    {
      this.mViewModelStore.put(paramString, paramClass);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider
 * JD-Core Version:    0.7.0.1
 */