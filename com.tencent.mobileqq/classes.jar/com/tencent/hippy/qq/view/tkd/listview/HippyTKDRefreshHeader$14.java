package com.tencent.hippy.qq.view.tkd.listview;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.utils.ImageUtil;

class HippyTKDRefreshHeader$14
  implements URLDrawable.URLDrawableListener
{
  HippyTKDRefreshHeader$14(HippyTKDRefreshHeader paramHippyTKDRefreshHeader, HippyTKDRefreshHeader.ImageRequestListener paramImageRequestListener, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.val$listener.onRequestFail(paramThrowable, this.val$url);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.val$listener.onRequestSuccess(ImageUtil.b(paramURLDrawable), this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.14
 * JD-Core Version:    0.7.0.1
 */