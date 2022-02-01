package com.tencent.falco.base.floatwindow.interfaces;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import org.jetbrains.annotations.Nullable;

public abstract interface OnFloatWindowCallbacks
{
  public abstract void createdResult(boolean paramBoolean, int paramInt, @Nullable View paramView);
  
  public abstract void dismiss();
  
  public abstract void drag(@NonNull View paramView, @NonNull MotionEvent paramMotionEvent);
  
  public abstract void dragEnd(@NonNull View paramView);
  
  public abstract void hide(@NonNull View paramView);
  
  public abstract void show(@NonNull View paramView);
  
  public abstract void touchEvent(@NonNull View paramView, @NonNull MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks
 * JD-Core Version:    0.7.0.1
 */