package com.bumptech.glide.request;

import android.support.annotation.VisibleForTesting;

@VisibleForTesting
class RequestFutureTarget$Waiter
{
  void a(Object paramObject)
  {
    paramObject.notifyAll();
  }
  
  void a(Object paramObject, long paramLong)
  {
    paramObject.wait(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.RequestFutureTarget.Waiter
 * JD-Core Version:    0.7.0.1
 */