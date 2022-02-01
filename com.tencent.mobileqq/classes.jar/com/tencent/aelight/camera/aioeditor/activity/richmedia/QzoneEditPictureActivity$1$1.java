package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Handler;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class QzoneEditPictureActivity$1$1
  implements VideoFilterTools.OnResourceDownloadListener
{
  QzoneEditPictureActivity$1$1(QzoneEditPictureActivity.1 param1) {}
  
  public void h(boolean paramBoolean)
  {
    if (QzoneEditPictureActivity.a(this.a.this$0).N != null) {
      QzoneHandlerThreadFactory.getMainHandler().post(new QzoneEditPictureActivity.1.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity.1.1
 * JD-Core Version:    0.7.0.1
 */