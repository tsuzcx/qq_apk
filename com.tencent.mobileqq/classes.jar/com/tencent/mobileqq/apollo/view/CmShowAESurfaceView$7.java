package com.tencent.mobileqq.apollo.view;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.SpaceFilter;

class CmShowAESurfaceView$7
  implements Runnable
{
  CmShowAESurfaceView$7(CmShowAESurfaceView paramCmShowAESurfaceView) {}
  
  public void run()
  {
    if (CmShowAESurfaceView.a(this.this$0) != null) {
      CmShowAESurfaceView.a(this.this$0).destroy();
    }
    CmShowAESurfaceView.a(this.this$0).clearGLSL();
    CmShowAESurfaceView.a(this.this$0).clearGLSL();
    CmShowAESurfaceView.a(this.this$0).clear();
    CmShowAESurfaceView.b(this.this$0).clear();
    QLog.i("CmShowAESurfaceView", 1, "Clear in GLThread.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.7
 * JD-Core Version:    0.7.0.1
 */