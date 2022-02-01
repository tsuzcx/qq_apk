package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EditTextPanel$2$1
  implements Runnable
{
  EditTextPanel$2$1(EditTextPanel.2 param2, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.c.a.b != null)
    {
      if (this.c.a.b.e == null) {
        return;
      }
      int j = this.c.a.b.e.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.c.a.b.e.getChildAt(i);
        localObject = (EditTextEffectView.EditTextHolder)this.c.a.b.getChildViewHolder((View)localObject);
        if ((((EditTextEffectView.EditTextHolder)localObject).b.isContainsResUrl(this.a)) && (((EditTextEffectView.EditTextHolder)localObject).b.text_id == this.b)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.1.1(this, (EditTextEffectView.EditTextHolder)localObject));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.1
 * JD-Core Version:    0.7.0.1
 */