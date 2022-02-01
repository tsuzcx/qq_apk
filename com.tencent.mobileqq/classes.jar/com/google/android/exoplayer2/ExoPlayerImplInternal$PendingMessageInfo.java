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
    int k = 1;
    int i;
    int j;
    if (this.resolvedPeriodUid == null)
    {
      i = 1;
      if (paramPendingMessageInfo.resolvedPeriodUid != null) {
        break label45;
      }
      j = 1;
      label21:
      if (i == j) {
        break label50;
      }
      i = k;
      if (this.resolvedPeriodUid != null) {
        i = -1;
      }
    }
    label45:
    label50:
    do
    {
      return i;
      i = 0;
      break;
      j = 0;
      break label21;
      if (this.resolvedPeriodUid == null) {
        return 0;
      }
      j = this.resolvedPeriodIndex - paramPendingMessageInfo.resolvedPeriodIndex;
      i = j;
    } while (j != 0);
    return Util.compareLong(this.resolvedPeriodTimeUs, paramPendingMessageInfo.resolvedPeriodTimeUs);
  }
  
  public void setResolvedPosition(int paramInt, long paramLong, Object paramObject)
  {
    this.resolvedPeriodIndex = paramInt;
    this.resolvedPeriodTimeUs = paramLong;
    this.resolvedPeriodUid = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo
 * JD-Core Version:    0.7.0.1
 */