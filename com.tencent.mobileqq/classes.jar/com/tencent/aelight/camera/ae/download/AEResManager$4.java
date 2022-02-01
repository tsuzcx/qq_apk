package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import java.util.List;
import java.util.Map;

class AEResManager$4
  implements Runnable
{
  AEResManager$4(AEResManager paramAEResManager, AEResInfo paramAEResInfo, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startPreDownLoad], preDownloadTask.run(), aeResInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraDownloadApiAEResInfo);
    AEQLog.b("AEResManager", localStringBuilder.toString());
    AEResManager.a(this.this$0).put(this.jdField_a_of_type_ComTencentAelightCameraDownloadApiAEResInfo, Integer.valueOf(3));
    AEResManager.b(this.this$0).put(this.jdField_a_of_type_ComTencentAelightCameraDownloadApiAEResInfo, Long.valueOf(System.currentTimeMillis()));
    AEResDownload.a(this.jdField_a_of_type_ComTencentAelightCameraDownloadApiAEResInfo, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$INet_ShortVideoResource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResManager.4
 * JD-Core Version:    0.7.0.1
 */