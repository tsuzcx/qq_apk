package com.tencent.mobileqq.ark.base;

import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;

class ArkAppCenter$1
  implements IGuardInterface
{
  ArkAppCenter$1(ArkAppCenter paramArkAppCenter) {}
  
  public void onApplicationBackground() {}
  
  public void onApplicationForeground()
  {
    this.a.h();
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.ArkAppCenter.1
 * JD-Core Version:    0.7.0.1
 */