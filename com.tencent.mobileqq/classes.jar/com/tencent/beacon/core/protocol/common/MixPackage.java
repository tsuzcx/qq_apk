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
  
  public final void readFrom(a parama)
  {
    if (cache_mixMap == null)
    {
      cache_mixMap = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_mixMap.put(Integer.valueOf(0), arrayOfByte);
    }
    this.mixMap = ((Map)parama.a(cache_mixMap, 0, true));
  }
  
  public final void writeTo(b paramb)
  {
    paramb.a(this.mixMap, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.common.MixPackage
 * JD-Core Version:    0.7.0.1
 */