package com.squareup.okhttp.internal.framed;

import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

class NameValueBlockReader$1
  extends ForwardingSource
{
  NameValueBlockReader$1(NameValueBlockReader paramNameValueBlockReader, Source paramSource)
  {
    super(paramSource);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (NameValueBlockReader.access$000(this.this$0) == 0) {}
    do
    {
      return -1L;
      paramLong = super.read(paramBuffer, Math.min(paramLong, NameValueBlockReader.access$000(this.this$0)));
    } while (paramLong == -1L);
    NameValueBlockReader.access$002(this.this$0, (int)(NameValueBlockReader.access$000(this.this$0) - paramLong));
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.NameValueBlockReader.1
 * JD-Core Version:    0.7.0.1
 */