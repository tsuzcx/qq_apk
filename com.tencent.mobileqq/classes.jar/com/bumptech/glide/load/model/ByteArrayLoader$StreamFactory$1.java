package com.bumptech.glide.load.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class ByteArrayLoader$StreamFactory$1
  implements ByteArrayLoader.Converter<InputStream>
{
  ByteArrayLoader$StreamFactory$1(ByteArrayLoader.StreamFactory paramStreamFactory) {}
  
  public InputStream a(byte[] paramArrayOfByte)
  {
    return new ByteArrayInputStream(paramArrayOfByte);
  }
  
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory.1
 * JD-Core Version:    0.7.0.1
 */