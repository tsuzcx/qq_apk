package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;

class VideoStoryPiecesPart$12
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  VideoStoryPiecesPart$12(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    AECircleCaptureStyle localAECircleCaptureStyle = VideoStoryPiecesPart.a(paramRatio);
    if (VideoStoryPiecesPart.Q(this.a) != null) {
      VideoStoryPiecesPart.Q(this.a).setCaptureRadio(paramRatio);
    }
    VideoStoryPiecesPart.a(this.a, localAECircleCaptureStyle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.12
 * JD-Core Version:    0.7.0.1
 */