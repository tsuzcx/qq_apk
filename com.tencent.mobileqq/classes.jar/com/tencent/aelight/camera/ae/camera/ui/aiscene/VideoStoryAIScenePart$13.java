package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.os.Bundle;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;

class VideoStoryAIScenePart$13
  implements Runnable
{
  VideoStoryAIScenePart$13(VideoStoryAIScenePart paramVideoStoryAIScenePart, QIMFilterCategoryItem paramQIMFilterCategoryItem, Bundle paramBundle, CaptureComboManager paramCaptureComboManager) {}
  
  public void run()
  {
    if ((VideoStoryAIScenePart.m(this.this$0) != null) && (!VideoStoryAIScenePart.m(this.this$0).aE())) {
      return;
    }
    if ((VideoStoryAIScenePart.n(this.this$0) != null) && (VideoStoryAIScenePart.o(this.this$0).getSelectedCamera() == 2))
    {
      VideoStoryAIScenePart.b(this.this$0, true);
      AEBaseDataReporter.a().d(this.a.a);
      if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
        this.b.putBoolean("capture_force_enable", true);
      }
      this.c.a(this.a, VideoStoryAIScenePart.p(this.this$0), this.b);
      if (AEDashboardUtil.d())
      {
        DYAEFilterProviderView.a(this.a.a);
        return;
      }
      AEFilterProviderView.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.13
 * JD-Core Version:    0.7.0.1
 */