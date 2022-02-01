package com.tencent.av.app;

import java.lang.ref.WeakReference;

class DeviceCapabilityExamination$MyTestRunnable
  implements Runnable
{
  WeakReference<DeviceCapabilityExamination> a;
  
  DeviceCapabilityExamination$MyTestRunnable(DeviceCapabilityExamination paramDeviceCapabilityExamination)
  {
    this.a = new WeakReference(paramDeviceCapabilityExamination);
  }
  
  public void run()
  {
    DeviceCapabilityExamination localDeviceCapabilityExamination = (DeviceCapabilityExamination)this.a.get();
    if (localDeviceCapabilityExamination != null) {
      DeviceCapabilityExamination.a(localDeviceCapabilityExamination);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.MyTestRunnable
 * JD-Core Version:    0.7.0.1
 */