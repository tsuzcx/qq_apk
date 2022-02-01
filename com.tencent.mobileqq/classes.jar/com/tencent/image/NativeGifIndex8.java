package com.tencent.image;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

public class NativeGifIndex8
  extends AbstractGifImage
{
  public static final int INDEX_EXT_DATA_NEXT_DELAY = 0;
  public static final int INDEX_EXT_DATA_RESULT_CODE = 1;
  public static final String TAG = "NativeGifIndex8";
  private static boolean mIsGIFEngineAvaliable = false;
  private static boolean mIsLibLoaded = false;
  private boolean mCacheFirstFrame = false;
  protected Bitmap mCurrentFrameBitmap;
  protected Bitmap mCurrentFrameBitmapBuffer;
  protected boolean mDecodeNextFrameEnd = true;
  protected int[] mExtData;
  protected Bitmap mFirstFrameBitmap;
  public int mFrameNumber;
  private volatile int mGifHandler = 0;
  private boolean mIsFirstBitmap = true;
  private Bitmap mLastBitmap;
  protected int mReqHeight;
  protected int mReqWidth;
  protected String mSrcGifFile;
  
  public NativeGifIndex8(File paramFile, boolean paramBoolean)
  {
    this(paramFile, paramBoolean, false, 0, 0, 0.0F);
  }
  
  public NativeGifIndex8(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    loadLibrary();
    this.mSrcGifFile = paramFile.getAbsolutePath();
    this.mCacheFirstFrame = paramBoolean1;
    if (!paramFile.exists())
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e("NativeGifIndex8", 2, this.mSrcGifFile + " doesn't exist");
      }
      return;
    }
    this.mExtData = new int[2];
    if (mIsGIFEngineAvaliable)
    {
      this.mGifHandler = nativeInit(this.mSrcGifFile, paramBoolean2);
      initSize(paramInt1, paramInt2);
      nativeSetDestSize(this.mGifHandler, this.mReqWidth, this.mReqHeight);
      nativeSetLoopCount(this.mGifHandler, -1);
      this.mFrameNumber = nativeGetFrameNum(this.mGifHandler);
      this.mExtData[0] = 0;
    }
    for (;;)
    {
      this.mDefaultRoundCorner = paramFloat;
      init(paramBoolean1);
      return;
      this.mFrameNumber = 1;
      this.mExtData[0] = 100;
    }
  }
  
  public static Rect getImageSize(File paramFile, boolean paramBoolean)
  {
    if (!paramFile.exists()) {
      return new Rect(0, 0, 0, 0);
    }
    int i;
    if (mIsGIFEngineAvaliable)
    {
      i = nativeInit(paramFile.getPath(), paramBoolean);
      nativeGetWidth(i);
      nativeGetHeight(i);
      nativeUnInit(i);
    }
    for (;;)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
      return new Rect(0, 0, localOptions.outWidth, localOptions.outHeight);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
      i = localOptions.outWidth;
      i = localOptions.outHeight;
    }
  }
  
  public static String getSoLibPath(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = paramContext.getFilesDir();
    } while (paramContext == null);
    return paramContext.getParent() + "/txlib/";
  }
  
  private void init(boolean paramBoolean)
  {
    getNextFrame();
    applyNextFrame();
    if (paramBoolean) {}
    try
    {
      this.mFirstFrameBitmap = this.mCurrentFrameBitmap;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void initSize(int paramInt1, int paramInt2)
  {
    Rect localRect = getImageSize();
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
          break label109;
        }
      }
    }
    for (;;)
    {
      j = k;
      i = m;
      if (f1 < 1.0F)
      {
        i = (int)(m * f1);
        j = (int)(k * f1);
      }
      this.mReqWidth = i;
      this.mReqHeight = j;
      return;
      label109:
      f1 = f2;
    }
  }
  
  public static boolean isGifEngineAvail()
  {
    loadLibrary();
    return mIsGIFEngineAvaliable == true;
  }
  
  private static void loadLibrary()
  {
    boolean bool2 = false;
    Object localObject = null;
    boolean bool1 = bool2;
    if (URLDrawable.mApplicationContext != null)
    {
      SharedPreferences localSharedPreferences = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
      localObject = localSharedPreferences;
      bool1 = bool2;
      if (localSharedPreferences != null)
      {
        bool1 = localSharedPreferences.getBoolean("gif_so_is_update", false);
        localObject = localSharedPreferences;
      }
    }
    if (((!mIsLibLoaded) && (URLDrawable.mApplicationContext != null)) || (bool1)) {}
    try
    {
      System.load(getSoLibPath(URLDrawable.mApplicationContext) + "libkIndexGif.so");
      mIsGIFEngineAvaliable = true;
      if (localObject != null) {
        localObject.edit().putBoolean("gif_so_is_update", false).commit();
      }
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("NativeGifIndex8", 2, "libkIndexGif.so is loaded. gifIsUpdate:" + bool1);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e("NativeGifIndex8", 2, "loadLibrary(): " + localUnsatisfiedLinkError.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e("NativeGifIndex8", 2, "loadLibrary(): " + localException.getMessage());
        }
      }
    }
    mIsLibLoaded = true;
  }
  
  private static native Bitmap nativeDecodeNext(int[] paramArrayOfInt, int paramInt);
  
  private static native int nativeGetFrameNum(int paramInt);
  
  private static native int nativeGetHeight(int paramInt);
  
  private static native int nativeGetWidth(int paramInt);
  
  private static native int nativeInit(String paramString, boolean paramBoolean);
  
  private static native boolean nativeIsEnd(int paramInt);
  
  private static native void nativeSetDestSize(int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeSetLoopCount(int paramInt1, int paramInt2);
  
  private static native int nativeUnInit(int paramInt);
  
  protected void applyNextFrame() {}
  
  protected void doApplyNextFrame()
  {
    this.mDecodeNextFrameEnd = true;
    super.doApplyNextFrame();
  }
  
  protected void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((this.mFrameNumber <= 1) || (!paramBoolean)) {
      if ((this.mCurrentFrameBitmap != null) && (!this.mCurrentFrameBitmap.isRecycled())) {
        paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
      }
    }
    do
    {
      return;
      URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
      return;
      if ((this.mCurrentFrameBitmap != null) && (!this.mCurrentFrameBitmap.isRecycled())) {}
      try
      {
        paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
        if ((this.mLastBitmap != null) && (!this.mLastBitmap.isRecycled()) && (!this.mIsFirstBitmap))
        {
          this.mLastBitmap.recycle();
          this.mIsFirstBitmap = false;
        }
        if ((this.mCurrentFrameBitmap != null) && (!this.mCurrentFrameBitmap.isRecycled())) {
          this.mLastBitmap = this.mCurrentFrameBitmap;
        }
        if (!sPaused)
        {
          executeNewTask();
          return;
        }
      }
      catch (Throwable paramCanvas)
      {
        for (;;)
        {
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.w("NativeGifIndex8", 2, paramCanvas.getMessage());
          }
          URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
        }
      }
    } while (this.mIsInPendingAction);
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
  }
  
  protected void executeNewTask()
  {
    long l1;
    long l2;
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      l1 = SystemClock.uptimeMillis();
      l2 = this.mExtData[0];
    }
    try
    {
      URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new NativeGifIndex8.NativeDecodeFrameTask(this, l1 + l2), null, true);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e("URLDrawable_", 2, "executeNewTask->" + localRejectedExecutionException.getMessage());
      }
      URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
      return;
    }
    catch (Exception localException)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e("URLDrawable_", 2, "executeNewTask->" + localException.getMessage());
      }
      URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
    }
  }
  
  protected void finalize()
  {
    int i = this.mGifHandler;
    this.mGifHandler = 0;
    if (mIsGIFEngineAvaliable) {
      nativeUnInit(i);
    }
    super.finalize();
  }
  
  public int getByteSize()
  {
    if (mIsGIFEngineAvaliable) {}
    return (int)(0L + Utils.getBitmapSize(this.mCurrentFrameBitmap) + Utils.getBitmapSize(this.mFirstFrameBitmap));
  }
  
  public NativeGifIOException.NativeGifError getError()
  {
    return NativeGifIOException.NativeGifError.fromCode(this.mExtData[1]);
  }
  
  public int getHeight()
  {
    if (this.mGifHandler != 0) {
      return nativeGetHeight(this.mGifHandler);
    }
    return 0;
  }
  
  public Rect getImageSize()
  {
    int j;
    if (mIsGIFEngineAvaliable) {
      j = nativeGetWidth(this.mGifHandler);
    }
    BitmapFactory.Options localOptions;
    for (int i = nativeGetHeight(this.mGifHandler);; i = localOptions.outHeight)
    {
      return new Rect(0, 0, j, i);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.mSrcGifFile, localOptions);
      j = localOptions.outWidth;
    }
  }
  
  /* Error */
  protected void getNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 35	com/tencent/image/NativeGifIndex8:mIsGIFEngineAvaliable	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifeq +149 -> 156
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 110	com/tencent/image/NativeGifIndex8:mExtData	[I
    //   15: aload_0
    //   16: getfield 49	com/tencent/image/NativeGifIndex8:mGifHandler	I
    //   19: invokestatic 387	com/tencent/image/NativeGifIndex8:nativeDecodeNext	([II)Landroid/graphics/Bitmap;
    //   22: putfield 203	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   25: aload_0
    //   26: getfield 203	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   29: ifnull +12 -> 41
    //   32: aload_0
    //   33: getfield 110	com/tencent/image/NativeGifIndex8:mExtData	[I
    //   36: iconst_1
    //   37: iaload
    //   38: ifeq +38 -> 76
    //   41: getstatic 224	com/tencent/image/URLDrawable:mApplicationContext	Landroid/content/Context;
    //   44: ldc 226
    //   46: iconst_4
    //   47: invokevirtual 230	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +24 -> 76
    //   55: aload_3
    //   56: invokeinterface 251 1 0
    //   61: ldc_w 301
    //   64: iconst_0
    //   65: invokeinterface 257 3 0
    //   70: invokeinterface 260 1 0
    //   75: pop
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_3
    //   80: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   83: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   86: invokeinterface 92 1 0
    //   91: ifeq -66 -> 25
    //   94: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   97: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   100: ldc 13
    //   102: iconst_2
    //   103: aload_3
    //   104: invokevirtual 388	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   107: invokeinterface 316 4 0
    //   112: goto -87 -> 25
    //   115: astore_3
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_3
    //   119: athrow
    //   120: astore_3
    //   121: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   124: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   127: invokeinterface 92 1 0
    //   132: ifeq -107 -> 25
    //   135: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   138: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   141: ldc 13
    //   143: iconst_2
    //   144: aload_3
    //   145: invokevirtual 389	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   148: invokeinterface 316 4 0
    //   153: goto -128 -> 25
    //   156: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   159: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   162: invokeinterface 92 1 0
    //   167: ifeq +20 -> 187
    //   170: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   173: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   176: ldc 13
    //   178: iconst_2
    //   179: ldc_w 391
    //   182: invokeinterface 316 4 0
    //   187: aload_0
    //   188: getfield 122	com/tencent/image/NativeGifIndex8:mReqHeight	I
    //   191: ifle -115 -> 76
    //   194: aload_0
    //   195: getfield 120	com/tencent/image/NativeGifIndex8:mReqWidth	I
    //   198: istore_1
    //   199: iload_1
    //   200: ifle -124 -> 76
    //   203: aload_0
    //   204: aload_0
    //   205: getfield 71	com/tencent/image/NativeGifIndex8:mSrcGifFile	Ljava/lang/String;
    //   208: invokestatic 394	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   211: putfield 203	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 203	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   219: aload_0
    //   220: getfield 120	com/tencent/image/NativeGifIndex8:mReqWidth	I
    //   223: aload_0
    //   224: getfield 122	com/tencent/image/NativeGifIndex8:mReqHeight	I
    //   227: iconst_1
    //   228: invokestatic 398	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   231: putfield 203	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   234: goto -158 -> 76
    //   237: astore_3
    //   238: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   241: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   244: invokeinterface 92 1 0
    //   249: ifeq -173 -> 76
    //   252: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   255: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   258: ldc 13
    //   260: iconst_2
    //   261: new 94	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 400
    //   271: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_3
    //   275: invokevirtual 388	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokeinterface 108 4 0
    //   289: goto -213 -> 76
    //   292: astore_3
    //   293: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   296: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   299: invokeinterface 92 1 0
    //   304: ifeq -228 -> 76
    //   307: getstatic 81	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   310: getfield 87	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   313: ldc 13
    //   315: iconst_2
    //   316: new 94	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 402
    //   326: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_3
    //   330: invokevirtual 313	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokeinterface 108 4 0
    //   344: goto -268 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	NativeGifIndex8
    //   198	2	1	i	int
    //   5	2	2	bool	boolean
    //   50	6	3	localSharedPreferences	SharedPreferences
    //   79	25	3	localOutOfMemoryError1	OutOfMemoryError
    //   115	4	3	localObject	Object
    //   120	25	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   237	38	3	localOutOfMemoryError2	OutOfMemoryError
    //   292	38	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	25	79	java/lang/OutOfMemoryError
    //   2	6	115	finally
    //   10	25	115	finally
    //   25	41	115	finally
    //   41	51	115	finally
    //   55	76	115	finally
    //   80	112	115	finally
    //   121	153	115	finally
    //   156	187	115	finally
    //   187	199	115	finally
    //   203	234	115	finally
    //   238	289	115	finally
    //   293	344	115	finally
    //   10	25	120	java/lang/IllegalArgumentException
    //   203	234	237	java/lang/OutOfMemoryError
    //   203	234	292	java/lang/Throwable
  }
  
  public int getWidth()
  {
    if (this.mGifHandler != 0) {
      return nativeGetWidth(this.mGifHandler);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifIndex8
 * JD-Core Version:    0.7.0.1
 */