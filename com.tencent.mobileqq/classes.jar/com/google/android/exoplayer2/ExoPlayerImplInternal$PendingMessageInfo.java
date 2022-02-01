package com.google.android.exoplayer2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;

final class ExoPlayerImplInternal$PendingMessageInfo
  implements Comparable<PendingMessageInfo>
{
  public final PlayerMessage message;
  public int resolvedPeriodIndex;
  public long resolvedPeriodTimeUs;
  @Nullable
  public Object resolvedPeriodUid;
  
  public ExoPlayerImplInternal$PendingMessageInfo(PlayerMessage paramPlayerMessage)
  {
    this.message = paramPlayerMessage;
  }
  
  public int compareTo(@NonNull PendingMessageInfo paramPendingMessageInfo)
  {
    Object localObject = this.resolvedPeriodUid;
    int k = 1;
    if (localObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramPendingMessageInfo.resolvedPeriodUid == null) {
      j = 1;
    } else {
      j = 0;
    }
    if (i != j)
    {
      i = k;
      if (this.resolvedPeriodUid != null) {
        i = -1;
      }
      return i;
    }
    if (this.resolvedPeriodUid == null) {
      return 0;
    }
    int i = this.resolvedPeriodIndex - paramPendingMessageInfo.resolvedPeriodIndex;
    if (i != 0) {
      return i;
    }
    return Util.compareLong(this.resolvedPeriodTimeUs, paramPendingMessageInfo.resolvedPeriodTimeUs);
  }
  
  public void setResolvedPosition(int paramInt, long paramLong, Object paramObject)
  {
    this.resolvedPeriodIndex = paramInt;
    this.resolvedPeriodTimeUs = paramLong;
    this.resolvedPeriodUid = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo
 * JD-Core Version:    0.7.0.1
 */