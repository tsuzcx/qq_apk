package com.tencent.beacon.pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class RequestPackageV2
  extends AbstractJceStruct
  implements Cloneable
{
  static Map<String, String> cache_common;
  static ArrayList<EventRecordV2> cache_events = new ArrayList();
  public String appVersion = "";
  public Map<String, String> common = null;
  public ArrayList<EventRecordV2> events = null;
  public String mainAppKey = "";
  public String model = "";
  public String osVersion = "";
  public String packageName = "";
  public int platformId = 0;
  public String reserved = "";
  public String sdkId = "";
  public String sdkVersion = "";
  
  static
  {
    EventRecordV2 localEventRecordV2 = new EventRecordV2();
    cache_events.add(localEventRecordV2);
    cache_common = new HashMap();
    cache_common.put("", "");
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
    this.platformId = parama.a(this.platformId, 0, true);
    this.mainAppKey = parama.a(1, true);
    this.appVersion = parama.a(2, true);
    this.sdkVersion = parama.a(3, true);
    this.events = ((ArrayList)parama.a(cache_events, 4, true));
    this.packageName = parama.a(5, false);
    this.common = ((Map)parama.a(cache_common, 6, false));
    this.model = parama.a(7, false);
    this.osVersion = parama.a(8, false);
    this.reserved = parama.a(9, false);
    this.sdkId = parama.a(10, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RequestPackageV2{platformId=");
    localStringBuilder.append(this.platformId);
    localStringBuilder.append(", mainAppKey='");
    localStringBuilder.append(this.mainAppKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appVersion='");
    localStringBuilder.append(this.appVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sdkVersion='");
    localStringBuilder.append(this.sdkVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", packageName='");
    localStringBuilder.append(this.packageName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", model='");
    localStringBuilder.append(this.model);
    localStringBuilder.append('\'');
    localStringBuilder.append(", osVersion='");
    localStringBuilder.append(this.osVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reserved='");
    localStringBuilder.append(this.reserved);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sdkId='");
    localStringBuilder.append(this.sdkId);
    localStringBuilder.append('\'');
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
  
  public void writeTo(b paramb)
  {
    paramb.a(this.platformId, 0);
    paramb.a(this.mainAppKey, 1);
    paramb.a(this.appVersion, 2);
    paramb.a(this.sdkVersion, 3);
    paramb.a(this.events, 4);
    Object localObject = this.packageName;
    if (localObject != null) {
      paramb.a((String)localObject, 5);
    }
    localObject = this.common;
    if (localObject != null) {
      paramb.a((Map)localObject, 6);
    }
    localObject = this.model;
    if (localObject != null) {
      paramb.a((String)localObject, 7);
    }
    localObject = this.osVersion;
    if (localObject != null) {
      paramb.a((String)localObject, 8);
    }
    localObject = this.reserved;
    if (localObject != null) {
      paramb.a((String)localObject, 9);
    }
    localObject = this.sdkId;
    if (localObject != null) {
      paramb.a((String)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.RequestPackageV2
 * JD-Core Version:    0.7.0.1
 */