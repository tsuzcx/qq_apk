package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class InitializationChunk
  extends Chunk
{
  private volatile int bytesLoaded;
  private final ChunkExtractorWrapper extractorWrapper;
  private volatile boolean loadCanceled;
  
  public InitializationChunk(DataSource paramDataSource, DataSpec paramDataSpec, Format paramFormat, int paramInt, Object paramObject, ChunkExtractorWrapper paramChunkExtractorWrapper)
  {
    super(paramDataSource, paramDataSpec, 2, paramFormat, paramInt, paramObject, -9223372036854775807L, -9223372036854775807L);
    this.extractorWrapper = paramChunkExtractorWrapper;
  }
  
  public long bytesLoaded()
  {
    return this.bytesLoaded;
  }
  
  public void cancelLoad()
  {
    this.loadCanceled = true;
  }
  
  public boolean isLoadCanceled()
  {
    return this.loadCanceled;
  }
  
  public void load()
  {
    Object localObject1 = this.dataSpec.subrange(this.bytesLoaded);
    for (;;)
    {
      try
      {
        localObject1 = new DefaultExtractorInput(this.dataSource, ((DataSpec)localObject1).absoluteStreamPosition, this.dataSource.open((DataSpec)localObject1));
        if (this.bytesLoaded == 0) {
          this.extractorWrapper.init(null);
        }
        int i;
        try
        {
          Extractor localExtractor = this.extractorWrapper.extractor;
          i = 0;
          if ((i != 0) || (this.loadCanceled)) {
            break label159;
          }
          i = localExtractor.read((ExtractorInput)localObject1, null);
          continue;
          Assertions.checkState(bool);
          this.bytesLoaded = ((int)(((ExtractorInput)localObject1).getPosition() - this.dataSpec.absoluteStreamPosition));
          return;
        }
        finally
        {
          this.bytesLoaded = ((int)(((ExtractorInput)localObject1).getPosition() - this.dataSpec.absoluteStreamPosition));
        }
        bool = false;
        continue;
        if (i == 1) {
          continue;
        }
      }
      finally
      {
        Util.closeQuietly(this.dataSource);
      }
      label159:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.InitializationChunk
 * JD-Core Version:    0.7.0.1
 */