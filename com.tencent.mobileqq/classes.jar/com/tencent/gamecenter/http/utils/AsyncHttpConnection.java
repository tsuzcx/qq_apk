package com.tencent.gamecenter.http.utils;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class AsyncHttpConnection
  implements Runnable
{
  private String a;
  private int b;
  private Handler c;
  private String d;
  private HttpClient e;
  
  public AsyncHttpConnection(Handler paramHandler)
  {
    this.c = paramHandler;
  }
  
  private void a(HttpEntity paramHttpEntity, int paramInt)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramHttpEntity.getContent()));
    Object localObject1 = new StringBuilder("");
    for (;;)
    {
      localObject2 = localBufferedReader.readLine();
      if (localObject2 == null) {
        break;
      }
      ((StringBuilder)localObject1).append((String)localObject2);
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    long l;
    if (paramHttpEntity.getContentLength() > 0L) {
      l = paramHttpEntity.getContentLength();
    } else {
      l = ((String)localObject1).getBytes().length;
    }
    paramHttpEntity = new String[3];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt);
    paramHttpEntity[0] = ((StringBuilder)localObject2).toString();
    paramHttpEntity[1] = localObject1;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l);
    paramHttpEntity[2] = ((StringBuilder)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("statusCode = ");
      ((StringBuilder)localObject1).append(paramHttpEntity[0]);
      ((StringBuilder)localObject1).append(",result = ");
      ((StringBuilder)localObject1).append(paramHttpEntity[1]);
      ((StringBuilder)localObject1).append("contentLength = ");
      ((StringBuilder)localObject1).append(l);
      QLog.d("GameCenter", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt != 200) && (paramInt != 201)) {
      paramHttpEntity = Message.obtain(this.c, 1, paramHttpEntity);
    } else {
      paramHttpEntity = Message.obtain(this.c, 2, paramHttpEntity);
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      ((Handler)localObject1).sendMessage(paramHttpEntity);
    } else if (QLog.isColorLevel()) {
      QLog.d("GameCenter", 2, "AsyncHttpConnection_processEntity() handler was null.");
    }
    localBufferedReader.close();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.b = paramInt;
    this.a = paramString1;
    this.d = paramString2;
    AsyncHttpConnectionManager.a().a(this);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  public void run()
  {
    Object localObject1 = this.c;
    int j = 0;
    if (localObject1 != null) {
      ((Handler)localObject1).sendMessage(Message.obtain((Handler)localObject1, 0));
    } else if (QLog.isColorLevel()) {
      QLog.d("GameCenter", 2, "AsyncHttpConnection_run() Could not call handler to post DID_START message because it was null.");
    }
    this.e = new DefaultHttpClient();
    HttpConnectionParams.setConnectionTimeout(this.e.getParams(), 20000);
    localObject1 = null;
    int i = j;
    try
    {
      this.a = MsfSdkUtils.insertMtype("GameCenter", this.a);
      i = j;
      if (QLog.isColorLevel())
      {
        i = j;
        localObject2 = new StringBuilder();
        i = j;
        ((StringBuilder)localObject2).append("Http url= ");
        i = j;
        ((StringBuilder)localObject2).append(Util.b(this.a, new String[0]));
        i = j;
        QLog.d("GameCenter", 2, ((StringBuilder)localObject2).toString());
      }
      i = j;
      int k = this.b;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k == 2)
          {
            i = j;
            localObject1 = new HttpPost(this.a);
            i = j;
            ((HttpPost)localObject1).setHeader("Content-Type", "multipart/form-data");
            i = j;
            ((HttpPost)localObject1).setEntity(new StringEntity(this.d, "utf-8"));
            i = j;
            ((HttpPost)localObject1).getParams().setBooleanParameter("http.protocol.expect-continue", false);
            i = j;
            localObject1 = this.e.execute((HttpUriRequest)localObject1);
          }
        }
        else
        {
          i = j;
          localObject1 = new HttpPost(this.a);
          i = j;
          ((HttpPost)localObject1).setHeader("Content-Type", "application/x-www-form-urlencoded");
          i = j;
          ((HttpPost)localObject1).setEntity(new StringEntity(this.d, "utf-8"));
          i = j;
          ((HttpPost)localObject1).getParams().setBooleanParameter("http.protocol.expect-continue", false);
          i = j;
          localObject1 = this.e.execute((HttpUriRequest)localObject1);
        }
      }
      else
      {
        i = j;
        localObject1 = new HttpGet(this.a);
        i = j;
        localObject1 = this.e.execute((HttpUriRequest)localObject1);
      }
      i = j;
      if ((this.b <= 2) && (localObject1 != null))
      {
        i = j;
        j = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
        i = j;
        a(((HttpResponse)localObject1).getEntity(), j);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AsyncHttpConnection_run() statusCode = ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.d("GameCenter", 2, ((StringBuilder)localObject2).toString());
      }
      localException.printStackTrace();
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        Message localMessage = Message.obtain((Handler)localObject2, 1, localException);
        this.c.sendMessage(localMessage);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GameCenter", 2, "AsyncHttpConnection_run() handler post DID_ERROR because it was null.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.http.utils.AsyncHttpConnection
 * JD-Core Version:    0.7.0.1
 */