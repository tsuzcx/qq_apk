package com.google.android.exoplayer2.source;

import java.io.IOException;

public final class MergingMediaSource$IllegalMergeException
  extends IOException
{
  public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
  public final int reason;
  
  public MergingMediaSource$IllegalMergeException(int paramInt)
  {
    this.reason = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MergingMediaSource.IllegalMergeException
 * JD-Core Version:    0.7.0.1
 */