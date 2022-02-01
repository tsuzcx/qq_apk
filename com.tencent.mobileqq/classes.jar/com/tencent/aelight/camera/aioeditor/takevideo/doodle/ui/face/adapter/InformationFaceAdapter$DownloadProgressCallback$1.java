package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.qphone.base.util.QLog;

class InformationFaceAdapter$DownloadProgressCallback$1
  implements Runnable
{
  InformationFaceAdapter$DownloadProgressCallback$1(InformationFaceAdapter.DownloadProgressCallback paramDownloadProgressCallback, int paramInt) {}
  
  public void run()
  {
    InformationFaceAdapter.DownloadProgressCallback.a(this.b).setVisibility(0);
    InformationFaceAdapter.DownloadProgressCallback.a(this.b).setProgress(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("progress:");
      localStringBuilder.append(this.a);
      QLog.d("InformationFaceAdapter", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.1
 * JD-Core Version:    0.7.0.1
 */