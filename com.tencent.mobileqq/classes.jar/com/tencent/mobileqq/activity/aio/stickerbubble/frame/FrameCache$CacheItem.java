package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.commonsdk.cache.Sizeable;

public class FrameCache$CacheItem
  implements Sizeable
{
  private String a;
  private BitmapDrawable[] b;
  private int c;
  private int d;
  
  public FrameCache$CacheItem(String paramString, BitmapDrawable[] paramArrayOfBitmapDrawable, int paramInt)
  {
    this.a = paramString;
    this.b = paramArrayOfBitmapDrawable;
    this.c = paramInt;
    c();
  }
  
  private void c()
  {
    int i = 0;
    this.d = 0;
    BitmapDrawable[] arrayOfBitmapDrawable = this.b;
    int j = arrayOfBitmapDrawable.length;
    while (i < j)
    {
      BitmapDrawable localBitmapDrawable = arrayOfBitmapDrawable[i];
      if ((localBitmapDrawable != null) && (localBitmapDrawable.getBitmap() != null)) {
        this.d += localBitmapDrawable.getBitmap().getByteCount();
      }
      i += 1;
    }
  }
  
  public BitmapDrawable[] a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int getByteSize()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameCache.CacheItem
 * JD-Core Version:    0.7.0.1
 */