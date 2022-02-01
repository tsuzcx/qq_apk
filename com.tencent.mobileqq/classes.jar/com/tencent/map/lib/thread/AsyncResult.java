package com.tencent.map.lib.thread;

import android.os.Message;

public class AsyncResult
{
  public Throwable exception;
  public Object result;
  public Object userObj;
  
  public AsyncResult(Object paramObject1, Object paramObject2, Throwable paramThrowable)
  {
    this.userObj = paramObject1;
    this.result = paramObject2;
    this.exception = paramThrowable;
  }
  
  public static AsyncResult forMessage(Message paramMessage)
  {
    AsyncResult localAsyncResult = new AsyncResult(paramMessage.obj, null, null);
    paramMessage.obj = localAsyncResult;
    return localAsyncResult;
  }
  
  public static AsyncResult forMessage(Message paramMessage, Object paramObject, Throwable paramThrowable)
  {
    paramObject = new AsyncResult(paramMessage.obj, paramObject, paramThrowable);
    paramMessage.obj = paramObject;
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncResult
 * JD-Core Version:    0.7.0.1
 */