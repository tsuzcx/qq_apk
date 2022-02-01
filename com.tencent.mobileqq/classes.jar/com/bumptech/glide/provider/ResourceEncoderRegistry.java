package com.bumptech.glide.provider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry
{
  private final List<ResourceEncoderRegistry.Entry<?>> a = new ArrayList();
  
  @Nullable
  public <Z> ResourceEncoder<Z> a(@NonNull Class<Z> paramClass)
  {
    int i = 0;
    try
    {
      int j = this.a.size();
      while (i < j)
      {
        ResourceEncoderRegistry.Entry localEntry = (ResourceEncoderRegistry.Entry)this.a.get(i);
        if (localEntry.a(paramClass))
        {
          paramClass = localEntry.a;
          return paramClass;
        }
        i += 1;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public <Z> void a(@NonNull Class<Z> paramClass, @NonNull ResourceEncoder<Z> paramResourceEncoder)
  {
    try
    {
      this.a.add(new ResourceEncoderRegistry.Entry(paramClass, paramResourceEncoder));
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
 * Qualified Name:     com.bumptech.glide.provider.ResourceEncoderRegistry
 * JD-Core Version:    0.7.0.1
 */