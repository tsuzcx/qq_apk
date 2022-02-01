package com.tencent.aelight.camera.aeeditor.module.frame;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;

class AEEditorFramePanel$1
  implements View.OnClickListener
{
  AEEditorFramePanel$1(AEEditorFramePanel paramAEEditorFramePanel) {}
  
  public void onClick(View paramView)
  {
    if (AEEditorFramePanel.a(this.a) != null)
    {
      AEEditorFramePanel.a(this.a).removeFrame(AEEditorFramePanel.a(this.a).getCurrentIndex());
      AEEditorFramePanel.b(this.a).put(AEEditorFramePanel.a(this.a).getCurrentIndex(), null);
      this.a.setSelectedIndex(-1);
    }
    if (AEBaseReportParam.a().n() != null) {
      AEBaseReportParam.a().n().c.put(AEEditorFramePanel.a(this.a).getCurrentIndex(), "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.frame.AEEditorFramePanel.1
 * JD-Core Version:    0.7.0.1
 */