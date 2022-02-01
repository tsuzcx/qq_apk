package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.util.SparseArray;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qphone.base.util.QLog;
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
      AEQLog.b(AEEditorImageTemplatePanel.a, "Pic template apply start");
      AEEditorImageTemplatePanel.i(this.b.this$0);
      if ((QzoneConfig.isQQCircleImageTemplateApplyFilter()) && (AEEditorImageTemplatePanel.a(this.b.this$0, AEEditorImageTemplatePanel.c(this.b.this$0).getCurrentIndex()))) {
        AEEditorImageTemplatePanel.a(this.b.this$0, AEEditorImageTemplatePanel.c(this.b.this$0).getCurrentIndex(), this.a, this.b.a);
      }
      AEEditorImageTemplatePanel.b(this.b.this$0, AEEditorImageTemplatePanel.c(this.b.this$0).getCurrentIndex(), this.a, this.b.a);
      AEEditorImageTemplatePanel.c(this.b.this$0, AEEditorImageTemplatePanel.c(this.b.this$0).getCurrentIndex(), this.a, this.b.a);
      if (QLog.isColorLevel())
      {
        String str = AEEditorImageTemplatePanel.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Pic template apply step1 cost:");
        localStringBuilder.append(System.currentTimeMillis() - this.b.b);
        AEQLog.b(str, localStringBuilder.toString());
      }
      AEEditorImageTemplatePanel.c(this.b.this$0).updateAndRenderTemplate(AEEditorImageTemplatePanel.c(this.b.this$0).getCurrentIndex(), false, new AEEditorImageTemplatePanel.5.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      AEQLog.a(AEEditorImageTemplatePanel.a, "Pic template apply error", localException);
      AEEditorImageTemplatePanel.c(this.b.this$0).updateAndRenderTemplate(AEEditorImageTemplatePanel.c(this.b.this$0).getCurrentIndex());
      this.b.this$0.setSelectedIndex(this.b.c, true);
      this.b.this$0.b.put(AEEditorImageTemplatePanel.c(this.b.this$0).getCurrentIndex(), this.b.a.id);
      AEEditorImageTemplatePanel.a(this.b.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.5.1
 * JD-Core Version:    0.7.0.1
 */