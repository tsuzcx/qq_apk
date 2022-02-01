package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ArkAppEventObserverManager$1
  extends SosoInterfaceOnLocationListener
{
  ArkAppEventObserverManager$1(ArkAppEventObserverManager paramArkAppEventObserverManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onConsecutiveFailure errCode=" + paramInt1 + ", failCount=" + paramInt2);
    }
    if (paramInt2 < 3) {
      return;
    }
    ArkAppCenter.a().post(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.1.2(this));
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + paramInt);
    }
    ArkAppCenter.a().post(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.1.1(this, paramSosoLbsInfo, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1
 * JD-Core Version:    0.7.0.1
 */