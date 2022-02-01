package com.tencent.aelight.camera.aeeditor.module.export;

import com.tencent.aelight.camera.aeeditor.listener.AETavSessionStatusListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.ExportListener;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavkit.report.TAVReportUtils;

class AEEditorGenerateRunnable$1
  implements MovieExporter.ExportListener
{
  private long jdField_a_of_type_Long;
  private long b;
  
  AEEditorGenerateRunnable$1(AEEditorGenerateRunnable paramAEEditorGenerateRunnable, TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void onExportCancel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportCancel:");
    localStringBuilder.append(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable));
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable).c(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable));
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportCompleted(String paramString)
  {
    this.b = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("perf: video export cost = ");
    localStringBuilder.append(this.b - this.jdField_a_of_type_Long);
    localStringBuilder.append("ms");
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportCompleted mMissionID: ");
    localStringBuilder.append(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable));
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportCompleted exportPath: ");
    localStringBuilder.append(paramString);
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable), paramString);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportError(AssetExportSession paramAssetExportSession)
  {
    int i;
    if (paramAssetExportSession != null)
    {
      i = paramAssetExportSession.getErrCode();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onExportError] errorcode ");
      localStringBuilder.append(i);
      AEQLog.d("AEEditorGenerateRunnable", localStringBuilder.toString());
      paramAssetExportSession = TAVReportUtils.a("unknown", paramAssetExportSession);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onExportError] msg ");
      localStringBuilder.append(paramAssetExportSession);
      AEQLog.d("AEEditorGenerateRunnable", localStringBuilder.toString());
    }
    else
    {
      i = -1;
      paramAssetExportSession = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportError:");
    localStringBuilder.append(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable));
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable), i, paramAssetExportSession);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportStart()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportStart :");
    localStringBuilder.append(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable));
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable).b(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable));
    }
  }
  
  public void onExporting(float paramFloat)
  {
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable), paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.export.AEEditorGenerateRunnable.1
 * JD-Core Version:    0.7.0.1
 */