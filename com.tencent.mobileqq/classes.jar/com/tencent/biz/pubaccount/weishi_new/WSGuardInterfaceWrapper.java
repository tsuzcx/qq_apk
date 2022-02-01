package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;

public class WSGuardInterfaceWrapper
  implements IGuardInterface
{
  private String a;
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void onApplicationBackground()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onApplicationBackground] mPageId:");
    localStringBuilder.append(this.a);
    WSLog.e("WSGuardInterfaceWrapper", localStringBuilder.toString());
  }
  
  public void onApplicationForeground()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onApplicationForeground] mPageId:");
    localStringBuilder.append(this.a);
    WSLog.e("WSGuardInterfaceWrapper", localStringBuilder.toString());
  }
  
  public void onBackgroundTimeTick(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onBackgroundTimeTick] mPageId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tick:");
    localStringBuilder.append(paramLong);
    WSLog.e("WSGuardInterfaceWrapper", localStringBuilder.toString());
  }
  
  public void onBackgroundUnguardTimeTick(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onBackgroundUnGuardTimeTick] mPageId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tick:");
    localStringBuilder.append(paramLong);
    WSLog.e("WSGuardInterfaceWrapper", localStringBuilder.toString());
  }
  
  public void onLiteTimeTick(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onLiteTimeTick] mPageId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tick:");
    localStringBuilder.append(paramLong);
    WSLog.e("WSGuardInterfaceWrapper", localStringBuilder.toString());
  }
  
  public void onScreensStateChanged(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onScreensStateChanged] mPageId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isEnabled:");
    localStringBuilder.append(paramBoolean);
    WSLog.e("WSGuardInterfaceWrapper", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSGuardInterfaceWrapper
 * JD-Core Version:    0.7.0.1
 */