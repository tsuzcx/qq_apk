package com.tencent.biz.troop.feeds;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class TroopNewGuidePopWindow$7
  implements URLDrawableDownListener
{
  TroopNewGuidePopWindow$7(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.a(false, "onLoadCancelled");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.a(false, "onLoadFailed");
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    this.a.a(false, "onLoadInterrupted");
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.a(true, "onLoadSuccessed");
    this.a.t = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.7
 * JD-Core Version:    0.7.0.1
 */