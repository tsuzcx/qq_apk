package com.tencent.hippy.qq.adapter;

import android.os.Handler;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import java.io.File;
import java.util.TimerTask;

class HippyQQImageLoader$2
  extends TimerTask
{
  HippyQQImageLoader$2(HippyQQImageLoader paramHippyQQImageLoader, HippyDrawable paramHippyDrawable, File paramFile, boolean paramBoolean, HippyImageLoader.Callback paramCallback) {}
  
  public void run()
  {
    this.val$hippyTarget.setData(this.val$localFile, this.val$isGif);
    HippyQQImageLoader.access$000(this.this$0).post(new HippyQQImageLoader.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.2
 * JD-Core Version:    0.7.0.1
 */