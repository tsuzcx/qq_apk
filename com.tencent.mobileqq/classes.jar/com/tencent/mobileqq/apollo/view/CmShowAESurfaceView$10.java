package com.tencent.mobileqq.apollo.view;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AESticker;

class CmShowAESurfaceView$10
  implements Runnable
{
  CmShowAESurfaceView$10(CmShowAESurfaceView paramCmShowAESurfaceView, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    if ((CmShowAESurfaceView.a(this.this$0) != null) && (CmShowAESurfaceView.a(this.this$0).getmPTSticker() != null))
    {
      CmShowAESurfaceView.a(this.this$0).getmPTSticker().setTouchRotate(this.a);
      CmShowAESurfaceView.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.10
 * JD-Core Version:    0.7.0.1
 */