package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class TopicShareHelper$1
  implements URLDrawable.URLDrawableListener
{
  TopicShareHelper$1(TopicShareHelper paramTopicShareHelper) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((TopicShareHelper.a(this.a) != null) && (TopicShareHelper.a(this.a).getStatus() == 1) && ((TopicShareHelper.a(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)TopicShareHelper.a(this.a).getCurrDrawable();
      TopicShareHelper.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.1
 * JD-Core Version:    0.7.0.1
 */