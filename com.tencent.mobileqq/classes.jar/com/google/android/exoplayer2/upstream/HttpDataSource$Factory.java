package com.google.android.exoplayer2.upstream;

public abstract interface HttpDataSource$Factory
  extends DataSource.Factory
{
  @Deprecated
  public abstract void clearAllDefaultRequestProperties();
  
  @Deprecated
  public abstract void clearDefaultRequestProperty(String paramString);
  
  public abstract HttpDataSource createDataSource();
  
  public abstract HttpDataSource.RequestProperties getDefaultRequestProperties();
  
  @Deprecated
  public abstract void setDefaultRequestProperty(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.HttpDataSource.Factory
 * JD-Core Version:    0.7.0.1
 */