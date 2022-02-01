package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class DataSourceException
  extends IOException
{
  public static final int POSITION_OUT_OF_RANGE = 0;
  public final int reason;
  
  public DataSourceException(int paramInt)
  {
    this.reason = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DataSourceException
 * JD-Core Version:    0.7.0.1
 */