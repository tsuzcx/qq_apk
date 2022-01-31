package com.tencent.beacon.a.d.c;

import com.tencent.beacon.a.h.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends c
{
  private static ArrayList<b> e;
  private static Map<String, String> f;
  public ArrayList<b> a = null;
  public int b = 0;
  public String c = "";
  public Map<String, String> d = null;
  
  public final void a(com.tencent.beacon.a.h.a parama)
  {
    if (e == null)
    {
      e = new ArrayList();
      b localb = new b();
      e.add(localb);
    }
    this.a = ((ArrayList)parama.a(e, 0, true));
    this.b = parama.a(this.b, 1, true);
    this.c = parama.b(2, true);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)parama.a(f, 3, false));
  }
  
  public final void a(com.tencent.beacon.a.h.b paramb)
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
 * Qualified Name:     com.tencent.beacon.a.d.c.a
 * JD-Core Version:    0.7.0.1
 */