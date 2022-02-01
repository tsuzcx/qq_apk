package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.editor.params.EditVideoParams;

class EditPicSave$1
  implements ThreadExcutor.IThreadListener
{
  EditPicSave$1(EditPicSave paramEditPicSave) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (this.a.u != null)
    {
      if (this.a.u.getActivity() == null) {
        return;
      }
      this.a.u.getRootView().postDelayed(new EditPicSave.1.1(this), 500L);
    }
  }
  
  public void onPreRun()
  {
    if (this.a.t.I.h() == 14) {
      EditPicSave.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.1
 * JD-Core Version:    0.7.0.1
 */