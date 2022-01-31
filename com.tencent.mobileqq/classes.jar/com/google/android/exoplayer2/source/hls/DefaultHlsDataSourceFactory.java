package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource.Factory;

public final class DefaultHlsDataSourceFactory
  implements HlsDataSourceFactory
{
  private final DataSource.Factory dataSourceFactory;
  
  public DefaultHlsDataSourceFactory(DataSource.Factory paramFactory)
  {
    this.dataSourceFactory = paramFactory;
  }
  
  public DataSource createDataSource(int paramInt)
  {
    return this.dataSourceFactory.createDataSource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */