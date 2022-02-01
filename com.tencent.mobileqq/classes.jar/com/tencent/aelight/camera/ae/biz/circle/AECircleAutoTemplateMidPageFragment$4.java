package com.tencent.aelight.camera.ae.biz.circle;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.AEEditorModuleManager;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;

class AECircleAutoTemplateMidPageFragment$4
  implements View.OnClickListener
{
  AECircleAutoTemplateMidPageFragment$4(AECircleAutoTemplateMidPageFragment paramAECircleAutoTemplateMidPageFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    AECircleAutoTemplateMidPageFragment localAECircleAutoTemplateMidPageFragment = this.a;
    AECircleAutoTemplateMidPageFragment.a(localAECircleAutoTemplateMidPageFragment, paramView, AECircleAutoTemplateMidPageFragment.c(localAECircleAutoTemplateMidPageFragment));
    paramView.putBoolean("ae_auto_set_editor_material", true);
    paramView.putSerializable("AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL", AECircleAutoTemplateMidPageFragment.d(this.a));
    AECircleAutoTemplateMidPageFragment.a(this.a, 3);
    this.a.b().b("AutoTemplateMidPage", paramView);
    if ((AECircleAutoTemplateMidPageFragment.c(this.a) != null) && (AECircleAutoTemplateMidPageFragment.d(this.a) != null))
    {
      paramView = new StringBuilder();
      paramView.append("nextStep Button click : ");
      paramView.append(AECircleAutoTemplateMidPageFragment.c(this.a).size());
      paramView.append(", Template: ");
      paramView.append(AECircleAutoTemplateMidPageFragment.d(this.a).id);
      AEQLog.b("AECircleAutoTemplateMidPageFragment", paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAutoTemplateMidPageFragment.4
 * JD-Core Version:    0.7.0.1
 */