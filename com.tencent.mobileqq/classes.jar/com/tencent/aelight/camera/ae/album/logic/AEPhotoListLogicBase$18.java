package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tav.core.AssetExportSession;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

class AEPhotoListLogicBase$18
  implements MovieExporter.VideoCompressListener
{
  AEPhotoListLogicBase$18(AEPhotoListLogicBase paramAEPhotoListLogicBase, int paramInt, AEAlbumVideoModel paramAEAlbumVideoModel) {}
  
  public void onCompressCanceled()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCompress---cancel, index=");
    localStringBuilder.append(this.a);
    AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
    if (AEPhotoListLogicBase.g(this.c) != null) {
      AEPhotoListLogicBase.g(this.c).countDown();
    }
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    paramAssetExportSession = new StringBuilder();
    paramAssetExportSession.append("batchCompress---error, index=");
    paramAssetExportSession.append(this.a);
    paramAssetExportSession.append(", path=");
    paramAssetExportSession.append(this.b.getPath());
    AEQLog.b("AEPhotoListLogicBase", paramAssetExportSession.toString());
    AEPhotoListLogicBase.b(this.c, true);
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.2(this));
    if (AEPhotoListLogicBase.g(this.c) != null) {
      AEPhotoListLogicBase.g(this.c).countDown();
    }
  }
  
  public void onCompressFinish(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCompress---finish, index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", compressed path=");
    localStringBuilder.append(paramString);
    AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
    AEPhotoListLogicBase.k(this.c).put(this.b.getPath(), paramString);
    this.b.setPath(paramString);
    if (AEPhotoListLogicBase.g(this.c) != null) {
      AEPhotoListLogicBase.g(this.c).countDown();
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.18
 * JD-Core Version:    0.7.0.1
 */