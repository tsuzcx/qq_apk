package com.tencent.luggage.wxa.mj;

import android.os.Handler;
import com.tencent.luggage.wxa.am.d;
import com.tencent.luggage.wxa.am.d.a;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.am.w;
import com.tencent.luggage.wxa.ao.c;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceBandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "", "eventHandler", "Landroid/os/Handler;", "eventListener", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;", "maxWeight", "", "clock", "Lcom/google/android/exoplayer2/util/Clock;", "(Landroid/os/Handler;Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;ILcom/google/android/exoplayer2/util/Clock;)V", "bitrateEstimate", "", "sampleBytesTransferred", "sampleStartTimeMs", "slidingPercentile", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "streamCount", "totalBytesTransferred", "totalElapsedTimeMs", "getBitrateEstimate", "notifyBandwidthSample", "", "elapsedMs", "bytes", "bitrate", "onBytesTransferred", "source", "onTransferEnd", "onTransferStart", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "resetBizrateEstimate", "Companion", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  implements d, w<Object>
{
  public static final a.a a = new a.a(null);
  private static final int l = 2000;
  private static final long m = 2000L;
  private static final long n = 524288L;
  private final b b;
  private int c;
  private long d;
  private long e;
  private long f;
  private long g;
  private long h;
  private final Handler i;
  private final d.a j;
  private final c k;
  
  @JvmOverloads
  public a()
  {
    this(null, null, 0, null, 15, null);
  }
  
  @JvmOverloads
  public a(@Nullable Handler paramHandler, @Nullable d.a parama, int paramInt, @NotNull c paramc)
  {
    this.i = paramHandler;
    this.j = parama;
    this.k = paramc;
    this.b = new b(paramInt);
    this.h = -1L;
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2)
  {
    Handler localHandler = this.i;
    if ((localHandler != null) && (this.j != null)) {
      localHandler.post((Runnable)new a.b(this, paramInt, paramLong1, paramLong2));
    }
  }
  
  public long a()
  {
    try
    {
      long l1 = this.h;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(@NotNull Object paramObject)
  {
    for (;;)
    {
      float f1;
      try
      {
        Intrinsics.checkParameterIsNotNull(paramObject, "source");
        if (this.c > 0)
        {
          bool = true;
          com.tencent.luggage.wxa.ao.a.b(bool);
          long l2 = this.k.a();
          int i1 = (int)(l2 - this.d);
          l1 = this.f;
          long l3 = i1;
          this.f = (l1 + l3);
          this.g += this.e;
          if (i1 > 0)
          {
            f1 = (float)(this.e * 8000L / l3);
            this.b.a((int)Math.sqrt(this.e), f1);
            if ((this.f >= m) || (this.g >= n))
            {
              f1 = this.b.a();
              if (Float.isNaN(f1)) {
                break label227;
              }
              if (f1 >= 0) {
                break label220;
              }
              break label227;
              this.h = l1;
            }
          }
          a(i1, this.e, this.h);
          this.c -= 1;
          if (this.c > 0) {
            this.d = l2;
          }
          this.e = 0L;
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label220:
      long l1 = f1;
      continue;
      label227:
      l1 = -1L;
    }
  }
  
  public void a(@NotNull Object paramObject, int paramInt)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramObject, "source");
      this.e += paramInt;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void a(@NotNull Object paramObject, @NotNull j paramj)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramObject, "source");
      Intrinsics.checkParameterIsNotNull(paramj, "dataSpec");
      if (this.c == 0) {
        this.d = this.k.a();
      }
      this.c += 1;
      int i1 = this.c;
      return;
    }
    finally {}
  }
  
  public final void b()
  {
    this.h = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mj.a
 * JD-Core Version:    0.7.0.1
 */