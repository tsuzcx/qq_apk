package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.app.Activity;
import androidx.annotation.RequiresApi;

class AEEditorAutoTemplatePanel$5
  implements Runnable
{
  AEEditorAutoTemplatePanel$5(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  @RequiresApi(api=17)
  public void run()
  {
    Activity localActivity = (Activity)this.this$0.getContext();
    if ((!localActivity.isDestroyed()) && (!localActivity.isFinishing()))
    {
      AEEditorAutoTemplatePanel.a(this.this$0);
      this.this$0.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.5
 * JD-Core Version:    0.7.0.1
 */