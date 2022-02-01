package com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

class EditPicSave$5
  implements ProgressPieDrawable.OnProgressListener
{
  EditPicSave$5(EditPicSave paramEditPicSave) {}
  
  public void onProgressChanged(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditPicSave", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramProgressPieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicSave.5
 * JD-Core Version:    0.7.0.1
 */