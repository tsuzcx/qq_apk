package com.tencent.beacon.core.protocol.strategy;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ModuleStrategy
  extends JceStruct
{
  static Map<String, String> cache_detail;
  static ArrayList<String> cache_preventEventCode;
  static ArrayList<String> cache_sampleEvent;
  public static Object cache_sms;
  public Map<String, String> detail = null;
  public byte mId = 0;
  public byte onOff = 0;
  public ArrayList<String> preventEventCode = null;
  public ArrayList<String> sampleEvent = null;
  public Object sms = null;
  public String url = "";
  
  public ModuleStrategy() {}
  
  public ModuleStrategy(byte paramByte1, byte paramByte2, String paramString, Map<String, String> paramMap, ArrayList<String> paramArrayList1, Object paramObject, ArrayList<String> paramArrayList2)
  {
    this.mId = paramByte1;
    this.onOff = paramByte2;
    this.url = paramString;
    this.detail = paramMap;
    this.preventEventCode = paramArrayList1;
    this.sms = paramObject;
    this.sampleEvent = paramArrayList2;
  }
  
  public final void readFrom(a parama)
  {
    this.mId = parama.a(this.mId, 0, true);
    this.onOff = parama.a(this.onOff, 1, true);
    this.url = parama.b(2, true);
    if (cache_detail == null)
    {
      cache_detail = new HashMap();
      cache_detail.put("", "");
    }
    this.detail = ((Map)parama.a(cache_detail, 3, true));
    if (cache_preventEventCode == null)
    {
      cache_preventEventCode = new ArrayList();
      cache_preventEventCode.add("");
    }
    this.preventEventCode = ((ArrayList)parama.a(cache_preventEventCode, 4, false));
    if (cache_sms != null) {
      this.sms = parama.a(cache_sms, 5, false);
    }
    if (cache_sampleEvent == null)
    {
      cache_sampleEvent = new ArrayList();
      cache_sampleEvent.add("");
    }
    this.sampleEvent = ((ArrayList)parama.a(cache_sampleEvent, 6, false));
  }
  
  public final void writeTo(b paramb)
  {
    paramb.a(this.mId, 0);
    paramb.a(this.onOff, 1);
    paramb.a(this.url, 2);
    paramb.a(this.detail, 3);
    if (this.preventEventCode != null) {
      paramb.a(this.preventEventCode, 4);
    }
    if (this.sms != null) {
      paramb.a(this.sms, 5);
    }
    if (this.sampleEvent != null) {
      paramb.a(this.sampleEvent, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.strategy.ModuleStrategy
 * JD-Core Version:    0.7.0.1
 */