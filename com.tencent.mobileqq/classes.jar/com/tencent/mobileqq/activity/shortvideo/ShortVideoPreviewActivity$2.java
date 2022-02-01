package com.tencent.mobileqq.activity.shortvideo;

import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class ShortVideoPreviewActivity$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ShortVideoPreviewActivity$2(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onGlobalLayout()
  {
    Object localObject = this.a;
    ((ShortVideoPreviewActivity)localObject).mSurfaceViewWidth = ((ShortVideoPreviewActivity)localObject).mSurfaceView.getWidth();
    localObject = this.a;
    ((ShortVideoPreviewActivity)localObject).mSurfaceViewHeight = ((ShortVideoPreviewActivity)localObject).mSurfaceView.getHeight();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGlobalLayout,mSurfaceViewWidth:");
      ((StringBuilder)localObject).append(this.a.mSurfaceViewWidth);
      ((StringBuilder)localObject).append(",mSurfaceViewHeight:");
      ((StringBuilder)localObject).append(this.a.mSurfaceViewHeight);
      QLog.d("ShortVideoPreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.a.mSurfaceView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */