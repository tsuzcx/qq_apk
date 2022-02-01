package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.os.Bundle;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderView;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;

class VideoStoryAIScenePart$13
  implements Runnable
{
  VideoStoryAIScenePart$13(VideoStoryAIScenePart paramVideoStoryAIScenePart, QIMFilterCategoryItem paramQIMFilterCategoryItem, Bundle paramBundle, CaptureComboManager paramCaptureComboManager) {}
  
  public void run()
  {
    if ((VideoStoryAIScenePart.a(this.this$0) != null) && (!VideoStoryAIScenePart.a(this.this$0).n())) {
      return;
    }
    if ((VideoStoryAIScenePart.c(this.this$0) != null) && (VideoStoryAIScenePart.a(this.this$0).getSelectedCamera() == 2))
    {
      VideoStoryAIScenePart.b(this.this$0, true);
      AEBaseDataReporter.a().d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem.a);
      if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("capture_force_enable", true);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem, VideoStoryAIScenePart.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
      AEFilterProviderView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.13
 * JD-Core Version:    0.7.0.1
 */