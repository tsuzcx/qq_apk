package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode>
{
  private final Class<DataType> a;
  private final List<? extends ResourceDecoder<DataType, ResourceType>> b;
  private final ResourceTranscoder<ResourceType, Transcode> c;
  private final Pools.Pool<List<Throwable>> d;
  private final String e;
  
  public DecodePath(Class<DataType> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<? extends ResourceDecoder<DataType, ResourceType>> paramList, ResourceTranscoder<ResourceType, Transcode> paramResourceTranscoder, Pools.Pool<List<Throwable>> paramPool)
  {
    this.a = paramClass;
    this.b = paramList;
    this.c = paramResourceTranscoder;
    this.d = paramPool;
    paramList = new StringBuilder();
    paramList.append("Failed DecodePath{");
    paramList.append(paramClass.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass1.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass2.getSimpleName());
    paramList.append("}");
    this.e = paramList.toString();
  }
  
  @NonNull
  private Resource<ResourceType> a(DataRewinder<DataType> paramDataRewinder, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    List localList = (List)Preconditions.a(this.d.acquire());
    try
    {
      paramDataRewinder = a(paramDataRewinder, paramInt1, paramInt2, paramOptions, localList);
      return paramDataRewinder;
    }
    finally
    {
      this.d.release(localList);
    }
  }
  
  @NonNull
  private Resource<ResourceType> a(DataRewinder<DataType> paramDataRewinder, int paramInt1, int paramInt2, @NonNull Options paramOptions, List<Throwable> paramList)
  {
    int j = this.b.size();
    Object localObject1 = null;
    int i = 0;
    Object localObject3;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      ResourceDecoder localResourceDecoder = (ResourceDecoder)this.b.get(i);
      localObject2 = localObject1;
      try
      {
        if (!localResourceDecoder.a(paramDataRewinder.a(), paramOptions)) {
          break label161;
        }
        localObject2 = localResourceDecoder.a(paramDataRewinder.a(), paramInt1, paramInt2, paramOptions);
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}catch (RuntimeException localRuntimeException) {}catch (IOException localIOException) {}
      if (Log.isLoggable("DecodePath", 2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to decode data for ");
        localStringBuilder.append(localResourceDecoder);
        Log.v("DecodePath", localStringBuilder.toString(), localIOException);
      }
      paramList.add(localIOException);
      localObject3 = localObject1;
      label161:
      if (localObject3 != null) {
        break;
      }
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject3 != null) {
      return localObject3;
    }
    paramDataRewinder = new GlideException(this.e, new ArrayList(paramList));
    for (;;)
    {
      throw paramDataRewinder;
    }
  }
  
  public Resource<Transcode> a(DataRewinder<DataType> paramDataRewinder, int paramInt1, int paramInt2, @NonNull Options paramOptions, DecodePath.DecodeCallback<ResourceType> paramDecodeCallback)
  {
    paramDataRewinder = paramDecodeCallback.a(a(paramDataRewinder, paramInt1, paramInt2, paramOptions));
    return this.c.a(paramDataRewinder, paramOptions);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DecodePath{ dataClass=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", decoders=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", transcoder=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DecodePath
 * JD-Core Version:    0.7.0.1
 */