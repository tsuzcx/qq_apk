package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class KandianCompetitiveAdPandentView$11
  implements URLDrawableDownListener
{
  KandianCompetitiveAdPandentView$11(KandianCompetitiveAdPandentView paramKandianCompetitiveAdPandentView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if ((paramView instanceof ImageView)) {
      KandianCompetitiveAdPandentView.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView.11
 * JD-Core Version:    0.7.0.1
 */