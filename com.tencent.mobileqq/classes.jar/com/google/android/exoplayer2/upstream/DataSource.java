package com.google.android.exoplayer2.upstream;

import android.net.Uri;

public abstract interface DataSource
{
  public abstract void close();
  
  public abstract Uri getUri();
  
  public abstract long open(DataSpec paramDataSpec);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DataSource
 * JD-Core Version:    0.7.0.1
 */