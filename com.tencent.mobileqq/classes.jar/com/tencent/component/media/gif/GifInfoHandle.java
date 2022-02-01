package com.tencent.component.media.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class GifInfoHandle
{
  static final GifInfoHandle NULL_INFO = new GifInfoHandle(0L, 0, 0, 0);
  int frameCount;
  private volatile long gifInfoPtr;
  final int height;
  final int width;
  
  static
  {
    System.loadLibrary("image_gif");
  }
  
  private GifInfoHandle(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.gifInfoPtr = paramLong;
    this.width = paramInt1;
    this.height = paramInt2;
    this.frameCount = paramInt3;
  }
  
  private static native void bindSurface(long paramLong, Surface paramSurface, long[] paramArrayOfLong, boolean paramBoolean);
  
  static native long changeFile(long paramLong, String paramString, boolean paramBoolean);
  
  private static native long doRender(long paramLong, Bitmap paramBitmap);
  
  private static native void free(long paramLong);
  
  private static native long getAllocationByteCount(long paramLong);
  
  private static native String getComment(long paramLong);
  
  private static native int getCurrentFrameIndex(long paramLong);
  
  private static native int getCurrentLoop(long paramLong);
  
  private static native int getCurrentPosition(long paramLong);
  
  private static native int getDuration(long paramLong);
  
  private static native int getFrameDuration(long paramLong, int paramInt);
  
  private static native int getImageCount(long paramLong);
  
  private static native int getLoopCount(long paramLong);
  
  private static native int getNativeErrorCode(long paramLong);
  
  private static native int getPreferConfig(long paramLong);
  
  private static native long[] getSavedState(long paramLong);
  
  private static native long getSourceLength(long paramLong);
  
  private static native boolean isAnimationCompleted(long paramLong);
  
  static GifInfoHandle openAssetFileDescriptor(AssetFileDescriptor paramAssetFileDescriptor, boolean paramBoolean, NewGifDecoder.Options paramOptions)
  {
    try
    {
      paramOptions = openFd(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramBoolean, paramOptions);
      return paramOptions;
    }
    finally
    {
      paramAssetFileDescriptor.close();
    }
  }
  
  static native GifInfoHandle openByteArray(byte[] paramArrayOfByte, boolean paramBoolean, NewGifDecoder.Options paramOptions);
  
  static native GifInfoHandle openDirectByteBuffer(ByteBuffer paramByteBuffer, boolean paramBoolean, NewGifDecoder.Options paramOptions);
  
  static native GifInfoHandle openFd(FileDescriptor paramFileDescriptor, long paramLong, boolean paramBoolean, NewGifDecoder.Options paramOptions);
  
  static native GifInfoHandle openFile(String paramString, boolean paramBoolean, NewGifDecoder.Options paramOptions);
  
  static native GifInfoHandle openFileForGifPlaying(String paramString, boolean paramBoolean, NewGifDecoder.Options paramOptions);
  
  static GifInfoHandle openMarkableInputStream(InputStream paramInputStream, boolean paramBoolean, NewGifDecoder.Options paramOptions)
  {
    if (paramInputStream.markSupported()) {
      return openStream(paramInputStream, paramBoolean, paramOptions);
    }
    throw new IllegalArgumentException("InputStream does not support marking");
  }
  
  static native GifInfoHandle openStream(InputStream paramInputStream, boolean paramBoolean, NewGifDecoder.Options paramOptions);
  
  static GifInfoHandle openUri(ContentResolver paramContentResolver, Uri paramUri, boolean paramBoolean, NewGifDecoder.Options paramOptions)
  {
    if ("file".equals(paramUri.getScheme())) {
      return openFile(paramUri.getPath(), paramBoolean, null);
    }
    return openAssetFileDescriptor(paramContentResolver.openAssetFileDescriptor(paramUri, "r"), paramBoolean, paramOptions);
  }
  
  private static native void postUnbindSurface(long paramLong);
  
  private static native int prepareData(long paramLong);
  
  private static native long renderFrame(long paramLong, Bitmap paramBitmap);
  
  private static native long renderFrameForGifPlay(long paramLong, Bitmap paramBitmap, boolean paramBoolean);
  
  private static native boolean reset(long paramLong);
  
  private static native long restoreRemainder(long paramLong);
  
  private static native int restoreSavedState(long paramLong, long[] paramArrayOfLong, Bitmap paramBitmap);
  
  private static native void saveRemainder(long paramLong);
  
  private static native void seekToFrame(long paramLong, int paramInt, Bitmap paramBitmap);
  
  private static native long seekToFrameGetTime(long paramLong, int paramInt, Bitmap paramBitmap);
  
  private static native void seekToTime(long paramLong, int paramInt, Bitmap paramBitmap);
  
  private static native void setLoopCount(long paramLong, int paramInt);
  
  private static native void setSpeedFactor(long paramLong, float paramFloat);
  
  static native long updateFile(long paramLong, String paramString, boolean paramBoolean);
  
  void bindSurface(Surface paramSurface, long[] paramArrayOfLong, boolean paramBoolean)
  {
    bindSurface(this.gifInfoPtr, paramSurface, paramArrayOfLong, paramBoolean);
  }
  
  void changeFile(String paramString)
  {
    try
    {
      changeFile(this.gifInfoPtr, paramString, false);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  long doRender(Bitmap paramBitmap)
  {
    return doRender(this.gifInfoPtr, paramBitmap);
  }
  
  protected void finalize()
  {
    try
    {
      recycle();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  long getAllocationByteCount()
  {
    try
    {
      long l = getAllocationByteCount(this.gifInfoPtr);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  String getComment()
  {
    try
    {
      String str = getComment(this.gifInfoPtr);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getCurrentFrameIndex()
  {
    try
    {
      int i = getCurrentFrameIndex(this.gifInfoPtr);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getCurrentLoop()
  {
    try
    {
      int i = getCurrentLoop(this.gifInfoPtr);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getCurrentPosition()
  {
    try
    {
      int i = getCurrentPosition(this.gifInfoPtr);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getDuration()
  {
    try
    {
      int i = getDuration(this.gifInfoPtr);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getFrameDuration(int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < this.frameCount)
      {
        paramInt = getFrameDuration(this.gifInfoPtr, paramInt);
        return paramInt;
      }
      throw new IndexOutOfBoundsException("Frame index is out of bounds");
    }
    finally {}
  }
  
  int getImageCount()
  {
    try
    {
      this.frameCount = getImageCount(this.gifInfoPtr);
      int i = this.frameCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getLoopCount()
  {
    try
    {
      int i = getLoopCount(this.gifInfoPtr);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getNativeErrorCode()
  {
    try
    {
      int i = getNativeErrorCode(this.gifInfoPtr);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getPreferConfig()
  {
    return getPreferConfig(this.gifInfoPtr);
  }
  
  long[] getSavedState()
  {
    try
    {
      long[] arrayOfLong = getSavedState(this.gifInfoPtr);
      return arrayOfLong;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  long getSourceLength()
  {
    try
    {
      long l = getSourceLength(this.gifInfoPtr);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean isAnimationCompleted()
  {
    try
    {
      boolean bool = isAnimationCompleted(this.gifInfoPtr);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean isRecycled()
  {
    try
    {
      long l = this.gifInfoPtr;
      boolean bool;
      if (l == 0L) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void postUnbindSurface()
  {
    try
    {
      postUnbindSurface(this.gifInfoPtr);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void prepareData()
  {
    prepareData(this.gifInfoPtr);
  }
  
  void recycle()
  {
    try
    {
      free(this.gifInfoPtr);
      this.gifInfoPtr = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  long renderFrame(Bitmap paramBitmap)
  {
    try
    {
      long l = renderFrame(this.gifInfoPtr, paramBitmap);
      return l;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  long renderFrameForGifPlay(Bitmap paramBitmap, boolean paramBoolean)
  {
    try
    {
      long l = renderFrameForGifPlay(this.gifInfoPtr, paramBitmap, paramBoolean);
      return l;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  boolean reset()
  {
    try
    {
      boolean bool = reset(this.gifInfoPtr);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  long restoreRemainder()
  {
    try
    {
      long l = restoreRemainder(this.gifInfoPtr);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int restoreSavedState(long[] paramArrayOfLong, Bitmap paramBitmap)
  {
    try
    {
      int i = restoreSavedState(this.gifInfoPtr, paramArrayOfLong, paramBitmap);
      return i;
    }
    finally
    {
      paramArrayOfLong = finally;
      throw paramArrayOfLong;
    }
  }
  
  void saveRemainder()
  {
    try
    {
      saveRemainder(this.gifInfoPtr);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void seekToFrame(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      seekToFrame(this.gifInfoPtr, paramInt, paramBitmap);
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  long seekToFrameGetTime(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      long l = seekToFrameGetTime(this.gifInfoPtr, paramInt, paramBitmap);
      return l;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  void seekToTime(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      seekToTime(this.gifInfoPtr, paramInt, paramBitmap);
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  void setLoopCount(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 65535)) {
      try
      {
        setLoopCount(this.gifInfoPtr, paramInt);
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException("Loop count of range <0, 65535>");
  }
  
  void setSpeedFactor(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (!Float.isNaN(paramFloat)))
    {
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      try
      {
        setSpeedFactor(this.gifInfoPtr, f);
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException("Speed factor is not positive");
  }
  
  void updateFile(String paramString)
  {
    try
    {
      updateFile(this.gifInfoPtr, paramString, false);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.gif.GifInfoHandle
 * JD-Core Version:    0.7.0.1
 */