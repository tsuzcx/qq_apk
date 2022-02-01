package com.tencent.component.network.module.common;

import okhttp3.ResponseBody;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

class ProgressResponseBody$1
  extends ForwardingSource
{
  long totalBytesRead = 0L;
  
  ProgressResponseBody$1(ProgressResponseBody paramProgressResponseBody, Source paramSource)
  {
    super(paramSource);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    long l1 = super.read(paramBuffer, paramLong);
    long l2 = this.totalBytesRead;
    if (l1 != -1L) {
      paramLong = l1;
    } else {
      paramLong = 0L;
    }
    this.totalBytesRead = (l2 + paramLong);
    if (ProgressResponseBody.access$000(this.this$0) != null)
    {
      paramBuffer = ProgressResponseBody.access$000(this.this$0);
      paramLong = this.totalBytesRead;
      l2 = ProgressResponseBody.access$100(this.this$0).contentLength();
      boolean bool;
      if (l1 == -1L) {
        bool = true;
      } else {
        bool = false;
      }
      paramBuffer.update(paramLong, l2, bool);
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.ProgressResponseBody.1
 * JD-Core Version:    0.7.0.1
 */