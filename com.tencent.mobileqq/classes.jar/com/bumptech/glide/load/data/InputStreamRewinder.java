package com.bumptech.glide.load.data;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

public final class InputStreamRewinder
  implements DataRewinder<InputStream>
{
  private final RecyclableBufferedInputStream a;
  
  InputStreamRewinder(InputStream paramInputStream, ArrayPool paramArrayPool)
  {
    this.a = new RecyclableBufferedInputStream(paramInputStream, paramArrayPool);
    this.a.mark(5242880);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  @NonNull
  public InputStream c()
  {
    this.a.reset();
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.InputStreamRewinder
 * JD-Core Version:    0.7.0.1
 */