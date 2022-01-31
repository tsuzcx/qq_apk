package com.tencent.beacon.a.d.a;

import com.tencent.beacon.a.h.a;
import com.tencent.beacon.a.h.b;
import com.tencent.beacon.a.h.c;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends c
{
  private static Map<String, String> e = new HashMap();
  public int a = 0;
  public Map<String, String> b = null;
  public byte[] c = null;
  public String d = "";
  
  static
  {
    e.put("", "");
    ((byte[])new byte[1])[0] = 0;
  }
  
  public final void a(a parama)
  {
    this.a = parama.a(this.a, 0, true);
    this.b = ((Map)parama.a(e, 1, true));
    this.c = ((byte[])parama.c(2, true));
    this.d = parama.b(3, false);
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    if (this.d != null) {
      paramb.a(this.d, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.d.a.e
 * JD-Core Version:    0.7.0.1
 */