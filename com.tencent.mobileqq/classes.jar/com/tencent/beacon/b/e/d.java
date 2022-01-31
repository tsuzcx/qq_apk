package com.tencent.beacon.b.e;

import com.tencent.beacon.e.a;
import com.tencent.beacon.e.b;
import com.tencent.beacon.e.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends c
{
  private static Map<String, String> h;
  private static ArrayList<String> i;
  private static e j;
  private static ArrayList<String> k;
  public byte a = 0;
  public byte b = 0;
  public String c = "";
  public Map<String, String> d = null;
  public ArrayList<String> e = null;
  public e f = null;
  public ArrayList<String> g = null;
  
  public final void a(a parama)
  {
    this.a = parama.a(this.a, 0, true);
    this.b = parama.a(this.b, 1, true);
    this.c = parama.b(2, true);
    if (h == null)
    {
      h = new HashMap();
      h.put("", "");
    }
    this.d = ((Map)parama.a(h, 3, true));
    if (i == null)
    {
      i = new ArrayList();
      i.add("");
    }
    this.e = ((ArrayList)parama.a(i, 4, false));
    if (j == null) {
      j = new e();
    }
    this.f = ((e)parama.a(j, 5, false));
    if (k == null)
    {
      k = new ArrayList();
      k.add("");
    }
    this.g = ((ArrayList)parama.a(k, 6, false));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    paramb.a(this.d, 3);
    if (this.e != null) {
      paramb.a(this.e, 4);
    }
    if (this.f != null) {
      paramb.a(this.f);
    }
    if (this.g != null) {
      paramb.a(this.g, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.e.d
 * JD-Core Version:    0.7.0.1
 */