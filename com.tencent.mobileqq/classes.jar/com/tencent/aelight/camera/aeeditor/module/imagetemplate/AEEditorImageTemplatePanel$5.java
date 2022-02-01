package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class AEEditorImageTemplatePanel$5
  implements Runnable
{
  AEEditorImageTemplatePanel$5(AEEditorImageTemplatePanel paramAEEditorImageTemplatePanel, MetaMaterial paramMetaMaterial, long paramLong, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(ImageTemplateMaterialExKt.a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial));
      ThreadManager.getUIHandler().post(new AEEditorImageTemplatePanel.5.1(this, localJSONObject));
      return;
    }
    catch (Exception localException)
    {
      AEQLog.a(AEEditorImageTemplatePanel.a, "Pic template apply error", localException);
      AEEditorImageTemplatePanel.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.5
 * JD-Core Version:    0.7.0.1
 */