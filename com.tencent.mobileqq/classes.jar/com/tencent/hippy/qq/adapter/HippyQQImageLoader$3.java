package com.tencent.hippy.qq.adapter;

import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.qphone.base.util.QLog;

class HippyQQImageLoader$3
  implements Runnable
{
  HippyQQImageLoader$3(HippyQQImageLoader paramHippyQQImageLoader, HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, Throwable paramThrowable, String paramString, HippyDrawable paramHippyDrawable) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeImage url:");
      ((StringBuilder)localObject).append(this.val$imageInfo.url);
      ((StringBuilder)localObject).append(" useLocal onRequestSuccess");
      QLog.i("HippyImageAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.val$finalThrowable;
    if (localObject != null)
    {
      this.val$imageInfo.onRequestFail((Throwable)localObject, this.val$finalErrorMsg);
      return;
    }
    this.val$imageInfo.onRequestSuccess(this.val$hippyTarget);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.3
 * JD-Core Version:    0.7.0.1
 */