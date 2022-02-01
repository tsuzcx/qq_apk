package com.tencent.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
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
    if (paramFile != null)
    {
      this.mSrcGifFile = paramFile.getAbsolutePath();
      this.mIsEmosmFile = paramBoolean2;
      if ((!paramFile.exists()) && (URLDrawable.depImp.mLog.isColorLevel()))
      {
        localObject = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mSrcGifFile);
        localStringBuilder.append(" doesn't exist");
        ((ILog)localObject).e("NativeGifImage", 2, localStringBuilder.toString());
      }
      Object localObject = getImageSize(paramFile, paramBoolean2);
      int k = ((Rect)localObject).width();
      int m = ((Rect)localObject).height();
      int j = k;
      int i = m;
      if (paramInt1 > 0)
      {
        j = k;
        i = m;
        if (paramInt2 > 0)
        {
          float f1 = paramInt1;
          float f3 = k;
          f1 /= f3;
          float f2 = paramInt2;
          float f4 = m;
          f2 /= f4;
          if (f1 >= f2) {
            f1 = f2;
          }
          j = k;
          i = m;
          if (f1 < 1.0F)
          {
            j = (int)(f3 * f1);
            i = (int)(f4 * f1);
          }
        }
      }
      this.mReqWidth = j;
      this.mReqHeight = i;
      initCurrentFrameBitmap();
      if (mIsGIFEngineAvaliable)
      {
        this.mGifFilePtr = nativeOpenFile(this.mMetaData, paramFile.getPath(), this.mCurrentFrameBitmap, paramBoolean2);
      }
      else
      {
        this.mMetaData[WIDTH_INDEX] = ((Rect)localObject).width();
        this.mMetaData[HEIGHT_INDEX] = ((Rect)localObject).height();
        paramFile = this.mMetaData;
        paramFile[FRAME_COUNT_INDEX] = 1;
        paramFile[ERRCODE_INDEX] = 0;
        paramFile[POST_INVALIDATION_TIME_INDEX] = 2147483647;
        paramFile[CURRENT_FRAMEINDEX_INDEX] = -1;
        paramFile[CURRENT_LOOP_INDEX] = -1;
      }
      this.mDefaultRoundCorner = paramFloat;
      init(paramBoolean1);
      return;
    }
    throw new NullPointerException("Source is null");
  }
  
  public static Rect getImageSize(File paramFile, boolean paramBoolean)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return new Rect(0, 0, 0, 0);
      }
      loadLibrary();
      int[] arrayOfInt = new int[7];
      if (mIsGIFEngineAvaliable)
      {
        nativeGetFileImageSize(arrayOfInt, paramFile.getPath(), paramBoolean);
      }
      else
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
        arrayOfInt[WIDTH_INDEX] = localOptions.outWidth;
        arrayOfInt[HEIGHT_INDEX] = localOptions.outHeight;
      }
      return new Rect(0, 0, arrayOfInt[WIDTH_INDEX], arrayOfInt[HEIGHT_INDEX]);
    }
    throw new NullPointerException("Source is null");
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
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.mCurrentFrameBitmapBuffer = Bitmap.createBitmap(i, j, this.mCurrentConfig);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError3) {}
        localOutOfMemoryError1 = localOutOfMemoryError1;
      }
    }
    if (this.mCurrentConfig == Bitmap.Config.ARGB_8888) {}
    try
    {
      this.mCurrentConfig = Bitmap.Config.ARGB_4444;
      this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label67:
      int i;
      int j;
      break label67;
    }
    URLDrawable.clearMemoryCache();
    this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    break label114;
    URLDrawable.clearMemoryCache();
    this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    label114:
    i = this.mReqWidth;
    j = this.mReqHeight;
    if (i * j <= IMAGE_SIZE_DISABLE_DOUBLE_BUFFER) {}
  }
  
  public static void loadLibrary()
  {
    if ((!mIsLibLoaded) && (URLDrawable.mApplicationContext != null)) {}
    for (;;)
    {
      int j;
      try
      {
        Utils.beginPile();
        mIsGIFEngineAvaliable = URLDrawable.depImp.mTool.loadSoByName(URLDrawable.mApplicationContext, "GIFEngine");
        i = Color.argb(255, 0, 1, 2);
        Object localObject1 = DEFAULT_CONFIG;
        sequence = nativeTestColor(Bitmap.createBitmap(new int[] { i }, 1, 1, (Bitmap.Config)localObject1));
        if ((sequence == null) || (sequence.length != 4)) {
          break label367;
        }
        localObject1 = sequence;
        j = localObject1.length;
        i = 0;
      }
      catch (Exception localException)
      {
        if (!URLDrawable.depImp.mLog.isColorLevel()) {
          break label259;
        }
        localObject2 = URLDrawable.depImp.mLog;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadLibrary(): ");
        localStringBuilder.append(localException.getMessage());
        ((ILog)localObject2).e("NativeGifImage", 2, localStringBuilder.toString());
        break label259;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (!URLDrawable.depImp.mLog.isColorLevel()) {
          break label259;
        }
        localObject2 = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadLibrary(): ");
        localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
        ((ILog)localObject2).e("NativeGifImage", 2, localStringBuilder.toString());
      }
      if (i != 0) {
        sequence = new int[] { 0, 1, 2, 3 };
      }
      Object localObject2;
      label259:
      mIsLibLoaded = true;
      Utils.endPile("NativeGifImage", "Load libGIFEngine");
      ILog localILog;
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localILog = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("libGIFEngine.so loaded ");
        ((StringBuilder)localObject2).append(mIsLibLoaded);
        localILog.i("NativeGifImage", 2, ((StringBuilder)localObject2).toString());
      }
      return;
      while (i < j)
      {
        int k = localILog[i];
        if ((k < 0) || (k > 3)) {
          break label367;
        }
        i += 1;
      }
      int i = 0;
      continue;
      label367:
      i = 1;
    }
  }
  
  private static native void nativeFree(long paramLong);
  
  private static native long nativeGetAllocationByteCount(long paramLong);
  
  private static native int nativeGetFileImageSize(int[] paramArrayOfInt, String paramString, boolean paramBoolean);
  
  private static native long nativeOpenFile(int[] paramArrayOfInt, String paramString, Bitmap paramBitmap, boolean paramBoolean);
  
  private static native boolean nativeReset(long paramLong);
  
  private static native void nativeSeekToNextFrame(Bitmap paramBitmap, long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private static native int[] nativeTestColor(Bitmap paramBitmap);
  
  protected void applyNextFrame()
  {
    Canvas localCanvas;
    label245:
    try
    {
      this.mCurrentFrameIndex = this.mMetaData[CURRENT_FRAMEINDEX_INDEX];
      this.mCurrentLoop = this.mMetaData[CURRENT_LOOP_INDEX];
      if ((this.mCurrentLoop == 1) && (this.mCurrentFrameIndex == 0))
      {
        if (this.mPlayOnceListener != null)
        {
          localObject1 = (GifDrawable.OnGIFPlayOnceListener)this.mPlayOnceListener.get();
          if (localObject1 != null) {
            ((GifDrawable.OnGIFPlayOnceListener)localObject1).onPlayOnce();
          }
        }
        if (this.mStrongPlayOnceListener != null) {
          this.mStrongPlayOnceListener.onPlayOnce();
        }
      }
      localObject3 = this.mCurrentFrameBitmapBuffer;
      localCanvas = null;
      localObject1 = null;
      if (localObject3 != null)
      {
        localCanvas = new Canvas(this.mCurrentFrameBitmap);
        this.mCurrentFrameBitmap.eraseColor(0);
        if (this.mDefaultRoundCorner > 0.0F)
        {
          localObject1 = new Paint();
          ((Paint)localObject1).setAntiAlias(true);
          localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight()), this.mDefaultRoundCorner, this.mDefaultRoundCorner, (Paint)localObject1);
          ((Paint)localObject1).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        localCanvas.drawBitmap(this.mCurrentFrameBitmapBuffer, 0.0F, 0.0F, (Paint)localObject1);
      }
      else
      {
        float f = this.mDefaultRoundCorner;
        if (f <= 0.0F) {}
      }
    }
    finally {}
    try
    {
      localObject1 = Bitmap.createBitmap(this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight(), this.mCurrentConfig);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      break label245;
    }
    Object localObject3 = this.mCurrentConfig;
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Object localObject1 = localCanvas;
    if (localObject3 == localConfig) {}
    try
    {
      localObject1 = Bitmap.createBitmap(this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight(), Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label289:
      break label289;
    }
    localObject1 = localCanvas;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      URLDrawable.depImp.mLog.d("NativeGifImage", 2, "create ARGB_4444 bitmap oom!");
      localObject1 = localCanvas;
    }
    if (localObject1 != null)
    {
      localCanvas = new Canvas((Bitmap)localObject1);
      localObject3 = new Paint();
      ((Paint)localObject3).setAntiAlias(true);
      localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight()), this.mDefaultRoundCorner, this.mDefaultRoundCorner, (Paint)localObject3);
      ((Paint)localObject3).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(this.mCurrentFrameBitmap, 0.0F, 0.0F, (Paint)localObject3);
      this.mCurrentFrameBitmap = ((Bitmap)localObject1);
    }
  }
  
  protected void doApplyNextFrame()
  {
    this.mDecodeNextFrameEnd = true;
    super.doApplyNextFrame();
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((this.mMetaData[FRAME_COUNT_INDEX] > 1) && ((paramBoolean) || (this.mCurrentFrameBitmap == null)))
    {
      Bitmap localBitmap = this.mCurrentFrameBitmap;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
      if (!this.mIsInPendingAction)
      {
        if (sPaused) {
          sPendingActions.add(new WeakReference(this));
        }
        this.mIsInPendingAction = true;
      }
      return;
    }
    paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
  }
  
  public void drawFirstFrame(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    initHandlerAndRunnable();
    Bitmap localBitmap = this.mFirstFrameBitmap;
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, null, paramRect, paramPaint);
    }
  }
  
  protected void executeNewTask()
  {
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      GIF_DEFAULT_DELAY = this.mMetaData[POST_INVALIDATION_TIME_INDEX];
      long l1;
      int i;
      if (QZONE_DELAY == -1)
      {
        l1 = SystemClock.uptimeMillis();
        i = this.mMetaData[POST_INVALIDATION_TIME_INDEX];
      }
      else
      {
        l1 = SystemClock.uptimeMillis();
        i = QZONE_DELAY;
      }
      long l2 = i;
      try
      {
        URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new NativeGifImage.NativeDecodeFrameTask(this, l1 + l2), null, true);
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e("URLDrawable_", 2, "executeNewTask()", localRejectedExecutionException);
        }
      }
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
    boolean bool = mIsGIFEngineAvaliable;
    long l2 = 0L;
    long l1 = l2;
    if (bool) {
      try
      {
        l1 = nativeGetAllocationByteCount(this.mGifFilePtr);
        l1 = 0L + l1;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        l1 = l2;
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          ILog localILog = URLDrawable.depImp.mLog;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getByteSize(): ");
          localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
          localILog.e("NativeGifImage", 2, localStringBuilder.toString());
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
    Bitmap localBitmap = this.mCurrentFrameBitmap;
    if (localBitmap != null) {
      return localBitmap.getHeight();
    }
    return 0;
  }
  
  /* Error */
  protected void getNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 71	com/tencent/image/NativeGifImage:mIsGIFEngineAvaliable	Z
    //   5: ifeq +52 -> 57
    //   8: aload_0
    //   9: getfield 244	com/tencent/image/NativeGifImage:mCurrentFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   12: ifnull +24 -> 36
    //   15: aload_0
    //   16: getfield 244	com/tencent/image/NativeGifImage:mCurrentFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   19: aload_0
    //   20: getfield 92	com/tencent/image/NativeGifImage:mGifFilePtr	J
    //   23: aload_0
    //   24: getfield 86	com/tencent/image/NativeGifImage:mMetaData	[I
    //   27: getstatic 284	com/tencent/image/NativeGifImage:sequence	[I
    //   30: invokestatic 486	com/tencent/image/NativeGifImage:nativeSeekToNextFrame	(Landroid/graphics/Bitmap;J[I[I)V
    //   33: goto +55 -> 88
    //   36: aload_0
    //   37: getfield 164	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   40: aload_0
    //   41: getfield 92	com/tencent/image/NativeGifImage:mGifFilePtr	J
    //   44: aload_0
    //   45: getfield 86	com/tencent/image/NativeGifImage:mMetaData	[I
    //   48: getstatic 284	com/tencent/image/NativeGifImage:sequence	[I
    //   51: invokestatic 486	com/tencent/image/NativeGifImage:nativeSeekToNextFrame	(Landroid/graphics/Bitmap;J[I[I)V
    //   54: goto +34 -> 88
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 100	com/tencent/image/NativeGifImage:mSrcGifFile	Ljava/lang/String;
    //   62: invokestatic 489	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   65: putfield 164	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 164	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   73: aload_0
    //   74: getfield 154	com/tencent/image/NativeGifImage:mReqWidth	I
    //   77: aload_0
    //   78: getfield 156	com/tencent/image/NativeGifImage:mReqHeight	I
    //   81: iconst_1
    //   82: invokestatic 493	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   85: putfield 164	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: goto -9 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	NativeGifImage
    //   91	4	1	localObject	Object
    //   96	1	1	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   2	33	91	finally
    //   36	54	91	finally
    //   57	88	91	finally
    //   57	88	96	java/lang/OutOfMemoryError
  }
  
  public int getWidth()
  {
    Bitmap localBitmap = this.mCurrentFrameBitmap;
    if (localBitmap != null) {
      return localBitmap.getWidth();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.NativeGifImage
 * JD-Core Version:    0.7.0.1
 */