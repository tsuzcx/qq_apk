package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.signature.ObjectKey;

public class ByteArrayLoader<Data>
  implements ModelLoader<byte[], Data>
{
  private final ByteArrayLoader.Converter<Data> a;
  
  public ByteArrayLoader(ByteArrayLoader.Converter<Data> paramConverter)
  {
    this.a = paramConverter;
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new ModelLoader.LoadData(new ObjectKey(paramArrayOfByte), new ByteArrayLoader.Fetcher(paramArrayOfByte, this.a));
  }
  
  public boolean a(@NonNull byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ByteArrayLoader
 * JD-Core Version:    0.7.0.1
 */