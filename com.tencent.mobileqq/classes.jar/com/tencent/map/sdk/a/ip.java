package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.JNI;
import com.tencent.map.sdk.engine.jni.models.TappedElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public final class ip
  implements go
{
  public hi a;
  public int[] b;
  public int[] c;
  public int d;
  public GeoPoint e;
  public int f = -1;
  public int g = -1;
  private lg h;
  private boolean i = true;
  private ip.a j;
  private float k = -1.0F;
  private lv l;
  
  public ip(lv paramlv, hi paramhi)
  {
    this.l = paramlv;
    a(paramhi);
  }
  
  private ip.a c()
  {
    try
    {
      ip.a locala = this.j;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Rect a(fu paramfu)
  {
    Object localObject2 = b(paramfu);
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).left);
    localObject2 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).right);
    localObject1 = paramfu.a((GeoPoint)localObject1);
    paramfu = paramfu.a((GeoPoint)localObject2);
    return new Rect((int)((DoublePoint)localObject1).x, (int)((DoublePoint)localObject1).y, (int)paramfu.x, (int)paramfu.y);
  }
  
  public final void a()
  {
    try
    {
      this.j = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.j = new ip.a();
      this.j.a = paramInt1;
      this.j.b = paramInt2;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt, GeoPoint paramGeoPoint)
  {
    this.d = paramInt;
    this.e = paramGeoPoint;
  }
  
  public final void a(hi paramhi)
  {
    if (paramhi != null) {}
    try
    {
      if ((paramhi.b != null) && (paramhi.b.size() >= 2))
      {
        if ((paramhi.c != null) && (paramhi.c.length > 0))
        {
          if ((paramhi.d != null) && (paramhi.d.length > 0))
          {
            this.a = paramhi;
            this.b = paramhi.c;
            this.c = paramhi.d;
            this.f = -1;
            return;
          }
          throw new IllegalArgumentException("参数colors不能为空!");
        }
        throw new IllegalArgumentException("参数startIndexes不能为空!");
      }
      throw new IllegalArgumentException("LineOptions中点的个数不能小于2");
    }
    finally
    {
      label123:
      break label123;
    }
    throw new IllegalArgumentException("LineOptions不能为空！");
    throw paramhi;
  }
  
  public final void a(GL10 paramGL10)
  {
    paramGL10 = this.l;
    if (paramGL10 == null) {
      return;
    }
    this.h = paramGL10.a;
    float f1 = this.l.a.b().i.b.e;
    float f2 = this.k;
    if ((f2 == -1.0F) || (f2 != f1)) {
      this.k = f1;
    }
    paramGL10 = this.l;
    int m;
    long l1;
    int n;
    if (!paramGL10.e.contains(Integer.valueOf(this.f)))
    {
      if (((paramGL10.a instanceof lw)) && (!this.a.n))
      {
        localObject1 = ((lw)paramGL10.a).l;
        f1 = this.a.j;
        f2 = pz.a((Context)localObject1);
        this.a.j = (f1 * f2);
      }
      m = paramGL10.a.g().a(this);
      this.f = m;
      if (!paramGL10.e.contains(Integer.valueOf(m)))
      {
        paramGL10.e.add(Integer.valueOf(m));
        paramGL10.f.append(m, this.a.n);
      }
      this.f = m;
      localObject1 = paramGL10.b;
      try
      {
        ((pf)localObject1).y();
        l1 = ((pf)localObject1).b;
        if (l1 == 0L) {}
        for (;;)
        {
          ((pf)localObject1).z();
          break;
          m = this.f;
          if (m != -1)
          {
            n = this.a.v;
            int i1 = this.a.w;
            ((pf)localObject1).f.a(new pf.32((pf)localObject1, m, new int[] { n, i1 }));
          }
        }
        if (paramGL10.g.contains(Integer.valueOf(this.f))) {
          break label353;
        }
      }
      finally
      {
        ((pf)localObject1).z();
      }
    }
    else
    {
      paramGL10.g.add(Integer.valueOf(this.f));
    }
    label353:
    Object localObject1 = paramGL10.b;
    try
    {
      ((pf)localObject1).y();
      l1 = ((pf)localObject1).b;
      if (l1 == 0L) {}
      label533:
      label829:
      for (;;)
      {
        ((pf)localObject1).z();
        break label453;
        m = this.f;
        if (m != -1) {}
        Object localObject5;
        label453:
        label749:
        try
        {
          localObject5 = c();
          if (localObject5 == null) {}
          ((pf)localObject1).a.nativeSetTurnArrow(((pf)localObject1).b, m, ((ip.a)localObject5).a, ((ip.a)localObject5).b);
        }
        finally {}
      }
      localObject1 = paramGL10.b;
      try
      {
        ((pf)localObject1).y();
        l1 = ((pf)localObject1).b;
        if (l1 == 0L) {}
        for (;;)
        {
          ((pf)localObject1).z();
          break label533;
          m = this.f;
          if (m != -1) {}
          label936:
          try
          {
            ((pf)localObject1).a.nativeSetLineDrawArrow(((pf)localObject1).b, m, this.a.i);
          }
          finally {}
        }
        if (this.a.q)
        {
          localObject1 = paramGL10.b;
          try
          {
            ((pf)localObject1).y();
            l1 = ((pf)localObject1).b;
            if (l1 == 0L) {}
            for (;;)
            {
              ((pf)localObject1).z();
              break label749;
              m = this.f;
              if (m != -1) {
                try
                {
                  localObject5 = this.e;
                  if (localObject5 == null) {}
                  ((pf)localObject1).a.nativeLineClearPoint(((pf)localObject1).b, m, (GeoPoint)localObject5, this.d);
                }
                finally {}
              }
            }
            localObject1 = paramGL10.b;
          }
          finally
          {
            ((pf)localObject1).z();
          }
        }
        try
        {
          ((pf)localObject1).y();
          l1 = ((pf)localObject1).b;
          if (l1 == 0L) {}
          for (;;)
          {
            ((pf)localObject1).z();
            break label749;
            m = this.f;
            if (m != -1) {}
            try
            {
              localObject5 = this.e;
              if (localObject5 == null) {}
              ((pf)localObject1).a.nativeLineInsertPoint(((pf)localObject1).b, m, (GeoPoint)localObject5, this.d);
            }
            finally {}
          }
          localObject1 = paramGL10.b;
          try
          {
            ((pf)localObject1).y();
            l1 = ((pf)localObject1).b;
            if (l1 == 0L) {}
            for (;;)
            {
              ((pf)localObject1).z();
              break label829;
              m = this.f;
              if (m != -1) {}
              try
              {
                ((pf)localObject1).a.nativeSetDrawCap(((pf)localObject1).b, m, this.a.l);
              }
              finally {}
            }
            if (!nl.a(this.a.t))
            {
              localObject1 = paramGL10.b;
              try
              {
                ((pf)localObject1).y();
                l1 = ((pf)localObject1).b;
                if (l1 == 0L) {}
                for (;;)
                {
                  ((pf)localObject1).z();
                  break label936;
                  m = this.f;
                  if (m != -1) {
                    try
                    {
                      ((pf)localObject1).a.nativeSetLineDirectionArrowTextureName(((pf)localObject1).b, m, this.a.t);
                    }
                    finally {}
                  }
                }
                paramGL10 = paramGL10.b;
              }
              finally
              {
                ((pf)localObject1).z();
              }
            }
            try
            {
              paramGL10.y();
              l1 = paramGL10.b;
              if (l1 == 0L) {
                return;
              }
              m = this.f;
              if (m == -1) {
                return;
              }
              f1 = this.a.u;
              if (f1 < 0.0F) {
                return;
              }
              n = this.a.o;
              if ((n != 3) && (n != 0)) {
                try
                {
                  paramGL10.a.nativeSetLineFootPrintSpacing(paramGL10.b, m, this.a.u);
                }
                finally {}
              }
              try
              {
                paramGL10.a.nativeSetLineArrowSpacing(paramGL10.b, m, this.a.u);
                return;
              }
              finally {}
              paramGL10 = finally;
            }
            finally {}
            paramGL10 = finally;
          }
          finally {}
          paramGL10 = finally;
        }
        finally {}
        paramGL10 = finally;
      }
      finally
      {
        localObject4.z();
      }
      throw paramGL10;
    }
    finally
    {
      localObject4.z();
    }
    for (;;) {}
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    try
    {
      Object localObject1 = this.h;
      if (localObject1 == null) {
        return false;
      }
      localObject1 = this.h.g().b(paramFloat1, paramFloat2);
      if (localObject1 != null)
      {
        long l1 = ((TappedElement)localObject1).itemId;
        int m = this.f;
        if (l1 == m) {
          return true;
        }
      }
      return false;
    }
    finally {}
  }
  
  public final Rect b()
  {
    Object localObject = this.a.a;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      int m = this.d;
      if ((m >= 0) && (m < ((ArrayList)localObject).size()))
      {
        localObject = ((ArrayList)localObject).subList(this.d, ((ArrayList)localObject).size());
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          int i4 = 0;
          GeoPoint localGeoPoint = (GeoPoint)((List)localObject).get(0);
          int n = localGeoPoint.getLongitudeE6();
          m = localGeoPoint.getLongitudeE6();
          int i3 = localGeoPoint.getLatitudeE6();
          int i5 = localGeoPoint.getLatitudeE6();
          int i11 = ((List)localObject).size();
          while (i4 < i11)
          {
            localGeoPoint = (GeoPoint)((List)localObject).get(i4);
            int i7 = i5;
            int i8 = n;
            int i9 = m;
            int i10 = i3;
            if (localGeoPoint != null)
            {
              int i6 = localGeoPoint.getLatitudeE6();
              i7 = localGeoPoint.getLongitudeE6();
              int i1;
              int i2;
              if (i7 < n)
              {
                i1 = i7;
                i2 = m;
              }
              else
              {
                i1 = n;
                i2 = m;
                if (i7 > m)
                {
                  i2 = i7;
                  i1 = n;
                }
              }
              if (i6 < i5)
              {
                i7 = i6;
                i8 = i1;
                i9 = i2;
                i10 = i3;
              }
              else
              {
                i7 = i5;
                i8 = i1;
                i9 = i2;
                i10 = i3;
                if (i6 > i3)
                {
                  i10 = i6;
                  i9 = i2;
                  i8 = i1;
                  i7 = i5;
                }
              }
            }
            i4 += 1;
            i5 = i7;
            n = i8;
            m = i9;
            i3 = i10;
          }
          localObject = new Rect(n, i3, m, i5);
        }
        else
        {
          localObject = null;
        }
        if (localObject != null) {
          this.a.r = ((Rect)localObject);
        }
      }
    }
    return this.a.r;
  }
  
  public final Rect b(fu paramfu)
  {
    paramfu = this.a;
    if ((paramfu != null) && (paramfu.b != null) && (!this.a.b.isEmpty()))
    {
      paramfu = this.a.b.iterator();
      int i1 = 2147483647;
      int i5 = -2147483648;
      int m = -2147483648;
      int n = 2147483647;
      while (paramfu.hasNext())
      {
        GeoPoint localGeoPoint = (GeoPoint)paramfu.next();
        int i6 = localGeoPoint.getLatitudeE6();
        int i2 = localGeoPoint.getLongitudeE6();
        int i3 = i5;
        if (i6 > i5) {
          i3 = i6;
        }
        int i4 = n;
        if (i6 < n) {
          i4 = i6;
        }
        i6 = m;
        if (i2 > m) {
          i6 = i2;
        }
        i5 = i3;
        m = i6;
        n = i4;
        if (i2 < i1)
        {
          i1 = i2;
          i5 = i3;
          m = i6;
          n = i4;
        }
      }
      return new Rect(i1, i5, m, n);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ip
 * JD-Core Version:    0.7.0.1
 */