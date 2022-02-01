package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class EditVideoPartManager$1
  implements ActionSheet.OnButtonClickListener
{
  EditVideoPartManager$1(EditVideoPartManager paramEditVideoPartManager, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      this.b.h();
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.1
 * JD-Core Version:    0.7.0.1
 */