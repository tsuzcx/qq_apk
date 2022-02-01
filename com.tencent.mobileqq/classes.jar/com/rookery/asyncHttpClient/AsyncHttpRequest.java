package com.rookery.asyncHttpClient;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

class AsyncHttpRequest
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final AsyncHttpResponseHandler jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler;
  private final HttpUriRequest jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest;
  private final AbstractHttpClient jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient;
  private final HttpContext jdField_a_of_type_OrgApacheHttpProtocolHttpContext;
  private boolean jdField_a_of_type_Boolean;
  
  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient = paramAbstractHttpClient;
    this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext = paramHttpContext;
    this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest = paramHttpUriRequest;
    this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler = paramAsyncHttpResponseHandler;
  }
  
  private void a()
  {
    if (!Thread.currentThread().isInterrupted()) {
      try
      {
        HttpResponse localHttpResponse = this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient.execute(this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
        if ((!Thread.currentThread().isInterrupted()) && (this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler != null))
        {
          this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler.a(localHttpResponse);
          return;
        }
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[makeRequest]IOException:");
          localStringBuilder.append(localIOException);
          QLog.e("Translator", 2, localStringBuilder.toString());
        }
        if (Thread.currentThread().isInterrupted()) {
          return;
        }
        throw localIOException;
      }
    }
  }
  
  private void b()
  {
    Object localObject2 = this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient.getHttpRequestRetryHandler();
    Object localObject1 = null;
    boolean bool = true;
    while (bool) {
      try
      {
        a();
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("[makeRequestWithRetries]NullPointerException:");
          localStringBuilder2.append(localNullPointerException);
          QLog.e("Translator", 2, localStringBuilder2.toString());
        }
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("NPE in HttpClient");
        localStringBuilder2.append(localNullPointerException.getMessage());
        IOException localIOException1 = new IOException(localStringBuilder2.toString());
        i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        bool = ((HttpRequestRetryHandler)localObject2).retryRequest(localIOException1, i, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
      }
      catch (IOException localIOException2)
      {
        StringBuilder localStringBuilder2;
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("[makeRequestWithRetries]IOException:");
          localStringBuilder2.append(localIOException2);
          QLog.e("Translator", 2, localStringBuilder2.toString());
        }
        int i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        bool = ((HttpRequestRetryHandler)localObject2).retryRequest(localIOException2, i, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        localObject2 = this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler;
        if (localObject2 != null) {
          ((AsyncHttpResponseHandler)localObject2).b(localSocketTimeoutException, "socket time out");
        }
        return;
      }
      catch (SocketException localSocketException)
      {
        localObject2 = this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler;
        if (localObject2 != null) {
          ((AsyncHttpResponseHandler)localObject2).b(localSocketException, "can't resolve host");
        }
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        localObject2 = this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler;
        if (localObject2 != null) {
          ((AsyncHttpResponseHandler)localObject2).b(localUnknownHostException, "can't resolve host");
        }
        return;
      }
    }
    localObject2 = new ConnectException();
    ((ConnectException)localObject2).initCause(localUnknownHostException);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[makeRequestWithRetries] end function. Execption:");
      localStringBuilder1.append(localObject2);
      QLog.e("Translator", 2, localStringBuilder1.toString());
    }
    for (;;)
    {
      throw ((Throwable)localObject2);
    }
  }
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler != null) {
        this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler.c();
      }
      b();
      if (this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler != null)
      {
        this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler.d();
        return;
      }
    }
    catch (IOException localIOException)
    {
      AsyncHttpResponseHandler localAsyncHttpResponseHandler = this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler;
      if (localAsyncHttpResponseHandler != null)
      {
        localAsyncHttpResponseHandler.d();
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler.a(localIOException, (byte[])null);
          return;
        }
        this.jdField_a_of_type_ComRookeryAsyncHttpClientAsyncHttpResponseHandler.b(localIOException, (String)null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.AsyncHttpRequest
 * JD-Core Version:    0.7.0.1
 */