package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ar
  extends k
  implements Cloneable
{
  private static ArrayList<aq> f;
  private static Map<String, String> g;
  public byte a = 0;
  public String b = "";
  public String c = "";
  public ArrayList<aq> d = null;
  public Map<String, String> e = null;
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.b(1, false);
    this.c = parami.b(2, false);
    if (f == null)
    {
      f = new ArrayList();
      aq localaq = new aq();
      f.add(localaq);
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
    Object localObject = this.b;
    if (localObject != null) {
      paramj.a((String)localObject, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramj.a((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramj.a((Collection)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramj.a((Map)localObject, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.ar
 * JD-Core Version:    0.7.0.1
 */