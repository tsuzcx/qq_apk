package com.rookery.asyncHttpClient;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class RetryHandler
  implements HttpRequestRetryHandler
{
  private static HashSet<Class<?>> a = new HashSet();
  private static HashSet<Class<?>> b = new HashSet();
  private final int c;
  
  static
  {
    a.add(NoHttpResponseException.class);
    a.add(UnknownHostException.class);
    a.add(SocketException.class);
    b.add(InterruptedIOException.class);
    b.add(SSLException.class);
  }
  
  public RetryHandler(int paramInt)
  {
    this.c = paramInt;
  }
  
  protected boolean a(HashSet<Class<?>> paramHashSet, Throwable paramThrowable)
  {
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext()) {
      if (((Class)paramHashSet.next()).isInstance(paramThrowable)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[retryRequest] exception:");
      ((StringBuilder)localObject).append(paramIOException);
      ((StringBuilder)localObject).append("executionCount:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Translator", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    boolean bool1 = false;
    if (((localObject == null) || (((Boolean)localObject).booleanValue())) || ((paramInt <= this.c) && (!a(b, paramIOException))))
    {
      a(a, paramIOException);
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = ((HttpUriRequest)paramHttpContext.getAttribute("http.request")).getMethod().equals("POST") ^ true;
    }
    if (bool2)
    {
      SystemClock.sleep(1500L);
      return bool2;
    }
    paramIOException.printStackTrace();
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.RetryHandler
 * JD-Core Version:    0.7.0.1
 */