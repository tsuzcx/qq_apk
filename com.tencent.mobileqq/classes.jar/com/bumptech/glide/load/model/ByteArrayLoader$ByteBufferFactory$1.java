package com.bumptech.glide.load.model;

import java.nio.ByteBuffer;

class ByteArrayLoader$ByteBufferFactory$1
  implements ByteArrayLoader.Converter<ByteBuffer>
{
  ByteArrayLoader$ByteBufferFactory$1(ByteArrayLoader.ByteBufferFactory paramByteBufferFactory) {}
  
  public Class<ByteBuffer> a()
  {
    return ByteBuffer.class;
  }
  
  public ByteBuffer a(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory.1
 * JD-Core Version:    0.7.0.1
 */