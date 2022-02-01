package com.tencent.beacon.core.network.volley;

import java.io.FilterInputStream;
import java.net.HttpURLConnection;

class HurlStack$UrlConnectionInputStream
  extends FilterInputStream
{
  private final HttpURLConnection mConnection;
  
  HurlStack$UrlConnectionInputStream(HttpURLConnection paramHttpURLConnection)
  {
    super(HurlStack.access$000(paramHttpURLConnection));
    this.mConnection = paramHttpURLConnection;
  }
  
  public void close()
  {
    super.close();
    this.mConnection.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.HurlStack.UrlConnectionInputStream
 * JD-Core Version:    0.7.0.1
 */