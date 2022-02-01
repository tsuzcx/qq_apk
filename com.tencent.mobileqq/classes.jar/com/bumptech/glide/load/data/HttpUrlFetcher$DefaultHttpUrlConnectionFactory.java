package com.bumptech.glide.load.data;

import java.net.HttpURLConnection;
import java.net.URL;

class HttpUrlFetcher$DefaultHttpUrlConnectionFactory
  implements HttpUrlFetcher.HttpUrlConnectionFactory
{
  public HttpURLConnection a(URL paramURL)
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.HttpUrlFetcher.DefaultHttpUrlConnectionFactory
 * JD-Core Version:    0.7.0.1
 */