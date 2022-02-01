package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Stack;
import javax.microedition.khronos.opengles.GL10;

final class lw$d
{
  private final ArrayList<lw.e> b = new ArrayList();
  private lw.e c;
  
  private lw$d(lw paramlw) {}
  
  private Bitmap a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt1 = new int[i];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt2);
    localIntBuffer.position(0);
    paramGL10.glReadPixels((this.a.i.width() - paramInt1) / 2, (this.a.i.height() - paramInt2) / 2, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
    i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      while (j < paramInt1)
      {
        int k = arrayOfInt2[(i * paramInt1 + j)];
        arrayOfInt1[((paramInt2 - i - 1) * paramInt1 + j)] = (k & 0xFF00FF00 | k << 16 & 0xFF0000 | k >> 16 & 0xFF);
        j += 1;
      }
      i += 1;
    }
    try
    {
      paramGL10 = Bitmap.createBitmap(arrayOfInt1, paramInt1, paramInt2, Bitmap.Config.RGB_565);
      return paramGL10;
    }
    catch (OutOfMemoryError paramGL10)
    {
      label174:
      break label174;
    }
    return Bitmap.createBitmap(arrayOfInt1, paramInt1, paramInt2, Bitmap.Config.RGB_565);
  }
  
  private void a(lw.e parame)
  {
    if (parame != null)
    {
      if (parame.a()) {
        return;
      }
      parame.b();
      synchronized (this.b)
      {
        this.b.remove(parame);
        this.a.c.e();
        return;
      }
    }
  }
  
  private lw.e c()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.b.size() > 0)
        {
          lw.e locale = (lw.e)this.b.get(0);
          return locale;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    try
    {
      if ((this.c != null) && (!this.c.c()))
      {
        a(paramGL10, this.c.c, this.c.d);
        a(this.c);
      }
      return;
    }
    finally
    {
      paramGL10 = finally;
      throw paramGL10;
    }
  }
  
  public final void a(GL10 paramGL10, lv paramlv)
  {
    try
    {
      Object localObject = this.a.a;
      if (localObject == null) {
        return;
      }
      localObject = this.c.b;
      if (localObject != null) {
        ((go)localObject).a(paramGL10);
      }
      paramlv.a();
      return;
    }
    finally {}
  }
  
  public final boolean a()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.b == null) {
          break label41;
        }
        if (this.b.isEmpty())
        {
          break label41;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label41:
      bool = true;
    }
  }
  
  public final lw.e b()
  {
    try
    {
      this.c = c();
      Object localObject1 = this.c;
      if (localObject1 == null) {
        return null;
      }
      if (this.c.c())
      {
        a(this.c);
        return null;
      }
      localObject1 = this.a.c;
      Object localObject4;
      try
      {
        localObject4 = (kc)((kl)localObject1).i.clone();
        localObject5 = new StringBuilder("mapParam stack saveMapParam:");
        ((StringBuilder)localObject5).append(((kc)localObject4).toString());
        or.a(((StringBuilder)localObject5).toString());
        ((kl)localObject1).g.push(localObject4);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
      }
      Rect localRect = this.c.e;
      int k = this.c.c;
      int i = this.c.d;
      Object localObject5 = new Rect();
      int j = (int)(pz.a(this.a.l) * 20.0F);
      k = (this.a.i.width() - k) / 2 + j;
      ((Rect)localObject5).right = k;
      ((Rect)localObject5).left = k;
      i = (this.a.i.height() - i) / 2 + j;
      ((Rect)localObject5).bottom = i;
      ((Rect)localObject5).top = i;
      Object localObject2 = this.a.c;
      if (localRect != null)
      {
        if (((localRect.height() > 0) || (localRect.width() > 0)) && (((kl)localObject2).c()))
        {
          localObject4 = new Rect(((kl)localObject2).j);
          ((Rect)localObject4).left += ((Rect)localObject5).left;
          ((Rect)localObject4).right -= ((Rect)localObject5).right;
          ((Rect)localObject4).top += ((Rect)localObject5).top;
          ((Rect)localObject4).bottom -= ((Rect)localObject5).bottom;
          localObject5 = new GeoPoint(localRect.top, localRect.left);
          GeoPoint localGeoPoint = new GeoPoint(localRect.bottom, localRect.right);
          localRect = new Rect();
          localRect.left = Math.min(((GeoPoint)localObject5).getLongitudeE6(), localGeoPoint.getLongitudeE6());
          localRect.right = Math.max(((GeoPoint)localObject5).getLongitudeE6(), localGeoPoint.getLongitudeE6());
          localRect.top = Math.min(((GeoPoint)localObject5).getLatitudeE6(), localGeoPoint.getLatitudeE6());
          localRect.bottom = Math.max(((GeoPoint)localObject5).getLatitudeE6(), localGeoPoint.getLatitudeE6());
          localObject5 = ((kl)localObject2).h.g();
          if ((0L != ((pf)localObject5).b) && (((pf)localObject5).f != null)) {
            ((pf)localObject5).f.a(new pf.8((pf)localObject5, localRect, (Rect)localObject4));
          }
          ((kl)localObject2).a.b();
        }
        ((kl)localObject2).n();
      }
      localObject2 = this.c;
      return localObject2;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lw.d
 * JD-Core Version:    0.7.0.1
 */