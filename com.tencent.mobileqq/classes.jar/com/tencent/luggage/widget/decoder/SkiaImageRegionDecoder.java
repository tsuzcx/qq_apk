package com.tencent.luggage.widget.decoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.widget.c;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SkiaImageRegionDecoder
  implements d
{
  private BitmapRegionDecoder a;
  private final ReadWriteLock b = new ReentrantReadWriteLock(true);
  private final Bitmap.Config c;
  
  @Keep
  public SkiaImageRegionDecoder()
  {
    this(null);
  }
  
  public SkiaImageRegionDecoder(@Nullable Bitmap.Config paramConfig)
  {
    Bitmap.Config localConfig = c.getPreferredBitmapConfig();
    if (paramConfig != null)
    {
      this.c = paramConfig;
      return;
    }
    if (localConfig != null)
    {
      this.c = localConfig;
      return;
    }
    this.c = Bitmap.Config.RGB_565;
  }
  
  private Lock c()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return this.b.writeLock();
    }
    return this.b.readLock();
  }
  
  @NonNull
  public Bitmap a(@NonNull Rect paramRect, int paramInt)
  {
    c().lock();
    try
    {
      if ((this.a != null) && (!this.a.isRecycled()))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = paramInt;
        localOptions.inPreferredConfig = this.c;
        paramRect = this.a.decodeRegion(paramRect, localOptions);
        if (paramRect != null) {
          return paramRect;
        }
        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
      }
      throw new IllegalStateException("Cannot decode region after decoder has been recycled");
    }
    finally
    {
      c().unlock();
    }
  }
  
  /* Error */
  @NonNull
  public android.graphics.Point a(android.content.Context paramContext, @NonNull android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 115	android/net/Uri:toString	()Ljava/lang/String;
    //   4: astore 4
    //   6: aload 4
    //   8: ldc 117
    //   10: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13: ifeq +158 -> 171
    //   16: aload_2
    //   17: invokevirtual 126	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   20: astore 5
    //   22: aload_1
    //   23: invokevirtual 131	android/content/Context:getPackageName	()Ljava/lang/String;
    //   26: aload 5
    //   28: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +12 -> 43
    //   34: aload_1
    //   35: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   38: astore 4
    //   40: goto +14 -> 54
    //   43: aload_1
    //   44: invokevirtual 143	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   47: aload 5
    //   49: invokevirtual 149	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   52: astore 4
    //   54: aload_2
    //   55: invokevirtual 153	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   58: astore_2
    //   59: aload_2
    //   60: invokeinterface 159 1 0
    //   65: istore_3
    //   66: iload_3
    //   67: iconst_2
    //   68: if_icmpne +44 -> 112
    //   71: aload_2
    //   72: iconst_0
    //   73: invokeinterface 163 2 0
    //   78: checkcast 119	java/lang/String
    //   81: ldc 165
    //   83: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +26 -> 112
    //   89: aload 4
    //   91: aload_2
    //   92: iconst_1
    //   93: invokeinterface 163 2 0
    //   98: checkcast 119	java/lang/String
    //   101: ldc 165
    //   103: aload 5
    //   105: invokevirtual 171	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   108: istore_3
    //   109: goto +43 -> 152
    //   112: iload_3
    //   113: iconst_1
    //   114: if_icmpne +36 -> 150
    //   117: aload_2
    //   118: iconst_0
    //   119: invokeinterface 163 2 0
    //   124: checkcast 173	java/lang/CharSequence
    //   127: invokestatic 179	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   130: ifeq +20 -> 150
    //   133: aload_2
    //   134: iconst_0
    //   135: invokeinterface 163 2 0
    //   140: checkcast 119	java/lang/String
    //   143: invokestatic 185	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   146: istore_3
    //   147: goto +5 -> 152
    //   150: iconst_0
    //   151: istore_3
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   157: iload_3
    //   158: invokevirtual 189	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   161: iconst_0
    //   162: invokestatic 193	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   165: putfield 70	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:a	Landroid/graphics/BitmapRegionDecoder;
    //   168: goto +105 -> 273
    //   171: aload 4
    //   173: ldc 195
    //   175: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   178: ifeq +31 -> 209
    //   181: aload 4
    //   183: bipush 22
    //   185: invokevirtual 199	java/lang/String:substring	(I)Ljava/lang/String;
    //   188: astore_2
    //   189: aload_0
    //   190: aload_1
    //   191: invokevirtual 203	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   194: aload_2
    //   195: iconst_1
    //   196: invokevirtual 209	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   199: iconst_0
    //   200: invokestatic 193	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   203: putfield 70	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:a	Landroid/graphics/BitmapRegionDecoder;
    //   206: goto +67 -> 273
    //   209: aload 4
    //   211: ldc 211
    //   213: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   216: ifeq +21 -> 237
    //   219: aload_0
    //   220: aload 4
    //   222: bipush 7
    //   224: invokevirtual 199	java/lang/String:substring	(I)Ljava/lang/String;
    //   227: iconst_0
    //   228: invokestatic 214	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/lang/String;Z)Landroid/graphics/BitmapRegionDecoder;
    //   231: putfield 70	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:a	Landroid/graphics/BitmapRegionDecoder;
    //   234: goto +39 -> 273
    //   237: aconst_null
    //   238: astore 4
    //   240: aload_1
    //   241: invokevirtual 218	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   244: aload_2
    //   245: invokevirtual 224	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   248: astore_1
    //   249: aload_1
    //   250: ifnull +45 -> 295
    //   253: aload_1
    //   254: astore 4
    //   256: aload_0
    //   257: aload_1
    //   258: iconst_0
    //   259: invokestatic 193	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   262: putfield 70	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:a	Landroid/graphics/BitmapRegionDecoder;
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 229	java/io/InputStream:close	()V
    //   273: new 231	android/graphics/Point
    //   276: dup
    //   277: aload_0
    //   278: getfield 70	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:a	Landroid/graphics/BitmapRegionDecoder;
    //   281: invokevirtual 234	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   284: aload_0
    //   285: getfield 70	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:a	Landroid/graphics/BitmapRegionDecoder;
    //   288: invokevirtual 237	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   291: invokespecial 240	android/graphics/Point:<init>	(II)V
    //   294: areturn
    //   295: aload_1
    //   296: astore 4
    //   298: new 109	java/lang/Exception
    //   301: dup
    //   302: ldc 242
    //   304: invokespecial 243	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   307: athrow
    //   308: astore_1
    //   309: aload 4
    //   311: ifnull +8 -> 319
    //   314: aload 4
    //   316: invokevirtual 229	java/io/InputStream:close	()V
    //   319: aload_1
    //   320: athrow
    //   321: astore_2
    //   322: goto -172 -> 150
    //   325: astore_1
    //   326: goto -53 -> 273
    //   329: astore_2
    //   330: goto -11 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	SkiaImageRegionDecoder
    //   0	333	1	paramContext	android.content.Context
    //   0	333	2	paramUri	android.net.Uri
    //   65	93	3	i	int
    //   4	311	4	localObject	Object
    //   20	84	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   240	249	308	finally
    //   256	265	308	finally
    //   298	308	308	finally
    //   133	147	321	java/lang/NumberFormatException
    //   269	273	325	java/lang/Exception
    //   314	319	329	java/lang/Exception
  }
  
  public boolean a()
  {
    try
    {
      if (this.a != null)
      {
        bool = this.a.isRecycled();
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
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   6: invokeinterface 56 1 0
    //   11: invokeinterface 68 1 0
    //   16: aload_0
    //   17: getfield 70	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:a	Landroid/graphics/BitmapRegionDecoder;
    //   20: invokevirtual 246	android/graphics/BitmapRegionDecoder:recycle	()V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 70	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:a	Landroid/graphics/BitmapRegionDecoder;
    //   28: aload_0
    //   29: getfield 30	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   32: invokeinterface 56 1 0
    //   37: invokeinterface 92 1 0
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 30	com/tencent/luggage/widget/decoder/SkiaImageRegionDecoder:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   50: invokeinterface 56 1 0
    //   55: invokeinterface 92 1 0
    //   60: aload_1
    //   61: athrow
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	SkiaImageRegionDecoder
    //   45	16	1	localObject1	Object
    //   62	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	28	45	finally
    //   2	16	62	finally
    //   28	42	62	finally
    //   46	62	62	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.decoder.SkiaImageRegionDecoder
 * JD-Core Version:    0.7.0.1
 */