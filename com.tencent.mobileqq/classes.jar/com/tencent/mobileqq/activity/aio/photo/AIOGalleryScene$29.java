package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

class AIOGalleryScene$29
  implements ProgressPieDrawable.OnProgressListener
{
  AIOGalleryScene$29(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onProgressChanged(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onProgressCompleted] hide ProgressPieDrawable ,ppd = ");
      localStringBuilder.append(paramProgressPieDrawable);
      QLog.i("AIOGalleryScene", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.29
 * JD-Core Version:    0.7.0.1
 */