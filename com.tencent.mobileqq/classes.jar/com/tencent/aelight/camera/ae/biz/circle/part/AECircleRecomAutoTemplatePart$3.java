package com.tencent.aelight.camera.ae.biz.circle.part;

import android.os.Bundle;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.biz.circle.adapter.RecomAutoTemplateAdapter;
import com.tencent.aelight.camera.ae.biz.circle.adapter.RecomAutoTemplateAdapter.ApplyMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorLauncher;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import java.util.ArrayList;

class AECircleRecomAutoTemplatePart$3
  implements RecomAutoTemplateAdapter.ApplyMaterial
{
  AECircleRecomAutoTemplatePart$3(AECircleRecomAutoTemplatePart paramAECircleRecomAutoTemplatePart) {}
  
  public void a()
  {
    AEQLog.b("AECircleRecomAutoTemplatePart", "res download start");
    AECircleRecomAutoTemplatePart.d(this.a);
  }
  
  public void a(ArrayList<LocalMediaInfo> paramArrayList, MetaMaterial paramMetaMaterial, String paramString)
  {
    AEQLog.b("AECircleRecomAutoTemplatePart", "res onApply");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_qcircle_mid_page_template_info", paramMetaMaterial);
    localBundle.putSerializable("key_qcircle_mid_page_photo_info", paramArrayList);
    localBundle.putString("key_qcircle_mid_page_clustering_id", paramString);
    AEReportUtils.a("", 3, "1", paramString, RecomAutoTemplateAdapter.a(paramArrayList), paramMetaMaterial.id);
    AEEditorLauncher.a(this.a.g(), 4, localBundle, 0);
    QCircleUtils.d().deleteOneRecomAutoTemplateData(paramString);
  }
  
  public void b()
  {
    AEQLog.b("AECircleRecomAutoTemplatePart", "res download success");
    AECircleRecomAutoTemplatePart.e(this.a);
  }
  
  public void c()
  {
    AEQLog.d("AECircleRecomAutoTemplatePart", "res download fail");
    AECircleRecomAutoTemplatePart.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart.3
 * JD-Core Version:    0.7.0.1
 */