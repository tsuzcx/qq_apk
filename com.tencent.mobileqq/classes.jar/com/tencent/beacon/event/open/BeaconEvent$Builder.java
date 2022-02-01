package com.tencent.beacon.event.open;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class BeaconEvent$Builder
{
  private String a;
  private String b;
  private EventType c = EventType.NORMAL;
  private boolean d = true;
  private Map<String, String> e = new HashMap();
  
  private BeaconEvent$Builder() {}
  
  private BeaconEvent$Builder(BeaconEvent paramBeaconEvent)
  {
    this.a = BeaconEvent.a(paramBeaconEvent);
    this.b = BeaconEvent.b(paramBeaconEvent);
    this.c = BeaconEvent.c(paramBeaconEvent);
    this.d = BeaconEvent.d(paramBeaconEvent);
    this.e.putAll(BeaconEvent.e(paramBeaconEvent));
  }
  
  public BeaconEvent build()
  {
    String str = com.tencent.beacon.event.c.c.b(this.b);
    if (TextUtils.isEmpty(this.a)) {
      this.a = com.tencent.beacon.a.c.c.d().f();
    }
    return new BeaconEvent(this.a, str, this.c, this.d, this.e, null);
  }
  
  public Builder withAppKey(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public Builder withCode(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Builder withIsSucceed(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public Builder withParams(@NonNull String paramString1, String paramString2)
  {
    this.e.put(paramString1, paramString2);
    return this;
  }
  
  public Builder withParams(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      this.e.putAll(paramMap);
    }
    return this;
  }
  
  public Builder withType(EventType paramEventType)
  {
    this.c = paramEventType;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconEvent.Builder
 * JD-Core Version:    0.7.0.1
 */