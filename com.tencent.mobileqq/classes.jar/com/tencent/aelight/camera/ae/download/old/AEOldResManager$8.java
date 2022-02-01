package com.tencent.aelight.camera.ae.download.old;

import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.INet_ShortVideoResource;
import java.util.List;
import java.util.Map;

class AEOldResManager$8
  implements Runnable
{
  AEOldResManager$8(AEOldResManager paramAEOldResManager, AEOldResInfo paramAEOldResInfo, List paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startPreDownLoad], preDownloadTask.run(), aeResInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
    AEOldResManager.a(this.this$0).put(this.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo, Integer.valueOf(3));
    AEOldResManager.b(this.this$0).put(this.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo, Long.valueOf(System.currentTimeMillis()));
    AEOldResDownload.a(this.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$INet_ShortVideoResource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldResManager.8
 * JD-Core Version:    0.7.0.1
 */