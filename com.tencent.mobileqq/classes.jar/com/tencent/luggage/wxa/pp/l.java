package com.tencent.luggage.wxa.pp;

import android.util.SparseArray;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

final class l
  implements f.b, f.c
{
  static SparseArray<WeakReference<u>> a = new SparseArray();
  final WeakReference<u> b;
  
  private l(u paramu)
  {
    this.b = new WeakReference(paramu);
  }
  
  public static void a(u paramu)
  {
    synchronized (a)
    {
      if (a.get(paramu.getComponentId()) == null)
      {
        a.put(paramu.getComponentId(), new WeakReference(paramu));
        l locall = new l(paramu);
        paramu.a(locall);
        paramu.a(locall);
      }
      return;
    }
  }
  
  public static void b(u paramu)
  {
    synchronized (a)
    {
      if (a.get(paramu.getComponentId()) == null) {
        a.remove(paramu.getComponentId());
      }
      return;
    }
  }
  
  public void b()
  {
    u localu = (u)this.b.get();
    if (localu != null) {
      o.a(localu);
    }
  }
  
  public void d()
  {
    u localu = (u)this.b.get();
    if (localu != null)
    {
      if ((localu.getContext() instanceof ae)) {
        ((ae)localu.getContext()).i();
      }
      o.a(localu);
      o.b(localu);
      e.a(localu);
      localu.b(this);
      localu.b(this);
      if (localu.aj() != null) {
        h.a().a(localu.aj());
      }
      b(localu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.l
 * JD-Core Version:    0.7.0.1
 */