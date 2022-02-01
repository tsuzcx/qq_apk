package com.tencent.ad.tangram.device;

import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gathererga.core.IExecutor;

class AdDeviceInfo$2
  implements IExecutor
{
  AdDeviceInfo$2(AdDeviceInfo paramAdDeviceInfo) {}
  
  public void execute(Runnable paramRunnable)
  {
    AdThreadManager.INSTANCE.post(paramRunnable, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo.2
 * JD-Core Version:    0.7.0.1
 */