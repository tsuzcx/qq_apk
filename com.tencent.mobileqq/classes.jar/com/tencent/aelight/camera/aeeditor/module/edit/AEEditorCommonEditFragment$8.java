package com.tencent.aelight.camera.aeeditor.module.edit;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.aeeditor.module.MaterialViewModel;
import java.util.HashMap;

class AEEditorCommonEditFragment$8
  implements Observer<Boolean>
{
  AEEditorCommonEditFragment$8(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if (!this.a.y)
    {
      int i = this.a.u.d();
      if (i != -1)
      {
        paramBoolean = (View)AEEditorCommonEditFragment.a(this.a).get(Integer.valueOf(i));
        if (paramBoolean != null)
        {
          paramBoolean.setVisibility(0);
          this.a.z();
          if (paramBoolean.getVisibility() == 0) {
            AEEditorCommonEditFragment.a(this.a, i, 1);
          }
        }
        paramBoolean = this.a;
        paramBoolean.s = paramBoolean.u.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.8
 * JD-Core Version:    0.7.0.1
 */