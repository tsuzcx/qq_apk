package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build.VERSION;

class EditPicSave$3
  implements Runnable
{
  EditPicSave$3(EditPicSave paramEditPicSave) {}
  
  public void run()
  {
    Activity localActivity;
    if (this.this$0.a == null) {
      localActivity = null;
    } else {
      localActivity = this.this$0.a.getActivity();
    }
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if ((Build.VERSION.SDK_INT > 16) && (localActivity.isDestroyed())) {
        return;
      }
      EditPicSave.a(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.3
 * JD-Core Version:    0.7.0.1
 */