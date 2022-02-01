package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;

public class WSGuardInterfaceWrapper
  implements IGuardInterface
{
  private String a;
  
  public void a()
  {
    WSLog.e("WSGuardInterfaceWrapper", "[onApplicationForeground] mPageId:" + this.a);
  }
  
  public void a(long paramLong)
  {
    WSLog.e("WSGuardInterfaceWrapper", "[onBackgroundTimeTick] mPageId:" + this.a + ", tick:" + paramLong);
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    WSLog.e("WSGuardInterfaceWrapper", "[onScreensStateChanged] mPageId:" + this.a + ", isEnabled:" + paramBoolean);
  }
  
  public void b()
  {
    WSLog.e("WSGuardInterfaceWrapper", "[onApplicationBackground] mPageId:" + this.a);
  }
  
  public void b(long paramLong)
  {
    WSLog.e("WSGuardInterfaceWrapper", "[onLiteTimeTick] mPageId:" + this.a + ", tick:" + paramLong);
  }
  
  public void c(long paramLong)
  {
    WSLog.e("WSGuardInterfaceWrapper", "[onBackgroundUnGuardTimeTick] mPageId:" + this.a + ", tick:" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSGuardInterfaceWrapper
 * JD-Core Version:    0.7.0.1
 */