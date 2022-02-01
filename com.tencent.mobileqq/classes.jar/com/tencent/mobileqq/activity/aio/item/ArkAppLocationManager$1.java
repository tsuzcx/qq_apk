package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
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
    if ((paramInt == 0) && (paramSosoLbsInfo != null)) {}
    for (boolean bool = true;; bool = false)
    {
      ArkAppCenter.a().post(this.a.a, new ArkAppLocationManager.1.1(this, bool, paramSosoLbsInfo));
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.1
 * JD-Core Version:    0.7.0.1
 */