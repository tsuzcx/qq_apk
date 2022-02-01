package com.tencent.aelight.camera.aeeditor.module.export;

import com.tencent.aelight.camera.aeeditor.listener.AETavSessionStatusListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.exporter.MovieExporter.ExportListener;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavkit.report.TAVReportUtils;

class AEEditorGenerateRunnable$1
  implements MovieExporter.ExportListener
{
  private long c;
  private long d;
  
  AEEditorGenerateRunnable$1(AEEditorGenerateRunnable paramAEEditorGenerateRunnable, TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void onExportCancel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportCancel:");
    localStringBuilder.append(AEEditorGenerateRunnable.a(this.b));
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    if (AEEditorGenerateRunnable.b(this.b) != null) {
      AEEditorGenerateRunnable.b(this.b).e(AEEditorGenerateRunnable.a(this.b));
    }
    this.a.release();
  }
  
  public void onExportCompleted(String paramString)
  {
    this.d = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("perf: video export cost = ");
    localStringBuilder.append(this.d - this.c);
    localStringBuilder.append("ms");
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportCompleted mMissionID: ");
    localStringBuilder.append(AEEditorGenerateRunnable.a(this.b));
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportCompleted exportPath: ");
    localStringBuilder.append(paramString);
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    if (AEEditorGenerateRunnable.b(this.b) != null) {
      AEEditorGenerateRunnable.b(this.b).a(AEEditorGenerateRunnable.a(this.b), paramString);
    }
    this.a.release();
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
      paramAssetExportSession = TAVReportUtils.buildExportErrorMsg("unknown", paramAssetExportSession);
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
    localStringBuilder.append(AEEditorGenerateRunnable.a(this.b));
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    if (AEEditorGenerateRunnable.b(this.b) != null) {
      AEEditorGenerateRunnable.b(this.b).a(AEEditorGenerateRunnable.a(this.b), i, paramAssetExportSession);
    }
    this.a.release();
  }
  
  public void onExportStart()
  {
    this.c = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportStart :");
    localStringBuilder.append(AEEditorGenerateRunnable.a(this.b));
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    if (AEEditorGenerateRunnable.b(this.b) != null) {
      AEEditorGenerateRunnable.b(this.b).d(AEEditorGenerateRunnable.a(this.b));
    }
  }
  
  public void onExporting(float paramFloat)
  {
    if (AEEditorGenerateRunnable.b(this.b) != null) {
      AEEditorGenerateRunnable.b(this.b).a(AEEditorGenerateRunnable.a(this.b), paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.export.AEEditorGenerateRunnable.1
 * JD-Core Version:    0.7.0.1
 */