package com.tencent.aelight.camera.ae.biz.circle.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.qphone.base.util.QLog;

class AECircleSelectPanelPart$4
  implements View.OnClickListener
{
  AECircleSelectPanelPart$4(AECircleSelectPanelPart paramAECircleSelectPanelPart) {}
  
  public void onClick(View paramView)
  {
    if (AECircleSelectPanelPart.a(this.a) != null)
    {
      AECircleSelectPanelPart.b(this.a).e();
      return;
    }
    QLog.d("AECircleSelectPanelPart", 1, "initMove, mPhotoListLogic == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart.4
 * JD-Core Version:    0.7.0.1
 */