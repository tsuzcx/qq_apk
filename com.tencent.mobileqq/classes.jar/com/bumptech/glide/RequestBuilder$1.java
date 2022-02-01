package com.bumptech.glide;

import com.bumptech.glide.request.RequestFutureTarget;

class RequestBuilder$1
  implements Runnable
{
  public void run()
  {
    if (!this.a.isCancelled())
    {
      RequestBuilder localRequestBuilder = this.this$0;
      RequestFutureTarget localRequestFutureTarget = this.a;
      localRequestBuilder.a(localRequestFutureTarget, localRequestFutureTarget);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.RequestBuilder.1
 * JD-Core Version:    0.7.0.1
 */