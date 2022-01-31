package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class au
  extends k
  implements Cloneable
{
  private static ArrayList<at> f;
  private static Map<String, String> g;
  public byte a = 0;
  public String b = "";
  public String c = "";
  public ArrayList<at> d = null;
  public Map<String, String> e = null;
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.b(1, false);
    this.c = parami.b(2, false);
    if (f == null)
    {
      f = new ArrayList();
      at localat = new at();
      f.add(localat);
    }
    this.d = ((ArrayList)parami.a(f, 3, false));
    if (g == null)
    {
      g = new HashMap();
      g.put("", "");
    }
    this.e = ((Map)parami.a(g, 4, false));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    if (this.b != null) {
      paramj.a(this.b, 1);
    }
    if (this.c != null) {
      paramj.a(this.c, 2);
    }
    if (this.d != null) {
      paramj.a(this.d, 3);
    }
    if (this.e != null) {
      paramj.a(this.e, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.au
 * JD-Core Version:    0.7.0.1
 */