package android.net.http;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.StatusLine;
import org.apache.http.params.HttpParams;

public class AndroidHttpClientConnection
  implements HttpConnection, HttpInetConnection
{
  public AndroidHttpClientConnection()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void bind(Socket paramSocket, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void close()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void doFlush()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void flush()
  {
    throw new RuntimeException("Stub!");
  }
  
  public InetAddress getLocalAddress()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getLocalPort()
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    throw new RuntimeException("Stub!");
  }
  
  public InetAddress getRemoteAddress()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getRemotePort()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getSocketTimeout()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isOpen()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isStale()
  {
    throw new RuntimeException("Stub!");
  }
  
  public StatusLine parseResponseHeader(Headers paramHeaders)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpEntity receiveResponseEntity(Headers paramHeaders)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void sendRequestHeader(HttpRequest paramHttpRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setSocketTimeout(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void shutdown()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String toString()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.net.http.AndroidHttpClientConnection
 * JD-Core Version:    0.7.0.1
 */