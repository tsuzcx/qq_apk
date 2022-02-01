package com.tencent.aelight.camera.aeeditor.module.edit;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.aeeditor.module.aifilter.ComicsFilterResult;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel;
import com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterInfoCache;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import java.util.HashMap;

class AEEditorImageEditFragment$19
  implements Runnable
{
  AEEditorImageEditFragment$19(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, int paramInt2, ComicsFilterResult paramComicsFilterResult, MetaMaterial paramMetaMaterial) {}
  
  public void run()
  {
    this.this$0.j.a(false);
    this.this$0.a(this.a);
    AEEditorImageEditFragment.d(this.this$0, this.a);
    this.this$0.g.setSelectedIndex(this.a, true);
    AEEditorImageEditFragment.u(this.this$0).a(this.b, this.c, this.a);
    AEEditorImageEditFragment.u(this.this$0).a(this.b, this.d.id);
    if (AEEditorImageEditFragment.f(this.this$0) != null) {
      AEEditorImageEditFragment.f(this.this$0).setOverlayImage(this.b, this.c.a());
    }
    AEBaseReportParam.a().n().e.put(Integer.valueOf(this.b), this.d.id);
    AEBaseReportParam.a().n().f.put(Integer.valueOf(this.b), Float.valueOf(-1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.19
 * JD-Core Version:    0.7.0.1
 */