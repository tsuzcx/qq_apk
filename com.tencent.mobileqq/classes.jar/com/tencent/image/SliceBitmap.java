package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IReport;
import com.tencent.image.api.URLDrawableDepWrap;

public class SliceBitmap
{
  public static final int DEFAULT_TEXTURE_BITMAP_SIZE = 2048;
  public static final int DENSITY_NONE = 0;
  private static final int SLICE_SIZE = 2048;
  public static final String TAG_REPORT_TEXTURE_MAX_SIZE = "texture_max_size";
  public static int gl_max_texture_size;
  boolean hasAlpha;
  Bitmap[] mBitmaps;
  int mChangingConfigurations;
  int mColumnCount;
  int mDensity;
  int mHeight;
  int mRowCount;
  int mWidth;
  
  public SliceBitmap(Bitmap paramBitmap)
  {
    if (needSlice(paramBitmap))
    {
      this.mWidth = paramBitmap.getWidth();
      this.mHeight = paramBitmap.getHeight();
      this.mDensity = paramBitmap.getDensity();
      this.hasAlpha = paramBitmap.hasAlpha();
      this.mRowCount = ((this.mWidth + 2048 - 1) / 2048);
      this.mColumnCount = ((this.mHeight + 2048 - 1) / 2048);
      Bitmap[] arrayOfBitmap = new Bitmap[this.mRowCount * this.mColumnCount];
      int j = 0;
      int i = 0;
      while (j < this.mRowCount)
      {
        int k = 0;
        while (k < this.mColumnCount)
        {
          int i1 = j * 2048;
          int i2 = k * 2048;
          int m = this.mWidth;
          if (i1 + 2048 > m) {
            m -= i1;
          } else {
            m = 2048;
          }
          int n = this.mHeight;
          if (i2 + 2048 > n) {
            n -= i2;
          } else {
            n = 2048;
          }
          arrayOfBitmap[i] = Bitmap.createBitmap(paramBitmap, i1, i2, m, n);
          i += 1;
          k += 1;
        }
        j += 1;
      }
      this.mBitmaps = arrayOfBitmap;
      return;
    }
    paramBitmap = new IllegalArgumentException("the bitmap no need to Slice");
    for (;;)
    {
      throw paramBitmap;
    }
  }
  
  /* Error */
  public static int getTextureBitmapMaxSize()
  {
    // Byte code:
    //   0: getstatic 84	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_1
    //   4: sipush 2048
    //   7: istore_0
    //   8: iload_1
    //   9: bipush 17
    //   11: if_icmplt +503 -> 514
    //   14: iconst_0
    //   15: invokestatic 90	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   18: astore_2
    //   19: iconst_2
    //   20: newarray int
    //   22: astore_3
    //   23: aload_2
    //   24: aload_3
    //   25: iconst_0
    //   26: aload_3
    //   27: iconst_1
    //   28: invokestatic 94	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   31: pop
    //   32: iconst_1
    //   33: anewarray 96	android/opengl/EGLConfig
    //   36: astore_3
    //   37: iconst_1
    //   38: newarray int
    //   40: astore 4
    //   42: aload_2
    //   43: bipush 9
    //   45: newarray int
    //   47: dup
    //   48: iconst_0
    //   49: sipush 12351
    //   52: iastore
    //   53: dup
    //   54: iconst_1
    //   55: sipush 12430
    //   58: iastore
    //   59: dup
    //   60: iconst_2
    //   61: sipush 12329
    //   64: iastore
    //   65: dup
    //   66: iconst_3
    //   67: iconst_0
    //   68: iastore
    //   69: dup
    //   70: iconst_4
    //   71: sipush 12352
    //   74: iastore
    //   75: dup
    //   76: iconst_5
    //   77: iconst_4
    //   78: iastore
    //   79: dup
    //   80: bipush 6
    //   82: sipush 12339
    //   85: iastore
    //   86: dup
    //   87: bipush 7
    //   89: iconst_1
    //   90: iastore
    //   91: dup
    //   92: bipush 8
    //   94: sipush 12344
    //   97: iastore
    //   98: iconst_0
    //   99: aload_3
    //   100: iconst_0
    //   101: iconst_1
    //   102: aload 4
    //   104: iconst_0
    //   105: invokestatic 100	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   108: pop
    //   109: aload 4
    //   111: iconst_0
    //   112: iaload
    //   113: istore_1
    //   114: iload_1
    //   115: ifne +30 -> 145
    //   118: aload_2
    //   119: ifnull +22 -> 141
    //   122: aload_2
    //   123: getstatic 104	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   126: getstatic 104	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   129: getstatic 108	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   132: invokestatic 112	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   135: pop
    //   136: aload_2
    //   137: invokestatic 116	android/opengl/EGL14:eglTerminate	(Landroid/opengl/EGLDisplay;)Z
    //   140: pop
    //   141: sipush 2048
    //   144: ireturn
    //   145: aload_3
    //   146: iconst_0
    //   147: aaload
    //   148: astore 4
    //   150: aload_2
    //   151: aload 4
    //   153: iconst_5
    //   154: newarray int
    //   156: dup
    //   157: iconst_0
    //   158: sipush 12375
    //   161: iastore
    //   162: dup
    //   163: iconst_1
    //   164: bipush 64
    //   166: iastore
    //   167: dup
    //   168: iconst_2
    //   169: sipush 12374
    //   172: iastore
    //   173: dup
    //   174: iconst_3
    //   175: bipush 64
    //   177: iastore
    //   178: dup
    //   179: iconst_4
    //   180: sipush 12344
    //   183: iastore
    //   184: iconst_0
    //   185: invokestatic 120	android/opengl/EGL14:eglCreatePbufferSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;[II)Landroid/opengl/EGLSurface;
    //   188: astore_3
    //   189: aload_2
    //   190: aload 4
    //   192: getstatic 108	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   195: iconst_3
    //   196: newarray int
    //   198: dup
    //   199: iconst_0
    //   200: sipush 12440
    //   203: iastore
    //   204: dup
    //   205: iconst_1
    //   206: iconst_2
    //   207: iastore
    //   208: dup
    //   209: iconst_2
    //   210: sipush 12344
    //   213: iastore
    //   214: iconst_0
    //   215: invokestatic 124	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   218: astore 5
    //   220: aload_2
    //   221: aload_3
    //   222: aload_3
    //   223: aload 5
    //   225: invokestatic 112	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   228: pop
    //   229: iconst_1
    //   230: newarray int
    //   232: astore 4
    //   234: sipush 3379
    //   237: aload 4
    //   239: iconst_0
    //   240: invokestatic 130	android/opengl/GLES20:glGetIntegerv	(I[II)V
    //   243: aload 4
    //   245: iconst_0
    //   246: iaload
    //   247: sipush 2048
    //   250: if_icmple +8 -> 258
    //   253: aload 4
    //   255: iconst_0
    //   256: iaload
    //   257: istore_0
    //   258: aload_2
    //   259: ifnull +44 -> 303
    //   262: aload_2
    //   263: getstatic 104	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   266: getstatic 104	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   269: getstatic 108	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   272: invokestatic 112	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   275: pop
    //   276: aload_3
    //   277: ifnull +9 -> 286
    //   280: aload_2
    //   281: aload_3
    //   282: invokestatic 134	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   285: pop
    //   286: aload 5
    //   288: ifnull +10 -> 298
    //   291: aload_2
    //   292: aload 5
    //   294: invokestatic 138	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   297: pop
    //   298: aload_2
    //   299: invokestatic 116	android/opengl/EGL14:eglTerminate	(Landroid/opengl/EGLDisplay;)Z
    //   302: pop
    //   303: iload_0
    //   304: ireturn
    //   305: astore 4
    //   307: goto +159 -> 466
    //   310: astore 7
    //   312: aload 5
    //   314: astore 6
    //   316: aload_2
    //   317: astore 5
    //   319: aload_3
    //   320: astore 4
    //   322: aload 6
    //   324: astore_2
    //   325: goto +63 -> 388
    //   328: astore 4
    //   330: goto +21 -> 351
    //   333: astore 5
    //   335: aload_3
    //   336: astore 4
    //   338: aload 5
    //   340: astore_3
    //   341: aload_2
    //   342: astore 5
    //   344: goto +39 -> 383
    //   347: astore 4
    //   349: aconst_null
    //   350: astore_3
    //   351: aconst_null
    //   352: astore 5
    //   354: goto +112 -> 466
    //   357: astore_3
    //   358: aload_2
    //   359: astore 5
    //   361: goto +19 -> 380
    //   364: astore 4
    //   366: aconst_null
    //   367: astore_3
    //   368: aconst_null
    //   369: astore 5
    //   371: aconst_null
    //   372: astore_2
    //   373: goto +93 -> 466
    //   376: astore_3
    //   377: aconst_null
    //   378: astore 5
    //   380: aconst_null
    //   381: astore 4
    //   383: aconst_null
    //   384: astore_2
    //   385: aload_3
    //   386: astore 7
    //   388: aload 7
    //   390: invokevirtual 141	java/lang/Throwable:printStackTrace	()V
    //   393: aload 5
    //   395: ifnull +119 -> 514
    //   398: aload 5
    //   400: getstatic 104	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   403: getstatic 104	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   406: getstatic 108	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   409: invokestatic 112	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   412: pop
    //   413: aload 4
    //   415: ifnull +11 -> 426
    //   418: aload 5
    //   420: aload 4
    //   422: invokestatic 134	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   425: pop
    //   426: aload_2
    //   427: ifnull +10 -> 437
    //   430: aload 5
    //   432: aload_2
    //   433: invokestatic 138	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   436: pop
    //   437: aload 5
    //   439: invokestatic 116	android/opengl/EGL14:eglTerminate	(Landroid/opengl/EGLDisplay;)Z
    //   442: pop
    //   443: sipush 2048
    //   446: ireturn
    //   447: astore 6
    //   449: aload 4
    //   451: astore_3
    //   452: aload_2
    //   453: astore 4
    //   455: aload 5
    //   457: astore_2
    //   458: aload 4
    //   460: astore 5
    //   462: aload 6
    //   464: astore 4
    //   466: aload_2
    //   467: ifnull +44 -> 511
    //   470: aload_2
    //   471: getstatic 104	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   474: getstatic 104	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   477: getstatic 108	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   480: invokestatic 112	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   483: pop
    //   484: aload_3
    //   485: ifnull +9 -> 494
    //   488: aload_2
    //   489: aload_3
    //   490: invokestatic 134	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   493: pop
    //   494: aload 5
    //   496: ifnull +10 -> 506
    //   499: aload_2
    //   500: aload 5
    //   502: invokestatic 138	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   505: pop
    //   506: aload_2
    //   507: invokestatic 116	android/opengl/EGL14:eglTerminate	(Landroid/opengl/EGLDisplay;)Z
    //   510: pop
    //   511: aload 4
    //   513: athrow
    //   514: sipush 2048
    //   517: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	297	0	i	int
    //   3	112	1	j	int
    //   18	489	2	localObject1	Object
    //   22	329	3	localObject2	Object
    //   357	1	3	localThrowable1	java.lang.Throwable
    //   367	1	3	localObject3	Object
    //   376	10	3	localThrowable2	java.lang.Throwable
    //   451	39	3	localObject4	Object
    //   40	214	4	arrayOfInt	int[]
    //   305	1	4	localObject5	Object
    //   320	1	4	localObject6	Object
    //   328	1	4	localObject7	Object
    //   336	1	4	localObject8	Object
    //   347	1	4	localObject9	Object
    //   364	1	4	localObject10	Object
    //   381	131	4	localObject11	Object
    //   218	100	5	localObject12	Object
    //   333	6	5	localThrowable3	java.lang.Throwable
    //   342	159	5	localObject13	Object
    //   314	9	6	localObject14	Object
    //   447	16	6	localObject15	Object
    //   310	1	7	localThrowable4	java.lang.Throwable
    //   386	3	7	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   220	243	305	finally
    //   220	243	310	java/lang/Throwable
    //   189	220	328	finally
    //   189	220	333	java/lang/Throwable
    //   19	109	347	finally
    //   150	189	347	finally
    //   19	109	357	java/lang/Throwable
    //   150	189	357	java/lang/Throwable
    //   14	19	364	finally
    //   14	19	376	java/lang/Throwable
    //   388	393	447	finally
  }
  
  public static boolean needSlice(Bitmap paramBitmap)
  {
    return (paramBitmap.getWidth() > 2048) || (paramBitmap.getHeight() > 2048);
  }
  
  public static boolean needSliceBitmap(Bitmap paramBitmap)
  {
    if (gl_max_texture_size == 0)
    {
      gl_max_texture_size = getTextureBitmapMaxSize();
      Object localObject = new ReportBean("texture_max_size");
      ((ReportBean)localObject).size = gl_max_texture_size;
      URLDrawable.depImp.mReport.report((ReportBean)localObject);
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localObject = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init TextureBitmapMaxSize:");
        localStringBuilder.append(gl_max_texture_size);
        ((ILog)localObject).i("URLDrawable_", 2, localStringBuilder.toString());
      }
    }
    return (paramBitmap.getWidth() > gl_max_texture_size) || (paramBitmap.getHeight() > gl_max_texture_size);
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 == paramInt3) {
        return paramInt1;
      }
      i = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
    }
    return i;
  }
  
  void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    int m = paramCanvas.save();
    boolean bool = paramCanvas.isHardwareAccelerated();
    int n = paramCanvas.getDensity();
    paramCanvas.translate(paramRect.left, paramRect.top);
    if ((paramRect.width() != this.mWidth) || (paramRect.height() != this.mHeight)) {
      paramCanvas.scale(paramRect.width() / this.mWidth, paramRect.height() / this.mHeight);
    }
    if (!bool) {
      paramCanvas.setDensity(this.mDensity);
    }
    int j = 0;
    int i = 0;
    while (j < this.mRowCount)
    {
      int k = 0;
      while (k < this.mColumnCount)
      {
        paramRect = this.mBitmaps[i];
        if (paramRect != null) {
          paramCanvas.drawBitmap(paramRect, j * 2048, k * 2048, paramPaint);
        }
        i += 1;
        k += 1;
      }
      j += 1;
    }
    if (!bool) {
      paramCanvas.setDensity(n);
    }
    paramCanvas.restoreToCount(m);
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    Bitmap[] arrayOfBitmap = this.mBitmaps;
    if ((arrayOfBitmap != null) && (arrayOfBitmap.length > paramInt)) {
      return arrayOfBitmap[paramInt];
    }
    return null;
  }
  
  public final int getByteCount()
  {
    Bitmap[] arrayOfBitmap = this.mBitmaps;
    int k = arrayOfBitmap.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += Utils.getBitmapSize(arrayOfBitmap[i]);
      i += 1;
    }
    return j;
  }
  
  public int getColumnCount()
  {
    return this.mColumnCount;
  }
  
  public final int getHeight()
  {
    return this.mHeight;
  }
  
  public int getRowCount()
  {
    return this.mRowCount;
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramInt);
  }
  
  public int getScaledHeight(Canvas paramCanvas)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramCanvas.getDensity());
  }
  
  public int getScaledHeight(DisplayMetrics paramDisplayMetrics)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramDisplayMetrics.densityDpi);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramInt);
  }
  
  public int getScaledWidth(Canvas paramCanvas)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramCanvas.getDensity());
  }
  
  public int getScaledWidth(DisplayMetrics paramDisplayMetrics)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramDisplayMetrics.densityDpi);
  }
  
  public final int getWidth()
  {
    return this.mWidth;
  }
  
  public final boolean hasAlpha()
  {
    return this.hasAlpha;
  }
  
  public void recyle()
  {
    Bitmap[] arrayOfBitmap = this.mBitmaps;
    int j = arrayOfBitmap.length;
    int i = 0;
    while (i < j)
    {
      Bitmap localBitmap = arrayOfBitmap[i];
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.SliceBitmap
 * JD-Core Version:    0.7.0.1
 */