package com.tencent.beacon.module;

import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import java.util.Map;

class StatModule$5
  implements Runnable
{
  StatModule$5(StatModule paramStatModule, Map paramMap) {}
  
  public void run()
  {
    BeaconEvent localBeaconEvent = BeaconEvent.builder().withCode("rqd_appresumed").withIsSucceed(true).withParams(this.a).withType(EventType.REALTIME).build();
    BeaconReport.getInstance().report(localBeaconEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.StatModule.5
 * JD-Core Version:    0.7.0.1
 */