package com.tencent.component.media.photogif;

import android.graphics.Bitmap;
import com.tencent.component.media.image.BitmapReference;

class NewAnimationDrawable$FrameRef
{
  int mBmpGenerationId;
  BitmapReference mBmpRef;
  
  public NewAnimationDrawable$FrameRef(BitmapReference paramBitmapReference)
  {
    this.mBmpRef = paramBitmapReference;
    this.mBmpGenerationId = paramBitmapReference.getBitmap().getGenerationId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.photogif.NewAnimationDrawable.FrameRef
 * JD-Core Version:    0.7.0.1
 */