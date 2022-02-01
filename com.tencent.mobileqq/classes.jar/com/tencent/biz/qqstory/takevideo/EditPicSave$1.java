package com.tencent.biz.qqstory.takevideo;

import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;

class EditPicSave$1
  implements ThreadExcutor.IThreadListener
{
  EditPicSave$1(EditPicSave paramEditPicSave) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    int i = 1;
    this.a.a.a().postDelayed(new EditPicSave.1.1(this), 500L);
    if (CameraControl.a().a == 1) {}
    for (;;)
    {
      CaptureReportUtil.e(i);
      return;
      i = 2;
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicSave.1
 * JD-Core Version:    0.7.0.1
 */