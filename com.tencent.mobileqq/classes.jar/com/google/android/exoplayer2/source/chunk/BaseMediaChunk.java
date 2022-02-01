package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;

public abstract class BaseMediaChunk
  extends MediaChunk
{
  private int[] firstSampleIndices;
  private BaseMediaChunkOutput output;
  
  public BaseMediaChunk(DataSource paramDataSource, DataSpec paramDataSpec, Format paramFormat, int paramInt, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramDataSource, paramDataSpec, paramFormat, paramInt, paramObject, paramLong1, paramLong2, paramLong3);
  }
  
  public final int getFirstSampleIndex(int paramInt)
  {
    return this.firstSampleIndices[paramInt];
  }
  
  protected final BaseMediaChunkOutput getOutput()
  {
    return this.output;
  }
  
  public void init(BaseMediaChunkOutput paramBaseMediaChunkOutput)
  {
    this.output = paramBaseMediaChunkOutput;
    this.firstSampleIndices = paramBaseMediaChunkOutput.getWriteIndices();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.BaseMediaChunk
 * JD-Core Version:    0.7.0.1
 */