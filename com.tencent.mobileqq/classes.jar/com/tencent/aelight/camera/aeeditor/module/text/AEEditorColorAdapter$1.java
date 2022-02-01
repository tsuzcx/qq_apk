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
    if (this.a == AEEditorColorAdapter.a(this.c)) {
      return;
    }
    AEEditorColorAdapter.e(this.c).a(AEEditorColorAdapter.b(this.c), ((Integer)AEEditorColorAdapter.c(this.c).get(this.a)).intValue(), this.a, AEEditorColorAdapter.d(this.c));
    AEEditorColorAdapter.a(this.c, this.a);
    AEEditorColorAdapter.a(this.c, this.b, this.a);
    if ("adapter_extract".equals(AEEditorColorAdapter.b(this.c)))
    {
      AEBaseReportParam.a().n().B = "ai_color";
      AEBaseReportParam.a().n().D = -1;
    }
    else if ("adapter_fix".equals(AEEditorColorAdapter.b(this.c)))
    {
      AEBaseReportParam.a().n().B = "common_color";
      AEBaseReportParam.a().n().D = (this.a + 1);
    }
    AEBaseReportParam.a().n().C = AEEditorColorAdapter.d(this.c);
    AEBaseDataReporter.a().A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorColorAdapter.1
 * JD-Core Version:    0.7.0.1
 */