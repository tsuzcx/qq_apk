package com.rookery.asyncHttpClient;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class AsyncHttpResponseHandler
{
  private Handler a;
  
  public AsyncHttpResponseHandler()
  {
    if (Looper.myLooper() != null) {
      this.a = new AsyncHttpResponseHandler.1(this);
    }
  }
  
  protected Message a(int paramInt, Object paramObject)
  {
    if (this.a != null) {
      return this.a.obtainMessage(paramInt, paramObject);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  public void a() {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString) {}
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (Object[])paramMessage.obj;
      c(((Integer)paramMessage[0]).intValue(), (Header[])paramMessage[1], (String)paramMessage[2]);
      return;
    case 1: 
      paramMessage = (Object[])paramMessage.obj;
      c((Throwable)paramMessage[0], (String)paramMessage[1]);
      return;
    case 2: 
      a();
      return;
    }
    b();
  }
  
  public void a(Throwable paramThrowable, String paramString) {}
  
  protected void a(Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    b(a(1, new Object[] { paramThrowable, paramArrayOfByte }));
  }
  
  void a(HttpResponse paramHttpResponse)
  {
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    try
    {
      localObject = paramHttpResponse.getEntity();
      if (localObject == null) {
        break label79;
      }
      localObject = EntityUtils.toString(new BufferedHttpEntity((HttpEntity)localObject), "UTF-8");
    }
    catch (IOException localIOException)
    {
      label79:
      String str;
      for (;;)
      {
        Object localObject;
        b(localIOException, (String)null);
        str = "";
      }
      b(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), str);
    }
    if (localStatusLine.getStatusCode() >= 300)
    {
      b(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()), (String)localObject);
      return;
    }
  }
  
  public void b() {}
  
  protected void b(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    b(a(0, new Object[] { new Integer(paramInt), paramArrayOfHeader, paramString }));
  }
  
  protected void b(Message paramMessage)
  {
    if (this.a != null)
    {
      this.a.sendMessage(paramMessage);
      return;
    }
    a(paramMessage);
  }
  
  protected void b(Throwable paramThrowable, String paramString)
  {
    b(a(1, new Object[] { paramThrowable, paramString }));
  }
  
  protected void c()
  {
    b(a(2, null));
  }
  
  protected void c(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    a(paramInt, paramArrayOfHeader, paramString);
  }
  
  protected void c(Throwable paramThrowable, String paramString)
  {
    a(paramThrowable, paramString);
  }
  
  protected void d()
  {
    b(a(3, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.AsyncHttpResponseHandler
 * JD-Core Version:    0.7.0.1
 */