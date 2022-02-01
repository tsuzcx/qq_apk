package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import java.io.File;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader$Factory
  implements ModelLoaderFactory<File, ByteBuffer>
{
  @NonNull
  public ModelLoader<File, ByteBuffer> a(@NonNull MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new ByteBufferFileLoader();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ByteBufferFileLoader.Factory
 * JD-Core Version:    0.7.0.1
 */