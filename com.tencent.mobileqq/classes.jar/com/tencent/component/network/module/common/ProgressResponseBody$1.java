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
    if (l1 != -1L)
    {
      paramLong = l1;
      this.totalBytesRead = (paramLong + l2);
      if (ProgressResponseBody.access$000(this.this$0) != null)
      {
        paramBuffer = ProgressResponseBody.access$000(this.this$0);
        paramLong = this.totalBytesRead;
        l2 = ProgressResponseBody.access$100(this.this$0).contentLength();
        if (l1 != -1L) {
          break label100;
        }
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      paramBuffer.update(paramLong, l2, bool);
      return l1;
      paramLong = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.module.common.ProgressResponseBody.1
 * JD-Core Version:    0.7.0.1
 */