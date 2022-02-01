package androidx.activity;

import java.util.ArrayDeque;

class OnBackPressedDispatcher$OnBackPressedCancellable
  implements Cancellable
{
  private final OnBackPressedCallback mOnBackPressedCallback;
  
  OnBackPressedDispatcher$OnBackPressedCancellable(OnBackPressedDispatcher paramOnBackPressedDispatcher, OnBackPressedCallback paramOnBackPressedCallback)
  {
    this.mOnBackPressedCallback = paramOnBackPressedCallback;
  }
  
  public void cancel()
  {
    this.this$0.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
    this.mOnBackPressedCallback.removeCancellable(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.OnBackPressedDispatcher.OnBackPressedCancellable
 * JD-Core Version:    0.7.0.1
 */