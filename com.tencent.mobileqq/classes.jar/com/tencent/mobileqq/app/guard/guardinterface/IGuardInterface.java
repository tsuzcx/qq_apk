package com.tencent.mobileqq.app.guard.guardinterface;

public abstract interface IGuardInterface
{
  public abstract void onApplicationBackground();
  
  public abstract void onApplicationForeground();
  
  public abstract void onBackgroundTimeTick(long paramLong);
  
  public abstract void onBackgroundUnguardTimeTick(long paramLong);
  
  public abstract void onLiteTimeTick(long paramLong);
  
  public abstract void onScreensStateChanged(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
 * JD-Core Version:    0.7.0.1
 */