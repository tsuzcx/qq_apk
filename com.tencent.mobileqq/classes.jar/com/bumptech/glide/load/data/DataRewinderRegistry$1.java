package com.bumptech.glide.load.data;

import android.support.annotation.NonNull;

class DataRewinderRegistry$1
  implements DataRewinder.Factory<Object>
{
  @NonNull
  public DataRewinder<Object> a(@NonNull Object paramObject)
  {
    return new DataRewinderRegistry.DefaultRewinder(paramObject);
  }
  
  @NonNull
  public Class<Object> a()
  {
    throw new UnsupportedOperationException("Not implemented");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.DataRewinderRegistry.1
 * JD-Core Version:    0.7.0.1
 */