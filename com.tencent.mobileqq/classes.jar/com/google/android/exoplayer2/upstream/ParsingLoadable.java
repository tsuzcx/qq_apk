package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Util;

public final class ParsingLoadable<T>
  implements Loader.Loadable
{
  private volatile long bytesLoaded;
  private final DataSource dataSource;
  public final DataSpec dataSpec;
  private volatile boolean isCanceled;
  private final ParsingLoadable.Parser<? extends T> parser;
  private volatile T result;
  public final int type;
  
  public ParsingLoadable(DataSource paramDataSource, Uri paramUri, int paramInt, ParsingLoadable.Parser<? extends T> paramParser)
  {
    this(paramDataSource, new DataSpec(paramUri, 3), paramInt, paramParser);
  }
  
  public ParsingLoadable(DataSource paramDataSource, DataSpec paramDataSpec, int paramInt, ParsingLoadable.Parser<? extends T> paramParser)
  {
    this.dataSource = paramDataSource;
    this.dataSpec = paramDataSpec;
    this.type = paramInt;
    this.parser = paramParser;
  }
  
  public long bytesLoaded()
  {
    return this.bytesLoaded;
  }
  
  public final void cancelLoad()
  {
    this.isCanceled = true;
  }
  
  public final T getResult()
  {
    return this.result;
  }
  
  public final boolean isLoadCanceled()
  {
    return this.isCanceled;
  }
  
  public final void load()
  {
    DataSourceInputStream localDataSourceInputStream = new DataSourceInputStream(this.dataSource, this.dataSpec);
    try
    {
      localDataSourceInputStream.open();
      this.result = this.parser.parse(this.dataSource.getUri(), localDataSourceInputStream);
      return;
    }
    finally
    {
      this.bytesLoaded = localDataSourceInputStream.bytesRead();
      Util.closeQuietly(localDataSourceInputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.ParsingLoadable
 * JD-Core Version:    0.7.0.1
 */