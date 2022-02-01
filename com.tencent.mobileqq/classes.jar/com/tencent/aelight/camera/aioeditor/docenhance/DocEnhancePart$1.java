package com.tencent.aelight.camera.aioeditor.docenhance;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;

class DocEnhancePart$1
  implements View.OnClickListener
{
  DocEnhancePart$1(DocEnhancePart paramDocEnhancePart) {}
  
  public void onClick(View paramView)
  {
    this.a.a.r();
    if (this.a.a.f() > 0) {
      DocEnhancePart.a(this.a);
    } else {
      DocEnhancePart.b(this.a);
    }
    AEBaseDataReporter.a().aZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart.1
 * JD-Core Version:    0.7.0.1
 */