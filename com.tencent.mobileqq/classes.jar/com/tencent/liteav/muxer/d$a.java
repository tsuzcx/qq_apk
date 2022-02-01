package com.tencent.liteav.muxer;

import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

class d$a
{
  ByteBuffer a;
  MediaCodec.BufferInfo b;
  
  public d$a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    this.a = paramByteBuffer;
    this.b = paramBufferInfo;
  }
  
  public ByteBuffer a()
  {
    return this.a;
  }
  
  public MediaCodec.BufferInfo b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.muxer.d.a
 * JD-Core Version:    0.7.0.1
 */