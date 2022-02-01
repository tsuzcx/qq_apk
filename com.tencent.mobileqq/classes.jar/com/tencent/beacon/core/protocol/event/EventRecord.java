package com.tencent.beacon.core.protocol.event;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;

public final class EventRecord
  extends JceStruct
  implements Cloneable
{
  public String apn = "";
  public long cosumeTime = 0L;
  public String eventName = "";
  public boolean eventResult = true;
  public long eventTime = 0L;
  public int eventType = 0;
  public String eventValue = "";
  public long packageSize = 0L;
  public String srcIp = "";
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public void readFrom(a parama)
  {
    this.apn = parama.a(0, true);
    this.srcIp = parama.a(1, true);
    this.eventName = parama.a(2, true);
    this.eventResult = parama.a(this.eventResult, 3, true);
    this.packageSize = parama.a(this.packageSize, 4, true);
    this.cosumeTime = parama.a(this.cosumeTime, 5, true);
    this.eventValue = parama.a(6, true);
    this.eventTime = parama.a(this.eventTime, 7, true);
    this.eventType = parama.a(this.eventType, 8, false);
  }
  
  public void writeTo(b paramb)
  {
    paramb.a(this.apn, 0);
    paramb.a(this.srcIp, 1);
    paramb.a(this.eventName, 2);
    paramb.a(this.eventResult, 3);
    paramb.a(this.packageSize, 4);
    paramb.a(this.cosumeTime, 5);
    paramb.a(this.eventValue, 6);
    paramb.a(this.eventTime, 7);
    paramb.a(this.eventType, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.event.EventRecord
 * JD-Core Version:    0.7.0.1
 */