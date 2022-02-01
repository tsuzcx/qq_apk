package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.savedstate.SavedStateRegistry;

final class SavedStateHandleController
  implements LifecycleEventObserver
{
  static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
  private final SavedStateHandle mHandle;
  private boolean mIsAttached = false;
  private final String mKey;
  
  SavedStateHandleController(String paramString, SavedStateHandle paramSavedStateHandle)
  {
    this.mKey = paramString;
    this.mHandle = paramSavedStateHandle;
  }
  
  static void attachHandleIfNeeded(ViewModel paramViewModel, SavedStateRegistry paramSavedStateRegistry, Lifecycle paramLifecycle)
  {
    paramViewModel = (SavedStateHandleController)paramViewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
    if ((paramViewModel != null) && (!paramViewModel.isAttached()))
    {
      paramViewModel.attachToLifecycle(paramSavedStateRegistry, paramLifecycle);
      tryToAddRecreator(paramSavedStateRegistry, paramLifecycle);
    }
  }
  
  static SavedStateHandleController create(SavedStateRegistry paramSavedStateRegistry, Lifecycle paramLifecycle, String paramString, Bundle paramBundle)
  {
    paramString = new SavedStateHandleController(paramString, SavedStateHandle.createHandle(paramSavedStateRegistry.consumeRestoredStateForKey(paramString), paramBundle));
    paramString.attachToLifecycle(paramSavedStateRegistry, paramLifecycle);
    tryToAddRecreator(paramSavedStateRegistry, paramLifecycle);
    return paramString;
  }
  
  private static void tryToAddRecreator(SavedStateRegistry paramSavedStateRegistry, Lifecycle paramLifecycle)
  {
    Lifecycle.State localState = paramLifecycle.getCurrentState();
    if ((localState == Lifecycle.State.INITIALIZED) || (localState.isAtLeast(Lifecycle.State.STARTED)))
    {
      paramSavedStateRegistry.runOnNextRecreation(SavedStateHandleController.OnRecreation.class);
      return;
    }
    paramLifecycle.addObserver(new SavedStateHandleController.1(paramLifecycle, paramSavedStateRegistry));
  }
  
  void attachToLifecycle(SavedStateRegistry paramSavedStateRegistry, Lifecycle paramLifecycle)
  {
    if (this.mIsAttached) {
      throw new IllegalStateException("Already attached to lifecycleOwner");
    }
    this.mIsAttached = true;
    paramLifecycle.addObserver(this);
    paramSavedStateRegistry.registerSavedStateProvider(this.mKey, this.mHandle.savedStateProvider());
  }
  
  SavedStateHandle getHandle()
  {
    return this.mHandle;
  }
  
  boolean isAttached()
  {
    return this.mIsAttached;
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (paramEvent == Lifecycle.Event.ON_DESTROY)
    {
      this.mIsAttached = false;
      paramLifecycleOwner.getLifecycle().removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.SavedStateHandleController
 * JD-Core Version:    0.7.0.1
 */