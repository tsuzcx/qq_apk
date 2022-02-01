package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.Util;

class AttributeStrategy
  implements LruPoolStrategy
{
  private final AttributeStrategy.KeyPool a = new AttributeStrategy.KeyPool();
  private final GroupedLinkedMap<AttributeStrategy.Key, Bitmap> b = new GroupedLinkedMap();
  
  static String c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], ");
    localStringBuilder.append(paramConfig);
    return localStringBuilder.toString();
  }
  
  private static String d(Bitmap paramBitmap)
  {
    return c(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
  }
  
  public Bitmap a()
  {
    return (Bitmap)this.b.a();
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    paramConfig = this.a.a(paramInt1, paramInt2, paramConfig);
    return (Bitmap)this.b.a(paramConfig);
  }
  
  public void a(Bitmap paramBitmap)
  {
    AttributeStrategy.Key localKey = this.a.a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    this.b.a(localKey, paramBitmap);
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return c(paramInt1, paramInt2, paramConfig);
  }
  
  public String b(Bitmap paramBitmap)
  {
    return d(paramBitmap);
  }
  
  public int c(Bitmap paramBitmap)
  {
    return Util.a(paramBitmap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AttributeStrategy:\n  ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy
 * JD-Core Version:    0.7.0.1
 */