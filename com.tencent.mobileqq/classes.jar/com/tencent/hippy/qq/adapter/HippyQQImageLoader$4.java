package com.tencent.hippy.qq.adapter;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class HippyQQImageLoader$4
  implements URLDrawable.URLDrawableListener
{
  HippyQQImageLoader$4(HippyQQImageLoader paramHippyQQImageLoader, HippyQQImageLoader.HippyImageInfo paramHippyImageInfo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchImage url:");
      localStringBuilder.append(this.val$imageInfo.url);
      localStringBuilder.append(" onLoadCanceled");
      QLog.i("HippyImageAdapter", 2, localStringBuilder.toString());
    }
    HippyQQImageLoader.access$400(this.this$0).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchImage url:");
      localStringBuilder.append(this.val$imageInfo.url);
      localStringBuilder.append(" onLoadFialed + linsenter:");
      localStringBuilder.append(this);
      QLog.e("HippyImageAdapter", 2, localStringBuilder.toString());
    }
    HippyQQImageLoader.access$300(this.this$0, paramURLDrawable, paramThrowable, this.val$imageInfo);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("fetchImage url:");
      paramURLDrawable.append(this.val$imageInfo.url);
      paramURLDrawable.append(" onLoadProgressed:");
      paramURLDrawable.append(paramInt);
      QLog.i("HippyImageAdapter", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchImage url:");
      localStringBuilder.append(this.val$imageInfo.url);
      localStringBuilder.append(" onLoadSuccessed");
      QLog.i("HippyImageAdapter", 2, localStringBuilder.toString());
    }
    HippyQQImageLoader.access$200(this.this$0, this.val$imageInfo, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.4
 * JD-Core Version:    0.7.0.1
 */