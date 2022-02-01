package com.tencent.falco.base.libapi.floatwindow;

import android.app.Activity;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface FloatWindowPermissionInterface
  extends ServiceBaseInterface
{
  public abstract boolean hasFWPermission();
  
  public abstract void init(FloatWindowPermissionAdapter paramFloatWindowPermissionAdapter);
  
  public abstract void requestPermissionAndDoJump(Activity paramActivity, Runnable paramRunnable);
  
  public abstract void requestPermissionAndDoJump(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface
 * JD-Core Version:    0.7.0.1
 */