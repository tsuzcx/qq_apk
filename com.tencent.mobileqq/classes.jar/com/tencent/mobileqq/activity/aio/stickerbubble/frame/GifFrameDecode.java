package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.Bitmap;
import com.tencent.image.NativeGifImage;
import java.io.File;

public class GifFrameDecode
  extends NativeGifImage
  implements IFrameDecode
{
  public GifFrameDecode(File paramFile, boolean paramBoolean)
  {
    super(paramFile, paramBoolean);
  }
  
  public int a()
  {
    return this.mMetaData[POST_INVALIDATION_TIME_INDEX];
  }
  
  public Bitmap a()
  {
    return this.mCurrentFrameBitmap;
  }
  
  public void a()
  {
    getNextFrame();
    applyNextFrame();
  }
  
  public int b()
  {
    return this.mMetaData[FRAME_COUNT_INDEX];
  }
  
  public void b() {}
  
  public int c()
  {
    return this.mCurrentFrameIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.GifFrameDecode
 * JD-Core Version:    0.7.0.1
 */