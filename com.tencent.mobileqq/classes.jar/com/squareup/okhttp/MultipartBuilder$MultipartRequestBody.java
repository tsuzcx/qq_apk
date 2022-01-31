package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

final class MultipartBuilder$MultipartRequestBody
  extends RequestBody
{
  private final ByteString boundary;
  private long contentLength = -1L;
  private final MediaType contentType;
  private final List<RequestBody> partBodies;
  private final List<Headers> partHeaders;
  
  public MultipartBuilder$MultipartRequestBody(MediaType paramMediaType, ByteString paramByteString, List<Headers> paramList, List<RequestBody> paramList1)
  {
    if (paramMediaType == null) {
      throw new NullPointerException("type == null");
    }
    this.boundary = paramByteString;
    this.contentType = MediaType.parse(paramMediaType + "; boundary=" + paramByteString.utf8());
    this.partHeaders = Util.immutableList(paramList);
    this.partBodies = Util.immutableList(paramList1);
  }
  
  private long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    long l1 = 0L;
    if (paramBoolean) {
      paramBufferedSink = new Buffer();
    }
    for (BufferedSink localBufferedSink = paramBufferedSink;; localBufferedSink = null)
    {
      int k = this.partHeaders.size();
      int i = 0;
      if (i < k)
      {
        Object localObject = (Headers)this.partHeaders.get(i);
        RequestBody localRequestBody = (RequestBody)this.partBodies.get(i);
        paramBufferedSink.write(MultipartBuilder.access$000());
        paramBufferedSink.write(this.boundary);
        paramBufferedSink.write(MultipartBuilder.access$100());
        if (localObject != null)
        {
          int j = 0;
          int m = ((Headers)localObject).size();
          while (j < m)
          {
            paramBufferedSink.writeUtf8(((Headers)localObject).name(j)).write(MultipartBuilder.access$200()).writeUtf8(((Headers)localObject).value(j)).write(MultipartBuilder.access$100());
            j += 1;
          }
        }
        localObject = localRequestBody.contentType();
        if (localObject != null) {
          paramBufferedSink.writeUtf8("Content-Type: ").writeUtf8(((MediaType)localObject).toString()).write(MultipartBuilder.access$100());
        }
        l2 = localRequestBody.contentLength();
        if (l2 != -1L) {
          paramBufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l2).write(MultipartBuilder.access$100());
        }
        while (!paramBoolean)
        {
          paramBufferedSink.write(MultipartBuilder.access$100());
          if (!paramBoolean) {
            break label305;
          }
          l1 = l2 + l1;
          paramBufferedSink.write(MultipartBuilder.access$100());
          i += 1;
          break;
        }
        localBufferedSink.clear();
        l2 = -1L;
      }
      label305:
      do
      {
        return l2;
        ((RequestBody)this.partBodies.get(i)).writeTo(paramBufferedSink);
        break;
        paramBufferedSink.write(MultipartBuilder.access$000());
        paramBufferedSink.write(this.boundary);
        paramBufferedSink.write(MultipartBuilder.access$000());
        paramBufferedSink.write(MultipartBuilder.access$100());
        l2 = l1;
      } while (!paramBoolean);
      long l2 = localBufferedSink.size();
      localBufferedSink.clear();
      return l1 + l2;
    }
  }
  
  public long contentLength()
  {
    long l = this.contentLength;
    if (l != -1L) {
      return l;
    }
    l = writeOrCountBytes(null, true);
    this.contentLength = l;
    return l;
  }
  
  public MediaType contentType()
  {
    return this.contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.MultipartBuilder.MultipartRequestBody
 * JD-Core Version:    0.7.0.1
 */