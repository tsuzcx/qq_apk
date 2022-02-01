package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder.Factory;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.model.AssetUriLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.AssetUriLoader.StreamFactory;
import com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory;
import com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader.Factory;
import com.bumptech.glide.load.model.DataUrlLoader.StreamFactory;
import com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.FileLoader.StreamFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader.Factory;
import com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.StreamFactory;
import com.bumptech.glide.load.model.ResourceLoader.UriFactory;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader.AssetFileDescriptorFactory;
import com.bumptech.glide.load.model.StringLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.StringLoader.StreamFactory;
import com.bumptech.glide.load.model.UnitModelLoader.Factory;
import com.bumptech.glide.load.model.UriLoader.AssetFileDescriptorFactory;
import com.bumptech.glide.load.model.UriLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.UriLoader.StreamFactory;
import com.bumptech.glide.load.model.UrlUriLoader.StreamFactory;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Factory;
import com.bumptech.glide.load.model.stream.HttpUriLoader.Factory;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader.Factory;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader.Factory;
import com.bumptech.glide.load.model.stream.UrlLoader.StreamFactory;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder.Factory;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide
  implements ComponentCallbacks2
{
  private static volatile Glide a;
  private static volatile boolean b;
  private final Engine c;
  private final BitmapPool d;
  private final MemoryCache e;
  private final BitmapPreFiller f;
  private final GlideContext g;
  private final Registry h;
  private final ArrayPool i;
  private final RequestManagerRetriever j;
  private final ConnectivityMonitorFactory k;
  private final List<RequestManager> l = new ArrayList();
  private MemoryCategory m = MemoryCategory.NORMAL;
  
  Glide(@NonNull Context paramContext, @NonNull Engine paramEngine, @NonNull MemoryCache paramMemoryCache, @NonNull BitmapPool paramBitmapPool, @NonNull ArrayPool paramArrayPool, @NonNull RequestManagerRetriever paramRequestManagerRetriever, @NonNull ConnectivityMonitorFactory paramConnectivityMonitorFactory, int paramInt, @NonNull RequestOptions paramRequestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> paramMap)
  {
    this.c = paramEngine;
    this.d = paramBitmapPool;
    this.i = paramArrayPool;
    this.e = paramMemoryCache;
    this.j = paramRequestManagerRetriever;
    this.k = paramConnectivityMonitorFactory;
    this.f = new BitmapPreFiller(paramMemoryCache, paramBitmapPool, (DecodeFormat)paramRequestOptions.k().a(Downsampler.a));
    paramMemoryCache = paramContext.getResources();
    this.h = new Registry();
    this.h.a(new DefaultImageHeaderParser());
    Object localObject = new Downsampler(this.h.a(), paramMemoryCache.getDisplayMetrics(), paramBitmapPool, paramArrayPool);
    paramRequestManagerRetriever = new ByteBufferGifDecoder(paramContext, this.h.a(), paramBitmapPool, paramArrayPool);
    paramConnectivityMonitorFactory = VideoDecoder.b(paramBitmapPool);
    ByteBufferBitmapDecoder localByteBufferBitmapDecoder = new ByteBufferBitmapDecoder((Downsampler)localObject);
    localObject = new StreamBitmapDecoder((Downsampler)localObject, paramArrayPool);
    ResourceDrawableDecoder localResourceDrawableDecoder = new ResourceDrawableDecoder(paramContext);
    ResourceLoader.StreamFactory localStreamFactory = new ResourceLoader.StreamFactory(paramMemoryCache);
    ResourceLoader.UriFactory localUriFactory = new ResourceLoader.UriFactory(paramMemoryCache);
    ResourceLoader.FileDescriptorFactory localFileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(paramMemoryCache);
    ResourceLoader.AssetFileDescriptorFactory localAssetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(paramMemoryCache);
    BitmapEncoder localBitmapEncoder = new BitmapEncoder(paramArrayPool);
    BitmapBytesTranscoder localBitmapBytesTranscoder = new BitmapBytesTranscoder();
    GifDrawableBytesTranscoder localGifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    this.h.a(ByteBuffer.class, new ByteBufferEncoder()).a(InputStream.class, new StreamEncoder(paramArrayPool)).a("Bitmap", ByteBuffer.class, Bitmap.class, localByteBufferBitmapDecoder).a("Bitmap", InputStream.class, Bitmap.class, (ResourceDecoder)localObject).a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, paramConnectivityMonitorFactory).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.a(paramBitmapPool)).a(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.a()).a("Bitmap", Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).a(Bitmap.class, localBitmapEncoder).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(paramMemoryCache, localByteBufferBitmapDecoder)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(paramMemoryCache, (ResourceDecoder)localObject)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(paramMemoryCache, paramConnectivityMonitorFactory)).a(BitmapDrawable.class, new BitmapDrawableEncoder(paramBitmapPool, localBitmapEncoder)).a("Gif", InputStream.class, GifDrawable.class, new StreamGifDecoder(this.h.a(), paramRequestManagerRetriever, paramArrayPool)).a("Gif", ByteBuffer.class, GifDrawable.class, paramRequestManagerRetriever).a(GifDrawable.class, new GifDrawableEncoder()).a(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.a()).a("Bitmap", GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(paramBitmapPool)).a(Uri.class, Drawable.class, localResourceDrawableDecoder).a(Uri.class, Bitmap.class, new ResourceBitmapDecoder(localResourceDrawableDecoder, paramBitmapPool)).a(new ByteBufferRewinder.Factory()).a(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).a(File.class, InputStream.class, new FileLoader.StreamFactory()).a(File.class, File.class, new FileDecoder()).a(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).a(File.class, File.class, UnitModelLoader.Factory.a()).a(new InputStreamRewinder.Factory(paramArrayPool)).a(Integer.TYPE, InputStream.class, localStreamFactory).a(Integer.TYPE, ParcelFileDescriptor.class, localFileDescriptorFactory).a(Integer.class, InputStream.class, localStreamFactory).a(Integer.class, ParcelFileDescriptor.class, localFileDescriptorFactory).a(Integer.class, Uri.class, localUriFactory).a(Integer.TYPE, AssetFileDescriptor.class, localAssetFileDescriptorFactory).a(Integer.class, AssetFileDescriptor.class, localAssetFileDescriptorFactory).a(Integer.TYPE, Uri.class, localUriFactory).a(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).a(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).a(String.class, InputStream.class, new StringLoader.StreamFactory()).a(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).a(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).a(Uri.class, InputStream.class, new HttpUriLoader.Factory()).a(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(paramContext.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(paramContext.getAssets())).a(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(paramContext)).a(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(paramContext)).a(Uri.class, InputStream.class, new UriLoader.StreamFactory(localContentResolver)).a(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(localContentResolver)).a(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(localContentResolver)).a(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).a(URL.class, InputStream.class, new UrlLoader.StreamFactory()).a(Uri.class, File.class, new MediaStoreFileLoader.Factory(paramContext)).a(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).a([B.class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).a([B.class, InputStream.class, new ByteArrayLoader.StreamFactory()).a(Uri.class, Uri.class, UnitModelLoader.Factory.a()).a(Drawable.class, Drawable.class, UnitModelLoader.Factory.a()).a(Drawable.class, Drawable.class, new UnitDrawableDecoder()).a(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(paramMemoryCache)).a(Bitmap.class, [B.class, localBitmapBytesTranscoder).a(Drawable.class, [B.class, new DrawableBytesTranscoder(paramBitmapPool, localBitmapBytesTranscoder, localGifDrawableBytesTranscoder)).a(GifDrawable.class, [B.class, localGifDrawableBytesTranscoder);
    paramMemoryCache = new ImageViewTargetFactory();
    this.g = new GlideContext(paramContext, paramArrayPool, this.h, paramMemoryCache, paramRequestOptions, paramMap, paramEngine, paramInt);
  }
  
  @NonNull
  public static Glide a(@NonNull Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          c(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  private static void a(@NonNull Context paramContext, @NonNull GlideBuilder paramGlideBuilder)
  {
    Context localContext = paramContext.getApplicationContext();
    GeneratedAppGlideModule localGeneratedAppGlideModule = i();
    paramContext = Collections.emptyList();
    if ((localGeneratedAppGlideModule == null) || (localGeneratedAppGlideModule.c())) {
      paramContext = new ManifestParser(localContext).a();
    }
    Object localObject2;
    Object localObject3;
    if ((localGeneratedAppGlideModule != null) && (!localGeneratedAppGlideModule.a().isEmpty()))
    {
      localObject1 = localGeneratedAppGlideModule.a();
      localObject2 = paramContext.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (GlideModule)((Iterator)localObject2).next();
        if (((Set)localObject1).contains(localObject3.getClass()))
        {
          if (Log.isLoggable("Glide", 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("AppGlideModule excludes manifest GlideModule: ");
            localStringBuilder.append(localObject3);
            Log.d("Glide", localStringBuilder.toString());
          }
          ((Iterator)localObject2).remove();
        }
      }
    }
    if (Log.isLoggable("Glide", 3))
    {
      localObject1 = paramContext.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GlideModule)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Discovered GlideModule from manifest: ");
        ((StringBuilder)localObject3).append(localObject2.getClass());
        Log.d("Glide", ((StringBuilder)localObject3).toString());
      }
    }
    if (localGeneratedAppGlideModule != null) {
      localObject1 = localGeneratedAppGlideModule.b();
    } else {
      localObject1 = null;
    }
    paramGlideBuilder.a((RequestManagerRetriever.RequestManagerFactory)localObject1);
    Object localObject1 = paramContext.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((GlideModule)((Iterator)localObject1).next()).a(localContext, paramGlideBuilder);
    }
    if (localGeneratedAppGlideModule != null) {
      localGeneratedAppGlideModule.a(localContext, paramGlideBuilder);
    }
    paramGlideBuilder = paramGlideBuilder.a(localContext);
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      ((GlideModule)paramContext.next()).a(localContext, paramGlideBuilder, paramGlideBuilder.h);
    }
    if (localGeneratedAppGlideModule != null) {
      localGeneratedAppGlideModule.a(localContext, paramGlideBuilder, paramGlideBuilder.h);
    }
    localContext.registerComponentCallbacks(paramGlideBuilder);
    a = paramGlideBuilder;
  }
  
  private static void a(Exception paramException)
  {
    throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", paramException);
  }
  
  @NonNull
  public static RequestManager b(@NonNull Context paramContext)
  {
    return e(paramContext).a(paramContext);
  }
  
  private static void c(@NonNull Context paramContext)
  {
    if (!b)
    {
      b = true;
      d(paramContext);
      b = false;
      return;
    }
    throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
  }
  
  private static void d(@NonNull Context paramContext)
  {
    a(paramContext, new GlideBuilder());
  }
  
  @NonNull
  private static RequestManagerRetriever e(@Nullable Context paramContext)
  {
    Preconditions.a(paramContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    return a(paramContext).g();
  }
  
  @Nullable
  private static GeneratedAppGlideModule i()
  {
    try
    {
      try
      {
        GeneratedAppGlideModule localGeneratedAppGlideModule = (GeneratedAppGlideModule)Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        return localGeneratedAppGlideModule;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        a(localInvocationTargetException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        a(localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        a(localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        a(localInstantiationException);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label58:
      break label58;
    }
    if (Log.isLoggable("Glide", 5)) {
      Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
    }
    return null;
  }
  
  @NonNull
  public BitmapPool a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    Util.a();
    this.e.a(paramInt);
    this.d.a(paramInt);
    this.i.a(paramInt);
  }
  
  void a(RequestManager paramRequestManager)
  {
    synchronized (this.l)
    {
      if (!this.l.contains(paramRequestManager))
      {
        this.l.add(paramRequestManager);
        return;
      }
      throw new IllegalStateException("Cannot register already registered manager");
    }
  }
  
  boolean a(@NonNull Target<?> paramTarget)
  {
    synchronized (this.l)
    {
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext()) {
        if (((RequestManager)localIterator.next()).b(paramTarget)) {
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramTarget;
    }
  }
  
  @NonNull
  public ArrayPool b()
  {
    return this.i;
  }
  
  void b(RequestManager paramRequestManager)
  {
    synchronized (this.l)
    {
      if (this.l.contains(paramRequestManager))
      {
        this.l.remove(paramRequestManager);
        return;
      }
      throw new IllegalStateException("Cannot unregister not yet registered manager");
    }
  }
  
  @NonNull
  public Context c()
  {
    return this.g.getBaseContext();
  }
  
  ConnectivityMonitorFactory d()
  {
    return this.k;
  }
  
  @NonNull
  GlideContext e()
  {
    return this.g;
  }
  
  public void f()
  {
    Util.a();
    this.e.c();
    this.d.a();
    this.i.a();
  }
  
  @NonNull
  public RequestManagerRetriever g()
  {
    return this.j;
  }
  
  @NonNull
  public Registry h()
  {
    return this.h;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    f();
  }
  
  public void onTrimMemory(int paramInt)
  {
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.Glide
 * JD-Core Version:    0.7.0.1
 */