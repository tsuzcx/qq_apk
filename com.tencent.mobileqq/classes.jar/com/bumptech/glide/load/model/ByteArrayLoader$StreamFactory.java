package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import java.io.InputStream;

public class ByteArrayLoader$StreamFactory
  implements ModelLoaderFactory<byte[], InputStream>
{
  @NonNull
  public ModelLoader<byte[], InputStream> a(@NonNull MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new ByteArrayLoader(new ByteArrayLoader.StreamFactory.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory
 * JD-Core Version:    0.7.0.1
 */