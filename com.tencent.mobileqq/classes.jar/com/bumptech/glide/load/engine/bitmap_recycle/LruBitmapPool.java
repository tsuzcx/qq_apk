package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool
  implements BitmapPool
{
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  private final LruPoolStrategy b;
  private final Set<Bitmap.Config> c;
  private final long d;
  private final LruBitmapPool.BitmapTracker e;
  private long f;
  private long g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public LruBitmapPool(long paramLong)
  {
    this(paramLong, f(), g());
  }
  
  LruBitmapPool(long paramLong, LruPoolStrategy paramLruPoolStrategy, Set<Bitmap.Config> paramSet)
  {
    this.d = paramLong;
    this.f = paramLong;
    this.b = paramLruPoolStrategy;
    this.c = paramSet;
    this.e = new LruBitmapPool.NullBitmapTracker();
  }
  
  private void a(long paramLong)
  {
    try
    {
      while (this.g > paramLong)
      {
        Bitmap localBitmap = this.b.a();
        if (localBitmap == null)
        {
          if (Log.isLoggable("LruBitmapPool", 5))
          {
            Log.w("LruBitmapPool", "Size mismatch, resetting");
            e();
          }
          this.g = 0L;
          return;
        }
        this.e.b(localBitmap);
        this.g -= this.b.c(localBitmap);
        this.k += 1;
        if (Log.isLoggable("LruBitmapPool", 3))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Evicting bitmap=");
          localStringBuilder.append(this.b.b(localBitmap));
          Log.d("LruBitmapPool", localStringBuilder.toString());
        }
        d();
        localBitmap.recycle();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  @TargetApi(26)
  private static void a(Bitmap.Config paramConfig)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return;
    }
    if (paramConfig != Bitmap.Config.HARDWARE) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot create a mutable Bitmap with config: ");
    localStringBuilder.append(paramConfig);
    localStringBuilder.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void b(Bitmap paramBitmap)
  {
    paramBitmap.setHasAlpha(true);
    c(paramBitmap);
  }
  
  @NonNull
  private static Bitmap c(int paramInt1, int paramInt2, @Nullable Bitmap.Config paramConfig)
  {
    if (paramConfig == null) {
      paramConfig = a;
    }
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
  
  private void c()
  {
    a(this.f);
  }
  
  @TargetApi(19)
  private static void c(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramBitmap.setPremultiplied(true);
    }
  }
  
  @Nullable
  private Bitmap d(int paramInt1, int paramInt2, @Nullable Bitmap.Config paramConfig)
  {
    try
    {
      a(paramConfig);
      Object localObject2 = this.b;
      if (paramConfig != null) {
        localObject1 = paramConfig;
      } else {
        localObject1 = a;
      }
      Object localObject1 = ((LruPoolStrategy)localObject2).a(paramInt1, paramInt2, (Bitmap.Config)localObject1);
      if (localObject1 == null)
      {
        if (Log.isLoggable("LruBitmapPool", 3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Missing bitmap=");
          ((StringBuilder)localObject2).append(this.b.b(paramInt1, paramInt2, paramConfig));
          Log.d("LruBitmapPool", ((StringBuilder)localObject2).toString());
        }
        this.i += 1;
      }
      else
      {
        this.h += 1;
        this.g -= this.b.c((Bitmap)localObject1);
        this.e.b((Bitmap)localObject1);
        b((Bitmap)localObject1);
      }
      if (Log.isLoggable("LruBitmapPool", 2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Get bitmap=");
        ((StringBuilder)localObject2).append(this.b.b(paramInt1, paramInt2, paramConfig));
        Log.v("LruBitmapPool", ((StringBuilder)localObject2).toString());
      }
      d();
      return localObject1;
    }
    finally {}
  }
  
  private void d()
  {
    if (Log.isLoggable("LruBitmapPool", 2)) {
      e();
    }
  }
  
  private void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hits=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", misses=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", puts=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", evictions=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", currentSize=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", maxSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\nStrategy=");
    localStringBuilder.append(this.b);
    Log.v("LruBitmapPool", localStringBuilder.toString());
  }
  
  private static LruPoolStrategy f()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return new SizeConfigStrategy();
    }
    return new AttributeStrategy();
  }
  
  @TargetApi(26)
  private static Set<Bitmap.Config> g()
  {
    HashSet localHashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
    if (Build.VERSION.SDK_INT >= 19) {
      localHashSet.add(null);
    }
    if (Build.VERSION.SDK_INT >= 26) {
      localHashSet.remove(Bitmap.Config.HARDWARE);
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  @NonNull
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Bitmap localBitmap = d(paramInt1, paramInt2, paramConfig);
    if (localBitmap != null)
    {
      localBitmap.eraseColor(0);
      return localBitmap;
    }
    return c(paramInt1, paramInt2, paramConfig);
  }
  
  public void a()
  {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      Log.d("LruBitmapPool", "clearMemory");
    }
    a(0L);
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (Log.isLoggable("LruBitmapPool", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trimMemory, level=");
      localStringBuilder.append(paramInt);
      Log.d("LruBitmapPool", localStringBuilder.toString());
    }
    if (paramInt >= 40)
    {
      a();
      return;
    }
    if ((paramInt >= 20) || (paramInt == 15)) {
      a(b() / 2L);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        StringBuilder localStringBuilder;
        if ((paramBitmap.isMutable()) && (this.b.c(paramBitmap) <= this.f) && (this.c.contains(paramBitmap.getConfig())))
        {
          int m = this.b.c(paramBitmap);
          this.b.a(paramBitmap);
          this.e.a(paramBitmap);
          this.j += 1;
          this.g += m;
          if (Log.isLoggable("LruBitmapPool", 2))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Put bitmap in pool=");
            localStringBuilder.append(this.b.b(paramBitmap));
            Log.v("LruBitmapPool", localStringBuilder.toString());
          }
          d();
          c();
          return;
        }
        if (Log.isLoggable("LruBitmapPool", 2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Reject bitmap from pool, bitmap: ");
          localStringBuilder.append(this.b.b(paramBitmap));
          localStringBuilder.append(", is mutable: ");
          localStringBuilder.append(paramBitmap.isMutable());
          localStringBuilder.append(", is allowed config: ");
          localStringBuilder.append(this.c.contains(paramBitmap.getConfig()));
          Log.v("LruBitmapPool", localStringBuilder.toString());
        }
        paramBitmap.recycle();
        return;
      }
      throw new IllegalStateException("Cannot pool recycled bitmap");
    }
    finally
    {
      label293:
      break label293;
    }
    throw new NullPointerException("Bitmap must not be null");
    throw paramBitmap;
  }
  
  public long b()
  {
    return this.f;
  }
  
  @NonNull
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Bitmap localBitmap2 = d(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = c(paramInt1, paramInt2, paramConfig);
    }
    return localBitmap1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
 * JD-Core Version:    0.7.0.1
 */