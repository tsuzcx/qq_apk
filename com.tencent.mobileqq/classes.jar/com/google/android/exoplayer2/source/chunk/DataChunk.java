package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public abstract class DataChunk
  extends Chunk
{
  private static final int READ_GRANULARITY = 16384;
  private byte[] data;
  private int limit;
  private volatile boolean loadCanceled;
  
  public DataChunk(DataSource paramDataSource, DataSpec paramDataSpec, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, byte[] paramArrayOfByte)
  {
    super(paramDataSource, paramDataSpec, paramInt1, paramFormat, paramInt2, paramObject, -9223372036854775807L, -9223372036854775807L);
    this.data = paramArrayOfByte;
  }
  
  private void maybeExpandData()
  {
    byte[] arrayOfByte = this.data;
    if (arrayOfByte == null)
    {
      this.data = new byte[16384];
      return;
    }
    if (arrayOfByte.length < this.limit + 16384) {
      this.data = Arrays.copyOf(arrayOfByte, arrayOfByte.length + 16384);
    }
  }
  
  public long bytesLoaded()
  {
    return this.limit;
  }
  
  public final void cancelLoad()
  {
    this.loadCanceled = true;
  }
  
  protected abstract void consume(byte[] paramArrayOfByte, int paramInt);
  
  public byte[] getDataHolder()
  {
    return this.data;
  }
  
  public final boolean isLoadCanceled()
  {
    return this.loadCanceled;
  }
  
  public final void load()
  {
    try
    {
      this.dataSource.open(this.dataSpec);
      int i = 0;
      this.limit = 0;
      while ((i != -1) && (!this.loadCanceled))
      {
        maybeExpandData();
        int j = this.dataSource.read(this.data, this.limit, 16384);
        i = j;
        if (j != -1)
        {
          this.limit += j;
          i = j;
        }
      }
      if (!this.loadCanceled) {
        consume(this.data, this.limit);
      }
      Util.closeQuietly(this.dataSource);
      return;
    }
    finally
    {
      Util.closeQuietly(this.dataSource);
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.DataChunk
 * JD-Core Version:    0.7.0.1
 */