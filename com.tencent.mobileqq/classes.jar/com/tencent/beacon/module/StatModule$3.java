package com.tencent.beacon.module;

import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;

class StatModule$3
  implements Runnable
{
  StatModule$3(StatModule paramStatModule, long paramLong1, String paramString, long paramLong2) {}
  
  public void run()
  {
    Object localObject = BeaconEvent.builder().withParams("A110", String.valueOf(this.a)).withParams("A111", this.b).withParams("A112", String.valueOf(this.c)).withCode("rqd_page").withType(EventType.NORMAL).build();
    BeaconReport.getInstance().report((BeaconEvent)localObject);
    localObject = this.d;
    StatModule.a((StatModule)localObject, StatModule.a((StatModule)localObject) + this.c);
    if (StatModule.a(this.d) >= 15000L) {
      StatModule.a(this.d, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.StatModule.3
 * JD-Core Version:    0.7.0.1
 */