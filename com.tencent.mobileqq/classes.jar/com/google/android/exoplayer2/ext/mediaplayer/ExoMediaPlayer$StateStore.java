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
    if (paramBoolean) {}
    for (int i = -268435456;; i = 0) {
      return i | paramInt;
    }
  }
  
  boolean isLastReportedPlayWhenReady()
  {
    return (this.prevStates[3] & 0xF0000000) != 0;
  }
  
  boolean matchesHistory(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 268435455;
      int k = this.prevStates.length - paramArrayOfInt.length;
      j = k;
      paramBoolean = true;
      label23:
      if (j >= this.prevStates.length) {
        return paramBoolean;
      }
      if ((this.prevStates[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      paramBoolean &= bool;
      j += 1;
      break label23;
      i = -1;
      break;
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
    ExoMediaPlayer.getLogger().v("ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.prevStates[3] + ",newState=" + i);
    if (this.prevStates[3] == i) {
      return;
    }
    this.prevStates[0] = this.prevStates[1];
    this.prevStates[1] = this.prevStates[2];
    this.prevStates[2] = this.prevStates[3];
    this.prevStates[3] = i;
    ExoMediaPlayer.getLogger().v("ExoMediaPlayer", "MostRecentState [" + this.prevStates[0] + "," + this.prevStates[1] + "," + this.prevStates[2] + "," + this.prevStates[3] + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.StateStore
 * JD-Core Version:    0.7.0.1
 */