package com.tencent.device.devicemgr;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;

public class SmartDeviceObserver
  implements BusinessObserver
{
  public void a(ArrayList paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a((ArrayList)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceObserver
 * JD-Core Version:    0.7.0.1
 */