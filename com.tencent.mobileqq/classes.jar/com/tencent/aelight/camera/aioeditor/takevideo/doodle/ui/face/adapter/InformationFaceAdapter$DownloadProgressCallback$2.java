package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  InformationFaceAdapter$DownloadProgressCallback$2(InformationFaceAdapter.DownloadProgressCallback paramDownloadProgressCallback, boolean paramBoolean, InformationFacePackage.Item paramItem) {}
  
  public void run()
  {
    InformationFaceAdapter.DownloadProgressCallback.a(this.c).setVisibility(8);
    if (this.a) {
      InformationFaceAdapter.a(this.c.a, InformationFaceAdapter.DownloadProgressCallback.b(this.c), this.b);
    } else {
      QQToast.makeText(InformationFaceAdapter.DownloadProgressCallback.a(this.c).getContext(), 0, HardCodeUtil.a(2131903729), 0).show();
    }
    this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */