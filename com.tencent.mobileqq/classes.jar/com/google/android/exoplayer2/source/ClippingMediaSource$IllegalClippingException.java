package com.google.android.exoplayer2.source;

import java.io.IOException;

public final class ClippingMediaSource$IllegalClippingException
  extends IOException
{
  public static final int REASON_INVALID_PERIOD_COUNT = 0;
  public static final int REASON_NOT_SEEKABLE_TO_START = 2;
  public static final int REASON_PERIOD_OFFSET_IN_WINDOW = 1;
  public static final int REASON_START_EXCEEDS_END = 3;
  public final int reason;
  
  public ClippingMediaSource$IllegalClippingException(int paramInt)
  {
    this.reason = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException
 * JD-Core Version:    0.7.0.1
 */