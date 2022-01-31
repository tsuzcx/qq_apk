package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class GenericNewGifDecoder
  implements NewGifDecoder
{
  private GifInfoHandle jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle;
  private NewGifDecoder.GifFrame jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame;
  
  public GenericNewGifDecoder(GifInfoHandle paramGifInfoHandle)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle = paramGifInfoHandle;
  }
  
  public void changeFile(String paramString)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.changeFile(paramString);
  }
  
  public NewGifDecoder.GifFrame doRender(Bitmap paramBitmap)
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame = new NewGifDecoder.GifFrame(paramBitmap, this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.doRender(paramBitmap));
      NewGifDecoder.GifFrame localGifFrame = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame;
      return localGifFrame;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().w("GenericNewGifDecoder", new Object[] { "catch an exception:", Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
    return new NewGifDecoder.GifFrame(paramBitmap, -1L);
  }
  
  public Bitmap.Config getAcceptableConfig()
  {
    int i = this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getPreferConfig();
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    switch (i)
    {
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    default: 
      localConfig = Bitmap.Config.ARGB_8888;
    }
    for (;;)
    {
      ImageManagerEnv.getLogger().d("GenericNewGifDecoder", new Object[] { "index GifInfoHandle: preferBmpFormat--" + i });
      return localConfig;
      localConfig = Bitmap.Config.ARGB_8888;
      continue;
      localConfig = Bitmap.Config.RGB_565;
      continue;
      localConfig = Bitmap.Config.ARGB_4444;
      continue;
      localConfig = Bitmap.Config.ALPHA_8;
    }
  }
  
  public long getAllocationByteCount()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getAllocationByteCount();
  }
  
  public String getComment()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getComment();
  }
  
  public int getCurrentFrameIndex()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getCurrentFrameIndex();
  }
  
  public int getCurrentLoop()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getCurrentLoop();
  }
  
  public int getCurrentPosition()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getCurrentPosition();
  }
  
  public int getDuration()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getDuration();
  }
  
  public int getError()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getNativeErrorCode();
  }
  
  public int getFrameCount()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.frameCount;
  }
  
  public int getFrameDuration(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getFrameDuration(paramInt);
  }
  
  public int getHeight()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.height;
  }
  
  public int getImageCount()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getImageCount();
  }
  
  public int getLoopCount()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getLoopCount();
  }
  
  public long getSourceLength()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.getSourceLength();
  }
  
  public int getWidth()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.width;
  }
  
  public boolean isAnimationCompleted()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.isAnimationCompleted();
  }
  
  public boolean isRecycled()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.isRecycled();
    }
    return true;
  }
  
  public NewGifDecoder.GifFrame next(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame = new NewGifDecoder.GifFrame(paramBitmap, this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.renderFrame(paramBitmap));
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame;
  }
  
  public NewGifDecoder.GifFrame nextForGifPlay(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame = new NewGifDecoder.GifFrame(paramBitmap, this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.renderFrameForGifPlay(paramBitmap, paramBoolean));
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame;
  }
  
  public void prepareData()
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.prepareData();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().w("GenericNewGifDecoder", new Object[] { "catch an exception:", Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
  }
  
  public void recycle()
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.recycle();
  }
  
  public boolean reset()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.reset();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().w("GenericNewGifDecoder", new Object[] { "reset failed,catch an exception:", Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
    return false;
  }
  
  public Bitmap seekToFrame(int paramInt, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.seekToFrame(paramInt, paramBitmap);
    return paramBitmap;
  }
  
  public NewGifDecoder.GifFrame seekToFrameGetTime(int paramInt, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame = new NewGifDecoder.GifFrame(paramBitmap, this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.seekToFrameGetTime(paramInt, paramBitmap));
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder$GifFrame;
  }
  
  public Bitmap seekToTime(int paramInt, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.seekToTime(paramInt, paramBitmap);
    return paramBitmap;
  }
  
  public void setGifInfoHandler(GifInfoHandle paramGifInfoHandle)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle = paramGifInfoHandle;
  }
  
  public void setLoopCount(int paramInt)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.setLoopCount(paramInt);
  }
  
  public void setSpeed(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.setSpeedFactor(paramFloat);
  }
  
  public long start()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.restoreRemainder();
  }
  
  public void stop()
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.saveRemainder();
  }
  
  public void updateFile(String paramString)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifGifInfoHandle.updateFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.GenericNewGifDecoder
 * JD-Core Version:    0.7.0.1
 */