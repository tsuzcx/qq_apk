package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public abstract class il<T extends Object<E>, E extends go>
  implements go
{
  private ArrayList<E> a;
  private int b = -1;
  private int c = -1;
  
  private int c()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private E d()
  {
    try
    {
      if ((this.a != null) && (this.c >= 0) && (this.a.size() > this.c))
      {
        go localgo = (go)this.a.get(this.c);
        return localgo;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int a()
  {
    try
    {
      ArrayList localArrayList = this.a;
      if (localArrayList == null) {
        return 0;
      }
      int i = this.a.size();
      return i;
    }
    finally {}
  }
  
  public final Rect a(fu paramfu)
  {
    Object localObject1 = b(paramfu);
    int i = ((Rect)localObject1).left;
    int j = ((Rect)localObject1).right;
    int k = ((Rect)localObject1).top;
    int m = ((Rect)localObject1).bottom;
    Object localObject2 = new GeoPoint(k, i);
    Object localObject4 = new GeoPoint(m, i);
    Object localObject3 = new GeoPoint(m, j);
    localObject1 = new GeoPoint(k, j);
    localObject2 = paramfu.a((GeoPoint)localObject2);
    localObject4 = paramfu.a((GeoPoint)localObject4);
    localObject3 = paramfu.a((GeoPoint)localObject3);
    paramfu = paramfu.a((GeoPoint)localObject1);
    return new Rect((int)Math.min(Math.min(((DoublePoint)localObject2).x, ((DoublePoint)localObject4).x), Math.min(((DoublePoint)localObject3).x, paramfu.x)), (int)Math.min(Math.min(((DoublePoint)localObject2).y, ((DoublePoint)localObject4).y), Math.min(((DoublePoint)localObject3).y, paramfu.y)), (int)Math.max(Math.max(((DoublePoint)localObject2).x, ((DoublePoint)localObject4).x), Math.max(((DoublePoint)localObject3).x, paramfu.x)), (int)Math.max(Math.max(((DoublePoint)localObject2).y, ((DoublePoint)localObject4).y), Math.max(((DoublePoint)localObject3).y, paramfu.y)));
  }
  
  public final E a(int paramInt)
  {
    try
    {
      if ((this.a != null) && (paramInt >= 0) && (this.a.size() > paramInt))
      {
        go localgo = (go)this.a.get(paramInt);
        return localgo;
      }
      return null;
    }
    finally {}
  }
  
  public final void a(E paramE)
  {
    try
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      this.a.add(paramE);
      return;
    }
    finally {}
  }
  
  public final void a(List<E> paramList)
  {
    try
    {
      if (paramList.size() <= 0)
      {
        this.a = null;
        return;
      }
      if (this.a == null) {
        this.a = new ArrayList(paramList.size());
      } else {
        this.a.clear();
      }
      this.a.addAll(paramList);
      return;
    }
    finally {}
  }
  
  public void a(GL10 paramGL10)
  {
    int j = c();
    int k = a();
    int i = 0;
    while (i < k)
    {
      if (j != i)
      {
        localgo = a(i);
        if ((localgo != null) && ((localgo instanceof ip))) {
          localgo.a(paramGL10);
        }
      }
      i += 1;
    }
    go localgo = d();
    if ((localgo != null) && ((localgo instanceof ip))) {
      localgo.a(paramGL10);
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(this.a.size());
      localArrayList.addAll(this.a);
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        int k = (this.b + i + 1) % j;
        if (((go)localArrayList.get(k)).a(paramFloat1, paramFloat2))
        {
          this.b = k;
          return true;
        }
        i += 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final Rect b(fu paramfu)
  {
    try
    {
      Object localObject2 = this.a;
      Object localObject1 = null;
      if ((localObject2 != null) && (!this.a.isEmpty()))
      {
        int i = 0;
        int j = this.a.size();
        while (i < j)
        {
          Rect localRect = ((go)this.a.get(i)).b(paramfu);
          localObject2 = localObject1;
          if (localRect != null) {
            if (localObject1 == null)
            {
              localObject2 = localRect;
            }
            else
            {
              localObject1.left = Math.min(localObject1.left, localRect.left);
              localObject1.top = Math.max(localObject1.top, localRect.top);
              localObject1.right = Math.max(localObject1.right, localRect.right);
              localObject1.bottom = Math.min(localObject1.bottom, localRect.bottom);
              localObject2 = localObject1;
            }
          }
          i += 1;
          localObject1 = localObject2;
        }
        return localObject1;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramfu;
    }
  }
  
  public final void b()
  {
    try
    {
      if (this.a != null) {
        this.a.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean b(E paramE)
  {
    try
    {
      if (this.a != null)
      {
        boolean bool = this.a.remove(paramE);
        return bool;
      }
      return false;
    }
    finally
    {
      paramE = finally;
      throw paramE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.il
 * JD-Core Version:    0.7.0.1
 */