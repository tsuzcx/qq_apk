package com.tencent.beacon.a.d.a;

import com.tencent.beacon.a.h.b;
import com.tencent.beacon.a.h.c;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends c
  implements Cloneable
{
  private static Map<Integer, byte[]> b;
  public Map<Integer, byte[]> a = null;
  
  public final void a(com.tencent.beacon.a.h.a parama)
  {
    if (b == null)
    {
      b = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      b.put(Integer.valueOf(0), arrayOfByte);
    }
    this.a = ((Map)parama.a(b, 0, true));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */