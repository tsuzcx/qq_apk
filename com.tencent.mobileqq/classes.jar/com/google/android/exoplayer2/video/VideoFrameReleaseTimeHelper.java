package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Util;

@TargetApi(16)
public final class VideoFrameReleaseTimeHelper
{
  private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500L;
  private static final long MAX_ALLOWED_DRIFT_NS = 20000000L;
  private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
  private static final long VSYNC_OFFSET_PERCENTAGE = 80L;
  private long adjustedLastFrameTimeNs;
  private final VideoFrameReleaseTimeHelper.DefaultDisplayListener displayListener;
  private long frameCount;
  private boolean haveSync;
  private long lastFramePresentationTimeUs;
  private long pendingAdjustedFrameTimeNs;
  private long syncFramePresentationTimeNs;
  private long syncUnadjustedReleaseTimeNs;
  private long vsyncDurationNs;
  private long vsyncOffsetNs;
  private final VideoFrameReleaseTimeHelper.VSyncSampler vsyncSampler;
  private final WindowManager windowManager;
  
  public VideoFrameReleaseTimeHelper()
  {
    this(null);
  }
  
  public VideoFrameReleaseTimeHelper(@Nullable Context paramContext)
  {
    Object localObject1;
    if (paramContext == null)
    {
      localObject1 = null;
      this.windowManager = ((WindowManager)localObject1);
      if (this.windowManager == null) {
        break label80;
      }
      localObject1 = localObject2;
      if (Util.SDK_INT >= 17) {
        localObject1 = maybeBuildDefaultDisplayListenerV17(paramContext);
      }
      this.displayListener = ((VideoFrameReleaseTimeHelper.DefaultDisplayListener)localObject1);
    }
    for (this.vsyncSampler = VideoFrameReleaseTimeHelper.VSyncSampler.getInstance();; this.vsyncSampler = null)
    {
      this.vsyncDurationNs = -9223372036854775807L;
      this.vsyncOffsetNs = -9223372036854775807L;
      return;
      localObject1 = (WindowManager)paramContext.getSystemService("window");
      break;
      label80:
      this.displayListener = null;
    }
  }
  
  private static long closestVsync(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong2 = (paramLong1 - paramLong2) / paramLong3 * paramLong3 + paramLong2;
    long l;
    if (paramLong1 <= paramLong2) {
      l = paramLong2 - paramLong3;
    }
    while (paramLong2 - paramLong1 < paramLong1 - l)
    {
      return paramLong2;
      l = paramLong2;
      paramLong2 += paramLong3;
    }
    return l;
  }
  
  private boolean isDriftTooLarge(long paramLong1, long paramLong2)
  {
    long l = this.syncFramePresentationTimeNs;
    return Math.abs(paramLong2 - this.syncUnadjustedReleaseTimeNs - (paramLong1 - l)) > 20000000L;
  }
  
  @TargetApi(17)
  private VideoFrameReleaseTimeHelper.DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context paramContext)
  {
    paramContext = (DisplayManager)paramContext.getSystemService("display");
    if (paramContext == null) {
      return null;
    }
    return new VideoFrameReleaseTimeHelper.DefaultDisplayListener(this, paramContext);
  }
  
  private void updateDefaultDisplayRefreshRateParams()
  {
    Display localDisplay = this.windowManager.getDefaultDisplay();
    if (localDisplay != null)
    {
      this.vsyncDurationNs = ((1000000000.0D / localDisplay.getRefreshRate()));
      this.vsyncOffsetNs = (this.vsyncDurationNs * 80L / 100L);
    }
  }
  
  public long adjustReleaseTime(long paramLong1, long paramLong2)
  {
    long l3 = paramLong1 * 1000L;
    long l1;
    long l2;
    if (this.haveSync)
    {
      if (paramLong1 != this.lastFramePresentationTimeUs)
      {
        this.frameCount += 1L;
        this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
      }
      if (this.frameCount >= 6L)
      {
        l1 = (l3 - this.syncFramePresentationTimeNs) / this.frameCount;
        l2 = this.adjustedLastFrameTimeNs + l1;
        if (isDriftTooLarge(l2, paramLong2))
        {
          this.haveSync = false;
          l1 = paramLong2;
          l2 = l3;
          if (!this.haveSync)
          {
            this.syncFramePresentationTimeNs = l3;
            this.syncUnadjustedReleaseTimeNs = paramLong2;
            this.frameCount = 0L;
            this.haveSync = true;
          }
          this.lastFramePresentationTimeUs = paramLong1;
          this.pendingAdjustedFrameTimeNs = l2;
          if ((this.vsyncSampler != null) && (this.vsyncDurationNs != -9223372036854775807L)) {
            break label199;
          }
        }
      }
    }
    label199:
    do
    {
      return l1;
      l1 = this.syncUnadjustedReleaseTimeNs + l2 - this.syncFramePresentationTimeNs;
      break;
      if (isDriftTooLarge(l3, paramLong2)) {
        this.haveSync = false;
      }
      l1 = paramLong2;
      l2 = l3;
      break;
      paramLong1 = this.vsyncSampler.sampledVsyncTimeNs;
    } while (paramLong1 == -9223372036854775807L);
    return closestVsync(l1, paramLong1, this.vsyncDurationNs) - this.vsyncOffsetNs;
  }
  
  public void disable()
  {
    if (this.windowManager != null)
    {
      if (this.displayListener != null) {
        this.displayListener.unregister();
      }
      this.vsyncSampler.removeObserver();
    }
  }
  
  public void enable()
  {
    this.haveSync = false;
    if (this.windowManager != null)
    {
      this.vsyncSampler.addObserver();
      if (this.displayListener != null) {
        this.displayListener.register();
      }
      updateDefaultDisplayRefreshRateParams();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper
 * JD-Core Version:    0.7.0.1
 */