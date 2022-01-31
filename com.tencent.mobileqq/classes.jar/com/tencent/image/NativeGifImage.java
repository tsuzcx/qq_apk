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
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;

public class NativeGifImage
  extends AbstractGifImage
{
  protected static int CURRENT_FRAMEINDEX_INDEX = 5;
  protected static int CURRENT_LOOP_INDEX = 6;
  public static final Bitmap.Config DEFAULT_CONFIG;
  protected static int ERRCODE_INDEX = 0;
  protected static int FRAME_COUNT_INDEX = 0;
  public static int GIF_DEFAULT_DELAY = 0;
  protected static int HEIGHT_INDEX = 0;
  private static int IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 262144;
  protected static int POST_INVALIDATION_TIME_INDEX = 0;
  public static int QZONE_DELAY = 0;
  public static final String TAG = "NativeGifImage";
  protected static int WIDTH_INDEX;
  private static boolean mIsGIFEngineAvaliable = false;
  private static boolean mIsLibLoaded = false;
  private static int[] sequence;
  protected Bitmap.Config mCurrentConfig = DEFAULT_CONFIG;
  protected Bitmap mCurrentFrameBitmap;
  protected Bitmap mCurrentFrameBitmapBuffer;
  protected int mCurrentFrameIndex;
  protected int mCurrentLoop;
  protected boolean mDecodeNextFrameEnd = true;
  protected Bitmap mFirstFrameBitmap;
  private volatile int mGifFilePtr = 0;
  protected final boolean mIsEmosmFile;
  protected final int[] mMetaData = new int[7];
  protected final int mReqHeight;
  protected final int mReqWidth;
  protected final String mSrcGifFile;
  
  static
  {
    DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    QZONE_DELAY = -1;
    GIF_DEFAULT_DELAY = -1;
    WIDTH_INDEX = 0;
    HEIGHT_INDEX = 1;
    FRAME_COUNT_INDEX = 2;
    ERRCODE_INDEX = 3;
    POST_INVALIDATION_TIME_INDEX = 4;
  }
  
  public NativeGifImage(File paramFile, boolean paramBoolean)
    throws IOException
  {
    this(paramFile, paramBoolean, false, 0, 0, 0.0F);
  }
  
  public NativeGifImage(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
    throws IOException
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    this.mSrcGifFile = paramFile.getAbsolutePath();
    this.mIsEmosmFile = paramBoolean2;
    if ((!paramFile.exists()) && (QLog.isColorLevel())) {
      QLog.e("NativeGifImage", 2, this.mSrcGifFile + " doesn't exist");
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
          break label257;
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
      label257:
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
    throws IOException
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
    int j = 0;
    if ((!mIsLibLoaded) && (URLDrawable.mApplicationContext != null)) {}
    try
    {
      Utils.beginPile();
      mIsGIFEngineAvaliable = SoLoadUtilNew.loadSoByName(URLDrawable.mApplicationContext, "GIFEngine");
      i = Color.argb(255, 0, 1, 2);
      localObject = DEFAULT_CONFIG;
      sequence = nativeTestColor(Bitmap.createBitmap(new int[] { i }, 1, 1, (Bitmap.Config)localObject));
      k = 0;
      if (sequence == null) {
        break label280;
      }
      if (sequence.length == 4) {
        break label156;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject;
        int k;
        int m;
        if (QLog.isColorLevel()) {
          QLog.e("NativeGifImage", 2, "loadLibrary(): " + localUnsatisfiedLinkError.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("NativeGifImage", 2, "loadLibrary(): " + localException.getMessage());
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
    if (QLog.isColorLevel()) {
      QLog.i("NativeGifImage", 2, "libGIFEngine.so loaded " + mIsLibLoaded);
    }
    return;
    label156:
    localObject = sequence;
    m = localObject.length;
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
  
  private static native void nativeFree(int paramInt);
  
  private static native long nativeGetAllocationByteCount(int paramInt);
  
  private static native int nativeGetFileImageSize(int[] paramArrayOfInt, String paramString, boolean paramBoolean)
    throws NativeGifIOException;
  
  private static native int nativeOpenFile(int[] paramArrayOfInt, String paramString, Bitmap paramBitmap, boolean paramBoolean)
    throws NativeGifIOException;
  
  private static native boolean nativeReset(int paramInt);
  
  private static native void nativeSeekToNextFrame(Bitmap paramBitmap, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private static native int[] nativeTestColor(Bitmap paramBitmap);
  
  /* Error */
  protected void applyNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 95	com/tencent/image/NativeGifImage:mMetaData	[I
    //   7: getstatic 75	com/tencent/image/NativeGifImage:CURRENT_FRAMEINDEX_INDEX	I
    //   10: iaload
    //   11: putfield 309	com/tencent/image/NativeGifImage:mCurrentFrameIndex	I
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 95	com/tencent/image/NativeGifImage:mMetaData	[I
    //   19: getstatic 77	com/tencent/image/NativeGifImage:CURRENT_LOOP_INDEX	I
    //   22: iaload
    //   23: putfield 311	com/tencent/image/NativeGifImage:mCurrentLoop	I
    //   26: aload_0
    //   27: getfield 311	com/tencent/image/NativeGifImage:mCurrentLoop	I
    //   30: iconst_1
    //   31: if_icmpne +38 -> 69
    //   34: aload_0
    //   35: getfield 309	com/tencent/image/NativeGifImage:mCurrentFrameIndex	I
    //   38: ifne +31 -> 69
    //   41: aload_0
    //   42: getfield 315	com/tencent/image/NativeGifImage:mPlayOnceListener	Ljava/lang/ref/WeakReference;
    //   45: ifnull +24 -> 69
    //   48: aload_0
    //   49: getfield 315	com/tencent/image/NativeGifImage:mPlayOnceListener	Ljava/lang/ref/WeakReference;
    //   52: invokevirtual 321	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   55: checkcast 323	com/tencent/image/GifDrawable$OnGIFPlayOnceListener
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +9 -> 69
    //   63: aload_2
    //   64: invokeinterface 326 1 0
    //   69: aload_0
    //   70: getfield 233	com/tencent/image/NativeGifImage:mCurrentFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   73: ifnull +114 -> 187
    //   76: new 328	android/graphics/Canvas
    //   79: dup
    //   80: aload_0
    //   81: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   84: invokespecial 331	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   87: astore_3
    //   88: aload_0
    //   89: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   92: iconst_0
    //   93: invokevirtual 334	android/graphics/Bitmap:eraseColor	(I)V
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 174	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   102: fconst_0
    //   103: fcmpl
    //   104: ifle +69 -> 173
    //   107: new 336	android/graphics/Paint
    //   110: dup
    //   111: invokespecial 337	android/graphics/Paint:<init>	()V
    //   114: astore_2
    //   115: aload_2
    //   116: iconst_1
    //   117: invokevirtual 340	android/graphics/Paint:setAntiAlias	(Z)V
    //   120: aload_3
    //   121: new 342	android/graphics/RectF
    //   124: dup
    //   125: fconst_0
    //   126: fconst_0
    //   127: aload_0
    //   128: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   131: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   134: i2f
    //   135: aload_0
    //   136: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   139: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   142: i2f
    //   143: invokespecial 351	android/graphics/RectF:<init>	(FFFF)V
    //   146: aload_0
    //   147: getfield 174	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   150: aload_0
    //   151: getfield 174	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   154: aload_2
    //   155: invokevirtual 355	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   158: aload_2
    //   159: new 357	android/graphics/PorterDuffXfermode
    //   162: dup
    //   163: getstatic 363	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   166: invokespecial 366	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   169: invokevirtual 370	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   172: pop
    //   173: aload_3
    //   174: aload_0
    //   175: getfield 233	com/tencent/image/NativeGifImage:mCurrentFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   178: fconst_0
    //   179: fconst_0
    //   180: aload_2
    //   181: invokevirtual 374	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   184: aload_0
    //   185: monitorexit
    //   186: return
    //   187: aload_0
    //   188: getfield 174	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   191: fstore_1
    //   192: fload_1
    //   193: fconst_0
    //   194: fcmpl
    //   195: ifle -11 -> 184
    //   198: aconst_null
    //   199: astore_3
    //   200: aload_0
    //   201: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   204: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   207: aload_0
    //   208: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   211: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   214: aload_0
    //   215: getfield 99	com/tencent/image/NativeGifImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   218: invokestatic 231	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   221: astore_2
    //   222: aload_2
    //   223: ifnull -39 -> 184
    //   226: new 328	android/graphics/Canvas
    //   229: dup
    //   230: aload_2
    //   231: invokespecial 331	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   234: astore_3
    //   235: new 336	android/graphics/Paint
    //   238: dup
    //   239: invokespecial 337	android/graphics/Paint:<init>	()V
    //   242: astore 4
    //   244: aload 4
    //   246: iconst_1
    //   247: invokevirtual 340	android/graphics/Paint:setAntiAlias	(Z)V
    //   250: aload_3
    //   251: new 342	android/graphics/RectF
    //   254: dup
    //   255: fconst_0
    //   256: fconst_0
    //   257: aload_0
    //   258: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   261: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   264: i2f
    //   265: aload_0
    //   266: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   269: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   272: i2f
    //   273: invokespecial 351	android/graphics/RectF:<init>	(FFFF)V
    //   276: aload_0
    //   277: getfield 174	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   280: aload_0
    //   281: getfield 174	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   284: aload 4
    //   286: invokevirtual 355	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   289: aload 4
    //   291: new 357	android/graphics/PorterDuffXfermode
    //   294: dup
    //   295: getstatic 363	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   298: invokespecial 366	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   301: invokevirtual 370	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   304: pop
    //   305: aload_3
    //   306: aload_0
    //   307: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   310: fconst_0
    //   311: fconst_0
    //   312: aload 4
    //   314: invokevirtual 374	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   317: aload_0
    //   318: aload_2
    //   319: putfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   322: goto -138 -> 184
    //   325: astore_2
    //   326: aload_0
    //   327: monitorexit
    //   328: aload_2
    //   329: athrow
    //   330: astore_2
    //   331: aload_0
    //   332: getfield 99	com/tencent/image/NativeGifImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   335: astore 4
    //   337: getstatic 57	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   340: astore 5
    //   342: aload_3
    //   343: astore_2
    //   344: aload 4
    //   346: aload 5
    //   348: if_acmpne -126 -> 222
    //   351: aload_0
    //   352: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   355: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   358: aload_0
    //   359: getfield 166	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   362: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   365: getstatic 236	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   368: invokestatic 231	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   371: astore_2
    //   372: goto -150 -> 222
    //   375: astore_2
    //   376: aload_3
    //   377: astore_2
    //   378: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq -159 -> 222
    //   384: ldc 26
    //   386: iconst_2
    //   387: ldc_w 376
    //   390: invokestatic 379	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: aload_3
    //   394: astore_2
    //   395: goto -173 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	NativeGifImage
    //   191	2	1	f	float
    //   58	261	2	localObject1	Object
    //   325	4	2	localObject2	Object
    //   330	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   343	29	2	localObject3	Object
    //   375	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   377	18	2	localObject4	Object
    //   87	307	3	localCanvas	Canvas
    //   242	103	4	localObject5	Object
    //   340	7	5	localConfig	Bitmap.Config
    // Exception table:
    //   from	to	target	type
    //   2	59	325	finally
    //   63	69	325	finally
    //   69	96	325	finally
    //   98	173	325	finally
    //   173	184	325	finally
    //   187	192	325	finally
    //   200	222	325	finally
    //   226	322	325	finally
    //   331	342	325	finally
    //   351	372	325	finally
    //   378	393	325	finally
    //   200	222	330	java/lang/OutOfMemoryError
    //   351	372	375	java/lang/OutOfMemoryError
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
        break label61;
      }
      l = SystemClock.uptimeMillis() + this.mMetaData[POST_INVALIDATION_TIME_INDEX];
    }
    try
    {
      for (;;)
      {
        Utils.executeAsyncTaskOnSerialExcuter(new NativeDecodeFrameTask(l), (Void[])null);
        return;
        label61:
        l = SystemClock.uptimeMillis() + QZONE_DELAY;
      }
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("URLDrawable_", 2, "executeNewTask()", localRejectedExecutionException);
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    int i = this.mGifFilePtr;
    this.mGifFilePtr = 0;
    if (mIsGIFEngineAvaliable) {
      nativeFree(i);
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
        if (QLog.isColorLevel())
        {
          QLog.e("NativeGifImage", 2, "getByteSize(): " + localUnsatisfiedLinkError.getMessage());
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
  
  private class NativeDecodeFrameTask
    extends AsyncTask<Void, Void, Void>
  {
    final long mNextFrameTime;
    
    public NativeDecodeFrameTask(long paramLong)
    {
      this.mNextFrameTime = paramLong;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      NativeGifImage.this.getNextFrame();
      if (NativeGifImage.this.mMetaData[NativeGifImage.FRAME_COUNT_INDEX] > 1)
      {
        long l = SystemClock.uptimeMillis();
        paramVarArgs = new Runnable()
        {
          public void run()
          {
            AbstractGifImage.sAccumulativeRunnable.add(new WeakReference[] { new WeakReference(NativeGifImage.this) });
          }
        };
        if (l < this.mNextFrameTime)
        {
          AbstractGifImage.sUIThreadHandler.postDelayed(paramVarArgs, this.mNextFrameTime - l);
          return null;
        }
        AbstractGifImage.sUIThreadHandler.post(paramVarArgs);
        return null;
      }
      NativeGifImage.this.mDecodeNextFrameEnd = true;
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifImage
 * JD-Core Version:    0.7.0.1
 */