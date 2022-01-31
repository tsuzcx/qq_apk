package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class NativeApngDecoder
  implements Handler.Callback
{
  public static final int ERROR_CODE_SUCCESS = 0;
  public static final int GET_NEXT_FRAME = 1;
  private static final int IMAGE_INFO_INDEX_CURRENTFRAM = 3;
  private static final int IMAGE_INFO_INDEX_ERRORCODE = 5;
  private static final int IMAGE_INFO_INDEX_FRAMECOUNT = 2;
  private static final int IMAGE_INFO_INDEX_FRAMEDELAY = 4;
  private static final int IMAGE_INFO_INDEX_HEIGHT = 1;
  private static final int IMAGE_INFO_INDEX_WIDTH = 0;
  public static final int PRE_LOAD_NEXT_FRAME = 2;
  public static final String TAG = "NativeApngDecoder";
  private long curFrameBegin;
  protected int currentFrameDelay;
  private int currentTotalDelay;
  private HandlerThread decodeThread;
  int decryptType;
  private boolean hasPreLoad;
  public int height;
  protected int mCurBitmapBufferIndex = -1;
  protected Bitmap mCurrentFrameBitmap;
  private int mFrameCount;
  private Handler mHandler;
  int[] mImageInfo = new int[7];
  protected Bitmap mNextFrameBitmap;
  private volatile long nativeFrameInfoInstance;
  long nativeImageInstance;
  private Paint paint = new Paint();
  private Paint paintTransparentBlack = new Paint();
  public int width;
  
  public NativeApngDecoder(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    this.decodeThread = new HandlerThread("gif_decode_thread");
    this.decodeThread.start();
    this.mHandler = new Handler(this.decodeThread.getLooper(), this);
    this.paint.setAntiAlias(true);
    this.paintTransparentBlack.setAntiAlias(true);
    this.paintTransparentBlack.setColor(0);
    getImageInfo(paramFile);
    if ((this.width > 0) && (this.height > 0)) {}
    try
    {
      this.mCurrentFrameBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
      this.mNextFrameBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
      this.nativeFrameInfoInstance = ApngImage.nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.mCurrentFrameBitmap, this.mImageInfo);
      if (this.mImageInfo[5] == 0) {
        this.currentFrameDelay = this.mImageInfo[4];
      }
      this.mCurBitmapBufferIndex = 0;
      return;
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          this.mCurrentFrameBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
          this.mNextFrameBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramFile)
        {
          QLog.e("NativeApngDecoder", 1, "APNG create Bitmap OOM");
        }
      }
    }
  }
  
  private void getImageInfo(File paramFile)
  {
    this.nativeImageInstance = ApngImage.nativeStartDecode(paramFile.getAbsolutePath(), this.mImageInfo, this.decryptType);
    if (this.mImageInfo[5] == 0)
    {
      this.width = this.mImageInfo[0];
      this.height = this.mImageInfo[1];
      this.mFrameCount = this.mImageInfo[2];
      if (QLog.isColorLevel()) {
        QLog.d("NativeApngDecoder", 2, "start decode success width = " + this.width + " height = " + this.height + " frameCount = " + this.mFrameCount);
      }
      return;
    }
    QLog.e("NativeApngDecoder", 1, "start decode error: " + this.mImageInfo[5]);
  }
  
  protected void finalize()
  {
    if (this.nativeFrameInfoInstance != 0L) {
      ApngImage.nativeFreeFrame(this.nativeFrameInfoInstance);
    }
    if (this.nativeImageInstance != 0L) {
      ApngImage.nativeFreeImage(this.nativeImageInstance);
    }
    super.finalize();
  }
  
  public int getHeight()
  {
    if (this.mCurrentFrameBitmap != null) {
      return this.mCurrentFrameBitmap.getHeight();
    }
    return 0;
  }
  
  public Bitmap getNextFrameBitmap(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.currentFrameDelay * 1000 * 1000;
    if (QLog.isColorLevel()) {
      QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| timestamp = " + paramLong);
    }
    long l3 = paramLong - this.curFrameBegin;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getNextFrameBitmap| interval = ");
      if (l3 < l2)
      {
        bool = true;
        QLog.d("NativeApngDecoder", 2, bool);
      }
    }
    else
    {
      if (l3 >= l2) {
        break label230;
      }
      if (!this.hasPreLoad)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 2;
        ((Message)localObject).arg1 = this.mCurBitmapBufferIndex;
        ((Message)localObject).arg2 = 0;
        this.mHandler.sendMessage((Message)localObject);
      }
      label157:
      localObject = null;
      if (this.mCurBitmapBufferIndex != 0) {
        break label323;
      }
      localObject = this.mCurrentFrameBitmap;
    }
    for (;;)
    {
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| gifTime= " + l2 + ",cost=" + (paramLong - l1));
      }
      return localObject;
      bool = false;
      break;
      label230:
      if (this.hasPreLoad)
      {
        if (this.mCurBitmapBufferIndex == 0) {}
        for (int i = 1;; i = 0)
        {
          this.mCurBitmapBufferIndex = i;
          this.curFrameBegin = paramLong;
          this.hasPreLoad = false;
          localObject = Message.obtain();
          ((Message)localObject).what = 2;
          ((Message)localObject).arg1 = this.mCurBitmapBufferIndex;
          ((Message)localObject).arg2 = 1;
          this.mHandler.sendMessage((Message)localObject);
          break;
        }
      }
      if (!QLog.isColorLevel()) {
        break label157;
      }
      QLog.e("NativeApngDecoder", 2, "getNextFrameBitmap| had not preLoad ");
      break label157;
      label323:
      if (this.mCurBitmapBufferIndex == 1) {
        localObject = this.mNextFrameBitmap;
      }
    }
  }
  
  public int getWidth()
  {
    if (this.mCurrentFrameBitmap != null) {
      return this.mCurrentFrameBitmap.getWidth();
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if ((this.mCurBitmapBufferIndex == -1) || (this.mCurBitmapBufferIndex == 1))
      {
        this.nativeFrameInfoInstance = ApngImage.nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.mCurrentFrameBitmap, this.mImageInfo);
        this.mCurBitmapBufferIndex = 0;
      }
    }
    while (paramMessage.what != 2)
    {
      do
      {
        return false;
      } while (this.mCurBitmapBufferIndex != 0);
      this.nativeFrameInfoInstance = ApngImage.nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.mNextFrameBitmap, this.mImageInfo);
      this.mCurBitmapBufferIndex = 1;
      return false;
    }
    long l1 = System.currentTimeMillis();
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    if (QLog.isColorLevel()) {
      QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| PRE_LOAD_FRAME Begin + type:" + j);
    }
    if (i == 0)
    {
      this.nativeFrameInfoInstance = ApngImage.nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.mNextFrameBitmap, this.mImageInfo);
      label173:
      if (this.mImageInfo[5] != 0) {
        break label288;
      }
      this.currentFrameDelay = this.mImageInfo[4];
    }
    for (;;)
    {
      this.hasPreLoad = true;
      i = this.mImageInfo[3];
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| PRE_LOAD_FRAME END curIndex= " + i + ", cost=" + (l2 - l1));
      return false;
      if (i != 1) {
        break label173;
      }
      this.nativeFrameInfoInstance = ApngImage.nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.mCurrentFrameBitmap, this.mImageInfo);
      break label173;
      label288:
      if (QLog.isColorLevel()) {
        QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap|error");
      }
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", new Object[] { Integer.valueOf(this.mImageInfo[0]), Integer.valueOf(this.mImageInfo[1]), Integer.valueOf(this.mImageInfo[2]), Integer.valueOf(this.mImageInfo[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.image.NativeApngDecoder
 * JD-Core Version:    0.7.0.1
 */