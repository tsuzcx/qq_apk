package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    if (AECirclePhotoListLogic.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic) != null) {
      AECirclePhotoListLogic.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic).countDown();
    }
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    paramAssetExportSession = new StringBuilder();
    paramAssetExportSession.append("batchCompress---error, index=");
    paramAssetExportSession.append(this.jdField_a_of_type_Int);
    paramAssetExportSession.append(", path=");
    paramAssetExportSession.append(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumVideoModel.getPath());
    AEQLog.b("AECirclePhotoListLogic", paramAssetExportSession.toString());
    AECirclePhotoListLogic.b(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic, true);
    ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.15.2(this));
    if (AECirclePhotoListLogic.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic) != null) {
      AECirclePhotoListLogic.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic).countDown();
    }
  }
  
  public void onCompressFinish(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCompress---finish, index=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", compressed path=");
    localStringBuilder.append(paramString);
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    AECirclePhotoListLogic.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic).put(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumVideoModel.getPath(), paramString);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumVideoModel.setPath(paramString);
    if (AECirclePhotoListLogic.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic) != null) {
      AECirclePhotoListLogic.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic).countDown();
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.15.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.15
 * JD-Core Version:    0.7.0.1
 */