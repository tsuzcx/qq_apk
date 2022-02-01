package com.tencent.luggage.wxa.mi;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements c
{
  protected b.e a;
  protected b.d b;
  protected b.f c;
  protected b.b d;
  protected b.g e;
  protected b.a f;
  protected b.h g;
  protected b.c h;
  private int i = 0;
  private volatile boolean j;
  private final Set<b.f> k = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.g> l = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.b> m = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public final int a()
  {
    return this.i;
  }
  
  public final void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.j) {
        return;
      }
      b.h localh = this.g;
      if (localh != null) {
        localh.a(this, paramInt1, paramInt2);
      }
      return;
    }
    finally {}
  }
  
  public void a(b.a parama)
  {
    this.f = parama;
  }
  
  public void a(b.b paramb)
  {
    this.d = paramb;
  }
  
  public void a(b.d paramd)
  {
    this.b = paramd;
  }
  
  public void a(b.e parame)
  {
    this.a = parame;
  }
  
  public void a(b.f paramf)
  {
    this.c = paramf;
  }
  
  public void a(b.g paramg)
  {
    this.e = paramg;
  }
  
  public void a(b.h paramh)
  {
    this.g = paramh;
  }
  
  protected void a(String paramString)
  {
    o.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnDownStreamChanged, selectIndex:%s", new Object[] { paramString });
    try
    {
      if (this.j) {
        return;
      }
      b.c localc = this.h;
      if (localc != null) {
        localc.a(paramString);
      }
      return;
    }
    finally {}
  }
  
  @CallSuper
  public void b()
  {
    this.j = true;
  }
  
  protected void b(int paramInt)
  {
    try
    {
      if (this.j) {
        return;
      }
      b.a locala = this.f;
      if (locala != null) {
        locala.a(this, paramInt);
      }
      return;
    }
    finally {}
  }
  
  public void b(@NonNull b.b paramb)
  {
    this.m.add(paramb);
  }
  
  public void b(@NonNull b.f paramf)
  {
    this.k.add(paramf);
  }
  
  public void b(@NonNull b.g paramg)
  {
    this.l.add(paramg);
  }
  
  protected boolean b(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    o.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.j) {
        return false;
      }
      b.d locald = this.b;
      boolean bool1 = bool2;
      if (locald != null)
      {
        bool1 = bool2;
        if (locald.a(this, paramInt1, paramInt2)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  protected void c()
  {
    o.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.j) {
        return;
      }
      Object localObject1 = this.c;
      if (localObject1 != null) {
        ((b.f)localObject1).a(this);
      }
      localObject1 = this.k.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((b.f)((Iterator)localObject1).next()).a(this);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected boolean c(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    o.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.j) {
        return false;
      }
      b.e locale = this.a;
      boolean bool1 = bool2;
      if (locale != null)
      {
        bool1 = bool2;
        if (locale.a(this, paramInt1, paramInt2)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  protected void d()
  {
    o.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnCompletion");
    try
    {
      if (this.j) {
        return;
      }
      Object localObject1 = this.d;
      if (localObject1 != null) {
        ((b.b)localObject1).a(this);
      }
      localObject1 = this.m.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((b.b)((Iterator)localObject1).next()).a(this);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void e()
  {
    o.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnSeekComplete");
    try
    {
      if (this.j) {
        return;
      }
      Object localObject1 = this.e;
      if (localObject1 != null) {
        ((b.g)localObject1).a(this);
      }
      localObject1 = this.l.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((b.g)((Iterator)localObject1).next()).a(this);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mi.a
 * JD-Core Version:    0.7.0.1
 */