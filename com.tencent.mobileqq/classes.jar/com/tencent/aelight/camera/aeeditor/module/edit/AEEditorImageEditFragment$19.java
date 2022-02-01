package com.tencent.aelight.camera.aeeditor.module.edit;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.aeeditor.module.aifilter.ComicsFilterResult;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel;
import com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterInfoCache;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.tavcut.session.TAVCutImageSession;
import java.util.HashMap;

class AEEditorImageEditFragment$19
  implements Runnable
{
  AEEditorImageEditFragment$19(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, int paramInt2, ComicsFilterResult paramComicsFilterResult, MetaMaterial paramMetaMaterial) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.a(false);
    this.this$0.a(this.jdField_a_of_type_Int);
    AEEditorImageEditFragment.d(this.this$0, this.jdField_a_of_type_Int);
    this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSelectedIndex(this.jdField_a_of_type_Int, true);
    AEEditorImageEditFragment.a(this.this$0).a(this.b, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterComicsFilterResult, this.jdField_a_of_type_Int);
    AEEditorImageEditFragment.a(this.this$0).a(this.b, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
    if (AEEditorImageEditFragment.a(this.this$0) != null) {
      AEEditorImageEditFragment.a(this.this$0).setOverlayImage(this.b, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterComicsFilterResult.a());
    }
    AEBaseReportParam.a().a().a.put(Integer.valueOf(this.b), this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
    AEBaseReportParam.a().a().b.put(Integer.valueOf(this.b), Float.valueOf(-1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.19
 * JD-Core Version:    0.7.0.1
 */