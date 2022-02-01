package com.tencent.ilive.uicomponent.floatwindowcomponent_interface;

import android.view.View;
import androidx.annotation.NonNull;

public abstract interface FloatWindowHandleCallback
{
  public abstract void invokePlayerContainer(@NonNull View paramView);
  
  public abstract void onDismissed(int paramInt);
  
  public abstract void onDragEnd(View paramView);
  
  public abstract void onShow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowHandleCallback
 * JD-Core Version:    0.7.0.1
 */