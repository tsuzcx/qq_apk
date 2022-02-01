package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public abstract class AbstractSavedStateViewModelFactory
  extends ViewModelProvider.KeyedFactory
{
  static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
  private final Bundle mDefaultArgs;
  private final Lifecycle mLifecycle;
  private final SavedStateRegistry mSavedStateRegistry;
  
  public AbstractSavedStateViewModelFactory(@NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner, @Nullable Bundle paramBundle)
  {
    this.mSavedStateRegistry = paramSavedStateRegistryOwner.getSavedStateRegistry();
    this.mLifecycle = paramSavedStateRegistryOwner.getLifecycle();
    this.mDefaultArgs = paramBundle;
  }
  
  @NonNull
  public final <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return create(str, paramClass);
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public final <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    SavedStateHandleController localSavedStateHandleController = SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, paramString, this.mDefaultArgs);
    paramString = create(paramString, paramClass, localSavedStateHandleController.getHandle());
    paramString.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", localSavedStateHandleController);
    return paramString;
  }
  
  @NonNull
  protected abstract <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass, @NonNull SavedStateHandle paramSavedStateHandle);
  
  void onRequery(@NonNull ViewModel paramViewModel)
  {
    SavedStateHandleController.attachHandleIfNeeded(paramViewModel, this.mSavedStateRegistry, this.mLifecycle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.AbstractSavedStateViewModelFactory
 * JD-Core Version:    0.7.0.1
 */