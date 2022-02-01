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
    double d1 = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    for (float f1 = 1.0F; f1 * 2.0F <= d1; f1 *= 2.0F) {}
    return (int)f1;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType)
  {
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      i = paramInt3;
    }
    double d1;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            if (paramScaleType != ImageView.ScaleType.FIT_XY) {
              break;
            }
            i = paramInt1;
          } while (paramInt1 != 0);
          return paramInt3;
          if (paramInt1 == 0) {
            return (int)(paramInt2 / paramInt4 * paramInt3);
          }
          i = paramInt1;
        } while (paramInt2 == 0);
        d1 = paramInt4 / paramInt3;
        if (paramScaleType != ImageView.ScaleType.CENTER_CROP) {
          break;
        }
        i = paramInt1;
      } while (paramInt1 * d1 >= paramInt2);
      return (int)(paramInt2 / d1);
      i = paramInt1;
    } while (paramInt1 * d1 <= paramInt2);
    return (int)(paramInt2 / d1);
  }
  
  public final o<Bitmap> a(j paramj)
  {
    label340:
    label357:
    for (;;)
    {
      byte[] arrayOfByte;
      BitmapFactory.Options localOptions;
      synchronized (f)
      {
        try
        {
          arrayOfByte = paramj.a;
          localOptions = new BitmapFactory.Options();
          Object localObject1;
          if ((this.c == 0) && (this.d == 0))
          {
            localOptions.inPreferredConfig = this.b;
            localBitmap = b.a.a(arrayOfByte);
            localObject1 = localBitmap;
            if (localBitmap == null) {
              localObject1 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
            }
            if (localObject1 != null) {
              break label340;
            }
            localObject1 = o.a(new l(paramj));
            paramj = (j)localObject1;
            return paramj;
          }
          Bitmap localBitmap = b.a.a(arrayOfByte);
          if (localBitmap != null)
          {
            j = localBitmap.getWidth();
            i = localBitmap.getHeight();
            int k = a(this.c, this.d, j, i, this.e);
            int m = a(this.d, this.c, i, j, this.e);
            localOptions.inJustDecodeBounds = false;
            localOptions.inSampleSize = a(j, i, k, m);
            localObject1 = localBitmap;
            if (localBitmap == null) {
              localObject1 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
            }
            if ((localObject1 == null) || ((((Bitmap)localObject1).getWidth() <= k) && (((Bitmap)localObject1).getHeight() <= m))) {
              break label357;
            }
            localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject1, k, m, true);
            ((Bitmap)localObject1).recycle();
            localObject1 = localBitmap;
            continue;
            paramj = finally;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          u.c("Caught OOM for %d byte image, url=%s", new Object[] { Integer.valueOf(paramj.a.length), c() });
          paramj = o.a(new l(localOutOfMemoryError));
          return paramj;
        }
      }
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      int j = localOptions.outWidth;
      int i = localOptions.outHeight;
      continue;
      o localo = o.a(localOutOfMemoryError, d.a(paramj));
      paramj = localo;
    }
  }
  
  public final m.b m()
  {
    return m.b.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.b.a.a.h
 * JD-Core Version:    0.7.0.1
 */