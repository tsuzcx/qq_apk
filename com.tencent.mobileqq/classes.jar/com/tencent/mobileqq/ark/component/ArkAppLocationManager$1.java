package com.tencent.mobileqq.ark.component;

import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

class ArkAppLocationManager$1
  extends SosoInterfaceOnLocationListener
{
  ArkAppLocationManager$1(ArkAppLocationManager paramArkAppLocationManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  protected void a(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    boolean bool;
    if ((paramInt == 0) && (paramSosoLbsInfo != null)) {
      bool = true;
    } else {
      bool = false;
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.a.a, new ArkAppLocationManager.1.1(this, bool, paramSosoLbsInfo));
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 3) {
      return;
    }
    a(paramInt1, null);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    a(paramInt, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppLocationManager.1
 * JD-Core Version:    0.7.0.1
 */