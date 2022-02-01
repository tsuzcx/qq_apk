package androidx.activity;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher
{
  @Nullable
  private final Runnable mFallbackOnBackPressed;
  final ArrayDeque<OnBackPressedCallback> mOnBackPressedCallbacks = new ArrayDeque();
  
  public OnBackPressedDispatcher()
  {
    this(null);
  }
  
  public OnBackPressedDispatcher(@Nullable Runnable paramRunnable)
  {
    this.mFallbackOnBackPressed = paramRunnable;
  }
  
  @MainThread
  public void addCallback(@NonNull OnBackPressedCallback paramOnBackPressedCallback)
  {
    addCancellableCallback(paramOnBackPressedCallback);
  }
  
  @SuppressLint({"LambdaLast"})
  @MainThread
  public void addCallback(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull OnBackPressedCallback paramOnBackPressedCallback)
  {
    paramLifecycleOwner = paramLifecycleOwner.getLifecycle();
    if (paramLifecycleOwner.getCurrentState() == Lifecycle.State.DESTROYED) {
      return;
    }
    paramOnBackPressedCallback.addCancellable(new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(this, paramLifecycleOwner, paramOnBackPressedCallback));
  }
  
  @MainThread
  @NonNull
  Cancellable addCancellableCallback(@NonNull OnBackPressedCallback paramOnBackPressedCallback)
  {
    this.mOnBackPressedCallbacks.add(paramOnBackPressedCallback);
    OnBackPressedDispatcher.OnBackPressedCancellable localOnBackPressedCancellable = new OnBackPressedDispatcher.OnBackPressedCancellable(this, paramOnBackPressedCallback);
    paramOnBackPressedCallback.addCancellable(localOnBackPressedCancellable);
    return localOnBackPressedCancellable;
  }
  
  @MainThread
  public boolean hasEnabledCallbacks()
  {
    Iterator localIterator = this.mOnBackPressedCallbacks.descendingIterator();
    while (localIterator.hasNext()) {
      if (((OnBackPressedCallback)localIterator.next()).isEnabled()) {
        return true;
      }
    }
    return false;
  }
  
  @MainThread
  public void onBackPressed()
  {
    Iterator localIterator = this.mOnBackPressedCallbacks.descendingIterator();
    while (localIterator.hasNext())
    {
      localOnBackPressedCallback = (OnBackPressedCallback)localIterator.next();
      if (localOnBackPressedCallback.isEnabled()) {
        localOnBackPressedCallback.handleOnBackPressed();
      }
    }
    while (this.mFallbackOnBackPressed == null)
    {
      OnBackPressedCallback localOnBackPressedCallback;
      return;
    }
    this.mFallbackOnBackPressed.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.activity.OnBackPressedDispatcher
 * JD-Core Version:    0.7.0.1
 */