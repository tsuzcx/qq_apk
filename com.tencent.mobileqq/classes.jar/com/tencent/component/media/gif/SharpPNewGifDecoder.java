package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.sharpP.SharpPGifDecoder;

public class SharpPNewGifDecoder
  implements NewGifDecoder
{
  private static final String TAG = "SharpPNewGifDecoder";
  private boolean isRecycled = false;
  private Handler mCtrlHandler = new Handler(ImageManagerEnv.g().getDispatcher());
  private int mCurFrameIndex = 0;
  private SharpPGifDecoder mDecoder;
  private float speedFactor = 1.0F;
  
  public SharpPNewGifDecoder(String paramString)
  {
    this.mDecoder = new SharpPGifDecoder(paramString);
  }
  
  public SharpPNewGifDecoder(String paramString, int paramInt1, int paramInt2)
  {
    this.mDecoder = new SharpPGifDecoder(paramString, paramInt1, paramInt2);
  }
  
  public void changeFile(String paramString) {}
  
  public NewGifDecoder.GifFrame doRender(Bitmap paramBitmap)
  {
    return null;
  }
  
  public Bitmap.Config getAcceptableConfig()
  {
    return this.mDecoder.getAcceptableBitmapConfig();
  }
  
  public long getAllocationByteCount()
  {
    return this.mDecoder.getAllocationByteCount();
  }
  
  public String getComment()
  {
    return null;
  }
  
  public int getCurrentFrameIndex()
  {
    return this.mDecoder.getCurFrameIndex();
  }
  
  public int getCurrentLoop()
  {
    return this.mDecoder.getCurrentLoop();
  }
  
  public int getCurrentPosition()
  {
    return this.mDecoder.getCurFrameIndex();
  }
  
  public int getDuration()
  {
    return 2147483647;
  }
  
  public int getError()
  {
    return 0;
  }
  
  public int getFrameCount()
  {
    return this.mDecoder.getFrameCount();
  }
  
  public int getFrameDuration(int paramInt)
  {
    return this.mDecoder.getCurFrameDuration();
  }
  
  public int getHeight()
  {
    return this.mDecoder.getDstHeight();
  }
  
  public int getImageCount()
  {
    return 0;
  }
  
  public int getLoopCount()
  {
    return this.mDecoder.getLoopCount();
  }
  
  public long getSourceLength()
  {
    return this.mDecoder.getSourceLength();
  }
  
  public int getWidth()
  {
    return this.mDecoder.getDstWidth();
  }
  
  public boolean isAnimationCompleted()
  {
    return false;
  }
  
  public boolean isRecycled()
  {
    return this.isRecycled;
  }
  
  public NewGifDecoder.GifFrame next(Bitmap paramBitmap)
  {
    NewGifDecoder.GifFrame localGifFrame = this.mDecoder.next(paramBitmap);
    if (localGifFrame != null)
    {
      localGifFrame.delay = ((int)((float)localGifFrame.delay / this.speedFactor));
      return localGifFrame;
    }
    return new NewGifDecoder.GifFrame(paramBitmap, 200L);
  }
  
  public NewGifDecoder.GifFrame nextForGifPlay(Bitmap paramBitmap, boolean paramBoolean)
  {
    return null;
  }
  
  public void prepareData() {}
  
  public void recycle()
  {
    ImageManagerEnv.getLogger().d("SharpPNewGifDecoder", new Object[] { "recycle" });
    this.isRecycled = true;
    this.mDecoder.close();
  }
  
  public boolean reset()
  {
    this.isRecycled = false;
    this.mCurFrameIndex = 0;
    return this.mDecoder.reset();
  }
  
  public Bitmap seekToFrame(int paramInt, Bitmap paramBitmap)
  {
    return this.mDecoder.seekToFrame(paramInt, paramBitmap);
  }
  
  public NewGifDecoder.GifFrame seekToFrameGetTime(int paramInt, Bitmap paramBitmap)
  {
    return null;
  }
  
  public Bitmap seekToTime(int paramInt, Bitmap paramBitmap)
  {
    return seekToFrame(paramInt, paramBitmap);
  }
  
  public void setGifInfoHandler(GifInfoHandle paramGifInfoHandle) {}
  
  public void setLoopCount(int paramInt)
  {
    this.mDecoder.setLoopCount(paramInt);
  }
  
  public void setSpeed(float paramFloat)
  {
    if ((paramFloat <= 0.0F) || (Float.isNaN(paramFloat))) {
      throw new IllegalArgumentException("Speed factor is not positive");
    }
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.speedFactor = f;
  }
  
  public long start()
  {
    this.mCtrlHandler.post(new SharpPNewGifDecoder.1(this));
    return 0L;
  }
  
  public void stop()
  {
    this.mCurFrameIndex = this.mDecoder.getCurFrameIndex();
    this.mDecoder.close();
  }
  
  public void updateFile(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.gif.SharpPNewGifDecoder
 * JD-Core Version:    0.7.0.1
 */