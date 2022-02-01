package com.tencent.luggage.wxa.mj;

import android.os.SystemClock;
import com.tencent.luggage.wxa.am.d;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.z.n;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "Lcom/google/android/exoplayer2/trackselection/BaseTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/source/TrackGroup;[ILcom/google/android/exoplayer2/upstream/BandwidthMeter;IJJJF)V", "maxDurationForQualityDecreaseUs", "minDurationForQualityIncreaseUs", "minDurationToRetainAfterDiscardUs", "reason", "selectedIndex", "determineIdealSelectedIndex", "nowMs", "evaluateQueueSize", "playbackPositionUs", "queue", "", "Lcom/google/android/exoplayer2/source/chunk/MediaChunk;", "getSelectFormat", "Lcom/google/android/exoplayer2/Format;", "getSelectedIndex", "getSelectionData", "", "getSelectionReason", "updateSelectedTrack", "", "bufferedDurationUs", "Companion", "Factory", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends com.tencent.luggage.wxa.al.a
{
  public static final c.a d = new c.a(null);
  private static final int m = 800000;
  private static final int n = 10000;
  private static final int o = 25000;
  private static final int p = 25000;
  private static final float q = 0.75F;
  private final long e;
  private final long f;
  private final long g;
  private int h;
  private int i;
  private final d j;
  private final int k;
  private final float l;
  
  @JvmOverloads
  public c(@NotNull n paramn, @NotNull int[] paramArrayOfInt, @NotNull d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramn, Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    this.j = paramd;
    this.k = paramInt;
    this.l = paramFloat;
    this.e = (paramLong1 * 1000L);
    this.f = (paramLong2 * 1000L);
    this.g = (paramLong3 * 1000L);
    paramArrayOfInt = this.j;
    paramn = paramArrayOfInt;
    if (!(paramArrayOfInt instanceof a)) {
      paramn = null;
    }
    paramn = (a)paramn;
    if (paramn != null) {
      paramn.b();
    }
    this.h = b(-1L);
    this.i = 1;
  }
  
  private final int b(long paramLong)
  {
    long l2 = this.j.a();
    long l1;
    if (l2 == -1L) {
      l1 = this.k;
    } else {
      l1 = ((float)l2 * this.l);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TRACE_ADAPTIVE] determineIdealSelectedIndex bitrateEstimate = ");
    localStringBuilder.append(l2);
    o.d("MicroMsg.AdavanceTrackSelection", localStringBuilder.toString());
    int i3 = this.b;
    int i1 = 0;
    int i2 = 0;
    while (i1 < i3)
    {
      if ((paramLong == -1L) || (!b(i1, paramLong)))
      {
        if (a(i1).b <= l1) {
          return i1;
        }
        i2 = i1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a(long paramLong)
  {
    long l1 = SystemClock.elapsedRealtime();
    int i1 = this.h;
    this.h = b(l1);
    if (this.h != i1)
    {
      if (!b(i1, l1))
      {
        localObject = a(i1);
        k localk = a(this.h);
        if ((localk.b > ((k)localObject).b) && (paramLong < this.e))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[TRACE_ADAPTIVE] updateSelectedTrack < selectIndex = ");
          ((StringBuilder)localObject).append(this.h);
          ((StringBuilder)localObject).append(", bufferedDurationUs = ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", min = ");
          ((StringBuilder)localObject).append(this.e);
          o.d("MicroMsg.AdavanceTrackSelection", ((StringBuilder)localObject).toString());
          this.h = i1;
        }
        else if ((localk.b < ((k)localObject).b) && (paramLong >= this.f))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[TRACE_ADAPTIVE] updateSelectedTrack > selectIndex = ");
          ((StringBuilder)localObject).append(this.h);
          ((StringBuilder)localObject).append(", bufferedDurationUs = ");
          ((StringBuilder)localObject).append(paramLong);
          o.d("MicroMsg.AdavanceTrackSelection", ((StringBuilder)localObject).toString());
          this.h = i1;
        }
      }
      if (this.h != i1) {
        this.i = 3;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[TRACE_ADAPTIVE] updateSelectedTrack selectIndex = ");
    ((StringBuilder)localObject).append(this.h);
    o.d("MicroMsg.AdavanceTrackSelection", ((StringBuilder)localObject).toString());
  }
  
  public int b()
  {
    return this.i;
  }
  
  @Nullable
  public Object c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mj.c
 * JD-Core Version:    0.7.0.1
 */