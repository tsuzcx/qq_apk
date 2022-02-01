package com.tencent.mm.modelappbrand.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.gl.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AppBrandSimpleImageLoader
{
  private static String g;
  private static AppBrandSimpleImageLoader.g h = AppBrandSimpleImageLoader.g.a;
  private final Map<AppBrandSimpleImageLoader.k, String> a = new ConcurrentHashMap();
  private final Map<String, AppBrandSimpleImageLoader.k> b = new ConcurrentHashMap();
  private final Map<Integer, String> c = new ConcurrentHashMap();
  private final AppBrandSimpleImageLoader.e d = new AppBrandSimpleImageLoader.e(new s("AppBrandSimpleImageLoaderDiskIOHandlerThread"), null);
  private final AppBrandSimpleImageLoader.l e = new AppBrandSimpleImageLoader.d();
  private final AppBrandSimpleImageLoader.i f = new AppBrandSimpleImageLoader.b(null);
  
  static
  {
    i locali2 = i.a(r.a().getExternalCacheDir());
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = i.a(r.a().getCacheDir());
    }
    if (locali1 != null) {
      resetCacheRoot(locali1.l());
    }
  }
  
  private static String b(String paramString, AppBrandSimpleImageLoader.h paramh, AppBrandSimpleImageLoader.f paramf)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (paramh != null)
    {
      localStringBuilder.append("|transformation:");
      localStringBuilder.append(paramh.a());
    }
    if (paramf != null)
    {
      localStringBuilder.append("|decoder:");
      localStringBuilder.append(paramf.a());
    }
    return localStringBuilder.toString();
  }
  
  private static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  /* Error */
  @WorkerThread
  private byte[] b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 146	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 81	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader:f	Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$i;
    //   13: new 148	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p
    //   16: dup
    //   17: aload_1
    //   18: aconst_null
    //   19: invokespecial 151	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:<init>	(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$1;)V
    //   22: invokestatic 154	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	(Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p;)Ljava/lang/String;
    //   25: invokeinterface 159 2 0
    //   30: astore 5
    //   32: aload 5
    //   34: ifnonnull +15 -> 49
    //   37: aload 5
    //   39: ifnull +8 -> 47
    //   42: aload 5
    //   44: invokevirtual 164	java/io/InputStream:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: aload 5
    //   51: invokestatic 170	org/apache/commons/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   54: astore_2
    //   55: aload 5
    //   57: ifnull +8 -> 65
    //   60: aload 5
    //   62: invokevirtual 164	java/io/InputStream:close	()V
    //   65: aload_2
    //   66: areturn
    //   67: astore_2
    //   68: aconst_null
    //   69: astore 4
    //   71: goto +12 -> 83
    //   74: astore_2
    //   75: aload_2
    //   76: athrow
    //   77: astore_3
    //   78: aload_2
    //   79: astore 4
    //   81: aload_3
    //   82: astore_2
    //   83: aload 5
    //   85: ifnull +21 -> 106
    //   88: aload 4
    //   90: ifnull +11 -> 101
    //   93: aload 5
    //   95: invokevirtual 164	java/io/InputStream:close	()V
    //   98: goto +8 -> 106
    //   101: aload 5
    //   103: invokevirtual 164	java/io/InputStream:close	()V
    //   106: aload_2
    //   107: athrow
    //   108: ldc 172
    //   110: ldc 174
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: invokestatic 179	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_2
    //   126: goto -18 -> 108
    //   129: astore_3
    //   130: goto -24 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	AppBrandSimpleImageLoader
    //   0	133	1	paramString	String
    //   54	12	2	arrayOfByte	byte[]
    //   67	1	2	localObject1	Object
    //   74	5	2	localThrowable1	java.lang.Throwable
    //   82	25	2	localObject2	Object
    //   125	1	2	localIOException	java.io.IOException
    //   77	5	3	localObject3	Object
    //   129	1	3	localThrowable2	java.lang.Throwable
    //   69	20	4	localThrowable3	java.lang.Throwable
    //   30	72	5	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   49	55	67	finally
    //   49	55	74	java/lang/Throwable
    //   75	77	77	finally
    //   9	32	125	java/io/IOException
    //   42	47	125	java/io/IOException
    //   60	65	125	java/io/IOException
    //   93	98	125	java/io/IOException
    //   101	106	125	java/io/IOException
    //   106	108	125	java/io/IOException
    //   93	98	129	java/lang/Throwable
  }
  
  private static String c(String paramString)
  {
    if (!af.c(paramString)) {
      return c.a(paramString.getBytes());
    }
    return null;
  }
  
  private boolean c()
  {
    if (TextUtils.isEmpty(g)) {
      return false;
    }
    return new i(g).i();
  }
  
  private static AppBrandSimpleImageLoader.g d()
  {
    synchronized ()
    {
      AppBrandSimpleImageLoader.g localg = h;
      return localg;
    }
  }
  
  public static AppBrandSimpleImageLoader instance()
  {
    return AppBrandSimpleImageLoader.o.a;
  }
  
  public static void resetBitmapFactory(AppBrandSimpleImageLoader.g paramg)
  {
    if (paramg == null) {
      return;
    }
    synchronized (instance())
    {
      h = paramg;
      return;
    }
  }
  
  public static void resetCacheRoot(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.endsWith("/"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject);
    paramString.append("wxacache/");
    g = paramString.toString();
    k.g(g);
  }
  
  @MainThread
  public String attach(@NonNull ImageView paramImageView, String paramString, int paramInt, AppBrandSimpleImageLoader.h paramh)
  {
    if (paramImageView == null) {
      return null;
    }
    return attach(paramImageView, paramString, paramImageView.getContext().getResources().getDrawable(paramInt), paramh);
  }
  
  @MainThread
  public String attach(@NonNull ImageView paramImageView, String paramString, @Nullable Drawable paramDrawable, @Nullable AppBrandSimpleImageLoader.h paramh)
  {
    return attach(paramImageView, paramString, paramDrawable, paramh, null);
  }
  
  @MainThread
  public String attach(@NonNull ImageView paramImageView, String paramString, Drawable paramDrawable, AppBrandSimpleImageLoader.h paramh, AppBrandSimpleImageLoader.f paramf)
  {
    if (paramImageView == null) {
      return null;
    }
    cancel(paramImageView);
    if (af.c(paramString))
    {
      if (paramDrawable != null) {
        paramImageView.setImageDrawable(paramDrawable);
      }
      return null;
    }
    paramDrawable = new AppBrandSimpleImageLoader.2(this, paramImageView, this, paramDrawable);
    paramString = load(paramDrawable, paramString, paramh, paramf);
    if (!paramDrawable.c) {
      this.c.put(Integer.valueOf(paramImageView.hashCode()), b(AppBrandSimpleImageLoader.m.a(paramDrawable), paramString));
    }
    return paramString;
  }
  
  @MainThread
  public void cancel(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView = (String)this.c.remove(Integer.valueOf(paramImageView.hashCode()));
    if (paramImageView == null) {
      return;
    }
    cancel((AppBrandSimpleImageLoader.k)this.b.get(paramImageView));
  }
  
  @MainThread
  public void cancel(AppBrandSimpleImageLoader.k paramk)
  {
    if (paramk == null) {
      return;
    }
    paramk = (String)this.a.remove(paramk);
    if (!af.c(paramk)) {
      this.b.remove(paramk);
    }
  }
  
  public void clearCache()
  {
    this.e.a();
  }
  
  public void deleteDiskCacheByUrl(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    paramString = c(paramString);
    if (this.d.b(paramString)) {
      return;
    }
    this.f.c(paramString);
  }
  
  public void deleteMemoryCacheByUrl(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    this.e.b(paramString);
  }
  
  public Bitmap findCachedInMemory(String paramString)
  {
    paramString = this.e.a(paramString);
    if ((paramString != null) && (!paramString.isRecycled())) {
      return paramString;
    }
    return null;
  }
  
  @WorkerThread
  public Bitmap findCachedLocal(String paramString)
  {
    return findCachedLocal(paramString, null);
  }
  
  /* Error */
  @WorkerThread
  public Bitmap findCachedLocal(String paramString, AppBrandSimpleImageLoader.f paramf)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 146	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: iload_3
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: aload_1
    //   15: aconst_null
    //   16: aload_2
    //   17: invokestatic 104	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader:b	(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$h;Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$f;)Ljava/lang/String;
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 74	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader:e	Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$l;
    //   26: aload 5
    //   28: invokeinterface 324 2 0
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +6 -> 43
    //   40: aload 6
    //   42: areturn
    //   43: aload_1
    //   44: ldc_w 339
    //   47: invokevirtual 342	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: istore_3
    //   51: iload_3
    //   52: ifeq +25 -> 77
    //   55: aload_1
    //   56: invokestatic 344	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   59: astore_1
    //   60: goto +31 -> 91
    //   63: ldc 172
    //   65: ldc_w 346
    //   68: invokestatic 349	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aconst_null
    //   72: invokestatic 352	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   75: aconst_null
    //   76: areturn
    //   77: aload_0
    //   78: getfield 81	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader:f	Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$i;
    //   81: aload_1
    //   82: invokestatic 101	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader:c	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokeinterface 159 2 0
    //   90: astore_1
    //   91: aload_1
    //   92: ifnonnull +9 -> 101
    //   95: aload_1
    //   96: invokestatic 352	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   99: aconst_null
    //   100: areturn
    //   101: aload_2
    //   102: ifnull +14 -> 116
    //   105: aload_2
    //   106: aload_1
    //   107: invokeinterface 355 2 0
    //   112: astore_2
    //   113: goto +13 -> 126
    //   116: invokestatic 114	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader:d	()Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$g;
    //   119: aload_1
    //   120: invokeinterface 356 2 0
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +15 -> 142
    //   130: aload_0
    //   131: getfield 74	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader:e	Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$l;
    //   134: aload 5
    //   136: aload_2
    //   137: invokeinterface 359 3 0
    //   142: aload_1
    //   143: invokestatic 352	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   146: aload_2
    //   147: areturn
    //   148: astore_2
    //   149: goto +37 -> 186
    //   152: astore_2
    //   153: goto +13 -> 166
    //   156: astore_2
    //   157: aload 4
    //   159: astore_1
    //   160: goto +26 -> 186
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: ldc 172
    //   168: aload_2
    //   169: ldc_w 360
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 363	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload_1
    //   180: invokestatic 352	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_2
    //   186: aload_1
    //   187: invokestatic 352	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   190: aload_2
    //   191: athrow
    //   192: astore_1
    //   193: goto -130 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	AppBrandSimpleImageLoader
    //   0	196	1	paramString	String
    //   0	196	2	paramf	AppBrandSimpleImageLoader.f
    //   4	48	3	bool	boolean
    //   6	152	4	localObject	Object
    //   20	115	5	str	String
    //   33	8	6	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   105	113	148	finally
    //   116	126	148	finally
    //   130	142	148	finally
    //   105	113	152	java/lang/Exception
    //   116	126	152	java/lang/Exception
    //   130	142	152	java/lang/Exception
    //   43	51	156	finally
    //   55	60	156	finally
    //   63	71	156	finally
    //   77	91	156	finally
    //   43	51	163	java/lang/Exception
    //   55	60	163	java/lang/Exception
    //   63	71	163	java/lang/Exception
    //   77	91	163	java/lang/Exception
    //   166	179	185	finally
    //   55	60	192	java/io/FileNotFoundException
  }
  
  @MainThread
  public String load(@NonNull AppBrandSimpleImageLoader.k paramk, String paramString, AppBrandSimpleImageLoader.h paramh)
  {
    return load(paramk, paramString, paramh, null);
  }
  
  public String load(@NonNull AppBrandSimpleImageLoader.k paramk, String paramString, AppBrandSimpleImageLoader.h paramh, AppBrandSimpleImageLoader.f paramf)
  {
    return load(paramk, paramString, null, paramh, paramf);
  }
  
  public String load(@NonNull AppBrandSimpleImageLoader.k paramk, String paramString, @Nullable Map<String, String> paramMap, AppBrandSimpleImageLoader.h paramh, AppBrandSimpleImageLoader.f paramf)
  {
    if (paramk == null) {
      return null;
    }
    if (af.c(paramString))
    {
      paramk.c();
      return null;
    }
    try
    {
      if ("null".equals(Uri.parse(paramString).getHost()))
      {
        paramk.c();
        return null;
      }
    }
    catch (Exception localException)
    {
      label45:
      Object localObject;
      break label45;
    }
    o.e("Luggage.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[] { paramString });
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramk.a());
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(paramk.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    paramh = new AppBrandSimpleImageLoader.n(paramString, paramMap, paramh, this, this.e, this.f, paramf, (String)localObject);
    paramMap = AppBrandSimpleImageLoader.n.a(paramh);
    paramk = new AppBrandSimpleImageLoader.1(this, paramMap, paramk, paramString, paramh);
    if (t.a())
    {
      paramk.run();
      return paramMap;
    }
    t.a(paramk);
    return paramMap;
  }
  
  public String load(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    return load(new AppBrandSimpleImageLoader.c(), paramString, null);
  }
  
  public void load(@NonNull String paramString, AppBrandSimpleImageLoader.j paramj)
  {
    load(paramString, null, paramj);
  }
  
  public void load(@NonNull String paramString, @Nullable Map<String, String> paramMap, AppBrandSimpleImageLoader.j paramj)
  {
    byte[] arrayOfByte = b(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      if (paramj != null) {
        paramj.a(arrayOfByte);
      }
      return;
    }
    load(new AppBrandSimpleImageLoader.3(this, paramString, paramj), paramString, paramMap, null, null);
  }
  
  public String loadIntoDiskCache(String paramString, @Nullable Map<String, String> paramMap, Function<InputStream, Void> paramFunction)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramFunction != null) {
        paramFunction.apply(null);
      }
      return null;
    }
    AppBrandSimpleImageLoader.p localp = new AppBrandSimpleImageLoader.p(paramString, null);
    AppBrandSimpleImageLoader.e.a(this.d).a(new AppBrandSimpleImageLoader.a(this, this, localp, paramFunction, paramString, paramMap));
    return AppBrandSimpleImageLoader.p.a(localp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader
 * JD-Core Version:    0.7.0.1
 */