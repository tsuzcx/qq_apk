package com.tencent.biz.qqstory.newshare.job;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class UrlDrawableDownloadJob$1
  implements URLDrawable.URLDrawableListener
{
  UrlDrawableDownloadJob$1(UrlDrawableDownloadJob paramUrlDrawableDownloadJob) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    UrlDrawableDownloadJob.c(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    UrlDrawableDownloadJob.b(this.a, false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a("UrlDrawableDownloadJob_dra", paramURLDrawable.getCurrDrawable());
    UrlDrawableDownloadJob.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.UrlDrawableDownloadJob.1
 * JD-Core Version:    0.7.0.1
 */