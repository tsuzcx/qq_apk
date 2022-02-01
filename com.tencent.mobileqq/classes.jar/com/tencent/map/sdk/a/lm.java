package com.tencent.map.sdk.a;

import com.tencent.map.sdk.engine.jni.models.TappedElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public final class lm
{
  public lg a;
  public gq b;
  private CopyOnWriteArrayList<go> c;
  private CopyOnWriteArrayList<go> d;
  private CopyOnWriteArrayList<go> e;
  private gt f;
  private List<Object> g;
  private gp h;
  private CopyOnWriteArrayList<Integer> i;
  
  public lm(lg paramlg)
  {
    this.a = paramlg;
    this.c = new CopyOnWriteArrayList();
    this.d = new CopyOnWriteArrayList();
    this.e = new CopyOnWriteArrayList();
    this.i = new CopyOnWriteArrayList();
  }
  
  public final void a(go paramgo)
  {
    synchronized (this.c)
    {
      if (this.c.contains(paramgo)) {
        return;
      }
      this.c.add(paramgo);
      this.a.b().a.b();
      return;
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    for (;;)
    {
      int j;
      synchronized (this.c)
      {
        j = this.c.size() - 1;
        if (j >= 0)
        {
          go localgo = (go)this.c.get(j);
          if ((localgo == null) || (!localgo.a(paramFloat1, paramFloat2))) {
            break label206;
          }
          return true;
        }
        ??? = this.a.g().b(paramFloat1, paramFloat2);
        if (??? == null) {
          break label204;
        }
        if ((((TappedElement)???).type == 1) && (this.f != null))
        {
          new im(((TappedElement)???).name, gb.a(((TappedElement)???).pixelX, ((TappedElement)???).pixelY));
          return true;
        }
      }
      if ((((TappedElement)???).type == 6) && (this.g != null))
      {
        ??? = this.g.iterator();
        while (((Iterator)???).hasNext()) {
          ((Iterator)???).next();
        }
        return true;
      }
      return (((TappedElement)???).type == 7) && (this.h != null);
      label204:
      label206:
      j -= 1;
    }
  }
  
  @Deprecated
  public final boolean a(GL10 paramGL10)
  {
    for (;;)
    {
      int j;
      int k;
      synchronized (this.c)
      {
        ArrayList localArrayList = new ArrayList();
        int m = this.e.size();
        j = 0;
        if (j < m)
        {
          localObject2 = (go)this.e.get(j);
          if ((localObject2 instanceof in))
          {
            localObject2 = (in)localObject2;
            int n = ((in)localObject2).a();
            k = 0;
            if (k >= n) {
              break label321;
            }
            go localgo = ((in)localObject2).a(k);
            if (!(localgo instanceof ir)) {
              break label314;
            }
            int i1 = ((ir)localgo).a();
            if (i1 < 0) {
              break label314;
            }
            localArrayList.add(Integer.valueOf(i1));
            break label314;
          }
          if (!(localObject2 instanceof ir)) {
            break label321;
          }
          k = ((ir)localObject2).a();
          if (k < 0) {
            break label321;
          }
          localArrayList.add(Integer.valueOf(k));
          break label321;
        }
        k = localArrayList.size();
        Object localObject2 = new int[k];
        j = 0;
        if (j < k)
        {
          localObject2[j] = ((Integer)localArrayList.get(j)).intValue();
          j += 1;
          continue;
        }
        this.a.g().a((int[])localObject2, k);
        this.e.clear();
        this.d.clear();
      }
      synchronized (this.c)
      {
        this.d.addAll(this.c);
        ??? = this.d.iterator();
        while (((Iterator)???).hasNext())
        {
          ((go)((Iterator)???).next()).a(paramGL10);
          continue;
          paramGL10 = finally;
          throw paramGL10;
        }
      }
      return true;
      label314:
      k += 1;
      continue;
      label321:
      j += 1;
    }
  }
  
  public final void b(go paramgo)
  {
    if (paramgo == null) {
      return;
    }
    synchronized (this.c)
    {
      if (this.c.remove(paramgo)) {
        this.a.b().a.b();
      }
      this.e.add(paramgo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.lm
 * JD-Core Version:    0.7.0.1
 */