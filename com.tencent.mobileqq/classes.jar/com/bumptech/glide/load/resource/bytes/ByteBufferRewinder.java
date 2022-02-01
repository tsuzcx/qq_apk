package com.bumptech.glide.load.resource.bytes;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

public class ByteBufferRewinder
  implements DataRewinder<ByteBuffer>
{
  private final ByteBuffer a;
  
  public ByteBufferRewinder(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public void b() {}
  
  @NonNull
  public ByteBuffer c()
  {
    this.a.position(0);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bytes.ByteBufferRewinder
 * JD-Core Version:    0.7.0.1
 */