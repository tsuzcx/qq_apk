package com.tencent.mobileqq.apollo.view;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.filter.LightNode;

class CmShowAESurfaceView$9
  implements Runnable
{
  CmShowAESurfaceView$9(CmShowAESurfaceView paramCmShowAESurfaceView, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    if ((CmShowAESurfaceView.d(this.this$0) != null) && (CmShowAESurfaceView.d(this.this$0).getLightNode() != null) && (CmShowAESurfaceView.d(this.this$0).getLightNode().getAsset() != null))
    {
      CmShowAESurfaceView.d(this.this$0).cmShowUpdateTouchRotate(this.a);
      CmShowAESurfaceView.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.9
 * JD-Core Version:    0.7.0.1
 */