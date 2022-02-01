package com.b.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;
import com.b.a.b.a;
import com.b.a.j;
import com.b.a.l;
import com.b.a.m;
import com.b.a.m.b;
import com.b.a.o;
import com.b.a.o.b;
import com.b.a.u;

public final class h
  extends m<Bitmap>
{
  private static final Object f = new Object();
  private final o.b<Bitmap> a;
  private final Bitmap.Config b;
  private final int c;
  private final int d;
  private final ImageView.ScaleType e;
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt1;
    double d2 = paramInt3;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    d2 = paramInt2;
    double d3 = paramInt4;
    Double.isNaN(d2);
    Double.isNaN(d3);
    d1 = Math.min(d1, d2 / d3);
    float f2;
    for (float f1 = 1.0F;; f1 = f2)
    {
      f2 = 2.0F * f1;
      if (f2 > d1) {
        break;
      }
    }
    return (int)f1;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return paramInt3;
    }
    if (paramScaleType == ImageView.ScaleType.FIT_XY)
    {
      if (paramInt1 == 0) {
        return paramInt3;
      }
      return paramInt1;
    }
    if (paramInt1 == 0)
    {
      d1 = paramInt2;
      d2 = paramInt4;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      d2 = paramInt3;
      Double.isNaN(d2);
      return (int)(d2 * d1);
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    double d1 = paramInt4;
    double d2 = paramInt3;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    if (paramScaleType == ImageView.ScaleType.CENTER_CROP)
    {
      d2 = paramInt1;
      Double.isNaN(d2);
      d3 = paramInt2;
      if (d2 * d1 < d3)
      {
        Double.isNaN(d3);
        paramInt1 = (int)(d3 / d1);
      }
      return paramInt1;
    }
    d2 = paramInt1;
    Double.isNaN(d2);
    double d3 = paramInt2;
    if (d2 * d1 > d3)
    {
      Double.isNaN(d3);
      paramInt1 = (int)(d3 / d1);
    }
    return paramInt1;
  }
  
  protected final o<Bitmap> a(j paramj)
  {
    synchronized (f)
    {
      try
      {
        byte[] arrayOfByte = paramj.a;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        Object localObject2;
        Object localObject1;
        if ((this.c == 0) && (this.d == 0))
        {
          localOptions.inPreferredConfig = this.b;
          localObject2 = b.a.a(arrayOfByte);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          }
        }
        else
        {
          localObject1 = b.a.a(arrayOfByte);
          int i;
          int j;
          if (localObject1 != null)
          {
            i = ((Bitmap)localObject1).getWidth();
            j = ((Bitmap)localObject1).getHeight();
          }
          else
          {
            localOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
            i = localOptions.outWidth;
            j = localOptions.outHeight;
          }
          int k = a(this.c, this.d, i, j, this.e);
          int m = a(this.d, this.c, j, i, this.e);
          localOptions.inJustDecodeBounds = false;
          localOptions.inSampleSize = a(i, j, k, m);
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            if (((Bitmap)localObject2).getWidth() <= k)
            {
              localObject1 = localObject2;
              if (((Bitmap)localObject2).getHeight() <= m) {}
            }
            else
            {
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, k, m, true);
              ((Bitmap)localObject2).recycle();
            }
          }
        }
        if (localObject1 == null)
        {
          localObject1 = o.a(new l(paramj));
          paramj = (j)localObject1;
        }
        else
        {
          localObject1 = o.a(localObject1, d.a(paramj));
          paramj = (j)localObject1;
        }
        return paramj;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        u.c("Caught OOM for %d byte image, url=%s", new Object[] { Integer.valueOf(paramj.a.length), c() });
        paramj = o.a(new l(localOutOfMemoryError));
        return paramj;
      }
      throw paramj;
    }
  }
  
  public final m.b m()
  {
    return m.b.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.h
 * JD-Core Version:    0.7.0.1
 */