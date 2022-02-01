package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
    if (AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase) != null) {
      AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase).countDown();
    }
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    paramAssetExportSession = new StringBuilder();
    paramAssetExportSession.append("batchCompress---error, index=");
    paramAssetExportSession.append(this.jdField_a_of_type_Int);
    paramAssetExportSession.append(", path=");
    paramAssetExportSession.append(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumVideoModel.getPath());
    AEQLog.b("AEPhotoListLogicBase", paramAssetExportSession.toString());
    AEPhotoListLogicBase.b(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase, true);
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.2(this));
    if (AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase) != null) {
      AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase).countDown();
    }
  }
  
  public void onCompressFinish(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCompress---finish, index=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", compressed path=");
    localStringBuilder.append(paramString);
    AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
    AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase).put(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumVideoModel.getPath(), paramString);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumVideoModel.setPath(paramString);
    if (AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase) != null) {
      AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase).countDown();
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.18
 * JD-Core Version:    0.7.0.1
 */