package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public class ContainerMediaChunk
  extends BaseMediaChunk
{
  private volatile int bytesLoaded;
  private final int chunkCount;
  private final ChunkExtractorWrapper extractorWrapper;
  private volatile boolean loadCanceled;
  private volatile boolean loadCompleted;
  private final long sampleOffsetUs;
  
  public ContainerMediaChunk(DataSource paramDataSource, DataSpec paramDataSpec, Format paramFormat, int paramInt1, Object paramObject, long paramLong1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, ChunkExtractorWrapper paramChunkExtractorWrapper)
  {
    super(paramDataSource, paramDataSpec, paramFormat, paramInt1, paramObject, paramLong1, paramLong2, paramLong3);
    this.chunkCount = paramInt2;
    this.sampleOffsetUs = paramLong4;
    this.extractorWrapper = paramChunkExtractorWrapper;
  }
  
  public final long bytesLoaded()
  {
    return this.bytesLoaded;
  }
  
  public final void cancelLoad()
  {
    this.loadCanceled = true;
  }
  
  public long getNextChunkIndex()
  {
    return this.chunkIndex + this.chunkCount;
  }
  
  public final boolean isLoadCanceled()
  {
    return this.loadCanceled;
  }
  
  public boolean isLoadCompleted()
  {
    return this.loadCompleted;
  }
  
  public final void load()
  {
    Object localObject1 = this.dataSpec.subrange(this.bytesLoaded);
    for (;;)
    {
      try
      {
        localObject1 = new DefaultExtractorInput(this.dataSource, ((DataSpec)localObject1).absoluteStreamPosition, this.dataSource.open((DataSpec)localObject1));
        if (this.bytesLoaded == 0)
        {
          localObject3 = getOutput();
          ((BaseMediaChunkOutput)localObject3).setSampleOffsetUs(this.sampleOffsetUs);
          this.extractorWrapper.init((ChunkExtractorWrapper.TrackOutputProvider)localObject3);
        }
      }
      finally
      {
        Object localObject3;
        int i;
        Util.closeQuietly(this.dataSource);
        continue;
        throw localObject2;
        continue;
        if (i == 1) {
          continue;
        }
        boolean bool = true;
        continue;
      }
      try
      {
        localObject3 = this.extractorWrapper.extractor;
        bool = false;
        i = 0;
        if ((i == 0) && (!this.loadCanceled))
        {
          i = ((Extractor)localObject3).read((ExtractorInput)localObject1, null);
          continue;
          Assertions.checkState(bool);
          this.bytesLoaded = ((int)(((ExtractorInput)localObject1).getPosition() - this.dataSpec.absoluteStreamPosition));
          Util.closeQuietly(this.dataSource);
          this.loadCompleted = true;
          return;
        }
      }
      finally
      {
        this.bytesLoaded = ((int)(((ExtractorInput)localObject1).getPosition() - this.dataSpec.absoluteStreamPosition));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ContainerMediaChunk
 * JD-Core Version:    0.7.0.1
 */