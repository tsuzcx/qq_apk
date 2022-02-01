package com.tencent.luggage.wxa.no;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import junit.framework.a;

public class b
  implements AppBrandSimpleImageLoader.h
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt3 == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a.b(bool1);
    if (paramInt4 == 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    a.b(bool1);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  @NonNull
  public Bitmap a(@NonNull Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return paramBitmap;
      }
      int m = paramBitmap.getWidth();
      int n = paramBitmap.getHeight();
      int k = this.a;
      int j = this.b;
      int i;
      if (k < 0)
      {
        i = 0;
      }
      else
      {
        i = k;
        if (k > m) {
          i = m;
        }
      }
      k = this.b;
      if (k < 0) {
        j = 0;
      } else if (k > n) {
        j = n;
      }
      int i2 = this.c + this.a - i;
      int i1 = this.d + this.b - j;
      k = i2;
      if (i + i2 > m) {
        k = m - i;
      }
      m = i1;
      if (j + i1 > n) {
        m = n - j;
      }
      if ((k > 0) && (m > 0))
      {
        localBitmap = com.tencent.luggage.wxa.qz.b.a(k, m, Bitmap.Config.ARGB_8888);
        new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect(i, j, i + k, j + m), new Rect(0, 0, k, m), null);
        return localBitmap;
      }
      localBitmap = com.tencent.luggage.wxa.qz.b.a(1, 1, Bitmap.Config.ARGB_8888);
    }
    return localBitmap;
  }
  
  @NonNull
  public String a()
  {
    return String.format("Transformation_x%s_y%s_w%s_h%s", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.no.b
 * JD-Core Version:    0.7.0.1
 */