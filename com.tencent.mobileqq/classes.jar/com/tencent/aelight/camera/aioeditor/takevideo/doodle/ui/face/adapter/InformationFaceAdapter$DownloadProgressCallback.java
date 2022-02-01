package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.IInformationPasterResDownloaderCallback;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.qphone.base.util.QLog;

class InformationFaceAdapter$DownloadProgressCallback
  implements QIMInformationPasterManager.IInformationPasterResDownloaderCallback
{
  private QIMCommonLoadingView b;
  private Boolean c;
  
  InformationFaceAdapter$DownloadProgressCallback(InformationFaceAdapter paramInformationFaceAdapter, QIMCommonLoadingView paramQIMCommonLoadingView, ImageView paramImageView)
  {
    this.b = paramQIMCommonLoadingView;
    this.c = ((Boolean)paramImageView.getTag(2131446799));
  }
  
  public void a()
  {
    this.b = null;
    this.c = null;
  }
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    paramInt = (int)paramFloat;
    this.b.post(new InformationFaceAdapter.DownloadProgressCallback.1(this, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString, InformationFacePackage.Item paramItem)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isSuccess:");
      paramString.append(paramBoolean);
      QLog.d("InformationFaceAdapter", 2, paramString.toString());
    }
    this.b.post(new InformationFaceAdapter.DownloadProgressCallback.2(this, paramBoolean, paramItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback
 * JD-Core Version:    0.7.0.1
 */