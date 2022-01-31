package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.sharpP.SharpPGifDecoder;

public class SharpPNewGifDecoder
  implements NewGifDecoder
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  private SharpPGifDecoder jdField_a_of_type_ComTencentSharpPSharpPGifDecoder;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SharpPNewGifDecoder(String paramString)
  {
    this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder = new SharpPGifDecoder(paramString);
  }
  
  public SharpPNewGifDecoder(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder = new SharpPGifDecoder(paramString, paramInt1, paramInt2);
  }
  
  public void changeFile(String paramString) {}
  
  public NewGifDecoder.GifFrame doRender(Bitmap paramBitmap)
  {
    return null;
  }
  
  public Bitmap.Config getAcceptableConfig()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.a();
  }
  
  public long getAllocationByteCount()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.i();
  }
  
  public String getComment()
  {
    return null;
  }
  
  public int getCurrentFrameIndex()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.c();
  }
  
  public int getCurrentLoop()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.h();
  }
  
  public int getCurrentPosition()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.c();
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
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.f();
  }
  
  public int getFrameDuration(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.b();
  }
  
  public int getHeight()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.e();
  }
  
  public int getImageCount()
  {
    return 0;
  }
  
  public int getLoopCount()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.g();
  }
  
  public long getSourceLength()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.a();
  }
  
  public int getWidth()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.d();
  }
  
  public boolean isAnimationCompleted()
  {
    return false;
  }
  
  public boolean isRecycled()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public NewGifDecoder.GifFrame next(Bitmap paramBitmap)
  {
    NewGifDecoder.GifFrame localGifFrame = this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.a(paramBitmap);
    if (localGifFrame != null)
    {
      localGifFrame.delay = ((int)((float)localGifFrame.delay / this.jdField_a_of_type_Float));
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
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.a();
  }
  
  public boolean reset()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.a();
  }
  
  public Bitmap seekToFrame(int paramInt, Bitmap paramBitmap)
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.a(paramInt, paramBitmap);
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
    this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.b(paramInt);
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
    this.jdField_a_of_type_Float = f;
  }
  
  public long start()
  {
    this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = false;
    return 0L;
  }
  
  public void stop()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.c();
    this.jdField_a_of_type_ComTencentSharpPSharpPGifDecoder.a();
  }
  
  public void updateFile(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.SharpPNewGifDecoder
 * JD-Core Version:    0.7.0.1
 */