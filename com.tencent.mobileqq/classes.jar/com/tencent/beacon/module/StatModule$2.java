package com.tencent.beacon.module;

import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;

class StatModule$2
  implements Runnable
{
  StatModule$2(StatModule paramStatModule, long paramLong1, String paramString, long paramLong2) {}
  
  public void run()
  {
    BeaconEvent localBeaconEvent = BeaconEvent.builder().withParams("A110", String.valueOf(this.a)).withParams("A111", this.b).withParams("A112", String.valueOf(this.c)).withCode("rqd_page_fgt").withType(EventType.REALTIME).build();
    BeaconReport.getInstance().report(localBeaconEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.StatModule.2
 * JD-Core Version:    0.7.0.1
 */