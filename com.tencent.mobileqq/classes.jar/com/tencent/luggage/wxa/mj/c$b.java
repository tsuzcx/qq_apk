package com.tencent.luggage.wxa.mj;

import com.tencent.luggage.wxa.al.e.a;
import com.tencent.luggage.wxa.am.d;
import com.tencent.luggage.wxa.z.n;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection$Factory;", "Lcom/google/android/exoplayer2/trackselection/TrackSelection$Factory;", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/upstream/BandwidthMeter;IIIIF)V", "createTrackSelection", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 1, 16})
public final class c$b
  implements e.a
{
  private final d a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final float f;
  
  @JvmOverloads
  public c$b(@NotNull d paramd, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    this.a = paramd;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramFloat;
  }
  
  @NotNull
  public c b(@NotNull n paramn, @NotNull int... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramn, "group");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "tracks");
    return new c(paramn, paramVarArgs, this.a, this.b, this.c, this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mj.c.b
 * JD-Core Version:    0.7.0.1
 */