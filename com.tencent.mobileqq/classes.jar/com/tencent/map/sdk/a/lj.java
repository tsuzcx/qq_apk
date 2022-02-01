package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.tencentmap.mapsdk.maps.model.BubbleGroup;
import com.tencent.tencentmap.mapsdk.maps.model.BubbleOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public final class lj
  extends in
{
  private static int e;
  private CopyOnWriteArrayList<lj.a> a = new CopyOnWriteArrayList();
  private Drawable[] b = new Drawable[4];
  private pn c;
  private Context d;
  private BubbleGroup f;
  
  public lj(pn parampn)
  {
    this.c = parampn;
    parampn = parampn.ay;
    Object localObject2 = fy.b(parampn, "bubble_station_lt.9.png");
    Object localObject4 = fy.b(parampn, "bubble_station_rt.9.png");
    Object localObject3 = fy.b(parampn, "bubble_station_rb.9.png");
    Object localObject1 = fy.b(parampn, "bubble_station_lb.9.png");
    byte[] arrayOfByte = ((Bitmap)localObject2).getNinePatchChunk();
    localObject2 = new NinePatchDrawable(parampn.getResources(), (Bitmap)localObject2, arrayOfByte, new Rect(), null);
    arrayOfByte = ((Bitmap)localObject4).getNinePatchChunk();
    localObject4 = new NinePatchDrawable(parampn.getResources(), (Bitmap)localObject4, arrayOfByte, new Rect(), null);
    arrayOfByte = ((Bitmap)localObject3).getNinePatchChunk();
    localObject3 = new NinePatchDrawable(parampn.getResources(), (Bitmap)localObject3, arrayOfByte, new Rect(), null);
    arrayOfByte = ((Bitmap)localObject1).getNinePatchChunk();
    parampn = new NinePatchDrawable(parampn.getResources(), (Bitmap)localObject1, arrayOfByte, new Rect(), null);
    localObject1 = this.b;
    localObject1[0] = localObject2;
    localObject1[1] = localObject4;
    localObject1[2] = localObject3;
    localObject1[3] = parampn;
  }
  
  private static boolean a(fu paramfu, ir paramir1, ir paramir2)
  {
    paramir1 = paramir1.b(paramfu);
    paramfu = paramir2.b(paramfu);
    if ((paramir1 != null) && (paramfu != null)) {
      return Rect.intersects(paramir1, paramfu);
    }
    return false;
  }
  
  private static int d(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return lj.b.d;
        }
        return lj.b.c;
      }
      return lj.b.b;
    }
    return lj.b.a;
  }
  
  private lj.a e(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      lj.a locala = (lj.a)localIterator.next();
      if ((locala != null) && (locala.b == paramInt)) {
        return locala;
      }
    }
    return null;
  }
  
  public final int a(BubbleOptions paramBubbleOptions, kg paramkg)
  {
    if (paramBubbleOptions == null) {
      return -1;
    }
    try
    {
      int i = e;
      e = i + 1;
      if (this.f == null) {
        this.f = new BubbleGroup(paramkg);
      }
      paramBubbleOptions = new lj.a(this, paramBubbleOptions, i);
      this.a.add(paramBubbleOptions);
      a(paramBubbleOptions.c);
      return i;
    }
    finally {}
  }
  
  public final void a(GL10 paramGL10)
  {
    try
    {
      localkd = this.c.az.b.h;
      if ((this.a == null) || (this.a.isEmpty())) {
        break label298;
      }
      n = this.a.size();
      i1 = lj.b.d - 1;
      arrayOfInt = new int[n];
      k = 0;
      j = 0;
      for (;;)
      {
        i = k;
        if (j >= n) {
          break;
        }
        arrayOfInt[j] = lj.b.a;
        j += 1;
      }
    }
    finally
    {
      for (;;)
      {
        kd localkd;
        int n;
        int i1;
        int[] arrayOfInt;
        int k;
        int j;
        lj.a locala1;
        ir localir1;
        lj.a locala2;
        ir localir2;
        int i2;
        for (;;)
        {
          label298:
          throw paramGL10;
        }
        int m = arrayOfInt[i] - 1 - 1;
        continue;
        k += 1;
        continue;
        label339:
        int i = j;
      }
    }
    if (i < n)
    {
      locala1 = (lj.a)this.a.get(i);
      localir1 = locala1.c;
      locala1.a(localkd, arrayOfInt[i]);
      j = i + 1;
      k = j;
      if (k >= n) {
        break label339;
      }
      locala2 = (lj.a)this.a.get(k);
      localir2 = locala2.c;
      locala2.a(localkd, arrayOfInt[k]);
      if (locala1.a() <= locala2.a())
      {
        m = arrayOfInt[k] - 1;
        while (m <= i1)
        {
          i2 = d(m);
          locala2.a(localkd, i2);
          arrayOfInt[k] = i2;
          if (!a(localkd, localir1, localir2)) {
            break;
          }
          m += 1;
        }
        while (m < i1)
        {
          i2 = d(m);
          locala2.a(localkd, i2);
          arrayOfInt[i] = i2;
          if (!a(localkd, localir1, localir2)) {
            break;
          }
          m += 1;
        }
      }
    }
    else
    {
      super.a(paramGL10);
      return;
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    try
    {
      int j = a();
      int i = 0;
      while (i < j)
      {
        ir localir = (ir)a(i);
        if (localir.a(paramFloat1, paramFloat2))
        {
          if ((i < j - 1) && (b(localir))) {
            a(localir);
          }
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
  
  public final boolean a(int paramInt, BubbleOptions paramBubbleOptions)
  {
    if ((paramInt >= 0) && (paramBubbleOptions != null)) {
      try
      {
        if ((this.a != null) && (!this.a.isEmpty()))
        {
          int j = this.a.size();
          int i = 0;
          while (i < j)
          {
            if ((this.a.get(i) != null) && (((lj.a)this.a.get(i)).b == paramInt))
            {
              paramBubbleOptions = new lj.a(this, paramBubbleOptions, paramInt);
              this.a.set(i, paramBubbleOptions);
              paramBubbleOptions = new ArrayList();
              Iterator localIterator = this.a.iterator();
              while (localIterator.hasNext())
              {
                lj.a locala = (lj.a)localIterator.next();
                if (locala != null) {
                  paramBubbleOptions.add(locala.c);
                }
              }
              a(paramBubbleOptions);
              return true;
            }
            i += 1;
          }
          return false;
        }
        return false;
      }
      finally {}
    }
    return false;
  }
  
  public final boolean b(int paramInt)
  {
    try
    {
      lj.a locala = e(paramInt);
      return locala != null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c()
  {
    try
    {
      this.a.clear();
      b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean c(int paramInt)
  {
    if (paramInt < 0) {
      return true;
    }
    try
    {
      lj.a locala = e(paramInt);
      if (locala == null) {
        return true;
      }
      this.a.remove(locala);
      boolean bool = b(locala.c);
      return bool;
    }
    finally {}
  }
  
  public final List<Integer> d()
  {
    try
    {
      if ((this.a != null) && (!this.a.isEmpty()))
      {
        int j = this.a.size();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          if (this.a.get(i) == null) {
            localArrayList.add(i, Integer.valueOf(-1));
          } else {
            localArrayList.add(i, Integer.valueOf(((lj.a)this.a.get(i)).b));
          }
          i += 1;
        }
        return localArrayList;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void e()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        lj.a locala = (lj.a)localIterator.next();
        if ((locala != null) && (locala.a.getOnTapHidden()))
        {
          this.a.remove(locala);
          b(locala.c);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.lj
 * JD-Core Version:    0.7.0.1
 */