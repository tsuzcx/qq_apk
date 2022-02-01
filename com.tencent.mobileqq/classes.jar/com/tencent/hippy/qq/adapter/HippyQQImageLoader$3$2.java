package com.tencent.hippy.qq.adapter;

import android.os.Handler;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class HippyQQImageLoader$3$2
  implements Runnable
{
  HippyQQImageLoader$3$2(HippyQQImageLoader.3 param3, File paramFile) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + this.this$1.val$realUrl + " onLoadSuccessed setData");
    }
    this.this$1.val$hippyTarget.setData(this.val$file, this.this$1.val$isGif);
    HippyQQImageLoader.access$000(this.this$1.this$0).post(new HippyQQImageLoader.3.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.3.2
 * JD-Core Version:    0.7.0.1
 */