package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class ScanGLRenderBaseFragment$1
  implements Runnable
{
  ScanGLRenderBaseFragment$1(ScanGLRenderBaseFragment paramScanGLRenderBaseFragment) {}
  
  public void run()
  {
    QBaseActivity localQBaseActivity = this.this$0.getQBaseActivity();
    if (localQBaseActivity != null) {
      QQToast.makeText(localQBaseActivity, HardCodeUtil.a(2131910986), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */