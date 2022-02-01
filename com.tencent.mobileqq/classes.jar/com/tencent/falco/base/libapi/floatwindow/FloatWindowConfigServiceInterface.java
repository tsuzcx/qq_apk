package com.tencent.falco.base.libapi.floatwindow;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface FloatWindowConfigServiceInterface
  extends ServiceBaseInterface
{
  public abstract boolean getFloatWindowEnabledAllTime();
  
  public abstract boolean getFloatWindowEnabledOnce();
  
  public abstract void setFloatWindowEnabledAllTime(boolean paramBoolean);
  
  public abstract void setFloatWindowEnabledOnce(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface
 * JD-Core Version:    0.7.0.1
 */