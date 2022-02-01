package com.bumptech.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinder.Factory;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Registry
{
  private final ModelLoaderRegistry a = new ModelLoaderRegistry(this.j);
  private final EncoderRegistry b = new EncoderRegistry();
  private final ResourceDecoderRegistry c = new ResourceDecoderRegistry();
  private final ResourceEncoderRegistry d = new ResourceEncoderRegistry();
  private final DataRewinderRegistry e = new DataRewinderRegistry();
  private final TranscoderRegistry f = new TranscoderRegistry();
  private final ImageHeaderParserRegistry g = new ImageHeaderParserRegistry();
  private final ModelToResourceClassCache h = new ModelToResourceClassCache();
  private final LoadPathCache i = new LoadPathCache();
  private final Pools.Pool<List<Throwable>> j = FactoryPools.a();
  
  public Registry()
  {
    a(Arrays.asList(new String[] { "Gif", "Bitmap", "BitmapDrawable" }));
  }
  
  @NonNull
  private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> c(@NonNull Class<Data> paramClass, @NonNull Class<TResource> paramClass1, @NonNull Class<Transcode> paramClass2)
  {
    ArrayList localArrayList = new ArrayList();
    paramClass1 = this.c.b(paramClass, paramClass1).iterator();
    while (paramClass1.hasNext())
    {
      Class localClass1 = (Class)paramClass1.next();
      Iterator localIterator = this.f.b(localClass1, paramClass2).iterator();
      while (localIterator.hasNext())
      {
        Class localClass2 = (Class)localIterator.next();
        localArrayList.add(new DecodePath(paramClass, localClass1, localClass2, this.c.a(paramClass, localClass1), this.f.a(localClass1, localClass2), this.j));
      }
    }
    return localArrayList;
  }
  
  @NonNull
  public Registry a(@NonNull ImageHeaderParser paramImageHeaderParser)
  {
    this.g.a(paramImageHeaderParser);
    return this;
  }
  
  @NonNull
  public Registry a(@NonNull DataRewinder.Factory<?> paramFactory)
  {
    this.e.a(paramFactory);
    return this;
  }
  
  @NonNull
  public <Data> Registry a(@NonNull Class<Data> paramClass, @NonNull Encoder<Data> paramEncoder)
  {
    this.b.a(paramClass, paramEncoder);
    return this;
  }
  
  @NonNull
  public <TResource> Registry a(@NonNull Class<TResource> paramClass, @NonNull ResourceEncoder<TResource> paramResourceEncoder)
  {
    this.d.a(paramClass, paramResourceEncoder);
    return this;
  }
  
  @NonNull
  public <Data, TResource> Registry a(@NonNull Class<Data> paramClass, @NonNull Class<TResource> paramClass1, @NonNull ResourceDecoder<Data, TResource> paramResourceDecoder)
  {
    a("legacy_append", paramClass, paramClass1, paramResourceDecoder);
    return this;
  }
  
  @NonNull
  public <Model, Data> Registry a(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull ModelLoaderFactory<Model, Data> paramModelLoaderFactory)
  {
    this.a.a(paramClass, paramClass1, paramModelLoaderFactory);
    return this;
  }
  
  @NonNull
  public <TResource, Transcode> Registry a(@NonNull Class<TResource> paramClass, @NonNull Class<Transcode> paramClass1, @NonNull ResourceTranscoder<TResource, Transcode> paramResourceTranscoder)
  {
    this.f.a(paramClass, paramClass1, paramResourceTranscoder);
    return this;
  }
  
  @NonNull
  public <Data, TResource> Registry a(@NonNull String paramString, @NonNull Class<Data> paramClass, @NonNull Class<TResource> paramClass1, @NonNull ResourceDecoder<Data, TResource> paramResourceDecoder)
  {
    this.c.a(paramString, paramResourceDecoder, paramClass, paramClass1);
    return this;
  }
  
  @NonNull
  public final Registry a(@NonNull List<String> paramList)
  {
    paramList = new ArrayList(paramList);
    paramList.add(0, "legacy_prepend_all");
    paramList.add("legacy_append");
    this.c.a(paramList);
    return this;
  }
  
  @NonNull
  public <X> Encoder<X> a(@NonNull X paramX)
  {
    Encoder localEncoder = this.b.a(paramX.getClass());
    if (localEncoder != null) {
      return localEncoder;
    }
    throw new Registry.NoSourceEncoderAvailableException(paramX.getClass());
  }
  
  @Nullable
  public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> a(@NonNull Class<Data> paramClass, @NonNull Class<TResource> paramClass1, @NonNull Class<Transcode> paramClass2)
  {
    LoadPath localLoadPath = this.i.a(paramClass, paramClass1, paramClass2);
    if (this.i.a(localLoadPath)) {
      return null;
    }
    Object localObject = localLoadPath;
    if (localLoadPath == null)
    {
      localObject = c(paramClass, paramClass1, paramClass2);
      if (((List)localObject).isEmpty()) {
        localObject = null;
      } else {
        localObject = new LoadPath(paramClass, paramClass1, paramClass2, (List)localObject, this.j);
      }
      this.i.a(paramClass, paramClass1, paramClass2, (LoadPath)localObject);
    }
    return localObject;
  }
  
  @NonNull
  public List<ImageHeaderParser> a()
  {
    List localList = this.g.a();
    if (!localList.isEmpty()) {
      return localList;
    }
    throw new Registry.NoImageHeaderParserException();
  }
  
  public boolean a(@NonNull Resource<?> paramResource)
  {
    return this.d.a(paramResource.c()) != null;
  }
  
  @NonNull
  public <X> ResourceEncoder<X> b(@NonNull Resource<X> paramResource)
  {
    ResourceEncoder localResourceEncoder = this.d.a(paramResource.c());
    if (localResourceEncoder != null) {
      return localResourceEncoder;
    }
    throw new Registry.NoResultEncoderAvailableException(paramResource.c());
  }
  
  @NonNull
  public <X> DataRewinder<X> b(@NonNull X paramX)
  {
    return this.e.a(paramX);
  }
  
  @NonNull
  public <Model, TResource, Transcode> List<Class<?>> b(@NonNull Class<Model> paramClass, @NonNull Class<TResource> paramClass1, @NonNull Class<Transcode> paramClass2)
  {
    Object localObject2 = this.h.a(paramClass, paramClass1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      localObject2 = this.a.a(paramClass).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Class)((Iterator)localObject2).next();
        localObject3 = this.c.b((Class)localObject3, paramClass1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject3).next();
          if ((!this.f.b(localClass, paramClass2).isEmpty()) && (!((List)localObject1).contains(localClass))) {
            ((List)localObject1).add(localClass);
          }
        }
      }
      this.h.a(paramClass, paramClass1, Collections.unmodifiableList((List)localObject1));
    }
    return localObject1;
  }
  
  @NonNull
  public <Model> List<ModelLoader<Model, ?>> c(@NonNull Model paramModel)
  {
    List localList = this.a.a(paramModel);
    if (!localList.isEmpty()) {
      return localList;
    }
    throw new Registry.NoModelLoaderAvailableException(paramModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.Registry
 * JD-Core Version:    0.7.0.1
 */