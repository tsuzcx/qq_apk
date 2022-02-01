package androidx.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable
  implements Cancellable, LifecycleEventObserver
{
  @Nullable
  private Cancellable mCurrentCancellable;
  private final Lifecycle mLifecycle;
  private final OnBackPressedCallback mOnBackPressedCallback;
  
  OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(OnBackPressedDispatcher paramOnBackPressedDispatcher, @NonNull Lifecycle paramLifecycle, @NonNull OnBackPressedCallback paramOnBackPressedCallback)
  {
    this.mLifecycle = paramLifecycle;
    this.mOnBackPressedCallback = paramOnBackPressedCallback;
    paramLifecycle.addObserver(this);
  }
  
  public void cancel()
  {
    this.mLifecycle.removeObserver(this);
    this.mOnBackPressedCallback.removeCancellable(this);
    if (this.mCurrentCancellable != null)
    {
      this.mCurrentCancellable.cancel();
      this.mCurrentCancellable = null;
    }
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (paramEvent == Lifecycle.Event.ON_START) {
      this.mCurrentCancellable = this.this$0.addCancellableCallback(this.mOnBackPressedCallback);
    }
    do
    {
      do
      {
        return;
        if (paramEvent != Lifecycle.Event.ON_STOP) {
          break;
        }
      } while (this.mCurrentCancellable == null);
      this.mCurrentCancellable.cancel();
      return;
    } while (paramEvent != Lifecycle.Event.ON_DESTROY);
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.activity.OnBackPressedDispatcher.LifecycleOnBackPressedCancellable
 * JD-Core Version:    0.7.0.1
 */