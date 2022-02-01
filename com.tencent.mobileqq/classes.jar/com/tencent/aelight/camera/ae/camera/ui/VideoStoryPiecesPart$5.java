package com.tencent.aelight.camera.ae.camera.ui;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class VideoStoryPiecesPart$5
  implements AEMaterialDownloader.MaterialDownloadListener
{
  VideoStoryPiecesPart$5(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    paramAEMaterialMetaData = new StringBuilder();
    paramAEMaterialMetaData.append("entry dynamics: onDownloadFinish");
    paramAEMaterialMetaData.append(paramInt);
    AEQLog.a("VideoStoryPiecesPart", paramAEMaterialMetaData.toString());
    ThreadManager.getUIHandler().post(new VideoStoryPiecesPart.5.1(this, paramInt));
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.5
 * JD-Core Version:    0.7.0.1
 */