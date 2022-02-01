package com.tencent.aelight.camera.education.api.impl;

import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;

public class AnswerSearchEditRawImage
  extends EditPicRawImage
{
  public AnswerSearchEditRawImage(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = super.handleMessage(paramMessage);
    if (paramMessage.what == 999)
    {
      this.t.E();
      ((AnswerSearchEditPictureManager)this.t).d();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.education.api.impl.AnswerSearchEditRawImage
 * JD-Core Version:    0.7.0.1
 */