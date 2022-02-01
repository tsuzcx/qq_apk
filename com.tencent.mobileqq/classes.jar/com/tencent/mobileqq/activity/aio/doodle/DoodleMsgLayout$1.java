package com.tencent.mobileqq.activity.aio.doodle;

import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class DoodleMsgLayout$1
  implements URLDrawableDownListener
{
  DoodleMsgLayout$1(DoodleMsgLayout paramDoodleMsgLayout) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == DoodleMsgLayout.a(this.a))
    {
      DoodleMsgLayout.a(this.a, true);
      DoodleMsgLayout.b(this.a);
      return;
    }
    if (paramView == DoodleMsgLayout.c(this.a))
    {
      ((GifDrawable)paramURLDrawable.getCurrDrawable()).setGIFPlayOnceListener(this.a);
      return;
    }
    DoodleMsgLayout.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.1
 * JD-Core Version:    0.7.0.1
 */