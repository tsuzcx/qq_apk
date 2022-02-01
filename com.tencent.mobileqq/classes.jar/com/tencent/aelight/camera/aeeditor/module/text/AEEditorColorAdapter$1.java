package com.tencent.aelight.camera.aeeditor.module.text;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import java.util.List;

class AEEditorColorAdapter$1
  implements View.OnClickListener
{
  AEEditorColorAdapter$1(AEEditorColorAdapter paramAEEditorColorAdapter, int paramInt, AEEditorColorAdapter.VH paramVH) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == AEEditorColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter)) {
      return;
    }
    AEEditorColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter).a(AEEditorColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter), ((Integer)AEEditorColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter).get(this.jdField_a_of_type_Int)).intValue(), this.jdField_a_of_type_Int, AEEditorColorAdapter.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter));
    AEEditorColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter, this.jdField_a_of_type_Int);
    AEEditorColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter$VH, this.jdField_a_of_type_Int);
    if ("adapter_extract".equals(AEEditorColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter)))
    {
      AEBaseReportParam.a().a().jdField_h_of_type_JavaLangString = "ai_color";
      AEBaseReportParam.a().a().jdField_h_of_type_Int = -1;
    }
    else if ("adapter_fix".equals(AEEditorColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter)))
    {
      AEBaseReportParam.a().a().jdField_h_of_type_JavaLangString = "common_color";
      AEBaseReportParam.a().a().jdField_h_of_type_Int = (this.jdField_a_of_type_Int + 1);
    }
    AEBaseReportParam.a().a().i = AEEditorColorAdapter.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorAdapter);
    AEBaseDataReporter.a().z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorColorAdapter.1
 * JD-Core Version:    0.7.0.1
 */