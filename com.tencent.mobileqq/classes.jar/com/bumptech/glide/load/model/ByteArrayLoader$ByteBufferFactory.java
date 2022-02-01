package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import java.nio.ByteBuffer;

public class ByteArrayLoader$ByteBufferFactory
  implements ModelLoaderFactory<byte[], ByteBuffer>
{
  @NonNull
  public ModelLoader<byte[], ByteBuffer> a(@NonNull MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new ByteArrayLoader(new ByteArrayLoader.ByteBufferFactory.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory
 * JD-Core Version:    0.7.0.1
 */