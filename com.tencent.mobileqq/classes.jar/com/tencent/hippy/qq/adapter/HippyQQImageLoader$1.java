package com.tencent.hippy.qq.adapter;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;

class HippyQQImageLoader$1
  implements Runnable
{
  HippyQQImageLoader$1(HippyQQImageLoader paramHippyQQImageLoader, String paramString, URLDrawable paramURLDrawable, HippyImageLoader.Callback paramCallback, HippyDrawable paramHippyDrawable) {}
  
  public void run()
  {
    if (!this.val$resizeMode.equals("cover"))
    {
      Drawable localDrawable = this.val$urlDrawable.getCurrDrawable();
      if ((localDrawable instanceof ApngDrawable)) {
        ((ApngDrawable)localDrawable).setGravity(17);
      }
    }
    this.val$requestCallback.onRequestSuccess(this.val$hippyTarget);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.1
 * JD-Core Version:    0.7.0.1
 */