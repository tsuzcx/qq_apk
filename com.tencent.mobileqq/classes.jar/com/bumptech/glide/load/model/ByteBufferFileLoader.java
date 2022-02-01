package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader
  implements ModelLoader<File, ByteBuffer>
{
  public ModelLoader.LoadData<ByteBuffer> a(@NonNull File paramFile, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new ModelLoader.LoadData(new ObjectKey(paramFile), new ByteBufferFileLoader.ByteBufferFetcher(paramFile));
  }
  
  public boolean a(@NonNull File paramFile)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ByteBufferFileLoader
 * JD-Core Version:    0.7.0.1
 */