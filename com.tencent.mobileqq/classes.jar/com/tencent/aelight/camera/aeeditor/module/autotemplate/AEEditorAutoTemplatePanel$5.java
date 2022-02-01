package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.aeeditor.manage.AEditorMaterialManager;
import java.util.ArrayList;

class AEEditorAutoTemplatePanel$5
  implements Runnable
{
  AEEditorAutoTemplatePanel$5(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  @RequiresApi(api=17)
  public void run()
  {
    Object localObject = (Activity)this.this$0.getContext();
    if ((!((Activity)localObject).isDestroyed()) && (!((Activity)localObject).isFinishing()))
    {
      if (AEEditorAutoTemplatePanel.f(this.this$0) != -1)
      {
        localObject = this.this$0;
        AEEditorAutoTemplatePanel.a((AEEditorAutoTemplatePanel)localObject, AEEditorAutoTemplatePanel.f((AEEditorAutoTemplatePanel)localObject) + AEditorMaterialManager.a().a.size());
      }
      AEEditorAutoTemplatePanel.b(this.this$0);
      this.this$0.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.5
 * JD-Core Version:    0.7.0.1
 */