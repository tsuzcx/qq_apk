package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;

public class DefaultLoadControl
  implements LoadControl
{
  public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
  public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
  public static final int DEFAULT_MAX_BUFFER_MS = 30000;
  public static final int DEFAULT_MIN_BUFFER_MS = 15000;
  public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = true;
  public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
  private final DefaultAllocator allocator;
  private final long bufferForPlaybackAfterRebufferUs;
  private final long bufferForPlaybackUs;
  private boolean isBuffering;
  private final long maxBufferUs;
  private final long minBufferUs;
  private final boolean prioritizeTimeOverSizeThresholds;
  private final PriorityTaskManager priorityTaskManager;
  private final int targetBufferBytesOverwrite;
  private int targetBufferSize;
  
  public DefaultLoadControl()
  {
    this(new DefaultAllocator(true, 65536));
  }
  
  public DefaultLoadControl(DefaultAllocator paramDefaultAllocator)
  {
    this(paramDefaultAllocator, 15000, 30000, 2500, 5000, -1, true);
  }
  
  public DefaultLoadControl(DefaultAllocator paramDefaultAllocator, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    this(paramDefaultAllocator, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, null);
  }
  
  public DefaultLoadControl(DefaultAllocator paramDefaultAllocator, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, PriorityTaskManager paramPriorityTaskManager)
  {
    this.allocator = paramDefaultAllocator;
    this.minBufferUs = (paramInt1 * 1000L);
    this.maxBufferUs = (paramInt2 * 1000L);
    this.bufferForPlaybackUs = (paramInt3 * 1000L);
    this.bufferForPlaybackAfterRebufferUs = (paramInt4 * 1000L);
    this.targetBufferBytesOverwrite = paramInt5;
    this.prioritizeTimeOverSizeThresholds = paramBoolean;
    this.priorityTaskManager = paramPriorityTaskManager;
  }
  
  private void reset(boolean paramBoolean)
  {
    this.targetBufferSize = 0;
    PriorityTaskManager localPriorityTaskManager = this.priorityTaskManager;
    if ((localPriorityTaskManager != null) && (this.isBuffering)) {
      localPriorityTaskManager.remove(0);
    }
    this.isBuffering = false;
    if (paramBoolean) {
      this.allocator.reset();
    }
  }
  
  protected int calculateTargetBufferSize(Renderer[] paramArrayOfRenderer, TrackSelectionArray paramTrackSelectionArray)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfRenderer.length; j = k)
    {
      k = j;
      if (paramTrackSelectionArray.get(i) != null) {
        k = j + Util.getDefaultBufferSize(paramArrayOfRenderer[i].getTrackType());
      }
      i += 1;
    }
    return j;
  }
  
  public Allocator getAllocator()
  {
    return this.allocator;
  }
  
  public long getBackBufferDurationUs()
  {
    return 0L;
  }
  
  public void onPrepared()
  {
    reset(false);
  }
  
  public void onReleased()
  {
    reset(true);
  }
  
  public void onStopped()
  {
    reset(true);
  }
  
  public void onTracksSelected(Renderer[] paramArrayOfRenderer, TrackGroupArray paramTrackGroupArray, TrackSelectionArray paramTrackSelectionArray)
  {
    int j = this.targetBufferBytesOverwrite;
    int i = j;
    if (j == -1) {
      i = calculateTargetBufferSize(paramArrayOfRenderer, paramTrackSelectionArray);
    }
    this.targetBufferSize = i;
    this.allocator.setTargetBufferSize(this.targetBufferSize);
  }
  
  public boolean retainBackBufferFromKeyframe()
  {
    return false;
  }
  
  public boolean shouldContinueLoading(long paramLong, float paramFloat)
  {
    int i = this.allocator.getTotalBytesAllocated();
    int j = this.targetBufferSize;
    boolean bool3 = true;
    boolean bool2 = true;
    if (i >= j) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool4 = this.isBuffering;
    boolean bool1;
    if (this.prioritizeTimeOverSizeThresholds)
    {
      bool1 = bool2;
      if (paramLong >= this.minBufferUs) {
        if ((paramLong <= this.maxBufferUs) && (bool4) && (i == 0)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      this.isBuffering = bool1;
    }
    else
    {
      if (i == 0)
      {
        bool1 = bool3;
        if (paramLong < this.minBufferUs) {
          break label143;
        }
        if ((paramLong <= this.maxBufferUs) && (bool4))
        {
          bool1 = bool3;
          break label143;
        }
      }
      bool1 = false;
      label143:
      this.isBuffering = bool1;
    }
    PriorityTaskManager localPriorityTaskManager = this.priorityTaskManager;
    if (localPriorityTaskManager != null)
    {
      bool1 = this.isBuffering;
      if (bool1 != bool4) {
        if (bool1) {
          localPriorityTaskManager.add(0);
        } else {
          localPriorityTaskManager.remove(0);
        }
      }
    }
    return this.isBuffering;
  }
  
  public boolean shouldStartPlayback(long paramLong, float paramFloat, boolean paramBoolean)
  {
    long l = Util.getPlayoutDurationForMediaDuration(paramLong, paramFloat);
    if (paramBoolean) {
      paramLong = this.bufferForPlaybackAfterRebufferUs;
    } else {
      paramLong = this.bufferForPlaybackUs;
    }
    return (paramLong <= 0L) || (l >= paramLong) || ((!this.prioritizeTimeOverSizeThresholds) && (this.allocator.getTotalBytesAllocated() >= this.targetBufferSize));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.DefaultLoadControl
 * JD-Core Version:    0.7.0.1
 */