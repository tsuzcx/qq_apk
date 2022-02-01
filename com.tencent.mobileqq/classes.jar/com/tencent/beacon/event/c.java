package com.tencent.beacon.event;

import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.event.TunnelModule;

final class c
  implements Runnable
{
  public void run()
  {
    d.a("[core] db events to up on app call", new Object[0]);
    try
    {
      TunnelModule.doUploadAllEventsData();
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.c
 * JD-Core Version:    0.7.0.1
 */