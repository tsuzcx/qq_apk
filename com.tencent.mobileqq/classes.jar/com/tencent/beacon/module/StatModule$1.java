package com.tencent.beacon.module;

import android.os.Build;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;

class StatModule$1
  implements Runnable
{
  StatModule$1(StatModule paramStatModule) {}
  
  public void run()
  {
    f localf = f.p();
    Object localObject1 = BeaconEvent.builder().withParams("A9", Build.BRAND).withParams("A10", Build.MODEL).withParams("A11", localf.h()).withParams("A12", localf.r()).withParams("A13", localf.G());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localf.D());
    ((StringBuilder)localObject2).append("m");
    localObject1 = ((BeaconEvent.Builder)localObject1).withParams("A14", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localf.A());
    ((StringBuilder)localObject2).append("m");
    localObject1 = ((BeaconEvent.Builder)localObject1).withParams("A15", ((StringBuilder)localObject2).toString()).withParams("A16", localf.i()).withParams("A17", localf.B()).withParams("A18", "").withParams("A20", localf.I()).withParams("A22", localf.K());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localf.E());
    ((StringBuilder)localObject2).append("m");
    localObject1 = ((BeaconEvent.Builder)localObject1).withParams("A30", ((StringBuilder)localObject2).toString()).withParams("A19", localf.w());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(localf.F());
    localObject1 = ((BeaconEvent.Builder)localObject1).withParams("A52", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(localf.f());
    ((StringBuilder)localObject2).append("m");
    localObject1 = ((BeaconEvent.Builder)localObject1).withParams("A53", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(localf.x());
    BeaconEvent.Builder localBuilder = ((BeaconEvent.Builder)localObject1).withParams("A54", ((StringBuilder)localObject2).toString()).withParams("A55", localf.g());
    boolean bool = localf.M();
    localObject2 = "Y";
    if (bool) {
      localObject1 = "Y";
    } else {
      localObject1 = "N";
    }
    localBuilder = localBuilder.withParams("A56", (String)localObject1).withParams("A57", localf.H());
    if (localf.q()) {
      localObject1 = localObject2;
    } else {
      localObject1 = "N";
    }
    localObject1 = localBuilder.withParams("A58", (String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localf.l());
    ((StringBuilder)localObject2).append("m");
    localObject1 = ((BeaconEvent.Builder)localObject1).withParams("A59", ((StringBuilder)localObject2).toString()).withParams("A69", localf.J()).withParams("A82", localf.C()).withType(EventType.REALTIME).withCode("rqd_model").build();
    BeaconReport.getInstance().report((BeaconEvent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.StatModule.1
 * JD-Core Version:    0.7.0.1
 */