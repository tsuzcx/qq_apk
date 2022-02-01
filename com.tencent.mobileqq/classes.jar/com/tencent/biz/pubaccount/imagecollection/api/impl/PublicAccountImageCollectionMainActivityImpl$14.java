package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class PublicAccountImageCollectionMainActivityImpl$14
  implements URLDrawable.URLDrawableListener
{
  PublicAccountImageCollectionMainActivityImpl$14(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.a.getStatus() == 1) && ((this.a.getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)this.a.getCurrDrawable();
      this.b.thumbBitmap = paramURLDrawable.getBitmap();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.14
 * JD-Core Version:    0.7.0.1
 */