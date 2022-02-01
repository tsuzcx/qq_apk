package com.tencent.mobileqq.apollo.view;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.SpaceFilter;

class CmShowAESurfaceView$6
  implements Runnable
{
  CmShowAESurfaceView$6(CmShowAESurfaceView paramCmShowAESurfaceView) {}
  
  public void run()
  {
    if (CmShowAESurfaceView.d(this.this$0) != null) {
      CmShowAESurfaceView.d(this.this$0).destroy();
    }
    CmShowAESurfaceView.e(this.this$0).clearGLSL();
    CmShowAESurfaceView.f(this.this$0).clearGLSL();
    CmShowAESurfaceView.g(this.this$0).clear();
    CmShowAESurfaceView.h(this.this$0).clear();
    QLog.i("[cmshow]CmShowAESurfaceView", 1, "Clear in GLThread.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.6
 * JD-Core Version:    0.7.0.1
 */