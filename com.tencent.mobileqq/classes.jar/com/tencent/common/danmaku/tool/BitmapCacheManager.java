package com.tencent.common.danmaku.tool;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.util.Logger;
import java.util.Iterator;
import java.util.LinkedList;

public class BitmapCacheManager
{
  private final LinkedList<BitmapCacheManager.BitmapHolder> a = new LinkedList();
  private final LinkedList<BitmapCacheManager.BitmapHolder> b = new LinkedList();
  private final int c;
  private int d;
  private int e;
  private int f;
  
  public BitmapCacheManager()
  {
    DisplayMetrics localDisplayMetrics = DanmakuDependImp.a().b().b().getDisplayMetrics();
    this.c = (localDisplayMetrics.widthPixels * localDisplayMetrics.heightPixels * 6);
  }
  
  private void e()
  {
    while (this.d > this.c)
    {
      Object localObject = null;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        BitmapCacheManager.BitmapHolder localBitmapHolder = (BitmapCacheManager.BitmapHolder)localIterator.next();
        if ((localObject == null) || (BitmapCacheManager.BitmapHolder.c((BitmapCacheManager.BitmapHolder)localObject) > BitmapCacheManager.BitmapHolder.c(localBitmapHolder))) {
          localObject = localBitmapHolder;
        }
      }
      if (localObject != null)
      {
        this.a.remove(localObject);
        this.d -= BitmapCacheManager.BitmapHolder.d((BitmapCacheManager.BitmapHolder)localObject);
        BitmapCacheManager.BitmapHolder.f((BitmapCacheManager.BitmapHolder)localObject);
        this.b.addLast(localObject);
      }
    }
  }
  
  private BitmapCacheManager.BitmapHolder f()
  {
    BitmapCacheManager.BitmapHolder localBitmapHolder2 = (BitmapCacheManager.BitmapHolder)this.b.poll();
    BitmapCacheManager.BitmapHolder localBitmapHolder1 = localBitmapHolder2;
    if (localBitmapHolder2 == null) {
      localBitmapHolder1 = new BitmapCacheManager.BitmapHolder(null);
    }
    return localBitmapHolder1;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    this.e += 1;
    Iterator localIterator = this.a.iterator();
    label21:
    Object localObject2;
    for (Object localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
    {
      localObject2 = (BitmapCacheManager.BitmapHolder)localIterator.next();
      if ((BitmapCacheManager.BitmapHolder.a((BitmapCacheManager.BitmapHolder)localObject2) < paramInt1) || (BitmapCacheManager.BitmapHolder.b((BitmapCacheManager.BitmapHolder)localObject2) < paramInt2) || ((localObject1 != null) && (BitmapCacheManager.BitmapHolder.c((BitmapCacheManager.BitmapHolder)localObject1) < BitmapCacheManager.BitmapHolder.c((BitmapCacheManager.BitmapHolder)localObject2)))) {
        break label21;
      }
    }
    if (localObject1 != null)
    {
      this.a.remove(localObject1);
      this.d -= BitmapCacheManager.BitmapHolder.d((BitmapCacheManager.BitmapHolder)localObject1);
      localObject2 = BitmapCacheManager.BitmapHolder.e((BitmapCacheManager.BitmapHolder)localObject1);
      this.b.addLast(localObject1);
      return localObject2;
    }
    try
    {
      this.f += 1;
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Logger.a("BitmapCacheManager", "create bitmap out of memory", localOutOfMemoryError);
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      BitmapCacheManager.BitmapHolder localBitmapHolder = (BitmapCacheManager.BitmapHolder)localIterator.next();
      if (localBitmapHolder != null) {
        BitmapCacheManager.BitmapHolder.f(localBitmapHolder);
      }
    }
    this.a.clear();
    this.d = 0;
    this.e = 0;
    this.f = 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return;
      }
      this.d += paramBitmap.getRowBytes() * paramBitmap.getHeight();
      BitmapCacheManager.BitmapHolder localBitmapHolder = f();
      BitmapCacheManager.BitmapHolder.a(localBitmapHolder, paramBitmap);
      this.a.addLast(localBitmapHolder);
      e();
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.tool.BitmapCacheManager
 * JD-Core Version:    0.7.0.1
 */