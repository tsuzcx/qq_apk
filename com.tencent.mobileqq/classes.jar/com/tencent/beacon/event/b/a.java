package com.tencent.beacon.event.b;

import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.EventType;
import java.util.Map;

public class a
  extends c
{
  protected BeaconEvent a(BeaconEvent paramBeaconEvent)
  {
    Object localObject = paramBeaconEvent.getType();
    if ((localObject == EventType.DT_REALTIME) || (localObject == EventType.DT_NORMAL))
    {
      localObject = paramBeaconEvent.getParams();
      f localf = f.p();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localf.n());
      ((Map)localObject).put("dt_imei2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localf.u());
      ((Map)localObject).put("dt_meid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localf.t());
      ((Map)localObject).put("dt_mf", localStringBuilder.toString());
      paramBeaconEvent.setParams((Map)localObject);
    }
    return paramBeaconEvent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.b.a
 * JD-Core Version:    0.7.0.1
 */