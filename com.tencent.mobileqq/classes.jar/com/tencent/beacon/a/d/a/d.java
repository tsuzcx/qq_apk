package com.tencent.beacon.a.d.a;

import com.tencent.beacon.a.h.a;
import com.tencent.beacon.a.h.b;
import com.tencent.beacon.a.h.c;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends c
{
  private static Map<String, String> c = new HashMap();
  private Map<String, String> a = null;
  private byte[] b = null;
  
  static
  {
    c.put("", "");
    ((byte[])new byte[1])[0] = 0;
  }
  
  public d() {}
  
  public d(Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this.a = paramMap;
    this.b = paramArrayOfByte;
  }
  
  public final void a(a parama)
  {
    this.a = ((Map)parama.a(c, 0, true));
    this.b = ((byte[])parama.c(1, true));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.d.a.d
 * JD-Core Version:    0.7.0.1
 */