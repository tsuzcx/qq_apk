package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory
{
  private static final MultiModelLoaderFactory.Factory a = new MultiModelLoaderFactory.Factory();
  private static final ModelLoader<Object, Object> b = new MultiModelLoaderFactory.EmptyModelLoader();
  private final List<MultiModelLoaderFactory.Entry<?, ?>> c = new ArrayList();
  private final MultiModelLoaderFactory.Factory d;
  private final Set<MultiModelLoaderFactory.Entry<?, ?>> e = new HashSet();
  private final Pools.Pool<List<Throwable>> f;
  
  public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> paramPool)
  {
    this(paramPool, a);
  }
  
  @VisibleForTesting
  MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> paramPool, @NonNull MultiModelLoaderFactory.Factory paramFactory)
  {
    this.f = paramPool;
    this.d = paramFactory;
  }
  
  @NonNull
  private static <Model, Data> ModelLoader<Model, Data> a()
  {
    return b;
  }
  
  @NonNull
  private <Model, Data> ModelLoader<Model, Data> a(@NonNull MultiModelLoaderFactory.Entry<?, ?> paramEntry)
  {
    return (ModelLoader)Preconditions.a(paramEntry.b.a(this));
  }
  
  private <Model, Data> void a(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory, boolean paramBoolean)
  {
    paramClass = new MultiModelLoaderFactory.Entry(paramClass, paramClass1, paramModelLoaderFactory);
    paramClass1 = this.c;
    int i;
    if (paramBoolean) {
      i = paramClass1.size();
    } else {
      i = 0;
    }
    paramClass1.add(i, paramClass);
  }
  
  /* Error */
  @NonNull
  public <Model, Data> ModelLoader<Model, Data> a(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 46	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 47	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 49	com/bumptech/glide/load/model/MultiModelLoaderFactory:c	Ljava/util/List;
    //   15: invokeinterface 103 1 0
    //   20: astore 5
    //   22: iconst_0
    //   23: istore_3
    //   24: aload 5
    //   26: invokeinterface 109 1 0
    //   31: ifeq +85 -> 116
    //   34: aload 5
    //   36: invokeinterface 113 1 0
    //   41: checkcast 65	com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry
    //   44: astore 6
    //   46: aload_0
    //   47: getfield 54	com/bumptech/glide/load/model/MultiModelLoaderFactory:e	Ljava/util/Set;
    //   50: aload 6
    //   52: invokeinterface 119 2 0
    //   57: ifeq +8 -> 65
    //   60: iconst_1
    //   61: istore_3
    //   62: goto -38 -> 24
    //   65: aload 6
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual 122	com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry:a	(Ljava/lang/Class;Ljava/lang/Class;)Z
    //   72: ifeq -48 -> 24
    //   75: aload_0
    //   76: getfield 54	com/bumptech/glide/load/model/MultiModelLoaderFactory:e	Ljava/util/Set;
    //   79: aload 6
    //   81: invokeinterface 124 2 0
    //   86: pop
    //   87: aload 4
    //   89: aload_0
    //   90: aload 6
    //   92: invokespecial 126	com/bumptech/glide/load/model/MultiModelLoaderFactory:a	(Lcom/bumptech/glide/load/model/MultiModelLoaderFactory$Entry;)Lcom/bumptech/glide/load/model/ModelLoader;
    //   95: invokeinterface 127 2 0
    //   100: pop
    //   101: aload_0
    //   102: getfield 54	com/bumptech/glide/load/model/MultiModelLoaderFactory:e	Ljava/util/Set;
    //   105: aload 6
    //   107: invokeinterface 130 2 0
    //   112: pop
    //   113: goto -89 -> 24
    //   116: aload 4
    //   118: invokeinterface 91 1 0
    //   123: iconst_1
    //   124: if_icmple +21 -> 145
    //   127: aload_0
    //   128: getfield 58	com/bumptech/glide/load/model/MultiModelLoaderFactory:d	Lcom/bumptech/glide/load/model/MultiModelLoaderFactory$Factory;
    //   131: aload 4
    //   133: aload_0
    //   134: getfield 56	com/bumptech/glide/load/model/MultiModelLoaderFactory:f	Landroid/support/v4/util/Pools$Pool;
    //   137: invokevirtual 133	com/bumptech/glide/load/model/MultiModelLoaderFactory$Factory:a	(Ljava/util/List;Landroid/support/v4/util/Pools$Pool;)Lcom/bumptech/glide/load/model/MultiModelLoader;
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: areturn
    //   145: aload 4
    //   147: invokeinterface 91 1 0
    //   152: iconst_1
    //   153: if_icmpne +19 -> 172
    //   156: aload 4
    //   158: iconst_0
    //   159: invokeinterface 137 2 0
    //   164: checkcast 80	com/bumptech/glide/load/model/ModelLoader
    //   167: astore_1
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: areturn
    //   172: iload_3
    //   173: ifeq +11 -> 184
    //   176: invokestatic 139	com/bumptech/glide/load/model/MultiModelLoaderFactory:a	()Lcom/bumptech/glide/load/model/ModelLoader;
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: areturn
    //   184: new 141	com/bumptech/glide/Registry$NoModelLoaderAvailableException
    //   187: dup
    //   188: aload_1
    //   189: aload_2
    //   190: invokespecial 144	com/bumptech/glide/Registry$NoModelLoaderAvailableException:<init>	(Ljava/lang/Class;Ljava/lang/Class;)V
    //   193: athrow
    //   194: astore_1
    //   195: goto +15 -> 210
    //   198: astore_1
    //   199: aload_0
    //   200: getfield 54	com/bumptech/glide/load/model/MultiModelLoaderFactory:e	Ljava/util/Set;
    //   203: invokeinterface 147 1 0
    //   208: aload_1
    //   209: athrow
    //   210: aload_0
    //   211: monitorexit
    //   212: goto +5 -> 217
    //   215: aload_1
    //   216: athrow
    //   217: goto -2 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	MultiModelLoaderFactory
    //   0	220	1	paramClass	Class<Model>
    //   0	220	2	paramClass1	Class<Data>
    //   23	150	3	i	int
    //   9	148	4	localArrayList	ArrayList
    //   20	15	5	localIterator	Iterator
    //   44	62	6	localEntry	MultiModelLoaderFactory.Entry
    // Exception table:
    //   from	to	target	type
    //   2	22	194	finally
    //   24	60	194	finally
    //   65	113	194	finally
    //   116	141	194	finally
    //   145	168	194	finally
    //   176	180	194	finally
    //   184	194	194	finally
    //   199	210	194	finally
    //   2	22	198	java/lang/Throwable
    //   24	60	198	java/lang/Throwable
    //   65	113	198	java/lang/Throwable
    //   116	141	198	java/lang/Throwable
    //   145	168	198	java/lang/Throwable
    //   176	180	198	java/lang/Throwable
    //   184	194	198	java/lang/Throwable
  }
  
  /* Error */
  @NonNull
  <Model> List<ModelLoader<Model, ?>> a(@NonNull Class<Model> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 46	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 47	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 49	com/bumptech/glide/load/model/MultiModelLoaderFactory:c	Ljava/util/List;
    //   14: invokeinterface 103 1 0
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface 109 1 0
    //   26: ifeq +80 -> 106
    //   29: aload_3
    //   30: invokeinterface 113 1 0
    //   35: checkcast 65	com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry
    //   38: astore 4
    //   40: aload_0
    //   41: getfield 54	com/bumptech/glide/load/model/MultiModelLoaderFactory:e	Ljava/util/Set;
    //   44: aload 4
    //   46: invokeinterface 119 2 0
    //   51: ifeq +6 -> 57
    //   54: goto -34 -> 20
    //   57: aload 4
    //   59: aload_1
    //   60: invokevirtual 152	com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry:a	(Ljava/lang/Class;)Z
    //   63: ifeq -43 -> 20
    //   66: aload_0
    //   67: getfield 54	com/bumptech/glide/load/model/MultiModelLoaderFactory:e	Ljava/util/Set;
    //   70: aload 4
    //   72: invokeinterface 124 2 0
    //   77: pop
    //   78: aload_2
    //   79: aload_0
    //   80: aload 4
    //   82: invokespecial 126	com/bumptech/glide/load/model/MultiModelLoaderFactory:a	(Lcom/bumptech/glide/load/model/MultiModelLoaderFactory$Entry;)Lcom/bumptech/glide/load/model/ModelLoader;
    //   85: invokeinterface 127 2 0
    //   90: pop
    //   91: aload_0
    //   92: getfield 54	com/bumptech/glide/load/model/MultiModelLoaderFactory:e	Ljava/util/Set;
    //   95: aload 4
    //   97: invokeinterface 130 2 0
    //   102: pop
    //   103: goto -83 -> 20
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: areturn
    //   110: astore_1
    //   111: goto +15 -> 126
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 54	com/bumptech/glide/load/model/MultiModelLoaderFactory:e	Ljava/util/Set;
    //   119: invokeinterface 147 1 0
    //   124: aload_1
    //   125: athrow
    //   126: aload_0
    //   127: monitorexit
    //   128: goto +5 -> 133
    //   131: aload_1
    //   132: athrow
    //   133: goto -2 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	MultiModelLoaderFactory
    //   0	136	1	paramClass	Class<Model>
    //   9	100	2	localArrayList	ArrayList
    //   19	11	3	localIterator	Iterator
    //   38	58	4	localEntry	MultiModelLoaderFactory.Entry
    // Exception table:
    //   from	to	target	type
    //   2	20	110	finally
    //   20	54	110	finally
    //   57	103	110	finally
    //   115	126	110	finally
    //   2	20	114	java/lang/Throwable
    //   20	54	114	java/lang/Throwable
    //   57	103	114	java/lang/Throwable
  }
  
  <Model, Data> void a(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory)
  {
    try
    {
      a(paramClass, paramClass1, paramModelLoaderFactory, true);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  @NonNull
  List<Class<?>> b(@NonNull Class<?> paramClass)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        MultiModelLoaderFactory.Entry localEntry = (MultiModelLoaderFactory.Entry)localIterator.next();
        if ((!localArrayList.contains(localEntry.a)) && (localEntry.a(paramClass))) {
          localArrayList.add(localEntry.a);
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.MultiModelLoaderFactory
 * JD-Core Version:    0.7.0.1
 */