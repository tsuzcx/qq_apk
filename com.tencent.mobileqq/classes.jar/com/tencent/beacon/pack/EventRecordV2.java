package com.tencent.beacon.pack;

import java.util.HashMap;
import java.util.Map;

public final class EventRecordV2
  extends AbstractJceStruct
  implements Cloneable
{
  static byte[] cache_byteValue;
  static Map<String, String> cache_mapValue;
  static int cache_valueType = 0;
  public String apn = "";
  public String appKey = "";
  public byte[] byteValue = null;
  public String eventCode = "";
  public boolean eventResult = true;
  public long eventTime = 0L;
  public int eventType = 0;
  public Map<String, String> mapValue = null;
  public String reserved = "";
  public String srcIp = "";
  public int valueType = 0;
  
  static
  {
    cache_mapValue = new HashMap();
    cache_mapValue.put("", "");
    cache_byteValue = new byte[1];
    cache_byteValue[0] = 0;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if ($assertionsDisabled) {
      return null;
    }
    throw new AssertionError();
  }
  
  public void readFrom(a parama)
  {
    this.appKey = parama.a(0, false);
    this.apn = parama.a(1, false);
    this.srcIp = parama.a(2, false);
    this.eventCode = parama.a(3, true);
    this.valueType = parama.a(this.valueType, 4, false);
    this.mapValue = ((Map)parama.a(cache_mapValue, 5, false));
    this.byteValue = parama.a(cache_byteValue, 6, false);
    this.eventTime = parama.a(this.eventTime, 7, true);
    this.eventResult = parama.a(this.eventResult, 8, false);
    this.eventType = parama.a(this.eventType, 9, false);
    this.reserved = parama.a(10, false);
  }
  
  public void writeTo(b paramb)
  {
    Object localObject = this.appKey;
    if (localObject != null) {
      paramb.a((String)localObject, 0);
    }
    localObject = this.apn;
    if (localObject != null) {
      paramb.a((String)localObject, 1);
    }
    localObject = this.srcIp;
    if (localObject != null) {
      paramb.a((String)localObject, 2);
    }
    paramb.a(this.eventCode, 3);
    paramb.a(this.valueType, 4);
    localObject = this.mapValue;
    if (localObject != null) {
      paramb.a((Map)localObject, 5);
    }
    localObject = this.byteValue;
    if (localObject != null) {
      paramb.a((byte[])localObject, 6);
    }
    paramb.a(this.eventTime, 7);
    paramb.a(this.eventResult, 8);
    paramb.a(this.eventType, 9);
    localObject = this.reserved;
    if (localObject != null) {
      paramb.a((String)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.EventRecordV2
 * JD-Core Version:    0.7.0.1
 */