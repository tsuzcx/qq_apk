package com.google.android.exoplayer2.upstream;

public final class DefaultHttpDataSourceFactory
  extends HttpDataSource.BaseFactory
{
  private final boolean allowCrossProtocolRedirects;
  private final int connectTimeoutMillis;
  private final TransferListener<? super DataSource> listener;
  private final int readTimeoutMillis;
  private final String userAgent;
  
  public DefaultHttpDataSourceFactory(String paramString)
  {
    this(paramString, null);
  }
  
  public DefaultHttpDataSourceFactory(String paramString, TransferListener<? super DataSource> paramTransferListener)
  {
    this(paramString, paramTransferListener, 8000, 8000, false);
  }
  
  public DefaultHttpDataSourceFactory(String paramString, TransferListener<? super DataSource> paramTransferListener, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.userAgent = paramString;
    this.listener = paramTransferListener;
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
  }
  
  protected DefaultHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties paramRequestProperties)
  {
    return new DefaultHttpDataSource(this.userAgent, null, this.listener, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, paramRequestProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */