package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.ResultCallback;

class ErrorResultImpl$a
  implements Runnable
{
  ErrorResultImpl$a(ErrorResultImpl paramErrorResultImpl, ResultCallback paramResultCallback) {}
  
  public void run()
  {
    ResultCallback localResultCallback = this.a;
    ErrorResultImpl localErrorResultImpl = this.b;
    localResultCallback.onResult(ErrorResultImpl.a(localErrorResultImpl, ErrorResultImpl.a(localErrorResultImpl)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.ErrorResultImpl.a
 * JD-Core Version:    0.7.0.1
 */