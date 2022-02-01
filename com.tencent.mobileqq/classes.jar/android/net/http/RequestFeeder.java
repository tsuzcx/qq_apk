package android.net.http;

import org.apache.http.HttpHost;

abstract interface RequestFeeder
{
  public abstract Request getRequest();
  
  public abstract Request getRequest(HttpHost paramHttpHost);
  
  public abstract boolean haveRequest(HttpHost paramHttpHost);
  
  public abstract void requeueRequest(Request paramRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.net.http.RequestFeeder
 * JD-Core Version:    0.7.0.1
 */