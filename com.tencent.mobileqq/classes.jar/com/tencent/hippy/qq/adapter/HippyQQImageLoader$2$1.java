package com.tencent.hippy.qq.adapter;

import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.qphone.base.util.QLog;

class HippyQQImageLoader$2$1
  implements Runnable
{
  HippyQQImageLoader$2$1(HippyQQImageLoader.2 param2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + this.this$1.val$realUrl + " useLocal onRequestSuccess");
    }
    this.this$1.val$requestCallback.onRequestSuccess(this.this$1.val$hippyTarget);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.2.1
 * JD-Core Version:    0.7.0.1
 */