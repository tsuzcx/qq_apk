package com.tencent.magicbrush;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseLongArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.gk.h;
import java.util.LinkedList;
import java.util.Queue;

public class d
{
  private final MBRuntime a;
  private SparseLongArray b = new SparseLongArray();
  private a c = new a();
  private Handler d;
  private final d.b e = new d.b(this, null);
  private int f;
  private int g;
  private float h;
  private Queue<Float> i = new LinkedList();
  private float j;
  private boolean k;
  private int l;
  private int m;
  private boolean n;
  private d.a o = new d.a(this);
  private d.a p = new d.a(this);
  
  d(MBRuntime paramMBRuntime)
  {
    this.a = paramMBRuntime;
    this.k = false;
  }
  
  @AnyThread
  @NonNull
  private void g()
  {
    synchronized (this.a)
    {
      if (this.a.a == 0L) {
        return;
      }
      Object localObject1 = this.a.nativeGetCurrentFps(this.a.a);
      this.c.a = localObject1[0];
      this.c.b = localObject1[1];
      if (this.k)
      {
        this.l += 1;
        if (this.l > this.m)
        {
          this.l = 1;
          if (this.n)
          {
            this.o.b = 0;
            this.o.a = 0;
          }
        }
        if (this.c.a < this.h)
        {
          localObject1 = this.o;
          ((d.a)localObject1).b += 1;
        }
        if ((this.i.size() >= this.f) && (this.f > 0))
        {
          if (this.c.a * this.f + this.g < this.j)
          {
            localObject1 = this.o;
            ((d.a)localObject1).a += 1;
          }
          this.j -= ((Float)this.i.remove()).floatValue();
        }
        this.i.add(Float.valueOf(this.c.a));
        this.j += this.c.a;
      }
      return;
    }
  }
  
  public float a(int paramInt)
  {
    return (e() - paramInt) * 1000.0F / (float)h.a(this.b.get(paramInt));
  }
  
  void a()
  {
    if (this.d == null)
    {
      this.d = new Handler(Looper.getMainLooper());
      this.d.post(this.e);
    }
  }
  
  void b()
  {
    Handler localHandler = this.d;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.e);
      this.d = null;
    }
  }
  
  public int c()
  {
    int i1 = e();
    this.b.put(i1, h.a());
    return i1;
  }
  
  public a d()
  {
    synchronized (this.a)
    {
      a locala = this.c;
      return locala;
    }
  }
  
  @AnyThread
  public int e()
  {
    synchronized (this.a)
    {
      if (this.a.a == 0L) {
        return -1;
      }
      int i1 = this.a.nativeGetFrameCounter(this.a.a);
      return i1;
    }
  }
  
  public void f()
  {
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.d
 * JD-Core Version:    0.7.0.1
 */