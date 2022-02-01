package com.Vas.ColorFont;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class FastColorFontHelper
{
  static boolean a = false;
  private static FastColorFontHelper g;
  public AtomicBoolean b = new AtomicBoolean(false);
  public AtomicBoolean c = new AtomicBoolean(false);
  public AtomicBoolean d = new AtomicBoolean(false);
  private FreeTypeLib e = new FreeTypeLib();
  private FastColorFontHelper.FontLruCache f = new FastColorFontHelper.FontLruCache(this, 8);
  
  public static FastColorFontHelper a()
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new FastColorFontHelper();
        }
      }
      finally {}
    }
    return g;
  }
  
  public int a(int paramInt)
  {
    return this.e.releaseColorFont(paramInt);
  }
  
  public int a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    return this.e.getFontColor(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public int a(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    return this.e.getExtraBitmap(paramInt, paramBitmap1, paramBitmap2, 0);
  }
  
  public int a(int paramInt1, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2)
  {
    return this.e.getExtraBitmap(paramInt1, paramBitmap1, paramBitmap2, paramInt2);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty((String)this.f.get(Integer.valueOf(paramInt))))
    {
      this.f.put(Integer.valueOf(paramInt), paramString);
      localObject = new int[5];
      long l1 = System.currentTimeMillis();
      int i = this.e.initColorFont(paramInt, paramString, (int[])localObject);
      long l2 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initColorFont cost:");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(" fontId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  fontWidth:");
      localStringBuilder.append(localObject[1]);
      localStringBuilder.append("  fontHeight:");
      localStringBuilder.append(localObject[2]);
      localStringBuilder.append("  lineSpace:");
      localStringBuilder.append(localObject[0]);
      localStringBuilder.append("  path=");
      localStringBuilder.append(paramString);
      FastColorFontLog.a("FastColorFontHelper", localStringBuilder.toString());
      int j = i / 100;
      if (j >= 2)
      {
        FastColorFontCache.b(paramInt, j);
        FastColorFontCache.c(paramInt, i % 100);
        FastColorFontCache.a(paramInt, localObject[0]);
        FastColorFontCache.e(paramInt, localObject[1]);
        FastColorFontCache.d(paramInt, localObject[2]);
        FastColorFontCache.f(paramInt, localObject[3]);
        FastColorFontCache.g(paramInt, localObject[4]);
      }
      if ((paramInt >= 8388608) || (paramInt <= -8388608)) {
        FastColorFontLog.b("FastColorFontHelper", "为了缓存不出现问题，字体id最好限制在3个字节以内！");
      }
      return i;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("该字体已经初始化  fontId=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("  path=");
    ((StringBuilder)localObject).append(paramString);
    FastColorFontLog.a("FastColorFontHelper", ((StringBuilder)localObject).toString());
    return 0;
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, long paramLong, int paramInt2, Bitmap paramBitmap, int[] paramArrayOfInt2)
  {
    return this.e.drawSpecialEffectsText(paramInt1, paramArrayOfInt1, paramLong, paramInt2, paramBitmap, paramArrayOfInt2);
  }
  
  public int a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.e.getHiBoomViewSize(paramInt, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.e.drawText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramBitmap, paramInt2, paramInt3, paramInt4, 0, null, 0);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt6, int paramInt5)
  {
    return this.e.drawText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramBitmap, paramInt2, paramInt3, 0, paramInt4, paramArrayOfInt6, paramInt5);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, int[] paramArrayOfInt6)
  {
    return this.e.drawAnimationText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramBitmap1, paramBitmap2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramArrayOfInt6, 0);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, Bitmap paramBitmap, int[] paramArrayOfInt7, int paramInt6)
  {
    return this.e.renderExpressionBitmap(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramArrayOfInt6, paramInt2, paramInt3, paramInt4, paramLong, paramInt5, paramBitmap, paramArrayOfInt7, paramInt6);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, int[] paramArrayOfInt7, int paramInt8)
  {
    return this.e.drawStrikingText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramArrayOfInt6, paramBitmap1, paramBitmap2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramArrayOfInt7, paramInt8);
  }
  
  public void a(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    this.e.getTextWidths(paramInt1, paramArrayOfInt1, paramInt2, paramArrayOfInt2);
  }
  
  public int[] a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, long paramLong, int[] paramArrayOfInt4)
  {
    return this.e.getBitmapWH(paramInt, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramLong, paramArrayOfInt4);
  }
  
  public int[] a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int[] paramArrayOfInt7, int[] paramArrayOfInt8, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    return this.e.calculateExpressionSize(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramArrayOfInt6, paramArrayOfInt7, paramArrayOfInt8, paramInt2, paramInt3, paramInt4, paramLong);
  }
  
  public FreeTypeLib b()
  {
    return this.e;
  }
  
  public void c()
  {
    this.f.evictAll();
    if (this.d.get())
    {
      this.e.clearCache();
      FastColorFontLog.a("FastColorFontHelper", "clearCache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontHelper
 * JD-Core Version:    0.7.0.1
 */