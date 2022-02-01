package com.tencent.beacon.core.event;

import com.tencent.beacon.core.e.d;

class z
  implements Runnable
{
  z(TunnelModule paramTunnelModule) {}
  
  public void run()
  {
    d.a("[net] db events to up on netConnectChange", new Object[0]);
    try
    {
      TunnelModule.doUploadRecentCommonData(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.z
 * JD-Core Version:    0.7.0.1
 */