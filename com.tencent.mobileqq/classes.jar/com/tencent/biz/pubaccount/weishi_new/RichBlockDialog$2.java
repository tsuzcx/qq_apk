package com.tencent.biz.pubaccount.weishi_new;

import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

class RichBlockDialog$2
  implements URLDrawableDownListener
{
  RichBlockDialog$2(RichBlockDialog paramRichBlockDialog) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    WSLog.c("RichBlockDialog", "onLoadCanceled - ");
    if (RichBlockDialog.h(this.a) != null) {
      RichBlockDialog.h(this.a).setImageResource(2130842687);
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (RichBlockDialog.h(this.a) != null) {
      RichBlockDialog.h(this.a).setImageResource(2130842687);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    RichBlockDialog.g(this.a);
    WSFallKeyPicMonitor.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.RichBlockDialog.2
 * JD-Core Version:    0.7.0.1
 */