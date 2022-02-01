package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;

final class ExtractorMediaPeriod$ExtractingLoadable
  implements Loader.Loadable
{
  private long bytesLoaded;
  private final DataSource dataSource;
  private DataSpec dataSpec;
  private final ExtractorMediaPeriod.ExtractorHolder extractorHolder;
  private long length;
  private volatile boolean loadCanceled;
  private final ConditionVariable loadCondition;
  private boolean pendingExtractorSeek;
  private final PositionHolder positionHolder;
  private long seekTimeUs;
  private final Uri uri;
  
  public ExtractorMediaPeriod$ExtractingLoadable(ExtractorMediaPeriod paramExtractorMediaPeriod, Uri paramUri, DataSource paramDataSource, ExtractorMediaPeriod.ExtractorHolder paramExtractorHolder, ConditionVariable paramConditionVariable)
  {
    this.uri = ((Uri)Assertions.checkNotNull(paramUri));
    this.dataSource = ((DataSource)Assertions.checkNotNull(paramDataSource));
    this.extractorHolder = ((ExtractorMediaPeriod.ExtractorHolder)Assertions.checkNotNull(paramExtractorHolder));
    this.loadCondition = paramConditionVariable;
    this.positionHolder = new PositionHolder();
    this.pendingExtractorSeek = true;
    this.length = -1L;
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
    int i = 0;
    DefaultExtractorInput localDefaultExtractorInput;
    for (;;)
    {
      if ((i != 0) || (this.loadCanceled)) {
        return;
      }
      try
      {
        long l = this.positionHolder.position;
        this.dataSpec = new DataSpec(this.uri, l, -1L, ExtractorMediaPeriod.access$800(this.this$0));
        this.length = this.dataSource.open(this.dataSpec);
        if (this.length != -1L) {
          this.length += l;
        }
        localDefaultExtractorInput = new DefaultExtractorInput(this.dataSource, l, this.length);
        int j = i;
        try
        {
          Extractor localExtractor = this.extractorHolder.selectExtractor(localDefaultExtractorInput, this.dataSource.getUri());
          j = i;
          if (this.pendingExtractorSeek)
          {
            j = i;
            localExtractor.seek(l, this.seekTimeUs);
            j = i;
            this.pendingExtractorSeek = false;
          }
          j = i;
          TraceUtil.beginSection("ExtractorRead");
          while (i == 0)
          {
            j = i;
            if (this.loadCanceled) {
              break;
            }
            j = i;
            this.loadCondition.block();
            j = i;
            int k = localExtractor.read(localDefaultExtractorInput, this.positionHolder);
            i = k;
            j = k;
            if (localDefaultExtractorInput.getPosition() > ExtractorMediaPeriod.access$900(this.this$0) + l)
            {
              j = k;
              l = localDefaultExtractorInput.getPosition();
              j = k;
              this.loadCondition.close();
              j = k;
              ExtractorMediaPeriod.access$1100(this.this$0).post(ExtractorMediaPeriod.access$1000(this.this$0));
              i = k;
            }
          }
          j = i;
          TraceUtil.endSection();
          if (i == 1)
          {
            i = 0;
          }
          else
          {
            this.positionHolder.position = localDefaultExtractorInput.getPosition();
            this.bytesLoaded = (this.positionHolder.position - this.dataSpec.absoluteStreamPosition);
          }
          Util.closeQuietly(this.dataSource);
          continue;
        }
        finally
        {
          i = j;
        }
        if (i == 1) {
          break label389;
        }
      }
      finally
      {
        localDefaultExtractorInput = null;
      }
    }
    if (localDefaultExtractorInput != null)
    {
      this.positionHolder.position = localDefaultExtractorInput.getPosition();
      this.bytesLoaded = (this.positionHolder.position - this.dataSpec.absoluteStreamPosition);
    }
    label389:
    Util.closeQuietly(this.dataSource);
    throw localObject2;
  }
  
  public void setLoadPosition(long paramLong1, long paramLong2)
  {
    this.positionHolder.position = paramLong1;
    this.seekTimeUs = paramLong2;
    this.pendingExtractorSeek = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable
 * JD-Core Version:    0.7.0.1
 */