package com.google.android.exoplayer2.upstream;

import android.content.Context;

public final class DefaultDataSourceFactory
  implements DataSource.Factory
{
  private final DataSource.Factory baseDataSourceFactory;
  private final Context context;
  private final TransferListener<? super DataSource> listener;
  
  public DefaultDataSourceFactory(Context paramContext, TransferListener<? super DataSource> paramTransferListener, DataSource.Factory paramFactory)
  {
    this.context = paramContext.getApplicationContext();
    this.listener = paramTransferListener;
    this.baseDataSourceFactory = paramFactory;
  }
  
  public DefaultDataSourceFactory(Context paramContext, String paramString)
  {
    this(paramContext, paramString, null);
  }
  
  public DefaultDataSourceFactory(Context paramContext, String paramString, TransferListener<? super DataSource> paramTransferListener)
  {
    this(paramContext, paramTransferListener, new DefaultHttpDataSourceFactory(paramString, paramTransferListener));
  }
  
  public DefaultDataSource createDataSource()
  {
    return new DefaultDataSource(this.context, this.listener, this.baseDataSourceFactory.createDataSource());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */