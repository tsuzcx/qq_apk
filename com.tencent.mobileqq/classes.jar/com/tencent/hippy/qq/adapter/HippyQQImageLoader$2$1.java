package com.tencent.hippy.qq.adapter;

import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.qphone.base.util.QLog;

class HippyQQImageLoader$2$1
  implements Runnable
{
  HippyQQImageLoader$2$1(HippyQQImageLoader.2 param2, HippyDrawable paramHippyDrawable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "onImageDownloadSuccessed url:" + this.this$1.val$imageInfo.url + " useLocal onRequestSuccess");
    }
    this.this$1.val$imageInfo.onRequestSuccess(this.val$hippyTarget);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.2.1
 * JD-Core Version:    0.7.0.1
 */