package com.tencent.hippy.qq.adapter;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class HippyQQImageLoader$3
  implements URLDrawable.URLDrawableListener
{
  HippyQQImageLoader$3(HippyQQImageLoader paramHippyQQImageLoader, HippyQQImageLoader.HippyImageInfo paramHippyImageInfo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "fetchImage url:" + this.val$imageInfo.url + " onLoadCanceled");
    }
    HippyQQImageLoader.access$400(this.this$0).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("HippyImageAdapter", 2, "fetchImage url:" + this.val$imageInfo.url + " onLoadFialed + linsenter:" + this);
    }
    HippyQQImageLoader.access$300(this.this$0, paramURLDrawable, paramThrowable, this.val$imageInfo);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "fetchImage url:" + this.val$imageInfo.url + " onLoadProgressed:" + paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "fetchImage url:" + this.val$imageInfo.url + " onLoadSuccessed");
    }
    HippyQQImageLoader.access$200(this.this$0, this.val$imageInfo, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.3
 * JD-Core Version:    0.7.0.1
 */