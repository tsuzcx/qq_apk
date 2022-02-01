package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.qroute.QRoute;

class QzoneEditPictureActivity$1
  implements Runnable
{
  QzoneEditPictureActivity$1(QzoneEditPictureActivity paramQzoneEditPictureActivity) {}
  
  public void run()
  {
    ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).loadEffectSo();
    VideoFilterTools.a().a(this.this$0.getContext(), new QzoneEditPictureActivity.1.1(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity.1
 * JD-Core Version:    0.7.0.1
 */