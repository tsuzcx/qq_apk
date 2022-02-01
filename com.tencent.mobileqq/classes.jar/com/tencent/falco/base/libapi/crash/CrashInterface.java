package com.tencent.falco.base.libapi.crash;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface CrashInterface
  extends ServiceBaseInterface
{
  public abstract void init(CrashInterface.CrashAdapter paramCrashAdapter);
  
  public abstract void setUid(long paramLong);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.crash.CrashInterface
 * JD-Core Version:    0.7.0.1
 */