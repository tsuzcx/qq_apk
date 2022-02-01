package com.tencent.component.media.image;

import com.tencent.component.media.annotation.Public;

public abstract class SecondImageProcessor
{
  public final BitmapReference doProcess(BitmapReference paramBitmapReference, boolean paramBoolean)
  {
    if (paramBitmapReference == null) {
      return null;
    }
    BitmapReference localBitmapReference = process(paramBitmapReference);
    if (localBitmapReference != null)
    {
      if (localBitmapReference == paramBitmapReference) {
        return paramBitmapReference;
      }
      if ((paramBoolean) && (!paramBitmapReference.isRecycled())) {
        paramBitmapReference.release();
      }
      return localBitmapReference;
    }
    return paramBitmapReference;
  }
  
  @Public
  public abstract String id();
  
  @Public
  public abstract BitmapReference process(BitmapReference paramBitmapReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.SecondImageProcessor
 * JD-Core Version:    0.7.0.1
 */