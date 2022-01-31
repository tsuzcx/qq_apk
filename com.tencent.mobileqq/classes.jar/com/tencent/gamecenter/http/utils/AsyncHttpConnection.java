package com.tencent.gamecenter.http.utils;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import mpw;
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
import yfr;

public class AsyncHttpConnection
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  private String b;
  
  public AsyncHttpConnection(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private void a(HttpEntity paramHttpEntity, int paramInt)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramHttpEntity.getContent()));
    Object localObject = new StringBuilder("");
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
      ((StringBuilder)localObject).append(str);
    }
    localObject = ((StringBuilder)localObject).toString();
    long l;
    if (paramHttpEntity.getContentLength() > 0L)
    {
      l = paramHttpEntity.getContentLength();
      paramHttpEntity = new String[3];
      paramHttpEntity[0] = ("" + paramInt);
      paramHttpEntity[1] = localObject;
      paramHttpEntity[2] = ("" + l);
      if (QLog.isColorLevel()) {
        QLog.d("GameCenter", 2, "statusCode = " + paramHttpEntity[0] + ",result = " + paramHttpEntity[1] + "contentLength = " + l);
      }
      if ((paramInt == 200) || (paramInt == 201)) {
        break label245;
      }
      paramHttpEntity = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramHttpEntity);
      label212:
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break label258;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramHttpEntity);
    }
    for (;;)
    {
      localBufferedReader.close();
      return;
      l = ((String)localObject).getBytes().length;
      break;
      label245:
      paramHttpEntity = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramHttpEntity);
      break label212;
      label258:
      if (QLog.isColorLevel()) {
        QLog.d("GameCenter", 2, "AsyncHttpConnection_processEntity() handler was null.");
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    yfr.a().a(this);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  public void run()
  {
    int j = 0;
    Object localObject;
    int i;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0));
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = new DefaultHttpClient();
      HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), 20000);
      localObject = null;
      i = j;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString);
        i = j;
        if (QLog.isColorLevel())
        {
          i = j;
          QLog.d("GameCenter", 2, "Http url= " + mpw.b(this.jdField_a_of_type_JavaLangString, new String[0]));
        }
        i = j;
        switch (this.jdField_a_of_type_Int)
        {
        case 0: 
          i = j;
          if ((this.jdField_a_of_type_Int <= 2) && (localObject != null))
          {
            i = j;
            j = ((HttpResponse)localObject).getStatusLine().getStatusCode();
            i = j;
            a(((HttpResponse)localObject).getEntity(), j);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GameCenter", 2, "AsyncHttpConnection_run() statusCode = " + i + "," + localException.toString());
        localException.printStackTrace();
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          continue;
        }
        Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, localException);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GameCenter", 2, "AsyncHttpConnection_run() handler post DID_ERROR because it was null.");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GameCenter", 2, "AsyncHttpConnection_run() Could not call handler to post DID_START message because it was null.");
      break;
      i = j;
      localObject = new HttpGet(this.jdField_a_of_type_JavaLangString);
      i = j;
      localObject = this.jdField_a_of_type_OrgApacheHttpClientHttpClient.execute((HttpUriRequest)localObject);
      continue;
      i = j;
      localObject = new HttpPost(this.jdField_a_of_type_JavaLangString);
      i = j;
      ((HttpPost)localObject).setHeader("Content-Type", "application/x-www-form-urlencoded");
      i = j;
      ((HttpPost)localObject).setEntity(new StringEntity(this.b, "utf-8"));
      i = j;
      ((HttpPost)localObject).getParams().setBooleanParameter("http.protocol.expect-continue", false);
      i = j;
      localObject = this.jdField_a_of_type_OrgApacheHttpClientHttpClient.execute((HttpUriRequest)localObject);
      continue;
      i = j;
      localObject = new HttpPost(this.jdField_a_of_type_JavaLangString);
      i = j;
      ((HttpPost)localObject).setHeader("Content-Type", "multipart/form-data");
      i = j;
      ((HttpPost)localObject).setEntity(new StringEntity(this.b, "utf-8"));
      i = j;
      ((HttpPost)localObject).getParams().setBooleanParameter("http.protocol.expect-continue", false);
      i = j;
      localObject = this.jdField_a_of_type_OrgApacheHttpClientHttpClient.execute((HttpUriRequest)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.http.utils.AsyncHttpConnection
 * JD-Core Version:    0.7.0.1
 */