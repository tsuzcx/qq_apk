package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R>
  implements DataFetcherGenerator.FetcherReadyCallback, FactoryPools.Poolable, Comparable<DecodeJob<?>>, Runnable
{
  private DataSource A;
  private DataFetcher<?> B;
  private volatile DataFetcherGenerator C;
  private volatile boolean D;
  private volatile boolean E;
  private final DecodeHelper<R> a = new DecodeHelper();
  private final List<Throwable> b = new ArrayList();
  private final StateVerifier c = StateVerifier.a();
  private final DecodeJob.DiskCacheProvider d;
  private final Pools.Pool<DecodeJob<?>> e;
  private final DecodeJob.DeferredEncodeManager<?> f = new DecodeJob.DeferredEncodeManager();
  private final DecodeJob.ReleaseManager g = new DecodeJob.ReleaseManager();
  private GlideContext h;
  private Key i;
  private Priority j;
  private EngineKey k;
  private int l;
  private int m;
  private DiskCacheStrategy n;
  private Options o;
  private DecodeJob.Callback<R> p;
  private int q;
  private DecodeJob.Stage r;
  private DecodeJob.RunReason s;
  private long t;
  private boolean u;
  private Object v;
  private Thread w;
  private Key x;
  private Key y;
  private Object z;
  
  DecodeJob(DecodeJob.DiskCacheProvider paramDiskCacheProvider, Pools.Pool<DecodeJob<?>> paramPool)
  {
    this.d = paramDiskCacheProvider;
    this.e = paramPool;
  }
  
  @NonNull
  private Options a(DataSource paramDataSource)
  {
    Options localOptions = this.o;
    if (Build.VERSION.SDK_INT < 26) {
      return localOptions;
    }
    if (localOptions.a(Downsampler.d) != null) {
      return localOptions;
    }
    if (paramDataSource != DataSource.RESOURCE_DISK_CACHE)
    {
      paramDataSource = localOptions;
      if (!this.a.l()) {}
    }
    else
    {
      paramDataSource = new Options();
      paramDataSource.a(this.o);
      paramDataSource.a(Downsampler.d, Boolean.valueOf(true));
    }
    return paramDataSource;
  }
  
  private DecodeJob.Stage a(DecodeJob.Stage paramStage)
  {
    int i1 = DecodeJob.1.b[paramStage.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((i1 != 3) && (i1 != 4))
        {
          if (i1 == 5)
          {
            if (this.n.a()) {
              return DecodeJob.Stage.RESOURCE_CACHE;
            }
            return a(DecodeJob.Stage.RESOURCE_CACHE);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized stage: ");
          localStringBuilder.append(paramStage);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return DecodeJob.Stage.FINISHED;
      }
      if (this.u) {
        return DecodeJob.Stage.FINISHED;
      }
      return DecodeJob.Stage.SOURCE;
    }
    if (this.n.b()) {
      return DecodeJob.Stage.DATA_CACHE;
    }
    return a(DecodeJob.Stage.DATA_CACHE);
  }
  
  private <Data> Resource<R> a(DataFetcher<?> paramDataFetcher, Data paramData, DataSource paramDataSource)
  {
    if (paramData == null)
    {
      paramDataFetcher.b();
      return null;
    }
    try
    {
      long l1 = LogTime.a();
      paramData = a(paramData, paramDataSource);
      if (Log.isLoggable("DecodeJob", 2))
      {
        paramDataSource = new StringBuilder();
        paramDataSource.append("Decoded result ");
        paramDataSource.append(paramData);
        a(paramDataSource.toString(), l1);
      }
      return paramData;
    }
    finally
    {
      paramDataFetcher.b();
    }
  }
  
  private <Data> Resource<R> a(Data paramData, DataSource paramDataSource)
  {
    return a(paramData, paramDataSource, this.a.b(paramData.getClass()));
  }
  
  private <Data, ResourceType> Resource<R> a(Data paramData, DataSource paramDataSource, LoadPath<Data, ResourceType, R> paramLoadPath)
  {
    Options localOptions = a(paramDataSource);
    paramData = this.h.c().b(paramData);
    try
    {
      paramDataSource = paramLoadPath.a(paramData, localOptions, this.l, this.m, new DecodeJob.DecodeCallback(this, paramDataSource));
      return paramDataSource;
    }
    finally
    {
      paramData.b();
    }
  }
  
  private void a(Resource<R> paramResource, DataSource paramDataSource)
  {
    m();
    this.p.a(paramResource, paramDataSource);
  }
  
  private void a(String paramString, long paramLong)
  {
    a(paramString, paramLong, null);
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" in ");
    localStringBuilder.append(LogTime.a(paramLong));
    localStringBuilder.append(", load key: ");
    localStringBuilder.append(this.k);
    if (paramString2 != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(", ");
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = "";
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", thread: ");
    localStringBuilder.append(Thread.currentThread().getName());
    Log.v("DecodeJob", localStringBuilder.toString());
  }
  
  private void b(Resource<R> paramResource, DataSource paramDataSource)
  {
    if ((paramResource instanceof Initializable)) {
      ((Initializable)paramResource).a();
    }
    Object localObject1 = null;
    Object localObject2 = paramResource;
    if (this.f.a())
    {
      localObject2 = LockedResource.a(paramResource);
      localObject1 = localObject2;
    }
    a((Resource)localObject2, paramDataSource);
    this.r = DecodeJob.Stage.ENCODE;
    try
    {
      if (this.f.a()) {
        this.f.a(this.d, this.o);
      }
      if (localObject1 != null) {
        localObject1.a();
      }
      e();
      return;
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.a();
      }
    }
  }
  
  private void e()
  {
    if (this.g.a()) {
      g();
    }
  }
  
  private void f()
  {
    if (this.g.b()) {
      g();
    }
  }
  
  private void g()
  {
    this.g.c();
    this.f.b();
    this.a.a();
    this.D = false;
    this.h = null;
    this.i = null;
    this.o = null;
    this.j = null;
    this.k = null;
    this.p = null;
    this.r = null;
    this.C = null;
    this.w = null;
    this.x = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.t = 0L;
    this.E = false;
    this.v = null;
    this.b.clear();
    this.e.release(this);
  }
  
  private int h()
  {
    return this.j.ordinal();
  }
  
  private void i()
  {
    int i1 = DecodeJob.1.a[this.s.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 == 3)
        {
          n();
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unrecognized run reason: ");
        localStringBuilder.append(this.s);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      k();
      return;
    }
    this.r = a(DecodeJob.Stage.INITIALIZE);
    this.C = j();
    k();
  }
  
  private DataFetcherGenerator j()
  {
    int i1 = DecodeJob.1.b[this.r.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 == 4) {
            return null;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized stage: ");
          localStringBuilder.append(this.r);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        return new SourceGenerator(this.a, this);
      }
      return new DataCacheGenerator(this.a, this);
    }
    return new ResourceCacheGenerator(this.a, this);
  }
  
  private void k()
  {
    this.w = Thread.currentThread();
    this.t = LogTime.a();
    boolean bool1 = false;
    boolean bool2;
    do
    {
      bool2 = bool1;
      if (this.E) {
        break;
      }
      bool2 = bool1;
      if (this.C == null) {
        break;
      }
      bool1 = this.C.a();
      bool2 = bool1;
      if (bool1) {
        break;
      }
      this.r = a(this.r);
      this.C = j();
    } while (this.r != DecodeJob.Stage.SOURCE);
    c();
    return;
    if (((this.r == DecodeJob.Stage.FINISHED) || (this.E)) && (!bool2)) {
      l();
    }
  }
  
  private void l()
  {
    m();
    GlideException localGlideException = new GlideException("Failed to load resource", new ArrayList(this.b));
    this.p.a(localGlideException);
    f();
  }
  
  private void m()
  {
    this.c.b();
    if (!this.D)
    {
      this.D = true;
      return;
    }
    throw new IllegalStateException("Already notified");
  }
  
  private void n()
  {
    if (Log.isLoggable("DecodeJob", 2))
    {
      long l1 = this.t;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("data: ");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append(", cache key: ");
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append(", fetcher: ");
      ((StringBuilder)localObject).append(this.B);
      a("Retrieved data", l1, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    try
    {
      Resource localResource = a(this.B, this.z, this.A);
      localObject = localResource;
    }
    catch (GlideException localGlideException)
    {
      localGlideException.setLoggingDetails(this.y, this.A);
      this.b.add(localGlideException);
    }
    if (localObject != null)
    {
      b((Resource)localObject, this.A);
      return;
    }
    k();
  }
  
  @NonNull
  public StateVerifier E_()
  {
    return this.c;
  }
  
  public int a(@NonNull DecodeJob<?> paramDecodeJob)
  {
    int i2 = h() - paramDecodeJob.h();
    int i1 = i2;
    if (i2 == 0) {
      i1 = this.q - paramDecodeJob.q;
    }
    return i1;
  }
  
  DecodeJob<R> a(GlideContext paramGlideContext, Object paramObject, EngineKey paramEngineKey, Key paramKey, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, DiskCacheStrategy paramDiskCacheStrategy, Map<Class<?>, Transformation<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Options paramOptions, DecodeJob.Callback<R> paramCallback, int paramInt3)
  {
    this.a.a(paramGlideContext, paramObject, paramKey, paramInt1, paramInt2, paramDiskCacheStrategy, paramClass, paramClass1, paramPriority, paramOptions, paramMap, paramBoolean1, paramBoolean2, this.d);
    this.h = paramGlideContext;
    this.i = paramKey;
    this.j = paramPriority;
    this.k = paramEngineKey;
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramDiskCacheStrategy;
    this.u = paramBoolean3;
    this.o = paramOptions;
    this.p = paramCallback;
    this.q = paramInt3;
    this.s = DecodeJob.RunReason.INITIALIZE;
    this.v = paramObject;
    return this;
  }
  
  @NonNull
  <Z> Resource<Z> a(DataSource paramDataSource, @NonNull Resource<Z> paramResource)
  {
    Class localClass = paramResource.d().getClass();
    Object localObject1 = DataSource.RESOURCE_DISK_CACHE;
    Object localObject2 = null;
    Transformation localTransformation;
    if (paramDataSource != localObject1)
    {
      localTransformation = this.a.c(localClass);
      localObject1 = localTransformation.a(this.h, paramResource, this.l, this.m);
    }
    else
    {
      localObject1 = paramResource;
      localTransformation = null;
    }
    if (!paramResource.equals(localObject1)) {
      paramResource.f();
    }
    EncodeStrategy localEncodeStrategy;
    if (this.a.a((Resource)localObject1))
    {
      paramResource = this.a.b((Resource)localObject1);
      localEncodeStrategy = paramResource.a(this.o);
    }
    else
    {
      localEncodeStrategy = EncodeStrategy.NONE;
      paramResource = localObject2;
    }
    boolean bool = this.a.a(this.x);
    if (this.n.a(bool ^ true, paramDataSource, localEncodeStrategy))
    {
      if (paramResource != null)
      {
        int i1 = DecodeJob.1.c[localEncodeStrategy.ordinal()];
        if (i1 != 1)
        {
          if (i1 == 2)
          {
            paramDataSource = new ResourceCacheKey(this.a.i(), this.x, this.i, this.l, this.m, localTransformation, localClass, this.o);
          }
          else
          {
            paramDataSource = new StringBuilder();
            paramDataSource.append("Unknown strategy: ");
            paramDataSource.append(localEncodeStrategy);
            throw new IllegalArgumentException(paramDataSource.toString());
          }
        }
        else {
          paramDataSource = new DataCacheKey(this.x, this.i);
        }
        localObject1 = LockedResource.a((Resource)localObject1);
        this.f.a(paramDataSource, paramResource, (LockedResource)localObject1);
        return localObject1;
      }
      throw new Registry.NoResultEncoderAvailableException(((Resource)localObject1).d().getClass());
    }
    return localObject1;
  }
  
  public void a(Key paramKey, Exception paramException, DataFetcher<?> paramDataFetcher, DataSource paramDataSource)
  {
    paramDataFetcher.b();
    paramException = new GlideException("Fetching data failed", paramException);
    paramException.setLoggingDetails(paramKey, paramDataSource, paramDataFetcher.a());
    this.b.add(paramException);
    if (Thread.currentThread() != this.w)
    {
      this.s = DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE;
      this.p.a(this);
      return;
    }
    k();
  }
  
  public void a(Key paramKey1, Object paramObject, DataFetcher<?> paramDataFetcher, DataSource paramDataSource, Key paramKey2)
  {
    this.x = paramKey1;
    this.z = paramObject;
    this.B = paramDataFetcher;
    this.A = paramDataSource;
    this.y = paramKey2;
    if (Thread.currentThread() != this.w)
    {
      this.s = DecodeJob.RunReason.DECODE_DATA;
      this.p.a(this);
      return;
    }
    GlideTrace.a("DecodeJob.decodeFromRetrievedData");
    try
    {
      n();
      return;
    }
    finally
    {
      GlideTrace.a();
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (this.g.a(paramBoolean)) {
      g();
    }
  }
  
  boolean a()
  {
    DecodeJob.Stage localStage = a(DecodeJob.Stage.INITIALIZE);
    return (localStage == DecodeJob.Stage.RESOURCE_CACHE) || (localStage == DecodeJob.Stage.DATA_CACHE);
  }
  
  public void b()
  {
    this.E = true;
    DataFetcherGenerator localDataFetcherGenerator = this.C;
    if (localDataFetcherGenerator != null) {
      localDataFetcherGenerator.b();
    }
  }
  
  public void c()
  {
    this.s = DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE;
    this.p.a(this);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 597
    //   3: aload_0
    //   4: getfield 378	com/bumptech/glide/load/engine/DecodeJob:v	Ljava/lang/Object;
    //   7: invokestatic 600	com/bumptech/glide/util/pool/GlideTrace:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   10: aload_0
    //   11: getfield 372	com/bumptech/glide/load/engine/DecodeJob:B	Lcom/bumptech/glide/load/data/DataFetcher;
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 376	com/bumptech/glide/load/engine/DecodeJob:E	Z
    //   19: ifeq +21 -> 40
    //   22: aload_0
    //   23: invokespecial 431	com/bumptech/glide/load/engine/DecodeJob:l	()V
    //   26: aload_1
    //   27: ifnull +9 -> 36
    //   30: aload_1
    //   31: invokeinterface 216 1 0
    //   36: invokestatic 582	com/bumptech/glide/util/pool/GlideTrace:a	()V
    //   39: return
    //   40: aload_0
    //   41: invokespecial 602	com/bumptech/glide/load/engine/DecodeJob:i	()V
    //   44: aload_1
    //   45: ifnull +9 -> 54
    //   48: aload_1
    //   49: invokeinterface 216 1 0
    //   54: invokestatic 582	com/bumptech/glide/util/pool/GlideTrace:a	()V
    //   57: return
    //   58: astore_2
    //   59: goto +107 -> 166
    //   62: astore_2
    //   63: ldc 226
    //   65: iconst_3
    //   66: invokestatic 232	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   69: ifeq +56 -> 125
    //   72: new 179	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   79: astore_3
    //   80: aload_3
    //   81: ldc_w 604
    //   84: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: aload_0
    //   90: getfield 376	com/bumptech/glide/load/engine/DecodeJob:E	Z
    //   93: invokevirtual 607	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_3
    //   98: ldc_w 609
    //   101: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: aload_0
    //   107: getfield 340	com/bumptech/glide/load/engine/DecodeJob:r	Lcom/bumptech/glide/load/engine/DecodeJob$Stage;
    //   110: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 226
    //   116: aload_3
    //   117: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_2
    //   121: invokestatic 612	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   124: pop
    //   125: aload_0
    //   126: getfield 340	com/bumptech/glide/load/engine/DecodeJob:r	Lcom/bumptech/glide/load/engine/DecodeJob$Stage;
    //   129: getstatic 338	com/bumptech/glide/load/engine/DecodeJob$Stage:ENCODE	Lcom/bumptech/glide/load/engine/DecodeJob$Stage;
    //   132: if_acmpeq +18 -> 150
    //   135: aload_0
    //   136: getfield 89	com/bumptech/glide/load/engine/DecodeJob:b	Ljava/util/List;
    //   139: aload_2
    //   140: invokeinterface 468 2 0
    //   145: pop
    //   146: aload_0
    //   147: invokespecial 431	com/bumptech/glide/load/engine/DecodeJob:l	()V
    //   150: aload_0
    //   151: getfield 376	com/bumptech/glide/load/engine/DecodeJob:E	Z
    //   154: ifeq +10 -> 164
    //   157: aload_1
    //   158: ifnull -104 -> 54
    //   161: goto -113 -> 48
    //   164: aload_2
    //   165: athrow
    //   166: aload_1
    //   167: ifnull +9 -> 176
    //   170: aload_1
    //   171: invokeinterface 216 1 0
    //   176: invokestatic 582	com/bumptech/glide/util/pool/GlideTrace:a	()V
    //   179: goto +5 -> 184
    //   182: aload_2
    //   183: athrow
    //   184: goto -2 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	DecodeJob
    //   14	157	1	localDataFetcher	DataFetcher
    //   58	1	2	localObject	Object
    //   62	121	2	localThrowable	Throwable
    //   79	38	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	26	58	finally
    //   40	44	58	finally
    //   63	125	58	finally
    //   125	150	58	finally
    //   150	157	58	finally
    //   164	166	58	finally
    //   15	26	62	java/lang/Throwable
    //   40	44	62	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DecodeJob
 * JD-Core Version:    0.7.0.1
 */