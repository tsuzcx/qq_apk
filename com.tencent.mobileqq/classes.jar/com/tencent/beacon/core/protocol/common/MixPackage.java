package com.tencent.beacon.core.protocol.common;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.HashMap;
import java.util.Map;

public final class MixPackage
  extends JceStruct
  implements Cloneable
{
  static Map<Integer, byte[]> cache_mixMap;
  public Map<Integer, byte[]> mixMap = null;
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public void readFrom(a parama)
  {
    if (cache_mixMap == null)
    {
      cache_mixMap = new HashMap();
      cache_mixMap.put(Integer.valueOf(0), new byte[] { 0 });
    }
    this.mixMap = ((Map)parama.a(cache_mixMap, 0, true));
  }
  
  public void writeTo(b paramb)
  {
    paramb.a(this.mixMap, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.common.MixPackage
 * JD-Core Version:    0.7.0.1
 */