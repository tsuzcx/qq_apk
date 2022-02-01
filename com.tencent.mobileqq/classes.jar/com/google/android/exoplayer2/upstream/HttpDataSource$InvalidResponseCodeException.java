package com.google.android.exoplayer2.upstream;

import java.util.List;
import java.util.Map;

public final class HttpDataSource$InvalidResponseCodeException
  extends HttpDataSource.HttpDataSourceException
{
  public final Map<String, List<String>> headerFields;
  public final int responseCode;
  
  public HttpDataSource$InvalidResponseCodeException(int paramInt, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
  {
    super(localStringBuilder.toString(), paramDataSpec, 1);
    this.responseCode = paramInt;
    this.headerFields = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException
 * JD-Core Version:    0.7.0.1
 */