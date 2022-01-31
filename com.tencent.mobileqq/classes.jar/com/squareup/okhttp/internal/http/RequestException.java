package com.squareup.okhttp.internal.http;

import java.io.IOException;

public final class RequestException
  extends Exception
{
  public RequestException(IOException paramIOException)
  {
    super(paramIOException);
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.RequestException
 * JD-Core Version:    0.7.0.1
 */