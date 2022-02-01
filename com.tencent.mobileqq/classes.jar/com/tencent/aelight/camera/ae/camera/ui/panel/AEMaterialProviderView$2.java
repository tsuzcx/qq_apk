package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.widget.QQViewPager;

class AEMaterialProviderView$2
  implements Runnable
{
  AEMaterialProviderView$2(AEMaterialProviderView paramAEMaterialProviderView, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select category: ");
    localStringBuilder.append(this.a);
    AEQLog.b("AEMaterialProviderView", localStringBuilder.toString());
    AEMaterialProviderView.b(this.this$0).setCurrentItem(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialProviderView.2
 * JD-Core Version:    0.7.0.1
 */