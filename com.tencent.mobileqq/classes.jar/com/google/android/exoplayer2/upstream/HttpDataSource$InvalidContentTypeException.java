package com.google.android.exoplayer2.upstream;

public final class HttpDataSource$InvalidContentTypeException
  extends HttpDataSource.HttpDataSourceException
{
  public final String contentType;
  
  public HttpDataSource$InvalidContentTypeException(String paramString, DataSpec paramDataSpec)
  {
    super("Invalid content type: " + paramString, paramDataSpec, 1);
    this.contentType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException
 * JD-Core Version:    0.7.0.1
 */