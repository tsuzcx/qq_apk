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
    catch (OutOfMemoryError paramGL10) {}
    return Bitmap.createBitmap(arrayOfInt1, paramInt1, paramInt2, Bitmap.Config.RGB_565);
  }
  
  private void a(lw.e parame)
  {
    if ((parame == null) || (parame.a())) {
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
  
  private lw.e c()
  {
    lw.e locale = null;
    synchronized (this.b)
    {
      if (this.b.size() > 0) {
        locale = (lw.e)this.b.get(0);
      }
      return locale;
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
  
  /* Error */
  public final void a(GL10 paramGL10, lv paramlv)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/tencent/map/sdk/a/lw$d:a	Lcom/tencent/map/sdk/a/lw;
    //   6: getfield 122	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 106	com/tencent/map/sdk/a/lw$d:c	Lcom/tencent/map/sdk/a/lw$e;
    //   21: getfield 125	com/tencent/map/sdk/a/lw$e:b	Lcom/tencent/map/sdk/a/go;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +10 -> 36
    //   29: aload_3
    //   30: aload_1
    //   31: invokeinterface 129 2 0
    //   36: aload_2
    //   37: invokevirtual 133	com/tencent/map/sdk/a/lv:a	()V
    //   40: goto -26 -> 14
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	d
    //   0	48	1	paramGL10	GL10
    //   0	48	2	paramlv	lv
    //   9	21	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	43	finally
    //   17	25	43	finally
    //   29	36	43	finally
    //   36	40	43	finally
  }
  
  public final boolean a()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.b != null)
        {
          if (!this.b.isEmpty()) {
            break label41;
          }
          break label36;
          return bool;
        }
      }
      label36:
      boolean bool = true;
      continue;
      label41:
      bool = false;
    }
  }
  
  public final lw.e b()
  {
    lw.e locale = null;
    for (;;)
    {
      Object localObject3;
      try
      {
        this.c = c();
        localObject3 = this.c;
        if (localObject3 == null) {
          return locale;
        }
        if (this.c.c())
        {
          a(this.c);
          continue;
        }
        localObject2 = this.a.c;
      }
      finally {}
      try
      {
        localObject3 = (kc)((kl)localObject2).i.clone();
        or.a("mapParam stack saveMapParam:" + ((kc)localObject3).toString());
        ((kl)localObject2).g.push(localObject3);
        localRect = this.c.e;
        int k = this.c.c;
        int i = this.c.d;
        localObject4 = new Rect();
        int j = (int)(pz.a(this.a.l) * 20.0F);
        k = (this.a.i.width() - k) / 2 + j;
        ((Rect)localObject4).right = k;
        ((Rect)localObject4).left = k;
        i = (this.a.i.height() - i) / 2 + j;
        ((Rect)localObject4).bottom = i;
        ((Rect)localObject4).top = i;
        Object localObject2 = this.a.c;
        if (localRect != null)
        {
          if (((localRect.height() > 0) || (localRect.width() > 0)) && (((kl)localObject2).c()))
          {
            localObject3 = new Rect(((kl)localObject2).j);
            ((Rect)localObject3).left += ((Rect)localObject4).left;
            ((Rect)localObject3).right -= ((Rect)localObject4).right;
            ((Rect)localObject3).top += ((Rect)localObject4).top;
            ((Rect)localObject3).bottom -= ((Rect)localObject4).bottom;
            localObject4 = new GeoPoint(localRect.top, localRect.left);
            GeoPoint localGeoPoint = new GeoPoint(localRect.bottom, localRect.right);
            localRect = new Rect();
            localRect.left = Math.min(((GeoPoint)localObject4).getLongitudeE6(), localGeoPoint.getLongitudeE6());
            localRect.right = Math.max(((GeoPoint)localObject4).getLongitudeE6(), localGeoPoint.getLongitudeE6());
            localRect.top = Math.min(((GeoPoint)localObject4).getLatitudeE6(), localGeoPoint.getLatitudeE6());
            localRect.bottom = Math.max(((GeoPoint)localObject4).getLatitudeE6(), localGeoPoint.getLatitudeE6());
            localObject4 = ((kl)localObject2).h.g();
            if ((0L == ((pf)localObject4).b) || (((pf)localObject4).f == null)) {
              ((kl)localObject2).a.b();
            }
          }
          else
          {
            ((kl)localObject2).n();
          }
        }
        else {
          localObject2 = this.c;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          Rect localRect;
          Object localObject4;
          localCloneNotSupportedException.printStackTrace();
          continue;
          ((pf)localObject4).f.a(new pf.8((pf)localObject4, localRect, (Rect)localObject3));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lw.d
 * JD-Core Version:    0.7.0.1
 */