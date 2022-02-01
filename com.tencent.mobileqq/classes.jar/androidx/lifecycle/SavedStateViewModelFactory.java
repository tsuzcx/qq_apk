package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class SavedStateViewModelFactory
  extends ViewModelProvider.KeyedFactory
{
  private static final Class<?>[] ANDROID_VIEWMODEL_SIGNATURE = { Application.class, SavedStateHandle.class };
  private static final Class<?>[] VIEWMODEL_SIGNATURE = { SavedStateHandle.class };
  private final Application mApplication;
  private final Bundle mDefaultArgs;
  private final ViewModelProvider.AndroidViewModelFactory mFactory;
  private final Lifecycle mLifecycle;
  private final SavedStateRegistry mSavedStateRegistry;
  
  public SavedStateViewModelFactory(@NonNull Application paramApplication, @NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner)
  {
    this(paramApplication, paramSavedStateRegistryOwner, null);
  }
  
  @SuppressLint({"LambdaLast"})
  public SavedStateViewModelFactory(@NonNull Application paramApplication, @NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner, @Nullable Bundle paramBundle)
  {
    this.mSavedStateRegistry = paramSavedStateRegistryOwner.getSavedStateRegistry();
    this.mLifecycle = paramSavedStateRegistryOwner.getLifecycle();
    this.mDefaultArgs = paramBundle;
    this.mApplication = paramApplication;
    this.mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(paramApplication);
  }
  
  private static <T> Constructor<T> findMatchingConstructor(Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    paramClass = paramClass.getConstructors();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Constructor<T> localConstructor = paramClass[i];
      if (Arrays.equals(paramArrayOfClass, localConstructor.getParameterTypes())) {
        return localConstructor;
      }
      i += 1;
    }
    return null;
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return create(str, paramClass);
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    boolean bool = AndroidViewModel.class.isAssignableFrom(paramClass);
    if (bool) {}
    for (Constructor localConstructor = findMatchingConstructor(paramClass, ANDROID_VIEWMODEL_SIGNATURE); localConstructor == null; localConstructor = findMatchingConstructor(paramClass, VIEWMODEL_SIGNATURE)) {
      return this.mFactory.create(paramClass);
    }
    SavedStateHandleController localSavedStateHandleController = SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, paramString, this.mDefaultArgs);
    if (bool) {}
    try
    {
      paramString = (ViewModel)localConstructor.newInstance(new Object[] { this.mApplication, localSavedStateHandleController.getHandle() });
      paramString.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", localSavedStateHandleController);
      return paramString;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        throw new RuntimeException("Failed to access " + paramClass, paramString);
        paramString = (ViewModel)localConstructor.newInstance(new Object[] { localSavedStateHandleController.getHandle() });
      }
    }
    catch (InstantiationException paramString)
    {
      throw new RuntimeException("A " + paramClass + " cannot be instantiated.", paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new RuntimeException("An exception happened in constructor of " + paramClass, paramString.getCause());
    }
  }
  
  void onRequery(@NonNull ViewModel paramViewModel)
  {
    SavedStateHandleController.attachHandleIfNeeded(paramViewModel, this.mSavedStateRegistry, this.mLifecycle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.SavedStateViewModelFactory
 * JD-Core Version:    0.7.0.1
 */