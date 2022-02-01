package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

class AECMShowResourceManager$1$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AECMShowResourceManager$1$1(AECMShowResourceManager.1 param1, String paramString, HashMap paramHashMap, AEEditorDownloadResBean paramAEEditorDownloadResBean, boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadEssentialResource], resId=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", download succeeded");
      AEQLog.a("AECMShowResourceManager", localStringBuilder.toString());
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowResourceManager$1.this$0.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorDownloadResBean));
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadEssentialResource], resId=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", download failed");
      AEQLog.a("AECMShowResourceManager", localStringBuilder.toString());
      this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, null);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowResourceManager.1.1
 * JD-Core Version:    0.7.0.1
 */