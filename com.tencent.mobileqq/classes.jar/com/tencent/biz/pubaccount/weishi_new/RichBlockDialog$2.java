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
    if (RichBlockDialog.a(this.a) != null) {
      RichBlockDialog.a(this.a).setImageResource(2130841770);
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (RichBlockDialog.a(this.a) != null) {
      RichBlockDialog.a(this.a).setImageResource(2130841770);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    RichBlockDialog.a(this.a);
    WSFallKeyPicMonitor.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.RichBlockDialog.2
 * JD-Core Version:    0.7.0.1
 */