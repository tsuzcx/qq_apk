package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tav.core.AssetExportSession;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

class AECirclePhotoListLogic$15
  implements MovieExporter.VideoCompressListener
{
  AECirclePhotoListLogic$15(AECirclePhotoListLogic paramAECirclePhotoListLogic, int paramInt, AEAlbumVideoModel paramAEAlbumVideoModel) {}
  
  public void onCompressCanceled()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCompress---cancel, index=");
    localStringBuilder.append(this.a);
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    if (AECirclePhotoListLogic.b(this.c) != null) {
      AECirclePhotoListLogic.b(this.c).countDown();
    }
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    paramAssetExportSession = new StringBuilder();
    paramAssetExportSession.append("batchCompress---error, index=");
    paramAssetExportSession.append(this.a);
    paramAssetExportSession.append(", path=");
    paramAssetExportSession.append(this.b.getPath());
    AEQLog.b("AECirclePhotoListLogic", paramAssetExportSession.toString());
    AECirclePhotoListLogic.b(this.c, true);
    ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.15.2(this));
    if (AECirclePhotoListLogic.b(this.c) != null) {
      AECirclePhotoListLogic.b(this.c).countDown();
    }
  }
  
  public void onCompressFinish(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCompress---finish, index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", compressed path=");
    localStringBuilder.append(paramString);
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    AECirclePhotoListLogic.f(this.c).put(this.b.getPath(), paramString);
    this.b.setPath(paramString);
    if (AECirclePhotoListLogic.b(this.c) != null) {
      AECirclePhotoListLogic.b(this.c).countDown();
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.15.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.15
 * JD-Core Version:    0.7.0.1
 */