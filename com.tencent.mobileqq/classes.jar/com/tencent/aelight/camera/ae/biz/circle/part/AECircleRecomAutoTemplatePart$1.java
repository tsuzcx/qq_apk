package com.tencent.aelight.camera.ae.biz.circle.part;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class AECircleRecomAutoTemplatePart$1
  implements View.OnClickListener
{
  AECircleRecomAutoTemplatePart$1(AECircleRecomAutoTemplatePart paramAECircleRecomAutoTemplatePart) {}
  
  public void onClick(View paramView)
  {
    paramView = AECircleRecomAutoTemplatePart.a(this.a).getText().toString();
    if (this.a.h().getString(2064187521).equals(paramView))
    {
      QCircleUtils.a().enterBySchemeAction(BaseApplication.getContext(), "openPrivacySetting", new HashMap());
      return;
    }
    AECircleRecomAutoTemplatePart.a(this.a).setText(this.a.h().getText(2064187521));
    AECircleRecomAutoTemplatePart.b(this.a);
    AECircleRecomAutoTemplatePart.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart.1
 * JD-Core Version:    0.7.0.1
 */