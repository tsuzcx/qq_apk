package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import java.io.File;

class DataCacheWriter<DataType>
  implements DiskCache.Writer
{
  private final Encoder<DataType> a;
  private final DataType b;
  private final Options c;
  
  DataCacheWriter(Encoder<DataType> paramEncoder, DataType paramDataType, Options paramOptions)
  {
    this.a = paramEncoder;
    this.b = paramDataType;
    this.c = paramOptions;
  }
  
  public boolean a(@NonNull File paramFile)
  {
    return this.a.a(this.b, paramFile, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DataCacheWriter
 * JD-Core Version:    0.7.0.1
 */