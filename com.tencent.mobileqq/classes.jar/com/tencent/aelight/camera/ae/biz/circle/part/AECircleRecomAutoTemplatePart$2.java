package com.tencent.aelight.camera.ae.biz.circle.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;

class AECircleRecomAutoTemplatePart$2
  implements View.OnClickListener
{
  AECircleRecomAutoTemplatePart$2(AECircleRecomAutoTemplatePart paramAECircleRecomAutoTemplatePart) {}
  
  public void onClick(View paramView)
  {
    QCircleUtils.d().deleteAllRecomAutoTemplateData();
    AECircleRecomAutoTemplatePart.a(this.a, true);
    this.a.a(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart.2
 * JD-Core Version:    0.7.0.1
 */