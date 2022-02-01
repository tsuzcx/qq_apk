package com.tencent.mm.modelappbrand.image;

import android.graphics.Bitmap;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.graphics.BitmapCompat;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

final class AppBrandSimpleImageLoader$n
  implements AppBrandSimpleImageLoader.e.a
{
  private final AppBrandSimpleImageLoader.p a;
  private final Map<String, String> b;
  private final AppBrandSimpleImageLoader.h c;
  private final AppBrandSimpleImageLoader d;
  private final AppBrandSimpleImageLoader.l e;
  private final AppBrandSimpleImageLoader.i f;
  private final AppBrandSimpleImageLoader.f g;
  private final String h;
  private boolean i = true;
  
  public AppBrandSimpleImageLoader$n(@NonNull String paramString1, @Nullable Map<String, String> paramMap, @Nullable AppBrandSimpleImageLoader.h paramh, @NonNull AppBrandSimpleImageLoader paramAppBrandSimpleImageLoader, @NonNull AppBrandSimpleImageLoader.l paraml, @NonNull AppBrandSimpleImageLoader.i parami, @Nullable AppBrandSimpleImageLoader.f paramf, @NonNull String paramString2)
  {
    this.a = new AppBrandSimpleImageLoader.p(paramString1, null);
    this.b = paramMap;
    this.c = paramh;
    this.d = paramAppBrandSimpleImageLoader;
    this.e = paraml;
    this.f = parami;
    this.g = paramf;
    this.h = paramString2;
  }
  
  @Nullable
  private Bitmap a(@NonNull InputStream paramInputStream)
  {
    try
    {
      if (this.g != null)
      {
        localBitmap = this.g.a(paramInputStream);
        return localBitmap;
      }
      Bitmap localBitmap = AppBrandSimpleImageLoader.b().a(paramInputStream);
      return localBitmap;
    }
    finally
    {
      af.a(paramInputStream);
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    AppBrandSimpleImageLoader.k localk = (AppBrandSimpleImageLoader.k)AppBrandSimpleImageLoader.d(this.d).remove(d());
    if (localk != null)
    {
      localk.a(paramBitmap);
      AppBrandSimpleImageLoader.c(this.d).remove(localk);
    }
  }
  
  /* Error */
  static void a(@NonNull AppBrandSimpleImageLoader.p paramp, @Nullable Map<String, String> paramMap, @NonNull AppBrandSimpleImageLoader.i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 110	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	(Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p;Ljava/util/Map;)Ljava/io/InputStream;
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 5
    //   10: aload 6
    //   12: ifnull +115 -> 127
    //   15: aload 5
    //   17: astore_3
    //   18: aload_2
    //   19: aload_0
    //   20: invokestatic 113	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	(Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p;)Ljava/lang/String;
    //   23: invokeinterface 118 2 0
    //   28: astore 7
    //   30: aload 7
    //   32: ifnull +22 -> 54
    //   35: aload 6
    //   37: aload 7
    //   39: sipush 16384
    //   42: invokestatic 124	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   45: pop2
    //   46: aload 7
    //   48: invokevirtual 129	java/io/OutputStream:flush	()V
    //   51: goto +18 -> 69
    //   54: ldc 131
    //   56: ldc 133
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: aastore
    //   66: invokestatic 138	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload 7
    //   71: ifnull +74 -> 145
    //   74: aload 5
    //   76: astore_3
    //   77: aload 7
    //   79: invokevirtual 141	java/io/OutputStream:close	()V
    //   82: goto +63 -> 145
    //   85: aload_1
    //   86: athrow
    //   87: astore_3
    //   88: aload_1
    //   89: astore 4
    //   91: aload_3
    //   92: astore_1
    //   93: aload 7
    //   95: ifnull +27 -> 122
    //   98: aload 4
    //   100: ifnull +14 -> 114
    //   103: aload 5
    //   105: astore_3
    //   106: aload 7
    //   108: invokevirtual 141	java/io/OutputStream:close	()V
    //   111: goto +11 -> 122
    //   114: aload 5
    //   116: astore_3
    //   117: aload 7
    //   119: invokevirtual 141	java/io/OutputStream:close	()V
    //   122: aload 5
    //   124: astore_3
    //   125: aload_1
    //   126: athrow
    //   127: aload 5
    //   129: astore_3
    //   130: ldc 131
    //   132: ldc 143
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: aastore
    //   142: invokestatic 138	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload 6
    //   147: ifnull +68 -> 215
    //   150: aload 6
    //   152: invokevirtual 146	java/io/InputStream:close	()V
    //   155: return
    //   156: aload_1
    //   157: astore_3
    //   158: aload_1
    //   159: athrow
    //   160: aload 6
    //   162: ifnull +20 -> 182
    //   165: aload_3
    //   166: ifnull +11 -> 177
    //   169: aload 6
    //   171: invokevirtual 146	java/io/InputStream:close	()V
    //   174: goto +8 -> 182
    //   177: aload 6
    //   179: invokevirtual 146	java/io/InputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: ldc 131
    //   187: ldc 148
    //   189: iconst_2
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_0
    //   196: aastore
    //   197: dup
    //   198: iconst_1
    //   199: aload_1
    //   200: aastore
    //   201: invokestatic 138	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload_2
    //   205: aload_0
    //   206: invokestatic 113	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	(Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p;)Ljava/lang/String;
    //   209: invokeinterface 151 2 0
    //   214: pop
    //   215: return
    //   216: astore_3
    //   217: goto -95 -> 122
    //   220: astore_3
    //   221: goto -39 -> 182
    //   224: astore_1
    //   225: aconst_null
    //   226: astore 4
    //   228: goto -135 -> 93
    //   231: astore_1
    //   232: goto -147 -> 85
    //   235: astore_1
    //   236: goto -76 -> 160
    //   239: astore_1
    //   240: goto -84 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramp	AppBrandSimpleImageLoader.p
    //   0	243	1	paramMap	Map<String, String>
    //   0	243	2	parami	AppBrandSimpleImageLoader.i
    //   17	60	3	localObject1	Object
    //   87	5	3	localObject2	Object
    //   105	61	3	localObject3	Object
    //   216	1	3	localThrowable1	java.lang.Throwable
    //   220	1	3	localThrowable2	java.lang.Throwable
    //   89	138	4	localMap	Map<String, String>
    //   8	120	5	localObject4	Object
    //   5	173	6	localInputStream	InputStream
    //   28	90	7	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   85	87	87	finally
    //   0	7	184	java/io/IOException
    //   150	155	184	java/io/IOException
    //   169	174	184	java/io/IOException
    //   177	182	184	java/io/IOException
    //   182	184	184	java/io/IOException
    //   106	111	216	java/lang/Throwable
    //   169	174	220	java/lang/Throwable
    //   35	51	224	finally
    //   54	69	224	finally
    //   35	51	231	java/lang/Throwable
    //   54	69	231	java/lang/Throwable
    //   18	30	235	finally
    //   77	82	235	finally
    //   106	111	235	finally
    //   117	122	235	finally
    //   125	127	235	finally
    //   130	145	235	finally
    //   158	160	235	finally
    //   18	30	239	java/lang/Throwable
    //   77	82	239	java/lang/Throwable
    //   117	122	239	java/lang/Throwable
    //   125	127	239	java/lang/Throwable
    //   130	145	239	java/lang/Throwable
  }
  
  @WorkerThread
  private Bitmap b(Bitmap paramBitmap)
  {
    return this.c.a(paramBitmap);
  }
  
  private void c(Bitmap paramBitmap)
  {
    boolean bool2 = false;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", new Object[] { Boolean.valueOf(bool1) });
    Bitmap localBitmap = paramBitmap;
    if (this.c != null)
    {
      localBitmap = paramBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localBitmap = b(paramBitmap);
          o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[] { paramBitmap, localBitmap });
          if (localBitmap != paramBitmap) {
            this.e.a(paramBitmap);
          }
        }
      }
    }
    this.e.a(e(), localBitmap);
    boolean bool1 = bool2;
    if (localBitmap != null)
    {
      bool1 = bool2;
      if (!localBitmap.isRecycled()) {
        bool1 = true;
      }
    }
    o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", new Object[] { localBitmap, Boolean.valueOf(bool1) });
    t.a(new AppBrandSimpleImageLoader.n.3(this, localBitmap));
  }
  
  private String d()
  {
    return AppBrandSimpleImageLoader.a(this.h, e());
  }
  
  private void d(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[] { paramBitmap });
      a(paramBitmap);
      return;
    }
    o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[] { paramBitmap });
    h();
  }
  
  private String e()
  {
    return AppBrandSimpleImageLoader.a(this.a.toString(), this.c, this.g);
  }
  
  private String f()
  {
    return AppBrandSimpleImageLoader.p.a(this.a);
  }
  
  private void g()
  {
    try
    {
      Bitmap localBitmap = i();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppBrandSimpleImageLoader.a(this.d).d(f());
        AppBrandSimpleImageLoader.a(this.d).b(f(), this);
        c(localBitmap);
        AppBrandSimpleImageLoader.a(this.d).a(f());
      }
      return;
    }
    catch (IOException localIOException)
    {
      o.a("Luggage.AppBrandSimpleImageLoader.LoadTask", localIOException, " doIOJobImpl, io exp ", new Object[0]);
      AppBrandSimpleImageLoader.a(this.d).d(f());
      AppBrandSimpleImageLoader.a(this.d).b(f(), this);
      AppBrandSimpleImageLoader.a(this.d).a(f());
      if ((localIOException instanceof FileNotFoundException)) {
        c(null);
      }
      return;
    }
    catch (b localb)
    {
      o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[] { localb });
      AppBrandSimpleImageLoader.a(this.d).d(f());
      AppBrandSimpleImageLoader.a(this.d).e(f());
      c(null);
      if ((localb instanceof b.a)) {
        AppBrandSimpleImageLoader.b(this.d).c(f());
      }
    }
  }
  
  private void h()
  {
    AppBrandSimpleImageLoader.k localk = (AppBrandSimpleImageLoader.k)AppBrandSimpleImageLoader.d(this.d).remove(d());
    if (localk != null)
    {
      localk.c();
      AppBrandSimpleImageLoader.c(this.d).remove(localk);
    }
  }
  
  private Bitmap i()
  {
    if (AppBrandSimpleImageLoader.f(this.d))
    {
      Object localObject2 = this.f.b(f());
      if (localObject2 == null)
      {
        o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", new Object[] { Boolean.valueOf(this.i) });
        if (this.i)
        {
          f.a.c(new AppBrandSimpleImageLoader.n.4(this));
        }
        else
        {
          AppBrandSimpleImageLoader.a(this.d).e(f());
          AppBrandSimpleImageLoader.a(this.d).d(f());
          throw new b.b();
        }
      }
      Object localObject1 = null;
      if (localObject2 != null)
      {
        try
        {
          localObject2 = a((InputStream)localObject2);
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          o.a("Luggage.AppBrandSimpleImageLoader.LoadTask", localException, " decode ", new Object[0]);
        }
        if ((localObject1 != null) && (!localObject1.isRecycled()))
        {
          o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", new Object[] { localObject1, Integer.valueOf(BitmapCompat.getAllocationByteCount(localObject1) / 1024), this.a });
          return localObject1;
        }
        o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", new Object[] { localObject1 });
        throw new b.a();
      }
      return null;
    }
    o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
    throw new b.c();
  }
  
  public void a()
  {
    Bitmap localBitmap = this.e.a(e());
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[] { e() });
      t.a(new AppBrandSimpleImageLoader.n.1(this, localBitmap));
      return;
    }
    if (AppBrandSimpleImageLoader.a(this.d).b(f()))
    {
      AppBrandSimpleImageLoader.a(this.d).a(f(), this);
      o.e("Luggage.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[] { f() });
      return;
    }
    AppBrandSimpleImageLoader.a(this.d).c(f());
    g();
  }
  
  public void b()
  {
    AppBrandSimpleImageLoader.k localk = (AppBrandSimpleImageLoader.k)AppBrandSimpleImageLoader.d(this.d).remove(d());
    if (localk != null) {
      AppBrandSimpleImageLoader.c(this.d).remove(localk);
    }
  }
  
  @MainThread
  void c()
  {
    AppBrandSimpleImageLoader.a(this.d).a(new AppBrandSimpleImageLoader.n.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.n
 * JD-Core Version:    0.7.0.1
 */