package com.tencent.beacon.core.network.volley;

import java.io.FilterInputStream;
import java.io.InputStream;

class DiskBasedCache$CountingInputStream
  extends FilterInputStream
{
  private long bytesRead;
  private final long length;
  
  DiskBasedCache$CountingInputStream(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.length = paramLong;
  }
  
  long bytesRead()
  {
    return this.bytesRead;
  }
  
  long bytesRemaining()
  {
    return this.length - this.bytesRead;
  }
  
  public int read()
  {
    int i = super.read();
    if (i != -1) {
      this.bytesRead += 1L;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.bytesRead += paramInt1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream
 * JD-Core Version:    0.7.0.1
 */