package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;

public class PendingResultImpl$a<R extends Result>
  extends Handler
{
  public PendingResultImpl$a()
  {
    this(Looper.getMainLooper());
  }
  
  public PendingResultImpl$a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(ResultCallback<? super R> paramResultCallback, R paramR)
  {
    sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
  }
  
  protected void b(ResultCallback<? super R> paramResultCallback, R paramR)
  {
    paramResultCallback.onResult(paramR);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Pair)paramMessage.obj;
    b((ResultCallback)paramMessage.first, (Result)paramMessage.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl.a
 * JD-Core Version:    0.7.0.1
 */