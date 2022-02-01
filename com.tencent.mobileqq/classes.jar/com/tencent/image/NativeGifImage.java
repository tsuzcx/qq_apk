package com.tencent.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.ITool;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;

public class NativeGifImage
  extends AbstractGifImage
{
  protected static int CURRENT_FRAMEINDEX_INDEX = 0;
  protected static int CURRENT_LOOP_INDEX = 0;
  public static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
  protected static int ERRCODE_INDEX = 0;
  protected static int FRAME_COUNT_INDEX = 0;
  public static int GIF_DEFAULT_DELAY = 0;
  protected static int HEIGHT_INDEX = 0;
  private static int IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 262144;
  protected static int POST_INVALIDATION_TIME_INDEX = 0;
  public static int QZONE_DELAY = -1;
  public static final String TAG = "NativeGifImage";
  protected static int WIDTH_INDEX;
  private static boolean mIsGIFEngineAvaliable;
  private static boolean mIsLibLoaded;
  private static int[] sequence;
  protected Bitmap.Config mCurrentConfig = DEFAULT_CONFIG;
  protected Bitmap mCurrentFrameBitmap;
  protected Bitmap mCurrentFrameBitmapBuffer;
  protected int mCurrentFrameIndex;
  protected int mCurrentLoop;
  protected boolean mDecodeNextFrameEnd = true;
  protected Bitmap mFirstFrameBitmap;
  private volatile long mGifFilePtr = 0L;
  protected final boolean mIsEmosmFile;
  protected final int[] mMetaData = new int[7];
  protected final int mReqHeight;
  protected final int mReqWidth;
  protected final String mSrcGifFile;
  
  static
  {
    GIF_DEFAULT_DELAY = -1;
    WIDTH_INDEX = 0;
    HEIGHT_INDEX = 1;
    FRAME_COUNT_INDEX = 2;
    ERRCODE_INDEX = 3;
    POST_INVALIDATION_TIME_INDEX = 4;
    CURRENT_FRAMEINDEX_INDEX = 5;
    CURRENT_LOOP_INDEX = 6;
    mIsGIFEngineAvaliable = false;
    mIsLibLoaded = false;
  }
  
  public NativeGifImage(File paramFile, boolean paramBoolean)
  {
    this(paramFile, paramBoolean, false, 0, 0, 0.0F);
  }
  
  public NativeGifImage(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    this.mSrcGifFile = paramFile.getAbsolutePath();
    this.mIsEmosmFile = paramBoolean2;
    if ((!paramFile.exists()) && (URLDrawable.depImp.mLog.isColorLevel())) {
      URLDrawable.depImp.mLog.e("NativeGifImage", 2, this.mSrcGifFile + " doesn't exist");
    }
    Rect localRect = getImageSize(paramFile, paramBoolean2);
    int m = localRect.width();
    int k = localRect.height();
    int j = k;
    int i = m;
    float f1;
    float f2;
    if (paramInt1 > 0)
    {
      j = k;
      i = m;
      if (paramInt2 > 0)
      {
        f1 = paramInt1 / m;
        f2 = paramInt2 / k;
        if (f1 >= f2) {
          break label273;
        }
        j = k;
        i = m;
        if (f1 < 1.0F)
        {
          i = (int)(m * f1);
          j = (int)(k * f1);
        }
      }
    }
    this.mReqWidth = i;
    this.mReqHeight = j;
    initCurrentFrameBitmap();
    if (mIsGIFEngineAvaliable) {
      this.mGifFilePtr = nativeOpenFile(this.mMetaData, paramFile.getPath(), this.mCurrentFrameBitmap, paramBoolean2);
    }
    for (;;)
    {
      this.mDefaultRoundCorner = paramFloat;
      init(paramBoolean1);
      return;
      label273:
      f1 = f2;
      break;
      this.mMetaData[WIDTH_INDEX] = localRect.width();
      this.mMetaData[HEIGHT_INDEX] = localRect.height();
      this.mMetaData[FRAME_COUNT_INDEX] = 1;
      this.mMetaData[ERRCODE_INDEX] = 0;
      this.mMetaData[POST_INVALIDATION_TIME_INDEX] = 2147483647;
      this.mMetaData[CURRENT_FRAMEINDEX_INDEX] = -1;
      this.mMetaData[CURRENT_LOOP_INDEX] = -1;
    }
  }
  
  public static Rect getImageSize(File paramFile, boolean paramBoolean)
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    if (!paramFile.exists()) {
      return new Rect(0, 0, 0, 0);
    }
    loadLibrary();
    int[] arrayOfInt = new int[7];
    if (mIsGIFEngineAvaliable) {
      nativeGetFileImageSize(arrayOfInt, paramFile.getPath(), paramBoolean);
    }
    for (;;)
    {
      return new Rect(0, 0, arrayOfInt[WIDTH_INDEX], arrayOfInt[HEIGHT_INDEX]);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
      arrayOfInt[WIDTH_INDEX] = localOptions.outWidth;
      arrayOfInt[HEIGHT_INDEX] = localOptions.outHeight;
    }
  }
  
  private void init(boolean paramBoolean)
  {
    getNextFrame();
    applyNextFrame();
    if (paramBoolean) {}
    try
    {
      this.mFirstFrameBitmap = this.mCurrentFrameBitmap.copy(this.mCurrentFrameBitmap.getConfig(), false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void initCurrentFrameBitmap()
  {
    if (mIsGIFEngineAvaliable) {}
    try
    {
      this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
      if (this.mReqWidth * this.mReqHeight > IMAGE_SIZE_DISABLE_DOUBLE_BUFFER) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.mCurrentFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError3) {}
        localOutOfMemoryError1 = localOutOfMemoryError1;
        if (this.mCurrentConfig == Bitmap.Config.ARGB_8888)
        {
          try
          {
            this.mCurrentConfig = Bitmap.Config.ARGB_4444;
            this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            URLDrawable.clearMemoryCache();
            this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
          }
        }
        else
        {
          URLDrawable.clearMemoryCache();
          this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
        }
      }
    }
  }
  
  public static void loadLibrary()
  {
    int k = 0;
    if ((!mIsLibLoaded) && (URLDrawable.mApplicationContext != null)) {}
    try
    {
      Utils.beginPile();
      mIsGIFEngineAvaliable = URLDrawable.depImp.mTool.loadSoByName(URLDrawable.mApplicationContext, "GIFEngine");
      i = Color.argb(255, 0, 1, 2);
      localObject = DEFAULT_CONFIG;
      sequence = nativeTestColor(Bitmap.createBitmap(new int[] { i }, 1, 1, (Bitmap.Config)localObject));
      if (sequence == null) {
        break label334;
      }
      if (sequence.length == 4) {
        break label176;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject;
        int m;
        int j;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e("NativeGifImage", 2, "loadLibrary(): " + localUnsatisfiedLinkError.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          URLDrawable.depImp.mLog.e("NativeGifImage", 2, "loadLibrary(): " + localException.getMessage());
          continue;
          i = 1;
        }
      }
    }
    if (i != 0) {
      sequence = new int[] { 0, 1, 2, 3 };
    }
    mIsLibLoaded = true;
    Utils.endPile("NativeGifImage", "Load libGIFEngine");
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.i("NativeGifImage", 2, "libGIFEngine.so loaded " + mIsLibLoaded);
    }
    return;
    label176:
    localObject = sequence;
    m = localObject.length;
    j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      i = localObject[j];
      if ((i < 0) || (i > 3))
      {
        i = 1;
        break;
      }
      j += 1;
    }
  }
  
  private static native void nativeFree(long paramLong);
  
  private static native long nativeGetAllocationByteCount(long paramLong);
  
  private static native int nativeGetFileImageSize(int[] paramArrayOfInt, String paramString, boolean paramBoolean);
  
  private static native long nativeOpenFile(int[] paramArrayOfInt, String paramString, Bitmap paramBitmap, boolean paramBoolean);
  
  private static native boolean nativeReset(long paramLong);
  
  private static native void nativeSeekToNextFrame(Bitmap paramBitmap, long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private static native int[] nativeTestColor(Bitmap paramBitmap);
  
  /* Error */
  protected void applyNextFrame()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_0
    //   6: getfield 86	com/tencent/image/NativeGifImage:mMetaData	[I
    //   9: getstatic 67	com/tencent/image/NativeGifImage:CURRENT_FRAMEINDEX_INDEX	I
    //   12: iaload
    //   13: putfield 314	com/tencent/image/NativeGifImage:mCurrentFrameIndex	I
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 86	com/tencent/image/NativeGifImage:mMetaData	[I
    //   21: getstatic 69	com/tencent/image/NativeGifImage:CURRENT_LOOP_INDEX	I
    //   24: iaload
    //   25: putfield 316	com/tencent/image/NativeGifImage:mCurrentLoop	I
    //   28: aload_0
    //   29: getfield 316	com/tencent/image/NativeGifImage:mCurrentLoop	I
    //   32: iconst_1
    //   33: if_icmpne +54 -> 87
    //   36: aload_0
    //   37: getfield 314	com/tencent/image/NativeGifImage:mCurrentFrameIndex	I
    //   40: ifne +47 -> 87
    //   43: aload_0
    //   44: getfield 320	com/tencent/image/NativeGifImage:mPlayOnceListener	Ljava/lang/ref/WeakReference;
    //   47: ifnull +24 -> 71
    //   50: aload_0
    //   51: getfield 320	com/tencent/image/NativeGifImage:mPlayOnceListener	Ljava/lang/ref/WeakReference;
    //   54: invokevirtual 326	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   57: checkcast 328	com/tencent/image/GifDrawable$OnGIFPlayOnceListener
    //   60: astore_3
    //   61: aload_3
    //   62: ifnull +9 -> 71
    //   65: aload_3
    //   66: invokeinterface 331 1 0
    //   71: aload_0
    //   72: getfield 335	com/tencent/image/NativeGifImage:mStrongPlayOnceListener	Lcom/tencent/image/GifDrawable$OnGIFPlayOnceListener;
    //   75: ifnull +12 -> 87
    //   78: aload_0
    //   79: getfield 335	com/tencent/image/NativeGifImage:mStrongPlayOnceListener	Lcom/tencent/image/GifDrawable$OnGIFPlayOnceListener;
    //   82: invokeinterface 331 1 0
    //   87: aload_0
    //   88: getfield 238	com/tencent/image/NativeGifImage:mCurrentFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   91: ifnull +112 -> 203
    //   94: new 337	android/graphics/Canvas
    //   97: dup
    //   98: aload_0
    //   99: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   102: invokespecial 340	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   105: astore_3
    //   106: aload_0
    //   107: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   110: iconst_0
    //   111: invokevirtual 344	android/graphics/Bitmap:eraseColor	(I)V
    //   114: aload_0
    //   115: getfield 179	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   118: fconst_0
    //   119: fcmpl
    //   120: ifle +69 -> 189
    //   123: new 346	android/graphics/Paint
    //   126: dup
    //   127: invokespecial 347	android/graphics/Paint:<init>	()V
    //   130: astore_2
    //   131: aload_2
    //   132: iconst_1
    //   133: invokevirtual 350	android/graphics/Paint:setAntiAlias	(Z)V
    //   136: aload_3
    //   137: new 352	android/graphics/RectF
    //   140: dup
    //   141: fconst_0
    //   142: fconst_0
    //   143: aload_0
    //   144: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   147: invokevirtual 355	android/graphics/Bitmap:getWidth	()I
    //   150: i2f
    //   151: aload_0
    //   152: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   155: invokevirtual 358	android/graphics/Bitmap:getHeight	()I
    //   158: i2f
    //   159: invokespecial 361	android/graphics/RectF:<init>	(FFFF)V
    //   162: aload_0
    //   163: getfield 179	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   166: aload_0
    //   167: getfield 179	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   170: aload_2
    //   171: invokevirtual 365	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   174: aload_2
    //   175: new 367	android/graphics/PorterDuffXfermode
    //   178: dup
    //   179: getstatic 373	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   182: invokespecial 376	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   185: invokevirtual 380	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   188: pop
    //   189: aload_3
    //   190: aload_0
    //   191: getfield 238	com/tencent/image/NativeGifImage:mCurrentFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   194: fconst_0
    //   195: fconst_0
    //   196: aload_2
    //   197: invokevirtual 384	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   200: aload_0
    //   201: monitorexit
    //   202: return
    //   203: aload_0
    //   204: getfield 179	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   207: fstore_1
    //   208: fload_1
    //   209: fconst_0
    //   210: fcmpl
    //   211: ifle -11 -> 200
    //   214: aload_0
    //   215: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   218: invokevirtual 355	android/graphics/Bitmap:getWidth	()I
    //   221: aload_0
    //   222: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   225: invokevirtual 358	android/graphics/Bitmap:getHeight	()I
    //   228: aload_0
    //   229: getfield 90	com/tencent/image/NativeGifImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   232: invokestatic 236	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   235: astore_2
    //   236: aload_2
    //   237: ifnull -37 -> 200
    //   240: new 337	android/graphics/Canvas
    //   243: dup
    //   244: aload_2
    //   245: invokespecial 340	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   248: astore_3
    //   249: new 346	android/graphics/Paint
    //   252: dup
    //   253: invokespecial 347	android/graphics/Paint:<init>	()V
    //   256: astore 4
    //   258: aload 4
    //   260: iconst_1
    //   261: invokevirtual 350	android/graphics/Paint:setAntiAlias	(Z)V
    //   264: aload_3
    //   265: new 352	android/graphics/RectF
    //   268: dup
    //   269: fconst_0
    //   270: fconst_0
    //   271: aload_0
    //   272: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   275: invokevirtual 355	android/graphics/Bitmap:getWidth	()I
    //   278: i2f
    //   279: aload_0
    //   280: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   283: invokevirtual 358	android/graphics/Bitmap:getHeight	()I
    //   286: i2f
    //   287: invokespecial 361	android/graphics/RectF:<init>	(FFFF)V
    //   290: aload_0
    //   291: getfield 179	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   294: aload_0
    //   295: getfield 179	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   298: aload 4
    //   300: invokevirtual 365	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   303: aload 4
    //   305: new 367	android/graphics/PorterDuffXfermode
    //   308: dup
    //   309: getstatic 373	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   312: invokespecial 376	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   315: invokevirtual 380	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   318: pop
    //   319: aload_3
    //   320: aload_0
    //   321: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   324: fconst_0
    //   325: fconst_0
    //   326: aload 4
    //   328: invokevirtual 384	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   331: aload_0
    //   332: aload_2
    //   333: putfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   336: goto -136 -> 200
    //   339: astore_2
    //   340: aload_0
    //   341: monitorexit
    //   342: aload_2
    //   343: athrow
    //   344: astore_2
    //   345: aload_0
    //   346: getfield 90	com/tencent/image/NativeGifImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   349: astore_2
    //   350: getstatic 49	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   353: astore_3
    //   354: aload_2
    //   355: aload_3
    //   356: if_acmpne +59 -> 415
    //   359: aload_0
    //   360: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   363: invokevirtual 355	android/graphics/Bitmap:getWidth	()I
    //   366: aload_0
    //   367: getfield 171	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   370: invokevirtual 358	android/graphics/Bitmap:getHeight	()I
    //   373: getstatic 241	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   376: invokestatic 236	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   379: astore_2
    //   380: goto -144 -> 236
    //   383: astore_2
    //   384: getstatic 119	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   387: getfield 125	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   390: invokeinterface 130 1 0
    //   395: ifeq +20 -> 415
    //   398: getstatic 119	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   401: getfield 125	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   404: ldc 21
    //   406: iconst_2
    //   407: ldc_w 386
    //   410: invokeinterface 389 4 0
    //   415: aconst_null
    //   416: astore_2
    //   417: goto -181 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	NativeGifImage
    //   207	2	1	f	float
    //   1	332	2	localObject1	Object
    //   339	4	2	localObject2	Object
    //   344	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   349	31	2	localObject3	Object
    //   383	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   416	1	2	localObject4	Object
    //   60	296	3	localObject5	Object
    //   256	71	4	localPaint	Paint
    // Exception table:
    //   from	to	target	type
    //   4	61	339	finally
    //   65	71	339	finally
    //   71	87	339	finally
    //   87	114	339	finally
    //   114	189	339	finally
    //   189	200	339	finally
    //   203	208	339	finally
    //   214	236	339	finally
    //   240	336	339	finally
    //   345	354	339	finally
    //   359	380	339	finally
    //   384	415	339	finally
    //   214	236	344	java/lang/OutOfMemoryError
    //   359	380	383	java/lang/OutOfMemoryError
  }
  
  protected void doApplyNextFrame()
  {
    this.mDecodeNextFrameEnd = true;
    super.doApplyNextFrame();
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((this.mMetaData[FRAME_COUNT_INDEX] <= 1) || ((!paramBoolean) && (this.mCurrentFrameBitmap != null))) {
      paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
    }
    do
    {
      return;
      if (this.mCurrentFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
    } while (this.mIsInPendingAction);
    if (sPaused) {
      sPendingActions.add(new WeakReference(this));
    }
    this.mIsInPendingAction = true;
  }
  
  public void drawFirstFrame(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    initHandlerAndRunnable();
    if (this.mFirstFrameBitmap != null) {
      paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
    }
  }
  
  protected void executeNewTask()
  {
    long l;
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      GIF_DEFAULT_DELAY = this.mMetaData[POST_INVALIDATION_TIME_INDEX];
      if (QZONE_DELAY != -1) {
        break label67;
      }
      l = SystemClock.uptimeMillis() + this.mMetaData[POST_INVALIDATION_TIME_INDEX];
    }
    try
    {
      for (;;)
      {
        URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new NativeGifImage.NativeDecodeFrameTask(this, l), null, true);
        return;
        label67:
        l = SystemClock.uptimeMillis() + QZONE_DELAY;
      }
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      while (!URLDrawable.depImp.mLog.isColorLevel()) {}
      URLDrawable.depImp.mLog.e("URLDrawable_", 2, "executeNewTask()", localRejectedExecutionException);
    }
  }
  
  protected void finalize()
  {
    long l = this.mGifFilePtr;
    this.mGifFilePtr = 0L;
    if (mIsGIFEngineAvaliable) {
      nativeFree(l);
    }
    super.finalize();
  }
  
  @TargetApi(12)
  public int getByteSize()
  {
    l2 = 0L;
    l1 = l2;
    if (mIsGIFEngineAvaliable) {}
    try
    {
      l1 = nativeGetAllocationByteCount(this.mGifFilePtr);
      l1 = 0L + l1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        l1 = l2;
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          URLDrawable.depImp.mLog.e("NativeGifImage", 2, "getByteSize(): " + localUnsatisfiedLinkError.getMessage());
          l1 = l2;
        }
      }
    }
    return (int)(l1 + Utils.getBitmapSize(this.mCurrentFrameBitmap) + Utils.getBitmapSize(this.mFirstFrameBitmap) + Utils.getBitmapSize(this.mCurrentFrameBitmapBuffer));
  }
  
  public NativeGifIOException.NativeGifError getError()
  {
    return NativeGifIOException.NativeGifError.fromCode(this.mMetaData[ERRCODE_INDEX]);
  }
  
  public Bitmap getFirstFrameBitmap()
  {
    return this.mFirstFrameBitmap;
  }
  
  public int getHeight()
  {
    if (this.mCurrentFrameBitmap != null) {
      return this.mCurrentFrameBitmap.getHeight();
    }
    return 0;
  }
  
  protected void getNextFrame()
  {
    for (;;)
    {
      try
      {
        if (mIsGIFEngineAvaliable)
        {
          if (this.mCurrentFrameBitmapBuffer != null)
          {
            nativeSeekToNextFrame(this.mCurrentFrameBitmapBuffer, this.mGifFilePtr, this.mMetaData, sequence);
            return;
          }
          nativeSeekToNextFrame(this.mCurrentFrameBitmap, this.mGifFilePtr, this.mMetaData, sequence);
          continue;
        }
        try
        {
          this.mCurrentFrameBitmap = BitmapFactory.decodeFile(this.mSrcGifFile);
          this.mCurrentFrameBitmap = Bitmap.createScaledBitmap(this.mCurrentFrameBitmap, this.mReqWidth, this.mReqHeight, true);
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
      finally {}
    }
  }
  
  public int getWidth()
  {
    if (this.mCurrentFrameBitmap != null) {
      return this.mCurrentFrameBitmap.getWidth();
    }
    return 0;
  }
  
  public void reset()
  {
    this.mCurrentFrameIndex = -1;
    this.mCurrentLoop = -1;
    if (mIsGIFEngineAvaliable) {
      nativeReset(this.mGifFilePtr);
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", new Object[] { Integer.valueOf(this.mMetaData[0]), Integer.valueOf(this.mMetaData[1]), Integer.valueOf(this.mMetaData[2]), Integer.valueOf(this.mMetaData[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifImage
 * JD-Core Version:    0.7.0.1
 */