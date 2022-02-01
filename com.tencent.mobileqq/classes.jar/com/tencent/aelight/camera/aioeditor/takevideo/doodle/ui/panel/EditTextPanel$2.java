package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.IDynamicTextResDownloadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EditTextPanel$2
  implements DynamicTextConfigManager.IDynamicTextResDownloadCallback
{
  EditTextPanel$2(EditTextPanel paramEditTextPanel) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.a.post(new EditTextPanel.2.1(this, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.a.b != null)
    {
      if (this.a.b.e == null) {
        return;
      }
      int j = this.a.b.e.getChildCount();
      DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)QIMManager.a(7);
      int i = 0;
      while (i < j)
      {
        Object localObject = this.a.b.e.getChildAt(i);
        localObject = (EditTextEffectView.EditTextHolder)this.a.b.getChildViewHolder((View)localObject);
        if (((EditTextEffectView.EditTextHolder)localObject).b.isContainsResUrl(paramString)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.2(this, paramBoolean, (EditTextEffectView.EditTextHolder)localObject, localDynamicTextConfigManager));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2
 * JD-Core Version:    0.7.0.1
 */