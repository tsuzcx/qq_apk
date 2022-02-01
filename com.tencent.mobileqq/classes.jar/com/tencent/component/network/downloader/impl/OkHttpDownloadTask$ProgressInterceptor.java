package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.module.common.ProgressResponseBody;
import com.tencent.component.network.module.common.ProgressResponseBody.ProgressListener;
import java.net.InetSocketAddress;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;

class OkHttpDownloadTask$ProgressInterceptor
  implements Interceptor
{
  ProgressResponseBody.ProgressListener progressListener;
  
  OkHttpDownloadTask$ProgressInterceptor(OkHttpDownloadTask paramOkHttpDownloadTask, ProgressResponseBody.ProgressListener paramProgressListener)
  {
    this.progressListener = paramProgressListener;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
  {
    Connection localConnection = paramChain.connection();
    if (localConnection != null) {
      OkHttpDownloadTask.access$302(this.this$0, localConnection.route().socketAddress().toString());
    }
    paramChain = paramChain.proceed(paramChain.request());
    return paramChain.newBuilder().body(new ProgressResponseBody(paramChain.body(), this.progressListener)).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.OkHttpDownloadTask.ProgressInterceptor
 * JD-Core Version:    0.7.0.1
 */