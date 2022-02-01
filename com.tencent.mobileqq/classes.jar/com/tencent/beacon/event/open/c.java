package com.tencent.beacon.event.open;

import com.tencent.beacon.a.b.d;
import com.tencent.beacon.base.util.e;

class c
  implements Runnable
{
  c(BeaconReport paramBeaconReport) {}
  
  public void run()
  {
    try
    {
      BeaconReport.a(this.a);
      BeaconReport.b(this.a);
      BeaconReport.c(this.a);
      e.a(BeaconReport.d(this.a));
      com.tencent.beacon.base.util.c.a("BeaconReport", "App: %s start success!", new Object[] { BeaconReport.e(this.a) });
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = d.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sdk init error! msg:");
      localStringBuilder.append(localThrowable.getMessage());
      ((d)localObject).a("201", localStringBuilder.toString(), localThrowable);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BeaconReport init error: ");
      ((StringBuilder)localObject).append(localThrowable.getMessage());
      com.tencent.beacon.base.util.c.b(((StringBuilder)localObject).toString(), new Object[0]);
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.c
 * JD-Core Version:    0.7.0.1
 */