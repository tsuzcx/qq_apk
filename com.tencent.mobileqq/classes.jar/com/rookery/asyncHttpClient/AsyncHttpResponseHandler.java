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
    Object localObject = this.a;
    if (localObject != null) {
      return ((Handler)localObject).obtainMessage(paramInt, paramObject);
    }
    localObject = Message.obtain();
    ((Message)localObject).what = paramInt;
    ((Message)localObject).obj = paramObject;
    return localObject;
  }
  
  public void a() {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString) {}
  
  protected void a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          b();
          return;
        }
        a();
        return;
      }
      paramMessage = (Object[])paramMessage.obj;
      c((Throwable)paramMessage[0], (String)paramMessage[1]);
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    c(((Integer)paramMessage[0]).intValue(), (Header[])paramMessage[1], (String)paramMessage[2]);
  }
  
  public void a(Throwable paramThrowable, String paramString) {}
  
  protected void a(Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    b(a(1, new Object[] { paramThrowable, paramArrayOfByte }));
  }
  
  void a(HttpResponse paramHttpResponse)
  {
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    String str3 = "";
    String str2;
    try
    {
      HttpEntity localHttpEntity = paramHttpResponse.getEntity();
      String str1 = str3;
      if (localHttpEntity != null) {
        str1 = EntityUtils.toString(new BufferedHttpEntity(localHttpEntity), "UTF-8");
      }
    }
    catch (IOException localIOException)
    {
      b(localIOException, (String)null);
      str2 = str3;
    }
    if (localStatusLine.getStatusCode() >= 300)
    {
      b(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()), str2);
      return;
    }
    b(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), str2);
  }
  
  public void b() {}
  
  protected void b(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    b(a(0, new Object[] { new Integer(paramInt), paramArrayOfHeader, paramString }));
  }
  
  protected void b(Message paramMessage)
  {
    Handler localHandler = this.a;
    if (localHandler != null)
    {
      localHandler.sendMessage(paramMessage);
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