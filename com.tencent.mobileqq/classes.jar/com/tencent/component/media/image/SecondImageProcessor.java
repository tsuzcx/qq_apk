package com.tencent.component.media.image;

import com.tencent.component.media.annotation.Public;

public abstract class SecondImageProcessor
{
  public final BitmapReference doProcess(BitmapReference paramBitmapReference, boolean paramBoolean)
  {
    BitmapReference localBitmapReference1;
    if (paramBitmapReference == null) {
      localBitmapReference1 = null;
    }
    BitmapReference localBitmapReference2;
    do
    {
      do
      {
        return localBitmapReference1;
        localBitmapReference2 = process(paramBitmapReference);
        localBitmapReference1 = paramBitmapReference;
      } while (localBitmapReference2 == null);
      localBitmapReference1 = paramBitmapReference;
    } while (localBitmapReference2 == paramBitmapReference);
    if ((paramBoolean) && (!paramBitmapReference.isRecycled())) {
      paramBitmapReference.release();
    }
    return localBitmapReference2;
  }
  
  @Public
  public abstract String id();
  
  @Public
  public abstract BitmapReference process(BitmapReference paramBitmapReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.SecondImageProcessor
 * JD-Core Version:    0.7.0.1
 */