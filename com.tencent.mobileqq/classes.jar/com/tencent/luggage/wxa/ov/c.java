package com.tencent.luggage.wxa.ov;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ou.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.bg;
import java.util.Deque;
import java.util.LinkedList;

public class c
  implements g, h
{
  private final String b;
  private final SparseArray<h.a> c = new SparseArray();
  private final Deque<h.a> d = new LinkedList();
  private boolean e = true;
  private String f;
  private h.a g;
  
  public c(String paramString1, String paramString2)
  {
    this.b = paramString1;
    try
    {
      this.f = paramString2;
      return;
    }
    finally {}
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.dq.c paramc1, @NonNull com.tencent.luggage.wxa.dq.c paramc2)
  {
    try
    {
      boolean bool = a(paramc2.ao());
      this.g = e(paramc2);
      this.g.c = new h.c(1, paramc1.ao());
      int i = paramc1.hashCode();
      while ((!c()) && (b().a != i)) {
        a();
      }
      if (bool) {
        a(new h.a(paramc1));
      }
      e(paramc1).d = new h.b(paramc2.ao());
      e(paramc1).c = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw paramc1;
    }
  }
  
  private void d()
  {
    try
    {
      this.g = null;
      this.f = null;
      this.e = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    try
    {
      this.f = paramc.ao();
      this.e = false;
      a(new h.a(paramc));
      h.a locala = b();
      if (af.c(this.b)) {
        paramc = null;
      } else {
        paramc = new h.b(this.b);
      }
      locala.d = paramc;
      return;
    }
    finally {}
  }
  
  private h.a e(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    h.a locala = b();
    if (locala == null)
    {
      if (!com.tencent.luggage.wxa.qz.c.a) {
        return new h.a(paramc);
      }
      throw new IllegalStateException("mismatch stack order, call @smoothieli to fix this");
    }
    if (locala.a == paramc.hashCode()) {
      return locala;
    }
    if (!com.tencent.luggage.wxa.qz.c.a)
    {
      o.a("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
      return locala;
    }
    throw new IllegalStateException("mismatch stack order, call @smoothieli to fix this");
  }
  
  public h.a a()
  {
    try
    {
      h.a locala = (h.a)this.d.pollFirst();
      if (locala != null) {
        this.c.remove(locala.a);
      }
      return locala;
    }
    finally {}
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    try
    {
      h.a locala = e(paramc);
      if (locala == null) {
        return;
      }
      paramc = f.a(paramc);
      locala.c = new h.c(((Integer)paramc.first).intValue(), (String)paramc.second);
      return;
    }
    finally {}
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc1, @Nullable com.tencent.luggage.wxa.dq.c paramc2, @NonNull bg parambg)
  {
    try
    {
      if (this.e)
      {
        d(paramc1);
        return;
      }
      if (parambg == bg.c)
      {
        a(paramc1, paramc2);
        return;
      }
      if (this.g != null) {
        d();
      }
      if (paramc2 != null)
      {
        parambg = e(paramc2);
        if (parambg != null) {
          parambg.c = new h.c(2, paramc1.ao());
        }
      }
      parambg = new h.a(paramc1);
      if (paramc2 == null) {
        paramc1 = null;
      } else {
        paramc1 = new h.b(paramc2.ao());
      }
      parambg.d = paramc1;
      a(parambg);
      return;
    }
    finally {}
  }
  
  public void a(@NonNull h.a parama)
  {
    try
    {
      this.d.offerFirst(parama);
      this.c.put(parama.a, parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (!af.c(this.f))
      {
        bool = this.f.equals(paramString);
        if (bool)
        {
          bool = true;
          break label32;
        }
      }
      boolean bool = false;
      label32:
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public h.a b()
  {
    try
    {
      h.a locala = (h.a)this.d.peekFirst();
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public h.a b(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    try
    {
      h.a locala = (h.a)this.c.get(paramc.hashCode());
      if ((locala == null) && (this.g != null) && (this.g.a == paramc.hashCode()))
      {
        paramc = this.g;
        return paramc;
      }
      return locala;
    }
    finally {}
  }
  
  public void c(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    try
    {
      if (this.e)
      {
        d(paramc);
        return;
      }
      d();
      return;
    }
    finally {}
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.d.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.c
 * JD-Core Version:    0.7.0.1
 */