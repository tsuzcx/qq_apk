package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import java.io.InputStream;

public final class DataUrlLoader$StreamFactory<Model>
  implements ModelLoaderFactory<Model, InputStream>
{
  private final DataUrlLoader.DataDecoder<InputStream> a = new DataUrlLoader.StreamFactory.1(this);
  
  @NonNull
  public ModelLoader<Model, InputStream> a(@NonNull MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new DataUrlLoader(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.DataUrlLoader.StreamFactory
 * JD-Core Version:    0.7.0.1
 */