package com.tencent.luggage.widget.decoder;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.widget.c;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SkiaPooledImageRegionDecoder
  implements d
{
  private static final String a = "SkiaPooledImageRegionDecoder";
  private static boolean b = false;
  private SkiaPooledImageRegionDecoder.b c = new SkiaPooledImageRegionDecoder.b(null);
  private final ReadWriteLock d = new ReentrantReadWriteLock(true);
  private final Bitmap.Config e;
  private Context f;
  private Uri g;
  private long h = 9223372036854775807L;
  private final Point i = new Point(0, 0);
  private final AtomicBoolean j = new AtomicBoolean(false);
  
  @Keep
  public SkiaPooledImageRegionDecoder()
  {
    this(null);
  }
  
  public SkiaPooledImageRegionDecoder(@Nullable Bitmap.Config paramConfig)
  {
    Bitmap.Config localConfig = c.getPreferredBitmapConfig();
    if (paramConfig != null)
    {
      this.e = paramConfig;
      return;
    }
    if (localConfig != null)
    {
      this.e = localConfig;
      return;
    }
    this.e = Bitmap.Config.RGB_565;
  }
  
  private void a(String paramString)
  {
    if (b) {
      Log.d(a, paramString);
    }
  }
  
  private void c()
  {
    if ((this.j.compareAndSet(false, true)) && (this.h < 9223372036854775807L))
    {
      a("Starting lazy init of additional decoders");
      new SkiaPooledImageRegionDecoder.1(this).start();
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:g	Landroid/net/Uri;
    //   4: invokevirtual 130	android/net/Uri:toString	()Ljava/lang/String;
    //   7: astore 8
    //   9: aload 8
    //   11: ldc 132
    //   13: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   16: istore_2
    //   17: ldc2_w 56
    //   20: lstore_3
    //   21: iload_2
    //   22: ifeq +199 -> 221
    //   25: aload_0
    //   26: getfield 124	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:g	Landroid/net/Uri;
    //   29: invokevirtual 141	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   32: astore 8
    //   34: aload_0
    //   35: getfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   38: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   41: aload 8
    //   43: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +15 -> 61
    //   49: aload_0
    //   50: getfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   53: invokevirtual 156	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   56: astore 7
    //   58: goto +17 -> 75
    //   61: aload_0
    //   62: getfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   65: invokevirtual 160	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   68: aload 8
    //   70: invokevirtual 166	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   73: astore 7
    //   75: aload_0
    //   76: getfield 124	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:g	Landroid/net/Uri;
    //   79: invokevirtual 170	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   82: astore 9
    //   84: aload 9
    //   86: invokeinterface 176 1 0
    //   91: istore_1
    //   92: iload_1
    //   93: iconst_2
    //   94: if_icmpne +46 -> 140
    //   97: aload 9
    //   99: iconst_0
    //   100: invokeinterface 180 2 0
    //   105: checkcast 134	java/lang/String
    //   108: ldc 182
    //   110: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifeq +27 -> 140
    //   116: aload 7
    //   118: aload 9
    //   120: iconst_1
    //   121: invokeinterface 180 2 0
    //   126: checkcast 134	java/lang/String
    //   129: ldc 182
    //   131: aload 8
    //   133: invokevirtual 188	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   136: istore_1
    //   137: goto +45 -> 182
    //   140: iload_1
    //   141: iconst_1
    //   142: if_icmpne +38 -> 180
    //   145: aload 9
    //   147: iconst_0
    //   148: invokeinterface 180 2 0
    //   153: checkcast 190	java/lang/CharSequence
    //   156: invokestatic 196	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +21 -> 180
    //   162: aload 9
    //   164: iconst_0
    //   165: invokeinterface 180 2 0
    //   170: checkcast 134	java/lang/String
    //   173: invokestatic 202	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   176: istore_1
    //   177: goto +5 -> 182
    //   180: iconst_0
    //   181: istore_1
    //   182: aload_0
    //   183: getfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   186: invokevirtual 156	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   189: iload_1
    //   190: invokevirtual 206	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   193: invokevirtual 212	android/content/res/AssetFileDescriptor:getLength	()J
    //   196: lstore 5
    //   198: lload 5
    //   200: lstore_3
    //   201: aload_0
    //   202: getfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   205: invokevirtual 156	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   208: iload_1
    //   209: invokevirtual 216	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   212: iconst_0
    //   213: invokestatic 222	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   216: astore 7
    //   218: goto +219 -> 437
    //   221: aload 8
    //   223: ldc 224
    //   225: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   228: ifeq +54 -> 282
    //   231: aload 8
    //   233: bipush 22
    //   235: invokevirtual 228	java/lang/String:substring	(I)Ljava/lang/String;
    //   238: astore 7
    //   240: aload_0
    //   241: getfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   244: invokevirtual 232	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   247: aload 7
    //   249: invokevirtual 238	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   252: invokevirtual 212	android/content/res/AssetFileDescriptor:getLength	()J
    //   255: lstore 5
    //   257: lload 5
    //   259: lstore_3
    //   260: aload_0
    //   261: getfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   264: invokevirtual 232	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   267: aload 7
    //   269: iconst_1
    //   270: invokevirtual 242	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   273: iconst_0
    //   274: invokestatic 222	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   277: astore 7
    //   279: goto +158 -> 437
    //   282: aload 8
    //   284: ldc 244
    //   286: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   289: ifeq +51 -> 340
    //   292: aload 8
    //   294: bipush 7
    //   296: invokevirtual 228	java/lang/String:substring	(I)Ljava/lang/String;
    //   299: iconst_0
    //   300: invokestatic 247	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/lang/String;Z)Landroid/graphics/BitmapRegionDecoder;
    //   303: astore 7
    //   305: new 249	java/io/File
    //   308: dup
    //   309: aload 8
    //   311: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   314: astore 8
    //   316: lload_3
    //   317: lstore 5
    //   319: aload 8
    //   321: invokevirtual 255	java/io/File:exists	()Z
    //   324: ifeq +10 -> 334
    //   327: aload 8
    //   329: invokevirtual 258	java/io/File:length	()J
    //   332: lstore 5
    //   334: lload 5
    //   336: lstore_3
    //   337: goto +100 -> 437
    //   340: aconst_null
    //   341: astore 8
    //   343: aload 8
    //   345: astore 7
    //   347: aload_0
    //   348: getfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   351: invokevirtual 262	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   354: astore 10
    //   356: aload 8
    //   358: astore 7
    //   360: aload 10
    //   362: aload_0
    //   363: getfield 124	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:g	Landroid/net/Uri;
    //   366: invokevirtual 268	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   369: astore 9
    //   371: aload 9
    //   373: astore 7
    //   375: aload 9
    //   377: iconst_0
    //   378: invokestatic 222	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   381: astore 8
    //   383: aload 9
    //   385: astore 7
    //   387: aload 10
    //   389: aload_0
    //   390: getfield 124	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:g	Landroid/net/Uri;
    //   393: ldc_w 270
    //   396: invokevirtual 274	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   399: astore 10
    //   401: lload_3
    //   402: lstore 5
    //   404: aload 10
    //   406: ifnull +14 -> 420
    //   409: aload 9
    //   411: astore 7
    //   413: aload 10
    //   415: invokevirtual 212	android/content/res/AssetFileDescriptor:getLength	()J
    //   418: lstore 5
    //   420: aload 9
    //   422: ifnull +8 -> 430
    //   425: aload 9
    //   427: invokevirtual 279	java/io/InputStream:close	()V
    //   430: aload 8
    //   432: astore 7
    //   434: lload 5
    //   436: lstore_3
    //   437: aload_0
    //   438: lload_3
    //   439: putfield 59	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:h	J
    //   442: aload_0
    //   443: getfield 66	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:i	Landroid/graphics/Point;
    //   446: aload 7
    //   448: invokevirtual 282	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   451: aload 7
    //   453: invokevirtual 285	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   456: invokevirtual 288	android/graphics/Point:set	(II)V
    //   459: aload_0
    //   460: getfield 55	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   463: invokeinterface 294 1 0
    //   468: invokeinterface 299 1 0
    //   473: aload_0
    //   474: getfield 48	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:c	Lcom/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b;
    //   477: ifnull +12 -> 489
    //   480: aload_0
    //   481: getfield 48	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:c	Lcom/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b;
    //   484: aload 7
    //   486: invokestatic 302	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b:a	(Lcom/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b;Landroid/graphics/BitmapRegionDecoder;)V
    //   489: aload_0
    //   490: getfield 55	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   493: invokeinterface 294 1 0
    //   498: invokeinterface 305 1 0
    //   503: return
    //   504: astore 7
    //   506: aload_0
    //   507: getfield 55	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   510: invokeinterface 294 1 0
    //   515: invokeinterface 305 1 0
    //   520: aload 7
    //   522: athrow
    //   523: astore 8
    //   525: aload 7
    //   527: ifnull +8 -> 535
    //   530: aload 7
    //   532: invokevirtual 279	java/io/InputStream:close	()V
    //   535: aload 8
    //   537: athrow
    //   538: astore 7
    //   540: goto -360 -> 180
    //   543: astore 7
    //   545: goto -344 -> 201
    //   548: astore 8
    //   550: goto -290 -> 260
    //   553: astore 8
    //   555: lload_3
    //   556: lstore 5
    //   558: goto -224 -> 334
    //   561: astore 7
    //   563: lload_3
    //   564: lstore 5
    //   566: goto -146 -> 420
    //   569: astore 7
    //   571: goto -141 -> 430
    //   574: astore 7
    //   576: goto -41 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	SkiaPooledImageRegionDecoder
    //   91	118	1	k	int
    //   16	6	2	bool	boolean
    //   20	544	3	l1	long
    //   196	369	5	l2	long
    //   56	429	7	localObject1	Object
    //   504	27	7	localObject2	Object
    //   538	1	7	localNumberFormatException	java.lang.NumberFormatException
    //   543	1	7	localException1	Exception
    //   561	1	7	localException2	Exception
    //   569	1	7	localException3	Exception
    //   574	1	7	localException4	Exception
    //   7	424	8	localObject3	Object
    //   523	13	8	localObject4	Object
    //   548	1	8	localException5	Exception
    //   553	1	8	localException6	Exception
    //   82	344	9	localObject5	Object
    //   354	60	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   473	489	504	finally
    //   347	356	523	finally
    //   360	371	523	finally
    //   375	383	523	finally
    //   387	401	523	finally
    //   413	420	523	finally
    //   162	177	538	java/lang/NumberFormatException
    //   182	198	543	java/lang/Exception
    //   240	257	548	java/lang/Exception
    //   305	316	553	java/lang/Exception
    //   319	334	553	java/lang/Exception
    //   387	401	561	java/lang/Exception
    //   413	420	561	java/lang/Exception
    //   425	430	569	java/lang/Exception
    //   530	535	574	java/lang/Exception
  }
  
  private int e()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Runtime.getRuntime().availableProcessors();
    }
    return f();
  }
  
  private int f()
  {
    try
    {
      int k = new File("/sys/devices/system/cpu/").listFiles(new SkiaPooledImageRegionDecoder.a(this)).length;
      return k;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return 1;
  }
  
  private boolean g()
  {
    ActivityManager localActivityManager = (ActivityManager)this.f.getSystemService("activity");
    if (localActivityManager != null)
    {
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.lowMemory;
    }
    return true;
  }
  
  @Keep
  public static void setDebug(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  @NonNull
  public Bitmap a(@NonNull Rect paramRect, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Decode region ");
    ((StringBuilder)localObject).append(paramRect);
    ((StringBuilder)localObject).append(" on thread ");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    a(((StringBuilder)localObject).toString());
    if ((paramRect.width() < this.i.x) || (paramRect.height() < this.i.y)) {
      c();
    }
    this.d.readLock().lock();
    try
    {
      if (this.c != null)
      {
        localObject = SkiaPooledImageRegionDecoder.b.b(this.c);
        if (localObject != null) {
          try
          {
            if (!((BitmapRegionDecoder)localObject).isRecycled())
            {
              BitmapFactory.Options localOptions = new BitmapFactory.Options();
              localOptions.inSampleSize = paramInt;
              localOptions.inPreferredConfig = this.e;
              paramRect = ((BitmapRegionDecoder)localObject).decodeRegion(paramRect, localOptions);
              if (paramRect != null)
              {
                if (localObject != null) {
                  SkiaPooledImageRegionDecoder.b.b(this.c, (BitmapRegionDecoder)localObject);
                }
                return paramRect;
              }
              throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
          }
          finally
          {
            if (localObject != null) {
              SkiaPooledImageRegionDecoder.b.b(this.c, (BitmapRegionDecoder)localObject);
            }
          }
        }
        if (localObject != null) {
          SkiaPooledImageRegionDecoder.b.b(this.c, (BitmapRegionDecoder)localObject);
        }
      }
      throw new IllegalStateException("Cannot decode region after decoder has been recycled");
    }
    finally
    {
      this.d.readLock().unlock();
    }
  }
  
  @NonNull
  public Point a(Context paramContext, @NonNull Uri paramUri)
  {
    this.f = paramContext;
    this.g = paramUri;
    d();
    return this.i;
  }
  
  public boolean a()
  {
    try
    {
      if (this.c != null)
      {
        bool = SkiaPooledImageRegionDecoder.b.c(this.c);
        if (!bool)
        {
          bool = true;
          break label28;
        }
      }
      boolean bool = false;
      label28:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean a(int paramInt, long paramLong)
  {
    if (paramInt >= 4)
    {
      a("No additional decoders allowed, reached hard limit (4)");
      return false;
    }
    paramLong = paramInt * paramLong;
    if (paramLong > 20971520L)
    {
      a("No additional encoders allowed, reached hard memory limit (20Mb)");
      return false;
    }
    if (paramInt >= e())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("No additional encoders allowed, limited by CPU cores (");
      localStringBuilder.append(e());
      localStringBuilder.append(")");
      a(localStringBuilder.toString());
      return false;
    }
    if (g())
    {
      a("No additional encoders allowed, memory is low");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Additional decoder allowed, current count is ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", estimated native memory ");
    localStringBuilder.append(paramLong / 1048576L);
    localStringBuilder.append("Mb");
    a(localStringBuilder.toString());
    return true;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   6: invokeinterface 294 1 0
    //   11: invokeinterface 299 1 0
    //   16: aload_0
    //   17: getfield 48	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:c	Lcom/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b;
    //   20: ifnull +25 -> 45
    //   23: aload_0
    //   24: getfield 48	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:c	Lcom/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b;
    //   27: invokestatic 462	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b:d	(Lcom/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b;)V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 48	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:c	Lcom/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder$b;
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 143	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:f	Landroid/content/Context;
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 124	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:g	Landroid/net/Uri;
    //   45: aload_0
    //   46: getfield 55	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   49: invokeinterface 294 1 0
    //   54: invokeinterface 305 1 0
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 55	com/tencent/luggage/widget/decoder/SkiaPooledImageRegionDecoder:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   67: invokeinterface 294 1 0
    //   72: invokeinterface 305 1 0
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	SkiaPooledImageRegionDecoder
    //   62	16	1	localObject1	Object
    //   79	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	45	62	finally
    //   2	16	79	finally
    //   45	59	79	finally
    //   63	79	79	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.decoder.SkiaPooledImageRegionDecoder
 * JD-Core Version:    0.7.0.1
 */