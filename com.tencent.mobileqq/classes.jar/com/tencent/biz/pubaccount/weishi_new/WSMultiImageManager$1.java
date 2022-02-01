package com.tencent.biz.pubaccount.weishi_new;

import android.view.View;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class WSMultiImageManager$1
  implements URLDrawableDownListener
{
  WSMultiImageManager$1(WSMultiImageManager paramWSMultiImageManager) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    WSMultiImageManager.a(this.a);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    WSMultiImageManager.a(this.a);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    WSMultiImageManager.a(this.a);
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSMultiImageManager.1
 * JD-Core Version:    0.7.0.1
 */