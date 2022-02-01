package com.tencent.mobileqq.apollo.view;

import android.animation.ValueAnimator;
import com.tencent.qphone.base.util.QLog;

class CmShowAESurfaceView$2
  implements Runnable
{
  CmShowAESurfaceView$2(CmShowAESurfaceView paramCmShowAESurfaceView) {}
  
  public void run()
  {
    QLog.i("CmShowAESurfaceView", 1, "mAnimatorCancelRunnable.");
    CmShowAESurfaceView.a(this.this$0).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.2
 * JD-Core Version:    0.7.0.1
 */