package com.bumptech.glide.provider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EncoderRegistry
{
  private final List<EncoderRegistry.Entry<?>> a = new ArrayList();
  
  @Nullable
  public <T> Encoder<T> a(@NonNull Class<T> paramClass)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        EncoderRegistry.Entry localEntry = (EncoderRegistry.Entry)localIterator.next();
        if (localEntry.a(paramClass))
        {
          paramClass = localEntry.a;
          return paramClass;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public <T> void a(@NonNull Class<T> paramClass, @NonNull Encoder<T> paramEncoder)
  {
    try
    {
      this.a.add(new EncoderRegistry.Entry(paramClass, paramEncoder));
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.provider.EncoderRegistry
 * JD-Core Version:    0.7.0.1
 */