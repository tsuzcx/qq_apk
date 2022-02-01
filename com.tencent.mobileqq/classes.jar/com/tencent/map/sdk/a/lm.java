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
    int j;
    synchronized (this.c)
    {
      j = this.c.size() - 1;
      Object localObject2;
      if (j >= 0)
      {
        localObject2 = (go)this.c.get(j);
        if ((localObject2 != null) && (((go)localObject2).a(paramFloat1, paramFloat2))) {
          return true;
        }
      }
      else
      {
        ??? = this.a.g().b(paramFloat1, paramFloat2);
        if (??? != null)
        {
          if ((((TappedElement)???).type == 1) && (this.f != null))
          {
            new im(((TappedElement)???).name, gb.a(((TappedElement)???).pixelX, ((TappedElement)???).pixelY));
            return true;
          }
          if (((TappedElement)???).type == 6)
          {
            localObject2 = this.g;
            if (localObject2 != null)
            {
              ??? = ((List)localObject2).iterator();
              while (((Iterator)???).hasNext()) {
                ((Iterator)???).next();
              }
              return true;
            }
          }
          if ((((TappedElement)???).type == 7) && (this.h != null)) {
            return true;
          }
        }
        return false;
      }
    }
  }
  
  @Deprecated
  public final boolean a(GL10 paramGL10)
  {
    int j;
    int k;
    label331:
    synchronized (this.c)
    {
      ArrayList localArrayList = new ArrayList();
      int n = this.e.size();
      int m = 0;
      j = 0;
      Object localObject2;
      if (j < n)
      {
        localObject2 = (go)this.e.get(j);
        if ((localObject2 instanceof in))
        {
          localObject2 = (in)localObject2;
          int i1 = ((in)localObject2).a();
          k = 0;
          if (k >= i1) {
            break label331;
          }
          go localgo = ((in)localObject2).a(k);
          if ((localgo instanceof ir))
          {
            int i2 = ((ir)localgo).a();
            if (i2 >= 0) {
              localArrayList.add(Integer.valueOf(i2));
            }
          }
        }
        else
        {
          if (!(localObject2 instanceof ir)) {
            break label331;
          }
          k = ((ir)localObject2).a();
          if (k < 0) {
            break label331;
          }
          localArrayList.add(Integer.valueOf(k));
          break label331;
        }
      }
      else
      {
        k = localArrayList.size();
        localObject2 = new int[k];
        j = m;
        while (j < k)
        {
          localObject2[j] = ((Integer)localArrayList.get(j)).intValue();
          j += 1;
        }
        this.a.g().a((int[])localObject2, k);
        this.e.clear();
        this.d.clear();
        synchronized (this.c)
        {
          this.d.addAll(this.c);
          ??? = this.d.iterator();
          while (((Iterator)???).hasNext()) {
            ((go)((Iterator)???).next()).a(paramGL10);
          }
          return true;
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lm
 * JD-Core Version:    0.7.0.1
 */