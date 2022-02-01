package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

final class SingleSampleMediaPeriod$SourceLoadable
  implements Loader.Loadable
{
  private final DataSource dataSource;
  public final DataSpec dataSpec;
  private byte[] sampleData;
  private int sampleSize;
  
  public SingleSampleMediaPeriod$SourceLoadable(DataSpec paramDataSpec, DataSource paramDataSource)
  {
    this.dataSpec = paramDataSpec;
    this.dataSource = paramDataSource;
  }
  
  public void cancelLoad() {}
  
  public boolean isLoadCanceled()
  {
    return false;
  }
  
  public void load()
  {
    int i = 0;
    this.sampleSize = 0;
    try
    {
      this.dataSource.open(this.dataSpec);
      if (i != -1)
      {
        this.sampleSize = (i + this.sampleSize);
        if (this.sampleData == null) {
          this.sampleData = new byte[1024];
        }
        for (;;)
        {
          i = this.dataSource.read(this.sampleData, this.sampleSize, this.sampleData.length - this.sampleSize);
          break;
          if (this.sampleSize == this.sampleData.length) {
            this.sampleData = Arrays.copyOf(this.sampleData, this.sampleData.length * 2);
          }
        }
      }
    }
    finally
    {
      Util.closeQuietly(this.dataSource);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable
 * JD-Core Version:    0.7.0.1
 */