package com.tencent.beacon.module;

import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;

class StatModule$4
  implements Runnable
{
  public void run()
  {
    BeaconEvent localBeaconEvent = BeaconEvent.builder().withCode("rqd_sensor").withParams(this.a).build();
    BeaconReport.getInstance().report(localBeaconEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.StatModule.4
 * JD-Core Version:    0.7.0.1
 */