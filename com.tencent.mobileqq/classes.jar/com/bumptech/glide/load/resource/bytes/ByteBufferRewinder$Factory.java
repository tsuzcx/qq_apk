package com.bumptech.glide.load.resource.bytes;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinder.Factory;
import java.nio.ByteBuffer;

public class ByteBufferRewinder$Factory
  implements DataRewinder.Factory<ByteBuffer>
{
  @NonNull
  public DataRewinder<ByteBuffer> a(ByteBuffer paramByteBuffer)
  {
    return new ByteBufferRewinder(paramByteBuffer);
  }
  
  @NonNull
  public Class<ByteBuffer> a()
  {
    return ByteBuffer.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bytes.ByteBufferRewinder.Factory
 * JD-Core Version:    0.7.0.1
 */