package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.utils.ImageUtil;

class SelectVideoPresenter$7
  implements URLDrawable.URLDrawableListener
{
  SelectVideoPresenter$7(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SelectVideoPresenter.b(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.b(paramURLDrawable.getCurrDrawable());
    SelectVideoPresenter.a(this.a, paramURLDrawable, SelectVideoPresenter.a(this.a).e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoPresenter.7
 * JD-Core Version:    0.7.0.1
 */