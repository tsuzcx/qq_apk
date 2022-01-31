package com.rookery.asyncHttpClient;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import lcl;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final lcl jdField_a_of_type_Lcl;
  private final HttpUriRequest jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest;
  private final AbstractHttpClient jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient;
  private final HttpContext jdField_a_of_type_OrgApacheHttpProtocolHttpContext;
  private boolean jdField_a_of_type_Boolean;
  
  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, lcl paramlcl)
  {
    this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient = paramAbstractHttpClient;
    this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext = paramHttpContext;
    this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest = paramHttpUriRequest;
    this.jdField_a_of_type_Lcl = paramlcl;
  }
  
  private void a()
  {
    if (!Thread.currentThread().isInterrupted()) {}
    try
    {
      HttpResponse localHttpResponse = this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient.execute(this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
      if ((!Thread.currentThread().isInterrupted()) && (this.jdField_a_of_type_Lcl != null)) {
        this.jdField_a_of_type_Lcl.a(localHttpResponse);
      }
      return;
    }
    catch (IOException localIOException)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[makeRequest]IOException:" + localIOException);
        }
      } while (Thread.currentThread().isInterrupted());
      throw localIOException;
    }
  }
  
  private void b()
  {
    boolean bool = true;
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient.getHttpRequestRetryHandler();
    IOException localIOException2;
    while (bool) {
      try
      {
        a();
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        while (this.jdField_a_of_type_Lcl == null) {}
        this.jdField_a_of_type_Lcl.b(localUnknownHostException, "can't resolve host");
        return;
      }
      catch (SocketException localSocketException)
      {
        while (this.jdField_a_of_type_Lcl == null) {}
        this.jdField_a_of_type_Lcl.b(localSocketException, "can't resolve host");
        return;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        while (this.jdField_a_of_type_Lcl == null) {}
        this.jdField_a_of_type_Lcl.b(localSocketTimeoutException, "socket time out");
        return;
      }
      catch (IOException localIOException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[makeRequestWithRetries]IOException:" + localIOException1);
        }
        i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        bool = ((HttpRequestRetryHandler)localObject2).retryRequest(localIOException1, i, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[makeRequestWithRetries]NullPointerException:" + localNullPointerException);
        }
        localIOException2 = new IOException("NPE in HttpClient" + localNullPointerException.getMessage());
        int i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        bool = ((HttpRequestRetryHandler)localObject2).retryRequest(localIOException2, i, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
      }
    }
    localObject2 = new ConnectException();
    ((ConnectException)localObject2).initCause(localIOException2);
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "[makeRequestWithRetries] end function. Execption:" + localObject2);
    }
    throw ((Throwable)localObject2);
  }
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Lcl != null) {
        this.jdField_a_of_type_Lcl.c();
      }
      b();
      if (this.jdField_a_of_type_Lcl != null) {
        this.jdField_a_of_type_Lcl.d();
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (this.jdField_a_of_type_Lcl == null) {}
      this.jdField_a_of_type_Lcl.d();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Lcl.a(localIOException, (byte[])null);
        return;
      }
      this.jdField_a_of_type_Lcl.b(localIOException, (String)null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.rookery.asyncHttpClient.AsyncHttpRequest
 * JD-Core Version:    0.7.0.1
 */