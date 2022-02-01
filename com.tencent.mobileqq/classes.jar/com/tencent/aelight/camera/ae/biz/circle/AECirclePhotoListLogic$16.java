package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tav.core.AssetExportSession;

class AECirclePhotoListLogic$16
  implements MovieExporter.VideoCompressListener
{
  AECirclePhotoListLogic$16(AECirclePhotoListLogic paramAECirclePhotoListLogic, MovieExporter.VideoCompressListener paramVideoCompressListener, String paramString) {}
  
  public void onCompressCanceled()
  {
    FileUtils.deleteFile(this.b);
    this.a.onCompressCanceled();
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    FileUtils.deleteFile(this.b);
    this.a.onCompressError(paramAssetExportSession);
  }
  
  public void onCompressFinish(String paramString)
  {
    this.a.onCompressFinish(paramString);
  }
  
  public void onCompressStart()
  {
    this.a.onCompressStart();
  }
  
  public void onCompressing(float paramFloat)
  {
    this.a.onCompressing(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.16
 * JD-Core Version:    0.7.0.1
 */