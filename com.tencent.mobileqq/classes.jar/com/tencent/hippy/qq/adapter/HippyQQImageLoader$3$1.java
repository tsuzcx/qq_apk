package com.tencent.hippy.qq.adapter;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;

class HippyQQImageLoader$3$1
  implements Runnable
{
  HippyQQImageLoader$3$1(HippyQQImageLoader.3 param3, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (!this.this$1.val$resizeMode.equals("cover"))
    {
      Drawable localDrawable = this.val$urlDrawable.getCurrDrawable();
      if ((localDrawable instanceof ApngDrawable)) {
        ((ApngDrawable)localDrawable).setGravity(17);
      }
    }
    this.this$1.val$requestCallback.onRequestSuccess(this.this$1.val$hippyTarget);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.3.1
 * JD-Core Version:    0.7.0.1
 */