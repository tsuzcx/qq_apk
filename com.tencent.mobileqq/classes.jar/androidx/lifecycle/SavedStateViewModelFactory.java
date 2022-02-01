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
  private final ViewModelProvider.Factory mFactory;
  private final Lifecycle mLifecycle;
  private final SavedStateRegistry mSavedStateRegistry;
  
  public SavedStateViewModelFactory(@Nullable Application paramApplication, @NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner)
  {
    this(paramApplication, paramSavedStateRegistryOwner, null);
  }
  
  @SuppressLint({"LambdaLast"})
  public SavedStateViewModelFactory(@Nullable Application paramApplication, @NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner, @Nullable Bundle paramBundle)
  {
    this.mSavedStateRegistry = paramSavedStateRegistryOwner.getSavedStateRegistry();
    this.mLifecycle = paramSavedStateRegistryOwner.getLifecycle();
    this.mDefaultArgs = paramBundle;
    this.mApplication = paramApplication;
    if (paramApplication != null) {
      paramApplication = ViewModelProvider.AndroidViewModelFactory.getInstance(paramApplication);
    } else {
      paramApplication = ViewModelProvider.NewInstanceFactory.getInstance();
    }
    this.mFactory = paramApplication;
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
    if (str != null) {
      return create(str, paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    boolean bool = AndroidViewModel.class.isAssignableFrom(paramClass);
    Object localObject;
    if ((bool) && (this.mApplication != null)) {
      localObject = findMatchingConstructor(paramClass, ANDROID_VIEWMODEL_SIGNATURE);
    } else {
      localObject = findMatchingConstructor(paramClass, VIEWMODEL_SIGNATURE);
    }
    if (localObject == null) {
      return this.mFactory.create(paramClass);
    }
    SavedStateHandleController localSavedStateHandleController = SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, paramString, this.mDefaultArgs);
    if (bool) {}
    try
    {
      if (this.mApplication != null) {
        paramString = (ViewModel)((Constructor)localObject).newInstance(new Object[] { this.mApplication, localSavedStateHandleController.getHandle() });
      } else {
        paramString = (ViewModel)((Constructor)localObject).newInstance(new Object[] { localSavedStateHandleController.getHandle() });
      }
      paramString.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", localSavedStateHandleController);
      return paramString;
    }
    catch (InvocationTargetException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("An exception happened in constructor of ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), paramString.getCause());
    }
    catch (InstantiationException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("A ");
      ((StringBuilder)localObject).append(paramClass);
      ((StringBuilder)localObject).append(" cannot be instantiated.");
      throw new RuntimeException(((StringBuilder)localObject).toString(), paramString);
    }
    catch (IllegalAccessException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to access ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), paramString);
    }
  }
  
  void onRequery(@NonNull ViewModel paramViewModel)
  {
    SavedStateHandleController.attachHandleIfNeeded(paramViewModel, this.mSavedStateRegistry, this.mLifecycle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.SavedStateViewModelFactory
 * JD-Core Version:    0.7.0.1
 */