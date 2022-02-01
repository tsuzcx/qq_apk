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
    if (paramFile != null)
    {
      loadLibrary();
      this.mSrcGifFile = paramFile.getAbsolutePath();
      this.mCacheFirstFrame = paramBoolean1;
      if (!paramFile.exists())
      {
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          paramFile = URLDrawable.depImp.mLog;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.mSrcGifFile);
          localStringBuilder.append(" doesn't exist");
          paramFile.e("NativeGifIndex8", 2, localStringBuilder.toString());
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
      else
      {
        this.mFrameNumber = 1;
        this.mExtData[0] = 100;
      }
      this.mDefaultRoundCorner = paramFloat;
      init(paramBoolean1);
      return;
    }
    throw new NullPointerException("Source is null");
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
    else
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
      i = localOptions.outWidth;
      i = localOptions.outHeight;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
    return new Rect(0, 0, localOptions.outWidth, localOptions.outHeight);
  }
  
  public static String getSoLibPath(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    File localFile = paramContext.getFilesDir();
    paramContext = localObject;
    if (localFile != null)
    {
      paramContext = new StringBuilder();
      paramContext.append(localFile.getParent());
      paramContext.append("/txlib/");
      paramContext = paramContext.toString();
    }
    return paramContext;
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
    int k = localRect.width();
    int m = localRect.height();
    int j = m;
    int i = k;
    if (paramInt1 > 0)
    {
      j = m;
      i = k;
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
        j = m;
        i = k;
        if (f1 < 1.0F)
        {
          i = (int)(f3 * f1);
          j = (int)(f4 * f1);
        }
      }
    }
    this.mReqWidth = i;
    this.mReqHeight = j;
  }
  
  public static boolean isGifEngineAvail()
  {
    loadLibrary();
    return mIsGIFEngineAvaliable == true;
  }
  
  private static void loadLibrary()
  {
    Object localObject2;
    Object localObject1;
    if (URLDrawable.mApplicationContext != null)
    {
      localObject2 = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        bool = ((SharedPreferences)localObject2).getBoolean("gif_so_is_update", false);
        localObject1 = localObject2;
        break label41;
      }
    }
    else
    {
      localObject1 = null;
    }
    boolean bool = false;
    label41:
    if (((!mIsLibLoaded) && (URLDrawable.mApplicationContext != null)) || (bool))
    {
      try
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getSoLibPath(URLDrawable.mApplicationContext));
        ((StringBuilder)localObject2).append("libkIndexGif.so");
        System.load(((StringBuilder)localObject2).toString());
        mIsGIFEngineAvaliable = true;
        if (localObject1 != null) {
          ((SharedPreferences)localObject1).edit().putBoolean("gif_so_is_update", false).commit();
        }
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localObject1 = URLDrawable.depImp.mLog;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("libkIndexGif.so is loaded. gifIsUpdate:");
          ((StringBuilder)localObject2).append(bool);
          ((ILog)localObject1).d("NativeGifIndex8", 2, ((StringBuilder)localObject2).toString());
        }
      }
      catch (Exception localException)
      {
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localObject2 = URLDrawable.depImp.mLog;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadLibrary(): ");
          localStringBuilder.append(localException.getMessage());
          ((ILog)localObject2).e("NativeGifIndex8", 2, localStringBuilder.toString());
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        StringBuilder localStringBuilder;
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localObject2 = URLDrawable.depImp.mLog;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadLibrary(): ");
          localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
          ((ILog)localObject2).e("NativeGifIndex8", 2, localStringBuilder.toString());
        }
      }
      mIsLibLoaded = true;
    }
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
    if ((this.mFrameNumber > 1) && (paramBoolean))
    {
      localBitmap = this.mCurrentFrameBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        try
        {
          paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
        }
        catch (Throwable paramCanvas)
        {
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.w("NativeGifIndex8", 2, paramCanvas.getMessage());
          }
          URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
        }
      }
      paramCanvas = this.mLastBitmap;
      if ((paramCanvas != null) && (!paramCanvas.isRecycled()) && (!this.mIsFirstBitmap))
      {
        this.mLastBitmap.recycle();
        this.mIsFirstBitmap = false;
      }
      paramCanvas = this.mCurrentFrameBitmap;
      if ((paramCanvas != null) && (!paramCanvas.isRecycled())) {
        this.mLastBitmap = this.mCurrentFrameBitmap;
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
      if (!this.mIsInPendingAction)
      {
        sPendingActions.add(new WeakReference(this));
        this.mIsInPendingAction = true;
      }
      return;
    }
    Bitmap localBitmap = this.mCurrentFrameBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
      return;
    }
    URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
  }
  
  protected void executeNewTask()
  {
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.mExtData[0];
      try
      {
        URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new NativeGifIndex8.NativeDecodeFrameTask(this, l1 + l2), null, true);
        return;
      }
      catch (Exception localException)
      {
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localILog = URLDrawable.depImp.mLog;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("executeNewTask->");
          localStringBuilder.append(localException.getMessage());
          localILog.e("URLDrawable_", 2, localStringBuilder.toString());
        }
        URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        ILog localILog;
        StringBuilder localStringBuilder;
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localILog = URLDrawable.depImp.mLog;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("executeNewTask->");
          localStringBuilder.append(localRejectedExecutionException.getMessage());
          localILog.e("URLDrawable_", 2, localStringBuilder.toString());
        }
        URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
      }
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
    boolean bool = mIsGIFEngineAvaliable;
    return (int)(Utils.getBitmapSize(this.mCurrentFrameBitmap) + 0L + Utils.getBitmapSize(this.mFirstFrameBitmap));
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
    int i;
    int j;
    if (mIsGIFEngineAvaliable)
    {
      i = nativeGetWidth(this.mGifHandler);
      j = nativeGetHeight(this.mGifHandler);
    }
    else
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.mSrcGifFile, localOptions);
      i = localOptions.outWidth;
      j = localOptions.outHeight;
    }
    return new Rect(0, 0, i, j);
  }
  
  protected void getNextFrame()
  {
    try
    {
      boolean bool = mIsGIFEngineAvaliable;
      if (bool)
      {
        try
        {
          this.mCurrentFrameBitmap = nativeDecodeNext(this.mExtData, this.mGifHandler);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.w("NativeGifIndex8", 2, localIllegalArgumentException.getMessage());
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.w("NativeGifIndex8", 2, localOutOfMemoryError1.getMessage());
          }
        }
        if ((this.mCurrentFrameBitmap == null) || (this.mExtData[1] != 0))
        {
          SharedPreferences localSharedPreferences = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
          if (localSharedPreferences != null) {
            localSharedPreferences.edit().putBoolean("use_new_gif_so", false).commit();
          }
        }
      }
      else
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.w("NativeGifIndex8", 2, "mIsGIFEngineAvaliable is false.");
        }
        if (this.mReqHeight <= 0) {
          break label373;
        }
        int i = this.mReqWidth;
        if (i <= 0) {
          break label373;
        }
        try
        {
          this.mCurrentFrameBitmap = BitmapFactory.decodeFile(this.mSrcGifFile);
          this.mCurrentFrameBitmap = Bitmap.createScaledBitmap(this.mCurrentFrameBitmap, this.mReqWidth, this.mReqHeight, true);
        }
        catch (Throwable localThrowable)
        {
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            localILog = URLDrawable.depImp.mLog;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getNextFrame failed, ");
            localStringBuilder.append(localThrowable.getMessage());
            localILog.e("NativeGifIndex8", 2, localStringBuilder.toString());
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          ILog localILog;
          StringBuilder localStringBuilder;
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            localILog = URLDrawable.depImp.mLog;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getNextFrame failed,[oom], ");
            localStringBuilder.append(localOutOfMemoryError2.getMessage());
            localILog.e("NativeGifIndex8", 2, localStringBuilder.toString());
          }
        }
      }
      return;
      label373:
      return;
    }
    finally {}
  }
  
  public int getWidth()
  {
    if (this.mGifHandler != 0) {
      return nativeGetWidth(this.mGifHandler);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.NativeGifIndex8
 * JD-Core Version:    0.7.0.1
 */