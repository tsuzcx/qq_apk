package com.tencent.beacon.b.a;

import com.tencent.beacon.e.b;
import com.tencent.beacon.e.c;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends c
  implements Cloneable
{
  private static Map<Integer, byte[]> b;
  public Map<Integer, byte[]> a = null;
  
  public final void a(com.tencent.beacon.e.a parama)
  {
    if (b == null)
    {
      b = new HashMap();
      b.put(Integer.valueOf(0), new byte[] { 0 });
    }
    this.a = ((Map)parama.a(b, 0, true));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.a.a
 * JD-Core Version:    0.7.0.1
 */