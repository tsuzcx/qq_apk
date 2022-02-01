package com.tencent.mm.plugin.appbrand.jsruntime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.appbrand.v8.c;
import com.tencent.mm.appbrand.v8.c.a;
import java.util.ArrayList;

public abstract class a
  extends d
  implements i, k, m, p, s, t, u
{
  private final c b;
  private final com.tencent.mm.appbrand.v8.n c;
  private final e d;
  private ArrayList<m.a> e = new ArrayList();
  private final Object f;
  private ArrayList<p.a> g;
  private final boolean h;
  
  public a(@Nullable c.a parama)
  {
    boolean bool2 = false;
    this.f = new byte[0];
    this.g = new ArrayList();
    this.b = a(parama);
    boolean bool1 = bool2;
    if (parama != null)
    {
      bool1 = bool2;
      if (parama.d) {
        bool1 = true;
      }
    }
    this.h = bool1;
    this.c = a(this.b, e.a());
    this.b.a(new a.1(this));
    this.d = new e(new a.2(this));
    this.d.a(this);
  }
  
  public a(@Nullable String paramString, @Nullable byte[] paramArrayOfByte)
  {
    this(new c.a(paramString, paramArrayOfByte));
  }
  
  @NonNull
  protected c a()
  {
    return this.b;
  }
  
  protected abstract c a(@Nullable c.a parama);
  
  protected abstract com.tencent.mm.appbrand.v8.n a(c paramc, int paramInt);
  
  public final g a(int paramInt)
  {
    return this.d.a(paramInt);
  }
  
  public final <T extends j> T a(Class<T> paramClass)
  {
    if ((paramClass == n.class) && (!this.h)) {
      return null;
    }
    return super.a(paramClass);
  }
  
  public void a(@Nullable m.a parama)
  {
    try
    {
      this.e.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  protected final com.tencent.mm.appbrand.v8.n b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.d.b(paramInt);
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final int d()
  {
    e locale = this.d;
    return e.a();
  }
  
  public void destroy()
  {
    b().a().b(new a.3(this));
    this.d.d();
    super.destroy();
    this.b.i();
  }
  
  public final g e()
  {
    return this.d.b();
  }
  
  public final g f()
  {
    return this.d.c();
  }
  
  public void setJsExceptionHandler(h paramh)
  {
    b().a(d(), paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.a
 * JD-Core Version:    0.7.0.1
 */