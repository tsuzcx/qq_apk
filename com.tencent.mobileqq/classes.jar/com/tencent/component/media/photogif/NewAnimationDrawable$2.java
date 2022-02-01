package com.tencent.component.media.photogif;

import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.utils.LruCache;

class NewAnimationDrawable$2
  extends LruCache<String, BitmapReference>
{
  NewAnimationDrawable$2(NewAnimationDrawable paramNewAnimationDrawable, int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOf(String paramString, BitmapReference paramBitmapReference)
  {
    return paramBitmapReference.getAllocSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.photogif.NewAnimationDrawable.2
 * JD-Core Version:    0.7.0.1
 */