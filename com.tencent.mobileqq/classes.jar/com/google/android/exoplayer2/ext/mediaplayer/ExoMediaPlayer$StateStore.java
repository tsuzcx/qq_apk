package com.google.android.exoplayer2.ext.mediaplayer;

class ExoMediaPlayer$StateStore
{
  private static final int FLAG_PLAY_WHEN_READY = -268435456;
  private static final int STATE_SEEKING = 100;
  private int[] prevStates = { 1, 1, 1, 1 };
  
  int getMostRecentState()
  {
    return this.prevStates[3];
  }
  
  int getState(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = -268435456;
    } else {
      i = 0;
    }
    return i | paramInt;
  }
  
  boolean isLastReportedPlayWhenReady()
  {
    return (this.prevStates[3] & 0xF0000000) != 0;
  }
  
  boolean matchesHistory(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 268435455;
    } else {
      i = -1;
    }
    int k = this.prevStates.length - paramArrayOfInt.length;
    int j = k;
    paramBoolean = true;
    for (;;)
    {
      int[] arrayOfInt = this.prevStates;
      if (j >= arrayOfInt.length) {
        break;
      }
      boolean bool;
      if ((arrayOfInt[j] & i) == (paramArrayOfInt[(j - k)] & i)) {
        bool = true;
      } else {
        bool = false;
      }
      paramBoolean &= bool;
      j += 1;
    }
    return paramBoolean;
  }
  
  void reset()
  {
    this.prevStates = new int[] { 1, 1, 1, 1 };
  }
  
  void setMostRecentState(boolean paramBoolean, int paramInt)
  {
    int i = getState(paramBoolean, paramInt);
    Object localObject = ExoMediaPlayer.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("request setMostRecentState [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], lastState=");
    localStringBuilder.append(this.prevStates[3]);
    localStringBuilder.append(",newState=");
    localStringBuilder.append(i);
    ((ILogger)localObject).v("ExoMediaPlayer", localStringBuilder.toString());
    localObject = this.prevStates;
    if (localObject[3] == i) {
      return;
    }
    localObject[0] = localObject[1];
    localObject[1] = localObject[2];
    localObject[2] = localObject[3];
    localObject[3] = i;
    localObject = ExoMediaPlayer.getLogger();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MostRecentState [");
    localStringBuilder.append(this.prevStates[0]);
    localStringBuilder.append(",");
    localStringBuilder.append(this.prevStates[1]);
    localStringBuilder.append(",");
    localStringBuilder.append(this.prevStates[2]);
    localStringBuilder.append(",");
    localStringBuilder.append(this.prevStates[3]);
    localStringBuilder.append("]");
    ((ILogger)localObject).v("ExoMediaPlayer", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.StateStore
 * JD-Core Version:    0.7.0.1
 */