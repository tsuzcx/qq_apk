package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.open.base.ToastUtil;

class EditTextPanel$2$2
  implements Runnable
{
  EditTextPanel$2$2(EditTextPanel.2 param2, boolean paramBoolean, EditTextEffectView.EditTextHolder paramEditTextHolder, DynamicTextConfigManager paramDynamicTextConfigManager) {}
  
  public void run()
  {
    boolean bool = this.a;
    if (!bool)
    {
      this.b.a(bool);
      ToastUtil.a().a(2131896273);
      return;
    }
    if (this.c.a(this.b.b))
    {
      this.b.a(this.a);
      if (this.b.j == this.d.a.g) {
        this.d.a.b(-1, this.d.a.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.2
 * JD-Core Version:    0.7.0.1
 */