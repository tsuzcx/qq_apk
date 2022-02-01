package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner
  implements Runnable
{
  static final long a = TimeUnit.SECONDS.toMillis(1L);
  private static final BitmapPreFillRunner.Clock b = new BitmapPreFillRunner.Clock();
  private final BitmapPool c;
  private final MemoryCache d;
  private final PreFillQueue e;
  private final BitmapPreFillRunner.Clock f;
  private final Set<PreFillType> g;
  private final Handler h;
  private long i;
  private boolean j;
  
  private boolean a(long paramLong)
  {
    return this.f.a() - paramLong >= 32L;
  }
  
  private long b()
  {
    return this.d.b() - this.d.a();
  }
  
  private long c()
  {
    long l = this.i;
    this.i = Math.min(4L * l, a);
    return l;
  }
  
  @VisibleForTesting
  boolean a()
  {
    long l = this.f.a();
    while ((!this.e.b()) && (!a(l)))
    {
      PreFillType localPreFillType = this.e.a();
      Object localObject;
      if (!this.g.contains(localPreFillType))
      {
        this.g.add(localPreFillType);
        localObject = this.c.b(localPreFillType.a(), localPreFillType.b(), localPreFillType.c());
      }
      else
      {
        localObject = Bitmap.createBitmap(localPreFillType.a(), localPreFillType.b(), localPreFillType.c());
      }
      int k = Util.a((Bitmap)localObject);
      if (b() >= k)
      {
        BitmapPreFillRunner.UniqueKey localUniqueKey = new BitmapPreFillRunner.UniqueKey();
        this.d.b(localUniqueKey, BitmapResource.a((Bitmap)localObject, this.c));
      }
      else
      {
        this.c.a((Bitmap)localObject);
      }
      if (Log.isLoggable("PreFillRunner", 3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("allocated [");
        ((StringBuilder)localObject).append(localPreFillType.a());
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(localPreFillType.b());
        ((StringBuilder)localObject).append("] ");
        ((StringBuilder)localObject).append(localPreFillType.c());
        ((StringBuilder)localObject).append(" size: ");
        ((StringBuilder)localObject).append(k);
        Log.d("PreFillRunner", ((StringBuilder)localObject).toString());
      }
    }
    return (!this.j) && (!this.e.b());
  }
  
  public void run()
  {
    if (a()) {
      this.h.postDelayed(this, c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner
 * JD-Core Version:    0.7.0.1
 */