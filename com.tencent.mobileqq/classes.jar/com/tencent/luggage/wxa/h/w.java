package com.tencent.luggage.wxa.h;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.tencent.luggage.wxa.ad.j.a;
import com.tencent.luggage.wxa.i.b;
import com.tencent.luggage.wxa.i.e;
import com.tencent.luggage.wxa.j.d;
import com.tencent.luggage.wxa.v.f.a;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public class w
  implements f
{
  protected final s[] a;
  private final f b;
  private final w.a c = new w.a(this, null);
  private final CopyOnWriteArraySet<w.b> d = new CopyOnWriteArraySet();
  private final CopyOnWriteArraySet<j.a> e = new CopyOnWriteArraySet();
  private final CopyOnWriteArraySet<f.a> f = new CopyOnWriteArraySet();
  private final int g;
  private final int h;
  private k i;
  private k j;
  private Surface k;
  private boolean l;
  private int m;
  private SurfaceHolder n;
  private TextureView o;
  private e p;
  private com.tencent.luggage.wxa.ap.g q;
  private d r;
  private d s;
  private int t;
  private b u;
  private float v;
  
  protected w(v paramv, com.tencent.luggage.wxa.al.g paramg, n paramn)
  {
    if (Looper.myLooper() != null) {
      localObject = Looper.myLooper();
    } else {
      localObject = Looper.getMainLooper();
    }
    Object localObject = new Handler((Looper)localObject);
    w.a locala = this.c;
    this.a = paramv.a((Handler)localObject, locala, locala, locala, locala);
    paramv = this.a;
    int i4 = paramv.length;
    int i1 = 0;
    int i3 = 0;
    int i2 = 0;
    while (i1 < i4)
    {
      int i5 = paramv[i1].a();
      if (i5 != 1)
      {
        if (i5 == 2) {
          i3 += 1;
        }
      }
      else {
        i2 += 1;
      }
      i1 += 1;
    }
    this.g = i3;
    this.h = i2;
    this.v = 1.0F;
    this.t = 0;
    this.u = b.a;
    this.m = 1;
    this.b = new h(this.a, paramg, paramn);
  }
  
  private void a(Surface paramSurface, boolean paramBoolean)
  {
    f.c[] arrayOfc = new f.c[this.g];
    Object localObject = this.a;
    int i4 = localObject.length;
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      f.b localb = localObject[i1];
      i3 = i2;
      if (localb.a() == 2)
      {
        arrayOfc[i2] = new f.c(localb, 1, paramSurface);
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    localObject = this.k;
    if ((localObject != null) && (localObject != paramSurface))
    {
      this.b.b(arrayOfc);
      if (this.l) {
        this.k.release();
      }
    }
    else
    {
      this.b.a(arrayOfc);
    }
    this.k = paramSurface;
    this.l = paramBoolean;
  }
  
  private void f()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      if (((TextureView)localObject).getSurfaceTextureListener() != this.c) {
        Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
      } else {
        this.o.setSurfaceTextureListener(null);
      }
      this.o = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((SurfaceHolder)localObject).removeCallback(this.c);
      this.n = null;
    }
  }
  
  public int a()
  {
    return this.b.a();
  }
  
  public void a(long paramLong)
  {
    this.b.a(paramLong);
  }
  
  public void a(q paramq)
  {
    this.b.a(paramq);
  }
  
  public void a(r.a parama)
  {
    this.b.a(parama);
  }
  
  public void a(e parame)
  {
    this.p = parame;
  }
  
  public void a(f.a parama)
  {
    this.f.add(parama);
  }
  
  public void a(com.tencent.luggage.wxa.z.h paramh)
  {
    this.b.a(paramh);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public void a(f.c... paramVarArgs)
  {
    this.b.a(paramVarArgs);
  }
  
  public void b(r.a parama)
  {
    this.b.b(parama);
  }
  
  public void b(f.c... paramVarArgs)
  {
    this.b.b(paramVarArgs);
  }
  
  public boolean b()
  {
    return this.b.b();
  }
  
  public boolean c()
  {
    return this.b.c();
  }
  
  public void d()
  {
    this.b.d();
  }
  
  public void e()
  {
    this.b.e();
    f();
    Surface localSurface = this.k;
    if (localSurface != null)
    {
      if (this.l) {
        localSurface.release();
      }
      this.k = null;
    }
  }
  
  public long g()
  {
    return this.b.g();
  }
  
  public long h()
  {
    return this.b.h();
  }
  
  public long i()
  {
    return this.b.i();
  }
  
  public int j()
  {
    return this.b.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.w
 * JD-Core Version:    0.7.0.1
 */