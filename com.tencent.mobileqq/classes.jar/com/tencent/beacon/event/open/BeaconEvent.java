package com.tencent.beacon.event.open;

import java.util.Map;

public final class BeaconEvent
{
  private String a;
  private String b;
  private EventType c;
  private boolean d;
  private Map<String, String> e;
  
  private BeaconEvent(String paramString1, String paramString2, EventType paramEventType, boolean paramBoolean, Map<String, String> paramMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramEventType;
    this.d = paramBoolean;
    this.e = paramMap;
  }
  
  public static BeaconEvent.Builder builder()
  {
    return new BeaconEvent.Builder(null);
  }
  
  public static BeaconEvent.Builder newBuilder(BeaconEvent paramBeaconEvent)
  {
    return new BeaconEvent.Builder(paramBeaconEvent, null);
  }
  
  public String getAppKey()
  {
    return this.a;
  }
  
  public String getCode()
  {
    return this.b;
  }
  
  public Map<String, String> getParams()
  {
    return this.e;
  }
  
  public EventType getType()
  {
    return this.c;
  }
  
  public boolean isRealtime()
  {
    EventType localEventType = this.c;
    return (localEventType == EventType.DT_REALTIME) || (localEventType == EventType.REALTIME);
  }
  
  public boolean isSucceed()
  {
    return this.d;
  }
  
  public void setAppKey(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setParams(Map<String, String> paramMap)
  {
    this.e = paramMap;
  }
  
  public void setSucceed(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setType(EventType paramEventType)
  {
    this.c = paramEventType;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconEvent
 * JD-Core Version:    0.7.0.1
 */