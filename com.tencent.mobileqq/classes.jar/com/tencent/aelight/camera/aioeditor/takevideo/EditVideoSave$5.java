package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

class EditVideoSave$5
  implements ProgressPieDrawable.OnProgressListener
{
  EditVideoSave$5(EditVideoSave paramEditVideoSave) {}
  
  public void onProgressChanged(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onProgressCompleted] hide ProgressPieDrawable ,ppd = ");
      localStringBuilder.append(paramProgressPieDrawable);
      QLog.i("EditVideoSave", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */