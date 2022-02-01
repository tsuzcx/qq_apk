package com.tencent.ilive.uicomponent.floatwindowcomponent_interface;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.ilive.uicomponent.UIOuter;

public abstract interface FloatWindowComponent
  extends UIOuter
{
  public abstract void dismiss(int paramInt);
  
  public abstract long getShowTime();
  
  public abstract void init(@NonNull Context paramContext);
  
  public abstract boolean isCalledShow();
  
  public abstract boolean isDragEnd();
  
  public abstract boolean isReallyShow();
  
  public abstract void setHandleCallback(@NonNull FloatWindowHandleCallback paramFloatWindowHandleCallback);
  
  public abstract void show(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent
 * JD-Core Version:    0.7.0.1
 */