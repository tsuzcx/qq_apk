package android.net.http;

import android.content.Context;
import android.net.compatibility.WebAddress;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.HttpHost;

public class RequestQueue
  implements RequestFeeder
{
  public RequestQueue(Context paramContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public RequestQueue(Context paramContext, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void disablePlatformNotifications()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void enablePlatformNotifications()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public HttpHost getProxyHost()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Request getRequest()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public Request getRequest(HttpHost paramHttpHost)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public boolean haveRequest(HttpHost paramHttpHost)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public RequestHandle queueRequest(String paramString1, WebAddress paramWebAddress, String paramString2, Map<String, String> paramMap, EventHandler paramEventHandler, InputStream paramInputStream, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public RequestHandle queueRequest(String paramString1, String paramString2, Map<String, String> paramMap, EventHandler paramEventHandler, InputStream paramInputStream, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void queueRequest(Request paramRequest, boolean paramBoolean)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public RequestHandle queueSynchronousRequest(String paramString1, WebAddress paramWebAddress, String paramString2, Map<String, String> paramMap, EventHandler paramEventHandler, InputStream paramInputStream, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void requeueRequest(Request paramRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void shutdown()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void startTiming()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void stopTiming()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.net.http.RequestQueue
 * JD-Core Version:    0.7.0.1
 */