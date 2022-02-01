package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

final class ExoPlayerImplInternal$PlaybackInfoUpdate
{
  private int discontinuityReason;
  private PlaybackInfo lastPlaybackInfo;
  private int operationAcks;
  private boolean positionDiscontinuity;
  
  public boolean hasPendingUpdate(PlaybackInfo paramPlaybackInfo)
  {
    return (paramPlaybackInfo != this.lastPlaybackInfo) || (this.operationAcks > 0) || (this.positionDiscontinuity);
  }
  
  public void incrementPendingOperationAcks(int paramInt)
  {
    this.operationAcks += paramInt;
  }
  
  public void reset(PlaybackInfo paramPlaybackInfo)
  {
    this.lastPlaybackInfo = paramPlaybackInfo;
    this.operationAcks = 0;
    this.positionDiscontinuity = false;
  }
  
  public void setPositionDiscontinuity(int paramInt)
  {
    boolean bool2 = this.positionDiscontinuity;
    boolean bool1 = true;
    if ((bool2) && (this.discontinuityReason != 4))
    {
      if (paramInt != 4) {
        bool1 = false;
      }
      Assertions.checkArgument(bool1);
      return;
    }
    this.positionDiscontinuity = true;
    this.discontinuityReason = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate
 * JD-Core Version:    0.7.0.1
 */