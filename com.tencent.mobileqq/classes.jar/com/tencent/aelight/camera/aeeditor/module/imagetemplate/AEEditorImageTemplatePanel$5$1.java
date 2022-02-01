package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.util.SparseArray;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.session.TAVCutImageSession;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

class AEEditorImageTemplatePanel$5$1
  implements Runnable
{
  AEEditorImageTemplatePanel$5$1(AEEditorImageTemplatePanel.5 param5, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      AEQLog.b(AEEditorImageTemplatePanel.jdField_a_of_type_JavaLangString, "Pic template apply start");
      AEEditorImageTemplatePanel.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0);
      if ((QzoneConfig.isQQCircleImageTemplateApplyFilter()) && (AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0, AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex()))) {
        AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0, AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex(), this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      }
      AEEditorImageTemplatePanel.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0, AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex(), this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      AEEditorImageTemplatePanel.c(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0, AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex(), this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      AEEditorImageTemplatePanel.d(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0, AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex(), this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      AEEditorImageTemplatePanel.e(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0, AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex(), this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      if (QLog.isColorLevel())
      {
        String str = AEEditorImageTemplatePanel.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Pic template apply step1 cost:");
        localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.jdField_a_of_type_Long);
        AEQLog.b(str, localStringBuilder.toString());
      }
      AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).updateAndRenderTemplate(AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex(), false, new AEEditorImageTemplatePanel.5.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      AEQLog.a(AEEditorImageTemplatePanel.jdField_a_of_type_JavaLangString, "Pic template apply error", localException);
      AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).updateAndRenderTemplate(AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex());
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0.setSelectedIndex(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.jdField_a_of_type_Int, true);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0.jdField_a_of_type_AndroidUtilSparseArray.put(AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0).getCurrentIndex(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
      AEEditorImageTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel$5.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.5.1
 * JD-Core Version:    0.7.0.1
 */