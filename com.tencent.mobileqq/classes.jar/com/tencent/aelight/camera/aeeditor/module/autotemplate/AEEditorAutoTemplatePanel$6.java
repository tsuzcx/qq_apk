package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class AEEditorAutoTemplatePanel$6
  implements Runnable
{
  AEEditorAutoTemplatePanel$6(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  @RequiresApi(api=17)
  public void run()
  {
    Activity localActivity = (Activity)this.this$0.getContext();
    if ((!localActivity.isDestroyed()) && (!localActivity.isFinishing()) && (AEEditorAutoTemplatePanel.a(this.this$0) != null))
    {
      AEEditorAutoTemplatePanel.a(this.this$0).a(true);
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(2064515202), 1).a();
      this.this$0.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.6
 * JD-Core Version:    0.7.0.1
 */