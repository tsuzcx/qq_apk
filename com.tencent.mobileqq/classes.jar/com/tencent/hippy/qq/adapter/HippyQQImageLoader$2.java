package com.tencent.hippy.qq.adapter;

import android.os.Handler;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class HippyQQImageLoader$2
  implements Runnable
{
  HippyQQImageLoader$2(HippyQQImageLoader paramHippyQQImageLoader, String paramString, HippyDrawable paramHippyDrawable, File paramFile, boolean paramBoolean, HippyImageLoader.Callback paramCallback) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + this.val$realUrl + " useLocal setData");
    }
    this.val$hippyTarget.setData(this.val$localFile, this.val$isGif);
    HippyQQImageLoader.access$000(this.this$0).post(new HippyQQImageLoader.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.2
 * JD-Core Version:    0.7.0.1
 */