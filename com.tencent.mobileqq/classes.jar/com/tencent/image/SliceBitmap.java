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
  public static int gl_max_texture_size = 0;
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
      int i = 0;
      int j = 0;
      while (i < this.mRowCount)
      {
        int k = 0;
        if (k < this.mColumnCount)
        {
          int i1 = i * 2048;
          int i2 = k * 2048;
          int m;
          if (i1 + 2048 > this.mWidth)
          {
            m = this.mWidth - i1;
            label154:
            if (i2 + 2048 <= this.mHeight) {
              break label213;
            }
          }
          label213:
          for (int n = this.mHeight - i2;; n = 2048)
          {
            arrayOfBitmap[j] = Bitmap.createBitmap(paramBitmap, i1, i2, m, n);
            k += 1;
            j += 1;
            break;
            m = 2048;
            break label154;
          }
        }
        i += 1;
      }
      this.mBitmaps = arrayOfBitmap;
      return;
    }
    throw new IllegalArgumentException("the bitmap no need to Slice");
  }
  
  /* Error */
  public static int getTextureBitmapMaxSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: getstatic 86	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 17
    //   11: if_icmplt +147 -> 158
    //   14: iconst_0
    //   15: invokestatic 92	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   18: astore_1
    //   19: iconst_2
    //   20: newarray int
    //   22: astore_2
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: aload_2
    //   27: iconst_1
    //   28: invokestatic 96	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   31: pop
    //   32: iconst_1
    //   33: anewarray 98	android/opengl/EGLConfig
    //   36: astore_2
    //   37: iconst_1
    //   38: newarray int
    //   40: astore_3
    //   41: aload_1
    //   42: bipush 9
    //   44: newarray int
    //   46: dup
    //   47: iconst_0
    //   48: sipush 12351
    //   51: iastore
    //   52: dup
    //   53: iconst_1
    //   54: sipush 12430
    //   57: iastore
    //   58: dup
    //   59: iconst_2
    //   60: sipush 12329
    //   63: iastore
    //   64: dup
    //   65: iconst_3
    //   66: iconst_0
    //   67: iastore
    //   68: dup
    //   69: iconst_4
    //   70: sipush 12352
    //   73: iastore
    //   74: dup
    //   75: iconst_5
    //   76: iconst_4
    //   77: iastore
    //   78: dup
    //   79: bipush 6
    //   81: sipush 12339
    //   84: iastore
    //   85: dup
    //   86: bipush 7
    //   88: iconst_1
    //   89: iastore
    //   90: dup
    //   91: bipush 8
    //   93: sipush 12344
    //   96: iastore
    //   97: iconst_0
    //   98: aload_2
    //   99: iconst_0
    //   100: iconst_1
    //   101: aload_3
    //   102: iconst_0
    //   103: invokestatic 102	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   106: pop
    //   107: aload_3
    //   108: iconst_0
    //   109: iaload
    //   110: istore_0
    //   111: iload_0
    //   112: ifne +50 -> 162
    //   115: aload_1
    //   116: ifnull +42 -> 158
    //   119: aload_1
    //   120: getstatic 106	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   123: getstatic 106	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   126: getstatic 110	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   129: invokestatic 114	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   132: pop
    //   133: iconst_0
    //   134: ifeq +9 -> 143
    //   137: aload_1
    //   138: aconst_null
    //   139: invokestatic 118	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   142: pop
    //   143: iconst_0
    //   144: ifeq +9 -> 153
    //   147: aload_1
    //   148: aconst_null
    //   149: invokestatic 122	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   152: pop
    //   153: aload_1
    //   154: invokestatic 126	android/opengl/EGL14:eglTerminate	(Landroid/opengl/EGLDisplay;)Z
    //   157: pop
    //   158: sipush 2048
    //   161: ireturn
    //   162: aload_2
    //   163: iconst_0
    //   164: aaload
    //   165: astore_2
    //   166: aload_1
    //   167: aload_2
    //   168: iconst_5
    //   169: newarray int
    //   171: dup
    //   172: iconst_0
    //   173: sipush 12375
    //   176: iastore
    //   177: dup
    //   178: iconst_1
    //   179: bipush 64
    //   181: iastore
    //   182: dup
    //   183: iconst_2
    //   184: sipush 12374
    //   187: iastore
    //   188: dup
    //   189: iconst_3
    //   190: bipush 64
    //   192: iastore
    //   193: dup
    //   194: iconst_4
    //   195: sipush 12344
    //   198: iastore
    //   199: iconst_0
    //   200: invokestatic 130	android/opengl/EGL14:eglCreatePbufferSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;[II)Landroid/opengl/EGLSurface;
    //   203: astore_3
    //   204: aload_1
    //   205: aload_2
    //   206: getstatic 110	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   209: iconst_3
    //   210: newarray int
    //   212: dup
    //   213: iconst_0
    //   214: sipush 12440
    //   217: iastore
    //   218: dup
    //   219: iconst_1
    //   220: iconst_2
    //   221: iastore
    //   222: dup
    //   223: iconst_2
    //   224: sipush 12344
    //   227: iastore
    //   228: iconst_0
    //   229: invokestatic 134	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   232: astore_2
    //   233: aload_1
    //   234: aload_3
    //   235: aload_3
    //   236: aload_2
    //   237: invokestatic 114	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   240: pop
    //   241: iconst_1
    //   242: newarray int
    //   244: astore 4
    //   246: sipush 3379
    //   249: aload 4
    //   251: iconst_0
    //   252: invokestatic 140	android/opengl/GLES20:glGetIntegerv	(I[II)V
    //   255: aload 4
    //   257: iconst_0
    //   258: iaload
    //   259: sipush 2048
    //   262: if_icmple +53 -> 315
    //   265: aload 4
    //   267: iconst_0
    //   268: iaload
    //   269: istore_0
    //   270: aload_1
    //   271: ifnull +42 -> 313
    //   274: aload_1
    //   275: getstatic 106	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   278: getstatic 106	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   281: getstatic 110	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   284: invokestatic 114	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   287: pop
    //   288: aload_3
    //   289: ifnull +9 -> 298
    //   292: aload_1
    //   293: aload_3
    //   294: invokestatic 118	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   297: pop
    //   298: aload_2
    //   299: ifnull +9 -> 308
    //   302: aload_1
    //   303: aload_2
    //   304: invokestatic 122	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   307: pop
    //   308: aload_1
    //   309: invokestatic 126	android/opengl/EGL14:eglTerminate	(Landroid/opengl/EGLDisplay;)Z
    //   312: pop
    //   313: iload_0
    //   314: ireturn
    //   315: sipush 2048
    //   318: istore_0
    //   319: goto -49 -> 270
    //   322: astore_3
    //   323: aconst_null
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: aload 5
    //   329: astore 4
    //   331: aload_3
    //   332: invokevirtual 143	java/lang/Throwable:printStackTrace	()V
    //   335: aload_2
    //   336: ifnull -178 -> 158
    //   339: aload_2
    //   340: getstatic 106	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   343: getstatic 106	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   346: getstatic 110	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   349: invokestatic 114	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   352: pop
    //   353: aload 4
    //   355: ifnull +10 -> 365
    //   358: aload_2
    //   359: aload 4
    //   361: invokestatic 118	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   364: pop
    //   365: aload_1
    //   366: ifnull +9 -> 375
    //   369: aload_2
    //   370: aload_1
    //   371: invokestatic 122	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   374: pop
    //   375: aload_2
    //   376: invokestatic 126	android/opengl/EGL14:eglTerminate	(Landroid/opengl/EGLDisplay;)Z
    //   379: pop
    //   380: sipush 2048
    //   383: ireturn
    //   384: astore_1
    //   385: aconst_null
    //   386: astore_3
    //   387: aconst_null
    //   388: astore_2
    //   389: aload_2
    //   390: ifnull +44 -> 434
    //   393: aload_2
    //   394: getstatic 106	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   397: getstatic 106	android/opengl/EGL14:EGL_NO_SURFACE	Landroid/opengl/EGLSurface;
    //   400: getstatic 110	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   403: invokestatic 114	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   406: pop
    //   407: aload_3
    //   408: ifnull +9 -> 417
    //   411: aload_2
    //   412: aload_3
    //   413: invokestatic 118	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   416: pop
    //   417: aload 4
    //   419: ifnull +10 -> 429
    //   422: aload_2
    //   423: aload 4
    //   425: invokestatic 122	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   428: pop
    //   429: aload_2
    //   430: invokestatic 126	android/opengl/EGL14:eglTerminate	(Landroid/opengl/EGLDisplay;)Z
    //   433: pop
    //   434: aload_1
    //   435: athrow
    //   436: astore 5
    //   438: aconst_null
    //   439: astore_3
    //   440: aload_1
    //   441: astore_2
    //   442: aload 5
    //   444: astore_1
    //   445: goto -56 -> 389
    //   448: astore 5
    //   450: aload_1
    //   451: astore_2
    //   452: aload 5
    //   454: astore_1
    //   455: goto -66 -> 389
    //   458: astore 5
    //   460: aload_2
    //   461: astore 4
    //   463: aload_1
    //   464: astore_2
    //   465: aload 5
    //   467: astore_1
    //   468: goto -79 -> 389
    //   471: astore 5
    //   473: aload 4
    //   475: astore_3
    //   476: aload_1
    //   477: astore 4
    //   479: aload 5
    //   481: astore_1
    //   482: goto -93 -> 389
    //   485: astore_3
    //   486: aload_1
    //   487: astore_2
    //   488: aconst_null
    //   489: astore_1
    //   490: aload 5
    //   492: astore 4
    //   494: goto -163 -> 331
    //   497: astore 4
    //   499: aload_1
    //   500: astore_2
    //   501: aload 4
    //   503: astore_1
    //   504: aconst_null
    //   505: astore 5
    //   507: aload_3
    //   508: astore 4
    //   510: aload_1
    //   511: astore_3
    //   512: aload 5
    //   514: astore_1
    //   515: goto -184 -> 331
    //   518: astore 6
    //   520: aload_3
    //   521: astore 4
    //   523: aload_1
    //   524: astore 5
    //   526: aload 6
    //   528: astore_3
    //   529: aload_2
    //   530: astore_1
    //   531: aload 5
    //   533: astore_2
    //   534: goto -203 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   110	209	0	i	int
    //   18	353	1	localEGLDisplay	android.opengl.EGLDisplay
    //   384	57	1	localObject1	Object
    //   444	87	1	localObject2	Object
    //   22	512	2	localObject3	Object
    //   40	254	3	localObject4	Object
    //   322	10	3	localThrowable1	java.lang.Throwable
    //   386	90	3	localObject5	Object
    //   485	23	3	localThrowable2	java.lang.Throwable
    //   511	18	3	localObject6	Object
    //   1	492	4	localObject7	Object
    //   497	5	4	localThrowable3	java.lang.Throwable
    //   508	14	4	localObject8	Object
    //   4	324	5	localObject9	Object
    //   436	7	5	localObject10	Object
    //   448	5	5	localObject11	Object
    //   458	8	5	localObject12	Object
    //   471	20	5	localObject13	Object
    //   505	27	5	localObject14	Object
    //   518	9	6	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   14	19	322	java/lang/Throwable
    //   14	19	384	finally
    //   19	107	436	finally
    //   166	204	436	finally
    //   204	233	448	finally
    //   233	255	458	finally
    //   331	335	471	finally
    //   19	107	485	java/lang/Throwable
    //   166	204	485	java/lang/Throwable
    //   204	233	497	java/lang/Throwable
    //   233	255	518	java/lang/Throwable
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
      ReportBean localReportBean = new ReportBean("texture_max_size");
      localReportBean.size = gl_max_texture_size;
      URLDrawable.depImp.mReport.report(localReportBean);
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.i("URLDrawable_", 2, "init TextureBitmapMaxSize:" + gl_max_texture_size);
      }
    }
    return (paramBitmap.getWidth() > gl_max_texture_size) || (paramBitmap.getHeight() > gl_max_texture_size);
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
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
    int i = 0;
    int j = 0;
    while (i < this.mRowCount)
    {
      int k = 0;
      while (k < this.mColumnCount)
      {
        paramRect = this.mBitmaps[j];
        if (paramRect != null) {
          paramCanvas.drawBitmap(paramRect, i * 2048, k * 2048, paramPaint);
        }
        k += 1;
        j += 1;
      }
      i += 1;
    }
    if (!bool) {
      paramCanvas.setDensity(n);
    }
    paramCanvas.restoreToCount(m);
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    if ((this.mBitmaps != null) && (this.mBitmaps.length > paramInt)) {
      return this.mBitmaps[paramInt];
    }
    return null;
  }
  
  public final int getByteCount()
  {
    int i = 0;
    Bitmap[] arrayOfBitmap = this.mBitmaps;
    int k = arrayOfBitmap.length;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.SliceBitmap
 * JD-Core Version:    0.7.0.1
 */