package com.bumptech.glide.load.data;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public final class InputStreamRewinder$Factory
  implements DataRewinder.Factory<InputStream>
{
  private final ArrayPool a;
  
  public InputStreamRewinder$Factory(ArrayPool paramArrayPool)
  {
    this.a = paramArrayPool;
  }
  
  @NonNull
  public DataRewinder<InputStream> a(InputStream paramInputStream)
  {
    return new InputStreamRewinder(paramInputStream, this.a);
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.InputStreamRewinder.Factory
 * JD-Core Version:    0.7.0.1
 */