package com.tencent.mobileqq.apollo.view;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AESticker;

class CmShowAESurfaceView$9
  implements Runnable
{
  CmShowAESurfaceView$9(CmShowAESurfaceView paramCmShowAESurfaceView, float paramFloat) {}
  
  public void run()
  {
    if ((CmShowAESurfaceView.a(this.this$0) != null) && (CmShowAESurfaceView.a(this.this$0).getmPTSticker() != null)) {
      CmShowAESurfaceView.a(this.this$0).getmPTSticker().setTouchScale(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.9
 * JD-Core Version:    0.7.0.1
 */