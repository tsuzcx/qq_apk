package com.tencent.device.devicemgr;

import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;

public class SmartDeviceObserver
  implements BusinessObserver
{
  protected void a(ArrayList<DeviceInfo> paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    a((ArrayList)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceObserver
 * JD-Core Version:    0.7.0.1
 */