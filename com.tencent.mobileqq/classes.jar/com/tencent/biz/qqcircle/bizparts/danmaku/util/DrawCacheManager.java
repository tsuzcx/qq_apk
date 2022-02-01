package com.tencent.biz.qqcircle.bizparts.danmaku.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import java.util.Iterator;
import java.util.LinkedList;

public class DrawCacheManager
{
  private final LinkedList<Bitmap> a = new LinkedList();
  private final int b;
  private int c;
  private int d;
  private int e;
  
  public DrawCacheManager(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.b = (paramContext.widthPixels * paramContext.heightPixels * 8);
  }
  
  private void b(Bitmap paramBitmap)
  {
    this.a.remove(paramBitmap);
    if (paramBitmap != null)
    {
      this.c -= paramBitmap.getRowBytes() * paramBitmap.getHeight();
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
    }
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    this.d += 1;
    Iterator localIterator = this.a.iterator();
    label21:
    Bitmap localBitmap;
    for (Object localObject = null; localIterator.hasNext(); localObject = localBitmap)
    {
      localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap.getWidth() < paramInt1) || (localBitmap.getHeight() < paramInt2) || ((localObject != null) && (localObject.getHeight() * localObject.getWidth() < localBitmap.getHeight() * localBitmap.getWidth()))) {
        break label21;
      }
    }
    if (localObject != null)
    {
      this.a.remove(localObject);
      this.c -= localObject.getRowBytes() * localObject.getHeight();
      return localObject;
    }
    try
    {
      this.e += 1;
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
    this.a.clear();
    this.c = 0;
    this.d = 0;
    this.e = 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return;
      }
      this.c += paramBitmap.getRowBytes() * paramBitmap.getHeight();
      this.a.addLast(paramBitmap);
      while (this.c > this.b)
      {
        paramBitmap = null;
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)localIterator.next();
          if ((paramBitmap == null) || (paramBitmap.getHeight() * paramBitmap.getWidth() >= localBitmap.getHeight() * localBitmap.getWidth())) {
            paramBitmap = localBitmap;
          }
        }
        if (paramBitmap != null) {
          b(paramBitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.util.DrawCacheManager
 * JD-Core Version:    0.7.0.1
 */