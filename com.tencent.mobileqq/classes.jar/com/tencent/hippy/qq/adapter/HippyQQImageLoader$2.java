package com.tencent.hippy.qq.adapter;

import android.os.Handler;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class HippyQQImageLoader$2
  implements Runnable
{
  HippyQQImageLoader$2(HippyQQImageLoader paramHippyQQImageLoader, HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, File paramFile) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "onImageDownloadSuccessed url:" + this.val$imageInfo.url + " useLocal setData");
    }
    HippyDrawable localHippyDrawable = new HippyDrawable();
    localHippyDrawable.setData(this.val$localFile, this.val$imageInfo.isGif);
    HippyQQImageLoader.access$100(this.this$0).post(new HippyQQImageLoader.2.1(this, localHippyDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.2
 * JD-Core Version:    0.7.0.1
 */