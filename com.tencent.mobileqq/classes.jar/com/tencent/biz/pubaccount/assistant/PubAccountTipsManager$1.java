package com.tencent.biz.pubaccount.assistant;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;

class PubAccountTipsManager$1
  implements URLDrawableDownListener
{
  PubAccountTipsManager$1(PubAccountTipsManager paramPubAccountTipsManager) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PubAccountTipsManager", 2, "img Load Failed.");
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PubAccountTipsManager", 2, "img Load Interrupted.");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (PubAccountTipsManager.a(this.a) != null) {
      PubAccountTipsManager.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountTipsManager.1
 * JD-Core Version:    0.7.0.1
 */